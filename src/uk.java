/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class uk
extends nn {
    private int a;
    private int b;

    public uk(abw par1World) {
        super(par1World);
        this.a(0.25f, 0.25f);
    }

    @Override
    protected void a() {
        this.ah.a(8, 5);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean a(double par1) {
        return par1 < 4096.0;
    }

    public uk(abw par1World, double par2, double par4, double par6, ye par8ItemStack) {
        super(par1World);
        this.a = 0;
        this.a(0.25f, 0.25f);
        this.b(par2, par4, par6);
        this.N = 0.0f;
        int i2 = 1;
        if (par8ItemStack != null && par8ItemStack.p()) {
            this.ah.b(8, par8ItemStack);
            by nbttagcompound = par8ItemStack.q();
            by nbttagcompound1 = nbttagcompound.l("Fireworks");
            if (nbttagcompound1 != null) {
                i2 += nbttagcompound1.c("Flight");
            }
        }
        this.x = this.ab.nextGaussian() * 0.001;
        this.z = this.ab.nextGaussian() * 0.001;
        this.y = 0.05;
        this.b = 10 * i2 + this.ab.nextInt(6) + this.ab.nextInt(7);
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
        this.x *= 1.15;
        this.z *= 1.15;
        this.y += 0.04;
        this.d(this.x, this.y, this.z);
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
        if (this.a == 0) {
            this.q.a(this, "fireworks.launch", 3.0f, 1.0f);
        }
        ++this.a;
        if (this.q.I && this.a % 2 < 2) {
            this.q.a("fireworksSpark", this.u, this.v - 0.3, this.w, this.ab.nextGaussian() * 0.05, -this.y * 0.5, this.ab.nextGaussian() * 0.05);
        }
        if (!this.q.I && this.a > this.b) {
            this.q.a((nn)this, (byte)17);
            this.x();
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(byte par1) {
        if (par1 == 17 && this.q.I) {
            ye itemstack = this.ah.f(8);
            by nbttagcompound = null;
            if (itemstack != null && itemstack.p()) {
                nbttagcompound = itemstack.q().l("Fireworks");
            }
            this.q.a(this.u, this.v, this.w, this.x, this.y, this.z, nbttagcompound);
        }
        super.a(par1);
    }

    @Override
    public void b(by par1NBTTagCompound) {
        par1NBTTagCompound.a("Life", this.a);
        par1NBTTagCompound.a("LifeTime", this.b);
        ye itemstack = this.ah.f(8);
        if (itemstack != null) {
            by nbttagcompound1 = new by();
            itemstack.b(nbttagcompound1);
            par1NBTTagCompound.a("FireworksItem", nbttagcompound1);
        }
    }

    @Override
    public void a(by par1NBTTagCompound) {
        ye itemstack;
        this.a = par1NBTTagCompound.e("Life");
        this.b = par1NBTTagCompound.e("LifeTime");
        by nbttagcompound1 = par1NBTTagCompound.l("FireworksItem");
        if (nbttagcompound1 != null && (itemstack = ye.a(nbttagcompound1)) != null) {
            this.ah.b(8, itemstack);
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public float S() {
        return 0.0f;
    }

    @Override
    public float d(float par1) {
        return super.d(par1);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int c(float par1) {
        return super.c(par1);
    }

    @Override
    public boolean aq() {
        return false;
    }
}

