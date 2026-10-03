/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  abg
 *  abr
 *  akc
 *  ard
 *  asx
 *  ata
 *  atc
 *  bu
 *  cb
 *  cd
 *  cl
 *  cpw.mods.fml.common.FMLLog
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  nb
 *  net.minecraft.server.MinecraftServer
 *  net.minecraftforge.common.IExtendedEntityProperties
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.Event
 *  net.minecraftforge.event.entity.EntityEvent$EntityConstructing
 *  no
 *  np
 *  od
 *  ol
 *  r
 *  sp
 *  t
 *  u
 */
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.IExtendedEntityProperties;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.entity.EntityEvent;

public abstract class nn {
    private static int b;
    public int k;
    public double l = 1.0;
    public boolean m;
    public nn n;
    public nn o;
    public boolean p;
    public abw q;
    public double r;
    public double s;
    public double t;
    public double u;
    public double v;
    public double w;
    public double x;
    public double y;
    public double z;
    public float A;
    public float B;
    public float C;
    public float D;
    public final asx E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    protected boolean K;
    public boolean L = true;
    public boolean M;
    public float N;
    public float O = 0.6f;
    public float P = 1.8f;
    public float Q;
    public float R;
    public float S;
    public float T;
    private int c = 1;
    public double U;
    public double V;
    public double W;
    public float X;
    public float Y;
    public boolean Z;
    public float aa;
    protected Random ab;
    public int ac;
    public int ad = 1;
    private int d;
    protected boolean ae;
    public int af;
    private boolean e = true;
    protected boolean ag;
    protected oo ah;
    private double f;
    private double g;
    public boolean ai;
    public int aj;
    public int ak;
    public int al;
    @SideOnly(value=Side.CLIENT)
    public int bZ;
    @SideOnly(value=Side.CLIENT)
    public int ca;
    @SideOnly(value=Side.CLIENT)
    public int cb;
    public boolean am;
    public boolean an;
    public int ao;
    protected boolean ap;
    protected int aq;
    public int ar;
    protected int as;
    private boolean h;
    private UUID i;
    public nr at;
    private by customEntityData;
    public boolean captureDrops = false;
    public ArrayList<ss> capturedDrops = new ArrayList();
    private UUID persistentID;
    private HashMap<String, IExtendedEntityProperties> extendedProperties;

    public nn(abw par1World) {
        this.k = b++;
        this.E = asx.a((double)0.0, (double)0.0, (double)0.0, (double)0.0, (double)0.0, (double)0.0);
        this.ab = new Random();
        this.ah = new oo();
        this.i = UUID.randomUUID();
        this.at = nr.b;
        this.q = par1World;
        this.b(0.0, 0.0, 0.0);
        if (par1World != null) {
            this.ar = par1World.t.i;
        }
        this.ah.a(0, (Object)0);
        this.ah.a(1, (Object)300);
        this.a();
        this.extendedProperties = new HashMap();
        MinecraftForge.EVENT_BUS.post((Event)new EntityEvent.EntityConstructing(this));
        for (IExtendedEntityProperties props : this.extendedProperties.values()) {
            props.init(this, par1World);
        }
    }

    protected abstract void a();

    public oo v() {
        return this.ah;
    }

    public boolean equals(Object par1Obj) {
        return par1Obj instanceof nn ? ((nn)par1Obj).k == this.k : false;
    }

    public int hashCode() {
        return this.k;
    }

    @SideOnly(value=Side.CLIENT)
    protected void w() {
        if (this.q != null) {
            while (this.v > 0.0) {
                this.b(this.u, this.v, this.w);
                if (this.q.a(this, this.E).isEmpty()) break;
                this.v += 1.0;
            }
            this.z = 0.0;
            this.y = 0.0;
            this.x = 0.0;
            this.B = 0.0f;
        }
    }

    public void x() {
        this.M = true;
    }

    protected void a(float par1, float par2) {
        float f2;
        if (par1 != this.O || par2 != this.P) {
            f2 = this.O;
            this.O = par1;
            this.P = par2;
            this.E.d = this.E.a + (double)this.O;
            this.E.f = this.E.c + (double)this.O;
            this.E.e = this.E.b + (double)this.P;
            if (this.O > f2 && !this.e && !this.q.I) {
                this.d(f2 - this.O, 0.0, f2 - this.O);
            }
        }
        this.at = (double)(f2 = par1 % 2.0f) < 0.375 ? nr.a : ((double)f2 < 0.75 ? nr.b : ((double)f2 < 1.0 ? nr.c : ((double)f2 < 1.375 ? nr.d : ((double)f2 < 1.75 ? nr.e : nr.f))));
    }

    protected void b(float par1, float par2) {
        this.A = par1 % 360.0f;
        this.B = par2 % 360.0f;
    }

    public void b(double par1, double par3, double par5) {
        this.u = par1;
        this.v = par3;
        this.w = par5;
        float f2 = this.O / 2.0f;
        float f1 = this.P;
        this.E.b(par1 - (double)f2, par3 - (double)this.N + (double)this.X, par5 - (double)f2, par1 + (double)f2, par3 - (double)this.N + (double)this.X + (double)f1, par5 + (double)f2);
    }

    @SideOnly(value=Side.CLIENT)
    public void c(float par1, float par2) {
        float f2 = this.B;
        float f3 = this.A;
        this.A = (float)((double)this.A + (double)par1 * 0.15);
        this.B = (float)((double)this.B - (double)par2 * 0.15);
        if (this.B < -90.0f) {
            this.B = -90.0f;
        }
        if (this.B > 90.0f) {
            this.B = 90.0f;
        }
        this.D += this.B - f2;
        this.C += this.A - f3;
    }

    public void l_() {
        this.y();
    }

