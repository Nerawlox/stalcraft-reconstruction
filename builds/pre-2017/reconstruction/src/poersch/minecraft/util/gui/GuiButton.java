/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.util.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class GuiButton
extends net.minecraft.client.gui.GuiButton {
    protected String toolTipString;

    public GuiButton(int n, int n2, int n3, String string) {
        this(n, n2, n3, 200, 20, string);
    }

    public GuiButton(int n, int n2, int n3, int n4, int n5, String string) {
        super(n, n2, n3, n4, n5, string);
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public GuiButton setToolTip(String string) {
        this.toolTipString = string;
        return this;
    }

    public String getToolTip() {
        return this.toolTipString;
    }

    public GuiButton mouseOver() {
        return this.drawButton && this.field_82253_i ? this : null;
    }

    @Override
    public void drawButton(Minecraft minecraft, int n, int n2) {
        if (this.drawButton) {
            FontRenderer fontRenderer = minecraft._z;
            minecraft._R()._a(net.minecraft.client.gui.GuiButton.buttonTextures);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            this.field_82253_i = n >= this.xPosition && n2 >= this.yPosition && n < this.xPosition + this.width && n2 < this.yPosition + this.height;
            int n3 = this.getHoverState(this.field_82253_i);
            this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 46 + n3 * 20, this.width / 2, this.height);
            this.drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition, 200 - this.width / 2, 46 + n3 * 20, this.width / 2, this.height);
            this.mouseDragged(minecraft, n, n2);
            int n4 = 0xE0E0E0;
            if (!this.enabled) {
                n4 = -6250336;
            } else if (this.field_82253_i) {
                n4 = 0xFFFFA0;
            }
            int n5 = fontRenderer._b(this.displayString);
            if (n5 > this.width - 8) {
                float f = (float)(this.width - 8) / (float)n5;
                GL11.glPushMatrix();
                GL11.glScalef(f, 1.0f, 1.0f);
                this.drawCenteredString(fontRenderer, this.displayString, (int)((float)(this.xPosition + this.width / 2) / f), this.yPosition + (this.height - 8) / 2, n4);
                GL11.glPopMatrix();
            } else {
                this.drawCenteredString(fontRenderer, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, n4);
            }
        }
    }
}

