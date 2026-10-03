/*
 * Decompiled with CFR 0.152.
 */
public class jiqw
extends gqjz {
    public final cvbr _a;
    public final String _b;
    public final String _c;
    public final gqjz _d;
    public final String _e;
    public final String _f;
    public final int _g;

    public jiqw(gqjz gqjz2, cvbr cvbr2, String string, String string2, int n) {
        this._d = gqjz2;
        this._g = n;
        this._a = cvbr2;
        this._b = string;
        this._c = string2;
        this._e = wpcz._a("gui.yes");
        this._f = wpcz._a("gui.no");
    }

    @Override
    public void func_73866_w_() {
        this.field_73887_h.add(new baxz(0, this.field_73880_f / 2 - 155, this.field_73881_g / 6 + 112, this._e));
        this.field_73887_h.add(new baxz(1, this.field_73880_f / 2 - 155 + 160, this.field_73881_g / 6 + 112, this._f));
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        this._d.func_73878_a(jiok2.field_73741_f == 0, this._g);
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        this.func_73732_a(this.field_73886_k, this._a._d, this.field_73880_f / 2, 70, this._a._c);
        this.func_73732_a(this.field_73886_k, this._b, this.field_73880_f / 2, 90, 0xFFFFFF);
        this.func_73732_a(this.field_73886_k, this._c, this.field_73880_f / 2, 110, 0xFFFFFF);
        super.func_73863_a(n, n2, f);
    }
}

