/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class tc
extends nn {
    public int a;
    private of b;

    public tc(abw par1World) {
        super(par1World);
        this.m = true;
        this.a(0.98f, 0.98f);
        this.N = this.P / 2.0f;
    }

    public tc(abw par1World, double par2, double par4, double par6, of par8EntityLivingBase) {
        this(par1World);
        this.b(par2, par4, par6);
        float f2 = (float)(Math.random() * Math.PI * 2.0);
        this.x = -((float)Math.sin(f2)) * 0.02f;
        this.y = 0.2f;
        this.z = -((float)Math.cos(f2)) * 0.02f;
        this.a = 80;
        this.r = par2;
        this.s = par4;
        this.t = par6;
        this.b = par8EntityLivingBase;
    }

    @Override
    protected void a() {
    }

    @Override
    protected boolean e_() {
        return false;
    }

    @Override
    public boolean L() {
        return !this.M;
    }

    @Override
    public void l_() {
        this.r = this.u;
        this.s = this.v;
        this.t = this.w;
        this.y -= (double)0.04f;
        this.d(this.x, this.y, this.z);
        this.x *= (double)0.98f;
        this.y *= (double)0.98f;
        this.z *= (double)0.98f;
        if (this.F) {
            this.x *= (double)0.7f;
            this.z *= (double)0.7f;
            this.y *= -0.5;
        }
        if (this.a-- <= 0) {
            this.x();
            if (!this.q.I) {
                this.d();
            }
        } else {
            this.q.a("smoke", this.u, this.v + 0.5, this.w, 0.0, 0.0, 0.0);
        }
    }

    private void d() {
        float f2 = 4.0f;
        this.q.a(this, this.u, this.v, this.w, f2, true);
    }

    @Override
    protected void b(by par1NBTTagCompound) {
        par1NBTTagCompound.a("Fuse", (byte)this.a);
    }

    @Override
    protected void a(by par1NBTTagCompound) {
        this.a = par1NBTTagCompound.c("Fuse");
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public float S() {
        return 0.0f;
    }

    public of c() {
        return this.b;
    }
}

