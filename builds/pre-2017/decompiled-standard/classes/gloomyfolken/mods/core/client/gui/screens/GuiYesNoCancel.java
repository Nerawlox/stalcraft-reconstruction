/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.screens;

import net.minecraft.client.xpzm;

public class GuiYesNoCancel
extends lowa {
    public GuiYesNoCancel(gqjz gqjz2, String string, String string2, int n) {
        super(gqjz2, string, string2, n);
    }

    @Override
    public void func_73872_a(xpzm xpzm2, int n, int n2) {
        this.field_73942_a.func_73872_a(xpzm2, n, n2);
        super.func_73872_a(xpzm2, n, n2);
    }

    @Override
    public void func_73866_w_() {
        this.field_73942_a.field_73887_h.forEach(object -> {
            jiok jiok2 = (jiok)object;
            jiok2.field_73742_g = false;
        });
        this.field_73887_h.add(new baxz(0, this.field_73880_f / 2 - 125, this.field_73881_g / 5 + 96, 70, 20, this.field_73941_c));
        this.field_73887_h.add(new baxz(1, this.field_73880_f / 2 - 125 + 75, this.field_73881_g / 5 + 96, 70, 20, this.field_73939_d));
        this.field_73887_h.add(new baxz(2, this.field_73880_f / 2 - 125 + 75 + 75, this.field_73881_g / 5 + 96, 100, 20, "\u041e\u0442\u043c\u0435\u043d\u0430"));
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        this.field_73942_a.func_73878_a(false, jiok2.field_73741_f);
    }

    @Override
    public void func_73873_v_() {
        this.func_73733_a(this.field_73880_f / 2 - 125 - 10, this.field_73881_g / 5 + 70 - 10, this.field_73880_f / 2 - 125 + 75 + 175 + 10, this.field_73881_g / 5 + 116 + 10, -1072689136, -804253680);
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.field_73942_a.func_73863_a(n, n2, f);
        this.func_73873_v_();
        this.func_73732_a(this.field_73886_k, this.field_73940_b, this.field_73880_f / 2, this.field_73881_g / 5 + 70, 0xFFFFFF);
        this.func_73732_a(this.field_73886_k, this.field_73944_m, this.field_73880_f / 2, this.field_73881_g / 5 + 82, 0xFFFFFF);
        for (int i = 0; i < this.field_73887_h.size(); ++i) {
            jiok jiok2 = (jiok)this.field_73887_h.get(i);
            jiok2.func_73737_a(this.field_73882_e, n, n2);
        }
    }

    @Override
    protected void func_73869_a(char c, int n) {
    }
}

