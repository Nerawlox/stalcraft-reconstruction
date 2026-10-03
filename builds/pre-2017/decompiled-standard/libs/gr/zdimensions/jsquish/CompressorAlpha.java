/*
 * Decompiled with CFR 0.152.
 */
package gr.zdimensions.jsquish;

final class CompressorAlpha {
    private static final int[] swapped = new int[16];
    private static final int[] codes5 = new int[8];
    private static final int[] codes7 = new int[8];
    private static final int[] indices5 = new int[16];
    private static final int[] indices7 = new int[16];
    private static final int[] codes = new int[8];
    private static final int[] indices = new int[16];

    private CompressorAlpha() {
    }

    static void compressAlphaDxt3(byte[] rgba, int mask, byte[] block, int offset) {
        int i = 0;
        while (i < 8) {
            float alpha1 = (float)(rgba[8 * i + 3] & 0xFF) * 0.05882353f;
            float alpha2 = (float)(rgba[8 * i + 7] & 0xFF) * 0.05882353f;
            int quant1 = Math.round(alpha1);
            int quant2 = Math.round(alpha2);
            int bit1 = 1 << 2 * i;
            int bit2 = 1 << 2 * i + 1;
            if ((mask & bit1) == 0) {
                quant1 = 0;
            }
            if ((mask & bit2) == 0) {
                quant2 = 0;
            }
            block[offset + i] = (byte)(quant1 | quant2 << 4);
            ++i;
        }
    }

    static void decompressAlphaDxt3(byte[] rgba, byte[] block, int offset) {
        int i = 0;
        while (i < 8) {
            int quant = block[offset + i] & 0xFF;
            int lo = quant & 0xF;
            int hi = quant & 0xF0;
            rgba[8 * i + 3] = (byte)(lo | lo << 4);
            rgba[8 * i + 7] = (byte)(hi | hi >> 4);
            ++i;
        }
    }

    private static int fitCodes(byte[] rgba, int mask, int[] codes, int[] indices) {
        int err = 0;
        int i = 0;
        while (i < 16) {
            int bit = 1 << i;
            if ((mask & bit) == 0) {
                indices[i] = 0;
            } else {
                int value = rgba[4 * i + 3] & 0xFF;
                int least = Integer.MAX_VALUE;
                int index = 0;
                int j = 0;
                while (j < 8) {
                    int dist = value - codes[j];
                    if ((dist *= dist) < least) {
                        least = dist;
                        index = j;
                    }
                    ++j;
                }
                indices[i] = index;
                err += least;
            }
            ++i;
        }
        return err;
    }

    private static void writeAlphaBlock(int alpha0, int alpha1, int[] indices, byte[] block, int offset) {
        block[offset + 0] = (byte)alpha0;
        block[offset + 1] = (byte)alpha1;
        int src = 0;
        int dest = 2;
        int i = 0;
        while (i < 2) {
            int value = 0;
            int j = 0;
            while (j < 8) {
                int index = indices[src++];
                value |= index << 3 * j;
                ++j;
            }
            j = 0;
            while (j < 3) {
                block[offset + dest++] = (byte)(value >> 8 * j & 0xFF);
                ++j;
            }
            ++i;
        }
    }

    private static void writeAlphaBlock5(int alpha0, int alpha1, int[] indices, byte[] block, int offset) {
        int[] swapped = CompressorAlpha.swapped;
        if (alpha0 > alpha1) {
            int i = 0;
            while (i < 16) {
                int index = indices[i];
                swapped[i] = index == 0 ? 1 : (index == 1 ? 0 : (index <= 5 ? 7 - index : index));
                ++i;
            }
            CompressorAlpha.writeAlphaBlock(alpha1, alpha0, swapped, block, offset);
        } else {
            CompressorAlpha.writeAlphaBlock(alpha0, alpha1, indices, block, offset);
        }
    }

