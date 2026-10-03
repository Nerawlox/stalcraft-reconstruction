/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block.material;

public class MapColor {
    public static final MapColor[] _a = new MapColor[16];
    public static final MapColor _b = new MapColor(0, 0);
    public static final MapColor _c = new MapColor(1, 8368696);
    public static final MapColor _d = new MapColor(2, 16247203);
    public static final MapColor _e = new MapColor(3, 0xA7A7A7);
    public static final MapColor _f = new MapColor(4, 0xFF0000);
    public static final MapColor _g = new MapColor(5, 0xA0A0FF);
    public static final MapColor _h = new MapColor(6, 0xA7A7A7);
    public static final MapColor _i = new MapColor(7, 31744);
    public static final MapColor _j = new MapColor(8, 0xFFFFFF);
    public static final MapColor _k = new MapColor(9, 10791096);
    public static final MapColor _l = new MapColor(10, 12020271);
    public static final MapColor _m = new MapColor(11, 0x707070);
    public static final MapColor _n = new MapColor(12, 0x4040FF);
    public static final MapColor _o = new MapColor(13, 6837042);
    public final int _p;
    public final int _q;

    public MapColor(int n, int n2) {
        this._q = n;
        this._p = n2;
        MapColor._a[n] = this;
    }
}

