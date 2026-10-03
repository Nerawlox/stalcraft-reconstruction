/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ItemHash
implements Comparable<ItemHash> {
    public short item;
    public short damage;
    public NBTTagCompound moreinfo;

    public ItemHash(int n, int n2, NBTTagCompound nBTTagCompound) {
        this.item = (short)n;
        this.damage = (short)n2;
        this.moreinfo = nBTTagCompound;
    }

    public ItemHash(ItemStack itemStack) {
        this.item = (short)itemStack._d;
        this.damage = (short)itemStack._j();
        this.moreinfo = itemStack._e;
    }

    public ItemHash(int n) {
        this(n, -1);
    }

    public ItemHash(int n, int n2) {
        this(n, n2, null);
    }

    public boolean equals(Object object) {
        if (object instanceof ItemHash) {
            ItemHash itemHash = (ItemHash)object;
            return itemHash.item == this.item && (itemHash.damage == this.damage || itemHash.damage == -1 || this.damage == -1) && (this.moreinfo == itemHash.moreinfo || this.moreinfo != null && this.moreinfo.equals(itemHash.moreinfo));
        }
        return false;
    }

    public int hashCode() {
        return this.item;
    }

    @Override
    public int compareTo(ItemHash itemHash) {
        if (itemHash.item != this.item) {
            return Integer.valueOf(this.item).compareTo(Integer.valueOf(itemHash.item));
        }
        if (itemHash.damage != this.damage) {
            return Integer.valueOf(this.damage).compareTo(Integer.valueOf(itemHash.damage));
        }
        return 0;
    }

    public ItemStack toStack() {
        ItemStack itemStack = new ItemStack(this.item, 1, (int)this.damage);
        itemStack._e = this.moreinfo;
        return itemStack;
    }
}

