/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.settings;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.util.IntHashMap;
import znw.mods.stalkerguide.pidb;

public class KeyBinding {
    public static List _a = new ArrayList();
    public static IntHashMap _b = new IntHashMap();
    public String _c;
    public int _d;
    public boolean _e;
    public int _f;

    public static void _a(int n) {
        KeyBinding keyBinding = (KeyBinding)_b._b(n);
        if (keyBinding != null) {
            ++keyBinding._f;
        }
    }

    public static void _a(int n, boolean bl) {
        KeyBinding keyBinding = (KeyBinding)_b._b(n);
        if (keyBinding != null) {
            keyBinding._e = bl;
        }
        pidb._a(null, n, bl);
    }

    public static void _a() {
        for (KeyBinding keyBinding : _a) {
            keyBinding._d();
        }
    }

    public static void _b() {
        _b._a();
        for (KeyBinding keyBinding : _a) {
            _b._a(keyBinding._d, keyBinding);
        }
    }

    public KeyBinding(String string, int n) {
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

