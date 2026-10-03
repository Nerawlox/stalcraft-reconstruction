/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.relauncher;

import com.google.common.base.Strings;
import com.google.common.base.Throwables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.ObjectArrays;
import com.google.common.primitives.Ints;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.launcher.FMLInjectionAndSortingTweaker;
import cpw.mods.fml.common.launcher.FMLTweaker;
import cpw.mods.fml.common.toposort.TopologicalSort;
import cpw.mods.fml.relauncher.FMLInjectionData;
import cpw.mods.fml.relauncher.FMLRelaunchLog;
import cpw.mods.fml.relauncher.IFMLCallHook;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.logging.Level;
import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.launchwrapper.LaunchClassLoader;

public class CoreModManager {
    private static final Attributes.Name COREMODCONTAINSFMLMOD = new Attributes.Name("FMLCorePluginContainsFMLMod");
    private static String[] rootPlugins = new String[]{"cpw.mods.fml.relauncher.FMLCorePlugin", "net.minecraftforge.classloading.FMLForgePlugin"};
    private static List<String> loadedCoremods = Lists.newArrayList();
    private static List<FMLPluginWrapper> loadPlugins;
    private static boolean deobfuscatedEnvironment;
    private static FMLTweaker tweaker;
    private static File mcDir;
    private static List<String> reparsedCoremods;
    private static Method ADDURL;
    private static Map<String, Integer> tweakSorting;

