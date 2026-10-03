/*
 * Decompiled with CFR 0.152.
 */
public class xtcq
extends hurg {
    public final qokq _a = new zzis(this);

    @Override
    public void func_70307_a(qoac qoac2) {
        super.func_70307_a(qoac2);
        this._a._a(qoac2);
    }

    @Override
    public void func_70310_b(qoac qoac2) {
        super.func_70310_b(qoac2);
        this._a._b(qoac2);
    }

    @Override
    public void func_70316_g() {
        this._a._g();
        super.func_70316_g();
    }

    @Override
    public cezg func_70319_e() {
        qoac qoac2 = new qoac();
        this.func_70310_b(qoac2);
        qoac2._p("SpawnPotentials");
        return new wpte(this.field_70329_l, this.field_70330_m, this.field_70327_n, 1, qoac2);
    }

    @Override
    public boolean func_70315_b(int n, int n2) {
        if (this._a._b(n)) {
            return true;
        }
        return super.func_70315_b(n, n2);
    }

    public qokq _a() {
        return this._a;
    }
}

