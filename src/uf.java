/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aaw
 *  abh
 *  abk
 *  ad
 *  ado
 *  akc
 *  anb
 *  arx
 *  asc
 *  asg
 *  asx
 *  atc
 *  ate
 *  atf
 *  atg
 *  atj
 *  atl
 *  ato
 *  cpw.mods.fml.common.FMLCommonHandler
 *  cpw.mods.fml.common.network.FMLNetworkHandler
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  kp
 *  ku
 *  la
 *  mo
 *  ms
 *  nb
 *  net.minecraftforge.common.ForgeHooks
 *  net.minecraftforge.common.ISpecialArmor$ArmorProperties
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.Event
 *  net.minecraftforge.event.ForgeEventFactory
 *  net.minecraftforge.event.entity.player.AttackEntityEvent
 *  net.minecraftforge.event.entity.player.EntityInteractEvent
 *  net.minecraftforge.event.entity.player.PlayerDestroyItemEvent
 *  net.minecraftforge.event.entity.player.PlayerDropsEvent
 *  net.minecraftforge.event.entity.player.PlayerFlyableFallEvent
 *  net.minecraftforge.event.entity.player.PlayerSleepInBedEvent
 *  ni
 *  os
 *  sh
 *  si
 *  t
 *  th
 *  uc
 *  ud
 *  ux
 *  vv
 *  wb
 */
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.event.entity.player.PlayerFlyableFallEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;

