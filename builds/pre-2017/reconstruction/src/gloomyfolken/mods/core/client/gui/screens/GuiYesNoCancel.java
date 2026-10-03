/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.screens;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiYesNo;

public class GuiYesNoCancel
extends GuiYesNo {
    public GuiYesNoCancel(GuiScreen guiScreen, String string, String string2, int n) {
        super(guiScreen, string, string2, n);
    }

    @Override
    public void setWorldAndResolution(Minecraft minecraft, int n, int n2) {
        this.parentScreen.setWorldAndResolution(minecraft, n, n2);
        super.setWorldAndResolution(minecraft, n, n2);
    }

    @Override
    public void initGui() {
        this.parentScreen.buttonList.forEach(object -> {
            GuiButton guiButton = (GuiButton)object;
            guiButton.enabled = false;
        });
        this.buttonList.add(new baxz(0, this.width / 2 - 125, this.height / 5 + 96, 70, 20, this.buttonText1));
        this.buttonList.add(new baxz(1, this.width / 2 - 125 + 75, this.height / 5 + 96, 70, 20, this.buttonText2));
        this.buttonList.add(new baxz(2, this.width / 2 - 125 + 75 + 75, this.height / 5 + 96, 100, 20, "\u041e\u0442\u043c\u0435\u043d\u0430"));
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        this.parentScreen.confirmClicked(false, guiButton.id);
    }

    @Override
    public void drawDefaultBackground() {
        this.drawGradientRect(this.width / 2 - 125 - 10, this.height / 5 + 70 - 10, this.width / 2 - 125 + 75 + 175 + 10, this.height / 5 + 116 + 10, -1072689136, -804253680);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.parentScreen.drawScreen(n, n2, f);
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, this.message1, this.width / 2, this.height / 5 + 70, 0xFFFFFF);
        this.drawCenteredString(this.fontRenderer, this.message2, this.width / 2, this.height / 5 + 82, 0xFFFFFF);
        for (int i = 0; i < this.buttonList.size(); ++i) {
            GuiButton guiButton = (GuiButton)this.buttonList.get(i);
            guiButton.drawButton(this.mc, n, n2);
        }
    }

    @Override
    protected void keyTyped(char c, int n) {
    }
}

