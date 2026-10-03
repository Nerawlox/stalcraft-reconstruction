/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world;

import net.minecraft.entity.player.PlayerCapabilities;

public enum EnumGameType {
    _a(-1, ""),
    _b(0, "survival"),
    _c(1, "creative"),
    _d(2, "adventure");

    public int _e;
    public String _f;

    /*
     * WARNING - void declaration
     */
    public EnumGameType() {
        void var4_2;
        void var3_1;
        this._e = var3_1;
        this._f = var4_2;
    }

    public int _a() {
        return this._e;
    }

    public String _b() {
        return this._f;
    }

    public void _a(PlayerCapabilities playerCapabilities) {
        if (this == _c) {
            playerCapabilities._c = true;
            playerCapabilities._d = true;
            playerCapabilities._a = true;
        } else {
            playerCapabilities._c = false;
            playerCapabilities._d = false;
            playerCapabilities._a = false;
            playerCapabilities._b = false;
        }
        playerCapabilities._e = !this._c();
    }

    public boolean _c() {
        return this == _d;
    }

    public boolean _d() {
        return this == _c;
    }

    public boolean _e() {
        return this == _b || this == _d;
    }

    public static EnumGameType _a(int n) {
        for (EnumGameType enumGameType : EnumGameType.values()) {
            if (enumGameType._e != n) continue;
            return enumGameType;
        }
        return _b;
    }

    public static EnumGameType _a(String string) {
        for (EnumGameType enumGameType : EnumGameType.values()) {
            if (!enumGameType._f.equals(string)) continue;
            return enumGameType;
        }
        return _b;
    }
}

