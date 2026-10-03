/*
 * Decompiled with CFR 0.152.
 */
package me.nallar.jdds.internal.jogl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class DDSImage {
    private FileInputStream fis;
    private FileChannel chan;
    private ByteBuffer buf;
    private Header header;
    public static final int DDSD_CAPS = 1;
    public static final int DDSD_HEIGHT = 2;
    public static final int DDSD_WIDTH = 4;
    public static final int DDSD_PITCH = 8;
    public static final int DDSD_PIXELFORMAT = 4096;
    public static final int DDSD_MIPMAPCOUNT = 131072;
    public static final int DDSD_LINEARSIZE = 524288;
    public static final int DDPF_ALPHAPIXELS = 1;
    public static final int DDPF_FOURCC = 4;
    public static final int DDPF_RGB = 64;
    public static final int DDSCAPS_COMPLEX = 8;
    public static final int DDSCAPS2_CUBEMAP = 512;
    public static final int DDSCAPS2_CUBEMAP_POSITIVEX = 1024;
    public static final int DDSCAPS2_CUBEMAP_NEGATIVEX = 2048;
    public static final int DDSCAPS2_CUBEMAP_POSITIVEY = 4096;
    public static final int DDSCAPS2_CUBEMAP_NEGATIVEY = 8192;
    public static final int DDSCAPS2_CUBEMAP_POSITIVEZ = 16384;
    public static final int DDSCAPS2_CUBEMAP_NEGATIVEZ = 32768;
    public static final int DDSCAPS2_VOLUME = 0x200000;
    public static final int D3DFMT_UNKNOWN = 0;
    public static final int D3DFMT_R8G8B8 = 20;
    public static final int D3DFMT_A8R8G8B8 = 21;
    public static final int D3DFMT_X8R8G8B8 = 22;
    public static final int D3DFMT_A1R5G5B5 = 25;
    public static final int D3DFMT_DXT1 = 827611204;
    public static final int D3DFMT_DXT2 = 844388420;
    public static final int D3DFMT_DXT3 = 861165636;
    public static final int D3DFMT_DXT4 = 877942852;
    public static final int D3DFMT_DXT5 = 894720068;
    private static final int MAGIC = 542327876;

    public static DDSImage read(File file) throws IOException {
        DDSImage image = new DDSImage();
        image.readFromFile(file);
        return image;
    }

    public static DDSImage read(ByteBuffer buf) throws IOException {
        DDSImage image = new DDSImage();
        image.readFromBuffer(buf);
        return image;
    }

    public void close() {
        try {
            if (this.chan != null) {
                this.chan.close();
                this.chan = null;
            }
            if (this.fis != null) {
                this.fis.close();
                this.fis = null;
            }
            this.buf = null;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static DDSImage createFromData(int d3dFormat, int width, int height, ByteBuffer[] mipmapData) throws IllegalArgumentException {
        DDSImage image = new DDSImage();
        image.initFromData(d3dFormat, width, height, mipmapData);
        return image;
    }

    public void write(FileOutputStream fos) throws IOException {
        FileChannel chan = fos.getChannel();
        ByteBuffer hdr = ByteBuffer.allocate(Header.writtenSize());
        hdr.order(ByteOrder.LITTLE_ENDIAN);
        this.header.write(hdr);
        hdr.rewind();
        chan.write(hdr);
        this.buf.position(Header.writtenSize());
        chan.write(this.buf);
        chan.force(true);
        chan.close();
    }

    public void write(File file) throws IOException {
        FileOutputStream stream = new FileOutputStream(file);
        this.write(stream);
        stream.close();
    }

    public boolean isSurfaceDescFlagSet(int flag) {
        return (this.header.flags & flag) != 0;
    }

    public boolean isPixelFormatFlagSet(int flag) {
        return (this.header.pfFlags & flag) != 0;
    }

    public int getPixelFormat() {
        if (this.isCompressed()) {
            return this.getCompressionFormat();
        }
        if (this.isPixelFormatFlagSet(64)) {
            if (this.isPixelFormatFlagSet(1)) {
                if (this.getDepth() == 32 && this.header.pfRBitMask == 0xFF0000 && this.header.pfGBitMask == 65280 && this.header.pfBBitMask == 255 && this.header.pfABitMask == -16777216) {
                    return 21;
                }
                if (this.getDepth() == 16 && this.header.pfRBitMask == 31744 && this.header.pfGBitMask == 992 && this.header.pfBBitMask == 31 && this.header.pfABitMask == 32768) {
                    return 25;
                }
            } else {
                if (this.getDepth() == 24 && this.header.pfRBitMask == 0xFF0000 && this.header.pfGBitMask == 65280 && this.header.pfBBitMask == 255) {
                    return 20;
                }
                if (this.getDepth() == 32 && this.header.pfRBitMask == 0xFF0000 && this.header.pfGBitMask == 65280 && this.header.pfBBitMask == 255) {
                    return 22;
                }
            }
        }
        return 0;
    }

    public boolean isCubemap() {
        return (this.header.ddsCaps1 & 8) != 0 && (this.header.ddsCaps2 & 0x200) != 0;
    }

    public boolean isVolume() {
        return (this.header.ddsCaps1 & 8) != 0 && (this.header.ddsCaps2 & 0x200000) != 0;
    }

    public boolean isCubemapSidePresent(int side) {
        return this.isCubemap() && (this.header.ddsCaps2 & side) != 0;
    }

    public boolean isCompressed() {
        return this.isPixelFormatFlagSet(4);
    }

    public int getCompressionFormat() {
        return this.header.pfFourCC;
    }

    public int getWidth() {
        return this.header.width;
    }

    public int getHeight() {
        return this.header.height;
    }

    public int getDepth() {
        return this.header.pfRGBBitCount;
    }

    public int getNumMipMaps() {
        if (!this.isSurfaceDescFlagSet(131072)) {
            return 0;
        }
        return this.header.mipMapCountOrAux;
    }

    public ImageInfo getMipMap(int map2) {
        return this.getMipMap(0, map2);
    }

    public ImageInfo getMipMap(int side, int map2) {
        if (!this.isCubemap() && side != 0) {
            throw new RuntimeException("Illegal side for 2D texture: " + side);
        }
        if (this.isCubemap() && !this.isCubemapSidePresent(side)) {
            throw new RuntimeException("Illegal side, side not present: " + side);
        }
        if (this.getNumMipMaps() > 0 && (map2 < 0 || map2 >= this.getNumMipMaps())) {
            throw new RuntimeException("Illegal mipmap number " + map2 + " (0.." + (this.getNumMipMaps() - 1) + ")");
        }
        int seek = Header.writtenSize();
        if (this.isCubemap()) {
            seek += this.sideShiftInBytes(side);
        }
        for (int i = 0; i < map2; ++i) {
            seek += this.mipMapSizeInBytes(i);
        }
        this.buf.limit(seek + this.mipMapSizeInBytes(map2));
        this.buf.position(seek);
        ByteBuffer next = this.buf.slice();
        this.buf.position(0);
        this.buf.limit(this.buf.capacity());
        return new ImageInfo(next, this.mipMapWidth(map2), this.mipMapHeight(map2), this.isCompressed(), this.getCompressionFormat());
    }

    private DDSImage() {
    }

    private void readFromFile(File file) throws IOException {
        this.fis = new FileInputStream(file);
        this.chan = this.fis.getChannel();
        MappedByteBuffer buf = this.chan.map(FileChannel.MapMode.READ_ONLY, 0L, (int)file.length());
        this.readFromBuffer(buf);
    }

    private void readFromBuffer(ByteBuffer buf) throws IOException {
        this.buf = buf;
        buf.order(ByteOrder.LITTLE_ENDIAN);
        this.header = new Header();
        this.header.read(buf);
        this.fixupHeader();
    }

    private void initFromData(int d3dFormat, int width, int height, ByteBuffer[] mipmapData) throws IllegalArgumentException {
        int topmostMipmapSize = width * height;
        int pitchOrLinearSize = width;
        boolean isCompressed = false;
        switch (d3dFormat) {
            case 20: {
                topmostMipmapSize *= 3;
                pitchOrLinearSize *= 3;
                break;
            }
            case 21: {
                topmostMipmapSize *= 4;
                pitchOrLinearSize *= 4;
                break;
            }
            case 22: {
                topmostMipmapSize *= 4;
                pitchOrLinearSize *= 4;
                break;
            }
            case 827611204: 
            case 844388420: 
            case 861165636: 
            case 877942852: 
            case 894720068: {
                pitchOrLinearSize = topmostMipmapSize = DDSImage.computeCompressedBlockSize(width, height, 1, d3dFormat);
                isCompressed = true;
                break;
            }
            default: {
                throw new IllegalArgumentException("d3dFormat must be one of the known formats");
            }
        }
        int curSize = topmostMipmapSize;
        int mipmapWidth = width;
        int mipmapHeight = height;
        int totalSize = 0;
        for (int i = 0; i < mipmapData.length; ++i) {
            if (mipmapData[i].remaining() != curSize) {
                throw new IllegalArgumentException("Mipmap level " + i + " didn't match expected data size (expected " + curSize + ", got " + mipmapData[i].remaining() + ")");
            }
            if (isCompressed) {
                if (mipmapWidth > 1) {
                    mipmapWidth /= 2;
                }
                if (mipmapHeight > 1) {
                    mipmapHeight /= 2;
                }
                curSize = DDSImage.computeCompressedBlockSize(mipmapWidth, mipmapHeight, 1, d3dFormat);
            } else {
                curSize /= 4;
            }
            totalSize += mipmapData[i].remaining();
        }
        ByteBuffer buf = ByteBuffer.allocate(totalSize += Header.writtenSize());
        buf.position(Header.writtenSize());
        for (ByteBuffer aMipmapData : mipmapData) {
            buf.put(aMipmapData);
        }
        this.buf = buf;
        this.header = new Header();
        this.header.size = Header.size();
        this.header.flags = 4103;
        if (mipmapData.length > 1) {
            this.header.flags |= 0x20000;
            this.header.mipMapCountOrAux = mipmapData.length;
        }
        this.header.width = width;
        this.header.height = height;
        if (isCompressed) {
            this.header.flags |= 0x80000;
            this.header.pfFlags |= 4;
            this.header.pfFourCC = d3dFormat;
        } else {
            this.header.flags |= 8;
            this.header.pfFlags |= 0x40;
            switch (d3dFormat) {
                case 20: {
                    this.header.pfRGBBitCount = 24;
                    break;
                }
                case 21: {
                    this.header.pfRGBBitCount = 32;
                    this.header.pfFlags |= 1;
                    break;
                }
                case 22: {
                    this.header.pfRGBBitCount = 32;
                }
            }
            this.header.pfRBitMask = 0xFF0000;
            this.header.pfGBitMask = 65280;
            this.header.pfBBitMask = 255;
            if (d3dFormat == 21) {
                this.header.pfABitMask = -16777216;
            }
        }
        this.header.pitchOrLinearSize = pitchOrLinearSize;
        this.header.pfSize = Header.pfSize();
    }

    private void fixupHeader() {
        if (this.isCompressed() && !this.isSurfaceDescFlagSet(524288)) {
            int depth = this.header.backBufferCountOrDepth;
            if (depth == 0) {
                depth = 1;
            }
            this.header.pitchOrLinearSize = DDSImage.computeCompressedBlockSize(this.getWidth(), this.getHeight(), depth, this.getCompressionFormat());
            this.header.flags |= 0x80000;
        }
    }

    private static int computeCompressedBlockSize(int width, int height, int depth, int compressionFormat) {
        int blockSize = (width + 3) / 4 * ((height + 3) / 4) * ((depth + 3) / 4);
        switch (compressionFormat) {
            case 827611204: {
                blockSize *= 8;
                break;
            }
            default: {
                blockSize *= 16;
            }
        }
        return blockSize;
    }

    private int mipMapWidth(int map2) {
        int width = this.getWidth();
        for (int i = 0; i < map2; ++i) {
            width >>= 1;
        }
        return Math.max(width, 1);
    }

    private int mipMapHeight(int map2) {
        int height = this.getHeight();
        for (int i = 0; i < map2; ++i) {
            height >>= 1;
        }
        return Math.max(height, 1);
    }

    public int mipMapSizeInBytes(int map2) {
        int width = this.mipMapWidth(map2);
        int height = this.mipMapHeight(map2);
        if (this.isCompressed()) {
            int blockSize = this.getCompressionFormat() == 827611204 ? 8 : 16;
            return (width + 3) / 4 * ((height + 3) / 4) * blockSize;
        }
        return width * height * (this.getDepth() / 8);
    }

    private int sideSizeInBytes() {
        int numLevels = this.getNumMipMaps();
        if (numLevels == 0) {
            numLevels = 1;
        }
        int size = 0;
        for (int i = 0; i < numLevels; ++i) {
            size += this.mipMapSizeInBytes(i);
        }
        return size;
    }

    private int sideShiftInBytes(int side) {
        int[] sides = new int[]{1024, 2048, 4096, 8192, 16384, 32768};
        int shift = 0;
        int sideSize = this.sideSizeInBytes();
        for (int temp : sides) {
            if ((temp & side) != 0) {
                return shift;
            }
            shift += sideSize;
        }
        throw new RuntimeException("Illegal side: " + side);
    }

    static class Header {
        int size;
        int flags;
        int height;
        int width;
        int pitchOrLinearSize;
        int backBufferCountOrDepth;
        int mipMapCountOrAux;
        int alphaBitDepth;
        int reserved1;
        int surface;
        int colorSpaceLowValue;
        int colorSpaceHighValue;
        int destBltColorSpaceLowValue;
        int destBltColorSpaceHighValue;
        int srcOverlayColorSpaceLowValue;
        int srcOverlayColorSpaceHighValue;
        int srcBltColorSpaceLowValue;
        int srcBltColorSpaceHighValue;
        int pfSize;
        int pfFlags;
        int pfFourCC;
        int pfRGBBitCount;
        int pfRBitMask;
        int pfGBitMask;
        int pfBBitMask;
        int pfABitMask;
        int ddsCaps1;
        int ddsCaps2;
        int ddsCapsReserved1;
        int ddsCapsReserved2;
        int textureStage;

        Header() {
        }

        void read(ByteBuffer buf) throws IOException {
            int magic = buf.getInt();
            if (magic != 542327876) {
                throw new IOException("Incorrect magic number 0x" + Integer.toHexString(magic) + " (expected " + 542327876 + ")");
            }
            this.size = buf.getInt();
            this.flags = buf.getInt();
            this.height = buf.getInt();
            this.width = buf.getInt();
            this.pitchOrLinearSize = buf.getInt();
            this.backBufferCountOrDepth = buf.getInt();
            this.mipMapCountOrAux = buf.getInt();
            this.alphaBitDepth = buf.getInt();
            this.reserved1 = buf.getInt();
            this.surface = buf.getInt();
            this.colorSpaceLowValue = buf.getInt();
            this.colorSpaceHighValue = buf.getInt();
            this.destBltColorSpaceLowValue = buf.getInt();
            this.destBltColorSpaceHighValue = buf.getInt();
            this.srcOverlayColorSpaceLowValue = buf.getInt();
            this.srcOverlayColorSpaceHighValue = buf.getInt();
            this.srcBltColorSpaceLowValue = buf.getInt();
            this.srcBltColorSpaceHighValue = buf.getInt();
            this.pfSize = buf.getInt();
            this.pfFlags = buf.getInt();
            this.pfFourCC = buf.getInt();
            this.pfRGBBitCount = buf.getInt();
            this.pfRBitMask = buf.getInt();
            this.pfGBitMask = buf.getInt();
            this.pfBBitMask = buf.getInt();
            this.pfABitMask = buf.getInt();
            this.ddsCaps1 = buf.getInt();
            this.ddsCaps2 = buf.getInt();
            this.ddsCapsReserved1 = buf.getInt();
            this.ddsCapsReserved2 = buf.getInt();
            this.textureStage = buf.getInt();
        }

        void write(ByteBuffer buf) {
            buf.putInt(542327876);
            buf.putInt(this.size);
            buf.putInt(this.flags);
            buf.putInt(this.height);
            buf.putInt(this.width);
            buf.putInt(this.pitchOrLinearSize);
            buf.putInt(this.backBufferCountOrDepth);
            buf.putInt(this.mipMapCountOrAux);
            buf.putInt(this.alphaBitDepth);
            buf.putInt(this.reserved1);
            buf.putInt(this.surface);
            buf.putInt(this.colorSpaceLowValue);
            buf.putInt(this.colorSpaceHighValue);
            buf.putInt(this.destBltColorSpaceLowValue);
            buf.putInt(this.destBltColorSpaceHighValue);
            buf.putInt(this.srcOverlayColorSpaceLowValue);
            buf.putInt(this.srcOverlayColorSpaceHighValue);
            buf.putInt(this.srcBltColorSpaceLowValue);
            buf.putInt(this.srcBltColorSpaceHighValue);
            buf.putInt(this.pfSize);
            buf.putInt(this.pfFlags);
            buf.putInt(this.pfFourCC);
            buf.putInt(this.pfRGBBitCount);
            buf.putInt(this.pfRBitMask);
            buf.putInt(this.pfGBitMask);
            buf.putInt(this.pfBBitMask);
            buf.putInt(this.pfABitMask);
            buf.putInt(this.ddsCaps1);
            buf.putInt(this.ddsCaps2);
            buf.putInt(this.ddsCapsReserved1);
            buf.putInt(this.ddsCapsReserved2);
            buf.putInt(this.textureStage);
        }

        private static int size() {
            return 124;
        }

        private static int pfSize() {
            return 32;
        }

        private static int writtenSize() {
            return 128;
        }
    }

    public static class ImageInfo {
        private final ByteBuffer data;
        private final int width;
        private final int height;
        private final boolean isCompressed;
        private final int compressionFormat;

        public ImageInfo(ByteBuffer data2, int width, int height, boolean compressed, int compressionFormat) {
            this.data = data2;
            this.width = width;
            this.height = height;
            this.isCompressed = compressed;
            this.compressionFormat = compressionFormat;
        }

        public ByteBuffer getData() {
            return this.data;
        }
    }
}

