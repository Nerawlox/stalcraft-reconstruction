/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.data;

import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;

public class DaylightSensor {
    public static final byte POLARITY_POSITIVE = 0;
    public static final byte POLARITY_NEGATIVE = 1;

    public static final int getType(int n) {
        return n & 0xF;
    }

    public static final void setType(TECarpentersBlock tECarpentersBlock, int n) {
        int n2 = BlockProperties.getData(tECarpentersBlock) & 0xFFF0;
        BlockProperties.setData(tECarpentersBlock, n2 |= n);
    }

    public static final int getPolarity(int n) {
        int n2 = n & 0x10;
        return n2 >> 4;
    }

    public static final void setPolarity(TECarpentersBlock tECarpentersBlock, int n) {
        int n2 = BlockProperties.getData(tECarpentersBlock) & 0xFFEF;
        BlockProperties.setData(tECarpentersBlock, n2 |= n << 4);
    }
}

