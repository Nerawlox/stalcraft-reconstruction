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

public class BlockStoneBrick
extends Block {
    public static final String[] _a = new String[]{"default", "mossy", "cracked", "chiseled"};
    public static final String[] _b = new String[]{null, "mossy", "cracked", "carved"};
    public Icon[] _c;

    public BlockStoneBrick(int n) {
        super(n, Material._e);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public Icon getIcon(int n, int n2) {
        if (n2 < 0 || n2 >= _b.length) {
            n2 = 0;
        }
        return this._c[n2];
    }

    @Override
    public int damageDropped(int n) {
        return n;
    }

    @Override
    public void getSubBlocks(int n, CreativeTabs creativeTabs, List list) {
        for (int i = 0; i < 4; ++i) {
            list.add(new ItemStack(n, 1, i));
        }
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this._c = new Icon[_b.length];
        for (int i = 0; i < this._c.length; ++i) {
            String string = this.getTextureName();
            if (_b[i] != null) {
                string = string + "_" + _b[i];
            }
            this._c[i] = iconRegister._b(string);
        }
    }
}

