/*
 * Decompiled with CFR 0.152.
 */
package com.stalcraft.blocks;

import com.stalcraft.StalcraftMod;
import com.stalcraft.blocks.StalcraftBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockTallGrass
extends Block
implements StalcraftBlock {
    public Icon topIcon;
    public Icon bottomIcon;

    public BlockTallGrass(int n, Material material) {
        super(n, material);
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 2.0f, 1.0f);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        return null;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.topIcon = iconRegister._b("stalcraft:grass_top");
        this.bottomIcon = iconRegister._b("stalcraft:grass_bottom");
        this.blockIcon = this.topIcon;
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
    public int getRenderType() {
        return StalcraftMod.grassRenderId;
    }
}