    public void y() {
        int k2;
        int j2;
        int l2;
        int i2;
        this.q.C.a("entityBaseTick");
        if (this.o != null && this.o.M) {
            this.o = null;
        }
        this.Q = this.R;
        this.r = this.u;
        this.s = this.v;
        this.t = this.w;
        this.D = this.B;
        this.C = this.A;
        if (!this.q.I && this.q instanceof js) {
            this.q.C.a("portal");
            MinecraftServer minecraftserver = ((js)this.q).p();
            i2 = this.z();
            if (this.ap) {
                if (minecraftserver.u()) {
                    if (this.o == null && this.aq++ >= i2) {
                        this.aq = i2;
                        this.ao = this.ac();
                        int b0 = this.q.t.i == -1 ? 0 : -1;
                        this.b(b0);
                    }
                    this.ap = false;
                }
            } else {
                if (this.aq > 0) {
                    this.aq -= 4;
                }
                if (this.aq < 0) {
                    this.aq = 0;
                }
            }
            if (this.ao > 0) {
                --this.ao;
            }
            this.q.C.b();
        }
        if (this.ai() && !this.H() && (l2 = this.q.a(j2 = ls.c(this.u), i2 = ls.c(this.v - (double)0.2f - (double)this.N), k2 = ls.c(this.w))) > 0) {
            this.q.a("tilecrack_" + l2 + "_" + this.q.h(j2, i2, k2), this.u + ((double)this.ab.nextFloat() - 0.5) * (double)this.O, this.E.b + 0.1, this.w + ((double)this.ab.nextFloat() - 0.5) * (double)this.O, -this.x * 4.0, 1.5, -this.z * 4.0);
        }
        this.I();
        if (this.q.I) {
            this.d = 0;
        } else if (this.d > 0) {
            if (this.ag) {
                this.d -= 4;
                if (this.d < 0) {
                    this.d = 0;
                }
            } else {
                if (this.d % 20 == 0) {
                    this.a(nb.b, 1.0f);
                }
                --this.d;
            }
        }
        if (this.J()) {
            this.A();
            this.T *= 0.5f;
        }
        if (this.v < -64.0) {
            this.C();
        }
        if (!this.q.I) {
            this.a(0, this.d > 0);
        }
        this.e = false;
        this.q.C.b();
    }

    public int z() {
        return 0;
    }

    protected void A() {
        if (!this.ag) {
            this.a(nb.c, 4.0f);
            this.d(15);
        }
    }

    public void d(int par1) {
        int j2 = par1 * 20;
        if (this.d < (j2 = abg.a((nn)this, (int)j2))) {
            this.d = j2;
        }
    }

    public void B() {
        this.d = 0;
    }

    protected void C() {
        this.x();
    }

    public boolean c(double par1, double par3, double par5) {
        asx axisalignedbb = this.E.c(par1, par3, par5);
        List list = this.q.a(this, axisalignedbb);
        return !list.isEmpty() ? false : !this.q.d(axisalignedbb);
    }

