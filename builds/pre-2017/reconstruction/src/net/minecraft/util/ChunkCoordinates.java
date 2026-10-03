/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

public class ChunkCoordinates
implements Comparable {
    public int _a;
    public int _b;
    public int _c;

    public ChunkCoordinates() {
    }

    public ChunkCoordinates(int n, int n2, int n3) {
        this._a = n;
        this._b = n2;
        this._c = n3;
    }

    public ChunkCoordinates(ChunkCoordinates chunkCoordinates) {
        this._a = chunkCoordinates._a;
        this._b = chunkCoordinates._b;
        this._c = chunkCoordinates._c;
    }

    public boolean equals(Object object) {
        if (!(object instanceof ChunkCoordinates)) {
            return false;
        }
        ChunkCoordinates chunkCoordinates = (ChunkCoordinates)object;
        return this._a == chunkCoordinates._a && this._b == chunkCoordinates._b && this._c == chunkCoordinates._c;
    }

    public int hashCode() {
        return this._a + this._c << 8 + this._b << 16;
    }

    public int _a(ChunkCoordinates chunkCoordinates) {
        if (this._b == chunkCoordinates._b) {
            if (this._c == chunkCoordinates._c) {
                return this._a - chunkCoordinates._a;
            }
            return this._c - chunkCoordinates._c;
        }
        return this._b - chunkCoordinates._b;
    }

    public void _a(int n, int n2, int n3) {
        this._a = n;
        this._b = n2;
        this._c = n3;
    }

    public float _b(int n, int n2, int n3) {
        float f = this._a - n;
        float f2 = this._b - n2;
        float f3 = this._c - n3;
        return f * f + f2 * f2 + f3 * f3;
    }

    public float _b(ChunkCoordinates chunkCoordinates) {
        return this._b(chunkCoordinates._a, chunkCoordinates._b, chunkCoordinates._c);
    }

    public /* synthetic */ int compareTo(Object object) {
        return this._a((ChunkCoordinates)object);
    }
}

