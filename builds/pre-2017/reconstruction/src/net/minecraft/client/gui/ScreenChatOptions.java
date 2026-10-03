/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlider;
import net.minecraft.client.settings.EnumOptions;
import net.minecraft.client.settings.GameSettings;

public class ScreenChatOptions
extends GuiScreen {
    public static final EnumOptions[] _a = new EnumOptions[]{EnumOptions._r, EnumOptions._s, EnumOptions._t, EnumOptions._u, EnumOptions._v, EnumOptions._C, EnumOptions._E, EnumOptions._F, EnumOptions._D};
    public static final EnumOptions[] _b = new EnumOptions[]{EnumOptions._A};
    public final GuiScreen _c;
    public final GameSettings _d;
    public String _e;
    public String _f;
    public int _g;

    public ScreenChatOptions(GuiScreen guiScreen, GameSettings gameSettings) {
        this._c = guiScreen;
        this._d = gameSettings;
    }

    @Override
    public void initGui() {
        int n = 0;
        this._e = wpcz._a("options.chat.title");
        this._f = wpcz._a("options.multiplayer.title");
        for (EnumOptions enumOptions : _a) {
            if (enumOptions._a()) {
                this.buttonList.add(new GuiSlider(enumOptions._c(), this.width / 2 - 155 + n % 2 * 160, this.height / 6 + 24 * (n >> 1), enumOptions, this._d.getKeyBinding(enumOptions), this._d.getOptionFloatValue(enumOptions)));
            } else {
                this.buttonList.add(new baxz(enumOptions._c(), this.width / 2 - 155 + n % 2 * 160, this.height / 6 + 24 * (n >> 1), enumOptions, this._d.getKeyBinding(enumOptions)));
            }
            ++n;
        }
        if (n % 2 == 1) {
            ++n;
        }
        this._g = this.height / 6 + 24 * (n >> 1);
        n += 2;
        for (EnumOptions enumOptions : _b) {
            if (enumOptions._a()) {
                this.buttonList.add(new GuiSlider(enumOptions._c(), this.width / 2 - 155 + n % 2 * 160, this.height / 6 + 24 * (n >> 1), enumOptions, this._d.getKeyBinding(enumOptions), this._d.getOptionFloatValue(enumOptions)));
            } else {
                this.buttonList.add(new baxz(enumOptions._c(), this.width / 2 - 155 + n % 2 * 160, this.height / 6 + 24 * (n >> 1), enumOptions, this._d.getKeyBinding(enumOptions)));
            }
            ++n;
        }
        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 168, wpcz._a("gui.done")));
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        if (!guiButton.enabled) {
            return;
        }
        if (guiButton.id < 100 && guiButton instanceof baxz) {
            this._d.setOptionValue(((baxz)guiButton).returnEnumOptions(), 1);
            guiButton.displayString = this._d.getKeyBinding(EnumOptions._a(guiButton.id));
        }
        if (guiButton.id == 200) {
            this.mc._M.saveOptions();
            this.mc._a(this._c);
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, this._e, this.width / 2, 20, 0xFFFFFF);
        this.drawCenteredString(this.fontRenderer, this._f, this.width / 2, this._g + 7, 0xFFFFFF);
        super.drawScreen(n, n2, f);
    }
}

