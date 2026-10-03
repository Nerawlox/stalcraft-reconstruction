/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.api;

import codechicken.nei.VisiblityData;
import codechicken.nei.api.INEIGuiHandler;
import codechicken.nei.api.TaggedInventoryArea;
import java.util.List;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;

public class INEIGuiAdapter
implements INEIGuiHandler {
    @Override
    public VisiblityData modifyVisiblity(GuiContainer guiContainer, VisiblityData visiblityData) {
        return visiblityData;
    }

    @Override
    public int getItemSpawnSlot(GuiContainer guiContainer, ItemStack itemStack) {
        return -1;
    }

    @Override
    public List<TaggedInventoryArea> getInventoryAreas(GuiContainer guiContainer) {
        return null;
    }

    @Override
    public boolean handleDragNDrop(GuiContainer guiContainer, int n, int n2, ItemStack itemStack, int n3) {
        return false;
    }

    @Override
    public boolean hideItemPanelSlot(GuiContainer guiContainer, int n, int n2, int n3, int n4) {
        return false;
    }
}

