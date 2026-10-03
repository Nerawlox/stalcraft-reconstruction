/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.EnumChatFormatting;
import org.lwjgl.opengl.GL11;

public class jzpo
extends GuiScreen {
    public int _b;

    @Override
    public void initGui() {
        this.buttonList.clear();
        if (this.mc._r.getWorldInfo()._t()) {
            if (this.mc._H()) {
                this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 96, wpcz._a("deathScreen.deleteWorld")));
            } else {
                this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 96, wpcz._a("deathScreen.leaveServer")));
            }
        } else {
            this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 72, wpcz._a("deathScreen.respawn")));
            this.buttonList.add(new GuiButton(2, this.width / 2 - 100, this.height / 4 + 96, wpcz._a("deathScreen.titleScreen")));
            if (this.mc._P() == null) {
                ((GuiButton)this.buttonList.get((int)1)).enabled = false;
            }
        }
        for (GuiButton guiButton : this.buttonList) {
            guiButton.enabled = false;
        }
    }

    @Override
    public void keyTyped(char c, int n) {
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        switch (guiButton.id) {
            case 1: {
                this.mc._t.respawnPlayer();
                this.mc._a((GuiScreen)null);
                break;
            }
            case 2: {
                this.mc._r.sendQuittingDisconnectingPacket();
                this.mc._a((pkix)null);
                this.mc._a(new fngq());
            }
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawGradientRect(0, 0, this.width, this.height, 0x60500000, -1602211792);
        GL11.glPushMatrix();
        GL11.glScalef(2.0f, 2.0f, 2.0f);
        boolean bl = this.mc._r.getWorldInfo()._t();
        String string = bl ? wpcz._a("deathScreen.title.hardcore") : wpcz._a("deathScreen.title");
        this.drawCenteredString(this.fontRenderer, string, this.width / 2 / 2, 30, 0xFFFFFF);
        GL11.glPopMatrix();
        if (bl) {
            this.drawCenteredString(this.fontRenderer, wpcz._a("deathScreen.hardcoreInfo"), this.width / 2, 144, 0xFFFFFF);
        }
        this.drawCenteredString(this.fontRenderer, wpcz._a("deathScreen.score") + ": " + (Object)((Object)EnumChatFormatting._o) + this.mc._t.getScore(), this.width / 2, 100, 0xFFFFFF);
        super.drawScreen(n, n2, f);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        ++this._b;
        if (this._b == 20) {
            for (GuiButton guiButton : this.buttonList) {
                guiButton.enabled = true;
            }
        }
    }
}

