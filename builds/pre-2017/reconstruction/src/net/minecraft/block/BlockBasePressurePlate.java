/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockBasePressurePlate
extends Block {
    public String _a;

    public BlockBasePressurePlate(int n, String string, Material material) {
        super(n, material);
        this._a = string;
        this.setCreativeTab(CreativeTabs.tabRedstone);
        this.setTickRandomly(true);
        this._a(this._c(15));
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        this._a(iBlockAccess.getBlockMetadata(n, n2, n3));
    }

    public void _a(int n) {
        boolean bl = this._b(n) > 0;
        float f = 0.0625f;
        if (bl) {
            this.setBlockBounds(f, 0.0f, f, 1.0f - f, 0.03125f, 1.0f - f);
        } else {
            this.setBlockBounds(f, 0.0f, f, 1.0f - f, 0.0625f, 1.0f - f);
        }
    }

    @Override
    public int tickRate(World world) {
        return 20;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        return null;
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
        return true;
    }

    @Override
    public boolean canPlaceBlockAt(World world, int n, int n2, int n3) {
        return world.doesBlockHaveSolidTopSurface(n, n2 - 1, n3) || BlockFence._a(world.getBlockId(n, n2 - 1, n3));
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        boolean bl = false;
        if (!world.doesBlockHaveSolidTopSurface(n, n2 - 1, n3) && !BlockFence._a(world.getBlockId(n, n2 - 1, n3))) {
            bl = true;
        }
        if (bl) {
            this.dropBlockAsItem(world, n, n2, n3, world.getBlockMetadata(n, n2, n3), 0);
            world.setBlockToAir(n, n2, n3);
        }
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        if (world.isRemote) {
            return;
        }
        int n4 = this._b(world.getBlockMetadata(n, n2, n3));
        if (n4 > 0) {
            this._a(world, n, n2, n3, n4);
        }
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int n, int n2, int n3, Entity entity) {
        if (world.isRemote) {
            return;
        }
        int n4 = this._b(world.getBlockMetadata(n, n2, n3));
        if (n4 == 0) {
            this._a(world, n, n2, n3, n4);
        }
    }

    public void _a(World world, int n, int n2, int n3, int n4) {
        boolean bl;
        int n5 = this._b(world, n, n2, n3);
        boolean bl2 = n4 > 0;
        boolean bl3 = bl = n5 > 0;
        if (n4 != n5) {
            world.func_72921_c(n, n2, n3, this._c(n5), 2);
            this._a(world, n, n2, n3);
            world.markBlockRangeForRenderUpdate(n, n2, n3, n, n2, n3);
        }
        if (!bl && bl2) {
            world.playSoundEffect((double)n + 0.5, (double)n2 + 0.1, (double)n3 + 0.5, "random.click", 0.3f, 0.5f);
        } else if (bl && !bl2) {
            world.playSoundEffect((double)n + 0.5, (double)n2 + 0.1, (double)n3 + 0.5, "random.click", 0.3f, 0.6f);
        }
        if (bl) {
            world.scheduleBlockUpdate(n, n2, n3, this.blockID, this.tickRate(world));
        }
    }

    public AxisAlignedBB _a(int n, int n2, int n3) {
        float f = 0.125f;
        return AxisAlignedBB._a()._a((float)n + f, n2, (float)n3 + f, (float)(n + 1) - f, (double)n2 + 0.25, (float)(n3 + 1) - f);
    }

    @Override
    public void breakBlock(World world, int n, int n2, int n3, int n4, int n5) {
        if (this._b(n5) > 0) {
            this._a(world, n, n2, n3);
        }
        super.breakBlock(world, n, n2, n3, n4, n5);
    }

    public void _a(World world, int n, int n2, int n3) {
        world.notifyBlocksOfNeighborChange(n, n2, n3, this.blockID);
        world.notifyBlocksOfNeighborChange(n, n2 - 1, n3, this.blockID);
    }

    @Override
    public int isProvidingWeakPower(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        return this._b(iBlockAccess.getBlockMetadata(n, n2, n3));
    }

    @Override
    public int isProvidingStrongPower(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        if (n4 == 1) {
            return this._b(iBlockAccess.getBlockMetadata(n, n2, n3));
        }
        return 0;
    }

    @Override
    public boolean canProvidePower() {
        return true;
    }

    @Override
    public void setBlockBoundsForItemRender() {
        float f = 0.5f;
        float f2 = 0.125f;
        float f3 = 0.5f;
        this.setBlockBounds(0.5f - f, 0.5f - f2, 0.5f - f3, 0.5f + f, 0.5f + f2, 0.5f + f3);
    }

    @Override
    public int getMobilityFlag() {
        return 1;
    }

    public abstract int _b(World var1, int var2, int var3, int var4);

    public abstract int _b(int var1);

    public abstract int _c(int var1);

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister._b(this._a);
    }
}

