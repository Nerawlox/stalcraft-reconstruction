/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiYesNo;

public class GuiConfirmOpenLink
extends GuiYesNo {
    public String _a;
    public String _b;
    public String _c;
    public boolean _d = true;

    public GuiConfirmOpenLink(GuiScreen guiScreen, String string, int n, boolean bl) {
        super(guiScreen, wpcz._a(bl ? "chat.link.confirmTrusted" : "chat.link.confirm"), string, n);
        this.buttonText1 = wpcz._a(bl ? "chat.link.open" : "gui.yes");
        this.buttonText2 = wpcz._a(bl ? "gui.cancel" : "gui.no");
        this._b = wpcz._a("chat.copy");
        this._a = wpcz._a("chat.link.warning");
        this._c = string;
    }

    @Override
    public void initGui() {
        this.buttonList.add(new GuiButton(0, this.width / 3 - 83 + 0, this.height / 6 + 96, 100, 20, this.buttonText1));
        this.buttonList.add(new GuiButton(2, this.width / 3 - 83 + 105, this.height / 6 + 96, 100, 20, this._b));
        this.buttonList.add(new GuiButton(1, this.width / 3 - 83 + 210, this.height / 6 + 96, 100, 20, this.buttonText2));
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        if (guiButton.id == 2) {
            this._a();
        }
        this.parentScreen.confirmClicked(guiButton.id == 0, this.worldNumber);
    }

    public void _a() {
        GuiConfirmOpenLink.setClipboardString(this._c);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        super.drawScreen(n, n2, f);
        if (this._d) {
            this.drawCenteredString(this.fontRenderer, this._a, this.width / 2, 110, 0xFFCCCC);
        }
    }

    public void _b() {
        this._d = false;
    }
}

