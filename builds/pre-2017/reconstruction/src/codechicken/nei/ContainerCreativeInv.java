/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.nei.ExtendedCreativeInv;
import codechicken.nei.SlotBlockArmor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotArmor;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ContainerCreativeInv
extends Container {
    public ContainerCreativeInv(EntityPlayer entityPlayer, ExtendedCreativeInv extendedCreativeInv) {
        int n;
        int n2;
        InventoryPlayer inventoryPlayer = entityPlayer.inventory;
        for (n2 = 0; n2 < 6; ++n2) {
            for (n = 0; n < 9; ++n) {
                this.addSlotToContainer(new Slot(extendedCreativeInv, n + n2 * 9, 8 + n * 18, 5 + n2 * 18));
            }
        }
        for (n2 = 0; n2 < 3; ++n2) {
            for (n = 0; n < 9; ++n) {
                this.addSlotToContainer(new Slot(inventoryPlayer, n + n2 * 9 + 9, 8 + n * 18, 118 + n2 * 18));
            }
        }
        for (n2 = 0; n2 < 9; ++n2) {
            this.addSlotToContainer(new Slot(inventoryPlayer, n2, 8 + n2 * 18, 176));
        }
        this.addSlotToContainer(new SlotBlockArmor((ContainerPlayer)entityPlayer.inventoryContainer, inventoryPlayer, inventoryPlayer.getSizeInventory() - 1, -15, 23, 0));
        for (n2 = 1; n2 < 4; ++n2) {
            this.addSlotToContainer(new SlotArmor((ContainerPlayer)entityPlayer.inventoryContainer, inventoryPlayer, inventoryPlayer.getSizeInventory() - 1 - n2, -15, 23 + n2 * 18, n2));
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int n) {
        ItemStack itemStack = null;
        Slot slot = (Slot)this.inventorySlots.get(n);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack2 = slot.getStack();
            itemStack = itemStack2._l();
            if (itemStack2._a() instanceof ItemArmor) {
                ItemArmor itemArmor = (ItemArmor)itemStack2._a();
                if (!this.getSlot(90 + itemArmor.armorType).getHasStack()) {
                    this.getSlot(90 + itemArmor.armorType).putStack(itemStack);
                    slot.putStack(null);
                    return itemStack;
                }
            }
            if (n < 54 ? !this.mergeItemStack(itemStack2, 54, 90, true) : !this.mergeItemStack(itemStack2, 0, 54, false)) {
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
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return true;
    }
}

