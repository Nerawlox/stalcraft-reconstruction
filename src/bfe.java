/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aaw
 *  akc
 *  asx
 *  ata
 *  atc
 *  atu
 *  awf
 *  bdd
 *  beg
 *  bel
 *  bet
 *  bex
 *  bez
 *  bff
 *  bfg
 *  bfh
 *  bft
 *  bfv
 *  bib
 *  bjo
 *  bma
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  lz
 *  net.minecraftforge.client.ForgeHooksClient
 *  ni
 *  org.lwjgl.input.Mouse
 *  org.lwjgl.opengl.Display
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GLContext
 *  org.lwjgl.util.glu.Project
 *  u
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.nio.FloatBuffer;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import net.minecraftforge.client.ForgeHooksClient;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.util.glu.Project;

@SideOnly(value=Side.CLIENT)
public class bfe {
    private static final bjo o = new bjo("textures/environment/rain.png");
    private static final bjo p = new bjo("textures/environment/snow.png");
    public static boolean a;
    public static int b;
    private atv q;
    private float r;
    public bfj c;
    private int s;
    private nn t;
    private lz u = new lz();
    private lz v = new lz();
    private lz w = new lz();
    private lz x = new lz();
    private lz y = new lz();
    private lz z = new lz();
    private float A = 4.0f;
    private float B = 4.0f;
    private float C;
    private float D;
    private float E;
    private float F;
    private float G;
    private float H;
    private float I;
    private float J;
    private float K;
    private float L;
    private float M;
    private float N;
    private float O;
    private final bib P;
    private final int[] Q;
    private final bjo R;
    private float S;
    private float T;
    private float U;
    private float V;
    private float W;
    private boolean X;
    private double Y = 1.0;
    private double Z;
    private double aa;
    private long ab = atv.F();
    private long ac;
    private boolean ad;
    float d;
    float e;
    float f;
    float g;
    private Random ae = new Random();
    private int af;
    float[] h;
    float[] i;
    FloatBuffer j = atu.h((int)16);
    float k;
    float l;
    float m;
    private float ag;
    private float ah;
    public int n;

    public bfe(atv par1Minecraft) {
        this.q = par1Minecraft;
        this.c = new bfj(par1Minecraft);
        this.P = new bib(16, 16);
        this.R = par1Minecraft.J().a("lightMap", this.P);
        this.Q = this.P.c();
    }

    public void a() {
        float f1;
        float f2;
        this.e();
        this.f();
        this.ag = this.ah;
        this.B = this.A;
        this.D = this.C;
        this.F = this.E;
        this.M = this.L;
        this.O = this.N;
        if (this.q.u.af) {
            f2 = this.q.u.c * 0.6f + 0.2f;
            f1 = f2 * f2 * f2 * 8.0f;
            this.I = this.u.a(this.G, 0.05f * f1);
            this.J = this.v.a(this.H, 0.05f * f1);
            this.K = 0.0f;
            this.G = 0.0f;
            this.H = 0.0f;
        }
        if (this.q.i == null) {
            this.q.i = this.q.h;
        }
        f2 = this.q.f.q(ls.c(this.q.i.u), ls.c(this.q.i.v), ls.c(this.q.i.w));
        f1 = (float)(3 - this.q.u.e) / 3.0f;
        float f22 = f2 * (1.0f - f1) + f1;
        this.ah += (f22 - this.ah) * 0.1f;
        ++this.s;
        this.c.a();
        this.g();
        this.W = this.V;
        if (bez.d) {
            this.V += 0.05f;
            if (this.V > 1.0f) {
                this.V = 1.0f;
            }
            bez.d = false;
        } else if (this.V > 0.0f) {
            this.V -= 0.0125f;
        }
    }

    public void a(float par1) {
        if (this.q.i != null && this.q.f != null) {
            this.q.j = null;
            double d0 = this.q.c.d();
            this.q.t = this.q.i.a(d0, par1);
            double d1 = d0;
            atc vec3 = this.q.i.l(par1);
            if (this.q.c.i()) {
                d0 = 6.0;
                d1 = 6.0;
            } else {
                if (d0 > 3.0) {
                    d1 = 3.0;
                }
                d0 = d1;
            }
            if (this.q.t != null) {
                d1 = this.q.t.f.d(vec3);
            }
            atc vec31 = this.q.i.j(par1);
            atc vec32 = vec3.c(vec31.c * d0, vec31.d * d0, vec31.e * d0);
            this.t = null;
            float f1 = 1.0f;
            List list = this.q.f.b((nn)this.q.i, this.q.i.E.a(vec31.c * d0, vec31.d * d0, vec31.e * d0).b((double)f1, (double)f1, (double)f1));
            double d2 = d1;
            for (int i2 = 0; i2 < list.size(); ++i2) {
                double d3;
                nn entity = (nn)list.get(i2);
                if (!entity.L()) continue;
                float f2 = entity.Z();
                asx axisalignedbb = entity.E.b((double)f2, (double)f2, (double)f2);
                ata movingobjectposition = axisalignedbb.a(vec3, vec32);
                if (axisalignedbb.a(vec3)) {
                    if (!(0.0 < d2) && d2 != 0.0) continue;
                    this.t = entity;
                    d2 = 0.0;
                    continue;
                }
                if (movingobjectposition == null || !((d3 = vec3.d(movingobjectposition.f)) < d2) && d2 != 0.0) continue;
                if (entity == this.q.i.o && !entity.canRiderInteract()) {
                    if (d2 != 0.0) continue;
                    this.t = entity;
                    continue;
                }
                this.t = entity;
                d2 = d3;
            }
            if (this.t != null && (d2 < d1 || this.q.t == null)) {
                this.q.t = new ata(this.t);
                if (this.t instanceof of) {
                    this.q.j = (of)this.t;
                }
            }
        }
    }

    private void e() {
        if (this.q.i instanceof bex) {
            bex entityplayersp = (bex)this.q.i;
            this.U = entityplayersp.t();
        } else {
            this.U = this.q.h.t();
        }
        this.T = this.S;
        this.S += (this.U - this.S) * 0.5f;
        if (this.S > 1.5f) {
            this.S = 1.5f;
        }
        if (this.S < 0.1f) {
            this.S = 0.1f;
        }
    }

    private float a(float par1, boolean par2) {
        int i2;
        if (this.n > 0) {
            return 90.0f;
        }
        of entityplayer = this.q.i;
        float f1 = 70.0f;
        if (par2) {
            f1 += this.q.u.aj * 40.0f;
            f1 *= this.T + (this.S - this.T) * par1;
        }
        if (entityplayer.aN() <= 0.0f) {
            float f2 = (float)entityplayer.aB + par1;
            f1 /= (1.0f - 500.0f / (f2 + 500.0f)) * 2.0f + 1.0f;
        }
        if ((i2 = atp.a((abw)this.q.f, entityplayer, par1)) != 0 && aqz.s[i2].cU == akc.h) {
            f1 = f1 * 60.0f / 70.0f;
        }
        return f1 + this.M + (this.L - this.M) * par1;
    }

