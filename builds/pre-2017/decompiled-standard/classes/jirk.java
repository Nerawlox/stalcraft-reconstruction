/*
 * Decompiled with CFR 0.152.
 */
import org.lwjgl.input.Keyboard;

public class jirk
extends gqjz {
    public gqjz _a;
    public ifms _b;
    public final String _c;

    public jirk(gqjz gqjz2, String string) {
        this._a = gqjz2;
        this._c = string;
    }

    @Override
    public void func_73876_c() {
        this._b.func_73780_a();
    }

    @Override
    public void func_73866_w_() {
        Keyboard.enableRepeatEvents(true);
        this.field_73887_h.clear();
        this.field_73887_h.add(new jiok(0, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 96 + 12, wpcz._a("selectWorld.renameButton")));
        this.field_73887_h.add(new jiok(1, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 120 + 12, wpcz._a("gui.cancel")));
        ozsq ozsq2 = this.field_73882_e._g();
        iyev iyev2 = ozsq2._c(this._c);
        String string = iyev2._k();
        this._b = new ifms(this.field_73886_k, this.field_73880_f / 2 - 100, 60, 200, 20);
        this._b.func_73796_b(true);
        this._b.func_73782_a(string);
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
        if (jiok2.field_73741_f == 1) {
            this.field_73882_e._a(this._a);
        } else if (jiok2.field_73741_f == 0) {
            ozsq ozsq2 = this.field_73882_e._g();
            ozsq2._a(this._c, this._b.func_73781_b().trim());
            this.field_73882_e._a(this._a);
        }
    }

    @Override
    public void func_73869_a(char c, int n) {
        this._b.func_73802_a(c, n);
        boolean bl = ((jiok)this.field_73887_h.get((int)0)).field_73742_g = this._b.func_73781_b().trim().length() > 0;
        if (n == 28 || n == 156) {
            this.func_73875_a((jiok)this.field_73887_h.get(0));
        }
    }

    @Override
    public void func_73864_a(int n, int n2, int n3) {
        super.func_73864_a(n, n2, n3);
        this._b.func_73793_a(n, n2, n3);
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        this.func_73732_a(this.field_73886_k, wpcz._a("selectWorld.renameTitle"), this.field_73880_f / 2, 20, 0xFFFFFF);
        this.func_73731_b(this.field_73886_k, wpcz._a("selectWorld.enterName"), this.field_73880_f / 2 - 100, 47, 0xA0A0A0);
        this._b.func_73795_f();
        super.func_73863_a(n, n2, f);
    }
}

