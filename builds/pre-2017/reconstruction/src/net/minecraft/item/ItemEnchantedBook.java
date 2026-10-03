/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import java.util.List;
import java.util.Random;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.sajh;
import net.minecraft.util.vjvn;

public class ItemEnchantedBook
extends Item {
    public ItemEnchantedBook(int n) {
        super(n);
    }

    @Override
    public boolean hasEffect(ItemStack itemStack) {
        return true;
    }

    @Override
    public boolean isItemTool(ItemStack itemStack) {
        return false;
    }

    @Override
    public EnumRarity getRarity(ItemStack itemStack) {
        if (this._a(itemStack)._d() > 0) {
            return EnumRarity._b;
        }
        return super.getRarity(itemStack);
    }

    public NBTTagList _a(ItemStack itemStack) {
        if (itemStack._e == null || !itemStack._e._c("StoredEnchantments")) {
            return new NBTTagList();
        }
        return (NBTTagList)itemStack._e._b("StoredEnchantments");
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean bl) {
        super.addInformation(itemStack, entityPlayer, list, bl);
        NBTTagList nBTTagList = this._a(itemStack);
        if (nBTTagList != null) {
            for (int i = 0; i < nBTTagList._d(); ++i) {
                short s = ((NBTTagCompound)nBTTagList._b(i))._e("id");
                short s2 = ((NBTTagCompound)nBTTagList._b(i))._e("lvl");
                if (Enchantment._a[s] == null) continue;
                list.add(Enchantment._a[s]._c(s2));
            }
        }
    }

    public void _a(ItemStack itemStack, ixcc ixcc2) {
        NBTTagList nBTTagList = this._a(itemStack);
        boolean bl = true;
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTTagList._b(i);
            if (nBTTagCompound._e("id") != ixcc2._a._y) continue;
            if (nBTTagCompound._e("lvl") < ixcc2._b) {
                nBTTagCompound._a("lvl", (short)ixcc2._b);
            }
            bl = false;
            break;
        }
        if (bl) {
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound._a("id", (short)ixcc2._a._y);
            nBTTagCompound._a("lvl", (short)ixcc2._b);
            nBTTagList._a(nBTTagCompound);
        }
        if (!itemStack._p()) {
            itemStack._d(new NBTTagCompound());
        }
        itemStack._q()._a("StoredEnchantments", nBTTagList);
    }

    public ItemStack _a(ixcc ixcc2) {
        ItemStack itemStack = new ItemStack(this);
        this._a(itemStack, ixcc2);
        return itemStack;
    }

    public void _a(Enchantment enchantment, List list) {
        for (int i = enchantment._b(); i <= enchantment._c(); ++i) {
            list.add(this._a(new ixcc(enchantment, i)));
        }
    }

    public vjvn _a(Random random) {
        return this._a(random, 1, 1, 1);
    }

    public vjvn _a(Random random, int n, int n2, int n3) {
        Enchantment enchantment = Enchantment._b[random.nextInt(Enchantment._b.length)];
        ItemStack itemStack = new ItemStack(this.itemID, 1, 0);
        int n4 = sajh._a(random, enchantment._b(), enchantment._c());
        this._a(itemStack, new ixcc(enchantment, n4));
        return new vjvn(itemStack, n, n2, n3);
    }
}

