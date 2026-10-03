/*
 * Decompiled with CFR 0.152.
 */
import java.util.Comparator;
import java.util.List;

public class cwdc {
    public static final Comparator _a = new vmxj();
    public final fojy _b;
    public final igri _c;
    public final String _d;
    public int _e;

    public cwdc(fojy fojy2, igri igri2, String string) {
        this._b = fojy2;
        this._c = igri2;
        this._d = string;
    }

    public void _a(int n) {
        if (this._c._c()._b()) {
            throw new IllegalStateException("Cannot modify read-only score");
        }
        this._c(this._b() + n);
    }

    public void _b(int n) {
        if (this._c._c()._b()) {
            throw new IllegalStateException("Cannot modify read-only score");
        }
        this._c(this._b() - n);
    }

    public void _a() {
        if (this._c._c()._b()) {
            throw new IllegalStateException("Cannot modify read-only score");
        }
        this._a(1);
    }

    public int _b() {
        return this._e;
    }

    public void _c(int n) {
        int n2 = this._e;
        this._e = n;
        if (n2 != n) {
            this._e()._a(this);
        }
    }

    public igri _c() {
        return this._c;
    }

    public String _d() {
        return this._d;
    }

    public fojy _e() {
        return this._b;
    }

    public void _a(List list) {
        this._c(this._c._c()._a(list));
    }
}

