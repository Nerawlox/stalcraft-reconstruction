/*
 * Decompiled with CFR 0.152.
 */
package me.nallar.jdds.internal.model;

import gr.zdimensions.jsquish.Squish;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import javax.activation.UnsupportedDataTypeException;
import me.nallar.jdds.internal.compression.ARGBBufferDecompressor;
import me.nallar.jdds.internal.compression.BufferDecompressor;
import me.nallar.jdds.internal.compression.DXTBufferDecompressor;
import me.nallar.jdds.internal.ddsutil.PixelFormats;
import me.nallar.jdds.internal.jogl.DDSImage;
import me.nallar.jdds.internal.model.AbstractTextureImage;
import me.nallar.jdds.internal.model.MipMaps;
import me.nallar.jdds.internal.model.TextureImage;

public class DDSFile
extends AbstractTextureImage {
    protected TextureImage.TextureType textureType;
    private DDSImage ddsimage;

    public DDSFile(File file) {
        this.file = file;
        try {
            this.init(DDSImage.read(file));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DDSFile(File file, DDSImage ddsimage) {
        this.file = file;
        this.init(ddsimage);
    }

    protected void init(DDSImage ddsimage) {
        this.ddsimage = ddsimage;
        this.width = ddsimage.getWidth();
        this.height = ddsimage.getHeight();
        this.pixelformat = ddsimage.getPixelFormat();
        this.textureType = DDSFile.getTextureType(ddsimage);
        this.numMipMaps = ddsimage.getNumMipMaps();
        this.mipMaps = new MipMaps(this.numMipMaps);
        this.hasMipMaps = ddsimage.getNumMipMaps() > 1;
    }

    public void loadImageData(int mipmap) throws UnsupportedDataTypeException {
        if (mipmap <= this.numMipMaps) {
            BufferDecompressor bufferDecompressor;
            int width = MipMaps.getMipMapSizeAtIndex(mipmap, this.ddsimage.getWidth());
            int height = MipMaps.getMipMapSizeAtIndex(mipmap, this.ddsimage.getHeight());
            ByteBuffer data2 = this.ddsimage.getMipMap(mipmap).getData();
            if (this.isCompressed()) {
                Squish.CompressionType compressionType = PixelFormats.getSquishCompressionFormat(this.ddsimage.getPixelFormat());
                bufferDecompressor = new DXTBufferDecompressor(data2, width, height, compressionType);
            } else {
                bufferDecompressor = new ARGBBufferDecompressor(data2, width, height, this.pixelformat);
            }
            this.mipMaps.addMipMap(bufferDecompressor.getImage());
        }
    }

    public String toString() {
        return this.file.getAbsolutePath() + PixelFormats.verbosePixelformat(this.pixelformat);
    }

    public boolean equals(Object second) {
        if (second != null && second instanceof DDSFile) {
            DDSFile secondFile = (DDSFile)second;
            return this.getFile().getAbsoluteFile().equals(secondFile.getFile().getAbsoluteFile()) && this.hasMipMaps() == secondFile.hasMipMaps() && this.getPixelformat() == secondFile.getPixelformat() && this.getHeight() == secondFile.getHeight() && this.getWidth() == secondFile.getWidth();
        }
        return false;
    }

    public static TextureImage.TextureType getTextureType(DDSImage ddsimage) {
        if (ddsimage.isCubemap()) {
            return TextureImage.TextureType.CUBEMAP;
        }
        if (ddsimage.isVolume()) {
            return TextureImage.TextureType.VOLUME;
        }
        return TextureImage.TextureType.TEXTURE;
    }

    @Override
    public void write(File targetFile) throws IOException {
        ByteBuffer[] mipmaps = new ByteBuffer[this.getNumMipMaps()];
        for (int i = 0; i < mipmaps.length; ++i) {
            mipmaps[i] = DDSImage.read(this.file).getMipMap(i).getData();
        }
        DDSImage outputDDS = DDSImage.createFromData(this.pixelformat, this.width, this.height, mipmaps);
        outputDDS.write(this.file);
        outputDDS.close();
    }
}

