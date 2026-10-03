/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

import com.google.common.collect.Iterators;
import gloomyfolken.mods.asm.Logger;
import gloomyfolken.mods.core.misc.amww;
import gloomyfolken.mods.core.misc.pidb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface xpzm<I extends Item, K>
extends amww {
    public static final String _a = "attach";

    @Nullable
    default public NBTTagCompound _a(ItemStack itemStack) {
        if (itemStack == null || itemStack._e == null || !itemStack._e._c(_a)) {
            return null;
        }
        return itemStack._e._m(_a);
    }

    @NotNull
    default public NBTTagCompound _b(ItemStack itemStack) {
        NBTTagCompound nBTTagCompound = ncwh._b(itemStack);
        NBTTagCompound nBTTagCompound2 = flra._a(nBTTagCompound, _a);
        if (nBTTagCompound2 == null) {
            xpzm._a(0);
        }
        return nBTTagCompound2;
    }

    @Nullable
    default public NBTTagCompound _a(ItemStack itemStack, K k) {
        if (itemStack == null || itemStack._e == null || !itemStack._e._c(_a) || !itemStack._e._m(_a)._c(k.toString())) {
            return null;
        }
        return itemStack._e._m(_a)._m(k.toString());
    }

    @Nullable
    default public ItemStack _b(ItemStack itemStack, K k) {
        NBTTagCompound nBTTagCompound = this._a(itemStack, k);
        if (nBTTagCompound == null) {
            return null;
        }
        return ItemStack._a(nBTTagCompound);
    }

    @Nullable
    default public ItemStack _c(ItemStack itemStack, K k) {
        ItemStack itemStack2 = this._b(itemStack, k);
        if (itemStack2 == null || !this._a(itemStack, itemStack2._a(), k)) {
            this._a(itemStack, (ItemStack)null, k);
            return null;
        }
        return itemStack2;
    }

    @Nullable
    default public I _d(ItemStack itemStack, K k) {
        NBTTagCompound nBTTagCompound = this._a(itemStack, k);
        if (nBTTagCompound == null) {
            return null;
        }
        short s = nBTTagCompound._e("id");
        if (s <= 0 || s >= 32000 || !this._a(itemStack, Item.itemsList[s], k)) {
            this._a(itemStack, (ItemStack)null, k);
            return null;
        }
        return this._b(Item.itemsList[s]);
    }

    default public void _a(ItemStack itemStack, ItemStack itemStack2, K k) {
        NBTTagCompound nBTTagCompound = this._b(itemStack);
        if (itemStack2 == null) {
            nBTTagCompound._p(k.toString());
        } else if (!this._a(itemStack, itemStack2._a(), k)) {
            Logger.info("Can't attach item " + itemStack2 + " to slot " + k + "!", new Object[0]);
            Thread.dumpStack();
        } else {
            nBTTagCompound._a(k.toString(), (NBTBase)itemStack2._b(new NBTTagCompound()));
        }
    }

    default public int _j_(ItemStack itemStack) {
        NBTTagCompound nBTTagCompound = this._a(itemStack);
        if (nBTTagCompound == null) {
            return 0;
        }
        return nBTTagCompound._c.size();
    }

    default public Iterator<NBTTagCompound> _d(ItemStack itemStack) {
        NBTTagCompound nBTTagCompound = this._a(itemStack);
        if (nBTTagCompound == null) {
            return Iterators.emptyIterator();
        }
        return nBTTagCompound._c.values().iterator();
    }

    default public List<ItemStack> _k_(ItemStack itemStack) {
        ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>(this._j_(itemStack));
        Iterator<NBTTagCompound> iterator2 = this._d(itemStack);
        while (iterator2.hasNext()) {
            NBTTagCompound nBTTagCompound = iterator2.next();
            ItemStack itemStack2 = ItemStack._a(nBTTagCompound);
            if (itemStack2 == null || !this._a(itemStack2._a())) continue;
            arrayList.add(itemStack2);
        }
        return arrayList;
    }

    default public void _a_(ItemStack itemStack, EntityPlayer entityPlayer) {
        pidb._c(itemStack, entityPlayer);
        if (pidb._b(itemStack)) {
            Iterator<NBTTagCompound> iterator2 = this._d(itemStack);
            while (iterator2.hasNext()) {
                NBTTagCompound nBTTagCompound = iterator2.next();
                NBTTagCompound nBTTagCompound2 = flra._a(nBTTagCompound, "tag");
                nBTTagCompound2._a("owner", entityPlayer.username);
            }
        }
    }

    default public String _f(ItemStack itemStack) {
        Iterator<NBTTagCompound> iterator2 = this._d(itemStack);
        while (iterator2.hasNext()) {
            NBTTagCompound nBTTagCompound = iterator2.next();
            NBTTagCompound nBTTagCompound2 = nBTTagCompound._m("tag");
            if (!nBTTagCompound2._c("owner")) continue;
            return nBTTagCompound2._j("owner");
        }
        return null;
    }

    default public boolean _b(ItemStack itemStack, ItemStack itemStack2, K k) {
        return this._a(itemStack, itemStack2._a(), k);
    }

    default public boolean _a(ItemStack itemStack, Item item, K k) {
        I i;
        try {
            i = this._b(item);
        }
        catch (ClassCastException classCastException) {
            return false;
        }
        return this._b(itemStack, i, k);
    }

    default public boolean _b(ItemStack itemStack, I i, K k) {
        return true;
    }

    default public boolean _a(Item item) {
        try {
            this._b(item);
            return true;
        }
        catch (ClassCastException classCastException) {
            return false;
        }
    }

    public I _b(Item var1);

    private static /* synthetic */ void _a(int n) {
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "gloomyfolken/mods/core/misc/IContainerItem", "getContainerTagOrCreate"));
    }
}