    public static void handleLaunch(File file, LaunchClassLoader launchClassLoader, FMLTweaker fMLTweaker) {
        Object object;
        mcDir = file;
        tweaker = fMLTweaker;
        try {
            object = launchClassLoader.getClassBytes("net.minecraft.world.World");
            if (object != null) {
                FMLRelaunchLog.info("Managed to load a deobfuscated Minecraft name- we are in a deobfuscated environment. Skipping runtime deobfuscation", new Object[0]);
                deobfuscatedEnvironment = true;
            }
        }
        catch (IOException iOException) {
            // empty catch block
        }
        if (!deobfuscatedEnvironment) {
            FMLRelaunchLog.fine("Enabling runtime deobfuscation", new Object[0]);
        }
        fMLTweaker.injectCascadingTweak("cpw.mods.fml.common.launcher.FMLInjectionAndSortingTweaker");
        try {
            launchClassLoader.registerTransformer("cpw.mods.fml.common.asm.transformers.PatchingTransformer");
        }
        catch (Exception exception) {
            FMLRelaunchLog.log(Level.SEVERE, exception, "The patch transformer failed to load! This is critical, loading cannot continue!", new Object[0]);
            throw Throwables.propagate(exception);
        }
        loadPlugins = new ArrayList<FMLPluginWrapper>();
        for (byte by : (Object)rootPlugins) {
            CoreModManager.loadCoreMod(launchClassLoader, (String)by, new File(FMLTweaker.getJarLocation()));
        }
        if (loadPlugins.isEmpty()) {
            throw new RuntimeException("A fatal error has occured - no valid fml load plugin was found - this is a completely corrupt FML installation.");
        }
        FMLRelaunchLog.fine("All fundamental core mods are successfully located", new Object[0]);
        object = System.getProperty("fml.coreMods.load", "");
        for (String string : ((String)object).split(",")) {
            if (string.isEmpty()) continue;
            FMLRelaunchLog.info("Found a command line coremod : %s", string);
            CoreModManager.loadCoreMod(launchClassLoader, string, null);
        }
        CoreModManager.discoverCoreMods(file, launchClassLoader);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void discoverCoreMods(File file, LaunchClassLoader launchClassLoader) {
        FMLRelaunchLog.fine("Discovering coremods", new Object[0]);
        File file2 = CoreModManager.setupCoreModDir(file);
        FilenameFilter filenameFilter = new FilenameFilter(){

            @Override
            public boolean accept(File file, String string) {
                return string.endsWith(".jar");
            }
        };
        Object[] objectArray = file2.listFiles(filenameFilter);
        File file3 = new File(file2, FMLInjectionData.mccversion);
        if (file3.isDirectory()) {
            Object[] objectArray2 = file3.listFiles(filenameFilter);
            objectArray = ObjectArrays.concat(objectArray, objectArray2, File.class);
        }
        Arrays.sort(objectArray);
        for (Object object : objectArray) {
            Object object2;
            Attributes attributes;
            FMLRelaunchLog.fine("Examining for coremod candidacy %s", ((File)object).getName());
            JarFile jarFile = null;
            try {
                jarFile = new JarFile((File)object);
                if (jarFile.getManifest() == null) continue;
                attributes = jarFile.getManifest().getMainAttributes();
            }
            catch (IOException iOException) {
                FMLRelaunchLog.log(Level.SEVERE, iOException, "Unable to read the jar file %s - ignoring", ((File)object).getName());
                continue;
            }
            finally {
                if (jarFile != null) {
                    try {
                        jarFile.close();
                    }
                    catch (IOException iOException) {}
                }
            }
            String string = attributes.getValue("TweakClass");
            if (string != null) {
                FMLRelaunchLog.info("Loading tweaker %s from %s", string, ((File)object).getName());
                object2 = Ints.tryParse(Strings.nullToEmpty(attributes.getValue("TweakOrder")));
                object2 = object2 == null ? Integer.valueOf(0) : object2;
                CoreModManager.handleCascadingTweak((File)object, jarFile, string, launchClassLoader, (Integer)object2);
                loadedCoremods.add(((File)object).getName());
                continue;
            }
            object2 = attributes.getValue("FMLCorePlugin");
            if (object2 == null) {
                FMLRelaunchLog.fine("Not found coremod data in %s", ((File)object).getName());
                continue;
            }
            try {
                launchClassLoader.addURL(((File)object).toURI().toURL());
                if (!attributes.containsKey(COREMODCONTAINSFMLMOD)) {
                    FMLRelaunchLog.finest("Adding %s to the list of known coremods, it will not be examined again", ((File)object).getName());
                    loadedCoremods.add(((File)object).getName());
                } else {
                    FMLRelaunchLog.finest("Found FMLCorePluginContainsFMLMod marker in %s, it will be examined later for regular @Mod instances", ((File)object).getName());
                    reparsedCoremods.add(((File)object).getName());
                }
            }
            catch (MalformedURLException malformedURLException) {
                FMLRelaunchLog.log(Level.SEVERE, malformedURLException, "Unable to convert file into a URL. weird", new Object[0]);
                continue;
            }
            CoreModManager.loadCoreMod(launchClassLoader, (String)object2, (File)object);
        }
    }

    private static void handleCascadingTweak(File file, JarFile jarFile, String string, LaunchClassLoader launchClassLoader, Integer n) {
        try {
            if (ADDURL == null) {
                ADDURL = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
                ADDURL.setAccessible(true);
            }
            ADDURL.invoke(launchClassLoader.getClass().getClassLoader(), file.toURI().toURL());
            launchClassLoader.addURL(file.toURI().toURL());
            tweaker.injectCascadingTweak(string);
            tweakSorting.put(string, n);
        }
        catch (Exception exception) {
            FMLRelaunchLog.log(Level.INFO, exception, "There was a problem trying to load the mod dir tweaker %s", file.getAbsolutePath());
        }
    }

    private static void injectTweakWrapper(FMLPluginWrapper fMLPluginWrapper) {
        loadPlugins.add(fMLPluginWrapper);
    }

    private static File setupCoreModDir(File file) {
        File file2 = new File(file, "mods");
        try {
            file2 = file2.getCanonicalFile();
        }
        catch (IOException iOException) {
            throw new RuntimeException(String.format("Unable to canonicalize the coremod dir at %s", file.getName()), iOException);
        }
        if (!file2.exists()) {
            file2.mkdir();
        } else if (file2.exists() && !file2.isDirectory()) {
            throw new RuntimeException(String.format("Found a coremod file in %s that's not a directory", file.getName()));
        }
        return file2;
    }

    public static List<String> getLoadedCoremods() {
        return loadedCoremods;
    }

    public static List<String> getReparseableCoremods() {
        return reparsedCoremods;
    }

    private static FMLPluginWrapper loadCoreMod(LaunchClassLoader launchClassLoader, String string, File file) {
        String string2 = string.substring(string.lastIndexOf(46) + 1);
        try {
            IFMLLoadingPlugin.SortingIndex sortingIndex;
            FMLRelaunchLog.fine("Instantiating coremod class %s", string2);
            launchClassLoader.addTransformerExclusion(string);
            Class<?> clazz = Class.forName(string, true, launchClassLoader);
            IFMLLoadingPlugin.Name name = clazz.getAnnotation(IFMLLoadingPlugin.Name.class);
            if (name != null && !Strings.isNullOrEmpty(name.value())) {
                string2 = name.value();
                FMLRelaunchLog.finest("coremod named %s is loading", string2);
            }
            IFMLLoadingPlugin.MCVersion mCVersion = clazz.getAnnotation(IFMLLoadingPlugin.MCVersion.class);
            if (!Arrays.asList(rootPlugins).contains(string) && (mCVersion == null || Strings.isNullOrEmpty(mCVersion.value()))) {
                FMLRelaunchLog.log(Level.WARNING, "The coremod %s does not have a MCVersion annotation, it may cause issues with this version of Minecraft", string);
            } else {
                if (mCVersion != null && !FMLInjectionData.mccversion.equals(mCVersion.value())) {
                    FMLRelaunchLog.log(Level.SEVERE, "The coremod %s is requesting minecraft version %s and minecraft is %s. It will be ignored.", string, mCVersion.value(), FMLInjectionData.mccversion);
                    return null;
                }
                if (mCVersion != null) {
                    FMLRelaunchLog.log(Level.FINE, "The coremod %s requested minecraft version %s and minecraft is %s. It will be loaded.", string, mCVersion.value(), FMLInjectionData.mccversion);
                }
            }
            IFMLLoadingPlugin.TransformerExclusions transformerExclusions = clazz.getAnnotation(IFMLLoadingPlugin.TransformerExclusions.class);
            if (transformerExclusions != null) {
                for (String string3 : transformerExclusions.value()) {
                    launchClassLoader.addTransformerExclusion(string3);
                }
            }
            IFMLLoadingPlugin.DependsOn dependsOn = clazz.getAnnotation(IFMLLoadingPlugin.DependsOn.class);
            String[] stringArray = new String[]{};
            if (dependsOn != null) {
                stringArray = dependsOn.value();
            }
            int n = (sortingIndex = clazz.getAnnotation(IFMLLoadingPlugin.SortingIndex.class)) != null ? sortingIndex.value() : 0;
            IFMLLoadingPlugin iFMLLoadingPlugin = (IFMLLoadingPlugin)clazz.newInstance();
            FMLPluginWrapper fMLPluginWrapper = new FMLPluginWrapper(string2, iFMLLoadingPlugin, file, n, stringArray);
            loadPlugins.add(fMLPluginWrapper);
            FMLRelaunchLog.fine("Enqueued coremod %s", string2);
            return fMLPluginWrapper;
        }
        catch (ClassNotFoundException classNotFoundException) {
            if (!Lists.newArrayList(rootPlugins).contains(string)) {
                FMLRelaunchLog.log(Level.SEVERE, classNotFoundException, "Coremod %s: Unable to class load the plugin %s", string2, string);
            } else {
                FMLRelaunchLog.fine("Skipping root plugin %s", string);
            }
        }
        catch (ClassCastException classCastException) {
            FMLRelaunchLog.log(Level.SEVERE, classCastException, "Coremod %s: The plugin %s is not an implementor of IFMLLoadingPlugin", string2, string);
        }
        catch (InstantiationException instantiationException) {
            FMLRelaunchLog.log(Level.SEVERE, instantiationException, "Coremod %s: The plugin class %s was not instantiable", string2, string);
        }
        catch (IllegalAccessException illegalAccessException) {
            FMLRelaunchLog.log(Level.SEVERE, illegalAccessException, "Coremod %s: The plugin class %s was not accessible", string2, string);
        }
        return null;
    }

    private static void sortCoreMods() {
        TopologicalSort.DirectedGraph<FMLPluginWrapper> directedGraph = new TopologicalSort.DirectedGraph<FMLPluginWrapper>();
        HashMap<String, FMLPluginWrapper> hashMap = Maps.newHashMap();
        for (FMLPluginWrapper fMLPluginWrapper : loadPlugins) {
            directedGraph.addNode(fMLPluginWrapper);
            hashMap.put(fMLPluginWrapper.name, fMLPluginWrapper);
        }
        for (FMLPluginWrapper fMLPluginWrapper : loadPlugins) {
            for (String string : fMLPluginWrapper.predepends) {
                if (!hashMap.containsKey(string)) {
                    FMLRelaunchLog.log(Level.SEVERE, "Missing coremod dependency - the coremod %s depends on coremod %s which isn't present.", fMLPluginWrapper.name, string);
                    throw new RuntimeException();
                }
                directedGraph.addEdge(fMLPluginWrapper, (FMLPluginWrapper)hashMap.get(string));
            }
        }
        try {
            loadPlugins = TopologicalSort.topologicalSort(directedGraph);
            FMLRelaunchLog.fine("Sorted coremod list %s", loadPlugins);
        }
        catch (Exception exception) {
            FMLLog.log(Level.SEVERE, exception, "There was a problem performing the coremod sort", new Object[0]);
            throw Throwables.propagate(exception);
        }
    }

    public static void injectTransformers(LaunchClassLoader launchClassLoader) {
        Launch.blackboard.put("fml.deobfuscatedEnvironment", deobfuscatedEnvironment);
        tweaker.injectCascadingTweak("cpw.mods.fml.common.launcher.FMLDeobfTweaker");
        tweakSorting.put("cpw.mods.fml.common.launcher.FMLDeobfTweaker", 1000);
    }

    public static void injectCoreModTweaks(FMLInjectionAndSortingTweaker fMLInjectionAndSortingTweaker) {
        List list2 = (List)Launch.blackboard.get("Tweaks");
        list2.add(0, fMLInjectionAndSortingTweaker);
        for (FMLPluginWrapper fMLPluginWrapper : loadPlugins) {
            list2.add(fMLPluginWrapper);
        }
    }

    public static void sortTweakList() {
        List list2 = (List)Launch.blackboard.get("Tweaks");
        ITweaker[] iTweakerArray = list2.toArray(new ITweaker[list2.size()]);
        Arrays.sort(iTweakerArray, new Comparator<ITweaker>(){

            @Override
            public int compare(ITweaker iTweaker, ITweaker iTweaker2) {
                Integer n = null;
                Integer n2 = null;
                if (iTweaker instanceof FMLInjectionAndSortingTweaker) {
                    n = Integer.MIN_VALUE;
                }
                if (iTweaker2 instanceof FMLInjectionAndSortingTweaker) {
                    n2 = Integer.MIN_VALUE;
                }
                if (iTweaker instanceof FMLPluginWrapper) {
                    n = ((FMLPluginWrapper)iTweaker).sortIndex;
                } else if (n == null) {
                    n = (Integer)tweakSorting.get(iTweaker.getClass().getName());
                }
                if (iTweaker2 instanceof FMLPluginWrapper) {
                    n2 = ((FMLPluginWrapper)iTweaker2).sortIndex;
                } else if (n2 == null) {
                    n2 = (Integer)tweakSorting.get(iTweaker2.getClass().getName());
                }
                if (n == null) {
                    n = 0;
                }
                if (n2 == null) {
                    n2 = 0;
                }
                return Ints.saturatedCast((long)n.intValue() - (long)n2.intValue());
            }
        });
        for (int i = 0; i < iTweakerArray.length; ++i) {
            list2.set(i, iTweakerArray[i]);
        }
    }

    static {
        reparsedCoremods = Lists.newArrayList();
        tweakSorting = Maps.newHashMap();
    }

    private static class FMLPluginWrapper
    implements ITweaker {
        public final String name;
        public final IFMLLoadingPlugin coreModInstance;
        public final List<String> predepends;
        public final File location;
        public final int sortIndex;

        public FMLPluginWrapper(String string, IFMLLoadingPlugin iFMLLoadingPlugin, File file, int n, String ... stringArray) {
            this.name = string;
            this.coreModInstance = iFMLLoadingPlugin;
            this.location = file;
            this.sortIndex = n;
            this.predepends = Lists.newArrayList(stringArray);
        }

        public String toString() {
            return String.format("%s {%s}", this.name, this.predepends);
        }

        public void acceptOptions(List<String> list2, File file, File file2, String string) {
        }

        @Override
        public void injectIntoClassLoader(LaunchClassLoader launchClassLoader) {
            FMLRelaunchLog.fine("Injecting coremod %s {%s} class transformers", this.name, this.coreModInstance.getClass().getName());
            if (this.coreModInstance.getASMTransformerClass() != null) {
                for (String object : this.coreModInstance.getASMTransformerClass()) {
                    FMLRelaunchLog.finest("Registering transformer %s", object);
                    launchClassLoader.registerTransformer(object);
                }
            }
            FMLRelaunchLog.fine("Injection complete", new Object[0]);
            FMLRelaunchLog.fine("Running coremod plugin for %s {%s}", this.name, this.coreModInstance.getClass().getName());
            HashMap hashMap = new HashMap();
            hashMap.put("mcLocation", mcDir);
            hashMap.put("coremodList", loadPlugins);
            hashMap.put("runtimeDeobfuscationEnabled", !deobfuscatedEnvironment);
            FMLRelaunchLog.fine("Running coremod plugin %s", this.name);
            hashMap.put("coremodLocation", this.location);
            this.coreModInstance.injectData(hashMap);
            String string = this.coreModInstance.getSetupClass();
            if (string != null) {
                try {
                    IFMLCallHook iFMLCallHook = (IFMLCallHook)Class.forName(string, true, launchClassLoader).newInstance();
                    HashMap<String, Object> hashMap2 = new HashMap<String, Object>();
                    hashMap2.put("mcLocation", mcDir);
                    hashMap2.put("classLoader", launchClassLoader);
                    hashMap2.put("coremodLocation", this.location);
                    hashMap2.put("deobfuscationFileName", FMLInjectionData.debfuscationDataName());
                    iFMLCallHook.injectData(hashMap2);
                    iFMLCallHook.call();
                }
                catch (Exception exception) {
                    throw new RuntimeException(exception);
                }
            }
            FMLRelaunchLog.fine("Coremod plugin class %s run successfully", this.coreModInstance.getClass().getSimpleName());
            String string2 = this.coreModInstance.getModContainerClass();
            if (string2 != null) {
                FMLInjectionData.containers.add(string2);
            }
        }

        @Override
        public String getLaunchTarget() {
            return "";
        }

        @Override
        public String[] getLaunchArguments() {
            return new String[0];
        }
    }
}

