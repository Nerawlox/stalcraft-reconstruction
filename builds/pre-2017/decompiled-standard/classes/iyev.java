/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Map;
import net.minecraft.crash.jxsn;

public class iyev {
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
    public qoac _l;
    public int _m;
    public String _n;
    public int _o;
    public boolean _p;
    public int _q;
    public boolean _r;
    public int _s;
    public xtby _t;
    public boolean _u;
    public boolean _v;
    public boolean _w;
    public boolean _x;
    public mcam _y = new mcam();
    public Map<String, huhy> _z;

    public iyev() {
    }

    public iyev(qoac qoac2) {
        this._b = qoac2._g("RandomSeed");
        if (qoac2._c("generatorName")) {
            String string = qoac2._j("generatorName");
            this._c = nwix._a(string);
            if (this._c == null) {
                this._c = nwix._d;
            } else if (this._c._f()) {
                int n = 0;
                if (qoac2._c("generatorVersion")) {
                    n = qoac2._f("generatorVersion");
                }
                this._c = this._c._a(n);
            }
            if (qoac2._c("generatorOptions")) {
                this._d = qoac2._j("generatorOptions");
            }
        }
        this._t = xtby._a(qoac2._f("GameType"));
        this._u = qoac2._c("MapFeatures") ? qoac2._o("MapFeatures") : true;
        this._e = qoac2._f("SpawnX");
        this._f = qoac2._f("SpawnY");
        this._g = qoac2._f("SpawnZ");
        this._h = qoac2._g("Time");
        this._i = qoac2._c("DayTime") ? qoac2._g("DayTime") : this._h;
        this._j = qoac2._g("LastPlayed");
        this._k = qoac2._g("SizeOnDisk");
        this._n = qoac2._j("LevelName");
        this._o = qoac2._f("version");
        this._q = qoac2._f("rainTime");
        this._p = qoac2._o("raining");
        this._s = qoac2._f("thunderTime");
        this._r = qoac2._o("thundering");
        this._v = qoac2._o("hardcore");
        this._x = qoac2._c("initialized") ? qoac2._o("initialized") : true;
        if (qoac2._c("allowCommands")) {
            this._w = qoac2._o("allowCommands");
        } else {
            boolean bl = this._w = this._t == xtby._c;
        }
        if (qoac2._c("Player")) {
            this._l = qoac2._m("Player");
            this._m = this._l._f("Dimension");
        }
        if (qoac2._c("GameRules")) {
            this._y._a(qoac2._m("GameRules"));
        }
    }

    public iyev(nfhj nfhj2, String string) {
        this._b = nfhj2._d();
        this._t = nfhj2._e();
        this._u = nfhj2._g();
        this._n = string;
        this._v = nfhj2._f();
        this._c = nfhj2._h();
        this._d = nfhj2._j();
        this._w = nfhj2._i();
        this._x = false;
    }

    public iyev(iyev iyev2) {
        this._b = iyev2._b;
        this._c = iyev2._c;
        this._d = iyev2._d;
        this._t = iyev2._t;
        this._u = iyev2._u;
        this._e = iyev2._e;
        this._f = iyev2._f;
        this._g = iyev2._g;
        this._h = iyev2._h;
        this._i = iyev2._i;
        this._j = iyev2._j;
        this._k = iyev2._k;
        this._l = iyev2._l;
        this._m = iyev2._m;
        this._n = iyev2._n;
        this._o = iyev2._o;
        this._q = iyev2._q;
        this._p = iyev2._p;
        this._s = iyev2._s;
        this._r = iyev2._r;
        this._v = iyev2._v;
        this._w = iyev2._w;
        this._x = iyev2._x;
        this._y = iyev2._y;
    }

    public qoac _a() {
        qoac qoac2 = new qoac();
        this._a(qoac2, this._l);
        return qoac2;
    }

    public qoac _a(qoac qoac2) {
        qoac qoac3 = new qoac();
        this._a(qoac3, qoac2);
        return qoac3;
    }

    public void _a(qoac qoac2, qoac qoac3) {
        qoac2._a("RandomSeed", this._b);
        qoac2._a("generatorName", this._c._a());
        qoac2._a("generatorVersion", this._c._c());
        qoac2._a("generatorOptions", this._d);
        qoac2._a("GameType", this._t._a());
        qoac2._a("MapFeatures", this._u);
        qoac2._a("SpawnX", this._e);
        qoac2._a("SpawnY", this._f);
        qoac2._a("SpawnZ", this._g);
        qoac2._a("Time", this._h);
        qoac2._a("DayTime", this._i);
        qoac2._a("SizeOnDisk", this._k);
        qoac2._a("LastPlayed", dzfd.__aq());
        qoac2._a("LevelName", this._n);
        qoac2._a("version", this._o);
        qoac2._a("rainTime", this._q);
        qoac2._a("raining", this._p);
        qoac2._a("thunderTime", this._s);
        qoac2._a("thundering", this._r);
        qoac2._a("hardcore", this._v);
        qoac2._a("allowCommands", this._w);
        qoac2._a("initialized", this._x);
        qoac2._a("GameRules", this._y._a());
        if (qoac3 != null) {
            qoac2._a("Player", qoac3);
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

    public qoac _i() {
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

    public xtby _r() {
        return this._t;
    }

    public boolean _s() {
        return this._u;
    }

    public void _a(xtby xtby2) {
        this._t = xtby2;
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

    public mcam _x() {
        return this._y;
    }

    public void _a(jxsn jxsn2) {
        jxsn2._a("Level seed", new gazc(this));
        jxsn2._a("Level generator", new mckx(this));
        jxsn2._a("Level generator options", new dism(this));
        jxsn2._a("Level spawn location", new bcmf(this));
        jxsn2._a("Level time", new ywoq(this));
        jxsn2._a("Level dimension", new mtna(this));
        jxsn2._a("Level storage version", new xckm(this));
        jxsn2._a("Level weather", new ywor(this));
        jxsn2._a("Level game mode", new foyo(this));
    }

    public static nwix _a(iyev iyev2) {
        return iyev2._c;
    }

    public static boolean _b(iyev iyev2) {
        return iyev2._u;
    }

    public static String _c(iyev iyev2) {
        return iyev2._d;
    }

    public static int _d(iyev iyev2) {
        return iyev2._e;
    }

    public static int _e(iyev iyev2) {
        return iyev2._f;
    }

    public static int _f(iyev iyev2) {
        return iyev2._g;
    }

    public static long _g(iyev iyev2) {
        return iyev2._h;
    }

    public static long _h(iyev iyev2) {
        return iyev2._i;
    }

    public static int _i(iyev iyev2) {
        return iyev2._m;
    }

    public static int _j(iyev iyev2) {
        return iyev2._o;
    }

    public static int _k(iyev iyev2) {
        return iyev2._q;
    }

    public static boolean _l(iyev iyev2) {
        return iyev2._p;
    }

    public static int _m(iyev iyev2) {
        return iyev2._s;
    }

    public static boolean _n(iyev iyev2) {
        return iyev2._r;
    }

    public static xtby _o(iyev iyev2) {
        return iyev2._t;
    }

    public static boolean _p(iyev iyev2) {
        return iyev2._v;
    }

    public static boolean _q(iyev iyev2) {
        return iyev2._w;
    }

    public void _a(Map<String, huhy> map) {
        if (this._z == null) {
            this._z = map;
        }
    }

    public huhy _b(String string) {
        return this._z != null ? this._z.get(string) : null;
    }
}

