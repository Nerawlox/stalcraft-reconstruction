/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.nei.api.IInfiniteItemHandler;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;

public class InfiniteToolHandler
implements IInfiniteItemHandler {
    @Override
    public void onPickup(ItemStack itemStack) {
        itemStack._b(0);
    }

    @Override
    public void onPlaceInfinite(ItemStack itemStack) {
        itemStack._b(-32000);
    }

    @Override
    public void replenishInfiniteStack(InventoryPlayer inventoryPlayer, int n) {
        inventoryPlayer.getStackInSlot(n)._b(-32000);
    }

    @Override
    public boolean canHandleItem(ItemStack itemStack) {
        return itemStack._a().isDamageable() && itemStack._d() == 1;
    }

    @Override
    public boolean isItemInfinite(ItemStack itemStack) {
        return itemStack._j() < -30000;
    }

    @Override
    public ItemStack getInfiniteItem(ItemStack itemStack) {
        return new ItemStack(itemStack._d, 1, -32000);
    }
}

