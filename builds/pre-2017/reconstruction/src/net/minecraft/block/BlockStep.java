/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class BlockStep
extends BlockHalfSlab {
    public static final String[] _b = new String[]{"stone", "sand", "wood", "cobble", "brick", "smoothStoneBrick", "netherBrick", "quartz"};
    public Icon _c;

    public BlockStep(int n, boolean bl) {
        super(n, bl, Material._e);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public Icon getIcon(int n, int n2) {
        int n3 = n2 & 7;
        if (this._a && (n2 & 8) != 0) {
            n = 1;
        }
        if (n3 == 0) {
            if (n == 1 || n == 0) {
                return this.blockIcon;
            }
            return this._c;
        }
        if (n3 == 1) {
            return Block.sandStone.getBlockTextureFromSide(n);
        }
        if (n3 == 2) {
            return Block.planks.getBlockTextureFromSide(n);
        }
        if (n3 == 3) {
            return Block.cobblestone.getBlockTextureFromSide(n);
        }
        if (n3 == 4) {
            return Block.brick.getBlockTextureFromSide(n);
        }
        if (n3 == 5) {
            return Block.stoneBrick.getIcon(n, 0);
        }
        if (n3 == 6) {
            return Block.netherBrick.getBlockTextureFromSide(1);
        }
        if (n3 == 7) {
            return Block.blockNetherQuartz.getBlockTextureFromSide(n);
        }
        return this.blockIcon;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister._b("stone_slab_top");
        this._c = iconRegister._b("stone_slab_side");
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return Block.stoneSingleSlab.blockID;
    }

    @Override
    public ItemStack createStackedBlock(int n) {
        return new ItemStack(Block.stoneSingleSlab.blockID, 2, n & 7);
    }

    @Override
    public String _b(int n) {
        if (n < 0 || n >= _b.length) {
            n = 0;
        }
        return super.getUnlocalizedName() + "." + _b[n];
    }

    @Override
    public void getSubBlocks(int n, CreativeTabs creativeTabs, List list2) {
        if (n == Block.stoneDoubleSlab.blockID) {
            return;
        }
        for (int i = 0; i <= 7; ++i) {
            if (i == 2) continue;
            list2.add(new ItemStack(n, 1, i));
        }
    }
}

