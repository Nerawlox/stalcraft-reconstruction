/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.data;

import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;

public class Button {
    public static final byte POLARITY_POSITIVE = 0;
    public static final byte POLARITY_NEGATIVE = 1;
    public static final byte STATE_OFF = 0;
    public static final byte STATE_ON = 1;

    public static final int getType(int n) {
        return n & 7;
    }

    public static final void setType(TECarpentersBlock tECarpentersBlock, int n) {
        int n2 = BlockProperties.getData(tECarpentersBlock) & 0xFFF8;
        BlockProperties.setData(tECarpentersBlock, n2 |= n);
    }

    public static final int getState(int n) {
        int n2 = n & 8;
        return n2 >> 3;
    }

    public static final void setState(TECarpentersBlock tECarpentersBlock, int n, boolean bl) {
        int n2 = BlockProperties.getData(tECarpentersBlock) & 0xFFF7;
        n2 |= n << 3;
        int n3 = BlockProperties.getData(tECarpentersBlock);
        Button.getPolarity(n3);
        if (!tECarpentersBlock.field_70331_k.field_72995_K && BlockProperties.getCoverBlock((TECarpentersBlock)tECarpentersBlock, (int)6).field_72018_cp != tflj._n && bl && Button.getState(n3) != n) {
            tECarpentersBlock.field_70331_k.func_72908_a((double)tECarpentersBlock.field_70329_l + 0.5, (double)tECarpentersBlock.field_70330_m + 0.5, (double)tECarpentersBlock.field_70327_n + 0.5, "random.click", 0.3f, Button.getState(n3) == 1 ? 0.5f : 0.6f);
        }
        BlockProperties.setData(tECarpentersBlock, n2);
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

