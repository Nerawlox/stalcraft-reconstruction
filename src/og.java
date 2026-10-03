/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aaw
 *  cd
 *  cl
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  fo
 *  net.minecraftforge.common.ForgeHooks
 *  net.minecraftforge.event.Event$Result
 *  net.minecraftforge.event.ForgeEventFactory
 *  oc
 *  oi
 *  oq
 *  ot
 *  pb
 *  pd
 *  pt
 *  rf
 *  rg
 *  th
 *  wh
 *  zl
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ForgeEventFactory;

public abstract class og
extends of {
    public int a_;
    public int b;
    private pe h;
    private pf i;
    private pd j;
    private pb bn;
    private rf bo;
    public final pt c;
    public final pt d;
    private of bp;
    private rg bq;
    private ye[] br = new ye[5];
    protected float[] e = new float[5];
    private boolean bs;
    private boolean bt;
    protected float f;
    private nn bu;
    protected int g;
    private boolean bv;
    private nn bw;
    private by bx;

    public og(abw par1World) {
        super(par1World);
        this.c = new pt(par1World != null && par1World.C != null ? par1World.C : null);
        this.d = new pt(par1World != null && par1World.C != null ? par1World.C : null);
        this.h = new pe(this);
        this.i = new pf(this);
        this.j = new pd(this);
        this.bn = new pb((of)this);
        this.bo = new rf(this, par1World);
        this.bq = new rg(this);
        for (int i2 = 0; i2 < this.e.length; ++i2) {
            this.e[i2] = 0.085f;
        }
    }

    @Override
    protected void az() {
        super.az();
        this.aX().b(tp.b).a(16.0);
    }

    public pe h() {
        return this.h;
    }

    public pf i() {
        return this.i;
    }

    public pd j() {
        return this.j;
    }

    public rf k() {
        return this.bo;
    }

    public rg l() {
        return this.bq;
    }

    public of m() {
        return this.bp;
    }

    public void d(of par1EntityLivingBase) {
        this.bp = par1EntityLivingBase;
        ForgeHooks.onLivingSetAttackTarget((of)this, (of)par1EntityLivingBase);
    }

    public boolean a(Class par1Class) {
        return tf.class != par1Class && tj.class != par1Class;
    }

    public void n() {
    }

    @Override
    protected void a() {
        super.a();
        this.ah.a(11, (Object)0);
        this.ah.a(10, "");
    }

    public int o() {
        return 80;
    }

    public void p() {
        String s2 = this.r();
        if (s2 != null) {
            this.a(s2, this.ba(), this.bb());
        }
    }

    @Override
    public void y() {
        super.y();
        this.q.C.a("mobBaseTick");
        if (this.T() && this.ab.nextInt(1000) < this.a_++) {
            this.a_ = -this.o();
            this.p();
        }
        this.q.C.b();
    }

    @Override
    protected int e(uf par1EntityPlayer) {
        if (this.b > 0) {
            int i2 = this.b;
            ye[] aitemstack = this.ae();
            for (int j2 = 0; j2 < aitemstack.length; ++j2) {
                if (aitemstack[j2] == null || !(this.e[j2] <= 1.0f)) continue;
                i2 += 1 + this.ab.nextInt(3);
            }
            return i2;
        }
        return this.b;
    }

    public void q() {
        for (int i2 = 0; i2 < 20; ++i2) {
            double d0 = this.ab.nextGaussian() * 0.02;
            double d1 = this.ab.nextGaussian() * 0.02;
            double d2 = this.ab.nextGaussian() * 0.02;
            double d3 = 10.0;
            this.q.a("explode", this.u + (double)(this.ab.nextFloat() * this.O * 2.0f) - (double)this.O - d0 * d3, this.v + (double)(this.ab.nextFloat() * this.P) - d1 * d3, this.w + (double)(this.ab.nextFloat() * this.O * 2.0f) - (double)this.O - d2 * d3, d0, d1, d2);
        }
    }

    @Override
    public void l_() {
        super.l_();
        if (!this.q.I) {
            this.bF();
        }
    }

    @Override
    protected float f(float par1, float par2) {
        if (this.bf()) {
            this.bn.a();
            return par2;
        }
        return super.f(par1, par2);
    }

    protected String r() {
        return null;
    }

    protected int s() {
        return 0;
    }

    @Override
    protected void b(boolean par1, int par2) {
        int j2 = this.s();
        if (j2 > 0) {
            int k2 = this.ab.nextInt(3);
            if (par2 > 0) {
                k2 += this.ab.nextInt(par2 + 1);
            }
            for (int l2 = 0; l2 < k2; ++l2) {
                this.b(j2, 1);
            }
        }
    }

    @Override
    public void b(by par1NBTTagCompound) {
        by nbttagcompound1;
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("CanPickUpLoot", this.bD());
        par1NBTTagCompound.a("PersistenceRequired", this.bt);
        cg nbttaglist = new cg();
        for (int i2 = 0; i2 < this.br.length; ++i2) {
            nbttagcompound1 = new by();
            if (this.br[i2] != null) {
                this.br[i2].b(nbttagcompound1);
            }
            nbttaglist.a(nbttagcompound1);
        }
        par1NBTTagCompound.a("Equipment", nbttaglist);
        cg nbttaglist1 = new cg();
        for (int j2 = 0; j2 < this.e.length; ++j2) {
            nbttaglist1.a((cl)new cd(j2 + "", this.e[j2]));
        }
        par1NBTTagCompound.a("DropChances", nbttaglist1);
        par1NBTTagCompound.a("CustomName", this.bA());
        par1NBTTagCompound.a("CustomNameVisible", this.bC());
        par1NBTTagCompound.a("Leashed", this.bv);
        if (this.bw != null) {
            nbttagcompound1 = new by("Leash");
            if (this.bw instanceof of) {
                nbttagcompound1.a("UUIDMost", this.bw.aw().getMostSignificantBits());
                nbttagcompound1.a("UUIDLeast", this.bw.aw().getLeastSignificantBits());
            } else if (this.bw instanceof oc) {
                oc entityhanging = (oc)this.bw;
                nbttagcompound1.a("X", entityhanging.b);
                nbttagcompound1.a("Y", entityhanging.c);
                nbttagcompound1.a("Z", entityhanging.d);
            }
            par1NBTTagCompound.a("Leash", (cl)nbttagcompound1);
        }
    }

    @Override
    public void a(by par1NBTTagCompound) {
        int i2;
        cg nbttaglist;
        super.a(par1NBTTagCompound);
        this.h(par1NBTTagCompound.n("CanPickUpLoot"));
        this.bt = par1NBTTagCompound.n("PersistenceRequired");
        if (par1NBTTagCompound.b("CustomName") && par1NBTTagCompound.i("CustomName").length() > 0) {
            this.a(par1NBTTagCompound.i("CustomName"));
        }
        this.g(par1NBTTagCompound.n("CustomNameVisible"));
        if (par1NBTTagCompound.b("Equipment")) {
            nbttaglist = par1NBTTagCompound.m("Equipment");
            for (i2 = 0; i2 < this.br.length; ++i2) {
                this.br[i2] = ye.a((by)nbttaglist.b(i2));
            }
        }
        if (par1NBTTagCompound.b("DropChances")) {
            nbttaglist = par1NBTTagCompound.m("DropChances");
            for (i2 = 0; i2 < nbttaglist.c(); ++i2) {
                this.e[i2] = ((cd)nbttaglist.b((int)i2)).a;
            }
        }
        this.bv = par1NBTTagCompound.n("Leashed");
        if (this.bv && par1NBTTagCompound.b("Leash")) {
            this.bx = par1NBTTagCompound.l("Leash");
        }
    }

    public void n(float par1) {
        this.bf = par1;
    }

    @Override
    public void i(float par1) {
        super.i(par1);
        this.n(par1);
    }

    @Override
    public void c() {
        super.c();
        this.q.C.a("looting");
        if (!this.q.I && this.bD() && !this.aU && this.q.O().b("mobGriefing")) {
            List list = this.q.a(ss.class, this.E.b(1.0, 0.0, 1.0));
            for (ss entityitem : list) {
                ye itemstack;
                int i2;
                if (entityitem.M || entityitem.d() == null || (i2 = og.b(itemstack = entityitem.d())) <= -1) continue;
                boolean flag = true;
                ye itemstack1 = this.n(i2);
                if (itemstack1 != null) {
                    if (i2 == 0) {
                        if (itemstack.b() instanceof zl && !(itemstack1.b() instanceof zl)) {
                            flag = true;
                        } else if (itemstack.b() instanceof zl && itemstack1.b() instanceof zl) {
                            zl itemsword = (zl)itemstack.b();
                            zl itemsword1 = (zl)itemstack1.b();
                            flag = itemsword.g() == itemsword1.g() ? itemstack.k() > itemstack1.k() || itemstack.p() && !itemstack1.p() : itemsword.g() > itemsword1.g();
                        } else {
                            flag = false;
                        }
                    } else if (itemstack.b() instanceof wh && !(itemstack1.b() instanceof wh)) {
                        flag = true;
                    } else if (itemstack.b() instanceof wh && itemstack1.b() instanceof wh) {
                        wh itemarmor = (wh)itemstack.b();
                        wh itemarmor1 = (wh)itemstack1.b();
                        flag = itemarmor.c == itemarmor1.c ? itemstack.k() > itemstack1.k() || itemstack.p() && !itemstack1.p() : itemarmor.c > itemarmor1.c;
                    } else {
                        flag = false;
                    }
                }
                if (!flag) continue;
                if (itemstack1 != null && this.ab.nextFloat() - 0.1f < this.e[i2]) {
                    this.a(itemstack1, 0.0f);
                }
                this.c(i2, itemstack);
                this.e[i2] = 2.0f;
                this.bt = true;
                this.a((nn)entityitem, 1);
                entityitem.x();
            }
        }
        this.q.C.b();
    }

    @Override
    protected boolean bf() {
        return false;
    }

    protected boolean t() {
        return true;
    }

    protected void u() {
        Event.Result result = null;
        if (this.bt) {
            this.aV = 0;
        } else if ((this.aV & 0x1F) == 31 && (result = ForgeEventFactory.canEntityDespawn((og)this)) != Event.Result.DEFAULT) {
            if (result == Event.Result.DENY) {
                this.aV = 0;
            } else {
                this.x();
            }
        } else {
            uf entityplayer = this.q.a((nn)this, -1.0);
            if (entityplayer != null) {
                double d0 = entityplayer.u - this.u;
                double d1 = entityplayer.v - this.v;
                double d2 = entityplayer.w - this.w;
                double d3 = d0 * d0 + d1 * d1 + d2 * d2;
                if (this.t() && d3 > 16384.0) {
                    this.x();
                }
                if (this.aV > 600 && this.ab.nextInt(800) == 0 && d3 > 1024.0 && this.t()) {
                    this.x();
                } else if (d3 < 1024.0) {
                    this.aV = 0;
                }
            }
        }
    }

    @Override
    protected void bi() {
        ++this.aV;
        this.q.C.a("checkDespawn");
        this.u();
        this.q.C.b();
        this.q.C.a("sensing");
        this.bq.a();
        this.q.C.b();
        this.q.C.a("targetSelector");
        this.d.a();
        this.q.C.b();
        this.q.C.a("goalSelector");
        this.c.a();
        this.q.C.b();
        this.q.C.a("navigation");
        this.bo.f();
        this.q.C.b();
        this.q.C.a("mob tick");
        this.bk();
        this.q.C.b();
        this.q.C.a("controls");
        this.q.C.a("move");
        this.i.c();
        this.q.C.c("look");
        this.h.a();
        this.q.C.c("jump");
        this.j.b();
        this.q.C.b();
        this.q.C.b();
    }

    @Override
    protected void bl() {
        super.bl();
        this.be = 0.0f;
        this.bf = 0.0f;
        this.u();
        float f2 = 8.0f;
        if (this.ab.nextFloat() < 0.02f) {
            uf entityplayer = this.q.a((nn)this, (double)f2);
            if (entityplayer != null) {
                this.bu = entityplayer;
                this.g = 10 + this.ab.nextInt(20);
            } else {
                this.bg = (this.ab.nextFloat() - 0.5f) * 20.0f;
            }
        }
        if (this.bu != null) {
            this.a(this.bu, 10.0f, (float)this.bp());
            if (this.g-- <= 0 || this.bu.M || this.bu.e(this) > (double)(f2 * f2)) {
                this.bu = null;
            }
        } else {
            if (this.ab.nextFloat() < 0.05f) {
                this.bg = (this.ab.nextFloat() - 0.5f) * 20.0f;
            }
            this.A += this.bg;
            this.B = this.f;
        }
        boolean flag = this.H();
        boolean flag1 = this.J();
        if (flag || flag1) {
            this.bd = this.ab.nextFloat() < 0.8f;
        }
    }

    public int bp() {
        return 40;
    }

    public void a(nn par1Entity, float par2, float par3) {
        double d2;
        double d0 = par1Entity.u - this.u;
        double d1 = par1Entity.w - this.w;
        if (par1Entity instanceof of) {
            of entitylivingbase = (of)par1Entity;
            d2 = entitylivingbase.v + (double)entitylivingbase.f() - (this.v + (double)this.f());
        } else {
            d2 = (par1Entity.E.b + par1Entity.E.e) / 2.0 - (this.v + (double)this.f());
        }
        double d3 = ls.a(d0 * d0 + d1 * d1);
        float f2 = (float)(Math.atan2(d1, d0) * 180.0 / Math.PI) - 90.0f;
        float f3 = (float)(-(Math.atan2(d2, d3) * 180.0 / Math.PI));
        this.B = this.b(this.B, f3, par3);
        this.A = this.b(this.A, f2, par2);
    }

    private float b(float par1, float par2, float par3) {
        float f3 = ls.g(par2 - par1);
        if (f3 > par3) {
            f3 = par3;
        }
        if (f3 < -par3) {
            f3 = -par3;
        }
        return par1 + f3;
    }

    public boolean bs() {
        return this.q.b(this.E) && this.q.a((nn)this, this.E).isEmpty() && !this.q.d(this.E);
    }

    public float bt() {
        return 1.0f;
    }

    public int bv() {
        return 4;
    }

    @Override
    public int as() {
        if (this.m() == null) {
            return 3;
        }
        int i2 = (int)(this.aN() - this.aT() * 0.33f);
        if ((i2 -= (3 - this.q.r) * 4) < 0) {
            i2 = 0;
        }
        return i2 + 3;
    }

    @Override
    public ye aZ() {
        return this.br[0];
    }

    @Override
    public ye n(int par1) {
        return this.br[par1];
    }

    public ye o(int par1) {
        return this.br[par1 + 1];
    }

    @Override
    public void c(int par1, ye par2ItemStack) {
        this.br[par1] = par2ItemStack;
    }

    @Override
    public ye[] ae() {
        return this.br;
    }

    @Override
    protected void a(boolean par1, int par2) {
        for (int j2 = 0; j2 < this.ae().length; ++j2) {
            boolean flag1;
            ye itemstack = this.n(j2);
            boolean bl2 = flag1 = this.e[j2] > 1.0f;
            if (itemstack == null || !par1 && !flag1 || !(this.ab.nextFloat() - (float)par2 * 0.01f < this.e[j2])) continue;
            if (!flag1 && itemstack.g()) {
                int k2 = Math.max(itemstack.l() - 25, 1);
                int l2 = itemstack.l() - this.ab.nextInt(this.ab.nextInt(k2) + 1);
                if (l2 > k2) {
                    l2 = k2;
                }
                if (l2 < 1) {
                    l2 = 1;
                }
                itemstack.b(l2);
            }
            this.a(itemstack, 0.0f);
        }
    }

    protected void bw() {
        if (this.ab.nextFloat() < 0.15f * this.q.b(this.u, this.v, this.w)) {
            float f2;
            int i2 = this.ab.nextInt(2);
            float f3 = f2 = this.q.r == 3 ? 0.1f : 0.25f;
            if (this.ab.nextFloat() < 0.095f) {
                ++i2;
            }
            if (this.ab.nextFloat() < 0.095f) {
                ++i2;
            }
            if (this.ab.nextFloat() < 0.095f) {
                ++i2;
            }
            for (int j2 = 3; j2 >= 0; --j2) {
                yc item;
                ye itemstack = this.o(j2);
                if (j2 < 3 && this.ab.nextFloat() < f2) break;
                if (itemstack != null || (item = og.a(j2 + 1, i2)) == null) continue;
                this.c(j2 + 1, new ye(item));
            }
        }
    }

    public static int b(ye par0ItemStack) {
        if (par0ItemStack.d != aqz.bf.cF && par0ItemStack.d != yc.bS.cv) {
            if (par0ItemStack.b() instanceof wh) {
                switch (((wh)par0ItemStack.b()).b) {
                    case 0: {
                        return 4;
                    }
                    case 1: {
                        return 3;
                    }
                    case 2: {
                        return 2;
                    }
                    case 3: {
                        return 1;
                    }
                }
            }
            return 0;
        }
        return 4;
    }

    public static yc a(int par0, int par1) {
        switch (par0) {
            case 4: {
                if (par1 == 0) {
                    return yc.X;
                }
                if (par1 == 1) {
                    return yc.an;
                }
                if (par1 == 2) {
                    return yc.ab;
                }
                if (par1 == 3) {
                    return yc.af;
                }
                if (par1 == 4) {
                    return yc.aj;
                }
            }
            case 3: {
                if (par1 == 0) {
                    return yc.Y;
                }
                if (par1 == 1) {
                    return yc.ao;
                }
                if (par1 == 2) {
                    return yc.ac;
                }
                if (par1 == 3) {
                    return yc.ag;
                }
                if (par1 == 4) {
                    return yc.ak;
                }
            }
            case 2: {
                if (par1 == 0) {
                    return yc.Z;
                }
                if (par1 == 1) {
                    return yc.ap;
                }
                if (par1 == 2) {
                    return yc.ad;
                }
                if (par1 == 3) {
                    return yc.ah;
                }
                if (par1 == 4) {
                    return yc.al;
                }
            }
            case 1: {
                if (par1 == 0) {
                    return yc.aa;
                }
                if (par1 == 1) {
                    return yc.aq;
                }
                if (par1 == 2) {
                    return yc.ae;
                }
                if (par1 == 3) {
                    return yc.ai;
                }
                if (par1 != 4) break;
                return yc.am;
            }
        }
        return null;
    }

    protected void bx() {
        float f2 = this.q.b(this.u, this.v, this.w);
        if (this.aZ() != null && this.ab.nextFloat() < 0.25f * f2) {
            aaw.a((Random)this.ab, (ye)this.aZ(), (int)((int)(5.0f + f2 * (float)this.ab.nextInt(18))));
        }
        for (int i2 = 0; i2 < 4; ++i2) {
            ye itemstack = this.o(i2);
            if (itemstack == null || !(this.ab.nextFloat() < 0.5f * f2)) continue;
            aaw.a((Random)this.ab, (ye)itemstack, (int)((int)(5.0f + f2 * (float)this.ab.nextInt(18))));
        }
    }

    public oi a(oi par1EntityLivingData) {
        this.a(tp.b).a(new ot("Random spawn bonus", this.ab.nextGaussian() * 0.05, 1));
        return par1EntityLivingData;
    }

    public boolean by() {
        return false;
    }

    @Override
    public String an() {
        return this.bB() ? this.bA() : super.an();
    }

    public void bz() {
        this.bt = true;
    }

    public void a(String par1Str) {
        this.ah.b(10, par1Str);
    }

    public String bA() {
        return this.ah.e(10);
    }

    public boolean bB() {
        return this.ah.e(10).length() > 0;
    }

    public void g(boolean par1) {
        this.ah.b(11, (byte)(par1 ? 1 : 0));
    }

    public boolean bC() {
        return this.ah.a(11) == 1;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean bd() {
        return this.bC();
    }

    public void a(int par1, float par2) {
        this.e[par1] = par2;
    }

    public boolean bD() {
        return this.bs;
    }

    public void h(boolean par1) {
        this.bs = par1;
    }

    public boolean bE() {
        return this.bt;
    }

    @Override
    public final boolean c(uf par1EntityPlayer) {
        if (this.bH() && this.bI() == par1EntityPlayer) {
            this.a(true, !par1EntityPlayer.bG.d);
            return true;
        }
        ye itemstack = par1EntityPlayer.bn.h();
        if (itemstack != null && itemstack.d == yc.ch.cv && this.bG()) {
            if (!(this instanceof oq) || !((oq)this).bT()) {
                this.b((nn)par1EntityPlayer, true);
                --itemstack.b;
                return true;
            }
            if (par1EntityPlayer.c_().equalsIgnoreCase(((oq)this).h_())) {
                this.b((nn)par1EntityPlayer, true);
                --itemstack.b;
                return true;
            }
        }
        return this.a(par1EntityPlayer) ? true : super.c(par1EntityPlayer);
    }

    protected boolean a(uf par1EntityPlayer) {
        return false;
    }

    protected void bF() {
        if (this.bx != null) {
            this.bJ();
        }
        if (this.bv && (this.bw == null || this.bw.M)) {
            this.a(true, true);
        }
    }

    public void a(boolean par1, boolean par2) {
        if (this.bv) {
            this.bv = false;
            this.bw = null;
            if (!this.q.I && par2) {
                this.b(yc.ch.cv, 1);
            }
            if (!this.q.I && par1 && this.q instanceof js) {
                ((js)this.q).q().a(this, (ey)new fo(1, (nn)this, (nn)null));
            }
        }
    }

    public boolean bG() {
        return !this.bH() && !(this instanceof th);
    }

    public boolean bH() {
        return this.bv;
    }

    public nn bI() {
        return this.bw;
    }

    public void b(nn par1Entity, boolean par2) {
        this.bv = true;
        this.bw = par1Entity;
        if (!this.q.I && par2 && this.q instanceof js) {
            ((js)this.q).q().a(this, (ey)new fo(1, (nn)this, this.bw));
        }
    }

    private void bJ() {
        if (this.bv && this.bx != null) {
            if (this.bx.b("UUIDMost") && this.bx.b("UUIDLeast")) {
                UUID uuid = new UUID(this.bx.f("UUIDMost"), this.bx.f("UUIDLeast"));
                List list = this.q.a(of.class, this.E.b(10.0, 10.0, 10.0));
                for (of entitylivingbase : list) {
                    if (!entitylivingbase.aw().equals(uuid)) continue;
                    this.bw = entitylivingbase;
                    break;
                }
            } else if (this.bx.b("X") && this.bx.b("Y") && this.bx.b("Z")) {
                int k2;
                int j2;
                int i2 = this.bx.e("X");
                oe entityleashknot = oe.b(this.q, i2, j2 = this.bx.e("Y"), k2 = this.bx.e("Z"));
                if (entityleashknot == null) {
                    entityleashknot = oe.a(this.q, i2, j2, k2);
                }
                this.bw = entityleashknot;
            } else {
                this.a(false, true);
            }
        }
        this.bx = null;
    }
}

