/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.nei.NEIServerUtils;
import codechicken.nei.api.INEIGuiAdapter;
import codechicken.nei.api.TaggedInventoryArea;
import java.util.Arrays;
import java.util.List;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;

public class NEIChestGuiHandler
extends INEIGuiAdapter {
    public int chestSize(GuiContainer guiContainer) {
        return ((wpkx)guiContainer.inventorySlots)._a().getSizeInventory();
    }

    @Override
    public int getItemSpawnSlot(GuiContainer guiContainer, ItemStack itemStack) {
        if (!(guiContainer instanceof GuiChest)) {
            return -1;
        }
        return NEIServerUtils.getSlotForStack(guiContainer.inventorySlots, 0, this.chestSize(guiContainer), itemStack);
    }

    @Override
    public List<TaggedInventoryArea> getInventoryAreas(GuiContainer guiContainer) {
        if (!(guiContainer instanceof GuiChest)) {
            return null;
        }
        return Arrays.asList(new TaggedInventoryArea("Chest", 0, this.chestSize(guiContainer), guiContainer.inventorySlots));
    }
}

