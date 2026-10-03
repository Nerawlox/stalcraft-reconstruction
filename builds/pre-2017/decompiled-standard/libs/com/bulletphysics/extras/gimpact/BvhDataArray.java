/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.extras.gimpact;

import com.bulletphysics.extras.gimpact.BoxCollision;
import javax.vecmath.Vector3f;

class BvhDataArray {
    private int size = 0;
    float[] bound = new float[0];
    int[] data = new int[0];

    BvhDataArray() {
    }

    public int size() {
        return this.size;
    }

    public void resize(int newSize) {
        float[] newBound = new float[newSize * 6];
        int[] newData = new int[newSize];
        System.arraycopy(this.bound, 0, newBound, 0, this.size * 6);
        System.arraycopy(this.data, 0, newData, 0, this.size);
        this.bound = newBound;
        this.data = newData;
        this.size = newSize;
    }

    public void swap(int idx1, int idx2) {
        int pos1 = idx1 * 6;
        int pos2 = idx2 * 6;
        float b0 = this.bound[pos1 + 0];
        float b1 = this.bound[pos1 + 1];
        float b2 = this.bound[pos1 + 2];
        float b3 = this.bound[pos1 + 3];
        float b4 = this.bound[pos1 + 4];
        float b5 = this.bound[pos1 + 5];
        int d = this.data[idx1];
        this.bound[pos1 + 0] = this.bound[pos2 + 0];
        this.bound[pos1 + 1] = this.bound[pos2 + 1];
        this.bound[pos1 + 2] = this.bound[pos2 + 2];
        this.bound[pos1 + 3] = this.bound[pos2 + 3];
        this.bound[pos1 + 4] = this.bound[pos2 + 4];
        this.bound[pos1 + 5] = this.bound[pos2 + 5];
        this.data[idx1] = this.data[idx2];
        this.bound[pos2 + 0] = b0;
        this.bound[pos2 + 1] = b1;
        this.bound[pos2 + 2] = b2;
        this.bound[pos2 + 3] = b3;
        this.bound[pos2 + 4] = b4;
        this.bound[pos2 + 5] = b5;
        this.data[idx2] = d;
    }

    public BoxCollision.AABB getBound(int idx, BoxCollision.AABB out) {
        int pos = idx * 6;
        out.min.set(this.bound[pos + 0], this.bound[pos + 1], this.bound[pos + 2]);
        out.max.set(this.bound[pos + 3], this.bound[pos + 4], this.bound[pos + 5]);
        return out;
    }

    public Vector3f getBoundMin(int idx, Vector3f out) {
        int pos = idx * 6;
        out.set(this.bound[pos + 0], this.bound[pos + 1], this.bound[pos + 2]);
        return out;
    }

    public Vector3f getBoundMax(int idx, Vector3f out) {
        int pos = idx * 6;
        out.set(this.bound[pos + 3], this.bound[pos + 4], this.bound[pos + 5]);
        return out;
    }

    public void setBound(int idx, BoxCollision.AABB aabb) {
        int pos = idx * 6;
        this.bound[pos + 0] = aabb.min.x;
        this.bound[pos + 1] = aabb.min.y;
        this.bound[pos + 2] = aabb.min.z;
        this.bound[pos + 3] = aabb.max.x;
        this.bound[pos + 4] = aabb.max.y;
        this.bound[pos + 5] = aabb.max.z;
    }

    public int getData(int idx) {
        return this.data[idx];
    }

    public void setData(int idx, int value) {
        this.data[idx] = value;
    }
}

