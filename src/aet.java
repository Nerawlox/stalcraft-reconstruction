/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aco
 *  ado
 *  aer
 *  afm
 *  agg
 *  aiw
 *  ajt
 *  aos
 *  lx
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.Event
 *  net.minecraftforge.event.Event$Result
 *  net.minecraftforge.event.terraingen.ChunkProviderEvent$InitNoiseField
 *  net.minecraftforge.event.terraingen.ChunkProviderEvent$ReplaceBiomeBlocks
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
import net.minecraftforge.event.terraingen.InitMapGenEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

public class aet
implements ado {
    private Random k;
    private ajt l;
    private ajt m;
    private ajt n;
    private ajt o;
    public ajt a;
    public ajt b;
    public ajt c;
    private abw p;
    private final boolean q;
    private double[] r;
    private double[] s = new double[256];
    private aer t = new aeq();
    private ahq u = new ahq();
    private aiw v = new aiw();
    private agg w = new agg();
    private ahh x = new ahh();
    private aer y = new aem();
    private acq[] z;
    double[] d;
    double[] e;
    double[] f;
    double[] g;
    double[] h;
    float[] i;
    int[][] j = new int[32][32];

    public aet(abw par1World, long par2, boolean par4) {
        this.t = TerrainGen.getModdedMapGen((aer)this.t, (InitMapGenEvent.EventType)InitMapGenEvent.EventType.CAVE);
        this.u = (ahq)TerrainGen.getModdedMapGen((aer)this.u, (InitMapGenEvent.EventType)InitMapGenEvent.EventType.STRONGHOLD);
        this.v = (aiw)TerrainGen.getModdedMapGen((aer)this.v, (InitMapGenEvent.EventType)InitMapGenEvent.EventType.VILLAGE);
        this.w = (agg)TerrainGen.getModdedMapGen((aer)this.w, (InitMapGenEvent.EventType)InitMapGenEvent.EventType.MINESHAFT);
        this.x = (ahh)TerrainGen.getModdedMapGen((aer)this.x, (InitMapGenEvent.EventType)InitMapGenEvent.EventType.SCATTERED_FEATURE);
        this.y = TerrainGen.getModdedMapGen((aer)this.y, (InitMapGenEvent.EventType)InitMapGenEvent.EventType.RAVINE);
        this.p = par1World;
        this.q = par4;
        this.k = new Random(par2);
        this.l = new ajt(this.k, 16);
        this.m = new ajt(this.k, 16);
        this.n = new ajt(this.k, 8);
        this.o = new ajt(this.k, 4);
        this.a = new ajt(this.k, 10);
        this.b = new ajt(this.k, 16);
        this.c = new ajt(this.k, 8);
        ajt[] noiseGens = new ajt[]{this.l, this.m, this.n, this.o, this.a, this.b, this.c};
        noiseGens = TerrainGen.getModdedNoiseGenerators((abw)par1World, (Random)this.k, (ajt[])noiseGens);
        this.l = noiseGens[0];
        this.m = noiseGens[1];
        this.n = noiseGens[2];
        this.o = noiseGens[3];
        this.a = noiseGens[4];
        this.b = noiseGens[5];
        this.c = noiseGens[6];
    }

    public void a(int par1, int par2, byte[] par3ArrayOfByte) {
        int b0 = 4;
        int b1 = 16;
        int b2 = 63;
        int k = b0 + 1;
        int b3 = 17;
        int l = b0 + 1;
        this.z = this.p.u().a(this.z, par1 * 4 - 2, par2 * 4 - 2, k + 5, l + 5);
        this.r = this.a(this.r, par1 * b0, 0, par2 * b0, k, b3, l);
        for (int i1 = 0; i1 < b0; ++i1) {
            for (int j1 = 0; j1 < b0; ++j1) {
                for (int k1 = 0; k1 < b1; ++k1) {
                    double d0 = 0.125;
                    double d1 = this.r[((i1 + 0) * l + j1 + 0) * b3 + k1 + 0];
                    double d2 = this.r[((i1 + 0) * l + j1 + 1) * b3 + k1 + 0];
                    double d3 = this.r[((i1 + 1) * l + j1 + 0) * b3 + k1 + 0];
                    double d4 = this.r[((i1 + 1) * l + j1 + 1) * b3 + k1 + 0];
                    double d5 = (this.r[((i1 + 0) * l + j1 + 0) * b3 + k1 + 1] - d1) * d0;
                    double d6 = (this.r[((i1 + 0) * l + j1 + 1) * b3 + k1 + 1] - d2) * d0;
                    double d7 = (this.r[((i1 + 1) * l + j1 + 0) * b3 + k1 + 1] - d3) * d0;
                    double d8 = (this.r[((i1 + 1) * l + j1 + 1) * b3 + k1 + 1] - d4) * d0;
                    for (int l1 = 0; l1 < 8; ++l1) {
                        double d9 = 0.25;
                        double d10 = d1;
                        double d11 = d2;
                        double d12 = (d3 - d1) * d9;
                        double d13 = (d4 - d2) * d9;
                        for (int i2 = 0; i2 < 4; ++i2) {
                            int j2 = i2 + i1 * 4 << 11 | 0 + j1 * 4 << 7 | k1 * 8 + l1;
                            int short1 = 128;
                            j2 -= short1;
                            double d14 = 0.25;
                            double d15 = (d11 - d10) * d14;
                            double d16 = d10 - d15;
                            for (int k2 = 0; k2 < 4; ++k2) {
                                double d;
                                d16 += d15;
                                par3ArrayOfByte[j2 += short1] = d > 0.0 ? (byte)aqz.y.cF : (k1 * 8 + l1 < b2 ? (byte)aqz.G.cF : (byte)0);
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

    public void a(int par1, int par2, byte[] par3ArrayOfByte, acq[] par4ArrayOfBiomeGenBase) {
        ChunkProviderEvent.ReplaceBiomeBlocks event = new ChunkProviderEvent.ReplaceBiomeBlocks((ado)this, par1, par2, par3ArrayOfByte, par4ArrayOfBiomeGenBase);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (event.getResult() == Event.Result.DENY) {
            return;
        }
        int b0 = 63;
        double d0 = 0.03125;
        this.s = this.o.a(this.s, par1 * 16, par2 * 16, 0, 16, 16, 1, d0 * 2.0, d0 * 2.0, d0 * 2.0);
        for (int k = 0; k < 16; ++k) {
            for (int l = 0; l < 16; ++l) {
                acq biomegenbase = par4ArrayOfBiomeGenBase[l + k * 16];
                float f = biomegenbase.j();
                int i1 = (int)(this.s[k + l * 16] / 3.0 + 3.0 + this.k.nextDouble() * 0.25);
                int j1 = -1;
                byte b1 = biomegenbase.A;
                byte b2 = biomegenbase.B;
                for (int k1 = 127; k1 >= 0; --k1) {
                    int l1 = (l * 16 + k) * 128 + k1;
                    if (k1 <= 0 + this.k.nextInt(5)) {
                        par3ArrayOfByte[l1] = (byte)aqz.E.cF;
                        continue;
                    }
                    byte b3 = par3ArrayOfByte[l1];
                    if (b3 == 0) {
                        j1 = -1;
                        continue;
                    }
                    if (b3 != aqz.y.cF) continue;
                    if (j1 == -1) {
                        if (i1 <= 0) {
                            b1 = 0;
                            b2 = (byte)aqz.y.cF;
                        } else if (k1 >= b0 - 4 && k1 <= b0 + 1) {
                            b1 = biomegenbase.A;
                            b2 = biomegenbase.B;
                        }
                        if (k1 < b0 && b1 == 0) {
                            b1 = f < 0.15f ? (byte)aqz.aY.cF : (byte)aqz.G.cF;
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
                    par3ArrayOfByte[l1] = b2;
                    if (--j1 != 0 || b2 != aqz.J.cF) continue;
                    j1 = this.k.nextInt(4);
                    b2 = (byte)aqz.V.cF;
                }
            }
        }
    }

    public adr c(int par1, int par2) {
        return this.d(par1, par2);
    }

    public adr d(int par1, int par2) {
        this.k.setSeed((long)par1 * 341873128712L + (long)par2 * 132897987541L);
        byte[] abyte = new byte[32768];
        this.a(par1, par2, abyte);
        this.z = this.p.u().b(this.z, par1 * 16, par2 * 16, 16, 16);
        this.a(par1, par2, abyte, this.z);
        this.t.a((ado)this, this.p, par1, par2, abyte);
        this.y.a((ado)this, this.p, par1, par2, abyte);
        if (this.q) {
            this.w.a((ado)this, this.p, par1, par2, abyte);
            this.v.a((ado)this, this.p, par1, par2, abyte);
            this.u.a(this, this.p, par1, par2, abyte);
            this.x.a(this, this.p, par1, par2, abyte);
        }
        adr chunk = new adr(this.p, abyte, par1, par2);
        byte[] abyte1 = chunk.m();
        for (int k = 0; k < abyte1.length; ++k) {
            abyte1[k] = (byte)this.z[k].N;
        }
        chunk.b();
        return chunk;
    }

    private double[] a(double[] par1ArrayOfDouble, int par2, int par3, int par4, int par5, int par6, int par7) {
        ChunkProviderEvent.InitNoiseField event = new ChunkProviderEvent.InitNoiseField((ado)this, par1ArrayOfDouble, par2, par3, par4, par5, par6, par7);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (event.getResult() == Event.Result.DENY) {
            return event.noisefield;
        }
        if (par1ArrayOfDouble == null) {
            par1ArrayOfDouble = new double[par5 * par6 * par7];
        }
        if (this.i == null) {
            this.i = new float[25];
            for (int k1 = -2; k1 <= 2; ++k1) {
                for (int l1 = -2; l1 <= 2; ++l1) {
                    float f;
                    this.i[k1 + 2 + (l1 + 2) * 5] = f = 10.0f / ls.c((float)(k1 * k1 + l1 * l1) + 0.2f);
                }
            }
        }
        double d0 = 684.412;
        double d1 = 684.412;
        this.g = this.a.a(this.g, par2, par4, par5, par7, 1.121, 1.121, 0.5);
        this.h = this.b.a(this.h, par2, par4, par5, par7, 200.0, 200.0, 0.5);
        this.d = this.n.a(this.d, par2, par3, par4, par5, par6, par7, d0 / 80.0, d1 / 160.0, d0 / 80.0);
        this.e = this.l.a(this.e, par2, par3, par4, par5, par6, par7, d0, d1, d0);
        this.f = this.m.a(this.f, par2, par3, par4, par5, par6, par7, d0, d1, d0);
        boolean flag = false;
        boolean flag1 = false;
        int i2 = 0;
        int j2 = 0;
        for (int k2 = 0; k2 < par5; ++k2) {
            for (int l2 = 0; l2 < par7; ++l2) {
                float f1 = 0.0f;
                float f2 = 0.0f;
                float f3 = 0.0f;
                int b0 = 2;
                acq biomegenbase = this.z[k2 + 2 + (l2 + 2) * (par5 + 5)];
                for (int i3 = -b0; i3 <= b0; ++i3) {
                    for (int j3 = -b0; j3 <= b0; ++j3) {
                        acq biomegenbase1 = this.z[k2 + i3 + 2 + (l2 + j3 + 2) * (par5 + 5)];
                        float f4 = this.i[i3 + 2 + (j3 + 2) * 5] / (biomegenbase1.D + 2.0f);
                        if (biomegenbase1.D > biomegenbase.D) {
                            f4 /= 2.0f;
                        }
                        f1 += biomegenbase1.E * f4;
                        f2 += biomegenbase1.D * f4;
                        f3 += f4;
                    }
                }
                f1 /= f3;
                f2 /= f3;
                f1 = f1 * 0.9f + 0.1f;
                f2 = (f2 * 4.0f - 1.0f) / 8.0f;
                double d2 = this.h[j2] / 8000.0;
                if (d2 < 0.0) {
                    d2 = -d2 * 0.3;
                }
                if ((d2 = d2 * 3.0 - 2.0) < 0.0) {
                    if ((d2 /= 2.0) < -1.0) {
                        d2 = -1.0;
                    }
                    d2 /= 1.4;
                    d2 /= 2.0;
                } else {
                    if (d2 > 1.0) {
                        d2 = 1.0;
                    }
                    d2 /= 8.0;
                }
                ++j2;
                for (int k3 = 0; k3 < par6; ++k3) {
                    double d3 = f2;
                    double d4 = f1;
                    d3 += d2 * 0.2;
                    d3 = d3 * (double)par6 / 16.0;
                    double d5 = (double)par6 / 2.0 + d3 * 4.0;
                    double d6 = 0.0;
                    double d7 = ((double)k3 - d5) * 12.0 * 128.0 / 128.0 / d4;
                    if (d7 < 0.0) {
                        d7 *= 4.0;
                    }
                    double d8 = this.e[i2] / 512.0;
                    double d9 = this.f[i2] / 512.0;
                    double d10 = (this.d[i2] / 10.0 + 1.0) / 2.0;
                    d6 = d10 < 0.0 ? d8 : (d10 > 1.0 ? d9 : d8 + (d9 - d8) * d10);
                    d6 -= d7;
                    if (k3 > par6 - 4) {
                        double d11 = (float)(k3 - (par6 - 4)) / 3.0f;
                        d6 = d6 * (1.0 - d11) + -10.0 * d11;
                    }
                    par1ArrayOfDouble[i2] = d6;
                    ++i2;
                }
            }
        }
        return par1ArrayOfDouble;
    }

    public boolean a(int par1, int par2) {
        return true;
    }

    public void a(ado par1IChunkProvider, int par2, int par3) {
        int i2;
        int l1;
        int k1;
        aos.c = true;
        int k = par2 * 16;
        int l = par3 * 16;
        acq biomegenbase = this.p.a(k + 16, l + 16);
        this.k.setSeed(this.p.H());
        long i1 = this.k.nextLong() / 2L * 2L + 1L;
        long j1 = this.k.nextLong() / 2L * 2L + 1L;
        this.k.setSeed((long)par2 * i1 + (long)par3 * j1 ^ this.p.H());
        boolean flag = false;
        MinecraftForge.EVENT_BUS.post((Event)new PopulateChunkEvent.Pre(par1IChunkProvider, this.p, this.k, par2, par3, flag));
        if (this.q) {
            this.w.a(this.p, this.k, par2, par3);
            flag = this.v.a(this.p, this.k, par2, par3);
            this.u.a(this.p, this.k, par2, par3);
            this.x.a(this.p, this.k, par2, par3);
        }
        if (biomegenbase != acq.d && biomegenbase != acq.s && !flag && this.k.nextInt(4) == 0 && TerrainGen.populate((ado)par1IChunkProvider, (abw)this.p, (Random)this.k, (int)par2, (int)par3, (boolean)flag, (PopulateChunkEvent.Populate.EventType)PopulateChunkEvent.Populate.EventType.LAKE)) {
            k1 = k + this.k.nextInt(16) + 8;
            l1 = this.k.nextInt(128);
            i2 = l + this.k.nextInt(16) + 8;
            new afm(aqz.G.cF).a(this.p, this.k, k1, l1, i2);
        }
        if (TerrainGen.populate((ado)par1IChunkProvider, (abw)this.p, (Random)this.k, (int)par2, (int)par3, (boolean)flag, (PopulateChunkEvent.Populate.EventType)PopulateChunkEvent.Populate.EventType.LAVA) && !flag && this.k.nextInt(8) == 0) {
            k1 = k + this.k.nextInt(16) + 8;
            l1 = this.k.nextInt(this.k.nextInt(120) + 8);
            i2 = l + this.k.nextInt(16) + 8;
            if (l1 < 63 || this.k.nextInt(10) == 0) {
                new afm(aqz.I.cF).a(this.p, this.k, k1, l1, i2);
            }
        }
        boolean doGen = TerrainGen.populate((ado)par1IChunkProvider, (abw)this.p, (Random)this.k, (int)par2, (int)par3, (boolean)flag, (PopulateChunkEvent.Populate.EventType)PopulateChunkEvent.Populate.EventType.DUNGEON);
        for (k1 = 0; doGen && k1 < 8; ++k1) {
            l1 = k + this.k.nextInt(16) + 8;
            i2 = this.k.nextInt(128);
            int j2 = l + this.k.nextInt(16) + 8;
            new afp().a(this.p, this.k, l1, i2, j2);
        }
        biomegenbase.a(this.p, this.k, k, l);
        aci.a(this.p, biomegenbase, k + 8, l + 8, 16, 16, this.k);
        k += 8;
        l += 8;
        doGen = TerrainGen.populate((ado)par1IChunkProvider, (abw)this.p, (Random)this.k, (int)par2, (int)par3, (boolean)flag, (PopulateChunkEvent.Populate.EventType)PopulateChunkEvent.Populate.EventType.ICE);
        for (k1 = 0; doGen && k1 < 16; ++k1) {
            for (l1 = 0; l1 < 16; ++l1) {
                i2 = this.p.h(k + k1, l + l1);
                if (this.p.x(k1 + k, i2 - 1, l1 + l)) {
                    this.p.f(k1 + k, i2 - 1, l1 + l, aqz.aY.cF, 0, 2);
                }
                if (!this.p.z(k1 + k, i2, l1 + l)) continue;
                this.p.f(k1 + k, i2, l1 + l, aqz.aX.cF, 0, 2);
            }
        }
        MinecraftForge.EVENT_BUS.post((Event)new PopulateChunkEvent.Post(par1IChunkProvider, this.p, this.k, par2, par3, flag));
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
        return "RandomLevelSource";
    }

    public List a(oh par1EnumCreatureType, int par2, int par3, int par4) {
        acq biomegenbase = this.p.a(par2, par4);
        return biomegenbase == null ? null : (par1EnumCreatureType == oh.a && this.x.a(par2, par3, par4) ? this.x.b() : biomegenbase.a(par1EnumCreatureType));
    }

    public aco a(abw par1World, String par2Str, int par3, int par4, int par5) {
        return "Stronghold".equals(par2Str) && this.u != null ? this.u.a(par1World, par3, par4, par5) : null;
    }

    public int f() {
        return 0;
    }

    public void e(int par1, int par2) {
        if (this.q) {
            this.w.a((ado)this, this.p, par1, par2, (byte[])null);
            this.v.a((ado)this, this.p, par1, par2, (byte[])null);
            this.u.a(this, this.p, par1, par2, null);
            this.x.a(this, this.p, par1, par2, null);
        }
    }
}

