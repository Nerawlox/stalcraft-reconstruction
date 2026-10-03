/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  abk
 *  abm
 *  abp
 *  arx
 *  asc
 *  asd
 *  asg
 *  asm
 *  ate
 *  atg
 *  ato
 *  dj
 *  dk
 *  dm
 *  dp
 *  dv
 *  dw
 *  dx
 *  dy
 *  dz
 *  ea
 *  ec
 *  ed
 *  ef
 *  fa
 *  ff
 *  fg
 *  fo
 *  fr
 *  fs
 *  gd
 *  gj
 *  jw
 *  kp
 *  ku
 *  la
 *  mo
 *  nb
 *  nc
 *  net.minecraft.server.MinecraftServer
 *  net.minecraftforge.common.ForgeHooks
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.Event
 *  net.minecraftforge.event.entity.player.PlayerDropsEvent
 *  net.minecraftforge.event.world.ChunkWatchEvent$Watch
 *  t
 *  u
 *  va
 *  vd
 *  vf
 *  vi
 *  vj
 *  vl
 *  vm
 *  vp
 *  vr
 *  vs
 *  vy
 *  vz
 *  wd
 *  wf
 *  wv
 */
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.event.world.ChunkWatchEvent;

public class jv
extends uf
implements vi {
    private String bN = "en_US";
    public ka a;
    public MinecraftServer b;
    public jw c;
    public double d;
    public double e;
    public final List f = new LinkedList();
    public final List g = new LinkedList();
    private float bO = Float.MIN_VALUE;
    private float bP = -1.0E8f;
    private int bQ = -99999999;
    private boolean bR = true;
    private int bS = -99999999;
    private int bT = 60;
    private int bU;
    private int bV;
    private boolean bW = true;
    private long bX = 0L;
    public int bY;
    public boolean h;
    public int i;
    public boolean j;

    public jv(MinecraftServer par1MinecraftServer, abw par2World, String par3Str, jw par4ItemInWorldManager) {
        super(par2World, par3Str);
        par4ItemInWorldManager.b = this;
        this.c = par4ItemInWorldManager;
        this.bU = par1MinecraftServer == null ? 0 : par1MinecraftServer.af().o();
        t chunkcoordinates = par2World.t.getRandomizedSpawnPoint();
        int i2 = chunkcoordinates.a;
        int j2 = chunkcoordinates.c;
        int k2 = chunkcoordinates.b;
        this.b = par1MinecraftServer;
        this.Y = 0.0f;
        this.N = 0.0f;
        this.b((double)i2 + 0.5, k2, (double)j2 + 0.5, 0.0f, 0.0f);
        while (!par2World.a((nn)this, this.E).isEmpty()) {
            this.b(this.u, this.v + 1.0, this.w);
        }
    }

    @Override
    public void a(by par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        if (par1NBTTagCompound.b("playerGameType")) {
            if (MinecraftServer.F().ao()) {
                this.c.a(MinecraftServer.F().h());
            } else {
                this.c.a(ace.a(par1NBTTagCompound.e("playerGameType")));
            }
        }
    }

    @Override
    public void b(by par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("playerGameType", this.c.b().a());
    }

    @Override
    public void a(int par1) {
        super.a(par1);
        this.bS = -1;
    }

    public void d() {
        this.bp.a(this);
    }

    @Override
    protected void d_() {
        this.N = 0.0f;
    }

    @Override
    public void l_() {
        this.c.a();
        --this.bT;
        this.bp.b();
        if (!this.q.I && !ForgeHooks.canInteractWith((uf)this, (uy)this.bp)) {
            this.i();
            this.bp = this.bo;
        }
        while (!this.g.isEmpty()) {
            int i2 = Math.min(this.g.size(), 127);
            int[] aint = new int[i2];
            Iterator iterator = this.g.iterator();
            int j2 = 0;
            while (iterator.hasNext() && j2 < i2) {
                aint[j2++] = (Integer)iterator.next();
                iterator.remove();
            }
            this.a.b((ey)new ff(aint));
        }
        if (!this.f.isEmpty()) {
            ArrayList<adr> arraylist = new ArrayList<adr>();
            Iterator iterator1 = this.f.iterator();
            ArrayList arraylist1 = new ArrayList();
            while (iterator1.hasNext() && arraylist.size() < 5) {
                abp chunkcoordintpair = (abp)iterator1.next();
                iterator1.remove();
                if (chunkcoordintpair == null || !this.q.f(chunkcoordintpair.a << 4, 0, chunkcoordintpair.b << 4)) continue;
                arraylist.add(this.q.e(chunkcoordintpair.a, chunkcoordintpair.b));
                arraylist1.addAll(((js)this.q).c(chunkcoordintpair.a * 16, 0, chunkcoordintpair.b * 16, chunkcoordintpair.a * 16 + 15, 256, chunkcoordintpair.b * 16 + 15));
            }
            if (!arraylist.isEmpty()) {
                this.a.b(new el(arraylist));
                for (asp tileentity : arraylist1) {
                    this.b(tileentity);
                }
                for (adr chunk : arraylist) {
                    this.p().q().a(this, chunk);
                    MinecraftForge.EVENT_BUS.post((Event)new ChunkWatchEvent.Watch(chunk.l(), this));
                }
            }
        }
        if (this.bX > 0L && this.b.ar() > 0 && MinecraftServer.aq() - this.bX > (long)(this.b.ar() * 1000 * 60)) {
            this.a.c("You have been idle for too long!");
        }
    }

    public void h() {
        try {
            super.l_();
            for (int i2 = 0; i2 < this.bn.j_(); ++i2) {
                ey packet;
                ye itemstack = this.bn.a(i2);
                if (itemstack == null || !yc.g[itemstack.d].f() || this.a.f() > 5 || (packet = ((wv)yc.g[itemstack.d]).c(itemstack, this.q, (uf)this)) == null) continue;
                this.a.b(packet);
            }
            if (this.aN() != this.bP || this.bQ != this.bq.a() || this.bq.e() == 0.0f != this.bR) {
                this.a.b((ey)new fs(this.aN(), this.bq.a(), this.bq.e()));
                this.bP = this.aN();
                this.bQ = this.bq.a();
                boolean bl2 = this.bR = this.bq.e() == 0.0f;
            }
            if (this.aN() + this.bn() != this.bO) {
                this.bO = this.aN() + this.bn();
                Collection collection = this.bM().a(ato.f);
                for (ate scoreobjective : collection) {
                    this.bM().a(this.an(), scoreobjective).a(Arrays.asList(this));
                }
            }
            if (this.bI != this.bS) {
                this.bS = this.bI;
                this.a.b((ey)new fr(this.bJ, this.bI, this.bH));
            }
        }
        catch (Throwable throwable) {
            b crashreport = b.a(throwable, "Ticking player");
            m crashreportcategory = crashreport.a("Player being ticked");
            this.a(crashreportcategory);
            throw new u(crashreport);
        }
    }

    @Override
    public void a(nb par1DamageSource) {
        if (ForgeHooks.onLivingDeath((of)this, (nb)par1DamageSource)) {
            return;
        }
        this.b.af().a(this.aR().b());
        if (!this.q.O().b("keepInventory")) {
            this.captureDrops = true;
            this.capturedDrops.clear();
            this.bn.m();
            this.captureDrops = false;
            PlayerDropsEvent event = new PlayerDropsEvent((uf)this, par1DamageSource, this.capturedDrops, this.aT > 0);
            if (!MinecraftForge.EVENT_BUS.post((Event)event)) {
                for (ss item : this.capturedDrops) {
                    this.a(item);
                }
            }
        }
        Collection collection = this.q.X().a(ato.c);
        for (ate scoreobjective : collection) {
            atg score = this.bM().a(this.an(), scoreobjective);
            score.a();
        }
        of entitylivingbase = this.aS();
        if (entitylivingbase != null) {
            entitylivingbase.b(this, this.bb);
        }
        this.a(la.y, 1);
    }

    @Override
    public boolean a(nb par1DamageSource, float par2) {
        boolean flag;
        if (this.ar()) {
            return false;
        }
        boolean bl2 = flag = this.b.V() && this.b.Z() && "fall".equals(par1DamageSource.o);
        if (!flag && this.bT > 0 && par1DamageSource != nb.i) {
            return false;
        }
        if (par1DamageSource instanceof nc) {
            nn entity = par1DamageSource.i();
            if (entity instanceof uf && !this.a((uf)entity)) {
                return false;
            }
            if (entity instanceof uh) {
                uh entityarrow = (uh)entity;
                if (entityarrow.c instanceof uf && !this.a((uf)entityarrow.c)) {
                    return false;
                }
            }
        }
        return super.a(par1DamageSource, par2);
    }

    @Override
    public boolean a(uf par1EntityPlayer) {
        return !this.b.Z() ? false : super.a(par1EntityPlayer);
    }

    @Override
    public void b(int par1) {
        if (this.ar == 1 && par1 == 1) {
            this.a((ku)kp.C);
            this.q.e(this);
            this.j = true;
            this.a.b((ey)new ef(4, 0));
        } else {
            if (this.ar == 0 && par1 == 1) {
                this.a((ku)kp.B);
                t chunkcoordinates = this.b.a(par1).l();
                if (chunkcoordinates != null) {
                    this.a.a(chunkcoordinates.a, chunkcoordinates.b, chunkcoordinates.c, 0.0f, 0.0f);
                }
                par1 = 1;
            } else {
                this.a((ku)kp.x);
            }
            this.b.af().a(this, par1);
            this.bS = -1;
            this.bP = -1.0f;
            this.bQ = -1;
        }
    }

    private void b(asp par1TileEntity) {
        ey packet;
        if (par1TileEntity != null && (packet = par1TileEntity.m()) != null) {
            this.a.b(packet);
        }
    }

    @Override
    public void a(nn par1Entity, int par2) {
        super.a(par1Entity, par2);
        this.bp.b();
    }

    @Override
    public ug a(int par1, int par2, int par3) {
        ug enumstatus = super.a(par1, par2, par3);
        if (enumstatus == ug.a) {
            ec packet17sleep = new ec((nn)this, 0, par1, par2, par3);
            this.p().q().a((nn)this, (ey)packet17sleep);
            this.a.a(this.u, this.v, this.w, this.A, this.B);
            this.a.b((ey)packet17sleep);
        }
        return enumstatus;
    }

    @Override
    public void a(boolean par1, boolean par2, boolean par3) {
        if (this.bh()) {
            this.p().q().b(this, (ey)new dj((nn)this, 3));
        }
        super.a(par1, par2, par3);
        if (this.a != null) {
            this.a.a(this.u, this.v, this.w, this.A, this.B);
        }
    }

    @Override
    public void a(nn par1Entity) {
        super.a(par1Entity);
        this.a.b((ey)new fo(0, (nn)this, this.o));
        this.a.a(this.u, this.v, this.w, this.A, this.B);
    }

    @Override
    protected void a(double par1, boolean par3) {
    }

    public void b(double par1, boolean par3) {
        super.a(par1, par3);
    }

    @Override
    public void a(asp par1TileEntity) {
        if (par1TileEntity instanceof asm) {
            ((asm)par1TileEntity).a((uf)this);
            this.a.b((ey)new gd(0, par1TileEntity.l, par1TileEntity.m, par1TileEntity.n));
        }
    }

    public void bN() {
        this.bY = this.bY % 100 + 1;
    }

    @Override
    public void b(int par1, int par2, int par3) {
        this.bN();
        this.a.b((ey)new dw(this.bY, 1, "Crafting", 9, true));
        this.bp = new vl(this.bn, this.q, par1, par2, par3);
        this.bp.d = this.bY;
        this.bp.a(this);
    }

    @Override
    public void a(int par1, int par2, int par3, String par4Str) {
        this.bN();
        this.a.b((ey)new dw(this.bY, 4, par4Str == null ? "" : par4Str, 9, par4Str != null));
        this.bp = new vm(this.bn, this.q, par1, par2, par3);
        this.bp.d = this.bY;
        this.bp.a(this);
    }

    @Override
    public void c(int par1, int par2, int par3) {
        this.bN();
        this.a.b((ey)new dw(this.bY, 8, "Repairing", 9, true));
        this.bp = new va(this.bn, this.q, par1, par2, par3, (uf)this);
        this.bp.d = this.bY;
        this.bp.a(this);
    }

    @Override
    public void a(mo par1IInventory) {
        if (this.bp != this.bo) {
            this.i();
        }
        this.bN();
        this.a.b((ey)new dw(this.bY, 0, par1IInventory.b(), par1IInventory.j_(), par1IInventory.c()));
        this.bp = new vj((mo)this.bn, par1IInventory);
        this.bp.d = this.bY;
        this.bp.a(this);
    }

    @Override
    public void a(asi par1TileEntityHopper) {
        this.bN();
        this.a.b((ey)new dw(this.bY, 9, par1TileEntityHopper.b(), par1TileEntityHopper.j_(), par1TileEntityHopper.c()));
        this.bp = new vr(this.bn, (mo)par1TileEntityHopper);
        this.bp.d = this.bY;
        this.bp.a(this);
    }

    @Override
    public void a(sx par1EntityMinecartHopper) {
        this.bN();
        this.a.b((ey)new dw(this.bY, 9, par1EntityMinecartHopper.b(), par1EntityMinecartHopper.j_(), par1EntityMinecartHopper.c()));
        this.bp = new vr(this.bn, (mo)par1EntityMinecartHopper);
        this.bp.d = this.bY;
        this.bp.a(this);
    }

    @Override
    public void a(asg par1TileEntityFurnace) {
        this.bN();
        this.a.b((ey)new dw(this.bY, 2, par1TileEntityFurnace.b(), par1TileEntityFurnace.j_(), par1TileEntityFurnace.c()));
        this.bp = new vp(this.bn, par1TileEntityFurnace);
        this.bp.d = this.bY;
        this.bp.a(this);
    }

    @Override
    public void a(asc par1TileEntityDispenser) {
        this.bN();
        this.a.b((ey)new dw(this.bY, par1TileEntityDispenser instanceof asd ? 10 : 3, par1TileEntityDispenser.b(), par1TileEntityDispenser.j_(), par1TileEntityDispenser.c()));
        this.bp = new wf((mo)this.bn, par1TileEntityDispenser);
        this.bp.d = this.bY;
        this.bp.a(this);
    }

    @Override
    public void a(arx par1TileEntityBrewingStand) {
        this.bN();
        this.a.b((ey)new dw(this.bY, 5, par1TileEntityBrewingStand.b(), par1TileEntityBrewingStand.j_(), par1TileEntityBrewingStand.c()));
        this.bp = new vf(this.bn, par1TileEntityBrewingStand);
        this.bp.d = this.bY;
        this.bp.a(this);
    }

    @Override
    public void a(arw par1TileEntityBeacon) {
        this.bN();
        this.a.b((ey)new dw(this.bY, 7, par1TileEntityBeacon.b(), par1TileEntityBeacon.j_(), par1TileEntityBeacon.c()));
        this.bp = new vd(this.bn, par1TileEntityBeacon);
        this.bp.d = this.bY;
        this.bp.a(this);
    }

    @Override
    public void a(abk par1IMerchant, String par2Str) {
        this.bN();
        this.bp = new vz(this.bn, par1IMerchant, this.q);
        this.bp.d = this.bY;
        this.bp.a(this);
        vy inventorymerchant = ((vz)this.bp).e();
        this.a.b((ey)new dw(this.bY, 6, par2Str == null ? "" : par2Str, inventorymerchant.j_(), par2Str != null));
        abm merchantrecipelist = par1IMerchant.b((uf)this);
        if (merchantrecipelist != null) {
            try {
                ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
                DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);
                dataoutputstream.writeInt(this.bY);
                merchantrecipelist.a(dataoutputstream);
                this.a.b((ey)new ea("MC|TrList", bytearrayoutputstream.toByteArray()));
            }
            catch (IOException ioexception) {
                ioexception.printStackTrace();
            }
        }
    }

    @Override
    public void a(rs par1EntityHorse, mo par2IInventory) {
        if (this.bp != this.bo) {
            this.i();
        }
        this.bN();
        this.a.b((ey)new dw(this.bY, 11, par2IInventory.b(), par2IInventory.j_(), par2IInventory.c(), par1EntityHorse.k));
        this.bp = new vs((mo)this.bn, par2IInventory, par1EntityHorse);
        this.bp.d = this.bY;
        this.bp.a(this);
    }

    public void a(uy par1Container, int par2, ye par3ItemStack) {
        if (!(par1Container.a(par2) instanceof wd) && !this.h) {
            this.a.b((ey)new dz(par1Container.d, par2, par3ItemStack));
        }
    }

    public void a(uy par1Container) {
        this.a(par1Container, par1Container.a());
    }

    public void a(uy par1Container, List par2List) {
        this.a.b((ey)new dx(par1Container.d, par2List));
        this.a.b((ey)new dz(-1, -1, this.bn.o()));
    }

    public void a(uy par1Container, int par2, int par3) {
        this.a.b((ey)new dy(par1Container.d, par2, par3));
    }

    @Override
    public void i() {
        this.a.b((ey)new dv(this.bp.d));
        this.k();
    }

    public void j() {
        if (!this.h) {
            this.a.b((ey)new dz(-1, -1, this.bn.o()));
        }
    }

    public void k() {
        this.bp.b(this);
        this.bp = this.bo;
    }

    public void a(float par1, float par2, boolean par3, boolean par4) {
        if (this.o != null) {
            if (par1 >= -1.0f && par1 <= 1.0f) {
                this.be = par1;
            }
            if (par2 >= -1.0f && par2 <= 1.0f) {
                this.bf = par2;
            }
            this.bd = par3;
            this.b(par4);
        }
    }

    @Override
    public void a(ku par1StatBase, int par2) {
        if (par1StatBase != null && !par1StatBase.f) {
            this.a.b((ey)new dk(par1StatBase.e, par2));
        }
    }

    public void l() {
        if (this.n != null) {
            this.n.a((nn)this);
        }
        if (this.bC) {
            this.a(true, false, false);
        }
    }

    public void m() {
        this.bP = -1.0E8f;
    }

    @Override
    public void a(String par1Str) {
        this.a.b((ey)new dm(cv.e(par1Str)));
    }

    @Override
    protected void n() {
        this.a.b((ey)new ed(this.k, 9));
        super.n();
    }

    @Override
    public void a(ye par1ItemStack, int par2) {
        super.a(par1ItemStack, par2);
        if (par1ItemStack != null && par1ItemStack.b() != null && par1ItemStack.b().c_(par1ItemStack) == zj.b) {
            this.p().q().b(this, (ey)new dj((nn)this, 5));
        }
    }

    @Override
    public void a(uf par1EntityPlayer, boolean par2) {
        super.a(par1EntityPlayer, par2);
        this.bS = -1;
        this.bP = -1.0f;
        this.bQ = -1;
        this.g.addAll(((jv)par1EntityPlayer).g);
    }

    @Override
    protected void a(nj par1PotionEffect) {
        super.a(par1PotionEffect);
        this.a.b((ey)new gj(this.k, par1PotionEffect));
    }

    @Override
    protected void a(nj par1PotionEffect, boolean par2) {
        super.a(par1PotionEffect, par2);
        this.a.b((ey)new gj(this.k, par1PotionEffect));
    }

    @Override
    protected void b(nj par1PotionEffect) {
        super.b(par1PotionEffect);
        this.a.b((ey)new fg(this.k, par1PotionEffect));
    }

    @Override
    public void a(double par1, double par3, double par5) {
        this.a.a(par1, par3, par5, this.A, this.B);
    }

    @Override
    public void b(nn par1Entity) {
        this.p().q().b(this, (ey)new dj(par1Entity, 6));
    }

    @Override
    public void c(nn par1Entity) {
        this.p().q().b(this, (ey)new dj(par1Entity, 7));
    }

    @Override
    public void o() {
        if (this.a != null) {
            this.a.b((ey)new fa(this.bG));
        }
    }

    public js p() {
        return (js)this.q;
    }

    @Override
    public void a(ace par1EnumGameType) {
        this.c.a(par1EnumGameType);
        this.a.b((ey)new ef(3, par1EnumGameType.a()));
    }

    public void a(cv par1ChatMessageComponent) {
        this.a.b((ey)new dm(par1ChatMessageComponent));
    }

    public boolean a(int par1, String par2Str) {
        return "seed".equals(par2Str) && !this.b.V() ? true : (!("tell".equals(par2Str) || "help".equals(par2Str) || "me".equals(par2Str)) ? (this.b.af().e(this.bu) ? this.b.k() >= par1 : false) : true);
    }

    public String q() {
        String s2 = this.a.a.c().toString();
        s2 = s2.substring(s2.indexOf("/") + 1);
        s2 = s2.substring(0, s2.indexOf(":"));
        return s2;
    }

    public void a(dp par1Packet204ClientInfo) {
        this.bN = par1Packet204ClientInfo.d();
        int i2 = 256 >> par1Packet204ClientInfo.f();
        if (i2 > 3 && i2 < 15) {
            this.bU = i2;
        }
        this.bV = par1Packet204ClientInfo.g();
        this.bW = par1Packet204ClientInfo.h();
        if (this.b.K() && this.b.J().equals(this.bu)) {
            this.b.c(par1Packet204ClientInfo.i());
        }
        this.b(1, !par1Packet204ClientInfo.j());
    }

    public int t() {
        return this.bV;
    }

    public void a(String par1Str, int par2) {
        String s1 = par1Str + "\u0000" + par2;
        this.a.b((ey)new ea("MC|TPack", s1.getBytes()));
    }

    public t b() {
        return new t(ls.c(this.u), ls.c(this.v + 0.5), ls.c(this.w));
    }

    public void u() {
        this.bX = MinecraftServer.aq();
    }

    @Override
    public float getDefaultEyeHeight() {
        return 1.62f;
    }
}

