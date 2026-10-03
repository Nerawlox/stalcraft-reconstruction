/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityRecordPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockJukeBox
extends BlockContainer {
    public Icon _a;

    public BlockJukeBox(int n) {
        super(n, Material._d);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    @Override
    public Icon getIcon(int n, int n2) {
        if (n == 1) {
            return this._a;
        }
        return this.blockIcon;
    }

    @Override
    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (world.getBlockMetadata(n, n2, n3) == 0) {
            return false;
        }
        this._a(world, n, n2, n3);
        return true;
    }

    public void _a(World world, int n, int n2, int n3, ItemStack itemStack) {
        if (world.isRemote) {
            return;
        }
        TileEntityRecordPlayer tileEntityRecordPlayer = (TileEntityRecordPlayer)world.getBlockTileEntity(n, n2, n3);
        if (tileEntityRecordPlayer == null) {
            return;
        }
        tileEntityRecordPlayer._a(itemStack._l());
        world.func_72921_c(n, n2, n3, 1, 2);
    }

    public void _a(World world, int n, int n2, int n3) {
        if (world.isRemote) {
            return;
        }
        TileEntityRecordPlayer tileEntityRecordPlayer = (TileEntityRecordPlayer)world.getBlockTileEntity(n, n2, n3);
        if (tileEntityRecordPlayer == null) {
            return;
        }
        ItemStack itemStack = tileEntityRecordPlayer._a();
        if (itemStack == null) {
            return;
        }
        world.playAuxSFX(1005, n, n2, n3, 0);
        world.playRecord(null, n, n2, n3);
        tileEntityRecordPlayer._a(null);
        world.func_72921_c(n, n2, n3, 0, 2);
        float f = 0.7f;
        double d = (double)(world.rand.nextFloat() * f) + (double)(1.0f - f) * 0.5;
        double d2 = (double)(world.rand.nextFloat() * f) + (double)(1.0f - f) * 0.2 + 0.6;
        double d3 = (double)(world.rand.nextFloat() * f) + (double)(1.0f - f) * 0.5;
        ItemStack itemStack2 = itemStack._l();
        EntityItem entityItem = new EntityItem(world, (double)n + d, (double)n2 + d2, (double)n3 + d3, itemStack2);
        entityItem.delayBeforeCanPickup = 10;
        world.spawnEntityInWorld(entityItem);
    }

    @Override
    public void breakBlock(World world, int n, int n2, int n3, int n4, int n5) {
        this._a(world, n, n2, n3);
        super.breakBlock(world, n, n2, n3, n4, n5);
    }

    @Override
    public void dropBlockAsItemWithChance(World world, int n, int n2, int n3, int n4, float f, int n5) {
        if (world.isRemote) {
            return;
        }
        super.dropBlockAsItemWithChance(world, n, n2, n3, n4, f, 0);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileEntityRecordPlayer();
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister._b(this.getTextureName() + "_side");
        this._a = iconRegister._b(this.getTextureName() + "_top");
    }

    @Override
    public boolean hasComparatorInputOverride() {
        return true;
    }

    @Override
    public int getComparatorInputOverride(World world, int n, int n2, int n3, int n4) {
        ItemStack itemStack = ((TileEntityRecordPlayer)world.getBlockTileEntity(n, n2, n3))._a();
        return itemStack == null ? 0 : itemStack._d + 1 - Item.record13.itemID;
    }
}

