/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  abp
 *  abr
 *  aca
 *  acd
 *  acj
 *  acm
 *  acn
 *  aco
 *  acr
 *  acv
 *  ado
 *  ads
 *  adw
 *  aey
 *  all
 *  amc
 *  atc
 *  atk
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  df
 *  ed
 *  ee
 *  ef
 *  gf
 *  hp
 *  jl
 *  jp
 *  jt
 *  ju
 *  lp
 *  lv
 *  lx
 *  mi
 *  net.minecraft.server.MinecraftServer
 *  net.minecraftforge.common.ChestGenHooks
 *  net.minecraftforge.common.DimensionManager
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.Event
 *  net.minecraftforge.event.ForgeEventFactory
 *  net.minecraftforge.event.world.WorldEvent$Save
 *  se
 *  sp
 *  t
 *  u
 *  ua
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.world.WorldEvent;

public class js
extends abw {
    private final MinecraftServer a;
    private final jm J;
    private final jp K;
    private Set L;
    private TreeSet M;
    public jr b;
    public boolean c;
    public boolean N;
    private int O;
    private final acj P;
    private final aci Q = new aci();
    private ju[] R = new ju[]{new ju((jt)null), new ju((jt)null)};
    private int S;
    public static final mk[] T = new mk[]{new mk(yc.F.cv, 0, 1, 3, 10), new mk(aqz.C.cF, 0, 1, 3, 10), new mk(aqz.O.cF, 0, 1, 3, 10), new mk(yc.A.cv, 0, 1, 1, 3), new mk(yc.w.cv, 0, 1, 1, 5), new mk(yc.z.cv, 0, 1, 1, 3), new mk(yc.v.cv, 0, 1, 1, 5), new mk(yc.l.cv, 0, 2, 3, 5), new mk(yc.W.cv, 0, 2, 3, 3)};
    private List U = new ArrayList();
    private lm V;
    protected Set<abp> doneChunks = new HashSet<abp>();
    public List<acj> customTeleporters = new ArrayList<acj>();

    public js(MinecraftServer par1MinecraftServer, amc par2ISaveHandler, String par3Str, int par4, acd par5WorldSettings, lv par6Profiler, lp par7ILogAgent) {
        super(par2ISaveHandler, par3Str, par5WorldSettings, aei.a(par4), par6Profiler, par7ILogAgent);
        this.a = par1MinecraftServer;
        this.J = new jm(this);
        this.K = new jp(this, par1MinecraftServer.af().o());
        if (this.V == null) {
            this.V = new lm();
        }
        if (this.L == null) {
            this.L = new HashSet();
        }
        if (this.M == null) {
            this.M = new TreeSet();
        }
        this.P = new acj(this);
        this.D = new hp(par1MinecraftServer);
        atk scoreboardsavedata = (atk)this.z.a(atk.class, "scoreboard");
        if (scoreboardsavedata == null) {
            scoreboardsavedata = new atk();
            this.z.a("scoreboard", (all)scoreboardsavedata);
        }
        if (!(this instanceof jl)) {
            scoreboardsavedata.a(this.D);
        }
        ((hp)this.D).a(scoreboardsavedata);
        DimensionManager.setWorld((int)par4, (js)this);
    }

    @Override
    public void b() {
        super.b();
        if (this.N().t() && this.r < 3) {
            this.r = 3;
        }
        this.t.e.b();
        if (this.e()) {
            if (this.O().b("doDaylightCycle")) {
                long i2 = this.x.g() + 24000L;
                this.x.c(i2 - i2 % 24000L);
            }
            this.d();
        }
        this.C.a("mobSpawner");
        if (this.O().b("doMobSpawning")) {
            this.Q.a(this, this.E, this.F, this.x.f() % 400L == 0L);
        }
        this.C.c("chunkSource");
        this.v.c();
        int j2 = this.a(1.0f);
        if (j2 != this.j) {
            this.j = j2;
        }
        this.x.b(this.x.f() + 1L);
        if (this.O().b("doDaylightCycle")) {
            this.x.c(this.x.g() + 1L);
        }
        this.C.c("tickPending");
        this.a(false);
        this.C.c("tickTiles");
        this.g();
        this.C.c("chunkMap");
        this.K.b();
        this.C.c("village");
        this.A.a();
        this.B.a();
        this.C.c("portalForcer");
        this.P.a(this.I());
        for (acj tele : this.customTeleporters) {
            tele.a(this.I());
        }
        this.C.b();
        this.aa();
    }

    public acr a(oh par1EnumCreatureType, int par2, int par3, int par4) {
        List list = this.L().a(par1EnumCreatureType, par2, par3, par4);
        return (list = ForgeEventFactory.getPotentialSpawns((js)this, (oh)par1EnumCreatureType, (int)par2, (int)par3, (int)par4, (List)list)) != null && !list.isEmpty() ? (acr)mi.a((Random)this.s, (Collection)list) : null;
    }

    @Override
    public void c() {
        this.N = !this.h.isEmpty();
        for (uf entityplayer : this.h) {
            if (entityplayer.bh()) continue;
            this.N = false;
            break;
        }
    }

    protected void d() {
        this.N = false;
        for (uf entityplayer : this.h) {
            if (!entityplayer.bh()) continue;
            entityplayer.a(false, false, true);
        }
        this.Z();
    }

    private void Z() {
        this.t.resetRainAndThunder();
    }

    public boolean e() {
        if (this.N && !this.I) {
            uf entityplayer;
            Iterator iterator = this.h.iterator();
            do {
                if (iterator.hasNext()) continue;
                return true;
            } while ((entityplayer = (uf)iterator.next()).bD());
            return false;
        }
        return false;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void f() {
        if (this.x.d() <= 0) {
            this.x.b(64);
        }
        int i2 = this.x.c();
        int j2 = this.x.e();
        int k2 = 0;
        while (this.b(i2, j2) == 0) {
            i2 += this.s.nextInt(8) - this.s.nextInt(8);
            j2 += this.s.nextInt(8) - this.s.nextInt(8);
            if (++k2 != 10000) continue;
        }
        this.x.a(i2);
        this.x.c(j2);
    }

    @Override
    protected void g() {
        super.g();
        int i2 = 0;
        int j2 = 0;
        Iterator iterator = this.G.iterator();
        this.doneChunks.retainAll(this.G);
        if (this.doneChunks.size() == this.G.size()) {
            this.doneChunks.clear();
        }
        long startTime = System.nanoTime();
        while (iterator.hasNext()) {
            int i22;
            int l1;
            int k1;
            int j1;
            int i1;
            abp chunkcoordintpair = (abp)iterator.next();
            int k2 = chunkcoordintpair.a * 16;
            int l2 = chunkcoordintpair.b * 16;
            this.C.a("getChunk");
            adr chunk = this.e(chunkcoordintpair.a, chunkcoordintpair.b);
            this.a(k2, l2, chunk);
            this.C.c("tickChunk");
            if (System.nanoTime() - startTime <= 4000000L && this.doneChunks.add(chunkcoordintpair)) {
                chunk.k();
            }
            this.C.c("thunder");
            if (this.t.canDoLightning(chunk) && this.s.nextInt(100000) == 0 && this.Q() && this.P()) {
                this.k = this.k * 3 + 1013904223;
                i1 = this.k >> 2;
                j1 = k2 + (i1 & 0xF);
                k1 = l2 + (i1 >> 8 & 0xF);
                l1 = this.h(j1, k1);
                if (this.F(j1, l1, k1)) {
                    this.c((nn)new sp((abw)this, (double)j1, (double)l1, (double)k1));
                }
            }
            this.C.c("iceandsnow");
            if (this.t.canDoRainSnowIce(chunk) && this.s.nextInt(16) == 0) {
                acq biomegenbase;
                this.k = this.k * 3 + 1013904223;
                i1 = this.k >> 2;
                j1 = i1 & 0xF;
                k1 = i1 >> 8 & 0xF;
                l1 = this.h(j1 + k2, k1 + l2);
                if (this.y(j1 + k2, l1 - 1, k1 + l2)) {
                    this.c(j1 + k2, l1 - 1, k1 + l2, aqz.aY.cF);
                }
                if (this.Q() && this.z(j1 + k2, l1, k1 + l2)) {
                    this.c(j1 + k2, l1, k1 + l2, aqz.aX.cF);
                }
                if (this.Q() && (biomegenbase = this.a(j1 + k2, k1 + l2)).d() && (i22 = this.a(j1 + k2, l1 - 1, k1 + l2)) != 0) {
                    aqz.s[i22].g(this, j1 + k2, l1 - 1, k1 + l2);
                }
            }
            this.C.c("tickTiles");
            for (ads extendedblockstorage : chunk.i()) {
                if (extendedblockstorage == null || !extendedblockstorage.b()) continue;
                for (int j22 = 0; j22 < 3; ++j22) {
                    this.k = this.k * 3 + 1013904223;
                    i22 = this.k >> 2;
                    int k22 = i22 & 0xF;
                    int l22 = i22 >> 8 & 0xF;
                    int i3 = i22 >> 16 & 0xF;
                    int j3 = extendedblockstorage.a(k22, i3, l22);
                    ++j2;
                    aqz block = aqz.s[j3];
                    if (block == null || !block.s()) continue;
                    ++i2;
                    block.a((abw)this, k22 + k2, i3 + extendedblockstorage.d(), l22 + l2, this.s);
                }
            }
            this.C.b();
        }
    }

    @Override
    public boolean a(int par1, int par2, int par3, int par4) {
        acm nextticklistentry = new acm(par1, par2, par3, par4);
        return this.U.contains(nextticklistentry);
    }

    @Override
    public void a(int par1, int par2, int par3, int par4, int par5) {
        this.a(par1, par2, par3, par4, par5, 0);
    }

    @Override
    public void a(int par1, int par2, int par3, int par4, int par5, int par6) {
        acm nextticklistentry = new acm(par1, par2, par3, par4);
        int b0 = 0;
        if (this.d && par4 > 0) {
            if (aqz.s[par4].l()) {
                int k1;
                b0 = 8;
                if (this.e(nextticklistentry.a - b0, nextticklistentry.b - b0, nextticklistentry.c - b0, nextticklistentry.a + b0, nextticklistentry.b + b0, nextticklistentry.c + b0) && (k1 = this.a(nextticklistentry.a, nextticklistentry.b, nextticklistentry.c)) == nextticklistentry.d && k1 > 0) {
                    aqz.s[k1].a((abw)this, nextticklistentry.a, nextticklistentry.b, nextticklistentry.c, this.s);
                }
                return;
            }
            par5 = 1;
        }
        if (this.e(par1 - b0, par2 - b0, par3 - b0, par1 + b0, par2 + b0, par3 + b0)) {
            if (par4 > 0) {
                nextticklistentry.a((long)par5 + this.x.f());
                nextticklistentry.a(par6);
            }
            if (!this.L.contains(nextticklistentry)) {
                this.L.add(nextticklistentry);
                this.M.add(nextticklistentry);
            }
        }
    }

    @Override
    public void b(int par1, int par2, int par3, int par4, int par5, int par6) {
        acm nextticklistentry = new acm(par1, par2, par3, par4);
        nextticklistentry.a(par6);
        if (par4 > 0) {
            nextticklistentry.a((long)par5 + this.x.f());
        }
        if (!this.L.contains(nextticklistentry)) {
            this.L.add(nextticklistentry);
            this.M.add(nextticklistentry);
        }
    }

    @Override
    public void h() {
        if (this.h.isEmpty() && this.getPersistentChunks().isEmpty()) {
            if (this.O++ >= 1200) {
                return;
            }
        } else {
            this.i();
        }
        super.h();
    }

    public void i() {
        this.O = 0;
    }

    @Override
    public boolean a(boolean par1) {
        acm nextticklistentry;
        int i2 = this.M.size();
        if (i2 != this.L.size()) {
            throw new IllegalStateException("TickNextTick list out of synch");
        }
        if (i2 > 1000) {
            i2 = 1000;
        }
        this.C.a("cleaning");
        for (int j2 = 0; j2 < i2; ++j2) {
            nextticklistentry = (acm)this.M.first();
            if (!par1 && nextticklistentry.e > this.x.f()) break;
            this.M.remove(nextticklistentry);
            this.L.remove(nextticklistentry);
            this.U.add(nextticklistentry);
        }
        this.C.b();
        this.C.a("ticking");
        Iterator iterator = this.U.iterator();
        while (iterator.hasNext()) {
            nextticklistentry = (acm)iterator.next();
            iterator.remove();
            int b0 = 0;
            if (this.e(nextticklistentry.a - b0, nextticklistentry.b - b0, nextticklistentry.c - b0, nextticklistentry.a + b0, nextticklistentry.b + b0, nextticklistentry.c + b0)) {
                int k2 = this.a(nextticklistentry.a, nextticklistentry.b, nextticklistentry.c);
                if (k2 <= 0 || !aqz.b(k2, nextticklistentry.d)) continue;
                try {
                    aqz.s[k2].a((abw)this, nextticklistentry.a, nextticklistentry.b, nextticklistentry.c, this.s);
                    continue;
                }
                catch (Throwable throwable) {
                    int l2;
                    b crashreport = b.a(throwable, "Exception while ticking a block");
                    m crashreportcategory = crashreport.a("Block being ticked");
                    try {
                        l2 = this.h(nextticklistentry.a, nextticklistentry.b, nextticklistentry.c);
                    }
                    catch (Throwable throwable1) {
                        l2 = -1;
                    }
                    m.a(crashreportcategory, nextticklistentry.a, nextticklistentry.b, nextticklistentry.c, k2, l2);
                    throw new u(crashreport);
                }
            }
            this.a(nextticklistentry.a, nextticklistentry.b, nextticklistentry.c, nextticklistentry.d, 0);
        }
        this.C.b();
        this.U.clear();
        return !this.M.isEmpty();
    }

    @Override
    public List a(adr par1Chunk, boolean par2) {
        ArrayList<acm> arraylist = null;
        abp chunkcoordintpair = par1Chunk.l();
        int i2 = (chunkcoordintpair.a << 4) - 2;
        int j2 = i2 + 16 + 2;
        int k2 = (chunkcoordintpair.b << 4) - 2;
        int l2 = k2 + 16 + 2;
        for (int i1 = 0; i1 < 2; ++i1) {
            Iterator iterator;
            if (i1 == 0) {
                iterator = this.M.iterator();
            } else {
                iterator = this.U.iterator();
                if (!this.U.isEmpty()) {
                    System.out.println(this.U.size());
                }
            }
            while (iterator.hasNext()) {
                acm nextticklistentry = (acm)iterator.next();
                if (nextticklistentry.a < i2 || nextticklistentry.a >= j2 || nextticklistentry.c < k2 || nextticklistentry.c >= l2) continue;
                if (par2) {
                    this.L.remove(nextticklistentry);
                    iterator.remove();
                }
                if (arraylist == null) {
                    arraylist = new ArrayList<acm>();
                }
                arraylist.add(nextticklistentry);
            }
        }
        return arraylist;
    }

    @Override
    public void a(nn par1Entity, boolean par2) {
        if (!this.a.X() && (par1Entity instanceof rp || par1Entity instanceof se)) {
            par1Entity.x();
        }
        if (!this.a.Y() && par1Entity instanceof ua) {
            par1Entity.x();
        }
        super.a(par1Entity, par2);
    }

    @Override
    protected ado j() {
        adw ichunkloader = this.w.a(this.t);
        this.b = new jr(this, ichunkloader, this.t.c());
        return this.b;
    }

    public List c(int par1, int par2, int par3, int par4, int par5, int par6) {
        ArrayList<asp> arraylist = new ArrayList<asp>();
        for (int x2 = par1 >> 4; x2 <= par4 >> 4; ++x2) {
            for (int z2 = par3 >> 4; z2 <= par6 >> 4; ++z2) {
                adr chunk = this.e(x2, z2);
                if (chunk == null) continue;
                for (Object obj : chunk.i.values()) {
                    asp entity = (asp)obj;
                    if (entity.r() || entity.l < par1 || entity.m < par2 || entity.n < par3 || entity.l > par4 || entity.m > par5 || entity.n > par6) continue;
                    arraylist.add(entity);
                }
            }
        }
        return arraylist;
    }

    @Override
    public boolean a(uf par1EntityPlayer, int par2, int par3, int par4) {
        return super.a(par1EntityPlayer, par2, par3, par4);
    }

    @Override
    public boolean canMineBlockBody(uf par1EntityPlayer, int par2, int par3, int par4) {
        return !this.a.a((abw)this, par2, par3, par4, par1EntityPlayer);
    }

    @Override
    protected void a(acd par1WorldSettings) {
        if (this.V == null) {
            this.V = new lm();
        }
        if (this.L == null) {
            this.L = new HashSet();
        }
        if (this.M == null) {
            this.M = new TreeSet();
        }
        this.b(par1WorldSettings);
        super.a(par1WorldSettings);
    }

    protected void b(acd par1WorldSettings) {
        if (!this.t.e()) {
            this.x.a(0, this.t.i(), 0);
        } else {
            this.y = true;
            acv worldchunkmanager = this.t.e;
            List list = worldchunkmanager.a();
            Random random = new Random(this.H());
            aco chunkposition = worldchunkmanager.a(0, 0, 256, list, random);
            int i2 = 0;
            int j2 = this.t.i();
            int k2 = 0;
            if (chunkposition != null) {
                i2 = chunkposition.a;
                k2 = chunkposition.c;
            } else {
                this.Y().b("Unable to find spawn biome");
            }
            int l2 = 0;
            while (!this.t.a(i2, k2)) {
                i2 += random.nextInt(64) - random.nextInt(64);
                k2 += random.nextInt(64) - random.nextInt(64);
                if (++l2 != 1000) continue;
            }
            this.x.a(i2, j2, k2);
            this.y = false;
            if (par1WorldSettings.c()) {
                this.k();
            }
        }
    }

    protected void k() {
        int k2;
        int l2;
        int j2;
        aey worldgeneratorbonuschest = new aey(ChestGenHooks.getItems((String)"bonusChest", (Random)this.s), ChestGenHooks.getCount((String)"bonusChest", (Random)this.s));
        for (int i2 = 0; i2 < 10 && !worldgeneratorbonuschest.a((abw)this, this.s, j2 = this.x.c() + this.s.nextInt(6) - this.s.nextInt(6), l2 = this.i(j2, k2 = this.x.e() + this.s.nextInt(6) - this.s.nextInt(6)) + 1, k2); ++i2) {
        }
    }

    public t l() {
        return this.t.h();
    }

    public void a(boolean par1, lx par2IProgressUpdate) throws aca {
        if (this.v.d()) {
            if (par2IProgressUpdate != null) {
                par2IProgressUpdate.a("Saving level");
            }
            this.a();
            if (par2IProgressUpdate != null) {
                par2IProgressUpdate.c("Saving chunks");
            }
            this.v.a(par1, par2IProgressUpdate);
            MinecraftForge.EVENT_BUS.post((Event)new WorldEvent.Save((abw)this));
        }
    }

    public void m() {
        if (this.v.d()) {
            this.v.b();
        }
    }

    protected void a() throws aca {
        this.G();
        this.w.a(this.x, this.a.af().q());
        this.z.a();
        this.perWorldStorage.a();
    }

    @Override
    protected void a(nn par1Entity) {
        super.a(par1Entity);
        this.V.a(par1Entity.k, par1Entity);
        nn[] aentity = par1Entity.ao();
        if (aentity != null) {
            for (int i2 = 0; i2 < aentity.length; ++i2) {
                this.V.a(aentity[i2].k, aentity[i2]);
            }
        }
    }

    @Override
    public void b(nn par1Entity) {
        super.b(par1Entity);
        this.V.d(par1Entity.k);
        nn[] aentity = par1Entity.ao();
        if (aentity != null) {
            for (int i2 = 0; i2 < aentity.length; ++i2) {
                this.V.d(aentity[i2].k);
            }
        }
    }

    @Override
    public nn a(int par1) {
        return (nn)this.V.a(par1);
    }

    @Override
    public boolean c(nn par1Entity) {
        if (super.c(par1Entity)) {
            this.a.af().a(par1Entity.u, par1Entity.v, par1Entity.w, 512.0, this.t.i, (ey)new df(par1Entity));
            return true;
        }
        return false;
    }

    @Override
    public void a(nn par1Entity, byte par2) {
        ed packet38entitystatus = new ed(par1Entity.k, par2);
        this.q().b(par1Entity, (ey)packet38entitystatus);
    }

    @Override
    public abr a(nn par1Entity, double par2, double par4, double par6, float par8, boolean par9, boolean par10) {
        abr explosion = new abr((abw)this, par1Entity, par2, par4, par6, par8);
        explosion.a = par9;
        explosion.b = par10;
        explosion.a();
        explosion.a(false);
        if (!par10) {
            explosion.h.clear();
        }
        for (uf entityplayer : this.h) {
            if (!(entityplayer.e(par2, par4, par6) < 4096.0)) continue;
            ((jv)entityplayer).a.b((ey)new ee(par2, par4, par6, par8, explosion.h, (atc)explosion.b().get(entityplayer)));
        }
        return explosion;
    }

    @Override
    public void d(int par1, int par2, int par3, int par4, int par5, int par6) {
        acn blockeventdata1;
        acn blockeventdata = new acn(par1, par2, par3, par4, par5, par6);
        Iterator iterator = this.R[this.S].iterator();
        do {
            if (iterator.hasNext()) continue;
            this.R[this.S].add((Object)blockeventdata);
            return;
        } while (!(blockeventdata1 = (acn)iterator.next()).equals((Object)blockeventdata));
    }

    private void aa() {
        while (!this.R[this.S].isEmpty()) {
            int i2 = this.S;
            this.S ^= 1;
            for (acn blockeventdata : this.R[i2]) {
                if (!this.a(blockeventdata)) continue;
                this.a.af().a((double)blockeventdata.a(), (double)blockeventdata.b(), (double)blockeventdata.c(), 64.0, this.t.i, (ey)new gf(blockeventdata.a(), blockeventdata.b(), blockeventdata.c(), blockeventdata.f(), blockeventdata.d(), blockeventdata.e()));
            }
            this.R[i2].clear();
        }
    }

    private boolean a(acn par1BlockEventData) {
        int i2 = this.a(par1BlockEventData.a(), par1BlockEventData.b(), par1BlockEventData.c());
        return i2 == par1BlockEventData.f() ? aqz.s[i2].b(this, par1BlockEventData.a(), par1BlockEventData.b(), par1BlockEventData.c(), par1BlockEventData.d(), par1BlockEventData.e()) : false;
    }

    public void n() {
        this.w.a();
    }

    @Override
    protected void o() {
        boolean flag = this.Q();
        super.o();
        if (flag != this.Q()) {
            if (flag) {
                this.a.af().a((ey)new ef(2, 0));
            } else {
                this.a.af().a((ey)new ef(1, 0));
            }
        }
    }

    public MinecraftServer p() {
        return this.a;
    }

    public jm q() {
        return this.J;
    }

    public jp s() {
        return this.K;
    }

    public acj t() {
        return this.P;
    }

    public File getChunkSaveLocation() {
        return ((aee)this.b.e).d;
    }
}

