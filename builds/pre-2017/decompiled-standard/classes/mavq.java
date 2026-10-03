/*
 * Decompiled with CFR 0.152.
 */
import org.lwjgl.opengl.GL11;

public class mavq
extends wovy {
    public int _a;
    public final /* synthetic */ tfkf _b;

    public mavq(tfkf tfkf2) {
        this._b = tfkf2;
        super(tfkf2.field_73882_e, tfkf2.field_73880_f, tfkf2.field_73881_g, 80, tfkf2.field_73881_g - 37, 24);
        this._a = -1;
    }

    public void _a(int n, int n2, int n3) {
        this._a(n + 1, n2 + 1);
        GL11.glEnable(32826);
        qnon._c();
        tfkf._c().func_77015_a(this._b.field_73886_k, this._b.field_73882_e._R(), new cvzo(n3, 1, 0), n + 2, n2 + 2);
        qnon._a();
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
        return tfkf._d().size();
    }

    @Override
    public void func_77213_a(int n, boolean bl) {
        this._a = n;
        this._b._a();
        tfkf._b(this._b).func_73782_a(((htjk)tfkf._d().get((int)tfkf._a((tfkf)this._b)._a))._c);
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
        htjk htjk2 = (htjk)tfkf._d().get(n);
        this._a(n2, n3, htjk2._a);
        this._b.field_73886_k._b(htjk2._b, n2 + 18 + 5, n3 + 6, 0xFFFFFF);
    }
}

