/*
 * Decompiled with CFR 0.152.
 */
public class wotc
extends lowa {
    public String _a;
    public String _b;
    public String _c;
    public boolean _d = true;

    public wotc(gqjz gqjz2, String string, int n, boolean bl) {
        super(gqjz2, wpcz._a(bl ? "chat.link.confirmTrusted" : "chat.link.confirm"), string, n);
        this.field_73941_c = wpcz._a(bl ? "chat.link.open" : "gui.yes");
        this.field_73939_d = wpcz._a(bl ? "gui.cancel" : "gui.no");
        this._b = wpcz._a("chat.copy");
        this._a = wpcz._a("chat.link.warning");
        this._c = string;
    }

    @Override
    public void func_73866_w_() {
        this.field_73887_h.add(new jiok(0, this.field_73880_f / 3 - 83 + 0, this.field_73881_g / 6 + 96, 100, 20, this.field_73941_c));
        this.field_73887_h.add(new jiok(2, this.field_73880_f / 3 - 83 + 105, this.field_73881_g / 6 + 96, 100, 20, this._b));
        this.field_73887_h.add(new jiok(1, this.field_73880_f / 3 - 83 + 210, this.field_73881_g / 6 + 96, 100, 20, this.field_73939_d));
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        if (jiok2.field_73741_f == 2) {
            this._a();
        }
        this.field_73942_a.func_73878_a(jiok2.field_73741_f == 0, this.field_73943_n);
    }

    public void _a() {
        wotc.func_73865_d(this._c);
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        super.func_73863_a(n, n2, f);
        if (this._d) {
            this.func_73732_a(this.field_73886_k, this._a, this.field_73880_f / 2, 110, 0xFFCCCC);
        }
    }

    public void _b() {
        this._d = false;
    }
}

