/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.network.packet.Packet0KeepAlive;

public class iwmg
extends GuiScreen {
    public bscn _a;
    public int _b;

    public iwmg(bscn bscn2) {
        this._a = bscn2;
    }

    @Override
    public void keyTyped(char c, int n) {
    }

    @Override
    public void initGui() {
        this.buttonList.clear();
    }

    @Override
    public void updateScreen() {
        ++this._b;
        if (this._b % 20 == 0) {
            this._a._b(new Packet0KeepAlive());
        }
        if (this._a != null) {
            this._a._b();
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawBackground(0);
        this.drawCenteredString(this.fontRenderer, wpcz._a("multiplayer.downloadingTerrain"), this.width / 2, this.height / 2 - 50, 0xFFFFFF);
        super.drawScreen(n, n2, f);
    }
}

