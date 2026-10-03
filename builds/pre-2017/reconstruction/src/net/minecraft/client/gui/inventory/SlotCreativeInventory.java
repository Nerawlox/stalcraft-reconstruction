/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class SlotCreativeInventory
extends Slot {
    public final Slot _a;
    public final /* synthetic */ qngy _b;

    public SlotCreativeInventory(qngy qngy2, Slot slot, int n) {
        this._b = qngy2;
        super(slot.inventory, n, 0, 0);
        this._a = slot;
    }

    @Override
    public void onPickupFromSlot(EntityPlayer entityPlayer, ItemStack itemStack) {
        this._a.onPickupFromSlot(entityPlayer, itemStack);
    }

    @Override
    public boolean isItemValid(ItemStack itemStack) {
        return this._a.isItemValid(itemStack);
    }

    @Override
    public ItemStack getStack() {
        return this._a.getStack();
    }

    @Override
    public boolean getHasStack() {
        return this._a.getHasStack();
    }

    @Override
    public void putStack(ItemStack itemStack) {
        this._a.putStack(itemStack);
    }

    @Override
    public void onSlotChanged() {
        this._a.onSlotChanged();
    }

    @Override
    public int getSlotStackLimit() {
        return this._a.getSlotStackLimit();
    }

    @Override
    public Icon getBackgroundIconIndex() {
        return this._a.getBackgroundIconIndex();
    }

    @Override
    public ItemStack decrStackSize(int n) {
        return this._a.decrStackSize(n);
    }

    @Override
    public boolean func_75217_a(IInventory iInventory, int n) {
        return this._a.func_75217_a(iInventory, n);
    }

    public static /* synthetic */ Slot _a(SlotCreativeInventory slotCreativeInventory) {
        return slotCreativeInventory._a;
    }
}

