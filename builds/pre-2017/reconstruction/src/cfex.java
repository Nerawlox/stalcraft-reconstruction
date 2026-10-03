/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;

public class cfex
implements Comparable {
    public static long _a;
    public int _b;
    public int _c;
    public int _d;
    public int _e;
    public long _f;
    public int _g;
    public long _h = _a++;

    public cfex(int n, int n2, int n3, int n4) {
        this._b = n;
        this._c = n2;
        this._d = n3;
        this._e = n4;
    }

    public boolean equals(Object object) {
        if (object instanceof cfex) {
            cfex cfex2 = (cfex)object;
            return this._b == cfex2._b && this._c == cfex2._c && this._d == cfex2._d && Block.isAssociatedBlockID(this._e, cfex2._e);
        }
        return false;
    }

    public int hashCode() {
        return (this._b * 1024 * 1024 + this._d * 1024 + this._c) * 256;
    }

    public cfex _a(long l) {
        this._f = l;
        return this;
    }

    public void _a(int n) {
        this._g = n;
    }

    public int _a(cfex cfex2) {
        if (this._f < cfex2._f) {
            return -1;
        }
        if (this._f > cfex2._f) {
            return 1;
        }
        if (this._g != cfex2._g) {
            return this._g - cfex2._g;
        }
        if (this._h < cfex2._h) {
            return -1;
        }
        if (this._h > cfex2._h) {
            return 1;
        }
        return 0;
    }

    public String toString() {
        return this._e + ": (" + this._b + ", " + this._c + ", " + this._d + "), " + this._f + ", " + this._g + ", " + this._h;
    }

    public /* synthetic */ int compareTo(Object object) {
        return this._a((cfex)object);
    }
}

