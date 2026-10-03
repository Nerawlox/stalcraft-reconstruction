/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class GuiYesNo
extends GuiScreen {
    public GuiScreen parentScreen;
    public String message1;
    public String message2;
    public String buttonText1;
    public String buttonText2;
    public int worldNumber;

    public GuiYesNo(GuiScreen guiScreen, String string, String string2, int n) {
        this.parentScreen = guiScreen;
        this.message1 = string;
        this.message2 = string2;
        this.worldNumber = n;
        this.buttonText1 = wpcz._a("gui.yes");
        this.buttonText2 = wpcz._a("gui.no");
    }

    public GuiYesNo(GuiScreen guiScreen, String string, String string2, String string3, String string4, int n) {
        this.parentScreen = guiScreen;
        this.message1 = string;
        this.message2 = string2;
        this.buttonText1 = string3;
        this.buttonText2 = string4;
        this.worldNumber = n;
    }

    @Override
    public void initGui() {
        this.buttonList.add(new baxz(0, this.width / 2 - 155, this.height / 6 + 96, this.buttonText1));
        this.buttonList.add(new baxz(1, this.width / 2 - 155 + 160, this.height / 6 + 96, this.buttonText2));
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        this.parentScreen.confirmClicked(guiButton.id == 0, this.worldNumber);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, this.message1, this.width / 2, 70, 0xFFFFFF);
        this.drawCenteredString(this.fontRenderer, this.message2, this.width / 2, 90, 0xFFFFFF);
        super.drawScreen(n, n2, f);
    }
}

