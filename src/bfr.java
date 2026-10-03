/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  FMLRenderAccessLibrary
 *  acf
 *  akc
 *  amv
 *  amy
 *  ana
 *  and
 *  anm
 *  anp
 *  anv
 *  anw
 *  aob
 *  aog
 *  aoh
 *  aoj
 *  aon
 *  aot
 *  aqf
 *  aqp
 *  aqq
 *  aqx
 *  aqy
 *  arl
 *  arn
 *  ast
 *  asu
 *  atc
 *  bfd
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ms
 *  net.minecraftforge.common.ForgeDirection
 *  org.lwjgl.opengl.GL11
 *  r
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.common.ForgeDirection;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class bfr {
    public acf a;
    public ms d;
    public boolean e;
    public boolean f;
    public static boolean b = true;
    public boolean c = true;
    public double g;
    public double h;
    public double i;
    public double j;
    public double k;
    public double l;
    public boolean m;
    public boolean n;
    public final atv o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public boolean v;
    public float w;
    public float x;
    public float y;
    public float z;
    public float A;
    public float B;
    public float C;
    public float D;
    public float E;
    public float F;
    public float G;
    public float H;
    public float I;
    public float J;
    public float K;
    public float L;
    public float M;
    public float N;
    public float O;
    public float P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public int V;
    public int W;
    public int X;
    public int Y;
    public int Z;
    public int aa;
    public int ab;
    public int ac;
    public int ad;
    public int ae;
    public int af;
    public int ag;
    public int ah;
    public int ai;
    public int aj;
    public int ak;
    public int al;
    public int am;
    public int an;
    public float ao;
    public float ap;
    public float aq;
    public float ar;
    public float as;
    public float at;
    public float au;
    public float av;
    public float aw;
    public float ax;
    public float ay;
    public float az;

    public bfr(acf par1IBlockAccess) {
        this.a = par1IBlockAccess;
        this.o = atv.w();
    }

    public bfr() {
        this.o = atv.w();
    }

    public void a(ms par1Icon) {
        this.d = par1Icon;
    }

    public void a() {
        this.d = null;
    }

    public boolean b() {
        return this.d != null;
    }

    public void a(double par1, double par3, double par5, double par7, double par9, double par11) {
        if (!this.m) {
            this.g = par1;
            this.h = par7;
            this.i = par3;
            this.j = par9;
            this.k = par5;
            this.l = par11;
            this.n = this.o.u.k >= 2 && (this.g > 0.0 || this.h < 1.0 || this.i > 0.0 || this.j < 1.0 || this.k > 0.0 || this.l < 1.0);
        }
    }

    public void a(aqz par1Block) {
        if (!this.m) {
            this.g = par1Block.u();
            this.h = par1Block.v();
            this.i = par1Block.w();
            this.j = par1Block.x();
            this.k = par1Block.y();
            this.l = par1Block.z();
            this.n = this.o.u.k >= 2 && (this.g > 0.0 || this.h < 1.0 || this.i > 0.0 || this.j < 1.0 || this.k > 0.0 || this.l < 1.0);
        }
    }

    public void b(double par1, double par3, double par5, double par7, double par9, double par11) {
        this.g = par1;
        this.h = par7;
        this.i = par3;
        this.j = par9;
        this.k = par5;
        this.l = par11;
        this.m = true;
        this.n = this.o.u.k >= 2 && (this.g > 0.0 || this.h < 1.0 || this.i > 0.0 || this.j < 1.0 || this.k > 0.0 || this.l < 1.0);
    }

    public void c() {
        this.m = false;
    }

    public void a(aqz par1Block, int par2, int par3, int par4, ms par5Icon) {
        this.a(par5Icon);
        this.b(par1Block, par2, par3, par4);
        this.a();
    }

    public void a(aqz par1Block, int par2, int par3, int par4) {
        this.f = true;
        this.b(par1Block, par2, par3, par4);
        this.f = false;
    }

    public boolean b(aqz par1Block, int par2, int par3, int par4) {
        int l2 = par1Block.d();
        if (l2 == -1) {
            return false;
        }
        par1Block.a(this.a, par2, par3, par4);
        this.a(par1Block);
        switch (l2) {
            case 0: {
                return this.p(par1Block, par2, par3, par4);
            }
            case 4: {
                return this.o(par1Block, par2, par3, par4);
            }
            case 31: {
                return this.q(par1Block, par2, par3, par4);
            }
            case 1: {
                return this.k(par1Block, par2, par3, par4);
            }
            case 2: {
                return this.c(par1Block, par2, par3, par4);
            }
            case 20: {
                return this.j(par1Block, par2, par3, par4);
            }
            case 11: {
                return this.a((aoh)par1Block, par2, par3, par4);
            }
            case 39: {
                return this.r(par1Block, par2, par3, par4);
            }
            case 5: {
                return this.h(par1Block, par2, par3, par4);
            }
            case 13: {
                return this.s(par1Block, par2, par3, par4);
            }
            case 9: {
                return this.a((amy)par1Block, par2, par3, par4);
            }
            case 19: {
                return this.l(par1Block, par2, par3, par4);
            }
            case 23: {
                return this.n(par1Block, par2, par3, par4);
            }
            case 6: {
                return this.m(par1Block, par2, par3, par4);
            }
            case 3: {
                return this.a((aoi)par1Block, par2, par3, par4);
            }
            case 8: {
                return this.i(par1Block, par2, par3, par4);
            }
            case 7: {
                return this.t(par1Block, par2, par3, par4);
            }
            case 10: {
                return this.a((aqp)par1Block, par2, par3, par4);
            }
            case 27: {
                return this.a((aob)par1Block, par2, par3, par4);
            }
            case 32: {
                return this.a((arn)par1Block, par2, par3, par4);
            }
            case 12: {
                return this.e(par1Block, par2, par3, par4);
            }
            case 29: {
                return this.f(par1Block, par2, par3, par4);
            }
            case 30: {
                return this.g(par1Block, par2, par3, par4);
            }
            case 14: {
                return this.u(par1Block, par2, par3, par4);
            }
            case 15: {
                return this.a((aqf)par1Block, par2, par3, par4);
            }
            case 36: {
                return this.a((anv)par1Block, par2, par3, par4);
            }
            case 37: {
                return this.a((anp)par1Block, par2, par3, par4);
            }
            case 16: {
                return this.b(par1Block, par2, par3, par4, false);
            }
            case 17: {
                return this.c(par1Block, par2, par3, par4, true);
            }
            case 18: {
                return this.a((aqy)par1Block, par2, par3, par4);
            }
            case 21: {
                return this.a((aog)par1Block, par2, par3, par4);
            }
            case 24: {
                return this.a((anj)par1Block, par2, par3, par4);
            }
            case 33: {
                return this.a((aoj)par1Block, par2, par3, par4);
            }
            case 35: {
                return this.a((amv)par1Block, par2, par3, par4);
            }
            case 25: {
                return this.a((and)par1Block, par2, par3, par4);
            }
            case 26: {
                return this.a((aqx)par1Block, par2, par3, par4);
            }
            case 28: {
                return this.a((anm)par1Block, par2, par3, par4);
            }
            case 34: {
                return this.a((ana)par1Block, par2, par3, par4);
            }
            case 38: {
                return this.a((aot)par1Block, par2, par3, par4);
            }
        }
        return FMLRenderAccessLibrary.renderWorldBlock((bfr)this, (acf)this.a, (int)par2, (int)par3, (int)par4, (aqz)par1Block, (int)l2);
    }

    public boolean a(aqx par1BlockEndPortalFrame, int par2, int par3, int par4) {
        int l2 = this.a.h(par2, par3, par4);
        int i1 = l2 & 3;
        if (i1 == 0) {
            this.t = 3;
        } else if (i1 == 3) {
            this.t = 1;
        } else if (i1 == 1) {
            this.t = 2;
        }
        if (!aqx.d((int)l2)) {
            this.a(0.0, 0.0, 0.0, 1.0, 0.8125, 1.0);
            this.p((aqz)par1BlockEndPortalFrame, par2, par3, par4);
            this.t = 0;
            return true;
        }
        this.f = true;
        this.a(0.0, 0.0, 0.0, 1.0, 0.8125, 1.0);
        this.p((aqz)par1BlockEndPortalFrame, par2, par3, par4);
        this.a(par1BlockEndPortalFrame.q());
        this.a(0.25, 0.8125, 0.25, 0.75, 1.0, 0.75);
        this.p((aqz)par1BlockEndPortalFrame, par2, par3, par4);
        this.f = false;
        this.a();
        this.t = 0;
        return true;
    }

    public boolean u(aqz par1Block, int par2, int par3, int par4) {
        bfq tessellator = bfq.a;
        int i1 = par1Block.getBedDirection(this.a, par2, par3, par4);
        boolean flag = par1Block.isBedFoot(this.a, par2, par3, par4);
        float f2 = 0.5f;
        float f1 = 1.0f;
        float f22 = 0.8f;
        float f3 = 0.6f;
        int j1 = par1Block.e(this.a, par2, par3, par4);
        tessellator.c(j1);
        tessellator.a(f2, f2, f2);
        ms icon = this.a(par1Block, this.a, par2, par3, par4, 0);
        if (this.b()) {
            icon = this.d;
        }
        double d0 = icon.c();
        double d1 = icon.d();
        double d2 = icon.e();
        double d3 = icon.f();
        double d4 = (double)par2 + this.g;
        double d5 = (double)par2 + this.h;
        double d6 = (double)par3 + this.i + 0.1875;
        double d7 = (double)par4 + this.k;
        double d8 = (double)par4 + this.l;
        tessellator.a(d4, d6, d8, d0, d3);
        tessellator.a(d4, d6, d7, d0, d2);
        tessellator.a(d5, d6, d7, d1, d2);
        tessellator.a(d5, d6, d8, d1, d3);
        tessellator.c(par1Block.e(this.a, par2, par3 + 1, par4));
        tessellator.a(f1, f1, f1);
        icon = this.a(par1Block, this.a, par2, par3, par4, 1);
        if (this.b()) {
            icon = this.d;
        }
        d0 = icon.c();
        d1 = icon.d();
        d2 = icon.e();
        d3 = icon.f();
        d4 = d0;
        d5 = d1;
        d6 = d2;
        d7 = d2;
        d8 = d0;
        double d9 = d1;
        double d10 = d3;
        double d11 = d3;
        if (i1 == 0) {
            d5 = d0;
            d6 = d3;
            d8 = d1;
            d11 = d2;
        } else if (i1 == 2) {
            d4 = d1;
            d7 = d3;
            d9 = d0;
            d10 = d2;
        } else if (i1 == 3) {
            d4 = d1;
            d7 = d3;
            d9 = d0;
            d10 = d2;
            d5 = d0;
            d6 = d3;
            d8 = d1;
            d11 = d2;
        }
        double d12 = (double)par2 + this.g;
        double d13 = (double)par2 + this.h;
        double d14 = (double)par3 + this.j;
        double d15 = (double)par4 + this.k;
        double d16 = (double)par4 + this.l;
        tessellator.a(d13, d14, d16, d8, d10);
        tessellator.a(d13, d14, d15, d4, d6);
        tessellator.a(d12, d14, d15, d5, d7);
        tessellator.a(d12, d14, d16, d9, d11);
        int k1 = r.d[i1];
        if (flag) {
            k1 = r.d[r.f[i1]];
        }
        int b0 = 4;
        switch (i1) {
            case 0: {
                b0 = 5;
                break;
            }
            case 1: {
                b0 = 3;
            }
            default: {
                break;
            }
            case 3: {
                b0 = 2;
            }
        }
        if (k1 != 2 && (this.f || par1Block.a(this.a, par2, par3, par4 - 1, 2))) {
            tessellator.c(this.k > 0.0 ? j1 : par1Block.e(this.a, par2, par3, par4 - 1));
            tessellator.a(f22, f22, f22);
            this.e = b0 == 2;
            this.c(par1Block, (double)par2, (double)par3, (double)par4, this.a(par1Block, this.a, par2, par3, par4, 2));
        }
        if (k1 != 3 && (this.f || par1Block.a(this.a, par2, par3, par4 + 1, 3))) {
            tessellator.c(this.l < 1.0 ? j1 : par1Block.e(this.a, par2, par3, par4 + 1));
            tessellator.a(f22, f22, f22);
            this.e = b0 == 3;
            this.d(par1Block, par2, par3, par4, this.a(par1Block, this.a, par2, par3, par4, 3));
        }
        if (k1 != 4 && (this.f || par1Block.a(this.a, par2 - 1, par3, par4, 4))) {
            tessellator.c(this.k > 0.0 ? j1 : par1Block.e(this.a, par2 - 1, par3, par4));
            tessellator.a(f3, f3, f3);
            this.e = b0 == 4;
            this.e(par1Block, par2, par3, par4, this.a(par1Block, this.a, par2, par3, par4, 4));
        }
        if (k1 != 5 && (this.f || par1Block.a(this.a, par2 + 1, par3, par4, 5))) {
            tessellator.c(this.l < 1.0 ? j1 : par1Block.e(this.a, par2 + 1, par3, par4));
            tessellator.a(f3, f3, f3);
            this.e = b0 == 5;
            this.f(par1Block, par2, par3, par4, this.a(par1Block, this.a, par2, par3, par4, 5));
        }
        this.e = false;
        return true;
    }

    public boolean a(and par1BlockBrewingStand, int par2, int par3, int par4) {
        this.a(0.4375, 0.0, 0.4375, 0.5625, 0.875, 0.5625);
        this.p((aqz)par1BlockBrewingStand, par2, par3, par4);
        this.a(par1BlockBrewingStand.i());
        this.f = true;
        this.a(0.5625, 0.0, 0.3125, 0.9375, 0.125, 0.6875);
        this.p((aqz)par1BlockBrewingStand, par2, par3, par4);
        this.a(0.125, 0.0, 0.0625, 0.5, 0.125, 0.4375);
        this.p((aqz)par1BlockBrewingStand, par2, par3, par4);
        this.a(0.125, 0.0, 0.5625, 0.5, 0.125, 0.9375);
        this.p((aqz)par1BlockBrewingStand, par2, par3, par4);
        this.f = false;
        this.a();
        bfq tessellator = bfq.a;
        tessellator.c(par1BlockBrewingStand.e(this.a, par2, par3, par4));
        float f2 = 1.0f;
        int l2 = par1BlockBrewingStand.c(this.a, par2, par3, par4);
        float f1 = (float)(l2 >> 16 & 0xFF) / 255.0f;
        float f22 = (float)(l2 >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(l2 & 0xFF) / 255.0f;
        if (bfe.a) {
            float f4 = (f1 * 30.0f + f22 * 59.0f + f3 * 11.0f) / 100.0f;
            float f5 = (f1 * 30.0f + f22 * 70.0f) / 100.0f;
            float f6 = (f1 * 30.0f + f3 * 70.0f) / 100.0f;
            f1 = f4;
            f22 = f5;
            f3 = f6;
        }
        tessellator.a(f2 * f1, f2 * f22, f2 * f3);
        ms icon = this.a((aqz)par1BlockBrewingStand, 0, 0);
        if (this.b()) {
            icon = this.d;
        }
        double d0 = icon.e();
        double d1 = icon.f();
        int i1 = this.a.h(par2, par3, par4);
        for (int j1 = 0; j1 < 3; ++j1) {
            double d2 = (double)j1 * Math.PI * 2.0 / 3.0 + 1.5707963267948966;
            double d3 = icon.a(8.0);
            double d4 = icon.d();
            if ((i1 & 1 << j1) != 0) {
                d4 = icon.c();
            }
            double d5 = (double)par2 + 0.5;
            double d6 = (double)par2 + 0.5 + Math.sin(d2) * 8.0 / 16.0;
            double d7 = (double)par4 + 0.5;
            double d8 = (double)par4 + 0.5 + Math.cos(d2) * 8.0 / 16.0;
            tessellator.a(d5, par3 + 1, d7, d3, d0);
            tessellator.a(d5, par3 + 0, d7, d3, d1);
            tessellator.a(d6, par3 + 0, d8, d4, d1);
            tessellator.a(d6, par3 + 1, d8, d4, d0);
            tessellator.a(d6, par3 + 1, d8, d4, d0);
            tessellator.a(d6, par3 + 0, d8, d4, d1);
            tessellator.a(d5, par3 + 0, d7, d3, d1);
            tessellator.a(d5, par3 + 1, d7, d3, d0);
        }
        par1BlockBrewingStand.g();
        return true;
    }

    public boolean a(anj par1BlockCauldron, int par2, int par3, int par4) {
        float f4;
        this.p(par1BlockCauldron, par2, par3, par4);
        bfq tessellator = bfq.a;
        tessellator.c(par1BlockCauldron.e(this.a, par2, par3, par4));
        float f2 = 1.0f;
        int l2 = par1BlockCauldron.c(this.a, par2, par3, par4);
        float f1 = (float)(l2 >> 16 & 0xFF) / 255.0f;
        float f22 = (float)(l2 >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(l2 & 0xFF) / 255.0f;
        if (bfe.a) {
            float f5 = (f1 * 30.0f + f22 * 59.0f + f3 * 11.0f) / 100.0f;
            f4 = (f1 * 30.0f + f22 * 70.0f) / 100.0f;
            float f6 = (f1 * 30.0f + f3 * 70.0f) / 100.0f;
            f1 = f5;
            f22 = f4;
            f3 = f6;
        }
        tessellator.a(f2 * f1, f2 * f22, f2 * f3);
        ms icon = par1BlockCauldron.m(2);
        f4 = 0.125f;
        this.f(par1BlockCauldron, (float)par2 - 1.0f + f4, par3, par4, icon);
        this.e(par1BlockCauldron, (float)par2 + 1.0f - f4, par3, par4, icon);
        this.d(par1BlockCauldron, par2, par3, (float)par4 - 1.0f + f4, icon);
        this.c((aqz)par1BlockCauldron, (double)par2, (double)par3, (float)par4 + 1.0f - f4, icon);
        ms icon1 = anj.b("inner");
        this.b((aqz)par1BlockCauldron, (double)par2, (float)par3 - 1.0f + 0.25f, (double)par4, icon1);
        this.a((aqz)par1BlockCauldron, (double)par2, (double)((float)par3 + 1.0f - 0.75f), (double)par4, icon1);
        int i1 = this.a.h(par2, par3, par4);
        if (i1 > 0) {
            ms icon2 = apc.b("water_still");
            if (i1 > 3) {
                i1 = 3;
            }
            this.b((aqz)par1BlockCauldron, (double)par2, (float)par3 - 1.0f + (6.0f + (float)i1 * 3.0f) / 16.0f, (double)par4, icon2);
        }
        return true;
    }

    public boolean a(aoj par1BlockFlowerPot, int par2, int par3, int par4) {
        float f5;
        float f4;
        this.p((aqz)par1BlockFlowerPot, par2, par3, par4);
        bfq tessellator = bfq.a;
        tessellator.c(par1BlockFlowerPot.e(this.a, par2, par3, par4));
        float f2 = 1.0f;
        int l2 = par1BlockFlowerPot.c(this.a, par2, par3, par4);
        ms icon = this.a((aqz)par1BlockFlowerPot, 0);
        float f1 = (float)(l2 >> 16 & 0xFF) / 255.0f;
        float f22 = (float)(l2 >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(l2 & 0xFF) / 255.0f;
        if (bfe.a) {
            f4 = (f1 * 30.0f + f22 * 59.0f + f3 * 11.0f) / 100.0f;
            float f6 = (f1 * 30.0f + f22 * 70.0f) / 100.0f;
            f5 = (f1 * 30.0f + f3 * 70.0f) / 100.0f;
            f1 = f4;
            f22 = f6;
            f3 = f5;
        }
        tessellator.a(f2 * f1, f2 * f22, f2 * f3);
        f4 = 0.1865f;
        this.f((aqz)par1BlockFlowerPot, (float)par2 - 0.5f + f4, par3, par4, icon);
        this.e((aqz)par1BlockFlowerPot, (float)par2 + 0.5f - f4, par3, par4, icon);
        this.d((aqz)par1BlockFlowerPot, par2, par3, (float)par4 - 0.5f + f4, icon);
        this.c((aqz)par1BlockFlowerPot, (double)par2, (double)par3, (float)par4 + 0.5f - f4, icon);
        this.b((aqz)par1BlockFlowerPot, (double)par2, (float)par3 - 0.5f + f4 + 0.1875f, (double)par4, this.b(aqz.A));
        int i1 = this.a.h(par2, par3, par4);
        if (i1 != 0) {
            f5 = 0.0f;
            float f7 = 4.0f;
            float f8 = 0.0f;
            ane blockflower = null;
            switch (i1) {
                case 1: {
                    blockflower = aqz.aj;
                    break;
                }
                case 2: {
                    blockflower = aqz.ai;
                }
                default: {
                    break;
                }
                case 7: {
                    blockflower = aqz.al;
                    break;
                }
                case 8: {
                    blockflower = aqz.ak;
                }
            }
            tessellator.c(f5 / 16.0f, f7 / 16.0f, f8 / 16.0f);
            if (blockflower != null) {
                this.b(blockflower, par2, par3, par4);
            } else if (i1 == 9) {
                this.f = true;
                float f9 = 0.125f;
                this.a(0.5f - f9, 0.0, (double)(0.5f - f9), (double)(0.5f + f9), 0.25, (double)(0.5f + f9));
                this.p(aqz.ba, par2, par3, par4);
                this.a(0.5f - f9, 0.25, (double)(0.5f - f9), (double)(0.5f + f9), 0.5, (double)(0.5f + f9));
                this.p(aqz.ba, par2, par3, par4);
                this.a(0.5f - f9, 0.5, (double)(0.5f - f9), (double)(0.5f + f9), 0.75, (double)(0.5f + f9));
                this.p(aqz.ba, par2, par3, par4);
                this.f = false;
                this.a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
            } else if (i1 == 3) {
                this.a(aqz.D, 0, (double)par2, (double)par3, (double)par4, 0.75f);
            } else if (i1 == 5) {
                this.a(aqz.D, 2, (double)par2, (double)par3, (double)par4, 0.75f);
            } else if (i1 == 4) {
                this.a(aqz.D, 1, (double)par2, (double)par3, (double)par4, 0.75f);
            } else if (i1 == 6) {
                this.a(aqz.D, 3, (double)par2, (double)par3, (double)par4, 0.75f);
            } else if (i1 == 11) {
                l2 = aqz.ac.c(this.a, par2, par3, par4);
                f1 = (float)(l2 >> 16 & 0xFF) / 255.0f;
                f22 = (float)(l2 >> 8 & 0xFF) / 255.0f;
                f3 = (float)(l2 & 0xFF) / 255.0f;
                tessellator.a(f2 * f1, f2 * f22, f2 * f3);
                this.a((aqz)aqz.ac, 2, (double)par2, (double)par3, (double)par4, 0.75f);
            } else if (i1 == 10) {
                this.a((aqz)aqz.ad, 2, (double)par2, (double)par3, (double)par4, 0.75f);
            }
            tessellator.c(-f5 / 16.0f, -f7 / 16.0f, -f8 / 16.0f);
        }
        return true;
    }

    public boolean a(amv par1BlockAnvil, int par2, int par3, int par4) {
        return this.a(par1BlockAnvil, par2, par3, par4, this.a.h(par2, par3, par4));
    }

    public boolean a(amv par1BlockAnvil, int par2, int par3, int par4, int par5) {
        bfq tessellator = bfq.a;
        tessellator.c(par1BlockAnvil.e(this.a, par2, par3, par4));
        float f2 = 1.0f;
        int i1 = par1BlockAnvil.c(this.a, par2, par3, par4);
        float f1 = (float)(i1 >> 16 & 0xFF) / 255.0f;
        float f22 = (float)(i1 >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(i1 & 0xFF) / 255.0f;
        if (bfe.a) {
            float f4 = (f1 * 30.0f + f22 * 59.0f + f3 * 11.0f) / 100.0f;
            float f5 = (f1 * 30.0f + f22 * 70.0f) / 100.0f;
            float f6 = (f1 * 30.0f + f3 * 70.0f) / 100.0f;
            f1 = f4;
            f22 = f5;
            f3 = f6;
        }
        tessellator.a(f2 * f1, f2 * f22, f2 * f3);
        return this.a(par1BlockAnvil, par2, par3, par4, par5, false);
    }

    public boolean a(amv par1BlockAnvil, int par2, int par3, int par4, int par5, boolean par6) {
        int i1 = par6 ? 0 : par5 & 3;
        boolean flag1 = false;
        float f2 = 0.0f;
        switch (i1) {
            case 0: {
                this.r = 2;
                this.s = 1;
                this.t = 3;
                this.u = 3;
                break;
            }
            case 1: {
                this.p = 1;
                this.q = 2;
                this.t = 2;
                this.u = 1;
                flag1 = true;
                break;
            }
            case 2: {
                this.r = 1;
                this.s = 2;
                break;
            }
            case 3: {
                this.p = 2;
                this.q = 1;
                this.t = 1;
                this.u = 2;
                flag1 = true;
            }
        }
        f2 = this.a(par1BlockAnvil, par2, par3, par4, 0, f2, 0.75f, 0.25f, 0.75f, flag1, par6, par5);
        f2 = this.a(par1BlockAnvil, par2, par3, par4, 1, f2, 0.5f, 0.0625f, 0.625f, flag1, par6, par5);
        f2 = this.a(par1BlockAnvil, par2, par3, par4, 2, f2, 0.25f, 0.3125f, 0.5f, flag1, par6, par5);
        this.a(par1BlockAnvil, par2, par3, par4, 3, f2, 0.625f, 0.375f, 1.0f, flag1, par6, par5);
        this.a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        return true;
    }

    public float a(amv par1BlockAnvil, int par2, int par3, int par4, int par5, float par6, float par7, float par8, float par9, boolean par10, boolean par11, int par12) {
        if (par10) {
            float f4 = par7;
            par7 = par9;
            par9 = f4;
        }
        par1BlockAnvil.b = par5;
        this.a(0.5f - (par7 /= 2.0f), par6, (double)(0.5f - (par9 /= 2.0f)), (double)(0.5f + par7), (double)(par6 + par8), (double)(0.5f + par9));
        if (par11) {
            bfq tessellator = bfq.a;
            tessellator.b();
            tessellator.b(0.0f, -1.0f, 0.0f);
            this.a((aqz)par1BlockAnvil, 0.0, 0.0, 0.0, this.a((aqz)par1BlockAnvil, 0, par12));
            tessellator.a();
            tessellator.b();
            tessellator.b(0.0f, 1.0f, 0.0f);
            this.b((aqz)par1BlockAnvil, 0.0, 0.0, 0.0, this.a((aqz)par1BlockAnvil, 1, par12));
            tessellator.a();
            tessellator.b();
            tessellator.b(0.0f, 0.0f, -1.0f);
            this.c((aqz)par1BlockAnvil, 0.0, 0.0, 0.0, this.a((aqz)par1BlockAnvil, 2, par12));
            tessellator.a();
            tessellator.b();
            tessellator.b(0.0f, 0.0f, 1.0f);
            this.d((aqz)par1BlockAnvil, 0.0, 0.0, 0.0, this.a((aqz)par1BlockAnvil, 3, par12));
            tessellator.a();
            tessellator.b();
            tessellator.b(-1.0f, 0.0f, 0.0f);
            this.e((aqz)par1BlockAnvil, 0.0, 0.0, 0.0, this.a((aqz)par1BlockAnvil, 4, par12));
            tessellator.a();
            tessellator.b();
            tessellator.b(1.0f, 0.0f, 0.0f);
            this.f((aqz)par1BlockAnvil, 0.0, 0.0, 0.0, this.a((aqz)par1BlockAnvil, 5, par12));
            tessellator.a();
        } else {
            this.p((aqz)par1BlockAnvil, par2, par3, par4);
        }
        return par6 + par8;
    }

    public boolean c(aqz par1Block, int par2, int par3, int par4) {
        int l2 = this.a.h(par2, par3, par4);
        bfq tessellator = bfq.a;
        tessellator.c(par1Block.e(this.a, par2, par3, par4));
        tessellator.a(1.0f, 1.0f, 1.0f);
        double d0 = 0.4f;
        double d1 = 0.5 - d0;
        double d2 = 0.2f;
        if (l2 == 1) {
            this.a(par1Block, (double)par2 - d1, (double)par3 + d2, (double)par4, -d0, 0.0, 0);
        } else if (l2 == 2) {
            this.a(par1Block, (double)par2 + d1, (double)par3 + d2, (double)par4, d0, 0.0, 0);
        } else if (l2 == 3) {
            this.a(par1Block, (double)par2, (double)par3 + d2, (double)par4 - d1, 0.0, -d0, 0);
        } else if (l2 == 4) {
            this.a(par1Block, (double)par2, (double)par3 + d2, (double)par4 + d1, 0.0, d0, 0);
        } else {
            this.a(par1Block, (double)par2, (double)par3, (double)par4, 0.0, 0.0, 0);
        }
        return true;
    }

    public boolean a(aqf par1BlockRedstoneRepeater, int par2, int par3, int par4) {
        int l2 = this.a.h(par2, par3, par4);
        int i1 = l2 & 3;
        int j1 = (l2 & 0xC) >> 2;
        bfq tessellator = bfq.a;
        tessellator.c(par1BlockRedstoneRepeater.e(this.a, par2, par3, par4));
        tessellator.a(1.0f, 1.0f, 1.0f);
        double d0 = -0.1875;
        boolean flag = par1BlockRedstoneRepeater.e(this.a, par2, par3, par4, l2);
        double d1 = 0.0;
        double d2 = 0.0;
        double d3 = 0.0;
        double d4 = 0.0;
        switch (i1) {
            case 0: {
                d4 = -0.3125;
                d2 = aqf.b[j1];
                break;
            }
            case 1: {
                d3 = 0.3125;
                d1 = -aqf.b[j1];
                break;
            }
            case 2: {
                d4 = 0.3125;
                d2 = -aqf.b[j1];
                break;
            }
            case 3: {
                d3 = -0.3125;
                d1 = aqf.b[j1];
            }
        }
        if (!flag) {
            this.a((aqz)par1BlockRedstoneRepeater, (double)par2 + d1, (double)par3 + d0, (double)par4 + d2, 0.0, 0.0, 0);
        } else {
            ms icon = this.b(aqz.E);
            this.a(icon);
            float f2 = 2.0f;
            float f1 = 14.0f;
            float f22 = 7.0f;
            float f3 = 9.0f;
            switch (i1) {
                case 1: 
                case 3: {
                    f2 = 7.0f;
                    f1 = 9.0f;
                    f22 = 2.0f;
                    f3 = 14.0f;
                }
            }
            this.a(f2 / 16.0f + (float)d1, 0.125, (double)(f22 / 16.0f + (float)d2), (double)(f1 / 16.0f + (float)d1), 0.25, (double)(f3 / 16.0f + (float)d2));
            double d5 = icon.a((double)f2);
            double d6 = icon.b((double)f22);
            double d7 = icon.a((double)f1);
            double d8 = icon.b((double)f3);
            tessellator.a((double)((float)par2 + f2 / 16.0f) + d1, (float)par3 + 0.25f, (double)((float)par4 + f22 / 16.0f) + d2, d5, d6);
            tessellator.a((double)((float)par2 + f2 / 16.0f) + d1, (float)par3 + 0.25f, (double)((float)par4 + f3 / 16.0f) + d2, d5, d8);
            tessellator.a((double)((float)par2 + f1 / 16.0f) + d1, (float)par3 + 0.25f, (double)((float)par4 + f3 / 16.0f) + d2, d7, d8);
            tessellator.a((double)((float)par2 + f1 / 16.0f) + d1, (float)par3 + 0.25f, (double)((float)par4 + f22 / 16.0f) + d2, d7, d6);
            this.p((aqz)par1BlockRedstoneRepeater, par2, par3, par4);
            this.a(0.0, 0.0, 0.0, 1.0, 0.125, 1.0);
            this.a();
        }
        tessellator.c(par1BlockRedstoneRepeater.e(this.a, par2, par3, par4));
        tessellator.a(1.0f, 1.0f, 1.0f);
        this.a((aqz)par1BlockRedstoneRepeater, (double)par2 + d3, (double)par3 + d0, (double)par4 + d4, 0.0, 0.0, 0);
        this.a((anv)par1BlockRedstoneRepeater, par2, par3, par4);
        return true;
    }

    public boolean a(anp par1BlockComparator, int par2, int par3, int par4) {
        ms icon;
        bfq tessellator = bfq.a;
        tessellator.c(par1BlockComparator.e(this.a, par2, par3, par4));
        tessellator.a(1.0f, 1.0f, 1.0f);
        int l2 = this.a.h(par2, par3, par4);
        int i1 = l2 & 3;
        double d0 = 0.0;
        double d1 = -0.1875;
        double d2 = 0.0;
        double d3 = 0.0;
        double d4 = 0.0;
        if (par1BlockComparator.d(l2)) {
            icon = aqz.aV.m(0);
        } else {
            d1 -= 0.1875;
            icon = aqz.aU.m(0);
        }
        switch (i1) {
            case 0: {
                d2 = -0.3125;
                d4 = 1.0;
                break;
            }
            case 1: {
                d0 = 0.3125;
                d3 = -1.0;
                break;
            }
            case 2: {
                d2 = 0.3125;
                d4 = -1.0;
                break;
            }
            case 3: {
                d0 = -0.3125;
                d3 = 1.0;
            }
        }
        this.a((aqz)par1BlockComparator, (double)par2 + 0.25 * d3 + 0.1875 * d4, (float)par3 - 0.1875f, (double)par4 + 0.25 * d4 + 0.1875 * d3, 0.0, 0.0, l2);
        this.a((aqz)par1BlockComparator, (double)par2 + 0.25 * d3 + -0.1875 * d4, (float)par3 - 0.1875f, (double)par4 + 0.25 * d4 + -0.1875 * d3, 0.0, 0.0, l2);
        this.a(icon);
        this.a((aqz)par1BlockComparator, (double)par2 + d0, (double)par3 + d1, (double)par4 + d2, 0.0, 0.0, l2);
        this.a();
        this.a((anv)par1BlockComparator, par2, par3, par4, i1);
        return true;
    }

    public boolean a(anv par1BlockRedstoneLogic, int par2, int par3, int par4) {
        bfq tessellator = bfq.a;
        this.a(par1BlockRedstoneLogic, par2, par3, par4, this.a.h(par2, par3, par4) & 3);
        return true;
    }

    public void a(anv par1BlockRedstoneLogic, int par2, int par3, int par4, int par5) {
        this.p((aqz)par1BlockRedstoneLogic, par2, par3, par4);
        bfq tessellator = bfq.a;
        tessellator.c(par1BlockRedstoneLogic.e(this.a, par2, par3, par4));
        tessellator.a(1.0f, 1.0f, 1.0f);
        int i1 = this.a.h(par2, par3, par4);
        ms icon = this.a((aqz)par1BlockRedstoneLogic, 1, i1);
        double d0 = icon.c();
        double d1 = icon.d();
        double d2 = icon.e();
        double d3 = icon.f();
        double d4 = 0.125;
        double d5 = par2 + 1;
        double d6 = par2 + 1;
        double d7 = par2 + 0;
        double d8 = par2 + 0;
        double d9 = par4 + 0;
        double d10 = par4 + 1;
        double d11 = par4 + 1;
        double d12 = par4 + 0;
        double d13 = (double)par3 + d4;
        if (par5 == 2) {
            d5 = d6 = (double)(par2 + 0);
            d7 = d8 = (double)(par2 + 1);
            d9 = d12 = (double)(par4 + 1);
            d10 = d11 = (double)(par4 + 0);
        } else if (par5 == 3) {
            d5 = d8 = (double)(par2 + 0);
            d6 = d7 = (double)(par2 + 1);
            d9 = d10 = (double)(par4 + 0);
            d11 = d12 = (double)(par4 + 1);
        } else if (par5 == 1) {
            d5 = d8 = (double)(par2 + 1);
            d6 = d7 = (double)(par2 + 0);
            d9 = d10 = (double)(par4 + 1);
            d11 = d12 = (double)(par4 + 0);
        }
        tessellator.a(d8, d13, d12, d0, d2);
        tessellator.a(d7, d13, d11, d0, d3);
        tessellator.a(d6, d13, d10, d1, d3);
        tessellator.a(d5, d13, d9, d1, d2);
    }

    public void d(aqz par1Block, int par2, int par3, int par4) {
        this.f = true;
        this.b(par1Block, par2, par3, par4, true);
        this.f = false;
    }

    public boolean b(aqz par1Block, int par2, int par3, int par4, boolean par5) {
        int l2 = this.a.h(par2, par3, par4);
        boolean flag1 = par5 || (l2 & 8) != 0;
        int i1 = ast.d((int)l2);
        float f2 = 0.25f;
        if (flag1) {
            switch (i1) {
                case 0: {
                    this.p = 3;
                    this.q = 3;
                    this.r = 3;
                    this.s = 3;
                    this.a(0.0, 0.25, 0.0, 1.0, 1.0, 1.0);
                    break;
                }
                case 1: {
                    this.a(0.0, 0.0, 0.0, 1.0, 0.75, 1.0);
                    break;
                }
                case 2: {
                    this.r = 1;
                    this.s = 2;
                    this.a(0.0, 0.0, 0.25, 1.0, 1.0, 1.0);
                    break;
                }
                case 3: {
                    this.r = 2;
                    this.s = 1;
                    this.t = 3;
                    this.u = 3;
                    this.a(0.0, 0.0, 0.0, 1.0, 1.0, 0.75);
                    break;
                }
                case 4: {
                    this.p = 1;
                    this.q = 2;
                    this.t = 2;
                    this.u = 1;
                    this.a(0.25, 0.0, 0.0, 1.0, 1.0, 1.0);
                    break;
                }
                case 5: {
                    this.p = 2;
                    this.q = 1;
                    this.t = 1;
                    this.u = 2;
                    this.a(0.0, 0.0, 0.0, 0.75, 1.0, 1.0);
                }
            }
            ((ast)par1Block).b((float)this.g, (float)this.i, (float)this.k, (float)this.h, (float)this.j, (float)this.l);
            this.p(par1Block, par2, par3, par4);
            this.p = 0;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = 0;
            this.a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
            ((ast)par1Block).b((float)this.g, (float)this.i, (float)this.k, (float)this.h, (float)this.j, (float)this.l);
        } else {
            switch (i1) {
                case 0: {
                    this.p = 3;
                    this.q = 3;
                    this.r = 3;
                    this.s = 3;
                }
                default: {
                    break;
                }
                case 2: {
                    this.r = 1;
                    this.s = 2;
                    break;
                }
                case 3: {
                    this.r = 2;
                    this.s = 1;
                    this.t = 3;
                    this.u = 3;
                    break;
                }
                case 4: {
                    this.p = 1;
                    this.q = 2;
                    this.t = 2;
                    this.u = 1;
                    break;
                }
                case 5: {
                    this.p = 2;
                    this.q = 1;
                    this.t = 1;
                    this.u = 2;
                }
            }
            this.p(par1Block, par2, par3, par4);
            this.p = 0;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = 0;
        }
        return true;
    }

    public void a(double par1, double par3, double par5, double par7, double par9, double par11, float par13, double par14) {
        ms icon = ast.b((String)"piston_side");
        if (this.b()) {
            icon = this.d;
        }
        bfq tessellator = bfq.a;
        double d7 = icon.c();
        double d8 = icon.e();
        double d9 = icon.a(par14);
        double d10 = icon.b(4.0);
        tessellator.a(par13, par13, par13);
        tessellator.a(par1, par7, par9, d9, d8);
        tessellator.a(par1, par5, par9, d7, d8);
        tessellator.a(par3, par5, par11, d7, d10);
        tessellator.a(par3, par7, par11, d9, d10);
    }

    public void b(double par1, double par3, double par5, double par7, double par9, double par11, float par13, double par14) {
        ms icon = ast.b((String)"piston_side");
        if (this.b()) {
            icon = this.d;
        }
        bfq tessellator = bfq.a;
        double d7 = icon.c();
        double d8 = icon.e();
        double d9 = icon.a(par14);
        double d10 = icon.b(4.0);
        tessellator.a(par13, par13, par13);
        tessellator.a(par1, par5, par11, d9, d8);
        tessellator.a(par1, par5, par9, d7, d8);
        tessellator.a(par3, par7, par9, d7, d10);
        tessellator.a(par3, par7, par11, d9, d10);
    }

    public void c(double par1, double par3, double par5, double par7, double par9, double par11, float par13, double par14) {
        ms icon = ast.b((String)"piston_side");
        if (this.b()) {
            icon = this.d;
        }
        bfq tessellator = bfq.a;
        double d7 = icon.c();
        double d8 = icon.e();
        double d9 = icon.a(par14);
        double d10 = icon.b(4.0);
        tessellator.a(par13, par13, par13);
        tessellator.a(par3, par5, par9, d9, d8);
        tessellator.a(par1, par5, par9, d7, d8);
        tessellator.a(par1, par7, par11, d7, d10);
        tessellator.a(par3, par7, par11, d9, d10);
    }

    public void a(aqz par1Block, int par2, int par3, int par4, boolean par5) {
        this.f = true;
        this.c(par1Block, par2, par3, par4, par5);
        this.f = false;
    }

    public boolean c(aqz par1Block, int par2, int par3, int par4, boolean par5) {
        int l2 = this.a.h(par2, par3, par4);
        int i1 = asu.d((int)l2);
        float f2 = 0.25f;
        float f1 = 0.375f;
        float f22 = 0.625f;
        float f3 = par1Block.f(this.a, par2, par3, par4);
        float f4 = par5 ? 1.0f : 0.5f;
        double d0 = par5 ? 16.0 : 8.0;
        switch (i1) {
            case 0: {
                this.p = 3;
                this.q = 3;
                this.r = 3;
                this.s = 3;
                this.a(0.0, 0.0, 0.0, 1.0, 0.25, 1.0);
                this.p(par1Block, par2, par3, par4);
                this.a((float)par2 + 0.375f, (float)par2 + 0.625f, (float)par3 + 0.25f, (float)par3 + 0.25f + f4, (double)((float)par4 + 0.625f), (double)((float)par4 + 0.625f), f3 * 0.8f, d0);
                this.a((float)par2 + 0.625f, (float)par2 + 0.375f, (float)par3 + 0.25f, (float)par3 + 0.25f + f4, (double)((float)par4 + 0.375f), (double)((float)par4 + 0.375f), f3 * 0.8f, d0);
                this.a((float)par2 + 0.375f, (float)par2 + 0.375f, (float)par3 + 0.25f, (float)par3 + 0.25f + f4, (double)((float)par4 + 0.375f), (double)((float)par4 + 0.625f), f3 * 0.6f, d0);
                this.a((float)par2 + 0.625f, (float)par2 + 0.625f, (float)par3 + 0.25f, (float)par3 + 0.25f + f4, (double)((float)par4 + 0.625f), (double)((float)par4 + 0.375f), f3 * 0.6f, d0);
                break;
            }
            case 1: {
                this.a(0.0, 0.75, 0.0, 1.0, 1.0, 1.0);
                this.p(par1Block, par2, par3, par4);
                this.a((float)par2 + 0.375f, (float)par2 + 0.625f, (float)par3 - 0.25f + 1.0f - f4, (float)par3 - 0.25f + 1.0f, (double)((float)par4 + 0.625f), (double)((float)par4 + 0.625f), f3 * 0.8f, d0);
                this.a((float)par2 + 0.625f, (float)par2 + 0.375f, (float)par3 - 0.25f + 1.0f - f4, (float)par3 - 0.25f + 1.0f, (double)((float)par4 + 0.375f), (double)((float)par4 + 0.375f), f3 * 0.8f, d0);
                this.a((float)par2 + 0.375f, (float)par2 + 0.375f, (float)par3 - 0.25f + 1.0f - f4, (float)par3 - 0.25f + 1.0f, (double)((float)par4 + 0.375f), (double)((float)par4 + 0.625f), f3 * 0.6f, d0);
                this.a((float)par2 + 0.625f, (float)par2 + 0.625f, (float)par3 - 0.25f + 1.0f - f4, (float)par3 - 0.25f + 1.0f, (double)((float)par4 + 0.625f), (double)((float)par4 + 0.375f), f3 * 0.6f, d0);
                break;
            }
            case 2: {
                this.r = 1;
                this.s = 2;
                this.a(0.0, 0.0, 0.0, 1.0, 1.0, 0.25);
                this.p(par1Block, par2, par3, par4);
                this.b((float)par2 + 0.375f, (float)par2 + 0.375f, (float)par3 + 0.625f, (float)par3 + 0.375f, (float)par4 + 0.25f, (float)par4 + 0.25f + f4, f3 * 0.6f, d0);
                this.b((float)par2 + 0.625f, (float)par2 + 0.625f, (float)par3 + 0.375f, (float)par3 + 0.625f, (float)par4 + 0.25f, (float)par4 + 0.25f + f4, f3 * 0.6f, d0);
                this.b((float)par2 + 0.375f, (float)par2 + 0.625f, (float)par3 + 0.375f, (float)par3 + 0.375f, (float)par4 + 0.25f, (float)par4 + 0.25f + f4, f3 * 0.5f, d0);
                this.b((float)par2 + 0.625f, (float)par2 + 0.375f, (float)par3 + 0.625f, (float)par3 + 0.625f, (float)par4 + 0.25f, (float)par4 + 0.25f + f4, f3, d0);
                break;
            }
            case 3: {
                this.r = 2;
                this.s = 1;
                this.t = 3;
                this.u = 3;
                this.a(0.0, 0.0, 0.75, 1.0, 1.0, 1.0);
                this.p(par1Block, par2, par3, par4);
                this.b((float)par2 + 0.375f, (float)par2 + 0.375f, (float)par3 + 0.625f, (float)par3 + 0.375f, (float)par4 - 0.25f + 1.0f - f4, (float)par4 - 0.25f + 1.0f, f3 * 0.6f, d0);
                this.b((float)par2 + 0.625f, (float)par2 + 0.625f, (float)par3 + 0.375f, (float)par3 + 0.625f, (float)par4 - 0.25f + 1.0f - f4, (float)par4 - 0.25f + 1.0f, f3 * 0.6f, d0);
                this.b((float)par2 + 0.375f, (float)par2 + 0.625f, (float)par3 + 0.375f, (float)par3 + 0.375f, (float)par4 - 0.25f + 1.0f - f4, (float)par4 - 0.25f + 1.0f, f3 * 0.5f, d0);
                this.b((float)par2 + 0.625f, (float)par2 + 0.375f, (float)par3 + 0.625f, (float)par3 + 0.625f, (float)par4 - 0.25f + 1.0f - f4, (float)par4 - 0.25f + 1.0f, f3, d0);
                break;
            }
            case 4: {
                this.p = 1;
                this.q = 2;
                this.t = 2;
                this.u = 1;
                this.a(0.0, 0.0, 0.0, 0.25, 1.0, 1.0);
                this.p(par1Block, par2, par3, par4);
                this.c((float)par2 + 0.25f, (float)par2 + 0.25f + f4, (float)par3 + 0.375f, (float)par3 + 0.375f, (float)par4 + 0.625f, (float)par4 + 0.375f, f3 * 0.5f, d0);
                this.c((float)par2 + 0.25f, (float)par2 + 0.25f + f4, (float)par3 + 0.625f, (float)par3 + 0.625f, (float)par4 + 0.375f, (float)par4 + 0.625f, f3, d0);
                this.c((float)par2 + 0.25f, (float)par2 + 0.25f + f4, (float)par3 + 0.375f, (float)par3 + 0.625f, (float)par4 + 0.375f, (float)par4 + 0.375f, f3 * 0.6f, d0);
                this.c((float)par2 + 0.25f, (float)par2 + 0.25f + f4, (float)par3 + 0.625f, (float)par3 + 0.375f, (float)par4 + 0.625f, (float)par4 + 0.625f, f3 * 0.6f, d0);
                break;
            }
            case 5: {
                this.p = 2;
                this.q = 1;
                this.t = 1;
                this.u = 2;
                this.a(0.75, 0.0, 0.0, 1.0, 1.0, 1.0);
                this.p(par1Block, par2, par3, par4);
                this.c((float)par2 - 0.25f + 1.0f - f4, (float)par2 - 0.25f + 1.0f, (float)par3 + 0.375f, (float)par3 + 0.375f, (float)par4 + 0.625f, (float)par4 + 0.375f, f3 * 0.5f, d0);
                this.c((float)par2 - 0.25f + 1.0f - f4, (float)par2 - 0.25f + 1.0f, (float)par3 + 0.625f, (float)par3 + 0.625f, (float)par4 + 0.375f, (float)par4 + 0.625f, f3, d0);
                this.c((float)par2 - 0.25f + 1.0f - f4, (float)par2 - 0.25f + 1.0f, (float)par3 + 0.375f, (float)par3 + 0.625f, (float)par4 + 0.375f, (float)par4 + 0.375f, f3 * 0.6f, d0);
                this.c((float)par2 - 0.25f + 1.0f - f4, (float)par2 - 0.25f + 1.0f, (float)par3 + 0.625f, (float)par3 + 0.375f, (float)par4 + 0.625f, (float)par4 + 0.625f, f3 * 0.6f, d0);
            }
        }
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
        return true;
    }

    public boolean e(aqz par1Block, int par2, int par3, int par4) {
        int l2 = this.a.h(par2, par3, par4);
        int i1 = l2 & 7;
        boolean flag = (l2 & 8) > 0;
        bfq tessellator = bfq.a;
        boolean flag1 = this.b();
        if (!flag1) {
            this.a(this.b(aqz.B));
        }
        float f2 = 0.25f;
        float f1 = 0.1875f;
        float f22 = 0.1875f;
        if (i1 == 5) {
            this.a(0.5f - f1, 0.0, (double)(0.5f - f2), (double)(0.5f + f1), (double)f22, (double)(0.5f + f2));
        } else if (i1 == 6) {
            this.a(0.5f - f2, 0.0, (double)(0.5f - f1), (double)(0.5f + f2), (double)f22, (double)(0.5f + f1));
        } else if (i1 == 4) {
            this.a(0.5f - f1, 0.5f - f2, (double)(1.0f - f22), (double)(0.5f + f1), (double)(0.5f + f2), 1.0);
        } else if (i1 == 3) {
            this.a(0.5f - f1, 0.5f - f2, 0.0, (double)(0.5f + f1), (double)(0.5f + f2), (double)f22);
        } else if (i1 == 2) {
            this.a(1.0f - f22, 0.5f - f2, (double)(0.5f - f1), 1.0, (double)(0.5f + f2), (double)(0.5f + f1));
        } else if (i1 == 1) {
            this.a(0.0, 0.5f - f2, (double)(0.5f - f1), (double)f22, (double)(0.5f + f2), (double)(0.5f + f1));
        } else if (i1 == 0) {
            this.a(0.5f - f2, 1.0f - f22, (double)(0.5f - f1), (double)(0.5f + f2), 1.0, (double)(0.5f + f1));
        } else if (i1 == 7) {
            this.a(0.5f - f1, 1.0f - f22, (double)(0.5f - f2), (double)(0.5f + f1), 1.0, (double)(0.5f + f2));
        }
        this.p(par1Block, par2, par3, par4);
        if (!flag1) {
            this.a();
        }
        tessellator.c(par1Block.e(this.a, par2, par3, par4));
        float f3 = 1.0f;
        if (aqz.w[par1Block.cF] > 0) {
            f3 = 1.0f;
        }
        tessellator.a(f3, f3, f3);
        ms icon = this.a(par1Block, 0);
        if (this.b()) {
            icon = this.d;
        }
        double d0 = icon.c();
        double d1 = icon.e();
        double d2 = icon.d();
        double d3 = icon.f();
        atc[] avec3 = new atc[8];
        float f4 = 0.0625f;
        float f5 = 0.0625f;
        float f6 = 0.625f;
        avec3[0] = this.a.V().a((double)(-f4), 0.0, (double)(-f5));
        avec3[1] = this.a.V().a((double)f4, 0.0, (double)(-f5));
        avec3[2] = this.a.V().a((double)f4, 0.0, (double)f5);
        avec3[3] = this.a.V().a((double)(-f4), 0.0, (double)f5);
        avec3[4] = this.a.V().a((double)(-f4), (double)f6, (double)(-f5));
        avec3[5] = this.a.V().a((double)f4, (double)f6, (double)(-f5));
        avec3[6] = this.a.V().a((double)f4, (double)f6, (double)f5);
        avec3[7] = this.a.V().a((double)(-f4), (double)f6, (double)f5);
        for (int j1 = 0; j1 < 8; ++j1) {
            if (flag) {
                avec3[j1].e -= 0.0625;
                avec3[j1].a(0.69813174f);
            } else {
                avec3[j1].e += 0.0625;
                avec3[j1].a(-0.69813174f);
            }
            if (i1 == 0 || i1 == 7) {
                avec3[j1].c((float)Math.PI);
            }
            if (i1 == 6 || i1 == 0) {
                avec3[j1].b(1.5707964f);
            }
            if (i1 > 0 && i1 < 5) {
                avec3[j1].d -= 0.375;
                avec3[j1].a(1.5707964f);
                if (i1 == 4) {
                    avec3[j1].b(0.0f);
                }
                if (i1 == 3) {
                    avec3[j1].b((float)Math.PI);
                }
                if (i1 == 2) {
                    avec3[j1].b(1.5707964f);
                }
                if (i1 == 1) {
                    avec3[j1].b(-1.5707964f);
                }
                avec3[j1].c += (double)par2 + 0.5;
                avec3[j1].d += (double)((float)par3 + 0.5f);
                avec3[j1].e += (double)par4 + 0.5;
                continue;
            }
            if (i1 != 0 && i1 != 7) {
                avec3[j1].c += (double)par2 + 0.5;
                avec3[j1].d += (double)((float)par3 + 0.125f);
                avec3[j1].e += (double)par4 + 0.5;
                continue;
            }
            avec3[j1].c += (double)par2 + 0.5;
            avec3[j1].d += (double)((float)par3 + 0.875f);
            avec3[j1].e += (double)par4 + 0.5;
        }
        atc vec3 = null;
        atc vec31 = null;
        atc vec32 = null;
        atc vec33 = null;
        for (int k1 = 0; k1 < 6; ++k1) {
            if (k1 == 0) {
                d0 = icon.a(7.0);
                d1 = icon.b(6.0);
                d2 = icon.a(9.0);
                d3 = icon.b(8.0);
            } else if (k1 == 2) {
                d0 = icon.a(7.0);
                d1 = icon.b(6.0);
                d2 = icon.a(9.0);
                d3 = icon.f();
            }
            if (k1 == 0) {
                vec3 = avec3[0];
                vec31 = avec3[1];
                vec32 = avec3[2];
                vec33 = avec3[3];
            } else if (k1 == 1) {
                vec3 = avec3[7];
                vec31 = avec3[6];
                vec32 = avec3[5];
                vec33 = avec3[4];
            } else if (k1 == 2) {
                vec3 = avec3[1];
                vec31 = avec3[0];
                vec32 = avec3[4];
                vec33 = avec3[5];
            } else if (k1 == 3) {
                vec3 = avec3[2];
                vec31 = avec3[1];
                vec32 = avec3[5];
                vec33 = avec3[6];
            } else if (k1 == 4) {
                vec3 = avec3[3];
                vec31 = avec3[2];
                vec32 = avec3[6];
                vec33 = avec3[7];
            } else if (k1 == 5) {
                vec3 = avec3[0];
                vec31 = avec3[3];
                vec32 = avec3[7];
                vec33 = avec3[4];
            }
            tessellator.a(vec3.c, vec3.d, vec3.e, d0, d3);
            tessellator.a(vec31.c, vec31.d, vec31.e, d2, d3);
            tessellator.a(vec32.c, vec32.d, vec32.e, d2, d1);
            tessellator.a(vec33.c, vec33.d, vec33.e, d0, d1);
        }
        return true;
    }

    public boolean f(aqz par1Block, int par2, int par3, int par4) {
        bfq tessellator = bfq.a;
        int l2 = this.a.h(par2, par3, par4);
        int i1 = l2 & 3;
        boolean flag = (l2 & 4) == 4;
        boolean flag1 = (l2 & 8) == 8;
        boolean flag2 = !this.a.w(par2, par3 - 1, par4);
        boolean flag3 = this.b();
        if (!flag3) {
            this.a(this.b(aqz.C));
        }
        float f2 = 0.25f;
        float f1 = 0.125f;
        float f22 = 0.125f;
        float f3 = 0.3f - f2;
        float f4 = 0.3f + f2;
        if (i1 == 2) {
            this.a(0.5f - f1, f3, (double)(1.0f - f22), (double)(0.5f + f1), (double)f4, 1.0);
        } else if (i1 == 0) {
            this.a(0.5f - f1, f3, 0.0, (double)(0.5f + f1), (double)f4, (double)f22);
        } else if (i1 == 1) {
            this.a(1.0f - f22, f3, (double)(0.5f - f1), 1.0, (double)f4, (double)(0.5f + f1));
        } else if (i1 == 3) {
            this.a(0.0, f3, (double)(0.5f - f1), (double)f22, (double)f4, (double)(0.5f + f1));
        }
        this.p(par1Block, par2, par3, par4);
        if (!flag3) {
            this.a();
        }
        tessellator.c(par1Block.e(this.a, par2, par3, par4));
        float f5 = 1.0f;
        if (aqz.w[par1Block.cF] > 0) {
            f5 = 1.0f;
        }
        tessellator.a(f5, f5, f5);
        ms icon = this.a(par1Block, 0);
        if (this.b()) {
            icon = this.d;
        }
        double d0 = icon.c();
        double d1 = icon.e();
        double d2 = icon.d();
        double d3 = icon.f();
        atc[] avec3 = new atc[8];
        float f6 = 0.046875f;
        float f7 = 0.046875f;
        float f8 = 0.3125f;
        avec3[0] = this.a.V().a((double)(-f6), 0.0, (double)(-f7));
        avec3[1] = this.a.V().a((double)f6, 0.0, (double)(-f7));
        avec3[2] = this.a.V().a((double)f6, 0.0, (double)f7);
        avec3[3] = this.a.V().a((double)(-f6), 0.0, (double)f7);
        avec3[4] = this.a.V().a((double)(-f6), (double)f8, (double)(-f7));
        avec3[5] = this.a.V().a((double)f6, (double)f8, (double)(-f7));
        avec3[6] = this.a.V().a((double)f6, (double)f8, (double)f7);
        avec3[7] = this.a.V().a((double)(-f6), (double)f8, (double)f7);
        for (int j1 = 0; j1 < 8; ++j1) {
            avec3[j1].e += 0.0625;
            if (flag1) {
                avec3[j1].a(0.5235988f);
                avec3[j1].d -= 0.4375;
            } else if (flag) {
                avec3[j1].a(0.08726647f);
                avec3[j1].d -= 0.4375;
            } else {
                avec3[j1].a(-0.69813174f);
                avec3[j1].d -= 0.375;
            }
            avec3[j1].a(1.5707964f);
            if (i1 == 2) {
                avec3[j1].b(0.0f);
            }
            if (i1 == 0) {
                avec3[j1].b((float)Math.PI);
            }
            if (i1 == 1) {
                avec3[j1].b(1.5707964f);
            }
            if (i1 == 3) {
                avec3[j1].b(-1.5707964f);
            }
            avec3[j1].c += (double)par2 + 0.5;
            avec3[j1].d += (double)((float)par3 + 0.3125f);
            avec3[j1].e += (double)par4 + 0.5;
        }
        atc vec3 = null;
        atc vec31 = null;
        atc vec32 = null;
        atc vec33 = null;
        int b0 = 7;
        int b1 = 9;
        int b2 = 9;
        int b3 = 16;
        for (int k1 = 0; k1 < 6; ++k1) {
            if (k1 == 0) {
                vec3 = avec3[0];
                vec31 = avec3[1];
                vec32 = avec3[2];
                vec33 = avec3[3];
                d0 = icon.a((double)b0);
                d1 = icon.b((double)b2);
                d2 = icon.a((double)b1);
                d3 = icon.b((double)(b2 + 2));
            } else if (k1 == 1) {
                vec3 = avec3[7];
                vec31 = avec3[6];
                vec32 = avec3[5];
                vec33 = avec3[4];
            } else if (k1 == 2) {
                vec3 = avec3[1];
                vec31 = avec3[0];
                vec32 = avec3[4];
                vec33 = avec3[5];
                d0 = icon.a((double)b0);
                d1 = icon.b((double)b2);
                d2 = icon.a((double)b1);
                d3 = icon.b((double)b3);
            } else if (k1 == 3) {
                vec3 = avec3[2];
                vec31 = avec3[1];
                vec32 = avec3[5];
                vec33 = avec3[6];
            } else if (k1 == 4) {
                vec3 = avec3[3];
                vec31 = avec3[2];
                vec32 = avec3[6];
                vec33 = avec3[7];
            } else if (k1 == 5) {
                vec3 = avec3[0];
                vec31 = avec3[3];
                vec32 = avec3[7];
                vec33 = avec3[4];
            }
            tessellator.a(vec3.c, vec3.d, vec3.e, d0, d3);
            tessellator.a(vec31.c, vec31.d, vec31.e, d2, d3);
            tessellator.a(vec32.c, vec32.d, vec32.e, d2, d1);
            tessellator.a(vec33.c, vec33.d, vec33.e, d0, d1);
        }
        float f9 = 0.09375f;
        float f10 = 0.09375f;
        float f11 = 0.03125f;
        avec3[0] = this.a.V().a((double)(-f9), 0.0, (double)(-f10));
        avec3[1] = this.a.V().a((double)f9, 0.0, (double)(-f10));
        avec3[2] = this.a.V().a((double)f9, 0.0, (double)f10);
        avec3[3] = this.a.V().a((double)(-f9), 0.0, (double)f10);
        avec3[4] = this.a.V().a((double)(-f9), (double)f11, (double)(-f10));
        avec3[5] = this.a.V().a((double)f9, (double)f11, (double)(-f10));
        avec3[6] = this.a.V().a((double)f9, (double)f11, (double)f10);
        avec3[7] = this.a.V().a((double)(-f9), (double)f11, (double)f10);
        for (int l1 = 0; l1 < 8; ++l1) {
            avec3[l1].e += 0.21875;
            if (flag1) {
                avec3[l1].d -= 0.09375;
                avec3[l1].e -= 0.1625;
                avec3[l1].a(0.0f);
            } else if (flag) {
                avec3[l1].d += 0.015625;
                avec3[l1].e -= 0.171875;
                avec3[l1].a(0.17453294f);
            } else {
                avec3[l1].a(0.87266463f);
            }
            if (i1 == 2) {
                avec3[l1].b(0.0f);
            }
            if (i1 == 0) {
                avec3[l1].b((float)Math.PI);
            }
            if (i1 == 1) {
                avec3[l1].b(1.5707964f);
            }
            if (i1 == 3) {
                avec3[l1].b(-1.5707964f);
            }
            avec3[l1].c += (double)par2 + 0.5;
            avec3[l1].d += (double)((float)par3 + 0.3125f);
            avec3[l1].e += (double)par4 + 0.5;
        }
        int b4 = 5;
        int b5 = 11;
        int b6 = 3;
        int b7 = 9;
        for (int i2 = 0; i2 < 6; ++i2) {
            if (i2 == 0) {
                vec3 = avec3[0];
                vec31 = avec3[1];
                vec32 = avec3[2];
                vec33 = avec3[3];
                d0 = icon.a((double)b4);
                d1 = icon.b((double)b6);
                d2 = icon.a((double)b5);
                d3 = icon.b((double)b7);
            } else if (i2 == 1) {
                vec3 = avec3[7];
                vec31 = avec3[6];
                vec32 = avec3[5];
                vec33 = avec3[4];
            } else if (i2 == 2) {
                vec3 = avec3[1];
                vec31 = avec3[0];
                vec32 = avec3[4];
                vec33 = avec3[5];
                d0 = icon.a((double)b4);
                d1 = icon.b((double)b6);
                d2 = icon.a((double)b5);
                d3 = icon.b((double)(b6 + 2));
            } else if (i2 == 3) {
                vec3 = avec3[2];
                vec31 = avec3[1];
                vec32 = avec3[5];
                vec33 = avec3[6];
            } else if (i2 == 4) {
                vec3 = avec3[3];
                vec31 = avec3[2];
                vec32 = avec3[6];
                vec33 = avec3[7];
            } else if (i2 == 5) {
                vec3 = avec3[0];
                vec31 = avec3[3];
                vec32 = avec3[7];
                vec33 = avec3[4];
            }
            tessellator.a(vec3.c, vec3.d, vec3.e, d0, d3);
            tessellator.a(vec31.c, vec31.d, vec31.e, d2, d3);
            tessellator.a(vec32.c, vec32.d, vec32.e, d2, d1);
            tessellator.a(vec33.c, vec33.d, vec33.e, d0, d1);
        }
        if (flag) {
            double d4 = avec3[0].d;
            float f12 = 0.03125f;
            float f13 = 0.5f - f12 / 2.0f;
            float f14 = f13 + f12;
            ms icon1 = this.b(aqz.bZ);
            double d5 = icon.c();
            double d6 = icon.b(flag ? 2.0 : 0.0);
            double d7 = icon.d();
            double d8 = icon.b(flag ? 4.0 : 2.0);
            double d9 = (double)(flag2 ? 3.5f : 1.5f) / 16.0;
            f5 = par1Block.f(this.a, par2, par3, par4) * 0.75f;
            tessellator.a(f5, f5, f5);
            if (i1 == 2) {
                tessellator.a((float)par2 + f13, (double)par3 + d9, (double)par4 + 0.25, d5, d6);
                tessellator.a((float)par2 + f14, (double)par3 + d9, (double)par4 + 0.25, d5, d8);
                tessellator.a((float)par2 + f14, (double)par3 + d9, par4, d7, d8);
                tessellator.a((float)par2 + f13, (double)par3 + d9, par4, d7, d6);
                tessellator.a((float)par2 + f13, d4, (double)par4 + 0.5, d5, d6);
                tessellator.a((float)par2 + f14, d4, (double)par4 + 0.5, d5, d8);
                tessellator.a((float)par2 + f14, (double)par3 + d9, (double)par4 + 0.25, d7, d8);
                tessellator.a((float)par2 + f13, (double)par3 + d9, (double)par4 + 0.25, d7, d6);
            } else if (i1 == 0) {
                tessellator.a((float)par2 + f13, (double)par3 + d9, (double)par4 + 0.75, d5, d6);
                tessellator.a((float)par2 + f14, (double)par3 + d9, (double)par4 + 0.75, d5, d8);
                tessellator.a((float)par2 + f14, d4, (double)par4 + 0.5, d7, d8);
                tessellator.a((float)par2 + f13, d4, (double)par4 + 0.5, d7, d6);
                tessellator.a((float)par2 + f13, (double)par3 + d9, par4 + 1, d5, d6);
                tessellator.a((float)par2 + f14, (double)par3 + d9, par4 + 1, d5, d8);
                tessellator.a((float)par2 + f14, (double)par3 + d9, (double)par4 + 0.75, d7, d8);
                tessellator.a((float)par2 + f13, (double)par3 + d9, (double)par4 + 0.75, d7, d6);
            } else if (i1 == 1) {
                tessellator.a(par2, (double)par3 + d9, (float)par4 + f14, d5, d8);
                tessellator.a((double)par2 + 0.25, (double)par3 + d9, (float)par4 + f14, d7, d8);
                tessellator.a((double)par2 + 0.25, (double)par3 + d9, (float)par4 + f13, d7, d6);
                tessellator.a(par2, (double)par3 + d9, (float)par4 + f13, d5, d6);
                tessellator.a((double)par2 + 0.25, (double)par3 + d9, (float)par4 + f14, d5, d8);
                tessellator.a((double)par2 + 0.5, d4, (float)par4 + f14, d7, d8);
                tessellator.a((double)par2 + 0.5, d4, (float)par4 + f13, d7, d6);
                tessellator.a((double)par2 + 0.25, (double)par3 + d9, (float)par4 + f13, d5, d6);
            } else {
                tessellator.a((double)par2 + 0.5, d4, (float)par4 + f14, d5, d8);
                tessellator.a((double)par2 + 0.75, (double)par3 + d9, (float)par4 + f14, d7, d8);
                tessellator.a((double)par2 + 0.75, (double)par3 + d9, (float)par4 + f13, d7, d6);
                tessellator.a((double)par2 + 0.5, d4, (float)par4 + f13, d5, d6);
                tessellator.a((double)par2 + 0.75, (double)par3 + d9, (float)par4 + f14, d5, d8);
                tessellator.a(par2 + 1, (double)par3 + d9, (float)par4 + f14, d7, d8);
                tessellator.a(par2 + 1, (double)par3 + d9, (float)par4 + f13, d7, d6);
                tessellator.a((double)par2 + 0.75, (double)par3 + d9, (float)par4 + f13, d5, d6);
            }
        }
        return true;
    }

    public boolean g(aqz par1Block, int par2, int par3, int par4) {
        boolean flag1;
        bfq tessellator = bfq.a;
        ms icon = this.a(par1Block, 0);
        int l2 = this.a.h(par2, par3, par4);
        boolean flag = (l2 & 4) == 4;
        boolean bl2 = flag1 = (l2 & 2) == 2;
        if (this.b()) {
            icon = this.d;
        }
        tessellator.c(par1Block.e(this.a, par2, par3, par4));
        float f2 = par1Block.f(this.a, par2, par3, par4) * 0.75f;
        tessellator.a(f2, f2, f2);
        double d0 = icon.c();
        double d1 = icon.b(flag ? 2.0 : 0.0);
        double d2 = icon.d();
        double d3 = icon.b(flag ? 4.0 : 2.0);
        double d4 = (double)(flag1 ? 3.5f : 1.5f) / 16.0;
        boolean flag2 = arl.a((acf)this.a, (int)par2, (int)par3, (int)par4, (int)l2, (int)1);
        boolean flag3 = arl.a((acf)this.a, (int)par2, (int)par3, (int)par4, (int)l2, (int)3);
        boolean flag4 = arl.a((acf)this.a, (int)par2, (int)par3, (int)par4, (int)l2, (int)2);
        boolean flag5 = arl.a((acf)this.a, (int)par2, (int)par3, (int)par4, (int)l2, (int)0);
        float f1 = 0.03125f;
        float f22 = 0.5f - f1 / 2.0f;
        float f3 = f22 + f1;
        if (!(flag4 || flag3 || flag5 || flag2)) {
            flag4 = true;
            flag5 = true;
        }
        if (flag4) {
            tessellator.a((float)par2 + f22, (double)par3 + d4, (double)par4 + 0.25, d0, d1);
            tessellator.a((float)par2 + f3, (double)par3 + d4, (double)par4 + 0.25, d0, d3);
            tessellator.a((float)par2 + f3, (double)par3 + d4, par4, d2, d3);
            tessellator.a((float)par2 + f22, (double)par3 + d4, par4, d2, d1);
            tessellator.a((float)par2 + f22, (double)par3 + d4, par4, d2, d1);
            tessellator.a((float)par2 + f3, (double)par3 + d4, par4, d2, d3);
            tessellator.a((float)par2 + f3, (double)par3 + d4, (double)par4 + 0.25, d0, d3);
            tessellator.a((float)par2 + f22, (double)par3 + d4, (double)par4 + 0.25, d0, d1);
        }
        if (flag4 || flag5 && !flag3 && !flag2) {
            tessellator.a((float)par2 + f22, (double)par3 + d4, (double)par4 + 0.5, d0, d1);
            tessellator.a((float)par2 + f3, (double)par3 + d4, (double)par4 + 0.5, d0, d3);
            tessellator.a((float)par2 + f3, (double)par3 + d4, (double)par4 + 0.25, d2, d3);
            tessellator.a((float)par2 + f22, (double)par3 + d4, (double)par4 + 0.25, d2, d1);
            tessellator.a((float)par2 + f22, (double)par3 + d4, (double)par4 + 0.25, d2, d1);
            tessellator.a((float)par2 + f3, (double)par3 + d4, (double)par4 + 0.25, d2, d3);
            tessellator.a((float)par2 + f3, (double)par3 + d4, (double)par4 + 0.5, d0, d3);
            tessellator.a((float)par2 + f22, (double)par3 + d4, (double)par4 + 0.5, d0, d1);
        }
        if (flag5 || flag4 && !flag3 && !flag2) {
            tessellator.a((float)par2 + f22, (double)par3 + d4, (double)par4 + 0.75, d0, d1);
            tessellator.a((float)par2 + f3, (double)par3 + d4, (double)par4 + 0.75, d0, d3);
            tessellator.a((float)par2 + f3, (double)par3 + d4, (double)par4 + 0.5, d2, d3);
            tessellator.a((float)par2 + f22, (double)par3 + d4, (double)par4 + 0.5, d2, d1);
            tessellator.a((float)par2 + f22, (double)par3 + d4, (double)par4 + 0.5, d2, d1);
            tessellator.a((float)par2 + f3, (double)par3 + d4, (double)par4 + 0.5, d2, d3);
            tessellator.a((float)par2 + f3, (double)par3 + d4, (double)par4 + 0.75, d0, d3);
            tessellator.a((float)par2 + f22, (double)par3 + d4, (double)par4 + 0.75, d0, d1);
        }
        if (flag5) {
            tessellator.a((float)par2 + f22, (double)par3 + d4, par4 + 1, d0, d1);
            tessellator.a((float)par2 + f3, (double)par3 + d4, par4 + 1, d0, d3);
            tessellator.a((float)par2 + f3, (double)par3 + d4, (double)par4 + 0.75, d2, d3);
            tessellator.a((float)par2 + f22, (double)par3 + d4, (double)par4 + 0.75, d2, d1);
            tessellator.a((float)par2 + f22, (double)par3 + d4, (double)par4 + 0.75, d2, d1);
            tessellator.a((float)par2 + f3, (double)par3 + d4, (double)par4 + 0.75, d2, d3);
            tessellator.a((float)par2 + f3, (double)par3 + d4, par4 + 1, d0, d3);
            tessellator.a((float)par2 + f22, (double)par3 + d4, par4 + 1, d0, d1);
        }
        if (flag2) {
            tessellator.a(par2, (double)par3 + d4, (float)par4 + f3, d0, d3);
            tessellator.a((double)par2 + 0.25, (double)par3 + d4, (float)par4 + f3, d2, d3);
            tessellator.a((double)par2 + 0.25, (double)par3 + d4, (float)par4 + f22, d2, d1);
            tessellator.a(par2, (double)par3 + d4, (float)par4 + f22, d0, d1);
            tessellator.a(par2, (double)par3 + d4, (float)par4 + f22, d0, d1);
            tessellator.a((double)par2 + 0.25, (double)par3 + d4, (float)par4 + f22, d2, d1);
            tessellator.a((double)par2 + 0.25, (double)par3 + d4, (float)par4 + f3, d2, d3);
            tessellator.a(par2, (double)par3 + d4, (float)par4 + f3, d0, d3);
        }
        if (flag2 || flag3 && !flag4 && !flag5) {
            tessellator.a((double)par2 + 0.25, (double)par3 + d4, (float)par4 + f3, d0, d3);
            tessellator.a((double)par2 + 0.5, (double)par3 + d4, (float)par4 + f3, d2, d3);
            tessellator.a((double)par2 + 0.5, (double)par3 + d4, (float)par4 + f22, d2, d1);
            tessellator.a((double)par2 + 0.25, (double)par3 + d4, (float)par4 + f22, d0, d1);
            tessellator.a((double)par2 + 0.25, (double)par3 + d4, (float)par4 + f22, d0, d1);
            tessellator.a((double)par2 + 0.5, (double)par3 + d4, (float)par4 + f22, d2, d1);
            tessellator.a((double)par2 + 0.5, (double)par3 + d4, (float)par4 + f3, d2, d3);
            tessellator.a((double)par2 + 0.25, (double)par3 + d4, (float)par4 + f3, d0, d3);
        }
        if (flag3 || flag2 && !flag4 && !flag5) {
            tessellator.a((double)par2 + 0.5, (double)par3 + d4, (float)par4 + f3, d0, d3);
            tessellator.a((double)par2 + 0.75, (double)par3 + d4, (float)par4 + f3, d2, d3);
            tessellator.a((double)par2 + 0.75, (double)par3 + d4, (float)par4 + f22, d2, d1);
            tessellator.a((double)par2 + 0.5, (double)par3 + d4, (float)par4 + f22, d0, d1);
            tessellator.a((double)par2 + 0.5, (double)par3 + d4, (float)par4 + f22, d0, d1);
            tessellator.a((double)par2 + 0.75, (double)par3 + d4, (float)par4 + f22, d2, d1);
            tessellator.a((double)par2 + 0.75, (double)par3 + d4, (float)par4 + f3, d2, d3);
            tessellator.a((double)par2 + 0.5, (double)par3 + d4, (float)par4 + f3, d0, d3);
        }
        if (flag3) {
            tessellator.a((double)par2 + 0.75, (double)par3 + d4, (float)par4 + f3, d0, d3);
            tessellator.a(par2 + 1, (double)par3 + d4, (float)par4 + f3, d2, d3);
            tessellator.a(par2 + 1, (double)par3 + d4, (float)par4 + f22, d2, d1);
            tessellator.a((double)par2 + 0.75, (double)par3 + d4, (float)par4 + f22, d0, d1);
            tessellator.a((double)par2 + 0.75, (double)par3 + d4, (float)par4 + f22, d0, d1);
            tessellator.a(par2 + 1, (double)par3 + d4, (float)par4 + f22, d2, d1);
            tessellator.a(par2 + 1, (double)par3 + d4, (float)par4 + f3, d2, d3);
            tessellator.a((double)par2 + 0.75, (double)par3 + d4, (float)par4 + f3, d0, d3);
        }
        return true;
    }

    public boolean a(aoi par1BlockFire, int par2, int par3, int par4) {
        bfq tessellator = bfq.a;
        ms icon = par1BlockFire.c(0);
        ms icon1 = par1BlockFire.c(1);
        ms icon2 = icon;
        if (this.b()) {
            icon2 = this.d;
        }
        tessellator.a(1.0f, 1.0f, 1.0f);
        tessellator.c(par1BlockFire.e(this.a, par2, par3, par4));
        double d0 = icon2.c();
        double d1 = icon2.e();
        double d2 = icon2.d();
        double d3 = icon2.f();
        float f2 = 1.4f;
        if (!this.a.w(par2, par3 - 1, par4) && !aqz.aw.canBlockCatchFire(this.a, par2, par3 - 1, par4, ForgeDirection.UP)) {
            double d5;
            float f1 = 0.2f;
            float f22 = 0.0625f;
            if ((par2 + par3 + par4 & 1) == 1) {
                d0 = icon1.c();
                d1 = icon1.e();
                d2 = icon1.d();
                d3 = icon1.f();
            }
            if ((par2 / 2 + par3 / 2 + par4 / 2 & 1) == 1) {
                d5 = d2;
                d2 = d0;
                d0 = d5;
            }
            if (aqz.aw.canBlockCatchFire(this.a, par2 - 1, par3, par4, ForgeDirection.EAST)) {
                tessellator.a((float)par2 + f1, (float)par3 + f2 + f22, par4 + 1, d2, d1);
                tessellator.a(par2 + 0, (float)(par3 + 0) + f22, par4 + 1, d2, d3);
                tessellator.a(par2 + 0, (float)(par3 + 0) + f22, par4 + 0, d0, d3);
                tessellator.a((float)par2 + f1, (float)par3 + f2 + f22, par4 + 0, d0, d1);
                tessellator.a((float)par2 + f1, (float)par3 + f2 + f22, par4 + 0, d0, d1);
                tessellator.a(par2 + 0, (float)(par3 + 0) + f22, par4 + 0, d0, d3);
                tessellator.a(par2 + 0, (float)(par3 + 0) + f22, par4 + 1, d2, d3);
                tessellator.a((float)par2 + f1, (float)par3 + f2 + f22, par4 + 1, d2, d1);
            }
            if (aqz.aw.canBlockCatchFire(this.a, par2 + 1, par3, par4, ForgeDirection.WEST)) {
                tessellator.a((float)(par2 + 1) - f1, (float)par3 + f2 + f22, par4 + 0, d0, d1);
                tessellator.a(par2 + 1 - 0, (float)(par3 + 0) + f22, par4 + 0, d0, d3);
                tessellator.a(par2 + 1 - 0, (float)(par3 + 0) + f22, par4 + 1, d2, d3);
                tessellator.a((float)(par2 + 1) - f1, (float)par3 + f2 + f22, par4 + 1, d2, d1);
                tessellator.a((float)(par2 + 1) - f1, (float)par3 + f2 + f22, par4 + 1, d2, d1);
                tessellator.a(par2 + 1 - 0, (float)(par3 + 0) + f22, par4 + 1, d2, d3);
                tessellator.a(par2 + 1 - 0, (float)(par3 + 0) + f22, par4 + 0, d0, d3);
                tessellator.a((float)(par2 + 1) - f1, (float)par3 + f2 + f22, par4 + 0, d0, d1);
            }
            if (aqz.aw.canBlockCatchFire(this.a, par2, par3, par4 - 1, ForgeDirection.SOUTH)) {
                tessellator.a(par2 + 0, (float)par3 + f2 + f22, (float)par4 + f1, d2, d1);
                tessellator.a(par2 + 0, (float)(par3 + 0) + f22, par4 + 0, d2, d3);
                tessellator.a(par2 + 1, (float)(par3 + 0) + f22, par4 + 0, d0, d3);
                tessellator.a(par2 + 1, (float)par3 + f2 + f22, (float)par4 + f1, d0, d1);
                tessellator.a(par2 + 1, (float)par3 + f2 + f22, (float)par4 + f1, d0, d1);
                tessellator.a(par2 + 1, (float)(par3 + 0) + f22, par4 + 0, d0, d3);
                tessellator.a(par2 + 0, (float)(par3 + 0) + f22, par4 + 0, d2, d3);
                tessellator.a(par2 + 0, (float)par3 + f2 + f22, (float)par4 + f1, d2, d1);
            }
            if (aqz.aw.canBlockCatchFire(this.a, par2, par3, par4 + 1, ForgeDirection.NORTH)) {
                tessellator.a(par2 + 1, (float)par3 + f2 + f22, (float)(par4 + 1) - f1, d0, d1);
                tessellator.a(par2 + 1, (float)(par3 + 0) + f22, par4 + 1 - 0, d0, d3);
                tessellator.a(par2 + 0, (float)(par3 + 0) + f22, par4 + 1 - 0, d2, d3);
                tessellator.a(par2 + 0, (float)par3 + f2 + f22, (float)(par4 + 1) - f1, d2, d1);
                tessellator.a(par2 + 0, (float)par3 + f2 + f22, (float)(par4 + 1) - f1, d2, d1);
                tessellator.a(par2 + 0, (float)(par3 + 0) + f22, par4 + 1 - 0, d2, d3);
                tessellator.a(par2 + 1, (float)(par3 + 0) + f22, par4 + 1 - 0, d0, d3);
                tessellator.a(par2 + 1, (float)par3 + f2 + f22, (float)(par4 + 1) - f1, d0, d1);
            }
            if (aqz.aw.canBlockCatchFire(this.a, par2, par3 + 1, par4, ForgeDirection.DOWN)) {
                d5 = (double)par2 + 0.5 + 0.5;
                double d6 = (double)par2 + 0.5 - 0.5;
                double d7 = (double)par4 + 0.5 + 0.5;
                double d8 = (double)par4 + 0.5 - 0.5;
                double d9 = (double)par2 + 0.5 - 0.5;
                double d10 = (double)par2 + 0.5 + 0.5;
                double d4 = (double)par4 + 0.5 - 0.5;
                double d11 = (double)par4 + 0.5 + 0.5;
                d0 = icon.c();
                d1 = icon.e();
                d2 = icon.d();
                d3 = icon.f();
                f2 = -0.2f;
                if ((par2 + ++par3 + par4 & 1) == 0) {
                    tessellator.a(d9, (float)par3 + f2, par4 + 0, d2, d1);
                    tessellator.a(d5, par3 + 0, par4 + 0, d2, d3);
                    tessellator.a(d5, par3 + 0, par4 + 1, d0, d3);
                    tessellator.a(d9, (float)par3 + f2, par4 + 1, d0, d1);
                    d0 = icon1.c();
                    d1 = icon1.e();
                    d2 = icon1.d();
                    d3 = icon1.f();
                    tessellator.a(d10, (float)par3 + f2, par4 + 1, d2, d1);
                    tessellator.a(d6, par3 + 0, par4 + 1, d2, d3);
                    tessellator.a(d6, par3 + 0, par4 + 0, d0, d3);
                    tessellator.a(d10, (float)par3 + f2, par4 + 0, d0, d1);
                } else {
                    tessellator.a(par2 + 0, (float)par3 + f2, d11, d2, d1);
                    tessellator.a(par2 + 0, par3 + 0, d8, d2, d3);
                    tessellator.a(par2 + 1, par3 + 0, d8, d0, d3);
                    tessellator.a(par2 + 1, (float)par3 + f2, d11, d0, d1);
                    d0 = icon1.c();
                    d1 = icon1.e();
                    d2 = icon1.d();
                    d3 = icon1.f();
                    tessellator.a(par2 + 1, (float)par3 + f2, d4, d2, d1);
                    tessellator.a(par2 + 1, par3 + 0, d7, d2, d3);
                    tessellator.a(par2 + 0, par3 + 0, d7, d0, d3);
                    tessellator.a(par2 + 0, (float)par3 + f2, d4, d0, d1);
                }
            }
        } else {
            double d12 = (double)par2 + 0.5 + 0.2;
            double d5 = (double)par2 + 0.5 - 0.2;
            double d6 = (double)par4 + 0.5 + 0.2;
            double d7 = (double)par4 + 0.5 - 0.2;
            double d8 = (double)par2 + 0.5 - 0.3;
            double d9 = (double)par2 + 0.5 + 0.3;
            double d10 = (double)par4 + 0.5 - 0.3;
            double d4 = (double)par4 + 0.5 + 0.3;
            tessellator.a(d8, (float)par3 + f2, par4 + 1, d2, d1);
            tessellator.a(d12, par3 + 0, par4 + 1, d2, d3);
            tessellator.a(d12, par3 + 0, par4 + 0, d0, d3);
            tessellator.a(d8, (float)par3 + f2, par4 + 0, d0, d1);
            tessellator.a(d9, (float)par3 + f2, par4 + 0, d2, d1);
            tessellator.a(d5, par3 + 0, par4 + 0, d2, d3);
            tessellator.a(d5, par3 + 0, par4 + 1, d0, d3);
            tessellator.a(d9, (float)par3 + f2, par4 + 1, d0, d1);
            d0 = icon1.c();
            d1 = icon1.e();
            d2 = icon1.d();
            d3 = icon1.f();
            tessellator.a(par2 + 1, (float)par3 + f2, d4, d2, d1);
            tessellator.a(par2 + 1, par3 + 0, d7, d2, d3);
            tessellator.a(par2 + 0, par3 + 0, d7, d0, d3);
            tessellator.a(par2 + 0, (float)par3 + f2, d4, d0, d1);
            tessellator.a(par2 + 0, (float)par3 + f2, d10, d2, d1);
            tessellator.a(par2 + 0, par3 + 0, d6, d2, d3);
            tessellator.a(par2 + 1, par3 + 0, d6, d0, d3);
            tessellator.a(par2 + 1, (float)par3 + f2, d10, d0, d1);
            d12 = (double)par2 + 0.5 - 0.5;
            d5 = (double)par2 + 0.5 + 0.5;
            d6 = (double)par4 + 0.5 - 0.5;
            d7 = (double)par4 + 0.5 + 0.5;
            d8 = (double)par2 + 0.5 - 0.4;
            d9 = (double)par2 + 0.5 + 0.4;
            d10 = (double)par4 + 0.5 - 0.4;
            d4 = (double)par4 + 0.5 + 0.4;
            tessellator.a(d8, (float)par3 + f2, par4 + 0, d0, d1);
            tessellator.a(d12, par3 + 0, par4 + 0, d0, d3);
            tessellator.a(d12, par3 + 0, par4 + 1, d2, d3);
            tessellator.a(d8, (float)par3 + f2, par4 + 1, d2, d1);
            tessellator.a(d9, (float)par3 + f2, par4 + 1, d0, d1);
            tessellator.a(d5, par3 + 0, par4 + 1, d0, d3);
            tessellator.a(d5, par3 + 0, par4 + 0, d2, d3);
            tessellator.a(d9, (float)par3 + f2, par4 + 0, d2, d1);
            d0 = icon.c();
            d1 = icon.e();
            d2 = icon.d();
            d3 = icon.f();
            tessellator.a(par2 + 0, (float)par3 + f2, d4, d0, d1);
            tessellator.a(par2 + 0, par3 + 0, d7, d0, d3);
            tessellator.a(par2 + 1, par3 + 0, d7, d2, d3);
            tessellator.a(par2 + 1, (float)par3 + f2, d4, d2, d1);
            tessellator.a(par2 + 1, (float)par3 + f2, d10, d0, d1);
            tessellator.a(par2 + 1, par3 + 0, d6, d0, d3);
            tessellator.a(par2 + 0, par3 + 0, d6, d2, d3);
            tessellator.a(par2 + 0, (float)par3 + f2, d10, d2, d1);
        }
        return true;
    }

    public boolean h(aqz par1Block, int par2, int par3, int par4) {
        boolean flag3;
        bfq tessellator = bfq.a;
        int l2 = this.a.h(par2, par3, par4);
        ms icon = aqb.b("cross");
        ms icon1 = aqb.b("line");
        ms icon2 = aqb.b("cross_overlay");
        ms icon3 = aqb.b("line_overlay");
        tessellator.c(par1Block.e(this.a, par2, par3, par4));
        float f2 = 1.0f;
        float f1 = (float)l2 / 15.0f;
        float f22 = f1 * 0.6f + 0.4f;
        if (l2 == 0) {
            f22 = 0.3f;
        }
        float f3 = f1 * f1 * 0.7f - 0.5f;
        float f4 = f1 * f1 * 0.6f - 0.7f;
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        if (f4 < 0.0f) {
            f4 = 0.0f;
        }
        tessellator.a(f22, f3, f4);
        double d0 = 0.015625;
        double d1 = 0.015625;
        boolean flag = aqb.f(this.a, par2 - 1, par3, par4, 1) || !this.a.u(par2 - 1, par3, par4) && aqb.f(this.a, par2 - 1, par3 - 1, par4, -1);
        boolean flag1 = aqb.f(this.a, par2 + 1, par3, par4, 3) || !this.a.u(par2 + 1, par3, par4) && aqb.f(this.a, par2 + 1, par3 - 1, par4, -1);
        boolean flag2 = aqb.f(this.a, par2, par3, par4 - 1, 2) || !this.a.u(par2, par3, par4 - 1) && aqb.f(this.a, par2, par3 - 1, par4 - 1, -1);
        boolean bl2 = flag3 = aqb.f(this.a, par2, par3, par4 + 1, 0) || !this.a.u(par2, par3, par4 + 1) && aqb.f(this.a, par2, par3 - 1, par4 + 1, -1);
        if (!this.a.u(par2, par3 + 1, par4)) {
            if (this.a.u(par2 - 1, par3, par4) && aqb.f(this.a, par2 - 1, par3 + 1, par4, -1)) {
                flag = true;
            }
            if (this.a.u(par2 + 1, par3, par4) && aqb.f(this.a, par2 + 1, par3 + 1, par4, -1)) {
                flag1 = true;
            }
            if (this.a.u(par2, par3, par4 - 1) && aqb.f(this.a, par2, par3 + 1, par4 - 1, -1)) {
                flag2 = true;
            }
            if (this.a.u(par2, par3, par4 + 1) && aqb.f(this.a, par2, par3 + 1, par4 + 1, -1)) {
                flag3 = true;
            }
        }
        float f5 = par2 + 0;
        float f6 = par2 + 1;
        float f7 = par4 + 0;
        float f8 = par4 + 1;
        int i1 = 0;
        if ((flag || flag1) && !flag2 && !flag3) {
            i1 = 1;
        }
        if ((flag2 || flag3) && !flag1 && !flag) {
            i1 = 2;
        }
        if (i1 == 0) {
            int j1 = 0;
            int k1 = 0;
            int l1 = 16;
            int i2 = 16;
            boolean flag4 = true;
            if (!flag) {
                f5 += 0.3125f;
            }
            if (!flag) {
                j1 += 5;
            }
            if (!flag1) {
                f6 -= 0.3125f;
            }
            if (!flag1) {
                l1 -= 5;
            }
            if (!flag2) {
                f7 += 0.3125f;
            }
            if (!flag2) {
                k1 += 5;
            }
            if (!flag3) {
                f8 -= 0.3125f;
            }
            if (!flag3) {
                i2 -= 5;
            }
            tessellator.a(f6, (double)par3 + 0.015625, f8, icon.a((double)l1), icon.b((double)i2));
            tessellator.a(f6, (double)par3 + 0.015625, f7, icon.a((double)l1), icon.b((double)k1));
            tessellator.a(f5, (double)par3 + 0.015625, f7, icon.a((double)j1), icon.b((double)k1));
            tessellator.a(f5, (double)par3 + 0.015625, f8, icon.a((double)j1), icon.b((double)i2));
            tessellator.a(f2, f2, f2);
            tessellator.a(f6, (double)par3 + 0.015625, f8, icon2.a((double)l1), icon2.b((double)i2));
            tessellator.a(f6, (double)par3 + 0.015625, f7, icon2.a((double)l1), icon2.b((double)k1));
            tessellator.a(f5, (double)par3 + 0.015625, f7, icon2.a((double)j1), icon2.b((double)k1));
            tessellator.a(f5, (double)par3 + 0.015625, f8, icon2.a((double)j1), icon2.b((double)i2));
        } else if (i1 == 1) {
            tessellator.a(f6, (double)par3 + 0.015625, f8, icon1.d(), icon1.f());
            tessellator.a(f6, (double)par3 + 0.015625, f7, icon1.d(), icon1.e());
            tessellator.a(f5, (double)par3 + 0.015625, f7, icon1.c(), icon1.e());
            tessellator.a(f5, (double)par3 + 0.015625, f8, icon1.c(), icon1.f());
            tessellator.a(f2, f2, f2);
            tessellator.a(f6, (double)par3 + 0.015625, f8, icon3.d(), icon3.f());
            tessellator.a(f6, (double)par3 + 0.015625, f7, icon3.d(), icon3.e());
            tessellator.a(f5, (double)par3 + 0.015625, f7, icon3.c(), icon3.e());
            tessellator.a(f5, (double)par3 + 0.015625, f8, icon3.c(), icon3.f());
        } else {
            tessellator.a(f6, (double)par3 + 0.015625, f8, icon1.d(), icon1.f());
            tessellator.a(f6, (double)par3 + 0.015625, f7, icon1.c(), icon1.f());
            tessellator.a(f5, (double)par3 + 0.015625, f7, icon1.c(), icon1.e());
            tessellator.a(f5, (double)par3 + 0.015625, f8, icon1.d(), icon1.e());
            tessellator.a(f2, f2, f2);
            tessellator.a(f6, (double)par3 + 0.015625, f8, icon3.d(), icon3.f());
            tessellator.a(f6, (double)par3 + 0.015625, f7, icon3.c(), icon3.f());
            tessellator.a(f5, (double)par3 + 0.015625, f7, icon3.c(), icon3.e());
            tessellator.a(f5, (double)par3 + 0.015625, f8, icon3.d(), icon3.e());
        }
        if (!this.a.u(par2, par3 + 1, par4)) {
            float f9 = 0.021875f;
            if (this.a.u(par2 - 1, par3, par4) && this.a.a(par2 - 1, par3 + 1, par4) == aqz.aA.cF) {
                tessellator.a(f2 * f22, f2 * f3, f2 * f4);
                tessellator.a((double)par2 + 0.015625, (float)(par3 + 1) + 0.021875f, par4 + 1, icon1.d(), icon1.e());
                tessellator.a((double)par2 + 0.015625, par3 + 0, par4 + 1, icon1.c(), icon1.e());
                tessellator.a((double)par2 + 0.015625, par3 + 0, par4 + 0, icon1.c(), icon1.f());
                tessellator.a((double)par2 + 0.015625, (float)(par3 + 1) + 0.021875f, par4 + 0, icon1.d(), icon1.f());
                tessellator.a(f2, f2, f2);
                tessellator.a((double)par2 + 0.015625, (float)(par3 + 1) + 0.021875f, par4 + 1, icon3.d(), icon3.e());
                tessellator.a((double)par2 + 0.015625, par3 + 0, par4 + 1, icon3.c(), icon3.e());
                tessellator.a((double)par2 + 0.015625, par3 + 0, par4 + 0, icon3.c(), icon3.f());
                tessellator.a((double)par2 + 0.015625, (float)(par3 + 1) + 0.021875f, par4 + 0, icon3.d(), icon3.f());
            }
            if (this.a.u(par2 + 1, par3, par4) && this.a.a(par2 + 1, par3 + 1, par4) == aqz.aA.cF) {
                tessellator.a(f2 * f22, f2 * f3, f2 * f4);
                tessellator.a((double)(par2 + 1) - 0.015625, par3 + 0, par4 + 1, icon1.c(), icon1.f());
                tessellator.a((double)(par2 + 1) - 0.015625, (float)(par3 + 1) + 0.021875f, par4 + 1, icon1.d(), icon1.f());
                tessellator.a((double)(par2 + 1) - 0.015625, (float)(par3 + 1) + 0.021875f, par4 + 0, icon1.d(), icon1.e());
                tessellator.a((double)(par2 + 1) - 0.015625, par3 + 0, par4 + 0, icon1.c(), icon1.e());
                tessellator.a(f2, f2, f2);
                tessellator.a((double)(par2 + 1) - 0.015625, par3 + 0, par4 + 1, icon3.c(), icon3.f());
                tessellator.a((double)(par2 + 1) - 0.015625, (float)(par3 + 1) + 0.021875f, par4 + 1, icon3.d(), icon3.f());
                tessellator.a((double)(par2 + 1) - 0.015625, (float)(par3 + 1) + 0.021875f, par4 + 0, icon3.d(), icon3.e());
                tessellator.a((double)(par2 + 1) - 0.015625, par3 + 0, par4 + 0, icon3.c(), icon3.e());
            }
            if (this.a.u(par2, par3, par4 - 1) && this.a.a(par2, par3 + 1, par4 - 1) == aqz.aA.cF) {
                tessellator.a(f2 * f22, f2 * f3, f2 * f4);
                tessellator.a(par2 + 1, par3 + 0, (double)par4 + 0.015625, icon1.c(), icon1.f());
                tessellator.a(par2 + 1, (float)(par3 + 1) + 0.021875f, (double)par4 + 0.015625, icon1.d(), icon1.f());
                tessellator.a(par2 + 0, (float)(par3 + 1) + 0.021875f, (double)par4 + 0.015625, icon1.d(), icon1.e());
                tessellator.a(par2 + 0, par3 + 0, (double)par4 + 0.015625, icon1.c(), icon1.e());
                tessellator.a(f2, f2, f2);
                tessellator.a(par2 + 1, par3 + 0, (double)par4 + 0.015625, icon3.c(), icon3.f());
                tessellator.a(par2 + 1, (float)(par3 + 1) + 0.021875f, (double)par4 + 0.015625, icon3.d(), icon3.f());
                tessellator.a(par2 + 0, (float)(par3 + 1) + 0.021875f, (double)par4 + 0.015625, icon3.d(), icon3.e());
                tessellator.a(par2 + 0, par3 + 0, (double)par4 + 0.015625, icon3.c(), icon3.e());
            }
            if (this.a.u(par2, par3, par4 + 1) && this.a.a(par2, par3 + 1, par4 + 1) == aqz.aA.cF) {
                tessellator.a(f2 * f22, f2 * f3, f2 * f4);
                tessellator.a(par2 + 1, (float)(par3 + 1) + 0.021875f, (double)(par4 + 1) - 0.015625, icon1.d(), icon1.e());
                tessellator.a(par2 + 1, par3 + 0, (double)(par4 + 1) - 0.015625, icon1.c(), icon1.e());
                tessellator.a(par2 + 0, par3 + 0, (double)(par4 + 1) - 0.015625, icon1.c(), icon1.f());
                tessellator.a(par2 + 0, (float)(par3 + 1) + 0.021875f, (double)(par4 + 1) - 0.015625, icon1.d(), icon1.f());
                tessellator.a(f2, f2, f2);
                tessellator.a(par2 + 1, (float)(par3 + 1) + 0.021875f, (double)(par4 + 1) - 0.015625, icon3.d(), icon3.e());
                tessellator.a(par2 + 1, par3 + 0, (double)(par4 + 1) - 0.015625, icon3.c(), icon3.e());
                tessellator.a(par2 + 0, par3 + 0, (double)(par4 + 1) - 0.015625, icon3.c(), icon3.f());
                tessellator.a(par2 + 0, (float)(par3 + 1) + 0.021875f, (double)(par4 + 1) - 0.015625, icon3.d(), icon3.f());
            }
        }
        return true;
    }

    public boolean a(amy par1BlockRailBase, int par2, int par3, int par4) {
        bfq tessellator = bfq.a;
        int l2 = this.a.h(par2, par3, par4);
        ms icon = this.a((aqz)par1BlockRailBase, 0, l2);
        if (this.b()) {
            icon = this.d;
        }
        if (par1BlockRailBase.e()) {
            l2 &= 7;
        }
        tessellator.c(par1BlockRailBase.e(this.a, par2, par3, par4));
        tessellator.a(1.0f, 1.0f, 1.0f);
        double d0 = icon.c();
        double d1 = icon.e();
        double d2 = icon.d();
        double d3 = icon.f();
        double d4 = 0.0625;
        double d5 = par2 + 1;
        double d6 = par2 + 1;
        double d7 = par2 + 0;
        double d8 = par2 + 0;
        double d9 = par4 + 0;
        double d10 = par4 + 1;
        double d11 = par4 + 1;
        double d12 = par4 + 0;
        double d13 = (double)par3 + d4;
        double d14 = (double)par3 + d4;
        double d15 = (double)par3 + d4;
        double d16 = (double)par3 + d4;
        if (l2 != 1 && l2 != 2 && l2 != 3 && l2 != 7) {
            if (l2 == 8) {
                d5 = d6 = (double)(par2 + 0);
                d7 = d8 = (double)(par2 + 1);
                d9 = d12 = (double)(par4 + 1);
                d10 = d11 = (double)(par4 + 0);
            } else if (l2 == 9) {
                d5 = d8 = (double)(par2 + 0);
                d6 = d7 = (double)(par2 + 1);
                d9 = d10 = (double)(par4 + 0);
                d11 = d12 = (double)(par4 + 1);
            }
        } else {
            d5 = d8 = (double)(par2 + 1);
            d6 = d7 = (double)(par2 + 0);
            d9 = d10 = (double)(par4 + 1);
            d11 = d12 = (double)(par4 + 0);
        }
        if (l2 != 2 && l2 != 4) {
            if (l2 == 3 || l2 == 5) {
                d14 += 1.0;
                d15 += 1.0;
            }
        } else {
            d13 += 1.0;
            d16 += 1.0;
        }
        tessellator.a(d5, d13, d9, d2, d1);
        tessellator.a(d6, d14, d10, d2, d3);
        tessellator.a(d7, d15, d11, d0, d3);
        tessellator.a(d8, d16, d12, d0, d1);
        tessellator.a(d8, d16, d12, d0, d1);
        tessellator.a(d7, d15, d11, d0, d3);
        tessellator.a(d6, d14, d10, d2, d3);
        tessellator.a(d5, d13, d9, d2, d1);
        return true;
    }

    public boolean i(aqz par1Block, int par2, int par3, int par4) {
        bfq tessellator = bfq.a;
        ms icon = this.a(par1Block, 0);
        if (this.b()) {
            icon = this.d;
        }
        tessellator.c(par1Block.e(this.a, par2, par3, par4));
        float f2 = 1.0f;
        tessellator.a(f2, f2, f2);
        double d0 = icon.c();
        double d1 = icon.e();
        double d2 = icon.d();
        double d3 = icon.f();
        int l2 = this.a.h(par2, par3, par4);
        double d4 = 0.0;
        double d5 = 0.05f;
        if (l2 == 5) {
            tessellator.a((double)par2 + d5, (double)(par3 + 1) + d4, (double)(par4 + 1) + d4, d0, d1);
            tessellator.a((double)par2 + d5, (double)(par3 + 0) - d4, (double)(par4 + 1) + d4, d0, d3);
            tessellator.a((double)par2 + d5, (double)(par3 + 0) - d4, (double)(par4 + 0) - d4, d2, d3);
            tessellator.a((double)par2 + d5, (double)(par3 + 1) + d4, (double)(par4 + 0) - d4, d2, d1);
        }
        if (l2 == 4) {
            tessellator.a((double)(par2 + 1) - d5, (double)(par3 + 0) - d4, (double)(par4 + 1) + d4, d2, d3);
            tessellator.a((double)(par2 + 1) - d5, (double)(par3 + 1) + d4, (double)(par4 + 1) + d4, d2, d1);
            tessellator.a((double)(par2 + 1) - d5, (double)(par3 + 1) + d4, (double)(par4 + 0) - d4, d0, d1);
            tessellator.a((double)(par2 + 1) - d5, (double)(par3 + 0) - d4, (double)(par4 + 0) - d4, d0, d3);
        }
        if (l2 == 3) {
            tessellator.a((double)(par2 + 1) + d4, (double)(par3 + 0) - d4, (double)par4 + d5, d2, d3);
            tessellator.a((double)(par2 + 1) + d4, (double)(par3 + 1) + d4, (double)par4 + d5, d2, d1);
            tessellator.a((double)(par2 + 0) - d4, (double)(par3 + 1) + d4, (double)par4 + d5, d0, d1);
            tessellator.a((double)(par2 + 0) - d4, (double)(par3 + 0) - d4, (double)par4 + d5, d0, d3);
        }
        if (l2 == 2) {
            tessellator.a((double)(par2 + 1) + d4, (double)(par3 + 1) + d4, (double)(par4 + 1) - d5, d0, d1);
            tessellator.a((double)(par2 + 1) + d4, (double)(par3 + 0) - d4, (double)(par4 + 1) - d5, d0, d3);
            tessellator.a((double)(par2 + 0) - d4, (double)(par3 + 0) - d4, (double)(par4 + 1) - d5, d2, d3);
            tessellator.a((double)(par2 + 0) - d4, (double)(par3 + 1) + d4, (double)(par4 + 1) - d5, d2, d1);
        }
        return true;
    }

    public boolean j(aqz par1Block, int par2, int par3, int par4) {
        bfq tessellator = bfq.a;
        ms icon = this.a(par1Block, 0);
        if (this.b()) {
            icon = this.d;
        }
        float f2 = 1.0f;
        tessellator.c(par1Block.e(this.a, par2, par3, par4));
        int l2 = par1Block.c(this.a, par2, par3, par4);
        float f1 = (float)(l2 >> 16 & 0xFF) / 255.0f;
        float f22 = (float)(l2 >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(l2 & 0xFF) / 255.0f;
        tessellator.a(f2 * f1, f2 * f22, f2 * f3);
        double d0 = icon.c();
        double d1 = icon.e();
        double d2 = icon.d();
        double d3 = icon.f();
        double d4 = 0.05f;
        int i1 = this.a.h(par2, par3, par4);
        if ((i1 & 2) != 0) {
            tessellator.a((double)par2 + d4, par3 + 1, par4 + 1, d0, d1);
            tessellator.a((double)par2 + d4, par3 + 0, par4 + 1, d0, d3);
            tessellator.a((double)par2 + d4, par3 + 0, par4 + 0, d2, d3);
            tessellator.a((double)par2 + d4, par3 + 1, par4 + 0, d2, d1);
            tessellator.a((double)par2 + d4, par3 + 1, par4 + 0, d2, d1);
            tessellator.a((double)par2 + d4, par3 + 0, par4 + 0, d2, d3);
            tessellator.a((double)par2 + d4, par3 + 0, par4 + 1, d0, d3);
            tessellator.a((double)par2 + d4, par3 + 1, par4 + 1, d0, d1);
        }
        if ((i1 & 8) != 0) {
            tessellator.a((double)(par2 + 1) - d4, par3 + 0, par4 + 1, d2, d3);
            tessellator.a((double)(par2 + 1) - d4, par3 + 1, par4 + 1, d2, d1);
            tessellator.a((double)(par2 + 1) - d4, par3 + 1, par4 + 0, d0, d1);
            tessellator.a((double)(par2 + 1) - d4, par3 + 0, par4 + 0, d0, d3);
            tessellator.a((double)(par2 + 1) - d4, par3 + 0, par4 + 0, d0, d3);
            tessellator.a((double)(par2 + 1) - d4, par3 + 1, par4 + 0, d0, d1);
            tessellator.a((double)(par2 + 1) - d4, par3 + 1, par4 + 1, d2, d1);
            tessellator.a((double)(par2 + 1) - d4, par3 + 0, par4 + 1, d2, d3);
        }
        if ((i1 & 4) != 0) {
            tessellator.a(par2 + 1, par3 + 0, (double)par4 + d4, d2, d3);
            tessellator.a(par2 + 1, par3 + 1, (double)par4 + d4, d2, d1);
            tessellator.a(par2 + 0, par3 + 1, (double)par4 + d4, d0, d1);
            tessellator.a(par2 + 0, par3 + 0, (double)par4 + d4, d0, d3);
            tessellator.a(par2 + 0, par3 + 0, (double)par4 + d4, d0, d3);
            tessellator.a(par2 + 0, par3 + 1, (double)par4 + d4, d0, d1);
            tessellator.a(par2 + 1, par3 + 1, (double)par4 + d4, d2, d1);
            tessellator.a(par2 + 1, par3 + 0, (double)par4 + d4, d2, d3);
        }
        if ((i1 & 1) != 0) {
            tessellator.a(par2 + 1, par3 + 1, (double)(par4 + 1) - d4, d0, d1);
            tessellator.a(par2 + 1, par3 + 0, (double)(par4 + 1) - d4, d0, d3);
            tessellator.a(par2 + 0, par3 + 0, (double)(par4 + 1) - d4, d2, d3);
            tessellator.a(par2 + 0, par3 + 1, (double)(par4 + 1) - d4, d2, d1);
            tessellator.a(par2 + 0, par3 + 1, (double)(par4 + 1) - d4, d2, d1);
            tessellator.a(par2 + 0, par3 + 0, (double)(par4 + 1) - d4, d2, d3);
            tessellator.a(par2 + 1, par3 + 0, (double)(par4 + 1) - d4, d0, d3);
            tessellator.a(par2 + 1, par3 + 1, (double)(par4 + 1) - d4, d0, d1);
        }
        if (this.a.u(par2, par3 + 1, par4)) {
            tessellator.a(par2 + 1, (double)(par3 + 1) - d4, par4 + 0, d0, d1);
            tessellator.a(par2 + 1, (double)(par3 + 1) - d4, par4 + 1, d0, d3);
            tessellator.a(par2 + 0, (double)(par3 + 1) - d4, par4 + 1, d2, d3);
            tessellator.a(par2 + 0, (double)(par3 + 1) - d4, par4 + 0, d2, d1);
        }
        return true;
    }

    public boolean a(aqy par1BlockPane, int par2, int par3, int par4) {
        ms icon1;
        ms icon;
        int l2 = this.a.R();
        bfq tessellator = bfq.a;
        tessellator.c(par1BlockPane.e(this.a, par2, par3, par4));
        float f2 = 1.0f;
        int i1 = par1BlockPane.c(this.a, par2, par3, par4);
        float f1 = (float)(i1 >> 16 & 0xFF) / 255.0f;
        float f22 = (float)(i1 >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(i1 & 0xFF) / 255.0f;
        if (bfe.a) {
            float f4 = (f1 * 30.0f + f22 * 59.0f + f3 * 11.0f) / 100.0f;
            float f5 = (f1 * 30.0f + f22 * 70.0f) / 100.0f;
            float f6 = (f1 * 30.0f + f3 * 70.0f) / 100.0f;
            f1 = f4;
            f22 = f5;
            f3 = f6;
        }
        tessellator.a(f2 * f1, f2 * f22, f2 * f3);
        if (this.b()) {
            icon = this.d;
            icon1 = this.d;
        } else {
            int j1 = this.a.h(par2, par3, par4);
            icon = this.a((aqz)par1BlockPane, 0, j1);
            icon1 = par1BlockPane.q();
        }
        double d0 = icon.c();
        double d1 = icon.a(8.0);
        double d2 = icon.d();
        double d3 = icon.e();
        double d4 = icon.f();
        double d5 = icon1.a(7.0);
        double d6 = icon1.a(9.0);
        double d7 = icon1.e();
        double d8 = icon1.b(8.0);
        double d9 = icon1.f();
        double d10 = par2;
        double d11 = (double)par2 + 0.5;
        double d12 = par2 + 1;
        double d13 = par4;
        double d14 = (double)par4 + 0.5;
        double d15 = par4 + 1;
        double d16 = (double)par2 + 0.5 - 0.0625;
        double d17 = (double)par2 + 0.5 + 0.0625;
        double d18 = (double)par4 + 0.5 - 0.0625;
        double d19 = (double)par4 + 0.5 + 0.0625;
        boolean flag = par1BlockPane.canPaneConnectTo(this.a, par2, par3, par4, ForgeDirection.NORTH);
        boolean flag1 = par1BlockPane.canPaneConnectTo(this.a, par2, par3, par4, ForgeDirection.SOUTH);
        boolean flag2 = par1BlockPane.canPaneConnectTo(this.a, par2, par3, par4, ForgeDirection.WEST);
        boolean flag3 = par1BlockPane.canPaneConnectTo(this.a, par2, par3, par4, ForgeDirection.EAST);
        boolean flag4 = par1BlockPane.a(this.a, par2, par3 + 1, par4, 1);
        boolean flag5 = par1BlockPane.a(this.a, par2, par3 - 1, par4, 0);
        double d20 = 0.01;
        double d21 = 0.005;
        if ((!flag2 || !flag3) && (flag2 || flag3 || flag || flag1)) {
            if (flag2 && !flag3) {
                tessellator.a(d10, par3 + 1, d14, d0, d3);
                tessellator.a(d10, par3 + 0, d14, d0, d4);
                tessellator.a(d11, par3 + 0, d14, d1, d4);
                tessellator.a(d11, par3 + 1, d14, d1, d3);
                tessellator.a(d11, par3 + 1, d14, d0, d3);
                tessellator.a(d11, par3 + 0, d14, d0, d4);
                tessellator.a(d10, par3 + 0, d14, d1, d4);
                tessellator.a(d10, par3 + 1, d14, d1, d3);
                if (!flag1 && !flag) {
                    tessellator.a(d11, par3 + 1, d19, d5, d7);
                    tessellator.a(d11, par3 + 0, d19, d5, d9);
                    tessellator.a(d11, par3 + 0, d18, d6, d9);
                    tessellator.a(d11, par3 + 1, d18, d6, d7);
                    tessellator.a(d11, par3 + 1, d18, d5, d7);
                    tessellator.a(d11, par3 + 0, d18, d5, d9);
                    tessellator.a(d11, par3 + 0, d19, d6, d9);
                    tessellator.a(d11, par3 + 1, d19, d6, d7);
                }
                if (flag4 || par3 < l2 - 1 && this.a.c(par2 - 1, par3 + 1, par4)) {
                    tessellator.a(d10, (double)(par3 + 1) + 0.01, d19, d6, d8);
                    tessellator.a(d11, (double)(par3 + 1) + 0.01, d19, d6, d9);
                    tessellator.a(d11, (double)(par3 + 1) + 0.01, d18, d5, d9);
                    tessellator.a(d10, (double)(par3 + 1) + 0.01, d18, d5, d8);
                    tessellator.a(d11, (double)(par3 + 1) + 0.01, d19, d6, d8);
                    tessellator.a(d10, (double)(par3 + 1) + 0.01, d19, d6, d9);
                    tessellator.a(d10, (double)(par3 + 1) + 0.01, d18, d5, d9);
                    tessellator.a(d11, (double)(par3 + 1) + 0.01, d18, d5, d8);
                }
                if (flag5 || par3 > 1 && this.a.c(par2 - 1, par3 - 1, par4)) {
                    tessellator.a(d10, (double)par3 - 0.01, d19, d6, d8);
                    tessellator.a(d11, (double)par3 - 0.01, d19, d6, d9);
                    tessellator.a(d11, (double)par3 - 0.01, d18, d5, d9);
                    tessellator.a(d10, (double)par3 - 0.01, d18, d5, d8);
                    tessellator.a(d11, (double)par3 - 0.01, d19, d6, d8);
                    tessellator.a(d10, (double)par3 - 0.01, d19, d6, d9);
                    tessellator.a(d10, (double)par3 - 0.01, d18, d5, d9);
                    tessellator.a(d11, (double)par3 - 0.01, d18, d5, d8);
                }
            } else if (!flag2 && flag3) {
                tessellator.a(d11, par3 + 1, d14, d1, d3);
                tessellator.a(d11, par3 + 0, d14, d1, d4);
                tessellator.a(d12, par3 + 0, d14, d2, d4);
                tessellator.a(d12, par3 + 1, d14, d2, d3);
                tessellator.a(d12, par3 + 1, d14, d1, d3);
                tessellator.a(d12, par3 + 0, d14, d1, d4);
                tessellator.a(d11, par3 + 0, d14, d2, d4);
                tessellator.a(d11, par3 + 1, d14, d2, d3);
                if (!flag1 && !flag) {
                    tessellator.a(d11, par3 + 1, d18, d5, d7);
                    tessellator.a(d11, par3 + 0, d18, d5, d9);
                    tessellator.a(d11, par3 + 0, d19, d6, d9);
                    tessellator.a(d11, par3 + 1, d19, d6, d7);
                    tessellator.a(d11, par3 + 1, d19, d5, d7);
                    tessellator.a(d11, par3 + 0, d19, d5, d9);
                    tessellator.a(d11, par3 + 0, d18, d6, d9);
                    tessellator.a(d11, par3 + 1, d18, d6, d7);
                }
                if (flag4 || par3 < l2 - 1 && this.a.c(par2 + 1, par3 + 1, par4)) {
                    tessellator.a(d11, (double)(par3 + 1) + 0.01, d19, d6, d7);
                    tessellator.a(d12, (double)(par3 + 1) + 0.01, d19, d6, d8);
                    tessellator.a(d12, (double)(par3 + 1) + 0.01, d18, d5, d8);
                    tessellator.a(d11, (double)(par3 + 1) + 0.01, d18, d5, d7);
                    tessellator.a(d12, (double)(par3 + 1) + 0.01, d19, d6, d7);
                    tessellator.a(d11, (double)(par3 + 1) + 0.01, d19, d6, d8);
                    tessellator.a(d11, (double)(par3 + 1) + 0.01, d18, d5, d8);
                    tessellator.a(d12, (double)(par3 + 1) + 0.01, d18, d5, d7);
                }
                if (flag5 || par3 > 1 && this.a.c(par2 + 1, par3 - 1, par4)) {
                    tessellator.a(d11, (double)par3 - 0.01, d19, d6, d7);
                    tessellator.a(d12, (double)par3 - 0.01, d19, d6, d8);
                    tessellator.a(d12, (double)par3 - 0.01, d18, d5, d8);
                    tessellator.a(d11, (double)par3 - 0.01, d18, d5, d7);
                    tessellator.a(d12, (double)par3 - 0.01, d19, d6, d7);
                    tessellator.a(d11, (double)par3 - 0.01, d19, d6, d8);
                    tessellator.a(d11, (double)par3 - 0.01, d18, d5, d8);
                    tessellator.a(d12, (double)par3 - 0.01, d18, d5, d7);
                }
            }
        } else {
            tessellator.a(d10, par3 + 1, d14, d0, d3);
            tessellator.a(d10, par3 + 0, d14, d0, d4);
            tessellator.a(d12, par3 + 0, d14, d2, d4);
            tessellator.a(d12, par3 + 1, d14, d2, d3);
            tessellator.a(d12, par3 + 1, d14, d0, d3);
            tessellator.a(d12, par3 + 0, d14, d0, d4);
            tessellator.a(d10, par3 + 0, d14, d2, d4);
            tessellator.a(d10, par3 + 1, d14, d2, d3);
            if (flag4) {
                tessellator.a(d10, (double)(par3 + 1) + 0.01, d19, d6, d9);
                tessellator.a(d12, (double)(par3 + 1) + 0.01, d19, d6, d7);
                tessellator.a(d12, (double)(par3 + 1) + 0.01, d18, d5, d7);
                tessellator.a(d10, (double)(par3 + 1) + 0.01, d18, d5, d9);
                tessellator.a(d12, (double)(par3 + 1) + 0.01, d19, d6, d9);
                tessellator.a(d10, (double)(par3 + 1) + 0.01, d19, d6, d7);
                tessellator.a(d10, (double)(par3 + 1) + 0.01, d18, d5, d7);
                tessellator.a(d12, (double)(par3 + 1) + 0.01, d18, d5, d9);
            } else {
                if (par3 < l2 - 1 && this.a.c(par2 - 1, par3 + 1, par4)) {
                    tessellator.a(d10, (double)(par3 + 1) + 0.01, d19, d6, d8);
                    tessellator.a(d11, (double)(par3 + 1) + 0.01, d19, d6, d9);
                    tessellator.a(d11, (double)(par3 + 1) + 0.01, d18, d5, d9);
                    tessellator.a(d10, (double)(par3 + 1) + 0.01, d18, d5, d8);
                    tessellator.a(d11, (double)(par3 + 1) + 0.01, d19, d6, d8);
                    tessellator.a(d10, (double)(par3 + 1) + 0.01, d19, d6, d9);
                    tessellator.a(d10, (double)(par3 + 1) + 0.01, d18, d5, d9);
                    tessellator.a(d11, (double)(par3 + 1) + 0.01, d18, d5, d8);
                }
                if (par3 < l2 - 1 && this.a.c(par2 + 1, par3 + 1, par4)) {
                    tessellator.a(d11, (double)(par3 + 1) + 0.01, d19, d6, d7);
                    tessellator.a(d12, (double)(par3 + 1) + 0.01, d19, d6, d8);
                    tessellator.a(d12, (double)(par3 + 1) + 0.01, d18, d5, d8);
                    tessellator.a(d11, (double)(par3 + 1) + 0.01, d18, d5, d7);
                    tessellator.a(d12, (double)(par3 + 1) + 0.01, d19, d6, d7);
                    tessellator.a(d11, (double)(par3 + 1) + 0.01, d19, d6, d8);
                    tessellator.a(d11, (double)(par3 + 1) + 0.01, d18, d5, d8);
                    tessellator.a(d12, (double)(par3 + 1) + 0.01, d18, d5, d7);
                }
            }
            if (flag5) {
                tessellator.a(d10, (double)par3 - 0.01, d19, d6, d9);
                tessellator.a(d12, (double)par3 - 0.01, d19, d6, d7);
                tessellator.a(d12, (double)par3 - 0.01, d18, d5, d7);
                tessellator.a(d10, (double)par3 - 0.01, d18, d5, d9);
                tessellator.a(d12, (double)par3 - 0.01, d19, d6, d9);
                tessellator.a(d10, (double)par3 - 0.01, d19, d6, d7);
                tessellator.a(d10, (double)par3 - 0.01, d18, d5, d7);
                tessellator.a(d12, (double)par3 - 0.01, d18, d5, d9);
            } else {
                if (par3 > 1 && this.a.c(par2 - 1, par3 - 1, par4)) {
                    tessellator.a(d10, (double)par3 - 0.01, d19, d6, d8);
                    tessellator.a(d11, (double)par3 - 0.01, d19, d6, d9);
                    tessellator.a(d11, (double)par3 - 0.01, d18, d5, d9);
                    tessellator.a(d10, (double)par3 - 0.01, d18, d5, d8);
                    tessellator.a(d11, (double)par3 - 0.01, d19, d6, d8);
                    tessellator.a(d10, (double)par3 - 0.01, d19, d6, d9);
                    tessellator.a(d10, (double)par3 - 0.01, d18, d5, d9);
                    tessellator.a(d11, (double)par3 - 0.01, d18, d5, d8);
                }
                if (par3 > 1 && this.a.c(par2 + 1, par3 - 1, par4)) {
                    tessellator.a(d11, (double)par3 - 0.01, d19, d6, d7);
                    tessellator.a(d12, (double)par3 - 0.01, d19, d6, d8);
                    tessellator.a(d12, (double)par3 - 0.01, d18, d5, d8);
                    tessellator.a(d11, (double)par3 - 0.01, d18, d5, d7);
                    tessellator.a(d12, (double)par3 - 0.01, d19, d6, d7);
                    tessellator.a(d11, (double)par3 - 0.01, d19, d6, d8);
                    tessellator.a(d11, (double)par3 - 0.01, d18, d5, d8);
                    tessellator.a(d12, (double)par3 - 0.01, d18, d5, d7);
                }
            }
        }
        if ((!flag || !flag1) && (flag2 || flag3 || flag || flag1)) {
            if (flag && !flag1) {
                tessellator.a(d11, par3 + 1, d13, d0, d3);
                tessellator.a(d11, par3 + 0, d13, d0, d4);
                tessellator.a(d11, par3 + 0, d14, d1, d4);
                tessellator.a(d11, par3 + 1, d14, d1, d3);
                tessellator.a(d11, par3 + 1, d14, d0, d3);
                tessellator.a(d11, par3 + 0, d14, d0, d4);
                tessellator.a(d11, par3 + 0, d13, d1, d4);
                tessellator.a(d11, par3 + 1, d13, d1, d3);
                if (!flag3 && !flag2) {
                    tessellator.a(d16, par3 + 1, d14, d5, d7);
                    tessellator.a(d16, par3 + 0, d14, d5, d9);
                    tessellator.a(d17, par3 + 0, d14, d6, d9);
                    tessellator.a(d17, par3 + 1, d14, d6, d7);
                    tessellator.a(d17, par3 + 1, d14, d5, d7);
                    tessellator.a(d17, par3 + 0, d14, d5, d9);
                    tessellator.a(d16, par3 + 0, d14, d6, d9);
                    tessellator.a(d16, par3 + 1, d14, d6, d7);
                }
                if (flag4 || par3 < l2 - 1 && this.a.c(par2, par3 + 1, par4 - 1)) {
                    tessellator.a(d16, (double)(par3 + 1) + 0.005, d13, d6, d7);
                    tessellator.a(d16, (double)(par3 + 1) + 0.005, d14, d6, d8);
                    tessellator.a(d17, (double)(par3 + 1) + 0.005, d14, d5, d8);
                    tessellator.a(d17, (double)(par3 + 1) + 0.005, d13, d5, d7);
                    tessellator.a(d16, (double)(par3 + 1) + 0.005, d14, d6, d7);
                    tessellator.a(d16, (double)(par3 + 1) + 0.005, d13, d6, d8);
                    tessellator.a(d17, (double)(par3 + 1) + 0.005, d13, d5, d8);
                    tessellator.a(d17, (double)(par3 + 1) + 0.005, d14, d5, d7);
                }
                if (flag5 || par3 > 1 && this.a.c(par2, par3 - 1, par4 - 1)) {
                    tessellator.a(d16, (double)par3 - 0.005, d13, d6, d7);
                    tessellator.a(d16, (double)par3 - 0.005, d14, d6, d8);
                    tessellator.a(d17, (double)par3 - 0.005, d14, d5, d8);
                    tessellator.a(d17, (double)par3 - 0.005, d13, d5, d7);
                    tessellator.a(d16, (double)par3 - 0.005, d14, d6, d7);
                    tessellator.a(d16, (double)par3 - 0.005, d13, d6, d8);
                    tessellator.a(d17, (double)par3 - 0.005, d13, d5, d8);
                    tessellator.a(d17, (double)par3 - 0.005, d14, d5, d7);
                }
            } else if (!flag && flag1) {
                tessellator.a(d11, par3 + 1, d14, d1, d3);
                tessellator.a(d11, par3 + 0, d14, d1, d4);
                tessellator.a(d11, par3 + 0, d15, d2, d4);
                tessellator.a(d11, par3 + 1, d15, d2, d3);
                tessellator.a(d11, par3 + 1, d15, d1, d3);
                tessellator.a(d11, par3 + 0, d15, d1, d4);
                tessellator.a(d11, par3 + 0, d14, d2, d4);
                tessellator.a(d11, par3 + 1, d14, d2, d3);
                if (!flag3 && !flag2) {
                    tessellator.a(d17, par3 + 1, d14, d5, d7);
                    tessellator.a(d17, par3 + 0, d14, d5, d9);
                    tessellator.a(d16, par3 + 0, d14, d6, d9);
                    tessellator.a(d16, par3 + 1, d14, d6, d7);
                    tessellator.a(d16, par3 + 1, d14, d5, d7);
                    tessellator.a(d16, par3 + 0, d14, d5, d9);
                    tessellator.a(d17, par3 + 0, d14, d6, d9);
                    tessellator.a(d17, par3 + 1, d14, d6, d7);
                }
                if (flag4 || par3 < l2 - 1 && this.a.c(par2, par3 + 1, par4 + 1)) {
                    tessellator.a(d16, (double)(par3 + 1) + 0.005, d14, d5, d8);
                    tessellator.a(d16, (double)(par3 + 1) + 0.005, d15, d5, d9);
                    tessellator.a(d17, (double)(par3 + 1) + 0.005, d15, d6, d9);
                    tessellator.a(d17, (double)(par3 + 1) + 0.005, d14, d6, d8);
                    tessellator.a(d16, (double)(par3 + 1) + 0.005, d15, d5, d8);
                    tessellator.a(d16, (double)(par3 + 1) + 0.005, d14, d5, d9);
                    tessellator.a(d17, (double)(par3 + 1) + 0.005, d14, d6, d9);
                    tessellator.a(d17, (double)(par3 + 1) + 0.005, d15, d6, d8);
                }
                if (flag5 || par3 > 1 && this.a.c(par2, par3 - 1, par4 + 1)) {
                    tessellator.a(d16, (double)par3 - 0.005, d14, d5, d8);
                    tessellator.a(d16, (double)par3 - 0.005, d15, d5, d9);
                    tessellator.a(d17, (double)par3 - 0.005, d15, d6, d9);
                    tessellator.a(d17, (double)par3 - 0.005, d14, d6, d8);
                    tessellator.a(d16, (double)par3 - 0.005, d15, d5, d8);
                    tessellator.a(d16, (double)par3 - 0.005, d14, d5, d9);
                    tessellator.a(d17, (double)par3 - 0.005, d14, d6, d9);
                    tessellator.a(d17, (double)par3 - 0.005, d15, d6, d8);
                }
            }
        } else {
            tessellator.a(d11, par3 + 1, d15, d0, d3);
            tessellator.a(d11, par3 + 0, d15, d0, d4);
            tessellator.a(d11, par3 + 0, d13, d2, d4);
            tessellator.a(d11, par3 + 1, d13, d2, d3);
            tessellator.a(d11, par3 + 1, d13, d0, d3);
            tessellator.a(d11, par3 + 0, d13, d0, d4);
            tessellator.a(d11, par3 + 0, d15, d2, d4);
            tessellator.a(d11, par3 + 1, d15, d2, d3);
            if (flag4) {
                tessellator.a(d17, (double)(par3 + 1) + 0.005, d15, d6, d9);
                tessellator.a(d17, (double)(par3 + 1) + 0.005, d13, d6, d7);
                tessellator.a(d16, (double)(par3 + 1) + 0.005, d13, d5, d7);
                tessellator.a(d16, (double)(par3 + 1) + 0.005, d15, d5, d9);
                tessellator.a(d17, (double)(par3 + 1) + 0.005, d13, d6, d9);
                tessellator.a(d17, (double)(par3 + 1) + 0.005, d15, d6, d7);
                tessellator.a(d16, (double)(par3 + 1) + 0.005, d15, d5, d7);
                tessellator.a(d16, (double)(par3 + 1) + 0.005, d13, d5, d9);
            } else {
                if (par3 < l2 - 1 && this.a.c(par2, par3 + 1, par4 - 1)) {
                    tessellator.a(d16, (double)(par3 + 1) + 0.005, d13, d6, d7);
                    tessellator.a(d16, (double)(par3 + 1) + 0.005, d14, d6, d8);
                    tessellator.a(d17, (double)(par3 + 1) + 0.005, d14, d5, d8);
                    tessellator.a(d17, (double)(par3 + 1) + 0.005, d13, d5, d7);
                    tessellator.a(d16, (double)(par3 + 1) + 0.005, d14, d6, d7);
                    tessellator.a(d16, (double)(par3 + 1) + 0.005, d13, d6, d8);
                    tessellator.a(d17, (double)(par3 + 1) + 0.005, d13, d5, d8);
                    tessellator.a(d17, (double)(par3 + 1) + 0.005, d14, d5, d7);
                }
                if (par3 < l2 - 1 && this.a.c(par2, par3 + 1, par4 + 1)) {
                    tessellator.a(d16, (double)(par3 + 1) + 0.005, d14, d5, d8);
                    tessellator.a(d16, (double)(par3 + 1) + 0.005, d15, d5, d9);
                    tessellator.a(d17, (double)(par3 + 1) + 0.005, d15, d6, d9);
                    tessellator.a(d17, (double)(par3 + 1) + 0.005, d14, d6, d8);
                    tessellator.a(d16, (double)(par3 + 1) + 0.005, d15, d5, d8);
                    tessellator.a(d16, (double)(par3 + 1) + 0.005, d14, d5, d9);
                    tessellator.a(d17, (double)(par3 + 1) + 0.005, d14, d6, d9);
                    tessellator.a(d17, (double)(par3 + 1) + 0.005, d15, d6, d8);
                }
            }
            if (flag5) {
                tessellator.a(d17, (double)par3 - 0.005, d15, d6, d9);
                tessellator.a(d17, (double)par3 - 0.005, d13, d6, d7);
                tessellator.a(d16, (double)par3 - 0.005, d13, d5, d7);
                tessellator.a(d16, (double)par3 - 0.005, d15, d5, d9);
                tessellator.a(d17, (double)par3 - 0.005, d13, d6, d9);
                tessellator.a(d17, (double)par3 - 0.005, d15, d6, d7);
                tessellator.a(d16, (double)par3 - 0.005, d15, d5, d7);
                tessellator.a(d16, (double)par3 - 0.005, d13, d5, d9);
            } else {
                if (par3 > 1 && this.a.c(par2, par3 - 1, par4 - 1)) {
                    tessellator.a(d16, (double)par3 - 0.005, d13, d6, d7);
                    tessellator.a(d16, (double)par3 - 0.005, d14, d6, d8);
                    tessellator.a(d17, (double)par3 - 0.005, d14, d5, d8);
                    tessellator.a(d17, (double)par3 - 0.005, d13, d5, d7);
                    tessellator.a(d16, (double)par3 - 0.005, d14, d6, d7);
                    tessellator.a(d16, (double)par3 - 0.005, d13, d6, d8);
                    tessellator.a(d17, (double)par3 - 0.005, d13, d5, d8);
                    tessellator.a(d17, (double)par3 - 0.005, d14, d5, d7);
                }
                if (par3 > 1 && this.a.c(par2, par3 - 1, par4 + 1)) {
                    tessellator.a(d16, (double)par3 - 0.005, d14, d5, d8);
                    tessellator.a(d16, (double)par3 - 0.005, d15, d5, d9);
                    tessellator.a(d17, (double)par3 - 0.005, d15, d6, d9);
                    tessellator.a(d17, (double)par3 - 0.005, d14, d6, d8);
                    tessellator.a(d16, (double)par3 - 0.005, d15, d5, d8);
                    tessellator.a(d16, (double)par3 - 0.005, d14, d5, d9);
                    tessellator.a(d17, (double)par3 - 0.005, d14, d6, d9);
                    tessellator.a(d17, (double)par3 - 0.005, d15, d6, d8);
                }
            }
        }
        return true;
    }

    public boolean k(aqz par1Block, int par2, int par3, int par4) {
        bfq tessellator = bfq.a;
        tessellator.c(par1Block.e(this.a, par2, par3, par4));
        float f2 = 1.0f;
        int l2 = par1Block.c(this.a, par2, par3, par4);
        float f1 = (float)(l2 >> 16 & 0xFF) / 255.0f;
        float f22 = (float)(l2 >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(l2 & 0xFF) / 255.0f;
        if (bfe.a) {
            float f4 = (f1 * 30.0f + f22 * 59.0f + f3 * 11.0f) / 100.0f;
            float f5 = (f1 * 30.0f + f22 * 70.0f) / 100.0f;
            float f6 = (f1 * 30.0f + f3 * 70.0f) / 100.0f;
            f1 = f4;
            f22 = f5;
            f3 = f6;
        }
        tessellator.a(f2 * f1, f2 * f22, f2 * f3);
        double d0 = par2;
        double d1 = par3;
        double d2 = par4;
        if (par1Block == aqz.ac) {
            long i1 = (long)(par2 * 3129871) ^ (long)par4 * 116129781L ^ (long)par3;
            i1 = i1 * i1 * 42317861L + i1 * 11L;
            d0 += ((double)((float)(i1 >> 16 & 0xFL) / 15.0f) - 0.5) * 0.5;
            d1 += ((double)((float)(i1 >> 20 & 0xFL) / 15.0f) - 1.0) * 0.2;
            d2 += ((double)((float)(i1 >> 24 & 0xFL) / 15.0f) - 0.5) * 0.5;
        }
        this.a(par1Block, this.a.h(par2, par3, par4), d0, d1, d2, 1.0f);
        return true;
    }

    public boolean l(aqz par1Block, int par2, int par3, int par4) {
        aqq blockstem = (aqq)par1Block;
        bfq tessellator = bfq.a;
        tessellator.c(blockstem.e(this.a, par2, par3, par4));
        float f2 = 1.0f;
        int l2 = blockstem.c(this.a, par2, par3, par4);
        float f1 = (float)(l2 >> 16 & 0xFF) / 255.0f;
        float f22 = (float)(l2 >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(l2 & 0xFF) / 255.0f;
        if (bfe.a) {
            float f4 = (f1 * 30.0f + f22 * 59.0f + f3 * 11.0f) / 100.0f;
            float f5 = (f1 * 30.0f + f22 * 70.0f) / 100.0f;
            float f6 = (f1 * 30.0f + f3 * 70.0f) / 100.0f;
            f1 = f4;
            f22 = f5;
            f3 = f6;
        }
        tessellator.a(f2 * f1, f2 * f22, f2 * f3);
        blockstem.a(this.a, par2, par3, par4);
        int i1 = blockstem.d(this.a, par2, par3, par4);
        if (i1 < 0) {
            this.a((aqz)blockstem, this.a.h(par2, par3, par4), this.j, (double)par2, (double)((float)par3 - 0.0625f), (double)par4);
        } else {
            this.a((aqz)blockstem, this.a.h(par2, par3, par4), 0.5, (double)par2, (double)((float)par3 - 0.0625f), (double)par4);
            this.a(blockstem, this.a.h(par2, par3, par4), i1, this.j, (double)par2, (double)((float)par3 - 0.0625f), (double)par4);
        }
        return true;
    }

    public boolean m(aqz par1Block, int par2, int par3, int par4) {
        bfq tessellator = bfq.a;
        tessellator.c(par1Block.e(this.a, par2, par3, par4));
        tessellator.a(1.0f, 1.0f, 1.0f);
        this.a(par1Block, this.a.h(par2, par3, par4), (double)par2, (double)((float)par3 - 0.0625f), (double)par4);
        return true;
    }

    public void a(aqz par1Block, double par2, double par4, double par6, double par8, double par10, int par12) {
        bfq tessellator = bfq.a;
        ms icon = this.a(par1Block, 0, par12);
        if (this.b()) {
            icon = this.d;
        }
        double d5 = icon.c();
        double d6 = icon.e();
        double d7 = icon.d();
        double d8 = icon.f();
        double d9 = icon.a(7.0);
        double d10 = icon.b(6.0);
        double d11 = icon.a(9.0);
        double d12 = icon.b(8.0);
        double d13 = icon.a(7.0);
        double d14 = icon.b(13.0);
        double d15 = icon.a(9.0);
        double d16 = icon.b(15.0);
        double d17 = (par2 += 0.5) - 0.5;
        double d18 = par2 + 0.5;
        double d19 = (par6 += 0.5) - 0.5;
        double d20 = par6 + 0.5;
        double d21 = 0.0625;
        double d22 = 0.625;
        tessellator.a(par2 + par8 * (1.0 - d22) - d21, par4 + d22, par6 + par10 * (1.0 - d22) - d21, d9, d10);
        tessellator.a(par2 + par8 * (1.0 - d22) - d21, par4 + d22, par6 + par10 * (1.0 - d22) + d21, d9, d12);
        tessellator.a(par2 + par8 * (1.0 - d22) + d21, par4 + d22, par6 + par10 * (1.0 - d22) + d21, d11, d12);
        tessellator.a(par2 + par8 * (1.0 - d22) + d21, par4 + d22, par6 + par10 * (1.0 - d22) - d21, d11, d10);
        tessellator.a(par2 + d21 + par8, par4, par6 - d21 + par10, d15, d14);
        tessellator.a(par2 + d21 + par8, par4, par6 + d21 + par10, d15, d16);
        tessellator.a(par2 - d21 + par8, par4, par6 + d21 + par10, d13, d16);
        tessellator.a(par2 - d21 + par8, par4, par6 - d21 + par10, d13, d14);
        tessellator.a(par2 - d21, par4 + 1.0, d19, d5, d6);
        tessellator.a(par2 - d21 + par8, par4 + 0.0, d19 + par10, d5, d8);
        tessellator.a(par2 - d21 + par8, par4 + 0.0, d20 + par10, d7, d8);
        tessellator.a(par2 - d21, par4 + 1.0, d20, d7, d6);
        tessellator.a(par2 + d21, par4 + 1.0, d20, d5, d6);
        tessellator.a(par2 + par8 + d21, par4 + 0.0, d20 + par10, d5, d8);
        tessellator.a(par2 + par8 + d21, par4 + 0.0, d19 + par10, d7, d8);
        tessellator.a(par2 + d21, par4 + 1.0, d19, d7, d6);
        tessellator.a(d17, par4 + 1.0, par6 + d21, d5, d6);
        tessellator.a(d17 + par8, par4 + 0.0, par6 + d21 + par10, d5, d8);
        tessellator.a(d18 + par8, par4 + 0.0, par6 + d21 + par10, d7, d8);
        tessellator.a(d18, par4 + 1.0, par6 + d21, d7, d6);
        tessellator.a(d18, par4 + 1.0, par6 - d21, d5, d6);
        tessellator.a(d18 + par8, par4 + 0.0, par6 - d21 + par10, d5, d8);
        tessellator.a(d17 + par8, par4 + 0.0, par6 - d21 + par10, d7, d8);
        tessellator.a(d17, par4 + 1.0, par6 - d21, d7, d6);
    }

    public void a(aqz par1Block, int par2, double par3, double par5, double par7, float par9) {
        bfq tessellator = bfq.a;
        ms icon = this.a(par1Block, 0, par2);
        if (this.b()) {
            icon = this.d;
        }
        double d3 = icon.c();
        double d4 = icon.e();
        double d5 = icon.d();
        double d6 = icon.f();
        double d7 = 0.45 * (double)par9;
        double d8 = par3 + 0.5 - d7;
        double d9 = par3 + 0.5 + d7;
        double d10 = par7 + 0.5 - d7;
        double d11 = par7 + 0.5 + d7;
        tessellator.a(d8, par5 + (double)par9, d10, d3, d4);
        tessellator.a(d8, par5 + 0.0, d10, d3, d6);
        tessellator.a(d9, par5 + 0.0, d11, d5, d6);
        tessellator.a(d9, par5 + (double)par9, d11, d5, d4);
        tessellator.a(d9, par5 + (double)par9, d11, d3, d4);
        tessellator.a(d9, par5 + 0.0, d11, d3, d6);
        tessellator.a(d8, par5 + 0.0, d10, d5, d6);
        tessellator.a(d8, par5 + (double)par9, d10, d5, d4);
        tessellator.a(d8, par5 + (double)par9, d11, d3, d4);
        tessellator.a(d8, par5 + 0.0, d11, d3, d6);
        tessellator.a(d9, par5 + 0.0, d10, d5, d6);
        tessellator.a(d9, par5 + (double)par9, d10, d5, d4);
        tessellator.a(d9, par5 + (double)par9, d10, d3, d4);
        tessellator.a(d9, par5 + 0.0, d10, d3, d6);
        tessellator.a(d8, par5 + 0.0, d11, d5, d6);
        tessellator.a(d8, par5 + (double)par9, d11, d5, d4);
    }

    public void a(aqz par1Block, int par2, double par3, double par5, double par7, double par9) {
        bfq tessellator = bfq.a;
        ms icon = this.a(par1Block, 0, par2);
        if (this.b()) {
            icon = this.d;
        }
        double d4 = icon.c();
        double d5 = icon.e();
        double d6 = icon.d();
        double d7 = icon.b(par3 * 16.0);
        double d8 = par5 + 0.5 - (double)0.45f;
        double d9 = par5 + 0.5 + (double)0.45f;
        double d10 = par9 + 0.5 - (double)0.45f;
        double d11 = par9 + 0.5 + (double)0.45f;
        tessellator.a(d8, par7 + par3, d10, d4, d5);
        tessellator.a(d8, par7 + 0.0, d10, d4, d7);
        tessellator.a(d9, par7 + 0.0, d11, d6, d7);
        tessellator.a(d9, par7 + par3, d11, d6, d5);
        tessellator.a(d9, par7 + par3, d11, d4, d5);
        tessellator.a(d9, par7 + 0.0, d11, d4, d7);
        tessellator.a(d8, par7 + 0.0, d10, d6, d7);
        tessellator.a(d8, par7 + par3, d10, d6, d5);
        tessellator.a(d8, par7 + par3, d11, d4, d5);
        tessellator.a(d8, par7 + 0.0, d11, d4, d7);
        tessellator.a(d9, par7 + 0.0, d10, d6, d7);
        tessellator.a(d9, par7 + par3, d10, d6, d5);
        tessellator.a(d9, par7 + par3, d10, d4, d5);
        tessellator.a(d9, par7 + 0.0, d10, d4, d7);
        tessellator.a(d8, par7 + 0.0, d11, d6, d7);
        tessellator.a(d8, par7 + par3, d11, d6, d5);
    }

    public boolean n(aqz par1Block, int par2, int par3, int par4) {
        bfq tessellator = bfq.a;
        ms icon = this.a(par1Block, 1);
        if (this.b()) {
            icon = this.d;
        }
        float f2 = 0.015625f;
        double d0 = icon.c();
        double d1 = icon.e();
        double d2 = icon.d();
        double d3 = icon.f();
        long l2 = (long)(par2 * 3129871) ^ (long)par4 * 116129781L ^ (long)par3;
        l2 = l2 * l2 * 42317861L + l2 * 11L;
        int i1 = (int)(l2 >> 16 & 3L);
        tessellator.c(par1Block.e(this.a, par2, par3, par4));
        float f1 = (float)par2 + 0.5f;
        float f22 = (float)par4 + 0.5f;
        float f3 = (float)(i1 & 1) * 0.5f * (float)(1 - i1 / 2 % 2 * 2);
        float f4 = (float)(i1 + 1 & 1) * 0.5f * (float)(1 - (i1 + 1) / 2 % 2 * 2);
        tessellator.d(par1Block.o());
        tessellator.a(f1 + f3 - f4, (float)par3 + f2, f22 + f3 + f4, d0, d1);
        tessellator.a(f1 + f3 + f4, (float)par3 + f2, f22 - f3 + f4, d2, d1);
        tessellator.a(f1 - f3 + f4, (float)par3 + f2, f22 - f3 - f4, d2, d3);
        tessellator.a(f1 - f3 - f4, (float)par3 + f2, f22 + f3 - f4, d0, d3);
        tessellator.d((par1Block.o() & 0xFEFEFE) >> 1);
        tessellator.a(f1 - f3 - f4, (float)par3 + f2, f22 + f3 - f4, d0, d3);
        tessellator.a(f1 - f3 + f4, (float)par3 + f2, f22 - f3 - f4, d2, d3);
        tessellator.a(f1 + f3 + f4, (float)par3 + f2, f22 - f3 + f4, d2, d1);
        tessellator.a(f1 + f3 - f4, (float)par3 + f2, f22 + f3 + f4, d0, d1);
        return true;
    }

    public void a(aqq par1BlockStem, int par2, int par3, double par4, double par6, double par8, double par10) {
        bfq tessellator = bfq.a;
        ms icon = par1BlockStem.q();
        if (this.b()) {
            icon = this.d;
        }
        double d4 = icon.c();
        double d5 = icon.e();
        double d6 = icon.d();
        double d7 = icon.f();
        double d8 = par6 + 0.5 - 0.5;
        double d9 = par6 + 0.5 + 0.5;
        double d10 = par10 + 0.5 - 0.5;
        double d11 = par10 + 0.5 + 0.5;
        double d12 = par6 + 0.5;
        double d13 = par10 + 0.5;
        if ((par3 + 1) / 2 % 2 == 1) {
            double d14 = d6;
            d6 = d4;
            d4 = d14;
        }
        if (par3 < 2) {
            tessellator.a(d8, par8 + par4, d13, d4, d5);
            tessellator.a(d8, par8 + 0.0, d13, d4, d7);
            tessellator.a(d9, par8 + 0.0, d13, d6, d7);
            tessellator.a(d9, par8 + par4, d13, d6, d5);
            tessellator.a(d9, par8 + par4, d13, d6, d5);
            tessellator.a(d9, par8 + 0.0, d13, d6, d7);
            tessellator.a(d8, par8 + 0.0, d13, d4, d7);
            tessellator.a(d8, par8 + par4, d13, d4, d5);
        } else {
            tessellator.a(d12, par8 + par4, d11, d4, d5);
            tessellator.a(d12, par8 + 0.0, d11, d4, d7);
            tessellator.a(d12, par8 + 0.0, d10, d6, d7);
            tessellator.a(d12, par8 + par4, d10, d6, d5);
            tessellator.a(d12, par8 + par4, d10, d6, d5);
            tessellator.a(d12, par8 + 0.0, d10, d6, d7);
            tessellator.a(d12, par8 + 0.0, d11, d4, d7);
            tessellator.a(d12, par8 + par4, d11, d4, d5);
        }
    }

    public void a(aqz par1Block, int par2, double par3, double par5, double par7) {
        bfq tessellator = bfq.a;
        ms icon = this.a(par1Block, 0, par2);
        if (this.b()) {
            icon = this.d;
        }
        double d3 = icon.c();
        double d4 = icon.e();
        double d5 = icon.d();
        double d6 = icon.f();
        double d7 = par3 + 0.5 - 0.25;
        double d8 = par3 + 0.5 + 0.25;
        double d9 = par7 + 0.5 - 0.5;
        double d10 = par7 + 0.5 + 0.5;
        tessellator.a(d7, par5 + 1.0, d9, d3, d4);
        tessellator.a(d7, par5 + 0.0, d9, d3, d6);
        tessellator.a(d7, par5 + 0.0, d10, d5, d6);
        tessellator.a(d7, par5 + 1.0, d10, d5, d4);
        tessellator.a(d7, par5 + 1.0, d10, d3, d4);
        tessellator.a(d7, par5 + 0.0, d10, d3, d6);
        tessellator.a(d7, par5 + 0.0, d9, d5, d6);
        tessellator.a(d7, par5 + 1.0, d9, d5, d4);
        tessellator.a(d8, par5 + 1.0, d10, d3, d4);
        tessellator.a(d8, par5 + 0.0, d10, d3, d6);
        tessellator.a(d8, par5 + 0.0, d9, d5, d6);
        tessellator.a(d8, par5 + 1.0, d9, d5, d4);
        tessellator.a(d8, par5 + 1.0, d9, d3, d4);
        tessellator.a(d8, par5 + 0.0, d9, d3, d6);
        tessellator.a(d8, par5 + 0.0, d10, d5, d6);
        tessellator.a(d8, par5 + 1.0, d10, d5, d4);
        d7 = par3 + 0.5 - 0.5;
        d8 = par3 + 0.5 + 0.5;
        d9 = par7 + 0.5 - 0.25;
        d10 = par7 + 0.5 + 0.25;
        tessellator.a(d7, par5 + 1.0, d9, d3, d4);
        tessellator.a(d7, par5 + 0.0, d9, d3, d6);
        tessellator.a(d8, par5 + 0.0, d9, d5, d6);
        tessellator.a(d8, par5 + 1.0, d9, d5, d4);
        tessellator.a(d8, par5 + 1.0, d9, d3, d4);
        tessellator.a(d8, par5 + 0.0, d9, d3, d6);
        tessellator.a(d7, par5 + 0.0, d9, d5, d6);
        tessellator.a(d7, par5 + 1.0, d9, d5, d4);
        tessellator.a(d8, par5 + 1.0, d10, d3, d4);
        tessellator.a(d8, par5 + 0.0, d10, d3, d6);
        tessellator.a(d7, par5 + 0.0, d10, d5, d6);
        tessellator.a(d7, par5 + 1.0, d10, d5, d4);
        tessellator.a(d7, par5 + 1.0, d10, d3, d4);
        tessellator.a(d7, par5 + 0.0, d10, d3, d6);
        tessellator.a(d8, par5 + 0.0, d10, d5, d6);
        tessellator.a(d8, par5 + 1.0, d10, d5, d4);
    }

    public boolean o(aqz par1Block, int par2, int par3, int par4) {
        float f7;
        float f8;
        float f9;
        bfq tessellator = bfq.a;
        int l2 = par1Block.c(this.a, par2, par3, par4);
        float f2 = (float)(l2 >> 16 & 0xFF) / 255.0f;
        float f1 = (float)(l2 >> 8 & 0xFF) / 255.0f;
        float f22 = (float)(l2 & 0xFF) / 255.0f;
        boolean flag = par1Block.a(this.a, par2, par3 + 1, par4, 1);
        boolean flag1 = par1Block.a(this.a, par2, par3 - 1, par4, 0);
        boolean[] aboolean = new boolean[]{par1Block.a(this.a, par2, par3, par4 - 1, 2), par1Block.a(this.a, par2, par3, par4 + 1, 3), par1Block.a(this.a, par2 - 1, par3, par4, 4), par1Block.a(this.a, par2 + 1, par3, par4, 5)};
        if (!(flag || flag1 || aboolean[0] || aboolean[1] || aboolean[2] || aboolean[3])) {
            return false;
        }
        boolean flag2 = false;
        float f3 = 0.5f;
        float f4 = 1.0f;
        float f5 = 0.8f;
        float f6 = 0.6f;
        double d0 = 0.0;
        double d1 = 1.0;
        akc material = par1Block.cU;
        int i1 = this.a.h(par2, par3, par4);
        double d2 = this.a(par2, par3, par4, material);
        double d3 = this.a(par2, par3, par4 + 1, material);
        double d4 = this.a(par2 + 1, par3, par4 + 1, material);
        double d5 = this.a(par2 + 1, par3, par4, material);
        double d6 = 0.001f;
        if (this.f || flag) {
            double d13;
            double d9;
            double d14;
            double d10;
            double d11;
            double d7;
            double d12;
            double d8;
            flag2 = true;
            ms icon = this.a(par1Block, 1, i1);
            float f10 = (float)apc.a(this.a, par2, par3, par4, material);
            if (f10 > -999.0f) {
                icon = this.a(par1Block, 2, i1);
            }
            d2 -= d6;
            d3 -= d6;
            d4 -= d6;
            d5 -= d6;
            if (f10 < -999.0f) {
                d8 = icon.a(0.0);
                d12 = icon.b(0.0);
                d7 = d8;
                d11 = icon.b(16.0);
                d10 = icon.a(16.0);
                d14 = d11;
                d9 = d10;
                d13 = d12;
            } else {
                f9 = ls.a(f10) * 0.25f;
                f8 = ls.b(f10) * 0.25f;
                f7 = 8.0f;
                d8 = icon.a((double)(8.0f + (-f8 - f9) * 16.0f));
                d12 = icon.b((double)(8.0f + (-f8 + f9) * 16.0f));
                d7 = icon.a((double)(8.0f + (-f8 + f9) * 16.0f));
                d11 = icon.b((double)(8.0f + (f8 + f9) * 16.0f));
                d10 = icon.a((double)(8.0f + (f8 + f9) * 16.0f));
                d14 = icon.b((double)(8.0f + (f8 - f9) * 16.0f));
                d9 = icon.a((double)(8.0f + (f8 - f9) * 16.0f));
                d13 = icon.b((double)(8.0f + (-f8 - f9) * 16.0f));
            }
            tessellator.c(par1Block.e(this.a, par2, par3, par4));
            f9 = 1.0f;
            tessellator.a(f4 * f9 * f2, f4 * f9 * f1, f4 * f9 * f22);
            tessellator.a(par2 + 0, (double)par3 + d2, par4 + 0, d8, d12);
            tessellator.a(par2 + 0, (double)par3 + d3, par4 + 1, d7, d11);
            tessellator.a(par2 + 1, (double)par3 + d4, par4 + 1, d10, d14);
            tessellator.a(par2 + 1, (double)par3 + d5, par4 + 0, d9, d13);
        }
        if (this.f || flag1) {
            tessellator.c(par1Block.e(this.a, par2, par3 - 1, par4));
            float f11 = 1.0f;
            tessellator.a(f3 * f11, f3 * f11, f3 * f11);
            this.a(par1Block, (double)par2, (double)par3 + d6, (double)par4, this.a(par1Block, 0));
            flag2 = true;
        }
        for (int j1 = 0; j1 < 4; ++j1) {
            double d20;
            double d19;
            double d18;
            double d16;
            double d17;
            double d15;
            int k1 = par2;
            int l1 = par4;
            if (j1 == 0) {
                l1 = par4 - 1;
            }
            if (j1 == 1) {
                ++l1;
            }
            if (j1 == 2) {
                k1 = par2 - 1;
            }
            if (j1 == 3) {
                ++k1;
            }
            ms icon1 = this.a(par1Block, j1 + 2, i1);
            if (!this.f && !aboolean[j1]) continue;
            if (j1 == 0) {
                d15 = d2;
                d17 = d5;
                d16 = par2;
                d18 = par2 + 1;
                d19 = (double)par4 + d6;
                d20 = (double)par4 + d6;
            } else if (j1 == 1) {
                d15 = d4;
                d17 = d3;
                d16 = par2 + 1;
                d18 = par2;
                d19 = (double)(par4 + 1) - d6;
                d20 = (double)(par4 + 1) - d6;
            } else if (j1 == 2) {
                d15 = d3;
                d17 = d2;
                d16 = (double)par2 + d6;
                d18 = (double)par2 + d6;
                d19 = par4 + 1;
                d20 = par4;
            } else {
                d15 = d5;
                d17 = d4;
                d16 = (double)(par2 + 1) - d6;
                d18 = (double)(par2 + 1) - d6;
                d19 = par4;
                d20 = par4 + 1;
            }
            flag2 = true;
            float f12 = icon1.a(0.0);
            f9 = icon1.a(8.0);
            f8 = icon1.b((1.0 - d15) * 16.0 * 0.5);
            f7 = icon1.b((1.0 - d17) * 16.0 * 0.5);
            float f13 = icon1.b(8.0);
            tessellator.c(par1Block.e(this.a, k1, par3, l1));
            float f14 = 1.0f;
            f14 = j1 < 2 ? (f14 *= f5) : (f14 *= f6);
            tessellator.a(f4 * f14 * f2, f4 * f14 * f1, f4 * f14 * f22);
            tessellator.a(d16, (double)par3 + d15, d19, f12, f8);
            tessellator.a(d18, (double)par3 + d17, d20, f9, f7);
            tessellator.a(d18, par3 + 0, d20, f9, f13);
            tessellator.a(d16, par3 + 0, d19, f12, f13);
        }
        this.i = d0;
        this.j = d1;
        return flag2;
    }

    public float a(int par1, int par2, int par3, akc par4Material) {
        int l2 = 0;
        float f2 = 0.0f;
        for (int i1 = 0; i1 < 4; ++i1) {
            int j1 = par1 - (i1 & 1);
            int k1 = par3 - (i1 >> 1 & 1);
            if (this.a.g(j1, par2 + 1, k1) == par4Material) {
                return 1.0f;
            }
            akc material1 = this.a.g(j1, par2, k1);
            if (material1 == par4Material) {
                int l1 = this.a.h(j1, par2, k1);
                if (l1 >= 8 || l1 == 0) {
                    f2 += apc.d(l1) * 10.0f;
                    l2 += 10;
                }
                f2 += apc.d(l1);
                ++l2;
                continue;
            }
            if (material1.a()) continue;
            f2 += 1.0f;
            ++l2;
        }
        return 1.0f - f2 / (float)l2;
    }

    public void a(aqz par1Block, abw par2World, int par3, int par4, int par5, int par6) {
        float f2 = 0.5f;
        float f1 = 1.0f;
        float f22 = 0.8f;
        float f3 = 0.6f;
        bfq tessellator = bfq.a;
        tessellator.b();
        tessellator.c(par1Block.e(par2World, par3, par4, par5));
        float f4 = 1.0f;
        float f5 = 1.0f;
        if (f5 < f4) {
            f5 = f4;
        }
        tessellator.a(f2 * f5, f2 * f5, f2 * f5);
        this.a(par1Block, -0.5, -0.5, -0.5, this.a(par1Block, 0, par6));
        f5 = 1.0f;
        if (f5 < f4) {
            f5 = f4;
        }
        tessellator.a(f1 * f5, f1 * f5, f1 * f5);
        this.b(par1Block, -0.5, -0.5, -0.5, this.a(par1Block, 1, par6));
        f5 = 1.0f;
        if (f5 < f4) {
            f5 = f4;
        }
        tessellator.a(f22 * f5, f22 * f5, f22 * f5);
        this.c(par1Block, -0.5, -0.5, -0.5, this.a(par1Block, 2, par6));
        f5 = 1.0f;
        if (f5 < f4) {
            f5 = f4;
        }
        tessellator.a(f22 * f5, f22 * f5, f22 * f5);
        this.d(par1Block, -0.5, -0.5, -0.5, this.a(par1Block, 3, par6));
        f5 = 1.0f;
        if (f5 < f4) {
            f5 = f4;
        }
        tessellator.a(f3 * f5, f3 * f5, f3 * f5);
        this.e(par1Block, -0.5, -0.5, -0.5, this.a(par1Block, 4, par6));
        f5 = 1.0f;
        if (f5 < f4) {
            f5 = f4;
        }
        tessellator.a(f3 * f5, f3 * f5, f3 * f5);
        this.f(par1Block, -0.5, -0.5, -0.5, this.a(par1Block, 5, par6));
        tessellator.a();
    }

    public boolean p(aqz par1Block, int par2, int par3, int par4) {
        int l2 = par1Block.c(this.a, par2, par3, par4);
        float f2 = (float)(l2 >> 16 & 0xFF) / 255.0f;
        float f1 = (float)(l2 >> 8 & 0xFF) / 255.0f;
        float f22 = (float)(l2 & 0xFF) / 255.0f;
        if (bfe.a) {
            float f3 = (f2 * 30.0f + f1 * 59.0f + f22 * 11.0f) / 100.0f;
            float f4 = (f2 * 30.0f + f1 * 70.0f) / 100.0f;
            float f5 = (f2 * 30.0f + f22 * 70.0f) / 100.0f;
            f2 = f3;
            f1 = f4;
            f22 = f5;
        }
        return atv.t() && aqz.w[par1Block.cF] == 0 ? (this.n ? this.b(par1Block, par2, par3, par4, f2, f1, f22) : this.a(par1Block, par2, par3, par4, f2, f1, f22)) : this.d(par1Block, par2, par3, par4, f2, f1, f22);
    }

    public boolean q(aqz par1Block, int par2, int par3, int par4) {
        int l2 = this.a.h(par2, par3, par4);
        int i1 = l2 & 0xC;
        if (i1 == 4) {
            this.p = 1;
            this.q = 1;
            this.t = 1;
            this.u = 1;
        } else if (i1 == 8) {
            this.r = 1;
            this.s = 1;
        }
        boolean flag = this.p(par1Block, par2, par3, par4);
        this.r = 0;
        this.p = 0;
        this.q = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        return flag;
    }

    public boolean r(aqz par1Block, int par2, int par3, int par4) {
        int l2 = this.a.h(par2, par3, par4);
        if (l2 == 3) {
            this.p = 1;
            this.q = 1;
            this.t = 1;
            this.u = 1;
        } else if (l2 == 4) {
            this.r = 1;
            this.s = 1;
        }
        boolean flag = this.p(par1Block, par2, par3, par4);
        this.r = 0;
        this.p = 0;
        this.q = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        return flag;
    }

    public boolean a(aqz par1Block, int par2, int par3, int par4, float par5, float par6, float par7) {
        ms icon;
        float f7;
        int i1;
        boolean flag4;
        boolean flag5;
        boolean flag2;
        boolean flag3;
        this.v = true;
        boolean flag = false;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        boolean flag1 = true;
        int l2 = par1Block.e(this.a, par2, par3, par4);
        bfq tessellator = bfq.a;
        tessellator.c(983055);
        if (this.b(par1Block).g().equals("grass_top")) {
            flag1 = false;
        } else if (this.b()) {
            flag1 = false;
        }
        if (this.f || par1Block.a(this.a, par2, par3 - 1, par4, 0)) {
            if (this.i <= 0.0) {
                --par3;
            }
            this.R = par1Block.e(this.a, par2 - 1, par3, par4);
            this.T = par1Block.e(this.a, par2, par3, par4 - 1);
            this.U = par1Block.e(this.a, par2, par3, par4 + 1);
            this.W = par1Block.e(this.a, par2 + 1, par3, par4);
            this.x = par1Block.i(this.a, par2 - 1, par3, par4);
            this.z = par1Block.i(this.a, par2, par3, par4 - 1);
            this.A = par1Block.i(this.a, par2, par3, par4 + 1);
            this.C = par1Block.i(this.a, par2 + 1, par3, par4);
            flag3 = aqz.v[this.a.a(par2 + 1, par3 - 1, par4)];
            flag2 = aqz.v[this.a.a(par2 - 1, par3 - 1, par4)];
            flag5 = aqz.v[this.a.a(par2, par3 - 1, par4 + 1)];
            flag4 = aqz.v[this.a.a(par2, par3 - 1, par4 - 1)];
            if (!flag4 && !flag2) {
                this.w = this.x;
                this.Q = this.R;
            } else {
                this.w = par1Block.i(this.a, par2 - 1, par3, par4 - 1);
                this.Q = par1Block.e(this.a, par2 - 1, par3, par4 - 1);
            }
            if (!flag5 && !flag2) {
                this.y = this.x;
                this.S = this.R;
            } else {
                this.y = par1Block.i(this.a, par2 - 1, par3, par4 + 1);
                this.S = par1Block.e(this.a, par2 - 1, par3, par4 + 1);
            }
            if (!flag4 && !flag3) {
                this.B = this.C;
                this.V = this.W;
            } else {
                this.B = par1Block.i(this.a, par2 + 1, par3, par4 - 1);
                this.V = par1Block.e(this.a, par2 + 1, par3, par4 - 1);
            }
            if (!flag5 && !flag3) {
                this.D = this.C;
                this.X = this.W;
            } else {
                this.D = par1Block.i(this.a, par2 + 1, par3, par4 + 1);
                this.X = par1Block.e(this.a, par2 + 1, par3, par4 + 1);
            }
            if (this.i <= 0.0) {
                ++par3;
            }
            i1 = l2;
            if (this.i <= 0.0 || !this.a.t(par2, par3 - 1, par4)) {
                i1 = par1Block.e(this.a, par2, par3 - 1, par4);
            }
            f7 = par1Block.i(this.a, par2, par3 - 1, par4);
            f3 = (this.y + this.x + this.A + f7) / 4.0f;
            f6 = (this.A + f7 + this.D + this.C) / 4.0f;
            f5 = (f7 + this.z + this.C + this.B) / 4.0f;
            f4 = (this.x + this.w + f7 + this.z) / 4.0f;
            this.ak = this.a(this.S, this.R, this.U, i1);
            this.an = this.a(this.U, this.X, this.W, i1);
            this.am = this.a(this.T, this.W, this.V, i1);
            this.al = this.a(this.R, this.Q, this.T, i1);
            if (flag1) {
                this.aq = this.ar = par5 * 0.5f;
                this.ap = this.ar;
                this.ao = this.ar;
                this.au = this.av = par6 * 0.5f;
                this.at = this.av;
                this.as = this.av;
                this.ay = this.az = par7 * 0.5f;
                this.ax = this.az;
                this.aw = this.az;
            } else {
                this.ar = 0.5f;
                this.aq = 0.5f;
                this.ap = 0.5f;
                this.ao = 0.5f;
                this.av = 0.5f;
                this.au = 0.5f;
                this.at = 0.5f;
                this.as = 0.5f;
                this.az = 0.5f;
                this.ay = 0.5f;
                this.ax = 0.5f;
                this.aw = 0.5f;
            }
            this.ao *= f3;
            this.as *= f3;
            this.aw *= f3;
            this.ap *= f4;
            this.at *= f4;
            this.ax *= f4;
            this.aq *= f5;
            this.au *= f5;
            this.ay *= f5;
            this.ar *= f6;
            this.av *= f6;
            this.az *= f6;
            this.a(par1Block, (double)par2, (double)par3, (double)par4, this.a(par1Block, this.a, par2, par3, par4, 0));
            flag = true;
        }
        if (this.f || par1Block.a(this.a, par2, par3 + 1, par4, 1)) {
            if (this.j >= 1.0) {
                ++par3;
            }
            this.Z = par1Block.e(this.a, par2 - 1, par3, par4);
            this.ad = par1Block.e(this.a, par2 + 1, par3, par4);
            this.ab = par1Block.e(this.a, par2, par3, par4 - 1);
            this.ae = par1Block.e(this.a, par2, par3, par4 + 1);
            this.F = par1Block.i(this.a, par2 - 1, par3, par4);
            this.J = par1Block.i(this.a, par2 + 1, par3, par4);
            this.H = par1Block.i(this.a, par2, par3, par4 - 1);
            this.K = par1Block.i(this.a, par2, par3, par4 + 1);
            flag3 = aqz.v[this.a.a(par2 + 1, par3 + 1, par4)];
            flag2 = aqz.v[this.a.a(par2 - 1, par3 + 1, par4)];
            flag5 = aqz.v[this.a.a(par2, par3 + 1, par4 + 1)];
            flag4 = aqz.v[this.a.a(par2, par3 + 1, par4 - 1)];
            if (!flag4 && !flag2) {
                this.E = this.F;
                this.Y = this.Z;
            } else {
                this.E = par1Block.i(this.a, par2 - 1, par3, par4 - 1);
                this.Y = par1Block.e(this.a, par2 - 1, par3, par4 - 1);
            }
            if (!flag4 && !flag3) {
                this.I = this.J;
                this.ac = this.ad;
            } else {
                this.I = par1Block.i(this.a, par2 + 1, par3, par4 - 1);
                this.ac = par1Block.e(this.a, par2 + 1, par3, par4 - 1);
            }
            if (!flag5 && !flag2) {
                this.G = this.F;
                this.aa = this.Z;
            } else {
                this.G = par1Block.i(this.a, par2 - 1, par3, par4 + 1);
                this.aa = par1Block.e(this.a, par2 - 1, par3, par4 + 1);
            }
            if (!flag5 && !flag3) {
                this.L = this.J;
                this.af = this.ad;
            } else {
                this.L = par1Block.i(this.a, par2 + 1, par3, par4 + 1);
                this.af = par1Block.e(this.a, par2 + 1, par3, par4 + 1);
            }
            if (this.j >= 1.0) {
                --par3;
            }
            i1 = l2;
            if (this.j >= 1.0 || !this.a.t(par2, par3 + 1, par4)) {
                i1 = par1Block.e(this.a, par2, par3 + 1, par4);
            }
            f7 = par1Block.i(this.a, par2, par3 + 1, par4);
            f6 = (this.G + this.F + this.K + f7) / 4.0f;
            f3 = (this.K + f7 + this.L + this.J) / 4.0f;
            f4 = (f7 + this.H + this.J + this.I) / 4.0f;
            f5 = (this.F + this.E + f7 + this.H) / 4.0f;
            this.an = this.a(this.aa, this.Z, this.ae, i1);
            this.ak = this.a(this.ae, this.af, this.ad, i1);
            this.al = this.a(this.ab, this.ad, this.ac, i1);
            this.am = this.a(this.Z, this.Y, this.ab, i1);
            this.aq = this.ar = par5;
            this.ap = this.ar;
            this.ao = this.ar;
            this.au = this.av = par6;
            this.at = this.av;
            this.as = this.av;
            this.ay = this.az = par7;
            this.ax = this.az;
            this.aw = this.az;
            this.ao *= f3;
            this.as *= f3;
            this.aw *= f3;
            this.ap *= f4;
            this.at *= f4;
            this.ax *= f4;
            this.aq *= f5;
            this.au *= f5;
            this.ay *= f5;
            this.ar *= f6;
            this.av *= f6;
            this.az *= f6;
            this.b(par1Block, (double)par2, (double)par3, (double)par4, this.a(par1Block, this.a, par2, par3, par4, 1));
            flag = true;
        }
        if (this.f || par1Block.a(this.a, par2, par3, par4 - 1, 2)) {
            if (this.k <= 0.0) {
                --par4;
            }
            this.M = par1Block.i(this.a, par2 - 1, par3, par4);
            this.z = par1Block.i(this.a, par2, par3 - 1, par4);
            this.H = par1Block.i(this.a, par2, par3 + 1, par4);
            this.N = par1Block.i(this.a, par2 + 1, par3, par4);
            this.ag = par1Block.e(this.a, par2 - 1, par3, par4);
            this.T = par1Block.e(this.a, par2, par3 - 1, par4);
            this.ab = par1Block.e(this.a, par2, par3 + 1, par4);
            this.ah = par1Block.e(this.a, par2 + 1, par3, par4);
            flag3 = aqz.v[this.a.a(par2 + 1, par3, par4 - 1)];
            flag2 = aqz.v[this.a.a(par2 - 1, par3, par4 - 1)];
            flag5 = aqz.v[this.a.a(par2, par3 + 1, par4 - 1)];
            flag4 = aqz.v[this.a.a(par2, par3 - 1, par4 - 1)];
            if (!flag2 && !flag4) {
                this.w = this.M;
                this.Q = this.ag;
            } else {
                this.w = par1Block.i(this.a, par2 - 1, par3 - 1, par4);
                this.Q = par1Block.e(this.a, par2 - 1, par3 - 1, par4);
            }
            if (!flag2 && !flag5) {
                this.E = this.M;
                this.Y = this.ag;
            } else {
                this.E = par1Block.i(this.a, par2 - 1, par3 + 1, par4);
                this.Y = par1Block.e(this.a, par2 - 1, par3 + 1, par4);
            }
            if (!flag3 && !flag4) {
                this.B = this.N;
                this.V = this.ah;
            } else {
                this.B = par1Block.i(this.a, par2 + 1, par3 - 1, par4);
                this.V = par1Block.e(this.a, par2 + 1, par3 - 1, par4);
            }
            if (!flag3 && !flag5) {
                this.I = this.N;
                this.ac = this.ah;
            } else {
                this.I = par1Block.i(this.a, par2 + 1, par3 + 1, par4);
                this.ac = par1Block.e(this.a, par2 + 1, par3 + 1, par4);
            }
            if (this.k <= 0.0) {
                ++par4;
            }
            i1 = l2;
            if (this.k <= 0.0 || !this.a.t(par2, par3, par4 - 1)) {
                i1 = par1Block.e(this.a, par2, par3, par4 - 1);
            }
            f7 = par1Block.i(this.a, par2, par3, par4 - 1);
            f3 = (this.M + this.E + f7 + this.H) / 4.0f;
            f4 = (f7 + this.H + this.N + this.I) / 4.0f;
            f5 = (this.z + f7 + this.B + this.N) / 4.0f;
            f6 = (this.w + this.M + this.z + f7) / 4.0f;
            this.ak = this.a(this.ag, this.Y, this.ab, i1);
            this.al = this.a(this.ab, this.ah, this.ac, i1);
            this.am = this.a(this.T, this.V, this.ah, i1);
            this.an = this.a(this.Q, this.ag, this.T, i1);
            if (flag1) {
                this.aq = this.ar = par5 * 0.8f;
                this.ap = this.ar;
                this.ao = this.ar;
                this.au = this.av = par6 * 0.8f;
                this.at = this.av;
                this.as = this.av;
                this.ay = this.az = par7 * 0.8f;
                this.ax = this.az;
                this.aw = this.az;
            } else {
                this.ar = 0.8f;
                this.aq = 0.8f;
                this.ap = 0.8f;
                this.ao = 0.8f;
                this.av = 0.8f;
                this.au = 0.8f;
                this.at = 0.8f;
                this.as = 0.8f;
                this.az = 0.8f;
                this.ay = 0.8f;
                this.ax = 0.8f;
                this.aw = 0.8f;
            }
            this.ao *= f3;
            this.as *= f3;
            this.aw *= f3;
            this.ap *= f4;
            this.at *= f4;
            this.ax *= f4;
            this.aq *= f5;
            this.au *= f5;
            this.ay *= f5;
            this.ar *= f6;
            this.av *= f6;
            this.az *= f6;
            icon = this.a(par1Block, this.a, par2, par3, par4, 2);
            this.c(par1Block, (double)par2, (double)par3, (double)par4, icon);
            if (b && icon.g().equals("grass_side") && !this.b()) {
                this.ao *= par5;
                this.ap *= par5;
                this.aq *= par5;
                this.ar *= par5;
                this.as *= par6;
                this.at *= par6;
                this.au *= par6;
                this.av *= par6;
                this.aw *= par7;
                this.ax *= par7;
                this.ay *= par7;
                this.az *= par7;
                this.c(par1Block, (double)par2, (double)par3, (double)par4, aon.p());
            }
            flag = true;
        }
        if (this.f || par1Block.a(this.a, par2, par3, par4 + 1, 3)) {
            if (this.l >= 1.0) {
                ++par4;
            }
            this.O = par1Block.i(this.a, par2 - 1, par3, par4);
            this.P = par1Block.i(this.a, par2 + 1, par3, par4);
            this.A = par1Block.i(this.a, par2, par3 - 1, par4);
            this.K = par1Block.i(this.a, par2, par3 + 1, par4);
            this.ai = par1Block.e(this.a, par2 - 1, par3, par4);
            this.aj = par1Block.e(this.a, par2 + 1, par3, par4);
            this.U = par1Block.e(this.a, par2, par3 - 1, par4);
            this.ae = par1Block.e(this.a, par2, par3 + 1, par4);
            flag3 = aqz.v[this.a.a(par2 + 1, par3, par4 + 1)];
            flag2 = aqz.v[this.a.a(par2 - 1, par3, par4 + 1)];
            flag5 = aqz.v[this.a.a(par2, par3 + 1, par4 + 1)];
            flag4 = aqz.v[this.a.a(par2, par3 - 1, par4 + 1)];
            if (!flag2 && !flag4) {
                this.y = this.O;
                this.S = this.ai;
            } else {
                this.y = par1Block.i(this.a, par2 - 1, par3 - 1, par4);
                this.S = par1Block.e(this.a, par2 - 1, par3 - 1, par4);
            }
            if (!flag2 && !flag5) {
                this.G = this.O;
                this.aa = this.ai;
            } else {
                this.G = par1Block.i(this.a, par2 - 1, par3 + 1, par4);
                this.aa = par1Block.e(this.a, par2 - 1, par3 + 1, par4);
            }
            if (!flag3 && !flag4) {
                this.D = this.P;
                this.X = this.aj;
            } else {
                this.D = par1Block.i(this.a, par2 + 1, par3 - 1, par4);
                this.X = par1Block.e(this.a, par2 + 1, par3 - 1, par4);
            }
            if (!flag3 && !flag5) {
                this.L = this.P;
                this.af = this.aj;
            } else {
                this.L = par1Block.i(this.a, par2 + 1, par3 + 1, par4);
                this.af = par1Block.e(this.a, par2 + 1, par3 + 1, par4);
            }
            if (this.l >= 1.0) {
                --par4;
            }
            i1 = l2;
            if (this.l >= 1.0 || !this.a.t(par2, par3, par4 + 1)) {
                i1 = par1Block.e(this.a, par2, par3, par4 + 1);
            }
            f7 = par1Block.i(this.a, par2, par3, par4 + 1);
            f3 = (this.O + this.G + f7 + this.K) / 4.0f;
            f6 = (f7 + this.K + this.P + this.L) / 4.0f;
            f5 = (this.A + f7 + this.D + this.P) / 4.0f;
            f4 = (this.y + this.O + this.A + f7) / 4.0f;
            this.ak = this.a(this.ai, this.aa, this.ae, i1);
            this.an = this.a(this.ae, this.aj, this.af, i1);
            this.am = this.a(this.U, this.X, this.aj, i1);
            this.al = this.a(this.S, this.ai, this.U, i1);
            if (flag1) {
                this.aq = this.ar = par5 * 0.8f;
                this.ap = this.ar;
                this.ao = this.ar;
                this.au = this.av = par6 * 0.8f;
                this.at = this.av;
                this.as = this.av;
                this.ay = this.az = par7 * 0.8f;
                this.ax = this.az;
                this.aw = this.az;
            } else {
                this.ar = 0.8f;
                this.aq = 0.8f;
                this.ap = 0.8f;
                this.ao = 0.8f;
                this.av = 0.8f;
                this.au = 0.8f;
                this.at = 0.8f;
                this.as = 0.8f;
                this.az = 0.8f;
                this.ay = 0.8f;
                this.ax = 0.8f;
                this.aw = 0.8f;
            }
            this.ao *= f3;
            this.as *= f3;
            this.aw *= f3;
            this.ap *= f4;
            this.at *= f4;
            this.ax *= f4;
            this.aq *= f5;
            this.au *= f5;
            this.ay *= f5;
            this.ar *= f6;
            this.av *= f6;
            this.az *= f6;
            icon = this.a(par1Block, this.a, par2, par3, par4, 3);
            this.d(par1Block, par2, par3, par4, this.a(par1Block, this.a, par2, par3, par4, 3));
            if (b && icon.g().equals("grass_side") && !this.b()) {
                this.ao *= par5;
                this.ap *= par5;
                this.aq *= par5;
                this.ar *= par5;
                this.as *= par6;
                this.at *= par6;
                this.au *= par6;
                this.av *= par6;
                this.aw *= par7;
                this.ax *= par7;
                this.ay *= par7;
                this.az *= par7;
                this.d(par1Block, par2, par3, par4, aon.p());
            }
            flag = true;
        }
        if (this.f || par1Block.a(this.a, par2 - 1, par3, par4, 4)) {
            if (this.g <= 0.0) {
                --par2;
            }
            this.x = par1Block.i(this.a, par2, par3 - 1, par4);
            this.M = par1Block.i(this.a, par2, par3, par4 - 1);
            this.O = par1Block.i(this.a, par2, par3, par4 + 1);
            this.F = par1Block.i(this.a, par2, par3 + 1, par4);
            this.R = par1Block.e(this.a, par2, par3 - 1, par4);
            this.ag = par1Block.e(this.a, par2, par3, par4 - 1);
            this.ai = par1Block.e(this.a, par2, par3, par4 + 1);
            this.Z = par1Block.e(this.a, par2, par3 + 1, par4);
            flag3 = aqz.v[this.a.a(par2 - 1, par3 + 1, par4)];
            flag2 = aqz.v[this.a.a(par2 - 1, par3 - 1, par4)];
            flag5 = aqz.v[this.a.a(par2 - 1, par3, par4 - 1)];
            flag4 = aqz.v[this.a.a(par2 - 1, par3, par4 + 1)];
            if (!flag5 && !flag2) {
                this.w = this.M;
                this.Q = this.ag;
            } else {
                this.w = par1Block.i(this.a, par2, par3 - 1, par4 - 1);
                this.Q = par1Block.e(this.a, par2, par3 - 1, par4 - 1);
            }
            if (!flag4 && !flag2) {
                this.y = this.O;
                this.S = this.ai;
            } else {
                this.y = par1Block.i(this.a, par2, par3 - 1, par4 + 1);
                this.S = par1Block.e(this.a, par2, par3 - 1, par4 + 1);
            }
            if (!flag5 && !flag3) {
                this.E = this.M;
                this.Y = this.ag;
            } else {
                this.E = par1Block.i(this.a, par2, par3 + 1, par4 - 1);
                this.Y = par1Block.e(this.a, par2, par3 + 1, par4 - 1);
            }
            if (!flag4 && !flag3) {
                this.G = this.O;
                this.aa = this.ai;
            } else {
                this.G = par1Block.i(this.a, par2, par3 + 1, par4 + 1);
                this.aa = par1Block.e(this.a, par2, par3 + 1, par4 + 1);
            }
            if (this.g <= 0.0) {
                ++par2;
            }
            i1 = l2;
            if (this.g <= 0.0 || !this.a.t(par2 - 1, par3, par4)) {
                i1 = par1Block.e(this.a, par2 - 1, par3, par4);
            }
            f7 = par1Block.i(this.a, par2 - 1, par3, par4);
            f6 = (this.x + this.y + f7 + this.O) / 4.0f;
            f3 = (f7 + this.O + this.F + this.G) / 4.0f;
            f4 = (this.M + f7 + this.E + this.F) / 4.0f;
            f5 = (this.w + this.x + this.M + f7) / 4.0f;
            this.an = this.a(this.R, this.S, this.ai, i1);
            this.ak = this.a(this.ai, this.Z, this.aa, i1);
            this.al = this.a(this.ag, this.Y, this.Z, i1);
            this.am = this.a(this.Q, this.R, this.ag, i1);
            if (flag1) {
                this.aq = this.ar = par5 * 0.6f;
                this.ap = this.ar;
                this.ao = this.ar;
                this.au = this.av = par6 * 0.6f;
                this.at = this.av;
                this.as = this.av;
                this.ay = this.az = par7 * 0.6f;
                this.ax = this.az;
                this.aw = this.az;
            } else {
                this.ar = 0.6f;
                this.aq = 0.6f;
                this.ap = 0.6f;
                this.ao = 0.6f;
                this.av = 0.6f;
                this.au = 0.6f;
                this.at = 0.6f;
                this.as = 0.6f;
                this.az = 0.6f;
                this.ay = 0.6f;
                this.ax = 0.6f;
                this.aw = 0.6f;
            }
            this.ao *= f3;
            this.as *= f3;
            this.aw *= f3;
            this.ap *= f4;
            this.at *= f4;
            this.ax *= f4;
            this.aq *= f5;
            this.au *= f5;
            this.ay *= f5;
            this.ar *= f6;
            this.av *= f6;
            this.az *= f6;
            icon = this.a(par1Block, this.a, par2, par3, par4, 4);
            this.e(par1Block, par2, par3, par4, icon);
            if (b && icon.g().equals("grass_side") && !this.b()) {
                this.ao *= par5;
                this.ap *= par5;
                this.aq *= par5;
                this.ar *= par5;
                this.as *= par6;
                this.at *= par6;
                this.au *= par6;
                this.av *= par6;
                this.aw *= par7;
                this.ax *= par7;
                this.ay *= par7;
                this.az *= par7;
                this.e(par1Block, par2, par3, par4, aon.p());
            }
            flag = true;
        }
        if (this.f || par1Block.a(this.a, par2 + 1, par3, par4, 5)) {
            if (this.h >= 1.0) {
                ++par2;
            }
            this.C = par1Block.i(this.a, par2, par3 - 1, par4);
            this.N = par1Block.i(this.a, par2, par3, par4 - 1);
            this.P = par1Block.i(this.a, par2, par3, par4 + 1);
            this.J = par1Block.i(this.a, par2, par3 + 1, par4);
            this.W = par1Block.e(this.a, par2, par3 - 1, par4);
            this.ah = par1Block.e(this.a, par2, par3, par4 - 1);
            this.aj = par1Block.e(this.a, par2, par3, par4 + 1);
            this.ad = par1Block.e(this.a, par2, par3 + 1, par4);
            flag3 = aqz.v[this.a.a(par2 + 1, par3 + 1, par4)];
            flag2 = aqz.v[this.a.a(par2 + 1, par3 - 1, par4)];
            flag5 = aqz.v[this.a.a(par2 + 1, par3, par4 + 1)];
            flag4 = aqz.v[this.a.a(par2 + 1, par3, par4 - 1)];
            if (!flag2 && !flag4) {
                this.B = this.N;
                this.V = this.ah;
            } else {
                this.B = par1Block.i(this.a, par2, par3 - 1, par4 - 1);
                this.V = par1Block.e(this.a, par2, par3 - 1, par4 - 1);
            }
            if (!flag2 && !flag5) {
                this.D = this.P;
                this.X = this.aj;
            } else {
                this.D = par1Block.i(this.a, par2, par3 - 1, par4 + 1);
                this.X = par1Block.e(this.a, par2, par3 - 1, par4 + 1);
            }
            if (!flag3 && !flag4) {
                this.I = this.N;
                this.ac = this.ah;
            } else {
                this.I = par1Block.i(this.a, par2, par3 + 1, par4 - 1);
                this.ac = par1Block.e(this.a, par2, par3 + 1, par4 - 1);
            }
            if (!flag3 && !flag5) {
                this.L = this.P;
                this.af = this.aj;
            } else {
                this.L = par1Block.i(this.a, par2, par3 + 1, par4 + 1);
                this.af = par1Block.e(this.a, par2, par3 + 1, par4 + 1);
            }
            if (this.h >= 1.0) {
                --par2;
            }
            i1 = l2;
            if (this.h >= 1.0 || !this.a.t(par2 + 1, par3, par4)) {
                i1 = par1Block.e(this.a, par2 + 1, par3, par4);
            }
            f7 = par1Block.i(this.a, par2 + 1, par3, par4);
            f3 = (this.C + this.D + f7 + this.P) / 4.0f;
            f4 = (this.B + this.C + this.N + f7) / 4.0f;
            f5 = (this.N + f7 + this.I + this.J) / 4.0f;
            f6 = (f7 + this.P + this.J + this.L) / 4.0f;
            this.ak = this.a(this.W, this.X, this.aj, i1);
            this.an = this.a(this.aj, this.ad, this.af, i1);
            this.am = this.a(this.ah, this.ac, this.ad, i1);
            this.al = this.a(this.V, this.W, this.ah, i1);
            if (flag1) {
                this.aq = this.ar = par5 * 0.6f;
                this.ap = this.ar;
                this.ao = this.ar;
                this.au = this.av = par6 * 0.6f;
                this.at = this.av;
                this.as = this.av;
                this.ay = this.az = par7 * 0.6f;
                this.ax = this.az;
                this.aw = this.az;
            } else {
                this.ar = 0.6f;
                this.aq = 0.6f;
                this.ap = 0.6f;
                this.ao = 0.6f;
                this.av = 0.6f;
                this.au = 0.6f;
                this.at = 0.6f;
                this.as = 0.6f;
                this.az = 0.6f;
                this.ay = 0.6f;
                this.ax = 0.6f;
                this.aw = 0.6f;
            }
            this.ao *= f3;
            this.as *= f3;
            this.aw *= f3;
            this.ap *= f4;
            this.at *= f4;
            this.ax *= f4;
            this.aq *= f5;
            this.au *= f5;
            this.ay *= f5;
            this.ar *= f6;
            this.av *= f6;
            this.az *= f6;
            icon = this.a(par1Block, this.a, par2, par3, par4, 5);
            this.f(par1Block, par2, par3, par4, icon);
            if (b && icon.g().equals("grass_side") && !this.b()) {
                this.ao *= par5;
                this.ap *= par5;
                this.aq *= par5;
                this.ar *= par5;
                this.as *= par6;
                this.at *= par6;
                this.au *= par6;
                this.av *= par6;
                this.aw *= par7;
                this.ax *= par7;
                this.ay *= par7;
                this.az *= par7;
                this.f(par1Block, par2, par3, par4, aon.p());
            }
            flag = true;
        }
        this.v = false;
        return flag;
    }

    public boolean b(aqz par1Block, int par2, int par3, int par4, float par5, float par6, float par7) {
        ms icon;
        int l1;
        int i2;
        int j1;
        int k1;
        float f10;
        float f11;
        float f8;
        float f9;
        float f7;
        int i1;
        boolean flag4;
        boolean flag5;
        boolean flag2;
        boolean flag3;
        this.v = true;
        boolean flag = false;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        boolean flag1 = true;
        int l2 = par1Block.e(this.a, par2, par3, par4);
        bfq tessellator = bfq.a;
        tessellator.c(983055);
        if (this.b(par1Block).g().equals("grass_top")) {
            flag1 = false;
        } else if (this.b()) {
            flag1 = false;
        }
        if (this.f || par1Block.a(this.a, par2, par3 - 1, par4, 0)) {
            if (this.i <= 0.0) {
                --par3;
            }
            this.R = par1Block.e(this.a, par2 - 1, par3, par4);
            this.T = par1Block.e(this.a, par2, par3, par4 - 1);
            this.U = par1Block.e(this.a, par2, par3, par4 + 1);
            this.W = par1Block.e(this.a, par2 + 1, par3, par4);
            this.x = par1Block.i(this.a, par2 - 1, par3, par4);
            this.z = par1Block.i(this.a, par2, par3, par4 - 1);
            this.A = par1Block.i(this.a, par2, par3, par4 + 1);
            this.C = par1Block.i(this.a, par2 + 1, par3, par4);
            flag3 = aqz.v[this.a.a(par2 + 1, par3 - 1, par4)];
            flag2 = aqz.v[this.a.a(par2 - 1, par3 - 1, par4)];
            flag5 = aqz.v[this.a.a(par2, par3 - 1, par4 + 1)];
            flag4 = aqz.v[this.a.a(par2, par3 - 1, par4 - 1)];
            if (!flag4 && !flag2) {
                this.w = this.x;
                this.Q = this.R;
            } else {
                this.w = par1Block.i(this.a, par2 - 1, par3, par4 - 1);
                this.Q = par1Block.e(this.a, par2 - 1, par3, par4 - 1);
            }
            if (!flag5 && !flag2) {
                this.y = this.x;
                this.S = this.R;
            } else {
                this.y = par1Block.i(this.a, par2 - 1, par3, par4 + 1);
                this.S = par1Block.e(this.a, par2 - 1, par3, par4 + 1);
            }
            if (!flag4 && !flag3) {
                this.B = this.C;
                this.V = this.W;
            } else {
                this.B = par1Block.i(this.a, par2 + 1, par3, par4 - 1);
                this.V = par1Block.e(this.a, par2 + 1, par3, par4 - 1);
            }
            if (!flag5 && !flag3) {
                this.D = this.C;
                this.X = this.W;
            } else {
                this.D = par1Block.i(this.a, par2 + 1, par3, par4 + 1);
                this.X = par1Block.e(this.a, par2 + 1, par3, par4 + 1);
            }
            if (this.i <= 0.0) {
                ++par3;
            }
            i1 = l2;
            if (this.i <= 0.0 || !this.a.t(par2, par3 - 1, par4)) {
                i1 = par1Block.e(this.a, par2, par3 - 1, par4);
            }
            f7 = par1Block.i(this.a, par2, par3 - 1, par4);
            f3 = (this.y + this.x + this.A + f7) / 4.0f;
            f6 = (this.A + f7 + this.D + this.C) / 4.0f;
            f5 = (f7 + this.z + this.C + this.B) / 4.0f;
            f4 = (this.x + this.w + f7 + this.z) / 4.0f;
            this.ak = this.a(this.S, this.R, this.U, i1);
            this.an = this.a(this.U, this.X, this.W, i1);
            this.am = this.a(this.T, this.W, this.V, i1);
            this.al = this.a(this.R, this.Q, this.T, i1);
            if (flag1) {
                this.aq = this.ar = par5 * 0.5f;
                this.ap = this.ar;
                this.ao = this.ar;
                this.au = this.av = par6 * 0.5f;
                this.at = this.av;
                this.as = this.av;
                this.ay = this.az = par7 * 0.5f;
                this.ax = this.az;
                this.aw = this.az;
            } else {
                this.ar = 0.5f;
                this.aq = 0.5f;
                this.ap = 0.5f;
                this.ao = 0.5f;
                this.av = 0.5f;
                this.au = 0.5f;
                this.at = 0.5f;
                this.as = 0.5f;
                this.az = 0.5f;
                this.ay = 0.5f;
                this.ax = 0.5f;
                this.aw = 0.5f;
            }
            this.ao *= f3;
            this.as *= f3;
            this.aw *= f3;
            this.ap *= f4;
            this.at *= f4;
            this.ax *= f4;
            this.aq *= f5;
            this.au *= f5;
            this.ay *= f5;
            this.ar *= f6;
            this.av *= f6;
            this.az *= f6;
            this.a(par1Block, (double)par2, (double)par3, (double)par4, this.a(par1Block, this.a, par2, par3, par4, 0));
            flag = true;
        }
        if (this.f || par1Block.a(this.a, par2, par3 + 1, par4, 1)) {
            if (this.j >= 1.0) {
                ++par3;
            }
            this.Z = par1Block.e(this.a, par2 - 1, par3, par4);
            this.ad = par1Block.e(this.a, par2 + 1, par3, par4);
            this.ab = par1Block.e(this.a, par2, par3, par4 - 1);
            this.ae = par1Block.e(this.a, par2, par3, par4 + 1);
            this.F = par1Block.i(this.a, par2 - 1, par3, par4);
            this.J = par1Block.i(this.a, par2 + 1, par3, par4);
            this.H = par1Block.i(this.a, par2, par3, par4 - 1);
            this.K = par1Block.i(this.a, par2, par3, par4 + 1);
            flag3 = aqz.v[this.a.a(par2 + 1, par3 + 1, par4)];
            flag2 = aqz.v[this.a.a(par2 - 1, par3 + 1, par4)];
            flag5 = aqz.v[this.a.a(par2, par3 + 1, par4 + 1)];
            flag4 = aqz.v[this.a.a(par2, par3 + 1, par4 - 1)];
            if (!flag4 && !flag2) {
                this.E = this.F;
                this.Y = this.Z;
            } else {
                this.E = par1Block.i(this.a, par2 - 1, par3, par4 - 1);
                this.Y = par1Block.e(this.a, par2 - 1, par3, par4 - 1);
            }
            if (!flag4 && !flag3) {
                this.I = this.J;
                this.ac = this.ad;
            } else {
                this.I = par1Block.i(this.a, par2 + 1, par3, par4 - 1);
                this.ac = par1Block.e(this.a, par2 + 1, par3, par4 - 1);
            }
            if (!flag5 && !flag2) {
                this.G = this.F;
                this.aa = this.Z;
            } else {
                this.G = par1Block.i(this.a, par2 - 1, par3, par4 + 1);
                this.aa = par1Block.e(this.a, par2 - 1, par3, par4 + 1);
            }
            if (!flag5 && !flag3) {
                this.L = this.J;
                this.af = this.ad;
            } else {
                this.L = par1Block.i(this.a, par2 + 1, par3, par4 + 1);
                this.af = par1Block.e(this.a, par2 + 1, par3, par4 + 1);
            }
            if (this.j >= 1.0) {
                --par3;
            }
            i1 = l2;
            if (this.j >= 1.0 || !this.a.t(par2, par3 + 1, par4)) {
                i1 = par1Block.e(this.a, par2, par3 + 1, par4);
            }
            f7 = par1Block.i(this.a, par2, par3 + 1, par4);
            f6 = (this.G + this.F + this.K + f7) / 4.0f;
            f3 = (this.K + f7 + this.L + this.J) / 4.0f;
            f4 = (f7 + this.H + this.J + this.I) / 4.0f;
            f5 = (this.F + this.E + f7 + this.H) / 4.0f;
            this.an = this.a(this.aa, this.Z, this.ae, i1);
            this.ak = this.a(this.ae, this.af, this.ad, i1);
            this.al = this.a(this.ab, this.ad, this.ac, i1);
            this.am = this.a(this.Z, this.Y, this.ab, i1);
            this.aq = this.ar = par5;
            this.ap = this.ar;
            this.ao = this.ar;
            this.au = this.av = par6;
            this.at = this.av;
            this.as = this.av;
            this.ay = this.az = par7;
            this.ax = this.az;
            this.aw = this.az;
            this.ao *= f3;
            this.as *= f3;
            this.aw *= f3;
            this.ap *= f4;
            this.at *= f4;
            this.ax *= f4;
            this.aq *= f5;
            this.au *= f5;
            this.ay *= f5;
            this.ar *= f6;
            this.av *= f6;
            this.az *= f6;
            this.b(par1Block, (double)par2, (double)par3, (double)par4, this.a(par1Block, this.a, par2, par3, par4, 1));
            flag = true;
        }
        if (this.f || par1Block.a(this.a, par2, par3, par4 - 1, 2)) {
            if (this.k <= 0.0) {
                --par4;
            }
            this.M = par1Block.i(this.a, par2 - 1, par3, par4);
            this.z = par1Block.i(this.a, par2, par3 - 1, par4);
            this.H = par1Block.i(this.a, par2, par3 + 1, par4);
            this.N = par1Block.i(this.a, par2 + 1, par3, par4);
            this.ag = par1Block.e(this.a, par2 - 1, par3, par4);
            this.T = par1Block.e(this.a, par2, par3 - 1, par4);
            this.ab = par1Block.e(this.a, par2, par3 + 1, par4);
            this.ah = par1Block.e(this.a, par2 + 1, par3, par4);
            flag3 = aqz.v[this.a.a(par2 + 1, par3, par4 - 1)];
            flag2 = aqz.v[this.a.a(par2 - 1, par3, par4 - 1)];
            flag5 = aqz.v[this.a.a(par2, par3 + 1, par4 - 1)];
            flag4 = aqz.v[this.a.a(par2, par3 - 1, par4 - 1)];
            if (!flag2 && !flag4) {
                this.w = this.M;
                this.Q = this.ag;
            } else {
                this.w = par1Block.i(this.a, par2 - 1, par3 - 1, par4);
                this.Q = par1Block.e(this.a, par2 - 1, par3 - 1, par4);
            }
            if (!flag2 && !flag5) {
                this.E = this.M;
                this.Y = this.ag;
            } else {
                this.E = par1Block.i(this.a, par2 - 1, par3 + 1, par4);
                this.Y = par1Block.e(this.a, par2 - 1, par3 + 1, par4);
            }
            if (!flag3 && !flag4) {
                this.B = this.N;
                this.V = this.ah;
            } else {
                this.B = par1Block.i(this.a, par2 + 1, par3 - 1, par4);
                this.V = par1Block.e(this.a, par2 + 1, par3 - 1, par4);
            }
            if (!flag3 && !flag5) {
                this.I = this.N;
                this.ac = this.ah;
            } else {
                this.I = par1Block.i(this.a, par2 + 1, par3 + 1, par4);
                this.ac = par1Block.e(this.a, par2 + 1, par3 + 1, par4);
            }
            if (this.k <= 0.0) {
                ++par4;
            }
            i1 = l2;
            if (this.k <= 0.0 || !this.a.t(par2, par3, par4 - 1)) {
                i1 = par1Block.e(this.a, par2, par3, par4 - 1);
            }
            f7 = par1Block.i(this.a, par2, par3, par4 - 1);
            f9 = (this.M + this.E + f7 + this.H) / 4.0f;
            f8 = (f7 + this.H + this.N + this.I) / 4.0f;
            f11 = (this.z + f7 + this.B + this.N) / 4.0f;
            f10 = (this.w + this.M + this.z + f7) / 4.0f;
            f3 = (float)((double)f9 * this.j * (1.0 - this.g) + (double)f8 * this.i * this.g + (double)f11 * (1.0 - this.j) * this.g + (double)f10 * (1.0 - this.j) * (1.0 - this.g));
            f4 = (float)((double)f9 * this.j * (1.0 - this.h) + (double)f8 * this.j * this.h + (double)f11 * (1.0 - this.j) * this.h + (double)f10 * (1.0 - this.j) * (1.0 - this.h));
            f5 = (float)((double)f9 * this.i * (1.0 - this.h) + (double)f8 * this.i * this.h + (double)f11 * (1.0 - this.i) * this.h + (double)f10 * (1.0 - this.i) * (1.0 - this.h));
            f6 = (float)((double)f9 * this.i * (1.0 - this.g) + (double)f8 * this.i * this.g + (double)f11 * (1.0 - this.i) * this.g + (double)f10 * (1.0 - this.i) * (1.0 - this.g));
            k1 = this.a(this.ag, this.Y, this.ab, i1);
            j1 = this.a(this.ab, this.ah, this.ac, i1);
            i2 = this.a(this.T, this.V, this.ah, i1);
            l1 = this.a(this.Q, this.ag, this.T, i1);
            this.ak = this.a(k1, j1, i2, l1, this.j * (1.0 - this.g), this.j * this.g, (1.0 - this.j) * this.g, (1.0 - this.j) * (1.0 - this.g));
            this.al = this.a(k1, j1, i2, l1, this.j * (1.0 - this.h), this.j * this.h, (1.0 - this.j) * this.h, (1.0 - this.j) * (1.0 - this.h));
            this.am = this.a(k1, j1, i2, l1, this.i * (1.0 - this.h), this.i * this.h, (1.0 - this.i) * this.h, (1.0 - this.i) * (1.0 - this.h));
            this.an = this.a(k1, j1, i2, l1, this.i * (1.0 - this.g), this.i * this.g, (1.0 - this.i) * this.g, (1.0 - this.i) * (1.0 - this.g));
            if (flag1) {
                this.aq = this.ar = par5 * 0.8f;
                this.ap = this.ar;
                this.ao = this.ar;
                this.au = this.av = par6 * 0.8f;
                this.at = this.av;
                this.as = this.av;
                this.ay = this.az = par7 * 0.8f;
                this.ax = this.az;
                this.aw = this.az;
            } else {
                this.ar = 0.8f;
                this.aq = 0.8f;
                this.ap = 0.8f;
                this.ao = 0.8f;
                this.av = 0.8f;
                this.au = 0.8f;
                this.at = 0.8f;
                this.as = 0.8f;
                this.az = 0.8f;
                this.ay = 0.8f;
                this.ax = 0.8f;
                this.aw = 0.8f;
            }
            this.ao *= f3;
            this.as *= f3;
            this.aw *= f3;
            this.ap *= f4;
            this.at *= f4;
            this.ax *= f4;
            this.aq *= f5;
            this.au *= f5;
            this.ay *= f5;
            this.ar *= f6;
            this.av *= f6;
            this.az *= f6;
            icon = this.a(par1Block, this.a, par2, par3, par4, 2);
            this.c(par1Block, (double)par2, (double)par3, (double)par4, icon);
            if (b && icon.g().equals("grass_side") && !this.b()) {
                this.ao *= par5;
                this.ap *= par5;
                this.aq *= par5;
                this.ar *= par5;
                this.as *= par6;
                this.at *= par6;
                this.au *= par6;
                this.av *= par6;
                this.aw *= par7;
                this.ax *= par7;
                this.ay *= par7;
                this.az *= par7;
                this.c(par1Block, (double)par2, (double)par3, (double)par4, aon.p());
            }
            flag = true;
        }
        if (this.f || par1Block.a(this.a, par2, par3, par4 + 1, 3)) {
            if (this.l >= 1.0) {
                ++par4;
            }
            this.O = par1Block.i(this.a, par2 - 1, par3, par4);
            this.P = par1Block.i(this.a, par2 + 1, par3, par4);
            this.A = par1Block.i(this.a, par2, par3 - 1, par4);
            this.K = par1Block.i(this.a, par2, par3 + 1, par4);
            this.ai = par1Block.e(this.a, par2 - 1, par3, par4);
            this.aj = par1Block.e(this.a, par2 + 1, par3, par4);
            this.U = par1Block.e(this.a, par2, par3 - 1, par4);
            this.ae = par1Block.e(this.a, par2, par3 + 1, par4);
            flag3 = aqz.v[this.a.a(par2 + 1, par3, par4 + 1)];
            flag2 = aqz.v[this.a.a(par2 - 1, par3, par4 + 1)];
            flag5 = aqz.v[this.a.a(par2, par3 + 1, par4 + 1)];
            flag4 = aqz.v[this.a.a(par2, par3 - 1, par4 + 1)];
            if (!flag2 && !flag4) {
                this.y = this.O;
                this.S = this.ai;
            } else {
                this.y = par1Block.i(this.a, par2 - 1, par3 - 1, par4);
                this.S = par1Block.e(this.a, par2 - 1, par3 - 1, par4);
            }
            if (!flag2 && !flag5) {
                this.G = this.O;
                this.aa = this.ai;
            } else {
                this.G = par1Block.i(this.a, par2 - 1, par3 + 1, par4);
                this.aa = par1Block.e(this.a, par2 - 1, par3 + 1, par4);
            }
            if (!flag3 && !flag4) {
                this.D = this.P;
                this.X = this.aj;
            } else {
                this.D = par1Block.i(this.a, par2 + 1, par3 - 1, par4);
                this.X = par1Block.e(this.a, par2 + 1, par3 - 1, par4);
            }
            if (!flag3 && !flag5) {
                this.L = this.P;
                this.af = this.aj;
            } else {
                this.L = par1Block.i(this.a, par2 + 1, par3 + 1, par4);
                this.af = par1Block.e(this.a, par2 + 1, par3 + 1, par4);
            }
            if (this.l >= 1.0) {
                --par4;
            }
            i1 = l2;
            if (this.l >= 1.0 || !this.a.t(par2, par3, par4 + 1)) {
                i1 = par1Block.e(this.a, par2, par3, par4 + 1);
            }
            f7 = par1Block.i(this.a, par2, par3, par4 + 1);
            f9 = (this.O + this.G + f7 + this.K) / 4.0f;
            f8 = (f7 + this.K + this.P + this.L) / 4.0f;
            f11 = (this.A + f7 + this.D + this.P) / 4.0f;
            f10 = (this.y + this.O + this.A + f7) / 4.0f;
            f3 = (float)((double)f9 * this.j * (1.0 - this.g) + (double)f8 * this.j * this.g + (double)f11 * (1.0 - this.j) * this.g + (double)f10 * (1.0 - this.j) * (1.0 - this.g));
            f4 = (float)((double)f9 * this.i * (1.0 - this.g) + (double)f8 * this.i * this.g + (double)f11 * (1.0 - this.i) * this.g + (double)f10 * (1.0 - this.i) * (1.0 - this.g));
            f5 = (float)((double)f9 * this.i * (1.0 - this.h) + (double)f8 * this.i * this.h + (double)f11 * (1.0 - this.i) * this.h + (double)f10 * (1.0 - this.i) * (1.0 - this.h));
            f6 = (float)((double)f9 * this.j * (1.0 - this.h) + (double)f8 * this.j * this.h + (double)f11 * (1.0 - this.j) * this.h + (double)f10 * (1.0 - this.j) * (1.0 - this.h));
            k1 = this.a(this.ai, this.aa, this.ae, i1);
            j1 = this.a(this.ae, this.aj, this.af, i1);
            i2 = this.a(this.U, this.X, this.aj, i1);
            l1 = this.a(this.S, this.ai, this.U, i1);
            this.ak = this.a(k1, l1, i2, j1, this.j * (1.0 - this.g), (1.0 - this.j) * (1.0 - this.g), (1.0 - this.j) * this.g, this.j * this.g);
            this.al = this.a(k1, l1, i2, j1, this.i * (1.0 - this.g), (1.0 - this.i) * (1.0 - this.g), (1.0 - this.i) * this.g, this.i * this.g);
            this.am = this.a(k1, l1, i2, j1, this.i * (1.0 - this.h), (1.0 - this.i) * (1.0 - this.h), (1.0 - this.i) * this.h, this.i * this.h);
            this.an = this.a(k1, l1, i2, j1, this.j * (1.0 - this.h), (1.0 - this.j) * (1.0 - this.h), (1.0 - this.j) * this.h, this.j * this.h);
            if (flag1) {
                this.aq = this.ar = par5 * 0.8f;
                this.ap = this.ar;
                this.ao = this.ar;
                this.au = this.av = par6 * 0.8f;
                this.at = this.av;
                this.as = this.av;
                this.ay = this.az = par7 * 0.8f;
                this.ax = this.az;
                this.aw = this.az;
            } else {
                this.ar = 0.8f;
                this.aq = 0.8f;
                this.ap = 0.8f;
                this.ao = 0.8f;
                this.av = 0.8f;
                this.au = 0.8f;
                this.at = 0.8f;
                this.as = 0.8f;
                this.az = 0.8f;
                this.ay = 0.8f;
                this.ax = 0.8f;
                this.aw = 0.8f;
            }
            this.ao *= f3;
            this.as *= f3;
            this.aw *= f3;
            this.ap *= f4;
            this.at *= f4;
            this.ax *= f4;
            this.aq *= f5;
            this.au *= f5;
            this.ay *= f5;
            this.ar *= f6;
            this.av *= f6;
            this.az *= f6;
            icon = this.a(par1Block, this.a, par2, par3, par4, 3);
            this.d(par1Block, par2, par3, par4, this.a(par1Block, this.a, par2, par3, par4, 3));
            if (b && icon.g().equals("grass_side") && !this.b()) {
                this.ao *= par5;
                this.ap *= par5;
                this.aq *= par5;
                this.ar *= par5;
                this.as *= par6;
                this.at *= par6;
                this.au *= par6;
                this.av *= par6;
                this.aw *= par7;
                this.ax *= par7;
                this.ay *= par7;
                this.az *= par7;
                this.d(par1Block, par2, par3, par4, aon.p());
            }
            flag = true;
        }
        if (this.f || par1Block.a(this.a, par2 - 1, par3, par4, 4)) {
            if (this.g <= 0.0) {
                --par2;
            }
            this.x = par1Block.i(this.a, par2, par3 - 1, par4);
            this.M = par1Block.i(this.a, par2, par3, par4 - 1);
            this.O = par1Block.i(this.a, par2, par3, par4 + 1);
            this.F = par1Block.i(this.a, par2, par3 + 1, par4);
            this.R = par1Block.e(this.a, par2, par3 - 1, par4);
            this.ag = par1Block.e(this.a, par2, par3, par4 - 1);
            this.ai = par1Block.e(this.a, par2, par3, par4 + 1);
            this.Z = par1Block.e(this.a, par2, par3 + 1, par4);
            flag3 = aqz.v[this.a.a(par2 - 1, par3 + 1, par4)];
            flag2 = aqz.v[this.a.a(par2 - 1, par3 - 1, par4)];
            flag5 = aqz.v[this.a.a(par2 - 1, par3, par4 - 1)];
            flag4 = aqz.v[this.a.a(par2 - 1, par3, par4 + 1)];
            if (!flag5 && !flag2) {
                this.w = this.M;
                this.Q = this.ag;
            } else {
                this.w = par1Block.i(this.a, par2, par3 - 1, par4 - 1);
                this.Q = par1Block.e(this.a, par2, par3 - 1, par4 - 1);
            }
            if (!flag4 && !flag2) {
                this.y = this.O;
                this.S = this.ai;
            } else {
                this.y = par1Block.i(this.a, par2, par3 - 1, par4 + 1);
                this.S = par1Block.e(this.a, par2, par3 - 1, par4 + 1);
            }
            if (!flag5 && !flag3) {
                this.E = this.M;
                this.Y = this.ag;
            } else {
                this.E = par1Block.i(this.a, par2, par3 + 1, par4 - 1);
                this.Y = par1Block.e(this.a, par2, par3 + 1, par4 - 1);
            }
            if (!flag4 && !flag3) {
                this.G = this.O;
                this.aa = this.ai;
            } else {
                this.G = par1Block.i(this.a, par2, par3 + 1, par4 + 1);
                this.aa = par1Block.e(this.a, par2, par3 + 1, par4 + 1);
            }
            if (this.g <= 0.0) {
                ++par2;
            }
            i1 = l2;
            if (this.g <= 0.0 || !this.a.t(par2 - 1, par3, par4)) {
                i1 = par1Block.e(this.a, par2 - 1, par3, par4);
            }
            f7 = par1Block.i(this.a, par2 - 1, par3, par4);
            f9 = (this.x + this.y + f7 + this.O) / 4.0f;
            f8 = (f7 + this.O + this.F + this.G) / 4.0f;
            f11 = (this.M + f7 + this.E + this.F) / 4.0f;
            f10 = (this.w + this.x + this.M + f7) / 4.0f;
            f3 = (float)((double)f8 * this.j * this.l + (double)f11 * this.j * (1.0 - this.l) + (double)f10 * (1.0 - this.j) * (1.0 - this.l) + (double)f9 * (1.0 - this.j) * this.l);
            f4 = (float)((double)f8 * this.j * this.k + (double)f11 * this.j * (1.0 - this.k) + (double)f10 * (1.0 - this.j) * (1.0 - this.k) + (double)f9 * (1.0 - this.j) * this.k);
            f5 = (float)((double)f8 * this.i * this.k + (double)f11 * this.i * (1.0 - this.k) + (double)f10 * (1.0 - this.i) * (1.0 - this.k) + (double)f9 * (1.0 - this.i) * this.k);
            f6 = (float)((double)f8 * this.i * this.l + (double)f11 * this.i * (1.0 - this.l) + (double)f10 * (1.0 - this.i) * (1.0 - this.l) + (double)f9 * (1.0 - this.i) * this.l);
            k1 = this.a(this.R, this.S, this.ai, i1);
            j1 = this.a(this.ai, this.Z, this.aa, i1);
            i2 = this.a(this.ag, this.Y, this.Z, i1);
            l1 = this.a(this.Q, this.R, this.ag, i1);
            this.ak = this.a(j1, i2, l1, k1, this.j * this.l, this.j * (1.0 - this.l), (1.0 - this.j) * (1.0 - this.l), (1.0 - this.j) * this.l);
            this.al = this.a(j1, i2, l1, k1, this.j * this.k, this.j * (1.0 - this.k), (1.0 - this.j) * (1.0 - this.k), (1.0 - this.j) * this.k);
            this.am = this.a(j1, i2, l1, k1, this.i * this.k, this.i * (1.0 - this.k), (1.0 - this.i) * (1.0 - this.k), (1.0 - this.i) * this.k);
            this.an = this.a(j1, i2, l1, k1, this.i * this.l, this.i * (1.0 - this.l), (1.0 - this.i) * (1.0 - this.l), (1.0 - this.i) * this.l);
            if (flag1) {
                this.aq = this.ar = par5 * 0.6f;
                this.ap = this.ar;
                this.ao = this.ar;
                this.au = this.av = par6 * 0.6f;
                this.at = this.av;
                this.as = this.av;
                this.ay = this.az = par7 * 0.6f;
                this.ax = this.az;
                this.aw = this.az;
            } else {
                this.ar = 0.6f;
                this.aq = 0.6f;
                this.ap = 0.6f;
                this.ao = 0.6f;
                this.av = 0.6f;
                this.au = 0.6f;
                this.at = 0.6f;
                this.as = 0.6f;
                this.az = 0.6f;
                this.ay = 0.6f;
                this.ax = 0.6f;
                this.aw = 0.6f;
            }
            this.ao *= f3;
            this.as *= f3;
            this.aw *= f3;
            this.ap *= f4;
            this.at *= f4;
            this.ax *= f4;
            this.aq *= f5;
            this.au *= f5;
            this.ay *= f5;
            this.ar *= f6;
            this.av *= f6;
            this.az *= f6;
            icon = this.a(par1Block, this.a, par2, par3, par4, 4);
            this.e(par1Block, par2, par3, par4, icon);
            if (b && icon.g().equals("grass_side") && !this.b()) {
                this.ao *= par5;
                this.ap *= par5;
                this.aq *= par5;
                this.ar *= par5;
                this.as *= par6;
                this.at *= par6;
                this.au *= par6;
                this.av *= par6;
                this.aw *= par7;
                this.ax *= par7;
                this.ay *= par7;
                this.az *= par7;
                this.e(par1Block, par2, par3, par4, aon.p());
            }
            flag = true;
        }
        if (this.f || par1Block.a(this.a, par2 + 1, par3, par4, 5)) {
            if (this.h >= 1.0) {
                ++par2;
            }
            this.C = par1Block.i(this.a, par2, par3 - 1, par4);
            this.N = par1Block.i(this.a, par2, par3, par4 - 1);
            this.P = par1Block.i(this.a, par2, par3, par4 + 1);
            this.J = par1Block.i(this.a, par2, par3 + 1, par4);
            this.W = par1Block.e(this.a, par2, par3 - 1, par4);
            this.ah = par1Block.e(this.a, par2, par3, par4 - 1);
            this.aj = par1Block.e(this.a, par2, par3, par4 + 1);
            this.ad = par1Block.e(this.a, par2, par3 + 1, par4);
            flag3 = aqz.v[this.a.a(par2 + 1, par3 + 1, par4)];
            flag2 = aqz.v[this.a.a(par2 + 1, par3 - 1, par4)];
            flag5 = aqz.v[this.a.a(par2 + 1, par3, par4 + 1)];
            flag4 = aqz.v[this.a.a(par2 + 1, par3, par4 - 1)];
            if (!flag2 && !flag4) {
                this.B = this.N;
                this.V = this.ah;
            } else {
                this.B = par1Block.i(this.a, par2, par3 - 1, par4 - 1);
                this.V = par1Block.e(this.a, par2, par3 - 1, par4 - 1);
            }
            if (!flag2 && !flag5) {
                this.D = this.P;
                this.X = this.aj;
            } else {
                this.D = par1Block.i(this.a, par2, par3 - 1, par4 + 1);
                this.X = par1Block.e(this.a, par2, par3 - 1, par4 + 1);
            }
            if (!flag3 && !flag4) {
                this.I = this.N;
                this.ac = this.ah;
            } else {
                this.I = par1Block.i(this.a, par2, par3 + 1, par4 - 1);
                this.ac = par1Block.e(this.a, par2, par3 + 1, par4 - 1);
            }
            if (!flag3 && !flag5) {
                this.L = this.P;
                this.af = this.aj;
            } else {
                this.L = par1Block.i(this.a, par2, par3 + 1, par4 + 1);
                this.af = par1Block.e(this.a, par2, par3 + 1, par4 + 1);
            }
            if (this.h >= 1.0) {
                --par2;
            }
            i1 = l2;
            if (this.h >= 1.0 || !this.a.t(par2 + 1, par3, par4)) {
                i1 = par1Block.e(this.a, par2 + 1, par3, par4);
            }
            f7 = par1Block.i(this.a, par2 + 1, par3, par4);
            f9 = (this.C + this.D + f7 + this.P) / 4.0f;
            f8 = (this.B + this.C + this.N + f7) / 4.0f;
            f11 = (this.N + f7 + this.I + this.J) / 4.0f;
            f10 = (f7 + this.P + this.J + this.L) / 4.0f;
            f3 = (float)((double)f9 * (1.0 - this.i) * this.l + (double)f8 * (1.0 - this.i) * (1.0 - this.l) + (double)f11 * this.i * (1.0 - this.l) + (double)f10 * this.i * this.l);
            f4 = (float)((double)f9 * (1.0 - this.i) * this.k + (double)f8 * (1.0 - this.i) * (1.0 - this.k) + (double)f11 * this.i * (1.0 - this.k) + (double)f10 * this.i * this.k);
            f5 = (float)((double)f9 * (1.0 - this.j) * this.k + (double)f8 * (1.0 - this.j) * (1.0 - this.k) + (double)f11 * this.j * (1.0 - this.k) + (double)f10 * this.j * this.k);
            f6 = (float)((double)f9 * (1.0 - this.j) * this.l + (double)f8 * (1.0 - this.j) * (1.0 - this.l) + (double)f11 * this.j * (1.0 - this.l) + (double)f10 * this.j * this.l);
            k1 = this.a(this.W, this.X, this.aj, i1);
            j1 = this.a(this.aj, this.ad, this.af, i1);
            i2 = this.a(this.ah, this.ac, this.ad, i1);
            l1 = this.a(this.V, this.W, this.ah, i1);
            this.ak = this.a(k1, l1, i2, j1, (1.0 - this.i) * this.l, (1.0 - this.i) * (1.0 - this.l), this.i * (1.0 - this.l), this.i * this.l);
            this.al = this.a(k1, l1, i2, j1, (1.0 - this.i) * this.k, (1.0 - this.i) * (1.0 - this.k), this.i * (1.0 - this.k), this.i * this.k);
            this.am = this.a(k1, l1, i2, j1, (1.0 - this.j) * this.k, (1.0 - this.j) * (1.0 - this.k), this.j * (1.0 - this.k), this.j * this.k);
            this.an = this.a(k1, l1, i2, j1, (1.0 - this.j) * this.l, (1.0 - this.j) * (1.0 - this.l), this.j * (1.0 - this.l), this.j * this.l);
            if (flag1) {
                this.aq = this.ar = par5 * 0.6f;
                this.ap = this.ar;
                this.ao = this.ar;
                this.au = this.av = par6 * 0.6f;
                this.at = this.av;
                this.as = this.av;
                this.ay = this.az = par7 * 0.6f;
                this.ax = this.az;
                this.aw = this.az;
            } else {
                this.ar = 0.6f;
                this.aq = 0.6f;
                this.ap = 0.6f;
                this.ao = 0.6f;
                this.av = 0.6f;
                this.au = 0.6f;
                this.at = 0.6f;
                this.as = 0.6f;
                this.az = 0.6f;
                this.ay = 0.6f;
                this.ax = 0.6f;
                this.aw = 0.6f;
            }
            this.ao *= f3;
            this.as *= f3;
            this.aw *= f3;
            this.ap *= f4;
            this.at *= f4;
            this.ax *= f4;
            this.aq *= f5;
            this.au *= f5;
            this.ay *= f5;
            this.ar *= f6;
            this.av *= f6;
            this.az *= f6;
            icon = this.a(par1Block, this.a, par2, par3, par4, 5);
            this.f(par1Block, par2, par3, par4, icon);
            if (b && icon.g().equals("grass_side") && !this.b()) {
                this.ao *= par5;
                this.ap *= par5;
                this.aq *= par5;
                this.ar *= par5;
                this.as *= par6;
                this.at *= par6;
                this.au *= par6;
                this.av *= par6;
                this.aw *= par7;
                this.ax *= par7;
                this.ay *= par7;
                this.az *= par7;
                this.f(par1Block, par2, par3, par4, aon.p());
            }
            flag = true;
        }
        this.v = false;
        return flag;
    }

    public int a(int par1, int par2, int par3, int par4) {
        if (par1 == 0) {
            par1 = par4;
        }
        if (par2 == 0) {
            par2 = par4;
        }
        if (par3 == 0) {
            par3 = par4;
        }
        return par1 + par2 + par3 + par4 >> 2 & 0xFF00FF;
    }

    public int a(int par1, int par2, int par3, int par4, double par5, double par7, double par9, double par11) {
        int i1 = (int)((double)(par1 >> 16 & 0xFF) * par5 + (double)(par2 >> 16 & 0xFF) * par7 + (double)(par3 >> 16 & 0xFF) * par9 + (double)(par4 >> 16 & 0xFF) * par11) & 0xFF;
        int j1 = (int)((double)(par1 & 0xFF) * par5 + (double)(par2 & 0xFF) * par7 + (double)(par3 & 0xFF) * par9 + (double)(par4 & 0xFF) * par11) & 0xFF;
        return i1 << 16 | j1;
    }

    public boolean d(aqz par1Block, int par2, int par3, int par4, float par5, float par6, float par7) {
        ms icon;
        this.v = false;
        bfq tessellator = bfq.a;
        boolean flag = false;
        float f3 = 0.5f;
        float f4 = 1.0f;
        float f5 = 0.8f;
        float f6 = 0.6f;
        float f7 = f4 * par5;
        float f8 = f4 * par6;
        float f9 = f4 * par7;
        float f10 = f3;
        float f11 = f5;
        float f12 = f6;
        float f13 = f3;
        float f14 = f5;
        float f15 = f6;
        float f16 = f3;
        float f17 = f5;
        float f18 = f6;
        if (par1Block != aqz.z) {
            f10 = f3 * par5;
            f11 = f5 * par5;
            f12 = f6 * par5;
            f13 = f3 * par6;
            f14 = f5 * par6;
            f15 = f6 * par6;
            f16 = f3 * par7;
            f17 = f5 * par7;
            f18 = f6 * par7;
        }
        int l2 = par1Block.e(this.a, par2, par3, par4);
        if (this.f || par1Block.a(this.a, par2, par3 - 1, par4, 0)) {
            tessellator.c(this.i > 0.0 ? l2 : par1Block.e(this.a, par2, par3 - 1, par4));
            tessellator.a(f10, f13, f16);
            this.a(par1Block, (double)par2, (double)par3, (double)par4, this.a(par1Block, this.a, par2, par3, par4, 0));
            flag = true;
        }
        if (this.f || par1Block.a(this.a, par2, par3 + 1, par4, 1)) {
            tessellator.c(this.j < 1.0 ? l2 : par1Block.e(this.a, par2, par3 + 1, par4));
            tessellator.a(f7, f8, f9);
            this.b(par1Block, (double)par2, (double)par3, (double)par4, this.a(par1Block, this.a, par2, par3, par4, 1));
            flag = true;
        }
        if (this.f || par1Block.a(this.a, par2, par3, par4 - 1, 2)) {
            tessellator.c(this.k > 0.0 ? l2 : par1Block.e(this.a, par2, par3, par4 - 1));
            tessellator.a(f11, f14, f17);
            icon = this.a(par1Block, this.a, par2, par3, par4, 2);
            this.c(par1Block, (double)par2, (double)par3, (double)par4, icon);
            if (b && icon.g().equals("grass_side") && !this.b()) {
                tessellator.a(f11 * par5, f14 * par6, f17 * par7);
                this.c(par1Block, (double)par2, (double)par3, (double)par4, aon.p());
            }
            flag = true;
        }
        if (this.f || par1Block.a(this.a, par2, par3, par4 + 1, 3)) {
            tessellator.c(this.l < 1.0 ? l2 : par1Block.e(this.a, par2, par3, par4 + 1));
            tessellator.a(f11, f14, f17);
            icon = this.a(par1Block, this.a, par2, par3, par4, 3);
            this.d(par1Block, par2, par3, par4, icon);
            if (b && icon.g().equals("grass_side") && !this.b()) {
                tessellator.a(f11 * par5, f14 * par6, f17 * par7);
                this.d(par1Block, par2, par3, par4, aon.p());
            }
            flag = true;
        }
        if (this.f || par1Block.a(this.a, par2 - 1, par3, par4, 4)) {
            tessellator.c(this.g > 0.0 ? l2 : par1Block.e(this.a, par2 - 1, par3, par4));
            tessellator.a(f12, f15, f18);
            icon = this.a(par1Block, this.a, par2, par3, par4, 4);
            this.e(par1Block, par2, par3, par4, icon);
            if (b && icon.g().equals("grass_side") && !this.b()) {
                tessellator.a(f12 * par5, f15 * par6, f18 * par7);
                this.e(par1Block, par2, par3, par4, aon.p());
            }
            flag = true;
        }
        if (this.f || par1Block.a(this.a, par2 + 1, par3, par4, 5)) {
            tessellator.c(this.h < 1.0 ? l2 : par1Block.e(this.a, par2 + 1, par3, par4));
            tessellator.a(f12, f15, f18);
            icon = this.a(par1Block, this.a, par2, par3, par4, 5);
            this.f(par1Block, par2, par3, par4, icon);
            if (b && icon.g().equals("grass_side") && !this.b()) {
                tessellator.a(f12 * par5, f15 * par6, f18 * par7);
                this.f(par1Block, par2, par3, par4, aon.p());
            }
            flag = true;
        }
        return flag;
    }

    public boolean a(anm par1BlockCocoa, int par2, int par3, int par4) {
        bfq tessellator = bfq.a;
        tessellator.c(par1BlockCocoa.e(this.a, par2, par3, par4));
        tessellator.a(1.0f, 1.0f, 1.0f);
        int l2 = this.a.h(par2, par3, par4);
        int i1 = anw.j((int)l2);
        int j1 = anm.c((int)l2);
        ms icon = par1BlockCocoa.i_(j1);
        int k1 = 4 + j1 * 2;
        int l1 = 5 + j1 * 2;
        double d0 = 15.0 - (double)k1;
        double d1 = 15.0;
        double d2 = 4.0;
        double d3 = 4.0 + (double)l1;
        double d4 = icon.a(d0);
        double d5 = icon.a(d1);
        double d6 = icon.b(d2);
        double d7 = icon.b(d3);
        double d8 = 0.0;
        double d9 = 0.0;
        switch (i1) {
            case 0: {
                d8 = 8.0 - (double)(k1 / 2);
                d9 = 15.0 - (double)k1;
                break;
            }
            case 1: {
                d8 = 1.0;
                d9 = 8.0 - (double)(k1 / 2);
                break;
            }
            case 2: {
                d8 = 8.0 - (double)(k1 / 2);
                d9 = 1.0;
                break;
            }
            case 3: {
                d8 = 15.0 - (double)k1;
                d9 = 8.0 - (double)(k1 / 2);
            }
        }
        double d10 = (double)par2 + d8 / 16.0;
        double d11 = (double)par2 + (d8 + (double)k1) / 16.0;
        double d12 = (double)par3 + (12.0 - (double)l1) / 16.0;
        double d13 = (double)par3 + 0.75;
        double d14 = (double)par4 + d9 / 16.0;
        double d15 = (double)par4 + (d9 + (double)k1) / 16.0;
        tessellator.a(d10, d12, d14, d4, d7);
        tessellator.a(d10, d12, d15, d5, d7);
        tessellator.a(d10, d13, d15, d5, d6);
        tessellator.a(d10, d13, d14, d4, d6);
        tessellator.a(d11, d12, d15, d4, d7);
        tessellator.a(d11, d12, d14, d5, d7);
        tessellator.a(d11, d13, d14, d5, d6);
        tessellator.a(d11, d13, d15, d4, d6);
        tessellator.a(d11, d12, d14, d4, d7);
        tessellator.a(d10, d12, d14, d5, d7);
        tessellator.a(d10, d13, d14, d5, d6);
        tessellator.a(d11, d13, d14, d4, d6);
        tessellator.a(d10, d12, d15, d4, d7);
        tessellator.a(d11, d12, d15, d5, d7);
        tessellator.a(d11, d13, d15, d5, d6);
        tessellator.a(d10, d13, d15, d4, d6);
        int i2 = k1;
        if (j1 >= 2) {
            i2 = k1 - 1;
        }
        d4 = icon.c();
        d5 = icon.a((double)i2);
        d6 = icon.e();
        d7 = icon.b((double)i2);
        tessellator.a(d10, d13, d15, d4, d7);
        tessellator.a(d11, d13, d15, d5, d7);
        tessellator.a(d11, d13, d14, d5, d6);
        tessellator.a(d10, d13, d14, d4, d6);
        tessellator.a(d10, d12, d14, d4, d6);
        tessellator.a(d11, d12, d14, d5, d6);
        tessellator.a(d11, d12, d15, d5, d7);
        tessellator.a(d10, d12, d15, d4, d7);
        d4 = icon.a(12.0);
        d5 = icon.d();
        d6 = icon.e();
        d7 = icon.b(4.0);
        d8 = 8.0;
        d9 = 0.0;
        switch (i1) {
            case 0: {
                d8 = 8.0;
                d9 = 12.0;
                double d16 = d4;
                d4 = d5;
                d5 = d16;
                break;
            }
            case 1: {
                d8 = 0.0;
                d9 = 8.0;
                break;
            }
            case 2: {
                d8 = 8.0;
                d9 = 0.0;
                break;
            }
            case 3: {
                d8 = 12.0;
                d9 = 8.0;
                double d16 = d4;
                d4 = d5;
                d5 = d16;
            }
        }
        d10 = (double)par2 + d8 / 16.0;
        d11 = (double)par2 + (d8 + 4.0) / 16.0;
        d12 = (double)par3 + 0.75;
        d13 = (double)par3 + 1.0;
        d14 = (double)par4 + d9 / 16.0;
        d15 = (double)par4 + (d9 + 4.0) / 16.0;
        if (i1 != 2 && i1 != 0) {
            if (i1 == 1 || i1 == 3) {
                tessellator.a(d11, d12, d14, d4, d7);
                tessellator.a(d10, d12, d14, d5, d7);
                tessellator.a(d10, d13, d14, d5, d6);
                tessellator.a(d11, d13, d14, d4, d6);
                tessellator.a(d10, d12, d14, d5, d7);
                tessellator.a(d11, d12, d14, d4, d7);
                tessellator.a(d11, d13, d14, d4, d6);
                tessellator.a(d10, d13, d14, d5, d6);
            }
        } else {
            tessellator.a(d10, d12, d14, d5, d7);
            tessellator.a(d10, d12, d15, d4, d7);
            tessellator.a(d10, d13, d15, d4, d6);
            tessellator.a(d10, d13, d14, d5, d6);
            tessellator.a(d10, d12, d15, d4, d7);
            tessellator.a(d10, d12, d14, d5, d7);
            tessellator.a(d10, d13, d14, d5, d6);
            tessellator.a(d10, d13, d15, d4, d6);
        }
        return true;
    }

    public boolean a(ana par1BlockBeacon, int par2, int par3, int par4) {
        float f2 = 0.1875f;
        this.a(this.b(aqz.R));
        this.a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
        this.p((aqz)par1BlockBeacon, par2, par3, par4);
        this.f = true;
        this.a(this.b(aqz.au));
        this.a(0.125, 0.00625f, 0.125, 0.875, (double)f2, 0.875);
        this.p((aqz)par1BlockBeacon, par2, par3, par4);
        this.a(this.b((aqz)aqz.cf));
        this.a(0.1875, f2, 0.1875, 0.8125, 0.875, 0.8125);
        this.p((aqz)par1BlockBeacon, par2, par3, par4);
        this.f = false;
        this.a();
        return true;
    }

    public boolean s(aqz par1Block, int par2, int par3, int par4) {
        int l2 = par1Block.c(this.a, par2, par3, par4);
        float f2 = (float)(l2 >> 16 & 0xFF) / 255.0f;
        float f1 = (float)(l2 >> 8 & 0xFF) / 255.0f;
        float f22 = (float)(l2 & 0xFF) / 255.0f;
        if (bfe.a) {
            float f3 = (f2 * 30.0f + f1 * 59.0f + f22 * 11.0f) / 100.0f;
            float f4 = (f2 * 30.0f + f1 * 70.0f) / 100.0f;
            float f5 = (f2 * 30.0f + f22 * 70.0f) / 100.0f;
            f2 = f3;
            f1 = f4;
            f22 = f5;
        }
        return this.e(par1Block, par2, par3, par4, f2, f1, f22);
    }

    public boolean e(aqz par1Block, int par2, int par3, int par4, float par5, float par6, float par7) {
        bfq tessellator = bfq.a;
        boolean flag = false;
        float f3 = 0.5f;
        float f4 = 1.0f;
        float f5 = 0.8f;
        float f6 = 0.6f;
        float f7 = f3 * par5;
        float f8 = f4 * par5;
        float f9 = f5 * par5;
        float f10 = f6 * par5;
        float f11 = f3 * par6;
        float f12 = f4 * par6;
        float f13 = f5 * par6;
        float f14 = f6 * par6;
        float f15 = f3 * par7;
        float f16 = f4 * par7;
        float f17 = f5 * par7;
        float f18 = f6 * par7;
        float f19 = 0.0625f;
        int l2 = par1Block.e(this.a, par2, par3, par4);
        if (this.f || par1Block.a(this.a, par2, par3 - 1, par4, 0)) {
            tessellator.c(this.i > 0.0 ? l2 : par1Block.e(this.a, par2, par3 - 1, par4));
            tessellator.a(f7, f11, f15);
            this.a(par1Block, (double)par2, (double)par3, (double)par4, this.a(par1Block, this.a, par2, par3, par4, 0));
        }
        if (this.f || par1Block.a(this.a, par2, par3 + 1, par4, 1)) {
            tessellator.c(this.j < 1.0 ? l2 : par1Block.e(this.a, par2, par3 + 1, par4));
            tessellator.a(f8, f12, f16);
            this.b(par1Block, (double)par2, (double)par3, (double)par4, this.a(par1Block, this.a, par2, par3, par4, 1));
        }
        tessellator.c(l2);
        tessellator.a(f9, f13, f17);
        tessellator.c(0.0f, 0.0f, f19);
        this.c(par1Block, (double)par2, (double)par3, (double)par4, this.a(par1Block, this.a, par2, par3, par4, 2));
        tessellator.c(0.0f, 0.0f, -f19);
        tessellator.c(0.0f, 0.0f, -f19);
        this.d(par1Block, par2, par3, par4, this.a(par1Block, this.a, par2, par3, par4, 3));
        tessellator.c(0.0f, 0.0f, f19);
        tessellator.a(f10, f14, f18);
        tessellator.c(f19, 0.0f, 0.0f);
        this.e(par1Block, par2, par3, par4, this.a(par1Block, this.a, par2, par3, par4, 4));
        tessellator.c(-f19, 0.0f, 0.0f);
        tessellator.c(-f19, 0.0f, 0.0f);
        this.f(par1Block, par2, par3, par4, this.a(par1Block, this.a, par2, par3, par4, 5));
        tessellator.c(f19, 0.0f, 0.0f);
        return true;
    }

    public boolean a(aoh par1BlockFence, int par2, int par3, int par4) {
        float f7;
        boolean flag = false;
        float f2 = 0.375f;
        float f1 = 0.625f;
        this.a(f2, 0.0, (double)f2, (double)f1, 1.0, (double)f1);
        this.p((aqz)par1BlockFence, par2, par3, par4);
        flag = true;
        boolean flag1 = false;
        boolean flag2 = false;
        if (par1BlockFence.d(this.a, par2 - 1, par3, par4) || par1BlockFence.d(this.a, par2 + 1, par3, par4)) {
            flag1 = true;
        }
        if (par1BlockFence.d(this.a, par2, par3, par4 - 1) || par1BlockFence.d(this.a, par2, par3, par4 + 1)) {
            flag2 = true;
        }
        boolean flag3 = par1BlockFence.d(this.a, par2 - 1, par3, par4);
        boolean flag4 = par1BlockFence.d(this.a, par2 + 1, par3, par4);
        boolean flag5 = par1BlockFence.d(this.a, par2, par3, par4 - 1);
        boolean flag6 = par1BlockFence.d(this.a, par2, par3, par4 + 1);
        if (!flag1 && !flag2) {
            flag1 = true;
        }
        f2 = 0.4375f;
        f1 = 0.5625f;
        float f22 = 0.75f;
        float f3 = 0.9375f;
        float f4 = flag3 ? 0.0f : f2;
        float f5 = flag4 ? 1.0f : f1;
        float f6 = flag5 ? 0.0f : f2;
        float f8 = f7 = flag6 ? 1.0f : f1;
        if (flag1) {
            this.a(f4, f22, (double)f2, (double)f5, (double)f3, (double)f1);
            this.p((aqz)par1BlockFence, par2, par3, par4);
            flag = true;
        }
        if (flag2) {
            this.a(f2, f22, (double)f6, (double)f1, (double)f3, (double)f7);
            this.p((aqz)par1BlockFence, par2, par3, par4);
            flag = true;
        }
        f22 = 0.375f;
        f3 = 0.5625f;
        if (flag1) {
            this.a(f4, f22, (double)f2, (double)f5, (double)f3, (double)f1);
            this.p((aqz)par1BlockFence, par2, par3, par4);
            flag = true;
        }
        if (flag2) {
            this.a(f2, f22, (double)f6, (double)f1, (double)f3, (double)f7);
            this.p((aqz)par1BlockFence, par2, par3, par4);
            flag = true;
        }
        par1BlockFence.a(this.a, par2, par3, par4);
        return flag;
    }

    public boolean a(arn par1BlockWall, int par2, int par3, int par4) {
        boolean flag = par1BlockWall.d(this.a, par2 - 1, par3, par4);
        boolean flag1 = par1BlockWall.d(this.a, par2 + 1, par3, par4);
        boolean flag2 = par1BlockWall.d(this.a, par2, par3, par4 - 1);
        boolean flag3 = par1BlockWall.d(this.a, par2, par3, par4 + 1);
        boolean flag4 = flag2 && flag3 && !flag && !flag1;
        boolean flag5 = !flag2 && !flag3 && flag && flag1;
        boolean flag6 = this.a.c(par2, par3 + 1, par4);
        if ((flag4 || flag5) && flag6) {
            if (flag4) {
                this.a(0.3125, 0.0, 0.0, 0.6875, 0.8125, 1.0);
                this.p((aqz)par1BlockWall, par2, par3, par4);
            } else {
                this.a(0.0, 0.0, 0.3125, 1.0, 0.8125, 0.6875);
                this.p((aqz)par1BlockWall, par2, par3, par4);
            }
        } else {
            this.a(0.25, 0.0, 0.25, 0.75, 1.0, 0.75);
            this.p((aqz)par1BlockWall, par2, par3, par4);
            if (flag) {
                this.a(0.0, 0.0, 0.3125, 0.25, 0.8125, 0.6875);
                this.p((aqz)par1BlockWall, par2, par3, par4);
            }
            if (flag1) {
                this.a(0.75, 0.0, 0.3125, 1.0, 0.8125, 0.6875);
                this.p((aqz)par1BlockWall, par2, par3, par4);
            }
            if (flag2) {
                this.a(0.3125, 0.0, 0.0, 0.6875, 0.8125, 0.25);
                this.p((aqz)par1BlockWall, par2, par3, par4);
            }
            if (flag3) {
                this.a(0.3125, 0.0, 0.75, 0.6875, 0.8125, 1.0);
                this.p((aqz)par1BlockWall, par2, par3, par4);
            }
        }
        par1BlockWall.a(this.a, par2, par3, par4);
        return true;
    }

    public boolean a(aob par1BlockDragonEgg, int par2, int par3, int par4) {
        boolean flag = false;
        int l2 = 0;
        for (int i1 = 0; i1 < 8; ++i1) {
            int b0 = 0;
            int b1 = 1;
            if (i1 == 0) {
                b0 = 2;
            }
            if (i1 == 1) {
                b0 = 3;
            }
            if (i1 == 2) {
                b0 = 4;
            }
            if (i1 == 3) {
                b0 = 5;
                b1 = 2;
            }
            if (i1 == 4) {
                b0 = 6;
                b1 = 3;
            }
            if (i1 == 5) {
                b0 = 7;
                b1 = 5;
            }
            if (i1 == 6) {
                b0 = 6;
                b1 = 2;
            }
            if (i1 == 7) {
                b0 = 3;
            }
            float f2 = (float)b0 / 16.0f;
            float f1 = 1.0f - (float)l2 / 16.0f;
            float f22 = 1.0f - (float)(l2 + b1) / 16.0f;
            l2 += b1;
            this.a(0.5f - f2, f22, (double)(0.5f - f2), (double)(0.5f + f2), (double)f1, (double)(0.5f + f2));
            this.p((aqz)par1BlockDragonEgg, par2, par3, par4);
        }
        flag = true;
        this.a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
        return flag;
    }

    public boolean a(aog par1BlockFenceGate, int par2, int par3, int par4) {
        float f9;
        float f7;
        float f8;
        float f6;
        boolean flag = true;
        int l2 = this.a.h(par2, par3, par4);
        boolean flag1 = aog.m_((int)l2);
        int i1 = anw.j((int)l2);
        float f2 = 0.375f;
        float f1 = 0.5625f;
        float f22 = 0.75f;
        float f3 = 0.9375f;
        float f4 = 0.3125f;
        float f5 = 1.0f;
        if ((i1 == 2 || i1 == 0) && this.a.a(par2 - 1, par3, par4) == aqz.cg.cF && this.a.a(par2 + 1, par3, par4) == aqz.cg.cF || (i1 == 3 || i1 == 1) && this.a.a(par2, par3, par4 - 1) == aqz.cg.cF && this.a.a(par2, par3, par4 + 1) == aqz.cg.cF) {
            f2 -= 0.1875f;
            f1 -= 0.1875f;
            f22 -= 0.1875f;
            f3 -= 0.1875f;
            f4 -= 0.1875f;
            f5 -= 0.1875f;
        }
        this.f = true;
        if (i1 != 3 && i1 != 1) {
            f6 = 0.0f;
            f8 = 0.125f;
            f7 = 0.4375f;
            f9 = 0.5625f;
            this.a(f6, f4, (double)f7, (double)f8, (double)f5, (double)f9);
            this.p((aqz)par1BlockFenceGate, par2, par3, par4);
            f6 = 0.875f;
            f8 = 1.0f;
            this.a(f6, f4, (double)f7, (double)f8, (double)f5, (double)f9);
            this.p((aqz)par1BlockFenceGate, par2, par3, par4);
        } else {
            this.t = 1;
            f6 = 0.4375f;
            f8 = 0.5625f;
            f7 = 0.0f;
            f9 = 0.125f;
            this.a(f6, f4, (double)f7, (double)f8, (double)f5, (double)f9);
            this.p((aqz)par1BlockFenceGate, par2, par3, par4);
            f7 = 0.875f;
            f9 = 1.0f;
            this.a(f6, f4, (double)f7, (double)f8, (double)f5, (double)f9);
            this.p((aqz)par1BlockFenceGate, par2, par3, par4);
            this.t = 0;
        }
        if (flag1) {
            if (i1 == 2 || i1 == 0) {
                this.t = 1;
            }
            if (i1 == 3) {
                f6 = 0.0f;
                f8 = 0.125f;
                f7 = 0.875f;
                f9 = 1.0f;
                float f10 = 0.5625f;
                float f12 = 0.8125f;
                float f11 = 0.9375f;
                this.a(0.8125, f2, 0.0, 0.9375, (double)f3, 0.125);
                this.p((aqz)par1BlockFenceGate, par2, par3, par4);
                this.a(0.8125, f2, 0.875, 0.9375, (double)f3, 1.0);
                this.p((aqz)par1BlockFenceGate, par2, par3, par4);
                this.a(0.5625, f2, 0.0, 0.8125, (double)f1, 0.125);
                this.p((aqz)par1BlockFenceGate, par2, par3, par4);
                this.a(0.5625, f2, 0.875, 0.8125, (double)f1, 1.0);
                this.p((aqz)par1BlockFenceGate, par2, par3, par4);
                this.a(0.5625, f22, 0.0, 0.8125, (double)f3, 0.125);
                this.p((aqz)par1BlockFenceGate, par2, par3, par4);
                this.a(0.5625, f22, 0.875, 0.8125, (double)f3, 1.0);
                this.p((aqz)par1BlockFenceGate, par2, par3, par4);
            } else if (i1 == 1) {
                f6 = 0.0f;
                f8 = 0.125f;
                f7 = 0.875f;
                f9 = 1.0f;
                float f10 = 0.0625f;
                float f12 = 0.1875f;
                float f11 = 0.4375f;
                this.a(0.0625, f2, 0.0, 0.1875, (double)f3, 0.125);
                this.p((aqz)par1BlockFenceGate, par2, par3, par4);
                this.a(0.0625, f2, 0.875, 0.1875, (double)f3, 1.0);
                this.p((aqz)par1BlockFenceGate, par2, par3, par4);
                this.a(0.1875, f2, 0.0, 0.4375, (double)f1, 0.125);
                this.p((aqz)par1BlockFenceGate, par2, par3, par4);
                this.a(0.1875, f2, 0.875, 0.4375, (double)f1, 1.0);
                this.p((aqz)par1BlockFenceGate, par2, par3, par4);
                this.a(0.1875, f22, 0.0, 0.4375, (double)f3, 0.125);
                this.p((aqz)par1BlockFenceGate, par2, par3, par4);
                this.a(0.1875, f22, 0.875, 0.4375, (double)f3, 1.0);
                this.p((aqz)par1BlockFenceGate, par2, par3, par4);
            } else if (i1 == 0) {
                f6 = 0.0f;
                f8 = 0.125f;
                f7 = 0.875f;
                f9 = 1.0f;
                float f10 = 0.5625f;
                float f12 = 0.8125f;
                float f11 = 0.9375f;
                this.a(0.0, f2, 0.8125, 0.125, (double)f3, 0.9375);
                this.p((aqz)par1BlockFenceGate, par2, par3, par4);
                this.a(0.875, f2, 0.8125, 1.0, (double)f3, 0.9375);
                this.p((aqz)par1BlockFenceGate, par2, par3, par4);
                this.a(0.0, f2, 0.5625, 0.125, (double)f1, 0.8125);
                this.p((aqz)par1BlockFenceGate, par2, par3, par4);
                this.a(0.875, f2, 0.5625, 1.0, (double)f1, 0.8125);
                this.p((aqz)par1BlockFenceGate, par2, par3, par4);
                this.a(0.0, f22, 0.5625, 0.125, (double)f3, 0.8125);
                this.p((aqz)par1BlockFenceGate, par2, par3, par4);
                this.a(0.875, f22, 0.5625, 1.0, (double)f3, 0.8125);
                this.p((aqz)par1BlockFenceGate, par2, par3, par4);
            } else if (i1 == 2) {
                f6 = 0.0f;
                f8 = 0.125f;
                f7 = 0.875f;
                f9 = 1.0f;
                float f10 = 0.0625f;
                float f12 = 0.1875f;
                float f11 = 0.4375f;
                this.a(0.0, f2, 0.0625, 0.125, (double)f3, 0.1875);
                this.p((aqz)par1BlockFenceGate, par2, par3, par4);
                this.a(0.875, f2, 0.0625, 1.0, (double)f3, 0.1875);
                this.p((aqz)par1BlockFenceGate, par2, par3, par4);
                this.a(0.0, f2, 0.1875, 0.125, (double)f1, 0.4375);
                this.p((aqz)par1BlockFenceGate, par2, par3, par4);
                this.a(0.875, f2, 0.1875, 1.0, (double)f1, 0.4375);
                this.p((aqz)par1BlockFenceGate, par2, par3, par4);
                this.a(0.0, f22, 0.1875, 0.125, (double)f3, 0.4375);
                this.p((aqz)par1BlockFenceGate, par2, par3, par4);
                this.a(0.875, f22, 0.1875, 1.0, (double)f3, 0.4375);
                this.p((aqz)par1BlockFenceGate, par2, par3, par4);
            }
        } else if (i1 != 3 && i1 != 1) {
            f6 = 0.375f;
            f8 = 0.5f;
            f7 = 0.4375f;
            f9 = 0.5625f;
            this.a(f6, f2, (double)f7, (double)f8, (double)f3, (double)f9);
            this.p((aqz)par1BlockFenceGate, par2, par3, par4);
            f6 = 0.5f;
            f8 = 0.625f;
            this.a(f6, f2, (double)f7, (double)f8, (double)f3, (double)f9);
            this.p((aqz)par1BlockFenceGate, par2, par3, par4);
            f6 = 0.625f;
            f8 = 0.875f;
            this.a(f6, f2, (double)f7, (double)f8, (double)f1, (double)f9);
            this.p((aqz)par1BlockFenceGate, par2, par3, par4);
            this.a(f6, f22, (double)f7, (double)f8, (double)f3, (double)f9);
            this.p((aqz)par1BlockFenceGate, par2, par3, par4);
            f6 = 0.125f;
            f8 = 0.375f;
            this.a(f6, f2, (double)f7, (double)f8, (double)f1, (double)f9);
            this.p((aqz)par1BlockFenceGate, par2, par3, par4);
            this.a(f6, f22, (double)f7, (double)f8, (double)f3, (double)f9);
            this.p((aqz)par1BlockFenceGate, par2, par3, par4);
        } else {
            this.t = 1;
            f6 = 0.4375f;
            f8 = 0.5625f;
            f7 = 0.375f;
            f9 = 0.5f;
            this.a(f6, f2, (double)f7, (double)f8, (double)f3, (double)f9);
            this.p((aqz)par1BlockFenceGate, par2, par3, par4);
            f7 = 0.5f;
            f9 = 0.625f;
            this.a(f6, f2, (double)f7, (double)f8, (double)f3, (double)f9);
            this.p((aqz)par1BlockFenceGate, par2, par3, par4);
            f7 = 0.625f;
            f9 = 0.875f;
            this.a(f6, f2, (double)f7, (double)f8, (double)f1, (double)f9);
            this.p((aqz)par1BlockFenceGate, par2, par3, par4);
            this.a(f6, f22, (double)f7, (double)f8, (double)f3, (double)f9);
            this.p((aqz)par1BlockFenceGate, par2, par3, par4);
            f7 = 0.125f;
            f9 = 0.375f;
            this.a(f6, f2, (double)f7, (double)f8, (double)f1, (double)f9);
            this.p((aqz)par1BlockFenceGate, par2, par3, par4);
            this.a(f6, f22, (double)f7, (double)f8, (double)f3, (double)f9);
            this.p((aqz)par1BlockFenceGate, par2, par3, par4);
        }
        this.f = false;
        this.t = 0;
        this.a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
        return flag;
    }

    public boolean a(aot par1BlockHopper, int par2, int par3, int par4) {
        bfq tessellator = bfq.a;
        tessellator.c(par1BlockHopper.e(this.a, par2, par3, par4));
        float f2 = 1.0f;
        int l2 = par1BlockHopper.c(this.a, par2, par3, par4);
        float f1 = (float)(l2 >> 16 & 0xFF) / 255.0f;
        float f22 = (float)(l2 >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(l2 & 0xFF) / 255.0f;
        if (bfe.a) {
            float f4 = (f1 * 30.0f + f22 * 59.0f + f3 * 11.0f) / 100.0f;
            float f5 = (f1 * 30.0f + f22 * 70.0f) / 100.0f;
            float f6 = (f1 * 30.0f + f3 * 70.0f) / 100.0f;
            f1 = f4;
            f22 = f5;
            f3 = f6;
        }
        tessellator.a(f2 * f1, f2 * f22, f2 * f3);
        return this.a(par1BlockHopper, par2, par3, par4, this.a.h(par2, par3, par4), false);
    }

    public boolean a(aot par1BlockHopper, int par2, int par3, int par4, int par5, boolean par6) {
        float f2;
        bfq tessellator = bfq.a;
        int i1 = aot.c((int)par5);
        double d0 = 0.625;
        this.a(0.0, d0, 0.0, 1.0, 1.0, 1.0);
        if (par6) {
            tessellator.b();
            tessellator.b(0.0f, -1.0f, 0.0f);
            this.a((aqz)par1BlockHopper, 0.0, 0.0, 0.0, this.a((aqz)par1BlockHopper, 0, par5));
            tessellator.a();
            tessellator.b();
            tessellator.b(0.0f, 1.0f, 0.0f);
            this.b((aqz)par1BlockHopper, 0.0, 0.0, 0.0, this.a((aqz)par1BlockHopper, 1, par5));
            tessellator.a();
            tessellator.b();
            tessellator.b(0.0f, 0.0f, -1.0f);
            this.c((aqz)par1BlockHopper, 0.0, 0.0, 0.0, this.a((aqz)par1BlockHopper, 2, par5));
            tessellator.a();
            tessellator.b();
            tessellator.b(0.0f, 0.0f, 1.0f);
            this.d((aqz)par1BlockHopper, 0.0, 0.0, 0.0, this.a((aqz)par1BlockHopper, 3, par5));
            tessellator.a();
            tessellator.b();
            tessellator.b(-1.0f, 0.0f, 0.0f);
            this.e((aqz)par1BlockHopper, 0.0, 0.0, 0.0, this.a((aqz)par1BlockHopper, 4, par5));
            tessellator.a();
            tessellator.b();
            tessellator.b(1.0f, 0.0f, 0.0f);
            this.f((aqz)par1BlockHopper, 0.0, 0.0, 0.0, this.a((aqz)par1BlockHopper, 5, par5));
            tessellator.a();
        } else {
            this.p((aqz)par1BlockHopper, par2, par3, par4);
        }
        if (!par6) {
            tessellator.c(par1BlockHopper.e(this.a, par2, par3, par4));
            float f1 = 1.0f;
            int j1 = par1BlockHopper.c(this.a, par2, par3, par4);
            f2 = (float)(j1 >> 16 & 0xFF) / 255.0f;
            float f22 = (float)(j1 >> 8 & 0xFF) / 255.0f;
            float f3 = (float)(j1 & 0xFF) / 255.0f;
            if (bfe.a) {
                float f4 = (f2 * 30.0f + f22 * 59.0f + f3 * 11.0f) / 100.0f;
                float f5 = (f2 * 30.0f + f22 * 70.0f) / 100.0f;
                float f6 = (f2 * 30.0f + f3 * 70.0f) / 100.0f;
                f2 = f4;
                f22 = f5;
                f3 = f6;
            }
            tessellator.a(f1 * f2, f1 * f22, f1 * f3);
        }
        ms icon = aot.b((String)"hopper_outside");
        ms icon1 = aot.b((String)"hopper_inside");
        f2 = 0.125f;
        if (par6) {
            tessellator.b();
            tessellator.b(1.0f, 0.0f, 0.0f);
            this.f((aqz)par1BlockHopper, -1.0f + f2, 0.0, 0.0, icon);
            tessellator.a();
            tessellator.b();
            tessellator.b(-1.0f, 0.0f, 0.0f);
            this.e((aqz)par1BlockHopper, 1.0f - f2, 0.0, 0.0, icon);
            tessellator.a();
            tessellator.b();
            tessellator.b(0.0f, 0.0f, 1.0f);
            this.d((aqz)par1BlockHopper, 0.0, 0.0, -1.0f + f2, icon);
            tessellator.a();
            tessellator.b();
            tessellator.b(0.0f, 0.0f, -1.0f);
            this.c((aqz)par1BlockHopper, 0.0, 0.0, 1.0f - f2, icon);
            tessellator.a();
            tessellator.b();
            tessellator.b(0.0f, 1.0f, 0.0f);
            this.b((aqz)par1BlockHopper, 0.0, -1.0 + d0, 0.0, icon1);
            tessellator.a();
        } else {
            this.f((aqz)par1BlockHopper, (float)par2 - 1.0f + f2, par3, par4, icon);
            this.e((aqz)par1BlockHopper, (float)par2 + 1.0f - f2, par3, par4, icon);
            this.d((aqz)par1BlockHopper, par2, par3, (float)par4 - 1.0f + f2, icon);
            this.c((aqz)par1BlockHopper, (double)par2, (double)par3, (float)par4 + 1.0f - f2, icon);
            this.b((aqz)par1BlockHopper, (double)par2, (double)((float)par3 - 1.0f) + d0, (double)par4, icon1);
        }
        this.a(icon);
        double d1 = 0.25;
        double d2 = 0.25;
        this.a(d1, d2, d1, 1.0 - d1, d0 - 0.002, 1.0 - d1);
        if (par6) {
            tessellator.b();
            tessellator.b(1.0f, 0.0f, 0.0f);
            this.f((aqz)par1BlockHopper, 0.0, 0.0, 0.0, icon);
            tessellator.a();
            tessellator.b();
            tessellator.b(-1.0f, 0.0f, 0.0f);
            this.e((aqz)par1BlockHopper, 0.0, 0.0, 0.0, icon);
            tessellator.a();
            tessellator.b();
            tessellator.b(0.0f, 0.0f, 1.0f);
            this.d((aqz)par1BlockHopper, 0.0, 0.0, 0.0, icon);
            tessellator.a();
            tessellator.b();
            tessellator.b(0.0f, 0.0f, -1.0f);
            this.c((aqz)par1BlockHopper, 0.0, 0.0, 0.0, icon);
            tessellator.a();
            tessellator.b();
            tessellator.b(0.0f, 1.0f, 0.0f);
            this.b((aqz)par1BlockHopper, 0.0, 0.0, 0.0, icon);
            tessellator.a();
            tessellator.b();
            tessellator.b(0.0f, -1.0f, 0.0f);
            this.a((aqz)par1BlockHopper, 0.0, 0.0, 0.0, icon);
            tessellator.a();
        } else {
            this.p((aqz)par1BlockHopper, par2, par3, par4);
        }
        if (!par6) {
            double d3 = 0.375;
            double d4 = 0.25;
            this.a(icon);
            if (i1 == 0) {
                this.a(d3, 0.0, d3, 1.0 - d3, 0.25, 1.0 - d3);
                this.p((aqz)par1BlockHopper, par2, par3, par4);
            }
            if (i1 == 2) {
                this.a(d3, d2, 0.0, 1.0 - d3, d2 + d4, d1);
                this.p((aqz)par1BlockHopper, par2, par3, par4);
            }
            if (i1 == 3) {
                this.a(d3, d2, 1.0 - d1, 1.0 - d3, d2 + d4, 1.0);
                this.p((aqz)par1BlockHopper, par2, par3, par4);
            }
            if (i1 == 4) {
                this.a(0.0, d2, d3, d1, d2 + d4, 1.0 - d3);
                this.p((aqz)par1BlockHopper, par2, par3, par4);
            }
            if (i1 == 5) {
                this.a(1.0 - d1, d2, d3, 1.0, d2 + d4, 1.0 - d3);
                this.p((aqz)par1BlockHopper, par2, par3, par4);
            }
        }
        this.a();
        return true;
    }

    public boolean a(aqp par1BlockStairs, int par2, int par3, int par4) {
        par1BlockStairs.d(this.a, par2, par3, par4);
        this.a((aqz)par1BlockStairs);
        this.p((aqz)par1BlockStairs, par2, par3, par4);
        boolean flag = par1BlockStairs.g(this.a, par2, par3, par4);
        this.a((aqz)par1BlockStairs);
        this.p((aqz)par1BlockStairs, par2, par3, par4);
        if (flag && par1BlockStairs.h(this.a, par2, par3, par4)) {
            this.a((aqz)par1BlockStairs);
            this.p((aqz)par1BlockStairs, par2, par3, par4);
        }
        return true;
    }

    public boolean t(aqz par1Block, int par2, int par3, int par4) {
        bfq tessellator = bfq.a;
        int l2 = this.a.h(par2, par3, par4);
        if ((l2 & 8) != 0 ? this.a.a(par2, par3 - 1, par4) != par1Block.cF : this.a.a(par2, par3 + 1, par4) != par1Block.cF) {
            return false;
        }
        boolean flag = false;
        float f2 = 0.5f;
        float f1 = 1.0f;
        float f22 = 0.8f;
        float f3 = 0.6f;
        int i1 = par1Block.e(this.a, par2, par3, par4);
        tessellator.c(this.i > 0.0 ? i1 : par1Block.e(this.a, par2, par3 - 1, par4));
        tessellator.a(f2, f2, f2);
        this.a(par1Block, (double)par2, (double)par3, (double)par4, this.a(par1Block, this.a, par2, par3, par4, 0));
        flag = true;
        tessellator.c(this.j < 1.0 ? i1 : par1Block.e(this.a, par2, par3 + 1, par4));
        tessellator.a(f1, f1, f1);
        this.b(par1Block, (double)par2, (double)par3, (double)par4, this.a(par1Block, this.a, par2, par3, par4, 1));
        flag = true;
        tessellator.c(this.k > 0.0 ? i1 : par1Block.e(this.a, par2, par3, par4 - 1));
        tessellator.a(f22, f22, f22);
        ms icon = this.a(par1Block, this.a, par2, par3, par4, 2);
        this.c(par1Block, (double)par2, (double)par3, (double)par4, icon);
        flag = true;
        this.e = false;
        tessellator.c(this.l < 1.0 ? i1 : par1Block.e(this.a, par2, par3, par4 + 1));
        tessellator.a(f22, f22, f22);
        icon = this.a(par1Block, this.a, par2, par3, par4, 3);
        this.d(par1Block, par2, par3, par4, icon);
        flag = true;
        this.e = false;
        tessellator.c(this.g > 0.0 ? i1 : par1Block.e(this.a, par2 - 1, par3, par4));
        tessellator.a(f3, f3, f3);
        icon = this.a(par1Block, this.a, par2, par3, par4, 4);
        this.e(par1Block, par2, par3, par4, icon);
        flag = true;
        this.e = false;
        tessellator.c(this.h < 1.0 ? i1 : par1Block.e(this.a, par2 + 1, par3, par4));
        tessellator.a(f3, f3, f3);
        icon = this.a(par1Block, this.a, par2, par3, par4, 5);
        this.f(par1Block, par2, par3, par4, icon);
        flag = true;
        this.e = false;
        return flag;
    }

    public void a(aqz par1Block, double par2, double par4, double par6, ms par8Icon) {
        bfq tessellator = bfq.a;
        if (this.b()) {
            par8Icon = this.d;
        }
        double d3 = par8Icon.a(this.g * 16.0);
        double d4 = par8Icon.a(this.h * 16.0);
        double d5 = par8Icon.b(this.k * 16.0);
        double d6 = par8Icon.b(this.l * 16.0);
        if (this.g < 0.0 || this.h > 1.0) {
            d3 = par8Icon.c();
            d4 = par8Icon.d();
        }
        if (this.k < 0.0 || this.l > 1.0) {
            d5 = par8Icon.e();
            d6 = par8Icon.f();
        }
        double d7 = d4;
        double d8 = d3;
        double d9 = d5;
        double d10 = d6;
        if (this.u == 2) {
            d3 = par8Icon.a(this.k * 16.0);
            d5 = par8Icon.b(16.0 - this.h * 16.0);
            d4 = par8Icon.a(this.l * 16.0);
            d6 = par8Icon.b(16.0 - this.g * 16.0);
            d9 = d5;
            d10 = d6;
            d7 = d3;
            d8 = d4;
            d5 = d6;
            d6 = d9;
        } else if (this.u == 1) {
            d3 = par8Icon.a(16.0 - this.l * 16.0);
            d5 = par8Icon.b(this.g * 16.0);
            d4 = par8Icon.a(16.0 - this.k * 16.0);
            d6 = par8Icon.b(this.h * 16.0);
            d7 = d4;
            d8 = d3;
            d3 = d4;
            d4 = d8;
            d9 = d6;
            d10 = d5;
        } else if (this.u == 3) {
            d3 = par8Icon.a(16.0 - this.g * 16.0);
            d4 = par8Icon.a(16.0 - this.h * 16.0);
            d5 = par8Icon.b(16.0 - this.k * 16.0);
            d6 = par8Icon.b(16.0 - this.l * 16.0);
            d7 = d4;
            d8 = d3;
            d9 = d5;
            d10 = d6;
        }
        double d11 = par2 + this.g;
        double d12 = par2 + this.h;
        double d13 = par4 + this.i;
        double d14 = par6 + this.k;
        double d15 = par6 + this.l;
        if (this.v) {
            tessellator.a(this.ao, this.as, this.aw);
            tessellator.c(this.ak);
            tessellator.a(d11, d13, d15, d8, d10);
            tessellator.a(this.ap, this.at, this.ax);
            tessellator.c(this.al);
            tessellator.a(d11, d13, d14, d3, d5);
            tessellator.a(this.aq, this.au, this.ay);
            tessellator.c(this.am);
            tessellator.a(d12, d13, d14, d7, d9);
            tessellator.a(this.ar, this.av, this.az);
            tessellator.c(this.an);
            tessellator.a(d12, d13, d15, d4, d6);
        } else {
            tessellator.a(d11, d13, d15, d8, d10);
            tessellator.a(d11, d13, d14, d3, d5);
            tessellator.a(d12, d13, d14, d7, d9);
            tessellator.a(d12, d13, d15, d4, d6);
        }
    }

    public void b(aqz par1Block, double par2, double par4, double par6, ms par8Icon) {
        bfq tessellator = bfq.a;
        if (this.b()) {
            par8Icon = this.d;
        }
        double d3 = par8Icon.a(this.g * 16.0);
        double d4 = par8Icon.a(this.h * 16.0);
        double d5 = par8Icon.b(this.k * 16.0);
        double d6 = par8Icon.b(this.l * 16.0);
        if (this.g < 0.0 || this.h > 1.0) {
            d3 = par8Icon.c();
            d4 = par8Icon.d();
        }
        if (this.k < 0.0 || this.l > 1.0) {
            d5 = par8Icon.e();
            d6 = par8Icon.f();
        }
        double d7 = d4;
        double d8 = d3;
        double d9 = d5;
        double d10 = d6;
        if (this.t == 1) {
            d3 = par8Icon.a(this.k * 16.0);
            d5 = par8Icon.b(16.0 - this.h * 16.0);
            d4 = par8Icon.a(this.l * 16.0);
            d6 = par8Icon.b(16.0 - this.g * 16.0);
            d9 = d5;
            d10 = d6;
            d7 = d3;
            d8 = d4;
            d5 = d6;
            d6 = d9;
        } else if (this.t == 2) {
            d3 = par8Icon.a(16.0 - this.l * 16.0);
            d5 = par8Icon.b(this.g * 16.0);
            d4 = par8Icon.a(16.0 - this.k * 16.0);
            d6 = par8Icon.b(this.h * 16.0);
            d7 = d4;
            d8 = d3;
            d3 = d4;
            d4 = d8;
            d9 = d6;
            d10 = d5;
        } else if (this.t == 3) {
            d3 = par8Icon.a(16.0 - this.g * 16.0);
            d4 = par8Icon.a(16.0 - this.h * 16.0);
            d5 = par8Icon.b(16.0 - this.k * 16.0);
            d6 = par8Icon.b(16.0 - this.l * 16.0);
            d7 = d4;
            d8 = d3;
            d9 = d5;
            d10 = d6;
        }
        double d11 = par2 + this.g;
        double d12 = par2 + this.h;
        double d13 = par4 + this.j;
        double d14 = par6 + this.k;
        double d15 = par6 + this.l;
        if (this.v) {
            tessellator.a(this.ao, this.as, this.aw);
            tessellator.c(this.ak);
            tessellator.a(d12, d13, d15, d4, d6);
            tessellator.a(this.ap, this.at, this.ax);
            tessellator.c(this.al);
            tessellator.a(d12, d13, d14, d7, d9);
            tessellator.a(this.aq, this.au, this.ay);
            tessellator.c(this.am);
            tessellator.a(d11, d13, d14, d3, d5);
            tessellator.a(this.ar, this.av, this.az);
            tessellator.c(this.an);
            tessellator.a(d11, d13, d15, d8, d10);
        } else {
            tessellator.a(d12, d13, d15, d4, d6);
            tessellator.a(d12, d13, d14, d7, d9);
            tessellator.a(d11, d13, d14, d3, d5);
            tessellator.a(d11, d13, d15, d8, d10);
        }
    }

    public void c(aqz par1Block, double par2, double par4, double par6, ms par8Icon) {
        double d7;
        bfq tessellator = bfq.a;
        if (this.b()) {
            par8Icon = this.d;
        }
        double d3 = par8Icon.a(this.g * 16.0);
        double d4 = par8Icon.a(this.h * 16.0);
        double d5 = par8Icon.b(16.0 - this.j * 16.0);
        double d6 = par8Icon.b(16.0 - this.i * 16.0);
        if (this.e) {
            d7 = d3;
            d3 = d4;
            d4 = d7;
        }
        if (this.g < 0.0 || this.h > 1.0) {
            d3 = par8Icon.c();
            d4 = par8Icon.d();
        }
        if (this.i < 0.0 || this.j > 1.0) {
            d5 = par8Icon.e();
            d6 = par8Icon.f();
        }
        d7 = d4;
        double d8 = d3;
        double d9 = d5;
        double d10 = d6;
        if (this.p == 2) {
            d3 = par8Icon.a(this.i * 16.0);
            d5 = par8Icon.b(16.0 - this.g * 16.0);
            d4 = par8Icon.a(this.j * 16.0);
            d6 = par8Icon.b(16.0 - this.h * 16.0);
            d9 = d5;
            d10 = d6;
            d7 = d3;
            d8 = d4;
            d5 = d6;
            d6 = d9;
        } else if (this.p == 1) {
            d3 = par8Icon.a(16.0 - this.j * 16.0);
            d5 = par8Icon.b(this.h * 16.0);
            d4 = par8Icon.a(16.0 - this.i * 16.0);
            d6 = par8Icon.b(this.g * 16.0);
            d7 = d4;
            d8 = d3;
            d3 = d4;
            d4 = d8;
            d9 = d6;
            d10 = d5;
        } else if (this.p == 3) {
            d3 = par8Icon.a(16.0 - this.g * 16.0);
            d4 = par8Icon.a(16.0 - this.h * 16.0);
            d5 = par8Icon.b(this.j * 16.0);
            d6 = par8Icon.b(this.i * 16.0);
            d7 = d4;
            d8 = d3;
            d9 = d5;
            d10 = d6;
        }
        double d11 = par2 + this.g;
        double d12 = par2 + this.h;
        double d13 = par4 + this.i;
        double d14 = par4 + this.j;
        double d15 = par6 + this.k;
        if (this.v) {
            tessellator.a(this.ao, this.as, this.aw);
            tessellator.c(this.ak);
            tessellator.a(d11, d14, d15, d7, d9);
            tessellator.a(this.ap, this.at, this.ax);
            tessellator.c(this.al);
            tessellator.a(d12, d14, d15, d3, d5);
            tessellator.a(this.aq, this.au, this.ay);
            tessellator.c(this.am);
            tessellator.a(d12, d13, d15, d8, d10);
            tessellator.a(this.ar, this.av, this.az);
            tessellator.c(this.an);
            tessellator.a(d11, d13, d15, d4, d6);
        } else {
            tessellator.a(d11, d14, d15, d7, d9);
            tessellator.a(d12, d14, d15, d3, d5);
            tessellator.a(d12, d13, d15, d8, d10);
            tessellator.a(d11, d13, d15, d4, d6);
        }
    }

    public void d(aqz par1Block, double par2, double par4, double par6, ms par8Icon) {
        double d7;
        bfq tessellator = bfq.a;
        if (this.b()) {
            par8Icon = this.d;
        }
        double d3 = par8Icon.a(this.g * 16.0);
        double d4 = par8Icon.a(this.h * 16.0);
        double d5 = par8Icon.b(16.0 - this.j * 16.0);
        double d6 = par8Icon.b(16.0 - this.i * 16.0);
        if (this.e) {
            d7 = d3;
            d3 = d4;
            d4 = d7;
        }
        if (this.g < 0.0 || this.h > 1.0) {
            d3 = par8Icon.c();
            d4 = par8Icon.d();
        }
        if (this.i < 0.0 || this.j > 1.0) {
            d5 = par8Icon.e();
            d6 = par8Icon.f();
        }
        d7 = d4;
        double d8 = d3;
        double d9 = d5;
        double d10 = d6;
        if (this.q == 1) {
            d3 = par8Icon.a(this.i * 16.0);
            d6 = par8Icon.b(16.0 - this.g * 16.0);
            d4 = par8Icon.a(this.j * 16.0);
            d9 = d5 = (double)par8Icon.b(16.0 - this.h * 16.0);
            d10 = d6;
            d7 = d3;
            d8 = d4;
            d5 = d6;
            d6 = d9;
        } else if (this.q == 2) {
            d3 = par8Icon.a(16.0 - this.j * 16.0);
            d5 = par8Icon.b(this.g * 16.0);
            d4 = par8Icon.a(16.0 - this.i * 16.0);
            d6 = par8Icon.b(this.h * 16.0);
            d7 = d4;
            d8 = d3;
            d3 = d4;
            d4 = d8;
            d9 = d6;
            d10 = d5;
        } else if (this.q == 3) {
            d3 = par8Icon.a(16.0 - this.g * 16.0);
            d4 = par8Icon.a(16.0 - this.h * 16.0);
            d5 = par8Icon.b(this.j * 16.0);
            d6 = par8Icon.b(this.i * 16.0);
            d7 = d4;
            d8 = d3;
            d9 = d5;
            d10 = d6;
        }
        double d11 = par2 + this.g;
        double d12 = par2 + this.h;
        double d13 = par4 + this.i;
        double d14 = par4 + this.j;
        double d15 = par6 + this.l;
        if (this.v) {
            tessellator.a(this.ao, this.as, this.aw);
            tessellator.c(this.ak);
            tessellator.a(d11, d14, d15, d3, d5);
            tessellator.a(this.ap, this.at, this.ax);
            tessellator.c(this.al);
            tessellator.a(d11, d13, d15, d8, d10);
            tessellator.a(this.aq, this.au, this.ay);
            tessellator.c(this.am);
            tessellator.a(d12, d13, d15, d4, d6);
            tessellator.a(this.ar, this.av, this.az);
            tessellator.c(this.an);
            tessellator.a(d12, d14, d15, d7, d9);
        } else {
            tessellator.a(d11, d14, d15, d3, d5);
            tessellator.a(d11, d13, d15, d8, d10);
            tessellator.a(d12, d13, d15, d4, d6);
            tessellator.a(d12, d14, d15, d7, d9);
        }
    }

    public void e(aqz par1Block, double par2, double par4, double par6, ms par8Icon) {
        double d7;
        bfq tessellator = bfq.a;
        if (this.b()) {
            par8Icon = this.d;
        }
        double d3 = par8Icon.a(this.k * 16.0);
        double d4 = par8Icon.a(this.l * 16.0);
        double d5 = par8Icon.b(16.0 - this.j * 16.0);
        double d6 = par8Icon.b(16.0 - this.i * 16.0);
        if (this.e) {
            d7 = d3;
            d3 = d4;
            d4 = d7;
        }
        if (this.k < 0.0 || this.l > 1.0) {
            d3 = par8Icon.c();
            d4 = par8Icon.d();
        }
        if (this.i < 0.0 || this.j > 1.0) {
            d5 = par8Icon.e();
            d6 = par8Icon.f();
        }
        d7 = d4;
        double d8 = d3;
        double d9 = d5;
        double d10 = d6;
        if (this.s == 1) {
            d3 = par8Icon.a(this.i * 16.0);
            d5 = par8Icon.b(16.0 - this.l * 16.0);
            d4 = par8Icon.a(this.j * 16.0);
            d6 = par8Icon.b(16.0 - this.k * 16.0);
            d9 = d5;
            d10 = d6;
            d7 = d3;
            d8 = d4;
            d5 = d6;
            d6 = d9;
        } else if (this.s == 2) {
            d3 = par8Icon.a(16.0 - this.j * 16.0);
            d5 = par8Icon.b(this.k * 16.0);
            d4 = par8Icon.a(16.0 - this.i * 16.0);
            d6 = par8Icon.b(this.l * 16.0);
            d7 = d4;
            d8 = d3;
            d3 = d4;
            d4 = d8;
            d9 = d6;
            d10 = d5;
        } else if (this.s == 3) {
            d3 = par8Icon.a(16.0 - this.k * 16.0);
            d4 = par8Icon.a(16.0 - this.l * 16.0);
            d5 = par8Icon.b(this.j * 16.0);
            d6 = par8Icon.b(this.i * 16.0);
            d7 = d4;
            d8 = d3;
            d9 = d5;
            d10 = d6;
        }
        double d11 = par2 + this.g;
        double d12 = par4 + this.i;
        double d13 = par4 + this.j;
        double d14 = par6 + this.k;
        double d15 = par6 + this.l;
        if (this.v) {
            tessellator.a(this.ao, this.as, this.aw);
            tessellator.c(this.ak);
            tessellator.a(d11, d13, d15, d7, d9);
            tessellator.a(this.ap, this.at, this.ax);
            tessellator.c(this.al);
            tessellator.a(d11, d13, d14, d3, d5);
            tessellator.a(this.aq, this.au, this.ay);
            tessellator.c(this.am);
            tessellator.a(d11, d12, d14, d8, d10);
            tessellator.a(this.ar, this.av, this.az);
            tessellator.c(this.an);
            tessellator.a(d11, d12, d15, d4, d6);
        } else {
            tessellator.a(d11, d13, d15, d7, d9);
            tessellator.a(d11, d13, d14, d3, d5);
            tessellator.a(d11, d12, d14, d8, d10);
            tessellator.a(d11, d12, d15, d4, d6);
        }
    }

    public void f(aqz par1Block, double par2, double par4, double par6, ms par8Icon) {
        double d7;
        bfq tessellator = bfq.a;
        if (this.b()) {
            par8Icon = this.d;
        }
        double d3 = par8Icon.a(this.k * 16.0);
        double d4 = par8Icon.a(this.l * 16.0);
        double d5 = par8Icon.b(16.0 - this.j * 16.0);
        double d6 = par8Icon.b(16.0 - this.i * 16.0);
        if (this.e) {
            d7 = d3;
            d3 = d4;
            d4 = d7;
        }
        if (this.k < 0.0 || this.l > 1.0) {
            d3 = par8Icon.c();
            d4 = par8Icon.d();
        }
        if (this.i < 0.0 || this.j > 1.0) {
            d5 = par8Icon.e();
            d6 = par8Icon.f();
        }
        d7 = d4;
        double d8 = d3;
        double d9 = d5;
        double d10 = d6;
        if (this.r == 2) {
            d3 = par8Icon.a(this.i * 16.0);
            d5 = par8Icon.b(16.0 - this.k * 16.0);
            d4 = par8Icon.a(this.j * 16.0);
            d6 = par8Icon.b(16.0 - this.l * 16.0);
            d9 = d5;
            d10 = d6;
            d7 = d3;
            d8 = d4;
            d5 = d6;
            d6 = d9;
        } else if (this.r == 1) {
            d3 = par8Icon.a(16.0 - this.j * 16.0);
            d5 = par8Icon.b(this.l * 16.0);
            d4 = par8Icon.a(16.0 - this.i * 16.0);
            d6 = par8Icon.b(this.k * 16.0);
            d7 = d4;
            d8 = d3;
            d3 = d4;
            d4 = d8;
            d9 = d6;
            d10 = d5;
        } else if (this.r == 3) {
            d3 = par8Icon.a(16.0 - this.k * 16.0);
            d4 = par8Icon.a(16.0 - this.l * 16.0);
            d5 = par8Icon.b(this.j * 16.0);
            d6 = par8Icon.b(this.i * 16.0);
            d7 = d4;
            d8 = d3;
            d9 = d5;
            d10 = d6;
        }
        double d11 = par2 + this.h;
        double d12 = par4 + this.i;
        double d13 = par4 + this.j;
        double d14 = par6 + this.k;
        double d15 = par6 + this.l;
        if (this.v) {
            tessellator.a(this.ao, this.as, this.aw);
            tessellator.c(this.ak);
            tessellator.a(d11, d12, d15, d8, d10);
            tessellator.a(this.ap, this.at, this.ax);
            tessellator.c(this.al);
            tessellator.a(d11, d12, d14, d4, d6);
            tessellator.a(this.aq, this.au, this.ay);
            tessellator.c(this.am);
            tessellator.a(d11, d13, d14, d7, d9);
            tessellator.a(this.ar, this.av, this.az);
            tessellator.c(this.an);
            tessellator.a(d11, d13, d15, d3, d5);
        } else {
            tessellator.a(d11, d12, d15, d8, d10);
            tessellator.a(d11, d12, d14, d4, d6);
            tessellator.a(d11, d13, d14, d7, d9);
            tessellator.a(d11, d13, d15, d3, d5);
        }
    }

    public void a(aqz par1Block, int par2, float par3) {
        float f3;
        float f2;
        float f1;
        int j2;
        boolean flag;
        bfq tessellator = bfq.a;
        boolean bl2 = flag = par1Block.cF == aqz.z.cF;
        if (par1Block == aqz.U || par1Block == aqz.cz || par1Block == aqz.aG) {
            par2 = 3;
        }
        if (this.c) {
            j2 = par1Block.b(par2);
            if (flag) {
                j2 = 0xFFFFFF;
            }
            f1 = (float)(j2 >> 16 & 0xFF) / 255.0f;
            f2 = (float)(j2 >> 8 & 0xFF) / 255.0f;
            f3 = (float)(j2 & 0xFF) / 255.0f;
            GL11.glColor4f((float)(f1 * par3), (float)(f2 * par3), (float)(f3 * par3), (float)1.0f);
        }
        j2 = par1Block.d();
        this.a(par1Block);
        if (j2 != 0 && j2 != 31 && j2 != 39 && j2 != 16 && j2 != 26) {
            if (j2 == 1) {
                tessellator.b();
                tessellator.b(0.0f, -1.0f, 0.0f);
                this.a(par1Block, par2, -0.5, -0.5, -0.5, 1.0f);
                tessellator.a();
            } else if (j2 == 19) {
                tessellator.b();
                tessellator.b(0.0f, -1.0f, 0.0f);
                par1Block.g();
                this.a(par1Block, par2, this.j, -0.5, -0.5, -0.5);
                tessellator.a();
            } else if (j2 == 23) {
                tessellator.b();
                tessellator.b(0.0f, -1.0f, 0.0f);
                par1Block.g();
                tessellator.a();
            } else if (j2 == 13) {
                par1Block.g();
                GL11.glTranslatef((float)-0.5f, (float)-0.5f, (float)-0.5f);
                f1 = 0.0625f;
                tessellator.b();
                tessellator.b(0.0f, -1.0f, 0.0f);
                this.a(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 0));
                tessellator.a();
                tessellator.b();
                tessellator.b(0.0f, 1.0f, 0.0f);
                this.b(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 1));
                tessellator.a();
                tessellator.b();
                tessellator.b(0.0f, 0.0f, -1.0f);
                tessellator.c(0.0f, 0.0f, f1);
                this.c(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 2));
                tessellator.c(0.0f, 0.0f, -f1);
                tessellator.a();
                tessellator.b();
                tessellator.b(0.0f, 0.0f, 1.0f);
                tessellator.c(0.0f, 0.0f, -f1);
                this.d(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 3));
                tessellator.c(0.0f, 0.0f, f1);
                tessellator.a();
                tessellator.b();
                tessellator.b(-1.0f, 0.0f, 0.0f);
                tessellator.c(f1, 0.0f, 0.0f);
                this.e(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 4));
                tessellator.c(-f1, 0.0f, 0.0f);
                tessellator.a();
                tessellator.b();
                tessellator.b(1.0f, 0.0f, 0.0f);
                tessellator.c(-f1, 0.0f, 0.0f);
                this.f(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 5));
                tessellator.c(f1, 0.0f, 0.0f);
                tessellator.a();
                GL11.glTranslatef((float)0.5f, (float)0.5f, (float)0.5f);
            } else if (j2 == 22) {
                GL11.glRotatef((float)90.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                GL11.glTranslatef((float)-0.5f, (float)-0.5f, (float)-0.5f);
                bfd.a.a(par1Block, par2, par3);
                GL11.glEnable((int)32826);
            } else if (j2 == 6) {
                tessellator.b();
                tessellator.b(0.0f, -1.0f, 0.0f);
                this.a(par1Block, par2, -0.5, -0.5, -0.5);
                tessellator.a();
            } else if (j2 == 2) {
                tessellator.b();
                tessellator.b(0.0f, -1.0f, 0.0f);
                this.a(par1Block, -0.5, -0.5, -0.5, 0.0, 0.0, 0);
                tessellator.a();
            } else if (j2 == 10) {
                for (int k = 0; k < 2; ++k) {
                    if (k == 0) {
                        this.a(0.0, 0.0, 0.0, 1.0, 1.0, 0.5);
                    }
                    if (k == 1) {
                        this.a(0.0, 0.0, 0.5, 1.0, 0.5, 1.0);
                    }
                    GL11.glTranslatef((float)-0.5f, (float)-0.5f, (float)-0.5f);
                    tessellator.b();
                    tessellator.b(0.0f, -1.0f, 0.0f);
                    this.a(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 0));
                    tessellator.a();
                    tessellator.b();
                    tessellator.b(0.0f, 1.0f, 0.0f);
                    this.b(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 1));
                    tessellator.a();
                    tessellator.b();
                    tessellator.b(0.0f, 0.0f, -1.0f);
                    this.c(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 2));
                    tessellator.a();
                    tessellator.b();
                    tessellator.b(0.0f, 0.0f, 1.0f);
                    this.d(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 3));
                    tessellator.a();
                    tessellator.b();
                    tessellator.b(-1.0f, 0.0f, 0.0f);
                    this.e(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 4));
                    tessellator.a();
                    tessellator.b();
                    tessellator.b(1.0f, 0.0f, 0.0f);
                    this.f(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 5));
                    tessellator.a();
                    GL11.glTranslatef((float)0.5f, (float)0.5f, (float)0.5f);
                }
            } else if (j2 == 27) {
                int k = 0;
                GL11.glTranslatef((float)-0.5f, (float)-0.5f, (float)-0.5f);
                tessellator.b();
                for (int l2 = 0; l2 < 8; ++l2) {
                    int b0 = 0;
                    int b1 = 1;
                    if (l2 == 0) {
                        b0 = 2;
                    }
                    if (l2 == 1) {
                        b0 = 3;
                    }
                    if (l2 == 2) {
                        b0 = 4;
                    }
                    if (l2 == 3) {
                        b0 = 5;
                        b1 = 2;
                    }
                    if (l2 == 4) {
                        b0 = 6;
                        b1 = 3;
                    }
                    if (l2 == 5) {
                        b0 = 7;
                        b1 = 5;
                    }
                    if (l2 == 6) {
                        b0 = 6;
                        b1 = 2;
                    }
                    if (l2 == 7) {
                        b0 = 3;
                    }
                    float f4 = (float)b0 / 16.0f;
                    float f5 = 1.0f - (float)k / 16.0f;
                    float f6 = 1.0f - (float)(k + b1) / 16.0f;
                    k += b1;
                    this.a(0.5f - f4, f6, (double)(0.5f - f4), (double)(0.5f + f4), (double)f5, (double)(0.5f + f4));
                    tessellator.b(0.0f, -1.0f, 0.0f);
                    this.a(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 0));
                    tessellator.b(0.0f, 1.0f, 0.0f);
                    this.b(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 1));
                    tessellator.b(0.0f, 0.0f, -1.0f);
                    this.c(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 2));
                    tessellator.b(0.0f, 0.0f, 1.0f);
                    this.d(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 3));
                    tessellator.b(-1.0f, 0.0f, 0.0f);
                    this.e(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 4));
                    tessellator.b(1.0f, 0.0f, 0.0f);
                    this.f(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 5));
                }
                tessellator.a();
                GL11.glTranslatef((float)0.5f, (float)0.5f, (float)0.5f);
                this.a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
            } else if (j2 == 11) {
                for (int k = 0; k < 4; ++k) {
                    f2 = 0.125f;
                    if (k == 0) {
                        this.a(0.5f - f2, 0.0, 0.0, (double)(0.5f + f2), 1.0, (double)(f2 * 2.0f));
                    }
                    if (k == 1) {
                        this.a(0.5f - f2, 0.0, (double)(1.0f - f2 * 2.0f), (double)(0.5f + f2), 1.0, 1.0);
                    }
                    f2 = 0.0625f;
                    if (k == 2) {
                        this.a(0.5f - f2, 1.0f - f2 * 3.0f, (double)(-f2 * 2.0f), (double)(0.5f + f2), (double)(1.0f - f2), (double)(1.0f + f2 * 2.0f));
                    }
                    if (k == 3) {
                        this.a(0.5f - f2, 0.5f - f2 * 3.0f, (double)(-f2 * 2.0f), (double)(0.5f + f2), (double)(0.5f - f2), (double)(1.0f + f2 * 2.0f));
                    }
                    GL11.glTranslatef((float)-0.5f, (float)-0.5f, (float)-0.5f);
                    tessellator.b();
                    tessellator.b(0.0f, -1.0f, 0.0f);
                    this.a(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 0));
                    tessellator.a();
                    tessellator.b();
                    tessellator.b(0.0f, 1.0f, 0.0f);
                    this.b(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 1));
                    tessellator.a();
                    tessellator.b();
                    tessellator.b(0.0f, 0.0f, -1.0f);
                    this.c(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 2));
                    tessellator.a();
                    tessellator.b();
                    tessellator.b(0.0f, 0.0f, 1.0f);
                    this.d(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 3));
                    tessellator.a();
                    tessellator.b();
                    tessellator.b(-1.0f, 0.0f, 0.0f);
                    this.e(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 4));
                    tessellator.a();
                    tessellator.b();
                    tessellator.b(1.0f, 0.0f, 0.0f);
                    this.f(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 5));
                    tessellator.a();
                    GL11.glTranslatef((float)0.5f, (float)0.5f, (float)0.5f);
                }
                this.a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
            } else if (j2 == 21) {
                for (int k = 0; k < 3; ++k) {
                    f2 = 0.0625f;
                    if (k == 0) {
                        this.a(0.5f - f2, 0.3f, 0.0, (double)(0.5f + f2), 1.0, (double)(f2 * 2.0f));
                    }
                    if (k == 1) {
                        this.a(0.5f - f2, 0.3f, (double)(1.0f - f2 * 2.0f), (double)(0.5f + f2), 1.0, 1.0);
                    }
                    f2 = 0.0625f;
                    if (k == 2) {
                        this.a(0.5f - f2, 0.5, 0.0, (double)(0.5f + f2), (double)(1.0f - f2), 1.0);
                    }
                    GL11.glTranslatef((float)-0.5f, (float)-0.5f, (float)-0.5f);
                    tessellator.b();
                    tessellator.b(0.0f, -1.0f, 0.0f);
                    this.a(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 0));
                    tessellator.a();
                    tessellator.b();
                    tessellator.b(0.0f, 1.0f, 0.0f);
                    this.b(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 1));
                    tessellator.a();
                    tessellator.b();
                    tessellator.b(0.0f, 0.0f, -1.0f);
                    this.c(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 2));
                    tessellator.a();
                    tessellator.b();
                    tessellator.b(0.0f, 0.0f, 1.0f);
                    this.d(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 3));
                    tessellator.a();
                    tessellator.b();
                    tessellator.b(-1.0f, 0.0f, 0.0f);
                    this.e(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 4));
                    tessellator.a();
                    tessellator.b();
                    tessellator.b(1.0f, 0.0f, 0.0f);
                    this.f(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 5));
                    tessellator.a();
                    GL11.glTranslatef((float)0.5f, (float)0.5f, (float)0.5f);
                }
            } else if (j2 == 32) {
                for (int k = 0; k < 2; ++k) {
                    if (k == 0) {
                        this.a(0.0, 0.0, 0.3125, 1.0, 0.8125, 0.6875);
                    }
                    if (k == 1) {
                        this.a(0.25, 0.0, 0.25, 0.75, 1.0, 0.75);
                    }
                    GL11.glTranslatef((float)-0.5f, (float)-0.5f, (float)-0.5f);
                    tessellator.b();
                    tessellator.b(0.0f, -1.0f, 0.0f);
                    this.a(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 0, par2));
                    tessellator.a();
                    tessellator.b();
                    tessellator.b(0.0f, 1.0f, 0.0f);
                    this.b(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 1, par2));
                    tessellator.a();
                    tessellator.b();
                    tessellator.b(0.0f, 0.0f, -1.0f);
                    this.c(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 2, par2));
                    tessellator.a();
                    tessellator.b();
                    tessellator.b(0.0f, 0.0f, 1.0f);
                    this.d(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 3, par2));
                    tessellator.a();
                    tessellator.b();
                    tessellator.b(-1.0f, 0.0f, 0.0f);
                    this.e(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 4, par2));
                    tessellator.a();
                    tessellator.b();
                    tessellator.b(1.0f, 0.0f, 0.0f);
                    this.f(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 5, par2));
                    tessellator.a();
                    GL11.glTranslatef((float)0.5f, (float)0.5f, (float)0.5f);
                }
                this.a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
            } else if (j2 == 35) {
                GL11.glTranslatef((float)-0.5f, (float)-0.5f, (float)-0.5f);
                this.a((amv)par1Block, 0, 0, 0, par2 << 2, true);
                GL11.glTranslatef((float)0.5f, (float)0.5f, (float)0.5f);
            } else if (j2 == 34) {
                for (int k = 0; k < 3; ++k) {
                    if (k == 0) {
                        this.a(0.125, 0.0, 0.125, 0.875, 0.1875, 0.875);
                        this.a(this.b(aqz.au));
                    } else if (k == 1) {
                        this.a(0.1875, 0.1875, 0.1875, 0.8125, 0.875, 0.8125);
                        this.a(this.b((aqz)aqz.cf));
                    } else if (k == 2) {
                        this.a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
                        this.a(this.b(aqz.R));
                    }
                    GL11.glTranslatef((float)-0.5f, (float)-0.5f, (float)-0.5f);
                    tessellator.b();
                    tessellator.b(0.0f, -1.0f, 0.0f);
                    this.a(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 0, par2));
                    tessellator.a();
                    tessellator.b();
                    tessellator.b(0.0f, 1.0f, 0.0f);
                    this.b(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 1, par2));
                    tessellator.a();
                    tessellator.b();
                    tessellator.b(0.0f, 0.0f, -1.0f);
                    this.c(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 2, par2));
                    tessellator.a();
                    tessellator.b();
                    tessellator.b(0.0f, 0.0f, 1.0f);
                    this.d(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 3, par2));
                    tessellator.a();
                    tessellator.b();
                    tessellator.b(-1.0f, 0.0f, 0.0f);
                    this.e(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 4, par2));
                    tessellator.a();
                    tessellator.b();
                    tessellator.b(1.0f, 0.0f, 0.0f);
                    this.f(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 5, par2));
                    tessellator.a();
                    GL11.glTranslatef((float)0.5f, (float)0.5f, (float)0.5f);
                }
                this.a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
                this.a();
            } else if (j2 == 38) {
                GL11.glTranslatef((float)-0.5f, (float)-0.5f, (float)-0.5f);
                this.a((aot)par1Block, 0, 0, 0, 0, true);
                GL11.glTranslatef((float)0.5f, (float)0.5f, (float)0.5f);
            } else {
                FMLRenderAccessLibrary.renderInventoryBlock((bfr)this, (aqz)par1Block, (int)par2, (int)j2);
            }
        } else {
            if (j2 == 16) {
                par2 = 1;
            }
            par1Block.g();
            this.a(par1Block);
            GL11.glRotatef((float)90.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glTranslatef((float)-0.5f, (float)-0.5f, (float)-0.5f);
            tessellator.b();
            tessellator.b(0.0f, -1.0f, 0.0f);
            this.a(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 0, par2));
            tessellator.a();
            if (flag && this.c) {
                int k = par1Block.b(par2);
                f2 = (float)(k >> 16 & 0xFF) / 255.0f;
                f3 = (float)(k >> 8 & 0xFF) / 255.0f;
                float f7 = (float)(k & 0xFF) / 255.0f;
                GL11.glColor4f((float)(f2 * par3), (float)(f3 * par3), (float)(f7 * par3), (float)1.0f);
            }
            tessellator.b();
            tessellator.b(0.0f, 1.0f, 0.0f);
            this.b(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 1, par2));
            tessellator.a();
            if (flag && this.c) {
                GL11.glColor4f((float)par3, (float)par3, (float)par3, (float)1.0f);
            }
            tessellator.b();
            tessellator.b(0.0f, 0.0f, -1.0f);
            this.c(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 2, par2));
            tessellator.a();
            tessellator.b();
            tessellator.b(0.0f, 0.0f, 1.0f);
            this.d(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 3, par2));
            tessellator.a();
            tessellator.b();
            tessellator.b(-1.0f, 0.0f, 0.0f);
            this.e(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 4, par2));
            tessellator.a();
            tessellator.b();
            tessellator.b(1.0f, 0.0f, 0.0f);
            this.f(par1Block, 0.0, 0.0, 0.0, this.a(par1Block, 5, par2));
            tessellator.a();
            GL11.glTranslatef((float)0.5f, (float)0.5f, (float)0.5f);
        }
    }

    public static boolean a(int par0) {
        switch (par0) {
            case 0: {
                return true;
            }
            case 31: {
                return true;
            }
            case 39: {
                return true;
            }
            case 13: {
                return true;
            }
            case 10: {
                return true;
            }
            case 11: {
                return true;
            }
            case 27: {
                return true;
            }
            case 22: {
                return true;
            }
            case 21: {
                return true;
            }
            case 16: {
                return true;
            }
            case 26: {
                return true;
            }
            case 32: {
                return true;
            }
            case 34: {
                return true;
            }
            case 35: {
                return true;
            }
        }
        return FMLRenderAccessLibrary.renderItemAsFull3DBlock((int)par0);
    }

    public ms a(aqz par1Block, acf par2IBlockAccess, int par3, int par4, int par5, int par6) {
        return this.b(par1Block.b_(par2IBlockAccess, par3, par4, par5, par6));
    }

    public ms a(aqz par1Block, int par2, int par3) {
        return this.b(par1Block.a(par2, par3));
    }

    public ms a(aqz par1Block, int par2) {
        return this.b(par1Block.m(par2));
    }

    public ms b(aqz par1Block) {
        return this.b(par1Block.m(1));
    }

    public ms b(ms par1Icon) {
        if (par1Icon == null) {
            par1Icon = ((bik)atv.w().J().b(bik.b)).b("missingno");
        }
        return par1Icon;
    }
}

