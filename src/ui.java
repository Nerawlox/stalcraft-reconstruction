/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ui
extends nn {
    private double a;
    private double b;
    private double c;
    private int d;
    private boolean e;

    public ui(abw par1World) {
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

    public ui(abw par1World, double par2, double par4, double par6) {
        super(par1World);
        this.d = 0;
        this.a(0.25f, 0.25f);
        this.b(par2, par4, par6);
        this.N = 0.0f;
    }

    public void a(double par1, int par3, double par4) {
        double d2 = par1 - this.u;
        double d3 = par4 - this.w;
        float f2 = ls.a(d2 * d2 + d3 * d3);
        if (f2 > 12.0f) {
            this.a = this.u + d2 / (double)f2 * 12.0;
            this.c = this.w + d3 / (double)f2 * 12.0;
            this.b = this.v + 8.0;
        } else {
            this.a = par1;
            this.b = par3;
            this.c = par4;
        }
        this.d = 0;
        this.e = this.ab.nextInt(5) > 0;
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
        if (!this.q.I) {
            double d0 = this.a - this.u;
            double d1 = this.c - this.w;
            float f1 = (float)Math.sqrt(d0 * d0 + d1 * d1);
            float f22 = (float)Math.atan2(d1, d0);
            double d2 = (double)f2 + (double)(f1 - f2) * 0.0025;
            if (f1 < 1.0f) {
                d2 *= 0.8;
                this.y *= 0.8;
            }
            this.x = Math.cos(f22) * d2;
            this.z = Math.sin(f22) * d2;
            this.y = this.v < this.b ? (this.y += (1.0 - this.y) * (double)0.015f) : (this.y += (-1.0 - this.y) * (double)0.015f);
        }
        float f3 = 0.25f;
        if (this.H()) {
            for (int i2 = 0; i2 < 4; ++i2) {
                this.q.a("bubble", this.u - this.x * (double)f3, this.v - this.y * (double)f3, this.w - this.z * (double)f3, this.x, this.y, this.z);
            }
        } else {
            this.q.a("portal", this.u - this.x * (double)f3 + this.ab.nextDouble() * 0.6 - 0.3, this.v - this.y * (double)f3 - 0.5, this.w - this.z * (double)f3 + this.ab.nextDouble() * 0.6 - 0.3, this.x, this.y, this.z);
        }
        if (!this.q.I) {
            this.b(this.u, this.v, this.w);
            ++this.d;
            if (this.d > 80 && !this.q.I) {
                this.x();
                if (this.e) {
                    this.q.d(new ss(this.q, this.u, this.v, this.w, new ye(yc.bC)));
                } else {
                    this.q.e(2003, (int)Math.round(this.u), (int)Math.round(this.v), (int)Math.round(this.w), 0);
                }
            }
        }
    }

    @Override
    public void b(by par1NBTTagCompound) {
    }

    @Override
    public void a(by par1NBTTagCompound) {
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

    @Override
    public boolean aq() {
        return false;
    }
}

