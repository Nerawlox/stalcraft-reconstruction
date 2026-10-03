/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  asx
 *  ata
 *  atc
 *  cb
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  nb
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

public abstract class uj
extends nn {
    private int e = -1;
    private int f = -1;
    private int g = -1;
    private int h;
    private boolean i;
    public of a;
    private int j;
    private int au;
    public double b;
    public double c;
    public double d;

    public uj(abw par1World) {
        super(par1World);
        this.a(1.0f, 1.0f);
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

    public uj(abw par1World, double par2, double par4, double par6, double par8, double par10, double par12) {
        super(par1World);
        this.a(1.0f, 1.0f);
        this.b(par2, par4, par6, this.A, this.B);
        this.b(par2, par4, par6);
        double d6 = ls.a(par8 * par8 + par10 * par10 + par12 * par12);
        this.b = par8 / d6 * 0.1;
        this.c = par10 / d6 * 0.1;
        this.d = par12 / d6 * 0.1;
    }

    public uj(abw par1World, of par2EntityLivingBase, double par3, double par5, double par7) {
        super(par1World);
        this.a = par2EntityLivingBase;
        this.a(1.0f, 1.0f);
        this.b(par2EntityLivingBase.u, par2EntityLivingBase.v, par2EntityLivingBase.w, par2EntityLivingBase.A, par2EntityLivingBase.B);
        this.b(this.u, this.v, this.w);
        this.N = 0.0f;
        this.z = 0.0;
        this.y = 0.0;
        this.x = 0.0;
        double d3 = ls.a((par3 += this.ab.nextGaussian() * 0.4) * par3 + (par5 += this.ab.nextGaussian() * 0.4) * par5 + (par7 += this.ab.nextGaussian() * 0.4) * par7);
        this.b = par3 / d3 * 0.1;
        this.c = par5 / d3 * 0.1;
        this.d = par7 / d3 * 0.1;
    }

    @Override
    public void l_() {
        if (!this.q.I && (this.a != null && this.a.M || !this.q.f((int)this.u, (int)this.v, (int)this.w))) {
            this.x();
        } else {
            super.l_();
            this.d(1);
            if (this.i) {
                int i2 = this.q.a(this.e, this.f, this.g);
                if (i2 == this.h) {
                    ++this.j;
                    if (this.j == 600) {
                        this.x();
                    }
                    return;
                }
                this.i = false;
                this.x *= (double)(this.ab.nextFloat() * 0.2f);
                this.y *= (double)(this.ab.nextFloat() * 0.2f);
                this.z *= (double)(this.ab.nextFloat() * 0.2f);
                this.j = 0;
                this.au = 0;
            } else {
                ++this.au;
            }
            atc vec3 = this.q.V().a(this.u, this.v, this.w);
            atc vec31 = this.q.V().a(this.u + this.x, this.v + this.y, this.w + this.z);
            ata movingobjectposition = this.q.a(vec3, vec31);
            vec3 = this.q.V().a(this.u, this.v, this.w);
            vec31 = this.q.V().a(this.u + this.x, this.v + this.y, this.w + this.z);
            if (movingobjectposition != null) {
                vec31 = this.q.V().a(movingobjectposition.f.c, movingobjectposition.f.d, movingobjectposition.f.e);
            }
            nn entity = null;
            List list = this.q.b((nn)this, this.E.a(this.x, this.y, this.z).b(1.0, 1.0, 1.0));
            double d0 = 0.0;
            for (int j2 = 0; j2 < list.size(); ++j2) {
                double d1;
                float f2;
                asx axisalignedbb;
                ata movingobjectposition1;
                nn entity1 = (nn)list.get(j2);
                if (!entity1.L() || entity1.h(this.a) && this.au < 25 || (movingobjectposition1 = (axisalignedbb = entity1.E.b((double)(f2 = 0.3f), (double)f2, (double)f2)).a(vec3, vec31)) == null || !((d1 = vec3.d(movingobjectposition1.f)) < d0) && d0 != 0.0) continue;
                entity = entity1;
                d0 = d1;
            }
            if (entity != null) {
                movingobjectposition = new ata(entity);
            }
            if (movingobjectposition != null) {
                this.a(movingobjectposition);
            }
            this.u += this.x;
            this.v += this.y;
            this.w += this.z;
            float f1 = ls.a(this.x * this.x + this.z * this.z);
            this.A = (float)(Math.atan2(this.z, this.x) * 180.0 / Math.PI) + 90.0f;
            this.B = (float)(Math.atan2(f1, this.y) * 180.0 / Math.PI) - 90.0f;
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
            float f2 = this.c();
            if (this.H()) {
                for (int k2 = 0; k2 < 4; ++k2) {
                    float f3 = 0.25f;
                    this.q.a("bubble", this.u - this.x * (double)f3, this.v - this.y * (double)f3, this.w - this.z * (double)f3, this.x, this.y, this.z);
                }
                f2 = 0.8f;
            }
            this.x += this.b;
            this.y += this.c;
            this.z += this.d;
            this.x *= (double)f2;
            this.y *= (double)f2;
            this.z *= (double)f2;
            this.q.a("smoke", this.u, this.v + 0.5, this.w, 0.0, 0.0, 0.0);
            this.b(this.u, this.v, this.w);
        }
    }

    protected float c() {
        return 0.95f;
    }

    protected abstract void a(ata var1);

    @Override
    public void b(by par1NBTTagCompound) {
        par1NBTTagCompound.a("xTile", (short)this.e);
        par1NBTTagCompound.a("yTile", (short)this.f);
        par1NBTTagCompound.a("zTile", (short)this.g);
        par1NBTTagCompound.a("inTile", (byte)this.h);
        par1NBTTagCompound.a("inGround", (byte)(this.i ? 1 : 0));
        par1NBTTagCompound.a("direction", this.a(this.x, this.y, this.z));
    }

    @Override
    public void a(by par1NBTTagCompound) {
        this.e = par1NBTTagCompound.d("xTile");
        this.f = par1NBTTagCompound.d("yTile");
        this.g = par1NBTTagCompound.d("zTile");
        this.h = par1NBTTagCompound.c("inTile") & 0xFF;
        boolean bl2 = this.i = par1NBTTagCompound.c("inGround") == 1;
        if (par1NBTTagCompound.b("direction")) {
            cg nbttaglist = par1NBTTagCompound.m("direction");
            this.x = ((cb)nbttaglist.b((int)0)).a;
            this.y = ((cb)nbttaglist.b((int)1)).a;
            this.z = ((cb)nbttaglist.b((int)2)).a;
        } else {
            this.x();
        }
    }

    @Override
    public boolean L() {
        return true;
    }

    @Override
    public float Z() {
        return 1.0f;
    }

    @Override
    public boolean a(nb par1DamageSource, float par2) {
        if (this.ar()) {
            return false;
        }
        this.K();
        if (par1DamageSource.i() != null) {
            atc vec3 = par1DamageSource.i().aa();
            if (vec3 != null) {
                this.x = vec3.c;
                this.y = vec3.d;
                this.z = vec3.e;
                this.b = this.x * 0.1;
                this.c = this.y * 0.1;
                this.d = this.z * 0.1;
            }
            if (par1DamageSource.i() instanceof of) {
                this.a = (of)par1DamageSource.i();
            }
            return true;
        }
        return false;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public float S() {
        return 0.0f;
    }

    @Override
    public float d(float par1) {
        return 1.0f;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int c(float par1) {
        return 0xF000F0;
    }
}

