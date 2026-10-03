/*
 * Decompiled with CFR 0.152.
 */
package me.nallar.jdds.internal.compression;

import gr.zdimensions.jsquish.Squish;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;
import java.util.zip.DataFormatException;
import me.nallar.jdds.internal.ddsutil.ByteBufferedImage;

public class DXTBufferCompressor {
    protected byte[] byteData;
    protected final Dimension dimension;
    protected final Squish.CompressionType compressionType;

    public DXTBufferCompressor(BufferedImage image, Squish.CompressionType compressionType) {
        this(ByteBufferedImage.convertBIintoARGBArray(image), new Dimension(image.getWidth(null), image.getHeight(null)), compressionType);
    }

    public DXTBufferCompressor(byte[] data2, Dimension dimension, Squish.CompressionType compressionType) {
        this.byteData = data2;
        this.dimension = dimension;
        this.compressionType = compressionType;
    }

    public ByteBuffer getByteBuffer() {
        try {
            if (this.byteData.length < this.dimension.height * this.dimension.width * 4) {
                System.out.println("blow up array from RGB to ARGB");
                this.byteData = this.convertRGBArraytiRGBAArray(this.byteData, this.dimension);
            }
            byte[] compressedData = DXTBufferCompressor.squishCompressToArray(this.byteData, this.dimension.width, this.dimension.height, this.compressionType);
            return ByteBuffer.wrap(compressedData);
        }
        catch (DataFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

    private byte[] convertRGBArraytiRGBAArray(byte[] data2, Dimension dimension) {
        int rgbLength = data2.length;
        int rgbaLength = dimension.width * dimension.height * 4;
        byte[] rgbaBuffer = new byte[rgbaLength];
        int loopN = 0;
        for (int i = 0; i < rgbLength; i += 3) {
            int destPos = i + loopN;
            System.arraycopy(data2, i, rgbaBuffer, destPos, 3);
            ++loopN;
        }
        return rgbaBuffer;
    }

    public byte[] getArray() {
        try {
            return DXTBufferCompressor.squishCompressToArray(this.byteData, this.dimension.width, this.dimension.height, this.compressionType);
        }
        catch (DataFormatException e) {
            e.printStackTrace();
            return this.byteData;
        }
    }

    private static byte[] squishCompressToArray(byte[] rgba, int width, int height, Squish.CompressionType compressionType) throws DataFormatException {
        int length = width * height * 4;
        if (rgba.length != length) {
            throw new DataFormatException("unexpected length:" + rgba.length + " instead of " + length);
        }
        int storageRequirements = Squish.getStorageRequirements(width, height, compressionType);
        return Squish.compressImage(rgba, width, height, new byte[storageRequirements], compressionType, Squish.CompressionMethod.CLUSTER_FIT);
    }
}

