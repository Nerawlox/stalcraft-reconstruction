/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  beg
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class bef
extends beg {
    float a;

    public bef(abw par1World, double par2, double par4, double par6, double par8, double par10, double par12) {
        this(par1World, par2, par4, par6, par8, par10, par12, 2.0f);
    }

    public bef(abw par1World, double par2, double par4, double par6, double par8, double par10, double par12, float par14) {
        super(par1World, par2, par4, par6, 0.0, 0.0, 0.0);
        this.x *= (double)0.01f;
        this.y *= (double)0.01f;
        this.z *= (double)0.01f;
        this.y += 0.2;
        this.j = ls.a(((float)par8 + 0.0f) * (float)Math.PI * 2.0f) * 0.65f + 0.35f;
        this.au = ls.a(((float)par8 + 0.33333334f) * (float)Math.PI * 2.0f) * 0.65f + 0.35f;
        this.av = ls.a(((float)par8 + 0.6666667f) * (float)Math.PI * 2.0f) * 0.65f + 0.35f;
        this.h *= 0.75f;
        this.h *= par14;
        this.a = this.h;
        this.g = 6;
        this.Z = false;
        this.i(64);
    }

    public void a(bfq par1Tessellator, float par2, float par3, float par4, float par5, float par6, float par7) {
        float f6 = ((float)this.f + par2) / (float)this.g * 32.0f;
        if (f6 < 0.0f) {
            f6 = 0.0f;
        }
        if (f6 > 1.0f) {
            f6 = 1.0f;
        }
        this.h = this.a * f6;
        super.a(par1Tessellator, par2, par3, par4, par5, par6, par7);
    }

    public void l_() {
        this.r = this.u;
        this.s = this.v;
        this.t = this.w;
        if (this.f++ >= this.g) {
            this.x();
        }
        this.d(this.x, this.y, this.z);
        if (this.v == this.s) {
            this.x *= 1.1;
            this.z *= 1.1;
        }
        this.x *= (double)0.66f;
        this.y *= (double)0.66f;
        this.z *= (double)0.66f;
        if (this.F) {
            this.x *= (double)0.7f;
            this.z *= (double)0.7f;
        }
    }
}

