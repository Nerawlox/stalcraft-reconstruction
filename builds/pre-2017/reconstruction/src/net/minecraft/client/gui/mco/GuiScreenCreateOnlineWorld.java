/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui.mco;

import java.util.ArrayList;
import java.util.Collections;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenLongRunningTask;
import net.minecraft.client.gui.GuiTextField;
import org.lwjgl.input.Keyboard;

public class GuiScreenCreateOnlineWorld
extends rqmv {
    public GuiScreen _a;
    public GuiTextField _b;
    public GuiTextField _c;
    public String _d;
    public String _e;
    public static int _f;
    public static int _g;
    public static int _h;
    public boolean _i;
    public String _j = "You must enter a name!";
    public ekjj _k;

    public GuiScreenCreateOnlineWorld(GuiScreen guiScreen) {
        this.buttonList = Collections.synchronizedList(new ArrayList());
        this._a = guiScreen;
    }

    @Override
    public void updateScreen() {
        this._b.updateCursorCounter();
        this._d = this._b.getText();
        this._c.updateCursorCounter();
        this._e = this._c.getText();
    }

    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(_f, this.width / 2 - 100, this.height / 4 + 120 + 17, 97, 20, wpcz._a("mco.create.world")));
        this.buttonList.add(new GuiButton(_g, this.width / 2 + 5, this.height / 4 + 120 + 17, 95, 20, wpcz._a("gui.cancel")));
        this._b = new GuiTextField(this.fontRenderer, this.width / 2 - 100, 65, 200, 20);
        this._b.setFocused(true);
        if (this._d != null) {
            this._b.setText(this._d);
        }
        this._c = new GuiTextField(this.fontRenderer, this.width / 2 - 100, 111, 200, 20);
        if (this._e != null) {
            this._c.setText(this._e);
        }
        if (this._k == null) {
            this.buttonList.add(new GuiButton(_h, this.width / 2 - 100, 147, 200, 20, wpcz._a("mco.template.default.name")));
        } else {
            this._c.setText("");
            this._c.setEnabled(false);
            this._c.setFocused(false);
            this.buttonList.add(new GuiButton(_h, this.width / 2 - 100, 147, 200, 20, wpcz._a("mco.template.name") + ": " + this._k._b));
        }
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
        if (guiButton.id == _g) {
            this.mc._a(this._a);
        } else if (guiButton.id == _f) {
            this._a();
        } else if (guiButton.id == _h) {
            this.mc._a(new jzwn(this, this._k));
        }
    }

    public void _a() {
        if (this._b()) {
            ceaj ceaj2 = new ceaj(this, this._b.getText(), "Minecraft Realms Server", this._e, this._k);
            GuiScreenLongRunningTask guiScreenLongRunningTask = new GuiScreenLongRunningTask(this.mc, this._a, ceaj2);
            guiScreenLongRunningTask._a();
            this.mc._a(guiScreenLongRunningTask);
        }
    }

    public boolean _b() {
        this._i = this._b.getText() == null || this._b.getText().trim().equals("");
        return !this._i;
    }

    @Override
    public void keyTyped(char c, int n) {
        this._b.textboxKeyTyped(c, n);
        this._c.textboxKeyTyped(c, n);
        if (n == 15) {
            this._b.setFocused(!this._b.isFocused());
            this._c.setFocused(!this._c.isFocused());
        }
        if (n == 28 || n == 156) {
            this.actionPerformed((GuiButton)this.buttonList.get(0));
        }
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
        this.drawCenteredString(this.fontRenderer, wpcz._a("mco.selectServer.create"), this.width / 2, 11, 0xFFFFFF);
        this.drawString(this.fontRenderer, wpcz._a("mco.configure.world.name"), this.width / 2 - 100, 52, 0xA0A0A0);
        this.drawString(this.fontRenderer, wpcz._a("mco.create.world.seed"), this.width / 2 - 100, 98, 0xA0A0A0);
        if (this._i) {
            this.drawCenteredString(this.fontRenderer, this._j, this.width / 2, 167, 0xFF0000);
        }
        this._b.drawTextBox();
        this._c.drawTextBox();
        super.drawScreen(n, n2, f);
    }

    public void _a(ekjj ekjj2) {
        this._k = ekjj2;
    }

    public static /* synthetic */ Minecraft _a(GuiScreenCreateOnlineWorld guiScreenCreateOnlineWorld) {
        return guiScreenCreateOnlineWorld.mc;
    }

    public static /* synthetic */ GuiScreen _b(GuiScreenCreateOnlineWorld guiScreenCreateOnlineWorld) {
        return guiScreenCreateOnlineWorld._a;
    }

    public static /* synthetic */ Minecraft _c(GuiScreenCreateOnlineWorld guiScreenCreateOnlineWorld) {
        return guiScreenCreateOnlineWorld.mc;
    }

    public static /* synthetic */ Minecraft _d(GuiScreenCreateOnlineWorld guiScreenCreateOnlineWorld) {
        return guiScreenCreateOnlineWorld.mc;
    }

    public static /* synthetic */ Minecraft _e(GuiScreenCreateOnlineWorld guiScreenCreateOnlineWorld) {
        return guiScreenCreateOnlineWorld.mc;
    }

    public static /* synthetic */ Minecraft _f(GuiScreenCreateOnlineWorld guiScreenCreateOnlineWorld) {
        return guiScreenCreateOnlineWorld.mc;
    }

    static {
        _g = 1;
        _h = 2;
    }
}

