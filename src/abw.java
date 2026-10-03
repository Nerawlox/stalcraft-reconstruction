/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  abp
 *  abr
 *  abt
 *  abx
 *  aby
 *  abz
 *  aca
 *  acb
 *  acd
 *  acf
 *  acl
 *  aco
 *  acv
 *  ado
 *  akc
 *  alf
 *  alg
 *  all
 *  als
 *  amc
 *  aop
 *  aot
 *  aqp
 *  arf
 *  asx
 *  ata
 *  atc
 *  atd
 *  atj
 *  com.google.common.collect.ImmutableSetMultimap
 *  cpw.mods.fml.common.FMLLog
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  hr
 *  lp
 *  lv
 *  net.minecraft.server.MinecraftServer
 *  net.minecraftforge.client.ForgeHooksClient
 *  net.minecraftforge.common.ForgeChunkManager
 *  net.minecraftforge.common.ForgeChunkManager$Ticket
 *  net.minecraftforge.common.ForgeDirection
 *  net.minecraftforge.common.ForgeDummyContainer
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.common.WorldSpecificSaveHandler
 *  net.minecraftforge.event.Event
 *  net.minecraftforge.event.entity.EntityEvent$CanUpdate
 *  net.minecraftforge.event.entity.EntityJoinWorldEvent
 *  net.minecraftforge.event.entity.PlaySoundAtEntityEvent
 *  nw
 *  s
 *  t
 *  u
 */
import com.google.common.collect.ImmutableSetMultimap;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.common.ForgeChunkManager;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.ForgeDummyContainer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.WorldSpecificSaveHandler;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.PlaySoundAtEntityEvent;