    public void d(double par1, double par3, double par5) {
        if (this.Z) {
            this.E.d(par1, par3, par5);
            this.u = (this.E.a + this.E.d) / 2.0;
            this.v = this.E.b + (double)this.N - (double)this.X;
            this.w = (this.E.c + this.E.f) / 2.0;
        } else {
            int k2;
            double d11;
            double d10;
            double d12;
            int j2;
            boolean flag;
            this.q.C.a("move");
            this.X *= 0.4f;
            double d3 = this.u;
            double d4 = this.v;
            double d5 = this.w;
            if (this.K) {
                this.K = false;
                par1 *= 0.25;
                par3 *= (double)0.05f;
                par5 *= 0.25;
                this.x = 0.0;
                this.y = 0.0;
                this.z = 0.0;
            }
            double d6 = par1;
            double d7 = par3;
            double d8 = par5;
            asx axisalignedbb = this.E.c();
            boolean bl2 = flag = this.F && this.ah() && this instanceof uf;
            if (flag) {
                double d9 = 0.05;
                while (par1 != 0.0 && this.q.a(this, this.E.c(par1, -1.0, 0.0)).isEmpty()) {
                    par1 = par1 < d9 && par1 >= -d9 ? 0.0 : (par1 > 0.0 ? (par1 -= d9) : (par1 += d9));
                    d6 = par1;
                }
                while (par5 != 0.0 && this.q.a(this, this.E.c(0.0, -1.0, par5)).isEmpty()) {
                    par5 = par5 < d9 && par5 >= -d9 ? 0.0 : (par5 > 0.0 ? (par5 -= d9) : (par5 += d9));
                    d8 = par5;
                }
                while (par1 != 0.0 && par5 != 0.0 && this.q.a(this, this.E.c(par1, -1.0, par5)).isEmpty()) {
                    par1 = par1 < d9 && par1 >= -d9 ? 0.0 : (par1 > 0.0 ? (par1 -= d9) : (par1 += d9));
                    par5 = par5 < d9 && par5 >= -d9 ? 0.0 : (par5 > 0.0 ? (par5 -= d9) : (par5 += d9));
                    d6 = par1;
                    d8 = par5;
                }
            }
            List list = this.q.a(this, this.E.a(par1, par3, par5));
            for (int i2 = 0; i2 < list.size(); ++i2) {
                par3 = ((asx)list.get(i2)).b(this.E, par3);
            }
            this.E.d(0.0, par3, 0.0);
            if (!this.L && d7 != par3) {
                par5 = 0.0;
                par3 = 0.0;
                par1 = 0.0;
            }
            boolean flag1 = this.F || d7 != par3 && d7 < 0.0;
            for (j2 = 0; j2 < list.size(); ++j2) {
                par1 = ((asx)list.get(j2)).a(this.E, par1);
            }
            this.E.d(par1, 0.0, 0.0);
            if (!this.L && d6 != par1) {
                par5 = 0.0;
                par3 = 0.0;
                par1 = 0.0;
            }
            for (j2 = 0; j2 < list.size(); ++j2) {
                par5 = ((asx)list.get(j2)).c(this.E, par5);
            }
            this.E.d(0.0, 0.0, par5);
            if (!this.L && d8 != par5) {
                par5 = 0.0;
                par3 = 0.0;
                par1 = 0.0;
            }
            if (this.Y > 0.0f && flag1 && (flag || this.X < 0.05f) && (d6 != par1 || d8 != par5)) {
                d12 = par1;
                d10 = par3;
                d11 = par5;
                par1 = d6;
                par3 = this.Y;
                par5 = d8;
                asx axisalignedbb1 = this.E.c();
                this.E.d(axisalignedbb);
                list = this.q.a(this, this.E.a(d6, par3, d8));
                for (k2 = 0; k2 < list.size(); ++k2) {
                    par3 = ((asx)list.get(k2)).b(this.E, par3);
                }
                this.E.d(0.0, par3, 0.0);
                if (!this.L && d7 != par3) {
                    par5 = 0.0;
                    par3 = 0.0;
                    par1 = 0.0;
                }
                for (k2 = 0; k2 < list.size(); ++k2) {
                    par1 = ((asx)list.get(k2)).a(this.E, par1);
                }
                this.E.d(par1, 0.0, 0.0);
                if (!this.L && d6 != par1) {
                    par5 = 0.0;
                    par3 = 0.0;
                    par1 = 0.0;
                }
                for (k2 = 0; k2 < list.size(); ++k2) {
                    par5 = ((asx)list.get(k2)).c(this.E, par5);
                }
                this.E.d(0.0, 0.0, par5);
                if (!this.L && d8 != par5) {
                    par5 = 0.0;
                    par3 = 0.0;
                    par1 = 0.0;
                }
                if (!this.L && d7 != par3) {
                    par5 = 0.0;
                    par3 = 0.0;
                    par1 = 0.0;
                } else {
                    par3 = -this.Y;
                    for (k2 = 0; k2 < list.size(); ++k2) {
                        par3 = ((asx)list.get(k2)).b(this.E, par3);
                    }
                    this.E.d(0.0, par3, 0.0);
                }
                if (d12 * d12 + d11 * d11 >= par1 * par1 + par5 * par5) {
                    par1 = d12;
                    par3 = d10;
                    par5 = d11;
                    this.E.d(axisalignedbb1);
                }
            }
            this.q.C.b();
            this.q.C.a("rest");
            this.u = (this.E.a + this.E.d) / 2.0;
            this.v = this.E.b + (double)this.N - (double)this.X;
            this.w = (this.E.c + this.E.f) / 2.0;
            this.G = d6 != par1 || d8 != par5;
            this.H = d7 != par3;
            this.F = d7 != par3 && d7 < 0.0;
            this.I = this.G || this.H;
            this.a(par3, this.F);
            if (d6 != par1) {
                this.x = 0.0;
            }
            if (d7 != par3) {
                this.y = 0.0;
            }
            if (d8 != par5) {
                this.z = 0.0;
            }
            d12 = this.u - d3;
            d10 = this.v - d4;
            d11 = this.w - d5;
            if (this.e_() && !flag && this.o == null) {
                int k1;
                int i1;
                int l2 = ls.c(this.u);
                int j1 = this.q.a(l2, k2 = ls.c(this.v - (double)0.2f - (double)this.N), i1 = ls.c(this.w));
                if (j1 == 0 && ((k1 = this.q.e(l2, k2 - 1, i1)) == 11 || k1 == 32 || k1 == 21)) {
                    j1 = this.q.a(l2, k2 - 1, i1);
                }
                if (j1 != aqz.aK.cF) {
                    d10 = 0.0;
                }
                this.R = (float)((double)this.R + (double)ls.a(d12 * d12 + d11 * d11) * 0.6);
                this.S = (float)((double)this.S + (double)ls.a(d12 * d12 + d10 * d10 + d11 * d11) * 0.6);
                if (this.S > (float)this.c && j1 > 0) {
                    this.c = (int)this.S + 1;
                    if (this.H()) {
                        float f2 = ls.a(this.x * this.x * (double)0.2f + this.y * this.y + this.z * this.z * (double)0.2f) * 0.35f;
                        if (f2 > 1.0f) {
                            f2 = 1.0f;
                        }
                        this.a("liquid.swim", f2, 1.0f + (this.ab.nextFloat() - this.ab.nextFloat()) * 0.4f);
                    }
                    this.a(l2, k2, i1, j1);
                    aqz.s[j1].b(this.q, l2, k2, i1, this);
                }
            }
            try {
                this.D();
            }
            catch (Throwable throwable) {
                b crashreport = b.a(throwable, "Checking entity tile collision");
                m crashreportcategory = crashreport.a("Entity being checked for collision");
                this.a(crashreportcategory);
                throw new u(crashreport);
            }
            boolean flag2 = this.G();
            if (this.q.e(this.E.e(0.001, 0.001, 0.001))) {
                this.e(1);
                if (!flag2) {
                    ++this.d;
                    if (this.d == 0) {
                        this.d(8);
                    }
                }
            } else if (this.d <= 0) {
                this.d = -this.ad;
            }
            if (flag2 && this.d > 0) {
                this.a("random.fizz", 0.7f, 1.6f + (this.ab.nextFloat() - this.ab.nextFloat()) * 0.4f);
                this.d = -this.ad;
            }
            this.q.C.b();
        }
    }

    protected void D() {
        int j1;
        int i1;
        int l2;
        int k2;
        int j2;
        int i2 = ls.c(this.E.a + 0.001);
        if (this.q.e(i2, j2 = ls.c(this.E.b + 0.001), k2 = ls.c(this.E.c + 0.001), l2 = ls.c(this.E.d - 0.001), i1 = ls.c(this.E.e - 0.001), j1 = ls.c(this.E.f - 0.001))) {
            for (int k1 = i2; k1 <= l2; ++k1) {
                for (int l1 = j2; l1 <= i1; ++l1) {
                    for (int i22 = k2; i22 <= j1; ++i22) {
                        int j22 = this.q.a(k1, l1, i22);
                        if (j22 <= 0) continue;
                        try {
                            aqz.s[j22].a(this.q, k1, l1, i22, this);
                            continue;
                        }
                        catch (Throwable throwable) {
                            b crashreport = b.a(throwable, "Colliding entity with tile");
                            m crashreportcategory = crashreport.a("Tile being collided with");
                            m.a(crashreportcategory, k1, l1, i22, j22, this.q.h(k1, l1, i22));
                            throw new u(crashreport);
                        }
                    }
                }
            }
        }
    }

