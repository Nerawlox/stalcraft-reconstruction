/*
 * Decompiled with CFR 0.152.
 */
package me.nallar.jdds;

import gr.zdimensions.jsquish.Squish;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.nio.ByteBuffer;
import javax.activation.UnsupportedDataTypeException;
import me.nallar.jdds.internal.compression.DXTBufferCompressor;
import me.nallar.jdds.internal.compression.DXTBufferDecompressor;
import me.nallar.jdds.internal.ddsutil.ByteBufferedImage;
import me.nallar.jdds.internal.ddsutil.PixelFormats;
import me.nallar.jdds.internal.ddsutil.TextureFactory;
import me.nallar.jdds.internal.jogl.DDSImage;
import me.nallar.jdds.internal.jogl.TEXImage;
import me.nallar.jdds.internal.model.TextureMap;

public class JDDS {
    public static BufferedImage read(File file) throws IOException {
        if (file.getName().endsWith(".dds")) {
            return JDDS.loadBufferedImage(DDSImage.read(file));
        }
        return JDDS.loadBufferedImage(TEXImage.read(file));
    }

    public static BufferedImage readDDS(byte[] data2) {
        return JDDS.readDDS(ByteBuffer.wrap(data2));
    }

    public static BufferedImage readDDS(ByteBuffer data2) {
        try {
            return JDDS.loadBufferedImage(DDSImage.read(data2));
        }
        catch (IOException e) {
            throw new IOError(e);
        }
    }

    public static BufferedImage loadBufferedImage(DDSImage image) throws UnsupportedDataTypeException {
        if (image.isCompressed()) {
            return JDDS.decompressTexture(image.getMipMap(0).getData(), image.getWidth(), image.getHeight(), JDDS.findCompressionFormat(image));
        }
        return JDDS.loadBufferedImageFromByteBuffer(image.getMipMap(0).getData(), image.getWidth(), image.getHeight(), image);
    }

    public static BufferedImage loadBufferedImageFromByteBuffer(ByteBuffer data2, int width, int height, DDSImage ddsimage) {
        if (ddsimage.getPixelFormat() == 21) {
            return new ByteBufferedImage(width, height, data2);
        }
        throw new UnsupportedOperationException("Unknown pixel format: " + ddsimage.getPixelFormat());
    }

    public static BufferedImage loadBufferedImage(TEXImage image) throws UnsupportedDataTypeException {
        return JDDS.decompressTexture(image.getEmbeddedMaps(0).getMipMap(0).getData(), image.getWidth(), image.getHeight(), JDDS.findCompressionFormat(image.getEmbeddedMaps(0)));
    }

    public static BufferedImage decompressTexture(byte[] compressedData, int width, int height, Squish.CompressionType compressionType) {
        return new DXTBufferDecompressor(compressedData, width, height, compressionType).getImage();
    }

    public static BufferedImage decompressTexture(ByteBuffer textureBuffer, int width, int height, Squish.CompressionType compressionType) {
        return new DXTBufferDecompressor(textureBuffer, width, height, compressionType).getImage();
    }

    public static BufferedImage decompressTexture(ByteBuffer textureBuffer, int width, int height, int pixelformat) throws UnsupportedDataTypeException {
        Squish.CompressionType compressionType = PixelFormats.getSquishCompressionFormat(pixelformat);
        return new DXTBufferDecompressor(textureBuffer, width, height, compressionType).getImage();
    }

    public static ByteBuffer compressTexture(BufferedImage image, Squish.CompressionType compressionType) {
        return new DXTBufferCompressor(image, compressionType).getByteBuffer();
    }

    public static byte[] compressTextureToArray(BufferedImage image, Squish.CompressionType compressionType) {
        return new DXTBufferCompressor(image, compressionType).getArray();
    }

    public static void write(File destinationfile, BufferedImage sourceImage, int pixelformat, boolean generateMipMaps) throws IOException {
        int width = sourceImage.getWidth();
        int height = sourceImage.getHeight();
        if (!sourceImage.getColorModel().hasAlpha()) {
            sourceImage = JDDS.convert(sourceImage, 6);
        }
        TextureMap maps = TextureFactory.createTextureMap(generateMipMaps, sourceImage);
        ByteBuffer[] mipmapBuffer = PixelFormats.isDXTCompressed(pixelformat) ? maps.getDXTCompressedBuffer(pixelformat) : maps.getUncompressedBuffer();
        JDDS.writeDDSImage(destinationfile, mipmapBuffer, width, height, pixelformat);
    }

    public static BufferedImage convert(BufferedImage srcImage, int destImgType) {
        BufferedImage img = new BufferedImage(srcImage.getWidth(), srcImage.getHeight(), destImgType);
        Graphics2D g2d = img.createGraphics();
        g2d.drawImage((Image)srcImage, 0, 0, null);
        g2d.dispose();
        return img;
    }

    public void write(File file, TextureMap map2, int pixelformat) throws IOException {
        JDDS.writeDDSImage(file, map2.getDXTCompressedBuffer(pixelformat), map2.getWidth(), map2.getHeight(), pixelformat);
    }

    private static DDSImage writeDDSImage(File file, ByteBuffer[] mipmapBuffer, int width, int height, int pixelformat) throws IllegalArgumentException, IOException {
        DDSImage writedds = DDSImage.createFromData(pixelformat, width, height, mipmapBuffer);
        writedds.write(file);
        return writedds;
    }

    public static int getCompressionType(File file) throws IOException {
        return DDSImage.read(file).getPixelFormat();
    }

    private static Squish.CompressionType findCompressionFormat(DDSImage ddsimage) throws UnsupportedDataTypeException {
        int pixelFormat = ddsimage.getPixelFormat();
        return PixelFormats.getSquishCompressionFormat(pixelFormat);
    }

    public static boolean isReadSupported(File file) {
        String fileSuffix = JDDS.getFileSuffix(file.getName());
        return fileSuffix.endsWith("dds") || fileSuffix.endsWith("tex");
    }

    private static String getFileSuffix(String filename) {
        int lastDot = filename.lastIndexOf(46);
        if (lastDot < 0) {
            return "";
        }
        return filename.substring(lastDot + 1).toLowerCase();
    }
}

