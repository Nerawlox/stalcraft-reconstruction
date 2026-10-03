/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class BlockEnderChest
extends BlockContainer {
    public BlockEnderChest(int n) {
        super(n, Material._e);
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setBlockBounds(0.0625f, 0.0f, 0.0625f, 0.9375f, 0.875f, 0.9375f);
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
        return 22;
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return Block.obsidian.blockID;
    }

    @Override
    public int quantityDropped(Random random) {
        return 8;
    }

    @Override
    public boolean canSilkHarvest() {
        return true;
    }

    @Override
    public void onBlockPlacedBy(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        int n4 = 0;
        int n5 = sajh._c((double)(entityLivingBase.rotationYaw * 4.0f / 360.0f) + 0.5) & 3;
        if (n5 == 0) {
            n4 = 2;
        }
        if (n5 == 1) {
            n4 = 5;
        }
        if (n5 == 2) {
            n4 = 3;
        }
        if (n5 == 3) {
            n4 = 4;
        }
        world.func_72921_c(n, n2, n3, n4, 2);
    }

    @Override
    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        InventoryEnderChest inventoryEnderChest = entityPlayer.getInventoryEnderChest();
        gaqr gaqr2 = (gaqr)world.getBlockTileEntity(n, n2, n3);
        if (inventoryEnderChest == null || gaqr2 == null) {
            return true;
        }
        if (world.isBlockNormalCube(n, n2 + 1, n3)) {
            return true;
        }
        if (world.isRemote) {
            return true;
        }
        inventoryEnderChest._a(gaqr2);
        entityPlayer.displayGUIChest(inventoryEnderChest);
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new gaqr();
    }

    @Override
    public void randomDisplayTick(World world, int n, int n2, int n3, Random random) {
        for (int i = 0; i < 3; ++i) {
            double d = (float)n + random.nextFloat();
            double d2 = (float)n2 + random.nextFloat();
            double d3 = (float)n3 + random.nextFloat();
            double d4 = 0.0;
            double d5 = 0.0;
            double d6 = 0.0;
            int n4 = random.nextInt(2) * 2 - 1;
            int n5 = random.nextInt(2) * 2 - 1;
            d4 = ((double)random.nextFloat() - 0.5) * 0.125;
            d5 = ((double)random.nextFloat() - 0.5) * 0.125;
            d6 = ((double)random.nextFloat() - 0.5) * 0.125;
            d3 = (double)n3 + 0.5 + 0.25 * (double)n5;
            d6 = random.nextFloat() * 1.0f * (float)n5;
            d = (double)n + 0.5 + 0.25 * (double)n4;
            d4 = random.nextFloat() * 1.0f * (float)n4;
            world.spawnParticle("portal", d, d2, d3, d4, d5, d6);
        }
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister._b("obsidian");
    }
}

