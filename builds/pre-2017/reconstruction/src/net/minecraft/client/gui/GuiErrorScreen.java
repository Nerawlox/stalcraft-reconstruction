/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class GuiErrorScreen
extends GuiScreen {
    public String message1;
    public String message2;

    public GuiErrorScreen(String string, String string2) {
        this.message1 = string;
        this.message2 = string2;
    }

    @Override
    public void initGui() {
        super.initGui();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, 140, wpcz._a("gui.cancel")));
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawGradientRect(0, 0, this.width, this.height, -12574688, -11530224);
        this.drawCenteredString(this.fontRenderer, this.message1, this.width / 2, 90, 0xFFFFFF);
        this.drawCenteredString(this.fontRenderer, this.message2, this.width / 2, 110, 0xFFFFFF);
        super.drawScreen(n, n2, f);
    }

    @Override
    public void keyTyped(char c, int n) {
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        this.mc._a((GuiScreen)null);
    }
}

