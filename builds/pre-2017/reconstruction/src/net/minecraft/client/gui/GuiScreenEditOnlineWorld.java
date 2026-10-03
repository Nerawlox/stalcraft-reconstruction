/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import java.io.UnsupportedEncodingException;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenOnlineServersSubscreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.mco.ExceptionMcoService;
import net.minecraft.client.mco.McoServer;
import org.lwjgl.input.Keyboard;

public class GuiScreenEditOnlineWorld
extends GuiScreen {
    public GuiScreen _a;
    public GuiScreen _b;
    public GuiTextField _c;
    public GuiTextField _d;
    public McoServer _e;
    public GuiButton _f;
    public int _g;
    public int _h;
    public int _i;
    public GuiScreenOnlineServersSubscreen _j;

    public GuiScreenEditOnlineWorld(GuiScreen guiScreen, GuiScreen guiScreen2, McoServer mcoServer) {
        this._a = guiScreen;
        this._b = guiScreen2;
        this._e = mcoServer;
    }

    @Override
    public void updateScreen() {
        this._d.updateCursorCounter();
        this._c.updateCursorCounter();
    }

    @Override
    public void initGui() {
        this._g = this.width / 4;
        this._h = this.width / 4 - 2;
        this._i = this.width / 2 + 4;
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        this._f = new GuiButton(0, this._g, this.height / 4 + 120 + 22, this._h, 20, wpcz._a("mco.configure.world.buttons.done"));
        this.buttonList.add(this._f);
        this.buttonList.add(new GuiButton(1, this._i, this.height / 4 + 120 + 22, this._h, 20, wpcz._a("gui.cancel")));
        this._d = new GuiTextField(this.fontRenderer, this._g, 56, 212, 20);
        this._d.setFocused(true);
        this._d.setMaxStringLength(32);
        this._d.setText(this._e._b());
        this._c = new GuiTextField(this.fontRenderer, this._g, 96, 212, 20);
        this._c.setMaxStringLength(32);
        this._c.setText(this._e._a());
        this._j = new GuiScreenOnlineServersSubscreen(this.width, this.height, this._g, 122, this._e._i, this._e._j);
        this.buttonList.addAll(this._j._e);
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
            this._a();
        } else if (guiButton.id == 2) {
            this.mc._a(new scom(this, this._e));
        } else {
            this._j._a(guiButton);
        }
    }

    public void _a() {
        rqmi rqmi2 = new rqmi(this.mc._P());
        try {
            String string = this._c.getText() == null || this._c.getText().trim().equals("") ? null : this._c.getText();
            rqmi2._a(this._e._a, this._d.getText(), string, this._j._i, this._j._j);
            this._e._a(this._d.getText());
            this._e._b(this._c.getText());
            this._e._i = this._j._i;
            this._e._j = this._j._j;
            this.mc._a(new xaxz(this._b, this._e));
        }
        catch (ExceptionMcoService exceptionMcoService) {
            this.mc._O()._c(exceptionMcoService.toString());
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            this.mc._O()._b("Realms: " + unsupportedEncodingException.getLocalizedMessage());
        }
    }

    @Override
    public void keyTyped(char c, int n) {
        this._d.textboxKeyTyped(c, n);
        this._c.textboxKeyTyped(c, n);
        if (n == 15) {
            this._d.setFocused(!this._d.isFocused());
            this._c.setFocused(!this._c.isFocused());
        }
        if (n == 28 || n == 156) {
            this._a();
        }
        this._f.enabled = this._d.getText() != null && !this._d.getText().trim().equals("");
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        super.mouseClicked(n, n2, n3);
        this._c.mouseClicked(n, n2, n3);
        this._d.mouseClicked(n, n2, n3);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, wpcz._a("mco.configure.world.edit.title"), this.width / 2, 17, 0xFFFFFF);
        this.drawString(this.fontRenderer, wpcz._a("mco.configure.world.name"), this._g, 43, 0xA0A0A0);
        this.drawString(this.fontRenderer, wpcz._a("mco.configure.world.description"), this._g, 84, 0xA0A0A0);
        this._d.drawTextBox();
        this._c.drawTextBox();
        this._j._a(this, this.fontRenderer);
        super.drawScreen(n, n2, f);
    }
}

