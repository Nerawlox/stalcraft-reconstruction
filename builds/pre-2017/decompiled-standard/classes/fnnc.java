/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.xpzm;

@SideOnly(value=Side.CLIENT)
public class fnnc
extends gqjz {
    public bscn _a;
    public boolean _b;
    public final gqjz _c;

    public fnnc(gqjz gqjz2, xpzm xpzm2, htsm htsm2) {
        this.field_73882_e = xpzm2;
        this._c = gqjz2;
        qnlr qnlr2 = qnlr._a(htsm2._b);
        xpzm2._a((pkix)null);
        xpzm2._a(htsm2);
        this._a(qnlr2._a(), qnlr2._b());
    }

    public fnnc(gqjz gqjz2, xpzm xpzm2, String string, int n) {
        this.field_73882_e = xpzm2;
        this._c = gqjz2;
        xpzm2._a((pkix)null);
        this._a(string, n);
    }

    public void _a(String string, int n) {
        this.field_73882_e._O()._a("Connecting to " + string + ", " + n);
        new dhgx(this, string, n).start();
    }

    @Override
    public void func_73876_c() {
        if (this._a != null) {
            this._a._b();
        }
    }

    @Override
    public void func_73869_a(char c, int n) {
    }

    @Override
    public void func_73866_w_() {
        this.field_73887_h.clear();
        this.field_73887_h.add(new jiok(0, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 120 + 12, wpcz._a("gui.cancel")));
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        if (jiok2.field_73741_f == 0) {
            this._b = true;
            if (this._a != null) {
                this._a._c();
            }
            this.field_73882_e._a(this._c);
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        if (this._a == null) {
            this.func_73732_a(this.field_73886_k, wpcz._a("connect.connecting"), this.field_73880_f / 2, this.field_73881_g / 2 - 50, 0xFFFFFF);
            this.func_73732_a(this.field_73886_k, "", this.field_73880_f / 2, this.field_73881_g / 2 - 10, 0xFFFFFF);
        } else {
            this.func_73732_a(this.field_73886_k, wpcz._a("connect.authorizing"), this.field_73880_f / 2, this.field_73881_g / 2 - 50, 0xFFFFFF);
            this.func_73732_a(this.field_73886_k, this._a._c, this.field_73880_f / 2, this.field_73881_g / 2 - 10, 0xFFFFFF);
        }
        super.func_73863_a(n, n2, f);
    }

    public static bscn _a(fnnc fnnc2, bscn bscn2) {
        fnnc2._a = bscn2;
        return fnnc2._a;
    }

    public static xpzm _a(fnnc fnnc2) {
        return fnnc2.field_73882_e;
    }

    public static boolean _b(fnnc fnnc2) {
        return fnnc2._b;
    }

    public static xpzm _c(fnnc fnnc2) {
        return fnnc2.field_73882_e;
    }

    public static bscn _d(fnnc fnnc2) {
        return fnnc2._a;
    }

    public static gqjz _e(fnnc fnnc2) {
        return fnnc2._c;
    }

    public static xpzm _f(fnnc fnnc2) {
        return fnnc2.field_73882_e;
    }

    public static xpzm _g(fnnc fnnc2) {
        return fnnc2.field_73882_e;
    }

    public static xpzm _h(fnnc fnnc2) {
        return fnnc2.field_73882_e;
    }

    public static void _i(fnnc fnnc2) {
        fnnc2._b = true;
        fnnc2._a = null;
    }
}

