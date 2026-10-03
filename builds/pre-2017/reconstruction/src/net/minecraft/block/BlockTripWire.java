/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ugqx;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTripWire
extends Block {
    public BlockTripWire(int n) {
        super(n, Material._q);
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.15625f, 1.0f);
        this.setTickRandomly(true);
    }

    @Override
    public int tickRate(World world) {
        return 10;
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
    public int getRenderBlockPass() {
        return 1;
    }

    @Override
    public int getRenderType() {
        return 30;
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return Item.silk.itemID;
    }

    @Override
    public int idPicked(World world, int n, int n2, int n3) {
        return Item.silk.itemID;
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        boolean bl;
        int n5 = world.getBlockMetadata(n, n2, n3);
        boolean bl2 = (n5 & 2) == 2;
        boolean bl3 = bl = !world.doesBlockHaveSolidTopSurface(n, n2 - 1, n3);
        if (bl2 != bl) {
            this.dropBlockAsItem(world, n, n2, n3, n5, 0);
            world.setBlockToAir(n, n2, n3);
        }
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        boolean bl;
        int n4 = iBlockAccess.getBlockMetadata(n, n2, n3);
        boolean bl2 = (n4 & 4) == 4;
        boolean bl3 = bl = (n4 & 2) == 2;
        if (!bl) {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.09375f, 1.0f);
        } else if (!bl2) {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f);
        } else {
            this.setBlockBounds(0.0f, 0.0625f, 0.0f, 1.0f, 0.15625f, 1.0f);
        }
    }

    @Override
    public void onBlockAdded(World world, int n, int n2, int n3) {
        int n4 = world.doesBlockHaveSolidTopSurface(n, n2 - 1, n3) ? 0 : 2;
        world.func_72921_c(n, n2, n3, n4, 3);
        this._a(world, n, n2, n3, n4);
    }

    @Override
    public void breakBlock(World world, int n, int n2, int n3, int n4, int n5) {
        this._a(world, n, n2, n3, n5 | 1);
    }

    @Override
    public void onBlockHarvested(World world, int n, int n2, int n3, int n4, EntityPlayer entityPlayer) {
        if (world.isRemote) {
            return;
        }
        if (entityPlayer.getCurrentEquippedItem() != null && entityPlayer.getCurrentEquippedItem()._d == Item.shears.itemID) {
            world.func_72921_c(n, n2, n3, n4 | 8, 4);
        }
    }

    public void _a(World world, int n, int n2, int n3, int n4) {
        block0: for (int i = 0; i < 2; ++i) {
            for (int j = 1; j < 42; ++j) {
                int n5 = n + ugqx._a[i] * j;
                int n6 = n3 + ugqx._b[i] * j;
                int n7 = world.getBlockId(n5, n2, n6);
                if (n7 == Block.tripWireSource.blockID) {
                    int n8 = world.getBlockMetadata(n5, n2, n6) & 3;
                    if (n8 != ugqx._f[i]) continue block0;
                    Block.tripWireSource._a(world, n5, n2, n6, n7, world.getBlockMetadata(n5, n2, n6), true, j, n4);
                    continue block0;
                }
                if (n7 != Block.tripWire.blockID) continue block0;
            }
        }
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int n, int n2, int n3, Entity entity) {
        if (world.isRemote) {
            return;
        }
        if ((world.getBlockMetadata(n, n2, n3) & 1) == 1) {
            return;
        }
        this._a(world, n, n2, n3);
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        if (world.isRemote) {
            return;
        }
        if ((world.getBlockMetadata(n, n2, n3) & 1) != 1) {
            return;
        }
        this._a(world, n, n2, n3);
    }

    public void _a(World world, int n, int n2, int n3) {
        int n4 = world.getBlockMetadata(n, n2, n3);
        boolean bl = (n4 & 1) == 1;
        boolean bl2 = false;
        List list = world.getEntitiesWithinAABBExcludingEntity(null, AxisAlignedBB._a()._a((double)n + this.minX, (double)n2 + this.minY, (double)n3 + this.minZ, (double)n + this.maxX, (double)n2 + this.maxY, (double)n3 + this.maxZ));
        if (!list.isEmpty()) {
            for (Entity entity : list) {
                if (entity.doesEntityNotTriggerPressurePlate()) continue;
                bl2 = true;
                break;
            }
        }
        if (bl2 && !bl) {
            n4 |= 1;
        }
        if (!bl2 && bl) {
            n4 &= 0xFFFFFFFE;
        }
        if (bl2 != bl) {
            world.func_72921_c(n, n2, n3, n4, 3);
            this._a(world, n, n2, n3, n4);
        }
        if (bl2) {
            world.scheduleBlockUpdate(n, n2, n3, this.blockID, this.tickRate(world));
        }
    }

    public static boolean _a(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4, int n5) {
        boolean bl;
        int n6 = n + ugqx._a[n5];
        int n7 = n2;
        int n8 = n3 + ugqx._b[n5];
        int n9 = iBlockAccess.getBlockId(n6, n7, n8);
        boolean bl2 = bl = (n4 & 2) == 2;
        if (n9 == Block.tripWireSource.blockID) {
            int n10 = iBlockAccess.getBlockMetadata(n6, n7, n8);
            int n11 = n10 & 3;
            return n11 == ugqx._f[n5];
        }
        if (n9 == Block.tripWire.blockID) {
            int n12 = iBlockAccess.getBlockMetadata(n6, n7, n8);
            boolean bl3 = (n12 & 2) == 2;
            return bl == bl3;
        }
        return false;
    }
}

