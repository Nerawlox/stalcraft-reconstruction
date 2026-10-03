/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.asm.GloomyHooks;

public class htjl
extends gqjz {
    public int _a;
    public int _b;

    @Override
    public void func_73866_w_() {
        this._a = 0;
        this.field_73887_h.clear();
        int n = -16;
        int n2 = 98;
        this.field_73887_h.add(new jiok(1, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 120 + n, wpcz._a("menu.returnToMenu")));
        if (!this.field_73882_e._H()) {
            ((jiok)this.field_73887_h.get((int)0)).field_73744_e = wpcz._a("menu.disconnect");
        }
        this.field_73887_h.add(new jiok(4, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 24 + n, wpcz._a("menu.returnToGame")));
        this.field_73887_h.add(new jiok(0, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 96 + n, 98, 20, wpcz._a("menu.options")));
        jiok jiok2 = new jiok(7, this.field_73880_f / 2 + 2, this.field_73881_g / 4 + 96 + n, 98, 20, wpcz._a("menu.shareToLan"));
        this.field_73887_h.add(jiok2);
        this.field_73887_h.add(new jiok(5, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 48 + n, 98, 20, wpcz._a("gui.achievements")));
        this.field_73887_h.add(new jiok(6, this.field_73880_f / 2 + 2, this.field_73881_g / 4 + 48 + n, 98, 20, wpcz._a("gui.stats")));
        jiok2.field_73742_g = this.field_73882_e._I() && !this.field_73882_e._J()._b();
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        boolean bl = GloomyHooks.actionPerformed(this, jiok2);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        switch (jiok2.field_73741_f) {
            case 0: {
                this.field_73882_e._a(new xayo(this, this.field_73882_e._M));
                break;
            }
            case 1: {
                jiok2.field_73742_g = false;
                this.field_73882_e._X._a(dzif._j, 1);
                this.field_73882_e._r.func_72882_A();
                this.field_73882_e._a((pkix)null);
                this.field_73882_e._a(new fngq());
                break;
            }
            case 4: {
                this.field_73882_e._a((gqjz)null);
                this.field_73882_e._o();
                this.field_73882_e._N._h();
                break;
            }
            case 5: {
                this.field_73882_e._a(new ohbq(this.field_73882_e._X));
                break;
            }
            case 6: {
                this.field_73882_e._a(new uzta(this, this.field_73882_e._X));
                break;
            }
            case 7: {
                this.field_73882_e._a(new iwoy(this));
            }
        }
    }

    @Override
    public void func_73876_c() {
        super.func_73876_c();
        ++this._b;
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        this.func_73732_a(this.field_73886_k, "Game menu", this.field_73880_f / 2, 40, 0xFFFFFF);
        super.func_73863_a(n, n2, f);
    }
}

