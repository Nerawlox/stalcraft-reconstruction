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
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockEnchantmentTable
extends BlockContainer {
    public Icon _a;
    public Icon _b;

    public BlockEnchantmentTable(int n) {
        super(n, Material._e);
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.75f, 1.0f);
        this.setLightOpacity(0);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public void randomDisplayTick(World world, int n, int n2, int n3, Random random) {
        super.randomDisplayTick(world, n, n2, n3, random);
        for (int i = n - 2; i <= n + 2; ++i) {
            block1: for (int j = n3 - 2; j <= n3 + 2; ++j) {
                if (i > n - 2 && i < n + 2 && j == n3 - 1) {
                    j = n3 + 2;
                }
                if (random.nextInt(16) != 0) continue;
                for (int k = n2; k <= n2 + 1; ++k) {
                    if (world.getBlockId(i, k, j) != Block.bookShelf.blockID) continue;
                    if (!world.isAirBlock((i - n) / 2 + n, k, (j - n3) / 2 + n3)) continue block1;
                    world.spawnParticle("enchantmenttable", (double)n + 0.5, (double)n2 + 2.0, (double)n3 + 0.5, (double)((float)(i - n) + random.nextFloat()) - 0.5, (float)(k - n2) - random.nextFloat() - 1.0f, (double)((float)(j - n3) + random.nextFloat()) - 0.5);
                }
            }
        }
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public Icon getIcon(int n, int n2) {
        if (n == 0) {
            return this._b;
        }
        if (n == 1) {
            return this._a;
        }
        return this.blockIcon;
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new mtdr();
    }

    @Override
    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (world.isRemote) {
            return true;
        }
        mtdr mtdr2 = (mtdr)world.getBlockTileEntity(n, n2, n3);
        entityPlayer.displayGUIEnchantment(n, n2, n3, mtdr2._b() ? mtdr2._a() : null);
        return true;
    }

    @Override
    public void onBlockPlacedBy(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        super.onBlockPlacedBy(world, n, n2, n3, entityLivingBase, itemStack);
        if (itemStack._u()) {
            ((mtdr)world.getBlockTileEntity(n, n2, n3))._a(itemStack._s());
        }
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister._b(this.getTextureName() + "_" + "side");
        this._a = iconRegister._b(this.getTextureName() + "_" + "top");
        this._b = iconRegister._b(this.getTextureName() + "_" + "bottom");
    }
}

