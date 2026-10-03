/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world;

import net.minecraft.world.EnumGameType;
import net.minecraft.world.storage.WorldInfo;

public final class WorldSettings {
    public final long _a;
    public final EnumGameType _b;
    public final boolean _c;
    public final boolean _d;
    public final nwix _e;
    public boolean _f;
    public boolean _g;
    public String _h = "";

    public WorldSettings(long l, EnumGameType enumGameType, boolean bl, boolean bl2, nwix nwix2) {
        this._a = l;
        this._b = enumGameType;
        this._c = bl;
        this._d = bl2;
        this._e = nwix2;
    }

    public WorldSettings(WorldInfo worldInfo) {
        this(worldInfo._b(), worldInfo._r(), worldInfo._s(), worldInfo._t(), worldInfo._u());
    }

    public WorldSettings _a() {
        this._g = true;
        return this;
    }

    public WorldSettings _b() {
        this._f = true;
        return this;
    }

    public WorldSettings _a(String string) {
        this._h = string;
        return this;
    }

    public boolean _c() {
        return this._g;
    }

    public long _d() {
        return this._a;
    }

    public EnumGameType _e() {
        return this._b;
    }

    public boolean _f() {
        return this._d;
    }

    public boolean _g() {
        return this._c;
    }

    public nwix _h() {
        return this._e;
    }

    public boolean _i() {
        return this._f;
    }

    public static EnumGameType _a(int n) {
        return EnumGameType._a(n);
    }

    public String _j() {
        return this._h;
    }
}

