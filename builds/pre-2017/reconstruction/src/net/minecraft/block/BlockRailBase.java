/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockRailBase
extends Block {
    public final boolean _b;
    public int _c = 9;

    public static final boolean _a(World world, int n, int n2, int n3) {
        return BlockRailBase._a(world.getBlockId(n, n2, n3));
    }

    public static final boolean _a(int n) {
        return Block.blocksList[n] instanceof BlockRailBase;
    }

    public BlockRailBase(int n, boolean bl) {
        super(n, Material._q);
        this._b = bl;
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.125f, 1.0f);
        this.setCreativeTab(CreativeTabs.tabTransport);
    }

    public boolean _a() {
        return this._b;
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
    public MovingObjectPosition collisionRayTrace(World world, int n, int n2, int n3, Vec3 vec3, Vec3 vec32) {
        this.setBlockBoundsBasedOnState(world, n, n2, n3);
        return super.collisionRayTrace(world, n, n2, n3, vec3, vec32);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        int n4 = iBlockAccess.getBlockMetadata(n, n2, n3);
        if (n4 >= 2 && n4 <= 5) {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.625f, 1.0f);
        } else {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.125f, 1.0f);
        }
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public int getRenderType() {
        return this._c;
    }

    @Override
    public int quantityDropped(Random random) {
        return 1;
    }

    @Override
    public boolean canPlaceBlockAt(World world, int n, int n2, int n3) {
        return world.doesBlockHaveSolidTopSurface(n, n2 - 1, n3);
    }

    @Override
    public void onBlockAdded(World world, int n, int n2, int n3) {
        if (!world.isRemote) {
            this._a(world, n, n2, n3, true);
            if (this._b) {
                this.onNeighborBlockChange(world, n, n2, n3, this.blockID);
            }
        }
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        if (!world.isRemote) {
            int n5;
            int n6 = n5 = world.getBlockMetadata(n, n2, n3);
            if (this._b) {
                n6 = n5 & 7;
            }
            boolean bl = false;
            if (!world.doesBlockHaveSolidTopSurface(n, n2 - 1, n3)) {
                bl = true;
            }
            if (n6 == 2 && !world.doesBlockHaveSolidTopSurface(n + 1, n2, n3)) {
                bl = true;
            }
            if (n6 == 3 && !world.doesBlockHaveSolidTopSurface(n - 1, n2, n3)) {
                bl = true;
            }
            if (n6 == 4 && !world.doesBlockHaveSolidTopSurface(n, n2, n3 - 1)) {
                bl = true;
            }
            if (n6 == 5 && !world.doesBlockHaveSolidTopSurface(n, n2, n3 + 1)) {
                bl = true;
            }
            if (bl) {
                this.dropBlockAsItem(world, n, n2, n3, world.getBlockMetadata(n, n2, n3), 0);
                world.setBlockToAir(n, n2, n3);
            } else {
                this._a(world, n, n2, n3, n5, n6, n4);
            }
        }
    }

    public void _a(World world, int n, int n2, int n3, int n4, int n5, int n6) {
    }

    public void _a(World world, int n, int n2, int n3, boolean bl) {
        if (!world.isRemote) {
            new hcdc(this, world, n, n2, n3)._a(world.isBlockIndirectlyGettingPowered(n, n2, n3), bl);
        }
    }

    @Override
    public int getMobilityFlag() {
        return 0;
    }

    @Override
    public void breakBlock(World world, int n, int n2, int n3, int n4, int n5) {
        int n6 = n5;
        if (this._b) {
            n6 = n5 & 7;
        }
        super.breakBlock(world, n, n2, n3, n4, n5);
        if (n6 == 2 || n6 == 3 || n6 == 4 || n6 == 5) {
            world.notifyBlocksOfNeighborChange(n, n2 + 1, n3, n4);
        }
        if (this._b) {
            world.notifyBlocksOfNeighborChange(n, n2, n3, n4);
            world.notifyBlocksOfNeighborChange(n, n2 - 1, n3, n4);
        }
    }

    public boolean _b(World world, int n, int n2, int n3) {
        return !this._b;
    }

    public boolean _c(World world, int n, int n2, int n3) {
        return true;
    }

    public int _a(IBlockAccess iBlockAccess, EntityMinecart entityMinecart, int n, int n2, int n3) {
        int n4 = iBlockAccess.getBlockMetadata(n, n2, n3);
        if (this._b) {
            n4 &= 7;
        }
        return n4;
    }

    public float _a(World world, EntityMinecart entityMinecart, int n, int n2, int n3) {
        return 0.4f;
    }

    public void _b(World world, EntityMinecart entityMinecart, int n, int n2, int n3) {
    }

    public void _b(int n) {
        this._c = n;
    }
}

