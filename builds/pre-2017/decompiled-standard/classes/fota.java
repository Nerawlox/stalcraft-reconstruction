/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.entity.jxsn;
import net.minecraft.util.sajh;
import net.minecraft.util.sajz;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

public class fota
implements mccn {
    public Random _a;
    public mcfq _b;
    public mcfq _c;
    public mcfq _d;
    public mcfq _e;
    public mcfq _f;
    public ozlu _g;
    public double[] _h;
    public foqh[] _i;
    public double[] _j;
    public double[] _k;
    public double[] _l;
    public double[] _m;
    public double[] _n;
    public int[][] _o = new int[32][32];

    public fota(ozlu ozlu2, long l) {
        this._g = ozlu2;
        this._a = new Random(l);
        this._b = new mcfq(this._a, 16);
        this._c = new mcfq(this._a, 16);
        this._d = new mcfq(this._a, 8);
        this._e = new mcfq(this._a, 10);
        this._f = new mcfq(this._a, 16);
        mcfq[] mcfqArray = new mcfq[]{this._b, this._c, this._d, this._e, this._f};
        mcfqArray = TerrainGen.getModdedNoiseGenerators(ozlu2, this._a, mcfqArray);
        this._b = mcfqArray[0];
        this._c = mcfqArray[1];
        this._d = mcfqArray[2];
        this._e = mcfqArray[3];
        this._f = mcfqArray[4];
    }

    public void _a(int n, int n2, byte[] byArray, foqh[] foqhArray) {
        int n3 = 2;
        int n4 = n3 + 1;
        int n5 = 33;
        int n6 = n3 + 1;
        this._h = this._a(this._h, n * n3, 0, n2 * n3, n4, n5, n6);
        for (int i = 0; i < n3; ++i) {
            for (int j = 0; j < n3; ++j) {
                for (int k = 0; k < 32; ++k) {
                    double d = 0.25;
                    double d2 = this._h[((i + 0) * n6 + j + 0) * n5 + k + 0];
                    double d3 = this._h[((i + 0) * n6 + j + 1) * n5 + k + 0];
                    double d4 = this._h[((i + 1) * n6 + j + 0) * n5 + k + 0];
                    double d5 = this._h[((i + 1) * n6 + j + 1) * n5 + k + 0];
                    double d6 = (this._h[((i + 0) * n6 + j + 0) * n5 + k + 1] - d2) * d;
                    double d7 = (this._h[((i + 0) * n6 + j + 1) * n5 + k + 1] - d3) * d;
                    double d8 = (this._h[((i + 1) * n6 + j + 0) * n5 + k + 1] - d4) * d;
                    double d9 = (this._h[((i + 1) * n6 + j + 1) * n5 + k + 1] - d5) * d;
                    for (int i2 = 0; i2 < 4; ++i2) {
                        double d10 = 0.125;
                        double d11 = d2;
                        double d12 = d3;
                        double d13 = (d4 - d2) * d10;
                        double d14 = (d5 - d3) * d10;
                        for (int i3 = 0; i3 < 8; ++i3) {
                            int n7 = i3 + i * 8 << 11 | 0 + j * 8 << 7 | k * 4 + i2;
                            int n8 = 128;
                            double d15 = 0.125;
                            double d16 = d11;
                            double d17 = (d12 - d11) * d15;
                            for (int i4 = 0; i4 < 8; ++i4) {
                                int n9 = 0;
                                if (d16 > 0.0) {
                                    n9 = twgu.field_72082_bJ.field_71990_ca;
                                }
                                byArray[n7] = (byte)n9;
                                n7 += n8;
                                d16 += d17;
                            }
                            d11 += d13;
                            d12 += d14;
                        }
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                        d5 += d9;
                    }
                }
            }
        }
    }

    public void _b(int n, int n2, byte[] byArray, foqh[] foqhArray) {
        ChunkProviderEvent.ReplaceBiomeBlocks replaceBiomeBlocks = new ChunkProviderEvent.ReplaceBiomeBlocks(this, n, n2, byArray, foqhArray);
        MinecraftForge.EVENT_BUS.post(replaceBiomeBlocks);
        if (replaceBiomeBlocks.getResult() == Event.Result.DENY) {
            return;
        }
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                int n3 = 1;
                int n4 = -1;
                byte by = (byte)twgu.field_72082_bJ.field_71990_ca;
                byte by2 = (byte)twgu.field_72082_bJ.field_71990_ca;
                for (int k = 127; k >= 0; --k) {
                    int n5 = (j * 16 + i) * 128 + k;
                    byte by3 = byArray[n5];
                    if (by3 == 0) {
                        n4 = -1;
                        continue;
                    }
                    if (by3 != twgu.field_71981_t.field_71990_ca) continue;
                    if (n4 == -1) {
                        if (n3 <= 0) {
                            by = 0;
                            by2 = (byte)twgu.field_72082_bJ.field_71990_ca;
                        }
                        n4 = n3;
                        if (k >= 0) {
                            byArray[n5] = by;
                            continue;
                        }
                        byArray[n5] = by2;
                        continue;
                    }
                    if (n4 <= 0) continue;
                    --n4;
                    byArray[n5] = by2;
                }
            }
        }
    }

    @Override
    public ixzi _a(int n, int n2) {
        return this._b(n, n2);
    }

    @Override
    public ixzi _b(int n, int n2) {
        this._a.setSeed((long)n * 341873128712L + (long)n2 * 132897987541L);
        byte[] byArray = new byte[32768];
        this._i = this._g.func_72959_q()._b(this._i, n * 16, n2 * 16, 16, 16);
        this._a(n, n2, byArray, this._i);
        this._b(n, n2, byArray, this._i);
        ixzi ixzi2 = new ixzi(this._g, byArray, n, n2);
        byte[] byArray2 = ixzi2._l();
        for (int i = 0; i < byArray2.length; ++i) {
            byArray2[i] = (byte)this._i[i]._P;
        }
        ixzi2._d();
        return ixzi2;
    }

    public double[] _a(double[] dArray, int n, int n2, int n3, int n4, int n5, int n6) {
        ChunkProviderEvent.InitNoiseField initNoiseField = new ChunkProviderEvent.InitNoiseField(this, dArray, n, n2, n3, n4, n5, n6);
        MinecraftForge.EVENT_BUS.post(initNoiseField);
        if (initNoiseField.getResult() == Event.Result.DENY) {
            return initNoiseField.noisefield;
        }
        if (dArray == null) {
            dArray = new double[n4 * n5 * n6];
        }
        double d = 684.412;
        double d2 = 684.412;
        this._m = this._e._a(this._m, n, n3, n4, n6, 1.121, 1.121, 0.5);
        this._n = this._f._a(this._n, n, n3, n4, n6, 200.0, 200.0, 0.5);
        this._j = this._d._a(this._j, n, n2, n3, n4, n5, n6, (d *= 2.0) / 80.0, d2 / 160.0, d / 80.0);
        this._k = this._b._a(this._k, n, n2, n3, n4, n5, n6, d, d2, d);
        this._l = this._c._a(this._l, n, n2, n3, n4, n5, n6, d, d2, d);
        int n7 = 0;
        int n8 = 0;
        for (int i = 0; i < n4; ++i) {
            for (int j = 0; j < n6; ++j) {
                double d3;
                double d4 = (this._m[n8] + 256.0) / 512.0;
                if (d4 > 1.0) {
                    d4 = 1.0;
                }
                if ((d3 = this._n[n8] / 8000.0) < 0.0) {
                    d3 = -d3 * 0.3;
                }
                d3 = d3 * 3.0 - 2.0;
                float f = (float)(i + n - 0) / 1.0f;
                float f2 = (float)(j + n3 - 0) / 1.0f;
                float f3 = 100.0f - sajh._c(f * f + f2 * f2) * 8.0f;
                if (f3 > 80.0f) {
                    f3 = 80.0f;
                }
                if (f3 < -100.0f) {
                    f3 = -100.0f;
                }
                if (d3 > 1.0) {
                    d3 = 1.0;
                }
                d3 /= 8.0;
                d3 = 0.0;
                if (d4 < 0.0) {
                    d4 = 0.0;
                }
                d4 += 0.5;
                d3 = d3 * (double)n5 / 16.0;
                ++n8;
                double d5 = (double)n5 / 2.0;
                for (int k = 0; k < n5; ++k) {
                    double d6;
                    double d7 = 0.0;
                    double d8 = ((double)k - d5) * 8.0 / d4;
                    if (d8 < 0.0) {
                        d8 *= -1.0;
                    }
                    double d9 = this._k[n7] / 512.0;
                    double d10 = this._l[n7] / 512.0;
                    double d11 = (this._j[n7] / 10.0 + 1.0) / 2.0;
                    d7 = d11 < 0.0 ? d9 : (d11 > 1.0 ? d10 : d9 + (d10 - d9) * d11);
                    d7 -= 8.0;
                    d7 += (double)f3;
                    int n9 = 2;
                    if (k > n5 / 2 - n9) {
                        d6 = (float)(k - (n5 / 2 - n9)) / 64.0f;
                        if (d6 < 0.0) {
                            d6 = 0.0;
                        }
                        if (d6 > 1.0) {
                            d6 = 1.0;
                        }
                        d7 = d7 * (1.0 - d6) + -3000.0 * d6;
                    }
                    if (k < (n9 = 8)) {
                        d6 = (float)(n9 - k) / ((float)n9 - 1.0f);
                        d7 = d7 * (1.0 - d6) + -30.0 * d6;
                    }
                    dArray[n7] = d7;
                    ++n7;
                }
            }
        }
        return dArray;
    }

    @Override
    public boolean _c(int n, int n2) {
        return true;
    }

    @Override
    public void _a(mccn mccn2, int n, int n2) {
        uilx._e = true;
        MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Pre(mccn2, this._g, this._g.field_73012_v, n, n2, false));
        int n3 = n * 16;
        int n4 = n2 * 16;
        foqh foqh2 = this._g.func_72807_a(n3 + 16, n4 + 16);
        foqh2._a(this._g, this._g.field_73012_v, n3, n4);
        MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Post(mccn2, this._g, this._g.field_73012_v, n, n2, false));
        uilx._e = false;
    }

    @Override
    public boolean _a(boolean bl, sajz sajz2) {
        return true;
    }

    @Override
    public void _a() {
    }

    @Override
    public boolean _b() {
        return false;
    }

    @Override
    public boolean _c() {
        return true;
    }

    @Override
    public String _d() {
        return "RandomLevelSource";
    }

    @Override
    public List _a(jxsn jxsn2, int n, int n2, int n3) {
        foqh foqh2 = this._g.func_72807_a(n, n3);
        return foqh2 == null ? null : foqh2._a(jxsn2);
    }

    @Override
    public xtcd _a(ozlu ozlu2, String string, int n, int n2, int n3) {
        return null;
    }

    @Override
    public int _e() {
        return 0;
    }

    @Override
    public void _d(int n, int n2) {
    }
}

