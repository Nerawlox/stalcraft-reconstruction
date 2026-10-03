/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.util.owak;
import net.minecraft.util.ugqx;

public class cflv
extends zzpm {
    @Override
    public boolean _a(ozlu ozlu2, Random random, int n, int n2, int n3) {
        int n4 = n;
        int n5 = n3;
        while (n2 < 128) {
            if (ozlu2.func_72799_c(n, n2, n3)) {
                for (int i = 2; i <= 5; ++i) {
                    if (!twgu.field_71998_bu.func_71850_a_(ozlu2, n, n2, n3, i)) continue;
                    ozlu2.func_72832_d(n, n2, n3, twgu.field_71998_bu.field_71990_ca, 1 << ugqx._e[owak._a[i]], 2);
                    break;
                }
            } else {
                n = n4 + random.nextInt(4) - random.nextInt(4);
                n3 = n5 + random.nextInt(4) - random.nextInt(4);
            }
            ++n2;
        }
        return true;
    }
}

