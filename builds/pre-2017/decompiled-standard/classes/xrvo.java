/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;

public class xrvo
extends twgu {
    public final boolean _a;

    public xrvo(int n, boolean bl) {
        super(n, tflj._t);
        this._a = bl;
        if (bl) {
            this.func_71900_a(1.0f);
        }
    }

    @Override
    public void func_71861_g(ozlu ozlu2, int n, int n2, int n3) {
        if (!ozlu2.field_72995_K) {
            if (this._a && !ozlu2.func_72864_z(n, n2, n3)) {
                ozlu2.func_72836_a(n, n2, n3, this.field_71990_ca, 4);
            } else if (!this._a && ozlu2.func_72864_z(n, n2, n3)) {
                ozlu2.func_72832_d(n, n2, n3, twgu.field_72080_bM.field_71990_ca, 0, 2);
            }
        }
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        if (!ozlu2.field_72995_K) {
            if (this._a && !ozlu2.func_72864_z(n, n2, n3)) {
                ozlu2.func_72836_a(n, n2, n3, this.field_71990_ca, 4);
            } else if (!this._a && ozlu2.func_72864_z(n, n2, n3)) {
                ozlu2.func_72832_d(n, n2, n3, twgu.field_72080_bM.field_71990_ca, 0, 2);
            }
        }
    }

    @Override
    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
        if (!ozlu2.field_72995_K && this._a && !ozlu2.func_72864_z(n, n2, n3)) {
            ozlu2.func_72832_d(n, n2, n3, twgu.field_72078_bL.field_71990_ca, 0, 2);
        }
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return twgu.field_72078_bL.field_71990_ca;
    }

    @Override
    public int func_71922_a(ozlu ozlu2, int n, int n2, int n3) {
        return twgu.field_72078_bL.field_71990_ca;
    }
}

