/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.sajh;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFenceGate
extends BlockDirectional {
    public BlockFenceGate(int n) {
        super(n, Material._d);
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }

    @Override
    public Icon getIcon(int n, int n2) {
        return Block.planks.getBlockTextureFromSide(n);
    }

    @Override
    public boolean canPlaceBlockAt(World world, int n, int n2, int n3) {
        if (!world.getBlockMaterial(n, n2 - 1, n3)._a()) {
            return false;
        }
        return super.canPlaceBlockAt(world, n, n2, n3);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        int n4 = world.getBlockMetadata(n, n2, n3);
        if (BlockFenceGate._a(n4)) {
            return null;
        }
        if (n4 == 2 || n4 == 0) {
            return AxisAlignedBB._a()._a(n, n2, (float)n3 + 0.375f, n + 1, (float)n2 + 1.5f, (float)n3 + 0.625f);
        }
        return AxisAlignedBB._a()._a((float)n + 0.375f, n2, n3, (float)n + 0.625f, (float)n2 + 1.5f, n3 + 1);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        int n4 = BlockFenceGate._d(iBlockAccess.getBlockMetadata(n, n2, n3));
        if (n4 == 2 || n4 == 0) {
            this.setBlockBounds(0.0f, 0.0f, 0.375f, 1.0f, 1.0f, 0.625f);
        } else {
            this.setBlockBounds(0.375f, 0.0f, 0.0f, 0.625f, 1.0f, 1.0f);
        }
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean getBlocksMovement(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        return BlockFenceGate._a(iBlockAccess.getBlockMetadata(n, n2, n3));
    }

    @Override
    public int getRenderType() {
        return 21;
    }

    @Override
    public void onBlockPlacedBy(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        int n4 = (sajh._c((double)(entityLivingBase.rotationYaw * 4.0f / 360.0f) + 0.5) & 3) % 4;
        world.func_72921_c(n, n2, n3, n4, 2);
    }

    @Override
    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        int n5 = world.getBlockMetadata(n, n2, n3);
        if (BlockFenceGate._a(n5)) {
            world.func_72921_c(n, n2, n3, n5 & 0xFFFFFFFB, 2);
        } else {
            int n6 = (sajh._c((double)(entityPlayer.rotationYaw * 4.0f / 360.0f) + 0.5) & 3) % 4;
            int n7 = BlockFenceGate._d(n5);
            if (n7 == (n6 + 2) % 4) {
                n5 = n6;
            }
            world.func_72921_c(n, n2, n3, n5 | 4, 2);
        }
        world.playAuxSFXAtEntity(entityPlayer, 1003, n, n2, n3, 0);
        return true;
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        if (world.isRemote) {
            return;
        }
        int n5 = world.getBlockMetadata(n, n2, n3);
        boolean bl = world.isBlockIndirectlyGettingPowered(n, n2, n3);
        if (bl || n4 > 0 && Block.blocksList[n4].canProvidePower()) {
            if (bl && !BlockFenceGate._a(n5)) {
                world.func_72921_c(n, n2, n3, n5 | 4, 2);
                world.playAuxSFXAtEntity(null, 1003, n, n2, n3, 0);
            } else if (!bl && BlockFenceGate._a(n5)) {
                world.func_72921_c(n, n2, n3, n5 & 0xFFFFFFFB, 2);
                world.playAuxSFXAtEntity(null, 1003, n, n2, n3, 0);
            }
        }
    }

    public static boolean _a(int n) {
        return (n & 4) != 0;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        return true;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
    }
}

