/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.shop.eidj;
import java.util.Collections;
import java.util.List;
import net.minecraft.client.xpzm;
import net.minecraft.util.ezfc;

public class teqa
extends htjl {
    private static GuiRenderer _c = GuiHelper.mcWidgetsRenderer;
    private static final List<String> _d = Collections.singletonList((Object)((Object)ezfc._m) + "\u0412\u044b \u043d\u0435 \u043c\u043e\u0436\u0435\u0442\u0435 \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u044c \u043f\u0435\u0440\u0441\u043e\u043d\u0430\u043b\u044c\u043d\u044b\u0439 \u0441\u043a\u043b\u0430\u0434 \u0437\u0430 \u043f\u0440\u0435\u0434\u0435\u043b\u0430\u043c\u0438 \u0441\u0435\u0439\u0432\u0437\u043e\u043d\u044b!");
    private boolean _e;
    private boolean _f;
    private jiok _g;

    @Override
    public void func_73866_w_() {
        this._e = eidj._a(this.field_73882_e._t);
        this._f = eidj._b(this.field_73882_e._t);
        this.field_73887_h.clear();
        int n = 0;
        this.field_73887_h.add(new jiok(1, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 136 + n, wpcz._a("menu.returnToMenu")));
        if (!this.field_73882_e._H()) {
            ((jiok)this.field_73887_h.get((int)0)).field_73744_e = wpcz._a("menu.disconnect");
        }
        this.field_73887_h.add(new jiok(4, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 31 + n, wpcz._a("menu.returnToGame")));
        this.field_73887_h.add(new jiok(0, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 112 + n, 98, 20, wpcz._a("menu.options")));
        jiok jiok2 = new jiok(7, this.field_73880_f / 2 + 2, this.field_73881_g / 4 + 112 + n, 98, 20, wpcz._a("menu.shareToLan"));
        this.field_73887_h.add(jiok2);
        jiok2.field_73742_g = this.field_73882_e._I() && !this.field_73882_e._J()._b();
        jiok jiok3 = new jiok(10, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 60 + n, 98, 20, "\u041c\u0430\u0433\u0430\u0437\u0438\u043d");
        jiok jiok4 = new jiok(11, this.field_73880_f / 2 + 2, this.field_73881_g / 4 + 60 + n, 98, 20, "\u041a\u0435\u0439\u0441\u044b");
        if (!this._e) {
            jiok3.field_73742_g = false;
            jiok4.field_73742_g = false;
        }
        this.field_73887_h.add(jiok3);
        this.field_73887_h.add(jiok4);
        this._g = new jiok(12, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 84 + n, "\u0421\u043a\u043b\u0430\u0434 \u043f\u0435\u0440\u0441\u043e\u043d\u0430\u043b\u044c\u043d\u044b\u0445 \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u043e\u0432");
        this.field_73887_h.add(this._g);
        if (!this._f) {
            this._g.field_73742_g = false;
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        super.func_73863_a(n, n2, f);
        if (!this._e) {
            this.func_73732_a(this.field_73886_k, "\u0412\u044b \u043d\u0435 \u043c\u043e\u0436\u0435\u0442\u0435 \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u044c \u0432\u043d\u0443\u0442\u0440\u0438\u0438\u0433\u0440\u043e\u0432\u043e\u0439", this.field_73880_f / 2, this.field_73881_g / 4 + 11, 0xFFFFFF);
            this.func_73732_a(this.field_73886_k, "\u043c\u0430\u0433\u0430\u0437\u0438\u043d, \u043f\u043e\u043a\u0430 \u043d\u0435 \u0437\u0430\u0432\u0435\u0440\u0448\u0438\u0442\u0435 \u043e\u0431\u0443\u0447\u0435\u043d\u0438\u0435.", this.field_73880_f / 2, this.field_73881_g / 4 + 19, 0xFFFFFF);
        }
        if (!this._f) {
            boolean bl;
            boolean bl2 = bl = n > this._g.field_73746_c && n < this._g.field_73746_c + this._g.field_73747_a && n2 > this._g.field_73743_d && n2 < this._g.field_73743_d + this._g.field_73745_b;
            if (bl) {
                _c.drawHoveringText(_d, n * 2, n2 * 2, this.field_73880_f, this.field_73881_g);
            }
        }
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        super.func_73875_a(jiok2);
        switch (jiok2.field_73741_f) {
            case 10: {
                xpzm._E()._a(new ivwa(null));
                break;
            }
            case 11: {
                xpzm._E()._a(new oxhq(null));
                break;
            }
            case 12: {
                this.field_73882_e._a((gqjz)null);
                new nudp().sendToServer();
            }
        }
    }
}

