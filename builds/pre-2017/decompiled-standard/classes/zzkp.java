/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;

public class zzkp
extends foqh {
    public zzpm _U;

    public zzkp(int n) {
        super(n);
        this._U = new qoqx(twgu.field_72006_bl.field_71990_ca, 8);
    }

    @Override
    public void _a(ozlu ozlu2, Random random, int n, int n2) {
        int n3;
        int n4;
        int n5;
        super._a(ozlu2, random, n, n2);
        int n6 = 3 + random.nextInt(6);
        for (n5 = 0; n5 < n6; ++n5) {
            int n7;
            n4 = n + random.nextInt(16);
            int n8 = ozlu2.func_72798_a(n4, n3 = random.nextInt(28) + 4, n7 = n2 + random.nextInt(16));
            if (n8 != twgu.field_71981_t.field_71990_ca) continue;
            ozlu2.func_72832_d(n4, n3, n7, twgu.field_72068_bR.field_71990_ca, 0, 2);
        }
        for (n6 = 0; n6 < 7; ++n6) {
            n5 = n + random.nextInt(16);
            n4 = random.nextInt(64);
            n3 = n2 + random.nextInt(16);
            this._U._a(ozlu2, random, n5, n4, n3);
        }
    }
}

