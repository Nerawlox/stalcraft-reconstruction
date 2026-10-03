/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.world.storage.WorldInfo;
import org.lwjgl.input.Keyboard;

public class GuiRenameWorld
extends GuiScreen {
    public GuiScreen _a;
    public GuiTextField _b;
    public final String _c;

    public GuiRenameWorld(GuiScreen guiScreen, String string) {
        this._a = guiScreen;
        this._c = string;
    }

    @Override
    public void updateScreen() {
        this._b.updateCursorCounter();
    }

    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 12, wpcz._a("selectWorld.renameButton")));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 120 + 12, wpcz._a("gui.cancel")));
        ISaveFormat iSaveFormat = this.mc._g();
        WorldInfo worldInfo = iSaveFormat._c(this._c);
        String string = worldInfo._k();
        this._b = new GuiTextField(this.fontRenderer, this.width / 2 - 100, 60, 200, 20);
        this._b.setFocused(true);
        this._b.setText(string);
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
            this.mc._a(this._a);
        } else if (guiButton.id == 0) {
            ISaveFormat iSaveFormat = this.mc._g();
            iSaveFormat._a(this._c, this._b.getText().trim());
            this.mc._a(this._a);
        }
    }

    @Override
    public void keyTyped(char c, int n) {
        this._b.textboxKeyTyped(c, n);
        boolean bl = ((GuiButton)this.buttonList.get((int)0)).enabled = this._b.getText().trim().length() > 0;
        if (n == 28 || n == 156) {
            this.actionPerformed((GuiButton)this.buttonList.get(0));
        }
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        super.mouseClicked(n, n2, n3);
        this._b.mouseClicked(n, n2, n3);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, wpcz._a("selectWorld.renameTitle"), this.width / 2, 20, 0xFFFFFF);
        this.drawString(this.fontRenderer, wpcz._a("selectWorld.enterName"), this.width / 2 - 100, 47, 0xA0A0A0);
        this._b.drawTextBox();
        super.drawScreen(n, n2, f);
    }
}

