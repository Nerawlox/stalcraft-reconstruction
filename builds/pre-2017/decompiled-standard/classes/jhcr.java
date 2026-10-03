/*
 * Decompiled with CFR 0.152.
 */
public class jhcr {
    public wnhj _a;
    public float _b;
    public float _c;
    public float _d = 0.7f;
    public float _e = 0.7f;
    public float _f;
    private int _k;
    public boolean _g;
    public float _h = 0.5f;
    public float _i = 0.5f;
    public float _j = 1.0f;

    public jhcr(wnhj wnhj2) {
        this._f = wnhj2.field_70331_k.field_73012_v.nextFloat() * 360.0f;
    }

    public void _a() {
        ++this._k;
        this._c = this._b;
        this._e = this._d;
        if (this._b < 3.0f) {
            this._b += 0.5f;
        }
        if (this._k > 5) {
            this._d -= 0.1f;
            this._h *= 0.9f;
            this._j *= 0.9f;
        }
        if (this._d <= 0.0f) {
            this._g = true;
        }
    }
}

