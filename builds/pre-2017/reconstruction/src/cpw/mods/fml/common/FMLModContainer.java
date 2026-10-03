/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common;

import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.base.Throwables;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import cpw.mods.fml.common.CertificateHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.ILanguageAdapter;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.MetadataCollection;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModClassLoader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.ProxyInjector;
import cpw.mods.fml.common.discovery.ASMDataTable;
import cpw.mods.fml.common.discovery.ModCandidate;
import cpw.mods.fml.common.event.FMLConstructionEvent;
import cpw.mods.fml.common.event.FMLEvent;
import cpw.mods.fml.common.event.FMLFingerprintViolationEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerAboutToStartEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLServerStoppedEvent;
import cpw.mods.fml.common.event.FMLServerStoppingEvent;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.common.versioning.ArtifactVersion;
import cpw.mods.fml.common.versioning.DefaultArtifactVersion;
import cpw.mods.fml.common.versioning.VersionParser;
import cpw.mods.fml.common.versioning.VersionRange;
import java.io.File;
import java.io.FileInputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class FMLModContainer
implements ModContainer {
    private Mod modDescriptor;
    private Object modInstance;
    private File source;
    private ModMetadata modMetadata;
    private String className;
    private Map<String, Object> descriptor;
    private boolean enabled = true;
    private String internalVersion;
    private boolean overridesMetadata;
    private EventBus eventBus;
    private LoadController controller;
    private DefaultArtifactVersion processedVersion;
    private boolean isNetworkMod;
    private static final BiMap<Class<? extends FMLEvent>, Class<? extends Annotation>> modAnnotationTypes = ((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)((ImmutableBiMap.Builder)ImmutableBiMap.builder().put(FMLPreInitializationEvent.class, Mod.PreInit.class)).put(FMLInitializationEvent.class, Mod.Init.class)).put(FMLPostInitializationEvent.class, Mod.PostInit.class)).put(FMLServerAboutToStartEvent.class, Mod.ServerAboutToStart.class)).put(FMLServerStartingEvent.class, Mod.ServerStarting.class)).put(FMLServerStartedEvent.class, Mod.ServerStarted.class)).put(FMLServerStoppingEvent.class, Mod.ServerStopping.class)).put(FMLServerStoppedEvent.class, Mod.ServerStopped.class)).put(FMLInterModComms.IMCEvent.class, Mod.IMCCallback.class)).put(FMLFingerprintViolationEvent.class, Mod.FingerprintWarning.class)).build();
    private static final BiMap<Class<? extends Annotation>, Class<? extends FMLEvent>> modTypeAnnotations = modAnnotationTypes.inverse();
    private String annotationDependencies;
    private VersionRange minecraftAccepted;
    private boolean fingerprintNotPresent;
    private Set<String> sourceFingerprints;
    private Certificate certificate;
    private String modLanguage;
    private ILanguageAdapter languageAdapter;
    private ListMultimap<Class<? extends FMLEvent>, Method> eventMethods;
    private Map<String, String> customModProperties;
    private ModCandidate candidate;

    public FMLModContainer(String string, ModCandidate modCandidate, Map<String, Object> map) {
        this.className = string;
        this.source = modCandidate.getModContainer();
        this.candidate = modCandidate;
        this.descriptor = map;
        this.modLanguage = (String)map.get("modLanguage");
        this.languageAdapter = "scala".equals(this.modLanguage) ? new ILanguageAdapter.ScalaAdapter() : new ILanguageAdapter.JavaAdapter();
        this.eventMethods = ArrayListMultimap.create();
    }

    private ILanguageAdapter getLanguageAdapter() {
        return this.languageAdapter;
    }

    @Override
    public String getModId() {
        return (String)this.descriptor.get("modid");
    }

    @Override
    public String getName() {
        return this.modMetadata.name;
    }

    @Override
    public String getVersion() {
        return this.internalVersion;
    }

    @Override
    public File getSource() {
        return this.source;
    }

    @Override
    public ModMetadata getMetadata() {
        return this.modMetadata;
    }

    @Override
    public void bindMetadata(MetadataCollection metadataCollection) {
        Object object;
        this.modMetadata = metadataCollection.getMetadataForId(this.getModId(), this.descriptor);
        if (this.descriptor.containsKey("useMetadata")) {
            boolean bl = this.overridesMetadata = (Boolean)this.descriptor.get("useMetadata") == false;
        }
        if (this.overridesMetadata || !this.modMetadata.useDependencyInformation) {
            object = Sets.newHashSet();
            ArrayList<ArtifactVersion> arrayList = Lists.newArrayList();
            ArrayList<ArtifactVersion> arrayList2 = Lists.newArrayList();
            this.annotationDependencies = (String)this.descriptor.get("dependencies");
            Loader.instance().computeDependencies(this.annotationDependencies, (Set<ArtifactVersion>)object, (List<ArtifactVersion>)arrayList, (List<ArtifactVersion>)arrayList2);
            this.modMetadata.requiredMods = object;
            this.modMetadata.dependencies = arrayList;
            this.modMetadata.dependants = arrayList2;
            FMLLog.log(this.getModId(), Level.FINEST, "Parsed dependency info : %s %s %s", object, arrayList, arrayList2);
        } else {
            FMLLog.log(this.getModId(), Level.FINEST, "Using mcmod dependency info : %s %s %s", this.modMetadata.requiredMods, this.modMetadata.dependencies, this.modMetadata.dependants);
        }
        if (Strings.isNullOrEmpty(this.modMetadata.name)) {
            FMLLog.log(this.getModId(), Level.INFO, "Mod %s is missing the required element 'name'. Substituting %s", this.getModId(), this.getModId());
            this.modMetadata.name = this.getModId();
        }
        this.internalVersion = (String)this.descriptor.get("version");
        if (Strings.isNullOrEmpty(this.internalVersion) && (object = this.searchForVersionProperties()) != null) {
            this.internalVersion = ((Properties)object).getProperty(this.getModId() + ".version");
            FMLLog.log(this.getModId(), Level.FINE, "Found version %s for mod %s in version.properties, using", this.internalVersion, this.getModId());
        }
        if (Strings.isNullOrEmpty(this.internalVersion) && !Strings.isNullOrEmpty(this.modMetadata.version)) {
            FMLLog.log(this.getModId(), Level.WARNING, "Mod %s is missing the required element 'version' and a version.properties file could not be found. Falling back to metadata version %s", this.getModId(), this.modMetadata.version);
            this.internalVersion = this.modMetadata.version;
        }
        if (Strings.isNullOrEmpty(this.internalVersion)) {
            FMLLog.log(this.getModId(), Level.WARNING, "Mod %s is missing the required element 'version' and no fallback can be found. Substituting '1.0'.", this.getModId());
            this.internalVersion = "1.0";
            this.modMetadata.version = "1.0";
        }
        this.minecraftAccepted = !Strings.isNullOrEmpty((String)(object = (String)this.descriptor.get("acceptedMinecraftVersions"))) ? VersionParser.parseRange((String)object) : Loader.instance().getMinecraftModContainer().getStaticVersionRange();
    }

    public Properties searchForVersionProperties() {
        try {
            File file;
            FMLLog.log(this.getModId(), Level.FINE, "Attempting to load the file version.properties from %s to locate a version number for %s", this.getSource().getName(), this.getModId());
            Properties properties = null;
            if (this.getSource().isFile()) {
                ZipFile zipFile = new ZipFile(this.getSource());
                ZipEntry zipEntry = zipFile.getEntry("version.properties");
                if (zipEntry != null) {
                    properties = new Properties();
                    properties.load(zipFile.getInputStream(zipEntry));
                }
                zipFile.close();
            } else if (this.getSource().isDirectory() && (file = new File(this.getSource(), "version.properties")).exists() && file.isFile()) {
                properties = new Properties();
                FileInputStream fileInputStream = new FileInputStream(file);
                properties.load(fileInputStream);
                fileInputStream.close();
            }
            return properties;
        }
        catch (Exception exception) {
            Throwables.propagateIfPossible(exception);
            FMLLog.log(this.getModId(), Level.FINEST, "Failed to find a usable version.properties file", new Object[0]);
            return null;
        }
    }

    @Override
    public void setEnabledState(boolean bl) {
        this.enabled = bl;
    }

    @Override
    public Set<ArtifactVersion> getRequirements() {
        return this.modMetadata.requiredMods;
    }

    @Override
    public List<ArtifactVersion> getDependencies() {
        return this.modMetadata.dependencies;
    }

    @Override
    public List<ArtifactVersion> getDependants() {
        return this.modMetadata.dependants;
    }

    @Override
    public String getSortingRules() {
        return this.overridesMetadata || !this.modMetadata.useDependencyInformation ? Strings.nullToEmpty(this.annotationDependencies) : this.modMetadata.printableSortingRules();
    }

    @Override
    public boolean matches(Object object) {
        return object == this.modInstance;
    }

    @Override
    public Object getMod() {
        return this.modInstance;
    }

    @Override
    public boolean registerBus(EventBus eventBus, LoadController loadController) {
        if (this.enabled) {
            FMLLog.log(this.getModId(), Level.FINE, "Enabling mod %s", this.getModId());
            this.eventBus = eventBus;
            this.controller = loadController;
            this.eventBus.register(this);
            return true;
        }
        return false;
    }

    private Method gatherAnnotations(Class<?> clazz) throws Exception {
        Method method = null;
        for (Method method2 : clazz.getDeclaredMethods()) {
            for (Annotation annotation : method2.getAnnotations()) {
                if (modTypeAnnotations.containsKey(annotation.annotationType())) {
                    Object[] objectArray = new Class[]{(Class)modTypeAnnotations.get(annotation.annotationType())};
                    if (Arrays.equals(method2.getParameterTypes(), objectArray)) {
                        method2.setAccessible(true);
                        this.eventMethods.put((Class<? extends FMLEvent>)modTypeAnnotations.get(annotation.annotationType()), method2);
                        continue;
                    }
                    FMLLog.log(this.getModId(), Level.SEVERE, "The mod %s appears to have an invalid method annotation %s. This annotation can only apply to methods with argument types %s -it will not be called", this.getModId(), annotation.annotationType().getSimpleName(), Arrays.toString(objectArray));
                    continue;
                }
                if (annotation.annotationType().equals(Mod.EventHandler.class)) {
                    if (method2.getParameterTypes().length == 1 && modAnnotationTypes.containsKey(method2.getParameterTypes()[0])) {
                        method2.setAccessible(true);
                        this.eventMethods.put(method2.getParameterTypes()[0], method2);
                        continue;
                    }
                    FMLLog.log(this.getModId(), Level.SEVERE, "The mod %s appears to have an invalid event annotation %s. This annotation can only apply to methods with recognized event arguments - it will not be called", this.getModId(), annotation.annotationType().getSimpleName());
                    continue;
                }
                if (!annotation.annotationType().equals(Mod.InstanceFactory.class)) continue;
                if (Modifier.isStatic(method2.getModifiers()) && method2.getParameterTypes().length == 0 && method == null) {
                    method2.setAccessible(true);
                    method = method2;
                    continue;
                }
                if (!Modifier.isStatic(method2.getModifiers()) || method2.getParameterTypes().length != 0) {
                    FMLLog.log(this.getModId(), Level.SEVERE, "The InstanceFactory annotation can only apply to a static method, taking zero arguments - it will be ignored on %s(%s)", method2.getName(), Arrays.asList(method2.getParameterTypes()));
                    continue;
                }
                if (method == null) continue;
                FMLLog.log(this.getModId(), Level.SEVERE, "The InstanceFactory annotation can only be used once, the application to %s(%s) will be ignored", method2.getName(), Arrays.asList(method2.getParameterTypes()));
            }
        }
        return method;
    }

    private void processFieldAnnotations(ASMDataTable aSMDataTable) throws Exception {
        SetMultimap<String, ASMDataTable.ASMData> setMultimap = aSMDataTable.getAnnotationsFor(this);
        this.parseSimpleFieldAnnotation(setMultimap, Mod.Instance.class.getName(), new Function<ModContainer, Object>(){

            @Override
            public Object apply(ModContainer modContainer) {
                return modContainer.getMod();
            }
        });
        this.parseSimpleFieldAnnotation(setMultimap, Mod.Metadata.class.getName(), new Function<ModContainer, Object>(){

            @Override
            public Object apply(ModContainer modContainer) {
                return modContainer.getMetadata();
            }
        });
    }

    private void parseSimpleFieldAnnotation(SetMultimap<String, ASMDataTable.ASMData> setMultimap, String string, Function<ModContainer, Object> function) throws IllegalAccessException {
        String[] stringArray = string.split("\\.");
        String string2 = stringArray[stringArray.length - 1];
        for (ASMDataTable.ASMData aSMData : setMultimap.get(string)) {
            String string3 = (String)aSMData.getAnnotationInfo().get("value");
            Field field = null;
            Object object = null;
            ModContainer modContainer = this;
            boolean bl = false;
            Class<?> clazz = this.modInstance.getClass();
            if (!Strings.isNullOrEmpty(string3)) {
                modContainer = Loader.isModLoaded(string3) ? Loader.instance().getIndexedModList().get(string3) : null;
            }
            if (modContainer != null) {
                try {
                    clazz = Class.forName(aSMData.getClassName(), true, Loader.instance().getModClassLoader());
                    field = clazz.getDeclaredField(aSMData.getObjectName());
                    field.setAccessible(true);
                    bl = Modifier.isStatic(field.getModifiers());
                    object = function.apply(modContainer);
                }
                catch (Exception exception) {
                    Throwables.propagateIfPossible(exception);
                    FMLLog.log(this.getModId(), Level.WARNING, exception, "Attempting to load @%s in class %s for %s and failing", string2, aSMData.getClassName(), modContainer.getModId());
                }
            }
            if (field == null) continue;
            Object object2 = null;
            if (!bl) {
                object2 = this.modInstance;
                if (!this.modInstance.getClass().equals(clazz)) {
                    FMLLog.log(this.getModId(), Level.WARNING, "Unable to inject @%s in non-static field %s.%s for %s as it is NOT the primary mod instance", string2, aSMData.getClassName(), aSMData.getObjectName(), modContainer.getModId());
                    continue;
                }
            }
            field.set(object2, object);
        }
    }

    @Subscribe
    public void constructMod(FMLConstructionEvent fMLConstructionEvent) {
        try {
            Object object;
            Object object2;
            ModClassLoader modClassLoader = fMLConstructionEvent.getModClassLoader();
            modClassLoader.addFile(this.source);
            modClassLoader.clearNegativeCacheFor(this.candidate.getClassList());
            Class<?> clazz = Class.forName(this.className, true, modClassLoader);
            Certificate[] certificateArray = clazz.getProtectionDomain().getCodeSource().getCertificates();
            int n = 0;
            if (certificateArray != null) {
                n = certificateArray.length;
            }
            ImmutableList.Builder builder = ImmutableList.builder();
            for (int i = 0; i < n; ++i) {
                builder.add(CertificateHelper.getFingerprint(certificateArray[i]));
            }
            ImmutableCollection immutableCollection = builder.build();
            this.sourceFingerprints = ImmutableSet.copyOf(immutableCollection);
            String string = (String)this.descriptor.get("certificateFingerprint");
            this.fingerprintNotPresent = true;
            if (string != null && !string.isEmpty()) {
                if (!this.sourceFingerprints.contains(string)) {
                    object2 = Level.SEVERE;
                    if (this.source.isDirectory()) {
                        object2 = Level.FINER;
                    }
                    FMLLog.log(this.getModId(), (Level)object2, "The mod %s is expecting signature %s for source %s, however there is no signature matching that description", this.getModId(), string, this.source.getName());
                } else {
                    this.certificate = certificateArray[((ImmutableList)immutableCollection).indexOf(string)];
                    this.fingerprintNotPresent = false;
                }
            }
            if ((object2 = (List)this.descriptor.get("customProperties")) != null) {
                object = ImmutableMap.builder();
                Iterator iterator2 = object2.iterator();
                while (iterator2.hasNext()) {
                    Map map = (Map)iterator2.next();
                    ((ImmutableMap.Builder)object).put((String)map.get("k"), (String)map.get("v"));
                }
                this.customModProperties = ((ImmutableMap.Builder)object).build();
            } else {
                this.customModProperties = EMPTY_PROPERTIES;
            }
            object = this.gatherAnnotations(clazz);
            this.modInstance = this.getLanguageAdapter().getNewInstance(this, clazz, modClassLoader, (Method)object);
            this.isNetworkMod = FMLNetworkHandler.instance().registerNetworkMod(this, clazz, fMLConstructionEvent.getASMHarvestedData());
            if (this.fingerprintNotPresent) {
                this.eventBus.post(new FMLFingerprintViolationEvent(this.source.isDirectory(), this.source, ImmutableSet.copyOf(this.sourceFingerprints), string));
            }
            ProxyInjector.inject(this, fMLConstructionEvent.getASMHarvestedData(), FMLCommonHandler.instance().getSide(), this.getLanguageAdapter());
            this.processFieldAnnotations(fMLConstructionEvent.getASMHarvestedData());
        }
        catch (Throwable throwable) {
            this.controller.errorOccurred(this, throwable);
            Throwables.propagateIfPossible(throwable);
        }
    }

    @Subscribe
    public void handleModStateEvent(FMLEvent fMLEvent) {
        if (!this.eventMethods.containsKey(fMLEvent.getClass())) {
            return;
        }
        try {
            for (Method method : this.eventMethods.get(fMLEvent.getClass())) {
                method.invoke(this.modInstance, fMLEvent);
            }
        }
        catch (Throwable throwable) {
            this.controller.errorOccurred(this, throwable);
        }
    }

    @Override
    public ArtifactVersion getProcessedVersion() {
        if (this.processedVersion == null) {
            this.processedVersion = new DefaultArtifactVersion(this.getModId(), this.getVersion());
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
        return this.modMetadata.version;
    }

    @Override
    public VersionRange acceptableMinecraftVersionRange() {
        return this.minecraftAccepted;
    }

    @Override
    public Certificate getSigningCertificate() {
        return this.certificate;
    }

    public String toString() {
        return "FMLMod:" + this.getModId() + "{" + this.getVersion() + "}";
    }

    @Override
    public Map<String, String> getCustomModProperties() {
        return this.customModProperties;
    }

    @Override
    public Class<?> getCustomResourcePackClass() {
        try {
            return this.getSource().isDirectory() ? Class.forName("cpw.mods.fml.client.FMLFolderResourcePack", true, this.getClass().getClassLoader()) : Class.forName("cpw.mods.fml.client.FMLFileResourcePack", true, this.getClass().getClassLoader());
        }
        catch (ClassNotFoundException classNotFoundException) {
            return null;
        }
    }

    @Override
    public Map<String, String> getSharedModDescriptor() {
        HashMap<String, String> hashMap = Maps.newHashMap();
        hashMap.put("modsystem", "FML");
        hashMap.put("id", this.getModId());
        hashMap.put("version", this.getDisplayVersion());
        hashMap.put("name", this.getName());
        hashMap.put("url", this.modMetadata.url);
        hashMap.put("authors", this.modMetadata.getAuthorList());
        hashMap.put("description", this.modMetadata.description);
        return hashMap;
    }
}

