/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCarpet
extends Block {
    public BlockCarpet(int n) {
        super(n, Material._r);
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.0625f, 1.0f);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this._a(0);
    }

    @Override
    public Icon getIcon(int n, int n2) {
        return Block.cloth.getIcon(n, n2);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        boolean bl = false;
        float f = 0.0625f;
        return AxisAlignedBB._a()._a((double)n + this.minX, (double)n2 + this.minY, (double)n3 + this.minZ, (double)n + this.maxX, (float)n2 + (float)bl * f, (double)n3 + this.maxZ);
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
    public void setBlockBoundsForItemRender() {
        this._a(0);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        this._a(iBlockAccess.getBlockMetadata(n, n2, n3));
    }

    public void _a(int n) {
        int n2 = 0;
        float f = (float)(1 * (1 + n2)) / 16.0f;
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, f, 1.0f);
    }

    @Override
    public boolean canPlaceBlockAt(World world, int n, int n2, int n3) {
        return super.canPlaceBlockAt(world, n, n2, n3) && this.canBlockStay(world, n, n2, n3);
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        this._a(world, n, n2, n3);
    }

    public boolean _a(World world, int n, int n2, int n3) {
        if (!this.canBlockStay(world, n, n2, n3)) {
            this.dropBlockAsItem(world, n, n2, n3, world.getBlockMetadata(n, n2, n3), 0);
            world.setBlockToAir(n, n2, n3);
            return false;
        }
        return true;
    }

    @Override
    public boolean canBlockStay(World world, int n, int n2, int n3) {
        return !world.isAirBlock(n, n2 - 1, n3);
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        if (n4 == 1) {
            return true;
        }
        return super.shouldSideBeRendered(iBlockAccess, n, n2, n3, n4);
    }

    @Override
    public int damageDropped(int n) {
        return n;
    }

    @Override
    public void getSubBlocks(int n, CreativeTabs creativeTabs, List list2) {
        for (int i = 0; i < 16; ++i) {
            list2.add(new ItemStack(n, 1, i));
        }
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
    }
}

