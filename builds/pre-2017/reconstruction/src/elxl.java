/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class elxl
extends Container {
    public InventoryPlayer _a;
    public InventoryBasic _b;
    public int _c = -1;
    public boolean _d;

    public elxl(InventoryPlayer inventoryPlayer) {
        this._a = inventoryPlayer;
        this._a.openChest();
        this._a(false);
    }

    public void _a() {
        if (this._d) {
            this._b = new InventoryBasic("container.mailbox.attachment", true, 6);
            this.inventoryItemStacks.clear();
            this.inventorySlots.clear();
            for (int i = 0; i < 6; ++i) {
                this.addSlotToContainer(new ukeo(this._b, i, 11, 65 + 22 * i));
            }
        } else {
            this._b = new InventoryBasic("container.mailbox.attachment", true, 1);
            this._c();
        }
    }

    public void _b() {
        for (int i = 0; i < 6; ++i) {
            this.getSlot((int)i).yDisplayPosition = 65 + 22 * (i + (this._a(i) ? 1 : 0));
        }
    }

    public elxl _a(boolean bl) {
        this._d = bl;
        this._a();
        return this;
    }

    public boolean _a(int n) {
        return n > this._c && this._c >= 0;
    }

    public void _c() {
        this.inventoryItemStacks.clear();
        this.inventorySlots.clear();
        this._d();
        int n = 15;
        int n2 = 183;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 12; ++j) {
                this.addSlotToContainer(new Slot(this._a, j + i * 12, n + 18 * j, n2 + 18 * i));
            }
        }
    }

    public void _d() {
        this.inventoryItemStacks.clear();
        this.inventorySlots.clear();
        this.addSlotToContainer(new vnhr(this._b, 0, 111, 43));
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int n) {
        ItemStack itemStack = null;
        Slot slot = (Slot)this.inventorySlots.get(n);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack2 = slot.getStack();
            if (itemStack2._e != null && itemStack2._e._c("clan")) {
                return null;
            }
            itemStack = itemStack2._l();
            if (n < 1 ? !this.mergeItemStack(itemStack2, 1, 37, true) : !this.mergeItemStack(itemStack2, 0, 1, false)) {
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

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return true;
    }
}

