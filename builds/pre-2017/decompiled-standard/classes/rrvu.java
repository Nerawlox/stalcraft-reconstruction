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
import net.minecraftforge.event.terraingen.InitMapGenEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

public class rrvu
implements mccn {
    public Random _a;
    public mcfq _b;
    public mcfq _c;
    public mcfq _d;
    public mcfq _e;
    public mcfq _f;
    public mcfq _g;
    public mcfq _h;
    public ozlu _i;
    public final boolean _j;
    public double[] _k;
    public double[] _l = new double[256];
    public yfis _m = new grvk();
    public fozd _n = new fozd();
    public hvak _o = new hvak();
    public bcjz _p = new bcjz();
    public vnal _q = new vnal();
    public yfis _r = new dzow();
    public foqh[] _s;
    public double[] _t;
    public double[] _u;
    public double[] _v;
    public double[] _w;
    public double[] _x;
    public float[] _y;
    public int[][] _z = new int[32][32];

    public rrvu(ozlu ozlu2, long l, boolean bl) {
        this._m = TerrainGen.getModdedMapGen(this._m, InitMapGenEvent.EventType.CAVE);
        this._n = (fozd)TerrainGen.getModdedMapGen(this._n, InitMapGenEvent.EventType.STRONGHOLD);
        this._o = (hvak)TerrainGen.getModdedMapGen(this._o, InitMapGenEvent.EventType.VILLAGE);
        this._p = (bcjz)TerrainGen.getModdedMapGen(this._p, InitMapGenEvent.EventType.MINESHAFT);
        this._q = (vnal)TerrainGen.getModdedMapGen(this._q, InitMapGenEvent.EventType.SCATTERED_FEATURE);
        this._r = TerrainGen.getModdedMapGen(this._r, InitMapGenEvent.EventType.RAVINE);
        this._i = ozlu2;
        this._j = bl;
        this._a = new Random(l);
        this._b = new mcfq(this._a, 16);
        this._c = new mcfq(this._a, 16);
        this._d = new mcfq(this._a, 8);
        this._e = new mcfq(this._a, 4);
        this._f = new mcfq(this._a, 10);
        this._g = new mcfq(this._a, 16);
        this._h = new mcfq(this._a, 8);
        mcfq[] mcfqArray = new mcfq[]{this._b, this._c, this._d, this._e, this._f, this._g, this._h};
        mcfqArray = TerrainGen.getModdedNoiseGenerators(ozlu2, this._a, mcfqArray);
        this._b = mcfqArray[0];
        this._c = mcfqArray[1];
        this._d = mcfqArray[2];
        this._e = mcfqArray[3];
        this._f = mcfqArray[4];
        this._g = mcfqArray[5];
        this._h = mcfqArray[6];
    }

    public void _a(int n, int n2, byte[] byArray) {
        int n3 = 4;
        int n4 = 16;
        int n5 = 63;
        int n6 = n3 + 1;
        int n7 = 17;
        int n8 = n3 + 1;
        this._s = this._i.func_72959_q()._a(this._s, n * 4 - 2, n2 * 4 - 2, n6 + 5, n8 + 5);
        this._k = this._a(this._k, n * n3, 0, n2 * n3, n6, n7, n8);
        for (int i = 0; i < n3; ++i) {
            for (int j = 0; j < n3; ++j) {
                for (int k = 0; k < n4; ++k) {
                    double d = 0.125;
                    double d2 = this._k[((i + 0) * n8 + j + 0) * n7 + k + 0];
                    double d3 = this._k[((i + 0) * n8 + j + 1) * n7 + k + 0];
                    double d4 = this._k[((i + 1) * n8 + j + 0) * n7 + k + 0];
                    double d5 = this._k[((i + 1) * n8 + j + 1) * n7 + k + 0];
                    double d6 = (this._k[((i + 0) * n8 + j + 0) * n7 + k + 1] - d2) * d;
                    double d7 = (this._k[((i + 0) * n8 + j + 1) * n7 + k + 1] - d3) * d;
                    double d8 = (this._k[((i + 1) * n8 + j + 0) * n7 + k + 1] - d4) * d;
                    double d9 = (this._k[((i + 1) * n8 + j + 1) * n7 + k + 1] - d5) * d;
                    for (int i2 = 0; i2 < 8; ++i2) {
                        double d10 = 0.25;
                        double d11 = d2;
                        double d12 = d3;
                        double d13 = (d4 - d2) * d10;
                        double d14 = (d5 - d3) * d10;
                        for (int i3 = 0; i3 < 4; ++i3) {
                            int n9 = i3 + i * 4 << 11 | 0 + j * 4 << 7 | k * 8 + i2;
                            int n10 = 128;
                            n9 -= n10;
                            double d15 = 0.25;
                            double d16 = (d12 - d11) * d15;
                            double d17 = d11 - d16;
                            for (int i4 = 0; i4 < 4; ++i4) {
                                double d18;
                                d17 += d16;
                                byArray[n9 += n10] = d18 > 0.0 ? (byte)twgu.field_71981_t.field_71990_ca : (k * 8 + i2 < n5 ? (byte)twgu.field_71943_B.field_71990_ca : (byte)0);
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

    public void _a(int n, int n2, byte[] byArray, foqh[] foqhArray) {
        ChunkProviderEvent.ReplaceBiomeBlocks replaceBiomeBlocks = new ChunkProviderEvent.ReplaceBiomeBlocks(this, n, n2, byArray, foqhArray);
        MinecraftForge.EVENT_BUS.post(replaceBiomeBlocks);
        if (replaceBiomeBlocks.getResult() == Event.Result.DENY) {
            return;
        }
        int n3 = 63;
        double d = 0.03125;
        this._l = this._e._a(this._l, n * 16, n2 * 16, 0, 16, 16, 1, d * 2.0, d * 2.0, d * 2.0);
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                foqh foqh2 = foqhArray[j + i * 16];
                float f = foqh2._k();
                int n4 = (int)(this._l[i + j * 16] / 3.0 + 3.0 + this._a.nextDouble() * 0.25);
                int n5 = -1;
                byte by = foqh2._A;
                byte by2 = foqh2._B;
                for (int k = 127; k >= 0; --k) {
                    int n6 = (j * 16 + i) * 128 + k;
                    if (k <= 0 + this._a.nextInt(5)) {
                        byArray[n6] = (byte)twgu.field_71986_z.field_71990_ca;
                        continue;
                    }
                    byte by3 = byArray[n6];
                    if (by3 == 0) {
                        n5 = -1;
                        continue;
                    }
                    if (by3 != twgu.field_71981_t.field_71990_ca) continue;
                    if (n5 == -1) {
                        if (n4 <= 0) {
                            by = 0;
                            by2 = (byte)twgu.field_71981_t.field_71990_ca;
                        } else if (k >= n3 - 4 && k <= n3 + 1) {
                            by = foqh2._A;
                            by2 = foqh2._B;
                        }
                        if (k < n3 && by == 0) {
                            by = f < 0.15f ? (byte)twgu.field_72036_aT.field_71990_ca : (byte)twgu.field_71943_B.field_71990_ca;
                        }
                        n5 = n4;
                        if (k >= n3 - 1) {
                            byArray[n6] = by;
                            continue;
                        }
                        byArray[n6] = by2;
                        continue;
                    }
                    if (n5 <= 0) continue;
                    byArray[n6] = by2;
                    if (--n5 != 0 || by2 != twgu.field_71939_E.field_71990_ca) continue;
                    n5 = this._a.nextInt(4);
                    by2 = (byte)twgu.field_71957_Q.field_71990_ca;
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
        this._a(n, n2, byArray);
        this._s = this._i.func_72959_q()._b(this._s, n * 16, n2 * 16, 16, 16);
        this._a(n, n2, byArray, this._s);
        this._m._a(this, this._i, n, n2, byArray);
        this._r._a(this, this._i, n, n2, byArray);
        if (this._j) {
            this._p._a(this, this._i, n, n2, byArray);
            this._o._a(this, this._i, n, n2, byArray);
            this._n._a(this, this._i, n, n2, byArray);
            this._q._a(this, this._i, n, n2, byArray);
        }
        ixzi ixzi2 = new ixzi(this._i, byArray, n, n2);
        byte[] byArray2 = ixzi2._l();
        for (int i = 0; i < byArray2.length; ++i) {
            byArray2[i] = (byte)this._s[i]._P;
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
        if (this._y == null) {
            this._y = new float[25];
            for (int i = -2; i <= 2; ++i) {
                for (int j = -2; j <= 2; ++j) {
                    float f;
                    this._y[i + 2 + (j + 2) * 5] = f = 10.0f / sajh._c((float)(i * i + j * j) + 0.2f);
                }
            }
        }
        double d = 684.412;
        double d2 = 684.412;
        this._w = this._f._a(this._w, n, n3, n4, n6, 1.121, 1.121, 0.5);
        this._x = this._g._a(this._x, n, n3, n4, n6, 200.0, 200.0, 0.5);
        this._t = this._d._a(this._t, n, n2, n3, n4, n5, n6, d / 80.0, d2 / 160.0, d / 80.0);
        this._u = this._b._a(this._u, n, n2, n3, n4, n5, n6, d, d2, d);
        this._v = this._c._a(this._v, n, n2, n3, n4, n5, n6, d, d2, d);
        boolean bl = false;
        boolean bl2 = false;
        int n7 = 0;
        int n8 = 0;
        for (int i = 0; i < n4; ++i) {
            for (int j = 0; j < n6; ++j) {
                float f = 0.0f;
                float f2 = 0.0f;
                float f3 = 0.0f;
                int n9 = 2;
                foqh foqh2 = this._s[i + 2 + (j + 2) * (n4 + 5)];
                for (int k = -n9; k <= n9; ++k) {
                    for (int i2 = -n9; i2 <= n9; ++i2) {
                        foqh foqh3 = this._s[i + k + 2 + (j + i2 + 2) * (n4 + 5)];
                        float f4 = this._y[k + 2 + (i2 + 2) * 5] / (foqh3._D + 2.0f);
                        if (foqh3._D > foqh2._D) {
                            f4 /= 2.0f;
                        }
                        f += foqh3._E * f4;
                        f2 += foqh3._D * f4;
                        f3 += f4;
                    }
                }
                f /= f3;
                f2 /= f3;
                f = f * 0.9f + 0.1f;
                f2 = (f2 * 4.0f - 1.0f) / 8.0f;
                double d3 = this._x[n8] / 8000.0;
                if (d3 < 0.0) {
                    d3 = -d3 * 0.3;
                }
                if ((d3 = d3 * 3.0 - 2.0) < 0.0) {
                    if ((d3 /= 2.0) < -1.0) {
                        d3 = -1.0;
                    }
                    d3 /= 1.4;
                    d3 /= 2.0;
                } else {
                    if (d3 > 1.0) {
                        d3 = 1.0;
                    }
                    d3 /= 8.0;
                }
                ++n8;
                for (int k = 0; k < n5; ++k) {
                    double d4 = f2;
                    double d5 = f;
                    d4 += d3 * 0.2;
                    d4 = d4 * (double)n5 / 16.0;
                    double d6 = (double)n5 / 2.0 + d4 * 4.0;
                    double d7 = 0.0;
                    double d8 = ((double)k - d6) * 12.0 * 128.0 / 128.0 / d5;
                    if (d8 < 0.0) {
                        d8 *= 4.0;
                    }
                    double d9 = this._u[n7] / 512.0;
                    double d10 = this._v[n7] / 512.0;
                    double d11 = (this._t[n7] / 10.0 + 1.0) / 2.0;
                    d7 = d11 < 0.0 ? d9 : (d11 > 1.0 ? d10 : d9 + (d10 - d9) * d11);
                    d7 -= d8;
                    if (k > n5 - 4) {
                        double d12 = (float)(k - (n5 - 4)) / 3.0f;
                        d7 = d7 * (1.0 - d12) + -10.0 * d12;
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
        int n3;
        int n4;
        int n5;
        uilx._e = true;
        int n6 = n * 16;
        int n7 = n2 * 16;
        foqh foqh2 = this._i.func_72807_a(n6 + 16, n7 + 16);
        this._a.setSeed(this._i.func_72905_C());
        long l = this._a.nextLong() / 2L * 2L + 1L;
        long l2 = this._a.nextLong() / 2L * 2L + 1L;
        this._a.setSeed((long)n * l + (long)n2 * l2 ^ this._i.func_72905_C());
        boolean bl = false;
        MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Pre(mccn2, this._i, this._a, n, n2, bl));
        if (this._j) {
            this._p._a(this._i, this._a, n, n2);
            bl = this._o._a(this._i, this._a, n, n2);
            this._n._a(this._i, this._a, n, n2);
            this._q._a(this._i, this._a, n, n2);
        }
        if (foqh2 != foqh._d && foqh2 != foqh._s && !bl && this._a.nextInt(4) == 0 && TerrainGen.populate(mccn2, this._i, this._a, n, n2, bl, PopulateChunkEvent.Populate.EventType.LAKE)) {
            n5 = n6 + this._a.nextInt(16) + 8;
            n4 = this._a.nextInt(128);
            n3 = n7 + this._a.nextInt(16) + 8;
            new vnaf(twgu.field_71943_B.field_71990_ca)._a(this._i, this._a, n5, n4, n3);
        }
        if (TerrainGen.populate(mccn2, this._i, this._a, n, n2, bl, PopulateChunkEvent.Populate.EventType.LAVA) && !bl && this._a.nextInt(8) == 0) {
            n5 = n6 + this._a.nextInt(16) + 8;
            n4 = this._a.nextInt(this._a.nextInt(120) + 8);
            n3 = n7 + this._a.nextInt(16) + 8;
            if (n4 < 63 || this._a.nextInt(10) == 0) {
                new vnaf(twgu.field_71938_D.field_71990_ca)._a(this._i, this._a, n5, n4, n3);
            }
        }
        boolean bl2 = TerrainGen.populate(mccn2, this._i, this._a, n, n2, bl, PopulateChunkEvent.Populate.EventType.DUNGEON);
        for (n5 = 0; bl2 && n5 < 8; ++n5) {
            n4 = n6 + this._a.nextInt(16) + 8;
            n3 = this._a.nextInt(128);
            int n8 = n7 + this._a.nextInt(16) + 8;
            new grvu()._a(this._i, this._a, n4, n3, n8);
        }
        foqh2._a(this._i, this._a, n6, n7);
        xtbl._a(this._i, foqh2, n6 + 8, n7 + 8, 16, 16, this._a);
        n6 += 8;
        n7 += 8;
        bl2 = TerrainGen.populate(mccn2, this._i, this._a, n, n2, bl, PopulateChunkEvent.Populate.EventType.ICE);
        for (n5 = 0; bl2 && n5 < 16; ++n5) {
            for (n4 = 0; n4 < 16; ++n4) {
                n3 = this._i.func_72874_g(n6 + n5, n7 + n4);
                if (this._i.func_72884_u(n5 + n6, n3 - 1, n4 + n7)) {
                    this._i.func_72832_d(n5 + n6, n3 - 1, n4 + n7, twgu.field_72036_aT.field_71990_ca, 0, 2);
                }
                if (!this._i.func_72858_w(n5 + n6, n3, n4 + n7)) continue;
                this._i.func_72832_d(n5 + n6, n3, n4 + n7, twgu.field_72037_aS.field_71990_ca, 0, 2);
            }
        }
        MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Post(mccn2, this._i, this._a, n, n2, bl));
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
        foqh foqh2 = this._i.func_72807_a(n, n3);
        return foqh2 == null ? null : (jxsn2 == jxsn._a && this._q._a(n, n2, n3) ? this._q._A_() : foqh2._a(jxsn2));
    }

    @Override
    public xtcd _a(ozlu ozlu2, String string, int n, int n2, int n3) {
        return "Stronghold".equals(string) && this._n != null ? this._n._a(ozlu2, n, n2, n3) : null;
    }

    @Override
    public int _e() {
        return 0;
    }

    @Override
    public void _d(int n, int n2) {
        if (this._j) {
            this._p._a(this, this._i, n, n2, null);
            this._o._a(this, this._i, n, n2, null);
            this._n._a(this, this._i, n, n2, null);
            this._q._a(this, this._i, n, n2, null);
        }
    }
}

