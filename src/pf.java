/*
 * Decompiled with CFR 0.152.
 */
public class pf {
    private og a;
    private double b;
    private double c;
    private double d;
    private double e;
    private boolean f;

    public pf(og par1EntityLiving) {
        this.a = par1EntityLiving;
        this.b = par1EntityLiving.u;
        this.c = par1EntityLiving.v;
        this.d = par1EntityLiving.w;
    }

    public boolean a() {
        return this.f;
    }

    public double b() {
        return this.e;
    }

    public void a(double par1, double par3, double par5, double par7) {
        this.b = par1;
        this.c = par3;
        this.d = par5;
        this.e = par7;
        this.f = true;
    }

    public void c() {
        this.a.n(0.0f);
        if (this.f) {
            double d1;
            this.f = false;
            double d0 = this.b - this.a.u;
            int i2 = ls.c(this.a.E.b + 0.5);
            double d2 = this.c - (double)i2;
            double d3 = d0 * d0 + d2 * d2 + (d1 = this.d - this.a.w) * d1;
            if (d3 >= 2.500000277905201E-7) {
                float f2 = (float)(Math.atan2(d1, d0) * 180.0 / Math.PI) - 90.0f;
                this.a.A = this.a(this.a.A, f2, 30.0f);
                this.a.i((float)(this.e * this.a.a(tp.d).e()));
                if (d2 > 0.0 && d0 * d0 + d1 * d1 < 1.0) {
                    this.a.j().a();
                }
            }
        }
    }

    private float a(float par1, float par2, float par3) {
        float f3 = ls.g(par2 - par1);
        if (f3 > par3) {
            f3 = par3;
        }
        if (f3 < -par3) {
            f3 = -par3;
        }
        return par1 + f3;
    }
}

