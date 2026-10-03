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
public class bba
extends bbo {
    private bcu[] a = new bcu[12];
    private bcu b;

    public bba() {
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            this.a[i2] = new bcu(this, 0, 16);
            this.a[i2].a(0.0f, 0.0f, 0.0f, 2, 8, 2);
        }
        this.b = new bcu(this, 0, 0);
        this.b.a(-4.0f, -4.0f, -4.0f, 8, 8, 8);
    }

    public int a() {
        return 8;
    }

    public void a(nn par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
        this.a(par2, par3, par4, par5, par6, par7, par1Entity);
        this.b.a(par7);
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            this.a[i2].a(par7);
        }
    }

    public void a(float par1, float par2, float par3, float par4, float par5, float par6, nn par7Entity) {
        int i2;
        float f6 = par3 * (float)Math.PI * -0.1f;
        for (i2 = 0; i2 < 4; ++i2) {
            this.a[i2].d = -2.0f + ls.b(((float)(i2 * 2) + par3) * 0.25f);
            this.a[i2].c = ls.b(f6) * 9.0f;
            this.a[i2].e = ls.a(f6) * 9.0f;
            f6 += 1.0f;
        }
        f6 = 0.7853982f + par3 * (float)Math.PI * 0.03f;
        for (i2 = 4; i2 < 8; ++i2) {
            this.a[i2].d = 2.0f + ls.b(((float)(i2 * 2) + par3) * 0.25f);
            this.a[i2].c = ls.b(f6) * 7.0f;
            this.a[i2].e = ls.a(f6) * 7.0f;
            f6 += 1.0f;
        }
        f6 = 0.47123894f + par3 * (float)Math.PI * -0.05f;
        for (i2 = 8; i2 < 12; ++i2) {
            this.a[i2].d = 11.0f + ls.b(((float)i2 * 1.5f + par3) * 0.5f);
            this.a[i2].c = ls.b(f6) * 5.0f;
            this.a[i2].e = ls.a(f6) * 5.0f;
            f6 += 1.0f;
        }
        this.b.g = par4 / 57.295776f;
        this.b.f = par5 / 57.295776f;
    }
}

