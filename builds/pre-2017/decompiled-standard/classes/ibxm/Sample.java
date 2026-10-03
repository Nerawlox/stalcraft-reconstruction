/*
 * Decompiled with CFR 0.152.
 */
package ibxm;

public class Sample {
    public String name = "";
    public boolean set_panning;
    public int volume;
    public int panning;
    public int transpose;
    private int loop_start;
    private int loop_length;
    private short[] sample_data;
    private static final int POINT_SHIFT = 4;
    private static final int POINTS = 16;
    private static final int OVERLAP = 8;
    private static final int INTERP_SHIFT = 11;
    private static final int INTERP_BITMASK = 2047;
    private static final short[] sinc_table = new short[]{0, -7, 27, -71, 142, -227, 299, 32439, 299, -227, 142, -71, 27, -7, 0, 0, 0, 0, -5, 36, -142, 450, -1439, 32224, 2302, -974, 455, -190, 64, -15, 2, 0, 0, 6, -33, 128, -391, 1042, -2894, 31584, 4540, -1765, 786, -318, 105, -25, 3, 0, 0, 10, -55, 204, -597, 1533, -4056, 30535, 6977, -2573, 1121, -449, 148, -36, 5, 0, -1, 13, -71, 261, -757, 1916, -4922, 29105, 9568, -3366, 1448, -578, 191, -47, 7, 0, -1, 15, -81, 300, -870, 2185, -5498, 27328, 12263, -4109, 1749, -698, 232, -58, 9, 0, -1, 15, -86, 322, -936, 2343, -5800, 25249, 15006, -4765, 2011, -802, 269, -68, 10, 0, -1, 15, -87, 328, -957, 2394, -5849, 22920, 17738, -5298, 2215, -885, 299, -77, 12, 0, 0, 14, -83, 319, -938, 2347, -5671, 20396, 20396, -5671, 2347, -938, 319, -83, 14, 0, 0, 12, -77, 299, -885, 2215, -5298, 17738, 22920, -5849, 2394, -957, 328, -87, 15, -1, 0, 10, -68, 269, -802, 2011, -4765, 15006, 25249, -5800, 2343, -936, 322, -86, 15, -1, 0, 9, -58, 232, -698, 1749, -4109, 12263, 27328, -5498, 2185, -870, 300, -81, 15, -1, 0, 7, -47, 191, -578, 1448, -3366, 9568, 29105, -4922, 1916, -757, 261, -71, 13, -1, 0, 5, -36, 148, -449, 1121, -2573, 6977, 30535, -4056, 1533, -597, 204, -55, 10, 0, 0, 3, -25, 105, -318, 786, -1765, 4540, 31584, -2894, 1042, -391, 128, -33, 6, 0, 0, 2, -15, 64, -190, 455, -974, 2302, 32224, -1439, 450, -142, 36, -5, 0, 0, 0, 0, -7, 27, -71, 142, -227, 299, 32439, 299, -227, 142, -71, 27, -7, 0};

    public Sample() {
        this.set_sample_data(new short[0], 0, 0, false);
    }

    public void set_sample_data(short[] sArray, int n, int n2, boolean bl) {
        if (n < 0) {
            n = 0;
        }
        if (n >= sArray.length) {
            n = sArray.length - 1;
        }
        if (n + n2 > sArray.length) {
            n2 = sArray.length - n;
        }
        if (n2 <= 1) {
            this.sample_data = new short[8 + sArray.length + 24];
            System.arraycopy(sArray, 0, this.sample_data, 8, sArray.length);
            for (int i = 0; i < 8; ++i) {
                short s = this.sample_data[8 + sArray.length - 1];
                this.sample_data[8 + sArray.length + i] = s = (short)(s * (8 - i) / 8);
            }
            n = 8 + sArray.length + 8;
            n2 = 1;
        } else {
            short s;
            int n3;
            if (bl) {
                this.sample_data = new short[8 + n + n2 * 2 + 16];
                System.arraycopy(sArray, 0, this.sample_data, 8, n + n2);
                for (n3 = 0; n3 < n2; ++n3) {
                    this.sample_data[8 + n + n2 + n3] = s = sArray[n + n2 - n3 - 1];
                }
                n += 8;
                n2 *= 2;
            } else {
                this.sample_data = new short[8 + n + n2 + 16];
                System.arraycopy(sArray, 0, this.sample_data, 8, n + n2);
                n += 8;
            }
            for (n3 = 0; n3 < 16; ++n3) {
                this.sample_data[n + n2 + n3] = s = this.sample_data[n + n3];
            }
        }
        this.loop_start = n;
        this.loop_length = n2;
    }

