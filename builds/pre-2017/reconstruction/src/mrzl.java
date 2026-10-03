/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.multiplayer.ServerData;
import org.lwjgl.input.Keyboard;

public class mrzl
extends GuiScreen {
    public final GuiScreen _a;
    public final ServerData _b;
    public GuiTextField _c;

    public mrzl(GuiScreen guiScreen, ServerData serverData) {
        this._a = guiScreen;
        this._b = serverData;
    }

    @Override
    public void updateScreen() {
        this._c.updateCursorCounter();
    }

    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 12, wpcz._a("selectServer.select")));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 120 + 12, wpcz._a("gui.cancel")));
        this._c = new GuiTextField(this.fontRenderer, this.width / 2 - 100, 116, 200, 20);
        this._c.setMaxStringLength(128);
        this._c.setFocused(true);
        this._c.setText(this.mc._M.lastServer);
        ((GuiButton)this.buttonList.get((int)0)).enabled = this._c.getText().length() > 0 && this._c.getText().split(":").length > 0;
    }

    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
        this.mc._M.lastServer = this._c.getText();
        this.mc._M.saveOptions();
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        if (!guiButton.enabled) {
            return;
        }
        if (guiButton.id == 1) {
            this._a.confirmClicked(false, 0);
        } else if (guiButton.id == 0) {
            this._b._b = this._c.getText();
            this._a.confirmClicked(true, 0);
        }
    }

    @Override
    public void keyTyped(char c, int n) {
        if (this._c.textboxKeyTyped(c, n)) {
            ((GuiButton)this.buttonList.get((int)0)).enabled = this._c.getText().length() > 0 && this._c.getText().split(":").length > 0;
        } else if (n == 28 || n == 156) {
            this.actionPerformed((GuiButton)this.buttonList.get(0));
        }
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        super.mouseClicked(n, n2, n3);
        this._c.mouseClicked(n, n2, n3);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, wpcz._a("selectServer.direct"), this.width / 2, 20, 0xFFFFFF);
        this.drawString(this.fontRenderer, wpcz._a("addServer.enterIp"), this.width / 2 - 100, 100, 0xA0A0A0);
        this._c.drawTextBox();
        super.drawScreen(n, n2, f);
    }
}

