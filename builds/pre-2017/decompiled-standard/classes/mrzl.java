/*
 * Decompiled with CFR 0.152.
 */
import org.lwjgl.input.Keyboard;

public class mrzl
extends gqjz {
    public final gqjz _a;
    public final htsm _b;
    public ifms _c;

    public mrzl(gqjz gqjz2, htsm htsm2) {
        this._a = gqjz2;
        this._b = htsm2;
    }

    @Override
    public void func_73876_c() {
        this._c.func_73780_a();
    }

    @Override
    public void func_73866_w_() {
        Keyboard.enableRepeatEvents(true);
        this.field_73887_h.clear();
        this.field_73887_h.add(new jiok(0, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 96 + 12, wpcz._a("selectServer.select")));
        this.field_73887_h.add(new jiok(1, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 120 + 12, wpcz._a("gui.cancel")));
        this._c = new ifms(this.field_73886_k, this.field_73880_f / 2 - 100, 116, 200, 20);
        this._c.func_73804_f(128);
        this._c.func_73796_b(true);
        this._c.func_73782_a(this.field_73882_e._M.field_74332_R);
        ((jiok)this.field_73887_h.get((int)0)).field_73742_g = this._c.func_73781_b().length() > 0 && this._c.func_73781_b().split(":").length > 0;
    }

    @Override
    public void func_73874_b() {
        Keyboard.enableRepeatEvents(false);
        this.field_73882_e._M.field_74332_R = this._c.func_73781_b();
        this.field_73882_e._M.func_74303_b();
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        if (!jiok2.field_73742_g) {
            return;
        }
        if (jiok2.field_73741_f == 1) {
            this._a.func_73878_a(false, 0);
        } else if (jiok2.field_73741_f == 0) {
            this._b._b = this._c.func_73781_b();
            this._a.func_73878_a(true, 0);
        }
    }

    @Override
    public void func_73869_a(char c, int n) {
        if (this._c.func_73802_a(c, n)) {
            ((jiok)this.field_73887_h.get((int)0)).field_73742_g = this._c.func_73781_b().length() > 0 && this._c.func_73781_b().split(":").length > 0;
        } else if (n == 28 || n == 156) {
            this.func_73875_a((jiok)this.field_73887_h.get(0));
        }
    }

    @Override
    public void func_73864_a(int n, int n2, int n3) {
        super.func_73864_a(n, n2, n3);
        this._c.func_73793_a(n, n2, n3);
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        this.func_73732_a(this.field_73886_k, wpcz._a("selectServer.direct"), this.field_73880_f / 2, 20, 0xFFFFFF);
        this.func_73731_b(this.field_73886_k, wpcz._a("addServer.enterIp"), this.field_73880_f / 2 - 100, 100, 0xA0A0A0);
        this._c.func_73795_f();
        super.func_73863_a(n, n2, f);
    }
}

