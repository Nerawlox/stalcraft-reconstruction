/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.containers.ContainerNPCSetup;
import noppes.npcs.roles.RoleFollower;

public class ContainerNPCFollowerSetup
extends ContainerNPCSetup {
    private RoleFollower role;

    public ContainerNPCFollowerSetup(EntityNPCInterface entityNPCInterface, EntityPlayer entityPlayer) {
        super(entityNPCInterface, entityPlayer);
        int n;
        this.role = (RoleFollower)entityNPCInterface.roleInterface;
        for (n = 0; n < 3; ++n) {
            this.addSlotToContainer(new Slot(this.role.inventory, n, 44, 29 + n * 25));
        }
        for (n = 0; n < 3; ++n) {
            for (int i = 0; i < 9; ++i) {
                this.addSlotToContainer(new Slot(entityPlayer.inventory, i + n * 9 + 9, 8 + i * 18, 103 + n * 18));
            }
        }
        for (n = 0; n < 9; ++n) {
            this.addSlotToContainer(new Slot(entityPlayer.inventory, n, 8 + n * 18, 161));
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int n) {
        if (!this.access) {
            return null;
        }
        ItemStack itemStack = null;
        Slot slot = (Slot)this.inventorySlots.get(n);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack2 = slot.getStack();
            itemStack = itemStack2._l();
            if (n >= 0 && n < 3 ? !this.mergeItemStack(itemStack2, 3, 38, true) : (n >= 3 && n < 30 ? !this.mergeItemStack(itemStack2, 30, 38, false) : (n >= 30 && n < 38 ? !this.mergeItemStack(itemStack2, 3, 29, false) : !this.mergeItemStack(itemStack2, 3, 38, false)))) {
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

