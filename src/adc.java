/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  acr
 *  afe
 *  afz
 *  agb
 */
import java.util.Random;

public class adc
extends acq {
    public adc(int par1) {
        super(par1);
        this.I.z = 50;
        this.I.B = 25;
        this.I.A = 4;
        this.J.add(new acr(rx.class, 2, 1, 1));
        this.K.add(new acr(rq.class, 10, 4, 4));
    }

    @Override
    public afe a(Random par1Random) {
        return par1Random.nextInt(10) == 0 ? this.P : (par1Random.nextInt(2) == 0 ? new afg(3, 0) : (par1Random.nextInt(3) == 0 ? new afo(false, 10 + par1Random.nextInt(20), 3, 3) : new aga(false, 4 + par1Random.nextInt(7), 3, 3, true)));
    }

    @Override
    public afe b(Random par1Random) {
        return par1Random.nextInt(4) == 0 ? new afz(aqz.ac.cF, 2) : new afz(aqz.ac.cF, 1);
    }

    @Override
    public void a(abw par1World, Random par2Random, int par3, int par4) {
        super.a(par1World, par2Random, par3, par4);
        agb worldgenvines = new agb();
        for (int k = 0; k < 50; ++k) {
            int l = par3 + par2Random.nextInt(16) + 8;
            int b0 = 64;
            int i1 = par4 + par2Random.nextInt(16) + 8;
            worldgenvines.a(par1World, par2Random, l, b0, i1);
        }
    }
}

