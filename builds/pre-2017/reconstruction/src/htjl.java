/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.asm.GloomyHooks;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiShareToLan;

public class htjl
extends GuiScreen {
    public int _a;
    public int _b;

    @Override
    public void initGui() {
        this._a = 0;
        this.buttonList.clear();
        int n = -16;
        int n2 = 98;
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 120 + n, wpcz._a("menu.returnToMenu")));
        if (!this.mc._H()) {
            ((GuiButton)this.buttonList.get((int)0)).displayString = wpcz._a("menu.disconnect");
        }
        this.buttonList.add(new GuiButton(4, this.width / 2 - 100, this.height / 4 + 24 + n, wpcz._a("menu.returnToGame")));
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + n, 98, 20, wpcz._a("menu.options")));
        GuiButton guiButton = new GuiButton(7, this.width / 2 + 2, this.height / 4 + 96 + n, 98, 20, wpcz._a("menu.shareToLan"));
        this.buttonList.add(guiButton);
        this.buttonList.add(new GuiButton(5, this.width / 2 - 100, this.height / 4 + 48 + n, 98, 20, wpcz._a("gui.achievements")));
        this.buttonList.add(new GuiButton(6, this.width / 2 + 2, this.height / 4 + 48 + n, 98, 20, wpcz._a("gui.stats")));
        guiButton.enabled = this.mc._I() && !this.mc._J()._b();
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        boolean bl = GloomyHooks.actionPerformed(this, guiButton);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        switch (guiButton.id) {
            case 0: {
                this.mc._a(new GuiOptions(this, this.mc._M));
                break;
            }
            case 1: {
                guiButton.enabled = false;
                this.mc._X._a(dzif._j, 1);
                this.mc._r.sendQuittingDisconnectingPacket();
                this.mc._a((pkix)null);
                this.mc._a(new fngq());
                break;
            }
            case 4: {
                this.mc._a((GuiScreen)null);
                this.mc._o();
                this.mc._N._h();
                break;
            }
            case 5: {
                this.mc._a(new ohbq(this.mc._X));
                break;
            }
            case 6: {
                this.mc._a(new uzta(this, this.mc._X));
                break;
            }
            case 7: {
                this.mc._a(new GuiShareToLan(this));
            }
        }
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        ++this._b;
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, "Game menu", this.width / 2, 40, 0xFFFFFF);
        super.drawScreen(n, n2, f);
    }
}

