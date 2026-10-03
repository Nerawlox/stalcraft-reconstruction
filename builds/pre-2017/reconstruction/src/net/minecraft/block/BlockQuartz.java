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
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockQuartz
extends Block {
    public static final String[] _a = new String[]{"default", "chiseled", "lines"};
    public static final String[] _b = new String[]{"side", "chiseled", "lines", null, null};
    public Icon[] _c;
    public Icon _d;
    public Icon _e;
    public Icon _f;
    public Icon _g;

    public BlockQuartz(int n) {
        super(n, Material._e);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public Icon getIcon(int n, int n2) {
        if (n2 == 2 || n2 == 3 || n2 == 4) {
            if (n2 == 2 && (n == 1 || n == 0)) {
                return this._e;
            }
            if (n2 == 3 && (n == 5 || n == 4)) {
                return this._e;
            }
            if (n2 == 4 && (n == 2 || n == 3)) {
                return this._e;
            }
            return this._c[n2];
        }
        if (n == 1 || n == 0 && n2 == 1) {
            if (n2 == 1) {
                return this._d;
            }
            return this._f;
        }
        if (n == 0) {
            return this._g;
        }
        if (n2 < 0 || n2 >= this._c.length) {
            n2 = 0;
        }
        return this._c[n2];
    }

    @Override
    public int onBlockPlaced(World world, int n, int n2, int n3, int n4, float f, float f2, float f3, int n5) {
        if (n5 == 2) {
            switch (n4) {
                case 2: 
                case 3: {
                    n5 = 4;
                    break;
                }
                case 4: 
                case 5: {
                    n5 = 3;
                    break;
                }
                case 0: 
                case 1: {
                    n5 = 2;
                }
            }
        }
        return n5;
    }

    @Override
    public int damageDropped(int n) {
        if (n == 3 || n == 4) {
            return 2;
        }
        return n;
    }

    @Override
    public ItemStack createStackedBlock(int n) {
        if (n == 3 || n == 4) {
            return new ItemStack(this.blockID, 1, 2);
        }
        return super.createStackedBlock(n);
    }

    @Override
    public int getRenderType() {
        return 39;
    }

    @Override
    public void getSubBlocks(int n, CreativeTabs creativeTabs, List list2) {
        list2.add(new ItemStack(n, 1, 0));
        list2.add(new ItemStack(n, 1, 1));
        list2.add(new ItemStack(n, 1, 2));
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this._c = new Icon[_b.length];
        for (int i = 0; i < this._c.length; ++i) {
            this._c[i] = _b[i] == null ? this._c[i - 1] : iconRegister._b(this.getTextureName() + "_" + _b[i]);
        }
        this._f = iconRegister._b(this.getTextureName() + "_" + "top");
        this._d = iconRegister._b(this.getTextureName() + "_" + "chiseled_top");
        this._e = iconRegister._b(this.getTextureName() + "_" + "lines_top");
        this._g = iconRegister._b(this.getTextureName() + "_" + "bottom");
    }
}

