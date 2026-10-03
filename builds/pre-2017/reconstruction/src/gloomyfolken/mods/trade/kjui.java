/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.trade;

import gloomyfolken.mods.trade.ezey;
import gloomyfolken.mods.trade.zwat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class kjui
extends Container {
    public EntityPlayer _a;
    public InventoryPlayer _b;
    public ezey _c;
    public ezey _d;

    public kjui(EntityPlayer entityPlayer, ezey ezey2, ezey ezey3) {
        int n;
        int n2;
        this._a = entityPlayer;
        this._c = ezey2;
        this._d = ezey3;
        this._b = entityPlayer.inventory;
        InventoryPlayer inventoryPlayer = entityPlayer.inventory;
        for (n2 = 0; n2 < 3; ++n2) {
            for (n = 0; n < 9; ++n) {
                this.addSlotToContainer(new Slot(inventoryPlayer, n + (n2 + 1) * 9, 8 + n * 18, 104 + n2 * 18));
            }
        }
        for (n2 = 0; n2 < 9; ++n2) {
            this.addSlotToContainer(new Slot(inventoryPlayer, n2, 8 + n2 * 18, 162));
        }
        for (n2 = 0; n2 < 5; ++n2) {
            for (n = 0; n < 4; ++n) {
                this.addSlotToContainer(new zwat(ezey2, n + n2 * 4, 8 + n * 18, -18 + n2 * 18));
            }
        }
        for (n2 = 0; n2 < 5; ++n2) {
            for (n = 0; n < 4; ++n) {
                this.addSlotToContainer(new zwat(ezey3, n + n2 * 4, 98 + n * 18, -18 + n2 * 18));
            }
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int n) {
        ItemStack itemStack = null;
        Slot slot = (Slot)this.inventorySlots.get(n);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack2 = slot.getStack();
            itemStack = itemStack2._l();
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
    public ItemStack slotClick(int n, int n2, int n3, EntityPlayer entityPlayer) {
        if (n3 == 4) {
            n3 = 0;
        }
        if (n >= this._b._a.length + this._c.getSizeInventory()) {
            return null;
        }
        return super.slotClick(n, n2, n3, entityPlayer);
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return entityPlayer == this._c._a;
    }
}

