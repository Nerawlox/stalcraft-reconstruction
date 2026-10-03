/*
 * Decompiled with CFR 0.152.
 */
import java.io.UnsupportedEncodingException;
import org.lwjgl.input.Keyboard;

public class mayp
extends gqjz {
    public gqjz _a;
    public gqjz _b;
    public ifms _c;
    public ifms _d;
    public rqmh _e;
    public jiok _f;
    public int _g;
    public int _h;
    public int _i;
    public scjn _j;

    public mayp(gqjz gqjz2, gqjz gqjz3, rqmh rqmh2) {
        this._a = gqjz2;
        this._b = gqjz3;
        this._e = rqmh2;
    }

    @Override
    public void func_73876_c() {
        this._d.func_73780_a();
        this._c.func_73780_a();
    }

    @Override
    public void func_73866_w_() {
        this._g = this.field_73880_f / 4;
        this._h = this.field_73880_f / 4 - 2;
        this._i = this.field_73880_f / 2 + 4;
        Keyboard.enableRepeatEvents(true);
        this.field_73887_h.clear();
        this._f = new jiok(0, this._g, this.field_73881_g / 4 + 120 + 22, this._h, 20, wpcz._a("mco.configure.world.buttons.done"));
        this.field_73887_h.add(this._f);
        this.field_73887_h.add(new jiok(1, this._i, this.field_73881_g / 4 + 120 + 22, this._h, 20, wpcz._a("gui.cancel")));
        this._d = new ifms(this.field_73886_k, this._g, 56, 212, 20);
        this._d.func_73796_b(true);
        this._d.func_73804_f(32);
        this._d.func_73782_a(this._e._b());
        this._c = new ifms(this.field_73886_k, this._g, 96, 212, 20);
        this._c.func_73804_f(32);
        this._c.func_73782_a(this._e._a());
        this._j = new scjn(this.field_73880_f, this.field_73881_g, this._g, 122, this._e._i, this._e._j);
        this.field_73887_h.addAll(this._j._e);
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
            this.field_73882_e._a(this._a);
        } else if (jiok2.field_73741_f == 0) {
            this._a();
        } else if (jiok2.field_73741_f == 2) {
            this.field_73882_e._a(new scom(this, this._e));
        } else {
            this._j._a(jiok2);
        }
    }

    public void _a() {
        rqmi rqmi2 = new rqmi(this.field_73882_e._P());
        try {
            String string = this._c.func_73781_b() == null || this._c.func_73781_b().trim().equals("") ? null : this._c.func_73781_b();
            rqmi2._a(this._e._a, this._d.func_73781_b(), string, this._j._i, this._j._j);
            this._e._a(this._d.func_73781_b());
            this._e._b(this._c.func_73781_b());
            this._e._i = this._j._i;
            this._e._j = this._j._j;
            this.field_73882_e._a(new xaxz(this._b, this._e));
        }
        catch (twsl twsl2) {
            this.field_73882_e._O()._c(twsl2.toString());
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            this.field_73882_e._O()._b("Realms: " + unsupportedEncodingException.getLocalizedMessage());
        }
    }

    @Override
    public void func_73869_a(char c, int n) {
        this._d.func_73802_a(c, n);
        this._c.func_73802_a(c, n);
        if (n == 15) {
            this._d.func_73796_b(!this._d.func_73806_l());
            this._c.func_73796_b(!this._c.func_73806_l());
        }
        if (n == 28 || n == 156) {
            this._a();
        }
        this._f.field_73742_g = this._d.func_73781_b() != null && !this._d.func_73781_b().trim().equals("");
    }

    @Override
    public void func_73864_a(int n, int n2, int n3) {
        super.func_73864_a(n, n2, n3);
        this._c.func_73793_a(n, n2, n3);
        this._d.func_73793_a(n, n2, n3);
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        this.func_73732_a(this.field_73886_k, wpcz._a("mco.configure.world.edit.title"), this.field_73880_f / 2, 17, 0xFFFFFF);
        this.func_73731_b(this.field_73886_k, wpcz._a("mco.configure.world.name"), this._g, 43, 0xA0A0A0);
        this.func_73731_b(this.field_73886_k, wpcz._a("mco.configure.world.description"), this._g, 84, 0xA0A0A0);
        this._d.func_73795_f();
        this._c.func_73795_f();
        this._j._a(this, this.field_73886_k);
        super.func_73863_a(n, n2, f);
    }
}

