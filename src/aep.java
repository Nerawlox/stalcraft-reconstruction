/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aco
 *  ado
 *  aer
 *  aff
 *  afh
 *  afi
 *  afj
 *  afn
 *  ajt
 *  aos
 *  lx
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.Event
 *  net.minecraftforge.event.Event$Result
 *  net.minecraftforge.event.terraingen.ChunkProviderEvent$InitNoiseField
 *  net.minecraftforge.event.terraingen.ChunkProviderEvent$ReplaceBiomeBlocks
 *  net.minecraftforge.event.terraingen.DecorateBiomeEvent$Decorate$EventType
 *  net.minecraftforge.event.terraingen.DecorateBiomeEvent$Post
 *  net.minecraftforge.event.terraingen.DecorateBiomeEvent$Pre
 *  net.minecraftforge.event.terraingen.InitMapGenEvent$EventType
 *  net.minecraftforge.event.terraingen.PopulateChunkEvent$Populate$EventType
 *  net.minecraftforge.event.terraingen.PopulateChunkEvent$Post
 *  net.minecraftforge.event.terraingen.PopulateChunkEvent$Pre
 *  net.minecraftforge.event.terraingen.TerrainGen
 */
import java.util.List;
import java.util.Random;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.InitMapGenEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

public class aep
implements ado {
    private Random i;
    private ajt j;
    private ajt k;
    private ajt l;
    private ajt m;
    private ajt n;
    public ajt a;
    public ajt b;
    private abw o;
    private double[] p;
    public agn c = new agn();
    private double[] q = new double[256];
    private double[] r = new double[256];
    private double[] s = new double[256];
    private aer t = new aes();
    double[] d;
    double[] e;
    double[] f;
    double[] g;
    double[] h;

    public aep(abw par1World, long par2) {
        this.c = (agn)TerrainGen.getModdedMapGen((aer)this.c, (InitMapGenEvent.EventType)InitMapGenEvent.EventType.NETHER_BRIDGE);
        this.t = TerrainGen.getModdedMapGen((aer)this.t, (InitMapGenEvent.EventType)InitMapGenEvent.EventType.NETHER_CAVE);
        this.o = par1World;
        this.i = new Random(par2);
        this.j = new ajt(this.i, 16);
        this.k = new ajt(this.i, 16);
        this.l = new ajt(this.i, 8);
        this.m = new ajt(this.i, 4);
        this.n = new ajt(this.i, 4);
        this.a = new ajt(this.i, 10);
        this.b = new ajt(this.i, 16);
        ajt[] noiseGens = new ajt[]{this.j, this.k, this.l, this.m, this.n, this.a, this.b};
        noiseGens = TerrainGen.getModdedNoiseGenerators((abw)par1World, (Random)this.i, (ajt[])noiseGens);
        this.j = noiseGens[0];
        this.k = noiseGens[1];
        this.l = noiseGens[2];
        this.m = noiseGens[3];
        this.n = noiseGens[4];
        this.a = noiseGens[5];
        this.b = noiseGens[6];
    }

    public void a(int par1, int par2, byte[] par3ArrayOfByte) {
        int b0 = 4;
        int b1 = 32;
        int k = b0 + 1;
        int b2 = 17;
        int l = b0 + 1;
        this.p = this.a(this.p, par1 * b0, 0, par2 * b0, k, b2, l);
        for (int i1 = 0; i1 < b0; ++i1) {
            for (int j1 = 0; j1 < b0; ++j1) {
                for (int k1 = 0; k1 < 16; ++k1) {
                    double d0 = 0.125;
                    double d1 = this.p[((i1 + 0) * l + j1 + 0) * b2 + k1 + 0];
                    double d2 = this.p[((i1 + 0) * l + j1 + 1) * b2 + k1 + 0];
                    double d3 = this.p[((i1 + 1) * l + j1 + 0) * b2 + k1 + 0];
                    double d4 = this.p[((i1 + 1) * l + j1 + 1) * b2 + k1 + 0];
                    double d5 = (this.p[((i1 + 0) * l + j1 + 0) * b2 + k1 + 1] - d1) * d0;
                    double d6 = (this.p[((i1 + 0) * l + j1 + 1) * b2 + k1 + 1] - d2) * d0;
                    double d7 = (this.p[((i1 + 1) * l + j1 + 0) * b2 + k1 + 1] - d3) * d0;
                    double d8 = (this.p[((i1 + 1) * l + j1 + 1) * b2 + k1 + 1] - d4) * d0;
                    for (int l1 = 0; l1 < 8; ++l1) {
                        double d9 = 0.25;
                        double d10 = d1;
                        double d11 = d2;
                        double d12 = (d3 - d1) * d9;
                        double d13 = (d4 - d2) * d9;
                        for (int i2 = 0; i2 < 4; ++i2) {
                            int j2 = i2 + i1 * 4 << 11 | 0 + j1 * 4 << 7 | k1 * 8 + l1;
                            int short1 = 128;
                            double d14 = 0.25;
                            double d15 = d10;
                            double d16 = (d11 - d10) * d14;
                            for (int k2 = 0; k2 < 4; ++k2) {
                                int l2 = 0;
                                if (k1 * 8 + l1 < b1) {
                                    l2 = aqz.I.cF;
                                }
                                if (d15 > 0.0) {
                                    l2 = aqz.bg.cF;
                                }
                                par3ArrayOfByte[j2] = (byte)l2;
                                j2 += short1;
                                d15 += d16;
                            }
                            d10 += d12;
                            d11 += d13;
                        }
                        d1 += d5;
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                    }
                }
            }
        }
    }

    public void b(int par1, int par2, byte[] par3ArrayOfByte) {
        ChunkProviderEvent.ReplaceBiomeBlocks event = new ChunkProviderEvent.ReplaceBiomeBlocks((ado)this, par1, par2, par3ArrayOfByte, null);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (event.getResult() == Event.Result.DENY) {
            return;
        }
        int b0 = 64;
        double d0 = 0.03125;
        this.q = this.m.a(this.q, par1 * 16, par2 * 16, 0, 16, 16, 1, d0, d0, 1.0);
        this.r = this.m.a(this.r, par1 * 16, 109, par2 * 16, 16, 1, 16, d0, 1.0, d0);
        this.s = this.n.a(this.s, par1 * 16, par2 * 16, 0, 16, 16, 1, d0 * 2.0, d0 * 2.0, d0 * 2.0);
        for (int k = 0; k < 16; ++k) {
            for (int l = 0; l < 16; ++l) {
                boolean flag = this.q[k + l * 16] + this.i.nextDouble() * 0.2 > 0.0;
                boolean flag1 = this.r[k + l * 16] + this.i.nextDouble() * 0.2 > 0.0;
                int i1 = (int)(this.s[k + l * 16] / 3.0 + 3.0 + this.i.nextDouble() * 0.25);
                int j1 = -1;
                byte b1 = (byte)aqz.bg.cF;
                byte b2 = (byte)aqz.bg.cF;
                for (int k1 = 127; k1 >= 0; --k1) {
                    int l1 = (l * 16 + k) * 128 + k1;
                    if (k1 < 127 - this.i.nextInt(5) && k1 > 0 + this.i.nextInt(5)) {
                        byte b3 = par3ArrayOfByte[l1];
                        if (b3 == 0) {
                            j1 = -1;
                            continue;
                        }
                        if (b3 != aqz.bg.cF) continue;
                        if (j1 == -1) {
                            if (i1 <= 0) {
                                b1 = 0;
                                b2 = (byte)aqz.bg.cF;
                            } else if (k1 >= b0 - 4 && k1 <= b0 + 1) {
                                b1 = (byte)aqz.bg.cF;
                                b2 = (byte)aqz.bg.cF;
                                if (flag1) {
                                    b1 = (byte)aqz.K.cF;
                                }
                                if (flag1) {
                                    b2 = (byte)aqz.bg.cF;
                                }
                                if (flag) {
                                    b1 = (byte)aqz.bh.cF;
                                }
                                if (flag) {
                                    b2 = (byte)aqz.bh.cF;
                                }
                            }
                            if (k1 < b0 && b1 == 0) {
                                b1 = (byte)aqz.I.cF;
                            }
                            j1 = i1;
                            if (k1 >= b0 - 1) {
                                par3ArrayOfByte[l1] = b1;
                                continue;
                            }
                            par3ArrayOfByte[l1] = b2;
                            continue;
                        }
                        if (j1 <= 0) continue;
                        --j1;
                        par3ArrayOfByte[l1] = b2;
                        continue;
                    }
                    par3ArrayOfByte[l1] = (byte)aqz.E.cF;
                }
            }
        }
    }

    public adr c(int par1, int par2) {
        return this.d(par1, par2);
    }

    public adr d(int par1, int par2) {
        this.i.setSeed((long)par1 * 341873128712L + (long)par2 * 132897987541L);
        byte[] abyte = new byte[32768];
        this.a(par1, par2, abyte);
        this.b(par1, par2, abyte);
        this.t.a((ado)this, this.o, par1, par2, abyte);
        this.c.a(this, this.o, par1, par2, abyte);
        adr chunk = new adr(this.o, abyte, par1, par2);
        acq[] abiomegenbase = this.o.u().b((acq[])null, par1 * 16, par2 * 16, 16, 16);
        byte[] abyte1 = chunk.m();
        for (int k = 0; k < abyte1.length; ++k) {
            abyte1[k] = (byte)abiomegenbase[k].N;
        }
        chunk.n();
        return chunk;
    }

    private double[] a(double[] par1ArrayOfDouble, int par2, int par3, int par4, int par5, int par6, int par7) {
        int i2;
        ChunkProviderEvent.InitNoiseField event = new ChunkProviderEvent.InitNoiseField((ado)this, par1ArrayOfDouble, par2, par3, par4, par5, par6, par7);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (event.getResult() == Event.Result.DENY) {
            return event.noisefield;
        }
        if (par1ArrayOfDouble == null) {
            par1ArrayOfDouble = new double[par5 * par6 * par7];
        }
        double d0 = 684.412;
        double d1 = 2053.236;
        this.g = this.a.a(this.g, par2, par3, par4, par5, 1, par7, 1.0, 0.0, 1.0);
        this.h = this.b.a(this.h, par2, par3, par4, par5, 1, par7, 100.0, 0.0, 100.0);
        this.d = this.l.a(this.d, par2, par3, par4, par5, par6, par7, d0 / 80.0, d1 / 60.0, d0 / 80.0);
        this.e = this.j.a(this.e, par2, par3, par4, par5, par6, par7, d0, d1, d0);
        this.f = this.k.a(this.f, par2, par3, par4, par5, par6, par7, d0, d1, d0);
        int k1 = 0;
        int l1 = 0;
        double[] adouble1 = new double[par6];
        for (i2 = 0; i2 < par6; ++i2) {
            adouble1[i2] = Math.cos((double)i2 * Math.PI * 6.0 / (double)par6) * 2.0;
            double d2 = i2;
            if (i2 > par6 / 2) {
                d2 = par6 - 1 - i2;
            }
            if (!(d2 < 4.0)) continue;
            d2 = 4.0 - d2;
            int n = i2;
            adouble1[n] = adouble1[n] - d2 * d2 * d2 * 10.0;
        }
        for (i2 = 0; i2 < par5; ++i2) {
            for (int j2 = 0; j2 < par7; ++j2) {
                double d3 = (this.g[l1] + 256.0) / 512.0;
                if (d3 > 1.0) {
                    d3 = 1.0;
                }
                double d4 = 0.0;
                double d5 = this.h[l1] / 8000.0;
                if (d5 < 0.0) {
                    d5 = -d5;
                }
                if ((d5 = d5 * 3.0 - 3.0) < 0.0) {
                    if ((d5 /= 2.0) < -1.0) {
                        d5 = -1.0;
                    }
                    d5 /= 1.4;
                    d5 /= 2.0;
                    d3 = 0.0;
                } else {
                    if (d5 > 1.0) {
                        d5 = 1.0;
                    }
                    d5 /= 6.0;
                }
                d3 += 0.5;
                d5 = d5 * (double)par6 / 16.0;
                ++l1;
                for (int k2 = 0; k2 < par6; ++k2) {
                    double d11;
                    double d6 = 0.0;
                    double d7 = adouble1[k2];
                    double d8 = this.e[k1] / 512.0;
                    double d9 = this.f[k1] / 512.0;
                    double d10 = (this.d[k1] / 10.0 + 1.0) / 2.0;
                    d6 = d10 < 0.0 ? d8 : (d10 > 1.0 ? d9 : d8 + (d9 - d8) * d10);
                    d6 -= d7;
                    if (k2 > par6 - 4) {
                        d11 = (float)(k2 - (par6 - 4)) / 3.0f;
                        d6 = d6 * (1.0 - d11) + -10.0 * d11;
                    }
                    if ((double)k2 < d4) {
                        d11 = (d4 - (double)k2) / 4.0;
                        if (d11 < 0.0) {
                            d11 = 0.0;
                        }
                        if (d11 > 1.0) {
                            d11 = 1.0;
                        }
                        d6 = d6 * (1.0 - d11) + -10.0 * d11;
                    }
                    par1ArrayOfDouble[k1] = d6;
                    ++k1;
                }
            }
        }
        return par1ArrayOfDouble;
    }

    public boolean a(int par1, int par2) {
        return true;
    }

    public void a(ado par1IChunkProvider, int par2, int par3) {
        int j2;
        int i2;
        int l1;
        int k1;
        int j1;
        int i1;
        aos.c = true;
        MinecraftForge.EVENT_BUS.post((Event)new PopulateChunkEvent.Pre(par1IChunkProvider, this.o, this.i, par2, par3, false));
        int k = par2 * 16;
        int l = par3 * 16;
        this.c.a(this.o, this.i, par2, par3);
        boolean doGen = TerrainGen.populate((ado)par1IChunkProvider, (abw)this.o, (Random)this.i, (int)par2, (int)par3, (boolean)false, (PopulateChunkEvent.Populate.EventType)PopulateChunkEvent.Populate.EventType.NETHER_LAVA);
        for (i1 = 0; doGen && i1 < 8; ++i1) {
            j1 = k + this.i.nextInt(16) + 8;
            k1 = this.i.nextInt(120) + 4;
            l1 = l + this.i.nextInt(16) + 8;
            new afj(aqz.H.cF, false).a(this.o, this.i, j1, k1, l1);
        }
        i1 = this.i.nextInt(this.i.nextInt(10) + 1) + 1;
        doGen = TerrainGen.populate((ado)par1IChunkProvider, (abw)this.o, (Random)this.i, (int)par2, (int)par3, (boolean)false, (PopulateChunkEvent.Populate.EventType)PopulateChunkEvent.Populate.EventType.FIRE);
        for (j1 = 0; doGen && j1 < i1; ++j1) {
            k1 = k + this.i.nextInt(16) + 8;
            l1 = this.i.nextInt(120) + 4;
            i2 = l + this.i.nextInt(16) + 8;
            new afh().a(this.o, this.i, k1, l1, i2);
        }
        i1 = this.i.nextInt(this.i.nextInt(10) + 1);
        doGen = TerrainGen.populate((ado)par1IChunkProvider, (abw)this.o, (Random)this.i, (int)par2, (int)par3, (boolean)false, (PopulateChunkEvent.Populate.EventType)PopulateChunkEvent.Populate.EventType.GLOWSTONE);
        for (j1 = 0; doGen && j1 < i1; ++j1) {
            k1 = k + this.i.nextInt(16) + 8;
            l1 = this.i.nextInt(120) + 4;
            i2 = l + this.i.nextInt(16) + 8;
            new afn().a(this.o, this.i, k1, l1, i2);
        }
        for (j1 = 0; doGen && j1 < 10; ++j1) {
            k1 = k + this.i.nextInt(16) + 8;
            l1 = this.i.nextInt(128);
            i2 = l + this.i.nextInt(16) + 8;
            new afi().a(this.o, this.i, k1, l1, i2);
        }
        MinecraftForge.EVENT_BUS.post((Event)new DecorateBiomeEvent.Pre(this.o, this.i, k, l));
        doGen = TerrainGen.decorate((abw)this.o, (Random)this.i, (int)k, (int)l, (DecorateBiomeEvent.Decorate.EventType)DecorateBiomeEvent.Decorate.EventType.SHROOM);
        if (doGen && this.i.nextInt(1) == 0) {
            j1 = k + this.i.nextInt(16) + 8;
            k1 = this.i.nextInt(128);
            l1 = l + this.i.nextInt(16) + 8;
            new aff(aqz.ak.cF).a(this.o, this.i, j1, k1, l1);
        }
        if (doGen && this.i.nextInt(1) == 0) {
            j1 = k + this.i.nextInt(16) + 8;
            k1 = this.i.nextInt(128);
            l1 = l + this.i.nextInt(16) + 8;
            new aff(aqz.al.cF).a(this.o, this.i, j1, k1, l1);
        }
        afq worldgenminable = new afq(aqz.cu.cF, 13, aqz.bg.cF);
        for (k1 = 0; k1 < 16; ++k1) {
            l1 = k + this.i.nextInt(16);
            i2 = this.i.nextInt(108) + 10;
            j2 = l + this.i.nextInt(16);
            worldgenminable.a(this.o, this.i, l1, i2, j2);
        }
        for (k1 = 0; k1 < 16; ++k1) {
            l1 = k + this.i.nextInt(16);
            i2 = this.i.nextInt(108) + 10;
            j2 = l + this.i.nextInt(16);
            new afj(aqz.H.cF, true).a(this.o, this.i, l1, i2, j2);
        }
        MinecraftForge.EVENT_BUS.post((Event)new DecorateBiomeEvent.Post(this.o, this.i, k, l));
        MinecraftForge.EVENT_BUS.post((Event)new PopulateChunkEvent.Post(par1IChunkProvider, this.o, this.i, par2, par3, false));
        aos.c = false;
    }

    public boolean a(boolean par1, lx par2IProgressUpdate) {
        return true;
    }

    public void b() {
    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        return true;
    }

    public String e() {
        return "HellRandomLevelSource";
    }

    public List a(oh par1EnumCreatureType, int par2, int par3, int par4) {
        acq biomegenbase;
        if (par1EnumCreatureType == oh.a) {
            if (this.c.b(par2, par3, par4)) {
                return this.c.b();
            }
            if (this.c.d(par2, par3, par4) && this.o.a(par2, par3 - 1, par4) == aqz.bF.cF) {
                return this.c.b();
            }
        }
        return (biomegenbase = this.o.a(par2, par4)) == null ? null : biomegenbase.a(par1EnumCreatureType);
    }

    public aco a(abw par1World, String par2Str, int par3, int par4, int par5) {
        return null;
    }

    public int f() {
        return 0;
    }

    public void e(int par1, int par2) {
        this.c.a(this, this.o, par1, par2, null);
    }
}

