/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class BlockEndPortalFrame
extends Block {
    public Icon _a;
    public Icon _b;

    public BlockEndPortalFrame(int n) {
        super(n, Material._e);
    }

    @Override
    public Icon getIcon(int n, int n2) {
        if (n == 1) {
            return this._a;
        }
        if (n == 0) {
            return Block.whiteStone.getBlockTextureFromSide(n);
        }
        return this.blockIcon;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister._b(this.getTextureName() + "_side");
        this._a = iconRegister._b(this.getTextureName() + "_top");
        this._b = iconRegister._b(this.getTextureName() + "_eye");
    }

    public Icon _a() {
        return this._b;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public int getRenderType() {
        return 26;
    }

    @Override
    public void setBlockBoundsForItemRender() {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.8125f, 1.0f);
    }

    @Override
    public void addCollisionBoxesToList(World world, int n, int n2, int n3, AxisAlignedBB axisAlignedBB, List list, Entity entity) {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.8125f, 1.0f);
        super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list, entity);
        int n4 = world.getBlockMetadata(n, n2, n3);
        if (BlockEndPortalFrame._a(n4)) {
            this.setBlockBounds(0.3125f, 0.8125f, 0.3125f, 0.6875f, 1.0f, 0.6875f);
            super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list, entity);
        }
        this.setBlockBoundsForItemRender();
    }

    public static boolean _a(int n) {
        return (n & 4) != 0;
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return 0;
    }

    @Override
    public void onBlockPlacedBy(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        int n4 = ((sajh._c((double)(entityLivingBase.rotationYaw * 4.0f / 360.0f) + 0.5) & 3) + 2) % 4;
        world.func_72921_c(n, n2, n3, n4, 2);
    }

    @Override
    public boolean hasComparatorInputOverride() {
        return true;
    }

    @Override
    public int getComparatorInputOverride(World world, int n, int n2, int n3, int n4) {
        int n5 = world.getBlockMetadata(n, n2, n3);
        if (BlockEndPortalFrame._a(n5)) {
            return 15;
        }
        return 0;
    }
}

