/*
 * Decompiled with CFR 0.152.
 */
public class htnw
extends wovy {
    public final /* synthetic */ uzta _a;

    public htnw(uzta uzta2) {
        this._a = uzta2;
        super(uzta._a(uzta2), uzta2.field_73880_f, uzta2.field_73881_g, 32, uzta2.field_73881_g - 64, 10);
        this.func_77216_a(false);
    }

    @Override
    public int func_77217_a() {
        return dzif._c.size();
    }

    @Override
    public void func_77213_a(int n, boolean bl) {
    }

    @Override
    public boolean func_77218_a(int n) {
        return false;
    }

    @Override
    public int func_77212_b() {
        return this.func_77217_a() * 10;
    }

    @Override
    public void func_77221_c() {
        this._a.func_73873_v_();
    }

    @Override
    public void func_77214_a(int n, int n2, int n3, int n4, htvf htvf2) {
        rann rann2 = (rann)dzif._c.get(n);
        this._a.func_73731_b(uzta._b(this._a), wpcz._a(rann2.func_75970_i()), n2 + 2, n3 + 1, n % 2 == 0 ? 0xFFFFFF : 0x909090);
        String string = rann2.func_75968_a(uzta._c(this._a)._a(rann2));
        this._a.func_73731_b(uzta._d(this._a), string, n2 + 2 + 213 - uzta._e(this._a)._b(string), n3 + 1, n % 2 == 0 ? 0xFFFFFF : 0x909090);
    }
}