    private void e(float par1) {
        float f2;
        of entitylivingbase = this.q.i;
        float f1 = (float)entitylivingbase.ay - par1;
        if (entitylivingbase.aN() <= 0.0f) {
            f2 = (float)entitylivingbase.aB + par1;
            GL11.glRotatef((float)(40.0f - 8000.0f / (f2 + 200.0f)), (float)0.0f, (float)0.0f, (float)1.0f);
        }
        if (f1 >= 0.0f) {
            f1 /= (float)entitylivingbase.az;
            f1 = ls.a(f1 * f1 * f1 * f1 * (float)Math.PI);
            f2 = entitylivingbase.aA;
            GL11.glRotatef((float)(-f2), (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glRotatef((float)(-f1 * 14.0f), (float)0.0f, (float)0.0f, (float)1.0f);
            GL11.glRotatef((float)f2, (float)0.0f, (float)1.0f, (float)0.0f);
        }
    }

    private void f(float par1) {
        if (this.q.i instanceof uf) {
            uf entityplayer = (uf)this.q.i;
            float f1 = entityplayer.R - entityplayer.Q;
            float f2 = -(entityplayer.R + f1 * par1);
            float f3 = entityplayer.bs + (entityplayer.bt - entityplayer.bs) * par1;
            float f4 = entityplayer.aJ + (entityplayer.aK - entityplayer.aJ) * par1;
            GL11.glTranslatef((float)(ls.a(f2 * (float)Math.PI) * f3 * 0.5f), (float)(-Math.abs(ls.b(f2 * (float)Math.PI) * f3)), (float)0.0f);
            GL11.glRotatef((float)(ls.a(f2 * (float)Math.PI) * f3 * 3.0f), (float)0.0f, (float)0.0f, (float)1.0f);
            GL11.glRotatef((float)(Math.abs(ls.b(f2 * (float)Math.PI - 0.2f) * f3) * 5.0f), (float)1.0f, (float)0.0f, (float)0.0f);
            GL11.glRotatef((float)f4, (float)1.0f, (float)0.0f, (float)0.0f);
        }
    }

    private void g(float par1) {
        of entitylivingbase = this.q.i;
        float f1 = entitylivingbase.N - 1.62f;
        double d0 = entitylivingbase.r + (entitylivingbase.u - entitylivingbase.r) * (double)par1;
        double d1 = entitylivingbase.s + (entitylivingbase.v - entitylivingbase.s) * (double)par1 - (double)f1;
        double d2 = entitylivingbase.t + (entitylivingbase.w - entitylivingbase.t) * (double)par1;
        GL11.glRotatef((float)(this.O + (this.N - this.O) * par1), (float)0.0f, (float)0.0f, (float)1.0f);
        if (entitylivingbase.bh()) {
            f1 = (float)((double)f1 + 1.0);
            GL11.glTranslatef((float)0.0f, (float)0.3f, (float)0.0f);
            if (!this.q.u.ag) {
                ForgeHooksClient.orientBedCamera((atv)this.q, (of)entitylivingbase);
                GL11.glRotatef((float)(entitylivingbase.C + (entitylivingbase.A - entitylivingbase.C) * par1 + 180.0f), (float)0.0f, (float)-1.0f, (float)0.0f);
                GL11.glRotatef((float)(entitylivingbase.D + (entitylivingbase.B - entitylivingbase.D) * par1), (float)-1.0f, (float)0.0f, (float)0.0f);
            }
        } else if (this.q.u.aa > 0) {
            double d3 = this.B + (this.A - this.B) * par1;
            if (this.q.u.ag) {
                float f3 = this.D + (this.C - this.D) * par1;
                float f2 = this.F + (this.E - this.F) * par1;
                GL11.glTranslatef((float)0.0f, (float)0.0f, (float)((float)(-d3)));
                GL11.glRotatef((float)f2, (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)f3, (float)0.0f, (float)1.0f, (float)0.0f);
            } else {
                float f3 = entitylivingbase.A;
                float f2 = entitylivingbase.B;
                if (this.q.u.aa == 2) {
                    f2 += 180.0f;
                }
                double d4 = (double)(-ls.a(f3 / 180.0f * (float)Math.PI) * ls.b(f2 / 180.0f * (float)Math.PI)) * d3;
                double d5 = (double)(ls.b(f3 / 180.0f * (float)Math.PI) * ls.b(f2 / 180.0f * (float)Math.PI)) * d3;
                double d6 = (double)(-ls.a(f2 / 180.0f * (float)Math.PI)) * d3;
                for (int l2 = 0; l2 < 8; ++l2) {
                    double d7;
                    float f4 = (l2 & 1) * 2 - 1;
                    float f5 = (l2 >> 1 & 1) * 2 - 1;
                    float f6 = (l2 >> 2 & 1) * 2 - 1;
                    ata movingobjectposition = this.q.f.a(this.q.f.V().a(d0 + (double)(f4 *= 0.1f), d1 + (double)(f5 *= 0.1f), d2 + (double)(f6 *= 0.1f)), this.q.f.V().a(d0 - d4 + (double)f4 + (double)f6, d1 - d6 + (double)f5, d2 - d5 + (double)f6));
                    if (movingobjectposition == null || !((d7 = movingobjectposition.f.d(this.q.f.V().a(d0, d1, d2))) < d3)) continue;
                    d3 = d7;
                }
                if (this.q.u.aa == 2) {
                    GL11.glRotatef((float)180.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                }
                GL11.glRotatef((float)(entitylivingbase.B - f2), (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)(entitylivingbase.A - f3), (float)0.0f, (float)1.0f, (float)0.0f);
                GL11.glTranslatef((float)0.0f, (float)0.0f, (float)((float)(-d3)));
                GL11.glRotatef((float)(f3 - entitylivingbase.A), (float)0.0f, (float)1.0f, (float)0.0f);
                GL11.glRotatef((float)(f2 - entitylivingbase.B), (float)1.0f, (float)0.0f, (float)0.0f);
            }
        } else {
            GL11.glTranslatef((float)0.0f, (float)0.0f, (float)-0.1f);
        }
        if (!this.q.u.ag) {
            GL11.glRotatef((float)(entitylivingbase.D + (entitylivingbase.B - entitylivingbase.D) * par1), (float)1.0f, (float)0.0f, (float)0.0f);
            GL11.glRotatef((float)(entitylivingbase.C + (entitylivingbase.A - entitylivingbase.C) * par1 + 180.0f), (float)0.0f, (float)1.0f, (float)0.0f);
        }
        GL11.glTranslatef((float)0.0f, (float)f1, (float)0.0f);
        d0 = entitylivingbase.r + (entitylivingbase.u - entitylivingbase.r) * (double)par1;
        d1 = entitylivingbase.s + (entitylivingbase.v - entitylivingbase.s) * (double)par1 - (double)f1;
        d2 = entitylivingbase.t + (entitylivingbase.w - entitylivingbase.t) * (double)par1;
        this.X = this.q.g.a(d0, d1, d2, par1);
    }

    private void a(float par1, int par2) {
        float f2;
        this.r = 256 >> this.q.u.e;
        GL11.glMatrixMode((int)5889);
        GL11.glLoadIdentity();
        float f1 = 0.07f;
        if (this.q.u.g) {
            GL11.glTranslatef((float)((float)(-(par2 * 2 - 1)) * f1), (float)0.0f, (float)0.0f);
        }
        if (this.Y != 1.0) {
            GL11.glTranslatef((float)((float)this.Z), (float)((float)(-this.aa)), (float)0.0f);
            GL11.glScaled((double)this.Y, (double)this.Y, (double)1.0);
        }
        Project.gluPerspective((float)this.a(par1, true), (float)((float)this.q.d / (float)this.q.e), (float)0.05f, (float)(this.r * 2.0f));
        if (this.q.c.a()) {
            f2 = 0.6666667f;
            GL11.glScalef((float)1.0f, (float)f2, (float)1.0f);
        }
        GL11.glMatrixMode((int)5888);
        GL11.glLoadIdentity();
        if (this.q.u.g) {
            GL11.glTranslatef((float)((float)(par2 * 2 - 1) * 0.1f), (float)0.0f, (float)0.0f);
        }
        this.e(par1);
        if (this.q.u.f) {
            this.f(par1);
        }
        if ((f2 = this.q.h.bO + (this.q.h.bN - this.q.h.bO) * par1) > 0.0f) {
            int b0 = 20;
            if (this.q.h.a(ni.k)) {
                b0 = 7;
            }
            float f3 = 5.0f / (f2 * f2 + 5.0f) - f2 * 0.04f;
            f3 *= f3;
            GL11.glRotatef((float)(((float)this.s + par1) * (float)b0), (float)0.0f, (float)1.0f, (float)1.0f);
            GL11.glScalef((float)(1.0f / f3), (float)1.0f, (float)1.0f);
            GL11.glRotatef((float)(-((float)this.s + par1) * (float)b0), (float)0.0f, (float)1.0f, (float)1.0f);
        }
        this.g(par1);
        if (this.n > 0) {
            int j2 = this.n - 1;
            if (j2 == 1) {
                GL11.glRotatef((float)90.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            }
            if (j2 == 2) {
                GL11.glRotatef((float)180.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            }
            if (j2 == 3) {
                GL11.glRotatef((float)-90.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            }
            if (j2 == 4) {
                GL11.glRotatef((float)90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
            }
            if (j2 == 5) {
                GL11.glRotatef((float)-90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
            }
        }
    }

    private void b(float par1, int par2) {
        if (this.n <= 0) {
            GL11.glMatrixMode((int)5889);
            GL11.glLoadIdentity();
            float f1 = 0.07f;
            if (this.q.u.g) {
                GL11.glTranslatef((float)((float)(-(par2 * 2 - 1)) * f1), (float)0.0f, (float)0.0f);
            }
            if (this.Y != 1.0) {
                GL11.glTranslatef((float)((float)this.Z), (float)((float)(-this.aa)), (float)0.0f);
                GL11.glScaled((double)this.Y, (double)this.Y, (double)1.0);
            }
            Project.gluPerspective((float)this.a(par1, false), (float)((float)this.q.d / (float)this.q.e), (float)0.05f, (float)(this.r * 2.0f));
            if (this.q.c.a()) {
                float f2 = 0.6666667f;
                GL11.glScalef((float)1.0f, (float)f2, (float)1.0f);
            }
            GL11.glMatrixMode((int)5888);
            GL11.glLoadIdentity();
            if (this.q.u.g) {
                GL11.glTranslatef((float)((float)(par2 * 2 - 1) * 0.1f), (float)0.0f, (float)0.0f);
            }
            GL11.glPushMatrix();
            this.e(par1);
            if (this.q.u.f) {
                this.f(par1);
            }
            if (!(this.q.u.aa != 0 || this.q.i.bh() || this.q.u.Z || this.q.c.a())) {
                this.b((double)par1);
                this.c.a(par1);
                this.a((double)par1);
            }
            GL11.glPopMatrix();
            if (this.q.u.aa == 0 && !this.q.i.bh()) {
                this.c.b(par1);
                this.e(par1);
            }
            if (this.q.u.f) {
                this.f(par1);
            }
        }
    }

    public void a(double par1) {
        bma.a((int)bma.b);
        GL11.glDisable((int)3553);
        bma.a((int)bma.a);
    }

    public void b(double par1) {
        bma.a((int)bma.b);
        GL11.glMatrixMode((int)5890);
        GL11.glLoadIdentity();
        float f2 = 0.00390625f;
        GL11.glScalef((float)f2, (float)f2, (float)f2);
        GL11.glTranslatef((float)8.0f, (float)8.0f, (float)8.0f);
        GL11.glMatrixMode((int)5888);
        this.q.J().a(this.R);
        GL11.glTexParameteri((int)3553, (int)10241, (int)9729);
        GL11.glTexParameteri((int)3553, (int)10240, (int)9729);
        GL11.glTexParameteri((int)3553, (int)10241, (int)9729);
        GL11.glTexParameteri((int)3553, (int)10240, (int)9729);
        GL11.glTexParameteri((int)3553, (int)10242, (int)10496);
        GL11.glTexParameteri((int)3553, (int)10243, (int)10496);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glEnable((int)3553);
        bma.a((int)bma.a);
    }

    private void f() {
        this.e = (float)((double)this.e + (Math.random() - Math.random()) * Math.random() * Math.random());
        this.g = (float)((double)this.g + (Math.random() - Math.random()) * Math.random() * Math.random());
        this.e = (float)((double)this.e * 0.9);
        this.g = (float)((double)this.g * 0.9);
        this.d += (this.e - this.d) * 1.0f;
        this.f += (this.g - this.f) * 1.0f;
        this.ad = true;
    }

    private void h(float par1) {
        bdd worldclient = this.q.f;
        if (worldclient != null) {
            for (int i2 = 0; i2 < 256; ++i2) {
                float f12;
                float f11;
                float f1 = worldclient.b(1.0f) * 0.95f + 0.05f;
                float f2 = worldclient.t.h[i2 / 16] * f1;
                float f3 = worldclient.t.h[i2 % 16] * (this.d * 0.1f + 1.5f);
                if (worldclient.q > 0) {
                    f2 = worldclient.t.h[i2 / 16];
                }
                float f4 = f2 * (worldclient.b(1.0f) * 0.65f + 0.35f);
                float f5 = f2 * (worldclient.b(1.0f) * 0.65f + 0.35f);
                float f6 = f3 * ((f3 * 0.6f + 0.4f) * 0.6f + 0.4f);
                float f7 = f3 * (f3 * f3 * 0.6f + 0.4f);
                float f8 = f4 + f3;
                float f9 = f5 + f6;
                float f10 = f2 + f7;
                f8 = f8 * 0.96f + 0.03f;
                f9 = f9 * 0.96f + 0.03f;
                f10 = f10 * 0.96f + 0.03f;
                if (this.V > 0.0f) {
                    f11 = this.W + (this.V - this.W) * par1;
                    f8 = f8 * (1.0f - f11) + f8 * 0.7f * f11;
                    f9 = f9 * (1.0f - f11) + f9 * 0.6f * f11;
                    f10 = f10 * (1.0f - f11) + f10 * 0.6f * f11;
                }
                if (worldclient.t.i == 1) {
                    f8 = 0.22f + f3 * 0.75f;
                    f9 = 0.28f + f6 * 0.75f;
                    f10 = 0.25f + f7 * 0.75f;
                }
                if (this.q.h.a(ni.r)) {
                    f11 = this.a((uf)this.q.h, par1);
                    f12 = 1.0f / f8;
                    if (f12 > 1.0f / f9) {
                        f12 = 1.0f / f9;
                    }
                    if (f12 > 1.0f / f10) {
                        f12 = 1.0f / f10;
                    }
                    f8 = f8 * (1.0f - f11) + f8 * f12 * f11;
                    f9 = f9 * (1.0f - f11) + f9 * f12 * f11;
                    f10 = f10 * (1.0f - f11) + f10 * f12 * f11;
                }
                if (f8 > 1.0f) {
                    f8 = 1.0f;
                }
                if (f9 > 1.0f) {
                    f9 = 1.0f;
                }
                if (f10 > 1.0f) {
                    f10 = 1.0f;
                }
                f11 = this.q.u.ak;
                f12 = 1.0f - f8;
                float f13 = 1.0f - f9;
                float f14 = 1.0f - f10;
                f12 = 1.0f - f12 * f12 * f12 * f12;
                f13 = 1.0f - f13 * f13 * f13 * f13;
                f14 = 1.0f - f14 * f14 * f14 * f14;
                f8 = f8 * (1.0f - f11) + f12 * f11;
                f9 = f9 * (1.0f - f11) + f13 * f11;
                f10 = f10 * (1.0f - f11) + f14 * f11;
                f8 = f8 * 0.96f + 0.03f;
                f9 = f9 * 0.96f + 0.03f;
                f10 = f10 * 0.96f + 0.03f;
                if (f8 > 1.0f) {
                    f8 = 1.0f;
                }
                if (f9 > 1.0f) {
                    f9 = 1.0f;
                }
                if (f10 > 1.0f) {
                    f10 = 1.0f;
                }
                if (f8 < 0.0f) {
                    f8 = 0.0f;
                }
                if (f9 < 0.0f) {
                    f9 = 0.0f;
                }
                if (f10 < 0.0f) {
                    f10 = 0.0f;
                }
                int short1 = 255;
                int j2 = (int)(f8 * 255.0f);
                int k = (int)(f9 * 255.0f);
                int l2 = (int)(f10 * 255.0f);
                this.Q[i2] = short1 << 24 | j2 << 16 | k << 8 | l2;
            }
            this.P.a();
            this.ad = false;
        }
    }

    private float a(uf par1EntityPlayer, float par2) {
        int i2 = par1EntityPlayer.b(ni.r).b();
        return i2 > 200 ? 1.0f : 0.7f + ls.a(((float)i2 - par2) * (float)Math.PI * 0.2f) * 0.3f;
    }

    public void b(float par1) {
        this.q.C.a("lightTex");
        if (this.ad) {
            this.h(par1);
        }
        this.q.C.b();
        boolean flag = Display.isActive();
        if (!(flag || !this.q.u.y || this.q.u.A && Mouse.isButtonDown((int)1))) {
            if (atv.F() - this.ab > 500L) {
                this.q.i();
            }
        } else {
            this.ab = atv.F();
        }
        this.q.C.a("mouse");
        if (this.q.A && flag) {
            this.q.w.c();
            float f1 = this.q.u.c * 0.6f + 0.2f;
            float f2 = f1 * f1 * f1 * 8.0f;
            float f3 = (float)this.q.w.a * f2;
            float f4 = (float)this.q.w.b * f2;
            int b0 = 1;
            if (this.q.u.d) {
                b0 = -1;
            }
            if (this.q.u.af) {
                this.G += f3;
                this.H += f4;
                float f5 = par1 - this.K;
                this.K = par1;
                f3 = this.I * f5;
                f4 = this.J * f5;
                this.q.h.c(f3, f4 * (float)b0);
            } else {
                this.q.h.c(f3, f4 * (float)b0);
            }
        }
        this.q.C.b();
        if (!this.q.s) {
            a = this.q.u.g;
            awf scaledresolution = new awf(this.q.u, this.q.d, this.q.e);
            int i2 = scaledresolution.a();
            int j2 = scaledresolution.b();
            int k = Mouse.getX() * i2 / this.q.d;
            int l2 = j2 - Mouse.getY() * j2 / this.q.e - 1;
            int i1 = bfe.a(this.q.u.i);
            if (this.q.f != null) {
                this.q.C.a("level");
                if (this.q.u.i == 0) {
                    this.a(par1, 0L);
                } else {
                    this.a(par1, this.ac + (long)(1000000000 / i1));
                }
                this.ac = System.nanoTime();
                this.q.C.c("gui");
                if (!this.q.u.Z || this.q.n != null) {
                    this.q.r.a(par1, this.q.n != null, k, l2);
                }
                this.q.C.b();
            } else {
                GL11.glViewport((int)0, (int)0, (int)this.q.d, (int)this.q.e);
                GL11.glMatrixMode((int)5889);
                GL11.glLoadIdentity();
                GL11.glMatrixMode((int)5888);
                GL11.glLoadIdentity();
                this.c();
                this.ac = System.nanoTime();
            }
            if (this.q.n != null) {
                GL11.glClear((int)256);
                try {
                    this.q.n.a(k, l2, par1);
                }
                catch (Throwable throwable) {
                    b crashreport = b.a(throwable, "Rendering screen");
                    m crashreportcategory = crashreport.a("Screen render details");
                    crashreportcategory.a("Screen name", (Callable)new bff(this));
                    crashreportcategory.a("Mouse location", (Callable)new bfg(this, k, l2));
                    crashreportcategory.a("Screen size", (Callable)new bfh(this, scaledresolution));
                    throw new u(crashreport);
                }
            }
        }
    }

    public void a(float par1, long par2) {
        this.q.C.a("lightTex");
        if (this.ad) {
            this.h(par1);
        }
        GL11.glEnable((int)2884);
        GL11.glEnable((int)2929);
        if (this.q.i == null) {
            this.q.i = this.q.h;
        }
        this.q.C.c("pick");
        this.a(par1);
        of entitylivingbase = this.q.i;
        bfl renderglobal = this.q.g;
        beh effectrenderer = this.q.k;
        double d0 = entitylivingbase.U + (entitylivingbase.u - entitylivingbase.U) * (double)par1;
        double d1 = entitylivingbase.V + (entitylivingbase.v - entitylivingbase.V) * (double)par1;
        double d2 = entitylivingbase.W + (entitylivingbase.w - entitylivingbase.W) * (double)par1;
        this.q.C.c("center");
        for (int j2 = 0; j2 < 2; ++j2) {
            if (this.q.u.g) {
                b = j2;
                if (b == 0) {
                    GL11.glColorMask((boolean)false, (boolean)true, (boolean)true, (boolean)false);
                } else {
                    GL11.glColorMask((boolean)true, (boolean)false, (boolean)false, (boolean)false);
                }
            }
            this.q.C.c("clear");
            GL11.glViewport((int)0, (int)0, (int)this.q.d, (int)this.q.e);
            this.i(par1);
            GL11.glClear((int)16640);
            GL11.glEnable((int)2884);
            this.q.C.c("camera");
            this.a(par1, j2);
            atp.a((uf)this.q.h, this.q.u.aa == 2);
            this.q.C.c("frustrum");
            bfu.a();
            if (this.q.u.e < 2) {
                this.a(-1, par1);
                this.q.C.c("sky");
                renderglobal.a(par1);
            }
            GL11.glEnable((int)2912);
            this.a(1, par1);
            if (this.q.u.k != 0) {
                GL11.glShadeModel((int)7425);
            }
            this.q.C.c("culling");
            bfv frustrum = new bfv();
            frustrum.a(d0, d1, d2);
            this.q.g.a((bft)frustrum, par1);
            if (j2 == 0) {
                long k;
                this.q.C.c("updatechunks");
                while (!this.q.g.a(entitylivingbase, false) && par2 != 0L && (k = par2 - System.nanoTime()) >= 0L && k <= 1000000000L) {
                }
            }
            if (entitylivingbase.v < 128.0) {
                this.a(renderglobal, par1);
            }
            this.q.C.c("prepareterrain");
            this.a(0, par1);
            GL11.glEnable((int)2912);
            this.q.J().a(bik.b);
            att.a();
            this.q.C.c("terrain");
            renderglobal.a(entitylivingbase, 0, (double)par1);
            GL11.glShadeModel((int)7424);
            if (this.n == 0) {
                att.b();
                this.q.C.c("entities");
                ForgeHooksClient.setRenderPass((int)0);
                renderglobal.a(entitylivingbase.l(par1), (bft)frustrum, par1);
                ForgeHooksClient.setRenderPass((int)0);
                if (this.q.t != null && entitylivingbase.a(akc.h) && entitylivingbase instanceof uf && !this.q.u.Z) {
                    uf entityplayer = (uf)entitylivingbase;
                    GL11.glDisable((int)3008);
                    this.q.C.c("outline");
                    if (!ForgeHooksClient.onDrawBlockHighlight((bfl)renderglobal, (uf)entityplayer, (ata)this.q.t, (int)0, (ye)entityplayer.bn.h(), (float)par1)) {
                        renderglobal.a(entityplayer, this.q.t, 0, par1);
                    }
                    GL11.glEnable((int)3008);
                }
            }
            GL11.glDisable((int)3042);
            GL11.glEnable((int)2884);
            GL11.glBlendFunc((int)770, (int)771);
            GL11.glDepthMask((boolean)true);
            this.a(0, par1);
            GL11.glEnable((int)3042);
            GL11.glDisable((int)2884);
            this.q.J().a(bik.b);
            if (this.q.u.j) {
                this.q.C.c("water");
                if (this.q.u.k != 0) {
                    GL11.glShadeModel((int)7425);
                }
                GL11.glColorMask((boolean)false, (boolean)false, (boolean)false, (boolean)false);
                int l2 = renderglobal.a(entitylivingbase, 1, (double)par1);
                if (this.q.u.g) {
                    if (b == 0) {
                        GL11.glColorMask((boolean)false, (boolean)true, (boolean)true, (boolean)true);
                    } else {
                        GL11.glColorMask((boolean)true, (boolean)false, (boolean)false, (boolean)true);
                    }
                } else {
                    GL11.glColorMask((boolean)true, (boolean)true, (boolean)true, (boolean)true);
                }
                if (l2 > 0) {
                    renderglobal.a(1, (double)par1);
                }
                GL11.glShadeModel((int)7424);
            } else {
                this.q.C.c("water");
                renderglobal.a(entitylivingbase, 1, (double)par1);
            }
            if (this.n == 0) {
                att.b();
                this.q.C.c("entities");
                ForgeHooksClient.setRenderPass((int)1);
                renderglobal.a(entitylivingbase.l(par1), (bft)frustrum, par1);
                ForgeHooksClient.setRenderPass((int)-1);
                att.a();
            }
            GL11.glDepthMask((boolean)true);
            GL11.glEnable((int)2884);
            GL11.glDisable((int)3042);
            if (this.Y == 1.0 && entitylivingbase instanceof uf && !this.q.u.Z && this.q.t != null && !entitylivingbase.a(akc.h)) {
                uf entityplayer = (uf)entitylivingbase;
                GL11.glDisable((int)3008);
                this.q.C.c("outline");
                if (!ForgeHooksClient.onDrawBlockHighlight((bfl)renderglobal, (uf)entityplayer, (ata)this.q.t, (int)0, (ye)entityplayer.bn.h(), (float)par1)) {
                    renderglobal.a(entityplayer, this.q.t, 0, par1);
                }
                GL11.glEnable((int)3008);
            }
            this.q.C.c("destroyProgress");
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)1);
            renderglobal.drawBlockDamageTexture(bfq.a, entitylivingbase, par1);
            GL11.glDisable((int)3042);
            this.q.C.c("weather");
            this.d(par1);
            GL11.glDisable((int)2912);
            if (entitylivingbase.v >= 128.0) {
                this.a(renderglobal, par1);
            }
            this.b((double)par1);
            this.q.C.c("litParticles");
            effectrenderer.b(entitylivingbase, par1);
            att.a();
            this.a(0, par1);
            this.q.C.c("particles");
            effectrenderer.a(entitylivingbase, par1);
            this.a((double)par1);
            this.q.C.c("FRenderLast");
            ForgeHooksClient.dispatchRenderLast((bfl)renderglobal, (float)par1);
            this.q.C.c("hand");
            if (this.Y == 1.0) {
                GL11.glClear((int)256);
                this.b(par1, j2);
            }
            if (this.q.u.g) continue;
            this.q.C.b();
            return;
        }
        GL11.glColorMask((boolean)true, (boolean)true, (boolean)true, (boolean)false);
        this.q.C.b();
    }

    private void a(bfl par1RenderGlobal, float par2) {
        if (this.q.u.d()) {
            this.q.C.c("clouds");
            GL11.glPushMatrix();
            this.a(0, par2);
            GL11.glEnable((int)2912);
            par1RenderGlobal.b(par2);
            GL11.glDisable((int)2912);
            this.a(1, par2);
            GL11.glPopMatrix();
        }
    }

    private void g() {
        float f2 = this.q.f.i(1.0f);
        if (!this.q.u.j) {
            f2 /= 2.0f;
        }
        if (f2 != 0.0f) {
            this.ae.setSeed((long)this.s * 312987231L);
            of entitylivingbase = this.q.i;
            bdd worldclient = this.q.f;
            int i2 = ls.c(entitylivingbase.u);
            int j2 = ls.c(entitylivingbase.v);
            int k = ls.c(entitylivingbase.w);
            int b0 = 10;
            double d0 = 0.0;
            double d1 = 0.0;
            double d2 = 0.0;
            int l2 = 0;
            int i1 = (int)(100.0f * f2 * f2);
            if (this.q.u.am == 1) {
                i1 >>= 1;
            } else if (this.q.u.am == 2) {
                i1 = 0;
            }
            for (int j1 = 0; j1 < i1; ++j1) {
                int k1 = i2 + this.ae.nextInt(b0) - this.ae.nextInt(b0);
                int l1 = k + this.ae.nextInt(b0) - this.ae.nextInt(b0);
                int i22 = worldclient.h(k1, l1);
                int j22 = worldclient.a(k1, i22 - 1, l1);
                acq biomegenbase = worldclient.a(k1, l1);
                if (i22 > j2 + b0 || i22 < j2 - b0 || !biomegenbase.d() || !(biomegenbase.j() >= 0.2f)) continue;
                float f1 = this.ae.nextFloat();
                float f22 = this.ae.nextFloat();
                if (j22 <= 0) continue;
                if (aqz.s[j22].cU == akc.i) {
                    this.q.k.a((beg)new bel((abw)worldclient, (double)((float)k1 + f1), (double)((float)i22 + 0.1f) - aqz.s[j22].w(), (double)((float)l1 + f22), 0.0, 0.0, 0.0));
                    continue;
                }
                if (this.ae.nextInt(++l2) == 0) {
                    d0 = (float)k1 + f1;
                    d1 = (double)((float)i22 + 0.1f) - aqz.s[j22].w();
                    d2 = (float)l1 + f22;
                }
                this.q.k.a((beg)new bet((abw)worldclient, (double)((float)k1 + f1), (double)((float)i22 + 0.1f) - aqz.s[j22].w(), (double)((float)l1 + f22)));
            }
            if (l2 > 0 && this.ae.nextInt(3) < this.af++) {
                this.af = 0;
                if (d1 > entitylivingbase.v + 1.0 && worldclient.h(ls.c(entitylivingbase.u), ls.c(entitylivingbase.w)) > ls.c(entitylivingbase.v)) {
                    this.q.f.a(d0, d1, d2, "ambient.weather.rain", 0.1f, 0.5f, false);
                } else {
                    this.q.f.a(d0, d1, d2, "ambient.weather.rain", 0.2f, 1.0f, false);
                }
            }
        }
    }

    protected void d(float par1) {
        float f1 = this.q.f.i(par1);
        if (f1 > 0.0f) {
            this.b((double)par1);
            if (this.h == null) {
                this.h = new float[1024];
                this.i = new float[1024];
                for (int i2 = 0; i2 < 32; ++i2) {
                    for (int j2 = 0; j2 < 32; ++j2) {
                        float f2 = j2 - 16;
                        float f3 = i2 - 16;
                        float f4 = ls.c(f2 * f2 + f3 * f3);
                        this.h[i2 << 5 | j2] = -f3 / f4;
                        this.i[i2 << 5 | j2] = f2 / f4;
                    }
                }
            }
            of entitylivingbase = this.q.i;
            bdd worldclient = this.q.f;
            int k = ls.c(entitylivingbase.u);
            int l2 = ls.c(entitylivingbase.v);
            int i1 = ls.c(entitylivingbase.w);
            bfq tessellator = bfq.a;
            GL11.glDisable((int)2884);
            GL11.glNormal3f((float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)771);
            GL11.glAlphaFunc((int)516, (float)0.01f);
            this.q.J().a(p);
            double d0 = entitylivingbase.U + (entitylivingbase.u - entitylivingbase.U) * (double)par1;
            double d1 = entitylivingbase.V + (entitylivingbase.v - entitylivingbase.V) * (double)par1;
            double d2 = entitylivingbase.W + (entitylivingbase.w - entitylivingbase.W) * (double)par1;
            int j1 = ls.c(d1);
            int b0 = 5;
            if (this.q.u.j) {
                b0 = 10;
            }
            boolean flag = false;
            int b1 = -1;
            float f5 = (float)this.s + par1;
            if (this.q.u.j) {
                b0 = 10;
            }
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            flag = false;
            for (int k1 = i1 - b0; k1 <= i1 + b0; ++k1) {
                for (int l1 = k - b0; l1 <= k + b0; ++l1) {
                    double d3;
                    float f10;
                    int i2 = (k1 - i1 + 16) * 32 + l1 - k + 16;
                    float f6 = this.h[i2] * 0.5f;
                    float f7 = this.i[i2] * 0.5f;
                    acq biomegenbase = worldclient.a(l1, k1);
                    if (!biomegenbase.d() && !biomegenbase.c()) continue;
                    int j2 = worldclient.h(l1, k1);
                    int k2 = l2 - b0;
                    int l22 = l2 + b0;
                    if (k2 < j2) {
                        k2 = j2;
                    }
                    if (l22 < j2) {
                        l22 = j2;
                    }
                    float f8 = 1.0f;
                    int i3 = j2;
                    if (j2 < j1) {
                        i3 = j1;
                    }
                    if (k2 == l22) continue;
                    this.ae.setSeed(l1 * l1 * 3121 + l1 * 45238971 ^ k1 * k1 * 418711 + k1 * 13761);
                    float f9 = biomegenbase.j();
                    if (worldclient.u().a(f9, j2) >= 0.15f) {
                        if (b1 != 0) {
                            if (b1 >= 0) {
                                tessellator.a();
                            }
                            b1 = 0;
                            this.q.J().a(o);
                            tessellator.b();
                        }
                        f10 = ((float)(this.s + l1 * l1 * 3121 + l1 * 45238971 + k1 * k1 * 418711 + k1 * 13761 & 0x1F) + par1) / 32.0f * (3.0f + this.ae.nextFloat());
                        double d4 = (double)((float)l1 + 0.5f) - entitylivingbase.u;
                        d3 = (double)((float)k1 + 0.5f) - entitylivingbase.w;
                        float f11 = ls.a(d4 * d4 + d3 * d3) / (float)b0;
                        float f12 = 1.0f;
                        tessellator.c(worldclient.h(l1, i3, k1, 0));
                        tessellator.a(f12, f12, f12, ((1.0f - f11 * f11) * 0.5f + 0.5f) * f1);
                        tessellator.b(-d0 * 1.0, -d1 * 1.0, -d2 * 1.0);
                        tessellator.a((double)((float)l1 - f6) + 0.5, k2, (double)((float)k1 - f7) + 0.5, 0.0f * f8, (float)k2 * f8 / 4.0f + f10 * f8);
                        tessellator.a((double)((float)l1 + f6) + 0.5, k2, (double)((float)k1 + f7) + 0.5, 1.0f * f8, (float)k2 * f8 / 4.0f + f10 * f8);
                        tessellator.a((double)((float)l1 + f6) + 0.5, l22, (double)((float)k1 + f7) + 0.5, 1.0f * f8, (float)l22 * f8 / 4.0f + f10 * f8);
                        tessellator.a((double)((float)l1 - f6) + 0.5, l22, (double)((float)k1 - f7) + 0.5, 0.0f * f8, (float)l22 * f8 / 4.0f + f10 * f8);
                        tessellator.b(0.0, 0.0, 0.0);
                        continue;
                    }
                    if (b1 != 1) {
                        if (b1 >= 0) {
                            tessellator.a();
                        }
                        b1 = 1;
                        this.q.J().a(new bjo("textures/environment/snow.png"));
                        tessellator.b();
                    }
                    f10 = ((float)(this.s & 0x1FF) + par1) / 512.0f;
                    float f13 = this.ae.nextFloat() + f5 * 0.01f * (float)this.ae.nextGaussian();
                    float f14 = this.ae.nextFloat() + f5 * (float)this.ae.nextGaussian() * 0.001f;
                    d3 = (double)((float)l1 + 0.5f) - entitylivingbase.u;
                    double d5 = (double)((float)k1 + 0.5f) - entitylivingbase.w;
                    float f15 = ls.a(d3 * d3 + d5 * d5) / (float)b0;
                    float f16 = 1.0f;
                    tessellator.c((worldclient.h(l1, i3, k1, 0) * 3 + 0xF000F0) / 4);
                    tessellator.a(f16, f16, f16, ((1.0f - f15 * f15) * 0.3f + 0.5f) * f1);
                    tessellator.b(-d0 * 1.0, -d1 * 1.0, -d2 * 1.0);
                    tessellator.a((double)((float)l1 - f6) + 0.5, k2, (double)((float)k1 - f7) + 0.5, 0.0f * f8 + f13, (float)k2 * f8 / 4.0f + f10 * f8 + f14);
                    tessellator.a((double)((float)l1 + f6) + 0.5, k2, (double)((float)k1 + f7) + 0.5, 1.0f * f8 + f13, (float)k2 * f8 / 4.0f + f10 * f8 + f14);
                    tessellator.a((double)((float)l1 + f6) + 0.5, l22, (double)((float)k1 + f7) + 0.5, 1.0f * f8 + f13, (float)l22 * f8 / 4.0f + f10 * f8 + f14);
                    tessellator.a((double)((float)l1 - f6) + 0.5, l22, (double)((float)k1 - f7) + 0.5, 0.0f * f8 + f13, (float)l22 * f8 / 4.0f + f10 * f8 + f14);
                    tessellator.b(0.0, 0.0, 0.0);
                }
            }
            if (b1 >= 0) {
                tessellator.a();
            }
            GL11.glEnable((int)2884);
            GL11.glDisable((int)3042);
            GL11.glAlphaFunc((int)516, (float)0.1f);
            this.a((double)par1);
        }
    }

    public void c() {
        awf scaledresolution = new awf(this.q.u, this.q.d, this.q.e);
        GL11.glClear((int)256);
        GL11.glMatrixMode((int)5889);
        GL11.glLoadIdentity();
        GL11.glOrtho((double)0.0, (double)scaledresolution.c(), (double)scaledresolution.d(), (double)0.0, (double)1000.0, (double)3000.0);
        GL11.glMatrixMode((int)5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef((float)0.0f, (float)0.0f, (float)-2000.0f);
    }

    private void i(float par1) {
        float f10;
        float f8;
        float f5;
        bdd worldclient = this.q.f;
        of entitylivingbase = this.q.i;
        float f1 = 1.0f / (float)(4 - this.q.u.e);
        f1 = 1.0f - (float)Math.pow(f1, 0.25);
        atc vec3 = worldclient.a((nn)this.q.i, par1);
        float f2 = (float)vec3.c;
        float f3 = (float)vec3.d;
        float f4 = (float)vec3.e;
        atc vec31 = worldclient.f(par1);
        this.k = (float)vec31.c;
        this.l = (float)vec31.d;
        this.m = (float)vec31.e;
        if (this.q.u.e < 2) {
            float[] afloat;
            atc vec32 = ls.a(worldclient.d(par1)) > 0.0f ? worldclient.V().a(-1.0, 0.0, 0.0) : worldclient.V().a(1.0, 0.0, 0.0);
            f5 = (float)entitylivingbase.j(par1).b(vec32);
            if (f5 < 0.0f) {
                f5 = 0.0f;
            }
            if (f5 > 0.0f && (afloat = worldclient.t.a(worldclient.c(par1), par1)) != null) {
                this.k = this.k * (1.0f - (f5 *= afloat[3])) + afloat[0] * f5;
                this.l = this.l * (1.0f - f5) + afloat[1] * f5;
                this.m = this.m * (1.0f - f5) + afloat[2] * f5;
            }
        }
        this.k += (f2 - this.k) * f1;
        this.l += (f3 - this.l) * f1;
        this.m += (f4 - this.m) * f1;
        float f6 = worldclient.i(par1);
        if (f6 > 0.0f) {
            f5 = 1.0f - f6 * 0.5f;
            float f7 = 1.0f - f6 * 0.4f;
            this.k *= f5;
            this.l *= f5;
            this.m *= f7;
        }
        if ((f5 = worldclient.h(par1)) > 0.0f) {
            float f7 = 1.0f - f5 * 0.5f;
            this.k *= f7;
            this.l *= f7;
            this.m *= f7;
        }
        int i2 = atp.a((abw)this.q.f, entitylivingbase, par1);
        if (this.X) {
            atc vec33 = worldclient.e(par1);
            this.k = (float)vec33.c;
            this.l = (float)vec33.d;
            this.m = (float)vec33.e;
        } else if (i2 != 0 && aqz.s[i2].cU == akc.h) {
            f8 = (float)aaw.b((of)entitylivingbase) * 0.2f;
            this.k = 0.02f + f8;
            this.l = 0.02f + f8;
            this.m = 0.2f + f8;
        } else if (i2 != 0 && aqz.s[i2].cU == akc.i) {
            this.k = 0.6f;
            this.l = 0.1f;
            this.m = 0.0f;
        }
        f8 = this.ag + (this.ah - this.ag) * par1;
        this.k *= f8;
        this.l *= f8;
        this.m *= f8;
        double d0 = (entitylivingbase.V + (entitylivingbase.v - entitylivingbase.V) * (double)par1) * worldclient.t.k();
        if (entitylivingbase.a(ni.q)) {
            int j2 = entitylivingbase.b(ni.q).b();
            d0 = j2 < 20 ? (d0 *= (double)(1.0f - (float)j2 / 20.0f)) : 0.0;
        }
        if (d0 < 1.0) {
            if (d0 < 0.0) {
                d0 = 0.0;
            }
            d0 *= d0;
            this.k = (float)((double)this.k * d0);
            this.l = (float)((double)this.l * d0);
            this.m = (float)((double)this.m * d0);
        }
        if (this.V > 0.0f) {
            float f9 = this.W + (this.V - this.W) * par1;
            this.k = this.k * (1.0f - f9) + this.k * 0.7f * f9;
            this.l = this.l * (1.0f - f9) + this.l * 0.6f * f9;
            this.m = this.m * (1.0f - f9) + this.m * 0.6f * f9;
        }
        if (entitylivingbase.a(ni.r)) {
            float f9 = this.a((uf)this.q.h, par1);
            f10 = 1.0f / this.k;
            if (f10 > 1.0f / this.l) {
                f10 = 1.0f / this.l;
            }
            if (f10 > 1.0f / this.m) {
                f10 = 1.0f / this.m;
            }
            this.k = this.k * (1.0f - f9) + this.k * f10 * f9;
            this.l = this.l * (1.0f - f9) + this.l * f10 * f9;
            this.m = this.m * (1.0f - f9) + this.m * f10 * f9;
        }
        if (this.q.u.g) {
            float f9 = (this.k * 30.0f + this.l * 59.0f + this.m * 11.0f) / 100.0f;
            f10 = (this.k * 30.0f + this.l * 70.0f) / 100.0f;
            float f11 = (this.k * 30.0f + this.m * 70.0f) / 100.0f;
            this.k = f9;
            this.l = f10;
            this.m = f11;
        }
        GL11.glClearColor((float)this.k, (float)this.l, (float)this.m, (float)0.0f);
    }

    private void a(int par1, float par2) {
        of entitylivingbase = this.q.i;
        boolean flag = false;
        if (entitylivingbase instanceof uf) {
            flag = ((uf)entitylivingbase).bG.d;
        }
        if (par1 == 999) {
            GL11.glFog((int)2918, (FloatBuffer)this.a(0.0f, 0.0f, 0.0f, 1.0f));
            GL11.glFogi((int)2917, (int)9729);
            GL11.glFogf((int)2915, (float)0.0f);
            GL11.glFogf((int)2916, (float)8.0f);
            if (GLContext.getCapabilities().GL_NV_fog_distance) {
                GL11.glFogi((int)34138, (int)34139);
            }
            GL11.glFogf((int)2915, (float)0.0f);
        } else {
            GL11.glFog((int)2918, (FloatBuffer)this.a(this.k, this.l, this.m, 1.0f));
            GL11.glNormal3f((float)0.0f, (float)-1.0f, (float)0.0f);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            int j2 = atp.a((abw)this.q.f, entitylivingbase, par2);
            if (entitylivingbase.a(ni.q)) {
                float f1 = 5.0f;
                int k = entitylivingbase.b(ni.q).b();
                if (k < 20) {
                    f1 = 5.0f + (this.r - 5.0f) * (1.0f - (float)k / 20.0f);
                }
                GL11.glFogi((int)2917, (int)9729);
                if (par1 < 0) {
                    GL11.glFogf((int)2915, (float)0.0f);
                    GL11.glFogf((int)2916, (float)(f1 * 0.8f));
                } else {
                    GL11.glFogf((int)2915, (float)(f1 * 0.25f));
                    GL11.glFogf((int)2916, (float)f1);
                }
                if (GLContext.getCapabilities().GL_NV_fog_distance) {
                    GL11.glFogi((int)34138, (int)34139);
                }
            } else if (this.X) {
                GL11.glFogi((int)2917, (int)2048);
                GL11.glFogf((int)2914, (float)0.1f);
            } else if (j2 > 0 && aqz.s[j2].cU == akc.h) {
                GL11.glFogi((int)2917, (int)2048);
                if (entitylivingbase.a(ni.o)) {
                    GL11.glFogf((int)2914, (float)0.05f);
                } else {
                    GL11.glFogf((int)2914, (float)(0.1f - (float)aaw.b((of)entitylivingbase) * 0.03f));
                }
            } else if (j2 > 0 && aqz.s[j2].cU == akc.i) {
                GL11.glFogi((int)2917, (int)2048);
                GL11.glFogf((int)2914, (float)2.0f);
            } else {
                double d0;
                float f1 = this.r;
                if (this.q.f.t.j() && !flag && (d0 = (double)((entitylivingbase.c(par2) & 0xF00000) >> 20) / 16.0 + (entitylivingbase.V + (entitylivingbase.v - entitylivingbase.V) * (double)par2 + 4.0) / 32.0) < 1.0) {
                    float f2;
                    if (d0 < 0.0) {
                        d0 = 0.0;
                    }
                    if ((f2 = 100.0f * (float)(d0 *= d0)) < 5.0f) {
                        f2 = 5.0f;
                    }
                    if (f1 > f2) {
                        f1 = f2;
                    }
                }
                GL11.glFogi((int)2917, (int)9729);
                if (par1 < 0) {
                    GL11.glFogf((int)2915, (float)0.0f);
                    GL11.glFogf((int)2916, (float)(f1 * 0.8f));
                } else {
                    GL11.glFogf((int)2915, (float)(f1 * 0.25f));
                    GL11.glFogf((int)2916, (float)f1);
                }
                if (GLContext.getCapabilities().GL_NV_fog_distance) {
                    GL11.glFogi((int)34138, (int)34139);
                }
                if (this.q.f.t.b((int)entitylivingbase.u, (int)entitylivingbase.w)) {
                    GL11.glFogf((int)2915, (float)(f1 * 0.05f));
                    GL11.glFogf((int)2916, (float)(Math.min(f1, 192.0f) * 0.5f));
                }
            }
            GL11.glEnable((int)2903);
            GL11.glColorMaterial((int)1028, (int)4608);
        }
    }

    private FloatBuffer a(float par1, float par2, float par3, float par4) {
        this.j.clear();
        this.j.put(par1).put(par2).put(par3).put(par4);
        this.j.flip();
        return this.j;
    }

    public static int a(int par0) {
        int short1 = 200;
        if (par0 == 1) {
            short1 = 120;
        }
        if (par0 == 2) {
            short1 = 35;
        }
        return short1;
    }

    static atv a(bfe par0EntityRenderer) {
        return par0EntityRenderer.q;
    }
}

