/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.util;

import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.handler.OverlayHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.BlockQuartz;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockProperties {
    private static boolean suppressUpdate = false;

    private static void ejectEntity(TECarpentersBlock tECarpentersBlock, ItemStack itemStack) {
    }

    public static boolean blockRotates(World world, Block block, int n, int n2, int n3) {
        return block.isWood(world, n, n2, n3) || block instanceof BlockQuartz;
    }

    public static int unsignedToBytes(byte by) {
        return by & 0xFF;
    }

    public static void playBlockPlacementSound(TECarpentersBlock tECarpentersBlock, int n) {
        BlockProperties.playBlockPlacementSound(tECarpentersBlock.worldObj, tECarpentersBlock.xCoord, tECarpentersBlock.yCoord, tECarpentersBlock.zCoord, n);
    }

    public static void playBlockPlacementSound(World world, int n, int n2, int n3, int n4) {
        if (!world.isRemote && n4 > 0) {
            Block block = Block.blocksList[n4];
            world.playSoundEffect((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, block.stepSound._e(), block.stepSound._a() + 0.5f, block.stepSound._b() * 0.8f);
        }
    }

    public static void clearAttributes(TECarpentersBlock tECarpentersBlock, int n) {
        suppressUpdate = true;
        BlockProperties.setDyeColor(tECarpentersBlock, n, 0);
        BlockProperties.setOverlay(tECarpentersBlock, n, null);
        BlockProperties.setCover(tECarpentersBlock, n, 0, null);
        BlockProperties.setPattern(tECarpentersBlock, n, 0);
        suppressUpdate = false;
        tECarpentersBlock.worldObj.markBlockForUpdate(tECarpentersBlock.xCoord, tECarpentersBlock.yCoord, tECarpentersBlock.zCoord);
    }

    public static int getCoverID(TECarpentersBlock tECarpentersBlock, int n) {
        return tECarpentersBlock.cover[n] & 0xFFF;
    }

    public static int getCoverMetadata(TECarpentersBlock tECarpentersBlock, int n) {
        return (tECarpentersBlock.cover[n] & 0xF000) >>> 12;
    }

    public static boolean hasCover(TECarpentersBlock tECarpentersBlock, int n) {
        int n2 = BlockProperties.getCoverID(tECarpentersBlock, n);
        int n3 = BlockProperties.getCoverMetadata(tECarpentersBlock, n);
        return n2 > 0 && Block.blocksList[n2] != null && BlockProperties.isCover(Item.itemsList[n2], n3);
    }

    public static boolean hasSideCovers(TECarpentersBlock tECarpentersBlock) {
        for (int i = 0; i < 6; ++i) {
            if (!BlockProperties.hasCover(tECarpentersBlock, i)) continue;
            return true;
        }
        return false;
    }

    public static Block getCoverBlock(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)iBlockAccess.getBlockTileEntity(n2, n3, n4);
        return BlockProperties.getCoverBlock(tECarpentersBlock, n);
    }

    public static Block getCoverBlock(TECarpentersBlock tECarpentersBlock, int n) {
        Block block = BlockProperties.hasCover(tECarpentersBlock, n) ? Block.blocksList[BlockProperties.getCoverID(tECarpentersBlock, n)] : Block.blocksList[tECarpentersBlock.worldObj.getBlockId(tECarpentersBlock.xCoord, tECarpentersBlock.yCoord, tECarpentersBlock.zCoord)];
        return block;
    }

    public static boolean isCover(Item item, int n) {
        if (item instanceof ItemBlock && !BlockProperties.isOverlay(item.itemID)) {
            Block block = Block.blocksList[item.itemID];
            return !block.hasTileEntity(n) && (block.renderAsNormalBlock() || block instanceof yufe || block instanceof BlockHalfSlab || block instanceof zxyg || block instanceof dgwv);
        }
        return false;
    }

    public static boolean setCover(TECarpentersBlock tECarpentersBlock, int n, int n2, ItemStack itemStack) {
        int n3;
        if (BlockProperties.hasCover(tECarpentersBlock, n)) {
            BlockProperties.ejectEntity(tECarpentersBlock, new ItemStack(BlockProperties.getCoverID(tECarpentersBlock, n), 1, BlockProperties.getCoverMetadata(tECarpentersBlock, n)));
        }
        int n4 = n3 = itemStack == null ? 0 : itemStack._d;
        if (itemStack != null) {
            BlockProperties.playBlockPlacementSound(tECarpentersBlock, n3);
        }
        tECarpentersBlock.cover[n] = (short)(n3 + (n2 << 12));
        tECarpentersBlock.worldObj.notifyBlocksOfNeighborChange(tECarpentersBlock.xCoord, tECarpentersBlock.yCoord, tECarpentersBlock.zCoord, n3);
        tECarpentersBlock.worldObj.markBlockForUpdate(tECarpentersBlock.xCoord, tECarpentersBlock.yCoord, tECarpentersBlock.zCoord);
        return true;
    }

    public static final int getData(TECarpentersBlock tECarpentersBlock) {
        return tECarpentersBlock.data;
    }

    public static void setData(TECarpentersBlock tECarpentersBlock, int n) {
        if (n != BlockProperties.getData(tECarpentersBlock)) {
            tECarpentersBlock.data = (short)n;
            if (!suppressUpdate) {
                tECarpentersBlock.worldObj.markBlockForUpdate(tECarpentersBlock.xCoord, tECarpentersBlock.yCoord, tECarpentersBlock.zCoord);
            }
        }
    }

    public static boolean hasDyeColor(TECarpentersBlock tECarpentersBlock, int n) {
        return tECarpentersBlock.color[n] > 0;
    }

    public static boolean setDyeColor(TECarpentersBlock tECarpentersBlock, int n, int n2) {
        if (tECarpentersBlock.color[n] > 0) {
            BlockProperties.ejectEntity(tECarpentersBlock, new ItemStack(Item.dyePowder, 1, 15 - tECarpentersBlock.color[n]));
        }
        tECarpentersBlock.color[n] = (byte)n2;
        if (!suppressUpdate) {
            tECarpentersBlock.worldObj.markBlockForUpdate(tECarpentersBlock.xCoord, tECarpentersBlock.yCoord, tECarpentersBlock.zCoord);
        }
        return true;
    }

    public static int getDyeColor(TECarpentersBlock tECarpentersBlock, int n) {
        return tECarpentersBlock.color[n];
    }

    public static boolean setOverlay(TECarpentersBlock tECarpentersBlock, int n, ItemStack itemStack) {
        if (BlockProperties.hasOverlay(tECarpentersBlock, n)) {
            BlockProperties.ejectEntity(tECarpentersBlock, OverlayHandler.getItemStack(tECarpentersBlock.overlay[n]));
        }
        tECarpentersBlock.overlay[n] = (byte)OverlayHandler.getKey(itemStack);
        if (!suppressUpdate) {
            tECarpentersBlock.worldObj.markBlockForUpdate(tECarpentersBlock.xCoord, tECarpentersBlock.yCoord, tECarpentersBlock.zCoord);
        }
        return true;
    }

    public static int getOverlay(TECarpentersBlock tECarpentersBlock, int n) {
        return tECarpentersBlock.overlay[n];
    }

    public static boolean hasOverlay(TECarpentersBlock tECarpentersBlock, int n) {
        return tECarpentersBlock.overlay[n] > 0;
    }

    public static boolean isOverlay(int n) {
        return OverlayHandler.reverseOverlayMap._c(n);
    }

    public static boolean hasPattern(TECarpentersBlock tECarpentersBlock, int n) {
        return BlockProperties.getPattern(tECarpentersBlock, n) > 0;
    }

    public static int getPattern(TECarpentersBlock tECarpentersBlock, int n) {
        return BlockProperties.unsignedToBytes(tECarpentersBlock.pattern[n]);
    }

    public static boolean setPattern(TECarpentersBlock tECarpentersBlock, int n, int n2) {
        tECarpentersBlock.pattern[n] = (byte)n2;
        if (!suppressUpdate) {
            tECarpentersBlock.worldObj.markBlockForUpdate(tECarpentersBlock.xCoord, tECarpentersBlock.yCoord, tECarpentersBlock.zCoord);
        }
        return true;
    }

    public static boolean shouldRenderSharedFaceBasedOnCovers(TECarpentersBlock tECarpentersBlock, TECarpentersBlock tECarpentersBlock2) {
        Block block = BlockProperties.getCoverBlock(tECarpentersBlock, 6);
        Block block2 = BlockProperties.getCoverBlock(tECarpentersBlock2, 6);
        return !BlockProperties.hasCover(tECarpentersBlock, 6) ? BlockProperties.hasCover(tECarpentersBlock2, 6) : (!BlockProperties.hasCover(tECarpentersBlock2, 6) && block.getRenderBlockPass() == 0 ? !block.isOpaqueCube() : !BlockProperties.hasCover(tECarpentersBlock2, 6) || block2.isOpaqueCube() != block.isOpaqueCube() || block2.getRenderBlockPass() != block.getRenderBlockPass());
    }
}

