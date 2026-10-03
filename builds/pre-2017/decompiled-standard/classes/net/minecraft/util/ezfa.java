/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

public enum ezfa {
    _a(0, 1, 0, -1, 0),
    _b(1, 0, 0, 1, 0),
    _c(2, 3, 0, 0, -1),
    _d(3, 2, 0, 0, 1),
    _e(4, 5, -1, 0, 0),
    _f(5, 4, 1, 0, 0);

    public final int _g;
    public final int _h;
    public final int _i;
    public final int _j;
    public final int _k;
    public static final ezfa[] _l;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public ezfa(int n3, int n4, int n5) {
        void var7_5;
        void var6_4;
        this._g = n3;
        this._h = n4;
        this._i = n5;
        this._j = var6_4;
        this._k = var7_5;
    }

    public int _a() {
        return this._i;
    }

    public int _b() {
        return this._j;
    }

    public int _c() {
        return this._k;
    }

    public static ezfa _a(int n) {
        return _l[n % _l.length];
    }

    static {
        _l = new ezfa[6];
        ezfa[] ezfaArray = ezfa.values();
        int n = ezfaArray.length;
        for (int i = 0; i < n; ++i) {
            ezfa ezfa2;
            ezfa._l[ezfa2._g] = ezfa2 = ezfaArray[i];
        }
    }
}

