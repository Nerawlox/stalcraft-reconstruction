/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.font;

import cpw.mods.fml.common.FMLLog;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import net.minecraft.util.amxi;

public class BitmapFontConfig {
    public int textureId;
    public amxi mappedIndices = new amxi();
    public int style;
    public int maxAscent;
    public int maxDescent;
    public int fontHeight;
    public char[] chars;
    public int[] left;
    public int[] top;
    public int[] width;
    public int[] height;
    public int bitmapSize;

    public static BitmapFontConfig generate(Font font, float f, int n, String string) {
        BitmapFontConfig bitmapFontConfig = new BitmapFontConfig();
        BufferedImage bufferedImage = BitmapFontConfig.generateIn(bitmapFontConfig, font, f, n, string);
        bitmapFontConfig.textureId = bsfn._a();
        bsfn._a(bitmapFontConfig.textureId, bufferedImage, false, false);
        return bitmapFontConfig;
    }

    public static void export(Font font, float f, int n, String string, File file, String string2) throws IOException {
        BitmapFontConfig bitmapFontConfig = new BitmapFontConfig();
        BufferedImage bufferedImage = BitmapFontConfig.generateIn(bitmapFontConfig, font, f, n, string);
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, string2 + ".bfnt")));){
            dataOutputStream.writeInt(bitmapFontConfig.style);
            dataOutputStream.writeInt(bitmapFontConfig.maxAscent);
            dataOutputStream.writeInt(bitmapFontConfig.maxDescent);
            dataOutputStream.writeInt(bitmapFontConfig.fontHeight);
            dataOutputStream.writeInt(bitmapFontConfig.bitmapSize);
            dataOutputStream.writeInt(bitmapFontConfig.chars.length);
            for (int i = 0; i < bitmapFontConfig.chars.length; ++i) {
                dataOutputStream.writeChar(bitmapFontConfig.chars[i]);
                dataOutputStream.writeInt(bitmapFontConfig.left[i]);
                dataOutputStream.writeInt(bitmapFontConfig.top[i]);
                dataOutputStream.writeInt(bitmapFontConfig.width[i]);
                dataOutputStream.writeInt(bitmapFontConfig.height[i]);
            }
            ImageIO.write((RenderedImage)bufferedImage, "png", dataOutputStream);
        }
    }

    public static BitmapFontConfig load(InputStream inputStream) throws IOException {
        BitmapFontConfig bitmapFontConfig = new BitmapFontConfig();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        bitmapFontConfig.style = dataInputStream.readInt();
        bitmapFontConfig.maxAscent = dataInputStream.readInt();
        bitmapFontConfig.maxDescent = dataInputStream.readInt();
        bitmapFontConfig.fontHeight = dataInputStream.readInt();
        bitmapFontConfig.bitmapSize = dataInputStream.readInt();
        int n = dataInputStream.readInt();
        bitmapFontConfig.chars = new char[n];
        bitmapFontConfig.left = new int[n];
        bitmapFontConfig.top = new int[n];
        bitmapFontConfig.width = new int[n];
        bitmapFontConfig.height = new int[n];
        for (int i = 0; i < n; ++i) {
            bitmapFontConfig.chars[i] = dataInputStream.readChar();
            bitmapFontConfig.left[i] = dataInputStream.readInt();
            bitmapFontConfig.top[i] = dataInputStream.readInt();
            bitmapFontConfig.width[i] = dataInputStream.readInt();
            bitmapFontConfig.height[i] = dataInputStream.readInt();
            bitmapFontConfig.mappedIndices._a(bitmapFontConfig.chars[i], i);
        }
        BufferedImage bufferedImage = ImageIO.read(dataInputStream);
        FMLLog.info("Successfully loaded ttf font config with %d chars", n);
        bitmapFontConfig.textureId = bsfn._a();
        bsfn._a(bitmapFontConfig.textureId, bufferedImage, false, false);
        return bitmapFontConfig;
    }

    private static BufferedImage generateIn(BitmapFontConfig bitmapFontConfig, Font font, float f, int n, String string) {
        int n2;
        f = f * 4.0f / 3.0f;
        font = font.deriveFont(n, f);
        bitmapFontConfig.chars = string.toCharArray();
        bitmapFontConfig.style = n;
        bitmapFontConfig.left = new int[bitmapFontConfig.chars.length];
        bitmapFontConfig.top = new int[bitmapFontConfig.chars.length];
        bitmapFontConfig.width = new int[bitmapFontConfig.chars.length];
        bitmapFontConfig.height = new int[bitmapFontConfig.chars.length];
        bitmapFontConfig.bitmapSize = 512;
        BufferedImage bufferedImage = new BufferedImage(bitmapFontConfig.bitmapSize, bitmapFontConfig.bitmapSize, 2);
        Graphics2D graphics2D = (Graphics2D)bufferedImage.getGraphics();
        graphics2D.setFont(font);
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics2D.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        graphics2D.setColor(new Color(255, 255, 255, 0));
        graphics2D.fillRect(0, 0, bitmapFontConfig.bitmapSize, bitmapFontConfig.bitmapSize);
        graphics2D.setColor(Color.white);
        FontMetrics fontMetrics = graphics2D.getFontMetrics();
        int n3 = n2 = 2;
        int n4 = n2;
        for (int i = 0; i < bitmapFontConfig.chars.length; ++i) {
            char c = bitmapFontConfig.chars[i];
            bitmapFontConfig.mappedIndices._a(c, i);
            Rectangle2D rectangle2D = fontMetrics.getStringBounds(String.valueOf(c), null);
            bitmapFontConfig.left[i] = n3;
            bitmapFontConfig.top[i] = n4 + n2;
            int n5 = (int)rectangle2D.getWidth();
            if (bitmapFontConfig.style == 2) {
                n5 = (int)((double)n5 * 1.25);
            }
            bitmapFontConfig.width[i] = n5;
            bitmapFontConfig.height[i] = (int)rectangle2D.getHeight();
            graphics2D.drawString(String.valueOf(c), (float)n3, (float)(n4 + fontMetrics.getAscent()) + f / 10.0f);
            if (bitmapFontConfig.style == 2) {
                n5 = (int)((double)n5 * 1.1);
            }
            if ((n3 += n5 + n2) < bitmapFontConfig.bitmapSize - 10 - fontMetrics.getMaxAdvance()) continue;
            n3 = n2;
            n4 = (int)((float)n4 + ((float)(fontMetrics.getMaxAscent() + fontMetrics.getMaxDescent()) + f));
        }
        bitmapFontConfig.fontHeight = fontMetrics.getHeight();
        bitmapFontConfig.maxAscent = fontMetrics.getMaxAscent();
        bitmapFontConfig.maxDescent = fontMetrics.getMaxDescent();
        return bufferedImage;
    }
}

