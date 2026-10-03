/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.misc;

import java.util.Objects;

public class zwaw {
    private final int _a;
    private final int _b;
    private float _c;
    private float _d;
    private float _e;
    private float _f;
    private long _g;
    private long _h;
    private boolean _i;

    public zwaw(int n, int n2, float f, float f2, long l, boolean bl) {
        this._a = n;
        this._b = n2;
        this._e = this._c = f;
        this._f = this._d = f2;
        this._g = l;
        this._i = bl;
        this._h = this._g;
    }

    public int _a() {
        return this._b;
    }

    public void _a(float f) {
        this._e = this._c;
        this._c = f;
    }

    public void _b(float f) {
        this._f = this._d;
        this._d = f;
    }

    public int _b() {
        return this._a;
    }

    public float _c() {
        return this._c;
    }

    public float _d() {
        return this._d;
    }

    public float _e() {
        return this._e;
    }

    public float _f() {
        return this._f;
    }

    public long _g() {
        return this._g;
    }

    public void _a(long l) {
        this._g = l;
    }

    public long _h() {
        return this._h;
    }

    public boolean _i() {
        return this._i;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        zwaw zwaw2 = (zwaw)object;
        return this._a == zwaw2._a && Float.compare(zwaw2._c, this._c) == 0 && Float.compare(zwaw2._d, this._d) == 0 && this._g == zwaw2._g;
    }

    public int hashCode() {
        return Objects.hash(this._a, Float.valueOf(this._c), Float.valueOf(this._d), this._g);
    }
}

