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
public class bck
extends bbo {
    private bcu[] a;
    private bcu[] b;

    public bck() {
        this.t = 64;
        this.u = 64;
        this.a = new bcu[3];
        this.a[0] = new bcu(this, 0, 16);
        this.a[0].a(-10.0f, 3.9f, -0.5f, 20, 3, 3);
        this.a[1] = new bcu(this).b(this.t, this.u);
        this.a[1].a(-2.0f, 6.9f, -0.5f);
        this.a[1].a(0, 22).a(0.0f, 0.0f, 0.0f, 3, 10, 3);
        this.a[1].a(24, 22).a(-4.0f, 1.5f, 0.5f, 11, 2, 2);
        this.a[1].a(24, 22).a(-4.0f, 4.0f, 0.5f, 11, 2, 2);
        this.a[1].a(24, 22).a(-4.0f, 6.5f, 0.5f, 11, 2, 2);
        this.a[2] = new bcu(this, 12, 22);
        this.a[2].a(0.0f, 0.0f, 0.0f, 3, 6, 3);
        this.b = new bcu[3];
        this.b[0] = new bcu(this, 0, 0);
        this.b[0].a(-4.0f, -4.0f, -4.0f, 8, 8, 8);
        this.b[1] = new bcu(this, 32, 0);
        this.b[1].a(-4.0f, -4.0f, -4.0f, 6, 6, 6);
        this.b[1].c = -8.0f;
        this.b[1].d = 4.0f;
        this.b[2] = new bcu(this, 32, 0);
        this.b[2].a(-4.0f, -4.0f, -4.0f, 6, 6, 6);
        this.b[2].c = 10.0f;
        this.b[2].d = 4.0f;
    }

    public int a() {
        return 32;
    }

    public void a(nn par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
        this.a(par2, par3, par4, par5, par6, par7, par1Entity);
        for (bcu modelrenderer : this.b) {
            modelrenderer.a(par7);
        }
        for (bcu modelrenderer : this.a) {
            modelrenderer.a(par7);
        }
    }

    public void a(float par1, float par2, float par3, float par4, float par5, float par6, nn par7Entity) {
        float f6 = ls.b(par3 * 0.1f);
        this.a[1].f = (0.065f + 0.05f * f6) * (float)Math.PI;
        this.a[2].a(-2.0f, 6.9f + ls.b(this.a[1].f) * 10.0f, -0.5f + ls.a(this.a[1].f) * 10.0f);
        this.a[2].f = (0.265f + 0.1f * f6) * (float)Math.PI;
        this.b[0].g = par4 / 57.295776f;
        this.b[0].f = par5 / 57.295776f;
    }

    public void a(of par1EntityLivingBase, float par2, float par3, float par4) {
        sm entitywither = (sm)par1EntityLivingBase;
        for (int i2 = 1; i2 < 3; ++i2) {
            this.b[i2].g = (entitywither.a(i2 - 1) - par1EntityLivingBase.aN) / 57.295776f;
            this.b[i2].f = entitywither.c(i2 - 1) / 57.295776f;
        }
    }
}

