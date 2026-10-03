/*
 * Decompiled with CFR 0.152.
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import net.minecraft.client.kjui;
import net.minecraft.util.sajh;

public class fnfu
extends gqjz {
    public final DateFormat _a = new SimpleDateFormat();
    public gqjz _b;
    public String _c = "Select world";
    public boolean _d;
    public int _e;
    public List _f;
    public fnfc _g;
    public String _h;
    public String _i;
    public String[] _j = new String[3];
    public boolean _k;
    public jiok _l;
    public jiok _m;
    public jiok _n;
    public jiok _o;

    public fnfu(gqjz gqjz2) {
        this._b = gqjz2;
    }

    @Override
    public void func_73866_w_() {
        this._c = wpcz._a("selectWorld.title");
        try {
            this._a();
        }
        catch (kjui kjui2) {
            kjui2.printStackTrace();
            this.field_73882_e._a(new hchw("Unable to load words", kjui2.getMessage()));
            return;
        }
        this._h = wpcz._a("selectWorld.world");
        this._i = wpcz._a("selectWorld.conversion");
        this._j[xtby._b._a()] = wpcz._a("gameMode.survival");
        this._j[xtby._c._a()] = wpcz._a("gameMode.creative");
        this._j[xtby._d._a()] = wpcz._a("gameMode.adventure");
        this._g = new fnfc(this);
        this._g.func_77220_a(4, 5);
        this._b();
    }

    public void _a() {
        ozsq ozsq2 = this.field_73882_e._g();
        this._f = ozsq2._a();
        Collections.sort(this._f);
        this._e = -1;
    }

    public String _a(int n) {
        return ((cfrv)this._f.get(n))._a();
    }

    public String _b(int n) {
        String string = ((cfrv)this._f.get(n))._b();
        if (string == null || sajh._a(string)) {
            string = wpcz._a("selectWorld.world") + " " + (n + 1);
        }
        return string;
    }

    public void _b() {
        this._m = new jiok(1, this.field_73880_f / 2 - 154, this.field_73881_g - 52, 150, 20, wpcz._a("selectWorld.select"));
        this.field_73887_h.add(this._m);
        this.field_73887_h.add(new jiok(3, this.field_73880_f / 2 + 4, this.field_73881_g - 52, 150, 20, wpcz._a("selectWorld.create")));
        this._n = new jiok(6, this.field_73880_f / 2 - 154, this.field_73881_g - 28, 72, 20, wpcz._a("selectWorld.rename"));
        this.field_73887_h.add(this._n);
        this._l = new jiok(2, this.field_73880_f / 2 - 76, this.field_73881_g - 28, 72, 20, wpcz._a("selectWorld.delete"));
        this.field_73887_h.add(this._l);
        this._o = new jiok(7, this.field_73880_f / 2 + 4, this.field_73881_g - 28, 72, 20, wpcz._a("selectWorld.recreate"));
        this.field_73887_h.add(this._o);
        this.field_73887_h.add(new jiok(0, this.field_73880_f / 2 + 82, this.field_73881_g - 28, 72, 20, wpcz._a("gui.cancel")));
        this._m.field_73742_g = false;
        this._l.field_73742_g = false;
        this._n.field_73742_g = false;
        this._o.field_73742_g = false;
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        if (!jiok2.field_73742_g) {
            return;
        }
        if (jiok2.field_73741_f == 2) {
            String string = this._b(this._e);
            if (string != null) {
                this._k = true;
                lowa lowa2 = fnfu._a(this, string, this._e);
                this.field_73882_e._a(lowa2);
            }
        } else if (jiok2.field_73741_f == 1) {
            this._c(this._e);
        } else if (jiok2.field_73741_f == 3) {
            this.field_73882_e._a(new ifku(this));
        } else if (jiok2.field_73741_f == 6) {
            this.field_73882_e._a(new jirk(this, this._a(this._e)));
        } else if (jiok2.field_73741_f == 0) {
            this.field_73882_e._a(this._b);
        } else if (jiok2.field_73741_f == 7) {
            ifku ifku2 = new ifku(this);
            mtms mtms2 = this.field_73882_e._g()._a(this._a(this._e), false);
            iyev iyev2 = mtms2.func_75757_d();
            mtms2.func_75759_a();
            ifku2._a(iyev2);
            this.field_73882_e._a(ifku2);
        } else {
            this._g.func_77219_a(jiok2);
        }
    }

    public void _c(int n) {
        String string;
        this.field_73882_e._a((gqjz)null);
        if (this._d) {
            return;
        }
        this._d = true;
        String string2 = this._a(n);
        if (string2 == null) {
            string2 = "World" + n;
        }
        if ((string = this._b(n)) == null) {
            string = "World" + n;
        }
        if (this.field_73882_e._g()._e(string2)) {
            this.field_73882_e._a(string2, string, null);
            this.field_73882_e._X._a(dzif._h, 1);
        }
    }

    @Override
    public void func_73878_a(boolean bl, int n) {
        if (this._k) {
            this._k = false;
            if (bl) {
                ozsq ozsq2 = this.field_73882_e._g();
                ozsq2._c();
                ozsq2._d(this._a(n));
                try {
                    this._a();
                }
                catch (kjui kjui2) {
                    kjui2.printStackTrace();
                }
            }
            this.field_73882_e._a(this);
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this._g.func_77211_a(n, n2, f);
        this.func_73732_a(this.field_73886_k, this._c, this.field_73880_f / 2, 20, 0xFFFFFF);
        super.func_73863_a(n, n2, f);
    }

    public static lowa _a(gqjz gqjz2, String string, int n) {
        String string2 = wpcz._a("selectWorld.deleteQuestion");
        String string3 = "'" + string + "' " + wpcz._a("selectWorld.deleteWarning");
        String string4 = wpcz._a("selectWorld.deleteButton");
        String string5 = wpcz._a("gui.cancel");
        lowa lowa2 = new lowa(gqjz2, string2, string3, string4, string5, n);
        return lowa2;
    }

    public static /* synthetic */ List _a(fnfu fnfu2) {
        return fnfu2._f;
    }

    public static /* synthetic */ int _a(fnfu fnfu2, int n) {
        fnfu2._e = n;
        return fnfu2._e;
    }

    public static /* synthetic */ int _b(fnfu fnfu2) {
        return fnfu2._e;
    }

    public static /* synthetic */ jiok _c(fnfu fnfu2) {
        return fnfu2._m;
    }

    public static /* synthetic */ jiok _d(fnfu fnfu2) {
        return fnfu2._l;
    }

    public static /* synthetic */ jiok _e(fnfu fnfu2) {
        return fnfu2._n;
    }

    public static /* synthetic */ jiok _f(fnfu fnfu2) {
        return fnfu2._o;
    }

    public static /* synthetic */ String _g(fnfu fnfu2) {
        return fnfu2._h;
    }

    public static /* synthetic */ DateFormat _h(fnfu fnfu2) {
        return fnfu2._a;
    }

    public static /* synthetic */ String _i(fnfu fnfu2) {
        return fnfu2._i;
    }

    public static /* synthetic */ String[] _j(fnfu fnfu2) {
        return fnfu2._j;
    }
}

