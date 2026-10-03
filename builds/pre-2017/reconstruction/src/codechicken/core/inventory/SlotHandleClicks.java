/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core.inventory;

import codechicken.core.inventory.ContainerExtended;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public abstract class SlotHandleClicks
extends Slot {
    public SlotHandleClicks(IInventory iInventory, int n, int n2, int n3) {
        super(iInventory, n, n2, n3);
    }

    public abstract ItemStack slotClick(ContainerExtended var1, EntityPlayer var2, int var3, int var4);
}

