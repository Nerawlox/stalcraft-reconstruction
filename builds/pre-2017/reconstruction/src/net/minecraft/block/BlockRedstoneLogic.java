/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.sajh;
import net.minecraft.util.ugqx;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockRedstoneLogic
extends BlockDirectional {
    public final boolean _a;

    public BlockRedstoneLogic(int n, boolean bl) {
        super(n, Material._q);
        this._a = bl;
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.125f, 1.0f);
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean canPlaceBlockAt(World world, int n, int n2, int n3) {
        if (!world.doesBlockHaveSolidTopSurface(n, n2 - 1, n3)) {
            return false;
        }
        return super.canPlaceBlockAt(world, n, n2, n3);
    }

    @Override
    public boolean canBlockStay(World world, int n, int n2, int n3) {
        if (!world.doesBlockHaveSolidTopSurface(n, n2 - 1, n3)) {
            return false;
        }
        return super.canBlockStay(world, n, n2, n3);
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        int n4 = world.getBlockMetadata(n, n2, n3);
        if (!this._b((IBlockAccess)world, n, n2, n3, n4)) {
            boolean bl = this._b(world, n, n2, n3, n4);
            if (this._a && !bl) {
                world.setBlock(n, n2, n3, this._b().blockID, n4, 2);
            } else if (!this._a) {
                world.setBlock(n, n2, n3, this._a().blockID, n4, 2);
                if (!bl) {
                    world.scheduleBlockUpdateWithPriority(n, n2, n3, this._a().blockID, this._h(n4), -1);
                }
            }
        }
    }

    @Override
    public Icon getIcon(int n, int n2) {
        if (n == 0) {
            if (this._a) {
                return Block.torchRedstoneActive.getBlockTextureFromSide(n);
            }
            return Block.torchRedstoneIdle.getBlockTextureFromSide(n);
        }
        if (n == 1) {
            return this.blockIcon;
        }
        return Block.stoneDoubleSlab.getBlockTextureFromSide(1);
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        return n4 != 0 && n4 != 1;
    }

    @Override
    public int getRenderType() {
        return 36;
    }

    public boolean _b(int n) {
        return this._a;
    }

    @Override
    public int isProvidingStrongPower(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        return this.isProvidingWeakPower(iBlockAccess, n, n2, n3, n4);
    }

    @Override
    public int isProvidingWeakPower(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        int n5 = iBlockAccess.getBlockMetadata(n, n2, n3);
        if (!this._b(n5)) {
            return 0;
        }
        int n6 = BlockRedstoneLogic._d(n5);
        if (n6 == 0 && n4 == 3) {
            return this._a(iBlockAccess, n, n2, n3, n5);
        }
        if (n6 == 1 && n4 == 4) {
            return this._a(iBlockAccess, n, n2, n3, n5);
        }
        if (n6 == 2 && n4 == 2) {
            return this._a(iBlockAccess, n, n2, n3, n5);
        }
        if (n6 == 3 && n4 == 5) {
            return this._a(iBlockAccess, n, n2, n3, n5);
        }
        return 0;
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        if (!this.canBlockStay(world, n, n2, n3)) {
            this.dropBlockAsItem(world, n, n2, n3, world.getBlockMetadata(n, n2, n3), 0);
            world.setBlockToAir(n, n2, n3);
            world.notifyBlocksOfNeighborChange(n + 1, n2, n3, this.blockID);
            world.notifyBlocksOfNeighborChange(n - 1, n2, n3, this.blockID);
            world.notifyBlocksOfNeighborChange(n, n2, n3 + 1, this.blockID);
            world.notifyBlocksOfNeighborChange(n, n2, n3 - 1, this.blockID);
            world.notifyBlocksOfNeighborChange(n, n2 - 1, n3, this.blockID);
            world.notifyBlocksOfNeighborChange(n, n2 + 1, n3, this.blockID);
            return;
        }
        this._d(world, n, n2, n3, n4);
    }

    public void _d(World world, int n, int n2, int n3, int n4) {
        int n5 = world.getBlockMetadata(n, n2, n3);
        if (!this._b((IBlockAccess)world, n, n2, n3, n5)) {
            boolean bl = this._b(world, n, n2, n3, n5);
            if ((this._a && !bl || !this._a && bl) && !world.isBlockTickScheduledThisTick(n, n2, n3, this.blockID)) {
                int n6 = -1;
                if (this._e(world, n, n2, n3, n5)) {
                    n6 = -3;
                } else if (this._a) {
                    n6 = -2;
                }
                world.scheduleBlockUpdateWithPriority(n, n2, n3, this.blockID, this._a(n5), n6);
            }
        }
    }

    public boolean _b(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        return false;
    }

    public boolean _b(World world, int n, int n2, int n3, int n4) {
        return this._c(world, n, n2, n3, n4) > 0;
    }

    public int _c(World world, int n, int n2, int n3, int n4) {
        int n5;
        int n6 = BlockRedstoneLogic._d(n4);
        int n7 = n + ugqx._a[n6];
        int n8 = world.getIndirectPowerLevelTo(n7, n2, n5 = n3 + ugqx._b[n6], ugqx._d[n6]);
        if (n8 >= 15) {
            return n8;
        }
        return Math.max(n8, world.getBlockId(n7, n2, n5) == Block.redstoneWire.blockID ? world.getBlockMetadata(n7, n2, n5) : 0);
    }

    public int _c(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        int n5 = BlockRedstoneLogic._d(n4);
        switch (n5) {
            case 0: 
            case 2: {
                return Math.max(this._d(iBlockAccess, n - 1, n2, n3, 4), this._d(iBlockAccess, n + 1, n2, n3, 5));
            }
            case 1: 
            case 3: {
                return Math.max(this._d(iBlockAccess, n, n2, n3 + 1, 3), this._d(iBlockAccess, n, n2, n3 - 1, 2));
            }
        }
        return 0;
    }

    public int _d(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        int n5 = iBlockAccess.getBlockId(n, n2, n3);
        if (this._e(n5)) {
            if (n5 == Block.redstoneWire.blockID) {
                return iBlockAccess.getBlockMetadata(n, n2, n3);
            }
            return iBlockAccess.isBlockProvidingPowerTo(n, n2, n3, n4);
        }
        return 0;
    }

    @Override
    public boolean canProvidePower() {
        return true;
    }

    @Override
    public void onBlockPlacedBy(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        int n4 = ((sajh._c((double)(entityLivingBase.rotationYaw * 4.0f / 360.0f) + 0.5) & 3) + 2) % 4;
        world.func_72921_c(n, n2, n3, n4, 3);
        boolean bl = this._b(world, n, n2, n3, n4);
        if (bl) {
            world.scheduleBlockUpdate(n, n2, n3, this.blockID, 1);
        }
    }

    @Override
    public void onBlockAdded(World world, int n, int n2, int n3) {
        this._a(world, n, n2, n3);
    }

    public void _a(World world, int n, int n2, int n3) {
        int n4 = BlockRedstoneLogic._d(world.getBlockMetadata(n, n2, n3));
        if (n4 == 1) {
            world.notifyBlockOfNeighborChange(n + 1, n2, n3, this.blockID);
            world.notifyBlocksOfNeighborChange(n + 1, n2, n3, this.blockID, 4);
        }
        if (n4 == 3) {
            world.notifyBlockOfNeighborChange(n - 1, n2, n3, this.blockID);
            world.notifyBlocksOfNeighborChange(n - 1, n2, n3, this.blockID, 5);
        }
        if (n4 == 2) {
            world.notifyBlockOfNeighborChange(n, n2, n3 + 1, this.blockID);
            world.notifyBlocksOfNeighborChange(n, n2, n3 + 1, this.blockID, 2);
        }
        if (n4 == 0) {
            world.notifyBlockOfNeighborChange(n, n2, n3 - 1, this.blockID);
            world.notifyBlocksOfNeighborChange(n, n2, n3 - 1, this.blockID, 3);
        }
    }

    @Override
    public void onBlockDestroyedByPlayer(World world, int n, int n2, int n3, int n4) {
        if (this._a) {
            world.notifyBlocksOfNeighborChange(n + 1, n2, n3, this.blockID);
            world.notifyBlocksOfNeighborChange(n - 1, n2, n3, this.blockID);
            world.notifyBlocksOfNeighborChange(n, n2, n3 + 1, this.blockID);
            world.notifyBlocksOfNeighborChange(n, n2, n3 - 1, this.blockID);
            world.notifyBlocksOfNeighborChange(n, n2 - 1, n3, this.blockID);
            world.notifyBlocksOfNeighborChange(n, n2 + 1, n3, this.blockID);
        }
        super.onBlockDestroyedByPlayer(world, n, n2, n3, n4);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    public boolean _e(int n) {
        Block block = Block.blocksList[n];
        return block != null && block.canProvidePower();
    }

    public int _a(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        return 15;
    }

    public static boolean _f(int n) {
        return Block.redstoneRepeaterIdle._g(n) || Block.redstoneComparatorIdle._g(n);
    }

    public boolean _g(int n) {
        return n == this._a().blockID || n == this._b().blockID;
    }

    public boolean _e(World world, int n, int n2, int n3, int n4) {
        int n5 = BlockRedstoneLogic._d(n4);
        if (BlockRedstoneLogic._f(world.getBlockId(n - ugqx._a[n5], n2, n3 - ugqx._b[n5]))) {
            int n6 = world.getBlockMetadata(n - ugqx._a[n5], n2, n3 - ugqx._b[n5]);
            int n7 = BlockRedstoneLogic._d(n6);
            return n7 != n5;
        }
        return false;
    }

    public int _h(int n) {
        return this._a(n);
    }

    public abstract int _a(int var1);

    public abstract BlockRedstoneLogic _a();

    public abstract BlockRedstoneLogic _b();

    @Override
    public boolean isAssociatedBlockID(int n) {
        return this._g(n);
    }
}

