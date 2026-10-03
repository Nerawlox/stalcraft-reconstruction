/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.tdpx;

public class cwsz
extends Container {
    public InventoryPlayer _a;
    public InventoryBasic _b;
    public boolean _c;
    public int _d = -1;

    public cwsz(boolean bl, InventoryPlayer inventoryPlayer) {
        this._c = bl;
        this._a = inventoryPlayer;
        this._a.openChest();
        this._b = new InventoryBasic(cwsz._a("container.mailbox.attachment"), true, 4);
        this._b();
    }

    public void _a() {
        this.inventoryItemStacks.clear();
        this.inventorySlots.clear();
        if (this._c) {
            this._a(false);
        } else {
            this._b(false);
        }
    }

    public void _b() {
        this.inventoryItemStacks.clear();
        this.inventorySlots.clear();
        if (this._c) {
            this._a(true);
        } else {
            this._b(true);
        }
    }

    public void _a(boolean bl) {
        int n;
        for (n = 0; n < 4; ++n) {
            this.addSlotToContainer(new Slot(this._b, n, 36 + 20 * n, 181));
        }
        if (!bl) {
            for (n = 0; n < 3; ++n) {
                for (int i = 0; i < 9; ++i) {
                    this.addSlotToContainer(new Slot(this._a, 9 + n * 9 + i, -7 + 18 * i, 79 + 18 * n));
                }
            }
            for (n = 0; n < 9; ++n) {
                this.addSlotToContainer(new Slot(this._a, n, -7 + 18 * n, 133));
            }
        }
    }

    public void _b(boolean bl) {
        for (int i = 0; i < 4; ++i) {
            this.addSlotToContainer(new ukeo(this._b, i, 36 + 20 * i, 191));
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int n) {
        ItemStack itemStack = null;
        Slot slot = (Slot)this.inventorySlots.get(n);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack2 = slot.getStack();
            itemStack = itemStack2._l();
            if (n < 4 ? !this.mergeItemStack(itemStack2, 4, 40, true) : !this.mergeItemStack(itemStack2, 0, 4, false)) {
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
    public void onContainerClosed(EntityPlayer entityPlayer) {
        super.onContainerClosed(entityPlayer);
        if (!entityPlayer.worldObj.isRemote && this._c) {
            InvokeSideOnly.frontend(() -> {});
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return true;
    }

    public static String _a(String string) {
        return tdpx._a(string);
    }
}