public abstract class abw
implements acf {
    public static double MAX_ENTITY_RADIUS = 2.0;
    public final amr perWorldStorage;
    public boolean d;
    public List e = new ArrayList();
    protected List f = new ArrayList();
    public List g = new ArrayList();
    private List a = new ArrayList();
    private List b = new ArrayList();
    public List h = new ArrayList();
    public List i = new ArrayList();
    private long c = 0xFFFFFFL;
    public int j;
    protected int k = new Random().nextInt();
    protected final int l = 1013904223;
    public float m;
    public float n;
    public float o;
    public float p;
    public int q;
    public int r;
    public Random s = new Random();
    public final aei t;
    protected List u = new ArrayList();
    protected ado v;
    protected final amc w;
    protected als x;
    public boolean y;
    public amr z;
    public rm A;
    protected final rl B = new rl(this);
    public final lv C;
    private final atd J = new atd(300, 2000);
    private final Calendar K = Calendar.getInstance();
    protected atj D = new atj();
    private final lp L;
    private ArrayList M = new ArrayList();
    private boolean N;
    protected boolean E = true;
    protected boolean F = true;
    public Set G = new HashSet();
    private int O = this.s.nextInt(12000);
    int[] H = new int[32768];
    public boolean I;
    private static amr s_mapStorage;
    private static amc s_savehandler;

    public acq a(int par1, int par2) {
        return this.t.getBiomeGenForCoords(par1, par2);
    }

    public acq getBiomeGenForCoordsBody(int par1, int par2) {
        adr chunk;
        if (this.f(par1, 0, par2) && (chunk = this.d(par1, par2)) != null) {
            return chunk.a(par1 & 0xF, par2 & 0xF, this.t.e);
        }
        return this.t.e.a(par1, par2);
    }

    public acv u() {
        return this.t.e;
    }

    @SideOnly(value=Side.CLIENT)
    public abw(amc par1ISaveHandler, String par2Str, aei par3WorldProvider, acd par4WorldSettings, lv par5Profiler, lp par6ILogAgent) {
        this.w = par1ISaveHandler;
        this.C = par5Profiler;
        this.x = new als(par4WorldSettings, par2Str);
        this.t = par3WorldProvider;
        this.perWorldStorage = new amr(null);
        this.L = par6ILogAgent;
    }

    @SideOnly(value=Side.CLIENT)
    protected void finishSetup() {
        rm villagecollection = (rm)this.z.a(rm.class, "villages");
        if (villagecollection == null) {
            this.A = new rm(this);
            this.z.a("villages", this.A);
        } else {
            this.A = villagecollection;
            this.A.a(this);
        }
        int providerDim = this.t.i;
        this.t.a(this);
        this.t.i = providerDim;
        this.v = this.j();
        this.A();
        this.a();
    }

    public abw(amc par1ISaveHandler, String par2Str, acd par3WorldSettings, aei par4WorldProvider, lv par5Profiler, lp par6ILogAgent) {
        rm villagecollection;
        this.w = par1ISaveHandler;
        this.C = par5Profiler;
        this.z = this.getMapStorage(par1ISaveHandler);
        this.L = par6ILogAgent;
        this.x = par1ISaveHandler.d();
        this.t = par4WorldProvider != null ? par4WorldProvider : (this.x != null && this.x.j() != 0 ? aei.a(this.x.j()) : aei.a(0));
        if (this.x == null) {
            this.x = new als(par3WorldSettings, par2Str);
        } else {
            this.x.a(par2Str);
        }
        this.t.a(this);
        this.v = this.j();
        this.perWorldStorage = this instanceof js ? new amr((amc)new WorldSpecificSaveHandler((js)this, par1ISaveHandler)) : new amr(null);
        if (!this.x.w()) {
            try {
                this.a(par3WorldSettings);
            }
            catch (Throwable throwable) {
                b crashreport = b.a(throwable, "Exception initializing level");
                try {
                    this.a(crashreport);
                }
                catch (Throwable throwable2) {
                    // empty catch block
                }
                throw new u(crashreport);
            }
            this.x.d(true);
        }
        if ((villagecollection = (rm)this.perWorldStorage.a(rm.class, "villages")) == null) {
            this.A = new rm(this);
            this.perWorldStorage.a("villages", this.A);
        } else {
            this.A = villagecollection;
            this.A.a(this);
        }
        this.A();
        this.a();
    }

    private amr getMapStorage(amc savehandler) {
        if (s_savehandler != savehandler || s_mapStorage == null) {
            s_mapStorage = new amr(savehandler);
            s_savehandler = savehandler;
        }
        return s_mapStorage;
    }

    protected abstract ado j();

    protected void a(acd par1WorldSettings) {
        this.x.d(true);
    }

    @SideOnly(value=Side.CLIENT)
    public void f() {
        this.E(8, 64, 8);
    }

    public int b(int par1, int par2) {
        int k = 63;
        while (!this.c(par1, k + 1, par2)) {
            ++k;
        }
        return this.a(par1, k, par2);
    }

    public int a(int par1, int par2, int par3) {
        if (par1 >= -30000000 && par3 >= -30000000 && par1 < 30000000 && par3 < 30000000) {
            if (par2 < 0) {
                return 0;
            }
            if (par2 >= 256) {
                return 0;
            }
            adr chunk = null;
            try {
                chunk = this.e(par1 >> 4, par3 >> 4);
                return chunk.a(par1 & 0xF, par2, par3 & 0xF);
            }
            catch (Throwable throwable) {
                b crashreport = b.a(throwable, "Exception getting block type in world");
                m crashreportcategory = crashreport.a("Requested block coordinates");
                crashreportcategory.a("Found chunk", chunk == null);
                crashreportcategory.a("Location", m.a(par1, par2, par3));
                throw new u(crashreport);
            }
        }
        return 0;
    }

    public boolean c(int par1, int par2, int par3) {
        int id = this.a(par1, par2, par3);
        return id == 0 || aqz.s[id] == null || aqz.s[id].isAirBlock(this, par1, par2, par3);
    }

    public boolean d(int par1, int par2, int par3) {
        int l = this.a(par1, par2, par3);
        int meta = this.h(par1, par2, par3);
        return aqz.s[l] != null && aqz.s[l].hasTileEntity(meta);
    }

    public int e(int par1, int par2, int par3) {
        int l = this.a(par1, par2, par3);
        return aqz.s[l] != null ? aqz.s[l].d() : -1;
    }

    public boolean f(int par1, int par2, int par3) {
        return par2 >= 0 && par2 < 256 ? this.c(par1 >> 4, par3 >> 4) : false;
    }

    public boolean b(int par1, int par2, int par3, int par4) {
        return this.e(par1 - par4, par2 - par4, par3 - par4, par1 + par4, par2 + par4, par3 + par4);
    }

    public boolean e(int par1, int par2, int par3, int par4, int par5, int par6) {
        if (par5 >= 0 && par2 < 256) {
            par3 >>= 4;
            par4 >>= 4;
            par6 >>= 4;
            for (int k1 = par1 >>= 4; k1 <= par4; ++k1) {
                for (int l1 = par3; l1 <= par6; ++l1) {
                    if (this.c(k1, l1)) continue;
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    protected boolean c(int par1, int par2) {
        return this.v.a(par1, par2);
    }

    public adr d(int par1, int par2) {
        return this.e(par1 >> 4, par2 >> 4);
    }

    public adr e(int par1, int par2) {
        return this.v.d(par1, par2);
    }

    public boolean f(int par1, int par2, int par3, int par4, int par5, int par6) {
        if (par1 >= -30000000 && par3 >= -30000000 && par1 < 30000000 && par3 < 30000000) {
            if (par2 < 0) {
                return false;
            }
            if (par2 >= 256) {
                return false;
            }
            adr chunk = this.e(par1 >> 4, par3 >> 4);
            int k1 = 0;
            if ((par6 & 1) != 0) {
                k1 = chunk.a(par1 & 0xF, par2, par3 & 0xF);
            }
            boolean flag = chunk.a(par1 & 0xF, par2, par3 & 0xF, par4, par5);
            this.C.a("checkLight");
            this.A(par1, par2, par3);
            this.C.b();
            if (flag) {
                if (!((par6 & 2) == 0 || this.I && (par6 & 4) != 0)) {
                    this.j(par1, par2, par3);
                }
                if (!this.I && (par6 & 1) != 0) {
                    this.d(par1, par2, par3, k1);
                    aqz block = aqz.s[par4];
                    if (block != null && block.q_()) {
                        this.m(par1, par2, par3, par4);
                    }
                }
            }
            return flag;
        }
        return false;
    }

    public akc g(int par1, int par2, int par3) {
        int l = this.a(par1, par2, par3);
        return l == 0 ? akc.a : aqz.s[l].cU;
    }

    public int h(int par1, int par2, int par3) {
        if (par1 >= -30000000 && par3 >= -30000000 && par1 < 30000000 && par3 < 30000000) {
            if (par2 < 0) {
                return 0;
            }
            if (par2 >= 256) {
                return 0;
            }
            adr chunk = this.e(par1 >> 4, par3 >> 4);
            return chunk.c(par1 &= 0xF, par2, par3 &= 0xF);
        }
        return 0;
    }

    public boolean b(int par1, int par2, int par3, int par4, int par5) {
        if (par1 >= -30000000 && par3 >= -30000000 && par1 < 30000000 && par3 < 30000000) {
            int k1;
            int j1;
            if (par2 < 0) {
                return false;
            }
            if (par2 >= 256) {
                return false;
            }
            adr chunk = this.e(par1 >> 4, par3 >> 4);
            boolean flag = chunk.b(j1 = par1 & 0xF, par2, k1 = par3 & 0xF, par4);
            if (flag) {
                int l1 = chunk.a(j1, par2, k1);
                if (!((par5 & 2) == 0 || this.I && (par5 & 4) != 0)) {
                    this.j(par1, par2, par3);
                }
                if (!this.I && (par5 & 1) != 0) {
                    this.d(par1, par2, par3, l1);
                    aqz block = aqz.s[l1];
                    if (block != null && block.q_()) {
                        this.m(par1, par2, par3, l1);
                    }
                }
            }
            return flag;
        }
        return false;
    }

    public boolean i(int par1, int par2, int par3) {
        return this.f(par1, par2, par3, 0, 0, 3);
    }

    public boolean a(int par1, int par2, int par3, boolean par4) {
        int l = this.a(par1, par2, par3);
        if (l > 0) {
            int i1 = this.h(par1, par2, par3);
            this.e(2001, par1, par2, par3, l + (i1 << 12));
            if (par4) {
                aqz.s[l].c(this, par1, par2, par3, i1, 0);
            }
            return this.f(par1, par2, par3, 0, 0, 3);
        }
        return false;
    }

    public boolean c(int par1, int par2, int par3, int par4) {
        return this.f(par1, par2, par3, par4, 0, 3);
    }

    public void j(int par1, int par2, int par3) {
        for (int l = 0; l < this.u.size(); ++l) {
            ((acb)this.u.get(l)).a(par1, par2, par3);
        }
    }

    public void d(int par1, int par2, int par3, int par4) {
        this.f(par1, par2, par3, par4);
    }

    public void e(int par1, int par2, int par3, int par4) {
        int i1;
        if (par3 > par4) {
            i1 = par4;
            par4 = par3;
            par3 = i1;
        }
        if (!this.t.g) {
            for (i1 = par3; i1 <= par4; ++i1) {
                this.c(ach.a, par1, i1, par2);
            }
        }
        this.g(par1, par3, par2, par1, par4, par2);
    }

    public void g(int par1, int par2, int par3, int par4, int par5, int par6) {
        for (int k1 = 0; k1 < this.u.size(); ++k1) {
            ((acb)this.u.get(k1)).a(par1, par2, par3, par4, par5, par6);
        }
    }

    public void f(int par1, int par2, int par3, int par4) {
        this.g(par1 - 1, par2, par3, par4);
        this.g(par1 + 1, par2, par3, par4);
        this.g(par1, par2 - 1, par3, par4);
        this.g(par1, par2 + 1, par3, par4);
        this.g(par1, par2, par3 - 1, par4);
        this.g(par1, par2, par3 + 1, par4);
    }

    public void c(int par1, int par2, int par3, int par4, int par5) {
        if (par5 != 4) {
            this.g(par1 - 1, par2, par3, par4);
        }
        if (par5 != 5) {
            this.g(par1 + 1, par2, par3, par4);
        }
        if (par5 != 0) {
            this.g(par1, par2 - 1, par3, par4);
        }
        if (par5 != 1) {
            this.g(par1, par2 + 1, par3, par4);
        }
        if (par5 != 2) {
            this.g(par1, par2, par3 - 1, par4);
        }
        if (par5 != 3) {
            this.g(par1, par2, par3 + 1, par4);
        }
    }

    public void g(int par1, int par2, int par3, int par4) {
        int i1;
        aqz block;
        if (!this.I && (block = aqz.s[i1 = this.a(par1, par2, par3)]) != null) {
            try {
                block.a(this, par1, par2, par3, par4);
            }
            catch (Throwable throwable) {
                int j1;
                b crashreport = b.a(throwable, "Exception while updating neighbours");
                m crashreportcategory = crashreport.a("Block being updated");
                try {
                    j1 = this.h(par1, par2, par3);
                }
                catch (Throwable throwable1) {
                    j1 = -1;
                }
                crashreportcategory.a("Source block type", (Callable)new abx(this, par4));
                m.a(crashreportcategory, par1, par2, par3, i1, j1);
                throw new u(crashreport);
            }
        }
    }

    public boolean a(int par1, int par2, int par3, int par4) {
        return false;
    }

    public boolean l(int par1, int par2, int par3) {
        return this.e(par1 >> 4, par3 >> 4).d(par1 & 0xF, par2, par3 & 0xF);
    }

    public int m(int par1, int par2, int par3) {
        if (par2 < 0) {
            return 0;
        }
        if (par2 >= 256) {
            par2 = 255;
        }
        return this.e(par1 >> 4, par3 >> 4).c(par1 & 0xF, par2, par3 & 0xF, 0);
    }

    public int n(int par1, int par2, int par3) {
        return this.b(par1, par2, par3, true);
    }

    public int b(int par1, int par2, int par3, boolean par4) {
        if (par1 >= -30000000 && par3 >= -30000000 && par1 < 30000000 && par3 < 30000000) {
            int l;
            if (par4 && aqz.x[l = this.a(par1, par2, par3)]) {
                int i1 = this.b(par1, par2 + 1, par3, false);
                int j1 = this.b(par1 + 1, par2, par3, false);
                int k1 = this.b(par1 - 1, par2, par3, false);
                int l1 = this.b(par1, par2, par3 + 1, false);
                int i2 = this.b(par1, par2, par3 - 1, false);
                if (j1 > i1) {
                    i1 = j1;
                }
                if (k1 > i1) {
                    i1 = k1;
                }
                if (l1 > i1) {
                    i1 = l1;
                }
                if (i2 > i1) {
                    i1 = i2;
                }
                return i1;
            }
            if (par2 < 0) {
                return 0;
            }
            if (par2 >= 256) {
                par2 = 255;
            }
            adr chunk = this.e(par1 >> 4, par3 >> 4);
            return chunk.c(par1 &= 0xF, par2, par3 &= 0xF, this.j);
        }
        return 15;
    }

    public int f(int par1, int par2) {
        if (par1 >= -30000000 && par2 >= -30000000 && par1 < 30000000 && par2 < 30000000) {
            if (!this.c(par1 >> 4, par2 >> 4)) {
                return 0;
            }
            adr chunk = this.e(par1 >> 4, par2 >> 4);
            return chunk.b(par1 & 0xF, par2 & 0xF);
        }
        return 0;
    }

    public int g(int par1, int par2) {
        if (par1 >= -30000000 && par2 >= -30000000 && par1 < 30000000 && par2 < 30000000) {
            if (!this.c(par1 >> 4, par2 >> 4)) {
                return 0;
            }
            adr chunk = this.e(par1 >> 4, par2 >> 4);
            return chunk.p;
        }
        return 0;
    }

    @SideOnly(value=Side.CLIENT)
    public int a(ach par1EnumSkyBlock, int par2, int par3, int par4) {
        if (this.t.g && par1EnumSkyBlock == ach.a) {
            return 0;
        }
        if (par3 < 0) {
            par3 = 0;
        }
        if (par3 >= 256) {
            return par1EnumSkyBlock.c;
        }
        if (par2 >= -30000000 && par4 >= -30000000 && par2 < 30000000 && par4 < 30000000) {
            int l = par2 >> 4;
            int i1 = par4 >> 4;
            if (!this.c(l, i1)) {
                return par1EnumSkyBlock.c;
            }
            if (aqz.x[this.a(par2, par3, par4)]) {
                int j1 = this.b(par1EnumSkyBlock, par2, par3 + 1, par4);
                int k1 = this.b(par1EnumSkyBlock, par2 + 1, par3, par4);
                int l1 = this.b(par1EnumSkyBlock, par2 - 1, par3, par4);
                int i2 = this.b(par1EnumSkyBlock, par2, par3, par4 + 1);
                int j2 = this.b(par1EnumSkyBlock, par2, par3, par4 - 1);
                if (k1 > j1) {
                    j1 = k1;
                }
                if (l1 > j1) {
                    j1 = l1;
                }
                if (i2 > j1) {
                    j1 = i2;
                }
                if (j2 > j1) {
                    j1 = j2;
                }
                return j1;
            }
            adr chunk = this.e(l, i1);
            return chunk.a(par1EnumSkyBlock, par2 & 0xF, par3, par4 & 0xF);
        }
        return par1EnumSkyBlock.c;
    }

    public int b(ach par1EnumSkyBlock, int par2, int par3, int par4) {
        if (par3 < 0) {
            par3 = 0;
        }
        if (par3 >= 256) {
            par3 = 255;
        }
        if (par2 >= -30000000 && par4 >= -30000000 && par2 < 30000000 && par4 < 30000000) {
            int l = par2 >> 4;
            int i1 = par4 >> 4;
            if (!this.c(l, i1)) {
                return par1EnumSkyBlock.c;
            }
            adr chunk = this.e(l, i1);
            return chunk.a(par1EnumSkyBlock, par2 & 0xF, par3, par4 & 0xF);
        }
        return par1EnumSkyBlock.c;
    }

    public void b(ach par1EnumSkyBlock, int par2, int par3, int par4, int par5) {
        if (par2 >= -30000000 && par4 >= -30000000 && par2 < 30000000 && par4 < 30000000 && par3 >= 0 && par3 < 256 && this.c(par2 >> 4, par4 >> 4)) {
            adr chunk = this.e(par2 >> 4, par4 >> 4);
            chunk.a(par1EnumSkyBlock, par2 & 0xF, par3, par4 & 0xF, par5);
            for (int i1 = 0; i1 < this.u.size(); ++i1) {
                ((acb)this.u.get(i1)).b(par2, par3, par4);
            }
        }
    }

    public void p(int par1, int par2, int par3) {
        for (int l = 0; l < this.u.size(); ++l) {
            ((acb)this.u.get(l)).b(par1, par2, par3);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public int h(int par1, int par2, int par3, int par4) {
        int i1 = this.a(ach.a, par1, par2, par3);
        int j1 = this.a(ach.b, par1, par2, par3);
        if (j1 < par4) {
            j1 = par4;
        }
        return i1 << 20 | j1 << 4;
    }

    @SideOnly(value=Side.CLIENT)
    public float i(int par1, int par2, int par3, int par4) {
        int i1 = this.n(par1, par2, par3);
        if (i1 < par4) {
            i1 = par4;
        }
        return this.t.h[i1];
    }

    public float q(int par1, int par2, int par3) {
        return this.t.h[this.n(par1, par2, par3)];
    }

    public boolean v() {
        return this.t.isDaytime();
    }

    public ata a(atc par1Vec3, atc par2Vec3) {
        return this.a(par1Vec3, par2Vec3, false, false);
    }

    public ata a(atc par1Vec3, atc par2Vec3, boolean par3) {
        return this.a(par1Vec3, par2Vec3, par3, false);
    }

    public ata a(atc par1Vec3, atc par2Vec3, boolean par3, boolean par4) {
        if (!(Double.isNaN(par1Vec3.c) || Double.isNaN(par1Vec3.d) || Double.isNaN(par1Vec3.e))) {
            if (!(Double.isNaN(par2Vec3.c) || Double.isNaN(par2Vec3.d) || Double.isNaN(par2Vec3.e))) {
                ata movingobjectposition;
                int i = ls.c(par2Vec3.c);
                int j2 = ls.c(par2Vec3.d);
                int k = ls.c(par2Vec3.e);
                int l = ls.c(par1Vec3.c);
                int i1 = ls.c(par1Vec3.d);
                int j1 = ls.c(par1Vec3.e);
                int k1 = this.a(l, i1, j1);
                int l1 = this.h(l, i1, j1);
                aqz block = aqz.s[k1];
                if (block != null && (!par4 || block == null || block.b(this, l, i1, j1) != null) && k1 > 0 && block.a(l1, par3) && (movingobjectposition = block.a(this, l, i1, j1, par1Vec3, par2Vec3)) != null) {
                    return movingobjectposition;
                }
                k1 = 200;
                while (k1-- >= 0) {
                    ata movingobjectposition1;
                    int b0;
                    if (Double.isNaN(par1Vec3.c) || Double.isNaN(par1Vec3.d) || Double.isNaN(par1Vec3.e)) {
                        return null;
                    }
                    if (l == i && i1 == j2 && j1 == k) {
                        return null;
                    }
                    boolean flag2 = true;
                    boolean flag3 = true;
                    boolean flag4 = true;
                    double d0 = 999.0;
                    double d1 = 999.0;
                    double d2 = 999.0;
                    if (i > l) {
                        d0 = (double)l + 1.0;
                    } else if (i < l) {
                        d0 = (double)l + 0.0;
                    } else {
                        flag2 = false;
                    }
                    if (j2 > i1) {
                        d1 = (double)i1 + 1.0;
                    } else if (j2 < i1) {
                        d1 = (double)i1 + 0.0;
                    } else {
                        flag3 = false;
                    }
                    if (k > j1) {
                        d2 = (double)j1 + 1.0;
                    } else if (k < j1) {
                        d2 = (double)j1 + 0.0;
                    } else {
                        flag4 = false;
                    }
                    double d3 = 999.0;
                    double d4 = 999.0;
                    double d5 = 999.0;
                    double d6 = par2Vec3.c - par1Vec3.c;
                    double d7 = par2Vec3.d - par1Vec3.d;
                    double d8 = par2Vec3.e - par1Vec3.e;
                    if (flag2) {
                        d3 = (d0 - par1Vec3.c) / d6;
                    }
                    if (flag3) {
                        d4 = (d1 - par1Vec3.d) / d7;
                    }
                    if (flag4) {
                        d5 = (d2 - par1Vec3.e) / d8;
                    }
                    boolean flag5 = false;
                    if (d3 < d4 && d3 < d5) {
                        b0 = i > l ? 4 : 5;
                        par1Vec3.c = d0;
                        par1Vec3.d += d7 * d3;
                        par1Vec3.e += d8 * d3;
                    } else if (d4 < d5) {
                        b0 = j2 > i1 ? 0 : 1;
                        par1Vec3.c += d6 * d4;
                        par1Vec3.d = d1;
                        par1Vec3.e += d8 * d4;
                    } else {
                        b0 = k > j1 ? 2 : 3;
                        par1Vec3.c += d6 * d5;
                        par1Vec3.d += d7 * d5;
                        par1Vec3.e = d2;
                    }
                    atc vec32 = this.V().a(par1Vec3.c, par1Vec3.d, par1Vec3.e);
                    vec32.c = ls.c(par1Vec3.c);
                    l = (int)vec32.c;
                    if (b0 == 5) {
                        --l;
                        vec32.c += 1.0;
                    }
                    vec32.d = ls.c(par1Vec3.d);
                    i1 = (int)vec32.d;
                    if (b0 == 1) {
                        --i1;
                        vec32.d += 1.0;
                    }
                    vec32.e = ls.c(par1Vec3.e);
                    j1 = (int)vec32.e;
                    if (b0 == 3) {
                        --j1;
                        vec32.e += 1.0;
                    }
                    int i2 = this.a(l, i1, j1);
                    int j22 = this.h(l, i1, j1);
                    aqz block1 = aqz.s[i2];
                    if (par4 && block1 != null && block1.b(this, l, i1, j1) == null || i2 <= 0 || !block1.a(j22, par3) || (movingobjectposition1 = block1.a(this, l, i1, j1, par1Vec3, par2Vec3)) == null) continue;
                    return movingobjectposition1;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public void a(nn par1Entity, String par2Str, float par3, float par4) {
        PlaySoundAtEntityEvent event = new PlaySoundAtEntityEvent(par1Entity, par2Str, par3, par4);
        if (MinecraftForge.EVENT_BUS.post((Event)event)) {
            return;
        }
        par2Str = event.name;
        if (par1Entity != null && par2Str != null) {
            for (int i = 0; i < this.u.size(); ++i) {
                ((acb)this.u.get(i)).a(par2Str, par1Entity.u, par1Entity.v - (double)par1Entity.N, par1Entity.w, par3, par4);
            }
        }
    }

    public void a(uf par1EntityPlayer, String par2Str, float par3, float par4) {
        PlaySoundAtEntityEvent event = new PlaySoundAtEntityEvent((nn)par1EntityPlayer, par2Str, par3, par4);
        if (MinecraftForge.EVENT_BUS.post((Event)event)) {
            return;
        }
        par2Str = event.name;
        if (par1EntityPlayer != null && par2Str != null) {
            for (int i = 0; i < this.u.size(); ++i) {
                ((acb)this.u.get(i)).a(par1EntityPlayer, par2Str, par1EntityPlayer.u, par1EntityPlayer.v - (double)par1EntityPlayer.N, par1EntityPlayer.w, par3, par4);
            }
        }
    }

    public void a(double par1, double par3, double par5, String par7Str, float par8, float par9) {
        if (par7Str != null) {
            for (int i = 0; i < this.u.size(); ++i) {
                ((acb)this.u.get(i)).a(par7Str, par1, par3, par5, par8, par9);
            }
        }
    }

    public void a(double par1, double par3, double par5, String par7Str, float par8, float par9, boolean par10) {
    }

    public void a(String par1Str, int par2, int par3, int par4) {
        for (int l = 0; l < this.u.size(); ++l) {
            ((acb)this.u.get(l)).a(par1Str, par2, par3, par4);
        }
    }

    public void a(String par1Str, double par2, double par4, double par6, double par8, double par10, double par12) {
        for (int i = 0; i < this.u.size(); ++i) {
            ((acb)this.u.get(i)).a(par1Str, par2, par4, par6, par8, par10, par12);
        }
    }

    public boolean c(nn par1Entity) {
        this.i.add(par1Entity);
        return true;
    }

    public boolean d(nn par1Entity) {
        int i = ls.c(par1Entity.u / 16.0);
        int j2 = ls.c(par1Entity.w / 16.0);
        boolean flag = par1Entity.p;
        if (par1Entity instanceof uf) {
            flag = true;
        }
        if (!flag && !this.c(i, j2)) {
            return false;
        }
        if (par1Entity instanceof uf) {
            uf entityplayer = (uf)par1Entity;
            this.h.add(entityplayer);
            this.c();
        }
        if (MinecraftForge.EVENT_BUS.post((Event)new EntityJoinWorldEvent(par1Entity, this)) && !flag) {
            return false;
        }
        this.e(i, j2).a(par1Entity);
        this.e.add(par1Entity);
        this.a(par1Entity);
        return true;
    }

    protected void a(nn par1Entity) {
        for (int i = 0; i < this.u.size(); ++i) {
            ((acb)this.u.get(i)).a(par1Entity);
        }
    }

    public void b(nn par1Entity) {
        for (int i = 0; i < this.u.size(); ++i) {
            ((acb)this.u.get(i)).b(par1Entity);
        }
    }

    public void e(nn par1Entity) {
        if (par1Entity.n != null) {
            par1Entity.n.a((nn)null);
        }
        if (par1Entity.o != null) {
            par1Entity.a((nn)null);
        }
        par1Entity.x();
        if (par1Entity instanceof uf) {
            this.h.remove(par1Entity);
            this.c();
        }
    }

    public void f(nn par1Entity) {
        par1Entity.x();
        if (par1Entity instanceof uf) {
            this.h.remove(par1Entity);
            this.c();
        }
        int i = par1Entity.aj;
        int j2 = par1Entity.al;
        if (par1Entity.ai && this.c(i, j2)) {
            this.e(i, j2).b(par1Entity);
        }
        this.e.remove(par1Entity);
        this.b(par1Entity);
    }

    public void a(acb par1IWorldAccess) {
        this.u.add(par1IWorldAccess);
    }

    public List a(nn par1Entity, asx par2AxisAlignedBB) {
        this.M.clear();
        int i = ls.c(par2AxisAlignedBB.a);
        int j2 = ls.c(par2AxisAlignedBB.d + 1.0);
        int k = ls.c(par2AxisAlignedBB.b);
        int l = ls.c(par2AxisAlignedBB.e + 1.0);
        int i1 = ls.c(par2AxisAlignedBB.c);
        int j1 = ls.c(par2AxisAlignedBB.f + 1.0);
        for (int k1 = i; k1 < j2; ++k1) {
            for (int l1 = i1; l1 < j1; ++l1) {
                if (!this.f(k1, 64, l1)) continue;
                for (int i2 = k - 1; i2 < l; ++i2) {
                    aqz block = aqz.s[this.a(k1, i2, l1)];
                    if (block == null) continue;
                    block.a(this, k1, i2, l1, par2AxisAlignedBB, this.M, par1Entity);
                }
            }
        }
        double d0 = 0.25;
        List list = this.b(par1Entity, par2AxisAlignedBB.b(d0, d0, d0));
        for (int j22 = 0; j22 < list.size(); ++j22) {
            asx axisalignedbb1 = ((nn)list.get(j22)).E();
            if (axisalignedbb1 != null && axisalignedbb1.b(par2AxisAlignedBB)) {
                this.M.add(axisalignedbb1);
            }
            if ((axisalignedbb1 = par1Entity.g((nn)list.get(j22))) == null || !axisalignedbb1.b(par2AxisAlignedBB)) continue;
            this.M.add(axisalignedbb1);
        }
        return this.M;
    }

    public List a(asx par1AxisAlignedBB) {
        this.M.clear();
        int i = ls.c(par1AxisAlignedBB.a);
        int j2 = ls.c(par1AxisAlignedBB.d + 1.0);
        int k = ls.c(par1AxisAlignedBB.b);
        int l = ls.c(par1AxisAlignedBB.e + 1.0);
        int i1 = ls.c(par1AxisAlignedBB.c);
        int j1 = ls.c(par1AxisAlignedBB.f + 1.0);
        for (int k1 = i; k1 < j2; ++k1) {
            for (int l1 = i1; l1 < j1; ++l1) {
                if (!this.f(k1, 64, l1)) continue;
                for (int i2 = k - 1; i2 < l; ++i2) {
                    aqz block = aqz.s[this.a(k1, i2, l1)];
                    if (block == null) continue;
                    block.a(this, k1, i2, l1, par1AxisAlignedBB, this.M, null);
                }
            }
        }
        return this.M;
    }

    public int a(float par1) {
        float f1 = this.c(par1);
        float f2 = 1.0f - (ls.b(f1 * (float)Math.PI * 2.0f) * 2.0f + 0.5f);
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        f2 = 1.0f - f2;
        f2 = (float)((double)f2 * (1.0 - (double)(this.i(par1) * 5.0f) / 16.0));
        f2 = (float)((double)f2 * (1.0 - (double)(this.h(par1) * 5.0f) / 16.0));
        f2 = 1.0f - f2;
        return (int)(f2 * 11.0f);
    }

    @SideOnly(value=Side.CLIENT)
    public void b(acb par1IWorldAccess) {
        this.u.remove(par1IWorldAccess);
    }

    @SideOnly(value=Side.CLIENT)
    public float b(float par1) {
        float f1 = this.c(par1);
        float f2 = 1.0f - (ls.b(f1 * (float)Math.PI * 2.0f) * 2.0f + 0.2f);
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        f2 = 1.0f - f2;
        f2 = (float)((double)f2 * (1.0 - (double)(this.i(par1) * 5.0f) / 16.0));
        f2 = (float)((double)f2 * (1.0 - (double)(this.h(par1) * 5.0f) / 16.0));
        return f2 * 0.8f + 0.2f;
    }

    @SideOnly(value=Side.CLIENT)
    public atc a(nn par1Entity, float par2) {
        return this.t.getSkyColor(par1Entity, par2);
    }

    @SideOnly(value=Side.CLIENT)
    public atc getSkyColorBody(nn par1Entity, float par2) {
        float f9;
        float f8;
        float f1 = this.c(par2);
        float f2 = ls.b(f1 * (float)Math.PI * 2.0f) * 2.0f + 0.5f;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        int i = ls.c(par1Entity.u);
        int j2 = ls.c(par1Entity.w);
        int multiplier = ForgeHooksClient.getSkyBlendColour((abw)this, (int)i, (int)j2);
        float f4 = (float)(multiplier >> 16 & 0xFF) / 255.0f;
        float f5 = (float)(multiplier >> 8 & 0xFF) / 255.0f;
        float f6 = (float)(multiplier & 0xFF) / 255.0f;
        f4 *= f2;
        f5 *= f2;
        f6 *= f2;
        float f7 = this.i(par2);
        if (f7 > 0.0f) {
            f8 = (f4 * 0.3f + f5 * 0.59f + f6 * 0.11f) * 0.6f;
            f9 = 1.0f - f7 * 0.75f;
            f4 = f4 * f9 + f8 * (1.0f - f9);
            f5 = f5 * f9 + f8 * (1.0f - f9);
            f6 = f6 * f9 + f8 * (1.0f - f9);
        }
        if ((f8 = this.h(par2)) > 0.0f) {
            f9 = (f4 * 0.3f + f5 * 0.59f + f6 * 0.11f) * 0.2f;
            float f10 = 1.0f - f8 * 0.75f;
            f4 = f4 * f10 + f9 * (1.0f - f10);
            f5 = f5 * f10 + f9 * (1.0f - f10);
            f6 = f6 * f10 + f9 * (1.0f - f10);
        }
        if (this.q > 0) {
            f9 = (float)this.q - par2;
            if (f9 > 1.0f) {
                f9 = 1.0f;
            }
            f4 = f4 * (1.0f - (f9 *= 0.45f)) + 0.8f * f9;
            f5 = f5 * (1.0f - f9) + 0.8f * f9;
            f6 = f6 * (1.0f - f9) + 1.0f * f9;
        }
        return this.V().a((double)f4, (double)f5, (double)f6);
    }

    public float c(float par1) {
        return this.t.a(this.x.g(), par1);
    }

    @SideOnly(value=Side.CLIENT)
    public int w() {
        return this.t.a(this.x.g());
    }

    public float x() {
        return aei.a[this.t.a(this.x.g())];
    }

    public float d(float par1) {
        float f1 = this.c(par1);
        return f1 * (float)Math.PI * 2.0f;
    }

    @SideOnly(value=Side.CLIENT)
    public atc e(float par1) {
        return this.t.drawClouds(par1);
    }

    @SideOnly(value=Side.CLIENT)
    public atc drawCloudsBody(float par1) {
        float f8;
        float f7;
        float f1 = this.c(par1);
        float f2 = ls.b(f1 * (float)Math.PI * 2.0f) * 2.0f + 0.5f;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        float f3 = (float)(this.c >> 16 & 0xFFL) / 255.0f;
        float f4 = (float)(this.c >> 8 & 0xFFL) / 255.0f;
        float f5 = (float)(this.c & 0xFFL) / 255.0f;
        float f6 = this.i(par1);
        if (f6 > 0.0f) {
            f7 = (f3 * 0.3f + f4 * 0.59f + f5 * 0.11f) * 0.6f;
            f8 = 1.0f - f6 * 0.95f;
            f3 = f3 * f8 + f7 * (1.0f - f8);
            f4 = f4 * f8 + f7 * (1.0f - f8);
            f5 = f5 * f8 + f7 * (1.0f - f8);
        }
        f3 *= f2 * 0.9f + 0.1f;
        f4 *= f2 * 0.9f + 0.1f;
        f5 *= f2 * 0.85f + 0.15f;
        f7 = this.h(par1);
        if (f7 > 0.0f) {
            f8 = (f3 * 0.3f + f4 * 0.59f + f5 * 0.11f) * 0.2f;
            float f9 = 1.0f - f7 * 0.95f;
            f3 = f3 * f9 + f8 * (1.0f - f9);
            f4 = f4 * f9 + f8 * (1.0f - f9);
            f5 = f5 * f9 + f8 * (1.0f - f9);
        }
        return this.V().a((double)f3, (double)f4, (double)f5);
    }

    @SideOnly(value=Side.CLIENT)
    public atc f(float par1) {
        float f1 = this.c(par1);
        return this.t.b(f1, par1);
    }

    public int h(int par1, int par2) {
        return this.d(par1, par2).d(par1 & 0xF, par2 & 0xF);
    }

    public int i(int par1, int par2) {
        adr chunk = this.d(par1, par2);
        int x2 = par1;
        int z2 = par2;
        par1 &= 0xF;
        par2 &= 0xF;
        for (int k = chunk.h() + 15; k > 0; --k) {
            int l = chunk.a(par1, k, par2);
            if (l == 0 || !aqz.s[l].cU.c() || aqz.s[l].cU == akc.j || aqz.s[l].isBlockFoliage(this, x2, k, z2)) continue;
            return k + 1;
        }
        return -1;
    }

    @SideOnly(value=Side.CLIENT)
    public float g(float par1) {
        return this.t.getStarBrightness(par1);
    }

    @SideOnly(value=Side.CLIENT)
    public float getStarBrightnessBody(float par1) {
        float f1 = this.c(par1);
        float f2 = 1.0f - (ls.b(f1 * (float)Math.PI * 2.0f) * 2.0f + 0.25f);
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        return f2 * f2 * 0.5f;
    }

    public void a(int par1, int par2, int par3, int par4, int par5) {
    }

    public void a(int par1, int par2, int par3, int par4, int par5, int par6) {
    }

    public void b(int par1, int par2, int par3, int par4, int par5, int par6) {
    }

    public void h() {
        int k;
        m crashreportcategory;
        b crashreport;
        nn entity;
        int i;
        this.C.a("entities");
        this.C.a("global");
        for (i = 0; i < this.i.size(); ++i) {
            entity = (nn)this.i.get(i);
            try {
                ++entity.ac;
                entity.l_();
            }
            catch (Throwable throwable) {
                crashreport = b.a(throwable, "Ticking entity");
                crashreportcategory = crashreport.a("Entity being ticked");
                if (entity == null) {
                    crashreportcategory.a("Entity", "~~NULL~~");
                } else {
                    entity.a(crashreportcategory);
                }
                if (ForgeDummyContainer.removeErroringEntities) {
                    FMLLog.severe((String)crashreport.e(), (Object[])new Object[0]);
                    this.e(entity);
                }
                throw new u(crashreport);
            }
            if (!entity.M) continue;
            this.i.remove(i--);
        }
        this.C.c("remove");
        this.e.removeAll(this.f);
        for (i = 0; i < this.f.size(); ++i) {
            entity = (nn)this.f.get(i);
            int j2 = entity.aj;
            k = entity.al;
            if (!entity.ai || !this.c(j2, k)) continue;
            this.e(j2, k).b(entity);
        }
        for (i = 0; i < this.f.size(); ++i) {
            this.b((nn)this.f.get(i));
        }
        this.f.clear();
        this.C.c("regular");
        for (i = 0; i < this.e.size(); ++i) {
            entity = (nn)this.e.get(i);
            if (entity.o != null) {
                if (!entity.o.M && entity.o.n == entity) continue;
                entity.o.n = null;
                entity.o = null;
            }
            this.C.a("tick");
            if (!entity.M) {
                try {
                    this.g(entity);
                }
                catch (Throwable throwable1) {
                    crashreport = b.a(throwable1, "Ticking entity");
                    crashreportcategory = crashreport.a("Entity being ticked");
                    entity.a(crashreportcategory);
                    if (ForgeDummyContainer.removeErroringEntities) {
                        FMLLog.severe((String)crashreport.e(), (Object[])new Object[0]);
                        this.e(entity);
                    }
                    throw new u(crashreport);
                }
            }
            this.C.b();
            this.C.a("remove");
            if (entity.M) {
                int j3 = entity.aj;
                k = entity.al;
                if (entity.ai && this.c(j3, k)) {
                    this.e(j3, k).b(entity);
                }
                this.e.remove(i--);
                this.b(entity);
            }
            this.C.b();
        }
        this.C.c("tileEntities");
        this.N = true;
        Iterator iterator = this.g.iterator();
        while (iterator.hasNext()) {
            adr chunk;
            asp tileentity = (asp)iterator.next();
            if (!tileentity.r() && tileentity.o() && this.f(tileentity.l, tileentity.m, tileentity.n)) {
                try {
                    tileentity.h();
                }
                catch (Throwable throwable2) {
                    crashreport = b.a(throwable2, "Ticking tile entity");
                    crashreportcategory = crashreport.a("Tile entity being ticked");
                    tileentity.a(crashreportcategory);
                    if (ForgeDummyContainer.removeErroringTileEntities) {
                        FMLLog.severe((String)crashreport.e(), (Object[])new Object[0]);
                        tileentity.w_();
                        this.i(tileentity.l, tileentity.m, tileentity.n);
                    }
                    throw new u(crashreport);
                }
            }
            if (!tileentity.r()) continue;
            iterator.remove();
            if (!this.c(tileentity.l >> 4, tileentity.n >> 4) || (chunk = this.e(tileentity.l >> 4, tileentity.n >> 4)) == null) continue;
            chunk.cleanChunkBlockTileEntity(tileentity.l & 0xF, tileentity.m, tileentity.n & 0xF);
        }
        if (!this.b.isEmpty()) {
            for (Object tile : this.b) {
                ((asp)tile).onChunkUnload();
            }
            this.g.removeAll(this.b);
            this.b.clear();
        }
        this.N = false;
        this.C.c("pendingTileEntities");
        if (!this.a.isEmpty()) {
            for (int l = 0; l < this.a.size(); ++l) {
                adr chunk1;
                asp tileentity1 = (asp)this.a.get(l);
                if (!tileentity1.r()) {
                    if (this.g.contains(tileentity1)) continue;
                    this.g.add(tileentity1);
                    continue;
                }
                if (!this.c(tileentity1.l >> 4, tileentity1.n >> 4) || (chunk1 = this.e(tileentity1.l >> 4, tileentity1.n >> 4)) == null) continue;
                chunk1.cleanChunkBlockTileEntity(tileentity1.l & 0xF, tileentity1.m, tileentity1.n & 0xF);
            }
            this.a.clear();
        }
        this.C.b();
        this.C.b();
    }

    public void a(Collection par1Collection) {
        List dest = this.N ? this.a : this.g;
        for (Object entity : par1Collection) {
            if (!((asp)entity).canUpdate()) continue;
            dest.add(entity);
        }
    }

    public void g(nn par1Entity) {
        this.a(par1Entity, true);
    }

    public void a(nn par1Entity, boolean par2) {
        boolean canUpdate;
        int i = ls.c(par1Entity.u);
        int j2 = ls.c(par1Entity.w);
        boolean isForced = this.getPersistentChunks().containsKey((Object)new abp(i >> 4, j2 >> 4));
        int b0 = isForced ? 0 : 32;
        boolean bl2 = canUpdate = !par2 || this.e(i - b0, 0, j2 - b0, i + b0, 0, j2 + b0);
        if (!canUpdate) {
            EntityEvent.CanUpdate event = new EntityEvent.CanUpdate(par1Entity);
            MinecraftForge.EVENT_BUS.post((Event)event);
            canUpdate = event.canUpdate;
        }
        if (canUpdate) {
            par1Entity.U = par1Entity.u;
            par1Entity.V = par1Entity.v;
            par1Entity.W = par1Entity.w;
            par1Entity.C = par1Entity.A;
            par1Entity.D = par1Entity.B;
            if (par2 && par1Entity.ai) {
                ++par1Entity.ac;
                if (par1Entity.o != null) {
                    par1Entity.V();
                } else {
                    par1Entity.l_();
                }
            }
            this.C.a("chunkCheck");
            if (Double.isNaN(par1Entity.u) || Double.isInfinite(par1Entity.u)) {
                par1Entity.u = par1Entity.U;
            }
            if (Double.isNaN(par1Entity.v) || Double.isInfinite(par1Entity.v)) {
                par1Entity.v = par1Entity.V;
            }
            if (Double.isNaN(par1Entity.w) || Double.isInfinite(par1Entity.w)) {
                par1Entity.w = par1Entity.W;
            }
            if (Double.isNaN(par1Entity.B) || Double.isInfinite(par1Entity.B)) {
                par1Entity.B = par1Entity.D;
            }
            if (Double.isNaN(par1Entity.A) || Double.isInfinite(par1Entity.A)) {
                par1Entity.A = par1Entity.C;
            }
            int k = ls.c(par1Entity.u / 16.0);
            int l = ls.c(par1Entity.v / 16.0);
            int i1 = ls.c(par1Entity.w / 16.0);
            if (!par1Entity.ai || par1Entity.aj != k || par1Entity.ak != l || par1Entity.al != i1) {
                if (par1Entity.ai && this.c(par1Entity.aj, par1Entity.al)) {
                    this.e(par1Entity.aj, par1Entity.al).a(par1Entity, par1Entity.ak);
                }
                if (this.c(k, i1)) {
                    par1Entity.ai = true;
                    this.e(k, i1).a(par1Entity);
                } else {
                    par1Entity.ai = false;
                }
            }
            this.C.b();
            if (par2 && par1Entity.ai && par1Entity.n != null) {
                if (!par1Entity.n.M && par1Entity.n.o == par1Entity) {
                    this.g(par1Entity.n);
                } else {
                    par1Entity.n.o = null;
                    par1Entity.n = null;
                }
            }
        }
    }

    public boolean b(asx par1AxisAlignedBB) {
        return this.a(par1AxisAlignedBB, (nn)null);
    }

    public boolean a(asx par1AxisAlignedBB, nn par2Entity) {
        List list = this.b((nn)null, par1AxisAlignedBB);
        for (int i = 0; i < list.size(); ++i) {
            nn entity1 = (nn)list.get(i);
            if (entity1.M || !entity1.m || entity1 == par2Entity) continue;
            return false;
        }
        return true;
    }

    public boolean c(asx par1AxisAlignedBB) {
        int i = ls.c(par1AxisAlignedBB.a);
        int j2 = ls.c(par1AxisAlignedBB.d + 1.0);
        int k = ls.c(par1AxisAlignedBB.b);
        int l = ls.c(par1AxisAlignedBB.e + 1.0);
        int i1 = ls.c(par1AxisAlignedBB.c);
        int j1 = ls.c(par1AxisAlignedBB.f + 1.0);
        if (par1AxisAlignedBB.a < 0.0) {
            --i;
        }
        if (par1AxisAlignedBB.b < 0.0) {
            --k;
        }
        if (par1AxisAlignedBB.c < 0.0) {
            --i1;
        }
        for (int k1 = i; k1 < j2; ++k1) {
            for (int l1 = k; l1 < l; ++l1) {
                for (int i2 = i1; i2 < j1; ++i2) {
                    aqz block = aqz.s[this.a(k1, l1, i2)];
                    if (block == null) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean d(asx par1AxisAlignedBB) {
        int i = ls.c(par1AxisAlignedBB.a);
        int j2 = ls.c(par1AxisAlignedBB.d + 1.0);
        int k = ls.c(par1AxisAlignedBB.b);
        int l = ls.c(par1AxisAlignedBB.e + 1.0);
        int i1 = ls.c(par1AxisAlignedBB.c);
        int j1 = ls.c(par1AxisAlignedBB.f + 1.0);
        if (par1AxisAlignedBB.a < 0.0) {
            --i;
        }
        if (par1AxisAlignedBB.b < 0.0) {
            --k;
        }
        if (par1AxisAlignedBB.c < 0.0) {
            --i1;
        }
        for (int k1 = i; k1 < j2; ++k1) {
            for (int l1 = k; l1 < l; ++l1) {
                for (int i2 = i1; i2 < j1; ++i2) {
                    aqz block = aqz.s[this.a(k1, l1, i2)];
                    if (block == null || !block.cU.d()) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean e(asx par1AxisAlignedBB) {
        int j1;
        int i = ls.c(par1AxisAlignedBB.a);
        int j2 = ls.c(par1AxisAlignedBB.d + 1.0);
        int k = ls.c(par1AxisAlignedBB.b);
        int l = ls.c(par1AxisAlignedBB.e + 1.0);
        int i1 = ls.c(par1AxisAlignedBB.c);
        if (this.e(i, k, i1, j2, l, j1 = ls.c(par1AxisAlignedBB.f + 1.0))) {
            for (int k1 = i; k1 < j2; ++k1) {
                for (int l1 = k; l1 < l; ++l1) {
                    for (int i2 = i1; i2 < j1; ++i2) {
                        int j22 = this.a(k1, l1, i2);
                        if (j22 == aqz.aw.cF || j22 == aqz.H.cF || j22 == aqz.I.cF) {
                            return true;
                        }
                        aqz block = aqz.s[j22];
                        if (block == null || !block.isBlockBurning(this, k1, l1, i2)) continue;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean a(asx par1AxisAlignedBB, akc par2Material, nn par3Entity) {
        int j1;
        int i = ls.c(par1AxisAlignedBB.a);
        int j2 = ls.c(par1AxisAlignedBB.d + 1.0);
        int k = ls.c(par1AxisAlignedBB.b);
        int l = ls.c(par1AxisAlignedBB.e + 1.0);
        int i1 = ls.c(par1AxisAlignedBB.c);
        if (!this.e(i, k, i1, j2, l, j1 = ls.c(par1AxisAlignedBB.f + 1.0))) {
            return false;
        }
        boolean flag = false;
        atc vec3 = this.V().a(0.0, 0.0, 0.0);
        for (int k1 = i; k1 < j2; ++k1) {
            for (int l1 = k; l1 < l; ++l1) {
                for (int i2 = i1; i2 < j1; ++i2) {
                    double d0;
                    aqz block = aqz.s[this.a(k1, l1, i2)];
                    if (block == null || block.cU != par2Material || !((double)l >= (d0 = (double)((float)(l1 + 1) - apc.d(this.h(k1, l1, i2)))))) continue;
                    flag = true;
                    block.a(this, k1, l1, i2, par3Entity, vec3);
                }
            }
        }
        if (vec3.b() > 0.0 && par3Entity.ax()) {
            vec3 = vec3.a();
            double d1 = 0.014;
            par3Entity.x += vec3.c * d1;
            par3Entity.y += vec3.d * d1;
            par3Entity.z += vec3.e * d1;
        }
        return flag;
    }

    public boolean a(asx par1AxisAlignedBB, akc par2Material) {
        int i = ls.c(par1AxisAlignedBB.a);
        int j2 = ls.c(par1AxisAlignedBB.d + 1.0);
        int k = ls.c(par1AxisAlignedBB.b);
        int l = ls.c(par1AxisAlignedBB.e + 1.0);
        int i1 = ls.c(par1AxisAlignedBB.c);
        int j1 = ls.c(par1AxisAlignedBB.f + 1.0);
        for (int k1 = i; k1 < j2; ++k1) {
            for (int l1 = k; l1 < l; ++l1) {
                for (int i2 = i1; i2 < j1; ++i2) {
                    aqz block = aqz.s[this.a(k1, l1, i2)];
                    if (block == null || block.cU != par2Material) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean b(asx par1AxisAlignedBB, akc par2Material) {
        int i = ls.c(par1AxisAlignedBB.a);
        int j2 = ls.c(par1AxisAlignedBB.d + 1.0);
        int k = ls.c(par1AxisAlignedBB.b);
        int l = ls.c(par1AxisAlignedBB.e + 1.0);
        int i1 = ls.c(par1AxisAlignedBB.c);
        int j1 = ls.c(par1AxisAlignedBB.f + 1.0);
        for (int k1 = i; k1 < j2; ++k1) {
            for (int l1 = k; l1 < l; ++l1) {
                for (int i2 = i1; i2 < j1; ++i2) {
                    aqz block = aqz.s[this.a(k1, l1, i2)];
                    if (block == null || block.cU != par2Material) continue;
                    int j22 = this.h(k1, l1, i2);
                    double d0 = l1 + 1;
                    if (j22 < 8) {
                        d0 = (double)(l1 + 1) - (double)j22 / 8.0;
                    }
                    if (!(d0 >= par1AxisAlignedBB.b)) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public abr a(nn par1Entity, double par2, double par4, double par6, float par8, boolean par9) {
        return this.a(par1Entity, par2, par4, par6, par8, false, par9);
    }

    public abr a(nn par1Entity, double par2, double par4, double par6, float par8, boolean par9, boolean par10) {
        abr explosion = new abr(this, par1Entity, par2, par4, par6, par8);
        explosion.a = par9;
        explosion.b = par10;
        explosion.a();
        explosion.a(true);
        return explosion;
    }

    public float a(atc par1Vec3, asx par2AxisAlignedBB) {
        double d0 = 1.0 / ((par2AxisAlignedBB.d - par2AxisAlignedBB.a) * 2.0 + 1.0);
        double d1 = 1.0 / ((par2AxisAlignedBB.e - par2AxisAlignedBB.b) * 2.0 + 1.0);
        double d2 = 1.0 / ((par2AxisAlignedBB.f - par2AxisAlignedBB.c) * 2.0 + 1.0);
        int i = 0;
        int j2 = 0;
        float f = 0.0f;
        while (f <= 1.0f) {
            float f1 = 0.0f;
            while (f1 <= 1.0f) {
                float f2 = 0.0f;
                while (f2 <= 1.0f) {
                    double d3 = par2AxisAlignedBB.a + (par2AxisAlignedBB.d - par2AxisAlignedBB.a) * (double)f;
                    double d4 = par2AxisAlignedBB.b + (par2AxisAlignedBB.e - par2AxisAlignedBB.b) * (double)f1;
                    double d5 = par2AxisAlignedBB.c + (par2AxisAlignedBB.f - par2AxisAlignedBB.c) * (double)f2;
                    if (this.a(this.V().a(d3, d4, d5), par1Vec3) == null) {
                        ++i;
                    }
                    ++j2;
                    f2 = (float)((double)f2 + d2);
                }
                f1 = (float)((double)f1 + d1);
            }
            f = (float)((double)f + d0);
        }
        return (float)i / (float)j2;
    }

    public boolean a(uf par1EntityPlayer, int par2, int par3, int par4, int par5) {
        if (par5 == 0) {
            --par3;
        }
        if (par5 == 1) {
            ++par3;
        }
        if (par5 == 2) {
            --par4;
        }
        if (par5 == 3) {
            ++par4;
        }
        if (par5 == 4) {
            --par2;
        }
        if (par5 == 5) {
            ++par2;
        }
        if (this.a(par2, par3, par4) == aqz.aw.cF) {
            this.a(par1EntityPlayer, 1004, par2, par3, par4, 0);
            this.i(par2, par3, par4);
            return true;
        }
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public String y() {
        return "All: " + this.e.size();
    }

    @SideOnly(value=Side.CLIENT)
    public String z() {
        return this.v.e();
    }

    public asp r(int par1, int par2, int par3) {
        if (par2 >= 0 && par2 < 256) {
            adr chunk;
            asp tileentity1;
            int l;
            asp tileentity = null;
            if (this.N) {
                for (l = 0; l < this.a.size(); ++l) {
                    tileentity1 = (asp)this.a.get(l);
                    if (tileentity1.r() || tileentity1.l != par1 || tileentity1.m != par2 || tileentity1.n != par3) continue;
                    tileentity = tileentity1;
                    break;
                }
            }
            if (tileentity == null && (chunk = this.e(par1 >> 4, par3 >> 4)) != null) {
                tileentity = chunk.e(par1 & 0xF, par2, par3 & 0xF);
            }
            if (tileentity == null) {
                for (l = 0; l < this.a.size(); ++l) {
                    tileentity1 = (asp)this.a.get(l);
                    if (tileentity1.r() || tileentity1.l != par1 || tileentity1.m != par2 || tileentity1.n != par3) continue;
                    tileentity = tileentity1;
                    break;
                }
            }
            return tileentity;
        }
        return null;
    }

    public void a(int par1, int par2, int par3, asp par4TileEntity) {
        adr chunk;
        if (par4TileEntity == null || par4TileEntity.r()) {
            return;
        }
        if (par4TileEntity.canUpdate()) {
            if (this.N) {
                Iterator iterator = this.a.iterator();
                while (iterator.hasNext()) {
                    asp tileentity1 = (asp)iterator.next();
                    if (tileentity1.l != par1 || tileentity1.m != par2 || tileentity1.n != par3) continue;
                    tileentity1.w_();
                    iterator.remove();
                }
                this.a.add(par4TileEntity);
            } else {
                this.g.add(par4TileEntity);
            }
        }
        if ((chunk = this.e(par1 >> 4, par3 >> 4)) != null) {
            chunk.a(par1 & 0xF, par2, par3 & 0xF, par4TileEntity);
        }
        this.m(par1, par2, par3, 0);
    }

    public void s(int par1, int par2, int par3) {
        adr chunk = this.e(par1 >> 4, par3 >> 4);
        if (chunk != null) {
            chunk.f(par1 & 0xF, par2, par3 & 0xF);
        }
        this.m(par1, par2, par3, 0);
    }

    public void a(asp par1TileEntity) {
        this.b.add(par1TileEntity);
    }

    public boolean t(int par1, int par2, int par3) {
        aqz block = aqz.s[this.a(par1, par2, par3)];
        return block == null ? false : block.c();
    }

    public boolean u(int par1, int par2, int par3) {
        aqz block = aqz.s[this.a(par1, par2, par3)];
        return block != null && block.isBlockNormalCube(this, par1, par2, par3);
    }

    public boolean v(int par1, int par2, int par3) {
        int l = this.a(par1, par2, par3);
        if (l != 0 && aqz.s[l] != null) {
            asx axisalignedbb = aqz.s[l].b(this, par1, par2, par3);
            return axisalignedbb != null && axisalignedbb.b() >= 1.0;
        }
        return false;
    }

    public boolean w(int par1, int par2, int par3) {
        return this.isBlockSolidOnSide(par1, par2, par3, ForgeDirection.UP);
    }

    @Deprecated
    public boolean a(aqz par1Block, int par2) {
        return par1Block == null ? false : (par1Block.cU.k() && par1Block.b() ? true : (par1Block instanceof aqp ? (par2 & 4) == 4 : (par1Block instanceof aop ? (par2 & 8) == 8 : (par1Block instanceof aot ? true : (par1Block instanceof arf ? (par2 & 7) == 7 : false)))));
    }

    public boolean c(int par1, int par2, int par3, boolean par4) {
        if (par1 >= -30000000 && par3 >= -30000000 && par1 < 30000000 && par3 < 30000000) {
            adr chunk = this.v.d(par1 >> 4, par3 >> 4);
            if (chunk != null && !chunk.g()) {
                aqz block = aqz.s[this.a(par1, par2, par3)];
                return block == null ? false : this.u(par1, par2, par3);
            }
            return par4;
        }
        return par4;
    }

    public void A() {
        int i = this.a(1.0f);
        if (i != this.j) {
            this.j = i;
        }
    }

    public void a(boolean par1, boolean par2) {
        this.t.setAllowedSpawnTypes(par1, par2);
    }

    public void b() {
        this.o();
    }

    private void a() {
        this.t.calculateInitialWeather();
    }

    public void calculateInitialWeatherBody() {
        if (this.x.p()) {
            this.n = 1.0f;
            if (this.x.n()) {
                this.p = 1.0f;
            }
        }
    }

    protected void o() {
        this.t.updateWeather();
    }

    public void updateWeatherBody() {
        if (!this.t.g) {
            int i = this.x.o();
            if (i <= 0) {
                if (this.x.n()) {
                    this.x.f(this.s.nextInt(12000) + 3600);
                } else {
                    this.x.f(this.s.nextInt(168000) + 12000);
                }
            } else {
                this.x.f(--i);
                if (i <= 0) {
                    this.x.a(!this.x.n());
                }
            }
            int j2 = this.x.q();
            if (j2 <= 0) {
                if (this.x.p()) {
                    this.x.g(this.s.nextInt(12000) + 12000);
                } else {
                    this.x.g(this.s.nextInt(168000) + 12000);
                }
            } else {
                this.x.g(--j2);
                if (j2 <= 0) {
                    this.x.b(!this.x.p());
                }
            }
            this.m = this.n;
            this.n = this.x.p() ? (float)((double)this.n + 0.01) : (float)((double)this.n - 0.01);
            if (this.n < 0.0f) {
                this.n = 0.0f;
            }
            if (this.n > 1.0f) {
                this.n = 1.0f;
            }
            this.o = this.p;
            this.p = this.x.n() ? (float)((double)this.p + 0.01) : (float)((double)this.p - 0.01);
            if (this.p < 0.0f) {
                this.p = 0.0f;
            }
            if (this.p > 1.0f) {
                this.p = 1.0f;
            }
        }
    }

    public void B() {
        this.t.toggleRain();
    }

    protected void C() {
        int k;
        int j2;
        uf entityplayer;
        int i;
        this.G.clear();
        this.G.addAll(this.getPersistentChunks().keySet());
        this.C.a("buildList");
        for (i = 0; i < this.h.size(); ++i) {
            entityplayer = (uf)this.h.get(i);
            j2 = ls.c(entityplayer.u / 16.0);
            k = ls.c(entityplayer.w / 16.0);
            int b0 = 7;
            for (int l = -b0; l <= b0; ++l) {
                for (int i1 = -b0; i1 <= b0; ++i1) {
                    this.G.add(new abp(l + j2, i1 + k));
                }
            }
        }
        this.C.b();
        if (this.O > 0) {
            --this.O;
        }
        this.C.a("playerCheckLight");
        if (!this.h.isEmpty()) {
            i = this.s.nextInt(this.h.size());
            entityplayer = (uf)this.h.get(i);
            j2 = ls.c(entityplayer.u) + this.s.nextInt(11) - 5;
            k = ls.c(entityplayer.v) + this.s.nextInt(11) - 5;
            int j1 = ls.c(entityplayer.w) + this.s.nextInt(11) - 5;
            this.A(j2, k, j1);
        }
        this.C.b();
    }

    protected void a(int par1, int par2, adr par3Chunk) {
        this.C.c("moodSound");
        if (this.O == 0 && !this.I) {
            uf entityplayer;
            this.k = this.k * 3 + 1013904223;
            int k = this.k >> 2;
            int l = k & 0xF;
            int i1 = k >> 8 & 0xF;
            int j1 = k >> 16 & 0x7F;
            int k1 = par3Chunk.a(l, j1, i1);
            if (k1 == 0 && this.m(l += par1, j1, i1 += par2) <= this.s.nextInt(8) && this.b(ach.a, l, j1, i1) <= 0 && (entityplayer = this.a((double)l + 0.5, (double)j1 + 0.5, (double)i1 + 0.5, 8.0)) != null && entityplayer.e((double)l + 0.5, (double)j1 + 0.5, (double)i1 + 0.5) > 4.0) {
                this.a((double)l + 0.5, (double)j1 + 0.5, (double)i1 + 0.5, "ambient.cave.cave", 0.7f, 0.8f + this.s.nextFloat() * 0.2f);
                this.O = this.s.nextInt(12000) + 6000;
            }
        }
        this.C.c("checkLight");
        par3Chunk.o();
    }

    protected void g() {
        this.C();
    }

    public boolean x(int par1, int par2, int par3) {
        return this.d(par1, par2, par3, false);
    }

    public boolean y(int par1, int par2, int par3) {
        return this.d(par1, par2, par3, true);
    }

    public boolean d(int par1, int par2, int par3, boolean par4) {
        return this.t.canBlockFreeze(par1, par2, par3, par4);
    }

    public boolean canBlockFreezeBody(int par1, int par2, int par3, boolean par4) {
        int l;
        acq biomegenbase = this.a(par1, par3);
        float f = biomegenbase.j();
        if (f > 0.15f) {
            return false;
        }
        if (par2 >= 0 && par2 < 256 && this.b(ach.b, par1, par2, par3) < 10 && ((l = this.a(par1, par2, par3)) == aqz.G.cF || l == aqz.F.cF) && this.h(par1, par2, par3) == 0) {
            if (!par4) {
                return true;
            }
            boolean flag1 = true;
            if (flag1 && this.g(par1 - 1, par2, par3) != akc.h) {
                flag1 = false;
            }
            if (flag1 && this.g(par1 + 1, par2, par3) != akc.h) {
                flag1 = false;
            }
            if (flag1 && this.g(par1, par2, par3 - 1) != akc.h) {
                flag1 = false;
            }
            if (flag1 && this.g(par1, par2, par3 + 1) != akc.h) {
                flag1 = false;
            }
            if (!flag1) {
                return true;
            }
        }
        return false;
    }

    public boolean z(int par1, int par2, int par3) {
        return this.t.canSnowAt(par1, par2, par3);
    }

    public boolean canSnowAtBody(int par1, int par2, int par3) {
        acq biomegenbase = this.a(par1, par3);
        float f = biomegenbase.j();
        if (f > 0.15f) {
            return false;
        }
        if (par2 >= 0 && par2 < 256 && this.b(ach.b, par1, par2, par3) < 10) {
            int l = this.a(par1, par2 - 1, par3);
            int i1 = this.a(par1, par2, par3);
            if (i1 == 0 && aqz.aX.c(this, par1, par2, par3) && l != 0 && l != aqz.aY.cF && aqz.s[l].cU.c()) {
                return true;
            }
        }
        return false;
    }

    public void A(int par1, int par2, int par3) {
        if (!this.t.g) {
            this.c(ach.a, par1, par2, par3);
        }
        this.c(ach.b, par1, par2, par3);
    }

    private int a(int par1, int par2, int par3, ach par4EnumSkyBlock) {
        int j1;
        if (par4EnumSkyBlock == ach.a && this.l(par1, par2, par3)) {
            return 15;
        }
        int l = this.a(par1, par2, par3);
        aqz block = aqz.s[l];
        int blockLight = block == null ? 0 : block.getLightValue(this, par1, par2, par3);
        int i1 = par4EnumSkyBlock == ach.a ? 0 : blockLight;
        int n = j1 = block == null ? 0 : block.getLightOpacity(this, par1, par2, par3);
        if (j1 >= 15 && blockLight > 0) {
            j1 = 1;
        }
        if (j1 < 1) {
            j1 = 1;
        }
        if (j1 >= 15) {
            return 0;
        }
        if (i1 >= 14) {
            return i1;
        }
        for (int k1 = 0; k1 < 6; ++k1) {
            int l1 = par1 + s.b[k1];
            int i2 = par2 + s.c[k1];
            int j2 = par3 + s.d[k1];
            int k2 = this.b(par4EnumSkyBlock, l1, i2, j2) - j1;
            if (k2 > i1) {
                i1 = k2;
            }
            if (i1 < 14) continue;
            return i1;
        }
        return i1;
    }

    public void c(ach par1EnumSkyBlock, int par2, int par3, int par4) {
        if (this.b(par2, par3, par4, 17)) {
            int k3;
            int l3;
            int j3;
            int i3;
            int l2;
            int k2;
            int j2;
            int i2;
            int l1;
            int l = 0;
            int i1 = 0;
            this.C.a("getBrightness");
            int j1 = this.b(par1EnumSkyBlock, par2, par3, par4);
            int k1 = this.a(par2, par3, par4, par1EnumSkyBlock);
            if (k1 > j1) {
                this.H[i1++] = 133152;
            } else if (k1 < j1) {
                this.H[i1++] = 0x20820 | j1 << 18;
                while (l < i1) {
                    l1 = this.H[l++];
                    i2 = (l1 & 0x3F) - 32 + par2;
                    j2 = (l1 >> 6 & 0x3F) - 32 + par3;
                    k2 = (l1 >> 12 & 0x3F) - 32 + par4;
                    l2 = l1 >> 18 & 0xF;
                    i3 = this.b(par1EnumSkyBlock, i2, j2, k2);
                    if (i3 != l2) continue;
                    this.b(par1EnumSkyBlock, i2, j2, k2, 0);
                    if (l2 <= 0 || (j3 = ls.a(i2 - par2)) + (l3 = ls.a(j2 - par3)) + (k3 = ls.a(k2 - par4)) >= 17) continue;
                    for (int i4 = 0; i4 < 6; ++i4) {
                        int j4 = i2 + s.b[i4];
                        int k4 = j2 + s.c[i4];
                        int l4 = k2 + s.d[i4];
                        aqz block = aqz.s[this.a(j4, k4, l4)];
                        int blockOpacity = block == null ? 0 : block.getLightOpacity(this, j4, k4, l4);
                        int i5 = Math.max(1, blockOpacity);
                        i3 = this.b(par1EnumSkyBlock, j4, k4, l4);
                        if (i3 != l2 - i5 || i1 >= this.H.length) continue;
                        this.H[i1++] = j4 - par2 + 32 | k4 - par3 + 32 << 6 | l4 - par4 + 32 << 12 | l2 - i5 << 18;
                    }
                }
                l = 0;
            }
            this.C.b();
            this.C.a("checkedPosition < toCheckCount");
            while (l < i1) {
                boolean flag;
                l1 = this.H[l++];
                i2 = (l1 & 0x3F) - 32 + par2;
                j2 = (l1 >> 6 & 0x3F) - 32 + par3;
                k2 = (l1 >> 12 & 0x3F) - 32 + par4;
                l2 = this.b(par1EnumSkyBlock, i2, j2, k2);
                i3 = this.a(i2, j2, k2, par1EnumSkyBlock);
                if (i3 == l2) continue;
                this.b(par1EnumSkyBlock, i2, j2, k2, i3);
                if (i3 <= l2) continue;
                j3 = Math.abs(i2 - par2);
                l3 = Math.abs(j2 - par3);
                k3 = Math.abs(k2 - par4);
                boolean bl2 = flag = i1 < this.H.length - 6;
                if (j3 + l3 + k3 >= 17 || !flag) continue;
                if (this.b(par1EnumSkyBlock, i2 - 1, j2, k2) < i3) {
                    this.H[i1++] = i2 - 1 - par2 + 32 + (j2 - par3 + 32 << 6) + (k2 - par4 + 32 << 12);
                }
                if (this.b(par1EnumSkyBlock, i2 + 1, j2, k2) < i3) {
                    this.H[i1++] = i2 + 1 - par2 + 32 + (j2 - par3 + 32 << 6) + (k2 - par4 + 32 << 12);
                }
                if (this.b(par1EnumSkyBlock, i2, j2 - 1, k2) < i3) {
                    this.H[i1++] = i2 - par2 + 32 + (j2 - 1 - par3 + 32 << 6) + (k2 - par4 + 32 << 12);
                }
                if (this.b(par1EnumSkyBlock, i2, j2 + 1, k2) < i3) {
                    this.H[i1++] = i2 - par2 + 32 + (j2 + 1 - par3 + 32 << 6) + (k2 - par4 + 32 << 12);
                }
                if (this.b(par1EnumSkyBlock, i2, j2, k2 - 1) < i3) {
                    this.H[i1++] = i2 - par2 + 32 + (j2 - par3 + 32 << 6) + (k2 - 1 - par4 + 32 << 12);
                }
                if (this.b(par1EnumSkyBlock, i2, j2, k2 + 1) >= i3) continue;
                this.H[i1++] = i2 - par2 + 32 + (j2 - par3 + 32 << 6) + (k2 + 1 - par4 + 32 << 12);
            }
            this.C.b();
        }
    }

    public boolean a(boolean par1) {
        return false;
    }

    public List a(adr par1Chunk, boolean par2) {
        return null;
    }

    public List b(nn par1Entity, asx par2AxisAlignedBB) {
        return this.a(par1Entity, par2AxisAlignedBB, (nw)null);
    }

    public List a(nn par1Entity, asx par2AxisAlignedBB, nw par3IEntitySelector) {
        ArrayList arraylist = new ArrayList();
        int i = ls.c((par2AxisAlignedBB.a - MAX_ENTITY_RADIUS) / 16.0);
        int j2 = ls.c((par2AxisAlignedBB.d + MAX_ENTITY_RADIUS) / 16.0);
        int k = ls.c((par2AxisAlignedBB.c - MAX_ENTITY_RADIUS) / 16.0);
        int l = ls.c((par2AxisAlignedBB.f + MAX_ENTITY_RADIUS) / 16.0);
        for (int i1 = i; i1 <= j2; ++i1) {
            for (int j1 = k; j1 <= l; ++j1) {
                if (!this.c(i1, j1)) continue;
                this.e(i1, j1).a(par1Entity, par2AxisAlignedBB, arraylist, par3IEntitySelector);
            }
        }
        return arraylist;
    }

    public List a(Class par1Class, asx par2AxisAlignedBB) {
        return this.a(par1Class, par2AxisAlignedBB, (nw)null);
    }

    public List a(Class par1Class, asx par2AxisAlignedBB, nw par3IEntitySelector) {
        int i = ls.c((par2AxisAlignedBB.a - MAX_ENTITY_RADIUS) / 16.0);
        int j2 = ls.c((par2AxisAlignedBB.d + MAX_ENTITY_RADIUS) / 16.0);
        int k = ls.c((par2AxisAlignedBB.c - MAX_ENTITY_RADIUS) / 16.0);
        int l = ls.c((par2AxisAlignedBB.f + MAX_ENTITY_RADIUS) / 16.0);
        ArrayList arraylist = new ArrayList();
        for (int i1 = i; i1 <= j2; ++i1) {
            for (int j1 = k; j1 <= l; ++j1) {
                if (!this.c(i1, j1)) continue;
                this.e(i1, j1).a(par1Class, par2AxisAlignedBB, arraylist, par3IEntitySelector);
            }
        }
        return arraylist;
    }

    public nn a(Class par1Class, asx par2AxisAlignedBB, nn par3Entity) {
        List list = this.a(par1Class, par2AxisAlignedBB);
        nn entity1 = null;
        double d0 = Double.MAX_VALUE;
        for (int i = 0; i < list.size(); ++i) {
            double d1;
            nn entity2 = (nn)list.get(i);
            if (entity2 == par3Entity || !((d1 = par3Entity.e(entity2)) <= d0)) continue;
            entity1 = entity2;
            d0 = d1;
        }
        return entity1;
    }

    public abstract nn a(int var1);

    @SideOnly(value=Side.CLIENT)
    public List D() {
        return this.e;
    }

    public void b(int par1, int par2, int par3, asp par4TileEntity) {
        if (this.f(par1, par2, par3)) {
            this.d(par1, par3).e();
        }
    }

    public int a(Class par1Class) {
        int i = 0;
        for (int j2 = 0; j2 < this.e.size(); ++j2) {
            nn entity = (nn)this.e.get(j2);
            if (entity instanceof og && ((og)entity).bE() || !par1Class.isAssignableFrom(entity.getClass())) continue;
            ++i;
        }
        return i;
    }

    public void a(List par1List) {
        for (int i = 0; i < par1List.size(); ++i) {
            nn entity = (nn)par1List.get(i);
            if (MinecraftForge.EVENT_BUS.post((Event)new EntityJoinWorldEvent(entity, this))) continue;
            this.e.add(entity);
            this.a(entity);
        }
    }

    public void b(List par1List) {
        this.f.addAll(par1List);
    }

    public boolean a(int par1, int par2, int par3, int par4, boolean par5, int par6, nn par7Entity, ye par8ItemStack) {
        int j1 = this.a(par2, par3, par4);
        aqz block = aqz.s[j1];
        aqz block1 = aqz.s[par1];
        asx axisalignedbb = block1.b(this, par2, par3, par4);
        if (par5) {
            axisalignedbb = null;
        }
        if (axisalignedbb != null && !this.a(axisalignedbb, par7Entity)) {
            return false;
        }
        if (block != null && (block == aqz.F || block == aqz.G || block == aqz.H || block == aqz.I || block == aqz.aw || block.cU.j())) {
            block = null;
        }
        if (block != null && block.isBlockReplaceable(this, par2, par3, par4)) {
            block = null;
        }
        return block != null && block.cU == akc.q && block1 == aqz.cm ? true : par1 > 0 && block == null && block1.a(this, par2, par3, par4, par6, par8ItemStack);
    }

    public alf a(nn par1Entity, nn par2Entity, float par3, boolean par4, boolean par5, boolean par6, boolean par7) {
        this.C.a("pathfind");
        int i = ls.c(par1Entity.u);
        int j2 = ls.c(par1Entity.v + 1.0);
        int k = ls.c(par1Entity.w);
        int l = (int)(par3 + 16.0f);
        int i1 = i - l;
        int j1 = j2 - l;
        int k1 = k - l;
        int l1 = i + l;
        int i2 = j2 + l;
        int j22 = k + l;
        acl chunkcache = new acl(this, i1, j1, k1, l1, i2, j22, 0);
        alf pathentity = new alg((acf)chunkcache, par4, par5, par6, par7).a(par1Entity, par2Entity, par3);
        this.C.b();
        return pathentity;
    }

    public alf a(nn par1Entity, int par2, int par3, int par4, float par5, boolean par6, boolean par7, boolean par8, boolean par9) {
        this.C.a("pathfind");
        int l = ls.c(par1Entity.u);
        int i1 = ls.c(par1Entity.v);
        int j1 = ls.c(par1Entity.w);
        int k1 = (int)(par5 + 8.0f);
        int l1 = l - k1;
        int i2 = i1 - k1;
        int j2 = j1 - k1;
        int k2 = l + k1;
        int l2 = i1 + k1;
        int i3 = j1 + k1;
        acl chunkcache = new acl(this, l1, i2, j2, k2, l2, i3, 0);
        alf pathentity = new alg((acf)chunkcache, par6, par7, par8, par9).a(par1Entity, par2, par3, par4, par5);
        this.C.b();
        return pathentity;
    }

    public int j(int par1, int par2, int par3, int par4) {
        int i1 = this.a(par1, par2, par3);
        return i1 == 0 ? 0 : aqz.s[i1].c((acf)this, par1, par2, par3, par4);
    }

    public int B(int par1, int par2, int par3) {
        int b0 = 0;
        int l = Math.max(b0, this.j(par1, par2 - 1, par3, 0));
        if (l >= 15) {
            return l;
        }
        if ((l = Math.max(l, this.j(par1, par2 + 1, par3, 1))) >= 15) {
            return l;
        }
        if ((l = Math.max(l, this.j(par1, par2, par3 - 1, 2))) >= 15) {
            return l;
        }
        if ((l = Math.max(l, this.j(par1, par2, par3 + 1, 3))) >= 15) {
            return l;
        }
        if ((l = Math.max(l, this.j(par1 - 1, par2, par3, 4))) >= 15) {
            return l;
        }
        return (l = Math.max(l, this.j(par1 + 1, par2, par3, 5))) >= 15 ? l : l;
    }

    public boolean k(int par1, int par2, int par3, int par4) {
        return this.l(par1, par2, par3, par4) > 0;
    }

    public int l(int par1, int par2, int par3, int par4) {
        aqz block = aqz.s[this.a(par1, par2, par3)];
        if (block == null) {
            return 0;
        }
        if (!block.shouldCheckWeakPower(this, par1, par2, par3, par4)) {
            return this.B(par1, par2, par3);
        }
        return block.b((acf)this, par1, par2, par3, par4);
    }

    public boolean C(int par1, int par2, int par3) {
        return this.l(par1, par2 - 1, par3, 0) > 0 ? true : (this.l(par1, par2 + 1, par3, 1) > 0 ? true : (this.l(par1, par2, par3 - 1, 2) > 0 ? true : (this.l(par1, par2, par3 + 1, 3) > 0 ? true : (this.l(par1 - 1, par2, par3, 4) > 0 ? true : this.l(par1 + 1, par2, par3, 5) > 0))));
    }

    public int D(int par1, int par2, int par3) {
        int l = 0;
        for (int i1 = 0; i1 < 6; ++i1) {
            int j1 = this.l(par1 + s.b[i1], par2 + s.c[i1], par3 + s.d[i1], i1);
            if (j1 >= 15) {
                return 15;
            }
            if (j1 <= l) continue;
            l = j1;
        }
        return l;
    }

    public uf a(nn par1Entity, double par2) {
        return this.a(par1Entity.u, par1Entity.v, par1Entity.w, par2);
    }

    public uf a(double par1, double par3, double par5, double par7) {
        double d4 = -1.0;
        uf entityplayer = null;
        for (int i = 0; i < this.h.size(); ++i) {
            uf entityplayer1 = (uf)this.h.get(i);
            double d5 = entityplayer1.e(par1, par3, par5);
            if (!(par7 < 0.0) && !(d5 < par7 * par7) || d4 != -1.0 && !(d5 < d4)) continue;
            d4 = d5;
            entityplayer = entityplayer1;
        }
        return entityplayer;
    }

    public uf b(nn par1Entity, double par2) {
        return this.b(par1Entity.u, par1Entity.v, par1Entity.w, par2);
    }

    public uf b(double par1, double par3, double par5, double par7) {
        double d4 = -1.0;
        uf entityplayer = null;
        for (int i = 0; i < this.h.size(); ++i) {
            uf entityplayer1 = (uf)this.h.get(i);
            if (entityplayer1.bG.a || !entityplayer1.T()) continue;
            double d5 = entityplayer1.e(par1, par3, par5);
            double d6 = par7;
            if (entityplayer1.ah()) {
                d6 = par7 * (double)0.8f;
            }
            if (entityplayer1.aj()) {
                float f = entityplayer1.bx();
                if (f < 0.1f) {
                    f = 0.1f;
                }
                d6 *= (double)(0.7f * f);
            }
            if (!(par7 < 0.0) && !(d5 < d6 * d6) || d4 != -1.0 && !(d5 < d4)) continue;
            d4 = d5;
            entityplayer = entityplayer1;
        }
        return entityplayer;
    }

    public uf a(String par1Str) {
        for (int i = 0; i < this.h.size(); ++i) {
            if (!par1Str.equals(((uf)this.h.get(i)).c_())) continue;
            return (uf)this.h.get(i);
        }
        return null;
    }

    @SideOnly(value=Side.CLIENT)
    public void F() {
    }

    public void G() throws aca {
        this.w.c();
    }

    @SideOnly(value=Side.CLIENT)
    public void a(long par1) {
        this.x.b(par1);
    }

    public long H() {
        return this.t.getSeed();
    }

    public long I() {
        return this.x.f();
    }

    public long J() {
        return this.t.getWorldTime();
    }

    public void b(long par1) {
        this.t.setWorldTime(par1);
    }

    public t K() {
        return this.t.getSpawnPoint();
    }

    @SideOnly(value=Side.CLIENT)
    public void E(int par1, int par2, int par3) {
        this.t.setSpawnPoint(par1, par2, par3);
    }

    @SideOnly(value=Side.CLIENT)
    public void h(nn par1Entity) {
        int i = ls.c(par1Entity.u / 16.0);
        int j2 = ls.c(par1Entity.w / 16.0);
        int b0 = 2;
        for (int k = i - b0; k <= i + b0; ++k) {
            for (int l = j2 - b0; l <= j2 + b0; ++l) {
                this.e(k, l);
            }
        }
        if (!this.e.contains(par1Entity) && !MinecraftForge.EVENT_BUS.post((Event)new EntityJoinWorldEvent(par1Entity, this))) {
            this.e.add(par1Entity);
        }
    }

    public boolean a(uf par1EntityPlayer, int par2, int par3, int par4) {
        return this.t.canMineBlock(par1EntityPlayer, par2, par3, par4);
    }

    public boolean canMineBlockBody(uf par1EntityPlayer, int par2, int par3, int par4) {
        return true;
    }

    public void a(nn par1Entity, byte par2) {
    }

    public ado L() {
        return this.v;
    }

    public void d(int par1, int par2, int par3, int par4, int par5, int par6) {
        if (par4 > 0) {
            aqz.s[par4].b(this, par1, par2, par3, par5, par6);
        }
    }

    public amc M() {
        return this.w;
    }

    public als N() {
        return this.x;
    }

    public abt O() {
        return this.x.x();
    }

    public void c() {
    }

    public float h(float par1) {
        return (this.o + (this.p - this.o) * par1) * this.i(par1);
    }

    public float i(float par1) {
        return this.m + (this.n - this.m) * par1;
    }

    @SideOnly(value=Side.CLIENT)
    public void j(float par1) {
        this.m = par1;
        this.n = par1;
    }

    public boolean P() {
        return (double)this.h(1.0f) > 0.9;
    }

    public boolean Q() {
        return (double)this.i(1.0f) > 0.2;
    }

    public boolean F(int par1, int par2, int par3) {
        if (!this.Q()) {
            return false;
        }
        if (!this.l(par1, par2, par3)) {
            return false;
        }
        if (this.h(par1, par3) > par2) {
            return false;
        }
        acq biomegenbase = this.a(par1, par3);
        return biomegenbase.c() ? false : biomegenbase.d();
    }

    public boolean G(int par1, int par2, int par3) {
        return this.t.isBlockHighHumidity(par1, par2, par3);
    }

    public void a(String par1Str, all par2WorldSavedData) {
        this.z.a(par1Str, par2WorldSavedData);
    }

    public all a(Class par1Class, String par2Str) {
        return this.z.a(par1Class, par2Str);
    }

    public int b(String par1Str) {
        return this.z.a(par1Str);
    }

    public void d(int par1, int par2, int par3, int par4, int par5) {
        for (int j1 = 0; j1 < this.u.size(); ++j1) {
            ((acb)this.u.get(j1)).a(par1, par2, par3, par4, par5);
        }
    }

    public void e(int par1, int par2, int par3, int par4, int par5) {
        this.a(null, par1, par2, par3, par4, par5);
    }

    public void a(uf par1EntityPlayer, int par2, int par3, int par4, int par5, int par6) {
        try {
            for (int j1 = 0; j1 < this.u.size(); ++j1) {
                ((acb)this.u.get(j1)).a(par1EntityPlayer, par2, par3, par4, par5, par6);
            }
        }
        catch (Throwable throwable) {
            b crashreport = b.a(throwable, "Playing level event");
            m crashreportcategory = crashreport.a("Level event being played");
            crashreportcategory.a("Block coordinates", m.a(par3, par4, par5));
            crashreportcategory.a("Event source", par1EntityPlayer);
            crashreportcategory.a("Event type", par2);
            crashreportcategory.a("Event data", par6);
            throw new u(crashreport);
        }
    }

    public int R() {
        return this.t.getHeight();
    }

    public int S() {
        return this.t.getActualHeight();
    }

    public hr a(st par1EntityMinecart) {
        return null;
    }

    public Random H(int par1, int par2, int par3) {
        long l = (long)par1 * 341873128712L + (long)par2 * 132897987541L + this.N().b() + (long)par3;
        this.s.setSeed(l);
        return this.s;
    }

    public aco b(String par1Str, int par2, int par3, int par4) {
        return this.L().a(this, par1Str, par2, par3, par4);
    }

    @SideOnly(value=Side.CLIENT)
    public boolean T() {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public double U() {
        return this.t.getHorizon();
    }

    public m a(b par1CrashReport) {
        m crashreportcategory = par1CrashReport.a("Affected level", 1);
        crashreportcategory.a("Level name", this.x == null ? "????" : this.x.k());
        crashreportcategory.a("All players", (Callable)new aby(this));
        crashreportcategory.a("Chunk stats", (Callable)new abz(this));
        try {
            this.x.a(crashreportcategory);
        }
        catch (Throwable throwable) {
            crashreportcategory.a("Level Data Unobtainable", throwable);
        }
        return crashreportcategory;
    }

    public void f(int par1, int par2, int par3, int par4, int par5) {
        for (int j1 = 0; j1 < this.u.size(); ++j1) {
            acb iworldaccess = (acb)this.u.get(j1);
            iworldaccess.b(par1, par2, par3, par4, par5);
        }
    }

    public atd V() {
        return this.J;
    }

    public Calendar W() {
        if (this.I() % 600L == 0L) {
            this.K.setTimeInMillis(MinecraftServer.aq());
        }
        return this.K;
    }

    @SideOnly(value=Side.CLIENT)
    public void a(double par1, double par3, double par5, double par7, double par9, double par11, by par13NBTTagCompound) {
    }

    public atj X() {
        return this.D;
    }

    public void m(int par1, int par2, int par3, int par4) {
        for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
            int j1 = par1 + dir.offsetX;
            int y = par2 + dir.offsetY;
            int k1 = par3 + dir.offsetZ;
            int l1 = this.a(j1, y, k1);
            aqz block = aqz.s[l1];
            if (block == null) continue;
            block.onNeighborTileChange(this, j1, y, k1, par1, par2, par3);
            if (!aqz.l(l1) || (block = aqz.s[l1 = this.a(j1 += dir.offsetX, y += dir.offsetY, k1 += dir.offsetZ)]) == null || !block.weakTileChanges()) continue;
            block.onNeighborTileChange(this, j1, y, k1, par1, par2, par3);
        }
    }

    public lp Y() {
        return this.L;
    }

    public float b(double par1, double par3, double par5) {
        return this.I(ls.c(par1), ls.c(par3), ls.c(par5));
    }

    public float I(int par1, int par2, int par3) {
        boolean flag;
        float f = 0.0f;
        boolean bl2 = flag = this.r == 3;
        if (this.f(par1, par2, par3)) {
            float f1 = this.x();
            f += ls.a((float)this.d((int)par1, (int)par3).q / 3600000.0f, 0.0f, 1.0f) * (flag ? 1.0f : 0.75f);
            f += f1 * 0.25f;
        }
        if (this.r < 2) {
            f *= (float)this.r / 2.0f;
        }
        return ls.a(f, 0.0f, flag ? 1.5f : 1.0f);
    }

    public void addTileEntity(asp entity) {
        List dest;
        List list = dest = this.N ? this.a : this.g;
        if (entity.canUpdate()) {
            dest.add(entity);
        }
    }

    public boolean isBlockSolidOnSide(int x2, int y, int z2, ForgeDirection side) {
        return this.isBlockSolidOnSide(x2, y, z2, side, false);
    }

    public boolean isBlockSolidOnSide(int x2, int y, int z2, ForgeDirection side, boolean _default) {
        if (x2 < -30000000 || z2 < -30000000 || x2 >= 30000000 || z2 >= 30000000) {
            return _default;
        }
        adr chunk = this.v.d(x2 >> 4, z2 >> 4);
        if (chunk == null || chunk.g()) {
            return _default;
        }
        aqz block = aqz.s[this.a(x2, y, z2)];
        if (block == null) {
            return false;
        }
        return block.isBlockSolidOnSide(this, x2, y, z2, side);
    }

    public ImmutableSetMultimap<abp, ForgeChunkManager.Ticket> getPersistentChunks() {
        return ForgeChunkManager.getPersistentChunksFor((abw)this);
    }

    public int getBlockLightOpacity(int x2, int y, int z2) {
        if (x2 < -30000000 || z2 < -30000000 || x2 >= 30000000 || z2 >= 30000000) {
            return 0;
        }
        if (y < 0 || y >= 256) {
            return 0;
        }
        return this.e(x2 >> 4, z2 >> 4).b(x2 & 0xF, y, z2 & 0xF);
    }

    public int countEntities(oh type, boolean forSpawnCount) {
        int count = 0;
        for (int x2 = 0; x2 < this.e.size(); ++x2) {
            if (!((nn)this.e.get(x2)).isCreatureType(type, forSpawnCount)) continue;
            ++count;
        }
        return count;
    }
}

