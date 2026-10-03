/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.screens;

import gloomyfolken.mods.core.client.gui.screens.GuiYesNoCancel;
import gloomyfolken.mods.core.main.GloomyCore;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public abstract class GuiGloomyGeneratedOptions
extends gqjz {
    protected gqjz parentGuiScreen;
    protected String screenTitle = "";
    protected HashMap<jiok, anpn> buttonsMap = new HashMap();
    private HashMap<anpn, String> initialValues = new HashMap();
    private boolean escExit;
    private jiok applyButton;

    public abstract List<anpn> options();

    public GuiGloomyGeneratedOptions(gqjz gqjz2) {
        this.parentGuiScreen = gqjz2;
        this.saveOptionValues();
    }

    protected void saveOptionValues() {
        for (anpn anpn2 : this.options()) {
            this.initialValues.put(anpn2, anpn2.getName());
        }
    }

    @Override
    public void func_73866_w_() {
        this.field_73887_h.clear();
        this.buttonsMap.clear();
        int n = 0;
        int n2 = 0;
        int n3 = this.options().size() / 2 * 24;
        boolean bl = this.options().size() % 2 != 0;
        for (anpn anpn2 : this.options()) {
            int n4 = this.field_73880_f / 2 + ((n2 + 1) % 2 == 0 ? 2 : -152);
            int n5 = (this.field_73881_g - n3) / 3 + n2 / 2 * 24;
            jiok jiok2 = anpn2.createButton(n2++, n4, n5);
            if (this.options().indexOf(anpn2) == this.options().size() - 1 && bl) {
                jiok2.field_73747_a *= 2;
            }
            this.field_73887_h.add(jiok2);
            this.buttonsMap.put(jiok2, anpn2);
            if (n5 <= n) continue;
            n = n5;
        }
        this.field_73887_h.add(new jiok(100, this.field_73880_f / 2 - 205, n + 24, 200, 20, "\u0413\u043e\u0442\u043e\u0432\u043e"));
        this.applyButton = new jiok(101, this.field_73880_f / 2 + 5, n + 24, 200, 20, "\u041f\u0440\u0438\u043c\u0435\u043d\u0438\u0442\u044c");
        this.field_73887_h.add(this.applyButton);
        this.updateButtonNames();
    }

    protected boolean hasChanges() {
        for (Map.Entry<anpn, String> entry : this.initialValues.entrySet()) {
            if (Objects.equals(entry.getValue(), entry.getKey().getName())) continue;
            return true;
        }
        return false;
    }

    public void updateButtonNames() {
        for (Map.Entry<jiok, anpn> entry : this.buttonsMap.entrySet()) {
            entry.getKey().field_73744_e = entry.getValue().getName();
        }
    }

    @Override
    protected void func_73869_a(char c, int n) {
        if (n == 1) {
            this.escExit = true;
            this.quitOptions();
        }
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        anpn anpn3 = this.buttonsMap.get(jiok2);
        if (anpn3 != null) {
            anpn3.onButtonPressed();
            jiok2.field_73744_e = anpn3.getName();
        }
        if (jiok2.field_73741_f == 100) {
            this.quitOptions();
        } else if (jiok2.field_73741_f == 101) {
            this.options().forEach(anpn2 -> anpn2.onChanged(false));
            this.saveOptionValues();
            this.options().forEach(anpn2 -> anpn2.save(GloomyCore.mcconfig));
            GloomyCore.mcconfig.save();
            this.applyButton.field_73742_g = false;
        } else {
            this.applyButton.field_73742_g = true;
        }
    }

    private void quitOptions() {
        if (this.hasChanges()) {
            this.field_73882_e._a(new GuiYesNoCancel(this, "\u0418\u043c\u0435\u044e\u0442\u0441\u044f \u043d\u0435\u0441\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u043d\u044b\u0435 \u0438\u0437\u043c\u0435\u043d\u0435\u043d\u0438\u044f.", "\u0421\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u044c \u0438 \u043f\u0440\u0438\u043c\u0435\u043d\u0438\u0442\u044c \u0443\u043a\u0430\u0437\u0430\u043d\u043d\u044b\u0435 \u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438?", -1));
        } else {
            this.field_73882_e._a(this.parentGuiScreen);
        }
    }

    @Override
    public void func_73878_a(boolean bl, int n) {
        if (n == 2) {
            this.field_73882_e._a(this);
        } else {
            if (n == 0) {
                this.options().forEach(anpn2 -> anpn2.save(GloomyCore.mcconfig));
                GloomyCore.mcconfig.save();
            } else if (n == 1) {
                this.options().forEach(anpn2 -> anpn2.load(GloomyCore.mcconfig));
            }
            this.options().forEach(anpn2 -> anpn2.onChanged(false));
            if (this.escExit) {
                this.field_73882_e._a((gqjz)null);
                this.field_73882_e._o();
            } else {
                this.field_73882_e._a(this.parentGuiScreen);
            }
        }
        this.escExit = false;
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        int n3 = this.options().size() / 2 * 24;
        int n4 = (this.field_73881_g - n3) / 3;
        this.func_73732_a(this.field_73886_k, this.screenTitle, this.field_73880_f / 2, n4 - 15, 0xFFFFFF);
        super.func_73863_a(n, n2, f);
    }
}

