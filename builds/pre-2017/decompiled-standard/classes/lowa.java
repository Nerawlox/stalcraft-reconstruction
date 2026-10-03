/*
 * Decompiled with CFR 0.152.
 */
public class lowa
extends gqjz {
    public gqjz field_73942_a;
    public String field_73940_b;
    public String field_73944_m;
    public String field_73941_c;
    public String field_73939_d;
    public int field_73943_n;

    public lowa(gqjz gqjz2, String string, String string2, int n) {
        this.field_73942_a = gqjz2;
        this.field_73940_b = string;
        this.field_73944_m = string2;
        this.field_73943_n = n;
        this.field_73941_c = wpcz._a("gui.yes");
        this.field_73939_d = wpcz._a("gui.no");
    }

    public lowa(gqjz gqjz2, String string, String string2, String string3, String string4, int n) {
        this.field_73942_a = gqjz2;
        this.field_73940_b = string;
        this.field_73944_m = string2;
        this.field_73941_c = string3;
        this.field_73939_d = string4;
        this.field_73943_n = n;
    }

    @Override
    public void func_73866_w_() {
        this.field_73887_h.add(new baxz(0, this.field_73880_f / 2 - 155, this.field_73881_g / 6 + 96, this.field_73941_c));
        this.field_73887_h.add(new baxz(1, this.field_73880_f / 2 - 155 + 160, this.field_73881_g / 6 + 96, this.field_73939_d));
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        this.field_73942_a.func_73878_a(jiok2.field_73741_f == 0, this.field_73943_n);
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        this.func_73732_a(this.field_73886_k, this.field_73940_b, this.field_73880_f / 2, 70, 0xFFFFFF);
        this.func_73732_a(this.field_73886_k, this.field_73944_m, this.field_73880_f / 2, 90, 0xFFFFFF);
        super.func_73863_a(n, n2, f);
    }
}

