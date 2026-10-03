/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.client.xpzm;
import org.lwjgl.input.Keyboard;

public class nvce
extends gqjz {
    public final gqjz _a;
    public near _b;
    public List _c = Lists.newArrayList();
    public int _d = -1;

    public nvce(gqjz gqjz2) {
        this._a = gqjz2;
    }

    @Override
    public void func_73866_w_() {
        Keyboard.enableRepeatEvents(true);
        this.field_73887_h.clear();
        this._b = new near(this);
        new vlxo(this).start();
        this._a();
    }

    public void _a() {
        this.field_73887_h.add(new jiok(1, this.field_73880_f / 2 - 154, this.field_73881_g - 52, 153, 20, wpcz._a("mco.invites.button.accept")));
        this.field_73887_h.add(new jiok(2, this.field_73880_f / 2 + 6, this.field_73881_g - 52, 153, 20, wpcz._a("mco.invites.button.reject")));
        this.field_73887_h.add(new jiok(0, this.field_73880_f / 2 - 75, this.field_73881_g - 28, 153, 20, wpcz._a("gui.back")));
    }

    @Override
    public void func_73876_c() {
        super.func_73876_c();
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        if (!jiok2.field_73742_g) {
            return;
        }
        if (jiok2.field_73741_f == 1) {
            this._c();
        } else if (jiok2.field_73741_f == 0) {
            this.field_73882_e._a(this._a);
        } else if (jiok2.field_73741_f == 2) {
            this._b();
        } else {
            this._b._a(jiok2);
        }
    }

    public void _b() {
        if (this._d >= 0 && this._d < this._c.size()) {
            new iwtq(this).start();
        }
    }

    public void _c() {
        if (this._d >= 0 && this._d < this._c.size()) {
            new ekhw(this).start();
        }
    }

    public void _d() {
        int n = this._d;
        if (this._c.size() - 1 == this._d) {
            --this._d;
        }
        this._c.remove(n);
        if (this._c.size() == 0) {
            this._d = -1;
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        this._b._a(n, n2, f);
        this.func_73732_a(this.field_73886_k, wpcz._a("mco.invites.title"), this.field_73880_f / 2, 20, 0xFFFFFF);
        super.func_73863_a(n, n2, f);
    }

    public static /* synthetic */ xpzm _a(nvce nvce2) {
        return nvce2.field_73882_e;
    }

    public static /* synthetic */ List _a(nvce nvce2, List list) {
        nvce2._c = list;
        return nvce2._c;
    }

    public static /* synthetic */ xpzm _b(nvce nvce2) {
        return nvce2.field_73882_e;
    }

    public static /* synthetic */ xpzm _c(nvce nvce2) {
        return nvce2.field_73882_e;
    }

    public static /* synthetic */ int _d(nvce nvce2) {
        return nvce2._d;
    }

    public static /* synthetic */ List _e(nvce nvce2) {
        return nvce2._c;
    }

    public static /* synthetic */ void _f(nvce nvce2) {
        nvce2._d();
    }

    public static /* synthetic */ xpzm _g(nvce nvce2) {
        return nvce2.field_73882_e;
    }

    public static /* synthetic */ xpzm _h(nvce nvce2) {
        return nvce2.field_73882_e;
    }

    public static /* synthetic */ xpzm _i(nvce nvce2) {
        return nvce2.field_73882_e;
    }

    public static /* synthetic */ xpzm _j(nvce nvce2) {
        return nvce2.field_73882_e;
    }

    public static /* synthetic */ int _a(nvce nvce2, int n) {
        nvce2._d = n;
        return nvce2._d;
    }

    public static /* synthetic */ qncw _k(nvce nvce2) {
        return nvce2.field_73886_k;
    }

    public static /* synthetic */ qncw _l(nvce nvce2) {
        return nvce2.field_73886_k;
    }
}

