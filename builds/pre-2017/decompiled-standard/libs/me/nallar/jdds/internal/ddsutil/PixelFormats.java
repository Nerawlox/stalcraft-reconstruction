/*
 * Decompiled with CFR 0.152.
 */
package me.nallar.jdds.internal.ddsutil;

import gr.zdimensions.jsquish.Squish;
import javax.activation.UnsupportedDataTypeException;
import me.nallar.jdds.internal.model.TextureImage;

public class PixelFormats {
    public static Squish.CompressionType getSquishCompressionFormat(int pixelFormat) throws UnsupportedDataTypeException {
        switch (pixelFormat) {
            case 827611204: {
                return Squish.CompressionType.DXT1;
            }
            case 861165636: {
                return Squish.CompressionType.DXT3;
            }
            case 894720068: {
                return Squish.CompressionType.DXT5;
            }
        }
        throw new UnsupportedDataTypeException("given pixel format not supported me.nallar.jdds.internal.compression format");
    }

    public static String verbosePixelformat(int pixelformat) {
        switch (pixelformat) {
            default: {
                return TextureImage.PixelFormat.Unknown.toString();
            }
            case 21: {
                return TextureImage.PixelFormat.Unknown.toString();
            }
            case 827611204: {
                return TextureImage.PixelFormat.DXT1.toString();
            }
            case 844388420: {
                return TextureImage.PixelFormat.DXT2.toString();
            }
            case 861165636: {
                return TextureImage.PixelFormat.DXT3.toString();
            }
            case 877942852: {
                return TextureImage.PixelFormat.DXT4.toString();
            }
            case 894720068: {
                return TextureImage.PixelFormat.DXT5.toString();
            }
            case 20: {
                return TextureImage.PixelFormat.R8G8B8.toString();
            }
            case 22: 
        }
        return TextureImage.PixelFormat.X8R8G8B8.toString();
    }

    public static boolean isDXTCompressed(int pixelformat) {
        switch (pixelformat) {
            default: {
                return false;
            }
            case 827611204: 
            case 844388420: 
            case 861165636: 
            case 877942852: 
            case 894720068: 
        }
        return true;
    }
}

