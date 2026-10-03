/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.toposort;

import com.google.common.collect.Sets;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.toposort.ModSortingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class TopologicalSort {
    public static <T> List<T> topologicalSort(DirectedGraph<T> directedGraph) {
        DirectedGraph<T> directedGraph2 = TopologicalSort.reverse(directedGraph);
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (T t : directedGraph2) {
            TopologicalSort.explore(t, directedGraph2, arrayList, hashSet, hashSet2);
        }
        return arrayList;
    }

    public static <T> DirectedGraph<T> reverse(DirectedGraph<T> directedGraph) {
        DirectedGraph<T> directedGraph2 = new DirectedGraph<T>();
        for (T t : directedGraph) {
            directedGraph2.addNode(t);
        }
        for (T t : directedGraph) {
            for (T t2 : directedGraph.edgesFrom(t)) {
                directedGraph2.addEdge(t2, t);
            }
        }
        return directedGraph2;
    }

    public static <T> void explore(T t, DirectedGraph<T> directedGraph, List<T> list, Set<T> set, Set<T> set2) {
        if (set.contains(t)) {
            if (set2.contains(t)) {
                return;
            }
            FMLLog.severe("Mod Sorting failed.", new Object[0]);
            FMLLog.severe("Visting node %s", t);
            FMLLog.severe("Current sorted list : %s", list);
            FMLLog.severe("Visited set for this node : %s", set);
            FMLLog.severe("Explored node set : %s", set2);
            Sets.SetView<T> setView = Sets.difference(set, set2);
            FMLLog.severe("Likely cycle is in : %s", setView);
            throw new ModSortingException("There was a cycle detected in the input graph, sorting is not possible", t, setView);
        }
        set.add(t);
        for (T t2 : directedGraph.edgesFrom(t)) {
            TopologicalSort.explore(t2, directedGraph, list, set, set2);
        }
        list.add(t);
        set2.add(t);
    }

    public static class DirectedGraph<T>
    implements Iterable<T> {
        private final Map<T, SortedSet<T>> graph = new HashMap<T, SortedSet<T>>();
        private List<T> orderedNodes = new ArrayList<T>();

        public boolean addNode(T t) {
            if (this.graph.containsKey(t)) {
                return false;
            }
            this.orderedNodes.add(t);
            this.graph.put(t, new TreeSet(new Comparator<T>(){

                @Override
                public int compare(T t, T t2) {
                    return DirectedGraph.this.orderedNodes.indexOf(t) - DirectedGraph.this.orderedNodes.indexOf(t2);
                }
            }));
            return true;
        }

        public void addEdge(T t, T t2) {
            if (!this.graph.containsKey(t) || !this.graph.containsKey(t2)) {
                throw new NoSuchElementException("Missing nodes from graph");
            }
            this.graph.get(t).add(t2);
        }

        public void removeEdge(T t, T t2) {
            if (!this.graph.containsKey(t) || !this.graph.containsKey(t2)) {
                throw new NoSuchElementException("Missing nodes from graph");
            }
            this.graph.get(t).remove(t2);
        }

        public boolean edgeExists(T t, T t2) {
            if (!this.graph.containsKey(t) || !this.graph.containsKey(t2)) {
                throw new NoSuchElementException("Missing nodes from graph");
            }
            return this.graph.get(t).contains(t2);
        }

        public Set<T> edgesFrom(T t) {
            if (!this.graph.containsKey(t)) {
                throw new NoSuchElementException("Missing node from graph");
            }
            return Collections.unmodifiableSortedSet(this.graph.get(t));
        }

        @Override
        public Iterator<T> iterator() {
            return this.orderedNodes.iterator();
        }

        public int size() {
            return this.graph.size();
        }

        public boolean isEmpty() {
            return this.graph.isEmpty();
        }

        public String toString() {
            return this.graph.toString();
        }
    }
}

