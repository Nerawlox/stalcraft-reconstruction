/*
 * Decompiled with CFR 0.152.
 */
package me.nallar.jdds.internal.ddsutil;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.WritableRaster;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class ByteBufferedImage
extends BufferedImage {
    public ByteBufferedImage(int width, int height, Buffer buffer) {
        super(width, height, 6);
        this.initRaster(width, height, buffer);
    }

    private void initRaster(int width, int height, Buffer buffer) {
        WritableRaster wr = this.getRaster();
        byte[] rgba = new byte[buffer.capacity()];
        ((ByteBuffer)buffer).get(rgba);
        wr.setDataElements(0, 0, width, height, rgba);
    }

    public static byte[] convertBIintoARGBArray(BufferedImage bi) {
        DataBuffer dataBuffer = bi.getRaster().getDataBuffer();
        int componentCount = bi.getColorModel().getNumComponents();
        return ByteBufferedImage.convertDataBufferToARGBArray(bi.getWidth(), bi.getHeight(), dataBuffer, componentCount, bi.getType());
    }

    private static byte[] convertDataBufferToARGBArray(int width, int height, DataBuffer dataBuffer, int componentCount, int bufferedImageType) {
        int length = height * width * 4;
        byte[] argb = new byte[length];
        int count = 0;
        if (length != dataBuffer.getSize()) {
            throw new IllegalStateException("Databuffer has not the expected length: " + dataBuffer.getSize() + " instead of " + length);
        }
        for (int i = 0; i < dataBuffer.getSize(); i += componentCount) {
            int b;
            int g;
            int r;
            if (componentCount > 3) {
                int a;
                if (bufferedImageType != 6) {
                    a = dataBuffer.getElem(i);
                    r = dataBuffer.getElem(i + 1);
                    g = dataBuffer.getElem(i + 2);
                    b = dataBuffer.getElem(i + 3);
                } else {
                    b = dataBuffer.getElem(i);
                    g = dataBuffer.getElem(i + 1);
                    r = dataBuffer.getElem(i + 2);
                    a = dataBuffer.getElem(i + 3);
                }
                argb[i] = (byte)(a & 0xFF);
                argb[i + 1] = (byte)(r & 0xFF);
                argb[i + 2] = (byte)(g & 0xFF);
                argb[i + 3] = (byte)(b & 0xFF);
                continue;
            }
            b = dataBuffer.getElem(count);
            g = dataBuffer.getElem(++count);
            r = dataBuffer.getElem(++count);
            ++count;
            argb[i] = -1;
            argb[i + 1] = (byte)(r & 0xFF);
            argb[i + 2] = (byte)(g & 0xFF);
            argb[i + 3] = (byte)(b & 0xFF);
        }
        return argb;
    }
}

