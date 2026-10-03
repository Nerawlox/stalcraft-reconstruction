/*
 * Decompiled with CFR 0.152.
 */
package gr.zdimensions.jsquish.test;

import gr.zdimensions.jsquish.Squish;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;

final class TextureDXT {
    private static final IntBuffer GEN_BUFFER = BufferUtils.createIntBuffer(1);
    private final int width;
    private final int height;
    private final int uncompressed;
    private final int compressedDriver;
    private final int compressedRangeFit;
    private final int compressedClusterFit;
    private final int channels;

    TextureDXT(BufferedImage image) {
        if (image == null) {
            throw new IllegalArgumentException("Invalid image specified.");
        }
        this.width = image.getWidth();
        this.height = image.getHeight();
        this.channels = image.getRaster().getNumBands() <= 3 ? 3 : 4;
        byte[] bytes = TextureDXT.getImageData(image);
        System.out.println("Creating Uncompressed...");
        this.uncompressed = TextureDXT.createUncompressed(this.width, this.height, bytes);
        System.out.println("Creating Compressed - DRIVER...");
        this.compressedDriver = TextureDXT.createCompressedDriver(this.channels, this.width, this.height, bytes);
        System.out.println("Creating Compressed - SQUISH - RANGE FIT...");
        this.compressedRangeFit = TextureDXT.createCompressedSquish(this.channels, this.width, this.height, bytes, Squish.CompressionMethod.RANGE_FIT);
        System.out.println("Creating Compressed - SQUISH - CLUSTER FIT...");
        this.compressedClusterFit = TextureDXT.createCompressedSquish(this.channels, this.width, this.height, bytes, Squish.CompressionMethod.CLUSTER_FIT);
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getUncompressed() {
        return this.uncompressed;
    }

    public int getCompressedDriver() {
        return this.compressedDriver;
    }

    public int getCompressedRangeFit() {
        return this.compressedRangeFit;
    }

    public int getCompressedClusterFit() {
        return this.compressedClusterFit;
    }

    private static byte[] getImageData(BufferedImage image) {
        int type2 = image.getType();
        if (type2 != 5 && type2 != 6) {
            BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getRaster().getNumBands() <= 3 ? 5 : 6);
            Graphics2D g2 = newImage.createGraphics();
            g2.drawImage(image, null, 0, 0);
            image = newImage;
        }
        WritableRaster raster = image.getRaster();
        byte[] data2 = ((DataBufferByte)raster.getDataBuffer()).getData();
        if (raster.getNumBands() == 3) {
            byte[] bytes = new byte[image.getWidth() * image.getHeight() * 4];
            int i = 0;
            int j = 0;
            while (i < data2.length) {
                byte b = data2[i++];
                byte g = data2[i++];
                byte r = data2[i++];
                bytes[j++] = r;
                bytes[j++] = g;
                bytes[j++] = b;
                bytes[j++] = -1;
            }
            data2 = bytes;
        } else {
            int i = 0;
            while (i < data2.length) {
                byte r;
                byte a = data2[i + 0];
                byte b = data2[i + 1];
                byte g = data2[i + 2];
                data2[i + 0] = r = data2[i + 3];
                data2[i + 1] = g;
                data2[i + 2] = b;
                data2[i + 3] = a;
                i += 4;
            }
        }
        return data2;
    }

    private static int createTexture() {
        GL11.glGenTextures(GEN_BUFFER);
        int texID = GEN_BUFFER.get(0);
        GL11.glBindTexture(3553, texID);
        GL11.glTexParameteri(3553, 10241, 9729);
        GL11.glTexParameteri(3553, 10240, 9729);
        GL11.glTexParameteri(3553, 10242, 33071);
        GL11.glTexParameteri(3553, 10243, 33071);
        return texID;
    }

    private static int createUncompressed(int width, int height, byte[] bytes) {
        int texID = TextureDXT.createTexture();
        ByteBuffer buffer = BufferUtils.createByteBuffer(bytes.length);
        buffer.put(bytes).flip();
        GL11.glTexImage2D(3553, 0, 6408, width, height, 0, 6408, 5121, buffer);
        return texID;
    }

    private static int createCompressedDriver(int channels, int width, int height, byte[] bytes) {
        ByteBuffer buffer;
        int format;
        int internalFormat;
        int texID = TextureDXT.createTexture();
        if (channels == 3) {
            internalFormat = 33776;
            format = 6407;
            buffer = BufferUtils.createByteBuffer(bytes.length / 4 * 3);
            int i = 0;
            int j = 0;
            while (i < bytes.length) {
                buffer.put(j++, bytes[i++]);
                buffer.put(j++, bytes[i++]);
                buffer.put(j++, bytes[i++]);
                ++i;
            }
        } else {
            internalFormat = 33779;
            format = 6408;
            buffer = BufferUtils.createByteBuffer(bytes.length);
            buffer.put(bytes).flip();
        }
        GL11.glTexImage2D(3553, 0, internalFormat, width, height, 0, format, 5121, buffer);
        return texID;
    }

    private static int createCompressedSquish(int channels, int width, int height, byte[] bytes, Squish.CompressionMethod method) {
        int internalFormat;
        Squish.CompressionType type2;
        if (channels == 3) {
            type2 = Squish.CompressionType.DXT1;
            internalFormat = 33776;
        } else {
            type2 = Squish.CompressionType.DXT5;
            internalFormat = 33779;
        }
        byte[] blocks = Squish.compressImage(bytes, width, height, null, type2, method);
        int texID = TextureDXT.createTexture();
        ByteBuffer buffer = BufferUtils.createByteBuffer(blocks.length);
        buffer.put(blocks).flip();
        GL13.glCompressedTexImage2D((int)3553, (int)0, (int)internalFormat, (int)width, (int)height, (int)0, (int)blocks.length, (ByteBuffer)buffer);
        return texID;
    }

    public void release() {
        GEN_BUFFER.put(0, this.uncompressed);
        GL11.glDeleteTextures(GEN_BUFFER);
        GEN_BUFFER.put(0, this.compressedDriver);
        GL11.glDeleteTextures(GEN_BUFFER);
        GEN_BUFFER.put(0, this.compressedRangeFit);
        GL11.glDeleteTextures(GEN_BUFFER);
        GEN_BUFFER.put(0, this.compressedClusterFit);
        GL11.glDeleteTextures(GEN_BUFFER);
    }
}

