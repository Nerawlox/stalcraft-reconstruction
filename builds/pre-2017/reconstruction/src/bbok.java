/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityDispenser;

public class bbok
extends Container {
    public TileEntityDispenser _a;

    public bbok(IInventory iInventory, TileEntityDispenser tileEntityDispenser) {
        int n;
        int n2;
        this._a = tileEntityDispenser;
        for (n2 = 0; n2 < 3; ++n2) {
            for (n = 0; n < 3; ++n) {
                this.addSlotToContainer(new Slot(tileEntityDispenser, n + n2 * 3, 62 + n * 18, 17 + n2 * 18));
            }
        }
        for (n2 = 0; n2 < 3; ++n2) {
            for (n = 0; n < 9; ++n) {
                this.addSlotToContainer(new Slot(iInventory, n + n2 * 9 + 9, 8 + n * 18, 84 + n2 * 18));
            }
        }
        for (n2 = 0; n2 < 9; ++n2) {
            this.addSlotToContainer(new Slot(iInventory, n2, 8 + n2 * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return this._a.isUseableByPlayer(entityPlayer);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int n) {
        ItemStack itemStack = null;
        Slot slot = (Slot)this.inventorySlots.get(n);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack2 = slot.getStack();
            itemStack = itemStack2._l();
            if (n < 9 ? !this.mergeItemStack(itemStack2, 9, 45, true) : !this.mergeItemStack(itemStack2, 0, 9, false)) {
                return null;
            }
            if (itemStack2._b == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }
            if (itemStack2._b == itemStack._b) {
                return null;
            }
            slot.onPickupFromSlot(entityPlayer, itemStack2);
        }
        return itemStack;
    }
}

