/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.world.EnumGameType;

public class GuiShareToLan
extends GuiScreen {
    public final GuiScreen _a;
    public GuiButton _b;
    public GuiButton _c;
    public String _d = "survival";
    public boolean _e;

    public GuiShareToLan(GuiScreen guiScreen) {
        this._a = guiScreen;
    }

    @Override
    public void initGui() {
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(101, this.width / 2 - 155, this.height - 28, 150, 20, wpcz._a("lanServer.start")));
        this.buttonList.add(new GuiButton(102, this.width / 2 + 5, this.height - 28, 150, 20, wpcz._a("gui.cancel")));
        this._c = new GuiButton(104, this.width / 2 - 155, 100, 150, 20, wpcz._a("selectWorld.gameMode"));
        this.buttonList.add(this._c);
        this._b = new GuiButton(103, this.width / 2 + 5, 100, 150, 20, wpcz._a("selectWorld.allowCommands"));
        this.buttonList.add(this._b);
        this._a();
    }

    public void _a() {
        this._c.displayString = wpcz._a("selectWorld.gameMode") + " " + wpcz._a("selectWorld.gameMode." + this._d);
        this._b.displayString = wpcz._a("selectWorld.allowCommands") + " ";
        this._b.displayString = this._e ? this._b.displayString + wpcz._a("options.on") : this._b.displayString + wpcz._a("options.off");
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        if (guiButton.id == 102) {
            this.mc._a(this._a);
        } else if (guiButton.id == 104) {
            this._d = this._d.equals("survival") ? "creative" : (this._d.equals("creative") ? "adventure" : "survival");
            this._a();
        } else if (guiButton.id == 103) {
            this._e = !this._e;
            this._a();
        } else if (guiButton.id == 101) {
            this.mc._a((GuiScreen)null);
            String string = this.mc._J()._a(EnumGameType._a(this._d), this._e);
            ChatMessageComponent chatMessageComponent = string != null ? ChatMessageComponent._b("commands.publish.started", string) : ChatMessageComponent._d("commands.publish.failed");
            this.mc._J.getChatGUI()._a(chatMessageComponent._a(true));
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, wpcz._a("lanServer.title"), this.width / 2, 50, 0xFFFFFF);
        this.drawCenteredString(this.fontRenderer, wpcz._a("lanServer.otherPlayers"), this.width / 2, 82, 0xFFFFFF);
        super.drawScreen(n, n2, f);
    }
}

