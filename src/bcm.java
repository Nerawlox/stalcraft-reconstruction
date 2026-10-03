/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class bcm
extends bbj {
    public bcm() {
        this(0.0f, false);
    }

    protected bcm(float par1, float par2, int par3, int par4) {
        super(par1, par2, par3, par4);
    }

    public bcm(float par1, boolean par2) {
        super(par1, 0.0f, 64, par2 ? 32 : 64);
    }

    @Override
    public void a(float par1, float par2, float par3, float par4, float par5, float par6, nn par7Entity) {
        super.a(par1, par2, par3, par4, par5, par6, par7Entity);
        float f6 = ls.a(this.p * (float)Math.PI);
        float f7 = ls.a((1.0f - (1.0f - this.p) * (1.0f - this.p)) * (float)Math.PI);
        this.f.h = 0.0f;
        this.g.h = 0.0f;
        this.f.g = -(0.1f - f6 * 0.6f);
        this.g.g = 0.1f - f6 * 0.6f;
        this.f.f = -1.5707964f;
        this.g.f = -1.5707964f;
        this.f.f -= f6 * 1.2f - f7 * 0.4f;
        this.g.f -= f6 * 1.2f - f7 * 0.4f;
        this.f.h += ls.b(par3 * 0.09f) * 0.05f + 0.05f;
        this.g.h -= ls.b(par3 * 0.09f) * 0.05f + 0.05f;
        this.f.f += ls.a(par3 * 0.067f) * 0.05f;
        this.g.f -= ls.a(par3 * 0.067f) * 0.05f;
    }
}

