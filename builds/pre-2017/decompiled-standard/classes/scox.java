/*
 * Decompiled with CFR 0.152.
 */
import java.util.Collections;
import java.util.List;
import net.minecraft.client.xpzm;
import org.lwjgl.input.Keyboard;

public class scox
extends gqjz {
    public final xaxz _a;
    public final long _b;
    public List _c = Collections.emptyList();
    public klxy _d;
    public int _e = -1;
    public jiok _f;

    public scox(xaxz xaxz2, long l) {
        this._a = xaxz2;
        this._b = l;
    }

    @Override
    public void func_73866_w_() {
        Keyboard.enableRepeatEvents(true);
        this.field_73887_h.clear();
        this._d = new klxy(this);
        new nvcw(this).start();
        this._a();
    }

    public void _a() {
        this.field_73887_h.add(new jiok(0, this.field_73880_f / 2 + 6, this.field_73881_g - 52, 153, 20, wpcz._a("gui.back")));
        this._f = new jiok(1, this.field_73880_f / 2 - 154, this.field_73881_g - 52, 153, 20, wpcz._a("mco.backup.button.restore"));
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
            String string = wpcz._a("mco.configure.world.restore.question.line1");
            String string2 = wpcz._a("mco.configure.world.restore.question.line2");
            this.field_73882_e._a(new jiqw(this, cvbr._a, string, string2, 1));
        } else if (jiok2.field_73741_f == 0) {
            this.field_73882_e._a(this._a);
        } else {
            this._d._a(jiok2);
        }
    }

    @Override
    public void func_73878_a(boolean bl, int n) {
        if (bl && n == 1) {
            this._b();
        } else {
            this.field_73882_e._a(this);
        }
    }

    public void _b() {
        if (this._e >= 0 && this._e < this._c.size()) {
            scnn scnn2 = (scnn)this._c.get(this._e);
            twsv twsv2 = new twsv(this, scnn2, null);
            kluc kluc2 = new kluc(this.field_73882_e, this._a, twsv2);
            kluc2._a();
            this.field_73882_e._a(kluc2);
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        this._d._a(n, n2, f);
        this.func_73732_a(this.field_73886_k, wpcz._a("mco.backup.title"), this.field_73880_f / 2, 20, 0xFFFFFF);
        super.func_73863_a(n, n2, f);
    }

    public static /* synthetic */ xpzm _a(scox scox2) {
        return scox2.field_73882_e;
    }

    public static /* synthetic */ List _a(scox scox2, List list2) {
        scox2._c = list2;
        return scox2._c;
    }

    public static /* synthetic */ long _b(scox scox2) {
        return scox2._b;
    }

    public static /* synthetic */ xpzm _c(scox scox2) {
        return scox2.field_73882_e;
    }

    public static /* synthetic */ xaxz _d(scox scox2) {
        return scox2._a;
    }

    public static /* synthetic */ xpzm _e(scox scox2) {
        return scox2.field_73882_e;
    }

    public static /* synthetic */ xpzm _f(scox scox2) {
        return scox2.field_73882_e;
    }

    public static /* synthetic */ List _g(scox scox2) {
        return scox2._c;
    }

    public static /* synthetic */ int _a(scox scox2, int n) {
        scox2._e = n;
        return scox2._e;
    }

    public static /* synthetic */ int _h(scox scox2) {
        return scox2._e;
    }

    public static /* synthetic */ qncw _i(scox scox2) {
        return scox2.field_73886_k;
    }

    public static /* synthetic */ qncw _j(scox scox2) {
        return scox2.field_73886_k;
    }
}

