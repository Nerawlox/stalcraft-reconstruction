/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.data;

import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;

public class Gate {
    public static final byte TYPE_VANILLA = 0;
    public static final byte TYPE_VANILLA_X1 = 1;
    public static final byte TYPE_VANILLA_X2 = 2;
    public static final byte TYPE_VANILLA_X3 = 3;
    public static final byte TYPE_PICKET = 4;
    public static final byte TYPE_PLANK_VERTICAL = 5;
    public static final byte TYPE_WALL = 6;
    public static final byte FACING_ON_X = 0;
    public static final byte FACING_ON_Z = 1;
    public static final byte STATE_CLOSED = 0;
    public static final byte STATE_OPEN = 1;
    public static final byte DIR_POS = 0;
    public static final byte DIR_NEG = 1;

    public static final int getType(int n) {
        return n & 0xF;
    }

    public static final void setType(TECarpentersBlock tECarpentersBlock, int n) {
        int n2 = BlockProperties.getData(tECarpentersBlock) & 0xFFF0;
        BlockProperties.setData(tECarpentersBlock, n2 |= n);
    }

    public static final int getFacing(int n) {
        int n2 = n & 0x20;
        return n2 >> 5;
    }

    public static final void setFacing(TECarpentersBlock tECarpentersBlock, int n) {
        int n2 = BlockProperties.getData(tECarpentersBlock) & 0xFFDF;
        BlockProperties.setData(tECarpentersBlock, n2 |= n << 5);
    }

    public static final int getState(int n) {
        int n2 = n & 0x40;
        return n2 >> 6;
    }

    public static final void setState(TECarpentersBlock tECarpentersBlock, int n, boolean bl) {
        int n2 = BlockProperties.getData(tECarpentersBlock) & 0xFFBF;
        n2 |= n << 6;
        if (!tECarpentersBlock.worldObj.isRemote && bl) {
            tECarpentersBlock.worldObj.playAuxSFXAtEntity(null, 1003, tECarpentersBlock.xCoord, tECarpentersBlock.yCoord, tECarpentersBlock.zCoord, 0);
        }
        BlockProperties.setData(tECarpentersBlock, n2);
    }

    public static final int getDirOpen(int n) {
        int n2 = n & 0x10;
        return n2 >> 4;
    }

    public static final void setDirOpen(TECarpentersBlock tECarpentersBlock, int n) {
        int n2 = BlockProperties.getData(tECarpentersBlock) & 0xFFEF;
        BlockProperties.setData(tECarpentersBlock, n2 |= n << 4);
    }
}

