/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common;

import com.google.common.base.CharMatcher;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;
import com.google.common.collect.TreeMultimap;
import cpw.mods.fml.common.CertificateHelper;
import cpw.mods.fml.common.DuplicateModsFoundException;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.ICrashCallable;
import cpw.mods.fml.common.InjectedModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.LoaderException;
import cpw.mods.fml.common.LoaderState;
import cpw.mods.fml.common.MCPDummyContainer;
import cpw.mods.fml.common.MetadataCollection;
import cpw.mods.fml.common.MinecraftDummyContainer;
import cpw.mods.fml.common.MissingModsException;
import cpw.mods.fml.common.ModAPIManager;
import cpw.mods.fml.common.ModClassLoader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.WrongMinecraftVersionException;
import cpw.mods.fml.common.discovery.ModDiscoverer;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLLoadEvent;
import cpw.mods.fml.common.functions.ArtifactVersionNameFunction;
import cpw.mods.fml.common.functions.ModIdFunction;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.toposort.ModSorter;
import cpw.mods.fml.common.toposort.ModSortingException;
import cpw.mods.fml.common.versioning.ArtifactVersion;
import cpw.mods.fml.common.versioning.VersionParser;
import cpw.mods.fml.relauncher.FMLRelaunchLog;
import gloomyfolken.hooklib.minecraft.SecondaryTransformerHook;
import gloomyfolken.mods.asm.GloomyStartHooks;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import net.minecraft.crash.jxtc;
import obf.gloomyfolken.modlist.ModListHooks;

public class Loader {
    private static final Splitter DEPENDENCYPARTSPLITTER = Splitter.on(":").omitEmptyStrings().trimResults();
    private static final Splitter DEPENDENCYSPLITTER = Splitter.on(";").omitEmptyStrings().trimResults();
    private static Loader instance;
    private static String major;
    private static String minor;
    private static String rev;
    private static String build;
    private static String mccversion;
    private static String mcpversion;
    private ModClassLoader modClassLoader = new ModClassLoader(this.getClass().getClassLoader());
    private List<ModContainer> mods;
    private Map<String, ModContainer> namedMods;
    private File canonicalConfigDir;
    private File canonicalMinecraftDir;
    private Exception capturedError;
    private File canonicalModsDir;
    private LoadController modController;
    private MinecraftDummyContainer minecraft;
    private MCPDummyContainer mcp;
    private static File minecraftDir;
    private static List<String> injectedContainers;
    private File loggingProperties;
    private ImmutableMap<String, String> fmlBrandingProperties;

    public static Loader instance() {
        if (instance == null) {
            instance = new Loader();
        }
        return instance;
    }

    public static void injectData(Object ... objectArray) {
        SecondaryTransformerHook.injectData(null, objectArray);
        major = (String)objectArray[0];
        minor = (String)objectArray[1];
        rev = (String)objectArray[2];
        build = (String)objectArray[3];
        mccversion = (String)objectArray[4];
        mcpversion = (String)objectArray[5];
        minecraftDir = (File)objectArray[6];
        injectedContainers = (List)objectArray[7];
    }

