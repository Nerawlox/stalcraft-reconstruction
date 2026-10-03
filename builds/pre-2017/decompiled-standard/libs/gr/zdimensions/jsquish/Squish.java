/*
 * Decompiled with CFR 0.152.
 */
package gr.zdimensions.jsquish;

import gr.zdimensions.jsquish.ColourBlock;
import gr.zdimensions.jsquish.ColourSet;
import gr.zdimensions.jsquish.CompressorAlpha;
import gr.zdimensions.jsquish.CompressorCluster;
import gr.zdimensions.jsquish.CompressorColourFit;
import gr.zdimensions.jsquish.CompressorRange;
import gr.zdimensions.jsquish.CompressorSingleColour;
import java.nio.ByteBuffer;

public final class Squish {
    private static final ColourSet colours = new ColourSet();

    private Squish() {
    }

    public static int getStorageRequirements(int width, int height, CompressionType type2) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Invalid image dimensions specified: " + width + " x " + height);
        }
        int blockcount = (width + 3) / 4 * ((height + 3) / 4);
        return blockcount * type2.blockSize;
    }

    public static byte[] compressImage(byte[] rgba, int width, int height, byte[] blocks, CompressionType type2) {
        return Squish.compressImage(rgba, width, height, blocks, type2, CompressionMethod.CLUSTER_FIT, CompressionMetric.PERCEPTUAL, false);
    }

    public static byte[] compressImage(int[] rgba, int width, int height, byte[] blocks, CompressionType type2) {
        return Squish.compressImage(rgba, width, height, blocks, type2, CompressionMethod.CLUSTER_FIT, CompressionMetric.PERCEPTUAL, false);
    }

    public static byte[] compressImage(ByteBuffer rgba, int width, int height, byte[] blocks, CompressionType type2) {
        return Squish.compressImage(rgba, width, height, blocks, type2, CompressionMethod.CLUSTER_FIT, CompressionMetric.PERCEPTUAL, false);
    }

    public static byte[] compressImage(byte[] rgba, int width, int height, byte[] blocks, CompressionType type2, CompressionMethod method) {
        return Squish.compressImage(rgba, width, height, blocks, type2, method, CompressionMetric.PERCEPTUAL, false);
    }

    public static byte[] compressImage(int[] rgba, int width, int height, byte[] blocks, CompressionType type2, CompressionMethod method) {
        return Squish.compressImage(rgba, width, height, blocks, type2, method, CompressionMetric.PERCEPTUAL, false);
    }

    public static byte[] compressImage(ByteBuffer rgba, int width, int height, byte[] blocks, CompressionType type2, CompressionMethod method) {
        return Squish.compressImage(rgba, width, height, blocks, type2, method, CompressionMetric.PERCEPTUAL, false);
    }

    public static byte[] compressImage(byte[] rgba, int width, int height, byte[] blocks, CompressionType type2, CompressionMethod method, CompressionMetric metric, boolean weightAlpha) {
        blocks = Squish.checkCompressInput(rgba, width, height, blocks, type2);
        byte[] sourceRGBA = new byte[64];
        int targetBlock = 0;
        int y = 0;
        while (y < height) {
            int x = 0;
            while (x < width) {
                int targetPixel = 0;
                int mask = 0;
                int py = 0;
                while (py < 4) {
                    int sy = y + py;
                    int px = 0;
                    while (px < 4) {
                        int sx = x + px;
                        if (sx < width && sy < height) {
                            int sourcePixel = 4 * (width * sy + sx);
                            int i = 0;
                            while (i < 4) {
                                sourceRGBA[targetPixel++] = rgba[sourcePixel++];
                                ++i;
                            }
                            mask |= 1 << 4 * py + px;
                        } else {
                            targetPixel += 4;
                        }
                        ++px;
                    }
                    ++py;
                }
                Squish.compress(sourceRGBA, mask, blocks, targetBlock, type2, method, metric, weightAlpha);
                targetBlock += type2.blockSize;
                x += 4;
            }
            y += 4;
        }
        return blocks;
    }

    public static byte[] compressImage(int[] rgba, int width, int height, byte[] blocks, CompressionType type2, CompressionMethod method, CompressionMetric metric, boolean weightAlpha) {
        blocks = Squish.checkCompressInput(rgba, width, height, blocks, type2);
        byte[] sourceRGBA = new byte[64];
        int targetBlock = 0;
        int y = 0;
        while (y < height) {
            int x = 0;
            while (x < width) {
                int targetPixel = 0;
                int mask = 0;
                int py = 0;
                while (py < 4) {
                    int sy = y + py;
                    int px = 0;
                    while (px < 4) {
                        int sx = x + px;
                        if (sx < width && sy < height) {
                            int sourcePixel = 4 * (width * sy + sx);
                            int i = 0;
                            while (i < 4) {
                                sourceRGBA[targetPixel++] = (byte)((rgba[i] & 0xFF000000) >> 24);
                                sourceRGBA[targetPixel++] = (byte)(rgba[i] & 0xFF);
                                sourceRGBA[targetPixel++] = (byte)((rgba[i] & 0xFF00) >> 8);
                                sourceRGBA[targetPixel++] = (byte)((rgba[i] & 0xFF0000) >> 16);
                                ++i;
                            }
                            mask |= 1 << 4 * py + px;
                        } else {
                            targetPixel += 4;
                        }
                        ++px;
                    }
                    ++py;
                }
                Squish.compress(sourceRGBA, mask, blocks, targetBlock, type2, method, metric, weightAlpha);
                targetBlock += type2.blockSize;
                x += 4;
            }
            y += 4;
        }
        return blocks;
    }

    public static byte[] compressImage(ByteBuffer rgbaBuffer, int width, int height, byte[] blocks, CompressionType type2, CompressionMethod method, CompressionMetric metric, boolean weightAlpha) {
        blocks = Squish.checkCompressInput(rgbaBuffer, width, height, blocks, type2);
        byte[] sourceRGBA = new byte[64];
        int targetBlock = 0;
        int y = 0;
        while (y < height) {
            int x = 0;
            while (x < width) {
                int targetPixel = 0;
                int mask = 0;
                int py = 0;
                while (py < 4) {
                    int sy = y + py;
                    int px = 0;
                    while (px < 4) {
                        int sx = x + px;
                        if (sx < width && sy < height) {
                            int sourcePixel = 4 * (width * sy + sx);
                            int i = 0;
                            while (i < 4) {
                                sourceRGBA[targetPixel++] = rgbaBuffer.get();
                                ++i;
                            }
                            mask |= 1 << 4 * py + px;
                        } else {
                            targetPixel += 4;
                        }
                        ++px;
                    }
                    ++py;
                }
                Squish.compress(sourceRGBA, mask, blocks, targetBlock, type2, method, metric, weightAlpha);
                targetBlock += type2.blockSize;
                x += 4;
            }
            y += 4;
        }
        return blocks;
    }

    private static byte[] checkCompressInput(int[] rgba, int width, int height, byte[] blocks, CompressionType type2) {
        return Squish.checkStorageSize(width, height, blocks, type2, rgba.length, rgba == null);
    }

    private static byte[] checkCompressInput(ByteBuffer rgbaBuffer, int width, int height, byte[] blocks, CompressionType type2) {
        return Squish.checkStorageSize(width, height, blocks, type2, rgbaBuffer.capacity(), rgbaBuffer == null);
    }

    private static byte[] checkCompressInput(byte[] rgba, int width, int height, byte[] blocks, CompressionType type2) {
        return Squish.checkStorageSize(width, height, blocks, type2, rgba.length, rgba == null);
    }

    private static byte[] checkStorageSize(int width, int height, byte[] blocks, CompressionType type2, int bufferSize, boolean bufferIsNull) {
        if (bufferIsNull || bufferSize < width * height * 4) {
            throw new IllegalArgumentException("Invalid source image data specified.");
        }
        int storageSize = Squish.getStorageRequirements(width, height, type2);
        if (blocks == null || blocks.length < storageSize) {
            blocks = new byte[storageSize];
        }
        return blocks;
    }

    private static void compress(byte[] rgba, int mask, byte[] block, int offset, CompressionType type2, CompressionMethod method, CompressionMetric metric, boolean weightAlpha) {
        int colourBlock = offset + type2.blockOffset;
        int alphaBlock = offset;
        colours.init(rgba, mask, type2, weightAlpha);
        CompressorColourFit fit = colours.getCount() == 1 ? new CompressorSingleColour(colours, type2) : method.getCompressor(colours, type2, metric);
        fit.compress(block, colourBlock);
        if (type2 == CompressionType.DXT3) {
            CompressorAlpha.compressAlphaDxt3(rgba, mask, block, alphaBlock);
        } else if (type2 == CompressionType.DXT5) {
            CompressorAlpha.compressAlphaDxt5(rgba, mask, block, alphaBlock);
        }
    }

    public static byte[] decompressImage(byte[] rgba, int width, int height, byte[] blocks, CompressionType type2) {
        rgba = Squish.checkDecompressInput(rgba, width, height, blocks, type2);
        byte[] targetRGBA = new byte[64];
        int sourceBlock = 0;
        int y = 0;
        while (y < height) {
            int x = 0;
            while (x < width) {
                Squish.decompress(targetRGBA, blocks, sourceBlock, type2);
                int sourcePixel = 0;
                int py = 0;
                while (py < 4) {
                    int px = 0;
                    while (px < 4) {
                        int sx = x + px;
                        int sy = y + py;
                        if (sx < width && sy < height) {
                            int targetPixel = 4 * (width * sy + sx);
                            int i = 0;
                            while (i < 4) {
                                rgba[targetPixel++] = targetRGBA[sourcePixel++];
                                ++i;
                            }
                        } else {
                            sourcePixel += 4;
                        }
                        ++px;
                    }
                    ++py;
                }
                sourceBlock += type2.blockSize;
                x += 4;
            }
            y += 4;
        }
        return rgba;
    }

    private static byte[] checkDecompressInput(byte[] rgba, int width, int height, byte[] blocks, CompressionType type2) {
        int storageSize = Squish.getStorageRequirements(width, height, type2);
        if (blocks == null || blocks.length < storageSize) {
            throw new IllegalArgumentException("Invalid source image data specified.");
        }
        if (rgba == null || rgba.length < width * height * 4) {
            rgba = new byte[width * height * 4];
        }
        return rgba;
    }

    private static void decompress(byte[] rgba, byte[] block, int offset, CompressionType type2) {
        int colourBlock = offset + type2.blockOffset;
        int alphaBock = offset;
        ColourBlock.decompressColour(rgba, block, colourBlock, type2 == CompressionType.DXT1);
        if (type2 == CompressionType.DXT3) {
            CompressorAlpha.decompressAlphaDxt3(rgba, block, alphaBock);
        } else if (type2 == CompressionType.DXT5) {
            CompressorAlpha.decompressAlphaDxt5(rgba, block, alphaBock);
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static enum CompressionMethod {
        CLUSTER_FIT{

            CompressorColourFit getCompressor(ColourSet colours, CompressionType type2, CompressionMetric metric) {
                return new CompressorCluster(colours, type2, metric);
            }
        }
        ,
        RANGE_FIT{

            CompressorColourFit getCompressor(ColourSet colours, CompressionType type2, CompressionMetric metric) {
                return new CompressorRange(colours, type2, metric);
            }
        };


        abstract CompressorColourFit getCompressor(ColourSet var1, CompressionType var2, CompressionMetric var3);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static enum CompressionMetric {
        PERCEPTUAL(0.2126f, 0.7152f, 0.0722f),
        UNIFORM(1.0f, 1.0f, 1.0f);

        public final float r;
        public final float g;
        public final float b;

        private CompressionMetric(float r, float g, float b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }

        public float dot(float x, float y, float z) {
            return this.r * x + this.g * y + this.b * z;
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static enum CompressionType {
        DXT1(8),
        DXT3(16),
        DXT5(16);

        public final int blockSize;
        public final int blockOffset;

        private CompressionType(int blockSize) {
            this.blockSize = blockSize;
            this.blockOffset = blockSize - 8;
        }
    }
}

