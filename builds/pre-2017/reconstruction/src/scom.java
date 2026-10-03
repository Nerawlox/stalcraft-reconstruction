/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenConfirmation;
import net.minecraft.client.gui.GuiScreenLongRunningTask;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.mco.GuiScreenConfirmationType;
import net.minecraft.client.mco.McoServer;
import org.lwjgl.input.Keyboard;

public class scom
extends rqmv {
    public GuiScreen _a;
    public McoServer _b;
    public GuiTextField _c;
    public final int _d = 1;
    public final int _e = 2;
    public static int _f = 3;
    public ekjj _g;
    public GuiButton _h;

    public scom(GuiScreen guiScreen, McoServer mcoServer) {
        this._a = guiScreen;
        this._b = mcoServer;
    }

    @Override
    public void updateScreen() {
        this._c.updateCursorCounter();
    }

    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        this._h = new GuiButton(1, this.width / 2 - 100, this.height / 4 + 120 + 12, 97, 20, wpcz._a("mco.configure.world.buttons.reset"));
        this.buttonList.add(this._h);
        this.buttonList.add(new GuiButton(2, this.width / 2 + 5, this.height / 4 + 120 + 12, 97, 20, wpcz._a("gui.cancel")));
        this._c = new GuiTextField(this.fontRenderer, this.width / 2 - 100, 99, 200, 20);
        this._c.setFocused(true);
        this._c.setMaxStringLength(32);
        this._c.setText("");
        if (this._g == null) {
            this.buttonList.add(new GuiButton(_f, this.width / 2 - 100, 125, 200, 20, wpcz._a("mco.template.default.name")));
        } else {
            this._c.setText("");
            this._c.setEnabled(false);
            this._c.setFocused(false);
            this.buttonList.add(new GuiButton(_f, this.width / 2 - 100, 125, 200, 20, wpcz._a("mco.template.name") + ": " + this._g._b));
        }
    }

    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    public void keyTyped(char c, int n) {
        this._c.textboxKeyTyped(c, n);
        if (n == 28 || n == 156) {
            this.actionPerformed(this._h);
        }
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        if (!guiButton.enabled) {
            return;
        }
        if (guiButton.id == 2) {
            this.mc._a(this._a);
        } else if (guiButton.id == 1) {
            String string = wpcz._a("mco.configure.world.reset.question.line1");
            String string2 = wpcz._a("mco.configure.world.reset.question.line2");
            this.mc._a(new GuiScreenConfirmation(this, GuiScreenConfirmationType._a, string, string2, 1));
        } else if (guiButton.id == _f) {
            this.mc._a(new jzwn(this, this._g));
        }
    }

    @Override
    public void confirmClicked(boolean bl, int n) {
        if (bl && n == 1) {
            this._a();
        } else {
            this.mc._a(this);
        }
    }

    public void _a() {
        ifre ifre2 = new ifre(this, this._b._a, this._c.getText(), this._g);
        GuiScreenLongRunningTask guiScreenLongRunningTask = new GuiScreenLongRunningTask(this.mc, this._a, ifre2);
        guiScreenLongRunningTask._a();
        this.mc._a(guiScreenLongRunningTask);
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        super.mouseClicked(n, n2, n3);
        this._c.mouseClicked(n, n2, n3);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, wpcz._a("mco.reset.world.title"), this.width / 2, 17, 0xFFFFFF);
        this.drawCenteredString(this.fontRenderer, wpcz._a("mco.reset.world.warning"), this.width / 2, 56, 0xFF0000);
        this.drawString(this.fontRenderer, wpcz._a("mco.reset.world.seed"), this.width / 2 - 100, 86, 0xA0A0A0);
        this._c.drawTextBox();
        super.drawScreen(n, n2, f);
    }

    public void _a(ekjj ekjj2) {
        this._g = ekjj2;
    }

    public static /* synthetic */ GuiScreen _a(scom scom2) {
        return scom2._a;
    }

    public static /* synthetic */ Minecraft _b(scom scom2) {
        return scom2.mc;
    }

    public static /* synthetic */ Minecraft _c(scom scom2) {
        return scom2.mc;
    }

    public static /* synthetic */ Minecraft _d(scom scom2) {
        return scom2.mc;
    }
}

