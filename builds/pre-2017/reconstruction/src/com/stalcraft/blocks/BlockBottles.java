/*
 * Decompiled with CFR 0.152.
 */
package com.stalcraft.blocks;

import com.stalcraft.blocks.StalcraftBlock;
import com.stalcraft.tile.TileEntityBottles;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class BlockBottles
extends BlockContainer
implements StalcraftBlock {
    public BlockBottles(int n, Material material) {
        super(n, material);
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.4f, 1.0f);
        String string = "stalcraft:inv";
        this.setTextureName(string);
    }

    @Override
    public void onBlockPlacedBy(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        int n4 = sajh._c((double)(entityLivingBase.rotationYaw * 4.0f / 360.0f) + 2.5) & 3;
        world.func_72921_c(n, n2, n3, n4, 2);
    }

    @Override
    public int getRenderType() {
        return -1;
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
    public TileEntity createNewTileEntity(World world) {
        return new TileEntityBottles();
    }
}

