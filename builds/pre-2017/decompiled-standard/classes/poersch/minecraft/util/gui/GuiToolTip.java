/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.util.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.client.xpzm;
import poersch.minecraft.util.gui.GuiButton;

@SideOnly(value=Side.CLIENT)
public class GuiToolTip
extends bawa {
    private GuiButton guiButton = null;
    private List<String> infoText = null;
    private int infoWidth = 0;
    private int infoHeight = 0;
    private int timer = 0;

    public void setButton(xpzm xpzm2, GuiButton guiButton) {
        if (this.guiButton != guiButton) {
            if (guiButton != null && guiButton.getToolTip() != null && guiButton.getToolTip().length() != 0) {
                this.infoText = xpzm2._z._c(guiButton.getToolTip(), 242);
                this.infoWidth = 0;
                int n = 0;
                for (int i = 0; i < this.infoText.size(); ++i) {
                    n = xpzm2._z._b(this.infoText.get(i));
                    if (n <= this.infoWidth) continue;
                    this.infoWidth = n;
                }
                this.infoWidth += 8;
                this.infoHeight = this.infoText.size() * xpzm2._z._c + 7;
            } else {
                this.infoText = null;
            }
            this.guiButton = guiButton;
            this.timer = 0;
        }
    }

    public void draw(xpzm xpzm2, int n, int n2) {
        if (this.infoText != null && this.timer++ > 100) {
            int n3 = n + 5 + this.infoWidth < xpzm2._B.field_73880_f ? n + 5 : xpzm2._B.field_73880_f - this.infoWidth;
            int n4 = n2 + 5 + this.infoHeight < xpzm2._B.field_73881_g ? n2 + 5 : xpzm2._B.field_73881_g - this.infoHeight;
            GuiToolTip.func_73734_a(n3, n4, n3 + this.infoWidth, n4 + this.infoHeight, -1157627904);
            for (int i = 0; i < this.infoText.size(); ++i) {
                xpzm2._z._a(this.infoText.get(i), n3 + 4, n4 + 4 + i * xpzm2._z._c, -1);
            }
        }
    }
}

