/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aaw
 *  akc
 *  ard
 *  asx
 *  ata
 *  atc
 *  atl
 *  cd
 *  cj
 *  cl
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  dj
 *  fq
 *  ga
 *  ms
 *  na
 *  nb
 *  net.minecraftforge.common.ForgeHooks
 *  ni
 *  oa
 *  or
 *  os
 *  ot
 *  ov
 *  pa
 *  wh
 *  zp
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import net.minecraftforge.common.ForgeHooks;

public abstract class of
extends nn {
    private static final UUID b = UUID.fromString("662A6B8D-DA3E-4C1C-8813-96EA6097278D");
    private static final ot c = new ot(b, "Sprinting speed boost", (double)0.3f, 2).a(false);
    private ov d;
    private final na e = new na(this);
    private final HashMap f = new HashMap();
    private final ye[] g = new ye[5];
    public boolean au;
    public int av;
    public int aw;
    public float ax;
    public int ay;
    public int az;
    public float aA;
    public int aB;
    public int aC;
    public float aD;
    public float aE;
    public float aF;
    public float aG;
    public float aH;
    public int aI = 20;
    public float aJ;
    public float aK;
    public float aL;
    public float aM;
    public float aN;
    public float aO;
    public float aP;
    public float aQ;
    public float aR = 0.02f;
    protected uf aS;
    protected int aT;
    protected boolean aU;
    protected int aV;
    protected float aW;
    protected float aX;
    protected float aY;
    protected float aZ;
    protected float ba;
    protected int bb;
    protected float bc;
    protected boolean bd;
    public float be;
    public float bf;
    protected float bg;
    protected int bh;
    protected double bi;
    protected double bj;
    protected double bk;
    protected double bl;
    protected double bm;
    private boolean h = true;
    private of i;
    private int j;
    private of bn;
    private int bo;
    private float bp;
    private int bq;
    private float br;

    public of(abw par1World) {
        super(par1World);
        this.az();
        this.g(this.aT());
        this.m = true;
        this.aM = (float)(Math.random() + 1.0) * 0.01f;
        this.b(this.u, this.v, this.w);
        this.aL = (float)Math.random() * 12398.0f;
        this.aP = this.A = (float)(Math.random() * Math.PI * 2.0);
        this.Y = 0.5f;
    }

    @Override
    protected void a() {
        this.ah.a(7, (Object)0);
        this.ah.a(8, (Object)0);
        this.ah.a(9, (Object)0);
        this.ah.a(6, Float.valueOf(1.0f));
    }

    protected void az() {
        this.aX().b(tp.a);
        this.aX().b(tp.c);
        this.aX().b(tp.d);
        if (!this.bf()) {
            this.a(tp.d).a((double)0.1f);
        }
    }

    @Override
    protected void a(double par1, boolean par3) {
        if (!this.H()) {
            this.I();
        }
        if (par3 && this.T > 0.0f) {
            int i1;
            int k2;
            int j2;
            int i2 = ls.c(this.u);
            int l2 = this.q.a(i2, j2 = ls.c(this.v - (double)0.2f - (double)this.N), k2 = ls.c(this.w));
            if (l2 == 0 && ((i1 = this.q.e(i2, j2 - 1, k2)) == 11 || i1 == 32 || i1 == 21)) {
                l2 = this.q.a(i2, j2 - 1, k2);
            }
            if (l2 > 0) {
                aqz.s[l2].a(this.q, i2, j2, k2, (nn)this, this.T);
            }
        }
        super.a(par1, par3);
    }

    public boolean aA() {
        return false;
    }

    @Override
    public void y() {
        boolean flag;
        this.aD = this.aE;
        super.y();
        this.q.C.a("livingEntityBaseTick");
        if (this.T() && this.U()) {
            this.a(nb.d, 1.0f);
        }
        if (this.F() || this.q.I) {
            this.B();
        }
        boolean bl2 = flag = this instanceof uf && ((uf)this).bG.a;
        if (this.T() && this.a(akc.h)) {
            if (!(this.aA() || this.i(ni.o.H) || flag)) {
                this.g(this.h(this.al()));
                if (this.al() == -20) {
                    this.g(0);
                    for (int i2 = 0; i2 < 8; ++i2) {
                        float f2 = this.ab.nextFloat() - this.ab.nextFloat();
                        float f1 = this.ab.nextFloat() - this.ab.nextFloat();
                        float f22 = this.ab.nextFloat() - this.ab.nextFloat();
                        this.q.a("bubble", this.u + (double)f2, this.v + (double)f1, this.w + (double)f22, this.x, this.y, this.z);
                    }
                    this.a(nb.e, 2.0f);
                }
            }
            this.B();
            if (!this.q.I && this.ag() && this.o != null && this.o.shouldDismountInWater(this)) {
                this.a((nn)null);
            }
        } else {
            this.g(300);
        }
        this.aJ = this.aK;
        if (this.aC > 0) {
            --this.aC;
        }
        if (this.ay > 0) {
            --this.ay;
        }
        if (this.af > 0) {
            --this.af;
        }
        if (this.aN() <= 0.0f) {
            this.aB();
        }
        if (this.aT > 0) {
            --this.aT;
        } else {
            this.aS = null;
        }
        if (this.bn != null && !this.bn.T()) {
            this.bn = null;
        }
        if (this.i != null && !this.i.T()) {
            this.b((of)null);
        }
        this.aJ();
        this.aZ = this.aY;
        this.aO = this.aN;
        this.aQ = this.aP;
        this.C = this.A;
        this.D = this.B;
        this.q.C.b();
    }

    public boolean g_() {
        return false;
    }

    protected void aB() {
        ++this.aB;
        if (this.aB == 20) {
            int i2;
            if (!this.q.I && (this.aT > 0 || this.aC()) && !this.g_() && this.q.O().b("doMobLoot")) {
                int j2;
                for (i2 = this.e(this.aS); i2 > 0; i2 -= j2) {
                    j2 = oa.a((int)i2);
                    this.q.d((nn)new oa(this.q, this.u, this.v, this.w, j2));
                }
            }
            this.x();
            for (i2 = 0; i2 < 20; ++i2) {
                double d0 = this.ab.nextGaussian() * 0.02;
                double d1 = this.ab.nextGaussian() * 0.02;
                double d2 = this.ab.nextGaussian() * 0.02;
                this.q.a("explode", this.u + (double)(this.ab.nextFloat() * this.O * 2.0f) - (double)this.O, this.v + (double)(this.ab.nextFloat() * this.P), this.w + (double)(this.ab.nextFloat() * this.O * 2.0f) - (double)this.O, d0, d1, d2);
            }
        }
    }

    protected int h(int par1) {
        int j2 = aaw.b((of)this);
        return j2 > 0 && this.ab.nextInt(j2 + 1) > 0 ? par1 : par1 - 1;
    }

    protected int e(uf par1EntityPlayer) {
        return 0;
    }

    protected boolean aC() {
        return false;
    }

    public Random aD() {
        return this.ab;
    }

    public of aE() {
        return this.i;
    }

    public int aF() {
        return this.j;
    }

    public void b(of par1EntityLivingBase) {
        this.i = par1EntityLivingBase;
        this.j = this.ac;
        ForgeHooks.onLivingSetAttackTarget((of)this, (of)par1EntityLivingBase);
    }

    public of aG() {
        return this.bn;
    }

    public int aH() {
        return this.bo;
    }

    public void k(nn par1Entity) {
        this.bn = par1Entity instanceof of ? (of)par1Entity : null;
        this.bo = this.ac;
    }

    public int aI() {
        return this.aV;
    }

    @Override
    public void b(by par1NBTTagCompound) {
        par1NBTTagCompound.a("HealF", this.aN());
        par1NBTTagCompound.a("Health", (short)Math.ceil(this.aN()));
        par1NBTTagCompound.a("HurtTime", (short)this.ay);
        par1NBTTagCompound.a("DeathTime", (short)this.aB);
        par1NBTTagCompound.a("AttackTime", (short)this.aC);
        par1NBTTagCompound.a("AbsorptionAmount", this.bn());
        for (ye itemstack : this.ae()) {
            if (itemstack == null) continue;
            this.d.a(itemstack.D());
        }
        par1NBTTagCompound.a("Attributes", tp.a(this.aX()));
        for (ye itemstack : this.ae()) {
            if (itemstack == null) continue;
            this.d.b(itemstack.D());
        }
        if (!this.f.isEmpty()) {
            cg nbttaglist = new cg();
            for (nj potioneffect : this.f.values()) {
                nbttaglist.a(potioneffect.a(new by()));
            }
            par1NBTTagCompound.a("ActiveEffects", nbttaglist);
        }
    }

    @Override
    public void a(by par1NBTTagCompound) {
        this.m(par1NBTTagCompound.g("AbsorptionAmount"));
        if (par1NBTTagCompound.b("Attributes") && this.q != null && !this.q.I) {
            tp.a(this.aX(), par1NBTTagCompound.m("Attributes"), this.q == null ? null : this.q.Y());
        }
        if (par1NBTTagCompound.b("ActiveEffects")) {
            cg nbttaglist = par1NBTTagCompound.m("ActiveEffects");
            for (int i2 = 0; i2 < nbttaglist.c(); ++i2) {
                by nbttagcompound1 = (by)nbttaglist.b(i2);
                nj potioneffect = nj.b(nbttagcompound1);
                this.f.put(potioneffect.a(), potioneffect);
            }
        }
        if (par1NBTTagCompound.b("HealF")) {
            this.g(par1NBTTagCompound.g("HealF"));
        } else {
            cl nbtbase = par1NBTTagCompound.a("Health");
            if (nbtbase == null) {
                this.g(this.aT());
            } else if (nbtbase.a() == 5) {
                this.g(((cd)nbtbase).a);
            } else if (nbtbase.a() == 2) {
                this.g((float)((cj)nbtbase).a);
            }
        }
        this.ay = par1NBTTagCompound.d("HurtTime");
        this.aB = par1NBTTagCompound.d("DeathTime");
        this.aC = par1NBTTagCompound.d("AttackTime");
    }

    protected void aJ() {
        boolean flag;
        Iterator iterator = this.f.keySet().iterator();
        while (iterator.hasNext()) {
            Integer integer = (Integer)iterator.next();
            nj potioneffect = (nj)this.f.get(integer);
            if (!potioneffect.a(this)) {
                if (this.q.I) continue;
                iterator.remove();
                this.b(potioneffect);
                continue;
            }
            if (potioneffect.b() % 600 != 0) continue;
            this.a(potioneffect, false);
        }
        if (this.h) {
            if (!this.q.I) {
                if (this.f.isEmpty()) {
                    this.ah.b(8, (byte)0);
                    this.ah.b(7, 0);
                    this.d(false);
                } else {
                    int i2 = zp.a(this.f.values());
                    this.ah.b(8, (byte)(zp.b(this.f.values()) ? 1 : 0));
                    this.ah.b(7, i2);
                    this.d(this.i(ni.p.H));
                }
            }
            this.h = false;
        }
        int i3 = this.ah.c(7);
        boolean bl2 = flag = this.ah.a(8) > 0;
        if (i3 > 0) {
            boolean flag1 = false;
            if (!this.aj()) {
                flag1 = this.ab.nextBoolean();
            } else {
                boolean bl3 = flag1 = this.ab.nextInt(15) == 0;
            }
            if (flag) {
                flag1 &= this.ab.nextInt(5) == 0;
            }
            if (flag1 && i3 > 0) {
                double d0 = (double)(i3 >> 16 & 0xFF) / 255.0;
                double d1 = (double)(i3 >> 8 & 0xFF) / 255.0;
                double d2 = (double)(i3 >> 0 & 0xFF) / 255.0;
                this.q.a(flag ? "mobSpellAmbient" : "mobSpell", this.u + (this.ab.nextDouble() - 0.5) * (double)this.O, this.v + this.ab.nextDouble() * (double)this.P - (double)this.N, this.w + (this.ab.nextDouble() - 0.5) * (double)this.O, d0, d1, d2);
            }
        }
    }

    public void aK() {
        Iterator iterator = this.f.keySet().iterator();
        while (iterator.hasNext()) {
            Integer integer = (Integer)iterator.next();
            nj potioneffect = (nj)this.f.get(integer);
            if (this.q.I) continue;
            iterator.remove();
            this.b(potioneffect);
        }
    }

    public Collection aL() {
        return this.f.values();
    }

    public boolean i(int par1) {
        return this.f.containsKey(par1);
    }

    public boolean a(ni par1Potion) {
        return this.f.containsKey(par1Potion.H);
    }

    public nj b(ni par1Potion) {
        return (nj)this.f.get(par1Potion.H);
    }

    public void c(nj par1PotionEffect) {
        if (this.d(par1PotionEffect)) {
            if (this.f.containsKey(par1PotionEffect.a())) {
                ((nj)this.f.get(par1PotionEffect.a())).a(par1PotionEffect);
                this.a((nj)this.f.get(par1PotionEffect.a()), true);
            } else {
                this.f.put(par1PotionEffect.a(), par1PotionEffect);
                this.a(par1PotionEffect);
            }
        }
    }

    public boolean d(nj par1PotionEffect) {
        int i2;
        return this.aY() != oj.b || (i2 = par1PotionEffect.a()) != ni.l.H && i2 != ni.u.H;
    }

    public boolean aM() {
        return this.aY() == oj.b;
    }

    public void j(int par1) {
        this.f.remove(par1);
    }

    public void k(int par1) {
        nj potioneffect = (nj)this.f.remove(par1);
        if (potioneffect != null) {
            this.b(potioneffect);
        }
    }

    protected void a(nj par1PotionEffect) {
        this.h = true;
        if (!this.q.I) {
            ni.a[par1PotionEffect.a()].b(this, this.aX(), par1PotionEffect.c());
        }
    }

    protected void a(nj par1PotionEffect, boolean par2) {
        this.h = true;
        if (par2 && !this.q.I) {
            ni.a[par1PotionEffect.a()].a(this, this.aX(), par1PotionEffect.c());
            ni.a[par1PotionEffect.a()].b(this, this.aX(), par1PotionEffect.c());
        }
    }

    protected void b(nj par1PotionEffect) {
        this.h = true;
        if (!this.q.I) {
            ni.a[par1PotionEffect.a()].a(this, this.aX(), par1PotionEffect.c());
        }
    }

    public void f(float par1) {
        float f1 = this.aN();
        if (f1 > 0.0f) {
            this.g(f1 + par1);
        }
    }

    public final float aN() {
        return this.ah.d(6);
    }

    public void g(float par1) {
        this.ah.b(6, Float.valueOf(ls.a(par1, 0.0f, this.aT())));
    }

    @Override
    public boolean a(nb par1DamageSource, float par2) {
        if (ForgeHooks.onLivingAttack((of)this, (nb)par1DamageSource, (float)par2)) {
            return false;
        }
        if (this.ar()) {
            return false;
        }
        if (this.q.I) {
            return false;
        }
        this.aV = 0;
        if (this.aN() <= 0.0f) {
            return false;
        }
        if (par1DamageSource.m() && this.a(ni.n)) {
            return false;
        }
        if ((par1DamageSource == nb.m || par1DamageSource == nb.n) && this.n(4) != null) {
            this.n(4).a((int)(par2 * 4.0f + this.ab.nextFloat() * par2 * 2.0f), this);
            par2 *= 0.75f;
        }
        this.aG = 1.5f;
        boolean flag = true;
        if ((float)this.af > (float)this.aI / 2.0f) {
            if (par2 <= this.bc) {
                return false;
            }
            this.d(par1DamageSource, par2 - this.bc);
            this.bc = par2;
            flag = false;
        } else {
            this.bc = par2;
            this.ax = this.aN();
            this.af = this.aI;
            this.d(par1DamageSource, par2);
            this.az = 10;
            this.ay = 10;
        }
        this.aA = 0.0f;
        nn entity = par1DamageSource.i();
        if (entity != null) {
            sf entitywolf;
            if (entity instanceof of) {
                this.b((of)entity);
            }
            if (entity instanceof uf) {
                this.aT = 100;
                this.aS = (uf)entity;
            } else if (entity instanceof sf && (entitywolf = (sf)((Object)entity)).bT()) {
                this.aT = 100;
                this.aS = null;
            }
        }
        if (flag) {
            this.q.a((nn)this, (byte)2);
            if (par1DamageSource != nb.e) {
                this.K();
            }
            if (entity != null) {
                double d0 = entity.u - this.u;
                double d1 = entity.w - this.w;
                while (d0 * d0 + d1 * d1 < 1.0E-4) {
                    d0 = (Math.random() - Math.random()) * 0.01;
                    d1 = (Math.random() - Math.random()) * 0.01;
                }
                this.aA = (float)(Math.atan2(d1, d0) * 180.0 / Math.PI) - this.A;
                this.a(entity, par2, d0, d1);
            } else {
                this.aA = (int)(Math.random() * 2.0) * 180;
            }
        }
        if (this.aN() <= 0.0f) {
            if (flag) {
                this.a(this.aP(), this.ba(), this.bb());
            }
            this.a(par1DamageSource);
        } else if (flag) {
            this.a(this.aO(), this.ba(), this.bb());
        }
        return true;
    }

    public void a(ye par1ItemStack) {
        this.a("random.break", 0.8f, 0.8f + this.q.s.nextFloat() * 0.4f);
        for (int i2 = 0; i2 < 5; ++i2) {
            atc vec3 = this.q.V().a(((double)this.ab.nextFloat() - 0.5) * 0.1, Math.random() * 0.1 + 0.1, 0.0);
            vec3.a(-this.B * (float)Math.PI / 180.0f);
            vec3.b(-this.A * (float)Math.PI / 180.0f);
            atc vec31 = this.q.V().a(((double)this.ab.nextFloat() - 0.5) * 0.3, (double)(-this.ab.nextFloat()) * 0.6 - 0.3, 0.6);
            vec31.a(-this.B * (float)Math.PI / 180.0f);
            vec31.b(-this.A * (float)Math.PI / 180.0f);
            vec31 = vec31.c(this.u, this.v + (double)this.f(), this.w);
            this.q.a("iconcrack_" + par1ItemStack.b().cv, vec31.c, vec31.d, vec31.e, vec3.c, vec3.d + 0.05, vec3.e);
        }
    }

    public void a(nb par1DamageSource) {
        if (ForgeHooks.onLivingDeath((of)this, (nb)par1DamageSource)) {
            return;
        }
        nn entity = par1DamageSource.i();
        of entitylivingbase = this.aS();
        if (this.bb >= 0 && entitylivingbase != null) {
            entitylivingbase.b(this, this.bb);
        }
        if (entity != null) {
            entity.a(this);
        }
        this.aU = true;
        if (!this.q.I) {
            int i2 = 0;
            if (entity instanceof uf) {
                i2 = aaw.g((of)((of)entity));
            }
            this.captureDrops = true;
            this.capturedDrops.clear();
            int j2 = 0;
            if (!this.g_() && this.q.O().b("doMobLoot")) {
                this.b(this.aT > 0, i2);
                this.a(this.aT > 0, i2);
                if (this.aT > 0 && (j2 = this.ab.nextInt(200) - i2) < 5) {
                    this.l(j2 <= 0 ? 1 : 0);
                }
            }
            this.captureDrops = false;
            if (!ForgeHooks.onLivingDrops((of)this, (nb)par1DamageSource, (ArrayList)this.capturedDrops, (int)i2, (this.aT > 0 ? 1 : 0) != 0, (int)j2)) {
                for (ss item : this.capturedDrops) {
                    this.q.d(item);
                }
            }
        }
        this.q.a((nn)this, (byte)3);
    }

    protected void a(boolean par1, int par2) {
    }

    public void a(nn par1Entity, float par2, double par3, double par5) {
        if (this.ab.nextDouble() >= this.a(tp.c).e()) {
            this.an = true;
            float f1 = ls.a(par3 * par3 + par5 * par5);
            float f2 = 0.4f;
            this.x /= 2.0;
            this.y /= 2.0;
            this.z /= 2.0;
            this.x -= par3 / (double)f1 * (double)f2;
            this.y += (double)f2;
            this.z -= par5 / (double)f1 * (double)f2;
            if (this.y > (double)0.4f) {
                this.y = 0.4f;
            }
        }
    }

    protected String aO() {
        return "damage.hit";
    }

    protected String aP() {
        return "damage.hit";
    }

    protected void l(int par1) {
    }

    protected void b(boolean par1, int par2) {
    }

    public boolean e() {
        int i2 = ls.c(this.u);
        int j2 = ls.c(this.E.b);
        int k2 = ls.c(this.w);
        int l2 = this.q.a(i2, j2, k2);
        return ForgeHooks.isLivingOnLadder((aqz)aqz.s[l2], (abw)this.q, (int)i2, (int)j2, (int)k2, (of)this);
    }

    @Override
    public boolean T() {
        return !this.M && this.aN() > 0.0f;
    }

    @Override
    protected void b(float par1) {
        if ((par1 = ForgeHooks.onLivingFall((of)this, (float)par1)) <= 0.0f) {
            return;
        }
        super.b(par1);
        nj potioneffect = this.b(ni.j);
        float f1 = potioneffect != null ? (float)(potioneffect.c() + 1) : 0.0f;
        int i2 = ls.f(par1 - 3.0f - f1);
        if (i2 > 0) {
            if (i2 > 4) {
                this.a("damage.fallbig", 1.0f, 1.0f);
            } else {
                this.a("damage.fallsmall", 1.0f, 1.0f);
            }
            this.a(nb.h, (float)i2);
            int j2 = this.q.a(ls.c(this.u), ls.c(this.v - (double)0.2f - (double)this.N), ls.c(this.w));
            if (j2 > 0) {
                ard stepsound = aqz.s[j2].cS;
                this.a(stepsound.e(), stepsound.c() * 0.5f, stepsound.d() * 0.75f);
            }
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void ad() {
        this.az = 10;
        this.ay = 10;
        this.aA = 0.0f;
    }

    public int aQ() {
        int i2 = 0;
        for (ye itemstack : this.ae()) {
            if (itemstack == null || !(itemstack.b() instanceof wh)) continue;
            int l2 = ((wh)itemstack.b()).c;
            i2 += l2;
        }
        return i2;
    }

    protected void h(float par1) {
    }

    protected float b(nb par1DamageSource, float par2) {
        if (!par1DamageSource.e()) {
            int i2 = 25 - this.aQ();
            float f1 = par2 * (float)i2;
            this.h(par2);
            par2 = f1 / 25.0f;
        }
        return par2;
    }

    protected float c(nb par1DamageSource, float par2) {
        float f1;
        int j2;
        int i2;
        if (this instanceof tw) {
            // empty if block
        }
        if (this.a(ni.m) && par1DamageSource != nb.i) {
            i2 = (this.b(ni.m).c() + 1) * 5;
            j2 = 25 - i2;
            f1 = par2 * (float)j2;
            par2 = f1 / 25.0f;
        }
        if (par2 <= 0.0f) {
            return 0.0f;
        }
        i2 = aaw.a((ye[])this.ae(), (nb)par1DamageSource);
        if (i2 > 20) {
            i2 = 20;
        }
        if (i2 > 0 && i2 <= 20) {
            j2 = 25 - i2;
            f1 = par2 * (float)j2;
            par2 = f1 / 25.0f;
        }
        return par2;
    }

    protected void d(nb par1DamageSource, float par2) {
        if (!this.ar()) {
            if ((par2 = ForgeHooks.onLivingHurt((of)this, (nb)par1DamageSource, (float)par2)) <= 0.0f) {
                return;
            }
            par2 = this.b(par1DamageSource, par2);
            float f1 = par2 = this.c(par1DamageSource, par2);
            par2 = Math.max(par2 - this.bn(), 0.0f);
            this.m(this.bn() - (f1 - par2));
            if (par2 != 0.0f) {
                float f2 = this.aN();
                this.g(f2 - par2);
                this.aR().a(par1DamageSource, f2, par2);
                this.m(this.bn() - par2);
            }
        }
    }

    public na aR() {
        return this.e;
    }

    public of aS() {
        return this.e.c() != null ? this.e.c() : (this.aS != null ? this.aS : (this.i != null ? this.i : null));
    }

    public final float aT() {
        return (float)this.a(tp.a).e();
    }

    public final int aU() {
        return this.ah.a(9);
    }

    public final void m(int par1) {
        this.ah.b(9, (byte)par1);
    }

    private int h() {
        return this.a(ni.e) ? 6 - (1 + this.b(ni.e).c()) * 1 : (this.a(ni.f) ? 6 + (1 + this.b(ni.f).c()) * 2 : 6);
    }

    public void aV() {
        yc item;
        ye stack = this.aZ();
        if (stack != null && stack.b() != null && (item = stack.b()).onEntitySwing(this, stack)) {
            return;
        }
        if (!this.au || this.av >= this.h() / 2 || this.av < 0) {
            this.av = -1;
            this.au = true;
            if (this.q instanceof js) {
                ((js)this.q).q().a(this, (ey)new dj((nn)this, 1));
            }
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(byte par1) {
        if (par1 == 2) {
            this.aG = 1.5f;
            this.af = this.aI;
            this.az = 10;
            this.ay = 10;
            this.aA = 0.0f;
            this.a(this.aO(), this.ba(), (this.ab.nextFloat() - this.ab.nextFloat()) * 0.2f + 1.0f);
            this.a(nb.j, 0.0f);
        } else if (par1 == 3) {
            this.a(this.aP(), this.ba(), (this.ab.nextFloat() - this.ab.nextFloat()) * 0.2f + 1.0f);
            this.g(0.0f);
            this.a(nb.j);
        } else {
            super.a(par1);
        }
    }

    @Override
    protected void C() {
        this.a(nb.i, 4.0f);
    }

    protected void aW() {
        int i2 = this.h();
        if (this.au) {
            ++this.av;
            if (this.av >= i2) {
                this.av = 0;
                this.au = false;
            }
        } else {
            this.av = 0;
        }
        this.aE = (float)this.av / (float)i2;
    }

    public os a(or par1Attribute) {
        return this.aX().a(par1Attribute);
    }

    public ov aX() {
        if (this.d == null) {
            this.d = new pa();
        }
        return this.d;
    }

    public oj aY() {
        return oj.a;
    }

    public abstract ye aZ();

    public abstract ye n(int var1);

    @Override
    public abstract void c(int var1, ye var2);

    @Override
    public void c(boolean par1) {
        super.c(par1);
        os attributeinstance = this.a(tp.d);
        if (attributeinstance.a(b) != null) {
            attributeinstance.b(c);
        }
        if (par1) {
            attributeinstance.a(c);
        }
    }

    @Override
    public abstract ye[] ae();

    protected float ba() {
        return 1.0f;
    }

    protected float bb() {
        return this.g_() ? (this.ab.nextFloat() - this.ab.nextFloat()) * 0.2f + 1.5f : (this.ab.nextFloat() - this.ab.nextFloat()) * 0.2f + 1.0f;
    }

    protected boolean bc() {
        return this.aN() <= 0.0f;
    }

    public void a(double par1, double par3, double par5) {
        this.b(par1, par3, par5, this.A, this.B);
    }

    public void l(nn par1Entity) {
        double d0 = par1Entity.u;
        double d1 = par1Entity.E.b + (double)par1Entity.P;
        double d2 = par1Entity.w;
        for (double d3 = -1.5; d3 < 2.0; d3 += 1.0) {
            for (double d4 = -1.5; d4 < 2.0; d4 += 1.0) {
                if (d3 == 0.0 && d4 == 0.0) continue;
                int i2 = (int)(this.u + d3);
                int j2 = (int)(this.w + d4);
                asx axisalignedbb = this.E.c(d3, 1.0, d4);
                if (!this.q.a(axisalignedbb).isEmpty()) continue;
                if (this.q.w(i2, (int)this.v, j2)) {
                    this.a(this.u + d3, this.v + 1.0, this.w + d4);
                    return;
                }
                if (!this.q.w(i2, (int)this.v - 1, j2) && this.q.g(i2, (int)this.v - 1, j2) != akc.h) continue;
                d0 = this.u + d3;
                d1 = this.v + 1.0;
                d2 = this.w + d4;
            }
        }
        this.a(d0, d1, d2);
    }

    @SideOnly(value=Side.CLIENT)
    public boolean bd() {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public ms b(ye par1ItemStack, int par2) {
        return par1ItemStack.c();
    }

    protected void be() {
        this.y = 0.42f;
        if (this.a(ni.j)) {
            this.y += (double)((float)(this.b(ni.j).c() + 1) * 0.1f);
        }
        if (this.ai()) {
            float f2 = this.A * ((float)Math.PI / 180);
            this.x -= (double)(ls.a(f2) * 0.2f);
            this.z += (double)(ls.b(f2) * 0.2f);
        }
        this.an = true;
        ForgeHooks.onLivingJump((of)this);
    }

    public void e(float par1, float par2) {
        double d0;
        if (!(!this.H() || this instanceof uf && ((uf)this).bG.b)) {
            d0 = this.v;
            this.a(par1, par2, this.bf() ? 0.04f : 0.02f);
            this.d(this.x, this.y, this.z);
            this.x *= (double)0.8f;
            this.y *= (double)0.8f;
            this.z *= (double)0.8f;
            this.y -= 0.02;
            if (this.G && this.c(this.x, this.y + (double)0.6f - this.v + d0, this.z)) {
                this.y = 0.3f;
            }
        } else if (!(!this.J() || this instanceof uf && ((uf)this).bG.b)) {
            d0 = this.v;
            this.a(par1, par2, 0.02f);
            this.d(this.x, this.y, this.z);
            this.x *= 0.5;
            this.y *= 0.5;
            this.z *= 0.5;
            this.y -= 0.02;
            if (this.G && this.c(this.x, this.y + (double)0.6f - this.v + d0, this.z)) {
                this.y = 0.3f;
            }
        } else {
            float f2 = 0.91f;
            if (this.F) {
                f2 = 0.54600006f;
                int i2 = this.q.a(ls.c(this.u), ls.c(this.E.b) - 1, ls.c(this.w));
                if (i2 > 0) {
                    f2 = aqz.s[i2].cV * 0.91f;
                }
            }
            float f3 = 0.16277136f / (f2 * f2 * f2);
            float f4 = this.F ? this.bg() * f3 : this.aR;
            this.a(par1, par2, f4);
            f2 = 0.91f;
            if (this.F) {
                f2 = 0.54600006f;
                int j2 = this.q.a(ls.c(this.u), ls.c(this.E.b) - 1, ls.c(this.w));
                if (j2 > 0) {
                    f2 = aqz.s[j2].cV * 0.91f;
                }
            }
            if (this.e()) {
                boolean flag;
                float f5 = 0.15f;
                if (this.x < (double)(-f5)) {
                    this.x = -f5;
                }
                if (this.x > (double)f5) {
                    this.x = f5;
                }
                if (this.z < (double)(-f5)) {
                    this.z = -f5;
                }
                if (this.z > (double)f5) {
                    this.z = f5;
                }
                this.T = 0.0f;
                if (this.y < -0.15) {
                    this.y = -0.15;
                }
                boolean bl2 = flag = this.ah() && this instanceof uf;
                if (flag && this.y < 0.0) {
                    this.y = 0.0;
                }
            }
            this.d(this.x, this.y, this.z);
            if (this.G && this.e()) {
                this.y = 0.2;
            }
            this.y = !(!this.q.I || this.q.f((int)this.u, 0, (int)this.w) && this.q.d((int)((int)this.u), (int)((int)this.w)).d) ? (this.v > 0.0 ? -0.1 : 0.0) : (this.y -= 0.08);
            this.y *= (double)0.98f;
            this.x *= (double)f2;
            this.z *= (double)f2;
        }
        this.aF = this.aG;
        d0 = this.u - this.r;
        double d1 = this.w - this.t;
        float f6 = ls.a(d0 * d0 + d1 * d1) * 4.0f;
        if (f6 > 1.0f) {
            f6 = 1.0f;
        }
        this.aG += (f6 - this.aG) * 0.4f;
        this.aH += this.aG;
    }

    protected boolean bf() {
        return false;
    }

    public float bg() {
        return this.bf() ? this.bp : 0.1f;
    }

    public void i(float par1) {
        this.bp = par1;
    }

    public boolean m(nn par1Entity) {
        this.k(par1Entity);
        return false;
    }

    public boolean bh() {
        return false;
    }

    @Override
    public void l_() {
        if (ForgeHooks.onLivingUpdate((of)this)) {
            return;
        }
        super.l_();
        if (!this.q.I) {
            int i2 = this.aU();
            if (i2 > 0) {
                if (this.aw <= 0) {
                    this.aw = 20 * (30 - i2);
                }
                --this.aw;
                if (this.aw <= 0) {
                    this.m(i2 - 1);
                }
            }
            for (int j2 = 0; j2 < 5; ++j2) {
                ye itemstack = this.g[j2];
                ye itemstack1 = this.n(j2);
                if (ye.b(itemstack1, itemstack)) continue;
                ((js)this.q).q().a(this, (ey)new fq(this.k, j2, itemstack1));
                if (itemstack != null) {
                    this.d.a(itemstack.D());
                }
                if (itemstack1 != null) {
                    this.d.b(itemstack1.D());
                }
                this.g[j2] = itemstack1 == null ? null : itemstack1.m();
            }
        }
        this.c();
        double d0 = this.u - this.r;
        double d1 = this.w - this.t;
        float f2 = (float)(d0 * d0 + d1 * d1);
        float f1 = this.aN;
        float f22 = 0.0f;
        this.aW = this.aX;
        float f3 = 0.0f;
        if (f2 > 0.0025000002f) {
            f3 = 1.0f;
            f22 = (float)Math.sqrt(f2) * 3.0f;
            f1 = (float)Math.atan2(d1, d0) * 180.0f / (float)Math.PI - 90.0f;
        }
        if (this.aE > 0.0f) {
            f1 = this.A;
        }
        if (!this.F) {
            f3 = 0.0f;
        }
        this.aX += (f3 - this.aX) * 0.3f;
        this.q.C.a("headTurn");
        f22 = this.f(f1, f22);
        this.q.C.b();
        this.q.C.a("rangeChecks");
        while (this.A - this.C < -180.0f) {
            this.C -= 360.0f;
        }
        while (this.A - this.C >= 180.0f) {
            this.C += 360.0f;
        }
        while (this.aN - this.aO < -180.0f) {
            this.aO -= 360.0f;
        }
        while (this.aN - this.aO >= 180.0f) {
            this.aO += 360.0f;
        }
        while (this.B - this.D < -180.0f) {
            this.D -= 360.0f;
        }
        while (this.B - this.D >= 180.0f) {
            this.D += 360.0f;
        }
        while (this.aP - this.aQ < -180.0f) {
            this.aQ -= 360.0f;
        }
        while (this.aP - this.aQ >= 180.0f) {
            this.aQ += 360.0f;
        }
        this.q.C.b();
        this.aY += f22;
    }

    protected float f(float par1, float par2) {
        boolean flag;
        float f2 = ls.g(par1 - this.aN);
        this.aN += f2 * 0.3f;
        float f3 = ls.g(this.A - this.aN);
        boolean bl2 = flag = f3 < -90.0f || f3 >= 90.0f;
        if (f3 < -75.0f) {
            f3 = -75.0f;
        }
        if (f3 >= 75.0f) {
            f3 = 75.0f;
        }
        this.aN = this.A - f3;
        if (f3 * f3 > 2500.0f) {
            this.aN += f3 * 0.2f;
        }
        if (flag) {
            par2 *= -1.0f;
        }
        return par2;
    }

    public void c() {
        if (this.bq > 0) {
            --this.bq;
        }
        if (this.bh > 0) {
            double d0 = this.u + (this.bi - this.u) / (double)this.bh;
            double d1 = this.v + (this.bj - this.v) / (double)this.bh;
            double d2 = this.w + (this.bk - this.w) / (double)this.bh;
            double d3 = ls.g(this.bl - (double)this.A);
            this.A = (float)((double)this.A + d3 / (double)this.bh);
            this.B = (float)((double)this.B + (this.bm - (double)this.B) / (double)this.bh);
            --this.bh;
            this.b(d0, d1, d2);
            this.b(this.A, this.B);
        } else if (!this.bm()) {
            this.x *= 0.98;
            this.y *= 0.98;
            this.z *= 0.98;
        }
        if (Math.abs(this.x) < 0.005) {
            this.x = 0.0;
        }
        if (Math.abs(this.y) < 0.005) {
            this.y = 0.0;
        }
        if (Math.abs(this.z) < 0.005) {
            this.z = 0.0;
        }
        this.q.C.a("ai");
        if (this.bc()) {
            this.bd = false;
            this.be = 0.0f;
            this.bf = 0.0f;
            this.bg = 0.0f;
        } else if (this.bm()) {
            if (this.bf()) {
                this.q.C.a("newAi");
                this.bi();
                this.q.C.b();
            } else {
                this.q.C.a("oldAi");
                this.bl();
                this.q.C.b();
                this.aP = this.A;
            }
        }
        this.q.C.b();
        this.q.C.a("jump");
        if (this.bd) {
            if (!this.H() && !this.J()) {
                if (this.F && this.bq == 0) {
                    this.be();
                    this.bq = 10;
                }
            } else {
                this.y += (double)0.04f;
            }
        } else {
            this.bq = 0;
        }
        this.q.C.b();
        this.q.C.a("travel");
        this.be *= 0.98f;
        this.bf *= 0.98f;
        this.bg *= 0.9f;
        this.e(this.be, this.bf);
        this.q.C.b();
        this.q.C.a("push");
        if (!this.q.I) {
            this.bj();
        }
        this.q.C.b();
    }

    protected void bi() {
    }

    protected void bj() {
        List list = this.q.b((nn)this, this.E.b((double)0.2f, 0.0, (double)0.2f));
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); ++i2) {
                nn entity = (nn)list.get(i2);
                if (!entity.M()) continue;
                this.n(entity);
            }
        }
    }

    protected void n(nn par1Entity) {
        par1Entity.f(this);
    }

    @Override
    public void V() {
        super.V();
        this.aW = this.aX;
        this.aX = 0.0f;
        this.T = 0.0f;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(double par1, double par3, double par5, float par7, float par8, int par9) {
        this.N = 0.0f;
        this.bi = par1;
        this.bj = par3;
        this.bk = par5;
        this.bl = par7;
        this.bm = par8;
        this.bh = par9;
    }

    protected void bk() {
    }

    protected void bl() {
        ++this.aV;
    }

    public void f(boolean par1) {
        this.bd = par1;
    }

    public void a(nn par1Entity, int par2) {
        if (!par1Entity.M && !this.q.I) {
            jm entitytracker = ((js)this.q).q();
            if (par1Entity instanceof ss) {
                entitytracker.a(par1Entity, (ey)new ga(par1Entity.k, this.k));
            }
            if (par1Entity instanceof uh) {
                entitytracker.a(par1Entity, (ey)new ga(par1Entity.k, this.k));
            }
            if (par1Entity instanceof oa) {
                entitytracker.a(par1Entity, (ey)new ga(par1Entity.k, this.k));
            }
        }
    }

    public boolean o(nn par1Entity) {
        return this.q.a(this.q.V().a(this.u, this.v + (double)this.f(), this.w), this.q.V().a(par1Entity.u, par1Entity.v + (double)par1Entity.f(), par1Entity.w)) == null;
    }

    @Override
    public atc aa() {
        return this.j(1.0f);
    }

    public atc j(float par1) {
        if (par1 == 1.0f) {
            float f1 = ls.b(-this.A * ((float)Math.PI / 180) - (float)Math.PI);
            float f2 = ls.a(-this.A * ((float)Math.PI / 180) - (float)Math.PI);
            float f3 = -ls.b(-this.B * ((float)Math.PI / 180));
            float f4 = ls.a(-this.B * ((float)Math.PI / 180));
            return this.q.V().a((double)(f2 * f3), (double)f4, (double)(f1 * f3));
        }
        float f1 = this.D + (this.B - this.D) * par1;
        float f2 = this.C + (this.A - this.C) * par1;
        float f3 = ls.b(-f2 * ((float)Math.PI / 180) - (float)Math.PI);
        float f4 = ls.a(-f2 * ((float)Math.PI / 180) - (float)Math.PI);
        float f5 = -ls.b(-f1 * ((float)Math.PI / 180));
        float f6 = ls.a(-f1 * ((float)Math.PI / 180));
        return this.q.V().a((double)(f4 * f5), (double)f6, (double)(f3 * f5));
    }

    @SideOnly(value=Side.CLIENT)
    public float k(float par1) {
        float f1 = this.aE - this.aD;
        if (f1 < 0.0f) {
            f1 += 1.0f;
        }
        return this.aD + f1 * par1;
    }

    @SideOnly(value=Side.CLIENT)
    public atc l(float par1) {
        if (par1 == 1.0f) {
            return this.q.V().a(this.u, this.v, this.w);
        }
        double d0 = this.r + (this.u - this.r) * (double)par1;
        double d1 = this.s + (this.v - this.s) * (double)par1;
        double d2 = this.t + (this.w - this.t) * (double)par1;
        return this.q.V().a(d0, d1, d2);
    }

    @SideOnly(value=Side.CLIENT)
    public ata a(double par1, float par3) {
        atc vec3 = this.l(par3);
        atc vec31 = this.j(par3);
        atc vec32 = vec3.c(vec31.c * par1, vec31.d * par1, vec31.e * par1);
        return this.q.a(vec3, vec32);
    }

    public boolean bm() {
        return !this.q.I;
    }

    @Override
    public boolean L() {
        return !this.M;
    }

    @Override
    public boolean M() {
        return !this.M;
    }

    @Override
    public float f() {
        return this.P * 0.85f;
    }

    @Override
    protected void K() {
        this.J = this.ab.nextDouble() >= this.a(tp.c).e();
    }

    @Override
    public float ap() {
        return this.aP;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void e(float par1) {
        this.aP = par1;
    }

    public float bn() {
        return this.br;
    }

    public void m(float par1) {
        if (par1 < 0.0f) {
            par1 = 0.0f;
        }
        this.br = par1;
    }

    public atl bo() {
        return null;
    }

    public boolean c(of par1EntityLivingBase) {
        return this.a(par1EntityLivingBase.bo());
    }

    public boolean a(atl par1Team) {
        return this.bo() != null ? this.bo().a(par1Team) : false;
    }

    public void curePotionEffects(ye curativeItem) {
        Iterator potionKey = this.f.keySet().iterator();
        if (this.q.I) {
            return;
        }
        while (potionKey.hasNext()) {
            Integer key = (Integer)potionKey.next();
            nj effect = (nj)this.f.get(key);
            if (!effect.isCurativeItem(curativeItem)) continue;
            potionKey.remove();
            this.b(effect);
        }
    }

    public boolean shouldRiderFaceForward(uf player) {
        return this instanceof ry;
    }
}

