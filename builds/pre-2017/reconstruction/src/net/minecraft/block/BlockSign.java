/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSign
extends BlockContainer {
    public Class _a;
    public boolean _b;

    public BlockSign(int n, Class clazz, boolean bl) {
        super(n, Material._d);
        this._b = bl;
        this._a = clazz;
        float f = 0.25f;
        float f2 = 1.0f;
        this.setBlockBounds(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, f2, 0.5f + f);
    }

    @Override
    public Icon getIcon(int n, int n2) {
        return Block.planks.getBlockTextureFromSide(n);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        return null;
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int n, int n2, int n3) {
        this.setBlockBoundsBasedOnState(world, n, n2, n3);
        return super.getSelectedBoundingBoxFromPool(world, n, n2, n3);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        if (this._b) {
            return;
        }
        int n4 = iBlockAccess.getBlockMetadata(n, n2, n3);
        float f = 0.28125f;
        float f2 = 0.78125f;
        float f3 = 0.0f;
        float f4 = 1.0f;
        float f5 = 0.125f;
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        if (n4 == 2) {
            this.setBlockBounds(f3, f, 1.0f - f5, f4, f2, 1.0f);
        }
        if (n4 == 3) {
            this.setBlockBounds(f3, f, 0.0f, f4, f2, f5);
        }
        if (n4 == 4) {
            this.setBlockBounds(1.0f - f5, f, f3, 1.0f, f2, f4);
        }
        if (n4 == 5) {
            this.setBlockBounds(0.0f, f, f3, f5, f2, f4);
        }
    }

    @Override
    public int getRenderType() {
        return -1;
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
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        try {
            return (TileEntity)this._a.newInstance();
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return Item.sign.itemID;
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        boolean bl = false;
        if (this._b) {
            if (!world.getBlockMaterial(n, n2 - 1, n3)._a()) {
                bl = true;
            }
        } else {
            int n5 = world.getBlockMetadata(n, n2, n3);
            bl = true;
            if (n5 == 2 && world.getBlockMaterial(n, n2, n3 + 1)._a()) {
                bl = false;
            }
            if (n5 == 3 && world.getBlockMaterial(n, n2, n3 - 1)._a()) {
                bl = false;
            }
            if (n5 == 4 && world.getBlockMaterial(n + 1, n2, n3)._a()) {
                bl = false;
            }
            if (n5 == 5 && world.getBlockMaterial(n - 1, n2, n3)._a()) {
                bl = false;
            }
        }
        if (bl) {
            this.dropBlockAsItem(world, n, n2, n3, world.getBlockMetadata(n, n2, n3), 0);
            world.setBlockToAir(n, n2, n3);
        }
        super.onNeighborBlockChange(world, n, n2, n3, n4);
    }

    @Override
    public int idPicked(World world, int n, int n2, int n3) {
        return Item.sign.itemID;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
    }
}

