/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.util.vjvn;

public class ukai
extends zzpm {
    public final vjvn[] _a;
    public final int _b;

    public ukai(vjvn[] vjvnArray, int n) {
        this._a = vjvnArray;
        this._b = n;
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, int n, int n2, int n3) {
        int n4 = 0;
        while (((n4 = ozlu2.func_72798_a(n, n2, n3)) == 0 || n4 == twgu.field_71952_K.field_71990_ca) && n2 > 1) {
            --n2;
        }
        if (n2 < 1) {
            return false;
        }
        ++n2;
        for (int i = 0; i < 4; ++i) {
            int n5;
            int n6;
            int n7 = n + random.nextInt(4) - random.nextInt(4);
            if (!ozlu2.func_72799_c(n7, n6 = n2 + random.nextInt(3) - random.nextInt(3), n5 = n3 + random.nextInt(4) - random.nextInt(4)) || !ozlu2.func_72797_t(n7, n6 - 1, n5)) continue;
            ozlu2.func_72832_d(n7, n6, n5, twgu.field_72077_au.field_71990_ca, 0, 2);
            yfav yfav2 = (yfav)ozlu2.func_72796_p(n7, n6, n5);
            if (yfav2 != null && yfav2 != null) {
                vjvn._a(random, this._a, yfav2, this._b);
            }
            if (ozlu2.func_72799_c(n7 - 1, n6, n5) && ozlu2.func_72797_t(n7 - 1, n6 - 1, n5)) {
                ozlu2.func_72832_d(n7 - 1, n6, n5, twgu.field_72069_aq.field_71990_ca, 0, 2);
            }
            if (ozlu2.func_72799_c(n7 + 1, n6, n5) && ozlu2.func_72797_t(n7 - 1, n6 - 1, n5)) {
                ozlu2.func_72832_d(n7 + 1, n6, n5, twgu.field_72069_aq.field_71990_ca, 0, 2);
            }
            if (ozlu2.func_72799_c(n7, n6, n5 - 1) && ozlu2.func_72797_t(n7 - 1, n6 - 1, n5)) {
                ozlu2.func_72832_d(n7, n6, n5 - 1, twgu.field_72069_aq.field_71990_ca, 0, 2);
            }
            if (ozlu2.func_72799_c(n7, n6, n5 + 1) && ozlu2.func_72797_t(n7 - 1, n6 - 1, n5)) {
                ozlu2.func_72832_d(n7, n6, n5 + 1, twgu.field_72069_aq.field_71990_ca, 0, 2);
            }
            return true;
        }
        return false;
    }
}

