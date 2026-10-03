/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  asx
 *  ata
 *  atc
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  un
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

public abstract class uq
extends nn
implements un {
    private int c = -1;
    private int d = -1;
    private int e = -1;
    private int f;
    protected boolean a;
    public int b;
    private of g;
    private String h;
    private int i;
    private int j;

    public uq(abw par1World) {
        super(par1World);
        this.a(0.25f, 0.25f);
    }

    @Override
    protected void a() {
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean a(double par1) {
        double d1 = this.E.b() * 4.0;
        return par1 < (d1 *= 64.0) * d1;
    }

    public uq(abw par1World, of par2EntityLivingBase) {
        super(par1World);
        this.g = par2EntityLivingBase;
        this.a(0.25f, 0.25f);
        this.b(par2EntityLivingBase.u, par2EntityLivingBase.v + (double)par2EntityLivingBase.f(), par2EntityLivingBase.w, par2EntityLivingBase.A, par2EntityLivingBase.B);
        this.u -= (double)(ls.b(this.A / 180.0f * (float)Math.PI) * 0.16f);
        this.v -= (double)0.1f;
        this.w -= (double)(ls.a(this.A / 180.0f * (float)Math.PI) * 0.16f);
        this.b(this.u, this.v, this.w);
        this.N = 0.0f;
        float f2 = 0.4f;
        this.x = -ls.a(this.A / 180.0f * (float)Math.PI) * ls.b(this.B / 180.0f * (float)Math.PI) * f2;
        this.z = ls.b(this.A / 180.0f * (float)Math.PI) * ls.b(this.B / 180.0f * (float)Math.PI) * f2;
        this.y = -ls.a((this.B + this.d()) / 180.0f * (float)Math.PI) * f2;
        this.c(this.x, this.y, this.z, this.c(), 1.0f);
    }

    public uq(abw par1World, double par2, double par4, double par6) {
        super(par1World);
        this.i = 0;
        this.a(0.25f, 0.25f);
        this.b(par2, par4, par6);
        this.N = 0.0f;
    }

    protected float c() {
        return 1.5f;
    }

    protected float d() {
        return 0.0f;
    }

    public void c(double par1, double par3, double par5, float par7, float par8) {
        float f2 = ls.a(par1 * par1 + par3 * par3 + par5 * par5);
        par1 /= (double)f2;
        par3 /= (double)f2;
        par5 /= (double)f2;
        par1 += this.ab.nextGaussian() * (double)0.0075f * (double)par8;
        par3 += this.ab.nextGaussian() * (double)0.0075f * (double)par8;
        par5 += this.ab.nextGaussian() * (double)0.0075f * (double)par8;
        this.x = par1 *= (double)par7;
        this.y = par3 *= (double)par7;
        this.z = par5 *= (double)par7;
        float f3 = ls.a(par1 * par1 + par5 * par5);
        this.C = this.A = (float)(Math.atan2(par1, par5) * 180.0 / Math.PI);
        this.D = this.B = (float)(Math.atan2(par3, f3) * 180.0 / Math.PI);
        this.i = 0;
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
        }
    }

    @Override
    public void l_() {
        this.U = this.u;
        this.V = this.v;
        this.W = this.w;
        super.l_();
        if (this.b > 0) {
            --this.b;
        }
        if (this.a) {
            int i2 = this.q.a(this.c, this.d, this.e);
            if (i2 == this.f) {
                ++this.i;
                if (this.i == 1200) {
                    this.x();
                }
                return;
            }
            this.a = false;
            this.x *= (double)(this.ab.nextFloat() * 0.2f);
            this.y *= (double)(this.ab.nextFloat() * 0.2f);
            this.z *= (double)(this.ab.nextFloat() * 0.2f);
            this.i = 0;
            this.j = 0;
        } else {
            ++this.j;
        }
        atc vec3 = this.q.V().a(this.u, this.v, this.w);
        atc vec31 = this.q.V().a(this.u + this.x, this.v + this.y, this.w + this.z);
        ata movingobjectposition = this.q.a(vec3, vec31);
        vec3 = this.q.V().a(this.u, this.v, this.w);
        vec31 = this.q.V().a(this.u + this.x, this.v + this.y, this.w + this.z);
        if (movingobjectposition != null) {
            vec31 = this.q.V().a(movingobjectposition.f.c, movingobjectposition.f.d, movingobjectposition.f.e);
        }
        if (!this.q.I) {
            nn entity = null;
            List list = this.q.b((nn)this, this.E.a(this.x, this.y, this.z).b(1.0, 1.0, 1.0));
            double d0 = 0.0;
            of entitylivingbase = this.h();
            for (int j2 = 0; j2 < list.size(); ++j2) {
                double d1;
                float f2;
                asx axisalignedbb;
                ata movingobjectposition1;
                nn entity1 = (nn)list.get(j2);
                if (!entity1.L() || entity1 == entitylivingbase && this.j < 5 || (movingobjectposition1 = (axisalignedbb = entity1.E.b((double)(f2 = 0.3f), (double)f2, (double)f2)).a(vec3, vec31)) == null || !((d1 = vec3.d(movingobjectposition1.f)) < d0) && d0 != 0.0) continue;
                entity = entity1;
                d0 = d1;
            }
            if (entity != null) {
                movingobjectposition = new ata(entity);
            }
        }
        if (movingobjectposition != null) {
            if (movingobjectposition.a == atb.a && this.q.a(movingobjectposition.b, movingobjectposition.c, movingobjectposition.d) == aqz.bj.cF) {
                this.ab();
            } else {
                this.a(movingobjectposition);
            }
        }
        this.u += this.x;
        this.v += this.y;
        this.w += this.z;
        float f1 = ls.a(this.x * this.x + this.z * this.z);
        this.A = (float)(Math.atan2(this.x, this.z) * 180.0 / Math.PI);
        this.B = (float)(Math.atan2(this.y, f1) * 180.0 / Math.PI);
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
        float f2 = 0.99f;
        float f3 = this.e();
        if (this.H()) {
            for (int k2 = 0; k2 < 4; ++k2) {
                float f4 = 0.25f;
                this.q.a("bubble", this.u - this.x * (double)f4, this.v - this.y * (double)f4, this.w - this.z * (double)f4, this.x, this.y, this.z);
            }
            f2 = 0.8f;
        }
        this.x *= (double)f2;
        this.y *= (double)f2;
        this.z *= (double)f2;
        this.y -= (double)f3;
        this.b(this.u, this.v, this.w);
    }

    protected float e() {
        return 0.03f;
    }

    protected abstract void a(ata var1);

    @Override
    public void b(by par1NBTTagCompound) {
        par1NBTTagCompound.a("xTile", (short)this.c);
        par1NBTTagCompound.a("yTile", (short)this.d);
        par1NBTTagCompound.a("zTile", (short)this.e);
        par1NBTTagCompound.a("inTile", (byte)this.f);
        par1NBTTagCompound.a("shake", (byte)this.b);
        par1NBTTagCompound.a("inGround", (byte)(this.a ? 1 : 0));
        if ((this.h == null || this.h.length() == 0) && this.g != null && this.g instanceof uf) {
            this.h = this.g.an();
        }
        par1NBTTagCompound.a("ownerName", this.h == null ? "" : this.h);
    }

    @Override
    public void a(by par1NBTTagCompound) {
        this.c = par1NBTTagCompound.d("xTile");
        this.d = par1NBTTagCompound.d("yTile");
        this.e = par1NBTTagCompound.d("zTile");
        this.f = par1NBTTagCompound.c("inTile") & 0xFF;
        this.b = par1NBTTagCompound.c("shake") & 0xFF;
        this.a = par1NBTTagCompound.c("inGround") == 1;
        this.h = par1NBTTagCompound.i("ownerName");
        if (this.h != null && this.h.length() == 0) {
            this.h = null;
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public float S() {
        return 0.0f;
    }

    public of h() {
        if (this.g == null && this.h != null && this.h.length() > 0) {
            this.g = this.q.a(this.h);
        }
        return this.g;
    }
}