public abstract class uf
extends of
implements ad {
    public static final String PERSISTED_NBT_TAG = "PlayerPersisted";
    public ud bn = new ud(this);
    private wb a = new wb();
    public uy bo;
    public uy bp;
    protected ux bq = new ux();
    protected int br;
    public float bs;
    public float bt;
    public final String bu;
    public int bv;
    public double bw;
    public double bx;
    public double by;
    public double bz;
    public double bA;
    public double bB;
    protected boolean bC;
    public t bD;
    public int b;
    public float bE;
    @SideOnly(value=Side.CLIENT)
    public float cc;
    public float bF;
    private t c;
    private HashMap<Integer, t> spawnChunkMap = new HashMap();
    private boolean d;
    private HashMap<Integer, Boolean> spawnForcedMap = new HashMap();
    private t e;
    public uc bG = new uc();
    public int bH;
    public int bI;
    public float bJ;
    public ye f;
    private int g;
    protected float bK = 0.1f;
    protected float bL = 0.02f;
    private int h;
    public ul bM;
    public float eyeHeight;
    private String displayname;

    public uf(abw par1World, String par2Str) {
        super(par1World);
        this.bu = par2Str;
        this.bp = this.bo = new vv(this.bn, !par1World.I, this);
        this.N = 1.62f;
        t chunkcoordinates = par1World.K();
        this.b((double)chunkcoordinates.a + 0.5, chunkcoordinates.b + 1, (double)chunkcoordinates.c + 0.5, 0.0f, 0.0f);
        this.ba = 180.0f;
        this.ad = 20;
        this.eyeHeight = this.getDefaultEyeHeight();
    }

    @Override
    protected void az() {
        super.az();
        this.aX().b(tp.e).a(1.0);
    }

    @Override
    protected void a() {
        super.a();
        this.ah.a(16, (Object)0);
        this.ah.a(17, Float.valueOf(0.0f));
        this.ah.a(18, (Object)0);
    }

    @SideOnly(value=Side.CLIENT)
    public ye bp() {
        return this.f;
    }

    @SideOnly(value=Side.CLIENT)
    public int bq() {
        return this.g;
    }

    public boolean br() {
        return this.f != null;
    }

    @SideOnly(value=Side.CLIENT)
    public int bs() {
        return this.br() ? this.f.n() - this.g : 0;
    }

    public void bt() {
        if (this.f != null) {
            this.f.b(this.q, this, this.g);
        }
        this.bu();
    }

    public void bu() {
        this.f = null;
        this.g = 0;
        if (!this.q.I) {
            this.e(false);
        }
    }

    public boolean bv() {
        return this.br() && yc.g[this.f.d].c_(this.f) == zj.d;
    }

    @Override
    public void l_() {
        FMLCommonHandler.instance().onPlayerPreTick(this);
        if (this.f != null) {
            ye itemstack = this.bn.h();
            if (itemstack == this.f) {
                this.f.b().onUsingItemTick(this.f, this, this.g);
                if (this.g <= 25 && this.g % 4 == 0) {
                    this.c(itemstack, 5);
                }
                if (--this.g == 0 && !this.q.I) {
                    this.n();
                }
            } else {
                this.bu();
            }
        }
        if (this.bv > 0) {
            --this.bv;
        }
        if (this.bh()) {
            ++this.b;
            if (this.b > 100) {
                this.b = 100;
            }
            if (!this.q.I) {
                if (!this.h()) {
                    this.a(true, true, false);
                } else if (this.q.v()) {
                    this.a(false, true, true);
                }
            }
        } else if (this.b > 0) {
            ++this.b;
            if (this.b >= 110) {
                this.b = 0;
            }
        }
        super.l_();
        if (!this.q.I && this.bp != null && !ForgeHooks.canInteractWith((uf)this, (uy)this.bp)) {
            this.i();
            this.bp = this.bo;
        }
        if (this.af() && this.bG.a) {
            this.B();
        }
        this.bw = this.bz;
        this.bx = this.bA;
        this.by = this.bB;
        double d0 = this.u - this.bz;
        double d1 = this.v - this.bA;
        double d2 = this.w - this.bB;
        double d3 = 10.0;
        if (d0 > d3) {
            this.bw = this.bz = this.u;
        }
        if (d2 > d3) {
            this.by = this.bB = this.w;
        }
        if (d1 > d3) {
            this.bx = this.bA = this.v;
        }
        if (d0 < -d3) {
            this.bw = this.bz = this.u;
        }
        if (d2 < -d3) {
            this.by = this.bB = this.w;
        }
        if (d1 < -d3) {
            this.bx = this.bA = this.v;
        }
        this.bz += d0 * 0.25;
        this.bB += d2 * 0.25;
        this.bA += d1 * 0.25;
        this.a(la.k, 1);
        if (this.o == null) {
            this.e = null;
        }
        if (!this.q.I) {
            this.bq.a(this);
        }
        FMLCommonHandler.instance().onPlayerPostTick(this);
    }

    @Override
    public int z() {
        return this.bG.a ? 0 : 80;
    }

    @Override
    public int ac() {
        return 10;
    }

    @Override
    public void a(String par1Str, float par2, float par3) {
        this.q.a(this, par1Str, par2, par3);
    }

    protected void c(ye par1ItemStack, int par2) {
        if (par1ItemStack.o() == zj.c) {
            this.a("random.drink", 0.5f, this.q.s.nextFloat() * 0.1f + 0.9f);
        }
        if (par1ItemStack.o() == zj.b) {
            for (int j2 = 0; j2 < par2; ++j2) {
                atc vec3 = this.q.V().a(((double)this.ab.nextFloat() - 0.5) * 0.1, Math.random() * 0.1 + 0.1, 0.0);
                vec3.a(-this.B * (float)Math.PI / 180.0f);
                vec3.b(-this.A * (float)Math.PI / 180.0f);
                atc vec31 = this.q.V().a(((double)this.ab.nextFloat() - 0.5) * 0.3, (double)(-this.ab.nextFloat()) * 0.6 - 0.3, 0.6);
                vec31.a(-this.B * (float)Math.PI / 180.0f);
                vec31.b(-this.A * (float)Math.PI / 180.0f);
                vec31 = vec31.c(this.u, this.v + (double)this.f(), this.w);
                this.q.a("iconcrack_" + par1ItemStack.b().cv + "_" + par1ItemStack.k(), vec31.c, vec31.d, vec31.e, vec3.c, vec3.d + 0.05, vec3.e);
            }
            this.a("random.eat", 0.5f + 0.5f * (float)this.ab.nextInt(2), (this.ab.nextFloat() - this.ab.nextFloat()) * 0.2f + 1.0f);
        }
    }

    protected void n() {
        if (this.f != null) {
            this.c(this.f, 16);
            int i2 = this.f.b;
            ye itemstack = this.f.b(this.q, this);
            if (itemstack != this.f || itemstack != null && itemstack.b != i2) {
                this.bn.a[this.bn.c] = itemstack;
                if (itemstack.b == 0) {
                    this.bn.a[this.bn.c] = null;
                }
            }
            this.bu();
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(byte par1) {
        if (par1 == 9) {
            this.n();
        } else {
            super.a(par1);
        }
    }

    @Override
    protected boolean bc() {
        return this.aN() <= 0.0f || this.bh();
    }

    public void i() {
        this.bp = this.bo;
    }

    @Override
    public void a(nn par1Entity) {
        if (this.o != null && par1Entity == null) {
            if (!this.q.I) {
                this.l(this.o);
            }
            if (this.o != null) {
                this.o.n = null;
            }
            this.o = null;
        } else {
            super.a(par1Entity);
        }
    }

    @Override
    public void V() {
        if (!this.q.I && this.ah()) {
            this.a((nn)null);
            this.b(false);
        } else {
            double d0 = this.u;
            double d1 = this.v;
            double d2 = this.w;
            float f2 = this.A;
            float f1 = this.B;
            super.V();
            this.bs = this.bt;
            this.bt = 0.0f;
            this.k(this.u - d0, this.v - d1, this.w - d2);
            if (this.o instanceof of && ((of)this.o).shouldRiderFaceForward(this)) {
                this.B = f1;
                this.A = f2;
                this.aN = ((of)this.o).aN;
            }
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void w() {
        this.N = 1.62f;
        this.a(0.6f, 1.8f);
        super.w();
        this.g(this.aT());
        this.aB = 0;
    }

    @Override
    protected void bl() {
        super.bl();
        this.aW();
    }

    @Override
    public void c() {
        if (this.br > 0) {
            --this.br;
        }
        if (this.q.r == 0 && this.aN() < this.aT() && this.q.O().b("naturalRegeneration") && this.ac % 20 * 12 == 0) {
            this.f(1.0f);
        }
        this.bn.k();
        this.bs = this.bt;
        super.c();
        os attributeinstance = this.a(tp.d);
        if (!this.q.I) {
            attributeinstance.a((double)this.bG.b());
        }
        this.aR = this.bL;
        if (this.ai()) {
            this.aR = (float)((double)this.aR + (double)this.bL * 0.3);
        }
        this.i((float)attributeinstance.e());
        float f2 = ls.a(this.x * this.x + this.z * this.z);
        float f1 = (float)Math.atan(-this.y * (double)0.2f) * 15.0f;
        if (f2 > 0.1f) {
            f2 = 0.1f;
        }
        if (!this.F || this.aN() <= 0.0f) {
            f2 = 0.0f;
        }
        if (this.F || this.aN() <= 0.0f) {
            f1 = 0.0f;
        }
        this.bt += (f2 - this.bt) * 0.4f;
        this.aK += (f1 - this.aK) * 0.8f;
        if (this.aN() > 0.0f) {
            asx axisalignedbb = null;
            axisalignedbb = this.o != null && !this.o.M ? this.E.a(this.o.E).b(1.0, 0.0, 1.0) : this.E.b(1.0, 0.5, 1.0);
            List list = this.q.b((nn)this, axisalignedbb);
            if (list != null) {
                for (int i2 = 0; i2 < list.size(); ++i2) {
                    nn entity = (nn)list.get(i2);
                    if (entity.M) continue;
                    this.r(entity);
                }
            }
        }
    }

    private void r(nn par1Entity) {
        par1Entity.b_(this);
    }

    public int bw() {
        return this.ah.c(18);
    }

    public void c(int par1) {
        this.ah.b(18, par1);
    }

    public void p(int par1) {
        int j2 = this.bw();
        this.ah.b(18, j2 + par1);
    }

    @Override
    public void a(nb par1DamageSource) {
        PlayerDropsEvent event;
        if (ForgeHooks.onLivingDeath((of)this, (nb)par1DamageSource)) {
            return;
        }
        super.a(par1DamageSource);
        this.a(0.2f, 0.2f);
        this.b(this.u, this.v, this.w);
        this.y = 0.1f;
        this.captureDrops = true;
        this.capturedDrops.clear();
        if (this.bu.equals("Notch")) {
            this.a(new ye(yc.l, 1), true);
        }
        if (!this.q.O().b("keepInventory")) {
            this.bn.m();
        }
        this.captureDrops = false;
        if (!this.q.I && !MinecraftForge.EVENT_BUS.post((Event)(event = new PlayerDropsEvent(this, par1DamageSource, this.capturedDrops, this.aT > 0)))) {
            for (ss item : this.capturedDrops) {
                this.a(item);
            }
        }
        if (par1DamageSource != null) {
            this.x = -ls.b((this.aA + this.A) * (float)Math.PI / 180.0f) * 0.1f;
            this.z = -ls.a((this.aA + this.A) * (float)Math.PI / 180.0f) * 0.1f;
        } else {
            this.z = 0.0;
            this.x = 0.0;
        }
        this.N = 0.1f;
        this.a(la.y, 1);
    }

    @Override
    public void b(nn par1Entity, int par2) {
        this.p(par2);
        Collection collection = this.bM().a(ato.e);
        if (par1Entity instanceof uf) {
            this.a(la.A, 1);
            collection.addAll(this.bM().a(ato.d));
        } else {
            this.a(la.z, 1);
        }
        for (ate scoreobjective : collection) {
            atg score = this.bM().a(this.an(), scoreobjective);
            score.a();
        }
    }

    public ss a(boolean par1) {
        ye stack = this.bn.h();
        if (stack == null) {
            return null;
        }
        if (stack.b().onDroppedByPlayer(stack, this)) {
            int count = par1 && this.bn.h() != null ? this.bn.h().b : 1;
            return ForgeHooks.onPlayerTossEvent((uf)this, (ye)this.bn.a(this.bn.c, count));
        }
        return null;
    }

    public ss b(ye par1ItemStack) {
        return ForgeHooks.onPlayerTossEvent((uf)this, (ye)par1ItemStack);
    }

    public ss a(ye par1ItemStack, boolean par2) {
        if (par1ItemStack == null) {
            return null;
        }
        if (par1ItemStack.b == 0) {
            return null;
        }
        ss entityitem = new ss(this.q, this.u, this.v - (double)0.3f + (double)this.f(), this.w, par1ItemStack);
        entityitem.b = 40;
        float f2 = 0.1f;
        if (par2) {
            float f1 = this.ab.nextFloat() * 0.5f;
            float f22 = this.ab.nextFloat() * (float)Math.PI * 2.0f;
            entityitem.x = -ls.a(f22) * f1;
            entityitem.z = ls.b(f22) * f1;
            entityitem.y = 0.2f;
        } else {
            f2 = 0.3f;
            entityitem.x = -ls.a(this.A / 180.0f * (float)Math.PI) * ls.b(this.B / 180.0f * (float)Math.PI) * f2;
            entityitem.z = ls.b(this.A / 180.0f * (float)Math.PI) * ls.b(this.B / 180.0f * (float)Math.PI) * f2;
            entityitem.y = -ls.a(this.B / 180.0f * (float)Math.PI) * f2 + 0.1f;
            f2 = 0.02f;
            float f1 = this.ab.nextFloat() * (float)Math.PI * 2.0f;
            entityitem.x += Math.cos(f1) * (double)(f2 *= this.ab.nextFloat());
            entityitem.y += (double)((this.ab.nextFloat() - this.ab.nextFloat()) * 0.1f);
            entityitem.z += Math.sin(f1) * (double)f2;
        }
        this.a(entityitem);
        this.a(la.v, 1);
        return entityitem;
    }

    public void a(ss par1EntityItem) {
        if (this.captureDrops) {
            this.capturedDrops.add(par1EntityItem);
            return;
        }
        this.q.d(par1EntityItem);
    }

    @Deprecated
    public float a(aqz par1Block, boolean par2) {
        return this.getCurrentPlayerStrVsBlock(par1Block, par2, 0);
    }

    public float getCurrentPlayerStrVsBlock(aqz par1Block, boolean par2, int meta) {
        float f2;
        ye stack = this.bn.h();
        float f3 = f2 = stack == null ? 1.0f : stack.b().getStrVsBlock(stack, par1Block, meta);
        if (f2 > 1.0f) {
            int i2 = aaw.c((of)this);
            ye itemstack = this.bn.h();
            if (i2 > 0 && itemstack != null) {
                float f1 = i2 * i2 + 1;
                boolean canHarvest = ForgeHooks.canToolHarvestBlock((aqz)par1Block, (int)meta, (ye)itemstack);
                f2 = !canHarvest && f2 <= 1.0f ? (f2 += f1 * 0.08f) : (f2 += f1);
            }
        }
        if (this.a(ni.e)) {
            f2 *= 1.0f + (float)(this.b(ni.e).c() + 1) * 0.2f;
        }
        if (this.a(ni.f)) {
            f2 *= 1.0f - (float)(this.b(ni.f).c() + 1) * 0.2f;
        }
        if (this.a(akc.h) && !aaw.h((of)this)) {
            f2 /= 5.0f;
        }
        if (!this.F) {
            f2 /= 5.0f;
        }
        return (f2 = ForgeEventFactory.getBreakSpeed((uf)this, (aqz)par1Block, (int)meta, (float)f2)) < 0.0f ? 0.0f : f2;
    }

    public boolean a(aqz par1Block) {
        return ForgeEventFactory.doPlayerHarvestCheck((uf)this, (aqz)par1Block, (boolean)this.bn.b(par1Block));
    }

    @Override
    public void a(by par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        cg nbttaglist = par1NBTTagCompound.m("Inventory");
        this.bn.b(nbttaglist);
        this.bn.c = par1NBTTagCompound.e("SelectedItemSlot");
        this.bC = par1NBTTagCompound.n("Sleeping");
        this.b = par1NBTTagCompound.d("SleepTimer");
        this.bJ = par1NBTTagCompound.g("XpP");
        this.bH = par1NBTTagCompound.e("XpLevel");
        this.bI = par1NBTTagCompound.e("XpTotal");
        this.c(par1NBTTagCompound.e("Score"));
        if (this.bC) {
            this.bD = new t(ls.c(this.u), ls.c(this.v), ls.c(this.w));
            this.a(true, true, false);
        }
        if (par1NBTTagCompound.b("SpawnX") && par1NBTTagCompound.b("SpawnY") && par1NBTTagCompound.b("SpawnZ")) {
            this.c = new t(par1NBTTagCompound.e("SpawnX"), par1NBTTagCompound.e("SpawnY"), par1NBTTagCompound.e("SpawnZ"));
            this.d = par1NBTTagCompound.n("SpawnForced");
        }
        cg spawnlist = null;
        spawnlist = par1NBTTagCompound.m("Spawns");
        for (int i2 = 0; i2 < spawnlist.c(); ++i2) {
            by spawndata = (by)spawnlist.b(i2);
            int spawndim = spawndata.e("Dim");
            this.spawnChunkMap.put(spawndim, new t(spawndata.e("SpawnX"), spawndata.e("SpawnY"), spawndata.e("SpawnZ")));
            this.spawnForcedMap.put(spawndim, spawndata.n("SpawnForced"));
        }
        this.bq.a(par1NBTTagCompound);
        this.bG.b(par1NBTTagCompound);
        if (par1NBTTagCompound.b("EnderItems")) {
            cg nbttaglist1 = par1NBTTagCompound.m("EnderItems");
            this.a.a(nbttaglist1);
        }
    }

    @Override
    public void b(by par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("Inventory", this.bn.a(new cg()));
        par1NBTTagCompound.a("SelectedItemSlot", this.bn.c);
        par1NBTTagCompound.a("Sleeping", this.bC);
        par1NBTTagCompound.a("SleepTimer", (short)this.b);
        par1NBTTagCompound.a("XpP", this.bJ);
        par1NBTTagCompound.a("XpLevel", this.bH);
        par1NBTTagCompound.a("XpTotal", this.bI);
        par1NBTTagCompound.a("Score", this.bw());
        if (this.c != null) {
            par1NBTTagCompound.a("SpawnX", this.c.a);
            par1NBTTagCompound.a("SpawnY", this.c.b);
            par1NBTTagCompound.a("SpawnZ", this.c.c);
            par1NBTTagCompound.a("SpawnForced", this.d);
        }
        cg spawnlist = new cg();
        for (Map.Entry<Integer, t> entry : this.spawnChunkMap.entrySet()) {
            by spawndata = new by();
            t spawn = entry.getValue();
            if (spawn == null) continue;
            Boolean forced = this.spawnForcedMap.get(entry.getKey());
            if (forced == null) {
                forced = false;
            }
            spawndata.a("Dim", (int)entry.getKey());
            spawndata.a("SpawnX", spawn.a);
            spawndata.a("SpawnY", spawn.b);
            spawndata.a("SpawnZ", spawn.c);
            spawndata.a("SpawnForced", forced);
            spawnlist.a(spawndata);
        }
        par1NBTTagCompound.a("Spawns", spawnlist);
        this.bq.b(par1NBTTagCompound);
        this.bG.a(par1NBTTagCompound);
        par1NBTTagCompound.a("EnderItems", this.a.h());
    }

    public void a(mo par1IInventory) {
    }

    public void a(asi par1TileEntityHopper) {
    }

    public void a(sx par1EntityMinecartHopper) {
    }

    public void a(rs par1EntityHorse, mo par2IInventory) {
    }

    public void a(int par1, int par2, int par3, String par4Str) {
    }

    public void c(int par1, int par2, int par3) {
    }

    public void b(int par1, int par2, int par3) {
    }

    @Override
    public float f() {
        return this.eyeHeight;
    }

    protected void d_() {
        this.N = 1.62f;
    }

    @Override
    public boolean a(nb par1DamageSource, float par2) {
        if (ForgeHooks.onLivingAttack((of)this, (nb)par1DamageSource, (float)par2)) {
            return false;
        }
        if (this.ar()) {
            return false;
        }
        if (this.bG.a && !par1DamageSource.g()) {
            return false;
        }
        this.aV = 0;
        if (this.aN() <= 0.0f) {
            return false;
        }
        if (this.bh() && !this.q.I) {
            this.a(true, true, false);
        }
        if (par1DamageSource.p()) {
            if (this.q.r == 0) {
                par2 = 0.0f;
            }
            if (this.q.r == 1) {
                par2 = par2 / 2.0f + 1.0f;
            }
            if (this.q.r == 3) {
                par2 = par2 * 3.0f / 2.0f;
            }
        }
        if (par2 == 0.0f) {
            return false;
        }
        nn entity = par1DamageSource.i();
        if (entity instanceof uh && ((uh)entity).c != null) {
            entity = ((uh)entity).c;
        }
        this.a(la.x, Math.round(par2 * 10.0f));
        return super.a(par1DamageSource, par2);
    }

    public boolean a(uf par1EntityPlayer) {
        atl team = this.bo();
        atl team1 = par1EntityPlayer.bo();
        return team == null ? true : (!team.a(team1) ? true : team.g());
    }

    @Override
    protected void h(float par1) {
        this.bn.a(par1);
    }

    @Override
    public int aQ() {
        return this.bn.l();
    }

    public float bx() {
        int i2 = 0;
        for (ye itemstack : this.bn.b) {
            if (itemstack == null) continue;
            ++i2;
        }
        return (float)i2 / (float)this.bn.b.length;
    }

    @Override
    protected void d(nb par1DamageSource, float par2) {
        if (!this.ar()) {
            if ((par2 = ForgeHooks.onLivingHurt((of)this, (nb)par1DamageSource, (float)par2)) <= 0.0f) {
                return;
            }
            if (!par1DamageSource.e() && this.bv() && par2 > 0.0f) {
                par2 = (1.0f + par2) * 0.5f;
            }
            if ((par2 = ISpecialArmor.ArmorProperties.ApplyArmor((of)this, (ye[])this.bn.b, (nb)par1DamageSource, (double)par2)) <= 0.0f) {
                return;
            }
            float f1 = par2 = this.c(par1DamageSource, par2);
            par2 = Math.max(par2 - this.bn(), 0.0f);
            this.m(this.bn() - (f1 - par2));
            if (par2 != 0.0f) {
                this.a(par1DamageSource.f());
                float f2 = this.aN();
                this.g(this.aN() - par2);
                this.aR().a(par1DamageSource, f2, par2);
            }
        }
    }

    public void a(asg par1TileEntityFurnace) {
    }

    public void a(asc par1TileEntityDispenser) {
    }

    public void a(asp par1TileEntity) {
    }

    public void a(arx par1TileEntityBrewingStand) {
    }

    public void a(arw par1TileEntityBeacon) {
    }

    public void a(abk par1IMerchant, String par2Str) {
    }

    public void c(ye par1ItemStack) {
    }

    public boolean p(nn par1Entity) {
        ye itemstack1;
        if (MinecraftForge.EVENT_BUS.post((Event)new EntityInteractEvent(this, par1Entity))) {
            return false;
        }
        ye itemstack = this.by();
        ye ye2 = itemstack1 = itemstack != null ? itemstack.m() : null;
        if (!par1Entity.c(this)) {
            if (itemstack != null && par1Entity instanceof of) {
                if (this.bG.d) {
                    itemstack = itemstack1;
                }
                if (itemstack.a(this, (of)par1Entity)) {
                    if (itemstack.b <= 0 && !this.bG.d) {
                        this.bz();
                    }
                    return true;
                }
            }
            return false;
        }
        if (itemstack != null && itemstack == this.by()) {
            if (itemstack.b <= 0 && !this.bG.d) {
                this.bz();
            } else if (itemstack.b < itemstack1.b && this.bG.d) {
                itemstack.b = itemstack1.b;
            }
        }
        return true;
    }

    public ye by() {
        return this.bn.h();
    }

    public void bz() {
        ye orig = this.by();
        this.bn.a(this.bn.c, (ye)null);
        MinecraftForge.EVENT_BUS.post((Event)new PlayerDestroyItemEvent(this, orig));
    }

    @Override
    public double X() {
        return this.N - 0.5f;
    }

    public void q(nn par1Entity) {
        if (MinecraftForge.EVENT_BUS.post((Event)new AttackEntityEvent(this, par1Entity))) {
            return;
        }
        ye stack = this.by();
        if (stack != null && stack.b().onLeftClickEntity(stack, this, par1Entity)) {
            return;
        }
        if (par1Entity.aq() && !par1Entity.i(this)) {
            float f2 = (float)this.a(tp.e).e();
            int i2 = 0;
            float f1 = 0.0f;
            if (par1Entity instanceof of) {
                f1 = aaw.a((of)this, (of)((of)par1Entity));
                i2 += aaw.b((of)this, (of)((of)par1Entity));
            }
            if (this.ai()) {
                ++i2;
            }
            if (f2 > 0.0f || f1 > 0.0f) {
                sh ientitymultipart;
                boolean flag2;
                boolean flag;
                boolean bl2 = flag = this.T > 0.0f && !this.F && !this.e() && !this.H() && !this.a(ni.q) && this.o == null && par1Entity instanceof of;
                if (flag && f2 > 0.0f) {
                    f2 *= 1.5f;
                }
                f2 += f1;
                boolean flag1 = false;
                int j2 = aaw.a((of)this);
                if (par1Entity instanceof of && j2 > 0 && !par1Entity.af()) {
                    flag1 = true;
                    par1Entity.d(1);
                }
                if (flag2 = par1Entity.a(nb.a((uf)this), f2)) {
                    if (i2 > 0) {
                        par1Entity.g(-ls.a(this.A * (float)Math.PI / 180.0f) * (float)i2 * 0.5f, 0.1, ls.b(this.A * (float)Math.PI / 180.0f) * (float)i2 * 0.5f);
                        this.x *= 0.6;
                        this.z *= 0.6;
                        this.c(false);
                    }
                    if (flag) {
                        this.b(par1Entity);
                    }
                    if (f1 > 0.0f) {
                        this.c(par1Entity);
                    }
                    if (f2 >= 18.0f) {
                        this.a((ku)kp.E);
                    }
                    this.k(par1Entity);
                    if (par1Entity instanceof of) {
                        abh.a((nn)this, (of)((of)par1Entity), (Random)this.ab);
                    }
                }
                ye itemstack = this.by();
                nn object = par1Entity;
                if (par1Entity instanceof si && (ientitymultipart = ((si)par1Entity).a) != null && ientitymultipart instanceof of) {
                    object = (of)ientitymultipart;
                }
                if (itemstack != null && object instanceof of) {
                    itemstack.a((of)object, this);
                    if (itemstack.b <= 0) {
                        this.bz();
                    }
                }
                if (par1Entity instanceof of) {
                    this.a(la.w, Math.round(f2 * 10.0f));
                    if (j2 > 0 && flag2) {
                        par1Entity.d(j2 * 4);
                    } else if (flag1) {
                        par1Entity.B();
                    }
                }
                this.a(0.3f);
            }
        }
    }

    public void b(nn par1Entity) {
    }

    public void c(nn par1Entity) {
    }

    @SideOnly(value=Side.CLIENT)
    public void bA() {
    }

    @Override
    public void x() {
        super.x();
        this.bo.b(this);
        if (this.bp != null) {
            this.bp.b(this);
        }
    }

    @Override
    public boolean U() {
        return !this.bC && super.U();
    }

    public ug a(int par1, int par2, int par3) {
        PlayerSleepInBedEvent event = new PlayerSleepInBedEvent(this, par1, par2, par3);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (event.result != null) {
            return event.result;
        }
        if (!this.q.I) {
            if (this.bh() || !this.T()) {
                return ug.e;
            }
            if (!this.q.t.d()) {
                return ug.b;
            }
            if (this.q.v()) {
                return ug.c;
            }
            if (Math.abs(this.u - (double)par1) > 3.0 || Math.abs(this.v - (double)par2) > 2.0 || Math.abs(this.w - (double)par3) > 3.0) {
                return ug.d;
            }
            double d0 = 8.0;
            double d1 = 5.0;
            List list = this.q.a(tm.class, asx.a().a((double)par1 - d0, (double)par2 - d1, (double)par3 - d0, (double)par1 + d0, (double)par2 + d1, (double)par3 + d0));
            if (!list.isEmpty()) {
                return ug.f;
            }
        }
        if (this.ag()) {
            this.a((nn)null);
        }
        this.a(0.2f, 0.2f);
        this.N = 0.2f;
        if (this.q.f(par1, par2, par3)) {
            int l2 = this.q.h(par1, par2, par3);
            int i1 = anb.j((int)l2);
            aqz block = aqz.s[this.q.a(par1, par2, par3)];
            if (block != null) {
                i1 = block.getBedDirection(this.q, par1, par2, par3);
            }
            float f2 = 0.5f;
            float f1 = 0.5f;
            switch (i1) {
                case 0: {
                    f1 = 0.9f;
                    break;
                }
                case 1: {
                    f2 = 0.1f;
                    break;
                }
                case 2: {
                    f1 = 0.1f;
                    break;
                }
                case 3: {
                    f2 = 0.9f;
                }
            }
            this.t(i1);
            this.b((float)par1 + f2, (float)par2 + 0.9375f, (float)par3 + f1);
        } else {
            this.b((float)par1 + 0.5f, (float)par2 + 0.9375f, (float)par3 + 0.5f);
        }
        this.bC = true;
        this.b = 0;
        this.bD = new t(par1, par2, par3);
        this.y = 0.0;
        this.z = 0.0;
        this.x = 0.0;
        if (!this.q.I) {
            this.q.c();
        }
        return ug.a;
    }

    private void t(int par1) {
        this.bE = 0.0f;
        this.bF = 0.0f;
        switch (par1) {
            case 0: {
                this.bF = -1.8f;
                break;
            }
            case 1: {
                this.bE = 1.8f;
                break;
            }
            case 2: {
                this.bF = 1.8f;
                break;
            }
            case 3: {
                this.bE = -1.8f;
            }
        }
    }

    public void a(boolean par1, boolean par2, boolean par3) {
        aqz block;
        this.a(0.6f, 1.8f);
        this.d_();
        t chunkcoordinates = this.bD;
        t chunkcoordinates1 = this.bD;
        aqz aqz2 = block = chunkcoordinates == null ? null : aqz.s[this.q.a(chunkcoordinates.a, chunkcoordinates.b, chunkcoordinates.c)];
        if (chunkcoordinates != null && block != null && block.isBed(this.q, chunkcoordinates.a, chunkcoordinates.b, chunkcoordinates.c, this)) {
            block.setBedOccupied(this.q, chunkcoordinates.a, chunkcoordinates.b, chunkcoordinates.c, this, false);
            chunkcoordinates1 = block.getBedSpawnPosition(this.q, chunkcoordinates.a, chunkcoordinates.b, chunkcoordinates.c, this);
            if (chunkcoordinates1 == null) {
                chunkcoordinates1 = new t(chunkcoordinates.a, chunkcoordinates.b + 1, chunkcoordinates.c);
            }
            this.b((float)chunkcoordinates1.a + 0.5f, (float)chunkcoordinates1.b + this.N + 0.1f, (float)chunkcoordinates1.c + 0.5f);
        }
        this.bC = false;
        if (!this.q.I && par2) {
            this.q.c();
        }
        this.b = par1 ? 0 : 100;
        if (par3) {
            this.a(this.bD, false);
        }
    }

    private boolean h() {
        t c2 = this.bD;
        int blockID = this.q.a(c2.a, c2.b, c2.c);
        return aqz.s[blockID] != null && aqz.s[blockID].isBed(this.q, c2.a, c2.b, c2.c, this);
    }

    public static t a(abw par0World, t par1ChunkCoordinates, boolean par2) {
        ado ichunkprovider = par0World.L();
        ichunkprovider.c(par1ChunkCoordinates.a - 3 >> 4, par1ChunkCoordinates.c - 3 >> 4);
        ichunkprovider.c(par1ChunkCoordinates.a + 3 >> 4, par1ChunkCoordinates.c - 3 >> 4);
        ichunkprovider.c(par1ChunkCoordinates.a - 3 >> 4, par1ChunkCoordinates.c + 3 >> 4);
        ichunkprovider.c(par1ChunkCoordinates.a + 3 >> 4, par1ChunkCoordinates.c + 3 >> 4);
        t c2 = par1ChunkCoordinates;
        aqz block = aqz.s[par0World.a(c2.a, c2.b, c2.c)];
        if (block != null && block.isBed(par0World, c2.a, c2.b, c2.c, null)) {
            t chunkcoordinates1 = block.getBedSpawnPosition(par0World, c2.a, c2.b, c2.c, null);
            return chunkcoordinates1;
        }
        akc material = par0World.g(par1ChunkCoordinates.a, par1ChunkCoordinates.b, par1ChunkCoordinates.c);
        akc material1 = par0World.g(par1ChunkCoordinates.a, par1ChunkCoordinates.b + 1, par1ChunkCoordinates.c);
        boolean flag1 = !material.a() && !material.d();
        boolean flag2 = !material1.a() && !material1.d();
        return par2 && flag1 && flag2 ? par1ChunkCoordinates : null;
    }

    @SideOnly(value=Side.CLIENT)
    public float bC() {
        if (this.bD != null) {
            int x2 = this.bD.a;
            int y2 = this.bD.b;
            int z2 = this.bD.c;
            aqz block = aqz.s[this.q.a(x2, y2, z2)];
            int i2 = block == null ? 0 : block.getBedDirection(this.q, x2, y2, z2);
            switch (i2) {
                case 0: {
                    return 90.0f;
                }
                case 1: {
                    return 0.0f;
                }
                case 2: {
                    return 270.0f;
                }
                case 3: {
                    return 180.0f;
                }
            }
        }
        return 0.0f;
    }

    @Override
    public boolean bh() {
        return this.bC;
    }

    public boolean bD() {
        return this.bC && this.b >= 100;
    }

    @SideOnly(value=Side.CLIENT)
    public int bE() {
        return this.b;
    }

    @SideOnly(value=Side.CLIENT)
    protected boolean r(int par1) {
        return (this.ah.a(16) & 1 << par1) != 0;
    }

    protected void b(int par1, boolean par2) {
        byte b0 = this.ah.a(16);
        if (par2) {
            this.ah.b(16, (byte)(b0 | 1 << par1));
        } else {
            this.ah.b(16, (byte)(b0 & ~(1 << par1)));
        }
    }

    public void a(String par1Str) {
    }

    @Deprecated
    public t bF() {
        return this.getBedLocation(this.ar);
    }

    @Deprecated
    public boolean bG() {
        return this.isSpawnForced(this.ar);
    }

    public t getBedLocation(int dimension) {
        if (dimension == 0) {
            return this.c;
        }
        return this.spawnChunkMap.get(dimension);
    }

    public boolean isSpawnForced(int dimension) {
        if (dimension == 0) {
            return this.d;
        }
        Boolean forced = this.spawnForcedMap.get(dimension);
        if (forced == null) {
            return false;
        }
        return forced;
    }

    public void a(t par1ChunkCoordinates, boolean par2) {
        if (this.ar != 0) {
            this.setSpawnChunk(par1ChunkCoordinates, par2, this.ar);
            return;
        }
        if (par1ChunkCoordinates != null) {
            this.c = new t(par1ChunkCoordinates);
            this.d = par2;
        } else {
            this.c = null;
            this.d = false;
        }
    }

    public void setSpawnChunk(t chunkCoordinates, boolean forced, int dimension) {
        if (dimension == 0) {
            if (chunkCoordinates != null) {
                this.c = new t(chunkCoordinates);
                this.d = forced;
            } else {
                this.c = null;
                this.d = false;
            }
            return;
        }
        if (chunkCoordinates != null) {
            this.spawnChunkMap.put(dimension, new t(chunkCoordinates));
            this.spawnForcedMap.put(dimension, forced);
        } else {
            this.spawnChunkMap.remove(dimension);
            this.spawnForcedMap.remove(dimension);
        }
    }

    public void a(ku par1StatBase) {
        this.a(par1StatBase, 1);
    }

    public void a(ku par1StatBase, int par2) {
    }

    @Override
    protected void be() {
        super.be();
        this.a(la.u, 1);
        if (this.ai()) {
            this.a(0.8f);
        } else {
            this.a(0.2f);
        }
    }

    @Override
    public void e(float par1, float par2) {
        double d0 = this.u;
        double d1 = this.v;
        double d2 = this.w;
        if (this.bG.b && this.o == null) {
            double d3 = this.y;
            float f2 = this.aR;
            this.aR = this.bG.a();
            super.e(par1, par2);
            this.y = d3 * 0.6;
            this.aR = f2;
        } else {
            super.e(par1, par2);
        }
        this.j(this.u - d0, this.v - d1, this.w - d2);
    }

    @Override
    public float bg() {
        return (float)this.a(tp.d).e();
    }

    public void j(double par1, double par3, double par5) {
        if (this.o == null) {
            if (this.a(akc.h)) {
                int i2 = Math.round(ls.a(par1 * par1 + par3 * par3 + par5 * par5) * 100.0f);
                if (i2 > 0) {
                    this.a(la.q, i2);
                    this.a(0.015f * (float)i2 * 0.01f);
                }
            } else if (this.H()) {
                int i3 = Math.round(ls.a(par1 * par1 + par5 * par5) * 100.0f);
                if (i3 > 0) {
                    this.a(la.m, i3);
                    this.a(0.015f * (float)i3 * 0.01f);
                }
            } else if (this.e()) {
                if (par3 > 0.0) {
                    this.a(la.o, (int)Math.round(par3 * 100.0));
                }
            } else if (this.F) {
                int i4 = Math.round(ls.a(par1 * par1 + par5 * par5) * 100.0f);
                if (i4 > 0) {
                    this.a(la.l, i4);
                    if (this.ai()) {
                        this.a(0.099999994f * (float)i4 * 0.01f);
                    } else {
                        this.a(0.01f * (float)i4 * 0.01f);
                    }
                }
            } else {
                int i5 = Math.round(ls.a(par1 * par1 + par5 * par5) * 100.0f);
                if (i5 > 25) {
                    this.a(la.p, i5);
                }
            }
        }
    }

    private void k(double par1, double par3, double par5) {
        int i2;
        if (this.o != null && (i2 = Math.round(ls.a(par1 * par1 + par3 * par3 + par5 * par5) * 100.0f)) > 0) {
            if (this.o instanceof st) {
                this.a(la.r, i2);
                if (this.e == null) {
                    this.e = new t(ls.c(this.u), ls.c(this.v), ls.c(this.w));
                } else if ((double)this.e.e(ls.c(this.u), ls.c(this.v), ls.c(this.w)) >= 1000000.0) {
                    this.a((ku)kp.q, 1);
                }
            } else if (this.o instanceof sq) {
                this.a(la.s, i2);
            } else if (this.o instanceof ry) {
                this.a(la.t, i2);
            }
        }
    }

    @Override
    protected void b(float par1) {
        if (!this.bG.c) {
            if (par1 >= 2.0f) {
                this.a(la.n, (int)Math.round((double)par1 * 100.0));
            }
            super.b(par1);
        } else {
            MinecraftForge.EVENT_BUS.post((Event)new PlayerFlyableFallEvent(this, par1));
        }
    }

    @Override
    public void a(of par1EntityLivingBase) {
        if (par1EntityLivingBase instanceof th) {
            this.a((ku)kp.s);
        }
    }

    @Override
    public void am() {
        if (!this.bG.b) {
            super.am();
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public ms b(ye par1ItemStack, int par2) {
        ms icon = super.b(par1ItemStack, par2);
        if (par1ItemStack.d == yc.aT.cv && this.bM != null) {
            icon = yc.aT.g();
        } else {
            if (par1ItemStack.b().b()) {
                return par1ItemStack.b().getIcon(par1ItemStack, par2);
            }
            if (this.f != null && par1ItemStack.d == yc.m.cv) {
                int j2 = par1ItemStack.n() - this.g;
                if (j2 >= 18) {
                    return yc.m.c(2);
                }
                if (j2 > 13) {
                    return yc.m.c(1);
                }
                if (j2 > 0) {
                    return yc.m.c(0);
                }
            }
            icon = par1ItemStack.b().getIcon(par1ItemStack, par2, this, this.f, this.g);
        }
        return icon;
    }

    public ye o(int par1) {
        return this.bn.f(par1);
    }

    public void s(int par1) {
        this.p(par1);
        int j2 = Integer.MAX_VALUE - this.bI;
        if (par1 > j2) {
            par1 = j2;
        }
        this.bJ += (float)par1 / (float)this.bH();
        this.bI += par1;
        while (this.bJ >= 1.0f) {
            this.bJ = (this.bJ - 1.0f) * (float)this.bH();
            this.a(1);
            this.bJ /= (float)this.bH();
        }
    }

    public void a(int par1) {
        this.bH += par1;
        if (this.bH < 0) {
            this.bH = 0;
            this.bJ = 0.0f;
            this.bI = 0;
        }
        if (par1 > 0 && this.bH % 5 == 0 && (float)this.h < (float)this.ac - 100.0f) {
            float f2 = this.bH > 30 ? 1.0f : (float)this.bH / 30.0f;
            this.q.a((nn)this, "random.levelup", f2 * 0.75f, 1.0f);
            this.h = this.ac;
        }
    }

    public int bH() {
        return this.bH >= 30 ? 62 + (this.bH - 30) * 7 : (this.bH >= 15 ? 17 + (this.bH - 15) * 3 : 17);
    }

    public void a(float par1) {
        if (!this.bG.a && !this.q.I) {
            this.bq.a(par1);
        }
    }

    public ux bI() {
        return this.bq;
    }

    public boolean g(boolean par1) {
        return (par1 || this.bq.c()) && !this.bG.a;
    }

    public boolean bJ() {
        return this.aN() > 0.0f && this.aN() < this.aT();
    }

    public void a(ye par1ItemStack, int par2) {
        if (par1ItemStack != this.f) {
            this.f = par1ItemStack;
            this.g = par2;
            if (!this.q.I) {
                this.e(true);
            }
        }
    }

    public boolean d(int par1, int par2, int par3) {
        if (this.bG.e) {
            return true;
        }
        int l2 = this.q.a(par1, par2, par3);
        if (l2 > 0) {
            ye itemstack;
            aqz block = aqz.s[l2];
            if (block.cU.q()) {
                return true;
            }
            if (this.by() != null && ((itemstack = this.by()).b(block) || itemstack.a(block) > 1.0f)) {
                return true;
            }
        }
        return false;
    }

    public boolean a(int par1, int par2, int par3, int par4, ye par5ItemStack) {
        return this.bG.e ? true : (par5ItemStack != null ? par5ItemStack.z() : false);
    }

    @Override
    protected int e(uf par1EntityPlayer) {
        if (this.q.O().b("keepInventory")) {
            return 0;
        }
        int i2 = this.bH * 7;
        return i2 > 100 ? 100 : i2;
    }

    @Override
    protected boolean aC() {
        return true;
    }

    @Override
    public String an() {
        return this.bu;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean bd() {
        return true;
    }

    public void a(uf par1EntityPlayer, boolean par2) {
        if (par2) {
            this.bn.b(par1EntityPlayer.bn);
            this.g(par1EntityPlayer.aN());
            this.bq = par1EntityPlayer.bq;
            this.bH = par1EntityPlayer.bH;
            this.bI = par1EntityPlayer.bI;
            this.bJ = par1EntityPlayer.bJ;
            this.c(par1EntityPlayer.bw());
            this.as = par1EntityPlayer.as;
        } else if (this.q.O().b("keepInventory")) {
            this.bn.b(par1EntityPlayer.bn);
            this.bH = par1EntityPlayer.bH;
            this.bI = par1EntityPlayer.bI;
            this.bJ = par1EntityPlayer.bJ;
            this.c(par1EntityPlayer.bw());
        }
        this.spawnChunkMap = par1EntityPlayer.spawnChunkMap;
        this.spawnForcedMap = par1EntityPlayer.spawnForcedMap;
        this.a = par1EntityPlayer.a;
        by old = par1EntityPlayer.getEntityData();
        if (old.b(PERSISTED_NBT_TAG)) {
            this.getEntityData().a(PERSISTED_NBT_TAG, old.l(PERSISTED_NBT_TAG));
        }
    }

    @Override
    protected boolean e_() {
        return !this.bG.b;
    }

    public void o() {
    }

    public void a(ace par1EnumGameType) {
    }

    public String c_() {
        return this.bu;
    }

    public abw f_() {
        return this.q;
    }

    public wb bK() {
        return this.a;
    }

    @Override
    public ye n(int par1) {
        return par1 == 0 ? this.bn.h() : this.bn.b[par1 - 1];
    }

    @Override
    public ye aZ() {
        return this.bn.h();
    }

    @Override
    public void c(int par1, ye par2ItemStack) {
        if (par1 == 0) {
            this.bn.a[this.bn.c] = par2ItemStack;
        } else {
            this.bn.b[par1 - 1] = par2ItemStack;
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean d(uf par1EntityPlayer) {
        if (!this.aj()) {
            return false;
        }
        atl team = this.bo();
        return team == null || par1EntityPlayer == null || par1EntityPlayer.bo() != team || !team.h();
    }

    @Override
    public ye[] ae() {
        return this.bn.b;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean bL() {
        return this.r(1);
    }

    @Override
    public boolean ax() {
        return !this.bG.b;
    }

    public atj bM() {
        return this.q.X();
    }

    @Override
    public atl bo() {
        return this.bM().i(this.bu);
    }

    @Override
    public String ay() {
        return atf.a((atl)this.bo(), (String)this.getDisplayName());
    }

    @Override
    public void m(float par1) {
        if (par1 < 0.0f) {
            par1 = 0.0f;
        }
        this.v().b(17, Float.valueOf(par1));
    }

    @Override
    public float bn() {
        return this.v().d(17);
    }

    public void openGui(Object mod, int modGuiId, abw world, int x2, int y2, int z2) {
        FMLNetworkHandler.openGui((uf)this, (Object)mod, (int)modGuiId, (abw)world, (int)x2, (int)y2, (int)z2);
    }

    public float getDefaultEyeHeight() {
        return 0.12f;
    }

    public String getDisplayName() {
        if (this.displayname == null) {
            this.displayname = ForgeEventFactory.getPlayerDisplayName((uf)this, (String)this.bu);
        }
        return this.displayname;
    }

    public void refreshDisplayName() {
        this.displayname = ForgeEventFactory.getPlayerDisplayName((uf)this, (String)this.bu);
    }
}

