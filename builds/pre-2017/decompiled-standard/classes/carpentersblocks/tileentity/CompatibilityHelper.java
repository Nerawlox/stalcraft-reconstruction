/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.tileentity;

import carpentersblocks.tileentity.TECarpentersBlock;

public class CompatibilityHelper {
    public static void convertData(TECarpentersBlock tECarpentersBlock, qoac qoac2) {
        short[] sArray = new short[7];
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        int n = qoac2._f("data");
        byte by = (byte)((n & 0xF00000) >> 20);
        byte by2 = (byte)((n & 0xF000) >> 12);
        sArray[6] = (short)(n & 0xFFF);
        byte by3 = qoac2._d("pattern");
        short s = (short)((n & 0xFF000000) >>> 24);
        int[] nArray = qoac2._l("sideCover");
        sArray[0] = (short)(((nArray[0] & 0xFFF0000) >> 16) + ((nArray[0] & 0xF0000000) >>> 16));
        sArray[1] = (short)((nArray[0] & 0xFFF) + (nArray[0] & 0xF000));
        sArray[2] = (short)(((nArray[1] & 0xFFF0000) >> 16) + ((nArray[1] & 0xF0000000) >>> 16));
        sArray[3] = (short)((nArray[1] & 0xFFF) + (nArray[1] & 0xF000));
        sArray[4] = (short)(((nArray[2] & 0xFFF0000) >> 16) + ((nArray[2] & 0xF0000000) >>> 16));
        sArray[5] = (short)((nArray[2] & 0xFFF) + (nArray[2] & 0xF000));
        for (int i = 0; i < 7; ++i) {
            tECarpentersBlock.cover[i] = sArray[i];
        }
        tECarpentersBlock.pattern[6] = by3;
        tECarpentersBlock.color[6] = by;
        tECarpentersBlock.overlay[6] = by2;
        tECarpentersBlock.data = s;
    }
}

