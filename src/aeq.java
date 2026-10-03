/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aer
 */
import java.util.Random;

public class aeq
extends aer {
    protected void a(long par1, int par3, int par4, byte[] par5ArrayOfByte, double par6, double par8, double par10) {
        this.a(par1, par3, par4, par5ArrayOfByte, par6, par8, par10, 1.0f + this.b.nextFloat() * 6.0f, 0.0f, 0.0f, -1, -1, 0.5);
    }

    protected void a(long par1, int par3, int par4, byte[] par5ArrayOfByte, double par6, double par8, double par10, float par12, float par13, float par14, int par15, int par16, double par17) {
        boolean flag1;
        double d4 = par3 * 16 + 8;
        double d5 = par4 * 16 + 8;
        float f3 = 0.0f;
        float f4 = 0.0f;
        Random random = new Random(par1);
        if (par16 <= 0) {
            int j1 = this.a * 16 - 16;
            par16 = j1 - random.nextInt(j1 / 4);
        }
        boolean flag = false;
        if (par15 == -1) {
            par15 = par16 / 2;
            flag = true;
        }
        int k1 = random.nextInt(par16 / 2) + par16 / 4;
        boolean bl2 = flag1 = random.nextInt(6) == 0;
        while (par15 < par16) {
            double d6 = 1.5 + (double)(ls.a((float)par15 * (float)Math.PI / (float)par16) * par12 * 1.0f);
            double d7 = d6 * par17;
            float f5 = ls.b(par14);
            float f6 = ls.a(par14);
            par6 += (double)(ls.b(par13) * f5);
            par8 += (double)f6;
            par10 += (double)(ls.a(par13) * f5);
            par14 = flag1 ? (par14 *= 0.92f) : (par14 *= 0.7f);
            par14 += f4 * 0.1f;
            par13 += f3 * 0.1f;
            f4 *= 0.9f;
            f3 *= 0.75f;
            f4 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0f;
            f3 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4.0f;
            if (!flag && par15 == k1 && par12 > 1.0f && par16 > 0) {
                this.a(random.nextLong(), par3, par4, par5ArrayOfByte, par6, par8, par10, random.nextFloat() * 0.5f + 0.5f, par13 - 1.5707964f, par14 / 3.0f, par15, par16, 1.0);
                this.a(random.nextLong(), par3, par4, par5ArrayOfByte, par6, par8, par10, random.nextFloat() * 0.5f + 0.5f, par13 + 1.5707964f, par14 / 3.0f, par15, par16, 1.0);
                return;
            }
            if (flag || random.nextInt(4) != 0) {
                double d8 = par6 - d4;
                double d9 = par10 - d5;
                double d10 = par16 - par15;
                double d11 = par12 + 2.0f + 16.0f;
                if (d8 * d8 + d9 * d9 - d10 * d10 > d11 * d11) {
                    return;
                }
                if (par6 >= d4 - 16.0 - d6 * 2.0 && par10 >= d5 - 16.0 - d6 * 2.0 && par6 <= d4 + 16.0 + d6 * 2.0 && par10 <= d5 + 16.0 + d6 * 2.0) {
                    int k3;
                    int j3;
                    int l1 = ls.c(par6 - d6) - par3 * 16 - 1;
                    int i2 = ls.c(par6 + d6) - par3 * 16 + 1;
                    int j2 = ls.c(par8 - d7) - 1;
                    int k2 = ls.c(par8 + d7) + 1;
                    int l2 = ls.c(par10 - d6) - par4 * 16 - 1;
                    int i3 = ls.c(par10 + d6) - par4 * 16 + 1;
                    if (l1 < 0) {
                        l1 = 0;
                    }
                    if (i2 > 16) {
                        i2 = 16;
                    }
                    if (j2 < 1) {
                        j2 = 1;
                    }
                    if (k2 > 120) {
                        k2 = 120;
                    }
                    if (l2 < 0) {
                        l2 = 0;
                    }
                    if (i3 > 16) {
                        i3 = 16;
                    }
                    boolean flag2 = false;
                    for (j3 = l1; !flag2 && j3 < i2; ++j3) {
                        for (int l3 = l2; !flag2 && l3 < i3; ++l3) {
                            for (int i4 = k2 + 1; !flag2 && i4 >= j2 - 1; --i4) {
                                k3 = (j3 * 16 + l3) * 128 + i4;
                                if (i4 < 0 || i4 >= 128) continue;
                                if (this.isOceanBlock(par5ArrayOfByte, k3, j3, i4, l3, par3, par4)) {
                                    flag2 = true;
                                }
                                if (i4 == j2 - 1 || j3 == l1 || j3 == i2 - 1 || l3 == l2 || l3 == i3 - 1) continue;
                                i4 = j2;
                            }
                        }
                    }
                    if (!flag2) {
                        for (j3 = l1; j3 < i2; ++j3) {
                            double d12 = ((double)(j3 + par3 * 16) + 0.5 - par6) / d6;
                            for (k3 = l2; k3 < i3; ++k3) {
                                double d13 = ((double)(k3 + par4 * 16) + 0.5 - par10) / d6;
                                int j4 = (j3 * 16 + k3) * 128 + k2;
                                boolean flag3 = false;
                                if (!(d12 * d12 + d13 * d13 < 1.0)) continue;
                                for (int k4 = k2 - 1; k4 >= j2; --k4) {
                                    double d14 = ((double)k4 + 0.5 - par8) / d7;
                                    if (d14 > -0.7 && d12 * d12 + d14 * d14 + d13 * d13 < 1.0) {
                                        if (this.isTopBlock(par5ArrayOfByte, j4, j3, k4, k3, par3, par4)) {
                                            flag3 = true;
                                        }
                                        this.digBlock(par5ArrayOfByte, j4, j3, k4, k3, par3, par4, flag3);
                                    }
                                    --j4;
                                }
                            }
                        }
                        if (flag) break;
                    }
                }
            }
            ++par15;
        }
    }

    protected void a(abw par1World, int par2, int par3, int par4, int par5, byte[] par6ArrayOfByte) {
        int i1 = this.b.nextInt(this.b.nextInt(this.b.nextInt(40) + 1) + 1);
        if (this.b.nextInt(15) != 0) {
            i1 = 0;
        }
        for (int j1 = 0; j1 < i1; ++j1) {
            double d0 = par2 * 16 + this.b.nextInt(16);
            double d1 = this.b.nextInt(this.b.nextInt(120) + 8);
            double d2 = par3 * 16 + this.b.nextInt(16);
            int k1 = 1;
            if (this.b.nextInt(4) == 0) {
                this.a(this.b.nextLong(), par4, par5, par6ArrayOfByte, d0, d1, d2);
                k1 += this.b.nextInt(4);
            }
            for (int l1 = 0; l1 < k1; ++l1) {
                float f = this.b.nextFloat() * (float)Math.PI * 2.0f;
                float f1 = (this.b.nextFloat() - 0.5f) * 2.0f / 8.0f;
                float f2 = this.b.nextFloat() * 2.0f + this.b.nextFloat();
                if (this.b.nextInt(10) == 0) {
                    f2 *= this.b.nextFloat() * this.b.nextFloat() * 3.0f + 1.0f;
                }
                this.a(this.b.nextLong(), par4, par5, par6ArrayOfByte, d0, d1, d2, f2, f, f1, 0, 0, 1.0);
            }
        }
    }

    protected boolean isOceanBlock(byte[] data, int index, int x2, int y2, int z2, int chunkX, int chunkZ) {
        return data[index] == aqz.F.cF || data[index] == aqz.G.cF;
    }

    private boolean isExceptionBiome(acq biome) {
        if (biome == acq.p) {
            return true;
        }
        if (biome == acq.r) {
            return true;
        }
        return biome == acq.d;
    }

    private boolean isTopBlock(byte[] data, int index, int x2, int y2, int z2, int chunkX, int chunkZ) {
        acq biome = this.c.a(x2 + chunkX * 16, z2 + chunkZ * 16);
        return this.isExceptionBiome(biome) ? data[index] == aqz.z.cF : data[index] == biome.A;
    }

    protected void digBlock(byte[] data, int index, int x2, int y2, int z2, int chunkX, int chunkZ, boolean foundTop) {
        acq biome = this.c.a(x2 + chunkX * 16, z2 + chunkZ * 16);
        int top = this.isExceptionBiome(biome) ? aqz.z.cF : (int)biome.A;
        int filler = this.isExceptionBiome(biome) ? aqz.A.cF : (int)biome.B;
        byte block = data[index];
        if (block == aqz.y.cF || block == filler || block == top) {
            if (y2 < 10) {
                data[index] = (byte)aqz.H.cF;
            } else {
                data[index] = 0;
                if (foundTop && data[index - 1] == filler) {
                    data[index - 1] = (byte)top;
                }
            }
        }
    }
}

