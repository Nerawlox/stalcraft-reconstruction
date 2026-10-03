/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class dzow
extends yfis {
    public float[] _d = new float[1024];

    public void _a(long l, int n, int n2, byte[] byArray, double d, double d2, double d3, float f, float f2, float f3, int n3, int n4, double d4) {
        int n5;
        Random random = new Random(l);
        double d5 = n * 16 + 8;
        double d6 = n2 * 16 + 8;
        float f4 = 0.0f;
        float f5 = 0.0f;
        if (n4 <= 0) {
            n5 = this._a * 16 - 16;
            n4 = n5 - random.nextInt(n5 / 4);
        }
        n5 = 0;
        if (n3 == -1) {
            n3 = n4 / 2;
            n5 = 1;
        }
        float f6 = 1.0f;
        for (int i = 0; i < 128; ++i) {
            if (i == 0 || random.nextInt(3) == 0) {
                f6 = 1.0f + random.nextFloat() * random.nextFloat() * 1.0f;
            }
            this._d[i] = f6 * f6;
        }
        while (n3 < n4) {
            double d7 = 1.5 + (double)(sajh._a((float)n3 * (float)Math.PI / (float)n4) * f * 1.0f);
            double d8 = d7 * d4;
            d7 *= (double)random.nextFloat() * 0.25 + 0.75;
            d8 *= (double)random.nextFloat() * 0.25 + 0.75;
            float f7 = sajh._b(f3);
            float f8 = sajh._a(f3);
            d += (double)(sajh._b(f2) * f7);
            d2 += (double)f8;
            d3 += (double)(sajh._a(f2) * f7);
            f3 *= 0.7f;
            f3 += f5 * 0.05f;
            f2 += f4 * 0.05f;
            f5 *= 0.8f;
            f4 *= 0.5f;
            f5 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0f;
            f4 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4.0f;
            if (n5 != 0 || random.nextInt(4) != 0) {
                double d9 = d - d5;
                double d10 = d3 - d6;
                double d11 = n4 - n3;
                double d12 = f + 2.0f + 16.0f;
                if (d9 * d9 + d10 * d10 - d11 * d11 > d12 * d12) {
                    return;
                }
                if (d >= d5 - 16.0 - d7 * 2.0 && d3 >= d6 - 16.0 - d7 * 2.0 && d <= d5 + 16.0 + d7 * 2.0 && d3 <= d6 + 16.0 + d7 * 2.0) {
                    int n6;
                    int n7;
                    int n8 = sajh._c(d - d7) - n * 16 - 1;
                    int n9 = sajh._c(d + d7) - n * 16 + 1;
                    int n10 = sajh._c(d2 - d8) - 1;
                    int n11 = sajh._c(d2 + d8) + 1;
                    int n12 = sajh._c(d3 - d7) - n2 * 16 - 1;
                    int n13 = sajh._c(d3 + d7) - n2 * 16 + 1;
                    if (n8 < 0) {
                        n8 = 0;
                    }
                    if (n9 > 16) {
                        n9 = 16;
                    }
                    if (n10 < 1) {
                        n10 = 1;
                    }
                    if (n11 > 120) {
                        n11 = 120;
                    }
                    if (n12 < 0) {
                        n12 = 0;
                    }
                    if (n13 > 16) {
                        n13 = 16;
                    }
                    boolean bl = false;
                    for (n7 = n8; !bl && n7 < n9; ++n7) {
                        for (int i = n12; !bl && i < n13; ++i) {
                            for (int j = n11 + 1; !bl && j >= n10 - 1; --j) {
                                n6 = (n7 * 16 + i) * 128 + j;
                                if (j < 0 || j >= 128) continue;
                                if (this._a(byArray, n6, n7, j, i, n, n2)) {
                                    bl = true;
                                }
                                if (j == n10 - 1 || n7 == n8 || n7 == n9 - 1 || i == n12 || i == n13 - 1) continue;
                                j = n10;
                            }
                        }
                    }
                    if (!bl) {
                        for (n7 = n8; n7 < n9; ++n7) {
                            double d13 = ((double)(n7 + n * 16) + 0.5 - d) / d7;
                            for (n6 = n12; n6 < n13; ++n6) {
                                double d14 = ((double)(n6 + n2 * 16) + 0.5 - d3) / d7;
                                int n14 = (n7 * 16 + n6) * 128 + n11;
                                boolean bl2 = false;
                                if (!(d13 * d13 + d14 * d14 < 1.0)) continue;
                                for (int i = n11 - 1; i >= n10; --i) {
                                    double d15 = ((double)i + 0.5 - d2) / d8;
                                    if ((d13 * d13 + d14 * d14) * (double)this._d[i] + d15 * d15 / 6.0 < 1.0) {
                                        if (this._b(byArray, n14, n7, i, n6, n, n2)) {
                                            bl2 = true;
                                        }
                                        this._a(byArray, n14, n7, i, n6, n, n2, bl2);
                                    }
                                    --n14;
                                }
                            }
                        }
                        if (n5 != 0) break;
                    }
                }
            }
            ++n3;
        }
    }

    @Override
    public void _a(World world, int n, int n2, int n3, int n4, byte[] byArray) {
        if (this._b.nextInt(50) == 0) {
            double d = n * 16 + this._b.nextInt(16);
            double d2 = this._b.nextInt(this._b.nextInt(40) + 8) + 20;
            double d3 = n2 * 16 + this._b.nextInt(16);
            int n5 = 1;
            for (int i = 0; i < n5; ++i) {
                float f = this._b.nextFloat() * (float)Math.PI * 2.0f;
                float f2 = (this._b.nextFloat() - 0.5f) * 2.0f / 8.0f;
                float f3 = (this._b.nextFloat() * 2.0f + this._b.nextFloat()) * 2.0f;
                this._a(this._b.nextLong(), n3, n4, byArray, d, d2, d3, f3, f, f2, 0, 0, 3.0);
            }
        }
    }

    public boolean _a(byte[] byArray, int n, int n2, int n3, int n4, int n5, int n6) {
        return byArray[n] == Block.waterMoving.blockID || byArray[n] == Block.waterStill.blockID;
    }

    public boolean _a(BiomeGenBase biomeGenBase) {
        if (biomeGenBase == BiomeGenBase._p) {
            return true;
        }
        if (biomeGenBase == BiomeGenBase._r) {
            return true;
        }
        return biomeGenBase == BiomeGenBase._d;
    }

    public boolean _b(byte[] byArray, int n, int n2, int n3, int n4, int n5, int n6) {
        BiomeGenBase biomeGenBase = this._c.getBiomeGenForCoords(n2 + n5 * 16, n4 + n6 * 16);
        return this._a(biomeGenBase) ? byArray[n] == Block.grass.blockID : byArray[n] == biomeGenBase._A;
    }

    public void _a(byte[] byArray, int n, int n2, int n3, int n4, int n5, int n6, boolean bl) {
        BiomeGenBase biomeGenBase = this._c.getBiomeGenForCoords(n2 + n5 * 16, n4 + n6 * 16);
        int n7 = this._a(biomeGenBase) ? Block.grass.blockID : (int)biomeGenBase._A;
        int n8 = this._a(biomeGenBase) ? Block.dirt.blockID : (int)biomeGenBase._B;
        byte by = byArray[n];
        if (by == Block.stone.blockID || by == n8 || by == n7) {
            if (n3 < 10) {
                byArray[n] = (byte)Block.lavaMoving.blockID;
            } else {
                byArray[n] = 0;
                if (bl && byArray[n - 1] == n8) {
                    byArray[n - 1] = (byte)n7;
                }
            }
        }
    }
}

