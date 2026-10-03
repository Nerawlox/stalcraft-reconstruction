/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core.inventory;

import codechicken.core.inventory.ContainerExtended;
import codechicken.core.inventory.SlotHandleClicks;
import codechicken.lib.inventory.InventoryUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class SlotDummy
extends SlotHandleClicks {
    public final int stackLimit;

    public SlotDummy(IInventory iInventory, int n, int n2, int n3) {
        this(iInventory, n, n2, n3, 64);
    }

    public SlotDummy(IInventory iInventory, int n, int n2, int n3, int n4) {
        super(iInventory, n, n2, n3);
        this.stackLimit = n4;
    }

    @Override
    public ItemStack slotClick(ContainerExtended containerExtended, EntityPlayer entityPlayer, int n, int n2) {
        ItemStack itemStack = entityPlayer.inventory._g();
        boolean bl = n2 == 1;
        this.slotClick(itemStack, n, bl);
        return null;
    }

    public void slotClick(ItemStack itemStack, int n, boolean bl) {
        ItemStack itemStack2 = this.getStack();
        if (!(itemStack == null || itemStack2 != null && InventoryUtils.canStack(itemStack, itemStack2))) {
            int n2 = Math.min(itemStack._b, this.stackLimit);
            if (bl) {
                n2 = Math.min(this.stackLimit, itemStack._d() * 16);
            }
            if (n == 1) {
                n2 = 1;
            }
            this.putStack(InventoryUtils.copyStack(itemStack, n2));
        } else if (itemStack2 != null) {
            int n3;
            int n4;
            if (itemStack != null) {
                int n5 = n4 = n == 1 ? -itemStack._b : itemStack._b;
                if (bl) {
                    n4 *= 16;
                }
            } else {
                int n6 = n4 = n == 1 ? -1 : 1;
                if (bl) {
                    n4 *= 16;
                }
            }
            if ((n3 = itemStack2._b + n4) <= 0) {
                this.putStack(null);
            } else {
                this.putStack(InventoryUtils.copyStack(itemStack2, n3));
            }
        }
    }

    @Override
    public void putStack(ItemStack itemStack) {
        if (itemStack != null && itemStack._b > this.stackLimit) {
            itemStack = InventoryUtils.copyStack(itemStack, this.stackLimit);
        }
        super.putStack(itemStack);
    }
}

