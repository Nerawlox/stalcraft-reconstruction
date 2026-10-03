/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.mco;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class GuiScreenClientOutdated
extends GuiScreen {
    public final GuiScreen _a;

    public GuiScreenClientOutdated(GuiScreen guiScreen) {
        this._a = guiScreen;
    }

    @Override
    public void initGui() {
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 120 + 12, "Back"));
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        String string = wpcz._a("mco.client.outdated.title");
        String string2 = wpcz._a("mco.client.outdated.msg");
        this.drawCenteredString(this.fontRenderer, string, this.width / 2, this.height / 2 - 50, 0xFF0000);
        this.drawCenteredString(this.fontRenderer, string2, this.width / 2, this.height / 2 - 30, 0xFFFFFF);
        super.drawScreen(n, n2, f);
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        if (guiButton.id == 0) {
            this.mc._a(this._a);
        }
    }

    @Override
    public void keyTyped(char c, int n) {
        if (n == 28 || n == 156) {
            this.mc._a(this._a);
        }
    }
}