    public void resample_nearest(int n, int n2, int n3, int n4, int n5, int[] nArray, int n6, int n7) {
        n += 8;
        int n8 = this.loop_start + this.loop_length - 1;
        int n9 = n6 << 1;
        int n10 = n6 + n7 - 1 << 1;
        while (n7 > 0) {
            int n11;
            if (n > n8) {
                if (this.loop_length <= 1) break;
                n = this.loop_start + (n - this.loop_start) % this.loop_length;
            }
            if ((n11 = n + (n2 + (n7 - 1) * n3 >> 15)) > n8) {
                while (n <= n8) {
                    int n12 = n9++;
                    nArray[n12] = nArray[n12] + (this.sample_data[n] * n4 >> 15);
                    int n13 = n9++;
                    nArray[n13] = nArray[n13] + (this.sample_data[n] * n5 >> 15);
                    n += (n2 += n3) >> 15;
                    n2 &= Short.MAX_VALUE;
                }
            } else {
                while (n9 <= n10) {
                    int n14 = n9++;
                    nArray[n14] = nArray[n14] + (this.sample_data[n] * n4 >> 15);
                    int n15 = n9++;
                    nArray[n15] = nArray[n15] + (this.sample_data[n] * n5 >> 15);
                    n += (n2 += n3) >> 15;
                    n2 &= Short.MAX_VALUE;
                }
            }
            n7 = n10 - n9 + 2 >> 1;
        }
    }

    public void resample_linear(int n, int n2, int n3, int n4, int n5, int[] nArray, int n6, int n7) {
        n += 8;
        int n8 = this.loop_start + this.loop_length - 1;
        int n9 = n6 << 1;
        int n10 = n6 + n7 - 1 << 1;
        while (n7 > 0) {
            int n11;
            int n12;
            if (n > n8) {
                if (this.loop_length <= 1) break;
                n = this.loop_start + (n - this.loop_start) % this.loop_length;
            }
            if ((n12 = n + (n2 + (n7 - 1) * n3 >> 15)) > n8) {
                while (n <= n8) {
                    n11 = this.sample_data[n];
                    n11 += (this.sample_data[n + 1] - n11) * n2 >> 15;
                    int n13 = n9++;
                    nArray[n13] = nArray[n13] + (n11 * n4 >> 15);
                    int n14 = n9++;
                    nArray[n14] = nArray[n14] + (n11 * n5 >> 15);
                    n += (n2 += n3) >> 15;
                    n2 &= Short.MAX_VALUE;
                }
            } else {
                while (n9 <= n10) {
                    n11 = this.sample_data[n];
                    n11 += (this.sample_data[n + 1] - n11) * n2 >> 15;
                    int n15 = n9++;
                    nArray[n15] = nArray[n15] + (n11 * n4 >> 15);
                    int n16 = n9++;
                    nArray[n16] = nArray[n16] + (n11 * n5 >> 15);
                    n += (n2 += n3) >> 15;
                    n2 &= Short.MAX_VALUE;
                }
            }
            n7 = n10 - n9 + 2 >> 1;
        }
    }

