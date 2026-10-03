/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.owak;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockHalfSlab
extends Block {
    public final boolean _a;

    public BlockHalfSlab(int n, boolean bl, Material material) {
        super(n, material);
        this._a = bl;
        if (bl) {
            BlockHalfSlab.opaqueCubeLookup[n] = true;
        } else {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f);
        }
        this.setLightOpacity(255);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        if (this._a) {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        } else {
            boolean bl;
            boolean bl2 = bl = (iBlockAccess.getBlockMetadata(n, n2, n3) & 8) != 0;
            if (bl) {
                this.setBlockBounds(0.0f, 0.5f, 0.0f, 1.0f, 1.0f, 1.0f);
            } else {
                this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f);
            }
        }
    }

    @Override
    public void setBlockBoundsForItemRender() {
        if (this._a) {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        } else {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f);
        }
    }

    @Override
    public void addCollisionBoxesToList(World world, int n, int n2, int n3, AxisAlignedBB axisAlignedBB, List list, Entity entity) {
        this.setBlockBoundsBasedOnState(world, n, n2, n3);
        super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list, entity);
    }

    @Override
    public boolean isOpaqueCube() {
        return this._a;
    }

    @Override
    public int onBlockPlaced(World world, int n, int n2, int n3, int n4, float f, float f2, float f3, int n5) {
        if (this._a) {
            return n5;
        }
        if (n4 == 0 || n4 != 1 && (double)f2 > 0.5) {
            return n5 | 8;
        }
        return n5;
    }

    @Override
    public int quantityDropped(Random random) {
        if (this._a) {
            return 2;
        }
        return 1;
    }

    @Override
    public int damageDropped(int n) {
        return n & 7;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return this._a;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        boolean bl;
        if (this._a) {
            return super.shouldSideBeRendered(iBlockAccess, n, n2, n3, n4);
        }
        if (n4 != 1 && n4 != 0 && !super.shouldSideBeRendered(iBlockAccess, n, n2, n3, n4)) {
            return false;
        }
        int n5 = n;
        int n6 = n2;
        int n7 = n3;
        boolean bl2 = bl = (iBlockAccess.getBlockMetadata(n5 += owak._b[owak._a[n4]], n6 += owak._c[owak._a[n4]], n7 += owak._d[owak._a[n4]]) & 8) != 0;
        if (bl) {
            if (n4 == 0) {
                return true;
            }
            if (n4 == 1 && super.shouldSideBeRendered(iBlockAccess, n, n2, n3, n4)) {
                return true;
            }
            return !BlockHalfSlab._a(iBlockAccess.getBlockId(n, n2, n3)) || (iBlockAccess.getBlockMetadata(n, n2, n3) & 8) == 0;
        }
        if (n4 == 1) {
            return true;
        }
        if (n4 == 0 && super.shouldSideBeRendered(iBlockAccess, n, n2, n3, n4)) {
            return true;
        }
        return !BlockHalfSlab._a(iBlockAccess.getBlockId(n, n2, n3)) || (iBlockAccess.getBlockMetadata(n, n2, n3) & 8) != 0;
    }

    public static boolean _a(int n) {
        return n == Block.stoneSingleSlab.blockID || n == Block.woodSingleSlab.blockID;
    }

    public abstract String _b(int var1);

    @Override
    public int getDamageValue(World world, int n, int n2, int n3) {
        return super.getDamageValue(world, n, n2, n3) & 7;
    }

    @Override
    public int idPicked(World world, int n, int n2, int n3) {
        if (BlockHalfSlab._a(this.blockID)) {
            return this.blockID;
        }
        if (this.blockID == Block.stoneDoubleSlab.blockID) {
            return Block.stoneSingleSlab.blockID;
        }
        if (this.blockID == Block.woodDoubleSlab.blockID) {
            return Block.woodSingleSlab.blockID;
        }
        return Block.stoneSingleSlab.blockID;
    }
}

