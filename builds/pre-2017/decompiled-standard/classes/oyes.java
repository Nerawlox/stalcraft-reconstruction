/*
 * Decompiled with CFR 0.152.
 */
public class oyes
extends gqjz {
    public final gqjz _a;

    public oyes(gqjz gqjz2) {
        this._a = gqjz2;
    }

    @Override
    public void func_73866_w_() {
        this.field_73887_h.clear();
        this.field_73887_h.add(new jiok(0, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 120 + 12, "Back"));
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        String string = wpcz._a("mco.client.outdated.title");
        String string2 = wpcz._a("mco.client.outdated.msg");
        this.func_73732_a(this.field_73886_k, string, this.field_73880_f / 2, this.field_73881_g / 2 - 50, 0xFF0000);
        this.func_73732_a(this.field_73886_k, string2, this.field_73880_f / 2, this.field_73881_g / 2 - 30, 0xFFFFFF);
        super.func_73863_a(n, n2, f);
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        if (jiok2.field_73741_f == 0) {
            this.field_73882_e._a(this._a);
        }
    }

    @Override
    public void func_73869_a(char c, int n) {
        if (n == 28 || n == 156) {
            this.field_73882_e._a(this._a);
        }
    }
}

