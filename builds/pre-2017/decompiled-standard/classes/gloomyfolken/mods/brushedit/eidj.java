/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.brushedit;

public class eidj {
    public int _a;
    public int _b;
    public qoac _c;

    public eidj() {
    }

    public eidj(ozlu ozlu2, int n, int n2, int n3) {
        this._a = ozlu2.func_72798_a(n, n2, n3);
        this._b = ozlu2.func_72805_g(n, n2, n3);
        hurg hurg2 = ozlu2.func_72796_p(n, n2, n3);
        if (hurg2 != null) {
            this._c = new qoac();
            hurg2.func_70310_b(this._c);
        }
    }

    public eidj(int n, int n2, qoac qoac2) {
        this._a = n;
        this._b = n2;
        this._c = qoac2;
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3) {
        ozlu2.func_72832_d(n, n2, n3, this._a, this._b, 3);
        if (this._c != null) {
            hurg hurg2 = ozlu2.func_72796_p(n, n2, n3);
            hurg2.func_70307_a(this._c);
            hurg2.field_70329_l = n;
            hurg2.field_70330_m = n2;
            hurg2.field_70327_n = n3;
        }
    }

    public void _a(qoac qoac2) {
        qoac2._a("id", this._a);
        qoac2._a("metadata", this._b);
        if (this._c != null) {
            qoac2._a("tile", (huhy)this._c);
        }
    }

    public void _b(qoac qoac2) {
        this._a = qoac2._f("id");
        this._b = qoac2._f("metadata");
        if (qoac2._c("tile")) {
            this._c = qoac2._m("tile");
        }
    }
}

