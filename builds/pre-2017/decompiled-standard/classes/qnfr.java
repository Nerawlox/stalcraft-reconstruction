/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import org.lwjgl.input.Keyboard;

public class qnfr
extends gqjz {
    public ifms _a;
    public rqmh _b;
    public final gqjz _c;
    public final xaxz _d;
    public final int _e = 0;
    public final int _f = 1;
    public String _g = "Could not invite the provided name";
    public String _h;
    public boolean _i;

    public qnfr(gqjz gqjz2, xaxz xaxz2, rqmh rqmh2) {
        this._c = gqjz2;
        this._d = xaxz2;
        this._b = rqmh2;
    }

    @Override
    public void func_73876_c() {
        this._a.func_73780_a();
    }

    @Override
    public void func_73866_w_() {
        Keyboard.enableRepeatEvents(true);
        this.field_73887_h.clear();
        this.field_73887_h.add(new jiok(0, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 96 + 12, wpcz._a("mco.configure.world.buttons.invite")));
        this.field_73887_h.add(new jiok(1, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 120 + 12, wpcz._a("gui.cancel")));
        this._a = new ifms(this.field_73886_k, this.field_73880_f / 2 - 100, 66, 200, 20);
        this._a.func_73796_b(true);
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
            this.field_73882_e._a(this._d);
        } else if (jiok2.field_73741_f == 0) {
            rqmi rqmi2 = new rqmi(this.field_73882_e._P());
            if (this._a.func_73781_b() == null || this._a.func_73781_b().isEmpty()) {
                return;
            }
            try {
                rqmh rqmh2 = rqmi2._b(this._b._a, this._a.func_73781_b());
                if (rqmh2 != null) {
                    this._b._f = rqmh2._f;
                    this.field_73882_e._a(new xaxz(this._c, this._b));
                } else {
                    this._a(this._g);
                }
            }
            catch (twsl twsl2) {
                this.field_73882_e._O()._c(twsl2.toString());
                this._a(twsl2._b);
            }
            catch (IOException iOException) {
                this.field_73882_e._O()._b("Realms: could not parse response");
                this._a(this._g);
            }
        }
    }

    public void _a(String string) {
        this._i = true;
        this._h = string;
    }

    @Override
    public void func_73869_a(char c, int n) {
        this._a.func_73802_a(c, n);
        if (n == 15) {
            if (this._a.func_73806_l()) {
                this._a.func_73796_b(false);
            } else {
                this._a.func_73796_b(true);
            }
        }
        if (n == 28 || n == 156) {
            this.func_73875_a((jiok)this.field_73887_h.get(0));
        }
    }

    @Override
    public void func_73864_a(int n, int n2, int n3) {
        super.func_73864_a(n, n2, n3);
        this._a.func_73793_a(n, n2, n3);
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        this.func_73731_b(this.field_73886_k, wpcz._a("mco.configure.world.invite.profile.name"), this.field_73880_f / 2 - 100, 53, 0xA0A0A0);
        if (this._i) {
            this.func_73732_a(this.field_73886_k, this._h, this.field_73880_f / 2, 100, 0xFF0000);
        }
        this._a.func_73795_f();
        super.func_73863_a(n, n2, f);
    }
}

