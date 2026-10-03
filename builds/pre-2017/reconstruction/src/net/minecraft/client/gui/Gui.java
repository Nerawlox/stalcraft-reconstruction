/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import gloomyfolken.mods.asm.ItemAtlasHooks;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class Gui {
    public static final ResourceLocation optionsBackground = new ResourceLocation("textures/gui/options_background.png");
    public static final ResourceLocation statIcons = new ResourceLocation("textures/gui/container/stats_icons.png");
    public static final ResourceLocation icons = new ResourceLocation("textures/gui/icons.png");
    public float zLevel;

    public void drawHorizontalLine(int n, int n2, int n3, int n4) {
        if (n2 < n) {
            int n5 = n;
            n = n2;
            n2 = n5;
        }
        Gui.drawRect(n, n3, n2 + 1, n3 + 1, n4);
    }

    public void drawVerticalLine(int n, int n2, int n3, int n4) {
        if (n3 < n2) {
            int n5 = n2;
            n2 = n3;
            n3 = n5;
        }
        Gui.drawRect(n, n2 + 1, n + 1, n3, n4);
    }

    public static void drawRect(int n, int n2, int n3, int n4, int n5) {
        int n6;
        if (n < n3) {
            n6 = n;
            n = n3;
            n3 = n6;
        }
        if (n2 < n4) {
            n6 = n2;
            n2 = n4;
            n4 = n6;
        }
        float f = (float)(n5 >> 24 & 0xFF) / 255.0f;
        float f2 = (float)(n5 >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n5 >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n5 & 0xFF) / 255.0f;
        Tessellator tessellator = Tessellator.instance;
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(f2, f3, f4, f);
        tessellator.startDrawingQuads();
        tessellator.addVertex(n, n4, 0.0);
        tessellator.addVertex(n3, n4, 0.0);
        tessellator.addVertex(n3, n2, 0.0);
        tessellator.addVertex(n, n2, 0.0);
        tessellator.draw();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
    }

    public void drawGradientRect(int n, int n2, int n3, int n4, int n5, int n6) {
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
        tessellator.addVertex(n3, n2, this.zLevel);
        tessellator.addVertex(n, n2, this.zLevel);
        tessellator.setColorRGBA_F(f6, f7, f8, f5);
        tessellator.addVertex(n, n4, this.zLevel);
        tessellator.addVertex(n3, n4, this.zLevel);
        tessellator.draw();
        GL11.glShadeModel(7424);
        GL11.glDisable(3042);
        GL11.glEnable(3008);
        GL11.glEnable(3553);
    }

    public void drawCenteredString(FontRenderer fontRenderer, String string, int n, int n2, int n3) {
        fontRenderer._a(string, n - fontRenderer._b(string) / 2, n2, n3);
    }

    public void drawString(FontRenderer fontRenderer, String string, int n, int n2, int n3) {
        fontRenderer._a(string, n, n2, n3);
    }

    public void drawTexturedModalRect(int n, int n2, int n3, int n4, int n5, int n6) {
        float f = 0.00390625f;
        float f2 = 0.00390625f;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(n + 0, n2 + n6, this.zLevel, (float)(n3 + 0) * f, (float)(n4 + n6) * f2);
        tessellator.addVertexWithUV(n + n5, n2 + n6, this.zLevel, (float)(n3 + n5) * f, (float)(n4 + n6) * f2);
        tessellator.addVertexWithUV(n + n5, n2 + 0, this.zLevel, (float)(n3 + n5) * f, (float)(n4 + 0) * f2);
        tessellator.addVertexWithUV(n + 0, n2 + 0, this.zLevel, (float)(n3 + 0) * f, (float)(n4 + 0) * f2);
        tessellator.draw();
    }

    public void drawTexturedModelRectFromIcon(int n, int n2, Icon icon, int n3, int n4) {
        ItemAtlasHooks.drawTexturedModelRectFromIcon(this, n, n2, icon, n3, n4);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(n + 0, n2 + n4, this.zLevel, icon.getMinU(), icon.getMaxV());
        tessellator.addVertexWithUV(n + n3, n2 + n4, this.zLevel, icon.getMaxU(), icon.getMaxV());
        tessellator.addVertexWithUV(n + n3, n2 + 0, this.zLevel, icon.getMaxU(), icon.getMinV());
        tessellator.addVertexWithUV(n + 0, n2 + 0, this.zLevel, icon.getMinU(), icon.getMinV());
        tessellator.draw();
    }
}

