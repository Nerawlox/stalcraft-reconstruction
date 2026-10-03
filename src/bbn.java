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
public class bbn
extends bbo {
    public bcu[] a = new bcu[7];

    public bbn() {
        this.a[0] = new bcu(this, 0, 10);
        this.a[1] = new bcu(this, 0, 0);
        this.a[2] = new bcu(this, 0, 0);
        this.a[3] = new bcu(this, 0, 0);
        this.a[4] = new bcu(this, 0, 0);
        this.a[5] = new bcu(this, 44, 10);
        int b0 = 20;
        int b1 = 8;
        int b2 = 16;
        int b3 = 4;
        this.a[0].a(-b0 / 2, (float)(-b2 / 2), -1.0f, b0, b2, 2, 0.0f);
        this.a[0].a(0.0f, b3, 0.0f);
        this.a[5].a(-b0 / 2 + 1, (float)(-b2 / 2 + 1), -1.0f, b0 - 2, b2 - 2, 1, 0.0f);
        this.a[5].a(0.0f, b3, 0.0f);
        this.a[1].a(-b0 / 2 + 2, (float)(-b1 - 1), -1.0f, b0 - 4, b1, 2, 0.0f);
        this.a[1].a(-b0 / 2 + 1, b3, 0.0f);
        this.a[2].a(-b0 / 2 + 2, (float)(-b1 - 1), -1.0f, b0 - 4, b1, 2, 0.0f);
        this.a[2].a(b0 / 2 - 1, b3, 0.0f);
        this.a[3].a(-b0 / 2 + 2, (float)(-b1 - 1), -1.0f, b0 - 4, b1, 2, 0.0f);
        this.a[3].a(0.0f, b3, -b2 / 2 + 1);
        this.a[4].a(-b0 / 2 + 2, (float)(-b1 - 1), -1.0f, b0 - 4, b1, 2, 0.0f);
        this.a[4].a(0.0f, b3, b2 / 2 - 1);
        this.a[0].f = 1.5707964f;
        this.a[1].g = 4.712389f;
        this.a[2].g = 1.5707964f;
        this.a[3].g = (float)Math.PI;
        this.a[5].f = -1.5707964f;
    }

    public void a(nn par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
        this.a[5].d = 4.0f - par4;
        for (int i2 = 0; i2 < 6; ++i2) {
            this.a[i2].a(par7);
        }
    }
}

