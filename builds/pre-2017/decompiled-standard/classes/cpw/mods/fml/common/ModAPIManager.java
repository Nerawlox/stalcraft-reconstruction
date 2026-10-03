/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.ModClassLoader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.asm.transformers.ModAPITransformer;
import cpw.mods.fml.common.discovery.ASMDataTable;
import cpw.mods.fml.common.discovery.ModCandidate;
import cpw.mods.fml.common.discovery.ModDiscoverer;
import cpw.mods.fml.common.functions.ModIdFunction;
import cpw.mods.fml.common.versioning.ArtifactVersion;
import cpw.mods.fml.common.versioning.DefaultArtifactVersion;
import cpw.mods.fml.common.versioning.VersionParser;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ModAPIManager {
    public static final ModAPIManager INSTANCE = new ModAPIManager();
    private ModAPITransformer transformer;
    private ASMDataTable dataTable;
    private Map<String, APIContainer> apiContainers;

    public void registerDataTableAndParseAPI(ASMDataTable aSMDataTable) {
        List<String> list2;
        Object object;
        Object object2;
        Object object3;
        Object object42;
        Object object5;
        this.dataTable = aSMDataTable;
        Set<ASMDataTable.ASMData> set = aSMDataTable.getAll("cpw.mods.fml.common.API");
        this.apiContainers = Maps.newHashMap();
        for (ASMDataTable.ASMData object6 : set) {
            object5 = object6.getAnnotationInfo();
            object42 = object6.getClassName().substring(0, object6.getClassName().indexOf(".package-info"));
            object3 = (String)object5.get("provides");
            object2 = (String)object5.get("owner");
            object = (String)object5.get("apiVersion");
            list2 = this.apiContainers.get(object3);
            if (list2 == null) {
                list2 = new APIContainer((String)object3, (String)object, object6.getCandidate().getModContainer(), VersionParser.parseVersionReference((String)object2));
                this.apiContainers.put((String)object3, (APIContainer)((Object)list2));
            } else {
                ((APIContainer)((Object)list2)).validate((String)object3, (String)object2, (String)object);
            }
            ((APIContainer)((Object)list2)).addOwnedPackage((String)object42);
            for (ModContainer modContainer : object6.getCandidate().getContainedMods()) {
                String string = modContainer.getModId();
                if (((APIContainer)((Object)list2)).currentReferents.contains(string)) continue;
                FMLLog.fine("Found API %s (owned by %s providing %s) embedded in %s", object42, object2, object3, string);
                if (string.equals(object2)) continue;
                ((APIContainer)((Object)list2)).addAPIReference(string);
            }
        }
        for (APIContainer aPIContainer : this.apiContainers.values()) {
            for (Object object42 : aPIContainer.packages) {
                object3 = aSMDataTable.getCandidatesFor((String)object42);
                object2 = object3.iterator();
                while (object2.hasNext()) {
                    object = (ModCandidate)object2.next();
                    list2 = Lists.transform(((ModCandidate)object).getContainedMods(), new ModIdFunction());
                    if (list2.contains(aPIContainer.ownerMod.getLabel()) || aPIContainer.currentReferents.containsAll(list2)) continue;
                    FMLLog.info("Found mod(s) %s containing declared API package %s (owned by %s) without associated API reference", list2, object42, aPIContainer.ownerMod);
                    aPIContainer.addAPIReferences(list2);
                }
            }
            if (this.apiContainers.containsKey(aPIContainer.ownerMod.getLabel())) {
                object5 = aPIContainer.ownerMod;
                do {
                    object42 = this.apiContainers.get(object5.getLabel());
                    FMLLog.finest("Removing upstream parent %s from %s", ((APIContainer)object42).ownerMod.getLabel(), aPIContainer);
                    aPIContainer.currentReferents.remove(((APIContainer)object42).ownerMod.getLabel());
                    aPIContainer.referredMods.remove(((APIContainer)object42).ownerMod);
                } while (this.apiContainers.containsKey((object5 = ((APIContainer)object42).ownerMod).getLabel()));
            }
            FMLLog.fine("Creating API container dummy for API %s: owner: %s, dependents: %s", aPIContainer.providedAPI, aPIContainer.ownerMod, aPIContainer.referredMods);
        }
    }

    public void manageAPI(ModClassLoader modClassLoader, ModDiscoverer modDiscoverer) {
        this.registerDataTableAndParseAPI(modDiscoverer.getASMTable());
        this.transformer = modClassLoader.addModAPITransformer(this.dataTable);
    }

    public void injectAPIModContainers(List<ModContainer> list2, Map<String, ModContainer> map) {
        list2.addAll(this.apiContainers.values());
        map.putAll(this.apiContainers);
    }

    public void cleanupAPIContainers(List<ModContainer> list2) {
        list2.removeAll(this.apiContainers.values());
    }

    public boolean hasAPI(String string) {
        return this.apiContainers.containsKey(string);
    }

    private static class APIContainer
    extends DummyModContainer {
        private List<ArtifactVersion> referredMods;
        private ArtifactVersion ownerMod;
        private ArtifactVersion ourVersion;
        private String providedAPI;
        private File source;
        private String version;
        private Set<String> currentReferents;
        private Set<String> packages;

        public APIContainer(String string, String string2, File file, ArtifactVersion artifactVersion) {
            this.providedAPI = string;
            this.version = string2;
            this.ownerMod = artifactVersion;
            this.ourVersion = new DefaultArtifactVersion(string, string2);
            this.referredMods = Lists.newArrayList();
            this.source = file;
            this.currentReferents = Sets.newHashSet();
            this.packages = Sets.newHashSet();
        }

        @Override
        public File getSource() {
            return this.source;
        }

        @Override
        public String getVersion() {
            return this.version;
        }

        @Override
        public String getName() {
            return "API: " + this.providedAPI;
        }

        @Override
        public String getModId() {
            return "API:" + this.providedAPI;
        }

        @Override
        public List<ArtifactVersion> getDependants() {
            return this.referredMods;
        }

        @Override
        public List<ArtifactVersion> getDependencies() {
            return ImmutableList.of(this.ownerMod);
        }

        @Override
        public ArtifactVersion getProcessedVersion() {
            return this.ourVersion;
        }

        public void validate(String string, String string2, String string3) {
        }

        @Override
        public String toString() {
            return "APIContainer{" + this.providedAPI + ":" + this.version + "}";
        }

        public void addAPIReference(String string) {
            if (this.currentReferents.add(string)) {
                this.referredMods.add(VersionParser.parseVersionReference(string));
            }
        }

        public void addOwnedPackage(String string) {
            this.packages.add(string);
        }

        public void addAPIReferences(List<String> list2) {
            for (String string : list2) {
                this.addAPIReference(string);
            }
        }
    }
}

