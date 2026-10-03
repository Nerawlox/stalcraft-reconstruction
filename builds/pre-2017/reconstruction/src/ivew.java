/*
 * Decompiled with CFR 0.152.
 */
public class ivew {
    private zftb _a;
    private final long _b;
    private boolean _c = false;

    public ivew(zftb zftb2, long l, boolean bl) {
        this._a = zftb2;
        this._b = l;
        this._c = bl;
    }

    public float _a(long l) {
        float f = (float)l / (float)this._b;
        float f2 = this._a._a(f, 0.0f, 1.0f, 1.0f);
        return this._c ? 1.0f - f2 : f2;
    }

    public zftb _a() {
        return this._a;
    }

    public long _b() {
        return this._b;
    }

    public boolean _c() {
        return this._c;
    }
}

