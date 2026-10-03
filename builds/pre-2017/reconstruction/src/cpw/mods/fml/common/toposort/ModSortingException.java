/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.toposort;

import java.util.Set;

public class ModSortingException
extends RuntimeException {
    private SortingExceptionData sortingExceptionData;

    public <T> ModSortingException(String string, T t, Set<T> set) {
        super(string);
        this.sortingExceptionData = new SortingExceptionData<T>(t, set);
    }

    public <T> SortingExceptionData<T> getExceptionData() {
        return this.sortingExceptionData;
    }

    public class SortingExceptionData<T> {
        private T firstBadNode;
        private Set<T> visitedNodes;

        public SortingExceptionData(T t, Set<T> set) {
            this.firstBadNode = t;
            this.visitedNodes = set;
        }

        public T getFirstBadNode() {
            return this.firstBadNode;
        }

        public Set<T> getVisitedNodes() {
            return this.visitedNodes;
        }
    }
}

