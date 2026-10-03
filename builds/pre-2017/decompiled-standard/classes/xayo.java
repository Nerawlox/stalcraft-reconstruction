/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.asm.GloomyHooks;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.kjui;

public class xayo
extends gqjz {
    public static final kjui[] _a = new kjui[]{kjui._a, kjui._b, kjui._c, kjui._d, kjui._e, kjui._l, kjui._B};
    public final gqjz _b;
    public final GameSettings _c;
    public String _d = "Options";

    public xayo(gqjz gqjz2, GameSettings gameSettings) {
        this._b = gqjz2;
        this._c = gameSettings;
    }

    @Override
    public void func_73866_w_() {
        int n = 0;
        this._d = wpcz._a("options.title");
        for (kjui kjui2 : _a) {
            if (kjui2._a()) {
                this.field_73887_h.add(new dyaq(kjui2._c(), this.field_73880_f / 2 - 155 + n % 2 * 160, this.field_73881_g / 6 - 12 + 24 * (n >> 1), kjui2, this._c.func_74297_c(kjui2), this._c.func_74296_a(kjui2)));
            } else {
                baxz baxz2 = new baxz(kjui2._c(), this.field_73880_f / 2 - 155 + n % 2 * 160, this.field_73881_g / 6 - 12 + 24 * (n >> 1), kjui2, this._c.func_74297_c(kjui2));
                if (kjui2 == kjui._l && this.field_73882_e._r != null && this.field_73882_e._r.func_72912_H()._t()) {
                    baxz2.field_73742_g = false;
                    baxz2.field_73744_e = wpcz._a("options.difficulty") + ": " + wpcz._a("options.difficulty.hardcore");
                }
                this.field_73887_h.add(baxz2);
            }
            ++n;
        }
        this.field_73887_h.add(new jiok(101, this.field_73880_f / 2 - 152, this.field_73881_g / 6 + 96 - 6, 150, 20, wpcz._a("options.video")));
        this.field_73887_h.add(new jiok(100, this.field_73880_f / 2 + 2, this.field_73881_g / 6 + 96 - 6, 150, 20, wpcz._a("options.controls")));
        this.field_73887_h.add(new jiok(102, this.field_73880_f / 2 - 152, this.field_73881_g / 6 + 120 - 6, 150, 20, wpcz._a("options.language")));
        this.field_73887_h.add(new jiok(103, this.field_73880_f / 2 + 2, this.field_73881_g / 6 + 120 - 6, 150, 20, wpcz._a("options.multiplayer.title")));
        this.field_73887_h.add(new jiok(105, this.field_73880_f / 2 - 152, this.field_73881_g / 6 + 144 - 6, 150, 20, wpcz._a("options.resourcepack")));
        this.field_73887_h.add(new jiok(104, this.field_73880_f / 2 + 2, this.field_73881_g / 6 + 144 - 6, 150, 20, wpcz._a("options.snooper.view")));
        this.field_73887_h.add(new jiok(200, this.field_73880_f / 2 - 100, this.field_73881_g / 6 + 168, wpcz._a("gui.done")));
        GloomyHooks.onInitGuiOptions(this);
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        if (!jiok2.field_73742_g) {
            return;
        }
        if (jiok2.field_73741_f < 100 && jiok2 instanceof baxz) {
            this._c.func_74306_a(((baxz)jiok2).func_73753_a(), 1);
            jiok2.field_73744_e = this._c.func_74297_c(kjui._a(jiok2.field_73741_f));
        }
        if (jiok2.field_73741_f == 101) {
            this.field_73882_e._M.func_74303_b();
            this.field_73882_e._a(new stkl(this, this._c));
        }
        if (jiok2.field_73741_f == 100) {
            this.field_73882_e._M.func_74303_b();
            this.field_73882_e._a(new nuzu(this, this._c));
        }
        if (jiok2.field_73741_f == 102) {
            this.field_73882_e._M.func_74303_b();
            this.field_73882_e._a(new twpa(this, this._c, this.field_73882_e._U()));
        }
        if (jiok2.field_73741_f == 103) {
            this.field_73882_e._M.func_74303_b();
            this.field_73882_e._a(new uisr(this, this._c));
        }
        if (jiok2.field_73741_f == 104) {
            this.field_73882_e._M.func_74303_b();
            this.field_73882_e._a(new ifno(this, this._c));
        }
        if (jiok2.field_73741_f == 200) {
            this.field_73882_e._M.func_74303_b();
            this.field_73882_e._a(this._b);
        }
        if (jiok2.field_73741_f == 105) {
            this.field_73882_e._M.func_74303_b();
            this.field_73882_e._a(new ekou(this, this._c));
        }
        GloomyHooks.onOptionsActionPerformed(this, jiok2);
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        this.func_73732_a(this.field_73886_k, this._d, this.field_73880_f / 2, 15, 0xFFFFFF);
        super.func_73863_a(n, n2, f);
    }
}

