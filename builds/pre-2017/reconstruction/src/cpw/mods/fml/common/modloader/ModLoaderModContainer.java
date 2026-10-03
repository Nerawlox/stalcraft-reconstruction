/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.modloader;

import com.google.common.base.Strings;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.ILanguageAdapter;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.LoaderException;
import cpw.mods.fml.common.MetadataCollection;
import cpw.mods.fml.common.ModClassLoader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.ProxyInjector;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.discovery.ASMDataTable;
import cpw.mods.fml.common.discovery.ContainerType;
import cpw.mods.fml.common.event.FMLConstructionEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLLoadCompleteEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.modloader.BaseModProxy;
import cpw.mods.fml.common.modloader.BaseModTicker;
import cpw.mods.fml.common.modloader.ModLoaderHelper;
import cpw.mods.fml.common.modloader.ModLoaderNetworkHandler;
import cpw.mods.fml.common.modloader.ModProperty;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.common.versioning.ArtifactVersion;
import cpw.mods.fml.common.versioning.DefaultArtifactVersion;
import cpw.mods.fml.common.versioning.VersionRange;
import cpw.mods.fml.relauncher.Side;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import net.minecraft.command.ICommand;

public class ModLoaderModContainer
implements ModContainer {
    public BaseModProxy mod;
    private File modSource;
    public Set<ArtifactVersion> requirements = Sets.newHashSet();
    public ArrayList<ArtifactVersion> dependencies = Lists.newArrayList();
    public ArrayList<ArtifactVersion> dependants = Lists.newArrayList();
    private ContainerType sourceType;
    private ModMetadata metadata;
    private ProxyInjector sidedProxy;
    private BaseModTicker gameTickHandler;
    private BaseModTicker guiTickHandler;
    private String modClazzName;
    private String modId;
    private EventBus bus;
    private LoadController controller;
    private boolean enabled = true;
    private String sortingProperties;
    private ArtifactVersion processedVersion;
    private boolean isNetworkMod;
    private List<ICommand> serverCommands = Lists.newArrayList();

    public ModLoaderModContainer(String string, File file, String string2) {
        this.modClazzName = string;
        this.modSource = file;
        this.modId = string.contains(".") ? string.substring(string.lastIndexOf(46) + 1) : string;
        this.sortingProperties = Strings.isNullOrEmpty(string2) ? "" : string2;
    }

    ModLoaderModContainer(BaseModProxy baseModProxy) {
        this.mod = baseModProxy;
        this.gameTickHandler = new BaseModTicker(baseModProxy, false);
        this.guiTickHandler = new BaseModTicker(baseModProxy, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void configureMod(Class<? extends BaseModProxy> clazz, ASMDataTable aSMDataTable) {
        Object object;
        Object object2;
        boolean bl;
        boolean bl2;
        Properties properties;
        File file;
        block34: {
            File file2 = Loader.instance().getConfigDir();
            file = new File(file2, String.format("%s.cfg", this.getModId()));
            properties = new Properties();
            bl2 = false;
            bl = false;
            if (file.exists()) {
                try {
                    FMLLog.fine("Reading existing configuration file for %s : %s", this.getModId(), file.getName());
                    object2 = new FileReader(file);
                    properties.load((Reader)object2);
                    ((InputStreamReader)object2).close();
                }
                catch (Exception exception) {
                    FMLLog.log(Level.SEVERE, exception, "Error occured reading mod configuration file %s", file.getName());
                    throw new LoaderException(exception);
                }
                bl2 = true;
            }
            object2 = new StringBuffer();
            ((StringBuffer)object2).append("MLProperties: name (type:default) min:max -- information\n");
            ArrayList<ModProperty> arrayList = Lists.newArrayList();
            try {
                for (ASMDataTable.ASMData object3 : Sets.union(aSMDataTable.getAnnotationsFor(this).get("net.minecraft.src.MLProp"), aSMDataTable.getAnnotationsFor(this).get("MLProp"))) {
                    if (!object3.getClassName().equals(this.modClazzName)) continue;
                    try {
                        arrayList.add(new ModProperty(clazz.getDeclaredField(object3.getObjectName()), object3.getAnnotationInfo()));
                        FMLLog.finest("Found an MLProp field %s in %s", object3.getObjectName(), this.getModId());
                    }
                    catch (Exception exception) {
                        FMLLog.log(Level.WARNING, exception, "An error occured trying to access field %s in mod %s", object3.getObjectName(), this.getModId());
                    }
                }
                for (ModProperty modProperty : arrayList) {
                    Object object3;
                    String string;
                    String string2;
                    Field field;
                    block33: {
                        if (!Modifier.isStatic(modProperty.field().getModifiers())) {
                            FMLLog.info("The MLProp field %s in mod %s appears not to be static", modProperty.field().getName(), this.getModId());
                            continue;
                        }
                        FMLLog.finest("Considering MLProp field %s", modProperty.field().getName());
                        field = modProperty.field();
                        string2 = !Strings.nullToEmpty(modProperty.name()).isEmpty() ? modProperty.name() : field.getName();
                        string = null;
                        object3 = null;
                        try {
                            object3 = field.get(null);
                            string = properties.getProperty(string2, this.extractValue(object3));
                            Object object4 = this.parseValue(string, modProperty, field.getType(), string2);
                            FMLLog.finest("Configuration for %s.%s found values default: %s, configured: %s, interpreted: %s", this.modClazzName, string2, object3, string, object4);
                            if (object4 == null || object4.equals(object3)) break block33;
                            FMLLog.finest("Configuration for %s.%s value set to: %s", this.modClazzName, string2, object4);
                            field.set(null, object4);
                        }
                        catch (Exception exception) {
                            try {
                                FMLLog.log(Level.SEVERE, exception, "Invalid configuration found for %s in %s", string2, file.getName());
                                throw new LoaderException(exception);
                            }
                            catch (Throwable throwable) {
                                ((StringBuffer)object2).append(String.format("MLProp : %s (%s:%s", string2, field.getType().getName(), object3));
                                if (modProperty.min() != Double.MIN_VALUE) {
                                    ((StringBuffer)object2).append(",>=").append(String.format("%.1f", modProperty.min()));
                                }
                                if (modProperty.max() != Double.MAX_VALUE) {
                                    ((StringBuffer)object2).append(",<=").append(String.format("%.1f", modProperty.max()));
                                }
                                ((StringBuffer)object2).append(")");
                                if (!Strings.nullToEmpty(modProperty.info()).isEmpty()) {
                                    ((StringBuffer)object2).append(" -- ").append(modProperty.info());
                                }
                                if (string != null) {
                                    properties.setProperty(string2, this.extractValue(string));
                                }
                                ((StringBuffer)object2).append("\n");
                                throw throwable;
                            }
                        }
                    }
                    ((StringBuffer)object2).append(String.format("MLProp : %s (%s:%s", string2, field.getType().getName(), object3));
                    if (modProperty.min() != Double.MIN_VALUE) {
                        ((StringBuffer)object2).append(",>=").append(String.format("%.1f", modProperty.min()));
                    }
                    if (modProperty.max() != Double.MAX_VALUE) {
                        ((StringBuffer)object2).append(",<=").append(String.format("%.1f", modProperty.max()));
                    }
                    ((StringBuffer)object2).append(")");
                    if (!Strings.nullToEmpty(modProperty.info()).isEmpty()) {
                        ((StringBuffer)object2).append(" -- ").append(modProperty.info());
                    }
                    if (string != null) {
                        properties.setProperty(string2, this.extractValue(string));
                    }
                    ((StringBuffer)object2).append("\n");
                    bl = true;
                }
                if (bl || bl2) break block34;
            }
            catch (Throwable throwable) {
                if (!bl && !bl2) {
                    FMLLog.fine("No MLProp configuration for %s found or required. No file written", this.getModId());
                    return;
                }
                if (!bl && bl2) {
                    File iOException = new File(file.getParent(), file.getName() + ".bak");
                    FMLLog.fine("MLProp configuration file for %s found but not required. Attempting to rename file to %s", this.getModId(), iOException.getName());
                    boolean bl3 = file.renameTo(iOException);
                    if (bl3) {
                        FMLLog.fine("Unused MLProp configuration file for %s renamed successfully to %s", this.getModId(), iOException.getName());
                    } else {
                        FMLLog.fine("Unused MLProp configuration file for %s renamed UNSUCCESSFULLY to %s", this.getModId(), iOException.getName());
                    }
                    return;
                }
                try {
                    FileWriter fileWriter = new FileWriter(file);
                    properties.store(fileWriter, ((StringBuffer)object2).toString());
                    fileWriter.close();
                    FMLLog.fine("Configuration for %s written to %s", this.getModId(), file.getName());
                }
                catch (IOException iOException) {
                    FMLLog.log(Level.SEVERE, iOException, "Error trying to write the config file %s", file.getName());
                    throw new LoaderException(iOException);
                }
                throw throwable;
            }
            FMLLog.fine("No MLProp configuration for %s found or required. No file written", this.getModId());
            return;
        }
        if (!bl && bl2) {
            object = new File(file.getParent(), file.getName() + ".bak");
            FMLLog.fine("MLProp configuration file for %s found but not required. Attempting to rename file to %s", this.getModId(), ((File)object).getName());
            boolean bl4 = file.renameTo((File)object);
            if (bl4) {
                FMLLog.fine("Unused MLProp configuration file for %s renamed successfully to %s", this.getModId(), ((File)object).getName());
            } else {
                FMLLog.fine("Unused MLProp configuration file for %s renamed UNSUCCESSFULLY to %s", this.getModId(), ((File)object).getName());
            }
            return;
        }
        try {
            object = new FileWriter(file);
            properties.store((Writer)object, ((StringBuffer)object2).toString());
            ((OutputStreamWriter)object).close();
            FMLLog.fine("Configuration for %s written to %s", this.getModId(), file.getName());
        }
        catch (IOException iOException) {
            FMLLog.log(Level.SEVERE, iOException, "Error trying to write the config file %s", file.getName());
            throw new LoaderException(iOException);
        }
    }

    private Object parseValue(String string, ModProperty modProperty, Class<?> clazz, String string2) {
        if (clazz.isAssignableFrom(String.class)) {
            return string;
        }
        if (clazz.isAssignableFrom(Boolean.TYPE) || clazz.isAssignableFrom(Boolean.class)) {
            return Boolean.parseBoolean(string);
        }
        if (Number.class.isAssignableFrom(clazz) || clazz.isPrimitive()) {
            Number number = null;
            if (clazz.isAssignableFrom(Double.TYPE) || Double.class.isAssignableFrom(clazz)) {
                number = Double.parseDouble(string);
            } else if (clazz.isAssignableFrom(Float.TYPE) || Float.class.isAssignableFrom(clazz)) {
                number = Float.valueOf(Float.parseFloat(string));
            } else if (clazz.isAssignableFrom(Long.TYPE) || Long.class.isAssignableFrom(clazz)) {
                number = Long.parseLong(string);
            } else if (clazz.isAssignableFrom(Integer.TYPE) || Integer.class.isAssignableFrom(clazz)) {
                number = Integer.parseInt(string);
            } else if (clazz.isAssignableFrom(Short.TYPE) || Short.class.isAssignableFrom(clazz)) {
                number = Short.parseShort(string);
            } else if (clazz.isAssignableFrom(Byte.TYPE) || Byte.class.isAssignableFrom(clazz)) {
                number = Byte.parseByte(string);
            } else {
                throw new IllegalArgumentException(String.format("MLProp declared on %s of type %s, an unsupported type", string2, clazz.getName()));
            }
            double d = number;
            if (modProperty.min() != Double.MIN_VALUE && d < modProperty.min() || modProperty.max() != Double.MAX_VALUE && d > modProperty.max()) {
                FMLLog.warning("Configuration for %s.%s found value %s outside acceptable range %s,%s", this.modClazzName, string2, number, modProperty.min(), modProperty.max());
                return null;
            }
            return number;
        }
        throw new IllegalArgumentException(String.format("MLProp declared on %s of type %s, an unsupported type", string2, clazz.getName()));
    }

    private String extractValue(Object object) {
        if (String.class.isInstance(object)) {
            return (String)object;
        }
        if (Number.class.isInstance(object) || Boolean.class.isInstance(object)) {
            return String.valueOf(object);
        }
        throw new IllegalArgumentException("MLProp declared on non-standard type");
    }

    @Override
    public String getName() {
        return this.mod != null ? this.mod.getName() : this.modId;
    }

    @Override
    public String getSortingRules() {
        return this.sortingProperties;
    }

    @Override
    public boolean matches(Object object) {
        return this.mod == object;
    }

    public static <A extends BaseModProxy> List<A> findAll(Class<A> clazz) {
        ArrayList<BaseModProxy> arrayList = new ArrayList<BaseModProxy>();
        for (ModContainer modContainer : Loader.instance().getActiveModList()) {
            if (!(modContainer instanceof ModLoaderModContainer) || modContainer.getMod() == null) continue;
            arrayList.add(((ModLoaderModContainer)modContainer).mod);
        }
        return arrayList;
    }

    @Override
    public File getSource() {
        return this.modSource;
    }

    @Override
    public Object getMod() {
        return this.mod;
    }

    @Override
    public Set<ArtifactVersion> getRequirements() {
        return this.requirements;
    }

    @Override
    public List<ArtifactVersion> getDependants() {
        return this.dependants;
    }

    @Override
    public List<ArtifactVersion> getDependencies() {
        return this.dependencies;
    }

    public String toString() {
        return this.modId;
    }

    @Override
    public ModMetadata getMetadata() {
        return this.metadata;
    }

    @Override
    public String getVersion() {
        if (this.mod == null || this.mod.getVersion() == null) {
            return "Not available";
        }
        return this.mod.getVersion();
    }

    public BaseModTicker getGameTickHandler() {
        return this.gameTickHandler;
    }

    public BaseModTicker getGUITickHandler() {
        return this.guiTickHandler;
    }

    @Override
    public String getModId() {
        return this.modId;
    }

    @Override
    public void bindMetadata(MetadataCollection metadataCollection) {
        ImmutableMap<String, Object> immutableMap = ImmutableMap.builder().put("name", this.modId).put("version", "1.0").build();
        this.metadata = metadataCollection.getMetadataForId(this.modId, immutableMap);
        Loader.instance().computeDependencies(this.sortingProperties, this.getRequirements(), this.getDependencies(), this.getDependants());
    }

    @Override
    public void setEnabledState(boolean bl) {
        this.enabled = bl;
    }

    @Override
    public boolean registerBus(EventBus eventBus, LoadController loadController) {
        if (this.enabled) {
            FMLLog.fine("Enabling mod %s", this.getModId());
            this.bus = eventBus;
            this.controller = loadController;
            eventBus.register(this);
            return true;
        }
        return false;
    }

    @Subscribe
    public void constructMod(FMLConstructionEvent fMLConstructionEvent) {
        try {
            ModClassLoader modClassLoader = fMLConstructionEvent.getModClassLoader();
            modClassLoader.addFile(this.modSource);
            EnumSet<TickType> enumSet = EnumSet.noneOf(TickType.class);
            this.gameTickHandler = new BaseModTicker(enumSet, false);
            this.guiTickHandler = new BaseModTicker((EnumSet<TickType>)enumSet.clone(), true);
            Class<? extends BaseModProxy> clazz = modClassLoader.loadBaseModClass(this.modClazzName);
            this.configureMod(clazz, fMLConstructionEvent.getASMHarvestedData());
            this.isNetworkMod = FMLNetworkHandler.instance().registerNetworkMod(this, clazz, fMLConstructionEvent.getASMHarvestedData());
            ModLoaderNetworkHandler modLoaderNetworkHandler = null;
            if (!this.isNetworkMod) {
                FMLLog.fine("Injecting dummy network mod handler for BaseMod %s", this.getModId());
                modLoaderNetworkHandler = new ModLoaderNetworkHandler(this);
                FMLNetworkHandler.instance().registerNetworkMod(modLoaderNetworkHandler);
            }
            Constructor<? extends BaseModProxy> constructor = clazz.getConstructor(new Class[0]);
            constructor.setAccessible(true);
            this.mod = clazz.newInstance();
            if (modLoaderNetworkHandler != null) {
                modLoaderNetworkHandler.setBaseMod(this.mod);
            }
            ProxyInjector.inject(this, fMLConstructionEvent.getASMHarvestedData(), FMLCommonHandler.instance().getSide(), new ILanguageAdapter.JavaAdapter());
        }
        catch (Exception exception) {
            this.controller.errorOccurred(this, exception);
            Throwables.propagateIfPossible(exception);
        }
    }

    @Subscribe
    public void preInit(FMLPreInitializationEvent fMLPreInitializationEvent) {
        try {
            this.gameTickHandler.setMod(this.mod);
            this.guiTickHandler.setMod(this.mod);
            TickRegistry.registerTickHandler(this.gameTickHandler, Side.CLIENT);
            TickRegistry.registerTickHandler(this.guiTickHandler, Side.CLIENT);
            GameRegistry.registerWorldGenerator(ModLoaderHelper.buildWorldGenHelper(this.mod));
            GameRegistry.registerFuelHandler(ModLoaderHelper.buildFuelHelper(this.mod));
            GameRegistry.registerCraftingHandler(ModLoaderHelper.buildCraftingHelper(this.mod));
            GameRegistry.registerPickupHandler(ModLoaderHelper.buildPickupHelper(this.mod));
            NetworkRegistry.instance().registerChatListener(ModLoaderHelper.buildChatListener(this.mod));
            NetworkRegistry.instance().registerConnectionHandler(ModLoaderHelper.buildConnectionHelper(this.mod));
        }
        catch (Exception exception) {
            this.controller.errorOccurred(this, exception);
            Throwables.propagateIfPossible(exception);
        }
    }

    @Subscribe
    public void init(FMLInitializationEvent fMLInitializationEvent) {
        try {
            this.mod.load();
        }
        catch (Throwable throwable) {
            this.controller.errorOccurred(this, throwable);
            Throwables.propagateIfPossible(throwable);
        }
    }

    @Subscribe
    public void postInit(FMLPostInitializationEvent fMLPostInitializationEvent) {
        try {
            this.mod.modsLoaded();
        }
        catch (Throwable throwable) {
            this.controller.errorOccurred(this, throwable);
            Throwables.propagateIfPossible(throwable);
        }
    }

    @Subscribe
    public void loadComplete(FMLLoadCompleteEvent fMLLoadCompleteEvent) {
        ModLoaderHelper.finishModLoading(this);
    }

    @Subscribe
    public void serverStarting(FMLServerStartingEvent fMLServerStartingEvent) {
        for (ICommand iCommand : this.serverCommands) {
            fMLServerStartingEvent.registerServerCommand(iCommand);
        }
    }

    @Override
    public ArtifactVersion getProcessedVersion() {
        if (this.processedVersion == null) {
            this.processedVersion = new DefaultArtifactVersion(this.modId, this.getVersion());
        }
        return this.processedVersion;
    }

    @Override
    public boolean isImmutable() {
        return false;
    }

    @Override
    public boolean isNetworkMod() {
        return this.isNetworkMod;
    }

    @Override
    public String getDisplayVersion() {
        return this.metadata != null ? this.metadata.version : this.getVersion();
    }

    public void addServerCommand(ICommand iCommand) {
        this.serverCommands.add(iCommand);
    }

    @Override
    public VersionRange acceptableMinecraftVersionRange() {
        return Loader.instance().getMinecraftModContainer().getStaticVersionRange();
    }

    @Override
    public Certificate getSigningCertificate() {
        return null;
    }

    @Override
    public Map<String, String> getCustomModProperties() {
        return EMPTY_PROPERTIES;
    }

    @Override
    public Class<?> getCustomResourcePackClass() {
        return null;
    }

    @Override
    public Map<String, String> getSharedModDescriptor() {
        HashMap<String, String> hashMap = Maps.newHashMap();
        hashMap.put("modsystem", "ModLoader");
        hashMap.put("id", this.getModId());
        hashMap.put("version", this.getDisplayVersion());
        hashMap.put("name", this.getName());
        hashMap.put("url", this.metadata.url);
        hashMap.put("authors", this.metadata.getAuthorList());
        hashMap.put("description", this.metadata.description);
        return hashMap;
    }
}

