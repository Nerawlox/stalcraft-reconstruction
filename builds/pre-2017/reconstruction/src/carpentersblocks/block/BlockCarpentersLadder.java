/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.block;

import carpentersblocks.CarpentersBlocks;
import carpentersblocks.block.BlockBase;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.handler.BlockHandler;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.sajh;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockCarpentersLadder
extends BlockBase {
    public BlockCarpentersLadder(int n) {
        super(n, Material._d);
        this.setHardness(Block.ladder.blockHardness);
        this.setUnlocalizedName("blockCarpentersLadder");
        this.setCreativeTab(CarpentersBlocks.tabCarpentersBlocks);
        this.setStepSound(Block.soundLadderFootstep);
        this.setTextureName("carpentersblocks:general/generic");
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        float[] fArray;
        iBlockAccess.getBlockTileEntity(n, n2, n3);
        int n4 = iBlockAccess.getBlockMetadata(n, n2, n3);
        switch (n4) {
            case 0: {
                fArray = new float[]{0.0f, 0.0f, 0.375f, 1.0f, 1.0f, 0.625f};
                break;
            }
            default: {
                fArray = new float[]{0.375f, 0.0f, 0.0f, 0.625f, 1.0f, 1.0f};
                break;
            }
            case 2: {
                fArray = new float[]{0.0f, 0.0f, 0.8125f, 1.0f, 1.0f, 1.0f};
                break;
            }
            case 3: {
                fArray = new float[]{0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.1875f};
                break;
            }
            case 4: {
                fArray = new float[]{0.8125f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
                break;
            }
            case 5: {
                fArray = new float[]{0.0f, 0.0f, 0.0f, 0.1875f, 1.0f, 1.0f};
            }
        }
        this.setBlockBounds(fArray[0], fArray[1], fArray[2], fArray[3], fArray[4], fArray[5]);
    }

    @Override
    public void addCollisionBoxesToList(World world, int n, int n2, int n3, AxisAlignedBB axisAlignedBB, List list2, Entity entity) {
        this.setBlockBoundsBasedOnState(world, n, n2, n3);
        super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list2, entity);
    }

    @Override
    public boolean canPlaceBlockOnSide(World world, int n, int n2, int n3, int n4) {
        switch (NamelessClass1349103133.$SwitchMap$net$minecraftforge$common$ForgeDirection[ForgeDirection.getOrientation(n4).ordinal()]) {
            case 1: {
                return world.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.SOUTH);
            }
            case 2: {
                return world.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.NORTH);
            }
            case 3: {
                return world.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.EAST);
            }
            case 4: {
                return world.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.WEST);
            }
        }
        return true;
    }

    @Override
    public int onBlockPlaced(World world, int n, int n2, int n3, int n4, float f, float f2, float f3, int n5) {
        return n4;
    }

    @Override
    public void auxiliaryOnBlockPlacedBy(TECarpentersBlock tECarpentersBlock, World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        if (world.getBlockMetadata(n, n2, n3) < 2) {
            if (world.getBlockId(n, n2 - 1, n3) == this.blockID) {
                world.func_72921_c(n, n2, n3, world.getBlockMetadata(n, n2 - 1, n3), 2);
            } else if (world.getBlockId(n, n2 + 1, n3) == this.blockID) {
                world.func_72921_c(n, n2, n3, world.getBlockMetadata(n, n2 + 1, n3), 2);
            } else {
                int n4 = sajh._c((double)(entityLivingBase.rotationYaw * 4.0f / 360.0f) + 0.5) & 3;
                world.func_72921_c(n, n2, n3, n4 % 2 == 0 ? 0 : 1, 2);
            }
        }
        this.onNeighborBlockChange(world, n, n2, n3, this.blockID);
    }

    @Override
    public void auxiliaryOnNeighborBlockChange(TECarpentersBlock tECarpentersBlock, World world, int n, int n2, int n3, int n4) {
        int n5 = world.getBlockMetadata(n, n2, n3);
        if (n5 > 1 && (n5 == 2 && !world.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH) || n5 == 3 && !world.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH) || n5 == 4 && !world.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST) || n5 == 5 && !world.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST))) {
            world.setBlockToAir(n, n2, n3);
        }
    }

    @Override
    public boolean isLadder(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase) {
        return !(entityLivingBase instanceof EntityPlayer) || ((EntityPlayer)entityLivingBase).capabilities._d;
    }

    @Override
    public int getRenderType() {
        return BlockHandler.carpentersLadderRenderID;
    }

    static class NamelessClass1349103133 {
        static final int[] $SwitchMap$net$minecraftforge$common$ForgeDirection = new int[ForgeDirection.values().length];

        NamelessClass1349103133() {
        }

        static {
            try {
                NamelessClass1349103133.$SwitchMap$net$minecraftforge$common$ForgeDirection[ForgeDirection.NORTH.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass1349103133.$SwitchMap$net$minecraftforge$common$ForgeDirection[ForgeDirection.SOUTH.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass1349103133.$SwitchMap$net$minecraftforge$common$ForgeDirection[ForgeDirection.WEST.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass1349103133.$SwitchMap$net$minecraftforge$common$ForgeDirection[ForgeDirection.EAST.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
        }
    }
}

