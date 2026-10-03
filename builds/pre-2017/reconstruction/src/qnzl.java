/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class qnzl
extends Container {
    public IInventory _a;
    public EntityHorse _b;

    public qnzl(IInventory iInventory, IInventory iInventory2, EntityHorse entityHorse) {
        int n;
        int n2;
        this._a = iInventory2;
        this._b = entityHorse;
        int n3 = 3;
        iInventory2.openChest();
        int n4 = (n3 - 4) * 18;
        this.addSlotToContainer(new dhud(this, iInventory2, 0, 8, 18));
        this.addSlotToContainer(new txdj(this, iInventory2, 1, 8, 36, entityHorse));
        if (entityHorse.isChested()) {
            for (n2 = 0; n2 < n3; ++n2) {
                for (n = 0; n < 5; ++n) {
                    this.addSlotToContainer(new Slot(iInventory2, 2 + n + n2 * 5, 80 + n * 18, 18 + n2 * 18));
                }
            }
        }
        for (n2 = 0; n2 < 3; ++n2) {
            for (n = 0; n < 9; ++n) {
                this.addSlotToContainer(new Slot(iInventory, n + n2 * 9 + 9, 8 + n * 18, 102 + n2 * 18 + n4));
            }
        }
        for (n2 = 0; n2 < 9; ++n2) {
            this.addSlotToContainer(new Slot(iInventory, n2, 8 + n2 * 18, 160 + n4));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return this._a.isUseableByPlayer(entityPlayer) && this._b.isEntityAlive() && this._b.getDistanceToEntity(entityPlayer) < 8.0f;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int n) {
        ItemStack itemStack = null;
        Slot slot = (Slot)this.inventorySlots.get(n);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack2 = slot.getStack();
            itemStack = itemStack2._l();
            if (n < this._a.getSizeInventory() ? !this.mergeItemStack(itemStack2, this._a.getSizeInventory(), this.inventorySlots.size(), true) : (this.getSlot(1).isItemValid(itemStack2) && !this.getSlot(1).getHasStack() ? !this.mergeItemStack(itemStack2, 1, 2, false) : (this.getSlot(0).isItemValid(itemStack2) ? !this.mergeItemStack(itemStack2, 0, 1, false) : this._a.getSizeInventory() <= 2 || !this.mergeItemStack(itemStack2, 2, this._a.getSizeInventory(), false)))) {
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