    private static void writeAlphaBlock7(int alpha0, int alpha1, int[] indices, byte[] block, int offset) {
        int[] swapped = CompressorAlpha.swapped;
        if (alpha0 < alpha1) {
            int i = 0;
            while (i < 16) {
                int index = indices[i];
                swapped[i] = index == 0 ? 1 : (index == 1 ? 0 : 9 - index);
                ++i;
            }
            CompressorAlpha.writeAlphaBlock(alpha1, alpha0, swapped, block, offset);
        } else {
            CompressorAlpha.writeAlphaBlock(alpha0, alpha1, indices, block, offset);
        }
    }

    static void compressAlphaDxt5(byte[] rgba, int mask, byte[] block, int offset) {
        int err7;
        int min5 = 255;
        int max5 = 0;
        int min7 = 255;
        int max7 = 0;
        int i = 0;
        while (i < 16) {
            int bit = 1 << i;
            if ((mask & bit) != 0) {
                int value = rgba[4 * i + 3] & 0xFF;
                if (value < min7) {
                    min7 = value;
                }
                if (value > max7) {
                    max7 = value;
                }
                if (value != 0 && value < min5) {
                    min5 = value;
                }
                if (value != 255 && value > max5) {
                    max5 = value;
                }
            }
            ++i;
        }
        if (min5 > max5) {
            min5 = max5;
        }
        if (min7 > max7) {
            min7 = max7;
        }
        if (max5 - min5 < 5) {
            max5 = Math.min(min5 + 5, 255);
        }
        if (max5 - min5 < 5) {
            min5 = Math.max(0, max5 - 5);
        }
        if (max7 - min7 < 7) {
            max7 = Math.min(min7 + 7, 255);
        }
        if (max7 - min7 < 7) {
            min7 = Math.max(0, max7 - 7);
        }
        int[] codes5 = CompressorAlpha.codes5;
        codes5[0] = min5;
        codes5[1] = max5;
        int i2 = 1;
        while (i2 < 5) {
            codes5[1 + i2] = ((5 - i2) * min5 + i2 * max5) / 5;
            ++i2;
        }
        codes5[6] = 0;
        codes5[7] = 255;
        int[] codes7 = CompressorAlpha.codes7;
        codes7[0] = min7;
        codes7[1] = max7;
        int i3 = 1;
        while (i3 < 7) {
            codes7[1 + i3] = ((7 - i3) * min7 + i3 * max7) / 7;
            ++i3;
        }
        int err5 = CompressorAlpha.fitCodes(rgba, mask, codes5, indices5);
        if (err5 <= (err7 = CompressorAlpha.fitCodes(rgba, mask, codes7, indices7))) {
            CompressorAlpha.writeAlphaBlock5(min5, max5, indices5, block, offset);
        } else {
            CompressorAlpha.writeAlphaBlock7(min7, max7, indices7, block, offset);
        }
    }

    static void decompressAlphaDxt5(byte[] rgba, byte[] block, int offset) {
        int i;
        int alpha0 = block[offset + 0] & 0xFF;
        int alpha1 = block[offset + 1] & 0xFF;
        int[] codes = CompressorAlpha.codes;
        codes[0] = alpha0;
        codes[1] = alpha1;
        if (alpha0 <= alpha1) {
            i = 1;
            while (i < 5) {
                codes[1 + i] = ((5 - i) * alpha0 + i * alpha1) / 5;
                ++i;
            }
            codes[6] = 0;
            codes[7] = 255;
        } else {
            i = 1;
            while (i < 7) {
                codes[1 + i] = ((7 - i) * alpha0 + i * alpha1) / 7;
                ++i;
            }
        }
        int[] indices = CompressorAlpha.indices;
        int src = 2;
        int dest = 0;
        int i2 = 0;
        while (i2 < 2) {
            int value = 0;
            int j = 0;
            while (j < 3) {
                int b = block[offset + src++] & 0xFF;
                value |= b << 8 * j;
                ++j;
            }
            j = 0;
            while (j < 8) {
                int index = value >> 3 * j & 7;
                indices[dest++] = index;
                ++j;
            }
            ++i2;
        }
        i2 = 0;
        while (i2 < 16) {
            rgba[4 * i2 + 3] = (byte)codes[indices[i2]];
            ++i2;
        }
    }
}

