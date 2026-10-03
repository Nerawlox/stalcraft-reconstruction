/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  abr
 *  aqw
 *  asx
 *  atc
 *  nb
 *  oa
 *  sg
 *  sh
 *  si
 *  sj
 *  th
 */
import java.util.List;

public class sk
extends og
implements sg,
sh,
th {
    public double h;
    public double i;
    public double j;
    public double[][] bn = new double[64][3];
    public int bo = -1;
    public si[] bp;
    public si bq = new si((sh)this, "head", 6.0f, 6.0f);
    public si br = new si((sh)this, "body", 8.0f, 8.0f);
    public si bs = new si((sh)this, "tail", 4.0f, 4.0f);
    public si bt = new si((sh)this, "tail", 4.0f, 4.0f);
    public si bu = new si((sh)this, "tail", 4.0f, 4.0f);
    public si bv = new si((sh)this, "wing", 4.0f, 4.0f);
    public si bw = new si((sh)this, "wing", 4.0f, 4.0f);
    public float bx;
    public float by;
    public boolean bz;
    public boolean bA;
    private nn bD;
    public int bB;
    public sj bC;

    public sk(abw par1World) {
        super(par1World);
        this.bp = new si[]{this.bq, this.br, this.bs, this.bt, this.bu, this.bv, this.bw};
        this.g(this.aT());
        this.a(16.0f, 8.0f);
        this.Z = true;
        this.ag = true;
        this.i = 100.0;
        this.am = true;
    }

    @Override
    protected void az() {
        super.az();
        this.a(tp.a).a(200.0);
    }

    @Override
    protected void a() {
        super.a();
    }

    public double[] b(int par1, float par2) {
        if (this.aN() <= 0.0f) {
            par2 = 0.0f;
        }
        par2 = 1.0f - par2;
        int j2 = this.bo - par1 * 1 & 0x3F;
        int k2 = this.bo - par1 * 1 - 1 & 0x3F;
        double[] adouble = new double[3];
        double d0 = this.bn[j2][0];
        double d1 = ls.g(this.bn[k2][0] - d0);
        adouble[0] = d0 + d1 * (double)par2;
        d0 = this.bn[j2][1];
        d1 = this.bn[k2][1] - d0;
        adouble[1] = d0 + d1 * (double)par2;
        adouble[2] = this.bn[j2][2] + (this.bn[k2][2] - this.bn[j2][2]) * (double)par2;
        return adouble;
    }

    @Override
    public void c() {
        float f1;
        float f2;
        if (this.q.I) {
            f2 = ls.b(this.by * (float)Math.PI * 2.0f);
            f1 = ls.b(this.bx * (float)Math.PI * 2.0f);
            if (f1 <= -0.3f && f2 >= -0.3f) {
                this.q.a(this.u, this.v, this.w, "mob.enderdragon.wings", 5.0f, 0.8f + this.ab.nextFloat() * 0.3f, false);
            }
        }
        this.bx = this.by;
        if (this.aN() <= 0.0f) {
            f2 = (this.ab.nextFloat() - 0.5f) * 8.0f;
            f1 = (this.ab.nextFloat() - 0.5f) * 4.0f;
            float f22 = (this.ab.nextFloat() - 0.5f) * 8.0f;
            this.q.a("largeexplode", this.u + (double)f2, this.v + 2.0 + (double)f1, this.w + (double)f22, 0.0, 0.0, 0.0);
        } else {
            float f3;
            double d2;
            double d1;
            double d3;
            this.bJ();
            f2 = 0.2f / (ls.a(this.x * this.x + this.z * this.z) * 10.0f + 1.0f);
            this.by = this.bA ? (this.by += f2 * 0.5f) : (this.by += (f2 *= (float)Math.pow(2.0, this.y)));
            this.A = ls.g(this.A);
            if (this.bo < 0) {
                for (int i2 = 0; i2 < this.bn.length; ++i2) {
                    this.bn[i2][0] = this.A;
                    this.bn[i2][1] = this.v;
                }
            }
            if (++this.bo == this.bn.length) {
                this.bo = 0;
            }
            this.bn[this.bo][0] = this.A;
            this.bn[this.bo][1] = this.v;
            if (this.q.I) {
                if (this.bh > 0) {
                    d3 = this.u + (this.bi - this.u) / (double)this.bh;
                    double d0 = this.v + (this.bj - this.v) / (double)this.bh;
                    d1 = this.w + (this.bk - this.w) / (double)this.bh;
                    d2 = ls.g(this.bl - (double)this.A);
                    this.A = (float)((double)this.A + d2 / (double)this.bh);
                    this.B = (float)((double)this.B + (this.bm - (double)this.B) / (double)this.bh);
                    --this.bh;
                    this.b(d3, d0, d1);
                    this.b(this.A, this.B);
                }
            } else {
                d3 = this.h - this.u;
                double d0 = this.i - this.v;
                d1 = this.j - this.w;
                d2 = d3 * d3 + d0 * d0 + d1 * d1;
                if (this.bD != null) {
                    this.h = this.bD.u;
                    this.j = this.bD.w;
                    double d4 = this.h - this.u;
                    double d5 = this.j - this.w;
                    double d6 = Math.sqrt(d4 * d4 + d5 * d5);
                    double d7 = (double)0.4f + d6 / 80.0 - 1.0;
                    if (d7 > 10.0) {
                        d7 = 10.0;
                    }
                    this.i = this.bD.E.b + d7;
                } else {
                    this.h += this.ab.nextGaussian() * 2.0;
                    this.j += this.ab.nextGaussian() * 2.0;
                }
                if (this.bz || d2 < 100.0 || d2 > 22500.0 || this.G || this.H) {
                    this.bK();
                }
                if ((d0 /= (double)ls.a(d3 * d3 + d1 * d1)) < (double)(-(f3 = 0.6f))) {
                    d0 = -f3;
                }
                if (d0 > (double)f3) {
                    d0 = f3;
                }
                this.y += d0 * (double)0.1f;
                this.A = ls.g(this.A);
                double d8 = 180.0 - Math.atan2(d3, d1) * 180.0 / Math.PI;
                double d9 = ls.g(d8 - (double)this.A);
                if (d9 > 50.0) {
                    d9 = 50.0;
                }
                if (d9 < -50.0) {
                    d9 = -50.0;
                }
                atc vec3 = this.q.V().a(this.h - this.u, this.i - this.v, this.j - this.w).a();
                atc vec31 = this.q.V().a((double)ls.a(this.A * (float)Math.PI / 180.0f), this.y, (double)(-ls.b(this.A * (float)Math.PI / 180.0f))).a();
                float f4 = (float)(vec31.b(vec3) + 0.5) / 1.5f;
                if (f4 < 0.0f) {
                    f4 = 0.0f;
                }
                this.bg *= 0.8f;
                float f5 = ls.a(this.x * this.x + this.z * this.z) * 1.0f + 1.0f;
                double d10 = Math.sqrt(this.x * this.x + this.z * this.z) * 1.0 + 1.0;
                if (d10 > 40.0) {
                    d10 = 40.0;
                }
                this.bg = (float)((double)this.bg + d9 * ((double)0.7f / d10 / (double)f5));
                this.A += this.bg * 0.1f;
                float f6 = (float)(2.0 / (d10 + 1.0));
                float f7 = 0.06f;
                this.a(0.0f, -1.0f, f7 * (f4 * f6 + (1.0f - f6)));
                if (this.bA) {
                    this.d(this.x * (double)0.8f, this.y * (double)0.8f, this.z * (double)0.8f);
                } else {
                    this.d(this.x, this.y, this.z);
                }
                atc vec32 = this.q.V().a(this.x, this.y, this.z).a();
                float f8 = (float)(vec32.b(vec31) + 1.0) / 2.0f;
                f8 = 0.8f + 0.15f * f8;
                this.x *= (double)f8;
                this.z *= (double)f8;
                this.y *= (double)0.91f;
            }
            this.aN = this.A;
            this.bq.P = 3.0f;
            this.bq.O = 3.0f;
            this.bs.P = 2.0f;
            this.bs.O = 2.0f;
            this.bt.P = 2.0f;
            this.bt.O = 2.0f;
            this.bu.P = 2.0f;
            this.bu.O = 2.0f;
            this.br.P = 3.0f;
            this.br.O = 5.0f;
            this.bv.P = 2.0f;
            this.bv.O = 4.0f;
            this.bw.P = 3.0f;
            this.bw.O = 4.0f;
            f1 = (float)(this.b(5, 1.0f)[1] - this.b(10, 1.0f)[1]) * 10.0f / 180.0f * (float)Math.PI;
            float f23 = ls.b(f1);
            float f9 = -ls.a(f1);
            float f10 = this.A * (float)Math.PI / 180.0f;
            float f11 = ls.a(f10);
            float f12 = ls.b(f10);
            this.br.l_();
            this.br.b(this.u + (double)(f11 * 0.5f), this.v, this.w - (double)(f12 * 0.5f), 0.0f, 0.0f);
            this.bv.l_();
            this.bv.b(this.u + (double)(f12 * 4.5f), this.v + 2.0, this.w + (double)(f11 * 4.5f), 0.0f, 0.0f);
            this.bw.l_();
            this.bw.b(this.u - (double)(f12 * 4.5f), this.v + 2.0, this.w - (double)(f11 * 4.5f), 0.0f, 0.0f);
            if (!this.q.I && this.ay == 0) {
                this.a(this.q.b((nn)this, this.bv.E.b(4.0, 2.0, 4.0).d(0.0, -2.0, 0.0)));
                this.a(this.q.b((nn)this, this.bw.E.b(4.0, 2.0, 4.0).d(0.0, -2.0, 0.0)));
                this.b(this.q.b((nn)this, this.bq.E.b(1.0, 1.0, 1.0)));
            }
            double[] adouble = this.b(5, 1.0f);
            double[] adouble1 = this.b(0, 1.0f);
            f3 = ls.a(this.A * (float)Math.PI / 180.0f - this.bg * 0.01f);
            float f13 = ls.b(this.A * (float)Math.PI / 180.0f - this.bg * 0.01f);
            this.bq.l_();
            this.bq.b(this.u + (double)(f3 * 5.5f * f23), this.v + (adouble1[1] - adouble[1]) * 1.0 + (double)(f9 * 5.5f), this.w - (double)(f13 * 5.5f * f23), 0.0f, 0.0f);
            for (int j2 = 0; j2 < 3; ++j2) {
                si entitydragonpart = null;
                if (j2 == 0) {
                    entitydragonpart = this.bs;
                }
                if (j2 == 1) {
                    entitydragonpart = this.bt;
                }
                if (j2 == 2) {
                    entitydragonpart = this.bu;
                }
                double[] adouble2 = this.b(12 + j2 * 2, 1.0f);
                float f14 = this.A * (float)Math.PI / 180.0f + this.b(adouble2[0] - adouble[0]) * (float)Math.PI / 180.0f * 1.0f;
                float f15 = ls.a(f14);
                float f16 = ls.b(f14);
                float f17 = 1.5f;
                float f18 = (float)(j2 + 1) * 2.0f;
                entitydragonpart.l_();
                entitydragonpart.b(this.u - (double)((f11 * f17 + f15 * f18) * f23), this.v + (adouble2[1] - adouble[1]) * 1.0 - (double)((f18 + f17) * f9) + 1.5, this.w + (double)((f12 * f17 + f16 * f18) * f23), 0.0f, 0.0f);
            }
            if (!this.q.I) {
                this.bA = this.a(this.bq.E) | this.a(this.br.E);
            }
        }
    }

    private void bJ() {
        if (this.bC != null) {
            if (this.bC.M) {
                if (!this.q.I) {
                    this.a(this.bq, nb.a((abr)null), 10.0f);
                }
                this.bC = null;
            } else if (this.ac % 10 == 0 && this.aN() < this.aT()) {
                this.g(this.aN() + 1.0f);
            }
        }
        if (this.ab.nextInt(10) == 0) {
            float f2 = 32.0f;
            List list = this.q.a(sj.class, this.E.b((double)f2, (double)f2, (double)f2));
            sj entityendercrystal = null;
            double d0 = Double.MAX_VALUE;
            for (sj entityendercrystal1 : list) {
                double d1 = entityendercrystal1.e((nn)this);
                if (!(d1 < d0)) continue;
                d0 = d1;
                entityendercrystal = entityendercrystal1;
            }
            this.bC = entityendercrystal;
        }
    }

    private void a(List par1List) {
        double d0 = (this.br.E.a + this.br.E.d) / 2.0;
        double d1 = (this.br.E.c + this.br.E.f) / 2.0;
        for (nn entity : par1List) {
            if (!(entity instanceof of)) continue;
            double d2 = entity.u - d0;
            double d3 = entity.w - d1;
            double d4 = d2 * d2 + d3 * d3;
            entity.g(d2 / d4 * 4.0, 0.2f, d3 / d4 * 4.0);
        }
    }

    private void b(List par1List) {
        for (int i2 = 0; i2 < par1List.size(); ++i2) {
            nn entity = (nn)par1List.get(i2);
            if (!(entity instanceof of)) continue;
            entity.a(nb.a((of)this), 10.0f);
        }
    }

    private void bK() {
        this.bz = false;
        if (this.ab.nextInt(2) == 0 && !this.q.h.isEmpty()) {
            this.bD = (nn)this.q.h.get(this.ab.nextInt(this.q.h.size()));
        } else {
            double d2;
            double d1;
            double d0;
            boolean flag = false;
            do {
                this.h = 0.0;
                this.i = 70.0f + this.ab.nextFloat() * 50.0f;
                this.j = 0.0;
                this.h += (double)(this.ab.nextFloat() * 120.0f - 60.0f);
                this.j += (double)(this.ab.nextFloat() * 120.0f - 60.0f);
            } while (!(flag = (d0 = this.u - this.h) * d0 + (d1 = this.v - this.i) * d1 + (d2 = this.w - this.j) * d2 > 100.0));
            this.bD = null;
        }
    }

    private float b(double par1) {
        return (float)ls.g(par1);
    }

    private boolean a(asx par1AxisAlignedBB) {
        int i2 = ls.c(par1AxisAlignedBB.a);
        int j2 = ls.c(par1AxisAlignedBB.b);
        int k2 = ls.c(par1AxisAlignedBB.c);
        int l2 = ls.c(par1AxisAlignedBB.d);
        int i1 = ls.c(par1AxisAlignedBB.e);
        int j1 = ls.c(par1AxisAlignedBB.f);
        boolean flag = false;
        boolean flag1 = false;
        for (int k1 = i2; k1 <= l2; ++k1) {
            for (int l1 = j2; l1 <= i1; ++l1) {
                for (int i22 = k2; i22 <= j1; ++i22) {
                    int j22 = this.q.a(k1, l1, i22);
                    aqz block = aqz.s[j22];
                    if (block == null) continue;
                    if (block.canEntityDestroy(this.q, k1, l1, i22, this) && this.q.O().b("mobGriefing")) {
                        flag1 = this.q.i(k1, l1, i22) || flag1;
                        continue;
                    }
                    flag = true;
                }
            }
        }
        if (flag1) {
            double d0 = par1AxisAlignedBB.a + (par1AxisAlignedBB.d - par1AxisAlignedBB.a) * (double)this.ab.nextFloat();
            double d1 = par1AxisAlignedBB.b + (par1AxisAlignedBB.e - par1AxisAlignedBB.b) * (double)this.ab.nextFloat();
            double d2 = par1AxisAlignedBB.c + (par1AxisAlignedBB.f - par1AxisAlignedBB.c) * (double)this.ab.nextFloat();
            this.q.a("largeexplode", d0, d1, d2, 0.0, 0.0, 0.0);
        }
        return flag;
    }

    public boolean a(si par1EntityDragonPart, nb par2DamageSource, float par3) {
        if (par1EntityDragonPart != this.bq) {
            par3 = par3 / 4.0f + 1.0f;
        }
        float f1 = this.A * (float)Math.PI / 180.0f;
        float f2 = ls.a(f1);
        float f3 = ls.b(f1);
        this.h = this.u + (double)(f2 * 5.0f) + (double)((this.ab.nextFloat() - 0.5f) * 2.0f);
        this.i = this.v + (double)(this.ab.nextFloat() * 3.0f) + 1.0;
        this.j = this.w - (double)(f3 * 5.0f) + (double)((this.ab.nextFloat() - 0.5f) * 2.0f);
        this.bD = null;
        if (par2DamageSource.i() instanceof uf || par2DamageSource.c()) {
            this.e(par2DamageSource, par3);
        }
        return true;
    }

    @Override
    public boolean a(nb par1DamageSource, float par2) {
        return false;
    }

    protected boolean e(nb par1DamageSource, float par2) {
        return super.a(par1DamageSource, par2);
    }

    @Override
    protected void aB() {
        ++this.bB;
        if (this.bB >= 180 && this.bB <= 200) {
            float f2 = (this.ab.nextFloat() - 0.5f) * 8.0f;
            float f1 = (this.ab.nextFloat() - 0.5f) * 4.0f;
            float f22 = (this.ab.nextFloat() - 0.5f) * 8.0f;
            this.q.a("hugeexplosion", this.u + (double)f2, this.v + 2.0 + (double)f1, this.w + (double)f22, 0.0, 0.0, 0.0);
        }
        if (!this.q.I) {
            if (this.bB > 150 && this.bB % 5 == 0) {
                int j2;
                for (int i2 = 1000; i2 > 0; i2 -= j2) {
                    j2 = oa.a((int)i2);
                    this.q.d((nn)new oa(this.q, this.u, this.v, this.w, j2));
                }
            }
            if (this.bB == 1) {
                this.q.d(1018, (int)this.u, (int)this.v, (int)this.w, 0);
            }
        }
        this.d(0.0, 0.1f, 0.0);
        this.aN = this.A += 20.0f;
        if (this.bB == 200 && !this.q.I) {
            int j3;
            for (int i3 = 2000; i3 > 0; i3 -= j3) {
                j3 = oa.a((int)i3);
                this.q.d((nn)new oa(this.q, this.u, this.v, this.w, j3));
            }
            this.c(ls.c(this.u), ls.c(this.w));
            this.x();
        }
    }

    private void c(int par1, int par2) {
        int b0 = 64;
        aqw.a = true;
        int b1 = 4;
        for (int k2 = b0 - 1; k2 <= b0 + 32; ++k2) {
            for (int l2 = par1 - b1; l2 <= par1 + b1; ++l2) {
                for (int i1 = par2 - b1; i1 <= par2 + b1; ++i1) {
                    double d0 = l2 - par1;
                    double d1 = i1 - par2;
                    double d2 = d0 * d0 + d1 * d1;
                    if (!(d2 <= ((double)b1 - 0.5) * ((double)b1 - 0.5))) continue;
                    if (k2 < b0) {
                        if (!(d2 <= ((double)(b1 - 1) - 0.5) * ((double)(b1 - 1) - 0.5))) continue;
                        this.q.c(l2, k2, i1, aqz.E.cF);
                        continue;
                    }
                    if (k2 > b0) {
                        this.q.c(l2, k2, i1, 0);
                        continue;
                    }
                    if (d2 > ((double)(b1 - 1) - 0.5) * ((double)(b1 - 1) - 0.5)) {
                        this.q.c(l2, k2, i1, aqz.E.cF);
                        continue;
                    }
                    this.q.c(l2, k2, i1, aqz.bM.cF);
                }
            }
        }
        this.q.c(par1, b0 + 0, par2, aqz.E.cF);
        this.q.c(par1, b0 + 1, par2, aqz.E.cF);
        this.q.c(par1, b0 + 2, par2, aqz.E.cF);
        this.q.c(par1 - 1, b0 + 2, par2, aqz.av.cF);
        this.q.c(par1 + 1, b0 + 2, par2, aqz.av.cF);
        this.q.c(par1, b0 + 2, par2 - 1, aqz.av.cF);
        this.q.c(par1, b0 + 2, par2 + 1, aqz.av.cF);
        this.q.c(par1, b0 + 3, par2, aqz.E.cF);
        this.q.c(par1, b0 + 4, par2, aqz.bP.cF);
        aqw.a = false;
    }

    @Override
    protected void u() {
    }

    @Override
    public nn[] ao() {
        return this.bp;
    }

    @Override
    public boolean L() {
        return false;
    }

    public abw b() {
        return this.q;
    }

    @Override
    protected String r() {
        return "mob.enderdragon.growl";
    }

    @Override
    protected String aO() {
        return "mob.enderdragon.hit";
    }

    @Override
    protected float ba() {
        return 5.0f;
    }
}

