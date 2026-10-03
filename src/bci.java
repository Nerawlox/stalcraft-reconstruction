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
public class bci
extends bbj {
    public bci() {
        this(0.0f, 0.0f, false);
    }

    public bci(float par1, float par2, boolean par3) {
        super(par1, 0.0f, 64, par3 ? 32 : 64);
        if (par3) {
            this.c = new bcu(this, 0, 0);
            this.c.a(-4.0f, -10.0f, -4.0f, 8, 6, 8, par1);
            this.c.a(0.0f, 0.0f + par2, 0.0f);
        } else {
            this.c = new bcu(this);
            this.c.a(0.0f, 0.0f + par2, 0.0f);
            this.c.a(0, 32).a(-4.0f, -10.0f, -4.0f, 8, 10, 8, par1);
            this.c.a(24, 32).a(-1.0f, -3.0f, -6.0f, 2, 4, 2, par1);
        }
    }

    public int a() {
        return 10;
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

