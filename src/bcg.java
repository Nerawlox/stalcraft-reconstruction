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
public class bcg
extends bbo {
    public bcu a;
    public bcu b;
    public bcu c;
    public bcu d;
    public bcu e;
    public bcu f;

    public bcg() {
        this(0.0f);
    }

    public bcg(float par1) {
        this(par1, -7.0f);
    }

    public bcg(float par1, float par2) {
        int short1 = 128;
        int short2 = 128;
        this.a = new bcu(this).b(short1, short2);
        this.a.a(0.0f, 0.0f + par2, -2.0f);
        this.a.a(0, 0).a(-4.0f, -12.0f, -5.5f, 8, 10, 8, par1);
        this.a.a(24, 0).a(-1.0f, -5.0f, -7.5f, 2, 4, 2, par1);
        this.b = new bcu(this).b(short1, short2);
        this.b.a(0.0f, 0.0f + par2, 0.0f);
        this.b.a(0, 40).a(-9.0f, -2.0f, -6.0f, 18, 12, 11, par1);
        this.b.a(0, 70).a(-4.5f, 10.0f, -3.0f, 9, 5, 6, par1 + 0.5f);
        this.c = new bcu(this).b(short1, short2);
        this.c.a(0.0f, -7.0f, 0.0f);
        this.c.a(60, 21).a(-13.0f, -2.5f, -3.0f, 4, 30, 6, par1);
        this.d = new bcu(this).b(short1, short2);
        this.d.a(0.0f, -7.0f, 0.0f);
        this.d.a(60, 58).a(9.0f, -2.5f, -3.0f, 4, 30, 6, par1);
        this.e = new bcu(this, 0, 22).b(short1, short2);
        this.e.a(-4.0f, 18.0f + par2, 0.0f);
        this.e.a(37, 0).a(-3.5f, -3.0f, -3.0f, 6, 16, 5, par1);
        this.f = new bcu(this, 0, 22).b(short1, short2);
        this.f.i = true;
        this.f.a(60, 0).a(5.0f, 18.0f + par2, 0.0f);
        this.f.a(-3.5f, -3.0f, -3.0f, 6, 16, 5, par1);
    }

    public void a(nn par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
        this.a(par2, par3, par4, par5, par6, par7, par1Entity);
        this.a.a(par7);
        this.b.a(par7);
        this.e.a(par7);
        this.f.a(par7);
        this.c.a(par7);
        this.d.a(par7);
    }

    public void a(float par1, float par2, float par3, float par4, float par5, float par6, nn par7Entity) {
        this.a.g = par4 / 57.295776f;
        this.a.f = par5 / 57.295776f;
        this.e.f = -1.5f * this.a(par1, 13.0f) * par2;
        this.f.f = 1.5f * this.a(par1, 13.0f) * par2;
        this.e.g = 0.0f;
        this.f.g = 0.0f;
    }

    public void a(of par1EntityLivingBase, float par2, float par3, float par4) {
        sd entityirongolem = (sd)((Object)par1EntityLivingBase);
        int i2 = entityirongolem.bU();
        if (i2 > 0) {
            this.c.f = -2.0f + 1.5f * this.a((float)i2 - par4, 10.0f);
            this.d.f = -2.0f + 1.5f * this.a((float)i2 - par4, 10.0f);
        } else {
            int j2 = entityirongolem.bV();
            if (j2 > 0) {
                this.c.f = -0.8f + 0.025f * this.a(j2, 70.0f);
                this.d.f = 0.0f;
            } else {
                this.c.f = (-0.2f + 1.5f * this.a(par2, 13.0f)) * par3;
                this.d.f = (-0.2f - 1.5f * this.a(par2, 13.0f)) * par3;
            }
        }
    }

    private float a(float par1, float par2) {
        return (Math.abs(par1 % par2 - par2 * 0.5f) - par2 * 0.25f) / (par2 * 0.25f);
    }
}

