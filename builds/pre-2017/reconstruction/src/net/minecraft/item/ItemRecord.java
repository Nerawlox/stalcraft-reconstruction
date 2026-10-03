/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.block.BlockJukeBox;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ItemRecord
extends Item {
    public static final Map _a = new HashMap();
    public final String _b;

    public ItemRecord(int n, String string) {
        super(n);
        this._b = string;
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.tabMisc);
        _a.put(string, this);
    }

    @Override
    public Icon getIconFromDamage(int n) {
        return this.itemIcon;
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (world.getBlockId(n, n2, n3) == Block.jukebox.blockID && world.getBlockMetadata(n, n2, n3) == 0) {
            if (world.isRemote) {
                return true;
            }
            ((BlockJukeBox)Block.jukebox)._a(world, n, n2, n3, itemStack);
            world.playAuxSFXAtEntity(null, 1005, n, n2, n3, this.itemID);
            --itemStack._b;
            return true;
        }
        return false;
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list2, boolean bl) {
        list2.add(this._a());
    }

    public String _a() {
        return "C418 - " + this._b;
    }

    @Override
    public EnumRarity getRarity(ItemStack itemStack) {
        return EnumRarity._c;
    }

    public static ItemRecord _a(String string) {
        return (ItemRecord)_a.get(string);
    }
}

