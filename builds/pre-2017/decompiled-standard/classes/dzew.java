/*
 * Decompiled with CFR 0.152.
 */
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class dzew
extends cwci {
    public final fojy _a;
    public final String _b;
    public final Set _c = new HashSet();
    public String _d;
    public String _e = "";
    public String _f = "";
    public boolean _g = true;
    public boolean _h = true;

    public dzew(fojy fojy2, String string) {
        this._a = fojy2;
        this._b = string;
        this._d = string;
    }

    @Override
    public String _a() {
        return this._b;
    }

    public String _b() {
        return this._d;
    }

    public void _a(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        this._d = string;
        this._a._c(this);
    }

    public Collection _c() {
        return this._c;
    }

    public String _d() {
        return this._e;
    }

    public void _b(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Prefix cannot be null");
        }
        this._e = string;
        this._a._c(this);
    }

    public String _e() {
        return this._f;
    }

    public void _c(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Suffix cannot be null");
        }
        this._f = string;
        this._a._c(this);
    }

    @Override
    public String _d(String string) {
        return this._d() + string + this._e();
    }

    public static String _a(cwci cwci2, String string) {
        if (cwci2 == null) {
            return string;
        }
        return cwci2._d(string);
    }

    @Override
    public boolean _f() {
        return this._g;
    }

    public void _a(boolean bl) {
        this._g = bl;
        this._a._c(this);
    }

    @Override
    public boolean _g() {
        return this._h;
    }

    public void _b(boolean bl) {
        this._h = bl;
        this._a._c(this);
    }

    public int _h() {
        int n = 0;
        if (this._f()) {
            n |= 1;
        }
        if (this._g()) {
            n |= 2;
        }
        return n;
    }

    public void _a(int n) {
        this._a((n & 1) > 0);
        this._b((n & 2) > 0);
    }
}

