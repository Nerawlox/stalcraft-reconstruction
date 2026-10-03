/*
 * Decompiled with CFR 0.152.
 */
public class qmkx {
    public float _a;
    public String _b;
    public String _c;
    public int _d = 1000;
    public int _e;

    public void _a(String string, String string2, float f) {
        this._b = string;
        this._c = string2;
        this._a = f;
        this._d = 0;
    }

    public boolean _a() {
        return this._d < 100;
    }

    public void _b() {
        ++this._d;
        this._e = this._d < 91 ? Math.min(9, this._e + 1) : Math.max(0, this._e - 1);
    }
}

