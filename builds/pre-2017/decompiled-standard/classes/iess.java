/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.nio.ByteBuffer;

public abstract class iess {
    public final jhuw _k;
    public final String _l;
    public final String _m;
    public final int _n;
    public final int _o;
    public final int _p;
    public final int _q;
    public final boolean _r;
    public final int _s;
    public short[] _t;
    protected float _u;

    public iess(jhuw jhuw2, String string, String string2, int n, short[] sArray, int n2, int n3, float f) {
        this._k = jhuw2;
        this._l = string;
        this._m = string2;
        this._s = n;
        this._o = sArray == null ? 0 : sArray.length;
        this._t = sArray;
        this._n = n2;
        this._p = n3;
        this._q = n3 * 3;
        this._r = jhuw2.animated && n > 0 && this._o > 0;
        this._u = f;
    }

    protected abstract void _a(ByteBuffer var1, hbom var2) throws IOException;

    protected void _d() {
    }

    public boolean _e() {
        return this._q > 65535;
    }

    public int _f() {
        if (this._k.fileVersion == 6.0f) {
            return 6 + (this._k.hasUvs() ? 4 : 0) + (this._k.hasNormals() ? 3 : 0) + (this._k.hasTangents() ? 6 : 0) + (this._r ? this._s * 2 - 1 : 0);
        }
        return 8 + (this._k.hasUvs() ? 4 : 0) + (this._k.hasNormals() ? 4 : 0) + (this._k.hasTangents() ? 4 : 0) + (this._s > 0 ? 4 : 0) + (this._s >= 3 ? 4 : 0);
    }

    public float _g() {
        return this._u;
    }
}

