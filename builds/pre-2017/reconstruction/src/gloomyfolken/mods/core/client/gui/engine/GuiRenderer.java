/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine;

import gloomyfolken.mods.asm.ItemAtlasHooks;
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.ScissorHelper;
import gloomyfolken.mods.core.client.gui.engine.component.ButtonState;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentButtonStyle;
import gloomyfolken.mods.core.client.gui.font.IFontRenderer;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiRenderer {
    private static Minecraft mc = Minecraft._E();
    public final int texWidth;
    public final int texHeight;
    public final float scale;
    public final float zLevel;
    protected final IFontRenderer fr;
    private final float du;
    private final float dv;
    private Point origin = Point.zeroPoint;

    public GuiRenderer(int n, int n2, float f, float f2, IFontRenderer iFontRenderer) {
        this.texWidth = n;
        this.texHeight = n2;
        this.scale = f;
        this.fr = iFontRenderer;
        this.zLevel = f2;
        this.du = 1.0f / (float)n;
        this.dv = 1.0f / (float)n2;
    }

    public void setOrigin(Point point) {
        this.origin = point;
    }

    public void clearOrigin() {
        this.origin = Point.zeroPoint;
    }

    protected int getOriginX() {
        return this.origin.x;
    }

    protected int getOriginY() {
        return this.origin.y;
    }

    public void bindTexture(ResourceLocation resourceLocation) {
        GuiRenderer.mc._h._a(resourceLocation);
    }

    public void drawRect(Point point, Dimension dimension, int n) {
        this.drawRect(point.x, point.y, dimension.width, dimension.height, n);
    }

    public void drawRect(double d, double d2, double d3, double d4, int n) {
        d += (double)this.getOriginX();
        d2 += (double)this.getOriginY();
        float f = (float)(n >> 24 & 0xFF) / 255.0f;
        float f2 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n & 0xFF) / 255.0f;
        Tessellator tessellator = Tessellator.instance;
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_F(f2, f3, f4, f);
        tessellator.addVertex(d * (double)this.scale, (d2 + d4) * (double)this.scale, this.zLevel);
        tessellator.addVertex((d + d3) * (double)this.scale, (d2 + d4) * (double)this.scale, this.zLevel);
        tessellator.addVertex((d + d3) * (double)this.scale, d2 * (double)this.scale, this.zLevel);
        tessellator.addVertex(d * (double)this.scale, d2 * (double)this.scale, this.zLevel);
        tessellator.draw();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
    }

    public void drawGradientRect(Point point, Dimension dimension, int n, int n2) {
        this.drawGradientRect(point.x, point.y, dimension.width, dimension.height, n, n2);
    }

    public void drawGradientRect(double d, double d2, double d3, double d4, int n, int n2) {
        d += (double)this.getOriginX();
        d2 += (double)this.getOriginY();
        float f = (float)(n >> 24 & 0xFF) / 255.0f;
        float f2 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n & 0xFF) / 255.0f;
        float f5 = (float)(n2 >> 24 & 0xFF) / 255.0f;
        float f6 = (float)(n2 >> 16 & 0xFF) / 255.0f;
        float f7 = (float)(n2 >> 8 & 0xFF) / 255.0f;
        float f8 = (float)(n2 & 0xFF) / 255.0f;
        GL11.glDisable(3553);
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(770, 771);
        GL11.glShadeModel(7425);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_F(f2, f3, f4, f);
        tessellator.addVertex((d + d3) * (double)this.scale, d2 * (double)this.scale, this.zLevel);
        tessellator.addVertex(d * (double)this.scale, d2 * (double)this.scale, this.zLevel);
        tessellator.setColorRGBA_F(f6, f7, f8, f5);
        tessellator.addVertex(d * (double)this.scale, (d2 + d4) * (double)this.scale, this.zLevel);
        tessellator.addVertex((d + d3) * (double)this.scale, (d2 + d4) * (double)this.scale, this.zLevel);
        tessellator.draw();
        GL11.glShadeModel(7424);
        GL11.glDisable(3042);
        GL11.glEnable(3008);
        GL11.glEnable(3553);
    }

    public void drawHorizontalGradient(float f, float f2, float f3, float f4, int n, int n2) {
        f += (float)this.getOriginX();
        f2 += (float)this.getOriginY();
        float f5 = this.zLevel;
        GL11.glDisable(3553);
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(770, 771);
        GL11.glShadeModel(7425);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_I(n2 & 0xFFFFFF, n2 >> 24 & 0xFF);
        tessellator.addVertex((f + f3) * this.scale, f2 * this.scale, f5);
        tessellator.setColorRGBA_I(n & 0xFFFFFF, n >> 24 & 0xFF);
        tessellator.addVertex(f * this.scale, f2 * this.scale, f5);
        tessellator.addVertex(f * this.scale, (f2 + f4) * this.scale, f5);
        tessellator.setColorRGBA_I(n2 & 0xFFFFFF, n2 >> 24 & 0xFF);
        tessellator.addVertex((f + f3) * this.scale, (f2 + f4) * this.scale, f5);
        tessellator.draw();
        GL11.glShadeModel(7424);
        GL11.glDisable(3042);
        GL11.glEnable(3008);
        GL11.glEnable(3553);
    }

    public void drawTexturedRect(Point point, Point point2, Point point3, Dimension dimension) {
        this.drawTexturedRect(point.x, point.y, (float)point2.x * this.du, (float)point2.y * this.dv, (float)point3.x * this.du, (float)point3.y * this.dv, dimension.width, dimension.height);
    }

    public void drawTexturedRect(int n, int n2, float f, float f2, float f3, float f4, int n3, int n4) {
        int n5 = n3;
        int n6 = n4;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV((float)((n += this.getOriginX()) + 0) * this.scale, (float)((n2 += this.getOriginY()) + n6) * this.scale, this.zLevel, f, f4);
        tessellator.addVertexWithUV((float)(n + n5) * this.scale, (float)(n2 + n6) * this.scale, this.zLevel, f3, f4);
        tessellator.addVertexWithUV((float)(n + n5) * this.scale, (float)(n2 + 0) * this.scale, this.zLevel, f3, f2);
        tessellator.addVertexWithUV((float)(n + 0) * this.scale, (float)(n2 + 0) * this.scale, this.zLevel, f, f2);
        tessellator.draw();
    }

    public void drawTexturedModalRect(Point point, Point point2, Dimension dimension) {
        this.drawTexturedRect(point.x, point.y, (float)point2.x * this.du, (float)point2.y * this.dv, (float)(point2.x + dimension.width) * this.du, (float)(point2.y + dimension.height) * this.dv, dimension.width, dimension.height);
    }

    public void drawTexturedModalRect(int n, int n2, int n3, int n4, int n5, int n6) {
        this.drawTexturedRect(n, n2, (float)n3 * this.du, (float)n4 * this.dv, (float)(n3 + n5) * this.du, (float)(n4 + n6) * this.dv, n5, n6);
    }

    public void drawIcon(Point point, Icon icon, Dimension dimension) {
        this.drawTexturedRect(point.x, point.y, icon.getMinU(), icon.getMinV(), icon.getMaxU(), icon.getMaxV(), dimension.width, dimension.height);
    }

    public void drawIcon(int n, int n2, Icon icon, int n3, int n4) {
        this.drawTexturedRect(n, n2, icon.getMinU(), icon.getMinV(), icon.getMaxU(), icon.getMaxV(), n3, n4);
    }

    public void drawTiledRect(Point point, Point point2, Dimension dimension, Dimension dimension2, int n) {
        this.drawTiledRect(point, point2, dimension, dimension2, n, n);
    }

    public void drawTiledRect(Point point, Point point2, Dimension dimension, Dimension dimension2, int n, int n2) {
        int n3 = point.x;
        int n4 = point.y;
        int n5 = point2.x;
        int n6 = point2.y;
        if (dimension.equals(dimension2)) {
            this.drawTexturedModalRect(n3, n4, n5, n6, dimension.width, dimension.height);
        } else if (dimension.width > dimension2.width && dimension.height == dimension2.height) {
            int n7;
            int n8 = dimension2.width - n * 2;
            this.drawTexturedModalRect(n3, n4, n5, n6, n, dimension.height);
            n3 += n;
            for (int i = dimension.width - n * 2; i > 0; i -= n7) {
                n7 = Math.min(n8, i);
                this.drawTexturedModalRect(n3, n4, n5 + n, n6, n7, dimension.height);
                n3 += n7;
            }
            this.drawTexturedModalRect(n3, n4, n5 + dimension2.width - n, n6, n, dimension.height);
        } else if (dimension.height > dimension2.height && dimension.width == dimension2.width) {
            int n9;
            int n10 = dimension2.height - n2 * 2;
            this.drawTexturedModalRect(n3, n4, n5, n6, dimension.width, n2);
            n4 += n2;
            for (int i = dimension.height - n2 * 2; i > 0; i -= n9) {
                n9 = Math.min(n10, i);
                this.drawTexturedModalRect(n3, n4, n5, n6 + n2, dimension.width, n9);
                n4 += n9;
            }
            this.drawTexturedModalRect(n3, n4, n5, n6 + dimension2.height - n2, dimension.width, n2);
        } else if (dimension.width <= dimension2.width && dimension.height <= dimension2.height) {
            int n11 = dimension.width / 2 + dimension.width % 2;
            int n12 = dimension.height / 2 + dimension.height % 2;
            this.drawTexturedModalRect(n3, n4, n5, n6, n11, n12);
            this.drawTexturedModalRect(n3, n4 + n12, n5, n6 + dimension2.height - dimension.height / 2, n11, dimension.height / 2);
            this.drawTexturedModalRect(n3 + n11, n4, n5 + dimension2.width - dimension.width / 2, n6, dimension.width / 2, n12);
            this.drawTexturedModalRect(n3 + n11, n4 + n12, n5 + dimension2.width - dimension.width / 2, n6 + dimension2.height - dimension.height / 2, dimension.width / 2, dimension.height / 2);
        } else {
            int n13;
            int n14;
            int n15 = Math.min(n2, dimension.height / 2);
            int n16 = Math.min(n, dimension.width / 2);
            this.drawTexturedModalRect(n3, n4, n5, n6, n16, n15);
            this.drawTexturedModalRect(n3 + dimension.width - n16, n4, n5 + dimension2.width - n16, n6, n16, n15);
            this.drawTexturedModalRect(n3, n4 + dimension.height - n15, n5, n6 + dimension2.height - n15, n16, n15);
            this.drawTexturedModalRect(n3 + dimension.width - n16, n4 + dimension.height - n15, n5 + dimension2.width - n16, n6 + dimension2.height - n15, n16, n15);
            int n17 = dimension.width - n16 * 2;
            int n18 = dimension2.width - n16 * 2;
            int n19 = n3 + n16;
            while (n17 > 0) {
                n14 = Math.max(Math.min(n17, n18), 0);
                n17 -= n14;
                this.drawTexturedModalRect(n19, n4, n5 + n16, n6, n14, n15);
                this.drawTexturedModalRect(n19, n4 + dimension.height - n15, n5 + n16, n6 + dimension2.height - n15, n14, n15);
                n19 += n14;
            }
            n14 = dimension.height - n15 * 2;
            int n20 = dimension2.height - n15 * 2;
            int n21 = n4 + n15;
            while (n14 > 0) {
                n13 = Math.max(Math.min(n14, n20), 0);
                n14 -= n13;
                this.drawTexturedModalRect(n3, n21, n5, n6 + n15, n16, n13);
                this.drawTexturedModalRect(n3 + dimension.width - n16, n21, n5 + dimension2.width - n16, n6 + n15, n16, n13);
                n21 += n13;
            }
            n17 = dimension.width - n16 * 2;
            n18 = dimension2.width - n16 * 2;
            n19 = n3 + n16;
            while (n17 > 0) {
                n13 = Math.min(n17, n18);
                n17 -= n13;
                n14 = dimension.height - n15 * 2;
                n20 = dimension2.height - n15 * 2;
                n21 = n4 + n15;
                while (n14 > 0) {
                    int n22 = Math.min(n14, n20);
                    n14 -= n22;
                    this.drawTexturedModalRect(n19, n21, n5 + n16, n6 + n15, n13, n22);
                    n21 += n22;
                }
                n19 += n13;
            }
        }
    }

    public void drawButton(int n, int n2, Dimension dimension, ComponentButtonStyle componentButtonStyle, ButtonState buttonState) {
        this.drawButton(new Point(n, n2), dimension, componentButtonStyle, buttonState);
    }

    public void drawButton(Point point, Dimension dimension, ComponentButtonStyle componentButtonStyle, ButtonState buttonState) {
        Point point2;
        if (componentButtonStyle == null) {
            return;
        }
        GuiRenderer.mc._h._a(componentButtonStyle.getResourceLocation());
        switch (buttonState) {
            case MOUSE_OVER: {
                point2 = componentButtonStyle.getMouseOverUv();
                break;
            }
            case ACTIVE: {
                point2 = componentButtonStyle.getActiveUv();
                break;
            }
            case DISABLED: {
                point2 = componentButtonStyle.getDisabledUv();
                break;
            }
            default: {
                point2 = componentButtonStyle.getDefaultUv();
            }
        }
        this.drawTiledRect(point, point2, dimension, componentButtonStyle.getSize(), componentButtonStyle.getBorderSizeX(), componentButtonStyle.getBorderSizeY());
    }

    public void scaledScissor(int n, int n2, int n3, int n4) {
        int n5 = GuiRenderer.mc._n;
        int n6 = GuiRenderer.mc._o;
        int n7 = 1;
        int n8 = GuiRenderer.mc._M.guiScale;
        if (n8 == 0) {
            n8 = 1000;
        }
        while (n7 < n8 && n5 / (n7 + 1) >= 320 && n6 / (n7 + 1) >= 240) {
            ++n7;
        }
        n = (int)((float)(n * n7) * this.scale);
        n2 = (int)((float)(n2 * n7) * this.scale);
        n3 = (int)((float)(n3 * n7) * this.scale);
        n4 = (int)((float)(n4 * n7) * this.scale);
        n2 = GuiRenderer.mc._o - n2 - n4;
        ScissorHelper.applyScissor(n, n2, n3, n4);
    }

    public void scaledScissor(Point point, Dimension dimension) {
        this.scaledScissor(point.x, point.y, dimension.width, dimension.height);
    }

    public int getStringWidth(String string) {
        return (int)((float)this.fr.getStringWidth(string) / this.scale);
    }

    public int getFontHeight() {
        return (int)((float)this.fr.getFontHeight() / this.scale);
    }

    public void drawCenteredString(String string, Point point, int n) {
        this.drawString(string, point.add(-this.getStringWidth(string) / 2, -this.getFontHeight() / 2), n);
    }

    public void drawCenteredString(String string, int n, int n2, int n3) {
        this.drawString(string, n - this.getStringWidth(string) / 2, n2 - this.getFontHeight() / 2, n3);
    }

    public int drawString(String string, Point point, int n) {
        return this.drawString(string, point.x, point.y, n);
    }

    public int drawString(String string, int n, int n2, int n3) {
        return this.drawString(string, n, n2, n3, false);
    }

    public int drawString(String string, int n, int n2, int n3, boolean bl) {
        int n4 = bl ? this.renderStringAbsolutePos(string, n + (int)(1.0f / this.scale), n2 + (int)(1.0f / this.scale), n3, true) : this.renderStringAbsolutePos(string, n += this.getOriginX(), n2 += this.getOriginY(), n3, false);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        return (int)((float)n4 / this.scale) - this.getOriginX();
    }

    public int renderStringAbsolutePos(String string, int n, int n2, int n3, boolean bl) {
        return this.fr.renderString(string, (int)((float)n * this.scale), (int)((float)n2 * this.scale), n3, bl);
    }

    public String trimToWidth(String string, int n, boolean bl) {
        if (this.getStringWidth(string) <= n) {
            return string;
        }
        if (bl) {
            n -= this.getStringWidth("..");
        }
        string = this.fr.trimToWidth(string, (int)((float)n * this.scale));
        if (bl) {
            string = string + "..";
        }
        return string;
    }

    public void drawHoveringText(List<String> list, Point point, Dimension dimension) {
        this.drawHoveringText(list, point.x, point.y, dimension.width, dimension.height);
    }

    public void drawHoveringText(List<String> list, float f, float f2, float f3, float f4) {
        if (!list.isEmpty()) {
            GL11.glDisable(32826);
            GL11.glDisable(2896);
            int n = 0;
            for (String string : list) {
                int n2 = this.getStringWidth(string);
                if (n2 <= n) continue;
                n = n2;
            }
            float f5 = f + 24.0f;
            float f6 = f2 - 24.0f;
            int n3 = 16;
            if (list.size() > 1) {
                n3 += 4 + (list.size() - 1) * 20;
            }
            if (f5 + (float)n > f3 * 2.0f) {
                f5 -= (float)(56 + n);
            }
            if (f6 + (float)n3 + 12.0f > f4 * 2.0f) {
                f6 = f4 * 2.0f - (float)n3 - 12.0f;
            }
            int n4 = -267386864;
            this.drawGradientRect(f5 - 6.0f, f6 - 8.0f, n + 12, 2.0, n4, n4);
            this.drawGradientRect(f5 - 6.0f, f6 + (float)n3 + 6.0f, n + 12, 2.0, n4, n4);
            this.drawGradientRect(f5 - 6.0f, f6 - 6.0f, n + 12, n3 + 14, n4, n4);
            this.drawGradientRect(f5 - 8.0f, f6 - 6.0f, 2.0, n3 + 12, n4, n4);
            this.drawGradientRect(f5 + (float)n + 6.0f, f6 - 6.0f, 2.0, n3 + 12, n4, n4);
            int n5 = 0x505000FF;
            int n6 = (n5 & 0xFEFEFE) >> 1 | n5 & 0xFF000000;
            this.drawGradientRect(f5 - 6.0f, f6 - 4.0f, 2.0, n3 + 8, n5, n6);
            this.drawGradientRect(f5 + (float)n + 4.0f, f6 - 4.0f, 2.0, n3 + 8, n5, n6);
            this.drawGradientRect(f5 - 6.0f, f6 - 6.0f, n + 12, 2.0, n5, n5);
            this.drawGradientRect(f5 - 6.0f, f6 + (float)n3 + 4.0f, n + 12, 2.0, n6, n6);
            for (int i = 0; i < list.size(); ++i) {
                String string = list.get(i);
                this.drawString(string, (int)f5, (int)f6, -1);
                if (i == 0) {
                    f6 += 4.0f;
                }
                f6 += 20.0f;
            }
            GL11.glEnable(2929);
            GL11.glEnable(32826);
        }
    }

    public List<String> wrapString(String string, int n) {
        return this.getFontRenderer().wrapString(string, (int)((float)n * this.scale));
    }

    public RenderItemHD createItemRender(float f) {
        return new RenderItemHD(f);
    }

    public GuiRenderer setFont(IFontRenderer iFontRenderer) {
        return new GuiRendererBuilder(this).setFontRenderer(iFontRenderer).create();
    }

    public IFontRenderer getFontRenderer() {
        return this.fr;
    }

    public class RenderItemHD
    extends RenderItem {
        public final float iconScale;
        public final int iconSize;

        protected RenderItemHD(float f) {
            this.iconScale = f;
            this.iconSize = (int)(16.0f * f);
        }

        public void renderStack(ItemStack itemStack, int n, int n2) {
            this.renderItemIcon(itemStack, n, n2);
            this.renderItemOverlay(itemStack, n, n2, null);
        }

        public void renderItemIcon(ItemStack itemStack, int n, int n2) {
            Block block;
            int n3 = itemStack._d;
            int n4 = itemStack._j();
            Icon icon = itemStack._b();
            Block block2 = block = n3 < Block.blocksList.length ? Block.blocksList[n3] : null;
            if (itemStack._c() == 0 && block != null && RenderBlocks._a(Block.blocksList[n3].getRenderType())) {
                GL11.glEnable(32826);
                qnon._c();
                mc._h._a(sctd._c);
                GL11.glPushMatrix();
                GL11.glTranslatef((float)(n += GuiRenderer.this.getOriginX()) * GuiRenderer.this.scale - 2.0f * this.iconScale * GuiRenderer.this.scale, (float)(n2 += GuiRenderer.this.getOriginY()) * GuiRenderer.this.scale + 3.0f * this.iconScale * GuiRenderer.this.scale, -3.0f + this.zLevel);
                GL11.glScalef(10.0f * this.iconScale * GuiRenderer.this.scale, 10.0f * this.iconScale * GuiRenderer.this.scale, 10.0f * this.iconScale * GuiRenderer.this.scale);
                GL11.glTranslatef(1.0f, 0.5f, 1.0f);
                GL11.glScalef(1.0f, 1.0f, -1.0f);
                GL11.glRotatef(210.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
                int n5 = Item.itemsList[n3].getColorFromItemStack(itemStack, 0);
                float f = (float)(n5 >> 16 & 0xFF) / 255.0f;
                float f2 = (float)(n5 >> 8 & 0xFF) / 255.0f;
                float f3 = (float)(n5 & 0xFF) / 255.0f;
                if (this.renderWithColor) {
                    GL11.glColor4f(f, f2, f3, 1.0f);
                }
                GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
                this.itemRenderBlocks._g = this.renderWithColor;
                this.itemRenderBlocks._a(block, n4, 1.0f);
                this.itemRenderBlocks._g = true;
                GL11.glPopMatrix();
                qnon._a();
                GL11.glDisable(32826);
            } else if (Item.itemsList[n3].requiresMultipleRenderPasses()) {
                GL11.glDisable(2896);
                for (int i = 0; i < Item.itemsList[n3].getRenderPasses(n4); ++i) {
                    ItemAtlasHooks.bindItemTexture(itemStack, (float)(this.iconSize * this.iconSize));
                    Icon icon2 = Item.itemsList[n3].getIcon(itemStack, i);
                    int n6 = Item.itemsList[n3].getColorFromItemStack(itemStack, i);
                    float f = (float)(n6 >> 16 & 0xFF) / 255.0f;
                    float f4 = (float)(n6 >> 8 & 0xFF) / 255.0f;
                    float f5 = (float)(n6 & 0xFF) / 255.0f;
                    if (this.renderWithColor) {
                        GL11.glColor4f(f, f4, f5, 1.0f);
                    }
                    GuiRenderer.this.drawIcon(n, n2, icon2, this.iconSize, this.iconSize);
                    if (!itemStack._c(i)) continue;
                    this.renderEffect(n, n2);
                }
                GL11.glEnable(2896);
            } else {
                GL11.glDisable(2896);
                ItemAtlasHooks.bindItemTexture(itemStack, (float)(this.iconSize * this.iconSize));
                if (icon == null) {
                    icon = ((sctd)Minecraft._E()._R()._b(sctd._e))._d("missingno");
                }
                int n7 = Item.itemsList[n3].getColorFromItemStack(itemStack, 0);
                float f = (float)(n7 >> 16 & 0xFF) / 255.0f;
                float f6 = (float)(n7 >> 8 & 0xFF) / 255.0f;
                float f7 = (float)(n7 & 0xFF) / 255.0f;
                if (this.renderWithColor) {
                    GL11.glColor4f(f, f6, f7, 1.0f);
                }
                GuiRenderer.this.drawIcon(n, n2, icon, this.iconSize, this.iconSize);
                GL11.glEnable(2896);
                if (itemStack._c(0)) {
                    this.renderEffect(n, n2);
                }
            }
            GL11.glEnable(2884);
        }

        protected void renderEffect(int n, int n2) {
            n += GuiRenderer.this.getOriginX();
            n2 += GuiRenderer.this.getOriginY();
            GL11.glDepthFunc(516);
            GL11.glDisable(2896);
            GL11.glDepthMask(false);
            mc._h._a(RenderItem.RES_ITEM_GLINT);
            this.zLevel -= 50.0f;
            GL11.glEnable(3042);
            GL11.glBlendFunc(774, 774);
            GL11.glColor4f(0.5f, 0.25f, 0.8f, 1.0f);
            this.renderGlint((int)((float)n * GuiRenderer.this.scale) - (int)(this.iconScale * GuiRenderer.this.scale), (int)((float)n2 * GuiRenderer.this.scale) - (int)(this.iconScale * GuiRenderer.this.scale), (int)(18.0f * this.iconScale * GuiRenderer.this.scale), (int)(18.0f * this.iconScale * GuiRenderer.this.scale));
            GL11.glDisable(3042);
            GL11.glDepthMask(true);
            this.zLevel += 50.0f;
            GL11.glEnable(2896);
            GL11.glDepthFunc(515);
        }

        protected void renderGlint(int n, int n2, int n3, int n4) {
            for (int i = 0; i < 2; ++i) {
                if (i == 0) {
                    GL11.glBlendFunc(768, 1);
                }
                if (i == 1) {
                    GL11.glBlendFunc(768, 1);
                }
                float f = 0.00390625f;
                float f2 = 0.00390625f;
                float f3 = (float)(Minecraft._M() % (long)(3000 + i * 1873)) / (3000.0f + (float)(i * 1873)) * 256.0f;
                float f4 = 0.0f;
                Tessellator tessellator = Tessellator.instance;
                float f5 = 4.0f;
                if (i == 1) {
                    f5 = -1.0f;
                }
                tessellator.startDrawingQuads();
                tessellator.addVertexWithUV(n + 0, n2 + n4, this.zLevel, (f3 + (float)n4 * f5) * f, (f4 + (float)n4) * f2);
                tessellator.addVertexWithUV(n + n3, n2 + n4, this.zLevel, (f3 + (float)n3 + (float)n4 * f5) * f, (f4 + (float)n4) * f2);
                tessellator.addVertexWithUV(n + n3, n2 + 0, this.zLevel, (f3 + (float)n3) * f, (f4 + 0.0f) * f2);
                tessellator.addVertexWithUV(n + 0, n2 + 0, this.zLevel, (f3 + 0.0f) * f, (f4 + 0.0f) * f2);
                tessellator.draw();
            }
        }

        protected void renderItemOverlay(ItemStack itemStack, int n, int n2, String string) {
            if (itemStack != null) {
                int n3;
                int n4;
                if (itemStack._b > 1 || string != null) {
                    String string2 = string == null ? String.valueOf(itemStack._b) : string;
                    GL11.glDisable(2896);
                    GL11.glDisable(2929);
                    n4 = n + this.iconSize - GuiRenderer.this.getStringWidth(string2);
                    n3 = n2 + this.iconSize - GuiRenderer.this.getFontHeight();
                    GuiRenderer.this.drawString(string2, n4, n3, 0xFFFFFF);
                    GL11.glEnable(2896);
                    GL11.glEnable(2929);
                }
                if (itemStack._h()) {
                    int n5 = (int)Math.round(13.0 - (double)itemStack._i() * 13.0 / (double)itemStack._k());
                    n4 = (int)Math.round(255.0 - (double)itemStack._i() * 255.0 / (double)itemStack._k());
                    GL11.glDisable(2896);
                    GL11.glDisable(3553);
                    n3 = -16777216;
                    int n6 = 255 - n4 << 16 | n4 << 8 | n3;
                    int n7 = (255 - n4) / 4 << 16 | 0x3F00 | n3;
                    GuiRenderer.this.drawRect(n + this.getScaledSize(2), n2 + this.getScaledSize(13), this.getScaledSize(13), this.getScaledSize(2), n3);
                    GuiRenderer.this.drawRect(n + this.getScaledSize(2), n2 + this.getScaledSize(13), this.getScaledSize(12), this.getScaledSize(1), n7);
                    GuiRenderer.this.drawRect(n + this.getScaledSize(2), n2 + this.getScaledSize(13), this.getScaledSize(n5), this.getScaledSize(1), n6);
                    GL11.glEnable(3553);
                    GL11.glEnable(2896);
                    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                }
            }
        }

        private int getScaledSize(int n) {
            return (int)((float)n * this.iconScale);
        }
    }
}

