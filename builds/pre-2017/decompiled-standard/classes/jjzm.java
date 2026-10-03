/*
 * Decompiled with CFR 0.152.
 */
public class jjzm
extends hurg {
    public int _a;

    @Override
    public void func_70310_b(qoac qoac2) {
        super.func_70310_b(qoac2);
        qoac2._a("OutputSignal", this._a);
    }

    @Override
    public void func_70307_a(qoac qoac2) {
        super.func_70307_a(qoac2);
        this._a = qoac2._f("OutputSignal");
    }

    public int _a() {
        return this._a;
    }

    public void _a(int n) {
        this._a = n;
    }
}

