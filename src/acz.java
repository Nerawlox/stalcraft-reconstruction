/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  acr
 *  afe
 */
import java.util.Random;

public class acz
extends acq {
    public acz(int par1) {
        super(par1);
        this.K.add(new acr(sf.class, 5, 4, 4));
        this.I.z = 10;
        this.I.B = 2;
    }

    @Override
    public afe a(Random par1Random) {
        return par1Random.nextInt(5) == 0 ? this.Q : (par1Random.nextInt(10) == 0 ? this.P : this.O);
    }
}

