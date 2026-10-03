/*
 * Decompiled with CFR 0.152.
 */
public class iwmg
extends gqjz {
    public bscn _a;
    public int _b;

    public iwmg(bscn bscn2) {
        this._a = bscn2;
    }

    @Override
    public void func_73869_a(char c, int n) {
    }

    @Override
    public void func_73866_w_() {
        this.field_73887_h.clear();
    }

    @Override
    public void func_73876_c() {
        ++this._b;
        if (this._b % 20 == 0) {
            this._a._b(new cezd());
        }
        if (this._a != null) {
            this._a._b();
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73871_c(0);
        this.func_73732_a(this.field_73886_k, wpcz._a("multiplayer.downloadingTerrain"), this.field_73880_f / 2, this.field_73881_g / 2 - 50, 0xFFFFFF);
        super.func_73863_a(n, n2, f);
    }
}

