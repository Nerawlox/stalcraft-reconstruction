/*
 * Decompiled with CFR 0.152.
 */
public class fool
extends hurg {
    public int _a;
    public int _b;
    public String _c = "";

    @Override
    public void func_70310_b(qoac qoac2) {
        super.func_70310_b(qoac2);
        qoac2._a("SkullType", (byte)(this._a & 0xFF));
        qoac2._a("Rot", (byte)(this._b & 0xFF));
        qoac2._a("ExtraType", this._c);
    }

    @Override
    public void func_70307_a(qoac qoac2) {
        super.func_70307_a(qoac2);
        this._a = qoac2._d("SkullType");
        this._b = qoac2._d("Rot");
        if (qoac2._c("ExtraType")) {
            this._c = qoac2._j("ExtraType");
        }
    }

    @Override
    public cezg func_70319_e() {
        qoac qoac2 = new qoac();
        this.func_70310_b(qoac2);
        return new wpte(this.field_70329_l, this.field_70330_m, this.field_70327_n, 4, qoac2);
    }

    public void _a(int n, String string) {
        this._a = n;
        this._c = string;
    }

    public int _a() {
        return this._a;
    }

    public int _b() {
        return this._b;
    }

    public void _a(int n) {
        this._b = n;
    }

    public String _c() {
        return this._c;
    }
}

