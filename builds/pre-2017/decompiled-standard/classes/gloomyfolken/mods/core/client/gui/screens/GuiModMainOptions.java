/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.screens;

import gloomyfolken.mods.core.client.gui.screens.GuiModGameOptions;
import gloomyfolken.mods.core.client.gui.screens.GuiModPerformanceOptions;
import gloomyfolken.mods.core.client.gui.screens.GuiModSoundOptions;
import gloomyfolken.mods.core.client.gui.screens.GuiModVideoOptions;

public class GuiModMainOptions
extends gqjz {
    private gqjz parentGuiScreen;
    protected String screenTitle = "\u041d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438";

    public GuiModMainOptions(gqjz gqjz2) {
        this.parentGuiScreen = gqjz2;
    }

    @Override
    public void func_73866_w_() {
        this.field_73887_h.clear();
        this.field_73887_h.add(new jiok(100, this.field_73880_f / 2 - 100, this.field_73881_g / 6 + 168, 200, 20, "\u0413\u043e\u0442\u043e\u0432\u043e"));
        this.field_73887_h.add(new jiok(101, this.field_73880_f / 2 - 60, this.field_73881_g / 6 + 10, 120, 20, "\u0418\u0433\u0440\u0430"));
        this.field_73887_h.add(new jiok(102, this.field_73880_f / 2 - 60, this.field_73881_g / 6 + 35, 120, 20, "\u0417\u0432\u0443\u043a"));
        this.field_73887_h.add(new jiok(103, this.field_73880_f / 2 - 60, this.field_73881_g / 6 + 60, 120, 20, "\u0413\u0440\u0430\u0444\u0438\u043a\u0430"));
        this.field_73887_h.add(new jiok(104, this.field_73880_f / 2 - 60, this.field_73881_g / 6 + 85, 120, 20, "\u041f\u0440\u043e\u0438\u0437\u0432\u043e\u0434\u0438\u0442\u0435\u043b\u044c\u043d\u043e\u0441\u0442\u044c"));
        this.field_73887_h.add(new jiok(105, this.field_73880_f / 2 - 60, this.field_73881_g / 6 + 110, 120, 20, "\u0423\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u0438\u0435"));
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        if (jiok2.field_73741_f == 100) {
            this.field_73882_e._a(this.parentGuiScreen);
        } else if (jiok2.field_73741_f == 101) {
            this.field_73882_e._a(new GuiModGameOptions(this));
        } else if (jiok2.field_73741_f == 102) {
            this.field_73882_e._a(new GuiModSoundOptions(this));
        } else if (jiok2.field_73741_f == 103) {
            this.field_73882_e._a(new GuiModVideoOptions(this));
        } else if (jiok2.field_73741_f == 104) {
            this.field_73882_e._a(new GuiModPerformanceOptions(this));
        } else if (jiok2.field_73741_f == 105) {
            this.field_73882_e._a(new nuzu(this, this.field_73882_e._M));
        } else if (jiok2.field_73741_f == 106) {
            this.field_73882_e._a(new ekou(this, this.field_73882_e._M));
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        this.func_73732_a(this.field_73886_k, this.screenTitle, this.field_73880_f / 2, 15, 0xFFFFFF);
        super.func_73863_a(n, n2, f);
    }
}

