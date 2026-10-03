/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.discovery;

import com.google.common.base.Predicate;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.SetMultimap;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.discovery.ModCandidate;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ASMDataTable {
    private SetMultimap<String, ASMData> globalAnnotationData = HashMultimap.create();
    private Map<ModContainer, SetMultimap<String, ASMData>> containerAnnotationData;
    private List<ModContainer> containers = Lists.newArrayList();
    private SetMultimap<String, ModCandidate> packageMap = HashMultimap.create();

    public SetMultimap<String, ASMData> getAnnotationsFor(ModContainer modContainer) {
        if (this.containerAnnotationData == null) {
            ImmutableMap.Builder<ModContainer, ImmutableSetMultimap<String, ASMData>> builder = ImmutableMap.builder();
            for (ModContainer modContainer2 : this.containers) {
                Multimap<String, ASMData> multimap = Multimaps.filterValues(this.globalAnnotationData, new ModContainerPredicate(modContainer2));
                builder.put(modContainer2, ImmutableSetMultimap.copyOf(multimap));
            }
            this.containerAnnotationData = builder.build();
        }
        return this.containerAnnotationData.get(modContainer);
    }

    public Set<ASMData> getAll(String string) {
        return this.globalAnnotationData.get(string);
    }

    public void addASMData(ModCandidate modCandidate, String string, String string2, String string3, Map<String, Object> map) {
        this.globalAnnotationData.put(string, new ASMData(modCandidate, string, string2, string3, map));
    }

    public void addContainer(ModContainer modContainer) {
        this.containers.add(modContainer);
    }

    public void registerPackage(ModCandidate modCandidate, String string) {
        this.packageMap.put(string, modCandidate);
    }

    public Set<ModCandidate> getCandidatesFor(String string) {
        return this.packageMap.get(string);
    }

    private static class ModContainerPredicate
    implements Predicate<ASMData> {
        private ModContainer container;

        public ModContainerPredicate(ModContainer modContainer) {
            this.container = modContainer;
        }

        @Override
        public boolean apply(ASMData aSMData) {
            return this.container.getSource().equals(aSMData.candidate.getModContainer());
        }
    }

    public static final class ASMData
    implements Cloneable {
        private ModCandidate candidate;
        private String annotationName;
        private String className;
        private String objectName;
        private Map<String, Object> annotationInfo;

        public ASMData(ModCandidate modCandidate, String string, String string2, String string3, Map<String, Object> map) {
            this.candidate = modCandidate;
            this.annotationName = string;
            this.className = string2;
            this.objectName = string3;
            this.annotationInfo = map;
        }

        public ModCandidate getCandidate() {
            return this.candidate;
        }

        public String getAnnotationName() {
            return this.annotationName;
        }

        public String getClassName() {
            return this.className;
        }

        public String getObjectName() {
            return this.objectName;
        }

        public Map<String, Object> getAnnotationInfo() {
            return this.annotationInfo;
        }

        public ASMData copy(Map<String, Object> map) {
            try {
                ASMData aSMData = (ASMData)this.clone();
                aSMData.annotationInfo = map;
                return aSMData;
            }
            catch (CloneNotSupportedException cloneNotSupportedException) {
                throw new RuntimeException("Unpossible", cloneNotSupportedException);
            }
        }
    }
}

