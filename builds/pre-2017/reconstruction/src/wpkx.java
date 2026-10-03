/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class wpkx
extends Container {
    public IInventory _a;
    public int _b;

    public wpkx(IInventory iInventory, IInventory iInventory2) {
        int n;
        int n2;
        this._a = iInventory2;
        this._b = iInventory2.getSizeInventory() / 9;
        iInventory2.openChest();
        int n3 = (this._b - 4) * 18;
        for (n2 = 0; n2 < this._b; ++n2) {
            for (n = 0; n < 9; ++n) {
                this.addSlotToContainer(new Slot(iInventory2, n + n2 * 9, 8 + n * 18, 18 + n2 * 18));
            }
        }
        for (n2 = 0; n2 < 3; ++n2) {
            for (n = 0; n < 9; ++n) {
                this.addSlotToContainer(new Slot(iInventory, n + n2 * 9 + 9, 8 + n * 18, 103 + n2 * 18 + n3));
            }
        }
        for (n2 = 0; n2 < 9; ++n2) {
            this.addSlotToContainer(new Slot(iInventory, n2, 8 + n2 * 18, 161 + n3));
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
            if (n < this._b * 9 ? !this.mergeItemStack(itemStack2, this._b * 9, this.inventorySlots.size(), true) : !this.mergeItemStack(itemStack2, 0, this._b * 9, false)) {
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

    public IInventory _a() {
        return this._a;
    }
}

