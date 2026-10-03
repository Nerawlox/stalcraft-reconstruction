/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.net.Proxy;
import java.security.KeyPair;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import net.minecraft.crash.CrashReport;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;
import net.minecraft.util.sajh;
import net.minecraft.util.turb;
import net.minecraft.util.zwat;
import net.minecraft.util.zwaw;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.WorldEvent;

public abstract class dzfd
implements Runnable,
nemo,
ujun {
    public static dzfd _a;
    public final ozsq _b;
    public final cfbu _c = new cfbu("server", this, dzfd.__aq());
    public final File _d;
    public final List _e = new ArrayList();
    public final zyqp _f;
    public final fokl _g = new fokl();
    public String _h;
    public int _i = -1;
    public yfgy[] _j = new yfgy[0];
    public ozhc _k;
    public boolean _l = true;
    public boolean _m;
    public int _n;
    public Proxy _o;
    public String _p;
    public int _q;
    public boolean _r;
    public boolean _s;
    public boolean _t;
    public boolean _u;
    public boolean _v;
    public String _w;
    public int _x;
    public int _y = 0;
    public long _z;
    public long _A;
    public long _B;
    public long _C;
    public final long[] _D;
    public final long[] _E;
    public final long[] _F;
    public final long[] _G;
    public final long[] _H;
    public Hashtable<Integer, long[]> _I = new Hashtable();
    public KeyPair _J;
    public String _K;
    public String _L;
    @SideOnly(value=Side.CLIENT)
    public String _M;
    public boolean _N;
    public boolean _O;
    public boolean _P;
    public String _Q = "";
    public boolean _R;
    public long _S;
    public String _T;
    public boolean _U;
    public boolean _V;

    public dzfd(File file) {
        this._o = Proxy.NO_PROXY;
        this._D = new long[100];
        this._E = new long[100];
        this._F = new long[100];
        this._G = new long[100];
        this._H = new long[100];
        _a = this;
        this._d = file;
        this._f = new jjbh();
        this._b = new mtel(file);
        this._m();
    }

    public void _m() {
        qnxl._a();
    }

    public abstract boolean _n() throws IOException;

    public void _f(String string) {
        if (this._S()._a(string)) {
            this._O()._a("Converting map!");
            this._g("menu.convertingLevel");
            this._S()._a(string, new ywad(this));
        }
    }

    public synchronized void _g(String string) {
        this._T = string;
    }

    @SideOnly(value=Side.CLIENT)
    public synchronized String _o() {
        return this._T;
    }

    public void _a(String string, String string2, long l, nwix nwix2, String string3) {
        nfhj nfhj2;
        this._f(string);
        this._g("menu.loadingLevel");
        mtms mtms2 = this._b._a(string, true);
        iyev iyev2 = mtms2.func_75757_d();
        if (iyev2 == null) {
            nfhj2 = new nfhj(l, this._r(), this._q(), this._t(), nwix2);
            nfhj2._a(string3);
        } else {
            nfhj2 = new nfhj(iyev2);
        }
        if (this._O) {
            nfhj2._a();
        }
        yfgy yfgy2 = this._R() ? new zily(this, mtms2, string2, 0, this._g, this._O()) : new yfgy(this, mtms2, string2, 0, nfhj2, this._g, this._O());
        Integer[] integerArray = DimensionManager.getStaticDimensionIDs();
        int n = integerArray.length;
        for (int i = 0; i < n; ++i) {
            int n2 = integerArray[i];
            yfgy yfgy3 = n2 == 0 ? yfgy2 : new rasa(this, mtms2, string2, n2, nfhj2, yfgy2, this._g, this._O());
            yfgy3.func_72954_a(new foqx(this, yfgy3));
            if (!this._N()) {
                yfgy3.func_72912_H()._a(this._r());
            }
            this._k._a(this._j);
            MinecraftForge.EVENT_BUS.post(new WorldEvent.Load(yfgy3));
        }
        this._k._a(new yfgy[]{yfgy2});
        this._c(this._s());
        this._p();
    }

    public void _p() {
        boolean bl = true;
        boolean bl2 = true;
        boolean bl3 = true;
        boolean bl4 = true;
        int n = 0;
        this._g("menu.generatingTerrain");
        int n2 = 0;
        this._O()._a("Preparing start region for level " + n2);
        yfgy yfgy2 = this._j[n2];
        zwaw zwaw2 = yfgy2.func_72861_E();
        long l = dzfd.__aq();
        for (int i = -192; i <= 192 && this._y(); i += 16) {
            for (int j = -192; j <= 192 && this._y(); j += 16) {
                long l2 = dzfd.__aq();
                if (l2 - l > 1000L) {
                    this._b("Preparing spawn area", n * 100 / 625);
                    l = l2;
                }
                ++n;
                yfgy2.field_73059_b._a(zwaw2._a + i >> 4, zwaw2._c + j >> 4);
            }
        }
        this._v();
    }

    public abstract boolean _q();

    public abstract xtby _r();

    public abstract int _s();

    public abstract boolean _t();

    public abstract int _u();

    public void _b(String string, int n) {
        this._p = string;
        this._q = n;
        this._O()._a(string + ": " + n + "%");
    }

    public void _v() {
        this._p = null;
        this._q = 0;
    }

    public void _a(boolean bl) {
        if (!this._P) {
            yfgy[] yfgyArray = this._j;
            if (yfgyArray == null) {
                return;
            }
            for (yfgy yfgy2 : yfgyArray) {
                if (yfgy2 == null) continue;
                if (!bl) {
                    this._O()._a("Saving chunks for level '" + yfgy2.func_72912_H()._k() + "'/" + yfgy2.field_73011_w._l());
                }
                try {
                    yfgy2.func_73044_a(true, null);
                }
                catch (xcad xcad2) {
                    this._O()._b(xcad2.getMessage());
                }
            }
        }
    }

    public void _w() {
        if (!this._P) {
            yfgy[] yfgyArray;
            this._O()._a("Stopping server");
            if (this.__ah() != null) {
                this.__ah()._a();
            }
            if (this._k != null) {
                this._O()._a("Saving players");
                this._k._n();
                this._k._v();
            }
            this._O()._a("Saving worlds");
            this._a(false);
            for (int i = 0; i < this._j.length; ++i) {
                yfgy[] yfgyArray2 = this._j[i];
                MinecraftForge.EVENT_BUS.post(new WorldEvent.Unload((ozlu)yfgyArray2));
                yfgyArray2.func_73041_k();
            }
            for (yfgy yfgy2 : yfgyArray = this._j) {
                DimensionManager.setWorld(yfgy2.field_73011_w._i, null);
            }
            if (this._c != null && this._c._f()) {
                this._c._g();
            }
        }
    }

    public String _x() {
        return this._h;
    }

    public void _h(String string) {
        this._h = string;
    }

    public boolean _y() {
        return this._l;
    }

    public void _z() {
        this._l = false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void run() {
        long l;
        long l2;
        try {
            if (!this._n()) {
                this._a((CrashReport)null);
                return;
            }
            FMLCommonHandler.instance().handleServerStarted();
            l2 = dzfd.__aq();
            FMLCommonHandler.instance().onWorldLoadTick(this._j);
            l = 0L;
        }
        catch (Throwable throwable) {
            if (FMLCommonHandler.instance().shouldServerBeKilledQuietly()) {
                return;
            }
            throwable.printStackTrace();
            this._O()._b("Encountered an unexpected exception " + throwable.getClass().getSimpleName(), throwable);
            CrashReport crashReport = null;
            crashReport = throwable instanceof turb ? this._b(((turb)throwable)._a()) : this._b(new CrashReport("Exception in server tick loop", throwable));
            File file = new File(new File(this._A(), "crash-reports"), "crash-" + new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss").format(new Date()) + "-server.txt");
            if (crashReport.func_71508_a(file, this._O())) {
                this._O()._c("This crash report has been saved to: " + file.getAbsolutePath());
            } else {
                this._O()._c("We were unable to save this crash report to disk.");
            }
            this._a(crashReport);
            return;
        }
        finally {
            try {
                if (FMLCommonHandler.instance().shouldServerBeKilledQuietly()) {
                    return;
                }
                this._w();
                this._m = true;
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            finally {
                FMLCommonHandler.instance().handleServerStopped();
                this._m = true;
                this._B();
            }
        }
        while (true) {
            if (!this._l) {
                FMLCommonHandler.instance().handleServerStopping();
                return;
            }
            long l3 = dzfd.__aq();
            long l4 = l3 - l2;
            if (l4 > 2000L && l2 - this._S >= 15000L) {
                this._O()._b("Can't keep up! Did the system time change, or is the server overloaded?");
                l4 = 2000L;
                this._S = l2;
            }
            if (l4 < 0L) {
                this._O()._b("Time ran backwards! Did the system time change?");
                l4 = 0L;
            }
            l += l4;
            l2 = l3;
            if (this._j[0].func_73056_e()) {
                this._C();
                l = 0L;
            } else {
                while (l > 50L) {
                    l -= 50L;
                    this._C();
                }
            }
            Thread.sleep(1L);
            this._R = true;
        }
    }

    public File _A() {
        return new File(".");
    }

    public void _a(CrashReport crashReport) {
    }

    public void _B() {
    }

    public void _C() {
        FMLCommonHandler.instance().rescheduleTicks(Side.SERVER);
        long l = System.nanoTime();
        eidj._a()._a();
        FMLCommonHandler.instance().onPreServerTick();
        ++this._n;
        if (this._U) {
            this._U = false;
            this._g._c = true;
            this._g._a();
        }
        this._g._a("root");
        this._D();
        if (this._n % 900 == 0) {
            this._g._a("save");
            this._k._n();
            this._a(true);
            this._g._b();
        }
        this._g._a("tallying");
        this._H[this._n % 100] = System.nanoTime() - l;
        this._D[this._n % 100] = cezg.field_73290_p - this._z;
        this._z = cezg.field_73290_p;
        this._E[this._n % 100] = cezg.field_73289_q - this._A;
        this._A = cezg.field_73289_q;
        this._F[this._n % 100] = cezg.field_73292_n - this._B;
        this._B = cezg.field_73292_n;
        this._G[this._n % 100] = cezg.field_73293_o - this._C;
        this._C = cezg.field_73293_o;
        this._g._b();
        this._g._a("snooper");
        if (!this._c._f() && this._n > 100) {
            this._c._a();
        }
        if (this._n % 6000 == 0) {
            this._c._d();
        }
        this._g._b();
        this._g._b();
        FMLCommonHandler.instance().onPostServerTick();
    }

    public void _D() {
        this._g._a("levels");
        Integer[] integerArray = DimensionManager.getIDs(this._n % 200 == 0);
        for (int i = 0; i < integerArray.length; ++i) {
            int n = integerArray[i];
            long l = System.nanoTime();
            if (n == 0 || this._E()) {
                yfgy yfgy2 = DimensionManager.getWorld(n);
                this._g._a(yfgy2.func_72912_H()._k());
                this._g._a("pools");
                yfgy2.func_82732_R()._a();
                this._g._b();
                if (this._n % 20 == 0) {
                    this._g._a("timeSync");
                    this._k._a(new rrld(yfgy2.func_82737_E(), yfgy2.func_72820_D(), yfgy2.func_82736_K()._b("doDaylightCycle")), yfgy2.field_73011_w._i);
                    this._g._b();
                }
                this._g._a("tick");
                FMLCommonHandler.instance().onPreWorldTick(yfgy2);
                try {
                    yfgy2.func_72835_b();
                }
                catch (Throwable throwable) {
                    CrashReport crashReport = CrashReport.func_85055_a(throwable, "Exception ticking world");
                    yfgy2.func_72914_a(crashReport);
                    throw new turb(crashReport);
                }
                try {
                    yfgy2.func_72939_s();
                }
                catch (Throwable throwable) {
                    CrashReport crashReport = CrashReport.func_85055_a(throwable, "Exception ticking world entities");
                    yfgy2.func_72914_a(crashReport);
                    throw new turb(crashReport);
                }
                FMLCommonHandler.instance().onPostWorldTick(yfgy2);
                this._g._b();
                this._g._a("tracker");
                yfgy2.func_73039_n()._a();
                this._g._b();
                this._g._b();
            }
            this._I.get((Object)Integer.valueOf((int)n))[this._n % 100] = System.nanoTime() - l;
        }
        this._g._c("dim_unloading");
        DimensionManager.unloadWorlds(this._I);
        this._g._c("connection");
        this.__ah()._b();
        this._g._c("players");
        this._k._i();
        this._g._c("tickables");
        for (int i = 0; i < this._e.size(); ++i) {
            ((ywed)this._e.get(i))._a();
        }
        this._g._b();
    }

    public boolean _E() {
        return true;
    }

    public void _F() {
        new vmwi(this, "Server thread").start();
    }

    public File _i(String string) {
        return new File(this._A(), string);
    }

    public void _b(String string) {
        this._O()._a(string);
    }

    public void _c(String string) {
        this._O()._b(string);
    }

    public yfgy _a(int n) {
        yfgy yfgy2 = DimensionManager.getWorld(n);
        if (yfgy2 == null) {
            DimensionManager.initDimension(n);
            yfgy2 = DimensionManager.getWorld(n);
        }
        return yfgy2;
    }

    public String _c() {
        return this._h;
    }

    public int _d() {
        return this._i;
    }

    public String _e() {
        return this._w;
    }

    public String _f() {
        return "1.6.4";
    }

    public int _g() {
        return this._k._q();
    }

    public int _h() {
        return this._k._r();
    }

    public String[] _i() {
        return this._k._k();
    }

    public String _k() {
        return "";
    }

    public String _a(String string) {
        hdlq._a._a();
        this._f.func_71556_a(hdlq._a, string);
        return hdlq._a._b();
    }

    public boolean _l() {
        return false;
    }

    public void _d(String string) {
        this._O()._c(string);
    }

    public void _e(String string) {
        if (this._l()) {
            this._O()._a(string);
        }
    }

    public String _H() {
        return FMLCommonHandler.instance().getModName();
    }

    public CrashReport _b(CrashReport crashReport) {
        crashReport.func_85056_g()._a("Profiler Position", new jjtx(this));
        if (this._j != null && this._j.length > 0 && this._j[0] != null) {
            crashReport.func_85056_g()._a("Vec3 Pool Size", new elgy(this));
        }
        if (this._k != null) {
            crashReport.func_85056_g()._a("Player Count", new grmg(this));
        }
        return crashReport;
    }

    public List _a(nemo nemo2, String string) {
        ArrayList<String> arrayList = new ArrayList<String>();
        if (string.startsWith("/")) {
            boolean bl = !(string = string.substring(1)).contains(" ");
            List list2 = this._f.func_71558_b(nemo2, string);
            if (list2 != null) {
                for (String string2 : list2) {
                    if (bl) {
                        arrayList.add("/" + string2);
                        continue;
                    }
                    arrayList.add(string2);
                }
            }
            return arrayList;
        }
        String[] stringArray = string.split(" ", -1);
        String string3 = stringArray[stringArray.length - 1];
        for (String string4 : this._k._k()) {
            if (!ohnk.func_71523_a(string3, string4)) continue;
            arrayList.add(string4);
        }
        return arrayList;
    }

    public static dzfd _I() {
        return _a;
    }

    @Override
    public String func_70005_c_() {
        return "Server";
    }

    @Override
    public void func_70006_a(zwat zwat2) {
        this._O()._a(zwat2.toString());
    }

    @Override
    public boolean func_70003_b(int n, String string) {
        return true;
    }

    public zyqp _J() {
        return this._f;
    }

    public KeyPair _K() {
        return this._J;
    }

    public int _L() {
        return this._i;
    }

    public void _b(int n) {
        this._i = n;
    }

    public String _M() {
        return this._K;
    }

    public void _j(String string) {
        this._K = string;
    }

    public boolean _N() {
        return this._K != null;
    }

    public String _j() {
        return this._L;
    }

    public void _k(String string) {
        this._L = string;
    }

    @SideOnly(value=Side.CLIENT)
    public void _l(String string) {
        this._M = string;
    }

    @SideOnly(value=Side.CLIENT)
    public String _P() {
        return this._M;
    }

    public void _a(KeyPair keyPair) {
        this._J = keyPair;
    }

    public void _c(int n) {
        for (int i = 0; i < this._j.length; ++i) {
            yfgy yfgy2 = this._j[i];
            if (yfgy2 == null) continue;
            if (yfgy2.func_72912_H()._t()) {
                yfgy2.field_73013_u = 3;
                yfgy2.func_72891_a(true, true);
                continue;
            }
            if (this._N()) {
                yfgy2.field_73013_u = n;
                yfgy2.func_72891_a(yfgy2.field_73013_u > 0, true);
                continue;
            }
            yfgy2.field_73013_u = n;
            yfgy2.func_72891_a(this._Q(), this._s);
        }
    }

    public boolean _Q() {
        return true;
    }

    public boolean _R() {
        return this._N;
    }

    public void _b(boolean bl) {
        this._N = bl;
    }

    public void _c(boolean bl) {
        this._O = bl;
    }

    public ozsq _S() {
        return this._b;
    }

    public void _T() {
        this._P = true;
        this._S()._c();
        for (int i = 0; i < this._j.length; ++i) {
            yfgy yfgy2 = this._j[i];
            if (yfgy2 == null) continue;
            MinecraftForge.EVENT_BUS.post(new WorldEvent.Unload(yfgy2));
            yfgy2.func_73041_k();
        }
        this._S()._d(this._j[0].func_72860_G().func_75760_g());
        this._z();
    }

    public String _U() {
        return this._Q;
    }

    public void _m(String string) {
        this._Q = string;
    }

    @Override
    public void _a(cfbu cfbu2) {
        cfbu2._a("whitelist_enabled", false);
        cfbu2._a("whitelist_count", 0);
        cfbu2._a("players_current", this._g());
        cfbu2._a("players_max", this._h());
        cfbu2._a("players_seen", this._k._s().length);
        cfbu2._a("uses_auth", this._r);
        cfbu2._a("gui_state", this.__aj() ? "enabled" : "disabled");
        cfbu2._a("run_time", (dzfd.__aq() - cfbu2._i()) / 60L * 1000L);
        cfbu2._a("avg_tick_ms", (int)(sajh._a(this._H) * 1.0E-6));
        cfbu2._a("avg_sent_packet_count", (int)sajh._a(this._D));
        cfbu2._a("avg_sent_packet_size", (int)sajh._a(this._E));
        cfbu2._a("avg_rec_packet_count", (int)sajh._a(this._F));
        cfbu2._a("avg_rec_packet_size", (int)sajh._a(this._G));
        int n = 0;
        for (int i = 0; i < this._j.length; ++i) {
            if (this._j[i] == null) continue;
            yfgy yfgy2 = this._j[i];
            iyev iyev2 = yfgy2.func_72912_H();
            cfbu2._a("world[" + n + "][dimension]", yfgy2.field_73011_w._i);
            cfbu2._a("world[" + n + "][mode]", (Object)iyev2._r());
            cfbu2._a("world[" + n + "][difficulty]", yfgy2.field_73013_u);
            cfbu2._a("world[" + n + "][hardcore]", iyev2._t());
            cfbu2._a("world[" + n + "][generator_name]", iyev2._u()._a());
            cfbu2._a("world[" + n + "][generator_version]", iyev2._u()._c());
            cfbu2._a("world[" + n + "][height]", this._x);
            cfbu2._a("world[" + n + "][chunks_loaded]", yfgy2.func_72863_F()._e());
            ++n;
        }
        cfbu2._a("worlds", n);
    }

    @Override
    public void _b(cfbu cfbu2) {
        cfbu2._a("singleplayer", this._N());
        cfbu2._a("server_brand", this._H());
        cfbu2._a("gui_supported", GraphicsEnvironment.isHeadless() ? "headless" : "supported");
        cfbu2._a("dedicated", this._W());
    }

    @Override
    public boolean _G() {
        return true;
    }

    public int _V() {
        return 16;
    }

    public abstract boolean _W();

    public boolean _X() {
        return this._r;
    }

    public void _d(boolean bl) {
        this._r = bl;
    }

    public boolean _Y() {
        return this._s;
    }

    public void _e(boolean bl) {
        this._s = bl;
    }

    public boolean _Z() {
        return this._t;
    }

    public void _f(boolean bl) {
        this._t = bl;
    }

    public boolean __aa() {
        return this._u;
    }

    public void _g(boolean bl) {
        this._u = bl;
    }

    public boolean __ab() {
        return this._v;
    }

    public void _h(boolean bl) {
        this._v = bl;
    }

    public abstract boolean __ac();

    public String __ad() {
        return this._w;
    }

    public void _n(String string) {
        this._w = string;
    }

    public int __ae() {
        return this._x;
    }

    public void _d(int n) {
        this._x = n;
    }

    public boolean __af() {
        return this._m;
    }

    public ozhc __ag() {
        return this._k;
    }

    public void _a(ozhc ozhc2) {
        this._k = ozhc2;
    }

    public void _a(xtby xtby2) {
        for (int i = 0; i < this._j.length; ++i) {
            dzfd._I()._j[i].func_72912_H()._a(xtby2);
        }
    }

    public abstract vmra __ah();

    @SideOnly(value=Side.CLIENT)
    public boolean __ai() {
        return this._R;
    }

    public boolean __aj() {
        return false;
    }

    public abstract String _a(xtby var1, boolean var2);

    public int __ak() {
        return this._n;
    }

    public void __al() {
        this._U = true;
    }

    @SideOnly(value=Side.CLIENT)
    public cfbu __am() {
        return this._c;
    }

    @Override
    public zwaw func_82114_b() {
        return new zwaw(0, 0, 0);
    }

    @Override
    public ozlu func_130014_f_() {
        return this._j[0];
    }

    public int __an() {
        return 16;
    }

    public boolean _a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer) {
        return false;
    }

    @Override
    public abstract jjmf _O();

    public void _i(boolean bl) {
        this._V = bl;
    }

    public boolean __ao() {
        return this._V;
    }

    public Proxy __ap() {
        return this._o;
    }

    public static long __aq() {
        return System.currentTimeMillis();
    }

    public int __ar() {
        return this._y;
    }

    public void _e(int n) {
        this._y = n;
    }

    public static ozhc _a(dzfd dzfd2) {
        return dzfd2._k;
    }
}

