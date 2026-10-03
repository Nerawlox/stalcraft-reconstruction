/*
 * Decompiled with CFR 0.152.
 */
public class tgvf
extends hurg {
    public byte _a;
    public boolean _b;

    @Override
    public void func_70310_b(qoac qoac2) {
        super.func_70310_b(qoac2);
        qoac2._a("note", this._a);
    }

    @Override
    public void func_70307_a(qoac qoac2) {
        super.func_70307_a(qoac2);
        this._a = qoac2._d("note");
        if (this._a < 0) {
            this._a = 0;
        }
        if (this._a > 24) {
            this._a = (byte)24;
        }
    }

    public void _a() {
        this._a = (byte)((this._a + 1) % 25);
        this.func_70296_d();
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3) {
        if (ozlu2.func_72803_f(n, n2 + 1, n3) != tflj._a) {
            return;
        }
        tflj tflj2 = ozlu2.func_72803_f(n, n2 - 1, n3);
        int n4 = 0;
        if (tflj2 == tflj._e) {
            n4 = 1;
        }
        if (tflj2 == tflj._p) {
            n4 = 2;
        }
        if (tflj2 == tflj._s) {
            n4 = 3;
        }
        if (tflj2 == tflj._d) {
            n4 = 4;
        }
        ozlu2.func_72965_b(n, n2, n3, twgu.field_71960_R.field_71990_ca, n4, this._a);
    }
}

