/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  akc
 *  asx
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  nb
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

public class sq
extends nn {
    private boolean a = true;
    private double b = 0.07;
    private int c;
    private double d;
    private double e;
    private double f;
    private double g;
    private double h;
    @SideOnly(value=Side.CLIENT)
    private double i;
    @SideOnly(value=Side.CLIENT)
    private double j;
    @SideOnly(value=Side.CLIENT)
    private double au;

    public sq(abw par1World) {
        super(par1World);
        this.m = true;
        this.a(1.5f, 0.6f);
        this.N = this.P / 2.0f;
    }

    @Override
    protected boolean e_() {
        return false;
    }

    @Override
    protected void a() {
        this.ah.a(17, new Integer(0));
        this.ah.a(18, new Integer(1));
        this.ah.a(19, new Float(0.0f));
    }

    @Override
    public asx g(nn par1Entity) {
        return par1Entity.E;
    }

    @Override
    public asx E() {
        return this.E;
    }

    @Override
    public boolean M() {
        return true;
    }

    public sq(abw par1World, double par2, double par4, double par6) {
        this(par1World);
        this.b(par2, par4 + (double)this.N, par6);
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
        this.r = par2;
        this.s = par4;
        this.t = par6;
    }

    @Override
    public double Y() {
        return (double)this.P * 0.0 - (double)0.3f;
    }

    @Override
    public boolean a(nb par1DamageSource, float par2) {
        if (this.ar()) {
            return false;
        }
        if (!this.q.I && !this.M) {
            boolean flag;
            this.c(-this.h());
            this.a(10);
            this.a(this.d() + par2 * 10.0f);
            this.K();
            boolean bl2 = flag = par1DamageSource.i() instanceof uf && ((uf)par1DamageSource.i()).bG.d;
            if (flag || this.d() > 40.0f) {
                if (this.n != null) {
                    this.n.a(this);
                }
                if (!flag) {
                    this.a(yc.aG.cv, 1, 0.0f);
                }
                this.x();
            }
            return true;
        }
        return true;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void ad() {
        this.c(-this.h());
        this.a(10);
        this.a(this.d() * 11.0f);
    }

    @Override
    public boolean L() {
        return !this.M;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(double par1, double par3, double par5, float par7, float par8, int par9) {
        if (this.a) {
            this.c = par9 + 5;
        } else {
            double d3 = par1 - this.u;
            double d4 = par3 - this.v;
            double d5 = par5 - this.w;
            double d6 = d3 * d3 + d4 * d4 + d5 * d5;
            if (d6 <= 1.0) {
                return;
            }
            this.c = 3;
        }
        this.d = par1;
        this.e = par3;
        this.f = par5;
        this.g = par7;
        this.h = par8;
        this.x = this.i;
        this.y = this.j;
        this.z = this.au;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void h(double par1, double par3, double par5) {
        this.i = this.x = par1;
        this.j = this.y = par3;
        this.au = this.z = par5;
    }

    @Override
    public void l_() {
        double d5;
        double d4;
        super.l_();
        if (this.e() > 0) {
            this.a(this.e() - 1);
        }
        if (this.d() > 0.0f) {
            this.a(this.d() - 1.0f);
        }
        this.r = this.u;
        this.s = this.v;
        this.t = this.w;
        int b0 = 5;
        double d0 = 0.0;
        for (int i2 = 0; i2 < b0; ++i2) {
            double d1 = this.E.b + (this.E.e - this.E.b) * (double)(i2 + 0) / (double)b0 - 0.125;
            double d2 = this.E.b + (this.E.e - this.E.b) * (double)(i2 + 1) / (double)b0 - 0.125;
            asx axisalignedbb = asx.a().a(this.E.a, d1, this.E.c, this.E.d, d2, this.E.f);
            if (!this.q.b(axisalignedbb, akc.h)) continue;
            d0 += 1.0 / (double)b0;
        }
        double d3 = Math.sqrt(this.x * this.x + this.z * this.z);
        if (d3 > 0.26249999999999996) {
            d4 = Math.cos((double)this.A * Math.PI / 180.0);
            d5 = Math.sin((double)this.A * Math.PI / 180.0);
            int j2 = 0;
            while ((double)j2 < 1.0 + d3 * 60.0) {
                double d9;
                double d8;
                double d6 = this.ab.nextFloat() * 2.0f - 1.0f;
                double d7 = (double)(this.ab.nextInt(2) * 2 - 1) * 0.7;
                if (this.ab.nextBoolean()) {
                    d8 = this.u - d4 * d6 * 0.8 + d5 * d7;
                    d9 = this.w - d5 * d6 * 0.8 - d4 * d7;
                    this.q.a("splash", d8, this.v - 0.125, d9, this.x, this.y, this.z);
                } else {
                    d8 = this.u + d4 + d5 * d6 * 0.7;
                    d9 = this.w + d5 - d4 * d6 * 0.7;
                    this.q.a("splash", d8, this.v - 0.125, d9, this.x, this.y, this.z);
                }
                ++j2;
            }
        }
        if (this.q.I && this.a) {
            if (this.c > 0) {
                d4 = this.u + (this.d - this.u) / (double)this.c;
                d5 = this.v + (this.e - this.v) / (double)this.c;
                double d11 = this.w + (this.f - this.w) / (double)this.c;
                double d10 = ls.g(this.g - (double)this.A);
                this.A = (float)((double)this.A + d10 / (double)this.c);
                this.B = (float)((double)this.B + (this.h - (double)this.B) / (double)this.c);
                --this.c;
                this.b(d4, d5, d11);
                this.b(this.A, this.B);
            } else {
                d4 = this.u + this.x;
                d5 = this.v + this.y;
                double d11 = this.w + this.z;
                this.b(d4, d5, d11);
                if (this.F) {
                    this.x *= 0.5;
                    this.y *= 0.5;
                    this.z *= 0.5;
                }
                this.x *= (double)0.99f;
                this.y *= (double)0.95f;
                this.z *= (double)0.99f;
            }
        } else {
            double d12;
            double d11;
            if (d0 < 1.0) {
                d4 = d0 * 2.0 - 1.0;
                this.y += (double)0.04f * d4;
            } else {
                if (this.y < 0.0) {
                    this.y /= 2.0;
                }
                this.y += (double)0.007f;
            }
            if (this.n != null && this.n instanceof of && (d4 = (double)((of)this.n).bf) > 0.0) {
                d5 = -Math.sin(this.n.A * (float)Math.PI / 180.0f);
                d11 = Math.cos(this.n.A * (float)Math.PI / 180.0f);
                this.x += d5 * this.b * (double)0.05f;
                this.z += d11 * this.b * (double)0.05f;
            }
            if ((d4 = Math.sqrt(this.x * this.x + this.z * this.z)) > 0.35) {
                d5 = 0.35 / d4;
                this.x *= d5;
                this.z *= d5;
                d4 = 0.35;
            }
            if (d4 > d3 && this.b < 0.35) {
                this.b += (0.35 - this.b) / 35.0;
                if (this.b > 0.35) {
                    this.b = 0.35;
                }
            } else {
                this.b -= (this.b - 0.07) / 35.0;
                if (this.b < 0.07) {
                    this.b = 0.07;
                }
            }
            if (this.F) {
                this.x *= 0.5;
                this.y *= 0.5;
                this.z *= 0.5;
            }
            this.d(this.x, this.y, this.z);
            if (this.G && d3 > 0.2) {
                if (!this.q.I && !this.M) {
                    int k2;
                    this.x();
                    for (k2 = 0; k2 < 3; ++k2) {
                        this.a(aqz.C.cF, 1, 0.0f);
                    }
                    for (k2 = 0; k2 < 2; ++k2) {
                        this.a(yc.F.cv, 1, 0.0f);
                    }
                }
            } else {
                this.x *= (double)0.99f;
                this.y *= (double)0.95f;
                this.z *= (double)0.99f;
            }
            this.B = 0.0f;
            d5 = this.A;
            d11 = this.r - this.u;
            double d10 = this.t - this.w;
            if (d11 * d11 + d10 * d10 > 0.001) {
                d5 = (float)(Math.atan2(d10, d11) * 180.0 / Math.PI);
            }
            if ((d12 = ls.g(d5 - (double)this.A)) > 20.0) {
                d12 = 20.0;
            }
            if (d12 < -20.0) {
                d12 = -20.0;
            }
            this.A = (float)((double)this.A + d12);
            this.b(this.A, this.B);
            if (!this.q.I) {
                List list = this.q.b((nn)this, this.E.b((double)0.2f, 0.0, (double)0.2f));
                if (list != null && !list.isEmpty()) {
                    for (int l2 = 0; l2 < list.size(); ++l2) {
                        nn entity = (nn)list.get(l2);
                        if (entity == this.n || !entity.M() || !(entity instanceof sq)) continue;
                        entity.f(this);
                    }
                }
                for (int l3 = 0; l3 < 4; ++l3) {
                    int i1 = ls.c(this.u + ((double)(l3 % 2) - 0.5) * 0.8);
                    int j1 = ls.c(this.w + ((double)(l3 / 2) - 0.5) * 0.8);
                    for (int k1 = 0; k1 < 2; ++k1) {
                        int l1 = ls.c(this.v) + k1;
                        int i2 = this.q.a(i1, l1, j1);
                        if (i2 == aqz.aX.cF) {
                            this.q.i(i1, l1, j1);
                            continue;
                        }
                        if (i2 != aqz.bE.cF) continue;
                        this.q.a(i1, l1, j1, true);
                    }
                }
                if (this.n != null && this.n.M) {
                    this.n = null;
                }
            }
        }
    }

    @Override
    public void W() {
        if (this.n != null) {
            double d0 = Math.cos((double)this.A * Math.PI / 180.0) * 0.4;
            double d1 = Math.sin((double)this.A * Math.PI / 180.0) * 0.4;
            this.n.b(this.u + d0, this.v + this.Y() + this.n.X(), this.w + d1);
        }
    }

    @Override
    protected void b(by par1NBTTagCompound) {
    }

    @Override
    protected void a(by par1NBTTagCompound) {
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public float S() {
        return 0.0f;
    }

    @Override
    public boolean c(uf par1EntityPlayer) {
        if (this.n != null && this.n instanceof uf && this.n != par1EntityPlayer) {
            return true;
        }
        if (!this.q.I) {
            par1EntityPlayer.a(this);
        }
        return true;
    }

    public void a(float par1) {
        this.ah.b(19, Float.valueOf(par1));
    }

    public float d() {
        return this.ah.d(19);
    }

    public void a(int par1) {
        this.ah.b(17, par1);
    }

    public int e() {
        return this.ah.c(17);
    }

    public void c(int par1) {
        this.ah.b(18, par1);
    }

    public int h() {
        return this.ah.c(18);
    }

    @SideOnly(value=Side.CLIENT)
    public void a(boolean par1) {
        this.a = par1;
    }
}

