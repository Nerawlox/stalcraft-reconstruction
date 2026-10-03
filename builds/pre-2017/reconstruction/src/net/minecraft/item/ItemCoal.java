/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import java.util.List;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ItemCoal
extends Item {
    public Icon _a;

    public ItemCoal(int n) {
        super(n);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        if (itemStack._j() == 1) {
            return "item.charcoal";
        }
        return "item.coal";
    }

    @Override
    public void getSubItems(int n, CreativeTabs creativeTabs, List list) {
        list.add(new ItemStack(n, 1, 0));
        list.add(new ItemStack(n, 1, 1));
    }

    @Override
    public Icon getIconFromDamage(int n) {
        if (n == 1) {
            return this._a;
        }
        return super.getIconFromDamage(n);
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        super.registerIcons(iconRegister);
        this._a = iconRegister._b("charcoal");
    }
}

