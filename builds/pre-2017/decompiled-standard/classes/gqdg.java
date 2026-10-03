/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;

public class gqdg
extends uilx {
    public gqdg(int n) {
        super(n);
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        if (n2 > 3) {
            n2 = 3;
        }
        if (random.nextInt(10 - n2 * 3) == 0) {
            return tgdv.field_77804_ap.field_77779_bT;
        }
        return this.field_71990_ca;
    }
}

