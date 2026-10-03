/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.font;

import cpw.mods.fml.common.FMLLog;
import gloomyfolken.mods.core.client.gui.font.BitmapFontConfig;
import gloomyfolken.mods.core.client.gui.font.IFontRenderer;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.resources.ResourceManager;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;
import org.lwjgl.opengl.GL11;

public class ExternalFont
implements IFontRenderer {
    public static String alphabet = "";
    private static final ResourceLocation tahomaTTF = new ResourceLocation("gloomycore", "fonts/Tahoma.ttf");
    private static final ResourceLocation tahomaTTFBold = new ResourceLocation("gloomycore", "fonts/Tahoma Bold.ttf");
    private static final Color greyColor;
    public static final ExternalFont tahoma9;
    public static final ExternalFont tahoma10;
    public static final ExternalFont tahoma11;
    public static final ExternalFont tahoma12;
    public static final ExternalFont tahoma13;
    public static final ExternalFont tahoma14;
    public static final ExternalFont tahoma16;
    public static final ExternalFont tahoma18;
    public static final ExternalFont tahoma14Italic;
    public static final ExternalFont tahomaBold17;
    private BitmapFontConfig config;
    private float scaleFactor = 2.0f;
    private int defaultColor = 0xFFFFFF;

    public ExternalFont(ResourceLocation resourceLocation, float f, int n, String string) {
        try (InputStream inputStream = Minecraft._E()._S()._a(resourceLocation)._a();){
            this.config = BitmapFontConfig.generate(Font.createFont(0, inputStream), f, n, string);
        }
        catch (FontFormatException | IOException exception) {
            exception.printStackTrace();
        }
    }

    public ExternalFont(InputStream inputStream, float f, int n, String string) {
        try {
            this.config = BitmapFontConfig.generate(Font.createFont(0, inputStream), f, n, string);
        }
        catch (FontFormatException | IOException exception) {
            exception.printStackTrace();
        }
    }

    public ExternalFont(Font font, float f, int n, String string) {
        this.config = BitmapFontConfig.generate(font, f, n, string);
    }

    public ExternalFont(String string) {
        String string2 = "gloomycore";
        String string3 = "fonts/ttf/" + string;
        ResourceManager resourceManager = Minecraft._E()._S();
        try (InputStream inputStream = resourceManager._a(new ResourceLocation(string2, string3 + ".bfnt"))._a();){
            this.config = BitmapFontConfig.load(inputStream);
            inputStream.close();
        }
        catch (IOException iOException) {
            throw new RuntimeException("Unable to load font from " + string2 + ":" + string3);
        }
    }

    @Override
    public int getStringWidth(String string) {
        if (string == null) {
            return 0;
        }
        int n = 0;
        char[] cArray = string.toCharArray();
        for (int i = 0; i < cArray.length; ++i) {
            char c = cArray[i];
            if (c == '\u00a7' && i + 1 < cArray.length) {
                ++i;
                continue;
            }
            Integer n2 = (Integer)this.config.mappedIndices._b(c);
            n += n2 != null ? this.config.width[n2] : 0;
        }
        return (int)((float)n / this.scaleFactor);
    }

    @Override
    public int getFontHeight() {
        return Math.round((float)this.config.fontHeight / this.scaleFactor);
    }

    @Override
    public String trimToWidth(String string, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = 0;
        while (this.getStringWidth(stringBuilder.toString()) < n && n2 < string.length()) {
            stringBuilder.append(string.charAt(n2++));
        }
        return stringBuilder.toString();
    }

    @Override
    public List<String> wrapString(String string, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string2 : string.split(" ")) {
            int n2 = stringBuilder.lastIndexOf(System.lineSeparator());
            String string3 = n2 != -1 ? stringBuilder.substring(n2) + string2 : stringBuilder + string2;
            if (this.getStringWidth(string3) > n) {
                stringBuilder.append(System.lineSeparator()).append(this.getFormatFromString(string3)).append(string2);
                continue;
            }
            stringBuilder.append(" ").append(string2);
        }
        return Arrays.asList(stringBuilder.toString().trim().split(System.lineSeparator()));
    }

    @Override
    public int renderString(String string, int n, int n2) {
        return this.renderString(string, n, n2, this.defaultColor);
    }

    @Override
    public int renderString(String string, int n, int n2, int n3) {
        return this.renderString(string, n, n2, n3, false);
    }

    @Override
    public int renderString(String string, int n, int n2, int n3, boolean bl) {
        return this.drawString(string, (double)n, (double)n2, n3, bl);
    }

    @Override
    public int renderString(String string, int n, int n2, boolean bl) {
        return this.renderString(string, n, n2, this.defaultColor, bl);
    }

    @Override
    public int renderCenteredString(String string, int n, int n2) {
        return this.renderCenteredString(string, n, n2, this.defaultColor);
    }

    @Override
    public int renderCenteredString(String string, int n, int n2, int n3) {
        return this.renderCenteredString(string, n, n2, n3, false);
    }

    @Override
    public int renderCenteredString(String string, int n, int n2, int n3, boolean bl) {
        return this.renderString(string, n - this.getStringWidth(string) / 2, n2 - this.getFontHeight() / 2, n3, bl);
    }

    @Override
    public int renderCenteredString(String string, int n, int n2, boolean bl) {
        return this.renderCenteredString(string, n, n2, this.defaultColor, bl);
    }

    public int drawCenteredString(String string, double d, double d2, int n) {
        return this.drawString(string, d - (double)this.getStringWidth(string) / 2.0, d2, n, false);
    }

    public int drawCenteredString(String string, double d, double d2, int n, boolean bl) {
        return this.drawString(string, d - (double)this.getStringWidth(string) / 2.0, d2, n, bl);
    }

    public int drawString(String string, double d, double d2, int n, boolean bl) {
        if ((n & 0xFE000000) == 0) {
            n |= 0xFF000000;
        }
        if (bl) {
            this.drawString(string, d + 0.5, d2 + 0.5, (n >> 24 & 0xFF) << 24, 16);
        }
        return this.drawString(string, d, d2, n, 0);
    }

    public int drawString(String string, double d, double d2, int n, int n2) {
        if (string == null) {
            return 0;
        }
        double d3 = 1.0 / (double)this.scaleFactor;
        double d4 = d * (double)this.scaleFactor;
        double d5 = d2 * (double)this.scaleFactor;
        GL11.glScaled(d3, d3, d3);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glEnable(3553);
        GL11.glEnable(3042);
        GL11.glBindTexture(3553, this.config.textureId);
        float f = (float)(n >> 16 & 0xFF) / 255.0f;
        float f2 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(n & 0xFF) / 255.0f;
        float f4 = (float)(n >> 24 & 0xFF) / 255.0f;
        boolean bl = false;
        GL11.glColor4f(f, f2, f3, f4);
        for (int i = 0; i < string.length(); ++i) {
            int n3;
            char c = string.charAt(i);
            if (c == '\u00a7' && i + 1 < string.length()) {
                int n4 = "0123456789abcdefklmnor".indexOf(string.toLowerCase().charAt(i + 1));
                if (n4 < 16) {
                    if (n4 < 0 || n4 > 15) {
                        n4 = 15;
                    }
                    n3 = (int)IFontRenderer.Colors.COLOR_CODES[n4 += n2];
                    GL11.glColor4f((float)(n3 >> 16) / 255.0f, (float)(n3 >> 8 & 0xFF) / 255.0f, (float)(n3 & 0xFF) / 255.0f, f4);
                } else if (n4 == 21) {
                    GL11.glColor4f(f, f2, f3, f4);
                    bl = false;
                } else if (n4 == 18) {
                    bl = true;
                }
                ++i;
                continue;
            }
            Integer n5 = (Integer)this.config.mappedIndices._b(c);
            if (n5 == null) continue;
            this.drawChar(c, d4, d5);
            n3 = this.config.width[n5];
            if (bl) {
                this.drawRect(d4, d5 + (double)(this.config.fontHeight / 2), n3, this.config.fontHeight / 10);
            }
            d4 += (double)n3;
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(3042);
        GL11.glScaled(this.scaleFactor, this.scaleFactor, this.scaleFactor);
        return (int)Math.round(d4 / (double)this.scaleFactor);
    }

    private String getFormatFromString(String string) {
        String string2 = "";
        int n = -1;
        int n2 = string.length();
        while ((n = string.indexOf(167, n + 1)) != -1) {
            if (n >= n2 - 1) continue;
            char c = string.charAt(n + 1);
            if (c >= '0' && c <= '9' || c >= 'a' && c <= 'f' || c >= 'A' && c <= 'F') {
                string2 = "\u00a7" + c;
                continue;
            }
            if (!(c >= 'k' && c <= 'o' || c >= 'K' && c <= 'O' || c == 'r') && c != 'R') continue;
            string2 = string2 + "\u00a7" + c;
        }
        return string2;
    }

    private void drawChar(char c, double d, double d2) {
        Integer n = (Integer)this.config.mappedIndices._b(c);
        if (n == null) {
            return;
        }
        this.drawTexturedModalRect(d, d2, this.config.width[n], this.config.height[n] + this.config.maxDescent, this.config.left[n], this.config.top[n], this.config.bitmapSize, this.config.bitmapSize);
    }

    private void drawRect(double d, double d2, double d3, double d4) {
        Tessellator tessellator = Tessellator.instance;
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        tessellator.startDrawingQuads();
        tessellator.addVertex(d, d2 + d4, 0.0);
        tessellator.addVertex(d + d3, d2 + d4, 0.0);
        tessellator.addVertex(d + d3, d2, 0.0);
        tessellator.addVertex(d, d2, 0.0);
        tessellator.draw();
        GL11.glEnable(3553);
    }

    private void drawTexturedModalRect(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        double d9 = 1.0 / d7;
        double d10 = 1.0 / d8;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(d, d2 + d4, 0.0, (double)((float)d5) * d9, (double)((float)(d6 + d4)) * d10);
        tessellator.addVertexWithUV(d + d3, d2 + d4, 0.0, (double)((float)(d5 + d3)) * d9, (double)((float)(d6 + d4)) * d10);
        tessellator.addVertexWithUV(d + d3, d2, 0.0, (double)((float)(d5 + d3)) * d9, (double)((float)d6) * d10);
        tessellator.addVertexWithUV(d, d2, 0.0, (double)((float)d5) * d9, (double)((float)d6) * d10);
        tessellator.draw();
    }

    public ExternalFont setDefaultColor(Color color) {
        this.defaultColor = color.getRGB();
        return this;
    }

    static {
        ResourceLocation resourceLocation = new ResourceLocation("gloomycore", "fonts/dict.txt");
        try (InputStream inputStream = Minecraft._E()._S()._a(resourceLocation)._a();){
            alphabet = String.join((CharSequence)"", IOUtils.readLines(inputStream, Charsets.UTF_8));
        }
        catch (IOException iOException) {
            FMLLog.warning("Error while initializing font's alphabet, custom fonts most likely wont work", new Object[0]);
            iOException.printStackTrace();
        }
        greyColor = new Color(147, 147, 147, 255);
        tahoma9 = new ExternalFont("tahoma_9").setDefaultColor(greyColor);
        tahoma10 = new ExternalFont("tahoma_10").setDefaultColor(greyColor);
        tahoma11 = new ExternalFont("tahoma_11").setDefaultColor(greyColor);
        tahoma12 = new ExternalFont("tahoma_12").setDefaultColor(greyColor);
        tahoma13 = new ExternalFont("tahoma_13").setDefaultColor(greyColor);
        tahoma14 = new ExternalFont("tahoma_14").setDefaultColor(greyColor);
        tahoma16 = new ExternalFont("tahoma_16").setDefaultColor(greyColor);
        tahoma18 = new ExternalFont("tahoma_18").setDefaultColor(greyColor);
        tahoma14Italic = new ExternalFont("tahoma_14_italic").setDefaultColor(greyColor);
        tahomaBold17 = new ExternalFont("tahoma_17_bold").setDefaultColor(greyColor);
    }
}

