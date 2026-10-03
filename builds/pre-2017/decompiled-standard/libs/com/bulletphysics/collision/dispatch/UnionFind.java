/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.dispatch;

import com.bulletphysics.linearmath.MiscUtil;
import com.bulletphysics.util.ObjectArrayList;
import java.util.Comparator;

public class UnionFind {
    private final ObjectArrayList<Element> elements = new ObjectArrayList();
    private static final Comparator<Element> elementComparator = new Comparator<Element>(){

        @Override
        public int compare(Element o1, Element o2) {
            return o1.id < o2.id ? -1 : 1;
        }
    };

    public void sortIslands() {
        int numElements = this.elements.size();
        for (int i = 0; i < numElements; ++i) {
            this.elements.getQuick((int)i).id = this.find(i);
            this.elements.getQuick((int)i).sz = i;
        }
        MiscUtil.quickSort(this.elements, elementComparator);
    }

    public void reset(int N) {
        this.allocate(N);
        for (int i = 0; i < N; ++i) {
            this.elements.getQuick((int)i).id = i;
            this.elements.getQuick((int)i).sz = 1;
        }
    }

    public int getNumElements() {
        return this.elements.size();
    }

    public boolean isRoot(int x) {
        return x == this.elements.getQuick((int)x).id;
    }

    public Element getElement(int index) {
        return this.elements.getQuick(index);
    }

    public void allocate(int N) {
        MiscUtil.resize(this.elements, N, Element.class);
    }

    public void free() {
        this.elements.clear();
    }

    public int find(int p, int q) {
        return this.find(p) == this.find(q) ? 1 : 0;
    }

    public void unite(int p, int q) {
        int j;
        int i = this.find(p);
        if (i == (j = this.find(q))) {
            return;
        }
        this.elements.getQuick((int)i).id = j;
        this.elements.getQuick((int)j).sz += this.elements.getQuick((int)i).sz;
    }

    public int find(int x) {
        while (x != this.elements.getQuick((int)x).id) {
            x = this.elements.getQuick((int)x).id = this.elements.getQuick((int)this.elements.getQuick((int)x).id).id;
        }
        return x;
    }

    public static class Element {
        public int id;
        public int sz;
    }
}

