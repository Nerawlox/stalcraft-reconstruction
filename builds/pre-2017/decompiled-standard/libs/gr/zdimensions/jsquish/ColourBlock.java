/*
 * Decompiled with CFR 0.152.
 */
package gr.zdimensions.jsquish;

import gr.zdimensions.jsquish.Vec;
import java.util.Arrays;

final class ColourBlock {
    private static final int[] remapped = new int[16];
    private static final int[] indices = new int[16];
    private static final int[] codes = new int[16];

    private ColourBlock() {
    }

    static int gammaColour(float colour, float scale) {
        return Math.round(scale * colour);
    }

    private static int floatTo565(Vec colour) {
        int r = Math.round(31.0f * colour.x());
        int g = Math.round(63.0f * colour.y());
        int b = Math.round(31.0f * colour.z());
        return r << 11 | g << 5 | b;
    }

    private static void writeColourBlock(int a, int b, int[] indices, byte[] block, int offset) {
        block[offset + 0] = (byte)(a & 0xFF);
        block[offset + 1] = (byte)(a >> 8);
        block[offset + 2] = (byte)(b & 0xFF);
        block[offset + 3] = (byte)(b >> 8);
        int i = 0;
        while (i < 4) {
            int index = 4 * i;
            block[offset + 4 + i] = (byte)(indices[index + 0] | indices[index + 1] << 2 | indices[index + 2] << 4 | indices[index + 3] << 6);
            ++i;
        }
    }

    static void writeColourBlock3(Vec start, Vec end, int[] indices, byte[] block, int offset) {
        int b;
        int a = ColourBlock.floatTo565(start);
        if (a <= (b = ColourBlock.floatTo565(end))) {
            System.arraycopy(indices, 0, remapped, 0, 16);
        } else {
            int tmp = a;
            a = b;
            b = tmp;
            int i = 0;
            while (i < 16) {
                ColourBlock.remapped[i] = indices[i] == 0 ? 1 : (indices[i] == 1 ? 0 : indices[i]);
                ++i;
            }
        }
        ColourBlock.writeColourBlock(a, b, remapped, block, offset);
    }

    static void writeColourBlock4(Vec start, Vec end, int[] indices, byte[] block, int offset) {
        int b;
        int a = ColourBlock.floatTo565(start);
        if (a < (b = ColourBlock.floatTo565(end))) {
            int tmp = a;
            a = b;
            b = tmp;
            int i = 0;
            while (i < 16) {
                ColourBlock.remapped[i] = (indices[i] ^ 1) & 3;
                ++i;
            }
        } else if (a == b) {
            Arrays.fill(remapped, 0);
        } else {
            System.arraycopy(indices, 0, remapped, 0, 16);
        }
        ColourBlock.writeColourBlock(a, b, remapped, block, offset);
    }

    static void decompressColour(byte[] rgba, byte[] block, int offset, boolean isDXT1) {
        int index;
        int[] codes = ColourBlock.codes;
        int a = ColourBlock.unpack565(block, offset, codes, 0);
        int b = ColourBlock.unpack565(block, offset + 2, codes, 4);
        int i = 0;
        while (i < 3) {
            int c = codes[i];
            int d = codes[4 + i];
            if (isDXT1 && a <= b) {
                codes[8 + i] = (c + d) / 2;
                codes[12 + i] = 0;
            } else {
                codes[8 + i] = (2 * c + d) / 3;
                codes[12 + i] = (c + 2 * d) / 3;
            }
            ++i;
        }
        codes[11] = 255;
        codes[15] = isDXT1 && a <= b ? 0 : 255;
        int[] indices = ColourBlock.indices;
        int i2 = 0;
        while (i2 < 4) {
            index = 4 * i2;
            int packed = block[offset + 4 + i2] & 0xFF;
            indices[index + 0] = packed & 3;
            indices[index + 1] = packed >> 2 & 3;
            indices[index + 2] = packed >> 4 & 3;
            indices[index + 3] = packed >> 6 & 3;
            ++i2;
        }
        i2 = 0;
        while (i2 < 16) {
            index = 4 * indices[i2];
            int j = 0;
            while (j < 4) {
                rgba[4 * i2 + j] = (byte)codes[index + j];
                ++j;
            }
            ++i2;
        }
    }

    private static int unpack565(byte[] packed, int pOffset, int[] colour, int cOffset) {
        int value = packed[pOffset + 0] & 0xFF | (packed[pOffset + 1] & 0xFF) << 8;
        int red = value >> 11 & 0x1F;
        int green = value >> 5 & 0x3F;
        int blue = value & 0x1F;
        colour[cOffset + 0] = red << 3 | red >> 2;
        colour[cOffset + 1] = green << 2 | green >> 4;
        colour[cOffset + 2] = blue << 3 | blue >> 2;
        colour[cOffset + 3] = 255;
        return value;
    }
}

