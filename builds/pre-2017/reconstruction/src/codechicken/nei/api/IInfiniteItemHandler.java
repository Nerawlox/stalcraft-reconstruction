/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.api;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;

public interface IInfiniteItemHandler {
    public void onPickup(ItemStack var1);

    public void onPlaceInfinite(ItemStack var1);

    public boolean canHandleItem(ItemStack var1);

    public boolean isItemInfinite(ItemStack var1);

    public void replenishInfiniteStack(InventoryPlayer var1, int var2);

    public ItemStack getInfiniteItem(ItemStack var1);
}

