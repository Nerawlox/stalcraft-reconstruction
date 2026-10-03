/*
 * Decompiled with CFR 0.152.
 */
public class dxwf {
    public final boolean _a;
    public final float _b;
    public final float _c;
    public final int _d;

    public dxwf(boolean bl, float f, float f2, int n) {
        this._a = bl;
        this._b = f;
        this._c = f2;
        this._d = n;
    }

    public dxwf(rpaa rpaa2) {
        this(rpaa2._i("mute"), rpaa2._j("muzzle_flash_offset"), rpaa2._a("muzzle_flash_size_factor", 1.0f), rpaa2._a("muzzle_flash_type", -1));
    }

    public int _a(wolf wolf2) {
        if (this._d < 0) {
            return wolf2.__af._n;
        }
        return this._d;
    }
}

