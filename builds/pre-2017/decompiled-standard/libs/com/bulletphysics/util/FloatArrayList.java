/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.util;

public class FloatArrayList {
    private float[] array = new float[16];
    private int size;

    public void add(float value) {
        if (this.size == this.array.length) {
            this.expand();
        }
        this.array[this.size++] = value;
    }

    private void expand() {
        float[] newArray = new float[this.array.length << 1];
        System.arraycopy(this.array, 0, newArray, 0, this.array.length);
        this.array = newArray;
    }

    public float remove(int index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        float old = this.array[index];
        System.arraycopy(this.array, index + 1, this.array, index, this.size - index - 1);
        --this.size;
        return old;
    }

    public float get(int index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        return this.array[index];
    }

    public void set(int index, float value) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        this.array[index] = value;
    }

    public int size() {
        return this.size;
    }
}

