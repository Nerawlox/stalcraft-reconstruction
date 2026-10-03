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
public class bbx
extends bbo {
    private bcu[] a = new bcu[7];
    private bcu[] b;
    private float[] c = new float[7];
    private static final int[][] d = new int[][]{{3, 2, 2}, {4, 3, 2}, {6, 4, 3}, {3, 3, 3}, {2, 2, 3}, {2, 1, 2}, {1, 1, 2}};
    private static final int[][] e = new int[][]{{0, 0}, {0, 4}, {0, 9}, {0, 16}, {0, 22}, {11, 0}, {13, 4}};

    public bbx() {
        float f2 = -3.5f;
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            this.a[i2] = new bcu(this, e[i2][0], e[i2][1]);
            this.a[i2].a((float)d[i2][0] * -0.5f, 0.0f, (float)d[i2][2] * -0.5f, d[i2][0], d[i2][1], d[i2][2]);
            this.a[i2].a(0.0f, 24 - d[i2][1], f2);
            this.c[i2] = f2;
            if (i2 >= this.a.length - 1) continue;
            f2 += (float)(d[i2][2] + d[i2 + 1][2]) * 0.5f;
        }
        this.b = new bcu[3];
        this.b[0] = new bcu(this, 20, 0);
        this.b[0].a(-5.0f, 0.0f, (float)d[2][2] * -0.5f, 10, 8, d[2][2]);
        this.b[0].a(0.0f, 16.0f, this.c[2]);
        this.b[1] = new bcu(this, 20, 11);
        this.b[1].a(-3.0f, 0.0f, (float)d[4][2] * -0.5f, 6, 4, d[4][2]);
        this.b[1].a(0.0f, 20.0f, this.c[4]);
        this.b[2] = new bcu(this, 20, 18);
        this.b[2].a(-3.0f, 0.0f, (float)d[4][2] * -0.5f, 6, 5, d[1][2]);
        this.b[2].a(0.0f, 19.0f, this.c[1]);
    }

    public void a(nn par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
        int i2;
        this.a(par2, par3, par4, par5, par6, par7, par1Entity);
        for (i2 = 0; i2 < this.a.length; ++i2) {
            this.a[i2].a(par7);
        }
        for (i2 = 0; i2 < this.b.length; ++i2) {
            this.b[i2].a(par7);
        }
    }

    public void a(float par1, float par2, float par3, float par4, float par5, float par6, nn par7Entity) {
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            this.a[i2].g = ls.b(par3 * 0.9f + (float)i2 * 0.15f * (float)Math.PI) * (float)Math.PI * 0.05f * (float)(1 + Math.abs(i2 - 2));
            this.a[i2].c = ls.a(par3 * 0.9f + (float)i2 * 0.15f * (float)Math.PI) * (float)Math.PI * 0.2f * (float)Math.abs(i2 - 2);
        }
        this.b[0].g = this.a[2].g;
        this.b[1].g = this.a[4].g;
        this.b[1].c = this.a[4].c;
        this.b[2].g = this.a[1].g;
        this.b[2].c = this.a[1].c;
    }
}

