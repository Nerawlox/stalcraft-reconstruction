/*
 * Decompiled with CFR 0.152.
 */
public class stik
extends gqjz {
    public static xsbj _a = new xsbj();
    public final ifku _b;
    public elpk _c = elpk._e();
    public String _d;
    public String _e;
    public String _f;
    public nuzy _g;
    public jiok _h;
    public jiok _i;
    public jiok _j;

    public stik(ifku ifku2, String string) {
        this._b = ifku2;
        this._a(string);
    }

    public String _a() {
        return this._c.toString();
    }

    public void _a(String string) {
        this._c = elpk._b(string);
    }

    @Override
    public void func_73866_w_() {
        this.field_73887_h.clear();
        this._d = wpcz._a("createWorld.customize.flat.title");
        this._e = wpcz._a("createWorld.customize.flat.tile");
        this._f = wpcz._a("createWorld.customize.flat.height");
        this._g = new nuzy(this);
        this._h = new jiok(2, this.field_73880_f / 2 - 154, this.field_73881_g - 52, 100, 20, wpcz._a("createWorld.customize.flat.addLayer") + " (NYI)");
        this.field_73887_h.add(this._h);
        this._i = new jiok(3, this.field_73880_f / 2 - 50, this.field_73881_g - 52, 100, 20, wpcz._a("createWorld.customize.flat.editLayer") + " (NYI)");
        this.field_73887_h.add(this._i);
        this._j = new jiok(4, this.field_73880_f / 2 - 155, this.field_73881_g - 52, 150, 20, wpcz._a("createWorld.customize.flat.removeLayer"));
        this.field_73887_h.add(this._j);
        this.field_73887_h.add(new jiok(0, this.field_73880_f / 2 - 155, this.field_73881_g - 28, 150, 20, wpcz._a("gui.done")));
        this.field_73887_h.add(new jiok(5, this.field_73880_f / 2 + 5, this.field_73881_g - 52, 150, 20, wpcz._a("createWorld.customize.presets")));
        this.field_73887_h.add(new jiok(1, this.field_73880_f / 2 + 5, this.field_73881_g - 28, 150, 20, wpcz._a("gui.cancel")));
        this._i.field_73748_h = false;
        this._h.field_73748_h = false;
        this._c._d();
        this._b();
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        int n = this._c._c().size() - this._g._a - 1;
        if (jiok2.field_73741_f == 1) {
            this.field_73882_e._a(this._b);
        } else if (jiok2.field_73741_f == 0) {
            this._b._y = this._a();
            this.field_73882_e._a(this._b);
        } else if (jiok2.field_73741_f == 5) {
            this.field_73882_e._a(new tfkf(this));
        } else if (jiok2.field_73741_f == 4 && this._c()) {
            this._c._c().remove(n);
            this._g._a = Math.min(this._g._a, this._c._c().size() - 1);
        }
        this._c._d();
        this._b();
    }

    public void _b() {
        boolean bl;
        this._j.field_73742_g = bl = this._c();
        this._i.field_73742_g = bl;
        this._i.field_73742_g = false;
        this._h.field_73742_g = false;
    }

    public boolean _c() {
        return this._g._a > -1 && this._g._a < this._c._c().size();
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        this._g.func_77211_a(n, n2, f);
        this.func_73732_a(this.field_73886_k, this._d, this.field_73880_f / 2, 8, 0xFFFFFF);
        int n3 = this.field_73880_f / 2 - 92 - 16;
        this.func_73731_b(this.field_73886_k, this._e, n3, 32, 0xFFFFFF);
        this.func_73731_b(this.field_73886_k, this._f, n3 + 2 + 213 - this.field_73886_k._b(this._f), 32, 0xFFFFFF);
        super.func_73863_a(n, n2, f);
    }

    public static /* synthetic */ xsbj _d() {
        return _a;
    }

    public static /* synthetic */ elpk _a(stik stik2) {
        return stik2._c;
    }
}

