/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.lib.inventory.InventoryUtils;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.api.IInfiniteItemHandler;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;

public class InfiniteStackSizeHandler
implements IInfiniteItemHandler {
    @Override
    public void onPickup(ItemStack itemStack) {
        itemStack._b = 1;
    }

    @Override
    public void onPlaceInfinite(ItemStack itemStack) {
        itemStack._b = 111;
    }

    @Override
    public boolean canHandleItem(ItemStack itemStack) {
        return !itemStack._f();
    }

    @Override
    public boolean isItemInfinite(ItemStack itemStack) {
        return false;
    }

    @Override
    public void replenishInfiniteStack(InventoryPlayer inventoryPlayer, int n) {
        ItemStack itemStack = inventoryPlayer.getStackInSlot(n);
        itemStack._b = 111;
        for (int i = 0; i < inventoryPlayer.getSizeInventory(); ++i) {
            if (i == n || !NEIServerUtils.areStacksSameType(itemStack, inventoryPlayer.getStackInSlot(i))) continue;
            inventoryPlayer.setInventorySlotContents(i, null);
        }
    }

    @Override
    public ItemStack getInfiniteItem(ItemStack itemStack) {
        return InventoryUtils.copyStack(itemStack, -1);
    }
}

