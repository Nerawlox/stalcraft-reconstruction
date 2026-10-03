/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

public class gomc {
    private final hurg _a;
    private int _b;
    private int _c;
    private int _d;

    public gomc(hurg hurg2) {
        this._a = hurg2;
    }

    public void _a() {
        if (!this._a.field_70331_k.field_72995_K && this._b()) {
            this._a.field_70331_k.func_94571_i(this._a.field_70329_l, this._a.field_70330_m, this._a.field_70327_n);
        }
    }

    public void _a(int n, int n2, int n3) {
        this._b = n;
        this._c = n2;
        this._d = n3;
    }

    public boolean _b() {
        return this._b != this._a.field_70329_l || this._c != this._a.field_70330_m || this._d != this._a.field_70327_n;
    }

    public void _a(qoac qoac2) {
        this._b = qoac2._f("placedAtX");
        this._c = qoac2._f("placedAtY");
        this._d = qoac2._f("placedAtZ");
    }

    public void _b(qoac qoac2) {
        qoac2._a("placedAtX", this._b);
        qoac2._a("placedAtY", this._c);
        qoac2._a("placedAtZ", this._d);
    }
}

