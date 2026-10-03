/*
 * Decompiled with CFR 0.152.
 */
public class vlxd
extends maxt {
    public final /* synthetic */ jzwn _u;

    public vlxd(jzwn jzwn2) {
        this._u = jzwn2;
        super(jzwn._c(jzwn2), jzwn2.field_73880_f, jzwn2.field_73881_g, 32, jzwn2.field_73881_g - 64, 36);
    }

    @Override
    public int _a() {
        return jzwn._d(this._u).size() + 1;
    }

    @Override
    public void _a(int n, boolean bl) {
        if (n >= jzwn._d(this._u).size()) {
            return;
        }
        jzwn._a(this._u, n);
        jzwn._a(this._u, null);
    }

    @Override
    public boolean _a(int n) {
        if (jzwn._d(this._u).size() == 0) {
            return false;
        }
        if (n >= jzwn._d(this._u).size()) {
            return false;
        }
        if (jzwn._e(this._u) != null) {
            return jzwn._e((jzwn)this._u)._b.equals(((ekjj)jzwn._d((jzwn)this._u).get((int)n))._b);
        }
        return n == jzwn._f(this._u);
    }

    @Override
    public boolean _b(int n) {
        return false;
    }

    @Override
    public int _b() {
        return this._a() * 36;
    }

    @Override
    public void _c() {
        this._u.func_73873_v_();
    }

    @Override
    public void _a(int n, int n2, int n3, int n4, htvf htvf2) {
        if (n < jzwn._d(this._u).size()) {
            this._b(n, n2, n3, n4, htvf2);
        }
    }

    public void _b(int n, int n2, int n3, int n4, htvf htvf2) {
        ekjj ekjj2 = (ekjj)jzwn._d(this._u).get(n);
        this._u.func_73731_b(jzwn._g(this._u), ekjj2._b, n2 + 2, n3 + 1, 0xFFFFFF);
        this._u.func_73731_b(jzwn._h(this._u), ekjj2._d, n2 + 2, n3 + 12, 0x6C6C6C);
        this._u.func_73731_b(jzwn._i(this._u), ekjj2._c, n2 + 2 + 207 - jzwn._j(this._u)._b(ekjj2._c), n3 + 1, 0x4C4C4C);
    }
}