    private Loader() {
        String string = new jxtc(null)._a();
        if (!mccversion.equals(string)) {
            FMLLog.severe("This version of FML is built for Minecraft %s, we have detected Minecraft %s in your minecraft jar file", mccversion, string);
            throw new LoaderException();
        }
        this.minecraft = new MinecraftDummyContainer(string);
        this.mcp = new MCPDummyContainer(MetadataCollection.from(this.getClass().getResourceAsStream("/mcpmod.info"), "MCP").getMetadataForId("mcp", null));
        GloomyStartHooks.initLoader(this);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void sortModList() {
        FMLLog.finer("Verifying mod requirements are satisfied", new Object[0]);
        try {
            Object object;
            HashBiMap<String, ArtifactVersion> hashBiMap = HashBiMap.create();
            for (ModContainer object2 : this.getActiveModList()) {
                hashBiMap.put(object2.getModId(), object2.getProcessedVersion());
            }
            for (ModContainer modContainer : this.getActiveModList()) {
                Object object22;
                if (!modContainer.acceptableMinecraftVersionRange().containsVersion(this.minecraft.getProcessedVersion())) {
                    FMLLog.severe("The mod %s does not wish to run in Minecraft version %s. You will have to remove it to play.", modContainer.getModId(), this.getMCVersionString());
                    throw new WrongMinecraftVersionException(modContainer);
                }
                object = Maps.uniqueIndex(modContainer.getRequirements(), new ArtifactVersionNameFunction());
                HashSet hashSet = Sets.newHashSet();
                Sets.SetView<Object> setView = Sets.difference(object.keySet(), hashBiMap.keySet());
                if (!setView.isEmpty()) {
                    FMLLog.severe("The mod %s (%s) requires mods %s to be available", modContainer.getModId(), modContainer.getName(), setView);
                    for (Object object22 : setView) {
                        hashSet.add(object.get(object22));
                    }
                    throw new MissingModsException(hashSet);
                }
                ImmutableCollection immutableCollection = ((ImmutableList.Builder)((ImmutableList.Builder)ImmutableList.builder().addAll(modContainer.getDependants())).addAll(modContainer.getDependencies())).build();
                object22 = ((ImmutableList)immutableCollection).iterator();
                while (object22.hasNext()) {
                    ArtifactVersion artifactVersion = (ArtifactVersion)object22.next();
                    if (!hashBiMap.containsKey(artifactVersion.getLabel()) || artifactVersion.containsVersion((ArtifactVersion)hashBiMap.get(artifactVersion.getLabel()))) continue;
                    hashSet.add(artifactVersion);
                }
                if (hashSet.isEmpty()) continue;
                FMLLog.severe("The mod %s (%s) requires mod versions %s to be available", modContainer.getModId(), modContainer.getName(), hashSet);
                throw new MissingModsException(hashSet);
            }
            FMLLog.finer("All mod requirements are satisfied", new Object[0]);
            Iterator<ModContainer> iterator2 = new ModSorter(this.getActiveModList(), this.namedMods);
            try {
                FMLLog.finer("Sorting mods into an ordered list", new Object[0]);
                List<ModContainer> list = ((ModSorter)((Object)iterator2)).sort();
                this.modController.getActiveModList().clear();
                this.modController.getActiveModList().addAll(list);
                this.mods.removeAll(list);
                list.addAll(this.mods);
                this.mods = list;
                FMLLog.finer("Mod sorting completed successfully", new Object[0]);
            }
            catch (ModSortingException modSortingException) {
                FMLLog.severe("A dependency cycle was detected in the input mod set so an ordering cannot be determined", new Object[0]);
                object = modSortingException.getExceptionData();
                FMLLog.severe("The first mod in the cycle is %s", ((ModSortingException.SortingExceptionData)object).getFirstBadNode());
                FMLLog.severe("The mod cycle involves", new Object[0]);
                for (Sets.SetView<Object> setView : ((ModSortingException.SortingExceptionData)object).getVisitedNodes()) {
                    FMLLog.severe("%s : before: %s, after: %s", ((Object)setView).toString(), setView.getDependants(), setView.getDependencies());
                }
                FMLLog.log(Level.SEVERE, modSortingException, "The full error", new Object[0]);
                throw modSortingException;
            }
        }
        catch (Throwable throwable) {
            FMLLog.fine("Mod sorting data", new Object[0]);
            int n = this.mods.size();
            for (ModContainer modContainer : this.getActiveModList()) {
                if (modContainer.isImmutable()) continue;
                FMLLog.fine("\t%s(%s:%s): %s (%s)", modContainer.getModId(), modContainer.getName(), modContainer.getVersion(), modContainer.getSource().getName(), modContainer.getSortingRules());
                --n;
            }
            if (n == this.mods.size()) {
                FMLLog.fine("No user mods found to sort", new Object[0]);
            }
            throw throwable;
        }
        FMLLog.fine("Mod sorting data", new Object[0]);
        int n = this.mods.size();
        for (ModContainer modContainer : this.getActiveModList()) {
            if (modContainer.isImmutable()) continue;
            FMLLog.fine("\t%s(%s:%s): %s (%s)", modContainer.getModId(), modContainer.getName(), modContainer.getVersion(), modContainer.getSource().getName(), modContainer.getSortingRules());
            --n;
        }
        if (n == this.mods.size()) {
            FMLLog.fine("No user mods found to sort", new Object[0]);
        }
    }

    private ModDiscoverer identifyMods() {
        FMLLog.fine("Building injected Mod Containers %s", injectedContainers);
        this.mods.add(new InjectedModContainer(this.mcp, new File("minecraft.jar")));
        for (String object2 : injectedContainers) {
            ModContainer modContainer;
            try {
                modContainer = (ModContainer)Class.forName(object2, true, this.modClassLoader).newInstance();
            }
            catch (Exception string) {
                FMLLog.log(Level.SEVERE, string, "A problem occured instantiating the injected mod container %s", object2);
                throw new LoaderException(string);
            }
            this.mods.add(new InjectedModContainer(modContainer, modContainer.getSource()));
        }
        ModDiscoverer modDiscoverer = new ModDiscoverer();
        FMLLog.fine("Attempting to load mods contained in the minecraft jar file and associated classes", new Object[0]);
        modDiscoverer.findClasspathMods(this.modClassLoader);
        FMLLog.fine("Minecraft jar mods loaded successfully", new Object[0]);
        FMLLog.info("Searching %s for mods", this.canonicalModsDir.getAbsolutePath());
        modDiscoverer.findModDirMods(this.canonicalModsDir);
        File file = new File(this.canonicalModsDir, mccversion);
        if (file.isDirectory()) {
            FMLLog.info("Also searching %s for mods", file);
            modDiscoverer.findModDirMods(file);
        }
        this.mods.addAll(modDiscoverer.identifyMods());
        this.identifyDuplicates(this.mods);
        this.namedMods = Maps.uniqueIndex(this.mods, new ModIdFunction());
        FMLLog.info("Forge Mod Loader has identified %d mod%s to load", this.mods.size(), this.mods.size() != 1 ? "s" : "");
        for (String string : this.namedMods.keySet()) {
            FMLLog.makeLog(string);
        }
        ModListHooks.afterModsLoaded();
        return modDiscoverer;
    }

    private void identifyDuplicates(List<ModContainer> list) {
        TreeMultimap<ModContainer, Object> treeMultimap = TreeMultimap.create(new ModIdComparator(), Ordering.arbitrary());
        for (ModContainer object2 : list) {
            if (object2.getSource() == null) continue;
            treeMultimap.put((Object)object2, (Object)object2.getSource());
        }
        ImmutableMultiset immutableMultiset = Multisets.copyHighestCountFirst(treeMultimap.keys());
        LinkedHashMultimap<ModContainer, File> linkedHashMultimap = LinkedHashMultimap.create();
        for (Multiset.Entry entry : immutableMultiset.entrySet()) {
            if (entry.getCount() <= 1) continue;
            FMLLog.severe("Found a duplicate mod %s at %s", ((ModContainer)entry.getElement()).getModId(), treeMultimap.get(entry.getElement()));
            linkedHashMultimap.putAll((ModContainer)entry.getElement(), (Iterable<File>)treeMultimap.get(entry.getElement()));
        }
        if (!linkedHashMultimap.isEmpty()) {
            throw new DuplicateModsFoundException(linkedHashMultimap);
        }
    }

    private void initializeLoader() {
        boolean bl;
        String string;
        String string2;
        File file = new File(minecraftDir, "mods");
        File file2 = new File(minecraftDir, "config");
        try {
            this.canonicalMinecraftDir = minecraftDir.getCanonicalFile();
            string2 = file.getCanonicalPath();
            string = file2.getCanonicalPath();
            this.canonicalConfigDir = file2.getCanonicalFile();
            this.canonicalModsDir = file.getCanonicalFile();
        }
        catch (IOException iOException) {
            FMLLog.log(Level.SEVERE, iOException, "Failed to resolve loader directories: mods : %s ; config %s", this.canonicalModsDir.getAbsolutePath(), file2.getAbsolutePath());
            throw new LoaderException(iOException);
        }
        if (!this.canonicalModsDir.exists()) {
            FMLLog.info("No mod directory found, creating one: %s", string2);
            bl = this.canonicalModsDir.mkdir();
            if (!bl) {
                FMLLog.severe("Unable to create the mod directory %s", string2);
                throw new LoaderException();
            }
            FMLLog.info("Mod directory created successfully", new Object[0]);
        }
        if (!this.canonicalConfigDir.exists()) {
            FMLLog.fine("No config directory found, creating one: %s", string);
            bl = this.canonicalConfigDir.mkdir();
            if (!bl) {
                FMLLog.severe("Unable to create the config directory %s", string);
                throw new LoaderException();
            }
            FMLLog.info("Config directory created successfully", new Object[0]);
        }
        if (!this.canonicalModsDir.isDirectory()) {
            FMLLog.severe("Attempting to load mods from %s, which is not a directory", string2);
            throw new LoaderException();
        }
        if (!file2.isDirectory()) {
            FMLLog.severe("Attempting to load configuration from %s, which is not a directory", string);
            throw new LoaderException();
        }
        this.loggingProperties = new File(this.canonicalConfigDir, "logging.properties");
        FMLLog.info("Reading custom logging properties from %s", this.loggingProperties.getPath());
        FMLRelaunchLog.loadLogConfiguration(this.loggingProperties);
        FMLLog.log(Level.OFF, "Logging level for ForgeModLoader logging is set to %s", FMLRelaunchLog.log.getLogger().getLevel());
    }

    public List<ModContainer> getModList() {
        return Loader.instance().mods != null ? ImmutableList.copyOf(Loader.instance().mods) : ImmutableList.of();
    }

    public void loadMods() {
        this.initializeLoader();
        this.mods = Lists.newArrayList();
        this.namedMods = Maps.newHashMap();
        this.modController = new LoadController(this);
        this.modController.transition(LoaderState.LOADING, false);
        ModDiscoverer modDiscoverer = this.identifyMods();
        ModAPIManager.INSTANCE.manageAPI(this.modClassLoader, modDiscoverer);
        this.disableRequestedMods();
        FMLLog.fine("Reloading logging properties from %s", this.loggingProperties.getPath());
        FMLRelaunchLog.loadLogConfiguration(this.loggingProperties);
        FMLLog.fine("Reloaded logging properties", new Object[0]);
        this.modController.distributeStateMessage(FMLLoadEvent.class);
        this.sortModList();
        ModAPIManager.INSTANCE.cleanupAPIContainers(this.modController.getActiveModList());
        ModAPIManager.INSTANCE.cleanupAPIContainers(this.mods);
        this.mods = ImmutableList.copyOf(this.mods);
        for (File object : modDiscoverer.getNonModLibs()) {
            if (!object.isFile()) continue;
            FMLLog.info("FML has found a non-mod file %s in your mods directory. It will now be injected into your classpath. This could severe stability issues, it should be removed if possible.", object.getName());
            try {
                this.modClassLoader.addFile(object);
            }
            catch (MalformedURLException malformedURLException) {
                FMLLog.log(Level.SEVERE, malformedURLException, "Encountered a weird problem with non-mod file injection : %s", object.getName());
            }
        }
        this.modController.transition(LoaderState.CONSTRUCTING, false);
        this.modController.distributeStateMessage(LoaderState.CONSTRUCTING, this.modClassLoader, modDiscoverer.getASMTable());
        FMLLog.fine("Mod signature data", new Object[0]);
        for (ModContainer modContainer : this.getActiveModList()) {
            FMLLog.fine("\t%s(%s:%s): %s (%s)", modContainer.getModId(), modContainer.getName(), modContainer.getVersion(), modContainer.getSource().getName(), CertificateHelper.getFingerprint(modContainer.getSigningCertificate()));
        }
        if (this.getActiveModList().isEmpty()) {
            FMLLog.fine("No user mod signature data found", new Object[0]);
        }
        this.modController.transition(LoaderState.PREINITIALIZATION, false);
        this.modController.distributeStateMessage(LoaderState.PREINITIALIZATION, modDiscoverer.getASMTable(), this.canonicalConfigDir);
        this.modController.transition(LoaderState.INITIALIZATION, false);
        GameData.validateRegistry();
    }

    private void disableRequestedMods() {
        String string = System.getProperty("fml.modStates", "");
        FMLLog.finer("Received a system property request '%s'", string);
        Map<String, String> map = Splitter.on(CharMatcher.anyOf(";:")).omitEmptyStrings().trimResults().withKeyValueSeparator("=").split(string);
        FMLLog.finer("System property request managing the state of %d mods", map.size());
        HashMap<String, String> hashMap = Maps.newHashMap();
        File file = new File(this.canonicalConfigDir, "fmlModState.properties");
        Properties properties = new Properties();
        if (file.exists() && file.isFile()) {
            FMLLog.finer("Found a mod state file %s", file.getName());
            try {
                properties.load(new FileReader(file));
                FMLLog.finer("Loaded states for %d mods from file", properties.size());
            }
            catch (Exception exception) {
                FMLLog.log(Level.INFO, exception, "An error occurred reading the fmlModState.properties file", new Object[0]);
            }
        }
        hashMap.putAll(Maps.fromProperties(properties));
        hashMap.putAll(map);
        FMLLog.fine("After merging, found state information for %d mods", hashMap.size());
        Map map2 = Maps.transformValues(hashMap, new Function<String, Boolean>(){

            @Override
            public Boolean apply(String string) {
                return Boolean.parseBoolean(string);
            }
        });
        for (Map.Entry entry : map2.entrySet()) {
            if (!this.namedMods.containsKey(entry.getKey())) continue;
            FMLLog.info("Setting mod %s to enabled state %b", entry.getKey(), entry.getValue());
            this.namedMods.get(entry.getKey()).setEnabledState(entry.getValue());
        }
    }

    public static boolean isModLoaded(String string) {
        return Loader.instance().namedMods.containsKey(string) && Loader.instance().modController.getModState(Loader.instance.namedMods.get(string)) != LoaderState.ModState.DISABLED;
    }

    public File getConfigDir() {
        return this.canonicalConfigDir;
    }

    public String getCrashInformation() {
        if (this.modController == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        List<String> list = FMLCommonHandler.instance().getBrandings();
        Joiner.on(' ').skipNulls().appendTo(stringBuilder, (Iterable<?>)list.subList(1, list.size()));
        if (this.modController != null) {
            this.modController.printModStates(stringBuilder);
        }
        return stringBuilder.toString();
    }

    public String getFMLVersionString() {
        return String.format("%s.%s.%s.%s", major, minor, rev, build);
    }

    public ClassLoader getModClassLoader() {
        return this.modClassLoader;
    }

    public void computeDependencies(String string, Set<ArtifactVersion> set, List<ArtifactVersion> list, List<ArtifactVersion> list2) {
        if (string == null || string.length() == 0) {
            return;
        }
        boolean bl = false;
        for (String string2 : DEPENDENCYSPLITTER.split(string)) {
            ArrayList<String> arrayList = Lists.newArrayList(DEPENDENCYPARTSPLITTER.split(string2));
            if (arrayList.size() != 2) {
                bl = true;
                continue;
            }
            String string3 = (String)arrayList.get(0);
            String string4 = (String)arrayList.get(1);
            boolean bl2 = string4.startsWith("*");
            if (bl2 && string4.length() > 1) {
                bl = true;
                continue;
            }
            if ("required-before".equals(string3) || "required-after".equals(string3)) {
                if (!bl2) {
                    set.add(VersionParser.parseVersionReference(string4));
                } else {
                    bl = true;
                    continue;
                }
            }
            if (bl2 && string4.indexOf(64) > -1) {
                bl = true;
                continue;
            }
            if ("required-before".equals(string3) || "before".equals(string3)) {
                list2.add(VersionParser.parseVersionReference(string4));
                continue;
            }
            if ("required-after".equals(string3) || "after".equals(string3)) {
                list.add(VersionParser.parseVersionReference(string4));
                continue;
            }
            bl = true;
        }
        if (bl) {
            FMLLog.log(Level.WARNING, "Unable to parse dependency string %s", string);
            throw new LoaderException();
        }
    }

    public Map<String, ModContainer> getIndexedModList() {
        return ImmutableMap.copyOf(this.namedMods);
    }

    public void initializeMods() {
        this.modController.distributeStateMessage(LoaderState.INITIALIZATION, new Object[0]);
        this.modController.transition(LoaderState.POSTINITIALIZATION, false);
        GameData.buildModObjectTable();
        this.modController.distributeStateMessage(FMLInterModComms.IMCEvent.class);
        this.modController.distributeStateMessage(LoaderState.POSTINITIALIZATION, new Object[0]);
        this.modController.transition(LoaderState.AVAILABLE, false);
        this.modController.distributeStateMessage(LoaderState.AVAILABLE, new Object[0]);
        GameData.dumpRegistry(minecraftDir);
        FMLLog.info("Forge Mod Loader has successfully loaded %d mod%s", this.mods.size(), this.mods.size() == 1 ? "" : "s");
    }

    public ICrashCallable getCallableCrashInformation() {
        return new ICrashCallable(){

            @Override
            public String call() throws Exception {
                return Loader.this.getCrashInformation();
            }

            @Override
            public String getLabel() {
                return "FML";
            }
        };
    }

    public List<ModContainer> getActiveModList() {
        return this.modController != null ? this.modController.getActiveModList() : ImmutableList.of();
    }

    public LoaderState.ModState getModState(ModContainer modContainer) {
        return this.modController.getModState(modContainer);
    }

    public String getMCVersionString() {
        return "Minecraft " + mccversion;
    }

    public boolean serverStarting(Object object) {
        try {
            this.modController.distributeStateMessage(LoaderState.SERVER_STARTING, object);
            this.modController.transition(LoaderState.SERVER_STARTING, false);
        }
        catch (Throwable throwable) {
            FMLLog.log(Level.SEVERE, throwable, "A fatal exception occurred during the server starting event", new Object[0]);
            return false;
        }
        return true;
    }

    public void serverStarted() {
        this.modController.distributeStateMessage(LoaderState.SERVER_STARTED, new Object[0]);
        this.modController.transition(LoaderState.SERVER_STARTED, false);
    }

    public void serverStopping() {
        this.modController.distributeStateMessage(LoaderState.SERVER_STOPPING, new Object[0]);
        this.modController.transition(LoaderState.SERVER_STOPPING, false);
    }

    public BiMap<ModContainer, Object> getModObjectList() {
        return this.modController.getModObjectList();
    }

    public BiMap<Object, ModContainer> getReversedModObjectList() {
        return this.getModObjectList().inverse();
    }

    public ModContainer activeModContainer() {
        return this.modController != null ? this.modController.activeContainer() : null;
    }

    public boolean isInState(LoaderState loaderState) {
        return this.modController.isInState(loaderState);
    }

    public MinecraftDummyContainer getMinecraftModContainer() {
        return this.minecraft;
    }

    public boolean hasReachedState(LoaderState loaderState) {
        return this.modController != null ? this.modController.hasReachedState(loaderState) : false;
    }

    public String getMCPVersionString() {
        return String.format("MCP v%s", mcpversion);
    }

    public void serverStopped() {
        this.modController.distributeStateMessage(LoaderState.SERVER_STOPPED, new Object[0]);
        this.modController.transition(LoaderState.SERVER_STOPPED, true);
        this.modController.transition(LoaderState.AVAILABLE, true);
    }

    public boolean serverAboutToStart(Object object) {
        try {
            this.modController.distributeStateMessage(LoaderState.SERVER_ABOUT_TO_START, object);
            this.modController.transition(LoaderState.SERVER_ABOUT_TO_START, false);
        }
        catch (Throwable throwable) {
            FMLLog.log(Level.SEVERE, throwable, "A fatal exception occurred during the server about to start event", new Object[0]);
            return false;
        }
        return true;
    }

    public Map<String, String> getFMLBrandingProperties() {
        if (this.fmlBrandingProperties == null) {
            Properties properties = new Properties();
            try {
                properties.load(this.getClass().getClassLoader().getResourceAsStream("fmlbranding.properties"));
            }
            catch (Exception exception) {
                // empty catch block
            }
            this.fmlBrandingProperties = Maps.fromProperties(properties);
        }
        return this.fmlBrandingProperties;
    }

    public Map<String, String> getCustomModProperties(String string) {
        return this.getIndexedModList().get(string).getCustomModProperties();
    }

    private class ModIdComparator
    implements Comparator<ModContainer> {
        private ModIdComparator() {
        }

        @Override
        public int compare(ModContainer modContainer, ModContainer modContainer2) {
            return modContainer.getModId().compareTo(modContainer2.getModId());
        }
    }
}

