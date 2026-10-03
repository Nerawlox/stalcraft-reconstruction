/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.toposort;

import com.google.common.collect.Maps;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModAPIManager;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.toposort.TopologicalSort;
import cpw.mods.fml.common.versioning.ArtifactVersion;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModSorter {
    private TopologicalSort.DirectedGraph<ModContainer> modGraph;
    private ModContainer beforeAll = new DummyModContainer("BeforeAll");
    private ModContainer afterAll = new DummyModContainer("AfterAll");
    private ModContainer before = new DummyModContainer("Before");
    private ModContainer after = new DummyModContainer("After");

    public ModSorter(List<ModContainer> list2, Map<String, ModContainer> map) {
        HashMap<String, ModContainer> hashMap = Maps.newHashMap(map);
        ModAPIManager.INSTANCE.injectAPIModContainers(list2, hashMap);
        this.buildGraph(list2, hashMap);
    }

    private void buildGraph(List<ModContainer> list2, Map<String, ModContainer> map) {
        this.modGraph = new TopologicalSort.DirectedGraph();
        this.modGraph.addNode(this.beforeAll);
        this.modGraph.addNode(this.before);
        this.modGraph.addNode(this.afterAll);
        this.modGraph.addNode(this.after);
        this.modGraph.addEdge(this.before, this.after);
        this.modGraph.addEdge(this.beforeAll, this.before);
        this.modGraph.addEdge(this.after, this.afterAll);
        for (ModContainer modContainer : list2) {
            this.modGraph.addNode(modContainer);
        }
        for (ModContainer modContainer : list2) {
            String string;
            if (modContainer.isImmutable()) {
                this.modGraph.addEdge(this.beforeAll, modContainer);
                this.modGraph.addEdge(modContainer, this.before);
                continue;
            }
            boolean bl = false;
            boolean bl2 = false;
            for (ArtifactVersion artifactVersion : modContainer.getDependencies()) {
                bl = true;
                string = artifactVersion.getLabel();
                if (string.equals("*")) {
                    this.modGraph.addEdge(modContainer, this.afterAll);
                    this.modGraph.addEdge(this.after, modContainer);
                    bl2 = true;
                    continue;
                }
                this.modGraph.addEdge(this.before, modContainer);
                if (!map.containsKey(string) && !Loader.isModLoaded(string)) continue;
                this.modGraph.addEdge(map.get(string), modContainer);
            }
            for (ArtifactVersion artifactVersion : modContainer.getDependants()) {
                bl2 = true;
                string = artifactVersion.getLabel();
                if (string.equals("*")) {
                    this.modGraph.addEdge(this.beforeAll, modContainer);
                    this.modGraph.addEdge(modContainer, this.before);
                    bl = true;
                    continue;
                }
                this.modGraph.addEdge(modContainer, this.after);
                if (!Loader.isModLoaded(string)) continue;
                this.modGraph.addEdge(modContainer, map.get(string));
            }
            if (!bl) {
                this.modGraph.addEdge(this.before, modContainer);
            }
            if (bl2) continue;
            this.modGraph.addEdge(modContainer, this.after);
        }
    }

    public List<ModContainer> sort() {
        List<ModContainer> list2 = TopologicalSort.topologicalSort(this.modGraph);
        list2.removeAll(Arrays.asList(this.beforeAll, this.before, this.after, this.afterAll));
        return list2;
    }
}

