/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core.inventory;

import codechicken.core.inventory.ContainerExtended;
import codechicken.core.inventory.SlotHandleClicks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class SlotDummyOutput
extends SlotHandleClicks {
    public SlotDummyOutput(IInventory iInventory, int n, int n2, int n3) {
        super(iInventory, n, n2, n3);
    }

    @Override
    public ItemStack slotClick(ContainerExtended containerExtended, EntityPlayer entityPlayer, int n, int n2) {
        return null;
    }
}

