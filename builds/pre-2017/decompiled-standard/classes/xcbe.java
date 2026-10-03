/*
 * Decompiled with CFR 0.152.
 */
public class xcbe
extends hurg {
    public cvzo _a;

    @Override
    public void func_70307_a(qoac qoac2) {
        super.func_70307_a(qoac2);
        if (qoac2._c("RecordItem")) {
            this._a(cvzo._a(qoac2._m("RecordItem")));
        } else if (qoac2._f("Record") > 0) {
            this._a(new cvzo(qoac2._f("Record"), 1, 0));
        }
    }

    @Override
    public void func_70310_b(qoac qoac2) {
        super.func_70310_b(qoac2);
        if (this._a() != null) {
            qoac2._a("RecordItem", this._a()._b(new qoac()));
            qoac2._a("Record", this._a()._d);
        }
    }

    public cvzo _a() {
        return this._a;
    }

    public void _a(cvzo cvzo2) {
        this._a = cvzo2;
        this.func_70296_d();
    }
}

