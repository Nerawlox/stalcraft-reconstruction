/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.respawn;

import gloomyfolken.bundle.common.core.eidj;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

@gloomyfolken.bundle.common.core.ezey(_a={eidj.CLIENT})
public class ezey
extends jzpo {
    public int _a;
    private int _c = 0;

    @Override
    public void drawScreen(int n, int n2, float f) {
        super.drawScreen(n, n2, f);
        if (this._a > 0) {
            String string = "\u041e\u0441\u0442\u0430\u043b\u043e\u0441\u044c: " + (this._a / 20 + 1 >= 60 ? this._a / 1200 + " \u043c\u0438\u043d." : this._a / 20 + 1 + " \u0441\u0435\u043a.");
            this.drawCenteredString(this.mc._z, string, this.width / 2, 110, 0xFFFFFF);
        }
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        --this._a;
        ++this._c;
        for (GuiButton guiButton : this.buttonList) {
            if (guiButton.id != 1) continue;
            guiButton.enabled = this._c >= 20 && this._a <= 0;
        }
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        switch (guiButton.id) {
            case 1: {
                this.mc._t.sendQueue._b(new ndnf(1));
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
}

