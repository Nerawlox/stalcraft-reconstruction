/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core.gui;

import codechicken.lib.math.MathHelper;
import java.awt.Dimension;
import java.awt.Point;
import java.util.Arrays;
import java.util.List;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class GuiDraw {
    public static final GuiHook gui = new GuiHook();
    public static qncw fontRenderer = xpzm._E()._z;
    public static apbu renderEngine = xpzm._E()._h;

    public static void drawRect(int n, int n2, int n3, int n4, int n5) {
        GuiDraw.drawGradientRect(n, n2, n3, n4, n5, n5);
    }

    public static void drawGradientRect(int n, int n2, int n3, int n4, int n5, int n6) {
        gui.func_73733_a(n, n2, n + n3, n2 + n4, n5, n6);
    }

    public static void drawTexturedModalRect(int n, int n2, int n3, int n4, int n5, int n6) {
        gui.func_73729_b(n, n2, n3, n4, n5, n6);
    }

    public static void drawString(String string, int n, int n2, int n3, boolean bl) {
        if (bl) {
            fontRenderer._a(string, n, n2, n3);
        } else {
            fontRenderer._b(string, n, n2, n3);
        }
    }

    public static void drawString(String string, int n, int n2, int n3) {
        GuiDraw.drawString(string, n, n2, n3, true);
    }

    public static void drawStringC(String string, int n, int n2, int n3, int n4, int n5, boolean bl) {
        GuiDraw.drawString(string, n + (n3 - GuiDraw.getStringWidth(string)) / 2, n2 + (n4 - 8) / 2, n5, bl);
    }

    public static void drawStringC(String string, int n, int n2, int n3, int n4, int n5) {
        GuiDraw.drawStringC(string, n, n2, n3, n4, n5, true);
    }

    public static void drawStringC(String string, int n, int n2, int n3, boolean bl) {
        GuiDraw.drawString(string, n - GuiDraw.getStringWidth(string) / 2, n2, n3, bl);
    }

    public static void drawStringC(String string, int n, int n2, int n3) {
        GuiDraw.drawStringC(string, n, n2, n3, true);
    }

    public static void drawStringR(String string, int n, int n2, int n3, boolean bl) {
        GuiDraw.drawString(string, n - GuiDraw.getStringWidth(string), n2, n3, bl);
    }

    public static void drawStringR(String string, int n, int n2, int n3) {
        GuiDraw.drawStringR(string, n, n2, n3, true);
    }

    public static int getStringWidth(String string) {
        if (string == null || string.equals("")) {
            return 0;
        }
        return GuiDraw.getStringWidthNoColours(fontRenderer, string);
    }

    public static int getStringWidthNoColours(qncw qncw2, String string) {
        int n;
        while ((n = string.indexOf(167)) != -1) {
            string = string.substring(0, n) + string.substring(n + 2);
        }
        return qncw2._b(string);
    }

    public static Dimension displaySize() {
        xpzm xpzm2 = xpzm._E();
        htou htou2 = new htou(xpzm2._M, xpzm2._n, xpzm2._o);
        return new Dimension(htou2._a(), htou2._b());
    }

    public static Dimension displayRes() {
        xpzm xpzm2 = xpzm._E();
        return new Dimension(xpzm2._n, xpzm2._o);
    }

    public static Point getMousePosition() {
        Dimension dimension = GuiDraw.displaySize();
        Dimension dimension2 = GuiDraw.displayRes();
        return new Point(Mouse.getX() * dimension.width / dimension2.width, dimension.height - Mouse.getY() * dimension.height / dimension2.height - 1);
    }

    public static void changeTexture(String string) {
        GuiDraw.changeTexture(new ResourceLocation(string));
    }

    public static void changeTexture(ResourceLocation resourceLocation) {
        xpzm._E()._h._a(resourceLocation);
    }

    public static void drawTip(int n, int n2, String string) {
        GuiDraw.drawMultilineTip(n, n2, Arrays.asList(string));
    }

    public static void drawMultilineTip(int n, int n2, List<String> list) {
        if (list.isEmpty()) {
            return;
        }
        GL11.glDisable(32826);
        qnon._a();
        GL11.glDisable(2896);
        GL11.glDisable(2929);
        int n3 = 0;
        for (String string : list) {
            int n4 = GuiDraw.getStringWidthNoColours(fontRenderer, string);
            if (n4 <= n3) continue;
            n3 = n4;
        }
        int n5 = -2;
        for (int i = 0; i < list.size(); ++i) {
            n5 += list.get(i).endsWith("\u00a7h") && i + 1 < list.size() ? 12 : 10;
        }
        if (n < 8) {
            n = 8;
        } else if (n > GuiDraw.displaySize().width - n3 - 8) {
            n -= 24 + n3;
        }
        n2 = (int)MathHelper.clip(n2, 8.0, GuiDraw.displaySize().height - 8 - n5);
        gui.incZLevel(300.0f);
        GuiDraw.drawTooltipBox(n - 4, n2 - 4, n3 + 7, n5 + 7);
        for (String string : list) {
            fontRenderer._a(string, n, n2, -1);
            if (string.endsWith("\u00a7h")) {
                n2 += 2;
            }
            n2 += 10;
        }
        gui.incZLevel(-300.0f);
    }

    public static void drawTooltipBox(int n, int n2, int n3, int n4) {
        int n5 = -267386864;
        GuiDraw.drawGradientRect(n + 1, n2, n3 - 1, 1, n5, n5);
        GuiDraw.drawGradientRect(n + 1, n2 + n4, n3 - 1, 1, n5, n5);
        GuiDraw.drawGradientRect(n + 1, n2 + 1, n3 - 1, n4 - 1, n5, n5);
        GuiDraw.drawGradientRect(n, n2 + 1, 1, n4 - 1, n5, n5);
        GuiDraw.drawGradientRect(n + n3, n2 + 1, 1, n4 - 1, n5, n5);
        int n6 = 0x505000FF;
        int n7 = 1344798847;
        GuiDraw.drawGradientRect(n + 1, n2 + 2, 1, n4 - 3, n6, n7);
        GuiDraw.drawGradientRect(n + n3 - 1, n2 + 2, 1, n4 - 3, n6, n7);
        GuiDraw.drawGradientRect(n + 1, n2 + 1, n3 - 1, 1, n6, n6);
        GuiDraw.drawGradientRect(n + 1, n2 + n4 - 1, n3 - 1, 1, n7, n7);
    }

    public static class GuiHook
    extends bawa {
        public void setZLevel(float f) {
            this.field_73735_i = f;
        }

        public float getZLevel() {
            return this.field_73735_i;
        }

        public void incZLevel(float f) {
            this.field_73735_i += f;
        }

        @Override
        public void func_73733_a(int n, int n2, int n3, int n4, int n5, int n6) {
            super.func_73733_a(n, n2, n3, n4, n5, n6);
        }
    }
}

