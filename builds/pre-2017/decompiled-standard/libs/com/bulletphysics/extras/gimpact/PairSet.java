/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.extras.gimpact;

import com.bulletphysics.extras.gimpact.Pair;

class PairSet {
    private Pair[] array = new Pair[32];
    private int size = 0;

    public PairSet() {
        for (int i = 0; i < this.array.length; ++i) {
            this.array[i] = new Pair();
        }
    }

    public void clear() {
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public Pair get(int index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        return this.array[index];
    }

    private void expand() {
        Pair[] newArray = new Pair[this.array.length << 1];
        for (int i = this.array.length; i < newArray.length; ++i) {
            newArray[i] = new Pair();
        }
        System.arraycopy(this.array, 0, newArray, 0, this.array.length);
        this.array = newArray;
    }

    public void push_pair(int index1, int index2) {
        if (this.size == this.array.length) {
            this.expand();
        }
        this.array[this.size].index1 = index1;
        this.array[this.size].index2 = index2;
        ++this.size;
    }

    public void push_pair_inv(int index1, int index2) {
        if (this.size == this.array.length) {
            this.expand();
        }
        this.array[this.size].index1 = index2;
        this.array[this.size].index2 = index1;
        ++this.size;
    }
}

