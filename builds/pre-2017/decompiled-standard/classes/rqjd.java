/*
 * Decompiled with CFR 0.152.
 */
import org.lwjgl.input.Keyboard;

public class rqjd
extends gqjz {
    public gqjz _a;
    public ifms _b;
    public ifms _c;
    public htsm _d;

    public rqjd(gqjz gqjz2, htsm htsm2) {
        this._a = gqjz2;
        this._d = htsm2;
    }

    @Override
    public void func_73876_c() {
        this._c.func_73780_a();
        this._b.func_73780_a();
    }

    @Override
    public void func_73866_w_() {
        Keyboard.enableRepeatEvents(true);
        this.field_73887_h.clear();
        this.field_73887_h.add(new jiok(0, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 96 + 12, wpcz._a("addServer.add")));
        this.field_73887_h.add(new jiok(1, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 120 + 12, wpcz._a("gui.cancel")));
        this.field_73887_h.add(new jiok(2, this.field_73880_f / 2 - 100, 142, wpcz._a("addServer.hideAddress") + ": " + (this._d._b() ? wpcz._a("gui.yes") : wpcz._a("gui.no"))));
        this._c = new ifms(this.field_73886_k, this.field_73880_f / 2 - 100, 66, 200, 20);
        this._c.func_73796_b(true);
        this._c.func_73782_a(this._d._a);
        this._b = new ifms(this.field_73886_k, this.field_73880_f / 2 - 100, 106, 200, 20);
        this._b.func_73804_f(128);
        this._b.func_73782_a(this._d._b);
        ((jiok)this.field_73887_h.get((int)0)).field_73742_g = this._b.func_73781_b().length() > 0 && this._b.func_73781_b().split(":").length > 0 && this._c.func_73781_b().length() > 0;
    }

    @Override
    public void func_73874_b() {
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        if (!jiok2.field_73742_g) {
            return;
        }
        if (jiok2.field_73741_f == 1) {
            this._a.func_73878_a(false, 0);
        } else if (jiok2.field_73741_f == 0) {
            this._d._a = this._c.func_73781_b();
            this._d._b = this._b.func_73781_b();
            this._a.func_73878_a(true, 0);
        } else if (jiok2.field_73741_f == 2) {
            this._d._b(!this._d._b());
            ((jiok)this.field_73887_h.get((int)2)).field_73744_e = wpcz._a("addServer.hideAddress") + ": " + (this._d._b() ? wpcz._a("gui.yes") : wpcz._a("gui.no"));
        }
    }

    @Override
    public void func_73869_a(char c, int n) {
        this._c.func_73802_a(c, n);
        this._b.func_73802_a(c, n);
        if (n == 15) {
            this._c.func_73796_b(!this._c.func_73806_l());
            this._b.func_73796_b(!this._b.func_73806_l());
        }
        if (n == 28 || n == 156) {
            this.func_73875_a((jiok)this.field_73887_h.get(0));
        }
        ((jiok)this.field_73887_h.get((int)0)).field_73742_g = this._b.func_73781_b().length() > 0 && this._b.func_73781_b().split(":").length > 0 && this._c.func_73781_b().length() > 0;
    }

    @Override
    public void func_73864_a(int n, int n2, int n3) {
        super.func_73864_a(n, n2, n3);
        this._b.func_73793_a(n, n2, n3);
        this._c.func_73793_a(n, n2, n3);
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        this.func_73732_a(this.field_73886_k, wpcz._a("addServer.title"), this.field_73880_f / 2, 17, 0xFFFFFF);
        this.func_73731_b(this.field_73886_k, wpcz._a("addServer.enterName"), this.field_73880_f / 2 - 100, 53, 0xA0A0A0);
        this.func_73731_b(this.field_73886_k, wpcz._a("addServer.enterIp"), this.field_73880_f / 2 - 100, 94, 0xA0A0A0);
        this._c.func_73795_f();
        this._b.func_73795_f();
        super.func_73863_a(n, n2, f);
    }
}

