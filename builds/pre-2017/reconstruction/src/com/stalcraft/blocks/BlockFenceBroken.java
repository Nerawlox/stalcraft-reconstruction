/*
 * Decompiled with CFR 0.152.
 */
package com.stalcraft.blocks;

import com.stalcraft.StalcraftMod;
import com.stalcraft.blocks.StalcraftBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class BlockFenceBroken
extends Block
implements StalcraftBlock {
    public BlockFenceBroken(int n, Material material) {
        super(n, material);
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 2.0f, 1.0f);
        String string = "stalcraft:fence";
        this.setTextureName(string);
    }

    @Override
    public void onBlockPlacedBy(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        int n4 = sajh._c((double)(entityLivingBase.rotationYaw * 4.0f / 360.0f) + 2.5) & 3;
        world.func_72921_c(n, n2, n3, n4, 0);
    }

    @Override
    public int getRenderType() {
        return StalcraftMod.fenceBrokenRenderId;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }
}

