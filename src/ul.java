/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  akc
 *  asx
 *  ata
 *  atc
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  la
 *  nb
 *  oa
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

public class ul
extends nn {
    private int d = -1;
    private int e = -1;
    private int f = -1;
    private int g;
    private boolean h;
    public int a;
    public uf b;
    private int i;
    private int j;
    private int au;
    public nn c;
    private int av;
    private double aw;
    private double ax;
    private double ay;
    private double az;
    private double aA;
    @SideOnly(value=Side.CLIENT)
    private double aB;
    @SideOnly(value=Side.CLIENT)
    private double aC;
    @SideOnly(value=Side.CLIENT)
    private double aD;

    public ul(abw par1World) {
        super(par1World);
        this.a(0.25f, 0.25f);
        this.am = true;
    }

    @SideOnly(value=Side.CLIENT)
    public ul(abw par1World, double par2, double par4, double par6, uf par8EntityPlayer) {
        this(par1World);
        this.b(par2, par4, par6);
        this.am = true;
        this.b = par8EntityPlayer;
        par8EntityPlayer.bM = this;
    }

    public ul(abw par1World, uf par2EntityPlayer) {
        super(par1World);
        this.am = true;
        this.b = par2EntityPlayer;
        this.b.bM = this;
        this.a(0.25f, 0.25f);
        this.b(par2EntityPlayer.u, par2EntityPlayer.v + 1.62 - (double)par2EntityPlayer.N, par2EntityPlayer.w, par2EntityPlayer.A, par2EntityPlayer.B);
        this.u -= (double)(ls.b(this.A / 180.0f * (float)Math.PI) * 0.16f);
        this.v -= (double)0.1f;
        this.w -= (double)(ls.a(this.A / 180.0f * (float)Math.PI) * 0.16f);
        this.b(this.u, this.v, this.w);
        this.N = 0.0f;
        float f2 = 0.4f;
        this.x = -ls.a(this.A / 180.0f * (float)Math.PI) * ls.b(this.B / 180.0f * (float)Math.PI) * f2;
        this.z = ls.b(this.A / 180.0f * (float)Math.PI) * ls.b(this.B / 180.0f * (float)Math.PI) * f2;
        this.y = -ls.a(this.B / 180.0f * (float)Math.PI) * f2;
        this.c(this.x, this.y, this.z, 1.5f, 1.0f);
    }

    @Override
    protected void a() {
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean a(double par1) {
        double d1 = this.E.b() * 4.0;
        return par1 < (d1 *= 64.0) * d1;
    }

    public void c(double par1, double par3, double par5, float par7, float par8) {
        float f2 = ls.a(par1 * par1 + par3 * par3 + par5 * par5);
        par1 /= (double)f2;
        par3 /= (double)f2;
        par5 /= (double)f2;
        par1 += this.ab.nextGaussian() * (double)0.0075f * (double)par8;
        par3 += this.ab.nextGaussian() * (double)0.0075f * (double)par8;
        par5 += this.ab.nextGaussian() * (double)0.0075f * (double)par8;
        this.x = par1 *= (double)par7;
        this.y = par3 *= (double)par7;
        this.z = par5 *= (double)par7;
        float f3 = ls.a(par1 * par1 + par5 * par5);
        this.C = this.A = (float)(Math.atan2(par1, par5) * 180.0 / Math.PI);
        this.D = this.B = (float)(Math.atan2(par3, f3) * 180.0 / Math.PI);
        this.i = 0;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(double par1, double par3, double par5, float par7, float par8, int par9) {
        this.aw = par1;
        this.ax = par3;
        this.ay = par5;
        this.az = par7;
        this.aA = par8;
        this.av = par9;
        this.x = this.aB;
        this.y = this.aC;
        this.z = this.aD;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void h(double par1, double par3, double par5) {
        this.aB = this.x = par1;
        this.aC = this.y = par3;
        this.aD = this.z = par5;
    }

    @Override
    public void l_() {
        super.l_();
        if (this.av > 0) {
            double d0 = this.u + (this.aw - this.u) / (double)this.av;
            double d1 = this.v + (this.ax - this.v) / (double)this.av;
            double d2 = this.w + (this.ay - this.w) / (double)this.av;
            double d3 = ls.g(this.az - (double)this.A);
            this.A = (float)((double)this.A + d3 / (double)this.av);
            this.B = (float)((double)this.B + (this.aA - (double)this.B) / (double)this.av);
            --this.av;
            this.b(d0, d1, d2);
            this.b(this.A, this.B);
        } else {
            double d5;
            if (!this.q.I) {
                ye itemstack = this.b.by();
                if (this.b.M || !this.b.T() || itemstack == null || itemstack.b() != yc.aT || this.e(this.b) > 1024.0) {
                    this.x();
                    this.b.bM = null;
                    return;
                }
                if (this.c != null) {
                    if (!this.c.M) {
                        this.u = this.c.u;
                        this.v = this.c.E.b + (double)this.c.P * 0.8;
                        this.w = this.c.w;
                        return;
                    }
                    this.c = null;
                }
            }
            if (this.a > 0) {
                --this.a;
            }
            if (this.h) {
                int i2 = this.q.a(this.d, this.e, this.f);
                if (i2 == this.g) {
                    ++this.i;
                    if (this.i == 1200) {
                        this.x();
                    }
                    return;
                }
                this.h = false;
                this.x *= (double)(this.ab.nextFloat() * 0.2f);
                this.y *= (double)(this.ab.nextFloat() * 0.2f);
                this.z *= (double)(this.ab.nextFloat() * 0.2f);
                this.i = 0;
                this.j = 0;
            } else {
                ++this.j;
            }
            atc vec3 = this.q.V().a(this.u, this.v, this.w);
            atc vec31 = this.q.V().a(this.u + this.x, this.v + this.y, this.w + this.z);
            ata movingobjectposition = this.q.a(vec3, vec31);
            vec3 = this.q.V().a(this.u, this.v, this.w);
            vec31 = this.q.V().a(this.u + this.x, this.v + this.y, this.w + this.z);
            if (movingobjectposition != null) {
                vec31 = this.q.V().a(movingobjectposition.f.c, movingobjectposition.f.d, movingobjectposition.f.e);
            }
            nn entity = null;
            List list = this.q.b((nn)this, this.E.a(this.x, this.y, this.z).b(1.0, 1.0, 1.0));
            double d4 = 0.0;
            for (int j2 = 0; j2 < list.size(); ++j2) {
                float f2;
                asx axisalignedbb;
                ata movingobjectposition1;
                nn entity1 = (nn)list.get(j2);
                if (!entity1.L() || entity1 == this.b && this.j < 5 || (movingobjectposition1 = (axisalignedbb = entity1.E.b((double)(f2 = 0.3f), (double)f2, (double)f2)).a(vec3, vec31)) == null || !((d5 = vec3.d(movingobjectposition1.f)) < d4) && d4 != 0.0) continue;
                entity = entity1;
                d4 = d5;
            }
            if (entity != null) {
                movingobjectposition = new ata(entity);
            }
            if (movingobjectposition != null) {
                if (movingobjectposition.g != null) {
                    if (movingobjectposition.g.a(nb.a((nn)this, (nn)this.b), 0.0f)) {
                        this.c = movingobjectposition.g;
                    }
                } else {
                    this.h = true;
                }
            }
            if (!this.h) {
                this.d(this.x, this.y, this.z);
                float f1 = ls.a(this.x * this.x + this.z * this.z);
                this.A = (float)(Math.atan2(this.x, this.z) * 180.0 / Math.PI);
                this.B = (float)(Math.atan2(this.y, f1) * 180.0 / Math.PI);
                while (this.B - this.D < -180.0f) {
                    this.D -= 360.0f;
                }
                while (this.B - this.D >= 180.0f) {
                    this.D += 360.0f;
                }
                while (this.A - this.C < -180.0f) {
                    this.C -= 360.0f;
                }
                while (this.A - this.C >= 180.0f) {
                    this.C += 360.0f;
                }
                this.B = this.D + (this.B - this.D) * 0.2f;
                this.A = this.C + (this.A - this.C) * 0.2f;
                float f2 = 0.92f;
                if (this.F || this.G) {
                    f2 = 0.5f;
                }
                int b0 = 5;
                double d6 = 0.0;
                for (int k2 = 0; k2 < b0; ++k2) {
                    double d7 = this.E.b + (this.E.e - this.E.b) * (double)(k2 + 0) / (double)b0 - 0.125 + 0.125;
                    double d8 = this.E.b + (this.E.e - this.E.b) * (double)(k2 + 1) / (double)b0 - 0.125 + 0.125;
                    asx axisalignedbb1 = asx.a().a(this.E.a, d7, this.E.c, this.E.d, d8, this.E.f);
                    if (!this.q.b(axisalignedbb1, akc.h)) continue;
                    d6 += 1.0 / (double)b0;
                }
                if (d6 > 0.0) {
                    if (this.au > 0) {
                        --this.au;
                    } else {
                        int short1 = 500;
                        if (this.q.F(ls.c(this.u), ls.c(this.v) + 1, ls.c(this.w))) {
                            short1 = 300;
                        }
                        if (this.ab.nextInt(short1) == 0) {
                            float f5;
                            this.au = this.ab.nextInt(30) + 10;
                            this.y -= (double)0.2f;
                            this.a("random.splash", 0.25f, 1.0f + (this.ab.nextFloat() - this.ab.nextFloat()) * 0.4f);
                            float f3 = ls.c(this.E.b);
                            int l2 = 0;
                            while ((float)l2 < 1.0f + this.O * 20.0f) {
                                f5 = (this.ab.nextFloat() * 2.0f - 1.0f) * this.O;
                                float f4 = (this.ab.nextFloat() * 2.0f - 1.0f) * this.O;
                                this.q.a("bubble", this.u + (double)f5, (double)(f3 + 1.0f), this.w + (double)f4, this.x, this.y - (double)(this.ab.nextFloat() * 0.2f), this.z);
                                ++l2;
                            }
                            l2 = 0;
                            while ((float)l2 < 1.0f + this.O * 20.0f) {
                                f5 = (this.ab.nextFloat() * 2.0f - 1.0f) * this.O;
                                float f4 = (this.ab.nextFloat() * 2.0f - 1.0f) * this.O;
                                this.q.a("splash", this.u + (double)f5, (double)(f3 + 1.0f), this.w + (double)f4, this.x, this.y, this.z);
                                ++l2;
                            }
                        }
                    }
                }
                if (this.au > 0) {
                    this.y -= (double)(this.ab.nextFloat() * this.ab.nextFloat() * this.ab.nextFloat()) * 0.2;
                }
                d5 = d6 * 2.0 - 1.0;
                this.y += (double)0.04f * d5;
                if (d6 > 0.0) {
                    f2 = (float)((double)f2 * 0.9);
                    this.y *= 0.8;
                }
                this.x *= (double)f2;
                this.y *= (double)f2;
                this.z *= (double)f2;
                this.b(this.u, this.v, this.w);
            }
        }
    }

    @Override
    public void b(by par1NBTTagCompound) {
        par1NBTTagCompound.a("xTile", (short)this.d);
        par1NBTTagCompound.a("yTile", (short)this.e);
        par1NBTTagCompound.a("zTile", (short)this.f);
        par1NBTTagCompound.a("inTile", (byte)this.g);
        par1NBTTagCompound.a("shake", (byte)this.a);
        par1NBTTagCompound.a("inGround", (byte)(this.h ? 1 : 0));
    }

    @Override
    public void a(by par1NBTTagCompound) {
        this.d = par1NBTTagCompound.d("xTile");
        this.e = par1NBTTagCompound.d("yTile");
        this.f = par1NBTTagCompound.d("zTile");
        this.g = par1NBTTagCompound.c("inTile") & 0xFF;
        this.a = par1NBTTagCompound.c("shake") & 0xFF;
        this.h = par1NBTTagCompound.c("inGround") == 1;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public float S() {
        return 0.0f;
    }

    public int c() {
        if (this.q.I) {
            return 0;
        }
        int b0 = 0;
        if (this.c != null) {
            double d0 = this.b.u - this.u;
            double d1 = this.b.v - this.v;
            double d2 = this.b.w - this.w;
            double d3 = ls.a(d0 * d0 + d1 * d1 + d2 * d2);
            double d4 = 0.1;
            this.c.x += d0 * d4;
            this.c.y += d1 * d4 + (double)ls.a(d3) * 0.08;
            this.c.z += d2 * d4;
            b0 = 3;
        } else if (this.au > 0) {
            ss entityitem = new ss(this.q, this.u, this.v, this.w, new ye(yc.aW));
            double d5 = this.b.u - this.u;
            double d6 = this.b.v - this.v;
            double d7 = this.b.w - this.w;
            double d8 = ls.a(d5 * d5 + d6 * d6 + d7 * d7);
            double d9 = 0.1;
            entityitem.x = d5 * d9;
            entityitem.y = d6 * d9 + (double)ls.a(d8) * 0.08;
            entityitem.z = d7 * d9;
            this.q.d(entityitem);
            this.b.a(la.B, 1);
            this.b.q.d((nn)new oa(this.b.q, this.b.u, this.b.v + 0.5, this.b.w + 0.5, this.ab.nextInt(6) + 1));
            b0 = 1;
        }
        if (this.h) {
            b0 = 2;
        }
        this.x();
        this.b.bM = null;
        return b0;
    }

    @Override
    public void x() {
        super.x();
        if (this.b != null) {
            this.b.bM = null;
        }
    }
}

