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
public class bbm
extends bbo {
    public bcu a;

    public bbm() {
        this(0, 0, 32, 32);
    }

    public bbm(int par1, int par2, int par3, int par4) {
        this.t = par3;
        this.u = par4;
        this.a = new bcu(this, par1, par2);
        this.a.a(-3.0f, -6.0f, -3.0f, 6, 8, 6, 0.0f);
        this.a.a(0.0f, 0.0f, 0.0f);
    }

    public void a(nn par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
        this.a(par2, par3, par4, par5, par6, par7, par1Entity);
        this.a.a(par7);
    }

    public void a(float par1, float par2, float par3, float par4, float par5, float par6, nn par7Entity) {
        super.a(par1, par2, par3, par4, par5, par6, par7Entity);
        this.a.g = par4 / 57.295776f;
        this.a.f = par5 / 57.295776f;
    }
}

