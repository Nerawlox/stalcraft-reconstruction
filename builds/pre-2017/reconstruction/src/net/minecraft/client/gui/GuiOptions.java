/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import gloomyfolken.mods.asm.GloomyHooks;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlider;
import net.minecraft.client.gui.ScreenChatOptions;
import net.minecraft.client.settings.EnumOptions;
import net.minecraft.client.settings.GameSettings;

public class GuiOptions
extends GuiScreen {
    public static final EnumOptions[] _a = new EnumOptions[]{EnumOptions._a, EnumOptions._b, EnumOptions._c, EnumOptions._d, EnumOptions._e, EnumOptions._l, EnumOptions._B};
    public final GuiScreen _b;
    public final GameSettings _c;
    public String _d = "Options";

    public GuiOptions(GuiScreen guiScreen, GameSettings gameSettings) {
        this._b = guiScreen;
        this._c = gameSettings;
    }

    @Override
    public void initGui() {
        int n = 0;
        this._d = wpcz._a("options.title");
        for (EnumOptions enumOptions : _a) {
            if (enumOptions._a()) {
                this.buttonList.add(new GuiSlider(enumOptions._c(), this.width / 2 - 155 + n % 2 * 160, this.height / 6 - 12 + 24 * (n >> 1), enumOptions, this._c.getKeyBinding(enumOptions), this._c.getOptionFloatValue(enumOptions)));
            } else {
                baxz baxz2 = new baxz(enumOptions._c(), this.width / 2 - 155 + n % 2 * 160, this.height / 6 - 12 + 24 * (n >> 1), enumOptions, this._c.getKeyBinding(enumOptions));
                if (enumOptions == EnumOptions._l && this.mc._r != null && this.mc._r.getWorldInfo()._t()) {
                    baxz2.enabled = false;
                    baxz2.displayString = wpcz._a("options.difficulty") + ": " + wpcz._a("options.difficulty.hardcore");
                }
                this.buttonList.add(baxz2);
            }
            ++n;
        }
        this.buttonList.add(new GuiButton(101, this.width / 2 - 152, this.height / 6 + 96 - 6, 150, 20, wpcz._a("options.video")));
        this.buttonList.add(new GuiButton(100, this.width / 2 + 2, this.height / 6 + 96 - 6, 150, 20, wpcz._a("options.controls")));
        this.buttonList.add(new GuiButton(102, this.width / 2 - 152, this.height / 6 + 120 - 6, 150, 20, wpcz._a("options.language")));
        this.buttonList.add(new GuiButton(103, this.width / 2 + 2, this.height / 6 + 120 - 6, 150, 20, wpcz._a("options.multiplayer.title")));
        this.buttonList.add(new GuiButton(105, this.width / 2 - 152, this.height / 6 + 144 - 6, 150, 20, wpcz._a("options.resourcepack")));
        this.buttonList.add(new GuiButton(104, this.width / 2 + 2, this.height / 6 + 144 - 6, 150, 20, wpcz._a("options.snooper.view")));
        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 168, wpcz._a("gui.done")));
        GloomyHooks.onInitGuiOptions(this);
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        if (!guiButton.enabled) {
            return;
        }
        if (guiButton.id < 100 && guiButton instanceof baxz) {
            this._c.setOptionValue(((baxz)guiButton).returnEnumOptions(), 1);
            guiButton.displayString = this._c.getKeyBinding(EnumOptions._a(guiButton.id));
        }
        if (guiButton.id == 101) {
            this.mc._M.saveOptions();
            this.mc._a(new stkl(this, this._c));
        }
        if (guiButton.id == 100) {
            this.mc._M.saveOptions();
            this.mc._a(new nuzu(this, this._c));
        }
        if (guiButton.id == 102) {
            this.mc._M.saveOptions();
            this.mc._a(new twpa(this, this._c, this.mc._U()));
        }
        if (guiButton.id == 103) {
            this.mc._M.saveOptions();
            this.mc._a(new ScreenChatOptions(this, this._c));
        }
        if (guiButton.id == 104) {
            this.mc._M.saveOptions();
            this.mc._a(new ifno(this, this._c));
        }
        if (guiButton.id == 200) {
            this.mc._M.saveOptions();
            this.mc._a(this._b);
        }
        if (guiButton.id == 105) {
            this.mc._M.saveOptions();
            this.mc._a(new ekou(this, this._c));
        }
        GloomyHooks.onOptionsActionPerformed(this, guiButton);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, this._d, this.width / 2, 15, 0xFFFFFF);
        super.drawScreen(n, n2, f);
    }
}

