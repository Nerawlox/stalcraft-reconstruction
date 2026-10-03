/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  nb
 *  nw
 *  pp
 *  ps
 *  qm
 *  qn
 *  qx
 *  qy
 *  sg
 *  sn
 *  to
 *  uv
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

public class sm
extends tm
implements sg,
to {
    private float[] bp = new float[2];
    private float[] bq = new float[2];
    private float[] br = new float[2];
    private float[] bs = new float[2];
    private int[] bt = new int[2];
    private int[] bu = new int[2];
    private int bv;
    private static final nw bw = new sn();

    public sm(abw par1World) {
        super(par1World);
        this.g(this.aT());
        this.a(0.9f, 4.0f);
        this.ag = true;
        this.k().e(true);
        this.c.a(0, (ps)new pp((og)this));
        this.c.a(2, (ps)new qn((to)this, 1.0, 40, 20.0f));
        this.c.a(5, (ps)new qm((on)this, 1.0));
        this.c.a(6, (ps)new px(this, uf.class, 8.0f));
        this.c.a(7, (ps)new ql(this));
        this.d.a(1, (ps)new qx((on)this, false));
        this.d.a(2, (ps)new qy((on)this, og.class, 0, false, false, bw));
        this.b = 50;
    }

    @Override
    protected void a() {
        super.a();
        this.ah.a(17, new Integer(0));
        this.ah.a(18, new Integer(0));
        this.ah.a(19, new Integer(0));
        this.ah.a(20, new Integer(0));
    }

    @Override
    public void b(by par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("Invul", this.bU());
    }

    @Override
    public void a(by par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        this.p(par1NBTTagCompound.e("Invul"));
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public float S() {
        return this.P / 8.0f;
    }

    @Override
    protected String r() {
        return "mob.wither.idle";
    }

    @Override
    protected String aO() {
        return "mob.wither.hurt";
    }

    @Override
    protected String aP() {
        return "mob.wither.death";
    }

    @Override
    public void c() {
        int j2;
        int i2;
        double d2;
        double d0;
        double d1;
        nn entity;
        this.y *= (double)0.6f;
        if (!this.q.I && this.q(0) > 0 && (entity = this.q.a(this.q(0))) != null) {
            double d3;
            if (this.v < entity.v || !this.bV() && this.v < entity.v + 5.0) {
                if (this.y < 0.0) {
                    this.y = 0.0;
                }
                this.y += (0.5 - this.y) * (double)0.6f;
            }
            if ((d1 = (d3 = entity.u - this.u) * d3 + (d0 = entity.w - this.w) * d0) > 9.0) {
                d2 = ls.a(d1);
                this.x += (d3 / d2 * 0.5 - this.x) * (double)0.6f;
                this.z += (d0 / d2 * 0.5 - this.z) * (double)0.6f;
            }
        }
        if (this.x * this.x + this.z * this.z > (double)0.05f) {
            this.A = (float)Math.atan2(this.z, this.x) * 57.295776f - 90.0f;
        }
        super.c();
        for (i2 = 0; i2 < 2; ++i2) {
            this.bs[i2] = this.bq[i2];
            this.br[i2] = this.bp[i2];
        }
        for (i2 = 0; i2 < 2; ++i2) {
            int j3 = this.q(i2 + 1);
            nn entity1 = null;
            if (j3 > 0) {
                entity1 = this.q.a(j3);
            }
            if (entity1 != null) {
                d0 = this.r(i2 + 1);
                d1 = this.s(i2 + 1);
                d2 = this.t(i2 + 1);
                double d4 = entity1.u - d0;
                double d5 = entity1.v + (double)entity1.f() - d1;
                double d6 = entity1.w - d2;
                double d7 = ls.a(d4 * d4 + d6 * d6);
                float f2 = (float)(Math.atan2(d6, d4) * 180.0 / Math.PI) - 90.0f;
                float f1 = (float)(-(Math.atan2(d5, d7) * 180.0 / Math.PI));
                this.bp[i2] = this.b(this.bp[i2], f1, 40.0f);
                this.bq[i2] = this.b(this.bq[i2], f2, 10.0f);
                continue;
            }
            this.bq[i2] = this.b(this.bq[i2], this.aN, 10.0f);
        }
        boolean flag = this.bV();
        for (j2 = 0; j2 < 3; ++j2) {
            double d8 = this.r(j2);
            double d9 = this.s(j2);
            double d10 = this.t(j2);
            this.q.a("smoke", d8 + this.ab.nextGaussian() * (double)0.3f, d9 + this.ab.nextGaussian() * (double)0.3f, d10 + this.ab.nextGaussian() * (double)0.3f, 0.0, 0.0, 0.0);
            if (!flag || this.q.s.nextInt(4) != 0) continue;
            this.q.a("mobSpell", d8 + this.ab.nextGaussian() * (double)0.3f, d9 + this.ab.nextGaussian() * (double)0.3f, d10 + this.ab.nextGaussian() * (double)0.3f, (double)0.7f, (double)0.7f, 0.5);
        }
        if (this.bU() > 0) {
            for (j2 = 0; j2 < 3; ++j2) {
                this.q.a("mobSpell", this.u + this.ab.nextGaussian() * 1.0, this.v + (double)(this.ab.nextFloat() * 3.3f), this.w + this.ab.nextGaussian() * 1.0, (double)0.7f, (double)0.7f, 0.9f);
            }
        }
    }

    @Override
    protected void bi() {
        if (this.bU() > 0) {
            int i2 = this.bU() - 1;
            if (i2 <= 0) {
                this.q.a((nn)this, this.u, this.v + (double)this.f(), this.w, 7.0f, false, this.q.O().b("mobGriefing"));
                this.q.d(1013, (int)this.u, (int)this.v, (int)this.w, 0);
            }
            this.p(i2);
            if (this.ac % 10 == 0) {
                this.f(10.0f);
            }
        } else {
            int j2;
            int i3;
            super.bi();
            block0: for (i3 = 1; i3 < 3; ++i3) {
                if (this.ac < this.bt[i3 - 1]) continue;
                this.bt[i3 - 1] = this.ac + 10 + this.ab.nextInt(10);
                if (this.q.r >= 2) {
                    int k2 = i3 - 1;
                    int l2 = this.bu[i3 - 1];
                    this.bu[k2] = this.bu[i3 - 1] + 1;
                    if (l2 > 15) {
                        float f2 = 10.0f;
                        float f1 = 5.0f;
                        double d0 = ls.a(this.ab, this.u - (double)f2, this.u + (double)f2);
                        double d1 = ls.a(this.ab, this.v - (double)f1, this.v + (double)f1);
                        double d2 = ls.a(this.ab, this.w - (double)f2, this.w + (double)f2);
                        this.a(i3 + 1, d0, d1, d2, true);
                        this.bu[i3 - 1] = 0;
                    }
                }
                if ((j2 = this.q(i3)) > 0) {
                    nn entity = this.q.a(j2);
                    if (entity != null && entity.T() && this.e(entity) <= 900.0 && this.o(entity)) {
                        this.a(i3 + 1, (of)entity);
                        this.bt[i3 - 1] = this.ac + 40 + this.ab.nextInt(20);
                        this.bu[i3 - 1] = 0;
                        continue;
                    }
                    this.c(i3, 0);
                    continue;
                }
                List list = this.q.a(of.class, this.E.b(20.0, 8.0, 20.0), bw);
                for (int i1 = 0; i1 < 10 && !list.isEmpty(); ++i1) {
                    of entitylivingbase = (of)list.get(this.ab.nextInt(list.size()));
                    if (entitylivingbase != this && entitylivingbase.T() && this.o(entitylivingbase)) {
                        if (entitylivingbase instanceof uf) {
                            if (((uf)entitylivingbase).bG.a) continue block0;
                            this.c(i3, entitylivingbase.k);
                            continue block0;
                        }
                        this.c(i3, entitylivingbase.k);
                        continue block0;
                    }
                    list.remove(entitylivingbase);
                }
            }
            if (this.m() != null) {
                this.c(0, this.m().k);
            } else {
                this.c(0, 0);
            }
            if (this.bv > 0) {
                --this.bv;
                if (this.bv == 0 && this.q.O().b("mobGriefing")) {
                    i3 = ls.c(this.v);
                    j2 = ls.c(this.u);
                    int j1 = ls.c(this.w);
                    boolean flag = false;
                    for (int k1 = -1; k1 <= 1; ++k1) {
                        for (int l1 = -1; l1 <= 1; ++l1) {
                            for (int i2 = 0; i2 <= 3; ++i2) {
                                int j22 = j2 + k1;
                                int k2 = i3 + i2;
                                int l2 = j1 + l1;
                                int i32 = this.q.a(j22, k2, l2);
                                aqz block = aqz.s[i32];
                                if (block == null || !block.canEntityDestroy(this.q, j22, k2, l2, this)) continue;
                                flag = this.q.a(j22, k2, l2, true) || flag;
                            }
                        }
                    }
                    if (flag) {
                        this.q.a(null, 1012, (int)this.u, (int)this.v, (int)this.w, 0);
                    }
                }
            }
            if (this.ac % 20 == 0) {
                this.f(1.0f);
            }
        }
    }

    public void bT() {
        this.p(220);
        this.g(this.aT() / 3.0f);
    }

    @Override
    public void am() {
    }

    @Override
    public int aQ() {
        return 4;
    }

    private double r(int par1) {
        if (par1 <= 0) {
            return this.u;
        }
        float f2 = (this.aN + (float)(180 * (par1 - 1))) / 180.0f * (float)Math.PI;
        float f1 = ls.b(f2);
        return this.u + (double)f1 * 1.3;
    }

    private double s(int par1) {
        return par1 <= 0 ? this.v + 3.0 : this.v + 2.2;
    }

    private double t(int par1) {
        if (par1 <= 0) {
            return this.w;
        }
        float f2 = (this.aN + (float)(180 * (par1 - 1))) / 180.0f * (float)Math.PI;
        float f1 = ls.a(f2);
        return this.w + (double)f1 * 1.3;
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

    private void a(int par1, of par2EntityLivingBase) {
        this.a(par1, par2EntityLivingBase.u, par2EntityLivingBase.v + (double)par2EntityLivingBase.f() * 0.5, par2EntityLivingBase.w, par1 == 0 && this.ab.nextFloat() < 0.001f);
    }

    private void a(int par1, double par2, double par4, double par6, boolean par8) {
        this.q.a(null, 1014, (int)this.u, (int)this.v, (int)this.w, 0);
        double d3 = this.r(par1);
        double d4 = this.s(par1);
        double d5 = this.t(par1);
        double d6 = par2 - d3;
        double d7 = par4 - d4;
        double d8 = par6 - d5;
        uv entitywitherskull = new uv(this.q, (of)this, d6, d7, d8);
        if (par8) {
            entitywitherskull.a(true);
        }
        entitywitherskull.v = d4;
        entitywitherskull.u = d3;
        entitywitherskull.w = d5;
        this.q.d((nn)entitywitherskull);
    }

    public void a(of par1EntityLivingBase, float par2) {
        this.a(0, par1EntityLivingBase);
    }

    @Override
    public boolean a(nb par1DamageSource, float par2) {
        nn entity;
        if (this.ar()) {
            return false;
        }
        if (par1DamageSource == nb.e) {
            return false;
        }
        if (this.bU() > 0) {
            return false;
        }
        if (this.bV() && (entity = par1DamageSource.h()) instanceof uh) {
            return false;
        }
        entity = par1DamageSource.i();
        if (entity != null && !(entity instanceof uf) && entity instanceof of && ((of)entity).aY() == this.aY()) {
            return false;
        }
        if (this.bv <= 0) {
            this.bv = 20;
        }
        int i2 = 0;
        while (i2 < this.bu.length) {
            int n2 = i2++;
            this.bu[n2] = this.bu[n2] + 3;
        }
        return super.a(par1DamageSource, par2);
    }

    @Override
    protected void b(boolean par1, int par2) {
        this.b(yc.bU.cv, 1);
    }

    @Override
    protected void u() {
        this.aV = 0;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int c(float par1) {
        return 0xF000F0;
    }

    @Override
    public boolean L() {
        return !this.M;
    }

    @Override
    protected void b(float par1) {
    }

    @Override
    public void c(nj par1PotionEffect) {
    }

    @Override
    protected boolean bf() {
        return true;
    }

    @Override
    protected void az() {
        super.az();
        this.a(tp.a).a(300.0);
        this.a(tp.d).a((double)0.6f);
        this.a(tp.b).a(40.0);
    }

    @SideOnly(value=Side.CLIENT)
    public float a(int par1) {
        return this.bq[par1];
    }

    @SideOnly(value=Side.CLIENT)
    public float c(int par1) {
        return this.bp[par1];
    }

    public int bU() {
        return this.ah.c(20);
    }

    public void p(int par1) {
        this.ah.b(20, par1);
    }

    public int q(int par1) {
        return this.ah.c(17 + par1);
    }

    public void c(int par1, int par2) {
        this.ah.b(17 + par1, par2);
    }

    public boolean bV() {
        return this.aN() <= this.aT() / 2.0f;
    }

    @Override
    public oj aY() {
        return oj.b;
    }

    @Override
    public void a(nn par1Entity) {
        this.o = null;
    }
}

