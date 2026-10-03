/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.demos.opengl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.color.ColorSpace;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.Hashtable;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class FontRender {
    private static ColorModel glColorModel = new ComponentColorModel(ColorSpace.getInstance(1000), new int[]{8, 8, 8, 0}, false, false, 1, 0);
    private static ColorModel glColorModelAlpha = new ComponentColorModel(ColorSpace.getInstance(1000), new int[]{8, 8, 8, 8}, true, false, 1, 0);

    private FontRender() {
    }

    private static String getFontFileName(String family, int size, boolean bold) {
        return family.replace(' ', '_') + "_" + size + (bold ? "_bold" : "") + ".fnt";
    }

    public static GLFont createFont(String family, int size, boolean bold, boolean antialiasing) throws IOException {
        GLFont gf = new GLFont();
        BufferedImage img = FontRender.renderFont(new Font(family, bold ? 1 : 0, size), antialiasing, gf.glyphs);
        gf.texture = FontRender.createTexture(img, false);
        gf.width = img.getWidth();
        gf.height = img.getHeight();
        return gf;
    }

    public static BufferedImage renderFont(Font font, boolean antialiasing, Glyph[] glyphs) {
        FontRenderContext frc = new FontRenderContext(null, antialiasing, false);
        int imgw = 256;
        if (font.getSize() >= 36) {
            imgw <<= 1;
        }
        if (font.getSize() >= 72) {
            imgw <<= 1;
        }
        BufferedImage img = FontRender.createImage(imgw, 1024, true);
        Graphics2D g = (Graphics2D)img.getGraphics();
        if (antialiasing) {
            g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        }
        g.setColor(Color.WHITE);
        g.setFont(font);
        int x = 0;
        int y = 0;
        int rowsize = 0;
        for (int c = 32; c < 128; ++c) {
            String s = "" + (char)c;
            Rectangle2D rect = font.getStringBounds(s, frc);
            LineMetrics lm = font.getLineMetrics(s, frc);
            int w = (int)rect.getWidth() + 1;
            int h = (int)rect.getHeight() + 2;
            if (x + w + 2 > img.getWidth()) {
                x = 0;
                y += rowsize;
                rowsize = 0;
            }
            g.drawString(s, x + 1, y + (int)lm.getAscent() + 1);
            if (glyphs != null) {
                glyphs[c - 32].x = x + 1;
                glyphs[c - 32].y = y + 1;
                glyphs[c - 32].w = w;
                glyphs[c - 32].h = h;
            }
            x += (w += 2);
            rowsize = Math.max(rowsize, h += 2);
        }
        g.dispose();
        if ((y += rowsize) < 128) {
            img = img.getSubimage(0, 0, img.getWidth(), 128);
        } else if (y < 256) {
            img = img.getSubimage(0, 0, img.getWidth(), 256);
        } else if (y < 512) {
            img = img.getSubimage(0, 0, img.getWidth(), 512);
        }
        return img;
    }

    private static void renderGlyph(GLFont font, Glyph g) {
        if (g.list != -1) {
            GL11.glCallList(g.list);
            return;
        }
        g.list = GL11.glGenLists(1);
        GL11.glNewList(g.list, 4864);
        float tw = font.width;
        float th = font.height;
        int x = 0;
        int y = 0;
        GL11.glBegin(7);
        GL11.glTexCoord2f((float)g.x / tw, (float)g.y / th);
        GL11.glVertex3f(x, y, 1.0f);
        GL11.glTexCoord2f((float)(g.x + g.w - 1) / tw, (float)g.y / th);
        GL11.glVertex3f(x + g.w - 1, y, 1.0f);
        GL11.glTexCoord2f((float)(g.x + g.w - 1) / tw, (float)(g.y + g.h - 1) / th);
        GL11.glVertex3f(x + g.w - 1, y + g.h - 1, 1.0f);
        GL11.glTexCoord2f((float)g.x / tw, (float)(g.y + g.h - 1) / th);
        GL11.glVertex3f(x, y + g.h - 1, 1.0f);
        GL11.glEnd();
        GL11.glEndList();
        GL11.glCallList(g.list);
    }

    public static void drawString(GLFont font, CharSequence s, int x, int y, float red, float green, float blue) {
        FontRender.drawString(font, s, x, y, red, green, blue, 1.0f);
    }

    public static void drawString(GLFont font, CharSequence s, int x, int y, float red, float green, float blue, float alpha) {
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glPushMatrix();
        GL11.glTranslatef(x, y, 0.0f);
        GL11.glBindTexture(3553, font.texture);
        GL11.glEnable(3553);
        GL11.glColor4f(red, green, blue, alpha);
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int c = s.charAt(i);
            if (c < 32 || c > 128) {
                c = 63;
            }
            Glyph g = font.glyphs[c - 32];
            FontRender.renderGlyph(font, g);
            GL11.glTranslatef(g.w - 2, 0.0f, 0.0f);
        }
        GL11.glDisable(3553);
        GL11.glPopMatrix();
        GL11.glDisable(3042);
    }

    private static int createTexture(BufferedImage img, boolean mipMap) {
        boolean USE_COMPRESSION = false;
        int[] id = new int[1];
        GL11.glGenTextures(IntBuffer.wrap(id));
        int tex = id[0];
        GL11.glBindTexture(3553, tex);
        GL11.glTexParameteri(3553, 10241, mipMap ? 9987 : 9729);
        GL11.glTexParameteri(3553, 10240, 9729);
        byte[] data2 = ((DataBufferByte)img.getRaster().getDataBuffer()).getData();
        ByteBuffer buf = ByteBuffer.allocateDirect(data2.length);
        buf.order(ByteOrder.nativeOrder());
        buf.put(data2, 0, data2.length);
        buf.flip();
        boolean alpha = img.getColorModel().hasAlpha();
        GL11.glTexImage2D(3553, 0, USE_COMPRESSION ? (alpha ? 34030 : 34029) : (alpha ? 6408 : 6407), img.getWidth(), img.getHeight(), 0, alpha ? 6408 : 6407, 5121, buf);
        if (mipMap) {
            GLU.gluBuild2DMipmaps(3553, USE_COMPRESSION ? (alpha ? 34030 : 34029) : (alpha ? 6408 : 6407), img.getWidth(), img.getHeight(), alpha ? 6408 : 6407, 5121, buf);
        }
        return tex;
    }

    private static BufferedImage createImage(int width, int height, boolean alpha) {
        if (alpha) {
            WritableRaster raster = Raster.createInterleavedRaster(0, width, height, 4, null);
            return new BufferedImage(glColorModelAlpha, raster, false, new Hashtable());
        }
        WritableRaster raster = Raster.createInterleavedRaster(0, width, height, 3, null);
        return new BufferedImage(glColorModel, raster, false, new Hashtable());
    }

    public static class GLFont {
        protected int texture;
        protected int width;
        protected int height;
        protected Glyph[] glyphs = new Glyph[96];

        public GLFont() {
            for (int i = 0; i < this.glyphs.length; ++i) {
                this.glyphs[i] = new Glyph();
            }
        }

        public GLFont(InputStream in) throws IOException {
            this();
            this.load(in);
        }

        public void destroy() {
            GL11.glDeleteTextures(IntBuffer.wrap(new int[]{this.texture}));
        }

        protected void save(File f) throws IOException {
            DataOutputStream out = new DataOutputStream(new FileOutputStream(f));
            out.writeInt(this.width);
            out.writeInt(this.height);
            GL11.glPixelStorei(3330, 0);
            GL11.glPixelStorei(3333, 1);
            GL11.glPixelStorei(3331, 0);
            GL11.glPixelStorei(3332, 0);
            int size = this.width * this.height * 4;
            ByteBuffer buf = BufferUtils.createByteBuffer(size);
            byte[] data2 = new byte[size];
            GL11.glBindTexture(3553, this.texture);
            GL11.glGetTexImage(3553, 0, 6408, 5121, (ByteBuffer)buf.position(0));
            buf.get(data2);
            out.write(data2);
            for (int i = 0; i < this.glyphs.length; ++i) {
                out.writeShort(this.glyphs[i].x);
                out.writeShort(this.glyphs[i].y);
                out.writeShort(this.glyphs[i].w);
                out.writeShort(this.glyphs[i].h);
            }
            out.close();
        }

        protected void load(File f) throws IOException {
            this.load(new FileInputStream(f));
        }

        protected void load(InputStream _in) throws IOException {
            DataInputStream in = new DataInputStream(_in);
            int w = in.readInt();
            int h = in.readInt();
            int size = w * h * 4;
            GL11.glPixelStorei(3314, 0);
            GL11.glPixelStorei(3317, 1);
            GL11.glPixelStorei(3315, 0);
            GL11.glPixelStorei(3316, 0);
            ByteBuffer buf = BufferUtils.createByteBuffer(size);
            byte[] data2 = new byte[size];
            in.read(data2);
            buf.put(data2);
            int[] id = new int[1];
            IntBuffer intBuf = BufferUtils.createIntBuffer(1);
            intBuf.put(id);
            intBuf.flip();
            GL11.glGenTextures(intBuf);
            this.texture = id[0];
            this.width = w;
            this.height = h;
            GL11.glBindTexture(3553, this.texture);
            GL11.glTexParameteri(3553, 10241, 9729);
            GL11.glTexParameteri(3553, 10240, 9729);
            GL11.glTexImage2D(3553, 0, 6408, w, h, 0, 6408, 5121, (ByteBuffer)buf.position(0));
            for (int i = 0; i < this.glyphs.length; ++i) {
                this.glyphs[i].x = in.readShort();
                this.glyphs[i].y = in.readShort();
                this.glyphs[i].w = in.readShort();
                this.glyphs[i].h = in.readShort();
            }
            in.close();
        }
    }

    protected static class Glyph {
        int x;
        int y;
        int w;
        int h;
        int list = -1;

        protected Glyph() {
        }
    }
}

