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
public class bdw
extends beg {
    protected bdw(abw par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
        this.g = 4;
    }

    public void a(bfq par1Tessellator, float par2, float par3, float par4, float par5, float par6, float par7) {
        float f6 = 0.25f;
        float f7 = f6 + 0.25f;
        float f8 = 0.125f;
        float f9 = f8 + 0.25f;
        float f10 = 7.1f * ls.a(((float)this.f + par2 - 1.0f) * 0.25f * (float)Math.PI);
        this.aw = 0.6f - ((float)this.f + par2 - 1.0f) * 0.25f * 0.5f;
        float f11 = (float)(this.r + (this.u - this.r) * (double)par2 - ay);
        float f12 = (float)(this.s + (this.v - this.s) * (double)par2 - az);
        float f13 = (float)(this.t + (this.w - this.t) * (double)par2 - aA);
        par1Tessellator.a(this.j, this.au, this.av, this.aw);
        par1Tessellator.a(f11 - par3 * f10 - par6 * f10, f12 - par4 * f10, f13 - par5 * f10 - par7 * f10, f7, f9);
        par1Tessellator.a(f11 - par3 * f10 + par6 * f10, f12 + par4 * f10, f13 - par5 * f10 + par7 * f10, f7, f8);
        par1Tessellator.a(f11 + par3 * f10 + par6 * f10, f12 + par4 * f10, f13 + par5 * f10 + par7 * f10, f6, f8);
        par1Tessellator.a(f11 + par3 * f10 - par6 * f10, f12 - par4 * f10, f13 + par5 * f10 - par7 * f10, f6, f9);
    }
}

