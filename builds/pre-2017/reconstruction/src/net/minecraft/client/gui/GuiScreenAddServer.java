/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.multiplayer.ServerData;
import org.lwjgl.input.Keyboard;

public class GuiScreenAddServer
extends GuiScreen {
    public GuiScreen _a;
    public GuiTextField _b;
    public GuiTextField _c;
    public ServerData _d;

    public GuiScreenAddServer(GuiScreen guiScreen, ServerData serverData) {
        this._a = guiScreen;
        this._d = serverData;
    }

    @Override
    public void updateScreen() {
        this._c.updateCursorCounter();
        this._b.updateCursorCounter();
    }

    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 12, wpcz._a("addServer.add")));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 120 + 12, wpcz._a("gui.cancel")));
        this.buttonList.add(new GuiButton(2, this.width / 2 - 100, 142, wpcz._a("addServer.hideAddress") + ": " + (this._d._b() ? wpcz._a("gui.yes") : wpcz._a("gui.no"))));
        this._c = new GuiTextField(this.fontRenderer, this.width / 2 - 100, 66, 200, 20);
        this._c.setFocused(true);
        this._c.setText(this._d._a);
        this._b = new GuiTextField(this.fontRenderer, this.width / 2 - 100, 106, 200, 20);
        this._b.setMaxStringLength(128);
        this._b.setText(this._d._b);
        ((GuiButton)this.buttonList.get((int)0)).enabled = this._b.getText().length() > 0 && this._b.getText().split(":").length > 0 && this._c.getText().length() > 0;
    }

    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        if (!guiButton.enabled) {
            return;
        }
        if (guiButton.id == 1) {
            this._a.confirmClicked(false, 0);
        } else if (guiButton.id == 0) {
            this._d._a = this._c.getText();
            this._d._b = this._b.getText();
            this._a.confirmClicked(true, 0);
        } else if (guiButton.id == 2) {
            this._d._b(!this._d._b());
            ((GuiButton)this.buttonList.get((int)2)).displayString = wpcz._a("addServer.hideAddress") + ": " + (this._d._b() ? wpcz._a("gui.yes") : wpcz._a("gui.no"));
        }
    }

    @Override
    public void keyTyped(char c, int n) {
        this._c.textboxKeyTyped(c, n);
        this._b.textboxKeyTyped(c, n);
        if (n == 15) {
            this._c.setFocused(!this._c.isFocused());
            this._b.setFocused(!this._b.isFocused());
        }
        if (n == 28 || n == 156) {
            this.actionPerformed((GuiButton)this.buttonList.get(0));
        }
        ((GuiButton)this.buttonList.get((int)0)).enabled = this._b.getText().length() > 0 && this._b.getText().split(":").length > 0 && this._c.getText().length() > 0;
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        super.mouseClicked(n, n2, n3);
        this._b.mouseClicked(n, n2, n3);
        this._c.mouseClicked(n, n2, n3);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, wpcz._a("addServer.title"), this.width / 2, 17, 0xFFFFFF);
        this.drawString(this.fontRenderer, wpcz._a("addServer.enterName"), this.width / 2 - 100, 53, 0xA0A0A0);
        this.drawString(this.fontRenderer, wpcz._a("addServer.enterIp"), this.width / 2 - 100, 94, 0xA0A0A0);
        this._c.drawTextBox();
        this._b.drawTextBox();
        super.drawScreen(n, n2, f);
    }
}

