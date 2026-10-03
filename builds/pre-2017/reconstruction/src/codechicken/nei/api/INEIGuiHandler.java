/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.api;

import codechicken.nei.VisiblityData;
import codechicken.nei.api.TaggedInventoryArea;
import java.util.List;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;

public interface INEIGuiHandler {
    public VisiblityData modifyVisiblity(GuiContainer var1, VisiblityData var2);

    public int getItemSpawnSlot(GuiContainer var1, ItemStack var2);

    public List<TaggedInventoryArea> getInventoryAreas(GuiContainer var1);

    public boolean handleDragNDrop(GuiContainer var1, int var2, int var3, ItemStack var4, int var5);

    public boolean hideItemPanelSlot(GuiContainer var1, int var2, int var3, int var4, int var5);
}

