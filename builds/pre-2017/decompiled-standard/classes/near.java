/*
 * Decompiled with CFR 0.152.
 */
public class near
extends maxt {
    public final /* synthetic */ nvce _u;

    public near(nvce nvce2) {
        this._u = nvce2;
        super(nvce._j(nvce2), nvce2.field_73880_f, nvce2.field_73881_g, 32, nvce2.field_73881_g - 64, 36);
    }

    @Override
    public int _a() {
        return nvce._e(this._u).size() + 1;
    }

    @Override
    public void _a(int n, boolean bl) {
        if (n >= nvce._e(this._u).size()) {
            return;
        }
        nvce._a(this._u, n);
    }

    @Override
    public boolean _a(int n) {
        return n == nvce._d(this._u);
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
        if (n < nvce._e(this._u).size()) {
            this._b(n, n2, n3, n4, htvf2);
        }
    }

    public void _b(int n, int n2, int n3, int n4, htvf htvf2) {
        stoq stoq2 = (stoq)nvce._e(this._u).get(n);
        this._u.func_73731_b(nvce._k(this._u), stoq2._b, n2 + 2, n3 + 1, 0xFFFFFF);
        this._u.func_73731_b(nvce._l(this._u), stoq2._c, n2 + 2, n3 + 12, 0x6C6C6C);
    }
}

