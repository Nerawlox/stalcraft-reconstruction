/*
 * Decompiled with CFR 0.152.
 */
import org.lwjgl.opengl.GL11;

public class nuzy
extends wovy {
    public int _a;
    public final /* synthetic */ stik _b;

    public nuzy(stik stik2) {
        this._b = stik2;
        super(stik2.field_73882_e, stik2.field_73880_f, stik2.field_73881_g, 43, stik2.field_73881_g - 60, 24);
        this._a = -1;
    }

    public void _a(int n, int n2, cvzo cvzo2) {
        this._a(n + 1, n2 + 1);
        GL11.glEnable(32826);
        if (cvzo2 != null) {
            qnon._c();
            stik._d().func_77015_a(this._b.field_73886_k, this._b.field_73882_e._R(), cvzo2, n + 2, n2 + 2);
            qnon._a();
        }
        GL11.glDisable(32826);
    }

    public void _a(int n, int n2) {
        this._a(n, n2, 0, 0);
    }

    public void _a(int n, int n2, int n3, int n4) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this._b.field_73882_e._R()._a(bawa.field_110323_l);
        float f = 0.0078125f;
        float f2 = 0.0078125f;
        int n5 = 18;
        int n6 = 18;
        htvf htvf2 = htvf.field_78398_a;
        htvf2.func_78382_b();
        htvf2.func_78374_a(n + 0, n2 + 18, this._b.field_73735_i, (float)(n3 + 0) * 0.0078125f, (float)(n4 + 18) * 0.0078125f);
        htvf2.func_78374_a(n + 18, n2 + 18, this._b.field_73735_i, (float)(n3 + 18) * 0.0078125f, (float)(n4 + 18) * 0.0078125f);
        htvf2.func_78374_a(n + 18, n2 + 0, this._b.field_73735_i, (float)(n3 + 18) * 0.0078125f, (float)(n4 + 0) * 0.0078125f);
        htvf2.func_78374_a(n + 0, n2 + 0, this._b.field_73735_i, (float)(n3 + 0) * 0.0078125f, (float)(n4 + 0) * 0.0078125f);
        htvf2.func_78381_a();
    }

    @Override
    public int func_77217_a() {
        return stik._a(this._b)._c().size();
    }

    @Override
    public void func_77213_a(int n, boolean bl) {
        this._a = n;
        this._b._b();
    }

    @Override
    public boolean func_77218_a(int n) {
        return n == this._a;
    }

    @Override
    public void func_77221_c() {
    }

    @Override
    public void func_77214_a(int n, int n2, int n3, int n4, htvf htvf2) {
        suyo suyo2 = (suyo)stik._a(this._b)._c().get(stik._a(this._b)._c().size() - n - 1);
        cvzo cvzo2 = suyo2._b() == 0 ? null : new cvzo(suyo2._b(), 1, suyo2._c());
        String string = cvzo2 == null ? "Air" : tgdv.field_77698_e[suyo2._b()].func_77653_i(cvzo2);
        this._a(n2, n3, cvzo2);
        this._b.field_73886_k._b(string, n2 + 18 + 5, n3 + 3, 0xFFFFFF);
        String string2 = n == 0 ? wpcz._a("createWorld.customize.flat.layer.top", suyo2._a()) : (n == stik._a(this._b)._c().size() - 1 ? wpcz._a("createWorld.customize.flat.layer.bottom", suyo2._a()) : wpcz._a("createWorld.customize.flat.layer", suyo2._a()));
        this._b.field_73886_k._b(string2, n2 + 2 + 213 - this._b.field_73886_k._b(string2), n3 + 3, 0xFFFFFF);
    }

    @Override
    public int func_77225_g() {
        return this._b.field_73880_f - 70;
    }
}

