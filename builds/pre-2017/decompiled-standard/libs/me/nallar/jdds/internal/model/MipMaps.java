/*
 * Decompiled with CFR 0.152.
 */
package me.nallar.jdds.internal.model;

import gr.zdimensions.jsquish.Squish;
import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import me.nallar.jdds.internal.ddsutil.ByteBufferedImage;
import me.nallar.jdds.internal.ddsutil.ImageRescaler;
import me.nallar.jdds.internal.ddsutil.MipMapsUtil;
import me.nallar.jdds.internal.ddsutil.NonCubicDimensionException;
import me.nallar.jdds.internal.ddsutil.Rescaler;
import me.nallar.jdds.internal.model.AbstractTextureMap;
import me.nallar.jdds.internal.model.DDSFile;

public class MipMaps
extends AbstractTextureMap
implements Iterable<BufferedImage> {
    public static final int TOP_MOST_MIP_MAP = 0;
    final List<BufferedImage> mipmaps;
    protected final Rescaler rescaler;
    private int numMipMaps;

    public MipMaps() {
        this(0);
    }

    public MipMaps(int numMipMaps) {
        this.numMipMaps = numMipMaps;
        this.rescaler = new ImageRescaler();
        this.mipmaps = new Vector<BufferedImage>(numMipMaps);
    }

    public void generateMipMaps(BufferedImage topmost) {
        this.addMipMap(topmost);
        System.out.println("Generate Mipmaps");
        if (!DDSFile.isPowerOfTwo(topmost.getWidth()) && !DDSFile.isPowerOfTwo(topmost.getHeight())) {
            throw new NonCubicDimensionException();
        }
        this.generateMipMapArray();
    }

    private void generateMipMapArray() {
        BufferedImage topmost = this.getMipMaps().get(0);
        int mipmapWidth = topmost.getWidth();
        int mipmapHeight = topmost.getHeight();
        this.numMipMaps = MipMapsUtil.calculateMaxNumberOfMipMaps(mipmapWidth, mipmapHeight);
        BufferedImage previousMap = topmost;
        for (int i = 1; i < this.numMipMaps; ++i) {
            mipmapWidth = MipMaps.calculateMipMapSize(mipmapWidth);
            mipmapHeight = MipMaps.calculateMipMapSize(mipmapHeight);
            BufferedImage mipMapBi = this.rescaler.rescaleBI(previousMap, mipmapWidth, mipmapHeight);
            this.addMipMap(mipMapBi);
            previousMap = mipMapBi;
        }
    }

    @Override
    public int getHeight() {
        return this.getMipMap(0).getHeight();
    }

    @Override
    public int getWidth() {
        return this.getMipMap(0).getWidth();
    }

    public BufferedImage getMipMap(int index) {
        return this.getMipMaps().get(index);
    }

    public void setMipMap(int mipmapIndex, BufferedImage image) {
        if (this.getMipMaps().size() == mipmapIndex) {
            this.addMipMap(mipmapIndex, image);
        } else {
            this.getMipMaps().set(mipmapIndex, image);
        }
    }

    private List<BufferedImage> getMipMaps() {
        return this.mipmaps;
    }

    public void addMipMap(BufferedImage image) {
        this.getMipMaps().add(image);
    }

    private void addMipMap(int mipmapIndex, BufferedImage image) {
        this.getMipMaps().add(mipmapIndex, image);
    }

    @Override
    public ByteBuffer[] getDXTCompressedBuffer(Squish.CompressionType compressionType) {
        ByteBuffer[] mipmapBuffer = new ByteBuffer[this.numMipMaps];
        for (int j = 0; j < this.numMipMaps; ++j) {
            System.out.println("compress mipmap " + j);
            mipmapBuffer[j] = this.compress(this.getMipMap(j), compressionType);
        }
        return mipmapBuffer;
    }

    @Override
    public ByteBuffer[] getUncompressedBuffer() {
        ByteBuffer[] mipmapBuffer = new ByteBuffer[this.numMipMaps];
        for (int i = 0; i < this.numMipMaps; ++i) {
            mipmapBuffer[i] = ByteBuffer.wrap(ByteBufferedImage.convertBIintoARGBArray(this.getMipMap(i)));
        }
        return mipmapBuffer;
    }

    @Override
    public Iterator<BufferedImage> iterator() {
        return new Iterator<BufferedImage>(){
            int count = 0;

            @Override
            public boolean hasNext() {
                return this.count++ < MipMaps.this.mipmaps.size() - 1;
            }

            @Override
            public BufferedImage next() {
                return MipMaps.this.mipmaps.get(this.count);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static int calculateMipMapSize(int currentValue) {
        return currentValue > 1 ? currentValue / 2 : 1;
    }

    public static int getMipMapSizeAtIndex(int targetIndex, int original) {
        int newValue = original;
        for (int i = 0; i < targetIndex; ++i) {
            newValue = MipMaps.calculateMipMapSize(newValue);
        }
        return newValue;
    }
}

