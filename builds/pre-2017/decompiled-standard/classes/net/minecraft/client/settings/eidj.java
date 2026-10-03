/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.settings;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.util.amxi;
import znw.mods.stalkerguide.pidb;

public class eidj {
    public static List _a = new ArrayList();
    public static amxi _b = new amxi();
    public String _c;
    public int _d;
    public boolean _e;
    public int _f;

    public static void _a(int n) {
        eidj eidj2 = (eidj)_b._b(n);
        if (eidj2 != null) {
            ++eidj2._f;
        }
    }

    public static void _a(int n, boolean bl) {
        eidj eidj2 = (eidj)_b._b(n);
        if (eidj2 != null) {
            eidj2._e = bl;
        }
        pidb._a(null, n, bl);
    }

    public static void _a() {
        for (eidj eidj2 : _a) {
            eidj2._d();
        }
    }

    public static void _b() {
        _b._a();
        for (eidj eidj2 : _a) {
            _b._a(eidj2._d, eidj2);
        }
    }

    public eidj(String string, int n) {
        this._c = string;
        this._d = n;
        _a.add(this);
        _b._a(n, this);
    }

    public boolean _c() {
        if (this._f == 0) {
            return false;
        }
        --this._f;
        return true;
    }

    public void _d() {
        this._f = 0;
        this._e = false;
    }
}

