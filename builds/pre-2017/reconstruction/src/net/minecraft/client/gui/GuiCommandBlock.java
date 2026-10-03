/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntityCommandBlock;
import org.lwjgl.input.Keyboard;

public class GuiCommandBlock
extends GuiScreen {
    public GuiTextField _a;
    public final TileEntityCommandBlock _b;
    public GuiButton _c;
    public GuiButton _d;

    public GuiCommandBlock(TileEntityCommandBlock tileEntityCommandBlock) {
        this._b = tileEntityCommandBlock;
    }

    @Override
    public void updateScreen() {
        this._a.updateCursorCounter();
    }

    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        this._c = new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 12, wpcz._a("gui.done"));
        this.buttonList.add(this._c);
        this._d = new GuiButton(1, this.width / 2 - 100, this.height / 4 + 120 + 12, wpcz._a("gui.cancel"));
        this.buttonList.add(this._d);
        this._a = new GuiTextField(this.fontRenderer, this.width / 2 - 150, 60, 300, 20);
        this._a.setMaxStringLength(Short.MAX_VALUE);
        this._a.setFocused(true);
        this._a.setText(this._b._a());
        this._c.enabled = this._a.getText().trim().length() > 0;
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
            this.mc._a((GuiScreen)null);
        } else if (guiButton.id == 0) {
            String string = "MC|AdvCdm";
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeInt(this._b.xCoord);
                dataOutputStream.writeInt(this._b.yCoord);
                dataOutputStream.writeInt(this._b.zCoord);
                Packet.writeString(this._a.getText(), dataOutputStream);
                this.mc._z()._b(new Packet250CustomPayload(string, byteArrayOutputStream.toByteArray()));
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            this.mc._a((GuiScreen)null);
        }
    }

    @Override
    public void keyTyped(char c, int n) {
        this._a.textboxKeyTyped(c, n);
        boolean bl = this._c.enabled = this._a.getText().trim().length() > 0;
        if (n == 28 || n == 156) {
            this.actionPerformed(this._c);
        } else if (n == 1) {
            this.actionPerformed(this._d);
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
        this.drawCenteredString(this.fontRenderer, wpcz._a("advMode.setCommand"), this.width / 2, 20, 0xFFFFFF);
        this.drawString(this.fontRenderer, wpcz._a("advMode.command"), this.width / 2 - 150, 47, 0xA0A0A0);
        this.drawString(this.fontRenderer, wpcz._a("advMode.nearestPlayer"), this.width / 2 - 150, 97, 0xA0A0A0);
        this.drawString(this.fontRenderer, wpcz._a("advMode.randomPlayer"), this.width / 2 - 150, 108, 0xA0A0A0);
        this.drawString(this.fontRenderer, wpcz._a("advMode.allPlayers"), this.width / 2 - 150, 119, 0xA0A0A0);
        this._a.drawTextBox();
        super.drawScreen(n, n2, f);
    }
}

