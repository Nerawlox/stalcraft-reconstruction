/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  acb
 *  acf
 *  akc
 *  asx
 *  ata
 *  atc
 *  atu
 *  auk
 *  bdd
 *  bdo
 *  bdp
 *  bdr
 *  bds
 *  bdt
 *  bdu
 *  bdx
 *  bdz
 *  beb
 *  bed
 *  bee
 *  beg
 *  bei
 *  bej
 *  bek
 *  bel
 *  bem
 *  ben
 *  beo
 *  bep
 *  beq
 *  bes
 *  bfb
 *  bfc
 *  bfm
 *  bfo
 *  bft
 *  bim
 *  bjo
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ji
 *  ms
 *  mt
 *  net.minecraftforge.client.IRenderHandler
 *  net.minecraftforge.client.MinecraftForgeClient
 *  org.lwjgl.opengl.ARBOcclusionQuery
 *  org.lwjgl.opengl.GL11
 *  u
 *  xl
 *  yr
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.client.MinecraftForgeClient;
import org.lwjgl.opengl.ARBOcclusionQuery;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class bfl
implements acb {
    private static final bjo g = new bjo("textures/environment/moon_phases.png");
    private static final bjo h = new bjo("textures/environment/sun.png");
    private static final bjo i = new bjo("textures/environment/clouds.png");
    private static final bjo j = new bjo("textures/environment/end_sky.png");
    public List a = new ArrayList();
    public bdd k;
    public final bim l;
    private List m = new ArrayList();
    private bfa[] n;
    private bfa[] o;
    private int p;
    private int q;
    private int r;
    private int s;
    public atv t;
    public bfr u;
    private IntBuffer v;
    private boolean w;
    private int x;
    private int y;
    private int z;
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    public Map H = new HashMap();
    private ms[] I;
    private int J = -1;
    private int K = 2;
    private int L;
    private int M;
    private int N;
    IntBuffer b = atu.f((int)64);
    private int O;
    private int P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private List V = new ArrayList();
    private bfo[] W = new bfo[]{new bfo(), new bfo(), new bfo(), new bfo()};
    double c = -9999.0;
    double d = -9999.0;
    double e = -9999.0;
    int f;

    public bfl(atv par1Minecraft) {
        int k;
        int j2;
        this.t = par1Minecraft;
        this.l = par1Minecraft.J();
        int b0 = 34;
        int b1 = 32;
        this.s = atu.a((int)(b0 * b0 * b1 * 3));
        this.w = auk.a();
        if (this.w) {
            this.b.clear();
            this.v = atu.f((int)(b0 * b0 * b1));
            this.v.clear();
            this.v.position(0);
            this.v.limit(b0 * b0 * b1);
            ARBOcclusionQuery.glGenQueriesARB((IntBuffer)this.v);
        }
        this.y = atu.a((int)3);
        GL11.glPushMatrix();
        GL11.glNewList((int)this.y, (int)4864);
        this.g();
        GL11.glEndList();
        GL11.glPopMatrix();
        bfq tessellator = bfq.a;
        this.z = this.y + 1;
        GL11.glNewList((int)this.z, (int)4864);
        int b2 = 64;
        int i2 = 256 / b2 + 2;
        float f2 = 16.0f;
        for (j2 = -b2 * i2; j2 <= b2 * i2; j2 += b2) {
            for (k = -b2 * i2; k <= b2 * i2; k += b2) {
                tessellator.b();
                tessellator.a((double)(j2 + 0), (double)f2, (double)(k + 0));
                tessellator.a((double)(j2 + b2), (double)f2, (double)(k + 0));
                tessellator.a((double)(j2 + b2), (double)f2, (double)(k + b2));
                tessellator.a((double)(j2 + 0), (double)f2, (double)(k + b2));
                tessellator.a();
            }
        }
        GL11.glEndList();
        this.A = this.y + 2;
        GL11.glNewList((int)this.A, (int)4864);
        f2 = -16.0f;
        tessellator.b();
        for (j2 = -b2 * i2; j2 <= b2 * i2; j2 += b2) {
            for (k = -b2 * i2; k <= b2 * i2; k += b2) {
                tessellator.a((double)(j2 + b2), (double)f2, (double)(k + 0));
                tessellator.a((double)(j2 + 0), (double)f2, (double)(k + 0));
                tessellator.a((double)(j2 + 0), (double)f2, (double)(k + b2));
                tessellator.a((double)(j2 + b2), (double)f2, (double)(k + b2));
            }
        }
        tessellator.a();
        GL11.glEndList();
    }

    private void g() {
        Random random = new Random(10842L);
        bfq tessellator = bfq.a;
        tessellator.b();
        for (int i2 = 0; i2 < 1500; ++i2) {
            double d0 = random.nextFloat() * 2.0f - 1.0f;
            double d1 = random.nextFloat() * 2.0f - 1.0f;
            double d2 = random.nextFloat() * 2.0f - 1.0f;
            double d3 = 0.15f + random.nextFloat() * 0.1f;
            double d4 = d0 * d0 + d1 * d1 + d2 * d2;
            if (!(d4 < 1.0) || !(d4 > 0.01)) continue;
            d4 = 1.0 / Math.sqrt(d4);
            double d5 = (d0 *= d4) * 100.0;
            double d6 = (d1 *= d4) * 100.0;
            double d7 = (d2 *= d4) * 100.0;
            double d8 = Math.atan2(d0, d2);
            double d9 = Math.sin(d8);
            double d10 = Math.cos(d8);
            double d11 = Math.atan2(Math.sqrt(d0 * d0 + d2 * d2), d1);
            double d12 = Math.sin(d11);
            double d13 = Math.cos(d11);
            double d14 = random.nextDouble() * Math.PI * 2.0;
            double d15 = Math.sin(d14);
            double d16 = Math.cos(d14);
            for (int j2 = 0; j2 < 4; ++j2) {
                double d17 = 0.0;
                double d18 = (double)((j2 & 2) - 1) * d3;
                double d19 = (double)((j2 + 1 & 2) - 1) * d3;
                double d20 = d18 * d16 - d19 * d15;
                double d21 = d19 * d16 + d18 * d15;
                double d22 = d20 * d12 + d17 * d13;
                double d23 = d17 * d12 - d20 * d13;
                double d24 = d23 * d9 - d21 * d10;
                double d25 = d21 * d9 + d23 * d10;
                tessellator.a(d5 + d24, d6 + d22, d7 + d25);
            }
        }
        tessellator.a();
    }

    public void a(bdd par1WorldClient) {
        if (this.k != null) {
            this.k.b((acb)this);
        }
        this.c = -9999.0;
        this.d = -9999.0;
        this.e = -9999.0;
        bgl.a.a((abw)par1WorldClient);
        this.k = par1WorldClient;
        this.u = new bfr((acf)par1WorldClient);
        if (par1WorldClient != null) {
            par1WorldClient.a((acb)this);
            this.a();
        }
    }

    public void a() {
        if (this.k != null) {
            of entitylivingbase;
            int l2;
            int i2;
            aqz.P.a(this.t.u.j);
            this.J = this.t.u.e;
            if (this.o != null) {
                for (i2 = 0; i2 < this.o.length; ++i2) {
                    this.o[i2].c();
                }
            }
            if ((i2 = 64 << 3 - this.J) > 400) {
                i2 = 400;
            }
            this.p = i2 / 16 + 1;
            this.q = 16;
            this.r = i2 / 16 + 1;
            this.o = new bfa[this.p * this.q * this.r];
            this.n = new bfa[this.p * this.q * this.r];
            int j2 = 0;
            int k = 0;
            this.B = 0;
            this.C = 0;
            this.D = 0;
            this.E = this.p;
            this.F = this.q;
            this.G = this.r;
            for (l2 = 0; l2 < this.m.size(); ++l2) {
                ((bfa)this.m.get((int)l2)).q = false;
            }
            this.m.clear();
            this.a.clear();
            for (l2 = 0; l2 < this.p; ++l2) {
                for (int i1 = 0; i1 < this.q; ++i1) {
                    for (int j1 = 0; j1 < this.r; ++j1) {
                        this.o[(j1 * this.q + i1) * this.p + l2] = new bfa((abw)this.k, this.a, l2 * 16, i1 * 16, j1 * 16, this.s + j2);
                        if (this.w) {
                            this.o[(j1 * this.q + i1) * this.p + l2].v = this.v.get(k);
                        }
                        this.o[(j1 * this.q + i1) * this.p + l2].u = false;
                        this.o[(j1 * this.q + i1) * this.p + l2].t = true;
                        this.o[(j1 * this.q + i1) * this.p + l2].l = true;
                        this.o[(j1 * this.q + i1) * this.p + l2].s = k++;
                        this.o[(j1 * this.q + i1) * this.p + l2].f();
                        this.n[(j1 * this.q + i1) * this.p + l2] = this.o[(j1 * this.q + i1) * this.p + l2];
                        this.m.add(this.o[(j1 * this.q + i1) * this.p + l2]);
                        j2 += 3;
                    }
                }
            }
            if (this.k != null && (entitylivingbase = this.t.i) != null) {
                this.c(ls.c(entitylivingbase.u), ls.c(entitylivingbase.v), ls.c(entitylivingbase.w));
                Arrays.sort(this.n, new bfc((nn)entitylivingbase));
            }
            this.K = 2;
        }
    }

    public void a(atc par1Vec3, bft par2ICamera, float par3) {
        int pass = MinecraftForgeClient.getRenderPass();
        if (this.K > 0) {
            if (pass > 0) {
                return;
            }
            --this.K;
        } else {
            nn entity;
            int i2;
            this.k.C.a("prepare");
            bjd.a.a((abw)this.k, this.t.J(), this.t.l, this.t.i, par3);
            bgl.a.a((abw)this.k, this.t.J(), this.t.l, this.t.i, this.t.j, this.t.u, par3);
            if (pass == 0) {
                this.L = 0;
                this.M = 0;
                this.N = 0;
                of entitylivingbase = this.t.i;
                bgl.b = entitylivingbase.U + (entitylivingbase.u - entitylivingbase.U) * (double)par3;
                bgl.c = entitylivingbase.V + (entitylivingbase.v - entitylivingbase.V) * (double)par3;
                bgl.d = entitylivingbase.W + (entitylivingbase.w - entitylivingbase.W) * (double)par3;
                bjd.b = entitylivingbase.U + (entitylivingbase.u - entitylivingbase.U) * (double)par3;
                bjd.c = entitylivingbase.V + (entitylivingbase.v - entitylivingbase.V) * (double)par3;
                bjd.d = entitylivingbase.W + (entitylivingbase.w - entitylivingbase.W) * (double)par3;
            }
            this.t.p.b((double)par3);
            this.k.C.c("global");
            List list = this.k.D();
            if (pass == 0) {
                this.L = list.size();
            }
            for (i2 = 0; i2 < this.k.i.size(); ++i2) {
                entity = (nn)this.k.i.get(i2);
                if (!entity.shouldRenderInPass(pass)) continue;
                ++this.M;
                if (!entity.a(par1Vec3)) continue;
                bgl.a.a(entity, par3);
            }
            this.k.C.c("entities");
            for (i2 = 0; i2 < list.size(); ++i2) {
                og entityliving;
                boolean flag;
                entity = (nn)list.get(i2);
                if (!entity.shouldRenderInPass(pass)) continue;
                boolean bl2 = flag = entity.a(par1Vec3) && (entity.am || par2ICamera.a(entity.E) || entity.n == this.t.h);
                if (!flag && entity instanceof og && (entityliving = (og)entity).bH() && entityliving.bI() != null) {
                    nn entity1 = entityliving.bI();
                    flag = par2ICamera.a(entity1.E);
                }
                if (!flag || entity == this.t.i && this.t.u.aa == 0 && !this.t.i.bh() || !this.k.f(ls.c(entity.u), 0, ls.c(entity.w))) continue;
                ++this.M;
                bgl.a.a(entity, par3);
            }
            this.k.C.c("tileentities");
            att.b();
            for (i2 = 0; i2 < this.a.size(); ++i2) {
                asp tile = (asp)this.a.get(i2);
                if (!tile.shouldRenderInPass(pass) || !par2ICamera.a(tile.getRenderBoundingBox())) continue;
                bjd.a.a(tile, par3);
            }
            this.t.p.a((double)par3);
            this.k.C.b();
        }
    }

    public String c() {
        return "C: " + this.R + "/" + this.O + ". F: " + this.P + ", O: " + this.Q + ", E: " + this.S;
    }

    public String d() {
        return "E: " + this.M + "/" + this.L + ". B: " + this.N + ", I: " + (this.L - this.N - this.M);
    }

    private void c(int par1, int par2, int par3) {
        par1 -= 8;
        par2 -= 8;
        par3 -= 8;
        this.B = Integer.MAX_VALUE;
        this.C = Integer.MAX_VALUE;
        this.D = Integer.MAX_VALUE;
        this.E = Integer.MIN_VALUE;
        this.F = Integer.MIN_VALUE;
        this.G = Integer.MIN_VALUE;
        int l2 = this.p * 16;
        int i1 = l2 / 2;
        for (int j1 = 0; j1 < this.p; ++j1) {
            int k1 = j1 * 16;
            int l1 = k1 + i1 - par1;
            if (l1 < 0) {
                l1 -= l2 - 1;
            }
            if ((k1 -= (l1 /= l2) * l2) < this.B) {
                this.B = k1;
            }
            if (k1 > this.E) {
                this.E = k1;
            }
            for (int i2 = 0; i2 < this.r; ++i2) {
                int j2 = i2 * 16;
                int k2 = j2 + i1 - par3;
                if (k2 < 0) {
                    k2 -= l2 - 1;
                }
                if ((j2 -= (k2 /= l2) * l2) < this.D) {
                    this.D = j2;
                }
                if (j2 > this.G) {
                    this.G = j2;
                }
                for (int l22 = 0; l22 < this.q; ++l22) {
                    int i3 = l22 * 16;
                    if (i3 < this.C) {
                        this.C = i3;
                    }
                    if (i3 > this.F) {
                        this.F = i3;
                    }
                    bfa worldrenderer = this.o[(i2 * this.q + l22) * this.p + j1];
                    boolean flag = worldrenderer.q;
                    worldrenderer.a(k1, i3, j2);
                    if (flag || !worldrenderer.q) continue;
                    this.m.add(worldrenderer);
                }
            }
        }
    }

    public int a(of par1EntityLivingBase, int par2, double par3) {
        int k;
        this.k.C.a("sortchunks");
        for (int j2 = 0; j2 < 10; ++j2) {
            this.U = (this.U + 1) % this.o.length;
            bfa worldrenderer = this.o[this.U];
            if (!worldrenderer.q || this.m.contains(worldrenderer)) continue;
            this.m.add(worldrenderer);
        }
        if (this.t.u.e != this.J) {
            this.a();
        }
        if (par2 == 0) {
            this.O = 0;
            this.T = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 0;
            this.S = 0;
        }
        double d1 = par1EntityLivingBase.U + (par1EntityLivingBase.u - par1EntityLivingBase.U) * par3;
        double d2 = par1EntityLivingBase.V + (par1EntityLivingBase.v - par1EntityLivingBase.V) * par3;
        double d3 = par1EntityLivingBase.W + (par1EntityLivingBase.w - par1EntityLivingBase.W) * par3;
        double d4 = par1EntityLivingBase.u - this.c;
        double d5 = par1EntityLivingBase.v - this.d;
        double d6 = par1EntityLivingBase.w - this.e;
        if (d4 * d4 + d5 * d5 + d6 * d6 > 16.0) {
            this.c = par1EntityLivingBase.u;
            this.d = par1EntityLivingBase.v;
            this.e = par1EntityLivingBase.w;
            this.c(ls.c(par1EntityLivingBase.u), ls.c(par1EntityLivingBase.v), ls.c(par1EntityLivingBase.w));
            Arrays.sort(this.n, new bfc((nn)par1EntityLivingBase));
        }
        att.a();
        int b0 = 0;
        if (this.w && this.t.u.h && !this.t.u.g && par2 == 0) {
            int b1 = 0;
            int l2 = 16;
            this.a(b1, l2);
            for (int i1 = b1; i1 < l2; ++i1) {
                this.n[i1].t = true;
            }
            this.k.C.c("render");
            k = b0 + this.a(b1, l2, par2, par3);
            do {
                this.k.C.c("occ");
                int j1 = l2;
                if ((l2 *= 2) > this.n.length) {
                    l2 = this.n.length;
                }
                GL11.glDisable((int)3553);
                GL11.glDisable((int)2896);
                GL11.glDisable((int)3008);
                GL11.glDisable((int)2912);
                GL11.glColorMask((boolean)false, (boolean)false, (boolean)false, (boolean)false);
                GL11.glDepthMask((boolean)false);
                this.k.C.a("check");
                this.a(j1, l2);
                this.k.C.b();
                GL11.glPushMatrix();
                float f2 = 0.0f;
                float f1 = 0.0f;
                float f22 = 0.0f;
                for (int k1 = j1; k1 < l2; ++k1) {
                    float f3;
                    int l1;
                    if (this.n[k1].e()) {
                        this.n[k1].l = false;
                        continue;
                    }
                    if (!this.n[k1].l) {
                        this.n[k1].t = true;
                    }
                    if (!this.n[k1].l || this.n[k1].u || this.x % (l1 = (int)(1.0f + (f3 = ls.c(this.n[k1].a(par1EntityLivingBase))) / 128.0f)) != k1 % l1) continue;
                    bfa worldrenderer1 = this.n[k1];
                    float f4 = (float)((double)worldrenderer1.f - d1);
                    float f5 = (float)((double)worldrenderer1.g - d2);
                    float f6 = (float)((double)worldrenderer1.h - d3);
                    float f7 = f4 - f2;
                    float f8 = f5 - f1;
                    float f9 = f6 - f22;
                    if (f7 != 0.0f || f8 != 0.0f || f9 != 0.0f) {
                        GL11.glTranslatef((float)f7, (float)f8, (float)f9);
                        f2 += f7;
                        f1 += f8;
                        f22 += f9;
                    }
                    this.k.C.a("bb");
                    ARBOcclusionQuery.glBeginQueryARB((int)35092, (int)this.n[k1].v);
                    this.n[k1].d();
                    ARBOcclusionQuery.glEndQueryARB((int)35092);
                    this.k.C.b();
                    this.n[k1].u = true;
                }
                GL11.glPopMatrix();
                if (this.t.u.g) {
                    if (bfe.b == 0) {
                        GL11.glColorMask((boolean)false, (boolean)true, (boolean)true, (boolean)true);
                    } else {
                        GL11.glColorMask((boolean)true, (boolean)false, (boolean)false, (boolean)true);
                    }
                } else {
                    GL11.glColorMask((boolean)true, (boolean)true, (boolean)true, (boolean)true);
                }
                GL11.glDepthMask((boolean)true);
                GL11.glEnable((int)3553);
                GL11.glEnable((int)3008);
                GL11.glEnable((int)2912);
                this.k.C.c("render");
                k += this.a(j1, l2, par2, par3);
            } while (l2 < this.n.length);
        } else {
            this.k.C.c("render");
            k = b0 + this.a(0, this.n.length, par2, par3);
        }
        this.k.C.b();
        return k;
    }

    private void a(int par1, int par2) {
        for (int k = par1; k < par2; ++k) {
            if (!this.n[k].u) continue;
            this.b.clear();
            ARBOcclusionQuery.glGetQueryObjectuARB((int)this.n[k].v, (int)34919, (IntBuffer)this.b);
            if (this.b.get(0) == 0) continue;
            this.n[k].u = false;
            this.b.clear();
            ARBOcclusionQuery.glGetQueryObjectuARB((int)this.n[k].v, (int)34918, (IntBuffer)this.b);
            this.n[k].t = this.b.get(0) != 0;
        }
    }

    private int a(int par1, int par2, int par3, double par4) {
        int l1;
        this.V.clear();
        int l2 = 0;
        for (int i1 = par1; i1 < par2; ++i1) {
            int j1;
            if (par3 == 0) {
                ++this.O;
                if (this.n[i1].m[par3]) {
                    ++this.S;
                } else if (!this.n[i1].l) {
                    ++this.P;
                } else if (this.w && !this.n[i1].t) {
                    ++this.Q;
                } else {
                    ++this.R;
                }
            }
            if (this.n[i1].m[par3] || !this.n[i1].l || this.w && !this.n[i1].t || (j1 = this.n[i1].a(par3)) < 0) continue;
            this.V.add(this.n[i1]);
            ++l2;
        }
        of entitylivingbase = this.t.i;
        double d1 = entitylivingbase.U + (entitylivingbase.u - entitylivingbase.U) * par4;
        double d2 = entitylivingbase.V + (entitylivingbase.v - entitylivingbase.V) * par4;
        double d3 = entitylivingbase.W + (entitylivingbase.w - entitylivingbase.W) * par4;
        int k1 = 0;
        for (l1 = 0; l1 < this.W.length; ++l1) {
            this.W[l1].b();
        }
        for (l1 = 0; l1 < this.V.size(); ++l1) {
            bfa worldrenderer = (bfa)this.V.get(l1);
            int i2 = -1;
            for (int j2 = 0; j2 < k1; ++j2) {
                if (!this.W[j2].a(worldrenderer.f, worldrenderer.g, worldrenderer.h)) continue;
                i2 = j2;
            }
            if (i2 < 0) {
                i2 = k1++;
                this.W[i2].a(worldrenderer.f, worldrenderer.g, worldrenderer.h, d1, d2, d3);
            }
            this.W[i2].a(worldrenderer.a(par3));
        }
        this.a(par3, par4);
        return l2;
    }

    public void a(int par1, double par2) {
        this.t.p.b(par2);
        for (int j2 = 0; j2 < this.W.length; ++j2) {
            this.W[j2].a();
        }
        this.t.p.a(par2);
    }

    public void e() {
        ++this.x;
        if (this.x % 20 == 0) {
            Iterator iterator = this.H.values().iterator();
            while (iterator.hasNext()) {
                ji destroyblockprogress = (ji)iterator.next();
                int i2 = destroyblockprogress.f();
                if (this.x - i2 <= 400) continue;
                iterator.remove();
            }
        }
    }

    public void a(float par1) {
        IRenderHandler skyProvider = null;
        skyProvider = this.t.f.t.getSkyRenderer();
        if (skyProvider != null) {
            skyProvider.render(par1, this.k, this.t);
            return;
        }
        if (this.t.f.t.i == 1) {
            GL11.glDisable((int)2912);
            GL11.glDisable((int)3008);
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)771);
            att.a();
            GL11.glDepthMask((boolean)false);
            this.l.a(j);
            bfq tessellator = bfq.a;
            for (int i2 = 0; i2 < 6; ++i2) {
                GL11.glPushMatrix();
                if (i2 == 1) {
                    GL11.glRotatef((float)90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                }
                if (i2 == 2) {
                    GL11.glRotatef((float)-90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                }
                if (i2 == 3) {
                    GL11.glRotatef((float)180.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                }
                if (i2 == 4) {
                    GL11.glRotatef((float)90.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                }
                if (i2 == 5) {
                    GL11.glRotatef((float)-90.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                }
                tessellator.b();
                tessellator.d(0x282828);
                tessellator.a(-100.0, -100.0, -100.0, 0.0, 0.0);
                tessellator.a(-100.0, -100.0, 100.0, 0.0, 16.0);
                tessellator.a(100.0, -100.0, 100.0, 16.0, 16.0);
                tessellator.a(100.0, -100.0, -100.0, 16.0, 0.0);
                tessellator.a();
                GL11.glPopMatrix();
            }
            GL11.glDepthMask((boolean)true);
            GL11.glEnable((int)3553);
            GL11.glEnable((int)3008);
        } else if (this.t.f.t.d()) {
            float f10;
            float f9;
            float f8;
            float f7;
            float f4;
            GL11.glDisable((int)3553);
            atc vec3 = this.k.a((nn)this.t.i, par1);
            float f1 = (float)vec3.c;
            float f2 = (float)vec3.d;
            float f3 = (float)vec3.e;
            if (this.t.u.g) {
                float f5 = (f1 * 30.0f + f2 * 59.0f + f3 * 11.0f) / 100.0f;
                float f6 = (f1 * 30.0f + f2 * 70.0f) / 100.0f;
                f4 = (f1 * 30.0f + f3 * 70.0f) / 100.0f;
                f1 = f5;
                f2 = f6;
                f3 = f4;
            }
            GL11.glColor3f((float)f1, (float)f2, (float)f3);
            bfq tessellator1 = bfq.a;
            GL11.glDepthMask((boolean)false);
            GL11.glEnable((int)2912);
            GL11.glColor3f((float)f1, (float)f2, (float)f3);
            GL11.glCallList((int)this.z);
            GL11.glDisable((int)2912);
            GL11.glDisable((int)3008);
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)771);
            att.a();
            float[] afloat = this.k.t.a(this.k.c(par1), par1);
            if (afloat != null) {
                float f11;
                GL11.glDisable((int)3553);
                GL11.glShadeModel((int)7425);
                GL11.glPushMatrix();
                GL11.glRotatef((float)90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)(ls.a(this.k.d(par1)) < 0.0f ? 180.0f : 0.0f), (float)0.0f, (float)0.0f, (float)1.0f);
                GL11.glRotatef((float)90.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                f4 = afloat[0];
                f7 = afloat[1];
                f8 = afloat[2];
                if (this.t.u.g) {
                    f9 = (f4 * 30.0f + f7 * 59.0f + f8 * 11.0f) / 100.0f;
                    f10 = (f4 * 30.0f + f7 * 70.0f) / 100.0f;
                    f11 = (f4 * 30.0f + f8 * 70.0f) / 100.0f;
                    f4 = f9;
                    f7 = f10;
                    f8 = f11;
                }
                tessellator1.b(6);
                tessellator1.a(f4, f7, f8, afloat[3]);
                tessellator1.a(0.0, 100.0, 0.0);
                int b0 = 16;
                tessellator1.a(afloat[0], afloat[1], afloat[2], 0.0f);
                for (int j2 = 0; j2 <= b0; ++j2) {
                    f11 = (float)j2 * (float)Math.PI * 2.0f / (float)b0;
                    float f12 = ls.a(f11);
                    float f13 = ls.b(f11);
                    tessellator1.a((double)(f12 * 120.0f), (double)(f13 * 120.0f), (double)(-f13 * 40.0f * afloat[3]));
                }
                tessellator1.a();
                GL11.glPopMatrix();
                GL11.glShadeModel((int)7424);
            }
            GL11.glEnable((int)3553);
            GL11.glBlendFunc((int)770, (int)1);
            GL11.glPushMatrix();
            f4 = 1.0f - this.k.i(par1);
            f7 = 0.0f;
            f8 = 0.0f;
            f9 = 0.0f;
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)f4);
            GL11.glTranslatef((float)f7, (float)f8, (float)f9);
            GL11.glRotatef((float)-90.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glRotatef((float)(this.k.c(par1) * 360.0f), (float)1.0f, (float)0.0f, (float)0.0f);
            f10 = 30.0f;
            this.l.a(h);
            tessellator1.b();
            tessellator1.a(-f10, 100.0, -f10, 0.0, 0.0);
            tessellator1.a(f10, 100.0, -f10, 1.0, 0.0);
            tessellator1.a(f10, 100.0, f10, 1.0, 1.0);
            tessellator1.a(-f10, 100.0, f10, 0.0, 1.0);
            tessellator1.a();
            f10 = 20.0f;
            this.l.a(g);
            int k = this.k.w();
            int l2 = k % 4;
            int i1 = k / 4 % 2;
            float f14 = (float)(l2 + 0) / 4.0f;
            float f15 = (float)(i1 + 0) / 2.0f;
            float f16 = (float)(l2 + 1) / 4.0f;
            float f17 = (float)(i1 + 1) / 2.0f;
            tessellator1.b();
            tessellator1.a(-f10, -100.0, f10, f16, f17);
            tessellator1.a(f10, -100.0, f10, f14, f17);
            tessellator1.a(f10, -100.0, -f10, f14, f15);
            tessellator1.a(-f10, -100.0, -f10, f16, f15);
            tessellator1.a();
            GL11.glDisable((int)3553);
            float f18 = this.k.g(par1) * f4;
            if (f18 > 0.0f) {
                GL11.glColor4f((float)f18, (float)f18, (float)f18, (float)f18);
                GL11.glCallList((int)this.y);
            }
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glDisable((int)3042);
            GL11.glEnable((int)3008);
            GL11.glEnable((int)2912);
            GL11.glPopMatrix();
            GL11.glDisable((int)3553);
            GL11.glColor3f((float)0.0f, (float)0.0f, (float)0.0f);
            double d0 = this.t.h.l((float)par1).d - this.k.U();
            if (d0 < 0.0) {
                GL11.glPushMatrix();
                GL11.glTranslatef((float)0.0f, (float)12.0f, (float)0.0f);
                GL11.glCallList((int)this.A);
                GL11.glPopMatrix();
                f8 = 1.0f;
                f9 = -((float)(d0 + 65.0));
                f10 = -f8;
                tessellator1.b();
                tessellator1.a(0, 255);
                tessellator1.a((double)(-f8), (double)f9, (double)f8);
                tessellator1.a((double)f8, (double)f9, (double)f8);
                tessellator1.a((double)f8, (double)f10, (double)f8);
                tessellator1.a((double)(-f8), (double)f10, (double)f8);
                tessellator1.a((double)(-f8), (double)f10, (double)(-f8));
                tessellator1.a((double)f8, (double)f10, (double)(-f8));
                tessellator1.a((double)f8, (double)f9, (double)(-f8));
                tessellator1.a((double)(-f8), (double)f9, (double)(-f8));
                tessellator1.a((double)f8, (double)f10, (double)(-f8));
                tessellator1.a((double)f8, (double)f10, (double)f8);
                tessellator1.a((double)f8, (double)f9, (double)f8);
                tessellator1.a((double)f8, (double)f9, (double)(-f8));
                tessellator1.a((double)(-f8), (double)f9, (double)(-f8));
                tessellator1.a((double)(-f8), (double)f9, (double)f8);
                tessellator1.a((double)(-f8), (double)f10, (double)f8);
                tessellator1.a((double)(-f8), (double)f10, (double)(-f8));
                tessellator1.a((double)(-f8), (double)f10, (double)(-f8));
                tessellator1.a((double)(-f8), (double)f10, (double)f8);
                tessellator1.a((double)f8, (double)f10, (double)f8);
                tessellator1.a((double)f8, (double)f10, (double)(-f8));
                tessellator1.a();
            }
            if (this.k.t.g()) {
                GL11.glColor3f((float)(f1 * 0.2f + 0.04f), (float)(f2 * 0.2f + 0.04f), (float)(f3 * 0.6f + 0.1f));
            } else {
                GL11.glColor3f((float)f1, (float)f2, (float)f3);
            }
            GL11.glPushMatrix();
            GL11.glTranslatef((float)0.0f, (float)(-((float)(d0 - 16.0))), (float)0.0f);
            GL11.glCallList((int)this.A);
            GL11.glPopMatrix();
            GL11.glEnable((int)3553);
            GL11.glDepthMask((boolean)true);
        }
    }

    public void b(float par1) {
        IRenderHandler renderer = null;
        renderer = this.k.t.getCloudRenderer();
        if (renderer != null) {
            renderer.render(par1, this.k, this.t);
            return;
        }
        if (this.t.f.t.d()) {
            if (this.t.u.j) {
                this.c(par1);
            } else {
                float f5;
                GL11.glDisable((int)2884);
                float f1 = (float)(this.t.i.V + (this.t.i.v - this.t.i.V) * (double)par1);
                int b0 = 32;
                int i2 = 256 / b0;
                bfq tessellator = bfq.a;
                this.l.a(i);
                GL11.glEnable((int)3042);
                GL11.glBlendFunc((int)770, (int)771);
                atc vec3 = this.k.e(par1);
                float f2 = (float)vec3.c;
                float f3 = (float)vec3.d;
                float f4 = (float)vec3.e;
                if (this.t.u.g) {
                    f5 = (f2 * 30.0f + f3 * 59.0f + f4 * 11.0f) / 100.0f;
                    float f6 = (f2 * 30.0f + f3 * 70.0f) / 100.0f;
                    float f7 = (f2 * 30.0f + f4 * 70.0f) / 100.0f;
                    f2 = f5;
                    f3 = f6;
                    f4 = f7;
                }
                f5 = 4.8828125E-4f;
                double d0 = (float)this.x + par1;
                double d1 = this.t.i.r + (this.t.i.u - this.t.i.r) * (double)par1 + d0 * (double)0.03f;
                double d2 = this.t.i.t + (this.t.i.w - this.t.i.t) * (double)par1;
                int j2 = ls.c(d1 / 2048.0);
                int k = ls.c(d2 / 2048.0);
                float f8 = this.k.t.f() - f1 + 0.33f;
                float f9 = (float)((d1 -= (double)(j2 * 2048)) * (double)f5);
                float f10 = (float)((d2 -= (double)(k * 2048)) * (double)f5);
                tessellator.b();
                tessellator.a(f2, f3, f4, 0.8f);
                for (int l2 = -b0 * i2; l2 < b0 * i2; l2 += b0) {
                    for (int i1 = -b0 * i2; i1 < b0 * i2; i1 += b0) {
                        tessellator.a(l2 + 0, f8, i1 + b0, (float)(l2 + 0) * f5 + f9, (float)(i1 + b0) * f5 + f10);
                        tessellator.a(l2 + b0, f8, i1 + b0, (float)(l2 + b0) * f5 + f9, (float)(i1 + b0) * f5 + f10);
                        tessellator.a(l2 + b0, f8, i1 + 0, (float)(l2 + b0) * f5 + f9, (float)(i1 + 0) * f5 + f10);
                        tessellator.a(l2 + 0, f8, i1 + 0, (float)(l2 + 0) * f5 + f9, (float)(i1 + 0) * f5 + f10);
                    }
                }
                tessellator.a();
                GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                GL11.glDisable((int)3042);
                GL11.glEnable((int)2884);
            }
        }
    }

    public boolean a(double par1, double par3, double par5, float par7) {
        return false;
    }

    public void c(float par1) {
        float f9;
        float f10;
        float f8;
        GL11.glDisable((int)2884);
        float f1 = (float)(this.t.i.V + (this.t.i.v - this.t.i.V) * (double)par1);
        bfq tessellator = bfq.a;
        float f2 = 12.0f;
        float f3 = 4.0f;
        double d0 = (float)this.x + par1;
        double d1 = (this.t.i.r + (this.t.i.u - this.t.i.r) * (double)par1 + d0 * (double)0.03f) / (double)f2;
        double d2 = (this.t.i.t + (this.t.i.w - this.t.i.t) * (double)par1) / (double)f2 + (double)0.33f;
        float f4 = this.k.t.f() - f1 + 0.33f;
        int i2 = ls.c(d1 / 2048.0);
        int j2 = ls.c(d2 / 2048.0);
        d1 -= (double)(i2 * 2048);
        d2 -= (double)(j2 * 2048);
        this.l.a(i);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        atc vec3 = this.k.e(par1);
        float f5 = (float)vec3.c;
        float f6 = (float)vec3.d;
        float f7 = (float)vec3.e;
        if (this.t.u.g) {
            f8 = (f5 * 30.0f + f6 * 59.0f + f7 * 11.0f) / 100.0f;
            f10 = (f5 * 30.0f + f6 * 70.0f) / 100.0f;
            f9 = (f5 * 30.0f + f7 * 70.0f) / 100.0f;
            f5 = f8;
            f6 = f10;
            f7 = f9;
        }
        f8 = (float)(d1 * 0.0);
        f10 = (float)(d2 * 0.0);
        f9 = 0.00390625f;
        f8 = (float)ls.c(d1) * f9;
        f10 = (float)ls.c(d2) * f9;
        float f11 = (float)(d1 - (double)ls.c(d1));
        float f12 = (float)(d2 - (double)ls.c(d2));
        int b0 = 8;
        int b1 = 4;
        float f13 = 9.765625E-4f;
        GL11.glScalef((float)f2, (float)1.0f, (float)f2);
        for (int k = 0; k < 2; ++k) {
            if (k == 0) {
                GL11.glColorMask((boolean)false, (boolean)false, (boolean)false, (boolean)false);
            } else if (this.t.u.g) {
                if (bfe.b == 0) {
                    GL11.glColorMask((boolean)false, (boolean)true, (boolean)true, (boolean)true);
                } else {
                    GL11.glColorMask((boolean)true, (boolean)false, (boolean)false, (boolean)true);
                }
            } else {
                GL11.glColorMask((boolean)true, (boolean)true, (boolean)true, (boolean)true);
            }
            for (int l2 = -b1 + 1; l2 <= b1; ++l2) {
                for (int i1 = -b1 + 1; i1 <= b1; ++i1) {
                    int j1;
                    tessellator.b();
                    float f14 = l2 * b0;
                    float f15 = i1 * b0;
                    float f16 = f14 - f11;
                    float f17 = f15 - f12;
                    if (f4 > -f3 - 1.0f) {
                        tessellator.a(f5 * 0.7f, f6 * 0.7f, f7 * 0.7f, 0.8f);
                        tessellator.b(0.0f, -1.0f, 0.0f);
                        tessellator.a(f16 + 0.0f, f4 + 0.0f, f17 + (float)b0, (f14 + 0.0f) * f9 + f8, (f15 + (float)b0) * f9 + f10);
                        tessellator.a(f16 + (float)b0, f4 + 0.0f, f17 + (float)b0, (f14 + (float)b0) * f9 + f8, (f15 + (float)b0) * f9 + f10);
                        tessellator.a(f16 + (float)b0, f4 + 0.0f, f17 + 0.0f, (f14 + (float)b0) * f9 + f8, (f15 + 0.0f) * f9 + f10);
                        tessellator.a(f16 + 0.0f, f4 + 0.0f, f17 + 0.0f, (f14 + 0.0f) * f9 + f8, (f15 + 0.0f) * f9 + f10);
                    }
                    if (f4 <= f3 + 1.0f) {
                        tessellator.a(f5, f6, f7, 0.8f);
                        tessellator.b(0.0f, 1.0f, 0.0f);
                        tessellator.a(f16 + 0.0f, f4 + f3 - f13, f17 + (float)b0, (f14 + 0.0f) * f9 + f8, (f15 + (float)b0) * f9 + f10);
                        tessellator.a(f16 + (float)b0, f4 + f3 - f13, f17 + (float)b0, (f14 + (float)b0) * f9 + f8, (f15 + (float)b0) * f9 + f10);
                        tessellator.a(f16 + (float)b0, f4 + f3 - f13, f17 + 0.0f, (f14 + (float)b0) * f9 + f8, (f15 + 0.0f) * f9 + f10);
                        tessellator.a(f16 + 0.0f, f4 + f3 - f13, f17 + 0.0f, (f14 + 0.0f) * f9 + f8, (f15 + 0.0f) * f9 + f10);
                    }
                    tessellator.a(f5 * 0.9f, f6 * 0.9f, f7 * 0.9f, 0.8f);
                    if (l2 > -1) {
                        tessellator.b(-1.0f, 0.0f, 0.0f);
                        for (j1 = 0; j1 < b0; ++j1) {
                            tessellator.a(f16 + (float)j1 + 0.0f, f4 + 0.0f, f17 + (float)b0, (f14 + (float)j1 + 0.5f) * f9 + f8, (f15 + (float)b0) * f9 + f10);
                            tessellator.a(f16 + (float)j1 + 0.0f, f4 + f3, f17 + (float)b0, (f14 + (float)j1 + 0.5f) * f9 + f8, (f15 + (float)b0) * f9 + f10);
                            tessellator.a(f16 + (float)j1 + 0.0f, f4 + f3, f17 + 0.0f, (f14 + (float)j1 + 0.5f) * f9 + f8, (f15 + 0.0f) * f9 + f10);
                            tessellator.a(f16 + (float)j1 + 0.0f, f4 + 0.0f, f17 + 0.0f, (f14 + (float)j1 + 0.5f) * f9 + f8, (f15 + 0.0f) * f9 + f10);
                        }
                    }
                    if (l2 <= 1) {
                        tessellator.b(1.0f, 0.0f, 0.0f);
                        for (j1 = 0; j1 < b0; ++j1) {
                            tessellator.a(f16 + (float)j1 + 1.0f - f13, f4 + 0.0f, f17 + (float)b0, (f14 + (float)j1 + 0.5f) * f9 + f8, (f15 + (float)b0) * f9 + f10);
                            tessellator.a(f16 + (float)j1 + 1.0f - f13, f4 + f3, f17 + (float)b0, (f14 + (float)j1 + 0.5f) * f9 + f8, (f15 + (float)b0) * f9 + f10);
                            tessellator.a(f16 + (float)j1 + 1.0f - f13, f4 + f3, f17 + 0.0f, (f14 + (float)j1 + 0.5f) * f9 + f8, (f15 + 0.0f) * f9 + f10);
                            tessellator.a(f16 + (float)j1 + 1.0f - f13, f4 + 0.0f, f17 + 0.0f, (f14 + (float)j1 + 0.5f) * f9 + f8, (f15 + 0.0f) * f9 + f10);
                        }
                    }
                    tessellator.a(f5 * 0.8f, f6 * 0.8f, f7 * 0.8f, 0.8f);
                    if (i1 > -1) {
                        tessellator.b(0.0f, 0.0f, -1.0f);
                        for (j1 = 0; j1 < b0; ++j1) {
                            tessellator.a(f16 + 0.0f, f4 + f3, f17 + (float)j1 + 0.0f, (f14 + 0.0f) * f9 + f8, (f15 + (float)j1 + 0.5f) * f9 + f10);
                            tessellator.a(f16 + (float)b0, f4 + f3, f17 + (float)j1 + 0.0f, (f14 + (float)b0) * f9 + f8, (f15 + (float)j1 + 0.5f) * f9 + f10);
                            tessellator.a(f16 + (float)b0, f4 + 0.0f, f17 + (float)j1 + 0.0f, (f14 + (float)b0) * f9 + f8, (f15 + (float)j1 + 0.5f) * f9 + f10);
                            tessellator.a(f16 + 0.0f, f4 + 0.0f, f17 + (float)j1 + 0.0f, (f14 + 0.0f) * f9 + f8, (f15 + (float)j1 + 0.5f) * f9 + f10);
                        }
                    }
                    if (i1 <= 1) {
                        tessellator.b(0.0f, 0.0f, 1.0f);
                        for (j1 = 0; j1 < b0; ++j1) {
                            tessellator.a(f16 + 0.0f, f4 + f3, f17 + (float)j1 + 1.0f - f13, (f14 + 0.0f) * f9 + f8, (f15 + (float)j1 + 0.5f) * f9 + f10);
                            tessellator.a(f16 + (float)b0, f4 + f3, f17 + (float)j1 + 1.0f - f13, (f14 + (float)b0) * f9 + f8, (f15 + (float)j1 + 0.5f) * f9 + f10);
                            tessellator.a(f16 + (float)b0, f4 + 0.0f, f17 + (float)j1 + 1.0f - f13, (f14 + (float)b0) * f9 + f8, (f15 + (float)j1 + 0.5f) * f9 + f10);
                            tessellator.a(f16 + 0.0f, f4 + 0.0f, f17 + (float)j1 + 1.0f - f13, (f14 + 0.0f) * f9 + f8, (f15 + (float)j1 + 0.5f) * f9 + f10);
                        }
                    }
                    tessellator.a();
                }
            }
        }
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glDisable((int)3042);
        GL11.glEnable((int)2884);
    }

    public boolean a(of par1EntityLivingBase, boolean par2) {
        int j1;
        int i1;
        int l2;
        bfa worldrenderer;
        int k;
        int b0 = 2;
        bfb rendersorter = new bfb(par1EntityLivingBase);
        bfa[] aworldrenderer = new bfa[b0];
        ArrayList<bfa> arraylist = null;
        int i2 = this.m.size();
        int j2 = 0;
        this.k.C.a("nearChunksSearch");
        block0: for (k = 0; k < i2; ++k) {
            worldrenderer = (bfa)this.m.get(k);
            if (worldrenderer == null) continue;
            if (!par2) {
                if (worldrenderer.a(par1EntityLivingBase) > 256.0f) {
                    for (l2 = 0; l2 < b0 && (aworldrenderer[l2] == null || rendersorter.a(aworldrenderer[l2], worldrenderer) <= 0); ++l2) {
                    }
                    if (--l2 <= 0) continue;
                    i1 = l2;
                    while (true) {
                        if (--i1 == 0) {
                            aworldrenderer[l2] = worldrenderer;
                            continue block0;
                        }
                        aworldrenderer[i1 - 1] = aworldrenderer[i1];
                    }
                }
            } else if (!worldrenderer.l) continue;
            if (arraylist == null) {
                arraylist = new ArrayList<bfa>();
            }
            ++j2;
            arraylist.add(worldrenderer);
            this.m.set(k, null);
        }
        this.k.C.b();
        this.k.C.a("sort");
        if (arraylist != null) {
            if (arraylist.size() > 1) {
                Collections.sort(arraylist, rendersorter);
            }
            for (k = arraylist.size() - 1; k >= 0; --k) {
                worldrenderer = (bfa)arraylist.get(k);
                worldrenderer.a();
                worldrenderer.q = false;
            }
        }
        this.k.C.b();
        k = 0;
        this.k.C.a("rebuild");
        for (j1 = b0 - 1; j1 >= 0; --j1) {
            bfa worldrenderer1 = aworldrenderer[j1];
            if (worldrenderer1 == null) continue;
            if (!worldrenderer1.l && j1 != b0 - 1) {
                aworldrenderer[j1] = null;
                aworldrenderer[0] = null;
                break;
            }
            aworldrenderer[j1].a();
            aworldrenderer[j1].q = false;
            ++k;
        }
        this.k.C.b();
        this.k.C.a("cleanup");
        l2 = 0;
        i1 = this.m.size();
        for (j1 = 0; j1 != i1; ++j1) {
            bfa worldrenderer2 = (bfa)this.m.get(j1);
            if (worldrenderer2 == null) continue;
            boolean flag1 = false;
            for (int k1 = 0; k1 < b0 && !flag1; ++k1) {
                if (worldrenderer2 != aworldrenderer[k1]) continue;
                flag1 = true;
            }
            if (flag1) continue;
            if (l2 != j1) {
                this.m.set(l2, worldrenderer2);
            }
            ++l2;
        }
        this.k.C.b();
        this.k.C.a("trim");
        while (true) {
            if (--j1 < l2) {
                this.k.C.b();
                return i2 == j2 + k;
            }
            this.m.remove(j1);
        }
    }

    public void a(bfq par1Tessellator, uf par2EntityPlayer, float par3) {
        this.drawBlockDamageTexture(par1Tessellator, par2EntityPlayer, par3);
    }

    public void drawBlockDamageTexture(bfq par1Tessellator, of par2EntityPlayer, float par3) {
        double d0 = par2EntityPlayer.U + (par2EntityPlayer.u - par2EntityPlayer.U) * (double)par3;
        double d1 = par2EntityPlayer.V + (par2EntityPlayer.v - par2EntityPlayer.V) * (double)par3;
        double d2 = par2EntityPlayer.W + (par2EntityPlayer.w - par2EntityPlayer.W) * (double)par3;
        if (!this.H.isEmpty()) {
            GL11.glBlendFunc((int)774, (int)768);
            this.l.a(bik.b);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)0.5f);
            GL11.glPushMatrix();
            GL11.glDisable((int)3008);
            GL11.glPolygonOffset((float)-3.0f, (float)-3.0f);
            GL11.glEnable((int)32823);
            GL11.glEnable((int)3008);
            par1Tessellator.b();
            par1Tessellator.b(-d0, -d1, -d2);
            par1Tessellator.c();
            Iterator iterator = this.H.values().iterator();
            while (iterator.hasNext()) {
                aqz block;
                double d5;
                double d4;
                ji destroyblockprogress = (ji)iterator.next();
                double d3 = (double)destroyblockprogress.b() - d0;
                if (d3 * d3 + (d4 = (double)destroyblockprogress.c() - d1) * d4 + (d5 = (double)destroyblockprogress.d() - d2) * d5 > 1024.0) {
                    iterator.remove();
                    continue;
                }
                int i2 = this.k.a(destroyblockprogress.b(), destroyblockprogress.c(), destroyblockprogress.d());
                aqz aqz2 = block = i2 > 0 ? aqz.s[i2] : null;
                if (block == null) {
                    block = aqz.y;
                }
                this.u.a(block, destroyblockprogress.b(), destroyblockprogress.c(), destroyblockprogress.d(), this.I[destroyblockprogress.e()]);
            }
            par1Tessellator.a();
            par1Tessellator.b(0.0, 0.0, 0.0);
            GL11.glDisable((int)3008);
            GL11.glPolygonOffset((float)0.0f, (float)0.0f);
            GL11.glDisable((int)32823);
            GL11.glEnable((int)3008);
            GL11.glDepthMask((boolean)true);
            GL11.glPopMatrix();
        }
    }

    public void a(uf par1EntityPlayer, ata par2MovingObjectPosition, int par3, float par4) {
        if (par3 == 0 && par2MovingObjectPosition.a == atb.a) {
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)771);
            GL11.glColor4f((float)0.0f, (float)0.0f, (float)0.0f, (float)0.4f);
            GL11.glLineWidth((float)2.0f);
            GL11.glDisable((int)3553);
            GL11.glDepthMask((boolean)false);
            float f1 = 0.002f;
            int j2 = this.k.a(par2MovingObjectPosition.b, par2MovingObjectPosition.c, par2MovingObjectPosition.d);
            if (j2 > 0) {
                aqz.s[j2].a((acf)this.k, par2MovingObjectPosition.b, par2MovingObjectPosition.c, par2MovingObjectPosition.d);
                double d0 = par1EntityPlayer.U + (par1EntityPlayer.u - par1EntityPlayer.U) * (double)par4;
                double d1 = par1EntityPlayer.V + (par1EntityPlayer.v - par1EntityPlayer.V) * (double)par4;
                double d2 = par1EntityPlayer.W + (par1EntityPlayer.w - par1EntityPlayer.W) * (double)par4;
                this.a(aqz.s[j2].c_((abw)this.k, par2MovingObjectPosition.b, par2MovingObjectPosition.c, par2MovingObjectPosition.d).b((double)f1, (double)f1, (double)f1).c(-d0, -d1, -d2));
            }
            GL11.glDepthMask((boolean)true);
            GL11.glEnable((int)3553);
            GL11.glDisable((int)3042);
        }
    }

    private void a(asx par1AxisAlignedBB) {
        bfq tessellator = bfq.a;
        tessellator.b(3);
        tessellator.a(par1AxisAlignedBB.a, par1AxisAlignedBB.b, par1AxisAlignedBB.c);
        tessellator.a(par1AxisAlignedBB.d, par1AxisAlignedBB.b, par1AxisAlignedBB.c);
        tessellator.a(par1AxisAlignedBB.d, par1AxisAlignedBB.b, par1AxisAlignedBB.f);
        tessellator.a(par1AxisAlignedBB.a, par1AxisAlignedBB.b, par1AxisAlignedBB.f);
        tessellator.a(par1AxisAlignedBB.a, par1AxisAlignedBB.b, par1AxisAlignedBB.c);
        tessellator.a();
        tessellator.b(3);
        tessellator.a(par1AxisAlignedBB.a, par1AxisAlignedBB.e, par1AxisAlignedBB.c);
        tessellator.a(par1AxisAlignedBB.d, par1AxisAlignedBB.e, par1AxisAlignedBB.c);
        tessellator.a(par1AxisAlignedBB.d, par1AxisAlignedBB.e, par1AxisAlignedBB.f);
        tessellator.a(par1AxisAlignedBB.a, par1AxisAlignedBB.e, par1AxisAlignedBB.f);
        tessellator.a(par1AxisAlignedBB.a, par1AxisAlignedBB.e, par1AxisAlignedBB.c);
        tessellator.a();
        tessellator.b(1);
        tessellator.a(par1AxisAlignedBB.a, par1AxisAlignedBB.b, par1AxisAlignedBB.c);
        tessellator.a(par1AxisAlignedBB.a, par1AxisAlignedBB.e, par1AxisAlignedBB.c);
        tessellator.a(par1AxisAlignedBB.d, par1AxisAlignedBB.b, par1AxisAlignedBB.c);
        tessellator.a(par1AxisAlignedBB.d, par1AxisAlignedBB.e, par1AxisAlignedBB.c);
        tessellator.a(par1AxisAlignedBB.d, par1AxisAlignedBB.b, par1AxisAlignedBB.f);
        tessellator.a(par1AxisAlignedBB.d, par1AxisAlignedBB.e, par1AxisAlignedBB.f);
        tessellator.a(par1AxisAlignedBB.a, par1AxisAlignedBB.b, par1AxisAlignedBB.f);
        tessellator.a(par1AxisAlignedBB.a, par1AxisAlignedBB.e, par1AxisAlignedBB.f);
        tessellator.a();
    }

    public void b(int par1, int par2, int par3, int par4, int par5, int par6) {
        int k1 = ls.a(par1, 16);
        int l1 = ls.a(par2, 16);
        int i2 = ls.a(par3, 16);
        int j2 = ls.a(par4, 16);
        int k2 = ls.a(par5, 16);
        int l2 = ls.a(par6, 16);
        for (int i3 = k1; i3 <= j2; ++i3) {
            int j3 = i3 % this.p;
            if (j3 < 0) {
                j3 += this.p;
            }
            for (int k3 = l1; k3 <= k2; ++k3) {
                int l3 = k3 % this.q;
                if (l3 < 0) {
                    l3 += this.q;
                }
                for (int i4 = i2; i4 <= l2; ++i4) {
                    int k4;
                    bfa worldrenderer;
                    int j4 = i4 % this.r;
                    if (j4 < 0) {
                        j4 += this.r;
                    }
                    if ((worldrenderer = this.o[k4 = (j4 * this.q + l3) * this.p + j3]) == null || worldrenderer.q) continue;
                    this.m.add(worldrenderer);
                    worldrenderer.f();
                }
            }
        }
    }

    public void a(int par1, int par2, int par3) {
        this.b(par1 - 1, par2 - 1, par3 - 1, par1 + 1, par2 + 1, par3 + 1);
    }

    public void b(int par1, int par2, int par3) {
        this.b(par1 - 1, par2 - 1, par3 - 1, par1 + 1, par2 + 1, par3 + 1);
    }

    public void a(int par1, int par2, int par3, int par4, int par5, int par6) {
        this.b(par1 - 1, par2 - 1, par3 - 1, par4 + 1, par5 + 1, par6 + 1);
    }

    public void a(bft par1ICamera, float par2) {
        for (int i2 = 0; i2 < this.o.length; ++i2) {
            if (this.o[i2].e() || this.o[i2].l && (i2 + this.f & 0xF) != 0) continue;
            this.o[i2].a(par1ICamera);
        }
        ++this.f;
    }

    public void a(String par1Str, int par2, int par3, int par4) {
        yr itemrecord = yr.e((String)par1Str);
        if (par1Str != null && itemrecord != null) {
            this.t.r.a(itemrecord.g());
        }
        this.t.v.a(par1Str, par2, par3, par4);
    }

    public void a(String par1Str, double par2, double par4, double par6, float par8, float par9) {
    }

    public void a(uf par1EntityPlayer, String par2Str, double par3, double par5, double par7, float par9, float par10) {
    }

    public void a(String par1Str, double par2, double par4, double par6, double par8, double par10, double par12) {
        try {
            this.b(par1Str, par2, par4, par6, par8, par10, par12);
        }
        catch (Throwable throwable) {
            b crashreport = b.a(throwable, "Exception while adding particle");
            m crashreportcategory = crashreport.a("Particle being added");
            crashreportcategory.a("Name", par1Str);
            crashreportcategory.a("Position", (Callable)new bfm(this, par2, par4, par6));
            throw new u(crashreport);
        }
    }

    public beg b(String par1Str, double par2, double par4, double par6, double par8, double par10, double par12) {
        if (this.t != null && this.t.i != null && this.t.k != null) {
            int i2 = this.t.u.am;
            if (i2 == 1 && this.k.s.nextInt(3) == 0) {
                i2 = 2;
            }
            double d6 = this.t.i.u - par2;
            double d7 = this.t.i.v - par4;
            double d8 = this.t.i.w - par6;
            Object entityfx = null;
            if (par1Str.equals("hugeexplosion")) {
                entityfx = new bed((abw)this.k, par2, par4, par6, par8, par10, par12);
                this.t.k.a((beg)entityfx);
            } else if (par1Str.equals("largeexplode")) {
                entityfx = new bec(this.l, (abw)this.k, par2, par4, par6, par8, par10, par12);
                this.t.k.a((beg)entityfx);
            } else if (par1Str.equals("fireworksSpark")) {
                entityfx = new bdx((abw)this.k, par2, par4, par6, par8, par10, par12, this.t.k);
                this.t.k.a((beg)entityfx);
            }
            if (entityfx != null) {
                return entityfx;
            }
            double d9 = 16.0;
            if (d6 * d6 + d7 * d7 + d8 * d8 > d9 * d9) {
                return null;
            }
            if (i2 > 1) {
                return null;
            }
            if (par1Str.equals("bubble")) {
                entityfx = new bdp((abw)this.k, par2, par4, par6, par8, par10, par12);
            } else if (par1Str.equals("suspended")) {
                entityfx = new bep((abw)this.k, par2, par4, par6, par8, par10, par12);
            } else if (par1Str.equals("depthsuspend")) {
                entityfx = new beq((abw)this.k, par2, par4, par6, par8, par10, par12);
            } else if (par1Str.equals("townaura")) {
                entityfx = new beq((abw)this.k, par2, par4, par6, par8, par10, par12);
            } else if (par1Str.equals("crit")) {
                entityfx = new bdr((abw)this.k, par2, par4, par6, par8, par10, par12);
            } else if (par1Str.equals("magicCrit")) {
                entityfx = new bdr((abw)this.k, par2, par4, par6, par8, par10, par12);
                entityfx.b(entityfx.c() * 0.3f, entityfx.d() * 0.8f, entityfx.e());
                entityfx.h();
            } else if (par1Str.equals("smoke")) {
                entityfx = new bel((abw)this.k, par2, par4, par6, par8, par10, par12);
            } else if (par1Str.equals("mobSpell")) {
                entityfx = new ben((abw)this.k, par2, par4, par6, 0.0, 0.0, 0.0);
                entityfx.b((float)par8, (float)par10, (float)par12);
            } else if (par1Str.equals("mobSpellAmbient")) {
                entityfx = new ben((abw)this.k, par2, par4, par6, 0.0, 0.0, 0.0);
                entityfx.g(0.15f);
                entityfx.b((float)par8, (float)par10, (float)par12);
            } else if (par1Str.equals("spell")) {
                entityfx = new ben((abw)this.k, par2, par4, par6, par8, par10, par12);
            } else if (par1Str.equals("instantSpell")) {
                entityfx = new ben((abw)this.k, par2, par4, par6, par8, par10, par12);
                ((ben)entityfx).a(144);
            } else if (par1Str.equals("witchMagic")) {
                entityfx = new ben((abw)this.k, par2, par4, par6, par8, par10, par12);
                ((ben)entityfx).a(144);
                float f2 = this.k.s.nextFloat() * 0.5f + 0.35f;
                entityfx.b(1.0f * f2, 0.0f * f2, 1.0f * f2);
            } else if (par1Str.equals("note")) {
                entityfx = new bef((abw)this.k, par2, par4, par6, par8, par10, par12);
            } else if (par1Str.equals("portal")) {
                entityfx = new bej((abw)this.k, par2, par4, par6, par8, par10, par12);
            } else if (par1Str.equals("enchantmenttable")) {
                entityfx = new bdt((abw)this.k, par2, par4, par6, par8, par10, par12);
            } else if (par1Str.equals("explode")) {
                entityfx = new bdu((abw)this.k, par2, par4, par6, par8, par10, par12);
            } else if (par1Str.equals("flame")) {
                entityfx = new bdz((abw)this.k, par2, par4, par6, par8, par10, par12);
            } else if (par1Str.equals("lava")) {
                entityfx = new bee((abw)this.k, par2, par4, par6);
            } else if (par1Str.equals("footstep")) {
                entityfx = new bea(this.l, (abw)this.k, par2, par4, par6);
            } else if (par1Str.equals("splash")) {
                entityfx = new beo((abw)this.k, par2, par4, par6, par8, par10, par12);
            } else if (par1Str.equals("largesmoke")) {
                entityfx = new bel((abw)this.k, par2, par4, par6, par8, par10, par12, 2.5f);
            } else if (par1Str.equals("cloud")) {
                entityfx = new bei((abw)this.k, par2, par4, par6, par8, par10, par12);
            } else if (par1Str.equals("reddust")) {
                entityfx = new bek((abw)this.k, par2, par4, par6, (float)par8, (float)par10, (float)par12);
            } else if (par1Str.equals("snowballpoof")) {
                entityfx = new bdo((abw)this.k, par2, par4, par6, yc.aF);
            } else if (par1Str.equals("dripWater")) {
                entityfx = new bds((abw)this.k, par2, par4, par6, akc.h);
            } else if (par1Str.equals("dripLava")) {
                entityfx = new bds((abw)this.k, par2, par4, par6, akc.i);
            } else if (par1Str.equals("snowshovel")) {
                entityfx = new bem((abw)this.k, par2, par4, par6, par8, par10, par12);
            } else if (par1Str.equals("slime")) {
                entityfx = new bdo((abw)this.k, par2, par4, par6, yc.aO);
            } else if (par1Str.equals("heart")) {
                entityfx = new beb((abw)this.k, par2, par4, par6, par8, par10, par12);
            } else if (par1Str.equals("angryVillager")) {
                entityfx = new beb((abw)this.k, par2, par4 + 0.5, par6, par8, par10, par12);
                entityfx.i(81);
                entityfx.b(1.0f, 1.0f, 1.0f);
            } else if (par1Str.equals("happyVillager")) {
                entityfx = new beq((abw)this.k, par2, par4, par6, par8, par10, par12);
                entityfx.i(82);
                entityfx.b(1.0f, 1.0f, 1.0f);
            } else if (par1Str.startsWith("iconcrack_")) {
                String[] astring = par1Str.split("_", 3);
                int j2 = Integer.parseInt(astring[1]);
                if (astring.length > 2) {
                    int k = Integer.parseInt(astring[2]);
                    entityfx = new bdo((abw)this.k, par2, par4, par6, par8, par10, par12, yc.g[j2], k);
                } else {
                    entityfx = new bdo((abw)this.k, par2, par4, par6, par8, par10, par12, yc.g[j2], 0);
                }
            } else if (par1Str.startsWith("tilecrack_")) {
                String[] astring = par1Str.split("_", 3);
                int j3 = Integer.parseInt(astring[1]);
                int k = Integer.parseInt(astring[2]);
                entityfx = new bes((abw)this.k, par2, par4, par6, par8, par10, par12, aqz.s[j3], k).a(k);
            }
            if (entityfx != null) {
                this.t.k.a((beg)entityfx);
            }
            return entityfx;
        }
        return null;
    }

    public void a(nn par1Entity) {
    }

    public void b(nn par1Entity) {
    }

    public void f() {
        atu.b((int)this.s);
    }

    public void a(int par1, int par2, int par3, int par4, int par5) {
        Random random = this.k.s;
        switch (par1) {
            case 1013: 
            case 1018: {
                if (this.t.i == null) break;
                double d0 = (double)par2 - this.t.i.u;
                double d1 = (double)par3 - this.t.i.v;
                double d2 = (double)par4 - this.t.i.w;
                double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
                double d4 = this.t.i.u;
                double d5 = this.t.i.v;
                double d6 = this.t.i.w;
                if (d3 > 0.0) {
                    d4 += d0 / d3 * 2.0;
                    d5 += d1 / d3 * 2.0;
                    d6 += d2 / d3 * 2.0;
                }
                if (par1 == 1013) {
                    this.k.a(d4, d5, d6, "mob.wither.spawn", 1.0f, 1.0f, false);
                    break;
                }
                if (par1 != 1018) break;
                this.k.a(d4, d5, d6, "mob.enderdragon.end", 5.0f, 1.0f, false);
            }
        }
    }

    public void a(uf par1EntityPlayer, int par2, int par3, int par4, int par5, int par6) {
        Random random = this.k.s;
        switch (par2) {
            case 1000: {
                this.k.a((double)par3, (double)par4, (double)par5, "random.click", 1.0f, 1.0f, false);
                break;
            }
            case 1001: {
                this.k.a((double)par3, (double)par4, (double)par5, "random.click", 1.0f, 1.2f, false);
                break;
            }
            case 1002: {
                this.k.a((double)par3, (double)par4, (double)par5, "random.bow", 1.0f, 1.2f, false);
                break;
            }
            case 1003: {
                if (Math.random() < 0.5) {
                    this.k.a((double)par3 + 0.5, (double)par4 + 0.5, (double)par5 + 0.5, "random.door_open", 1.0f, this.k.s.nextFloat() * 0.1f + 0.9f, false);
                    break;
                }
                this.k.a((double)par3 + 0.5, (double)par4 + 0.5, (double)par5 + 0.5, "random.door_close", 1.0f, this.k.s.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1004: {
                this.k.a((double)((float)par3 + 0.5f), (double)((float)par4 + 0.5f), (double)((float)par5 + 0.5f), "random.fizz", 0.5f, 2.6f + (random.nextFloat() - random.nextFloat()) * 0.8f, false);
                break;
            }
            case 1005: {
                if (yc.g[par6] instanceof yr) {
                    this.k.a(((yr)yc.g[par6]).a, par3, par4, par5);
                    break;
                }
                this.k.a((String)null, par3, par4, par5);
                break;
            }
            case 1007: {
                this.k.a((double)par3 + 0.5, (double)par4 + 0.5, (double)par5 + 0.5, "mob.ghast.charge", 10.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1008: {
                this.k.a((double)par3 + 0.5, (double)par4 + 0.5, (double)par5 + 0.5, "mob.ghast.fireball", 10.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1009: {
                this.k.a((double)par3 + 0.5, (double)par4 + 0.5, (double)par5 + 0.5, "mob.ghast.fireball", 2.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1010: {
                this.k.a((double)par3 + 0.5, (double)par4 + 0.5, (double)par5 + 0.5, "mob.zombie.wood", 2.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1011: {
                this.k.a((double)par3 + 0.5, (double)par4 + 0.5, (double)par5 + 0.5, "mob.zombie.metal", 2.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1012: {
                this.k.a((double)par3 + 0.5, (double)par4 + 0.5, (double)par5 + 0.5, "mob.zombie.woodbreak", 2.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1014: {
                this.k.a((double)par3 + 0.5, (double)par4 + 0.5, (double)par5 + 0.5, "mob.wither.shoot", 2.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1015: {
                this.k.a((double)par3 + 0.5, (double)par4 + 0.5, (double)par5 + 0.5, "mob.bat.takeoff", 0.05f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1016: {
                this.k.a((double)par3 + 0.5, (double)par4 + 0.5, (double)par5 + 0.5, "mob.zombie.infect", 2.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1017: {
                this.k.a((double)par3 + 0.5, (double)par4 + 0.5, (double)par5 + 0.5, "mob.zombie.unfect", 2.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1020: {
                this.k.a((double)((float)par3 + 0.5f), (double)((float)par4 + 0.5f), (double)((float)par5 + 0.5f), "random.anvil_break", 1.0f, this.k.s.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1021: {
                this.k.a((double)((float)par3 + 0.5f), (double)((float)par4 + 0.5f), (double)((float)par5 + 0.5f), "random.anvil_use", 1.0f, this.k.s.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1022: {
                this.k.a((double)((float)par3 + 0.5f), (double)((float)par4 + 0.5f), (double)((float)par5 + 0.5f), "random.anvil_land", 0.3f, this.k.s.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 2000: {
                int l1 = par6 % 3 - 1;
                int i2 = par6 / 3 % 3 - 1;
                double d1 = (double)par3 + (double)l1 * 0.6 + 0.5;
                double d2 = (double)par4 + 0.5;
                double d8 = (double)par5 + (double)i2 * 0.6 + 0.5;
                for (int j2 = 0; j2 < 10; ++j2) {
                    double d9 = random.nextDouble() * 0.2 + 0.01;
                    double d10 = d1 + (double)l1 * 0.01 + (random.nextDouble() - 0.5) * (double)i2 * 0.5;
                    double d7 = d2 + (random.nextDouble() - 0.5) * 0.5;
                    double d3 = d8 + (double)i2 * 0.01 + (random.nextDouble() - 0.5) * (double)l1 * 0.5;
                    double d4 = (double)l1 * d9 + random.nextGaussian() * 0.01;
                    double d5 = -0.03 + random.nextGaussian() * 0.01;
                    double d6 = (double)i2 * d9 + random.nextGaussian() * 0.01;
                    this.a("smoke", d10, d7, d3, d4, d5, d6);
                }
                return;
            }
            case 2001: {
                int k1 = par6 & 0xFFF;
                if (k1 > 0) {
                    aqz block = aqz.s[k1];
                    this.t.v.a(block.cS.a(), (float)par3 + 0.5f, (float)par4 + 0.5f, (float)par5 + 0.5f, (block.cS.c() + 1.0f) / 2.0f, block.cS.d() * 0.8f);
                }
                this.t.k.a(par3, par4, par5, par6 & 0xFFF, par6 >> 12 & 0xFF);
                break;
            }
            case 2002: {
                int j1;
                double d0 = par3;
                double d1 = par4;
                double d2 = par5;
                String s2 = "iconcrack_" + yc.bu.cv + "_" + par6;
                for (j1 = 0; j1 < 8; ++j1) {
                    this.a(s2, d0, d1, d2, random.nextGaussian() * 0.15, random.nextDouble() * 0.2, random.nextGaussian() * 0.15);
                }
                j1 = yc.bu.g(par6);
                float f2 = (float)(j1 >> 16 & 0xFF) / 255.0f;
                float f1 = (float)(j1 >> 8 & 0xFF) / 255.0f;
                float f22 = (float)(j1 >> 0 & 0xFF) / 255.0f;
                String s1 = "spell";
                if (yc.bu.h(par6)) {
                    s1 = "instantSpell";
                }
                for (int k1 = 0; k1 < 100; ++k1) {
                    double d7 = random.nextDouble() * 4.0;
                    double d3 = random.nextDouble() * Math.PI * 2.0;
                    double d4 = Math.cos(d3) * d7;
                    double d5 = 0.01 + random.nextDouble() * 0.5;
                    double d6 = Math.sin(d3) * d7;
                    beg entityfx = this.b(s1, d0 + d4 * 0.1, d1 + 0.3, d2 + d6 * 0.1, d4, d5, d6);
                    if (entityfx == null) continue;
                    float f3 = 0.75f + random.nextFloat() * 0.25f;
                    entityfx.b(f2 * f3, f1 * f3, f22 * f3);
                    entityfx.a((float)d7);
                }
                this.k.a((double)par3 + 0.5, (double)par4 + 0.5, (double)par5 + 0.5, "random.glass", 1.0f, this.k.s.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 2003: {
                double d0 = (double)par3 + 0.5;
                double d1 = par4;
                double d2 = (double)par5 + 0.5;
                String s3 = "iconcrack_" + yc.bC.cv;
                for (int j1 = 0; j1 < 8; ++j1) {
                    this.a(s3, d0, d1, d2, random.nextGaussian() * 0.15, random.nextDouble() * 0.2, random.nextGaussian() * 0.15);
                }
                for (double d11 = 0.0; d11 < Math.PI * 2; d11 += 0.15707963267948966) {
                    this.a("portal", d0 + Math.cos(d11) * 5.0, d1 - 0.4, d2 + Math.sin(d11) * 5.0, Math.cos(d11) * -5.0, 0.0, Math.sin(d11) * -5.0);
                    this.a("portal", d0 + Math.cos(d11) * 5.0, d1 - 0.4, d2 + Math.sin(d11) * 5.0, Math.cos(d11) * -7.0, 0.0, Math.sin(d11) * -7.0);
                }
                return;
            }
            case 2004: {
                for (int k2 = 0; k2 < 20; ++k2) {
                    double d12 = (double)par3 + 0.5 + ((double)this.k.s.nextFloat() - 0.5) * 2.0;
                    double d13 = (double)par4 + 0.5 + ((double)this.k.s.nextFloat() - 0.5) * 2.0;
                    double d14 = (double)par5 + 0.5 + ((double)this.k.s.nextFloat() - 0.5) * 2.0;
                    this.k.a("smoke", d12, d13, d14, 0.0, 0.0, 0.0);
                    this.k.a("flame", d12, d13, d14, 0.0, 0.0, 0.0);
                }
                return;
            }
            case 2005: {
                xl.a((abw)this.k, (int)par3, (int)par4, (int)par5, (int)par6);
            }
        }
    }

    public void b(int par1, int par2, int par3, int par4, int par5) {
        if (par5 >= 0 && par5 < 10) {
            ji destroyblockprogress = (ji)this.H.get(par1);
            if (destroyblockprogress == null || destroyblockprogress.b() != par2 || destroyblockprogress.c() != par3 || destroyblockprogress.d() != par4) {
                destroyblockprogress = new ji(par1, par2, par3, par4);
                this.H.put(par1, destroyblockprogress);
            }
            destroyblockprogress.a(par5);
            destroyblockprogress.b(this.x);
        } else {
            this.H.remove(par1);
        }
    }

    public void a(mt par1IconRegister) {
        this.I = new ms[10];
        for (int i2 = 0; i2 < this.I.length; ++i2) {
            this.I[i2] = par1IconRegister.a("destroy_stage_" + i2);
        }
    }
}

