/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.storage;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Map;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.GameRules;
import net.minecraft.world.WorldSettings;

public class WorldInfo {
    public long _b;
    public nwix _c = nwix._d;
    public String _d = "";
    public int _e;
    public int _f;
    public int _g;
    public long _h;
    public long _i;
    public long _j;
    public long _k;
    public NBTTagCompound _l;
    public int _m;
    public String _n;
    public int _o;
    public boolean _p;
    public int _q;
    public boolean _r;
    public int _s;
    public EnumGameType _t;
    public boolean _u;
    public boolean _v;
    public boolean _w;
    public boolean _x;
    public GameRules _y = new GameRules();
    public Map<String, NBTBase> _z;

    public WorldInfo() {
    }

    public WorldInfo(NBTTagCompound nBTTagCompound) {
        this._b = nBTTagCompound._g("RandomSeed");
        if (nBTTagCompound._c("generatorName")) {
            String string = nBTTagCompound._j("generatorName");
            this._c = nwix._a(string);
            if (this._c == null) {
                this._c = nwix._d;
            } else if (this._c._f()) {
                int n = 0;
                if (nBTTagCompound._c("generatorVersion")) {
                    n = nBTTagCompound._f("generatorVersion");
                }
                this._c = this._c._a(n);
            }
            if (nBTTagCompound._c("generatorOptions")) {
                this._d = nBTTagCompound._j("generatorOptions");
            }
        }
        this._t = EnumGameType._a(nBTTagCompound._f("GameType"));
        this._u = nBTTagCompound._c("MapFeatures") ? nBTTagCompound._o("MapFeatures") : true;
        this._e = nBTTagCompound._f("SpawnX");
        this._f = nBTTagCompound._f("SpawnY");
        this._g = nBTTagCompound._f("SpawnZ");
        this._h = nBTTagCompound._g("Time");
        this._i = nBTTagCompound._c("DayTime") ? nBTTagCompound._g("DayTime") : this._h;
        this._j = nBTTagCompound._g("LastPlayed");
        this._k = nBTTagCompound._g("SizeOnDisk");
        this._n = nBTTagCompound._j("LevelName");
        this._o = nBTTagCompound._f("version");
        this._q = nBTTagCompound._f("rainTime");
        this._p = nBTTagCompound._o("raining");
        this._s = nBTTagCompound._f("thunderTime");
        this._r = nBTTagCompound._o("thundering");
        this._v = nBTTagCompound._o("hardcore");
        this._x = nBTTagCompound._c("initialized") ? nBTTagCompound._o("initialized") : true;
        if (nBTTagCompound._c("allowCommands")) {
            this._w = nBTTagCompound._o("allowCommands");
        } else {
            boolean bl = this._w = this._t == EnumGameType._c;
        }
        if (nBTTagCompound._c("Player")) {
            this._l = nBTTagCompound._m("Player");
            this._m = this._l._f("Dimension");
        }
        if (nBTTagCompound._c("GameRules")) {
            this._y._a(nBTTagCompound._m("GameRules"));
        }
    }

    public WorldInfo(WorldSettings worldSettings, String string) {
        this._b = worldSettings._d();
        this._t = worldSettings._e();
        this._u = worldSettings._g();
        this._n = string;
        this._v = worldSettings._f();
        this._c = worldSettings._h();
        this._d = worldSettings._j();
        this._w = worldSettings._i();
        this._x = false;
    }

    public WorldInfo(WorldInfo worldInfo) {
        this._b = worldInfo._b;
        this._c = worldInfo._c;
        this._d = worldInfo._d;
        this._t = worldInfo._t;
        this._u = worldInfo._u;
        this._e = worldInfo._e;
        this._f = worldInfo._f;
        this._g = worldInfo._g;
        this._h = worldInfo._h;
        this._i = worldInfo._i;
        this._j = worldInfo._j;
        this._k = worldInfo._k;
        this._l = worldInfo._l;
        this._m = worldInfo._m;
        this._n = worldInfo._n;
        this._o = worldInfo._o;
        this._q = worldInfo._q;
        this._p = worldInfo._p;
        this._s = worldInfo._s;
        this._r = worldInfo._r;
        this._v = worldInfo._v;
        this._w = worldInfo._w;
        this._x = worldInfo._x;
        this._y = worldInfo._y;
    }

    public NBTTagCompound _a() {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        this._a(nBTTagCompound, this._l);
        return nBTTagCompound;
    }

    public NBTTagCompound _a(NBTTagCompound nBTTagCompound) {
        NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
        this._a(nBTTagCompound2, nBTTagCompound);
        return nBTTagCompound2;
    }

    public void _a(NBTTagCompound nBTTagCompound, NBTTagCompound nBTTagCompound2) {
        nBTTagCompound._a("RandomSeed", this._b);
        nBTTagCompound._a("generatorName", this._c._a());
        nBTTagCompound._a("generatorVersion", this._c._c());
        nBTTagCompound._a("generatorOptions", this._d);
        nBTTagCompound._a("GameType", this._t._a());
        nBTTagCompound._a("MapFeatures", this._u);
        nBTTagCompound._a("SpawnX", this._e);
        nBTTagCompound._a("SpawnY", this._f);
        nBTTagCompound._a("SpawnZ", this._g);
        nBTTagCompound._a("Time", this._h);
        nBTTagCompound._a("DayTime", this._i);
        nBTTagCompound._a("SizeOnDisk", this._k);
        nBTTagCompound._a("LastPlayed", MinecraftServer.__aq());
        nBTTagCompound._a("LevelName", this._n);
        nBTTagCompound._a("version", this._o);
        nBTTagCompound._a("rainTime", this._q);
        nBTTagCompound._a("raining", this._p);
        nBTTagCompound._a("thunderTime", this._s);
        nBTTagCompound._a("thundering", this._r);
        nBTTagCompound._a("hardcore", this._v);
        nBTTagCompound._a("allowCommands", this._w);
        nBTTagCompound._a("initialized", this._x);
        nBTTagCompound._a("GameRules", this._y._a());
        if (nBTTagCompound2 != null) {
            nBTTagCompound._a("Player", nBTTagCompound2);
        }
    }

