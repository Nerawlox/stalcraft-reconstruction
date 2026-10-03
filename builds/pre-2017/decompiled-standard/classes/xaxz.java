/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import net.minecraft.client.xpzm;
import org.lwjgl.input.Keyboard;

public class xaxz
extends gqjz {
    public final gqjz _a;
    public rqmh _b;
    public ekfb _c;
    public int _d;
    public int _e;
    public int _f;
    public int _g = -1;
    public String _h;
    public jiok _i;
    public jiok _j;
    public jiok _k;
    public jiok _l;
    public jiok _m;
    public jiok _n;
    public jiok _o;
    public jiok _p;
    public boolean _q;

    public xaxz(gqjz gqjz2, rqmh rqmh2) {
        this._a = gqjz2;
        this._b = rqmh2;
    }

    @Override
    public void func_73876_c() {
    }

    @Override
    public void func_73866_w_() {
        this._d = this.field_73880_f / 2 - 200;
        this._e = 180;
        this._f = this.field_73880_f / 2;
        Keyboard.enableRepeatEvents(true);
        this.field_73887_h.clear();
        if (this._b._d.equals("CLOSED")) {
            this._i = new jiok(0, this._d, this._a(12), this._e / 2 - 2, 20, wpcz._a("mco.configure.world.buttons.open"));
            this.field_73887_h.add(this._i);
            this._i.field_73742_g = !this._b._h;
        } else {
            this._j = new jiok(1, this._d, this._a(12), this._e / 2 - 2, 20, wpcz._a("mco.configure.world.buttons.close"));
            this.field_73887_h.add(this._j);
            this._j.field_73742_g = !this._b._h;
        }
        this._o = new jiok(7, this._d + this._e / 2 + 2, this._a(12), this._e / 2 - 2, 20, wpcz._a("mco.configure.world.buttons.subscription"));
        this.field_73887_h.add(this._o);
        this._k = new jiok(5, this._d, this._a(10), this._e / 2 - 2, 20, wpcz._a("mco.configure.world.buttons.edit"));
        this.field_73887_h.add(this._k);
        this._l = new jiok(6, this._d + this._e / 2 + 2, this._a(10), this._e / 2 - 2, 20, wpcz._a("mco.configure.world.buttons.reset"));
        this.field_73887_h.add(this._l);
        this._m = new jiok(4, this._f, this._a(10), this._e / 2 - 2, 20, wpcz._a("mco.configure.world.buttons.invite"));
        this.field_73887_h.add(this._m);
        this._n = new jiok(3, this._f + this._e / 2 + 2, this._a(10), this._e / 2 - 2, 20, wpcz._a("mco.configure.world.buttons.uninvite"));
        this.field_73887_h.add(this._n);
        this._p = new jiok(8, this._f, this._a(12), this._e / 2 - 2, 20, wpcz._a("mco.configure.world.buttons.backup"));
        this.field_73887_h.add(this._p);
        this.field_73887_h.add(new jiok(10, this._f + this._e / 2 + 2, this._a(12), this._e / 2 - 2, 20, wpcz._a("gui.back")));
        this._c = new ekfb(this);
        this._k.field_73742_g = !this._b._h;
        this._l.field_73742_g = !this._b._h;
        this._m.field_73742_g = !this._b._h;
        this._n.field_73742_g = !this._b._h;
        this._p.field_73742_g = !this._b._h;
    }

    public int _a(int n) {
        return 40 + n * 13;
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
        if (jiok2.field_73741_f == 10) {
            if (this._q) {
                ((htmo)this._a)._c(this._b._a);
            }
            this.field_73882_e._a(this._a);
        } else if (jiok2.field_73741_f == 5) {
            this.field_73882_e._a(new mayp(this, this._a, this._b));
        } else if (jiok2.field_73741_f == 1) {
            String string = wpcz._a("mco.configure.world.close.question.line1");
            String string2 = wpcz._a("mco.configure.world.close.question.line2");
            this.field_73882_e._a(new jiqw(this, cvbr._b, string, string2, 1));
        } else if (jiok2.field_73741_f == 0) {
            this._a();
        } else if (jiok2.field_73741_f == 4) {
            this.field_73882_e._a(new qnfr(this._a, this, this._b));
        } else if (jiok2.field_73741_f == 3) {
            this._c();
        } else if (jiok2.field_73741_f == 6) {
            this.field_73882_e._a(new scom(this, this._b));
        } else if (jiok2.field_73741_f == 7) {
            this.field_73882_e._a(new brzu(this, this._b));
        } else if (jiok2.field_73741_f == 8) {
            this.field_73882_e._a(new scox(this, this._b._a));
        }
    }

    public void _a() {
        rqmi rqmi2 = new rqmi(this.field_73882_e._P());
        try {
            Boolean bl = rqmi2._e(this._b._a);
            if (bl.booleanValue()) {
                this._q = true;
                this._b._d = "OPEN";
                this.func_73866_w_();
            }
        }
        catch (twsl twsl2) {
            this.field_73882_e._O()._c(twsl2.toString());
        }
        catch (IOException iOException) {
            this.field_73882_e._O()._b("Realms: could not parse response");
        }
    }

    public void _b() {
        rqmi rqmi2 = new rqmi(this.field_73882_e._P());
        try {
            boolean bl = rqmi2._f(this._b._a);
            if (bl) {
                this._q = true;
                this._b._d = "CLOSED";
                this.func_73866_w_();
            }
        }
        catch (twsl twsl2) {
            this.field_73882_e._O()._c(twsl2.toString());
        }
        catch (IOException iOException) {
            this.field_73882_e._O()._b("Realms: could not parse response");
        }
    }

    public void _c() {
        if (this._g >= 0 && this._g < this._b._f.size()) {
            this._h = (String)this._b._f.get(this._g);
            lowa lowa2 = new lowa(this, "Warning!", wpcz._a("mco.configure.world.uninvite.question") + " '" + this._h + "'", 3);
            this.field_73882_e._a(lowa2);
        }
    }

    @Override
    public void func_73878_a(boolean bl, int n) {
        if (n == 3) {
            if (bl) {
                rqmi rqmi2 = new rqmi(this.field_73882_e._P());
                try {
                    rqmi2._a(this._b._a, this._h);
                }
                catch (twsl twsl2) {
                    this.field_73882_e._O()._c(twsl2.toString());
                }
                this._b(this._g);
            }
            this.field_73882_e._a(new xaxz(this._a, this._b));
        }
        if (n == 1) {
            if (bl) {
                this._b();
            }
            this.field_73882_e._a(this);
        }
    }

    public void _b(int n) {
        this._b._f.remove(n);
    }

    @Override
    public void func_73869_a(char c, int n) {
    }

    @Override
    public void func_73864_a(int n, int n2, int n3) {
        super.func_73864_a(n, n2, n3);
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        this._c._a(n, n2, f);
        this.func_73732_a(this.field_73886_k, wpcz._a("mco.configure.world.title"), this.field_73880_f / 2, 17, 0xFFFFFF);
        this.func_73731_b(this.field_73886_k, wpcz._a("mco.configure.world.name"), this._d, this._a(1), 0xA0A0A0);
        this.func_73731_b(this.field_73886_k, this._b._b(), this._d, this._a(2), 0xFFFFFF);
        this.func_73731_b(this.field_73886_k, wpcz._a("mco.configure.world.description"), this._d, this._a(4), 0xA0A0A0);
        this.func_73731_b(this.field_73886_k, this._b._a(), this._d, this._a(5), 0xFFFFFF);
        this.func_73731_b(this.field_73886_k, wpcz._a("mco.configure.world.status"), this._d, this._a(7), 0xA0A0A0);
        this.func_73731_b(this.field_73886_k, this._d(), this._d, this._a(8), 0xFFFFFF);
        this.func_73731_b(this.field_73886_k, wpcz._a("mco.configure.world.invited"), this._f, this._a(1), 0xA0A0A0);
        super.func_73863_a(n, n2, f);
    }

    public String _d() {
        if (this._b._h) {
            return "Expired";
        }
        String string = this._b._d.toLowerCase();
        return Character.toUpperCase(string.charAt(0)) + string.substring(1);
    }

    public static /* synthetic */ xpzm _a(xaxz xaxz2) {
        return xaxz2.field_73882_e;
    }

    public static /* synthetic */ int _b(xaxz xaxz2) {
        return xaxz2._f;
    }

    public static /* synthetic */ int _a(xaxz xaxz2, int n) {
        return xaxz2._a(n);
    }

    public static /* synthetic */ int _c(xaxz xaxz2) {
        return xaxz2._e;
    }

    public static /* synthetic */ rqmh _d(xaxz xaxz2) {
        return xaxz2._b;
    }

    public static /* synthetic */ int _b(xaxz xaxz2, int n) {
        xaxz2._g = n;
        return xaxz2._g;
    }

    public static /* synthetic */ int _e(xaxz xaxz2) {
        return xaxz2._g;
    }

    public static /* synthetic */ qncw _f(xaxz xaxz2) {
        return xaxz2.field_73886_k;
    }
}

