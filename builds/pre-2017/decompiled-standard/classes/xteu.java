/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;

public class xteu
extends foqh {
    public xteu(int n) {
        super(n);
        this._K.clear();
        this._A = (byte)twgu.field_71939_E.field_71990_ca;
        this._B = (byte)twgu.field_71939_E.field_71990_ca;
        this._I.field_76832_z = -999;
        this._I.field_76804_C = 2;
        this._I.field_76799_E = 50;
        this._I.field_76800_F = 10;
    }

    @Override
    public void _a(ozlu ozlu2, Random random, int n, int n2) {
        super._a(ozlu2, random, n, n2);
        if (random.nextInt(1000) == 0) {
            int n3 = n + random.nextInt(16) + 8;
            int n4 = n2 + random.nextInt(16) + 8;
            zzmm zzmm2 = new zzmm();
            ((zzpm)zzmm2)._a(ozlu2, random, n3, ozlu2.func_72976_f(n3, n4) + 1, n4);
        }
    }
}

