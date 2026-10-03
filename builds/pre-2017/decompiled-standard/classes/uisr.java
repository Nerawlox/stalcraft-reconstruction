/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.kjui;

public class uisr
extends gqjz {
    public static final kjui[] _a = new kjui[]{kjui._r, kjui._s, kjui._t, kjui._u, kjui._v, kjui._C, kjui._E, kjui._F, kjui._D};
    public static final kjui[] _b = new kjui[]{kjui._A};
    public final gqjz _c;
    public final GameSettings _d;
    public String _e;
    public String _f;
    public int _g;

    public uisr(gqjz gqjz2, GameSettings gameSettings) {
        this._c = gqjz2;
        this._d = gameSettings;
    }

    @Override
    public void func_73866_w_() {
        int n = 0;
        this._e = wpcz._a("options.chat.title");
        this._f = wpcz._a("options.multiplayer.title");
        for (kjui kjui2 : _a) {
            if (kjui2._a()) {
                this.field_73887_h.add(new dyaq(kjui2._c(), this.field_73880_f / 2 - 155 + n % 2 * 160, this.field_73881_g / 6 + 24 * (n >> 1), kjui2, this._d.func_74297_c(kjui2), this._d.func_74296_a(kjui2)));
            } else {
                this.field_73887_h.add(new baxz(kjui2._c(), this.field_73880_f / 2 - 155 + n % 2 * 160, this.field_73881_g / 6 + 24 * (n >> 1), kjui2, this._d.func_74297_c(kjui2)));
            }
            ++n;
        }
        if (n % 2 == 1) {
            ++n;
        }
        this._g = this.field_73881_g / 6 + 24 * (n >> 1);
        n += 2;
        for (kjui kjui2 : _b) {
            if (kjui2._a()) {
                this.field_73887_h.add(new dyaq(kjui2._c(), this.field_73880_f / 2 - 155 + n % 2 * 160, this.field_73881_g / 6 + 24 * (n >> 1), kjui2, this._d.func_74297_c(kjui2), this._d.func_74296_a(kjui2)));
            } else {
                this.field_73887_h.add(new baxz(kjui2._c(), this.field_73880_f / 2 - 155 + n % 2 * 160, this.field_73881_g / 6 + 24 * (n >> 1), kjui2, this._d.func_74297_c(kjui2)));
            }
            ++n;
        }
        this.field_73887_h.add(new jiok(200, this.field_73880_f / 2 - 100, this.field_73881_g / 6 + 168, wpcz._a("gui.done")));
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        if (!jiok2.field_73742_g) {
            return;
        }
        if (jiok2.field_73741_f < 100 && jiok2 instanceof baxz) {
            this._d.func_74306_a(((baxz)jiok2).func_73753_a(), 1);
            jiok2.field_73744_e = this._d.func_74297_c(kjui._a(jiok2.field_73741_f));
        }
        if (jiok2.field_73741_f == 200) {
            this.field_73882_e._M.func_74303_b();
            this.field_73882_e._a(this._c);
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        this.func_73732_a(this.field_73886_k, this._e, this.field_73880_f / 2, 20, 0xFFFFFF);
        this.func_73732_a(this.field_73886_k, this._f, this.field_73880_f / 2, this._g + 7, 0xFFFFFF);
        super.func_73863_a(n, n2, f);
    }
}

