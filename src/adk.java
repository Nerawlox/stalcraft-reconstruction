/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  acr
 *  adl
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  tg
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class adk
extends acq {
    public adk(int par1) {
        super(par1);
        this.J.clear();
        this.K.clear();
        this.L.clear();
        this.M.clear();
        this.J.add(new acr(tg.class, 10, 4, 4));
        this.A = (byte)aqz.A.cF;
        this.B = (byte)aqz.A.cF;
        this.I = new adl((acq)this);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int a(float par1) {
        return 0;
    }
}

