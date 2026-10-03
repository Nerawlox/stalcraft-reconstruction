/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.data;

import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;
import carpentersblocks.util.handler.BlockHandler;
import net.minecraft.block.BlockBed;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.ForgeDirection;

public class Bed {
    public static final byte TYPE_NORMAL = 0;

    public static final int getType(int n) {
        return n & 0xF;
    }

    public static final void setType(TECarpentersBlock tECarpentersBlock, int n) {
        int n2 = BlockProperties.getData(tECarpentersBlock) & 0xFFF0;
        BlockProperties.setData(tECarpentersBlock, n2 |= n);
    }

    public static final int getDesign(int n) {
        int n2 = n & 0x1FE0;
        return n2 >> 5;
    }

    public static final void setDesign(TECarpentersBlock tECarpentersBlock, int n) {
        int n2 = BlockProperties.getData(tECarpentersBlock) & 0xE01F;
        BlockProperties.setData(tECarpentersBlock, n2 |= n << 5);
    }

    public static final boolean isOccupied(TECarpentersBlock tECarpentersBlock) {
        int n = BlockProperties.getData(tECarpentersBlock) & 0x10;
        return n != 0;
    }

    public static final void setOccupied(TECarpentersBlock tECarpentersBlock, boolean bl) {
        int n = BlockProperties.getData(tECarpentersBlock) & 0xFFEF;
        if (bl) {
            n |= 0x10;
        }
        BlockProperties.setData(tECarpentersBlock, n);
    }

    public static final ForgeDirection getDirection(int n) {
        switch (n) {
            case 0: {
                return ForgeDirection.NORTH;
            }
            case 1: {
                return ForgeDirection.EAST;
            }
            case 2: {
                return ForgeDirection.SOUTH;
            }
        }
        return ForgeDirection.WEST;
    }

    public static final TECarpentersBlock getOppositeTE(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        int n4 = iBlockAccess.getBlockMetadata(n, n2, n3);
        ForgeDirection forgeDirection = Bed.getDirection(n4 & 3);
        if (BlockBed._a(n4)) {
            n += forgeDirection.offsetX;
            n3 += forgeDirection.offsetZ;
        } else {
            n -= forgeDirection.offsetX;
            n3 -= forgeDirection.offsetZ;
        }
        return iBlockAccess.getBlockId(n, n2, n3) == BlockHandler.blockCarpentersBedID ? (TECarpentersBlock)iBlockAccess.getBlockTileEntity(n, n2, n3) : null;
    }
}

