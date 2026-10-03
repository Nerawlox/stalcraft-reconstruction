/*
 * Decompiled with CFR 0.152.
 */
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import org.lwjgl.input.Keyboard;

public class twlo
extends gqjz {
    public ifms _a;
    public final oiid _b;
    public jiok _c;
    public jiok _d;

    public twlo(oiid oiid2) {
        this._b = oiid2;
    }

    @Override
    public void func_73876_c() {
        this._a.func_73780_a();
    }

    @Override
    public void func_73866_w_() {
        Keyboard.enableRepeatEvents(true);
        this.field_73887_h.clear();
        this._c = new jiok(0, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 96 + 12, wpcz._a("gui.done"));
        this.field_73887_h.add(this._c);
        this._d = new jiok(1, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 120 + 12, wpcz._a("gui.cancel"));
        this.field_73887_h.add(this._d);
        this._a = new ifms(this.field_73886_k, this.field_73880_f / 2 - 150, 60, 300, 20);
        this._a.func_73804_f(Short.MAX_VALUE);
        this._a.func_73796_b(true);
        this._a.func_73782_a(this._b._a());
        this._c.field_73742_g = this._a.func_73781_b().trim().length() > 0;
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
            this.field_73882_e._a((gqjz)null);
        } else if (jiok2.field_73741_f == 0) {
            String string = "MC|AdvCdm";
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeInt(this._b.field_70329_l);
                dataOutputStream.writeInt(this._b.field_70330_m);
                dataOutputStream.writeInt(this._b.field_70327_n);
                cezg.func_73271_a(this._a.func_73781_b(), dataOutputStream);
                this.field_73882_e._z()._b(new jjqf(string, byteArrayOutputStream.toByteArray()));
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            this.field_73882_e._a((gqjz)null);
        }
    }

    @Override
    public void func_73869_a(char c, int n) {
        this._a.func_73802_a(c, n);
        boolean bl = this._c.field_73742_g = this._a.func_73781_b().trim().length() > 0;
        if (n == 28 || n == 156) {
            this.func_73875_a(this._c);
        } else if (n == 1) {
            this.func_73875_a(this._d);
        }
    }

    @Override
    public void func_73864_a(int n, int n2, int n3) {
        super.func_73864_a(n, n2, n3);
        this._a.func_73793_a(n, n2, n3);
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        this.func_73732_a(this.field_73886_k, wpcz._a("advMode.setCommand"), this.field_73880_f / 2, 20, 0xFFFFFF);
        this.func_73731_b(this.field_73886_k, wpcz._a("advMode.command"), this.field_73880_f / 2 - 150, 47, 0xA0A0A0);
        this.func_73731_b(this.field_73886_k, wpcz._a("advMode.nearestPlayer"), this.field_73880_f / 2 - 150, 97, 0xA0A0A0);
        this.func_73731_b(this.field_73886_k, wpcz._a("advMode.randomPlayer"), this.field_73880_f / 2 - 150, 108, 0xA0A0A0);
        this.func_73731_b(this.field_73886_k, wpcz._a("advMode.allPlayers"), this.field_73880_f / 2 - 150, 119, 0xA0A0A0);
        this._a.func_73795_f();
        super.func_73863_a(n, n2, f);
    }
}

