/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

public class amxi {
    public final int _a;
    public final int _b;
    public Object _c;
    public boolean _d;

    public amxi(int n, int n2, Object object) {
        this._b = n2;
        this._c = object;
        this._a = n;
        this._d = true;
    }

    public int _a() {
        return this._b;
    }

    public void _a(Object object) {
        this._c = object;
    }

    public Object _b() {
        return this._c;
    }

    public int _c() {
        return this._a;
    }

    public boolean _d() {
        return this._d;
    }

    public void _a(boolean bl) {
        this._d = bl;
    }

    public static /* synthetic */ boolean _a(amxi amxi2, boolean bl) {
        amxi2._d = bl;
        return amxi2._d;
    }
}

