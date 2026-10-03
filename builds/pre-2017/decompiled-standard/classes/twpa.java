/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.settings.GameSettings;

public class twpa
extends gqjz {
    public gqjz _a;
    public jiqn _b;
    public final GameSettings _c;
    public final gqvf _d;
    public baxz _e;

    public twpa(gqjz gqjz2, GameSettings gameSettings, gqvf gqvf2) {
        this._a = gqjz2;
        this._c = gameSettings;
        this._d = gqvf2;
    }

    @Override
    public void func_73866_w_() {
        this._e = new baxz(6, this.field_73880_f / 2 - 75, this.field_73881_g - 38, wpcz._a("gui.done"));
        this.field_73887_h.add(this._e);
        this._b = new jiqn(this);
        this._b.func_77220_a(7, 8);
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        if (!jiok2.field_73742_g) {
            return;
        }
        switch (jiok2.field_73741_f) {
            case 5: {
                break;
            }
            case 6: {
                this.field_73882_e._a(this._a);
                break;
            }
            default: {
                this._b.func_77219_a(jiok2);
            }
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this._b.func_77211_a(n, n2, f);
        this.func_73732_a(this.field_73886_k, wpcz._a("options.language"), this.field_73880_f / 2, 16, 0xFFFFFF);
        this.func_73732_a(this.field_73886_k, "(" + wpcz._a("options.languageWarning") + ")", this.field_73880_f / 2, this.field_73881_g - 56, 0x808080);
        super.func_73863_a(n, n2, f);
    }

    public static /* synthetic */ gqvf _a(twpa twpa2) {
        return twpa2._d;
    }

    public static /* synthetic */ GameSettings _b(twpa twpa2) {
        return twpa2._c;
    }

    public static /* synthetic */ baxz _c(twpa twpa2) {
        return twpa2._e;
    }
}

