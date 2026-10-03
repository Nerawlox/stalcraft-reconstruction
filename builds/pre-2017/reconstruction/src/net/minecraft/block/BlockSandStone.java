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

public class BlockSandStone
extends Block {
    public static final String[] _a = new String[]{"default", "chiseled", "smooth"};
    public static final String[] _b = new String[]{"normal", "carved", "smooth"};
    public Icon[] _c;
    public Icon _d;
    public Icon _e;

    public BlockSandStone(int n) {
        super(n, Material._e);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public Icon getIcon(int n, int n2) {
        if (n == 1 || n == 0 && (n2 == 1 || n2 == 2)) {
            return this._d;
        }
        if (n == 0) {
            return this._e;
        }
        if (n2 < 0 || n2 >= this._c.length) {
            n2 = 0;
        }
        return this._c[n2];
    }

    @Override
    public int damageDropped(int n) {
        return n;
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
            this._c[i] = iconRegister._b(this.getTextureName() + "_" + _b[i]);
        }
        this._d = iconRegister._b(this.getTextureName() + "_top");
        this._e = iconRegister._b(this.getTextureName() + "_bottom");
    }
}

