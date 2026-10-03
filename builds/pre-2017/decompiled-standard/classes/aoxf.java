/*
 * Decompiled with CFR 0.152.
 */
public class aoxf
extends wovy {
    public final /* synthetic */ ifno _a;

    public aoxf(ifno ifno2) {
        this._a = ifno2;
        super(ifno2.field_73882_e, ifno2.field_73880_f, ifno2.field_73881_g, 80, ifno2.field_73881_g - 40, ifno2.field_73886_k._c + 1);
    }

    @Override
    public int func_77217_a() {
        return ifno._a(this._a).size();
    }

    @Override
    public void func_77213_a(int n, boolean bl) {
    }

    @Override
    public boolean func_77218_a(int n) {
        return false;
    }

    @Override
    public void func_77221_c() {
    }

    @Override
    public void func_77214_a(int n, int n2, int n3, int n4, htvf htvf2) {
        this._a.field_73886_k._b((String)ifno._a(this._a).get(n), 10, n3, 0xFFFFFF);
        this._a.field_73886_k._b((String)ifno._b(this._a).get(n), 230, n3, 0xFFFFFF);
    }

    @Override
    public int func_77225_g() {
        return this._a.field_73880_f - 10;
    }
}

