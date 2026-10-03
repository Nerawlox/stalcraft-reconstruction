/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.sajz;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.InitMapGenEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

public class ozoc
implements IChunkProvider {
    public Random _a;
    public mcfq _b;
    public mcfq _c;
    public mcfq _d;
    public mcfq _e;
    public mcfq _f;
    public mcfq _g;
    public mcfq _h;
    public World _i;
    public double[] _j;
    public qoyo _k = new qoyo();
    public double[] _l = new double[256];
    public double[] _m = new double[256];
    public double[] _n = new double[256];
    public yfis _o = new ywju();
    public double[] _p;
    public double[] _q;
    public double[] _r;
    public double[] _s;
    public double[] _t;

    public ozoc(World world, long l) {
        this._k = (qoyo)TerrainGen.getModdedMapGen(this._k, InitMapGenEvent.EventType.NETHER_BRIDGE);
        this._o = TerrainGen.getModdedMapGen(this._o, InitMapGenEvent.EventType.NETHER_CAVE);
        this._i = world;
        this._a = new Random(l);
        this._b = new mcfq(this._a, 16);
        this._c = new mcfq(this._a, 16);
        this._d = new mcfq(this._a, 8);
        this._e = new mcfq(this._a, 4);
        this._f = new mcfq(this._a, 4);
        this._g = new mcfq(this._a, 10);
        this._h = new mcfq(this._a, 16);
        mcfq[] mcfqArray = new mcfq[]{this._b, this._c, this._d, this._e, this._f, this._g, this._h};
        mcfqArray = TerrainGen.getModdedNoiseGenerators(world, this._a, mcfqArray);
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
        int n4 = 32;
        int n5 = n3 + 1;
        int n6 = 17;
        int n7 = n3 + 1;
        this._j = this._a(this._j, n * n3, 0, n2 * n3, n5, n6, n7);
        for (int i = 0; i < n3; ++i) {
            for (int j = 0; j < n3; ++j) {
                for (int k = 0; k < 16; ++k) {
                    double d = 0.125;
                    double d2 = this._j[((i + 0) * n7 + j + 0) * n6 + k + 0];
                    double d3 = this._j[((i + 0) * n7 + j + 1) * n6 + k + 0];
                    double d4 = this._j[((i + 1) * n7 + j + 0) * n6 + k + 0];
                    double d5 = this._j[((i + 1) * n7 + j + 1) * n6 + k + 0];
                    double d6 = (this._j[((i + 0) * n7 + j + 0) * n6 + k + 1] - d2) * d;
                    double d7 = (this._j[((i + 0) * n7 + j + 1) * n6 + k + 1] - d3) * d;
                    double d8 = (this._j[((i + 1) * n7 + j + 0) * n6 + k + 1] - d4) * d;
                    double d9 = (this._j[((i + 1) * n7 + j + 1) * n6 + k + 1] - d5) * d;
                    for (int i2 = 0; i2 < 8; ++i2) {
                        double d10 = 0.25;
                        double d11 = d2;
                        double d12 = d3;
                        double d13 = (d4 - d2) * d10;
                        double d14 = (d5 - d3) * d10;
                        for (int i3 = 0; i3 < 4; ++i3) {
                            int n8 = i3 + i * 4 << 11 | 0 + j * 4 << 7 | k * 8 + i2;
                            int n9 = 128;
                            double d15 = 0.25;
                            double d16 = d11;
                            double d17 = (d12 - d11) * d15;
                            for (int i4 = 0; i4 < 4; ++i4) {
                                int n10 = 0;
                                if (k * 8 + i2 < n4) {
                                    n10 = Block.lavaStill.blockID;
                                }
                                if (d16 > 0.0) {
                                    n10 = Block.netherrack.blockID;
                                }
                                byArray[n8] = (byte)n10;
                                n8 += n9;
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

    public void _b(int n, int n2, byte[] byArray) {
        ChunkProviderEvent.ReplaceBiomeBlocks replaceBiomeBlocks = new ChunkProviderEvent.ReplaceBiomeBlocks(this, n, n2, byArray, null);
        MinecraftForge.EVENT_BUS.post(replaceBiomeBlocks);
        if (replaceBiomeBlocks.getResult() == Event.Result.DENY) {
            return;
        }
        int n3 = 64;
        double d = 0.03125;
        this._l = this._e._a(this._l, n * 16, n2 * 16, 0, 16, 16, 1, d, d, 1.0);
        this._m = this._e._a(this._m, n * 16, 109, n2 * 16, 16, 1, 16, d, 1.0, d);
        this._n = this._f._a(this._n, n * 16, n2 * 16, 0, 16, 16, 1, d * 2.0, d * 2.0, d * 2.0);
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                boolean bl = this._l[i + j * 16] + this._a.nextDouble() * 0.2 > 0.0;
                boolean bl2 = this._m[i + j * 16] + this._a.nextDouble() * 0.2 > 0.0;
                int n4 = (int)(this._n[i + j * 16] / 3.0 + 3.0 + this._a.nextDouble() * 0.25);
                int n5 = -1;
                byte by = (byte)Block.netherrack.blockID;
                byte by2 = (byte)Block.netherrack.blockID;
                for (int k = 127; k >= 0; --k) {
                    int n6 = (j * 16 + i) * 128 + k;
                    if (k < 127 - this._a.nextInt(5) && k > 0 + this._a.nextInt(5)) {
                        byte by3 = byArray[n6];
                        if (by3 == 0) {
                            n5 = -1;
                            continue;
                        }
                        if (by3 != Block.netherrack.blockID) continue;
                        if (n5 == -1) {
                            if (n4 <= 0) {
                                by = 0;
                                by2 = (byte)Block.netherrack.blockID;
                            } else if (k >= n3 - 4 && k <= n3 + 1) {
                                by = (byte)Block.netherrack.blockID;
                                by2 = (byte)Block.netherrack.blockID;
                                if (bl2) {
                                    by = (byte)Block.gravel.blockID;
                                }
                                if (bl2) {
                                    by2 = (byte)Block.netherrack.blockID;
                                }
                                if (bl) {
                                    by = (byte)Block.slowSand.blockID;
                                }
                                if (bl) {
                                    by2 = (byte)Block.slowSand.blockID;
                                }
                            }
                            if (k < n3 && by == 0) {
                                by = (byte)Block.lavaStill.blockID;
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
                        --n5;
                        byArray[n6] = by2;
                        continue;
                    }
                    byArray[n6] = (byte)Block.bedrock.blockID;
                }
            }
        }
    }

    @Override
    public Chunk _a(int n, int n2) {
        return this._b(n, n2);
    }

    @Override
    public Chunk _b(int n, int n2) {
        this._a.setSeed((long)n * 341873128712L + (long)n2 * 132897987541L);
        byte[] byArray = new byte[32768];
        this._a(n, n2, byArray);
        this._b(n, n2, byArray);
        this._o._a(this, this._i, n, n2, byArray);
        this._k._a(this, this._i, n, n2, byArray);
        Chunk chunk = new Chunk(this._i, byArray, n, n2);
        BiomeGenBase[] biomeGenBaseArray = this._i.getWorldChunkManager()._b((BiomeGenBase[])null, n * 16, n2 * 16, 16, 16);
        byte[] byArray2 = chunk._l();
        for (int i = 0; i < byArray2.length; ++i) {
            byArray2[i] = (byte)biomeGenBaseArray[i]._P;
        }
        chunk._m();
        return chunk;
    }

    public double[] _a(double[] dArray, int n, int n2, int n3, int n4, int n5, int n6) {
        int n7;
        ChunkProviderEvent.InitNoiseField initNoiseField = new ChunkProviderEvent.InitNoiseField(this, dArray, n, n2, n3, n4, n5, n6);
        MinecraftForge.EVENT_BUS.post(initNoiseField);
        if (initNoiseField.getResult() == Event.Result.DENY) {
            return initNoiseField.noisefield;
        }
        if (dArray == null) {
            dArray = new double[n4 * n5 * n6];
        }
        double d = 684.412;
        double d2 = 2053.236;
        this._s = this._g._a(this._s, n, n2, n3, n4, 1, n6, 1.0, 0.0, 1.0);
        this._t = this._h._a(this._t, n, n2, n3, n4, 1, n6, 100.0, 0.0, 100.0);
        this._p = this._d._a(this._p, n, n2, n3, n4, n5, n6, d / 80.0, d2 / 60.0, d / 80.0);
        this._q = this._b._a(this._q, n, n2, n3, n4, n5, n6, d, d2, d);
        this._r = this._c._a(this._r, n, n2, n3, n4, n5, n6, d, d2, d);
        int n8 = 0;
        int n9 = 0;
        double[] dArray2 = new double[n5];
        for (n7 = 0; n7 < n5; ++n7) {
            dArray2[n7] = Math.cos((double)n7 * Math.PI * 6.0 / (double)n5) * 2.0;
            double d3 = n7;
            if (n7 > n5 / 2) {
                d3 = n5 - 1 - n7;
            }
            if (!(d3 < 4.0)) continue;
            d3 = 4.0 - d3;
            int n10 = n7;
            dArray2[n10] = dArray2[n10] - d3 * d3 * d3 * 10.0;
        }
        for (n7 = 0; n7 < n4; ++n7) {
            for (int i = 0; i < n6; ++i) {
                double d4 = (this._s[n9] + 256.0) / 512.0;
                if (d4 > 1.0) {
                    d4 = 1.0;
                }
                double d5 = 0.0;
                double d6 = this._t[n9] / 8000.0;
                if (d6 < 0.0) {
                    d6 = -d6;
                }
                if ((d6 = d6 * 3.0 - 3.0) < 0.0) {
                    if ((d6 /= 2.0) < -1.0) {
                        d6 = -1.0;
                    }
                    d6 /= 1.4;
                    d6 /= 2.0;
                    d4 = 0.0;
                } else {
                    if (d6 > 1.0) {
                        d6 = 1.0;
                    }
                    d6 /= 6.0;
                }
                d4 += 0.5;
                d6 = d6 * (double)n5 / 16.0;
                ++n9;
                for (int j = 0; j < n5; ++j) {
                    double d7;
                    double d8 = 0.0;
                    double d9 = dArray2[j];
                    double d10 = this._q[n8] / 512.0;
                    double d11 = this._r[n8] / 512.0;
                    double d12 = (this._p[n8] / 10.0 + 1.0) / 2.0;
                    d8 = d12 < 0.0 ? d10 : (d12 > 1.0 ? d11 : d10 + (d11 - d10) * d12);
                    d8 -= d9;
                    if (j > n5 - 4) {
                        d7 = (float)(j - (n5 - 4)) / 3.0f;
                        d8 = d8 * (1.0 - d7) + -10.0 * d7;
                    }
                    if ((double)j < d5) {
                        d7 = (d5 - (double)j) / 4.0;
                        if (d7 < 0.0) {
                            d7 = 0.0;
                        }
                        if (d7 > 1.0) {
                            d7 = 1.0;
                        }
                        d8 = d8 * (1.0 - d7) + -10.0 * d7;
                    }
                    dArray[n8] = d8;
                    ++n8;
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
    public void _a(IChunkProvider iChunkProvider, int n, int n2) {
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        uilx._e = true;
        MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Pre(iChunkProvider, this._i, this._a, n, n2, false));
        int n9 = n * 16;
        int n10 = n2 * 16;
        this._k._a(this._i, this._a, n, n2);
        boolean bl = TerrainGen.populate(iChunkProvider, this._i, this._a, n, n2, false, PopulateChunkEvent.Populate.EventType.NETHER_LAVA);
        for (n8 = 0; bl && n8 < 8; ++n8) {
            n7 = n9 + this._a.nextInt(16) + 8;
            n6 = this._a.nextInt(120) + 4;
            n5 = n10 + this._a.nextInt(16) + 8;
            new igzp(Block.lavaMoving.blockID, false)._a(this._i, this._a, n7, n6, n5);
        }
        n8 = this._a.nextInt(this._a.nextInt(10) + 1) + 1;
        bl = TerrainGen.populate(iChunkProvider, this._i, this._a, n, n2, false, PopulateChunkEvent.Populate.EventType.FIRE);
        for (n7 = 0; bl && n7 < n8; ++n7) {
            n6 = n9 + this._a.nextInt(16) + 8;
            n5 = this._a.nextInt(120) + 4;
            n4 = n10 + this._a.nextInt(16) + 8;
            new mthj()._a(this._i, this._a, n6, n5, n4);
        }
        n8 = this._a.nextInt(this._a.nextInt(10) + 1);
        bl = TerrainGen.populate(iChunkProvider, this._i, this._a, n, n2, false, PopulateChunkEvent.Populate.EventType.GLOWSTONE);
        for (n7 = 0; bl && n7 < n8; ++n7) {
            n6 = n9 + this._a.nextInt(16) + 8;
            n5 = this._a.nextInt(120) + 4;
            n4 = n10 + this._a.nextInt(16) + 8;
            new suxi()._a(this._i, this._a, n6, n5, n4);
        }
        for (n7 = 0; bl && n7 < 10; ++n7) {
            n6 = n9 + this._a.nextInt(16) + 8;
            n5 = this._a.nextInt(128);
            n4 = n10 + this._a.nextInt(16) + 8;
            new plod()._a(this._i, this._a, n6, n5, n4);
        }
        MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(this._i, this._a, n9, n10));
        bl = TerrainGen.decorate(this._i, this._a, n9, n10, DecorateBiomeEvent.Decorate.EventType.SHROOM);
        if (bl && this._a.nextInt(1) == 0) {
            n7 = n9 + this._a.nextInt(16) + 8;
            n6 = this._a.nextInt(128);
            n5 = n10 + this._a.nextInt(16) + 8;
            new xces(Block.mushroomBrown.blockID)._a(this._i, this._a, n7, n6, n5);
        }
        if (bl && this._a.nextInt(1) == 0) {
            n7 = n9 + this._a.nextInt(16) + 8;
            n6 = this._a.nextInt(128);
            n5 = n10 + this._a.nextInt(16) + 8;
            new xces(Block.mushroomRed.blockID)._a(this._i, this._a, n7, n6, n5);
        }
        qoqx qoqx2 = new qoqx(Block.oreNetherQuartz.blockID, 13, Block.netherrack.blockID);
        for (n6 = 0; n6 < 16; ++n6) {
            n5 = n9 + this._a.nextInt(16);
            n4 = this._a.nextInt(108) + 10;
            n3 = n10 + this._a.nextInt(16);
            qoqx2._a(this._i, this._a, n5, n4, n3);
        }
        for (n6 = 0; n6 < 16; ++n6) {
            n5 = n9 + this._a.nextInt(16);
            n4 = this._a.nextInt(108) + 10;
            n3 = n10 + this._a.nextInt(16);
            new igzp(Block.lavaMoving.blockID, true)._a(this._i, this._a, n5, n4, n3);
        }
        MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(this._i, this._a, n9, n10));
        MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Post(iChunkProvider, this._i, this._a, n, n2, false));
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
        return "HellRandomLevelSource";
    }

    @Override
    public List _a(EnumCreatureType enumCreatureType, int n, int n2, int n3) {
        BiomeGenBase biomeGenBase;
        if (enumCreatureType == EnumCreatureType._a) {
            if (this._k._b(n, n2, n3)) {
                return this._k._B_();
            }
            if (this._k._d(n, n2, n3) && this._i.getBlockId(n, n2 - 1, n3) == Block.netherBrick.blockID) {
                return this._k._B_();
            }
        }
        return (biomeGenBase = this._i.getBiomeGenForCoords(n, n3)) == null ? null : biomeGenBase._a(enumCreatureType);
    }

    @Override
    public xtcd _a(World world, String string, int n, int n2, int n3) {
        return null;
    }

    @Override
    public int _e() {
        return 0;
    }

    @Override
    public void _d(int n, int n2) {
        this._k._a(this, this._i, n, n2, null);
    }
}