    public void resample_sinc(int n, int n2, int n3, int n4, int n5, int[] nArray, int n6, int n7) {
        int n8 = this.loop_start + this.loop_length - 1;
        int n9 = n6 << 1;
        int n10 = n6 + n7 - 1 << 1;
        while (n9 <= n10) {
            if (n > n8) {
                if (this.loop_length <= 1) break;
                n = this.loop_start + (n - this.loop_start) % this.loop_length;
            }
            int n11 = n2 >> 11 << 4;
            int n12 = sinc_table[n11 + 0] * this.sample_data[n + 0] >> 15;
            n12 += sinc_table[n11 + 1] * this.sample_data[n + 1] >> 15;
            n12 += sinc_table[n11 + 2] * this.sample_data[n + 2] >> 15;
            n12 += sinc_table[n11 + 3] * this.sample_data[n + 3] >> 15;
            n12 += sinc_table[n11 + 4] * this.sample_data[n + 4] >> 15;
            n12 += sinc_table[n11 + 5] * this.sample_data[n + 5] >> 15;
            n12 += sinc_table[n11 + 6] * this.sample_data[n + 6] >> 15;
            n12 += sinc_table[n11 + 7] * this.sample_data[n + 7] >> 15;
            n12 += sinc_table[n11 + 8] * this.sample_data[n + 8] >> 15;
            n12 += sinc_table[n11 + 9] * this.sample_data[n + 9] >> 15;
            n12 += sinc_table[n11 + 10] * this.sample_data[n + 10] >> 15;
            n12 += sinc_table[n11 + 11] * this.sample_data[n + 11] >> 15;
            n12 += sinc_table[n11 + 12] * this.sample_data[n + 12] >> 15;
            n12 += sinc_table[n11 + 13] * this.sample_data[n + 13] >> 15;
            n12 += sinc_table[n11 + 14] * this.sample_data[n + 14] >> 15;
            n12 += sinc_table[n11 + 15] * this.sample_data[n + 15] >> 15;
            int n13 = sinc_table[n11 + 16] * this.sample_data[n + 0] >> 15;
            n13 += sinc_table[n11 + 17] * this.sample_data[n + 1] >> 15;
            n13 += sinc_table[n11 + 18] * this.sample_data[n + 2] >> 15;
            n13 += sinc_table[n11 + 19] * this.sample_data[n + 3] >> 15;
            n13 += sinc_table[n11 + 20] * this.sample_data[n + 4] >> 15;
            n13 += sinc_table[n11 + 21] * this.sample_data[n + 5] >> 15;
            n13 += sinc_table[n11 + 22] * this.sample_data[n + 6] >> 15;
            n13 += sinc_table[n11 + 23] * this.sample_data[n + 7] >> 15;
            n13 += sinc_table[n11 + 24] * this.sample_data[n + 8] >> 15;
            n13 += sinc_table[n11 + 25] * this.sample_data[n + 9] >> 15;
            n13 += sinc_table[n11 + 26] * this.sample_data[n + 10] >> 15;
            n13 += sinc_table[n11 + 27] * this.sample_data[n + 11] >> 15;
            n13 += sinc_table[n11 + 28] * this.sample_data[n + 12] >> 15;
            n13 += sinc_table[n11 + 29] * this.sample_data[n + 13] >> 15;
            n13 += sinc_table[n11 + 30] * this.sample_data[n + 14] >> 15;
            int n14 = n12 + (((n13 += sinc_table[n11 + 31] * this.sample_data[n + 15] >> 15) - n12) * (n2 & 0x7FF) >> 11);
            int n15 = n9;
            nArray[n15] = nArray[n15] + (n14 * n4 >> 15);
            int n16 = n9 + 1;
            nArray[n16] = nArray[n16] + (n14 * n5 >> 15);
            n9 += 2;
            n += (n2 += n3) >> 15;
            n2 &= Short.MAX_VALUE;
        }
    }

    public boolean has_finished(int n) {
        boolean bl = false;
        if (this.loop_length <= 1 && n > this.loop_start) {
            bl = true;
        }
        return bl;
    }
}

