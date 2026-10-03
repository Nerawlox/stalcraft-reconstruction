/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.core.inventory.ContainerExtended;
import codechicken.core.inventory.SlotDummy;
import codechicken.nei.NEICPH;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.api.INEIGuiAdapter;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class NEIDummySlotHandler
extends INEIGuiAdapter {
    @Override
    public boolean handleDragNDrop(GuiContainer guiContainer, int n, int n2, ItemStack itemStack, int n3) {
        Slot slot = guiContainer.getSlotAtPosition(n, n2);
        if (slot instanceof SlotDummy && slot.isItemValid(itemStack) && guiContainer.inventorySlots instanceof ContainerExtended) {
            ((SlotDummy)slot).slotClick(itemStack, n3, NEIClientUtils.shiftKey());
            NEICPH.sendDummySlotSet(slot.slotNumber, slot.getStack());
            return true;
        }
        return false;
    }
}

