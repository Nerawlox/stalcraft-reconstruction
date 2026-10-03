/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraftforge.common.ForgeDirection;

public class rqca
extends aorr {
    public rqca(int n) {
        super(n);
        float f = 0.2f;
        this.func_71905_a(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, f * 2.0f, 0.5f + f);
        this.func_71907_b(true);
    }

    @Override
    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
        if (random.nextInt(25) == 0) {
            int n4;
            int n5;
            int n6;
            int n7 = 4;
            int n8 = 5;
            for (n6 = n - n7; n6 <= n + n7; ++n6) {
                for (n5 = n3 - n7; n5 <= n3 + n7; ++n5) {
                    for (n4 = n2 - 1; n4 <= n2 + 1; ++n4) {
                        if (ozlu2.func_72798_a(n6, n4, n5) != this.field_71990_ca || --n8 > 0) continue;
                        return;
                    }
                }
            }
            n6 = n + random.nextInt(3) - 1;
            n5 = n2 + random.nextInt(2) - random.nextInt(2);
            n4 = n3 + random.nextInt(3) - 1;
            for (int i = 0; i < 4; ++i) {
                if (ozlu2.func_72799_c(n6, n5, n4) && this.func_71854_d(ozlu2, n6, n5, n4)) {
                    n = n6;
                    n2 = n5;
                    n3 = n4;
                }
                n6 = n + random.nextInt(3) - 1;
                n5 = n2 + random.nextInt(2) - random.nextInt(2);
                n4 = n3 + random.nextInt(3) - 1;
            }
            if (ozlu2.func_72799_c(n6, n5, n4) && this.func_71854_d(ozlu2, n6, n5, n4)) {
                ozlu2.func_72832_d(n6, n5, n4, this.field_71990_ca, 0, 2);
            }
        }
    }

    @Override
    public boolean func_71930_b(ozlu ozlu2, int n, int n2, int n3) {
        return super.func_71930_b(ozlu2, n, n2, n3) && this.func_71854_d(ozlu2, n, n2, n3);
    }

    @Override
    public boolean _a(int n) {
        return twgu.field_71970_n[n];
    }

    @Override
    public boolean func_71854_d(ozlu ozlu2, int n, int n2, int n3) {
        if (n2 >= 0 && n2 < 256) {
            int n4 = ozlu2.func_72798_a(n, n2 - 1, n3);
            twgu twgu2 = twgu.field_71973_m[n4];
            return (n4 == twgu.field_71994_by.field_71990_ca || ozlu2.func_72883_k(n, n2, n3) < 13) && twgu2 != null && twgu2.canSustainPlant(ozlu2, n, n2 - 1, n3, ForgeDirection.UP, this);
        }
        return false;
    }

    public boolean _a(ozlu ozlu2, int n, int n2, int n3, Random random) {
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        ozlu2.func_94571_i(n, n2, n3);
        foso foso2 = null;
        if (this.field_71990_ca == twgu.field_72109_af.field_71990_ca) {
            foso2 = new foso(0);
        } else if (this.field_71990_ca == twgu.field_72103_ag.field_71990_ca) {
            foso2 = new foso(1);
        }
        if (foso2 != null && foso2._a(ozlu2, random, n, n2, n3)) {
            return true;
        }
        ozlu2.func_72832_d(n, n2, n3, this.field_71990_ca, n4, 3);
        return false;
    }
}