    protected void a(int par1, int par2, int par3, int par4) {
        ard stepsound = aqz.s[par4].cS;
        if (this.q.a(par1, par2 + 1, par3) == aqz.aX.cF) {
            stepsound = aqz.aX.cS;
            this.a(stepsound.e(), stepsound.c() * 0.15f, stepsound.d());
        } else if (!aqz.s[par4].cU.d()) {
            this.a(stepsound.e(), stepsound.c() * 0.15f, stepsound.d());
        }
    }

    public void a(String par1Str, float par2, float par3) {
        this.q.a(this, par1Str, par2, par3);
    }

    protected boolean e_() {
        return true;
    }

    protected void a(double par1, boolean par3) {
        if (par3) {
            if (this.T > 0.0f) {
                this.b(this.T);
                this.T = 0.0f;
            }
        } else if (par1 < 0.0) {
            this.T = (float)((double)this.T - par1);
        }
    }

    public asx E() {
        return null;
    }

    protected void e(int par1) {
        if (!this.ag) {
            this.a(nb.a, (float)par1);
        }
    }

    public final boolean F() {
        return this.ag;
    }

    protected void b(float par1) {
        if (this.n != null) {
            this.n.b(par1);
        }
    }

    public boolean G() {
        return this.ae || this.q.F(ls.c(this.u), ls.c(this.v), ls.c(this.w)) || this.q.F(ls.c(this.u), ls.c(this.v + (double)this.P), ls.c(this.w));
    }

    public boolean H() {
        return this.ae;
    }

    public boolean I() {
        if (this.q.a(this.E.b(0.0, (double)-0.4f, 0.0).e(0.001, 0.001, 0.001), akc.h, this)) {
            if (!this.ae && !this.e) {
                float f3;
                float f2;
                float f4 = ls.a(this.x * this.x * (double)0.2f + this.y * this.y + this.z * this.z * (double)0.2f) * 0.2f;
                if (f4 > 1.0f) {
                    f4 = 1.0f;
                }
                this.a("liquid.splash", f4, 1.0f + (this.ab.nextFloat() - this.ab.nextFloat()) * 0.4f);
                float f1 = ls.c(this.E.b);
                int i2 = 0;
                while ((float)i2 < 1.0f + this.O * 20.0f) {
                    f2 = (this.ab.nextFloat() * 2.0f - 1.0f) * this.O;
                    f3 = (this.ab.nextFloat() * 2.0f - 1.0f) * this.O;
                    this.q.a("bubble", this.u + (double)f2, (double)(f1 + 1.0f), this.w + (double)f3, this.x, this.y - (double)(this.ab.nextFloat() * 0.2f), this.z);
                    ++i2;
                }
                i2 = 0;
                while ((float)i2 < 1.0f + this.O * 20.0f) {
                    f2 = (this.ab.nextFloat() * 2.0f - 1.0f) * this.O;
                    f3 = (this.ab.nextFloat() * 2.0f - 1.0f) * this.O;
                    this.q.a("splash", this.u + (double)f2, (double)(f1 + 1.0f), this.w + (double)f3, this.x, this.y, this.z);
                    ++i2;
                }
            }
            this.T = 0.0f;
            this.ae = true;
            this.d = 0;
        } else {
            this.ae = false;
        }
        return this.ae;
    }

    public boolean a(akc par1Material) {
        int k2;
        int j2;
        double d0 = this.v + (double)this.f();
        int i2 = ls.c(this.u);
        int l2 = this.q.a(i2, j2 = ls.d(ls.c(d0)), k2 = ls.c(this.w));
        aqz block = aqz.s[l2];
        if (block != null && block.cU == par1Material) {
            double filled = block.getFilledPercentage(this.q, i2, j2, k2);
            if (filled < 0.0) {
                return d0 > (double)j2 + (1.0 - (filled *= -1.0));
            }
            return d0 < (double)j2 + filled;
        }
        return false;
    }

    public float f() {
        return 0.0f;
    }

    public boolean J() {
        return this.q.a(this.E.b((double)-0.1f, (double)-0.4f, (double)-0.1f), akc.i);
    }

