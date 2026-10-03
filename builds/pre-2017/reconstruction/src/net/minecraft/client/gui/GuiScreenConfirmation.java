/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.mco.GuiScreenConfirmationType;

public class GuiScreenConfirmation
extends GuiScreen {
    public final GuiScreenConfirmationType _a;
    public final String _b;
    public final String _c;
    public final GuiScreen _d;
    public final String _e;
    public final String _f;
    public final int _g;

    public GuiScreenConfirmation(GuiScreen guiScreen, GuiScreenConfirmationType guiScreenConfirmationType, String string, String string2, int n) {
        this._d = guiScreen;
        this._g = n;
        this._a = guiScreenConfirmationType;
        this._b = string;
        this._c = string2;
        this._e = wpcz._a("gui.yes");
        this._f = wpcz._a("gui.no");
    }

    @Override
    public void initGui() {
        this.buttonList.add(new baxz(0, this.width / 2 - 155, this.height / 6 + 112, this._e));
        this.buttonList.add(new baxz(1, this.width / 2 - 155 + 160, this.height / 6 + 112, this._f));
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        this._d.confirmClicked(guiButton.id == 0, this._g);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, this._a._d, this.width / 2, 70, this._a._c);
        this.drawCenteredString(this.fontRenderer, this._b, this.width / 2, 90, 0xFFFFFF);
        this.drawCenteredString(this.fontRenderer, this._c, this.width / 2, 110, 0xFFFFFF);
        super.drawScreen(n, n2, f);
    }
}

