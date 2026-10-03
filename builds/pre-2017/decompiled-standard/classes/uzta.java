/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.xpzm;
import org.lwjgl.opengl.GL11;

public class uzta
extends gqjz {
    public static xsbj _a = new xsbj();
    public gqjz _b;
    public String _c = "Select world";
    public htnw _d;
    public htnv _e;
    public woyi _f;
    public nwek _g;
    public wovy _h;

    public uzta(gqjz gqjz2, nwek nwek2) {
        this._b = gqjz2;
        this._g = nwek2;
    }

    @Override
    public void func_73866_w_() {
        this._c = wpcz._a("gui.stats");
        this._d = new htnw(this);
        this._d.func_77220_a(1, 1);
        this._e = new htnv(this);
        this._e.func_77220_a(1, 1);
        this._f = new woyi(this);
        this._f.func_77220_a(1, 1);
        this._h = this._d;
        this._a();
    }

    public void _a() {
        this.field_73887_h.add(new jiok(0, this.field_73880_f / 2 + 4, this.field_73881_g - 28, 150, 20, wpcz._a("gui.done")));
        this.field_73887_h.add(new jiok(1, this.field_73880_f / 2 - 154, this.field_73881_g - 52, 100, 20, wpcz._a("stat.generalButton")));
        jiok jiok2 = new jiok(2, this.field_73880_f / 2 - 46, this.field_73881_g - 52, 100, 20, wpcz._a("stat.blocksButton"));
        this.field_73887_h.add(jiok2);
        jiok jiok3 = new jiok(3, this.field_73880_f / 2 + 62, this.field_73881_g - 52, 100, 20, wpcz._a("stat.itemsButton"));
        this.field_73887_h.add(jiok3);
        if (this._f.func_77217_a() == 0) {
            jiok2.field_73742_g = false;
        }
        if (this._e.func_77217_a() == 0) {
            jiok3.field_73742_g = false;
        }
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        if (!jiok2.field_73742_g) {
            return;
        }
        if (jiok2.field_73741_f == 0) {
            this.field_73882_e._a(this._b);
        } else if (jiok2.field_73741_f == 1) {
            this._h = this._d;
        } else if (jiok2.field_73741_f == 3) {
            this._h = this._e;
        } else if (jiok2.field_73741_f == 2) {
            this._h = this._f;
        } else {
            this._h.func_77219_a(jiok2);
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this._h.func_77211_a(n, n2, f);
        this.func_73732_a(this.field_73886_k, this._c, this.field_73880_f / 2, 20, 0xFFFFFF);
        super.func_73863_a(n, n2, f);
    }

    public void _a(int n, int n2, int n3) {
        this._a(n + 1, n2 + 1);
        GL11.glEnable(32826);
        qnon._c();
        _a.func_77015_a(this.field_73886_k, this.field_73882_e._R(), new cvzo(n3, 1, 0), n + 2, n2 + 2);
        qnon._a();
        GL11.glDisable(32826);
    }

    public void _a(int n, int n2) {
        this._a(n, n2, 0, 0);
    }

    public void _a(int n, int n2, int n3, int n4) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73882_e._R()._a(field_110323_l);
        float f = 0.0078125f;
        float f2 = 0.0078125f;
        int n5 = 18;
        int n6 = 18;
        htvf htvf2 = htvf.field_78398_a;
        htvf2.func_78382_b();
        htvf2.func_78374_a(n + 0, n2 + 18, this.field_73735_i, (float)(n3 + 0) * 0.0078125f, (float)(n4 + 18) * 0.0078125f);
        htvf2.func_78374_a(n + 18, n2 + 18, this.field_73735_i, (float)(n3 + 18) * 0.0078125f, (float)(n4 + 18) * 0.0078125f);
        htvf2.func_78374_a(n + 18, n2 + 0, this.field_73735_i, (float)(n3 + 18) * 0.0078125f, (float)(n4 + 0) * 0.0078125f);
        htvf2.func_78374_a(n + 0, n2 + 0, this.field_73735_i, (float)(n3 + 0) * 0.0078125f, (float)(n4 + 0) * 0.0078125f);
        htvf2.func_78381_a();
    }

    public static /* synthetic */ xpzm _a(uzta uzta2) {
        return uzta2.field_73882_e;
    }

    public static /* synthetic */ qncw _b(uzta uzta2) {
        return uzta2.field_73886_k;
    }

    public static /* synthetic */ nwek _c(uzta uzta2) {
        return uzta2._g;
    }

    public static /* synthetic */ qncw _d(uzta uzta2) {
        return uzta2.field_73886_k;
    }

    public static /* synthetic */ qncw _e(uzta uzta2) {
        return uzta2.field_73886_k;
    }

    public static /* synthetic */ xpzm _f(uzta uzta2) {
        return uzta2.field_73882_e;
    }

    public static /* synthetic */ void _a(uzta uzta2, int n, int n2, int n3, int n4) {
        uzta2._a(n, n2, n3, n4);
    }

    public static /* synthetic */ xpzm _g(uzta uzta2) {
        return uzta2.field_73882_e;
    }

    public static /* synthetic */ qncw _h(uzta uzta2) {
        return uzta2.field_73886_k;
    }

    public static /* synthetic */ qncw _i(uzta uzta2) {
        return uzta2.field_73886_k;
    }

    public static /* synthetic */ qncw _j(uzta uzta2) {
        return uzta2.field_73886_k;
    }

    public static /* synthetic */ qncw _k(uzta uzta2) {
        return uzta2.field_73886_k;
    }

    public static /* synthetic */ qncw _l(uzta uzta2) {
        return uzta2.field_73886_k;
    }

    public static /* synthetic */ void _a(uzta uzta2, int n, int n2, int n3, int n4, int n5, int n6) {
        uzta2.func_73733_a(n, n2, n3, n4, n5, n6);
    }

    public static /* synthetic */ qncw _m(uzta uzta2) {
        return uzta2.field_73886_k;
    }

    public static /* synthetic */ qncw _n(uzta uzta2) {
        return uzta2.field_73886_k;
    }

    public static /* synthetic */ void _b(uzta uzta2, int n, int n2, int n3, int n4, int n5, int n6) {
        uzta2.func_73733_a(n, n2, n3, n4, n5, n6);
    }

    public static /* synthetic */ qncw _o(uzta uzta2) {
        return uzta2.field_73886_k;
    }

    public static /* synthetic */ void _a(uzta uzta2, int n, int n2, int n3) {
        uzta2._a(n, n2, n3);
    }
}