    public void a(float par1, float par2, float par3) {
        float f3 = par1 * par1 + par2 * par2;
        if (f3 >= 1.0E-4f) {
            if ((f3 = ls.c(f3)) < 1.0f) {
                f3 = 1.0f;
            }
            f3 = par3 / f3;
            float f4 = ls.a(this.A * (float)Math.PI / 180.0f);
            float f5 = ls.b(this.A * (float)Math.PI / 180.0f);
            this.x += (double)((par1 *= f3) * f5 - (par2 *= f3) * f4);
            this.z += (double)(par2 * f5 + par1 * f4);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public int c(float par1) {
        int j2;
        int i2 = ls.c(this.u);
        if (this.q.f(i2, 0, j2 = ls.c(this.w))) {
            double d0 = (this.E.e - this.E.b) * 0.66;
            int k2 = ls.c(this.v - (double)this.N + d0);
            return this.q.h(i2, k2, j2, 0);
        }
        return 0;
    }

    public float d(float par1) {
        int j2;
        int i2 = ls.c(this.u);
        if (this.q.f(i2, 0, j2 = ls.c(this.w))) {
            double d0 = (this.E.e - this.E.b) * 0.66;
            int k2 = ls.c(this.v - (double)this.N + d0);
            return this.q.q(i2, k2, j2);
        }
        return 0.0f;
    }

    public void a(abw par1World) {
        this.q = par1World;
    }

    public void a(double par1, double par3, double par5, float par7, float par8) {
        this.r = this.u = par1;
        this.s = this.v = par3;
        this.t = this.w = par5;
        this.C = this.A = par7;
        this.D = this.B = par8;
        this.X = 0.0f;
        double d3 = this.C - par7;
        if (d3 < -180.0) {
            this.C += 360.0f;
        }
        if (d3 >= 180.0) {
            this.C -= 360.0f;
        }
        this.b(this.u, this.v, this.w);
        this.b(par7, par8);
    }

    public void b(double par1, double par3, double par5, float par7, float par8) {
        this.r = this.u = par1;
        this.U = this.u;
        this.s = this.v = par3 + (double)this.N;
        this.V = this.v;
        this.t = this.w = par5;
        this.W = this.w;
        this.A = par7;
        this.B = par8;
        this.b(this.u, this.v, this.w);
    }

    public float d(nn par1Entity) {
        float f2 = (float)(this.u - par1Entity.u);
        float f1 = (float)(this.v - par1Entity.v);
        float f22 = (float)(this.w - par1Entity.w);
        return ls.c(f2 * f2 + f1 * f1 + f22 * f22);
    }

    public double e(double par1, double par3, double par5) {
        double d3 = this.u - par1;
        double d4 = this.v - par3;
        double d5 = this.w - par5;
        return d3 * d3 + d4 * d4 + d5 * d5;
    }

    public double f(double par1, double par3, double par5) {
        double d3 = this.u - par1;
        double d4 = this.v - par3;
        double d5 = this.w - par5;
        return ls.a(d3 * d3 + d4 * d4 + d5 * d5);
    }

    public double e(nn par1Entity) {
        double d0 = this.u - par1Entity.u;
        double d1 = this.v - par1Entity.v;
        double d2 = this.w - par1Entity.w;
        return d0 * d0 + d1 * d1 + d2 * d2;
    }

    public void b_(uf par1EntityPlayer) {
    }

    public void f(nn par1Entity) {
        double d1;
        double d0;
        double d2;
        if (par1Entity.n != this && par1Entity.o != this && (d2 = ls.a(d0 = par1Entity.u - this.u, d1 = par1Entity.w - this.w)) >= (double)0.01f) {
            d2 = ls.a(d2);
            d0 /= d2;
            d1 /= d2;
            double d3 = 1.0 / d2;
            if (d3 > 1.0) {
                d3 = 1.0;
            }
            d0 *= d3;
            d1 *= d3;
            d0 *= (double)0.05f;
            d1 *= (double)0.05f;
            this.g(-(d0 *= (double)(1.0f - this.aa)), 0.0, -(d1 *= (double)(1.0f - this.aa)));
            par1Entity.g(d0, 0.0, d1);
        }
    }

    public void g(double par1, double par3, double par5) {
        this.x += par1;
        this.y += par3;
        this.z += par5;
        this.an = true;
    }

    protected void K() {
        this.J = true;
    }

    public boolean a(nb par1DamageSource, float par2) {
        if (this.ar()) {
            return false;
        }
        this.K();
        return false;
    }

    public boolean L() {
        return false;
    }

    public boolean M() {
        return false;
    }

    public void b(nn par1Entity, int par2) {
    }

    @SideOnly(value=Side.CLIENT)
    public boolean a(atc par1Vec3) {
        double d0 = this.u - par1Vec3.c;
        double d1 = this.v - par1Vec3.d;
        double d2 = this.w - par1Vec3.e;
        double d3 = d0 * d0 + d1 * d1 + d2 * d2;
        return this.a(d3);
    }

    @SideOnly(value=Side.CLIENT)
    public boolean a(double par1) {
        double d1 = this.E.b();
        return par1 < (d1 *= 64.0 * this.l) * d1;
    }

    public boolean c(by par1NBTTagCompound) {
        String s2 = this.Q();
        if (!this.M && s2 != null) {
            par1NBTTagCompound.a("id", s2);
            this.e(par1NBTTagCompound);
            return true;
        }
        return false;
    }

    public boolean d(by par1NBTTagCompound) {
        String s2 = this.Q();
        if (!this.M && s2 != null && this.n == null) {
            par1NBTTagCompound.a("id", s2);
            this.e(par1NBTTagCompound);
            return true;
        }
        return false;
    }

    public void e(by par1NBTTagCompound) {
        try {
            by nbttagcompound1;
            par1NBTTagCompound.a("Pos", this.a(this.u, this.v + (double)this.X, this.w));
            par1NBTTagCompound.a("Motion", this.a(this.x, this.y, this.z));
            par1NBTTagCompound.a("Rotation", this.a(new float[]{this.A, this.B}));
            par1NBTTagCompound.a("FallDistance", this.T);
            par1NBTTagCompound.a("Fire", (short)this.d);
            par1NBTTagCompound.a("Air", (short)this.al());
            par1NBTTagCompound.a("OnGround", this.F);
            par1NBTTagCompound.a("Dimension", this.ar);
            par1NBTTagCompound.a("Invulnerable", this.h);
            par1NBTTagCompound.a("PortalCooldown", this.ao);
            par1NBTTagCompound.a("UUIDMost", this.i.getMostSignificantBits());
            par1NBTTagCompound.a("UUIDLeast", this.i.getLeastSignificantBits());
            if (this.customEntityData != null) {
                par1NBTTagCompound.a("ForgeData", this.customEntityData);
            }
            for (String identifier : this.extendedProperties.keySet()) {
                try {
                    IExtendedEntityProperties props = this.extendedProperties.get(identifier);
                    props.saveNBTData(par1NBTTagCompound);
                }
                catch (Throwable t2) {
                    FMLLog.severe((String)"Failed to save extended properties for %s.  This is a mod issue.", (Object[])new Object[]{identifier});
                    t2.printStackTrace();
                }
            }
            this.b(par1NBTTagCompound);
            if (this.o != null && this.o.c(nbttagcompound1 = new by("Riding"))) {
                par1NBTTagCompound.a("Riding", (cl)nbttagcompound1);
            }
        }
        catch (Throwable throwable) {
            b crashreport = b.a(throwable, "Saving entity NBT");
            m crashreportcategory = crashreport.a("Entity being saved");
            this.a(crashreportcategory);
            throw new u(crashreport);
        }
    }

    public void f(by par1NBTTagCompound) {
        try {
            cg nbttaglist = par1NBTTagCompound.m("Pos");
            cg nbttaglist1 = par1NBTTagCompound.m("Motion");
            cg nbttaglist2 = par1NBTTagCompound.m("Rotation");
            this.x = ((cb)nbttaglist1.b((int)0)).a;
            this.y = ((cb)nbttaglist1.b((int)1)).a;
            this.z = ((cb)nbttaglist1.b((int)2)).a;
            if (Math.abs(this.x) > 10.0) {
                this.x = 0.0;
            }
            if (Math.abs(this.y) > 10.0) {
                this.y = 0.0;
            }
            if (Math.abs(this.z) > 10.0) {
                this.z = 0.0;
            }
            this.U = this.u = ((cb)nbttaglist.b((int)0)).a;
            this.r = this.u;
            this.V = this.v = ((cb)nbttaglist.b((int)1)).a;
            this.s = this.v;
            this.W = this.w = ((cb)nbttaglist.b((int)2)).a;
            this.t = this.w;
            this.C = this.A = ((cd)nbttaglist2.b((int)0)).a;
            this.D = this.B = ((cd)nbttaglist2.b((int)1)).a;
            this.T = par1NBTTagCompound.g("FallDistance");
            this.d = par1NBTTagCompound.d("Fire");
            this.g(par1NBTTagCompound.d("Air"));
            this.F = par1NBTTagCompound.n("OnGround");
            this.ar = par1NBTTagCompound.e("Dimension");
            this.h = par1NBTTagCompound.n("Invulnerable");
            this.ao = par1NBTTagCompound.e("PortalCooldown");
            if (par1NBTTagCompound.b("UUIDMost") && par1NBTTagCompound.b("UUIDLeast")) {
                this.i = new UUID(par1NBTTagCompound.f("UUIDMost"), par1NBTTagCompound.f("UUIDLeast"));
            }
            this.b(this.u, this.v, this.w);
            this.b(this.A, this.B);
            if (par1NBTTagCompound.b("ForgeData")) {
                this.customEntityData = par1NBTTagCompound.l("ForgeData");
            }
            for (String identifier : this.extendedProperties.keySet()) {
                try {
                    IExtendedEntityProperties props = this.extendedProperties.get(identifier);
                    props.loadNBTData(par1NBTTagCompound);
                }
                catch (Throwable t2) {
                    FMLLog.severe((String)"Failed to load extended properties for %s.  This is a mod issue.", (Object[])new Object[]{identifier});
                    t2.printStackTrace();
                }
            }
            if (par1NBTTagCompound.b("PersistentIDMSB") && par1NBTTagCompound.b("PersistentIDLSB")) {
                this.i = new UUID(par1NBTTagCompound.f("PersistentIDMSB"), par1NBTTagCompound.f("PersistentIDLSB"));
            }
            this.a(par1NBTTagCompound);
            if (this.P()) {
                this.b(this.u, this.v, this.w);
            }
        }
        catch (Throwable throwable) {
            b crashreport = b.a(throwable, "Loading entity NBT");
            m crashreportcategory = crashreport.a("Entity being loaded");
            this.a(crashreportcategory);
            throw new u(crashreport);
        }
    }

    protected boolean P() {
        return true;
    }

    protected final String Q() {
        return nt.b(this);
    }

    protected abstract void a(by var1);

    protected abstract void b(by var1);

    public void R() {
    }

    protected cg a(double ... par1ArrayOfDouble) {
        cg nbttaglist = new cg();
        double[] adouble = par1ArrayOfDouble;
        int i2 = par1ArrayOfDouble.length;
        for (int j2 = 0; j2 < i2; ++j2) {
            double d1 = adouble[j2];
            nbttaglist.a((cl)new cb((String)null, d1));
        }
        return nbttaglist;
    }

    protected cg a(float ... par1ArrayOfFloat) {
        cg nbttaglist = new cg();
        float[] afloat = par1ArrayOfFloat;
        int i2 = par1ArrayOfFloat.length;
        for (int j2 = 0; j2 < i2; ++j2) {
            float f1 = afloat[j2];
            nbttaglist.a((cl)new cd((String)null, f1));
        }
        return nbttaglist;
    }

    @SideOnly(value=Side.CLIENT)
    public float S() {
        return this.P / 2.0f;
    }

    public ss b(int par1, int par2) {
        return this.a(par1, par2, 0.0f);
    }

    public ss a(int par1, int par2, float par3) {
        return this.a(new ye(par1, par2, 0), par3);
    }

    public ss a(ye par1ItemStack, float par2) {
        if (par1ItemStack.b == 0) {
            return null;
        }
        ss entityitem = new ss(this.q, this.u, this.v + (double)par2, this.w, par1ItemStack);
        entityitem.b = 10;
        if (this.captureDrops) {
            this.capturedDrops.add(entityitem);
        } else {
            this.q.d(entityitem);
        }
        return entityitem;
    }

    public boolean T() {
        return !this.M;
    }

    public boolean U() {
        for (int i2 = 0; i2 < 8; ++i2) {
            int l2;
            int k2;
            float f2 = ((float)((i2 >> 0) % 2) - 0.5f) * this.O * 0.8f;
            float f1 = ((float)((i2 >> 1) % 2) - 0.5f) * 0.1f;
            float f22 = ((float)((i2 >> 2) % 2) - 0.5f) * this.O * 0.8f;
            int j2 = ls.c(this.u + (double)f2);
            if (!this.q.u(j2, k2 = ls.c(this.v + (double)this.f() + (double)f1), l2 = ls.c(this.w + (double)f22))) continue;
            return true;
        }
        return false;
    }

    public boolean c(uf par1EntityPlayer) {
        return false;
    }

    public asx g(nn par1Entity) {
        return null;
    }

    public void V() {
        if (this.o.M) {
            this.o = null;
        } else {
            this.x = 0.0;
            this.y = 0.0;
            this.z = 0.0;
            this.l_();
            if (this.o != null) {
                this.o.W();
                this.g += (double)(this.o.A - this.o.C);
                this.f += (double)(this.o.B - this.o.D);
                while (this.g >= 180.0) {
                    this.g -= 360.0;
                }
                while (this.g < -180.0) {
                    this.g += 360.0;
                }
                while (this.f >= 180.0) {
                    this.f -= 360.0;
                }
                while (this.f < -180.0) {
                    this.f += 360.0;
                }
                double d0 = this.g * 0.5;
                double d1 = this.f * 0.5;
                float f2 = 10.0f;
                if (d0 > (double)f2) {
                    d0 = f2;
                }
                if (d0 < (double)(-f2)) {
                    d0 = -f2;
                }
                if (d1 > (double)f2) {
                    d1 = f2;
                }
                if (d1 < (double)(-f2)) {
                    d1 = -f2;
                }
                this.g -= d0;
                this.f -= d1;
            }
        }
    }

    public void W() {
        if (this.n != null) {
            this.n.b(this.u, this.v + this.Y() + this.n.X(), this.w);
        }
    }

    public double X() {
        return this.N;
    }

    public double Y() {
        return (double)this.P * 0.75;
    }

    public void a(nn par1Entity) {
        this.f = 0.0;
        this.g = 0.0;
        if (par1Entity == null) {
            if (this.o != null) {
                this.b(this.o.u, this.o.E.b + (double)this.o.P, this.o.w, this.A, this.B);
                this.o.n = null;
            }
            this.o = null;
        } else {
            if (this.o != null) {
                this.o.n = null;
            }
            this.o = par1Entity;
            par1Entity.n = this;
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void a(double par1, double par3, double par5, float par7, float par8, int par9) {
        this.b(par1, par3, par5);
        this.b(par7, par8);
        List list = this.q.a(this, this.E.e(0.03125, 0.0, 0.03125));
        if (!list.isEmpty()) {
            double d3 = 0.0;
            for (int j2 = 0; j2 < list.size(); ++j2) {
                asx axisalignedbb = (asx)list.get(j2);
                if (!(axisalignedbb.e > d3)) continue;
                d3 = axisalignedbb.e;
            }
            this.b(par1, par3 += d3 - this.E.b, par5);
        }
    }

    public float Z() {
        return 0.1f;
    }

    public atc aa() {
        return null;
    }

    public void ab() {
        if (this.ao > 0) {
            this.ao = this.ac();
        } else {
            double d0 = this.r - this.u;
            double d1 = this.t - this.w;
            if (!this.q.I && !this.ap) {
                this.as = r.a((double)d0, (double)d1);
            }
            this.ap = true;
        }
    }

    public int ac() {
        return 900;
    }

    @SideOnly(value=Side.CLIENT)
    public void h(double par1, double par3, double par5) {
        this.x = par1;
        this.y = par3;
        this.z = par5;
    }

    @SideOnly(value=Side.CLIENT)
    public void a(byte par1) {
    }

    @SideOnly(value=Side.CLIENT)
    public void ad() {
    }

    public ye[] ae() {
        return null;
    }

    public void c(int par1, ye par2ItemStack) {
    }

    public boolean af() {
        return !this.ag && (this.d > 0 || this.f(0));
    }

    public boolean ag() {
        return this.o != null && this.o.shouldRiderSit();
    }

    public boolean ah() {
        return this.f(1);
    }

    public void b(boolean par1) {
        this.a(1, par1);
    }

    public boolean ai() {
        return this.f(3);
    }

    public void c(boolean par1) {
        this.a(3, par1);
    }

    public boolean aj() {
        return this.f(5);
    }

    @SideOnly(value=Side.CLIENT)
    public boolean d(uf par1EntityPlayer) {
        return this.aj();
    }

    public void d(boolean par1) {
        this.a(5, par1);
    }

    @SideOnly(value=Side.CLIENT)
    public boolean ak() {
        return this.f(4);
    }

    public void e(boolean par1) {
        this.a(4, par1);
    }

    protected boolean f(int par1) {
        return (this.ah.a(0) & 1 << par1) != 0;
    }

    protected void a(int par1, boolean par2) {
        byte b0 = this.ah.a(0);
        if (par2) {
            this.ah.b(0, (byte)(b0 | 1 << par1));
        } else {
            this.ah.b(0, (byte)(b0 & ~(1 << par1)));
        }
    }

    public int al() {
        return this.ah.b(1);
    }

    public void g(int par1) {
        this.ah.b(1, (short)par1);
    }

    public void a(sp par1EntityLightningBolt) {
        this.e(5);
        ++this.d;
        if (this.d == 0) {
            this.d(8);
        }
    }

    public void a(of par1EntityLivingBase) {
    }

    protected boolean i(double par1, double par3, double par5) {
        int i2 = ls.c(par1);
        int j2 = ls.c(par3);
        int k2 = ls.c(par5);
        double d3 = par1 - (double)i2;
        double d4 = par3 - (double)j2;
        double d5 = par5 - (double)k2;
        List list = this.q.a(this.E);
        if (list.isEmpty() && !this.q.v(i2, j2, k2)) {
            return false;
        }
        boolean flag = !this.q.v(i2 - 1, j2, k2);
        boolean flag1 = !this.q.v(i2 + 1, j2, k2);
        boolean flag2 = !this.q.v(i2, j2 - 1, k2);
        boolean flag3 = !this.q.v(i2, j2 + 1, k2);
        boolean flag4 = !this.q.v(i2, j2, k2 - 1);
        boolean flag5 = !this.q.v(i2, j2, k2 + 1);
        int b0 = 3;
        double d6 = 9999.0;
        if (flag && d3 < d6) {
            d6 = d3;
            b0 = 0;
        }
        if (flag1 && 1.0 - d3 < d6) {
            d6 = 1.0 - d3;
            b0 = 1;
        }
        if (flag3 && 1.0 - d4 < d6) {
            d6 = 1.0 - d4;
            b0 = 3;
        }
        if (flag4 && d5 < d6) {
            d6 = d5;
            b0 = 4;
        }
        if (flag5 && 1.0 - d5 < d6) {
            d6 = 1.0 - d5;
            b0 = 5;
        }
        float f2 = this.ab.nextFloat() * 0.2f + 0.1f;
        if (b0 == 0) {
            this.x = -f2;
        }
        if (b0 == 1) {
            this.x = f2;
        }
        if (b0 == 2) {
            this.y = -f2;
        }
        if (b0 == 3) {
            this.y = f2;
        }
        if (b0 == 4) {
            this.z = -f2;
        }
        if (b0 == 5) {
            this.z = f2;
        }
        return true;
    }

    public void am() {
        this.K = true;
        this.T = 0.0f;
    }

    public String an() {
        String s2 = nt.b(this);
        if (s2 == null) {
            s2 = "generic";
        }
        return bu.a((String)("entity." + s2 + ".name"));
    }

    public nn[] ao() {
        return null;
    }

    public boolean h(nn par1Entity) {
        return this == par1Entity;
    }

    public float ap() {
        return 0.0f;
    }

    @SideOnly(value=Side.CLIENT)
    public void e(float par1) {
    }

    public boolean aq() {
        return true;
    }

    public boolean i(nn par1Entity) {
        return false;
    }

    public String toString() {
        return String.format("%s['%s'/%d, l='%s', x=%.2f, y=%.2f, z=%.2f]", this.getClass().getSimpleName(), this.an(), this.k, this.q == null ? "~NULL~" : this.q.N().k(), this.u, this.v, this.w);
    }

    public boolean ar() {
        return this.h;
    }

    public void j(nn par1Entity) {
        this.b(par1Entity.u, par1Entity.v, par1Entity.w, par1Entity.A, par1Entity.B);
    }

    public void a(nn par1Entity, boolean par2) {
        by nbttagcompound = new by();
        par1Entity.e(nbttagcompound);
        this.f(nbttagcompound);
        this.ao = par1Entity.ao;
        this.as = par1Entity.as;
    }

    public void b(int par1) {
        if (!this.q.I && !this.M) {
            this.q.C.a("changeDimension");
            MinecraftServer minecraftserver = MinecraftServer.F();
            int j2 = this.ar;
            js worldserver = minecraftserver.a(j2);
            js worldserver1 = minecraftserver.a(par1);
            this.ar = par1;
            if (j2 == 1 && par1 == 1) {
                worldserver1 = minecraftserver.a(0);
                this.ar = 0;
            }
            this.q.e(this);
            this.M = false;
            this.q.C.a("reposition");
            minecraftserver.af().a(this, j2, worldserver, worldserver1);
            this.q.C.c("reloading");
            nn entity = nt.a(nt.b(this), (abw)worldserver1);
            if (entity != null) {
                entity.a(this, true);
                if (j2 == 1 && par1 == 1) {
                    t chunkcoordinates = worldserver1.K();
                    chunkcoordinates.b = this.q.i(chunkcoordinates.a, chunkcoordinates.c);
                    entity.b(chunkcoordinates.a, chunkcoordinates.b, chunkcoordinates.c, entity.A, entity.B);
                }
                worldserver1.d(entity);
            }
            this.M = true;
            this.q.C.b();
            worldserver.i();
            worldserver1.i();
            this.q.C.b();
        }
    }

    public float a(abr par1Explosion, abw par2World, int par3, int par4, int par5, aqz par6Block) {
        return par6Block.getExplosionResistance(this, par2World, par3, par4, par5, this.u, this.v + (double)this.f(), this.w);
    }

    public boolean a(abr par1Explosion, abw par2World, int par3, int par4, int par5, int par6, float par7) {
        return true;
    }

    public int as() {
        return 3;
    }

    public int at() {
        return this.as;
    }

    public boolean au() {
        return false;
    }

    public void a(m par1CrashReportCategory) {
        par1CrashReportCategory.a("Entity Type", (Callable)new no(this));
        par1CrashReportCategory.a("Entity ID", this.k);
        par1CrashReportCategory.a("Entity Name", (Callable)new np(this));
        par1CrashReportCategory.a("Entity's Exact location", String.format("%.2f, %.2f, %.2f", this.u, this.v, this.w));
        par1CrashReportCategory.a("Entity's Block location", m.a(ls.c(this.u), ls.c(this.v), ls.c(this.w)));
        par1CrashReportCategory.a("Entity's Momentum", String.format("%.2f, %.2f, %.2f", this.x, this.y, this.z));
    }

    @SideOnly(value=Side.CLIENT)
    public boolean av() {
        return this.af();
    }

    public UUID aw() {
        return this.i;
    }

    public boolean ax() {
        return true;
    }

    public String ay() {
        return this.an();
    }

    public by getEntityData() {
        if (this.customEntityData == null) {
            this.customEntityData = new by();
        }
        return this.customEntityData;
    }

    public boolean shouldRiderSit() {
        return true;
    }

    public ye getPickedResult(ata target) {
        if (this instanceof ol) {
            return new ye(yc.au);
        }
        if (this instanceof st) {
            return ((st)this).getCartItem();
        }
        if (this instanceof sq) {
            return new ye(yc.aG);
        }
        if (this instanceof od) {
            ye held = ((od)this).h();
            if (held == null) {
                return new ye(yc.bK);
            }
            return held.m();
        }
        if (this instanceof oe) {
            return new ye(yc.ch);
        }
        int id = nt.a(this);
        if (id > 0 && nt.a.containsKey(id)) {
            return new ye(yc.bE, 1, id);
        }
        return null;
    }

    public UUID getPersistentID() {
        return this.i;
    }

    public final void resetEntityId() {
        this.k = b++;
    }

    public boolean shouldRenderInPass(int pass) {
        return pass == 0;
    }

    public boolean isCreatureType(oh type, boolean forSpawnCount) {
        return type.a().isAssignableFrom(this.getClass());
    }

    public String registerExtendedProperties(String identifier, IExtendedEntityProperties properties) {
        if (identifier == null) {
            FMLLog.warning((String)"Someone is attempting to register extended properties using a null identifier.  This is not allowed.  Aborting.  This may have caused instability.", (Object[])new Object[0]);
            return "";
        }
        if (properties == null) {
            FMLLog.warning((String)"Someone is attempting to register null extended properties.  This is not allowed.  Aborting.  This may have caused instability.", (Object[])new Object[0]);
            return "";
        }
        String baseIdentifier = identifier;
        int identifierModCount = 1;
        while (this.extendedProperties.containsKey(identifier)) {
            identifier = String.format("%s%d", baseIdentifier, identifierModCount++);
        }
        if (baseIdentifier != identifier) {
            FMLLog.info((String)"An attempt was made to register exended properties using an existing key.  The duplicate identifier (%s) has been remapped to %s.", (Object[])new Object[]{baseIdentifier, identifier});
        }
        this.extendedProperties.put(identifier, properties);
        return identifier;
    }

    public IExtendedEntityProperties getExtendedProperties(String identifier) {
        return this.extendedProperties.get(identifier);
    }

    public boolean canRiderInteract() {
        return false;
    }

    public boolean shouldDismountInWater(nn rider) {
        return this instanceof of;
    }
}

