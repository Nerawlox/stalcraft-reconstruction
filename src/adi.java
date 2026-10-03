/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  abs
 *  abv
 *  acr
 *  afe
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

public class adi
extends acq {
    protected adi(int par1) {
        super(par1);
        this.I.z = 2;
        this.I.A = -999;
        this.I.C = 1;
        this.I.D = 8;
        this.I.E = 10;
        this.I.I = 1;
        this.I.y = 4;
        this.H = 14745518;
        this.J.add(new acr(ts.class, 1, 1, 1));
    }

    @Override
    public afe a(Random par1Random) {
        return this.R;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int k() {
        double d0 = this.j();
        double d1 = this.i();
        return ((abv.a((double)d0, (double)d1) & 0xFEFEFE) + 0x4E0E4E) / 2;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int l() {
        double d0 = this.j();
        double d1 = this.i();
        return ((abs.a((double)d0, (double)d1) & 0xFEFEFE) + 0x4E0E4E) / 2;
    }
}

