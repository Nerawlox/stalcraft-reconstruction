/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  acr
 *  afe
 */
import java.util.Random;

public class adj
extends acq {
    public adj(int par1) {
        super(par1);
        this.K.add(new acr(sf.class, 8, 4, 4));
        this.I.z = 10;
        this.I.B = 1;
    }

    @Override
    public afe a(Random par1Random) {
        return par1Random.nextInt(3) == 0 ? new afr() : new afx(false);
    }
}

