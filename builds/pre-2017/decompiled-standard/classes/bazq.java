/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;

public class bazq
extends gqjz {
    public String _a;
    public String _b;
    public Object[] _c;
    public List _d;
    public final gqjz _e;

    public bazq(gqjz gqjz2, String string, String string2, Object ... objectArray) {
        this._e = gqjz2;
        this._a = wpcz._a(string);
        this._b = string2;
        this._c = objectArray;
    }

    @Override
    public void func_73869_a(char c, int n) {
    }

    @Override
    public void func_73866_w_() {
        this.field_73887_h.clear();
        this.field_73887_h.add(new jiok(0, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 120 + 12, wpcz._a("gui.back")));
        this._d = this._c != null ? this.field_73886_k._c(wpcz._a(this._b, this._c), this.field_73880_f - 50) : this.field_73886_k._c(wpcz._a(this._b), this.field_73880_f - 50);
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        if (jiok2.field_73741_f == 0) {
            this.field_73882_e._a(this._e);
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        this.func_73732_a(this.field_73886_k, this._a, this.field_73880_f / 2, this.field_73881_g / 2 - 50, 0xAAAAAA);
        int n3 = this.field_73881_g / 2 - 30;
        if (this._d != null) {
            for (String string : this._d) {
                this.func_73732_a(this.field_73886_k, string, this.field_73880_f / 2, n3, 0xFFFFFF);
                n3 += this.field_73886_k._c;
            }
        }
        super.func_73863_a(n, n2, f);
    }
}

