/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.data;

import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;

public class Hatch {
    public static final byte TYPE_HIDDEN = 0;
    public static final byte TYPE_WINDOW = 1;
    public static final byte TYPE_SCREEN = 2;
    public static final byte TYPE_FRENCH_WINDOW = 3;
    public static final byte TYPE_PANEL = 4;
    public static final byte STATE_CLOSED = 0;
    public static final byte STATE_OPEN = 1;
    public static final byte POSITION_LOW = 0;
    public static final byte POSITION_HIGH = 1;
    public static final byte DIR_Z_NEG = 0;
    public static final byte DIR_Z_POS = 1;
    public static final byte DIR_X_NEG = 2;
    public static final byte DIR_X_POS = 3;
    public static final byte HINGED_NONRIGID = 0;
    public static final byte HINGED_RIGID = 1;

    public static final int getType(int n) {
        return n & 7;
    }

    public static final void setType(TECarpentersBlock tECarpentersBlock, int n) {
        int n2 = BlockProperties.getData(tECarpentersBlock) & 0xFFF8;
        BlockProperties.setData(tECarpentersBlock, n2 |= n);
    }

    public static final int getPos(int n) {
        int n2 = n & 8;
        return n2 >> 3;
    }

    public static final void setPos(TECarpentersBlock tECarpentersBlock, int n) {
        int n2 = BlockProperties.getData(tECarpentersBlock) & 0xFFF7;
        BlockProperties.setData(tECarpentersBlock, n2 |= n << 3);
    }

    public static final int getState(int n) {
        int n2 = n & 0x10;
        return n2 >> 4;
    }

    public static final void setState(TECarpentersBlock tECarpentersBlock, int n) {
        int n2 = BlockProperties.getData(tECarpentersBlock) & 0xFFEF;
        BlockProperties.setData(tECarpentersBlock, n2 |= n << 4);
        if (!tECarpentersBlock.field_70331_k.field_72995_K) {
            tECarpentersBlock.field_70331_k.func_72889_a(null, 1003, tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n, 0);
        }
    }

    public static final int getDir(int n) {
        int n2 = n & 0x60;
        return n2 >> 5;
    }

    public static final void setDir(TECarpentersBlock tECarpentersBlock, int n) {
        int n2 = BlockProperties.getData(tECarpentersBlock) & 0xFF9F;
        BlockProperties.setData(tECarpentersBlock, n2 |= n << 5);
    }

    public static final int getRigidity(int n) {
        int n2 = n & 0x80;
        return n2 >> 7;
    }

    public static final void setRigidity(TECarpentersBlock tECarpentersBlock, int n) {
        int n2 = BlockProperties.getData(tECarpentersBlock) & 0xFF7F;
        BlockProperties.setData(tECarpentersBlock, n2 |= n << 7);
    }
}

