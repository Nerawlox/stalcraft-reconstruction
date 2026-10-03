/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.xpzm;
import org.lwjgl.input.Keyboard;

public class scom
extends rqmv {
    public gqjz _a;
    public rqmh _b;
    public ifms _c;
    public final int _d = 1;
    public final int _e = 2;
    public static int _f = 3;
    public ekjj _g;
    public jiok _h;

    public scom(gqjz gqjz2, rqmh rqmh2) {
        this._a = gqjz2;
        this._b = rqmh2;
    }

    @Override
    public void func_73876_c() {
        this._c.func_73780_a();
    }

    @Override
    public void func_73866_w_() {
        Keyboard.enableRepeatEvents(true);
        this.field_73887_h.clear();
        this._h = new jiok(1, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 120 + 12, 97, 20, wpcz._a("mco.configure.world.buttons.reset"));
        this.field_73887_h.add(this._h);
        this.field_73887_h.add(new jiok(2, this.field_73880_f / 2 + 5, this.field_73881_g / 4 + 120 + 12, 97, 20, wpcz._a("gui.cancel")));
        this._c = new ifms(this.field_73886_k, this.field_73880_f / 2 - 100, 99, 200, 20);
        this._c.func_73796_b(true);
        this._c.func_73804_f(32);
        this._c.func_73782_a("");
        if (this._g == null) {
            this.field_73887_h.add(new jiok(_f, this.field_73880_f / 2 - 100, 125, 200, 20, wpcz._a("mco.template.default.name")));
        } else {
            this._c.func_73782_a("");
            this._c.func_82265_c(false);
            this._c.func_73796_b(false);
            this.field_73887_h.add(new jiok(_f, this.field_73880_f / 2 - 100, 125, 200, 20, wpcz._a("mco.template.name") + ": " + this._g._b));
        }
    }

    @Override
    public void func_73874_b() {
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    public void func_73869_a(char c, int n) {
        this._c.func_73802_a(c, n);
        if (n == 28 || n == 156) {
            this.func_73875_a(this._h);
        }
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        if (!jiok2.field_73742_g) {
            return;
        }
        if (jiok2.field_73741_f == 2) {
            this.field_73882_e._a(this._a);
        } else if (jiok2.field_73741_f == 1) {
            String string = wpcz._a("mco.configure.world.reset.question.line1");
            String string2 = wpcz._a("mco.configure.world.reset.question.line2");
            this.field_73882_e._a(new jiqw(this, cvbr._a, string, string2, 1));
        } else if (jiok2.field_73741_f == _f) {
            this.field_73882_e._a(new jzwn(this, this._g));
        }
    }

    @Override
    public void func_73878_a(boolean bl, int n) {
        if (bl && n == 1) {
            this._a();
        } else {
            this.field_73882_e._a(this);
        }
    }

    public void _a() {
        ifre ifre2 = new ifre(this, this._b._a, this._c.func_73781_b(), this._g);
        kluc kluc2 = new kluc(this.field_73882_e, this._a, ifre2);
        kluc2._a();
        this.field_73882_e._a(kluc2);
    }

    @Override
    public void func_73864_a(int n, int n2, int n3) {
        super.func_73864_a(n, n2, n3);
        this._c.func_73793_a(n, n2, n3);
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        this.func_73732_a(this.field_73886_k, wpcz._a("mco.reset.world.title"), this.field_73880_f / 2, 17, 0xFFFFFF);
        this.func_73732_a(this.field_73886_k, wpcz._a("mco.reset.world.warning"), this.field_73880_f / 2, 56, 0xFF0000);
        this.func_73731_b(this.field_73886_k, wpcz._a("mco.reset.world.seed"), this.field_73880_f / 2 - 100, 86, 0xA0A0A0);
        this._c.func_73795_f();
        super.func_73863_a(n, n2, f);
    }

    public void _a(ekjj ekjj2) {
        this._g = ekjj2;
    }

    public static /* synthetic */ gqjz _a(scom scom2) {
        return scom2._a;
    }

    public static /* synthetic */ xpzm _b(scom scom2) {
        return scom2.field_73882_e;
    }

    public static /* synthetic */ xpzm _c(scom scom2) {
        return scom2.field_73882_e;
    }

    public static /* synthetic */ xpzm _d(scom scom2) {
        return scom2.field_73882_e;
    }
}

