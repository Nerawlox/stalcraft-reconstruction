/*
 * Decompiled with CFR 0.152.
 */
package mods.sound.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import mods.sound.config.SoundSource;

public class SoundGraph {
    public Map<SoundSource, SourceNode> nodes = new HashMap<SoundSource, SourceNode>();

    public SoundGraph(Collection<SoundSource> collection) {
        this.setSources(collection);
    }

    public void setSources(Collection<SoundSource> collection) {
        this.nodes.clear();
        for (SoundSource soundSource2 : collection) {
            SourceNode sourceNode = this.nodes.computeIfAbsent(soundSource2, soundSource -> new SourceNode((SoundSource)soundSource));
            for (SoundSource soundSource3 : collection) {
                if (soundSource2 == soundSource3) continue;
                SourceNode sourceNode2 = this.nodes.computeIfAbsent(soundSource3, soundSource -> new SourceNode((SoundSource)soundSource));
                if (!this.intersects(sourceNode.source, sourceNode2.source)) continue;
                sourceNode.add(sourceNode2);
                sourceNode2.add(sourceNode);
            }
        }
    }

    public List<Set<SoundSource>> getConnectedComponents() {
        HashSet<SourceNode> hashSet = new HashSet<SourceNode>(this.nodes.values());
        ArrayList<Set<SoundSource>> arrayList = new ArrayList<Set<SoundSource>>();
        while (!hashSet.isEmpty()) {
            HashSet hashSet2 = new HashSet();
            SourceNode sourceNode2 = (SourceNode)hashSet.iterator().next();
            LinkedList<SourceNode> linkedList = new LinkedList<SourceNode>();
            linkedList.add(sourceNode2);
            hashSet2.add(sourceNode2);
            sourceNode2.visited = true;
            while (!linkedList.isEmpty()) {
                SourceNode sourceNode3;
                SourceNode sourceNode4 = (SourceNode)linkedList.remove();
                while ((sourceNode3 = sourceNode4.getNextUnvisited()) != null) {
                    sourceNode3.visited = true;
                    hashSet2.add(sourceNode3);
                    linkedList.add(sourceNode3);
                }
            }
            hashSet.removeAll(hashSet2);
            arrayList.add(hashSet2.stream().map(sourceNode -> sourceNode.source).collect(Collectors.toSet()));
        }
        for (SourceNode sourceNode2 : this.nodes.values()) {
            sourceNode2.visited = false;
        }
        return arrayList;
    }

    private boolean intersects(SoundSource soundSource, SoundSource soundSource2) {
        float f = soundSource.getRolloff() - soundSource2.getRolloff();
        float f2 = soundSource.getRolloff() + soundSource2.getRolloff();
        float f3 = soundSource.getPos().x - soundSource2.getPos().x;
        float f4 = soundSource.getPos().z - soundSource2.getPos().z;
        float f5 = f3 * f3 + f4 * f4;
        return f * f <= f5 && f5 <= f2 * f2;
    }

    private class SourceNode {
        public SoundSource source;
        public Set<SourceNode> connected = new HashSet<SourceNode>();
        private boolean visited = false;

        private SourceNode(SoundSource soundSource) {
            this.source = soundSource;
        }

        public void add(SourceNode sourceNode) {
            this.connected.add(sourceNode);
        }

        private SourceNode getNextUnvisited() {
            for (SourceNode sourceNode : this.connected) {
                if (sourceNode.visited) continue;
                return sourceNode;
            }
            return null;
        }
    }
}

