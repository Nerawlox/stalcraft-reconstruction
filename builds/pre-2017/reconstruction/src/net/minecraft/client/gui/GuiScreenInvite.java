/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import java.io.IOException;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.mco.ExceptionMcoService;
import net.minecraft.client.mco.McoServer;
import org.lwjgl.input.Keyboard;

public class GuiScreenInvite
extends GuiScreen {
    public GuiTextField _a;
    public McoServer _b;
    public final GuiScreen _c;
    public final xaxz _d;
    public final int _e = 0;
    public final int _f = 1;
    public String _g = "Could not invite the provided name";
    public String _h;
    public boolean _i;

    public GuiScreenInvite(GuiScreen guiScreen, xaxz xaxz2, McoServer mcoServer) {
        this._c = guiScreen;
        this._d = xaxz2;
        this._b = mcoServer;
    }

    @Override
    public void updateScreen() {
        this._a.updateCursorCounter();
    }

    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 12, wpcz._a("mco.configure.world.buttons.invite")));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 120 + 12, wpcz._a("gui.cancel")));
        this._a = new GuiTextField(this.fontRenderer, this.width / 2 - 100, 66, 200, 20);
        this._a.setFocused(true);
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
            this.mc._a(this._d);
        } else if (guiButton.id == 0) {
            rqmi rqmi2 = new rqmi(this.mc._P());
            if (this._a.getText() == null || this._a.getText().isEmpty()) {
                return;
            }
            try {
                McoServer mcoServer = rqmi2._b(this._b._a, this._a.getText());
                if (mcoServer != null) {
                    this._b._f = mcoServer._f;
                    this.mc._a(new xaxz(this._c, this._b));
                } else {
                    this._a(this._g);
                }
            }
            catch (ExceptionMcoService exceptionMcoService) {
                this.mc._O()._c(exceptionMcoService.toString());
                this._a(exceptionMcoService._b);
            }
            catch (IOException iOException) {
                this.mc._O()._b("Realms: could not parse response");
                this._a(this._g);
            }
        }
    }

    public void _a(String string) {
        this._i = true;
        this._h = string;
    }

    @Override
    public void keyTyped(char c, int n) {
        this._a.textboxKeyTyped(c, n);
        if (n == 15) {
            if (this._a.isFocused()) {
                this._a.setFocused(false);
            } else {
                this._a.setFocused(true);
            }
        }
        if (n == 28 || n == 156) {
            this.actionPerformed((GuiButton)this.buttonList.get(0));
        }
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        super.mouseClicked(n, n2, n3);
        this._a.mouseClicked(n, n2, n3);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this.drawString(this.fontRenderer, wpcz._a("mco.configure.world.invite.profile.name"), this.width / 2 - 100, 53, 0xA0A0A0);
        if (this._i) {
            this.drawCenteredString(this.fontRenderer, this._h, this.width / 2, 100, 0xFF0000);
        }
        this._a.drawTextBox();
        super.drawScreen(n, n2, f);
    }
}

