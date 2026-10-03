/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiNEIButton
extends GuiButton {
    protected static ResourceLocation guiTex = new ResourceLocation("textures/gui/widgets.png");

    public GuiNEIButton(int n, int n2, int n3, int n4, int n5, String string) {
        super(n, n2, n3, n4, n5, string);
    }

    @Override
    public void drawButton(Minecraft minecraft, int n, int n2) {
        if (!this.drawButton) {
            return;
        }
        FontRenderer fontRenderer = minecraft._z;
        minecraft._h._a(guiTex);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        boolean bl = n >= this.xPosition && n2 >= this.yPosition && n < this.xPosition + this.width && n2 < this.yPosition + this.height;
        int n3 = this.getHoverState(bl);
        this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 46 + n3 * 20, this.width / 2, this.height / 2);
        this.drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition, 200 - this.width / 2, 46 + n3 * 20, this.width / 2, this.height / 2);
        this.drawTexturedModalRect(this.xPosition, this.yPosition + this.height / 2, 0, 46 + n3 * 20 + 20 - this.height / 2, this.width / 2, this.height / 2);
        this.drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition + this.height / 2, 200 - this.width / 2, 46 + n3 * 20 + 20 - this.height / 2, this.width / 2, this.height / 2);
        this.mouseDragged(minecraft, n, n2);
        if (!this.enabled) {
            this.drawCenteredString(fontRenderer, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, -6250336);
        } else if (bl) {
            this.drawCenteredString(fontRenderer, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, 0xFFFFA0);
        } else {
            this.drawCenteredString(fontRenderer, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, 0xE0E0E0);
        }
    }
}

