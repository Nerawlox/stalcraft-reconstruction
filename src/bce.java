/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bbo
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class bce
extends bbo {
    bcu a;
    bcu[] b = new bcu[8];

    public bce() {
        int b0 = -16;
        this.a = new bcu(this, 0, 0);
        this.a.a(-6.0f, -8.0f, -6.0f, 12, 16, 12);
        this.a.d += (float)(24 + b0);
        for (int i2 = 0; i2 < this.b.length; ++i2) {
            this.b[i2] = new bcu(this, 48, 0);
            double d0 = (double)i2 * Math.PI * 2.0 / (double)this.b.length;
            float f2 = (float)Math.cos(d0) * 5.0f;
            float f1 = (float)Math.sin(d0) * 5.0f;
            this.b[i2].a(-1.0f, 0.0f, -1.0f, 2, 18, 2);
            this.b[i2].c = f2;
            this.b[i2].e = f1;
            this.b[i2].d = 31 + b0;
            d0 = (double)i2 * Math.PI * -2.0 / (double)this.b.length + 1.5707963267948966;
            this.b[i2].g = (float)d0;
        }
    }

    public void a(float par1, float par2, float par3, float par4, float par5, float par6, nn par7Entity) {
        for (bcu modelrenderer : this.b) {
            modelrenderer.f = par3;
        }
    }

    public void a(nn par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
        this.a(par2, par3, par4, par5, par6, par7, par1Entity);
        this.a.a(par7);
        for (int i2 = 0; i2 < this.b.length; ++i2) {
            this.b[i2].a(par7);
        }
    }
}

