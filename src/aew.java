/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  afe
 *  aqi
 *  net.minecraftforge.common.ForgeDirection
 *  net.minecraftforge.common.IPlantable
 */
import java.util.Random;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;

public class aew
extends afe {
    static final byte[] a = new byte[]{2, 0, 0, 1, 2, 1};
    Random b = new Random();
    abw c;
    int[] d = new int[]{0, 0, 0};
    int e;
    int f;
    double g = 0.618;
    double h = 1.0;
    double i = 0.381;
    double j = 1.0;
    double k = 1.0;
    int l = 1;
    int m = 12;
    int n = 4;
    int[][] o;

    public aew(boolean par1) {
        super(par1);
    }

    void a() {
        int i;
        this.f = (int)((double)this.e * this.g);
        if (this.f >= this.e) {
            this.f = this.e - 1;
        }
        if ((i = (int)(1.382 + Math.pow(this.k * (double)this.e / 13.0, 2.0))) < 1) {
            i = 1;
        }
        int[][] aint = new int[i * this.e][4];
        int j2 = this.d[1] + this.e - this.n;
        int k = 1;
        int l = this.d[1] + this.f;
        int i1 = j2 - this.d[1];
        aint[0][0] = this.d[0];
        aint[0][1] = j2--;
        aint[0][2] = this.d[2];
        aint[0][3] = l;
        while (i1 >= 0) {
            float f = this.a(i1);
            if (f < 0.0f) {
                --j2;
                --i1;
                continue;
            }
            double d0 = 0.5;
            for (int j1 = 0; j1 < i; ++j1) {
                int[] aint2;
                int l1;
                double d2;
                double d1 = this.j * (double)f * ((double)this.b.nextFloat() + 0.328);
                int k1 = ls.c(d1 * Math.sin(d2 = (double)this.b.nextFloat() * 2.0 * Math.PI) + (double)this.d[0] + d0);
                int[] aint1 = new int[]{k1, j2, l1 = ls.c(d1 * Math.cos(d2) + (double)this.d[2] + d0)};
                if (this.a(aint1, aint2 = new int[]{k1, j2 + this.n, l1}) != -1) continue;
                int[] aint3 = new int[]{this.d[0], this.d[1], this.d[2]};
                double d3 = Math.sqrt(Math.pow(Math.abs(this.d[0] - aint1[0]), 2.0) + Math.pow(Math.abs(this.d[2] - aint1[2]), 2.0));
                double d4 = d3 * this.i;
                aint3[1] = (double)aint1[1] - d4 > (double)l ? l : (int)((double)aint1[1] - d4);
                if (this.a(aint3, aint1) != -1) continue;
                aint[k][0] = k1;
                aint[k][1] = j2;
                aint[k][2] = l1;
                aint[k][3] = aint3[1];
                ++k;
            }
            --j2;
            --i1;
        }
        this.o = new int[k][4];
        System.arraycopy(aint, 0, this.o, 0, k);
    }

    void a(int par1, int par2, int par3, float par4, byte par5, int par6) {
        int i1 = (int)((double)par4 + 0.618);
        byte b1 = a[par5];
        byte b2 = a[par5 + 3];
        int[] aint = new int[]{par1, par2, par3};
        int[] aint1 = new int[]{0, 0, 0};
        int k1 = -i1;
        aint1[par5] = aint[par5];
        for (int j1 = -i1; j1 <= i1; ++j1) {
            aint1[b1] = aint[b1] + j1;
            k1 = -i1;
            while (k1 <= i1) {
                double d0 = Math.pow((double)Math.abs(j1) + 0.5, 2.0) + Math.pow((double)Math.abs(k1) + 0.5, 2.0);
                if (d0 > (double)(par4 * par4)) {
                    ++k1;
                    continue;
                }
                aint1[b2] = aint[b2] + k1;
                int l1 = this.c.a(aint1[0], aint1[1], aint1[2]);
                aqz block = aqz.s[l1];
                if (block != null && !block.isAirBlock(this.c, aint1[0], aint1[1], aint1[2]) && !block.isLeaves(this.c, aint1[0], aint1[1], aint1[2])) {
                    ++k1;
                    continue;
                }
                this.a(this.c, aint1[0], aint1[1], aint1[2], par6, 0);
                ++k1;
            }
        }
    }

    float a(int par1) {
        if ((double)par1 < (double)this.e * 0.3) {
            return -1.618f;
        }
        float f = (float)this.e / 2.0f;
        float f1 = (float)this.e / 2.0f - (float)par1;
        float f2 = f1 == 0.0f ? f : (Math.abs(f1) >= f ? 0.0f : (float)Math.sqrt(Math.pow(Math.abs(f), 2.0) - Math.pow(Math.abs(f1), 2.0)));
        return f2 *= 0.5f;
    }

    float b(int par1) {
        return par1 >= 0 && par1 < this.n ? (par1 != 0 && par1 != this.n - 1 ? 3.0f : 2.0f) : -1.0f;
    }

    void a(int par1, int par2, int par3) {
        int i1 = par2 + this.n;
        for (int l = par2; l < i1; ++l) {
            float f = this.b(l - par2);
            this.a(par1, l, par3, f, (byte)1, aqz.P.cF);
        }
    }

    void a(int[] par1ArrayOfInteger, int[] par2ArrayOfInteger, int par3) {
        int[] aint2 = new int[]{0, 0, 0};
        int b1 = 0;
        for (int b0 = 0; b0 < 3; b0 = (int)((byte)(b0 + 1))) {
            aint2[b0] = par2ArrayOfInteger[b0] - par1ArrayOfInteger[b0];
            if (Math.abs(aint2[b0]) <= Math.abs(aint2[b1])) continue;
            b1 = b0;
        }
        if (aint2[b1] != 0) {
            byte b2 = a[b1];
            byte b3 = a[b1 + 3];
            int b4 = aint2[b1] > 0 ? 1 : -1;
            double d0 = (double)aint2[b2] / (double)aint2[b1];
            double d1 = (double)aint2[b3] / (double)aint2[b1];
            int[] aint3 = new int[]{0, 0, 0};
            int k = aint2[b1] + b4;
            for (int j2 = 0; j2 != k; j2 += b4) {
                int i1;
                aint3[b1] = ls.c((double)(par1ArrayOfInteger[b1] + j2) + 0.5);
                aint3[b2] = ls.c((double)par1ArrayOfInteger[b2] + (double)j2 * d0 + 0.5);
                aint3[b3] = ls.c((double)par1ArrayOfInteger[b3] + (double)j2 * d1 + 0.5);
                int b5 = 0;
                int l = Math.abs(aint3[0] - par1ArrayOfInteger[0]);
                int j1 = Math.max(l, i1 = Math.abs(aint3[2] - par1ArrayOfInteger[2]));
                if (j1 > 0) {
                    if (l == j1) {
                        b5 = 4;
                    } else if (i1 == j1) {
                        b5 = 8;
                    }
                }
                this.a(this.c, aint3[0], aint3[1], aint3[2], par3, b5);
            }
        }
    }

    void b() {
        int j2 = this.o.length;
        for (int i = 0; i < j2; ++i) {
            int k = this.o[i][0];
            int l = this.o[i][1];
            int i1 = this.o[i][2];
            this.a(k, l, i1);
        }
    }

    boolean c(int par1) {
        return (double)par1 >= (double)this.e * 0.2;
    }

    void c() {
        int i = this.d[0];
        int j2 = this.d[1];
        int k = this.d[1] + this.f;
        int l = this.d[2];
        int[] aint = new int[]{i, j2, l};
        int[] aint1 = new int[]{i, k, l};
        this.a(aint, aint1, aqz.O.cF);
        if (this.l == 2) {
            aint[0] = aint[0] + 1;
            aint1[0] = aint1[0] + 1;
            this.a(aint, aint1, aqz.O.cF);
            aint[2] = aint[2] + 1;
            aint1[2] = aint1[2] + 1;
            this.a(aint, aint1, aqz.O.cF);
            aint[0] = aint[0] + -1;
            aint1[0] = aint1[0] + -1;
            this.a(aint, aint1, aqz.O.cF);
        }
    }

    void d() {
        int j2 = this.o.length;
        int[] aint = new int[]{this.d[0], this.d[1], this.d[2]};
        for (int i = 0; i < j2; ++i) {
            int[] aint1 = this.o[i];
            int[] aint2 = new int[]{aint1[0], aint1[1], aint1[2]};
            aint[1] = aint1[3];
            int k = aint[1] - this.d[1];
            if (!this.c(k)) continue;
            this.a(aint, aint2, (int)((byte)aqz.O.cF));
        }
    }

    int a(int[] par1ArrayOfInteger, int[] par2ArrayOfInteger) {
        int i;
        int[] aint2 = new int[]{0, 0, 0};
        int b1 = 0;
        for (int b0 = 0; b0 < 3; b0 = (int)((byte)(b0 + 1))) {
            aint2[b0] = par2ArrayOfInteger[b0] - par1ArrayOfInteger[b0];
            if (Math.abs(aint2[b0]) <= Math.abs(aint2[b1])) continue;
            b1 = b0;
        }
        if (aint2[b1] == 0) {
            return -1;
        }
        byte b2 = a[b1];
        byte b3 = a[b1 + 3];
        int b4 = aint2[b1] > 0 ? 1 : -1;
        double d0 = (double)aint2[b2] / (double)aint2[b1];
        double d1 = (double)aint2[b3] / (double)aint2[b1];
        int[] aint3 = new int[]{0, 0, 0};
        int j2 = aint2[b1] + b4;
        for (i = 0; i != j2; i += b4) {
            aint3[b1] = par1ArrayOfInteger[b1] + i;
            aint3[b2] = ls.c((double)par1ArrayOfInteger[b2] + (double)i * d0);
            aint3[b3] = ls.c((double)par1ArrayOfInteger[b3] + (double)i * d1);
            int k = this.c.a(aint3[0], aint3[1], aint3[2]);
            aqz block = aqz.s[k];
            if (block != null && !block.isAirBlock(this.c, aint3[0], aint3[1], aint3[2]) && !block.isLeaves(this.c, aint3[0], aint3[1], aint3[2])) break;
        }
        return i == j2 ? -1 : Math.abs(i);
    }

    boolean e() {
        boolean isValidSoil;
        int[] aint = new int[]{this.d[0], this.d[1], this.d[2]};
        int[] aint1 = new int[]{this.d[0], this.d[1] + this.e - 1, this.d[2]};
        int i = this.c.a(this.d[0], this.d[1] - 1, this.d[2]);
        aqz soil = aqz.s[i];
        boolean bl2 = isValidSoil = soil != null && soil.canSustainPlant(this.c, this.d[0], this.d[1] - 1, this.d[2], ForgeDirection.UP, (IPlantable)((aqi)aqz.D));
        if (!isValidSoil) {
            return false;
        }
        int j2 = this.a(aint, aint1);
        if (j2 == -1) {
            return true;
        }
        if (j2 < 6) {
            return false;
        }
        this.e = j2;
        return true;
    }

    public void a(double par1, double par3, double par5) {
        this.m = (int)(par1 * 12.0);
        if (par1 > 0.5) {
            this.n = 5;
        }
        this.j = par3;
        this.k = par5;
    }

    public boolean a(abw par1World, Random par2Random, int par3, int par4, int par5) {
        this.c = par1World;
        long l = par2Random.nextLong();
        this.b.setSeed(l);
        this.d[0] = par3;
        this.d[1] = par4;
        this.d[2] = par5;
        if (this.e == 0) {
            this.e = 5 + this.b.nextInt(this.m);
        }
        if (!this.e()) {
            return false;
        }
        this.a();
        this.b();
        this.c();
        this.d();
        return true;
    }
}

