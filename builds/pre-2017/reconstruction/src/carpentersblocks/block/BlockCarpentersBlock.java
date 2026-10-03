/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.block;

import carpentersblocks.CarpentersBlocks;
import carpentersblocks.block.BlockBase;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;
import carpentersblocks.util.handler.BlockHandler;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockCarpentersBlock
extends BlockBase {
    public BlockCarpentersBlock(int n) {
        super(n, Material._d);
        this.setHardness(0.2f);
        this.setUnlocalizedName("blockCarpentersBlock");
        this.setCreativeTab(CarpentersBlocks.tabCarpentersBlocks);
        this.setTextureName("carpentersblocks:stairs/stairs");
    }

    @Override
    protected boolean onHammerLeftClick(TECarpentersBlock tECarpentersBlock, EntityPlayer entityPlayer) {
        int n = BlockProperties.getData(tECarpentersBlock);
        if (++n > 6) {
            n = 0;
        }
        BlockProperties.setData(tECarpentersBlock, n);
        return true;
    }

    @Override
    protected boolean onHammerRightClick(TECarpentersBlock tECarpentersBlock, EntityPlayer entityPlayer, int n) {
        int n2 = BlockProperties.getData(tECarpentersBlock);
        if (n2 == 0) {
            switch (n) {
                case 0: {
                    n2 = 4;
                    break;
                }
                case 1: {
                    n2 = 3;
                    break;
                }
                case 2: {
                    n2 = 6;
                    break;
                }
                case 3: {
                    n2 = 5;
                    break;
                }
                case 4: {
                    n2 = 2;
                    break;
                }
                case 5: {
                    n2 = 1;
                }
            }
        } else {
            n2 = 0;
        }
        BlockProperties.setData(tECarpentersBlock, n2);
        return true;
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)iBlockAccess.getBlockTileEntity(n, n2, n3);
        int n4 = BlockProperties.getData(tECarpentersBlock);
        switch (n4) {
            case 1: {
                this.setBlockBounds(0.0f, 0.0f, 0.0f, 0.5f, 1.0f, 1.0f);
                break;
            }
            case 2: {
                this.setBlockBounds(0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                break;
            }
            case 3: {
                this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f);
                break;
            }
            case 4: {
                this.setBlockBounds(0.0f, 0.5f, 0.0f, 1.0f, 1.0f, 1.0f);
                break;
            }
            case 5: {
                this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.5f);
                break;
            }
            case 6: {
                this.setBlockBounds(0.0f, 0.0f, 0.5f, 1.0f, 1.0f, 1.0f);
                break;
            }
            default: {
                this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
            }
        }
    }

    @Override
    public void addCollisionBoxesToList(World world, int n, int n2, int n3, AxisAlignedBB axisAlignedBB, List list, Entity entity) {
        this.setBlockBoundsBasedOnState(world, n, n2, n3);
        super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list, entity);
    }

    @Override
    public void auxiliaryOnBlockPlacedBy(TECarpentersBlock tECarpentersBlock, World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        int n4 = 0;
        if (!entityLivingBase.isSneaking()) {
            TECarpentersBlock tECarpentersBlock2;
            TECarpentersBlock tECarpentersBlock3 = world.getBlockId(n, n2 - 1, n3) == this.blockID ? (TECarpentersBlock)world.getBlockTileEntity(n, n2 - 1, n3) : null;
            TECarpentersBlock tECarpentersBlock4 = world.getBlockId(n, n2 + 1, n3) == this.blockID ? (TECarpentersBlock)world.getBlockTileEntity(n, n2 + 1, n3) : null;
            TECarpentersBlock tECarpentersBlock5 = world.getBlockId(n - 1, n2, n3) == this.blockID ? (TECarpentersBlock)world.getBlockTileEntity(n - 1, n2, n3) : null;
            TECarpentersBlock tECarpentersBlock6 = world.getBlockId(n + 1, n2, n3) == this.blockID ? (TECarpentersBlock)world.getBlockTileEntity(n + 1, n2, n3) : null;
            TECarpentersBlock tECarpentersBlock7 = world.getBlockId(n, n2, n3 - 1) == this.blockID ? (TECarpentersBlock)world.getBlockTileEntity(n, n2, n3 - 1) : null;
            TECarpentersBlock tECarpentersBlock8 = tECarpentersBlock2 = world.getBlockId(n, n2, n3 + 1) == this.blockID ? (TECarpentersBlock)world.getBlockTileEntity(n, n2, n3 + 1) : null;
            if (tECarpentersBlock3 != null) {
                n4 = BlockProperties.getData(tECarpentersBlock3);
            } else if (tECarpentersBlock4 != null) {
                n4 = BlockProperties.getData(tECarpentersBlock4);
            } else if (tECarpentersBlock5 != null) {
                n4 = BlockProperties.getData(tECarpentersBlock5);
            } else if (tECarpentersBlock6 != null) {
                n4 = BlockProperties.getData(tECarpentersBlock6);
            } else if (tECarpentersBlock7 != null) {
                n4 = BlockProperties.getData(tECarpentersBlock7);
            } else if (tECarpentersBlock2 != null) {
                n4 = BlockProperties.getData(tECarpentersBlock2);
            }
        }
        BlockProperties.setData(tECarpentersBlock, n4);
    }

    @Override
    public boolean isBlockNormalCube(World world, int n, int n2, int n3) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)world.getBlockTileEntity(n, n2, n3);
        return BlockProperties.getData(tECarpentersBlock) == 0;
    }

    @Override
    public boolean isBlockSolidOnSide(World world, int n, int n2, int n3, ForgeDirection forgeDirection) {
        TECarpentersBlock tECarpentersBlock = TECarpentersBlock.get(world, n, n2, n3);
        if (tECarpentersBlock == null) {
            return false;
        }
        if (this.isBlockSolid(world, n, n2, n3)) {
            int n4 = BlockProperties.getData(tECarpentersBlock);
            if (n4 == 0) {
                return true;
            }
            if (n4 == 3 && forgeDirection == ForgeDirection.DOWN) {
                return true;
            }
            if (n4 == 4 && forgeDirection == ForgeDirection.UP) {
                return true;
            }
            if (n4 == 5 && forgeDirection == ForgeDirection.NORTH) {
                return true;
            }
            if (n4 == 6 && forgeDirection == ForgeDirection.SOUTH) {
                return true;
            }
            if (n4 == 1 && forgeDirection == ForgeDirection.WEST) {
                return true;
            }
            if (n4 == 2 && forgeDirection == ForgeDirection.EAST) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected boolean shareFaces(TECarpentersBlock tECarpentersBlock, TECarpentersBlock tECarpentersBlock2, ForgeDirection forgeDirection, ForgeDirection forgeDirection2) {
        if (tECarpentersBlock.getBlockType() != this) {
            return super.shareFaces(tECarpentersBlock, tECarpentersBlock2, forgeDirection, forgeDirection2);
        }
        Block block = Block.blocksList[tECarpentersBlock2.worldObj.getBlockId(tECarpentersBlock2.xCoord, tECarpentersBlock2.yCoord, tECarpentersBlock2.zCoord)];
        this.setBlockBoundsBasedOnState(tECarpentersBlock2.worldObj, tECarpentersBlock2.xCoord, tECarpentersBlock2.yCoord, tECarpentersBlock2.zCoord);
        double[] dArray = new double[]{block.func_83009_v(), block.getBlockBoundsMinY(), block.getBlockBoundsMinZ(), block.getBlockBoundsMaxX(), block.getBlockBoundsMaxY(), block.getBlockBoundsMaxZ()};
        this.setBlockBoundsBasedOnState(tECarpentersBlock.worldObj, tECarpentersBlock.xCoord, tECarpentersBlock.yCoord, tECarpentersBlock.zCoord);
        switch (NamelessClass446984519.$SwitchMap$net$minecraftforge$common$ForgeDirection[forgeDirection2.ordinal()]) {
            case 1: {
                return this.maxY == 1.0 && dArray[1] == 0.0 && this.minX == dArray[0] && this.maxX == dArray[3] && this.minZ == dArray[2] && this.maxZ == dArray[5];
            }
            case 2: {
                return this.minY == 0.0 && dArray[4] == 1.0 && this.minX == dArray[0] && this.maxX == dArray[3] && this.minZ == dArray[2] && this.maxZ == dArray[5];
            }
            case 3: {
                return this.maxZ == 1.0 && dArray[2] == 0.0 && this.minX == dArray[0] && this.maxX == dArray[3] && this.minY == dArray[1] && this.maxY == dArray[4];
            }
            case 4: {
                return this.minZ == 0.0 && dArray[5] == 1.0 && this.minX == dArray[0] && this.maxX == dArray[3] && this.minY == dArray[1] && this.maxY == dArray[4];
            }
            case 5: {
                return this.maxX == 1.0 && dArray[0] == 0.0 && this.minY == dArray[1] && this.maxY == dArray[4] && this.minZ == dArray[2] && this.maxZ == dArray[5];
            }
            case 6: {
                return this.minX == 0.0 && dArray[3] == 1.0 && this.minY == dArray[1] && this.maxY == dArray[4] && this.minZ == dArray[2] && this.maxZ == dArray[5];
            }
        }
        return false;
    }

    @Override
    public boolean canCoverSide(TECarpentersBlock tECarpentersBlock, World world, int n, int n2, int n3, int n4) {
        return true;
    }

    @Override
    public int getRenderType() {
        return BlockHandler.carpentersBlockRenderID;
    }

    static class NamelessClass446984519 {
        static final int[] $SwitchMap$net$minecraftforge$common$ForgeDirection = new int[ForgeDirection.values().length];

        NamelessClass446984519() {
        }

        static {
            try {
                NamelessClass446984519.$SwitchMap$net$minecraftforge$common$ForgeDirection[ForgeDirection.DOWN.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass446984519.$SwitchMap$net$minecraftforge$common$ForgeDirection[ForgeDirection.UP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass446984519.$SwitchMap$net$minecraftforge$common$ForgeDirection[ForgeDirection.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass446984519.$SwitchMap$net$minecraftforge$common$ForgeDirection[ForgeDirection.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass446984519.$SwitchMap$net$minecraftforge$common$ForgeDirection[ForgeDirection.WEST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass446984519.$SwitchMap$net$minecraftforge$common$ForgeDirection[ForgeDirection.EAST.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
        }
    }
}

