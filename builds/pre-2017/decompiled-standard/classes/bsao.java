/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Collections;
import net.minecraft.client.xpzm;
import org.lwjgl.input.Keyboard;

public class bsao
extends rqmv {
    public gqjz _a;
    public ifms _b;
    public ifms _c;
    public String _d;
    public String _e;
    public static int _f;
    public static int _g;
    public static int _h;
    public boolean _i;
    public String _j = "You must enter a name!";
    public ekjj _k;

    public bsao(gqjz gqjz2) {
        this.field_73887_h = Collections.synchronizedList(new ArrayList());
        this._a = gqjz2;
    }

    @Override
    public void func_73876_c() {
        this._b.func_73780_a();
        this._d = this._b.func_73781_b();
        this._c.func_73780_a();
        this._e = this._c.func_73781_b();
    }

    @Override
    public void func_73866_w_() {
        Keyboard.enableRepeatEvents(true);
        this.field_73887_h.clear();
        this.field_73887_h.add(new jiok(_f, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 120 + 17, 97, 20, wpcz._a("mco.create.world")));
        this.field_73887_h.add(new jiok(_g, this.field_73880_f / 2 + 5, this.field_73881_g / 4 + 120 + 17, 95, 20, wpcz._a("gui.cancel")));
        this._b = new ifms(this.field_73886_k, this.field_73880_f / 2 - 100, 65, 200, 20);
        this._b.func_73796_b(true);
        if (this._d != null) {
            this._b.func_73782_a(this._d);
        }
        this._c = new ifms(this.field_73886_k, this.field_73880_f / 2 - 100, 111, 200, 20);
        if (this._e != null) {
            this._c.func_73782_a(this._e);
        }
        if (this._k == null) {
            this.field_73887_h.add(new jiok(_h, this.field_73880_f / 2 - 100, 147, 200, 20, wpcz._a("mco.template.default.name")));
        } else {
            this._c.func_73782_a("");
            this._c.func_82265_c(false);
            this._c.func_73796_b(false);
            this.field_73887_h.add(new jiok(_h, this.field_73880_f / 2 - 100, 147, 200, 20, wpcz._a("mco.template.name") + ": " + this._k._b));
        }
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
        if (jiok2.field_73741_f == _g) {
            this.field_73882_e._a(this._a);
        } else if (jiok2.field_73741_f == _f) {
            this._a();
        } else if (jiok2.field_73741_f == _h) {
            this.field_73882_e._a(new jzwn(this, this._k));
        }
    }

    public void _a() {
        if (this._b()) {
            ceaj ceaj2 = new ceaj(this, this._b.func_73781_b(), "Minecraft Realms Server", this._e, this._k);
            kluc kluc2 = new kluc(this.field_73882_e, this._a, ceaj2);
            kluc2._a();
            this.field_73882_e._a(kluc2);
        }
    }

    public boolean _b() {
        this._i = this._b.func_73781_b() == null || this._b.func_73781_b().trim().equals("");
        return !this._i;
    }

    @Override
    public void func_73869_a(char c, int n) {
        this._b.func_73802_a(c, n);
        this._c.func_73802_a(c, n);
        if (n == 15) {
            this._b.func_73796_b(!this._b.func_73806_l());
            this._c.func_73796_b(!this._c.func_73806_l());
        }
        if (n == 28 || n == 156) {
            this.func_73875_a((jiok)this.field_73887_h.get(0));
        }
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
        this.func_73732_a(this.field_73886_k, wpcz._a("mco.selectServer.create"), this.field_73880_f / 2, 11, 0xFFFFFF);
        this.func_73731_b(this.field_73886_k, wpcz._a("mco.configure.world.name"), this.field_73880_f / 2 - 100, 52, 0xA0A0A0);
        this.func_73731_b(this.field_73886_k, wpcz._a("mco.create.world.seed"), this.field_73880_f / 2 - 100, 98, 0xA0A0A0);
        if (this._i) {
            this.func_73732_a(this.field_73886_k, this._j, this.field_73880_f / 2, 167, 0xFF0000);
        }
        this._b.func_73795_f();
        this._c.func_73795_f();
        super.func_73863_a(n, n2, f);
    }

    public void _a(ekjj ekjj2) {
        this._k = ekjj2;
    }

    public static /* synthetic */ xpzm _a(bsao bsao2) {
        return bsao2.field_73882_e;
    }

    public static /* synthetic */ gqjz _b(bsao bsao2) {
        return bsao2._a;
    }

    public static /* synthetic */ xpzm _c(bsao bsao2) {
        return bsao2.field_73882_e;
    }

    public static /* synthetic */ xpzm _d(bsao bsao2) {
        return bsao2.field_73882_e;
    }

    public static /* synthetic */ xpzm _e(bsao bsao2) {
        return bsao2.field_73882_e;
    }

    public static /* synthetic */ xpzm _f(bsao bsao2) {
        return bsao2.field_73882_e;
    }

    static {
        _g = 1;
        _h = 2;
    }
}

