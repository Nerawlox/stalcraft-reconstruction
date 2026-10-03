/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import java.util.Iterator;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import noppes.npcs.roles.RoleFollower;

class SlotNpcMercenaryCurrency
extends Slot {
    RoleFollower role;

    public SlotNpcMercenaryCurrency(RoleFollower roleFollower, IInventory iInventory, int n, int n2, int n3) {
        super(iInventory, n, n2, n3);
        this.role = roleFollower;
    }

    @Override
    public int getSlotStackLimit() {
        return 64;
    }

    @Override
    public boolean isItemValid(ItemStack itemStack) {
        ItemStack itemStack2;
        int n = itemStack._d;
        Iterator<ItemStack> iterator2 = this.role.inventory.items.values().iterator();
        do {
            if (!iterator2.hasNext()) {
                return false;
            }
            itemStack2 = iterator2.next();
        } while (n != itemStack2._d || itemStack._g() && itemStack._j() != itemStack2._j());
        return true;
    }
}