    public long _b() {
        return this._b;
    }

    public int _c() {
        return this._e;
    }

    public int _d() {
        return this._f;
    }

    public int _e() {
        return this._g;
    }

    public long _f() {
        return this._h;
    }

    public long _g() {
        return this._i;
    }

    @SideOnly(value=Side.CLIENT)
    public long _h() {
        return this._k;
    }

    public NBTTagCompound _i() {
        return this._l;
    }

    public int _j() {
        return this._m;
    }

    @SideOnly(value=Side.CLIENT)
    public void _a(int n) {
        this._e = n;
    }

    @SideOnly(value=Side.CLIENT)
    public void _b(int n) {
        this._f = n;
    }

    public void _a(long l) {
        this._h = l;
    }

    @SideOnly(value=Side.CLIENT)
    public void _c(int n) {
        this._g = n;
    }

    public void _b(long l) {
        this._i = l;
    }

    public void _a(int n, int n2, int n3) {
        this._e = n;
        this._f = n2;
        this._g = n3;
    }

    public String _k() {
        return this._n;
    }

    public void _a(String string) {
        this._n = string;
    }

    public int _l() {
        return this._o;
    }

    public void _d(int n) {
        this._o = n;
    }

    @SideOnly(value=Side.CLIENT)
    public long _m() {
        return this._j;
    }

    public boolean _n() {
        return this._r;
    }

    public void _a(boolean bl) {
        this._r = bl;
    }

    public int _o() {
        return this._s;
    }

    public void _e(int n) {
        this._s = n;
    }

    public boolean _p() {
        return this._p;
    }

    public void _b(boolean bl) {
        this._p = bl;
    }

    public int _q() {
        return this._q;
    }

    public void _f(int n) {
        this._q = n;
    }

    public EnumGameType _r() {
        return this._t;
    }

    public boolean _s() {
        return this._u;
    }

    public void _a(EnumGameType enumGameType) {
        this._t = enumGameType;
    }

    public boolean _t() {
        return this._v;
    }

    public nwix _u() {
        return this._c;
    }

    public void _a(nwix nwix2) {
        this._c = nwix2;
    }

    public String _y() {
        return this._d;
    }

    public boolean _v() {
        return this._w;
    }

    public boolean _w() {
        return this._x;
    }

    public void _c(boolean bl) {
        this._x = bl;
    }

    public GameRules _x() {
        return this._y;
    }

    public void _a(CrashReportCategory crashReportCategory) {
        crashReportCategory._a("Level seed", new gazc(this));
        crashReportCategory._a("Level generator", new mckx(this));
        crashReportCategory._a("Level generator options", new dism(this));
        crashReportCategory._a("Level spawn location", new bcmf(this));
        crashReportCategory._a("Level time", new ywoq(this));
        crashReportCategory._a("Level dimension", new mtna(this));
        crashReportCategory._a("Level storage version", new xckm(this));
        crashReportCategory._a("Level weather", new ywor(this));
        crashReportCategory._a("Level game mode", new foyo(this));
    }

    public static nwix _a(WorldInfo worldInfo) {
        return worldInfo._c;
    }

    public static boolean _b(WorldInfo worldInfo) {
        return worldInfo._u;
    }

    public static String _c(WorldInfo worldInfo) {
        return worldInfo._d;
    }

    public static int _d(WorldInfo worldInfo) {
        return worldInfo._e;
    }

    public static int _e(WorldInfo worldInfo) {
        return worldInfo._f;
    }

    public static int _f(WorldInfo worldInfo) {
        return worldInfo._g;
    }

    public static long _g(WorldInfo worldInfo) {
        return worldInfo._h;
    }

    public static long _h(WorldInfo worldInfo) {
        return worldInfo._i;
    }

    public static int _i(WorldInfo worldInfo) {
        return worldInfo._m;
    }

    public static int _j(WorldInfo worldInfo) {
        return worldInfo._o;
    }

    public static int _k(WorldInfo worldInfo) {
        return worldInfo._q;
    }

    public static boolean _l(WorldInfo worldInfo) {
        return worldInfo._p;
    }

    public static int _m(WorldInfo worldInfo) {
        return worldInfo._s;
    }

    public static boolean _n(WorldInfo worldInfo) {
        return worldInfo._r;
    }

    public static EnumGameType _o(WorldInfo worldInfo) {
        return worldInfo._t;
    }

    public static boolean _p(WorldInfo worldInfo) {
        return worldInfo._v;
    }

    public static boolean _q(WorldInfo worldInfo) {
        return worldInfo._w;
    }

    public void _a(Map<String, NBTBase> map) {
        if (this._z == null) {
            this._z = map;
        }
    }

    public NBTBase _b(String string) {
        return this._z != null ? this._z.get(string) : null;
    }
}

