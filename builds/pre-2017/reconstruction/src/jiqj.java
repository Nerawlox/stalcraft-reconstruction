/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.gui.GuiButton;
import net.minecraft.network.packet.Packet19EntityAction;

public class jiqj
extends fndz {
    @Override
    public void initGui() {
        super.initGui();
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height - 40, wpcz._a("multiplayer.stopSleeping")));
    }

    @Override
    public void keyTyped(char c, int n) {
        if (n == 1) {
            this._b();
        } else if (n == 28 || n == 156) {
            String string = this._h.getText().trim();
            if (string.length() > 0) {
                this.mc._t.sendChatMessage(string);
            }
            this._h.setText("");
            this.mc._J.getChatGUI()._d();
        } else {
            super.keyTyped(c, n);
        }
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        if (guiButton.id == 1) {
            this._b();
        } else {
            super.actionPerformed(guiButton);
        }
    }

    public void _b() {
        bscn bscn2 = this.mc._t.sendQueue;
        bscn2._b(new Packet19EntityAction(this.mc._t, 3));
    }
}

