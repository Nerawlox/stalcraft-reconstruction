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

public class BlockFence
extends Block
implements StalcraftBlock {
    public static int xCoord;
    public static int yCoord;
    public static int zCoord;

    public BlockFence(int n, Material material) {
        super(n, material);
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 2.0f, 1.0f);
        String string = "stalcraft:fence";
        this.setTextureName(string);
    }

    @Override
    public void onBlockPlacedBy(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        xCoord = n;
        yCoord = n2;
        zCoord = n3;
        int n4 = sajh._c((double)(entityLivingBase.rotationYaw * 4.0f / 360.0f) + 2.5) & 3;
        world.func_72921_c(n, n2, n3, n4, 2);
    }

    @Override
    public int getRenderType() {
        return StalcraftMod.fenceRenderId;
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

