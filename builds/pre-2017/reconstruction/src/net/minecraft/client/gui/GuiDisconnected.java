/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import java.util.List;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class GuiDisconnected
extends GuiScreen {
    public String _a;
    public String _b;
    public Object[] _c;
    public List _d;
    public final GuiScreen _e;

    public GuiDisconnected(GuiScreen guiScreen, String string, String string2, Object ... objectArray) {
        this._e = guiScreen;
        this._a = wpcz._a(string);
        this._b = string2;
        this._c = objectArray;
    }

    @Override
    public void keyTyped(char c, int n) {
    }

    @Override
    public void initGui() {
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 120 + 12, wpcz._a("gui.toMenu")));
        this._d = this._c != null ? this.fontRenderer._c(wpcz._a(this._b, this._c), this.width - 50) : this.fontRenderer._c(wpcz._a(this._b), this.width - 50);
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        if (guiButton.id == 0) {
            this.mc._a(this._e);
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, this._a, this.width / 2, this.height / 2 - 50, 0xAAAAAA);
        int n3 = this.height / 2 - 30;
        if (this._d != null) {
            for (String string : this._d) {
                this.drawCenteredString(this.fontRenderer, string, this.width / 2, n3, 0xFFFFFF);
                n3 += this.fontRenderer._c;
            }
        }
        super.drawScreen(n, n2, f);
    }
}

