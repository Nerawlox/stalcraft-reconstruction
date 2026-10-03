/*
 * Decompiled with CFR 0.152.
 */
public class jiqj
extends fndz {
    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this.field_73887_h.add(new jiok(1, this.field_73880_f / 2 - 100, this.field_73881_g - 40, wpcz._a("multiplayer.stopSleeping")));
    }

    @Override
    public void func_73869_a(char c, int n) {
        if (n == 1) {
            this._b();
        } else if (n == 28 || n == 156) {
            String string = this._h.func_73781_b().trim();
            if (string.length() > 0) {
                this.field_73882_e._t.func_71165_d(string);
            }
            this._h.func_73782_a("");
            this.field_73882_e._J.func_73827_b()._d();
        } else {
            super.func_73869_a(c, n);
        }
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        if (jiok2.field_73741_f == 1) {
            this._b();
        } else {
            super.func_73875_a(jiok2);
        }
    }

    public void _b() {
        bscn bscn2 = this.field_73882_e._t.field_71174_a;
        bscn2._b(new diaa(this.field_73882_e._t, 3));
    }
}

