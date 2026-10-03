/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bdx
 *  beg
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class bdy
extends beg {
    private int aB;
    private final beh aC;
    private cg aD;
    boolean a;

    public bdy(abw par1World, double par2, double par4, double par6, double par8, double par10, double par12, beh par14EffectRenderer, by par15NBTTagCompound) {
        super(par1World, par2, par4, par6, 0.0, 0.0, 0.0);
        this.x = par8;
        this.y = par10;
        this.z = par12;
        this.aC = par14EffectRenderer;
        this.g = 8;
        if (par15NBTTagCompound != null) {
            this.aD = par15NBTTagCompound.m("Explosions");
            if (this.aD != null && this.aD.c() == 0) {
                this.aD = null;
            } else if (this.aD != null) {
                this.g = this.aD.c() * 2 - 1;
                for (int i2 = 0; i2 < this.aD.c(); ++i2) {
                    by nbttagcompound1 = (by)this.aD.b(i2);
                    if (!nbttagcompound1.n("Flicker")) continue;
                    this.a = true;
                    this.g += 15;
                    break;
                }
            }
        }
    }

    public void a(bfq par1Tessellator, float par2, float par3, float par4, float par5, float par6, float par7) {
    }

    public void l_() {
        boolean flag;
        if (this.aB == 0 && this.aD != null) {
            flag = this.i();
            boolean flag1 = false;
            if (this.aD.c() >= 3) {
                flag1 = true;
            } else {
                for (int i2 = 0; i2 < this.aD.c(); ++i2) {
                    by nbttagcompound = (by)this.aD.b(i2);
                    if (nbttagcompound.c("Type") != 1) continue;
                    flag1 = true;
                    break;
                }
            }
            String s2 = "fireworks." + (flag1 ? "largeBlast" : "blast") + (flag ? "_far" : "");
            this.q.a(this.u, this.v, this.w, s2, 20.0f, 0.95f + this.ab.nextFloat() * 0.1f, true);
        }
        if (this.aB % 2 == 0 && this.aD != null && this.aB / 2 < this.aD.c()) {
            int j2 = this.aB / 2;
            by nbttagcompound1 = (by)this.aD.b(j2);
            byte b0 = nbttagcompound1.c("Type");
            boolean flag2 = nbttagcompound1.n("Trail");
            boolean flag3 = nbttagcompound1.n("Flicker");
            int[] aint = nbttagcompound1.k("Colors");
            int[] aint1 = nbttagcompound1.k("FadeColors");
            if (b0 == 1) {
                this.a(0.5, 4, aint, aint1, flag2, flag3);
            } else if (b0 == 2) {
                this.a(0.5, new double[][]{{0.0, 1.0}, {0.3455, 0.309}, {0.9511, 0.309}, {0.3795918367346939, -0.12653061224489795}, {0.6122448979591837, -0.8040816326530612}, {0.0, -0.35918367346938773}}, aint, aint1, flag2, flag3, false);
            } else if (b0 == 3) {
                this.a(0.5, new double[][]{{0.0, 0.2}, {0.2, 0.2}, {0.2, 0.6}, {0.6, 0.6}, {0.6, 0.2}, {0.2, 0.2}, {0.2, 0.0}, {0.4, 0.0}, {0.4, -0.6}, {0.2, -0.6}, {0.2, -0.4}, {0.0, -0.4}}, aint, aint1, flag2, flag3, true);
            } else if (b0 == 4) {
                this.a(aint, aint1, flag2, flag3);
            } else {
                this.a(0.25, 2, aint, aint1, flag2, flag3);
            }
            int k = aint[0];
            float f2 = (float)((k & 0xFF0000) >> 16) / 255.0f;
            float f1 = (float)((k & 0xFF00) >> 8) / 255.0f;
            float f22 = (float)((k & 0xFF) >> 0) / 255.0f;
            bdw entityfireworkoverlayfx = new bdw(this.q, this.u, this.v, this.w);
            entityfireworkoverlayfx.b(f2, f1, f22);
            this.aC.a(entityfireworkoverlayfx);
        }
        ++this.aB;
        if (this.aB > this.g) {
            if (this.a) {
                flag = this.i();
                String s1 = "fireworks." + (flag ? "twinkle_far" : "twinkle");
                this.q.a(this.u, this.v, this.w, s1, 20.0f, 0.9f + this.ab.nextFloat() * 0.15f, true);
            }
            this.x();
        }
    }

    private boolean i() {
        atv minecraft = atv.w();
        return minecraft == null || minecraft.i == null || minecraft.i.e(this.u, this.v, this.w) >= 256.0;
    }

    private void a(double par1, double par3, double par5, double par7, double par9, double par11, int[] par13ArrayOfInteger, int[] par14ArrayOfInteger, boolean par15, boolean par16) {
        bdx entityfireworksparkfx = new bdx(this.q, par1, par3, par5, par7, par9, par11, this.aC);
        entityfireworksparkfx.a(par15);
        entityfireworksparkfx.f(par16);
        int i2 = this.ab.nextInt(par13ArrayOfInteger.length);
        entityfireworksparkfx.a(par13ArrayOfInteger[i2]);
        if (par14ArrayOfInteger != null && par14ArrayOfInteger.length > 0) {
            entityfireworksparkfx.c(par14ArrayOfInteger[this.ab.nextInt(par14ArrayOfInteger.length)]);
        }
        this.aC.a((beg)entityfireworksparkfx);
    }

    private void a(double par1, int par3, int[] par4ArrayOfInteger, int[] par5ArrayOfInteger, boolean par6, boolean par7) {
        double d1 = this.u;
        double d2 = this.v;
        double d3 = this.w;
        for (int j2 = -par3; j2 <= par3; ++j2) {
            for (int k = -par3; k <= par3; ++k) {
                for (int l2 = -par3; l2 <= par3; ++l2) {
                    double d4 = (double)k + (this.ab.nextDouble() - this.ab.nextDouble()) * 0.5;
                    double d5 = (double)j2 + (this.ab.nextDouble() - this.ab.nextDouble()) * 0.5;
                    double d6 = (double)l2 + (this.ab.nextDouble() - this.ab.nextDouble()) * 0.5;
                    double d7 = (double)ls.a(d4 * d4 + d5 * d5 + d6 * d6) / par1 + this.ab.nextGaussian() * 0.05;
                    this.a(d1, d2, d3, d4 / d7, d5 / d7, d6 / d7, par4ArrayOfInteger, par5ArrayOfInteger, par6, par7);
                    if (j2 == -par3 || j2 == par3 || k == -par3 || k == par3) continue;
                    l2 += par3 * 2 - 1;
                }
            }
        }
    }

    private void a(double par1, double[][] par3ArrayOfDouble, int[] par4ArrayOfInteger, int[] par5ArrayOfInteger, boolean par6, boolean par7, boolean par8) {
        double d1 = par3ArrayOfDouble[0][0];
        double d2 = par3ArrayOfDouble[0][1];
        this.a(this.u, this.v, this.w, d1 * par1, d2 * par1, 0.0, par4ArrayOfInteger, par5ArrayOfInteger, par6, par7);
        float f2 = this.ab.nextFloat() * (float)Math.PI;
        double d3 = par8 ? 0.034 : 0.34;
        for (int i2 = 0; i2 < 3; ++i2) {
            double d4 = (double)f2 + (double)((float)i2 * (float)Math.PI) * d3;
            double d5 = d1;
            double d6 = d2;
            for (int j2 = 1; j2 < par3ArrayOfDouble.length; ++j2) {
                double d7 = par3ArrayOfDouble[j2][0];
                double d8 = par3ArrayOfDouble[j2][1];
                for (double d9 = 0.25; d9 <= 1.0; d9 += 0.25) {
                    double d10 = (d5 + (d7 - d5) * d9) * par1;
                    double d11 = (d6 + (d8 - d6) * d9) * par1;
                    double d12 = d10 * Math.sin(d4);
                    d10 *= Math.cos(d4);
                    for (double d13 = -1.0; d13 <= 1.0; d13 += 2.0) {
                        this.a(this.u, this.v, this.w, d10 * d13, d11, d12 * d13, par4ArrayOfInteger, par5ArrayOfInteger, par6, par7);
                    }
                }
                d5 = d7;
                d6 = d8;
            }
        }
    }

    private void a(int[] par1ArrayOfInteger, int[] par2ArrayOfInteger, boolean par3, boolean par4) {
        double d0 = this.ab.nextGaussian() * 0.05;
        double d1 = this.ab.nextGaussian() * 0.05;
        for (int i2 = 0; i2 < 70; ++i2) {
            double d2 = this.x * 0.5 + this.ab.nextGaussian() * 0.15 + d0;
            double d3 = this.z * 0.5 + this.ab.nextGaussian() * 0.15 + d1;
            double d4 = this.y * 0.5 + this.ab.nextDouble() * 0.5;
            this.a(this.u, this.v, this.w, d2, d4, d3, par1ArrayOfInteger, par2ArrayOfInteger, par3, par4);
        }
    }

    public int b() {
        return 0;
    }
}

