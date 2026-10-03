/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.extras.gimpact;

class Pair {
    public int index1;
    public int index2;

    public Pair() {
    }

    public Pair(int index1, int index2) {
        this.index1 = index1;
        this.index2 = index2;
    }

    public Pair(Pair p) {
        this.index1 = p.index1;
        this.index2 = p.index2;
    }
}

