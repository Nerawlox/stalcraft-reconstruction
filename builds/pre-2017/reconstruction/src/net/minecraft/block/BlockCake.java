/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCake
extends Block {
    public Icon _a;
    public Icon _b;
    public Icon _c;

    public BlockCake(int n) {
        super(n, Material._E);
        this.setTickRandomly(true);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        int n4 = iBlockAccess.getBlockMetadata(n, n2, n3);
        float f = 0.0625f;
        float f2 = (float)(1 + n4 * 2) / 16.0f;
        float f3 = 0.5f;
        this.setBlockBounds(f2, 0.0f, f, 1.0f - f, f3, 1.0f - f);
    }

    @Override
    public void setBlockBoundsForItemRender() {
        float f = 0.0625f;
        float f2 = 0.5f;
        this.setBlockBounds(f, 0.0f, f, 1.0f - f, f2, 1.0f - f);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        int n4 = world.getBlockMetadata(n, n2, n3);
        float f = 0.0625f;
        float f2 = (float)(1 + n4 * 2) / 16.0f;
        float f3 = 0.5f;
        return AxisAlignedBB._a()._a((float)n + f2, n2, (float)n3 + f, (float)(n + 1) - f, (float)n2 + f3 - f, (float)(n3 + 1) - f);
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int n, int n2, int n3) {
        int n4 = world.getBlockMetadata(n, n2, n3);
        float f = 0.0625f;
        float f2 = (float)(1 + n4 * 2) / 16.0f;
        float f3 = 0.5f;
        return AxisAlignedBB._a()._a((float)n + f2, n2, (float)n3 + f, (float)(n + 1) - f, (float)n2 + f3, (float)(n3 + 1) - f);
    }

    @Override
    public Icon getIcon(int n, int n2) {
        if (n == 1) {
            return this._a;
        }
        if (n == 0) {
            return this._b;
        }
        if (n2 > 0 && n == 4) {
            return this._c;
        }
        return this.blockIcon;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister._b(this.getTextureName() + "_side");
        this._c = iconRegister._b(this.getTextureName() + "_inner");
        this._a = iconRegister._b(this.getTextureName() + "_top");
        this._b = iconRegister._b(this.getTextureName() + "_bottom");
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        this._a(world, n, n2, n3, entityPlayer);
        return true;
    }

    @Override
    public void onBlockClicked(World world, int n, int n2, int n3, EntityPlayer entityPlayer) {
        this._a(world, n, n2, n3, entityPlayer);
    }

    public void _a(World world, int n, int n2, int n3, EntityPlayer entityPlayer) {
        if (entityPlayer.canEat(false)) {
            entityPlayer.getFoodStats()._a(2, 0.1f);
            int n4 = world.getBlockMetadata(n, n2, n3) + 1;
            if (n4 >= 6) {
                world.setBlockToAir(n, n2, n3);
            } else {
                world.func_72921_c(n, n2, n3, n4, 2);
            }
        }
    }

    @Override
    public boolean canPlaceBlockAt(World world, int n, int n2, int n3) {
        if (!super.canPlaceBlockAt(world, n, n2, n3)) {
            return false;
        }
        return this.canBlockStay(world, n, n2, n3);
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        if (!this.canBlockStay(world, n, n2, n3)) {
            world.setBlockToAir(n, n2, n3);
        }
    }

    @Override
    public boolean canBlockStay(World world, int n, int n2, int n3) {
        return world.getBlockMaterial(n, n2 - 1, n3)._a();
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return 0;
    }

    @Override
    public int idPicked(World world, int n, int n2, int n3) {
        return Item.cake.itemID;
    }
}

