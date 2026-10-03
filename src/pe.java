/*
 * Decompiled with CFR 0.152.
 */
public class pe {
    private og a;
    private float b;
    private float c;
    private boolean d;
    private double e;
    private double f;
    private double g;

    public pe(og par1EntityLiving) {
        this.a = par1EntityLiving;
    }

    public void a(nn par1Entity, float par2, float par3) {
        this.e = par1Entity.u;
        this.f = par1Entity instanceof of ? par1Entity.v + (double)par1Entity.f() : (par1Entity.E.b + par1Entity.E.e) / 2.0;
        this.g = par1Entity.w;
        this.b = par2;
        this.c = par3;
        this.d = true;
    }

    public void a(double par1, double par3, double par5, float par7, float par8) {
        this.e = par1;
        this.f = par3;
        this.g = par5;
        this.b = par7;
        this.c = par8;
        this.d = true;
    }

    public void a() {
        this.a.B = 0.0f;
        if (this.d) {
            this.d = false;
            double d0 = this.e - this.a.u;
            double d1 = this.f - (this.a.v + (double)this.a.f());
            double d2 = this.g - this.a.w;
            double d3 = ls.a(d0 * d0 + d2 * d2);
            float f2 = (float)(Math.atan2(d2, d0) * 180.0 / Math.PI) - 90.0f;
            float f1 = (float)(-(Math.atan2(d1, d3) * 180.0 / Math.PI));
            this.a.B = this.a(this.a.B, f1, this.c);
            this.a.aP = this.a(this.a.aP, f2, this.b);
        } else {
            this.a.aP = this.a(this.a.aP, this.a.aN, 10.0f);
        }
        float f2 = ls.g(this.a.aP - this.a.aN);
        if (!this.a.k().g()) {
            if (f2 < -75.0f) {
                this.a.aP = this.a.aN - 75.0f;
            }
            if (f2 > 75.0f) {
                this.a.aP = this.a.aN + 75.0f;
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

