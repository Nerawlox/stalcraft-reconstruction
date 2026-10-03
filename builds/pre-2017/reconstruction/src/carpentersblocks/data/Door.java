/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.data;

import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;

public class Door {
    public static final byte TYPE_GLASS_TOP = 0;
    public static final byte TYPE_GLASS_TALL = 1;
    public static final byte TYPE_PANELS = 2;
    public static final byte TYPE_SCREEN_TALL = 3;
    public static final byte TYPE_FRENCH_GLASS = 4;
    public static final byte TYPE_HIDDEN = 5;
    public static final byte FACING_XP = 0;
    public static final byte FACING_ZP = 1;
    public static final byte FACING_XN = 2;
    public static final byte FACING_ZN = 3;
    public static final byte HINGE_LEFT = 0;
    public static final byte HINGE_RIGHT = 1;
    public static final byte STATE_CLOSED = 0;
    public static final byte STATE_OPEN = 1;
    public static final byte PIECE_BOTTOM = 0;
    public static final byte PIECE_TOP = 1;
    public static final byte HINGED_NONRIGID = 0;
    public static final byte HINGED_RIGID = 1;

    public static final int getType(int n) {
        return n & 7;
    }

    public static final void setType(TECarpentersBlock tECarpentersBlock, int n) {
        int n2 = BlockProperties.getData(tECarpentersBlock) & 0xFFF8;
        BlockProperties.setData(tECarpentersBlock, n2 |= n);
    }

    public static final int getHinge(int n) {
        int n2 = n & 8;
        return n2 >> 3;
    }

    public static final void setHingeSide(TECarpentersBlock tECarpentersBlock, int n) {
        int n2 = BlockProperties.getData(tECarpentersBlock) & 0xFFF7;
        BlockProperties.setData(tECarpentersBlock, n2 |= n << 3);
    }

    public static final int getFacing(int n) {
        int n2 = n & 0x30;
        return n2 >> 4;
    }

    public static final void setFacing(TECarpentersBlock tECarpentersBlock, int n) {
        int n2 = BlockProperties.getData(tECarpentersBlock) & 0xFFCF;
        BlockProperties.setData(tECarpentersBlock, n2 |= n << 4);
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

    public static final int getPiece(int n) {
        int n2 = n & 0x80;
        return n2 >> 7;
    }

    public static final void setPiece(TECarpentersBlock tECarpentersBlock, int n) {
        int n2 = BlockProperties.getData(tECarpentersBlock) & 0xFF7F;
        BlockProperties.setData(tECarpentersBlock, n2 |= n << 7);
    }

    public static final int getRigidity(int n) {
        int n2 = n & 0x100;
        return n2 >> 8;
    }

    public static final void setRigidity(TECarpentersBlock tECarpentersBlock, int n) {
        int n2 = BlockProperties.getData(tECarpentersBlock) & 0xFEFF;
        BlockProperties.setData(tECarpentersBlock, n2 |= n << 8);
    }
}

