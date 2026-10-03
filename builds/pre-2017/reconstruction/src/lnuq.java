/*
 * Decompiled with CFR 0.152.
 */
public class lnuq
implements Cloneable {
    public int _a;
    public int _b;
    public int _c;

    public lnuq() {
    }

    public lnuq(int n, int n2, int n3) {
        this._a = n;
        this._b = n2;
        this._c = n3;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        lnuq lnuq2 = (lnuq)object;
        if (this._a != lnuq2._a) {
            return false;
        }
        if (this._b != lnuq2._b) {
            return false;
        }
        return this._c == lnuq2._c;
    }

    public int hashCode() {
        int n = this._a;
        n = 31 * n + this._b;
        n = 31 * n + this._c;
        return n;
    }

    public lnuq _a() {
        return new lnuq(this._a, this._b, this._c);
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return this._a();
    }
}

