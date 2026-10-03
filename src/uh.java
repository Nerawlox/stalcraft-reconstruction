/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  abh
 *  acf
 *  asx
 *  ata
 *  atc
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ef
 *  nb
 *  tg
 *  un
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;

public class uh
extends nn
implements un {
    private int d = -1;
    private int e = -1;
    private int f = -1;
    private int g;
    private int h;
    private boolean i;
    public int a;
    public int b;
    public nn c;
    private int j;
    private int au;
    private double av = 2.0;
    private int aw;

    public uh(abw par1World) {
        super(par1World);
        this.l = 10.0;
        this.a(0.5f, 0.5f);
    }

    public uh(abw par1World, double par2, double par4, double par6) {
        super(par1World);
        this.l = 10.0;
        this.a(0.5f, 0.5f);
        this.b(par2, par4, par6);
        this.N = 0.0f;
    }

    public uh(abw par1World, of par2EntityLivingBase, of par3EntityLivingBase, float par4, float par5) {
        super(par1World);
        this.l = 10.0;
        this.c = par2EntityLivingBase;
        if (par2EntityLivingBase instanceof uf) {
            this.a = 1;
        }
        this.v = par2EntityLivingBase.v + (double)par2EntityLivingBase.f() - (double)0.1f;
        double d0 = par3EntityLivingBase.u - par2EntityLivingBase.u;
        double d1 = par3EntityLivingBase.E.b + (double)(par3EntityLivingBase.P / 3.0f) - this.v;
        double d2 = par3EntityLivingBase.w - par2EntityLivingBase.w;
        double d3 = ls.a(d0 * d0 + d2 * d2);
        if (d3 >= 1.0E-7) {
            float f2 = (float)(Math.atan2(d2, d0) * 180.0 / Math.PI) - 90.0f;
            float f3 = (float)(-(Math.atan2(d1, d3) * 180.0 / Math.PI));
            double d4 = d0 / d3;
            double d5 = d2 / d3;
            this.b(par2EntityLivingBase.u + d4, this.v, par2EntityLivingBase.w + d5, f2, f3);
            this.N = 0.0f;
            float f4 = (float)d3 * 0.2f;
            this.c(d0, d1 + (double)f4, d2, par4, par5);
        }
    }

    public uh(abw par1World, of par2EntityLivingBase, float par3) {
        super(par1World);
        this.l = 10.0;
        this.c = par2EntityLivingBase;
        if (par2EntityLivingBase instanceof uf) {
            this.a = 1;
        }
        this.a(0.5f, 0.5f);
        this.b(par2EntityLivingBase.u, par2EntityLivingBase.v + (double)par2EntityLivingBase.f(), par2EntityLivingBase.w, par2EntityLivingBase.A, par2EntityLivingBase.B);
        this.u -= (double)(ls.b(this.A / 180.0f * (float)Math.PI) * 0.16f);
        this.v -= (double)0.1f;
        this.w -= (double)(ls.a(this.A / 180.0f * (float)Math.PI) * 0.16f);
        this.b(this.u, this.v, this.w);
        this.N = 0.0f;
        this.x = -ls.a(this.A / 180.0f * (float)Math.PI) * ls.b(this.B / 180.0f * (float)Math.PI);
        this.z = ls.b(this.A / 180.0f * (float)Math.PI) * ls.b(this.B / 180.0f * (float)Math.PI);
        this.y = -ls.a(this.B / 180.0f * (float)Math.PI);
        this.c(this.x, this.y, this.z, par3 * 1.5f, 1.0f);
    }

    @Override
    protected void a() {
        this.ah.a(16, (Object)0);
    }

    public void c(double par1, double par3, double par5, float par7, float par8) {
        float f2 = ls.a(par1 * par1 + par3 * par3 + par5 * par5);
        par1 /= (double)f2;
        par3 /= (double)f2;
        par5 /= (double)f2;
        par1 += this.ab.nextGaussian() * (double)(this.ab.nextBoolean() ? -1 : 1) * (double)0.0075f * (double)par8;
        par3 += this.ab.nextGaussian() * (double)(this.ab.nextBoolean() ? -1 : 1) * (double)0.0075f * (double)par8;
        par5 += this.ab.nextGaussian() * (double)(this.ab.nextBoolean() ? -1 : 1) * (double)0.0075f * (double)par8;
        this.x = par1 *= (double)par7;
        this.y = par3 *= (double)par7;
        this.z = par5 *= (double)par7;
        float f3 = ls.a(par1 * par1 + par5 * par5);
        this.C = this.A = (float)(Math.atan2(par1, par5) * 180.0 / Math.PI);
        this.D = this.B = (float)(Math.atan2(par3, f3) * 180.0 / Math.PI);
        this.j = 0;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(double par1, double par3, double par5, float par7, float par8, int par9) {
        this.b(par1, par3, par5);
        this.b(par7, par8);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void h(double par1, double par3, double par5) {
        this.x = par1;
        this.y = par3;
        this.z = par5;
        if (this.D == 0.0f && this.C == 0.0f) {
            float f2 = ls.a(par1 * par1 + par5 * par5);
            this.C = this.A = (float)(Math.atan2(par1, par5) * 180.0 / Math.PI);
            this.D = this.B = (float)(Math.atan2(par3, f2) * 180.0 / Math.PI);
            this.D = this.B;
            this.C = this.A;
            this.b(this.u, this.v, this.w, this.A, this.B);
            this.j = 0;
        }
    }

    @Override
    public void l_() {
        int i2;
        super.l_();
        if (this.D == 0.0f && this.C == 0.0f) {
            float f2 = ls.a(this.x * this.x + this.z * this.z);
            this.C = this.A = (float)(Math.atan2(this.x, this.z) * 180.0 / Math.PI);
            this.D = this.B = (float)(Math.atan2(this.y, f2) * 180.0 / Math.PI);
        }
        if ((i2 = this.q.a(this.d, this.e, this.f)) > 0) {
            aqz.s[i2].a((acf)this.q, this.d, this.e, this.f);
            asx axisalignedbb = aqz.s[i2].b(this.q, this.d, this.e, this.f);
            if (axisalignedbb != null && axisalignedbb.a(this.q.V().a(this.u, this.v, this.w))) {
                this.i = true;
            }
        }
        if (this.b > 0) {
            --this.b;
        }
        if (this.i) {
            int j2 = this.q.a(this.d, this.e, this.f);
            int k2 = this.q.h(this.d, this.e, this.f);
            if (j2 == this.g && k2 == this.h) {
                ++this.j;
                if (this.j == 1200) {
                    this.x();
                }
            } else {
                this.i = false;
                this.x *= (double)(this.ab.nextFloat() * 0.2f);
                this.y *= (double)(this.ab.nextFloat() * 0.2f);
                this.z *= (double)(this.ab.nextFloat() * 0.2f);
                this.j = 0;
                this.au = 0;
            }
        } else {
            float f1;
            int l2;
            ++this.au;
            atc vec3 = this.q.V().a(this.u, this.v, this.w);
            atc vec31 = this.q.V().a(this.u + this.x, this.v + this.y, this.w + this.z);
            ata movingobjectposition = this.q.a(vec3, vec31, false, true);
            vec3 = this.q.V().a(this.u, this.v, this.w);
            vec31 = this.q.V().a(this.u + this.x, this.v + this.y, this.w + this.z);
            if (movingobjectposition != null) {
                vec31 = this.q.V().a(movingobjectposition.f.c, movingobjectposition.f.d, movingobjectposition.f.e);
            }
            nn entity = null;
            List list = this.q.b((nn)this, this.E.a(this.x, this.y, this.z).b(1.0, 1.0, 1.0));
            double d0 = 0.0;
            for (l2 = 0; l2 < list.size(); ++l2) {
                double d1;
                asx axisalignedbb1;
                ata movingobjectposition1;
                nn entity1 = (nn)list.get(l2);
                if (!entity1.L() || entity1 == this.c && this.au < 5 || (movingobjectposition1 = (axisalignedbb1 = entity1.E.b((double)(f1 = 0.3f), (double)f1, (double)f1)).a(vec3, vec31)) == null || !((d1 = vec3.d(movingobjectposition1.f)) < d0) && d0 != 0.0) continue;
                entity = entity1;
                d0 = d1;
            }
            if (entity != null) {
                movingobjectposition = new ata(entity);
            }
            if (movingobjectposition != null && movingobjectposition.g != null && movingobjectposition.g instanceof uf) {
                uf entityplayer = (uf)movingobjectposition.g;
                if (entityplayer.bG.a || this.c instanceof uf && !((uf)this.c).a(entityplayer)) {
                    movingobjectposition = null;
                }
            }
            if (movingobjectposition != null) {
                if (movingobjectposition.g != null) {
                    float f2 = ls.a(this.x * this.x + this.y * this.y + this.z * this.z);
                    int i1 = ls.f((double)f2 * this.av);
                    if (this.d()) {
                        i1 += this.ab.nextInt(i1 / 2 + 2);
                    }
                    nb damagesource = null;
                    damagesource = this.c == null ? nb.a((uh)this, (nn)this) : nb.a((uh)this, (nn)this.c);
                    if (this.af() && !(movingobjectposition.g instanceof tg)) {
                        movingobjectposition.g.d(5);
                    }
                    if (movingobjectposition.g.a(damagesource, (float)i1)) {
                        if (movingobjectposition.g instanceof of) {
                            float f3;
                            of entitylivingbase = (of)movingobjectposition.g;
                            if (!this.q.I) {
                                entitylivingbase.m(entitylivingbase.aU() + 1);
                            }
                            if (this.aw > 0 && (f3 = ls.a(this.x * this.x + this.z * this.z)) > 0.0f) {
                                movingobjectposition.g.g(this.x * (double)this.aw * (double)0.6f / (double)f3, 0.1, this.z * (double)this.aw * (double)0.6f / (double)f3);
                            }
                            if (this.c != null) {
                                abh.a((nn)this.c, (of)entitylivingbase, (Random)this.ab);
                            }
                            if (this.c != null && movingobjectposition.g != this.c && movingobjectposition.g instanceof uf && this.c instanceof jv) {
                                ((jv)this.c).a.b((ey)new ef(6, 0));
                            }
                        }
                        this.a("random.bowhit", 1.0f, 1.2f / (this.ab.nextFloat() * 0.2f + 0.9f));
                        if (!(movingobjectposition.g instanceof tg)) {
                            this.x();
                        }
                    } else {
                        this.x *= (double)-0.1f;
                        this.y *= (double)-0.1f;
                        this.z *= (double)-0.1f;
                        this.A += 180.0f;
                        this.C += 180.0f;
                        this.au = 0;
                    }
                } else {
                    this.d = movingobjectposition.b;
                    this.e = movingobjectposition.c;
                    this.f = movingobjectposition.d;
                    this.g = this.q.a(this.d, this.e, this.f);
                    this.h = this.q.h(this.d, this.e, this.f);
                    this.x = (float)(movingobjectposition.f.c - this.u);
                    this.y = (float)(movingobjectposition.f.d - this.v);
                    this.z = (float)(movingobjectposition.f.e - this.w);
                    float f2 = ls.a(this.x * this.x + this.y * this.y + this.z * this.z);
                    this.u -= this.x / (double)f2 * (double)0.05f;
                    this.v -= this.y / (double)f2 * (double)0.05f;
                    this.w -= this.z / (double)f2 * (double)0.05f;
                    this.a("random.bowhit", 1.0f, 1.2f / (this.ab.nextFloat() * 0.2f + 0.9f));
                    this.i = true;
                    this.b = 7;
                    this.a(false);
                    if (this.g != 0) {
                        aqz.s[this.g].a(this.q, this.d, this.e, this.f, this);
                    }
                }
            }
            if (this.d()) {
                for (l2 = 0; l2 < 4; ++l2) {
                    this.q.a("crit", this.u + this.x * (double)l2 / 4.0, this.v + this.y * (double)l2 / 4.0, this.w + this.z * (double)l2 / 4.0, -this.x, -this.y + 0.2, -this.z);
                }
            }
            this.u += this.x;
            this.v += this.y;
            this.w += this.z;
            float f2 = ls.a(this.x * this.x + this.z * this.z);
            this.A = (float)(Math.atan2(this.x, this.z) * 180.0 / Math.PI);
            this.B = (float)(Math.atan2(this.y, f2) * 180.0 / Math.PI);
            while (this.B - this.D < -180.0f) {
                this.D -= 360.0f;
            }
            while (this.B - this.D >= 180.0f) {
                this.D += 360.0f;
            }
            while (this.A - this.C < -180.0f) {
                this.C -= 360.0f;
            }
            while (this.A - this.C >= 180.0f) {
                this.C += 360.0f;
            }
            this.B = this.D + (this.B - this.D) * 0.2f;
            this.A = this.C + (this.A - this.C) * 0.2f;
            float f4 = 0.99f;
            f1 = 0.05f;
            if (this.H()) {
                for (int j1 = 0; j1 < 4; ++j1) {
                    float f3 = 0.25f;
                    this.q.a("bubble", this.u - this.x * (double)f3, this.v - this.y * (double)f3, this.w - this.z * (double)f3, this.x, this.y, this.z);
                }
                f4 = 0.8f;
            }
            this.x *= (double)f4;
            this.y *= (double)f4;
            this.z *= (double)f4;
            this.y -= (double)f1;
            this.b(this.u, this.v, this.w);
            this.D();
        }
    }

    @Override
    public void b(by par1NBTTagCompound) {
        par1NBTTagCompound.a("xTile", (short)this.d);
        par1NBTTagCompound.a("yTile", (short)this.e);
        par1NBTTagCompound.a("zTile", (short)this.f);
        par1NBTTagCompound.a("inTile", (byte)this.g);
        par1NBTTagCompound.a("inData", (byte)this.h);
        par1NBTTagCompound.a("shake", (byte)this.b);
        par1NBTTagCompound.a("inGround", (byte)(this.i ? 1 : 0));
        par1NBTTagCompound.a("pickup", (byte)this.a);
        par1NBTTagCompound.a("damage", this.av);
    }

    @Override
    public void a(by par1NBTTagCompound) {
        this.d = par1NBTTagCompound.d("xTile");
        this.e = par1NBTTagCompound.d("yTile");
        this.f = par1NBTTagCompound.d("zTile");
        this.g = par1NBTTagCompound.c("inTile") & 0xFF;
        this.h = par1NBTTagCompound.c("inData") & 0xFF;
        this.b = par1NBTTagCompound.c("shake") & 0xFF;
        boolean bl2 = this.i = par1NBTTagCompound.c("inGround") == 1;
        if (par1NBTTagCompound.b("damage")) {
            this.av = par1NBTTagCompound.h("damage");
        }
        if (par1NBTTagCompound.b("pickup")) {
            this.a = par1NBTTagCompound.c("pickup");
        } else if (par1NBTTagCompound.b("player")) {
            this.a = par1NBTTagCompound.n("player") ? 1 : 0;
        }
    }

    @Override
    public void b_(uf par1EntityPlayer) {
        if (!this.q.I && this.i && this.b <= 0) {
            boolean flag;
            boolean bl2 = flag = this.a == 1 || this.a == 2 && par1EntityPlayer.bG.d;
            if (this.a == 1 && !par1EntityPlayer.bn.a(new ye(yc.n, 1))) {
                flag = false;
            }
            if (flag) {
                this.a("random.pop", 0.2f, ((this.ab.nextFloat() - this.ab.nextFloat()) * 0.7f + 1.0f) * 2.0f);
                par1EntityPlayer.a((nn)this, 1);
                this.x();
            }
        }
    }

    @Override
    protected boolean e_() {
        return false;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public float S() {
        return 0.0f;
    }

    public void b(double par1) {
        this.av = par1;
    }

    public double c() {
        return this.av;
    }

    public void a(int par1) {
        this.aw = par1;
    }

    @Override
    public boolean aq() {
        return false;
    }

    public void a(boolean par1) {
        byte b0 = this.ah.a(16);
        if (par1) {
            this.ah.b(16, (byte)(b0 | 1));
        } else {
            this.ah.b(16, (byte)(b0 & 0xFFFFFFFE));
        }
    }

    public boolean d() {
        byte b0 = this.ah.a(16);
        return (b0 & 1) != 0;
    }
}

