/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.util.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import org.lwjgl.opengl.GL11;
import poersch.minecraft.util.gui.GuiButton;

@SideOnly(value=Side.CLIENT)
public class GuiHorizontalBar
extends GuiButton {
    public GuiHorizontalBar(int n, int n2, int n3, int n4, int n5) {
        super(n, n2, n3, n4, n5, "");
    }

    @Override
    protected void drawGradientRect(int n, int n2, int n3, int n4, int n5, int n6) {
        float f = (float)(n5 >> 24 & 0xFF) / 255.0f;
        float f2 = (float)(n5 >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n5 >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n5 & 0xFF) / 255.0f;
        float f5 = (float)(n6 >> 24 & 0xFF) / 255.0f;
        float f6 = (float)(n6 >> 16 & 0xFF) / 255.0f;
        float f7 = (float)(n6 >> 8 & 0xFF) / 255.0f;
        float f8 = (float)(n6 & 0xFF) / 255.0f;
        GL11.glDisable(3553);
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(770, 771);
        GL11.glShadeModel(7425);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_F(f2, f3, f4, f);
        tessellator.addVertex(n, n2, this.zLevel);
        tessellator.addVertex(n, n4, this.zLevel);
        tessellator.setColorRGBA_F(f6, f7, f8, f5);
        tessellator.addVertex(n3, n4, this.zLevel);
        tessellator.addVertex(n3, n2, this.zLevel);
        tessellator.draw();
        GL11.glShadeModel(7424);
        GL11.glDisable(3042);
        GL11.glEnable(3008);
        GL11.glEnable(3553);
    }

    @Override
    public void drawButton(Minecraft minecraft, int n, int n2) {
        if (this.drawButton) {
            this.drawGradientRect(this.xPosition, this.yPosition, this.xPosition + this.width / 2, this.yPosition + this.height, 0x666666, -10066330);
            this.drawGradientRect(this.xPosition + this.width / 2, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, -10066330, 0x666666);
        }
    }
}

