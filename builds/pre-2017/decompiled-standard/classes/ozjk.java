/*
 * Decompiled with CFR 0.152.
 */
public class ozjk {
    public cvzo _a;
    public cvzo _b;
    public cvzo _c;
    public int _d;
    public int _e;

    public ozjk(qoac qoac2) {
        this._a(qoac2);
    }

    public ozjk(cvzo cvzo2, cvzo cvzo3, cvzo cvzo4) {
        this._a = cvzo2;
        this._b = cvzo3;
        this._c = cvzo4;
        this._e = 7;
    }

    public ozjk(cvzo cvzo2, cvzo cvzo3) {
        this(cvzo2, null, cvzo3);
    }

    public ozjk(cvzo cvzo2, tgdv tgdv2) {
        this(cvzo2, new cvzo(tgdv2));
    }

    public cvzo _a() {
        return this._a;
    }

    public cvzo _b() {
        return this._b;
    }

    public boolean _c() {
        return this._b != null;
    }

    public cvzo _d() {
        return this._c;
    }

    public boolean _a(ozjk ozjk2) {
        if (this._a._d != ozjk2._a._d || this._c._d != ozjk2._c._d) {
            return false;
        }
        return this._b == null && ozjk2._b == null || this._b != null && ozjk2._b != null && this._b._d == ozjk2._b._d;
    }

    public boolean _b(ozjk ozjk2) {
        return this._a(ozjk2) && (this._a._b < ozjk2._a._b || this._b != null && this._b._b < ozjk2._b._b);
    }

    public void _e() {
        ++this._d;
    }

    public void _a(int n) {
        this._e += n;
    }

    public boolean _f() {
        return this._d >= this._e;
    }

    public void _g() {
        this._d = this._e;
    }

    public void _a(qoac qoac2) {
        qoac qoac3 = qoac2._m("buy");
        this._a = cvzo._a(qoac3);
        qoac qoac4 = qoac2._m("sell");
        this._c = cvzo._a(qoac4);
        if (qoac2._c("buyB")) {
            this._b = cvzo._a(qoac2._m("buyB"));
        }
        if (qoac2._c("uses")) {
            this._d = qoac2._f("uses");
        }
        this._e = qoac2._c("maxUses") ? qoac2._f("maxUses") : 7;
    }

    public qoac _h() {
        qoac qoac2 = new qoac();
        qoac2._a("buy", this._a._b(new qoac("buy")));
        qoac2._a("sell", this._c._b(new qoac("sell")));
        if (this._b != null) {
            qoac2._a("buyB", this._b._b(new qoac("buyB")));
        }
        qoac2._a("uses", this._d);
        qoac2._a("maxUses", this._e);
        return qoac2;
    }
}

