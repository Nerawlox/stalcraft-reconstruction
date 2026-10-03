/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aau
 *  aaw
 *  abb
 *  abk
 *  abl
 *  abm
 *  cpw.mods.fml.common.registry.VillagerRegistry
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  mh
 *  nb
 *  ni
 *  nk
 *  oi
 *  pp
 *  ps
 *  pv
 *  qb
 *  qd
 *  qi
 *  qm
 *  qo
 *  qv
 *  t
 *  th
 *  ua
 */
import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ub
extends nk
implements abk,
ua {
    private int bq;
    private boolean br;
    private boolean bs;
    rj bp;
    private uf bt;
    private abm bu;
    private int bv;
    private boolean bw;
    private int bx;
    private String by;
    private boolean bz;
    private float bA;
    public static final Map bB = new HashMap();
    public static final Map bC = new HashMap();

    public ub(abw par1World) {
        this(par1World, 0);
    }

    public ub(abw par1World, int par2) {
        super(par1World);
        this.p(par2);
        this.a(0.6f, 1.8f);
        this.k().b(true);
        this.k().a(true);
        this.c.a(0, (ps)new pp((og)((Object)this)));
        this.c.a(1, (ps)new pg((on)((Object)this), tw.class, 8.0f, 0.6, 0.6));
        this.c.a(1, (ps)new qv(this));
        this.c.a(1, (ps)new py(this));
        this.c.a(2, (ps)new qb((on)((Object)this)));
        this.c.a(3, (ps)new qo((on)((Object)this)));
        this.c.a(4, (ps)new qi((og)((Object)this), true));
        this.c.a(5, (ps)new qd((on)((Object)this), 0.6));
        this.c.a(6, (ps)new pz(this));
        this.c.a(7, (ps)new qt(this));
        this.c.a(8, (ps)new qk(this, 0.32));
        this.c.a(9, (ps)new pv((og)((Object)this), uf.class, 3.0f, 1.0f));
        this.c.a(9, (ps)new pv((og)((Object)this), ub.class, 5.0f, 0.02f));
        this.c.a(9, (ps)new qm((on)((Object)this), 0.6));
        this.c.a(10, (ps)new px((og)((Object)this), og.class, 8.0f));
    }

    protected void az() {
        super.az();
        this.a(tp.d).a(0.5);
    }

    public boolean bf() {
        return true;
    }

    protected void bk() {
        if (--this.bq <= 0) {
            this.q.A.a(ls.c(this.u), ls.c(this.v), ls.c(this.w));
            this.bq = 70 + this.ab.nextInt(50);
            this.bp = this.q.A.a(ls.c(this.u), ls.c(this.v), ls.c(this.w), 32);
            if (this.bp == null) {
                this.bR();
            } else {
                t chunkcoordinates = this.bp.a();
                this.b(chunkcoordinates.a, chunkcoordinates.b, chunkcoordinates.c, (int)((float)this.bp.b() * 0.6f));
                if (this.bz) {
                    this.bz = false;
                    this.bp.b(5);
                }
            }
        }
        if (!this.bW() && this.bv > 0) {
            --this.bv;
            if (this.bv <= 0) {
                if (this.bw) {
                    if (this.bu.size() > 1) {
                        for (abl merchantrecipe : this.bu) {
                            if (!merchantrecipe.g()) continue;
                            merchantrecipe.a(this.ab.nextInt(6) + this.ab.nextInt(6) + 2);
                        }
                    }
                    this.q(1);
                    this.bw = false;
                    if (this.bp != null && this.by != null) {
                        this.q.a((nn)((Object)this), (byte)14);
                        this.bp.a(this.by, 1);
                    }
                }
                this.c(new nj(ni.l.H, 200, 0));
            }
        }
        super.bk();
    }

    public boolean a(uf par1EntityPlayer) {
        boolean flag;
        ye itemstack = par1EntityPlayer.bn.h();
        boolean bl2 = flag = itemstack != null && itemstack.d == yc.bE.cv;
        if (!(flag || !this.T() || this.bW() || this.g_() || par1EntityPlayer.ah())) {
            if (!this.q.I) {
                this.a_(par1EntityPlayer);
                par1EntityPlayer.a(this, this.bA());
            }
            return true;
        }
        return super.a(par1EntityPlayer);
    }

    protected void a() {
        super.a();
        this.ah.a(16, (Object)0);
    }

    public void b(by par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("Profession", this.bT());
        par1NBTTagCompound.a("Riches", this.bx);
        if (this.bu != null) {
            par1NBTTagCompound.a("Offers", this.bu.a());
        }
    }

    public void a(by par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        this.p(par1NBTTagCompound.e("Profession"));
        this.bx = par1NBTTagCompound.e("Riches");
        if (par1NBTTagCompound.b("Offers")) {
            by nbttagcompound1 = par1NBTTagCompound.l("Offers");
            this.bu = new abm(nbttagcompound1);
        }
    }

    protected boolean t() {
        return false;
    }

    protected String r() {
        return this.bW() ? "mob.villager.haggle" : "mob.villager.idle";
    }

    protected String aO() {
        return "mob.villager.hit";
    }

    protected String aP() {
        return "mob.villager.death";
    }

    public void p(int par1) {
        this.ah.b(16, par1);
    }

    public int bT() {
        return this.ah.c(16);
    }

    public boolean bU() {
        return this.br;
    }

    public void i(boolean par1) {
        this.br = par1;
    }

    public void j(boolean par1) {
        this.bs = par1;
    }

    public boolean bV() {
        return this.bs;
    }

    public void b(of par1EntityLivingBase) {
        super.b(par1EntityLivingBase);
        if (this.bp != null && par1EntityLivingBase != null) {
            this.bp.a(par1EntityLivingBase);
            if (par1EntityLivingBase instanceof uf) {
                int b0 = -1;
                if (this.g_()) {
                    b0 = -3;
                }
                this.bp.a(((uf)par1EntityLivingBase).c_(), b0);
                if (this.T()) {
                    this.q.a((nn)((Object)this), (byte)13);
                }
            }
        }
    }

    public void a(nb par1DamageSource) {
        if (this.bp != null) {
            uf entityplayer;
            nn entity = par1DamageSource.i();
            if (entity != null) {
                if (entity instanceof uf) {
                    this.bp.a(((uf)entity).c_(), -2);
                } else if (entity instanceof th) {
                    this.bp.h();
                }
            } else if (entity == null && (entityplayer = this.q.a((nn)((Object)this), 16.0)) != null) {
                this.bp.h();
            }
        }
        super.a(par1DamageSource);
    }

    public void a_(uf par1EntityPlayer) {
        this.bt = par1EntityPlayer;
    }

    public uf m_() {
        return this.bt;
    }

    public boolean bW() {
        return this.bt != null;
    }

    public void a(abl par1MerchantRecipe) {
        par1MerchantRecipe.f();
        this.a_ = -this.o();
        this.a("mob.villager.yes", this.ba(), this.bb());
        if (par1MerchantRecipe.a((abl)this.bu.get(this.bu.size() - 1))) {
            this.bv = 40;
            this.bw = true;
            this.by = this.bt != null ? this.bt.c_() : null;
        }
        if (par1MerchantRecipe.a().d == yc.bJ.cv) {
            this.bx += par1MerchantRecipe.a().b;
        }
    }

    public void a_(ye par1ItemStack) {
        if (!this.q.I && this.a_ > -this.o() + 20) {
            this.a_ = -this.o();
            if (par1ItemStack != null) {
                this.a("mob.villager.yes", this.ba(), this.bb());
            } else {
                this.a("mob.villager.no", this.ba(), this.bb());
            }
        }
    }

    public abm b(uf par1EntityPlayer) {
        if (this.bu == null) {
            this.q(1);
        }
        return this.bu;
    }

    private float p(float par1) {
        float f1 = par1 + this.bA;
        return f1 > 0.9f ? 0.9f - (f1 - 0.9f) : f1;
    }

    private void q(int par1) {
        this.bA = this.bu != null ? ls.c(this.bu.size()) * 0.2f : 0.0f;
        abm merchantrecipelist = new abm();
        VillagerRegistry.manageVillagerTrades((abm)merchantrecipelist, (ub)this, (int)this.bT(), (Random)this.ab);
        switch (this.bT()) {
            case 0: {
                ub.a(merchantrecipelist, yc.V.cv, this.ab, this.p(0.9f));
                ub.a(merchantrecipelist, aqz.ag.cF, this.ab, this.p(0.5f));
                ub.a(merchantrecipelist, yc.bm.cv, this.ab, this.p(0.5f));
                ub.a(merchantrecipelist, yc.aX.cv, this.ab, this.p(0.4f));
                ub.b(merchantrecipelist, yc.W.cv, this.ab, this.p(0.9f));
                ub.b(merchantrecipelist, yc.bh.cv, this.ab, this.p(0.3f));
                ub.b(merchantrecipelist, yc.l.cv, this.ab, this.p(0.3f));
                ub.b(merchantrecipelist, yc.be.cv, this.ab, this.p(0.3f));
                ub.b(merchantrecipelist, yc.bg.cv, this.ab, this.p(0.3f));
                ub.b(merchantrecipelist, yc.k.cv, this.ab, this.p(0.3f));
                ub.b(merchantrecipelist, yc.bn.cv, this.ab, this.p(0.3f));
                ub.b(merchantrecipelist, yc.n.cv, this.ab, this.p(0.5f));
                if (!(this.ab.nextFloat() < this.p(0.5f))) break;
                merchantrecipelist.add((Object)new abl(new ye(aqz.K, 10), new ye(yc.bJ), new ye(yc.ar.cv, 4 + this.ab.nextInt(2), 0)));
                break;
            }
            case 1: {
                ub.a(merchantrecipelist, yc.aM.cv, this.ab, this.p(0.8f));
                ub.a(merchantrecipelist, yc.aN.cv, this.ab, this.p(0.8f));
                ub.a(merchantrecipelist, yc.bI.cv, this.ab, this.p(0.3f));
                ub.b(merchantrecipelist, aqz.as.cF, this.ab, this.p(0.8f));
                ub.b(merchantrecipelist, aqz.R.cF, this.ab, this.p(0.2f));
                ub.b(merchantrecipelist, yc.aS.cv, this.ab, this.p(0.2f));
                ub.b(merchantrecipelist, yc.aU.cv, this.ab, this.p(0.2f));
                if (!(this.ab.nextFloat() < this.p(0.07f))) break;
                aau enchantment = aau.c[this.ab.nextInt(aau.c.length)];
                int k2 = ls.a(this.ab, enchantment.d(), enchantment.b());
                ye itemstack = yc.bY.a(new abb(enchantment, k2));
                int j2 = 2 + this.ab.nextInt(5 + k2 * 10) + 3 * k2;
                merchantrecipelist.add((Object)new abl(new ye(yc.aN), new ye(yc.bJ, j2), itemstack));
                break;
            }
            case 2: {
                int[] aint;
                int j2;
                ub.b(merchantrecipelist, yc.bC.cv, this.ab, this.p(0.3f));
                ub.b(merchantrecipelist, yc.bF.cv, this.ab, this.p(0.2f));
                ub.b(merchantrecipelist, yc.aE.cv, this.ab, this.p(0.4f));
                ub.b(merchantrecipelist, aqz.bi.cF, this.ab, this.p(0.3f));
                int[] aint1 = aint = new int[]{yc.s.cv, yc.B.cv, yc.ag.cv, yc.ak.cv, yc.j.cv, yc.E.cv, yc.i.cv, yc.D.cv};
                int l2 = aint.length;
                for (j2 = 0; j2 < l2; ++j2) {
                    int i1 = aint1[j2];
                    if (!(this.ab.nextFloat() < this.p(0.05f))) continue;
                    merchantrecipelist.add((Object)new abl(new ye(i1, 1, 0), new ye(yc.bJ, 2 + this.ab.nextInt(3), 0), aaw.a((Random)this.ab, (ye)new ye(i1, 1, 0), (int)(5 + this.ab.nextInt(15)))));
                }
                break;
            }
            case 3: {
                ub.a(merchantrecipelist, yc.o.cv, this.ab, this.p(0.7f));
                ub.a(merchantrecipelist, yc.q.cv, this.ab, this.p(0.5f));
                ub.a(merchantrecipelist, yc.r.cv, this.ab, this.p(0.5f));
                ub.a(merchantrecipelist, yc.p.cv, this.ab, this.p(0.5f));
                ub.b(merchantrecipelist, yc.s.cv, this.ab, this.p(0.5f));
                ub.b(merchantrecipelist, yc.B.cv, this.ab, this.p(0.5f));
                ub.b(merchantrecipelist, yc.j.cv, this.ab, this.p(0.3f));
                ub.b(merchantrecipelist, yc.E.cv, this.ab, this.p(0.3f));
                ub.b(merchantrecipelist, yc.i.cv, this.ab, this.p(0.5f));
                ub.b(merchantrecipelist, yc.D.cv, this.ab, this.p(0.5f));
                ub.b(merchantrecipelist, yc.h.cv, this.ab, this.p(0.2f));
                ub.b(merchantrecipelist, yc.C.cv, this.ab, this.p(0.2f));
                ub.b(merchantrecipelist, yc.R.cv, this.ab, this.p(0.2f));
                ub.b(merchantrecipelist, yc.S.cv, this.ab, this.p(0.2f));
                ub.b(merchantrecipelist, yc.ai.cv, this.ab, this.p(0.2f));
                ub.b(merchantrecipelist, yc.am.cv, this.ab, this.p(0.2f));
                ub.b(merchantrecipelist, yc.af.cv, this.ab, this.p(0.2f));
                ub.b(merchantrecipelist, yc.aj.cv, this.ab, this.p(0.2f));
                ub.b(merchantrecipelist, yc.ag.cv, this.ab, this.p(0.2f));
                ub.b(merchantrecipelist, yc.ak.cv, this.ab, this.p(0.2f));
                ub.b(merchantrecipelist, yc.ah.cv, this.ab, this.p(0.2f));
                ub.b(merchantrecipelist, yc.al.cv, this.ab, this.p(0.2f));
                ub.b(merchantrecipelist, yc.ae.cv, this.ab, this.p(0.1f));
                ub.b(merchantrecipelist, yc.ab.cv, this.ab, this.p(0.1f));
                ub.b(merchantrecipelist, yc.ac.cv, this.ab, this.p(0.1f));
                ub.b(merchantrecipelist, yc.ad.cv, this.ab, this.p(0.1f));
                break;
            }
            case 4: {
                ub.a(merchantrecipelist, yc.o.cv, this.ab, this.p(0.7f));
                ub.a(merchantrecipelist, yc.as.cv, this.ab, this.p(0.5f));
                ub.a(merchantrecipelist, yc.bk.cv, this.ab, this.p(0.5f));
                ub.b(merchantrecipelist, yc.aC.cv, this.ab, this.p(0.1f));
                ub.b(merchantrecipelist, yc.Y.cv, this.ab, this.p(0.3f));
                ub.b(merchantrecipelist, yc.aa.cv, this.ab, this.p(0.3f));
                ub.b(merchantrecipelist, yc.X.cv, this.ab, this.p(0.3f));
                ub.b(merchantrecipelist, yc.Z.cv, this.ab, this.p(0.3f));
                ub.b(merchantrecipelist, yc.at.cv, this.ab, this.p(0.3f));
                ub.b(merchantrecipelist, yc.bl.cv, this.ab, this.p(0.3f));
            }
        }
        if (merchantrecipelist.isEmpty()) {
            ub.a(merchantrecipelist, yc.r.cv, this.ab, 1.0f);
        }
        Collections.shuffle(merchantrecipelist);
        if (this.bu == null) {
            this.bu = new abm();
        }
        for (int j1 = 0; j1 < par1 && j1 < merchantrecipelist.size(); ++j1) {
            this.bu.a((abl)merchantrecipelist.get(j1));
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void a(abm par1MerchantRecipeList) {
    }

    public static void a(abm par0MerchantRecipeList, int par1, Random par2Random, float par3) {
        if (par2Random.nextFloat() < par3) {
            par0MerchantRecipeList.add((Object)new abl(ub.a(par1, par2Random), yc.bJ));
        }
    }

    private static ye a(int par0, Random par1Random) {
        return new ye(par0, ub.b(par0, par1Random), 0);
    }

    private static int b(int par0, Random par1Random) {
        mh tuple = (mh)bB.get(par0);
        return tuple == null ? 1 : ((Integer)tuple.a() >= (Integer)tuple.b() ? (Integer)tuple.a() : (Integer)tuple.a() + par1Random.nextInt((Integer)tuple.b() - (Integer)tuple.a()));
    }

    public static void b(abm par0MerchantRecipeList, int par1, Random par2Random, float par3) {
        if (par2Random.nextFloat() < par3) {
            ye itemstack1;
            ye itemstack;
            int j2 = ub.c(par1, par2Random);
            if (j2 < 0) {
                itemstack = new ye(yc.bJ.cv, 1, 0);
                itemstack1 = new ye(par1, -j2, 0);
            } else {
                itemstack = new ye(yc.bJ.cv, j2, 0);
                itemstack1 = new ye(par1, 1, 0);
            }
            par0MerchantRecipeList.add((Object)new abl(itemstack, itemstack1));
        }
    }

    private static int c(int par0, Random par1Random) {
        mh tuple = (mh)bC.get(par0);
        return tuple == null ? 1 : ((Integer)tuple.a() >= (Integer)tuple.b() ? (Integer)tuple.a() : (Integer)tuple.a() + par1Random.nextInt((Integer)tuple.b() - (Integer)tuple.a()));
    }

    @SideOnly(value=Side.CLIENT)
    public void a(byte par1) {
        if (par1 == 12) {
            this.b("heart");
        } else if (par1 == 13) {
            this.b("angryVillager");
        } else if (par1 == 14) {
            this.b("happyVillager");
        } else {
            super.a(par1);
        }
    }

    public oi a(oi par1EntityLivingData) {
        par1EntityLivingData = super.a(par1EntityLivingData);
        VillagerRegistry.applyRandomTrade((ub)this, (Random)this.q.s);
        return par1EntityLivingData;
    }

    @SideOnly(value=Side.CLIENT)
    private void b(String par1Str) {
        for (int i2 = 0; i2 < 5; ++i2) {
            double d0 = this.ab.nextGaussian() * 0.02;
            double d1 = this.ab.nextGaussian() * 0.02;
            double d2 = this.ab.nextGaussian() * 0.02;
            this.q.a(par1Str, this.u + (double)(this.ab.nextFloat() * this.O * 2.0f) - (double)this.O, this.v + 1.0 + (double)(this.ab.nextFloat() * this.P), this.w + (double)(this.ab.nextFloat() * this.O * 2.0f) - (double)this.O, d0, d1, d2);
        }
    }

    public void bX() {
        this.bz = true;
    }

    public ub b(nk par1EntityAgeable) {
        ub entityvillager = new ub(this.q);
        entityvillager.a((oi)null);
        return entityvillager;
    }

    public boolean bG() {
        return false;
    }

    public nk a(nk par1EntityAgeable) {
        return this.b(par1EntityAgeable);
    }

    static {
        bB.put(yc.o.cv, new mh((Object)16, (Object)24));
        bB.put(yc.q.cv, new mh((Object)8, (Object)10));
        bB.put(yc.r.cv, new mh((Object)8, (Object)10));
        bB.put(yc.p.cv, new mh((Object)4, (Object)6));
        bB.put(yc.aM.cv, new mh((Object)24, (Object)36));
        bB.put(yc.aN.cv, new mh((Object)11, (Object)13));
        bB.put(yc.bI.cv, new mh((Object)1, (Object)1));
        bB.put(yc.bp.cv, new mh((Object)3, (Object)4));
        bB.put(yc.bC.cv, new mh((Object)2, (Object)3));
        bB.put(yc.as.cv, new mh((Object)14, (Object)18));
        bB.put(yc.bk.cv, new mh((Object)14, (Object)18));
        bB.put(yc.bm.cv, new mh((Object)14, (Object)18));
        bB.put(yc.aX.cv, new mh((Object)9, (Object)13));
        bB.put(yc.U.cv, new mh((Object)34, (Object)48));
        bB.put(yc.bj.cv, new mh((Object)30, (Object)38));
        bB.put(yc.bi.cv, new mh((Object)30, (Object)38));
        bB.put(yc.V.cv, new mh((Object)18, (Object)22));
        bB.put(aqz.ag.cF, new mh((Object)14, (Object)22));
        bB.put(yc.bo.cv, new mh((Object)36, (Object)64));
        bC.put(yc.k.cv, new mh((Object)3, (Object)4));
        bC.put(yc.bg.cv, new mh((Object)3, (Object)4));
        bC.put(yc.s.cv, new mh((Object)7, (Object)11));
        bC.put(yc.B.cv, new mh((Object)12, (Object)14));
        bC.put(yc.j.cv, new mh((Object)6, (Object)8));
        bC.put(yc.E.cv, new mh((Object)9, (Object)12));
        bC.put(yc.i.cv, new mh((Object)7, (Object)9));
        bC.put(yc.D.cv, new mh((Object)10, (Object)12));
        bC.put(yc.h.cv, new mh((Object)4, (Object)6));
        bC.put(yc.C.cv, new mh((Object)7, (Object)8));
        bC.put(yc.R.cv, new mh((Object)4, (Object)6));
        bC.put(yc.S.cv, new mh((Object)7, (Object)8));
        bC.put(yc.ai.cv, new mh((Object)4, (Object)6));
        bC.put(yc.am.cv, new mh((Object)7, (Object)8));
        bC.put(yc.af.cv, new mh((Object)4, (Object)6));
        bC.put(yc.aj.cv, new mh((Object)7, (Object)8));
        bC.put(yc.ag.cv, new mh((Object)10, (Object)14));
        bC.put(yc.ak.cv, new mh((Object)16, (Object)19));
        bC.put(yc.ah.cv, new mh((Object)8, (Object)10));
        bC.put(yc.al.cv, new mh((Object)11, (Object)14));
        bC.put(yc.ae.cv, new mh((Object)5, (Object)7));
        bC.put(yc.ab.cv, new mh((Object)5, (Object)7));
        bC.put(yc.ac.cv, new mh((Object)11, (Object)15));
        bC.put(yc.ad.cv, new mh((Object)9, (Object)11));
        bC.put(yc.W.cv, new mh((Object)-4, (Object)-2));
        bC.put(yc.bh.cv, new mh((Object)-8, (Object)-4));
        bC.put(yc.l.cv, new mh((Object)-8, (Object)-4));
        bC.put(yc.be.cv, new mh((Object)-10, (Object)-7));
        bC.put(aqz.R.cF, new mh((Object)-5, (Object)-3));
        bC.put(aqz.as.cF, new mh((Object)3, (Object)4));
        bC.put(yc.Y.cv, new mh((Object)4, (Object)5));
        bC.put(yc.aa.cv, new mh((Object)2, (Object)4));
        bC.put(yc.X.cv, new mh((Object)2, (Object)4));
        bC.put(yc.Z.cv, new mh((Object)2, (Object)4));
        bC.put(yc.aC.cv, new mh((Object)6, (Object)8));
        bC.put(yc.bF.cv, new mh((Object)-4, (Object)-1));
        bC.put(yc.aE.cv, new mh((Object)-4, (Object)-1));
        bC.put(yc.aS.cv, new mh((Object)10, (Object)12));
        bC.put(yc.aU.cv, new mh((Object)10, (Object)12));
        bC.put(aqz.bi.cF, new mh((Object)-3, (Object)-1));
        bC.put(yc.at.cv, new mh((Object)-7, (Object)-5));
        bC.put(yc.bl.cv, new mh((Object)-7, (Object)-5));
        bC.put(yc.bn.cv, new mh((Object)-8, (Object)-6));
        bC.put(yc.bC.cv, new mh((Object)7, (Object)11));
        bC.put(yc.n.cv, new mh((Object)-12, (Object)-8));
    }
}

