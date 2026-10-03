/*
 * Decompiled with CFR 0.152.
 */
package codechicken.lib.inventory;

import codechicken.lib.inventory.InventoryUtils;
import com.google.common.base.Objects;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ItemKey
implements Comparable<ItemKey> {
    public ItemStack item;
    private int hashcode = 0;

    public ItemKey(ItemStack itemStack) {
        this.item = itemStack;
    }

    public ItemKey(int n, int n2) {
        this(new ItemStack(n, 1, n2));
    }

    public ItemKey(int n, int n2, NBTTagCompound nBTTagCompound) {
        this(n, n2);
        this.item._d(nBTTagCompound);
    }

    public boolean equals(Object object) {
        if (!(object instanceof ItemKey)) {
            return false;
        }
        ItemKey itemKey = (ItemKey)object;
        return this.item._d == itemKey.item._d && InventoryUtils.actualDamage(this.item) == InventoryUtils.actualDamage(itemKey.item) && Objects.equal(this.item._e, itemKey.item._e);
    }

    public int hashCode() {
        return this.hashcode != 0 ? this.hashcode : (this.hashcode = Objects.hashCode(this.item._d, InventoryUtils.actualDamage(this.item), this.item._e));
    }

    public int compareInt(int n, int n2) {
        return n == n2 ? 0 : (n < n2 ? -1 : 1);
    }

    @Override
    public int compareTo(ItemKey itemKey) {
        if (this.item._d != itemKey.item._d) {
            return this.compareInt(this.item._d, itemKey.item._d);
        }
        if (InventoryUtils.actualDamage(this.item) != InventoryUtils.actualDamage(itemKey.item)) {
            return this.compareInt(InventoryUtils.actualDamage(this.item), InventoryUtils.actualDamage(itemKey.item));
        }
        return 0;
    }
}

