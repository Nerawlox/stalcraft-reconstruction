/*
 * Decompiled with CFR 0.152.
 */
public class uhib {
    public float _a;
    public float _b;
    public float _c;
    public float _d = 1.0f;
    public float _e = 0.5f;
    public float _f = 1.5f;
    public boolean _g = false;

    public uhib() {
    }

    public uhib(float f, float f2, float f3, float f4, float f5, float f6) {
        this._a = f;
        this._b = f2;
        this._c = f3;
        this._d = f4;
        this._e = f5;
        this._f = f6;
    }

    public uhib(uhib uhib2) {
        this._a = uhib2._a;
        this._b = uhib2._b;
        this._c = uhib2._c;
        this._d = uhib2._d;
        this._e = uhib2._e;
        this._f = uhib2._f;
        this._g = uhib2._g;
    }

    public void _a(rpaa rpaa2) {
        this._a = rpaa2._j("center_x");
        this._b = rpaa2._j("center_y");
        this._c = rpaa2._j("center_z");
        this._d = rpaa2._a("default_scale", this._d);
        this._e = rpaa2._a("min_scale", this._e);
        this._f = rpaa2._a("max_scale", this._f);
        this._g = rpaa2._a("animate_preview", false);
    }

    public static uhib _b(rpaa rpaa2) {
        uhib uhib2 = new uhib();
        uhib2._a(rpaa2);
        return uhib2;
    }
}

