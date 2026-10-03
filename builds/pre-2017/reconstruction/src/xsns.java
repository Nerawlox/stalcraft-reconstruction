/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class xsns
extends Container {
    public final IInventory _a;

    public xsns(InventoryPlayer inventoryPlayer, IInventory iInventory) {
        int n;
        this._a = iInventory;
        iInventory.openChest();
        int n2 = 51;
        for (n = 0; n < iInventory.getSizeInventory(); ++n) {
            this.addSlotToContainer(new Slot(iInventory, n, 44 + n * 18, 20));
        }
        for (n = 0; n < 3; ++n) {
            for (int i = 0; i < 9; ++i) {
                this.addSlotToContainer(new Slot(inventoryPlayer, i + n * 9 + 9, 8 + i * 18, n * 18 + n2));
            }
        }
        for (n = 0; n < 9; ++n) {
            this.addSlotToContainer(new Slot(inventoryPlayer, n, 8 + n * 18, 58 + n2));
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
            if (n < this._a.getSizeInventory() ? !this.mergeItemStack(itemStack2, this._a.getSizeInventory(), this.inventorySlots.size(), true) : !this.mergeItemStack(itemStack2, 0, this._a.getSizeInventory(), false)) {
                return null;
            }
            if (itemStack2._b == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }
        }
        return itemStack;
    }

    @Override
    public void onContainerClosed(EntityPlayer entityPlayer) {
        super.onContainerClosed(entityPlayer);
        this._a.closeChest();
    }
}

