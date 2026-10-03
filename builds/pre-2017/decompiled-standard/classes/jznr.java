/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;

public class jznr
extends ogyy {
    public jznr(int n, tflj tflj2) {
        super(n, tflj2);
        this.func_71907_b(false);
        if (tflj2 == tflj._i) {
            this.func_71907_b(true);
        }
    }

    @Override
    public boolean func_71918_c(sdrg sdrg2, int n, int n2, int n3) {
        return this.field_72018_cp != tflj._i;
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        super.func_71863_a(ozlu2, n, n2, n3, n4);
        if (ozlu2.func_72798_a(n, n2, n3) == this.field_71990_ca) {
            this._a(ozlu2, n, n2, n3);
        }
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3) {
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        ozlu2.func_72832_d(n, n2, n3, this.field_71990_ca - 1, n4, 2);
        ozlu2.func_72836_a(n, n2, n3, this.field_71990_ca - 1, this.func_71859_p_(ozlu2));
    }

    @Override
    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
        if (this.field_72018_cp == tflj._i) {
            int n4;
            int n5;
            int n6 = random.nextInt(3);
            for (n5 = 0; n5 < n6; ++n5) {
                n4 = ozlu2.func_72798_a(n += random.nextInt(3) - 1, ++n2, n3 += random.nextInt(3) - 1);
                if (n4 == 0) {
                    if (!this._b(ozlu2, n - 1, n2, n3) && !this._b(ozlu2, n + 1, n2, n3) && !this._b(ozlu2, n, n2, n3 - 1) && !this._b(ozlu2, n, n2, n3 + 1) && !this._b(ozlu2, n, n2 - 1, n3) && !this._b(ozlu2, n, n2 + 1, n3)) continue;
                    ozlu2.func_94575_c(n, n2, n3, twgu.field_72067_ar.field_71990_ca);
                    return;
                }
                if (!twgu.field_71973_m[n4].field_72018_cp._c()) continue;
                return;
            }
            if (n6 == 0) {
                n5 = n;
                n4 = n3;
                for (int i = 0; i < 3; ++i) {
                    n = n5 + random.nextInt(3) - 1;
                    if (!ozlu2.func_72799_c(n, n2 + 1, n3 = n4 + random.nextInt(3) - 1) || !this._b(ozlu2, n, n2, n3)) continue;
                    ozlu2.func_94575_c(n, n2 + 1, n3, twgu.field_72067_ar.field_71990_ca);
                }
            }
        }
    }

    public boolean _b(ozlu ozlu2, int n, int n2, int n3) {
        return ozlu2.func_72803_f(n, n2, n3)._h();
    }
}

