/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  alf
 *  ard
 *  bu
 *  cl
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  mo
 *  mp
 *  mu
 *  nb
 *  ni
 *  nk
 *  nw
 *  oi
 *  or
 *  os
 *  oy
 *  pp
 *  ps
 *  qj
 *  qm
 *  qq
 *  rt
 *  ru
 *  uz
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

public class rs
extends rp
implements mp {
    private static final nw bu = new rt();
    private static final or bv = new oy("horse.jumpStrength", 0.7, 0.0, 2.0).a("Jump Strength").a(true);
    private static final String[] bw = new String[]{null, "textures/entity/horse/armor/horse_armor_iron.png", "textures/entity/horse/armor/horse_armor_gold.png", "textures/entity/horse/armor/horse_armor_diamond.png"};
    private static final String[] bx = new String[]{"", "meo", "goo", "dio"};
    private static final int[] by = new int[]{0, 5, 7, 11};
    private static final String[] bz = new String[]{"textures/entity/horse/horse_white.png", "textures/entity/horse/horse_creamy.png", "textures/entity/horse/horse_chestnut.png", "textures/entity/horse/horse_brown.png", "textures/entity/horse/horse_black.png", "textures/entity/horse/horse_gray.png", "textures/entity/horse/horse_darkbrown.png"};
    private static final String[] bA = new String[]{"hwh", "hcr", "hch", "hbr", "hbl", "hgr", "hdb"};
    private static final String[] bB = new String[]{null, "textures/entity/horse/horse_markings_white.png", "textures/entity/horse/horse_markings_whitefield.png", "textures/entity/horse/horse_markings_whitedots.png", "textures/entity/horse/horse_markings_blackdots.png"};
    private static final String[] bC = new String[]{"", "wo_", "wmo", "wdo", "bdo"};
    private int bD;
    private int bE;
    private int bF;
    public int bp;
    public int bq;
    protected boolean br;
    private uz bG;
    private boolean bH;
    protected int bs;
    protected float bt;
    private boolean bI;
    private float bJ;
    private float bK;
    private float bL;
    private float bM;
    private float bN;
    private float bO;
    private int bP;
    private String bQ;
    private String[] bR = new String[3];

    public rs(abw par1World) {
        super(par1World);
        this.a(1.4f, 1.6f);
        this.ag = false;
        this.l(false);
        this.k().a(true);
        this.c.a(0, (ps)new pp((og)((Object)this)));
        this.c.a(1, (ps)new qj((on)((Object)this), 1.2));
        this.c.a(1, (ps)new qq(this, 1.2));
        this.c.a(2, (ps)new pk(this, 1.0));
        this.c.a(4, (ps)new pr(this, 1.0));
        this.c.a(6, (ps)new qm((on)((Object)this), 0.7));
        this.c.a(7, (ps)new px((og)((Object)this), uf.class, 6.0f));
        this.c.a(8, (ps)new ql((og)((Object)this)));
        this.cH();
    }

    protected void a() {
        super.a();
        this.ah.a(16, (Object)0);
        this.ah.a(19, (Object)0);
        this.ah.a(20, (Object)0);
        this.ah.a(21, String.valueOf(""));
        this.ah.a(22, (Object)0);
    }

    public void p(int par1) {
        this.ah.b(19, (byte)par1);
        this.cJ();
    }

    public int bT() {
        return this.ah.a(19);
    }

    public void q(int par1) {
        this.ah.b(20, par1);
        this.cJ();
    }

    public int bU() {
        return this.ah.c(20);
    }

    public String an() {
        if (this.bB()) {
            return this.bA();
        }
        int i2 = this.bT();
        switch (i2) {
            default: {
                return bu.a((String)"entity.horse.name");
            }
            case 1: {
                return bu.a((String)"entity.donkey.name");
            }
            case 2: {
                return bu.a((String)"entity.mule.name");
            }
            case 3: {
                return bu.a((String)"entity.zombiehorse.name");
            }
            case 4: 
        }
        return bu.a((String)"entity.skeletonhorse.name");
    }

    private boolean w(int par1) {
        return (this.ah.c(16) & par1) != 0;
    }

    private void b(int par1, boolean par2) {
        int j2 = this.ah.c(16);
        if (par2) {
            this.ah.b(16, j2 | par1);
        } else {
            this.ah.b(16, j2 & ~par1);
        }
    }

    public boolean bV() {
        return !this.g_();
    }

    public boolean bW() {
        return this.w(2);
    }

    public boolean ca() {
        return this.bV();
    }

    public String cb() {
        return this.ah.e(21);
    }

    public void b(String par1Str) {
        this.ah.b(21, par1Str);
    }

    public float cc() {
        int i2 = this.b();
        return i2 >= 0 ? 1.0f : 0.5f + (float)(-24000 - i2) / -24000.0f * 0.5f;
    }

    public void a(boolean par1) {
        if (par1) {
            this.a(this.cc());
        } else {
            this.a(1.0f);
        }
    }

    public boolean cd() {
        return this.br;
    }

    public void i(boolean par1) {
        this.b(2, par1);
    }

    public void j(boolean par1) {
        this.br = par1;
    }

    public boolean bG() {
        return !this.cy() && super.bG();
    }

    protected void o(float par1) {
        if (par1 > 6.0f && this.cg()) {
            this.o(false);
        }
    }

    public boolean ce() {
        return this.w(8);
    }

    public int cf() {
        return this.ah.c(22);
    }

    public int d(ye par1ItemStack) {
        return par1ItemStack == null ? 0 : (par1ItemStack.d == yc.ce.cv ? 1 : (par1ItemStack.d == yc.cf.cv ? 2 : (par1ItemStack.d == yc.cg.cv ? 3 : 0)));
    }

    public boolean cg() {
        return this.w(32);
    }

    public boolean ch() {
        return this.w(64);
    }

    public boolean ci() {
        return this.w(16);
    }

    public boolean cj() {
        return this.bH;
    }

    public void r(int par1) {
        this.ah.b(22, par1);
        this.cJ();
    }

    public void k(boolean par1) {
        this.b(16, par1);
    }

    public void l(boolean par1) {
        this.b(8, par1);
    }

    public void m(boolean par1) {
        this.bH = par1;
    }

    public void n(boolean par1) {
        this.b(4, par1);
    }

    public int ck() {
        return this.bs;
    }

    public void s(int par1) {
        this.bs = par1;
    }

    public int t(int par1) {
        int j2 = ls.a(this.ck() + par1, 0, this.cq());
        this.s(j2);
        return j2;
    }

    @Override
    public boolean a(nb par1DamageSource, float par2) {
        nn entity = par1DamageSource.i();
        return this.n != null && this.n.equals(entity) ? false : super.a(par1DamageSource, par2);
    }

    public int aQ() {
        return by[this.cf()];
    }

    public boolean M() {
        return this.n == null;
    }

    public boolean cl() {
        int i2 = ls.c(this.u);
        int j2 = ls.c(this.w);
        this.q.a(i2, j2);
        return true;
    }

    public void cm() {
        if (!this.q.I && this.ce()) {
            this.b(aqz.az.cF, 1);
            this.l(false);
        }
    }

    private void cF() {
        this.cM();
        this.q.a((nn)((Object)this), "eating", 1.0f, 1.0f + (this.ab.nextFloat() - this.ab.nextFloat()) * 0.2f);
    }

    protected void b(float par1) {
        int i2;
        if (par1 > 1.0f) {
            this.a("mob.horse.land", 0.4f, 1.0f);
        }
        if ((i2 = ls.f(par1 * 0.5f - 3.0f)) > 0) {
            int j2;
            this.a(nb.h, (float)i2);
            if (this.n != null) {
                this.n.a(nb.h, (float)i2);
            }
            if ((j2 = this.q.a(ls.c(this.u), ls.c(this.v - 0.2 - (double)this.C), ls.c(this.w))) > 0) {
                ard stepsound = aqz.s[j2].cS;
                this.q.a((nn)((Object)this), stepsound.e(), stepsound.c() * 0.5f, stepsound.d() * 0.75f);
            }
        }
    }

    private int cG() {
        int i2 = this.bT();
        return this.ce() && (i2 == 1 || i2 == 2) ? 17 : 2;
    }

    private void cH() {
        uz animalchest = this.bG;
        this.bG = new uz("HorseChest", this.cG());
        this.bG.a(this.an());
        if (animalchest != null) {
            animalchest.b((mp)this);
            int i2 = Math.min(animalchest.j_(), this.bG.j_());
            for (int j2 = 0; j2 < i2; ++j2) {
                ye itemstack = animalchest.a(j2);
                if (itemstack == null) continue;
                this.bG.a(j2, itemstack.m());
            }
            animalchest = null;
        }
        this.bG.a((mp)this);
        this.cI();
    }

    private void cI() {
        if (!this.q.I) {
            this.n(this.bG.a(0) != null);
            if (this.cv()) {
                this.r(this.d(this.bG.a(1)));
            }
        }
    }

    public void a(mu par1InventoryBasic) {
        int i2 = this.cf();
        boolean flag = this.co();
        this.cI();
        if (this.ac > 20) {
            if (i2 == 0 && i2 != this.cf()) {
                this.a("mob.horse.armor", 0.5f, 1.0f);
            }
            if (!flag && this.co()) {
                this.a("mob.horse.leather", 0.5f, 1.0f);
            }
        }
    }

    @Override
    public boolean bs() {
        this.cl();
        return super.bs();
    }

    protected rs a(nn par1Entity, double par2) {
        double d1 = Double.MAX_VALUE;
        nn entity1 = null;
        List list = this.q.a(par1Entity, par1Entity.E.a(par2, par2, par2), bu);
        for (nn entity2 : list) {
            double d2 = entity2.e(par1Entity.u, par1Entity.v, par1Entity.w);
            if (!(d2 < d1)) continue;
            entity1 = entity2;
            d1 = d2;
        }
        return (rs)((Object)entity1);
    }

    public double cn() {
        return this.a(bv).e();
    }

    protected String aP() {
        this.cM();
        int i2 = this.bT();
        return i2 == 3 ? "mob.horse.zombie.death" : (i2 == 4 ? "mob.horse.skeleton.death" : (i2 != 1 && i2 != 2 ? "mob.horse.death" : "mob.horse.donkey.death"));
    }

    protected int s() {
        boolean flag = this.ab.nextInt(4) == 0;
        int i2 = this.bT();
        return i2 == 4 ? yc.aZ.cv : (i2 == 3 ? (flag ? 0 : yc.bo.cv) : yc.aH.cv);
    }

    protected String aO() {
        int i2;
        this.cM();
        if (this.ab.nextInt(3) == 0) {
            this.cO();
        }
        return (i2 = this.bT()) == 3 ? "mob.horse.zombie.hit" : (i2 == 4 ? "mob.horse.skeleton.hit" : (i2 != 1 && i2 != 2 ? "mob.horse.hit" : "mob.horse.donkey.hit"));
    }

    public boolean co() {
        return this.w(4);
    }

    protected String r() {
        int i2;
        this.cM();
        if (this.ab.nextInt(10) == 0 && !this.bc()) {
            this.cO();
        }
        return (i2 = this.bT()) == 3 ? "mob.horse.zombie.idle" : (i2 == 4 ? "mob.horse.skeleton.idle" : (i2 != 1 && i2 != 2 ? "mob.horse.idle" : "mob.horse.donkey.idle"));
    }

    protected String cp() {
        this.cM();
        this.cO();
        int i2 = this.bT();
        return i2 != 3 && i2 != 4 ? (i2 != 1 && i2 != 2 ? "mob.horse.angry" : "mob.horse.donkey.angry") : null;
    }

    protected void a(int par1, int par2, int par3, int par4) {
        ard stepsound = aqz.s[par4].cS;
        if (this.q.a(par1, par2 + 1, par3) == aqz.aX.cF) {
            stepsound = aqz.aX.cS;
        }
        if (!aqz.s[par4].cU.d()) {
            int i1 = this.bT();
            if (this.n != null && i1 != 1 && i1 != 2) {
                ++this.bP;
                if (this.bP > 5 && this.bP % 3 == 0) {
                    this.a("mob.horse.gallop", stepsound.c() * 0.15f, stepsound.d());
                    if (i1 == 0 && this.ab.nextInt(10) == 0) {
                        this.a("mob.horse.breathe", stepsound.c() * 0.6f, stepsound.d());
                    }
                } else if (this.bP <= 5) {
                    this.a("mob.horse.wood", stepsound.c() * 0.15f, stepsound.d());
                }
            } else if (stepsound == aqz.h) {
                this.a("mob.horse.soft", stepsound.c() * 0.15f, stepsound.d());
            } else {
                this.a("mob.horse.wood", stepsound.c() * 0.15f, stepsound.d());
            }
        }
    }

    protected void az() {
        super.az();
        this.aX().b(bv);
        this.a(tp.a).a(53.0);
        this.a(tp.d).a((double)0.225f);
    }

    public int bv() {
        return 6;
    }

    public int cq() {
        return 100;
    }

    protected float ba() {
        return 0.8f;
    }

    @Override
    public int o() {
        return 400;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean cr() {
        return this.bT() == 0 || this.cf() > 0;
    }

    private void cJ() {
        this.bQ = null;
    }

    @SideOnly(value=Side.CLIENT)
    private void cK() {
        int k2;
        this.bQ = "horse/";
        this.bR[0] = null;
        this.bR[1] = null;
        this.bR[2] = null;
        int i2 = this.bT();
        int j2 = this.bU();
        if (i2 == 0) {
            k2 = j2 & 0xFF;
            int l2 = (j2 & 0xFF00) >> 8;
            this.bR[0] = bz[k2];
            this.bQ = this.bQ + bA[k2];
            this.bR[1] = bB[l2];
            this.bQ = this.bQ + bC[l2];
        } else {
            this.bR[0] = "";
            this.bQ = this.bQ + "_" + i2 + "_";
        }
        k2 = this.cf();
        this.bR[2] = bw[k2];
        this.bQ = this.bQ + bx[k2];
    }

    @SideOnly(value=Side.CLIENT)
    public String cs() {
        if (this.bQ == null) {
            this.cK();
        }
        return this.bQ;
    }

    @SideOnly(value=Side.CLIENT)
    public String[] ct() {
        if (this.bQ == null) {
            this.cK();
        }
        return this.bR;
    }

    public void f(uf par1EntityPlayer) {
        if (!this.q.I && (this.n == null || this.n == par1EntityPlayer) && this.bW()) {
            this.bG.a(this.an());
            par1EntityPlayer.a(this, (mo)this.bG);
        }
    }

    @Override
    public boolean a(uf par1EntityPlayer) {
        ye itemstack = par1EntityPlayer.bn.h();
        if (itemstack != null && itemstack.d == yc.bE.cv) {
            return super.a(par1EntityPlayer);
        }
        if (!this.bW() && this.cy()) {
            return false;
        }
        if (this.bW() && this.bV() && par1EntityPlayer.ah()) {
            this.f(par1EntityPlayer);
            return true;
        }
        if (this.ca() && this.n != null) {
            return super.a(par1EntityPlayer);
        }
        if (itemstack != null) {
            boolean flag = false;
            if (this.cv()) {
                int b0 = -1;
                if (itemstack.d == yc.ce.cv) {
                    b0 = 1;
                } else if (itemstack.d == yc.cf.cv) {
                    b0 = 2;
                } else if (itemstack.d == yc.cg.cv) {
                    b0 = 3;
                }
                if (b0 >= 0) {
                    if (!this.bW()) {
                        this.cD();
                        return true;
                    }
                    this.f(par1EntityPlayer);
                    return true;
                }
            }
            if (!flag && !this.cy()) {
                float f2 = 0.0f;
                int short1 = 0;
                int b1 = 0;
                if (itemstack.d == yc.V.cv) {
                    f2 = 2.0f;
                    short1 = 60;
                    b1 = 3;
                } else if (itemstack.d == yc.ba.cv) {
                    f2 = 1.0f;
                    short1 = 30;
                    b1 = 3;
                } else if (itemstack.d == yc.W.cv) {
                    f2 = 7.0f;
                    short1 = 180;
                    b1 = 3;
                } else if (itemstack.d == aqz.cB.cF) {
                    f2 = 20.0f;
                    short1 = 180;
                } else if (itemstack.d == yc.l.cv) {
                    f2 = 3.0f;
                    short1 = 60;
                    b1 = 3;
                } else if (itemstack.d == yc.bR.cv) {
                    f2 = 4.0f;
                    short1 = 60;
                    b1 = 5;
                    if (this.bW() && this.b() == 0) {
                        flag = true;
                        this.bX();
                    }
                } else if (itemstack.d == yc.av.cv) {
                    f2 = 10.0f;
                    short1 = 240;
                    b1 = 10;
                    if (this.bW() && this.b() == 0) {
                        flag = true;
                        this.bX();
                    }
                }
                if (this.aN() < this.aT() && f2 > 0.0f) {
                    this.f(f2);
                    flag = true;
                }
                if (!this.bV() && short1 > 0) {
                    this.a(short1);
                    flag = true;
                }
                if (b1 > 0 && (flag || !this.bW()) && b1 < this.cq()) {
                    flag = true;
                    this.t(b1);
                }
                if (flag) {
                    this.cF();
                }
            }
            if (!this.bW() && !flag) {
                if (itemstack != null && itemstack.a(par1EntityPlayer, (of)((Object)this))) {
                    return true;
                }
                this.cD();
                return true;
            }
            if (!flag && this.cw() && !this.ce() && itemstack.d == aqz.az.cF) {
                this.l(true);
                this.a("mob.chickenplop", 1.0f, (this.ab.nextFloat() - this.ab.nextFloat()) * 0.2f + 1.0f);
                flag = true;
                this.cH();
            }
            if (!flag && this.ca() && !this.co() && itemstack.d == yc.aC.cv) {
                this.f(par1EntityPlayer);
                return true;
            }
            if (flag) {
                if (!par1EntityPlayer.bG.d && --itemstack.b == 0) {
                    par1EntityPlayer.bn.a(par1EntityPlayer.bn.c, (ye)null);
                }
                return true;
            }
        }
        if (this.ca() && this.n == null) {
            if (itemstack != null && itemstack.a(par1EntityPlayer, (of)((Object)this))) {
                return true;
            }
            this.h(par1EntityPlayer);
            return true;
        }
        return super.a(par1EntityPlayer);
    }

    private void h(uf par1EntityPlayer) {
        par1EntityPlayer.A = this.A;
        par1EntityPlayer.B = this.B;
        this.o(false);
        this.p(false);
        if (!this.q.I) {
            par1EntityPlayer.a((nn)((Object)this));
        }
    }

    public boolean cv() {
        return this.bT() == 0;
    }

    public boolean cw() {
        int i2 = this.bT();
        return i2 == 2 || i2 == 1;
    }

    protected boolean bc() {
        return this.n != null && this.co() ? true : this.cg() || this.ch();
    }

    public boolean cy() {
        int i2 = this.bT();
        return i2 == 3 || i2 == 4;
    }

    public boolean cz() {
        return this.cy() || this.bT() == 2;
    }

    @Override
    public boolean c(ye par1ItemStack) {
        return false;
    }

    private void cL() {
        this.bp = 1;
    }

    public void a(nb par1DamageSource) {
        super.a(par1DamageSource);
        if (!this.q.I) {
            this.cE();
        }
    }

    @Override
    public void c() {
        if (this.ab.nextInt(200) == 0) {
            this.cL();
        }
        super.c();
        if (!this.q.I) {
            rs entityhorse;
            if (this.ab.nextInt(900) == 0 && this.aB == 0) {
                this.f(1.0f);
            }
            if (!this.cg() && this.n == null && this.ab.nextInt(300) == 0 && this.q.a(ls.c(this.u), ls.c(this.v) - 1, ls.c(this.w)) == aqz.z.cF) {
                this.o(true);
            }
            if (this.cg() && ++this.bD > 50) {
                this.bD = 0;
                this.o(false);
            }
            if (this.ci() && !this.bV() && !this.cg() && (entityhorse = this.a((nn)((Object)this), 16.0)) != null && this.e((nn)((Object)entityhorse)) > 4.0) {
                alf pathentity = this.q.a((nn)((Object)this), (nn)((Object)entityhorse), 16.0f, true, false, false, true);
                this.a(pathentity);
            }
        }
    }

    public void l_() {
        super.l_();
        if (this.q.I && this.ah.a()) {
            this.ah.e();
            this.cJ();
        }
        if (this.bE > 0 && ++this.bE > 30) {
            this.bE = 0;
            this.b(128, false);
        }
        if (!this.q.I && this.bF > 0 && ++this.bF > 20) {
            this.bF = 0;
            this.p(false);
        }
        if (this.bp > 0 && ++this.bp > 8) {
            this.bp = 0;
        }
        if (this.bq > 0) {
            ++this.bq;
            if (this.bq > 300) {
                this.bq = 0;
            }
        }
        this.bK = this.bJ;
        if (this.cg()) {
            this.bJ += (1.0f - this.bJ) * 0.4f + 0.05f;
            if (this.bJ > 1.0f) {
                this.bJ = 1.0f;
            }
        } else {
            this.bJ += (0.0f - this.bJ) * 0.4f - 0.05f;
            if (this.bJ < 0.0f) {
                this.bJ = 0.0f;
            }
        }
        this.bM = this.bL;
        if (this.ch()) {
            this.bJ = 0.0f;
            this.bK = 0.0f;
            this.bL += (1.0f - this.bL) * 0.4f + 0.05f;
            if (this.bL > 1.0f) {
                this.bL = 1.0f;
            }
        } else {
            this.bI = false;
            this.bL += (0.8f * this.bL * this.bL * this.bL - this.bL) * 0.6f - 0.05f;
            if (this.bL < 0.0f) {
                this.bL = 0.0f;
            }
        }
        this.bO = this.bN;
        if (this.w(128)) {
            this.bN += (1.0f - this.bN) * 0.7f + 0.05f;
            if (this.bN > 1.0f) {
                this.bN = 1.0f;
            }
        } else {
            this.bN += (0.0f - this.bN) * 0.7f - 0.05f;
            if (this.bN < 0.0f) {
                this.bN = 0.0f;
            }
        }
    }

    private void cM() {
        if (!this.q.I) {
            this.bE = 1;
            this.b(128, true);
        }
    }

    private boolean cN() {
        return this.n == null && this.o == null && this.bW() && this.bV() && !this.cz() && this.aN() >= this.aT();
    }

    public void e(boolean par1) {
        this.b(32, par1);
    }

    public void o(boolean par1) {
        this.e(par1);
    }

    public void p(boolean par1) {
        if (par1) {
            this.o(false);
        }
        this.b(64, par1);
    }

    private void cO() {
        if (!this.q.I) {
            this.bF = 1;
            this.p(true);
        }
    }

    public void cD() {
        this.cO();
        String s2 = this.cp();
        if (s2 != null) {
            this.a(s2, this.ba(), this.bb());
        }
    }

    public void cE() {
        this.a((nn)((Object)this), this.bG);
        this.cm();
    }

    private void a(nn par1Entity, uz par2AnimalChest) {
        if (par2AnimalChest != null && !this.q.I) {
            for (int i2 = 0; i2 < par2AnimalChest.j_(); ++i2) {
                ye itemstack = par2AnimalChest.a(i2);
                if (itemstack == null) continue;
                this.a(itemstack, 0.0f);
            }
        }
    }

    public boolean g(uf par1EntityPlayer) {
        this.b(par1EntityPlayer.c_());
        this.i(true);
        return true;
    }

    public void e(float par1, float par2) {
        if (this.n != null && this.co()) {
            this.C = this.A = this.n.A;
            this.B = this.n.B * 0.5f;
            this.b(this.A, this.B);
            this.aP = this.aN = this.A;
            par1 = ((of)this.n).be * 0.5f;
            par2 = ((of)this.n).bf;
            if (par2 <= 0.0f) {
                par2 *= 0.25f;
                this.bP = 0;
            }
            if (this.F && this.bt == 0.0f && this.ch() && !this.bI) {
                par1 = 0.0f;
                par2 = 0.0f;
            }
            if (this.bt > 0.0f && !this.cd() && this.F) {
                this.y = this.cn() * (double)this.bt;
                if (this.a(ni.j)) {
                    this.y += (double)((float)(this.b(ni.j).c() + 1) * 0.1f);
                }
                this.j(true);
                this.an = true;
                if (par2 > 0.0f) {
                    float f2 = ls.a(this.A * (float)Math.PI / 180.0f);
                    float f3 = ls.b(this.A * (float)Math.PI / 180.0f);
                    this.x += (double)(-0.4f * f2 * this.bt);
                    this.z += (double)(0.4f * f3 * this.bt);
                    this.a("mob.horse.jump", 0.4f, 1.0f);
                }
                this.bt = 0.0f;
            }
            this.Y = 1.0f;
            this.aR = this.bg() * 0.1f;
            if (!this.q.I) {
                this.i((float)this.a(tp.d).e());
                super.e(par1, par2);
            }
            if (this.F) {
                this.bt = 0.0f;
                this.j(false);
            }
            this.aF = this.aG;
            double d0 = this.u - this.r;
            double d1 = this.w - this.t;
            float f4 = ls.a(d0 * d0 + d1 * d1) * 4.0f;
            if (f4 > 1.0f) {
                f4 = 1.0f;
            }
            this.aG += (f4 - this.aG) * 0.4f;
            this.aH += this.aG;
        } else {
            this.Y = 0.5f;
            this.aR = 0.02f;
            super.e(par1, par2);
        }
    }

    @Override
    public void b(by par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("EatingHaystack", this.cg());
        par1NBTTagCompound.a("ChestedHorse", this.ce());
        par1NBTTagCompound.a("HasReproduced", this.cj());
        par1NBTTagCompound.a("Bred", this.ci());
        par1NBTTagCompound.a("Type", this.bT());
        par1NBTTagCompound.a("Variant", this.bU());
        par1NBTTagCompound.a("Temper", this.ck());
        par1NBTTagCompound.a("Tame", this.bW());
        par1NBTTagCompound.a("OwnerName", this.cb());
        if (this.ce()) {
            cg nbttaglist = new cg();
            for (int i2 = 2; i2 < this.bG.j_(); ++i2) {
                ye itemstack = this.bG.a(i2);
                if (itemstack == null) continue;
                by nbttagcompound1 = new by();
                nbttagcompound1.a("Slot", (byte)i2);
                itemstack.b(nbttagcompound1);
                nbttaglist.a(nbttagcompound1);
            }
            par1NBTTagCompound.a("Items", nbttaglist);
        }
        if (this.bG.a(1) != null) {
            par1NBTTagCompound.a("ArmorItem", (cl)this.bG.a(1).b(new by("ArmorItem")));
        }
        if (this.bG.a(0) != null) {
            par1NBTTagCompound.a("SaddleItem", (cl)this.bG.a(0).b(new by("SaddleItem")));
        }
    }

    @Override
    public void a(by par1NBTTagCompound) {
        ye itemstack;
        os attributeinstance;
        super.a(par1NBTTagCompound);
        this.o(par1NBTTagCompound.n("EatingHaystack"));
        this.k(par1NBTTagCompound.n("Bred"));
        this.l(par1NBTTagCompound.n("ChestedHorse"));
        this.m(par1NBTTagCompound.n("HasReproduced"));
        this.p(par1NBTTagCompound.e("Type"));
        this.q(par1NBTTagCompound.e("Variant"));
        this.s(par1NBTTagCompound.e("Temper"));
        this.i(par1NBTTagCompound.n("Tame"));
        if (par1NBTTagCompound.b("OwnerName")) {
            this.b(par1NBTTagCompound.i("OwnerName"));
        }
        if ((attributeinstance = this.aX().a("Speed")) != null) {
            this.a(tp.d).a(attributeinstance.b() * 0.25);
        }
        if (this.ce()) {
            cg nbttaglist = par1NBTTagCompound.m("Items");
            this.cH();
            for (int i2 = 0; i2 < nbttaglist.c(); ++i2) {
                by nbttagcompound1 = (by)nbttaglist.b(i2);
                int j2 = nbttagcompound1.c("Slot") & 0xFF;
                if (j2 < 2 || j2 >= this.bG.j_()) continue;
                this.bG.a(j2, ye.a(nbttagcompound1));
            }
        }
        if (par1NBTTagCompound.b("ArmorItem") && (itemstack = ye.a(par1NBTTagCompound.l("ArmorItem"))) != null && rs.v(itemstack.d)) {
            this.bG.a(1, itemstack);
        }
        if (par1NBTTagCompound.b("SaddleItem")) {
            itemstack = ye.a(par1NBTTagCompound.l("SaddleItem"));
            if (itemstack != null && itemstack.d == yc.aC.cv) {
                this.bG.a(0, itemstack);
            }
        } else if (par1NBTTagCompound.n("Saddle")) {
            this.bG.a(0, new ye(yc.aC));
        }
        this.cI();
    }

    @Override
    public boolean a(rp par1EntityAnimal) {
        if (par1EntityAnimal == this) {
            return false;
        }
        if (((Object)((Object)par1EntityAnimal)).getClass() != ((Object)((Object)this)).getClass()) {
            return false;
        }
        rs entityhorse = (rs)par1EntityAnimal;
        if (this.cN() && entityhorse.cN()) {
            int j2;
            int i2 = this.bT();
            return i2 == (j2 = entityhorse.bT()) || i2 == 0 && j2 == 1 || i2 == 1 && j2 == 0;
        }
        return false;
    }

    public nk a(nk par1EntityAgeable) {
        rs entityhorse = (rs)par1EntityAgeable;
        rs entityhorse1 = new rs(this.q);
        int i2 = this.bT();
        int j2 = entityhorse.bT();
        int k2 = 0;
        if (i2 == j2) {
            k2 = i2;
        } else if (i2 == 0 && j2 == 1 || i2 == 1 && j2 == 0) {
            k2 = 2;
        }
        if (k2 == 0) {
            int l2 = this.ab.nextInt(9);
            int i1 = l2 < 4 ? this.bU() & 0xFF : (l2 < 8 ? entityhorse.bU() & 0xFF : this.ab.nextInt(7));
            int j1 = this.ab.nextInt(5);
            i1 = j1 < 4 ? (i1 |= this.bU() & 0xFF00) : (j1 < 8 ? (i1 |= entityhorse.bU() & 0xFF00) : (i1 |= this.ab.nextInt(5) << 8 & 0xFF00));
            entityhorse1.q(i1);
        }
        entityhorse1.p(k2);
        double d0 = this.a(tp.a).b() + par1EntityAgeable.a(tp.a).b() + (double)this.cP();
        entityhorse1.a(tp.a).a(d0 / 3.0);
        double d1 = this.a(bv).b() + par1EntityAgeable.a(bv).b() + this.cQ();
        entityhorse1.a(bv).a(d1 / 3.0);
        double d2 = this.a(tp.d).b() + par1EntityAgeable.a(tp.d).b() + this.cR();
        entityhorse1.a(tp.d).a(d2 / 3.0);
        return entityhorse1;
    }

    public oi a(oi par1EntityLivingData) {
        int j2;
        oi par1EntityLivingData1 = super.a(par1EntityLivingData);
        boolean flag = false;
        int i2 = 0;
        if (par1EntityLivingData1 instanceof ru) {
            j2 = ((ru)par1EntityLivingData1).a;
            i2 = ((ru)par1EntityLivingData1).b & 0xFF | this.ab.nextInt(5) << 8;
        } else {
            if (this.ab.nextInt(10) == 0) {
                j2 = 1;
            } else {
                int k2 = this.ab.nextInt(7);
                int l2 = this.ab.nextInt(5);
                j2 = 0;
                i2 = k2 | l2 << 8;
            }
            par1EntityLivingData1 = new ru(j2, i2);
        }
        this.p(j2);
        this.q(i2);
        if (this.ab.nextInt(5) == 0) {
            this.c(-24000);
        }
        if (j2 != 4 && j2 != 3) {
            this.a(tp.a).a((double)this.cP());
            if (j2 == 0) {
                this.a(tp.d).a(this.cR());
            } else {
                this.a(tp.d).a((double)0.175f);
            }
        } else {
            this.a(tp.a).a(15.0);
            this.a(tp.d).a((double)0.2f);
        }
        if (j2 != 2 && j2 != 1) {
            this.a(bv).a(this.cQ());
        } else {
            this.a(bv).a(0.5);
        }
        this.g(this.aT());
        return par1EntityLivingData1;
    }

    @SideOnly(value=Side.CLIENT)
    public float p(float par1) {
        return this.bK + (this.bJ - this.bK) * par1;
    }

    @SideOnly(value=Side.CLIENT)
    public float q(float par1) {
        return this.bM + (this.bL - this.bM) * par1;
    }

    @SideOnly(value=Side.CLIENT)
    public float r(float par1) {
        return this.bO + (this.bN - this.bO) * par1;
    }

    protected boolean bf() {
        return true;
    }

    public void u(int par1) {
        if (this.co()) {
            if (par1 < 0) {
                par1 = 0;
            } else {
                this.bI = true;
                this.cO();
            }
            this.bt = par1 >= 90 ? 1.0f : 0.4f + 0.4f * (float)par1 / 90.0f;
        }
    }

    @SideOnly(value=Side.CLIENT)
    protected void q(boolean par1) {
        String s2 = par1 ? "heart" : "smoke";
        for (int i2 = 0; i2 < 7; ++i2) {
            double d0 = this.ab.nextGaussian() * 0.02;
            double d1 = this.ab.nextGaussian() * 0.02;
            double d2 = this.ab.nextGaussian() * 0.02;
            this.q.a(s2, this.u + (double)(this.ab.nextFloat() * this.O * 2.0f) - (double)this.O, this.v + 0.5 + (double)(this.ab.nextFloat() * this.P), this.w + (double)(this.ab.nextFloat() * this.O * 2.0f) - (double)this.O, d0, d1, d2);
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(byte par1) {
        if (par1 == 7) {
            this.q(true);
        } else if (par1 == 6) {
            this.q(false);
        } else {
            super.a(par1);
        }
    }

    public void W() {
        super.W();
        if (this.bM > 0.0f) {
            float f2 = ls.a(this.aN * (float)Math.PI / 180.0f);
            float f1 = ls.b(this.aN * (float)Math.PI / 180.0f);
            float f22 = 0.7f * this.bM;
            float f3 = 0.15f * this.bM;
            this.n.b(this.u + (double)(f22 * f2), this.v + this.Y() + this.n.X() + (double)f3, this.w - (double)(f22 * f1));
            if (this.n instanceof of) {
                ((of)this.n).aN = this.aN;
            }
        }
    }

    private float cP() {
        return 15.0f + (float)this.ab.nextInt(8) + (float)this.ab.nextInt(9);
    }

    private double cQ() {
        return (double)0.4f + this.ab.nextDouble() * 0.2 + this.ab.nextDouble() * 0.2 + this.ab.nextDouble() * 0.2;
    }

    private double cR() {
        return ((double)0.45f + this.ab.nextDouble() * 0.3 + this.ab.nextDouble() * 0.3 + this.ab.nextDouble() * 0.3) * 0.25;
    }

    public static boolean v(int par0) {
        return par0 == yc.ce.cv || par0 == yc.cf.cv || par0 == yc.cg.cv;
    }

    public boolean e() {
        return false;
    }
}

