/*
 * Decompiled with CFR 0.152.
 */
import java.util.Collections;
import java.util.List;
import net.minecraft.client.xpzm;
import org.lwjgl.input.Keyboard;

public class jzwn
extends gqjz {
    public final rqmv _a;
    public ekjj _b;
    public List _c = Collections.emptyList();
    public vlxd _d;
    public int _e = -1;
    public jiok _f;

    public jzwn(rqmv rqmv2, ekjj ekjj2) {
        this._a = rqmv2;
        this._b = ekjj2;
    }

    @Override
    public void func_73866_w_() {
        Keyboard.enableRepeatEvents(true);
        this.field_73887_h.clear();
        this._d = new vlxd(this);
        new tfrc(this).start();
        this._a();
    }

    public void _a() {
        this.field_73887_h.add(new jiok(0, this.field_73880_f / 2 + 6, this.field_73881_g - 52, 153, 20, wpcz._a("gui.cancel")));
        this._f = new jiok(1, this.field_73880_f / 2 - 154, this.field_73881_g - 52, 153, 20, wpcz._a("mco.template.button.select"));
        this.field_73887_h.add(this._f);
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
            this._b();
        } else if (jiok2.field_73741_f == 0) {
            this._a._a(null);
            this.field_73882_e._a(this._a);
        } else {
            this._d._a(jiok2);
        }
    }

    public void _b() {
        if (this._e >= 0 && this._e < this._c.size()) {
            this._a._a(this._c.get(this._e));
            this.field_73882_e._a(this._a);
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        this._d._a(n, n2, f);
        this.func_73732_a(this.field_73886_k, wpcz._a("mco.template.title"), this.field_73880_f / 2, 20, 0xFFFFFF);
        super.func_73863_a(n, n2, f);
    }

    public static /* synthetic */ xpzm _a(jzwn jzwn2) {
        return jzwn2.field_73882_e;
    }

    public static /* synthetic */ List _a(jzwn jzwn2, List list) {
        jzwn2._c = list;
        return jzwn2._c;
    }

    public static /* synthetic */ xpzm _b(jzwn jzwn2) {
        return jzwn2.field_73882_e;
    }

    public static /* synthetic */ xpzm _c(jzwn jzwn2) {
        return jzwn2.field_73882_e;
    }

    public static /* synthetic */ List _d(jzwn jzwn2) {
        return jzwn2._c;
    }

    public static /* synthetic */ int _a(jzwn jzwn2, int n) {
        jzwn2._e = n;
        return jzwn2._e;
    }

    public static /* synthetic */ ekjj _a(jzwn jzwn2, ekjj ekjj2) {
        jzwn2._b = ekjj2;
        return jzwn2._b;
    }

    public static /* synthetic */ ekjj _e(jzwn jzwn2) {
        return jzwn2._b;
    }

    public static /* synthetic */ int _f(jzwn jzwn2) {
        return jzwn2._e;
    }

    public static /* synthetic */ qncw _g(jzwn jzwn2) {
        return jzwn2.field_73886_k;
    }

    public static /* synthetic */ qncw _h(jzwn jzwn2) {
        return jzwn2.field_73886_k;
    }

    public static /* synthetic */ qncw _i(jzwn jzwn2) {
        return jzwn2.field_73886_k;
    }

    public static /* synthetic */ qncw _j(jzwn jzwn2) {
        return jzwn2.field_73886_k;
    }
}

