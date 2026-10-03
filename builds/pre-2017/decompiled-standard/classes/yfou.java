/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;

public class yfou
extends tycc {
    public yfou() {
    }

    public yfou(ozlu ozlu2, Random random, int n, int n2) {
        super(n, n2);
        nwmc nwmc2 = new nwmc(0, random, (n << 4) + 2, (n2 << 4) + 2);
        this._a.add(nwmc2);
        nwmc2._a(nwmc2, this._a, random);
        this._c();
        this._a(ozlu2, random, 10);
    }
}

