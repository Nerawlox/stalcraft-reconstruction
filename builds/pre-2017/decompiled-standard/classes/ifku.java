/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.util.ezey;
import net.minecraft.util.sajh;
import org.lwjgl.input.Keyboard;

@SideOnly(value=Side.CLIENT)
public class ifku
extends gqjz {
    public gqjz _a;
    public ifms _b;
    public ifms _c;
    public String _d;
    public String _e = "survival";
    public boolean _f = true;
    public boolean _g;
    public boolean _h;
    public boolean _i;
    public boolean _j;
    public boolean _k;
    public boolean _l;
    public jiok _m;
    public jiok _n;
    public jiok _o;
    public jiok _p;
    public jiok _q;
    public jiok _r;
    public jiok _s;
    public String _t;
    public String _u;
    public String _v;
    public String _w;
    public int _x;
    public String _y = "";
    public static final String[] _z = new String[]{"CON", "COM", "PRN", "AUX", "CLOCK$", "NUL", "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9", "LPT1", "LPT2", "LPT3", "LPT4", "LPT5", "LPT6", "LPT7", "LPT8", "LPT9"};

    public ifku(gqjz gqjz2) {
        this._a = gqjz2;
        this._v = "";
        this._w = wpcz._a("selectWorld.newWorld");
    }

    @Override
    public void func_73876_c() {
        this._b.func_73780_a();
        this._c.func_73780_a();
    }

    @Override
    public void func_73866_w_() {
        Keyboard.enableRepeatEvents(true);
        this.field_73887_h.clear();
        this.field_73887_h.add(new jiok(0, this.field_73880_f / 2 - 155, this.field_73881_g - 28, 150, 20, wpcz._a("selectWorld.create")));
        this.field_73887_h.add(new jiok(1, this.field_73880_f / 2 + 5, this.field_73881_g - 28, 150, 20, wpcz._a("gui.cancel")));
        this._m = new jiok(2, this.field_73880_f / 2 - 75, 115, 150, 20, wpcz._a("selectWorld.gameMode"));
        this.field_73887_h.add(this._m);
        this._n = new jiok(3, this.field_73880_f / 2 - 75, 187, 150, 20, wpcz._a("selectWorld.moreWorldOptions"));
        this.field_73887_h.add(this._n);
        this._o = new jiok(4, this.field_73880_f / 2 - 155, 100, 150, 20, wpcz._a("selectWorld.mapFeatures"));
        this.field_73887_h.add(this._o);
        this._o.field_73748_h = false;
        this._p = new jiok(7, this.field_73880_f / 2 + 5, 151, 150, 20, wpcz._a("selectWorld.bonusItems"));
        this.field_73887_h.add(this._p);
        this._p.field_73748_h = false;
        this._q = new jiok(5, this.field_73880_f / 2 + 5, 100, 150, 20, wpcz._a("selectWorld.mapType"));
        this.field_73887_h.add(this._q);
        this._q.field_73748_h = false;
        this._r = new jiok(6, this.field_73880_f / 2 - 155, 151, 150, 20, wpcz._a("selectWorld.allowCommands"));
        this.field_73887_h.add(this._r);
        this._r.field_73748_h = false;
        this._s = new jiok(8, this.field_73880_f / 2 + 5, 120, 150, 20, wpcz._a("selectWorld.customizeType"));
        this.field_73887_h.add(this._s);
        this._s.field_73748_h = false;
        this._b = new ifms(this.field_73886_k, this.field_73880_f / 2 - 100, 60, 200, 20);
        this._b.func_73796_b(true);
        this._b.func_73782_a(this._w);
        this._c = new ifms(this.field_73886_k, this.field_73880_f / 2 - 100, 60, 200, 20);
        this._c.func_73782_a(this._v);
        this._a(this._l);
        this._a();
        this._b();
    }

    public void _a() {
        this._d = this._b.func_73781_b().trim();
        for (char c : ezey._b) {
            this._d = this._d.replace(c, '_');
        }
        if (sajh._a(this._d)) {
            this._d = "World";
        }
        this._d = ifku._a(this.field_73882_e._g(), this._d);
    }

    public void _b() {
        this._m.field_73744_e = wpcz._a("selectWorld.gameMode") + " " + wpcz._a("selectWorld.gameMode." + this._e);
        this._t = wpcz._a("selectWorld.gameMode." + this._e + ".line1");
        this._u = wpcz._a("selectWorld.gameMode." + this._e + ".line2");
        this._o.field_73744_e = wpcz._a("selectWorld.mapFeatures") + " ";
        this._o.field_73744_e = this._f ? this._o.field_73744_e + wpcz._a("options.on") : this._o.field_73744_e + wpcz._a("options.off");
        this._p.field_73744_e = wpcz._a("selectWorld.bonusItems") + " ";
        this._p.field_73744_e = this._i && !this._j ? this._p.field_73744_e + wpcz._a("options.on") : this._p.field_73744_e + wpcz._a("options.off");
        this._q.field_73744_e = wpcz._a("selectWorld.mapType") + " " + wpcz._a(nwix._c[this._x]._b());
        this._r.field_73744_e = wpcz._a("selectWorld.allowCommands") + " ";
        this._r.field_73744_e = this._g && !this._j ? this._r.field_73744_e + wpcz._a("options.on") : this._r.field_73744_e + wpcz._a("options.off");
    }

    public static String _a(ozsq ozsq2, String string) {
        string = string.replaceAll("[\\./\"]", "_");
        for (String string2 : _z) {
            if (!string.equalsIgnoreCase(string2)) continue;
            string = "_" + string + "_";
        }
        while (ozsq2._c(string) != null) {
            string = string + "-";
        }
        return string;
    }

    @Override
    public void func_73874_b() {
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        if (jiok2.field_73742_g) {
            if (jiok2.field_73741_f == 1) {
                this.field_73882_e._a(this._a);
            } else if (jiok2.field_73741_f == 0) {
                this.field_73882_e._a((gqjz)null);
                if (this._k) {
                    return;
                }
                this._k = true;
                long l = new Random().nextLong();
                String string = this._c.func_73781_b();
                if (!sajh._a(string)) {
                    try {
                        long l2 = Long.parseLong(string);
                        if (l2 != 0L) {
                            l = l2;
                        }
                    }
                    catch (NumberFormatException numberFormatException) {
                        l = string.hashCode();
                    }
                }
                nwix._c[this._x]._j();
                xtby xtby2 = xtby._a(this._e);
                nfhj nfhj2 = new nfhj(l, xtby2, this._f, this._j, nwix._c[this._x]);
                nfhj2._a(this._y);
                if (this._i && !this._j) {
                    nfhj2._a();
                }
                if (this._g && !this._j) {
                    nfhj2._b();
                }
                this.field_73882_e._a(this._d, this._b.func_73781_b().trim(), nfhj2);
                this.field_73882_e._X._a(dzif._g, 1);
            } else if (jiok2.field_73741_f == 3) {
                this._c();
            } else if (jiok2.field_73741_f == 2) {
                if (this._e.equals("survival")) {
                    if (!this._h) {
                        this._g = false;
                    }
                    this._j = false;
                    this._e = "hardcore";
                    this._j = true;
                    this._r.field_73742_g = false;
                    this._p.field_73742_g = false;
                    this._b();
                } else if (this._e.equals("hardcore")) {
                    if (!this._h) {
                        this._g = true;
                    }
                    this._j = false;
                    this._e = "creative";
                    this._b();
                    this._j = false;
                    this._r.field_73742_g = true;
                    this._p.field_73742_g = true;
                } else {
                    if (!this._h) {
                        this._g = false;
                    }
                    this._e = "survival";
                    this._b();
                    this._r.field_73742_g = true;
                    this._p.field_73742_g = true;
                    this._j = false;
                }
                this._b();
            } else if (jiok2.field_73741_f == 4) {
                this._f = !this._f;
                this._b();
            } else if (jiok2.field_73741_f == 7) {
                this._i = !this._i;
                this._b();
            } else if (jiok2.field_73741_f == 5) {
                ++this._x;
                if (this._x >= nwix._c.length) {
                    this._x = 0;
                }
                while (nwix._c[this._x] == null || !nwix._c[this._x]._d()) {
                    ++this._x;
                    if (this._x < nwix._c.length) continue;
                    this._x = 0;
                }
                this._y = "";
                this._b();
                this._a(this._l);
            } else if (jiok2.field_73741_f == 6) {
                this._h = true;
                this._g = !this._g;
                this._b();
            } else if (jiok2.field_73741_f == 8) {
                nwix._c[this._x]._a(this.field_73882_e, this);
            }
        }
    }

    public void _c() {
        this._a(!this._l);
    }

    public void _a(boolean bl) {
        this._l = bl;
        this._m.field_73748_h = !this._l;
        this._o.field_73748_h = this._l;
        this._p.field_73748_h = this._l;
        this._q.field_73748_h = this._l;
        this._r.field_73748_h = this._l;
        this._s.field_73748_h = this._l && nwix._c[this._x]._l();
        this._n.field_73744_e = this._l ? wpcz._a("gui.done") : wpcz._a("selectWorld.moreWorldOptions");
    }

    @Override
    public void func_73869_a(char c, int n) {
        if (this._b.func_73806_l() && !this._l) {
            this._b.func_73802_a(c, n);
            this._w = this._b.func_73781_b();
        } else if (this._c.func_73806_l() && this._l) {
            this._c.func_73802_a(c, n);
            this._v = this._c.func_73781_b();
        }
        if (n == 28 || n == 156) {
            this.func_73875_a((jiok)this.field_73887_h.get(0));
        }
        ((jiok)this.field_73887_h.get((int)0)).field_73742_g = this._b.func_73781_b().length() > 0;
        this._a();
    }

    @Override
    public void func_73864_a(int n, int n2, int n3) {
        super.func_73864_a(n, n2, n3);
        if (this._l) {
            this._c.func_73793_a(n, n2, n3);
        } else {
            this._b.func_73793_a(n, n2, n3);
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        this.func_73732_a(this.field_73886_k, wpcz._a("selectWorld.create"), this.field_73880_f / 2, 20, 0xFFFFFF);
        if (this._l) {
            this.func_73731_b(this.field_73886_k, wpcz._a("selectWorld.enterSeed"), this.field_73880_f / 2 - 100, 47, 0xA0A0A0);
            this.func_73731_b(this.field_73886_k, wpcz._a("selectWorld.seedInfo"), this.field_73880_f / 2 - 100, 85, 0xA0A0A0);
            this.func_73731_b(this.field_73886_k, wpcz._a("selectWorld.mapFeatures.info"), this.field_73880_f / 2 - 150, 122, 0xA0A0A0);
            this.func_73731_b(this.field_73886_k, wpcz._a("selectWorld.allowCommands.info"), this.field_73880_f / 2 - 150, 172, 0xA0A0A0);
            this._c.func_73795_f();
        } else {
            this.func_73731_b(this.field_73886_k, wpcz._a("selectWorld.enterName"), this.field_73880_f / 2 - 100, 47, 0xA0A0A0);
            this.func_73731_b(this.field_73886_k, wpcz._a("selectWorld.resultFolder") + " " + this._d, this.field_73880_f / 2 - 100, 85, 0xA0A0A0);
            this._b.func_73795_f();
            this.func_73731_b(this.field_73886_k, this._t, this.field_73880_f / 2 - 100, 137, 0xA0A0A0);
            this.func_73731_b(this.field_73886_k, this._u, this.field_73880_f / 2 - 100, 149, 0xA0A0A0);
        }
        super.func_73863_a(n, n2, f);
    }

    public void _a(iyev iyev2) {
        this._w = wpcz._a("selectWorld.newWorld.copyOf", iyev2._k());
        this._v = iyev2._b() + "";
        this._x = iyev2._u()._g();
        this._y = iyev2._y();
        this._f = iyev2._s();
        this._g = iyev2._v();
        if (iyev2._t()) {
            this._e = "hardcore";
        } else if (iyev2._r()._e()) {
            this._e = "survival";
        } else if (iyev2._r()._d()) {
            this._e = "creative";
        }
    }
}

