/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.nei.ItemPanel;
import codechicken.nei.forge.GuiContainerManager;
import java.util.List;
import net.minecraft.item.ItemStack;

public class ItemPanelStack
implements ItemPanel.ItemPanelObject {
    public ItemStack item;

    public ItemPanelStack(ItemStack itemStack) {
        this.item = itemStack;
    }

    @Override
    public void draw(int n, int n2) {
        GuiContainerManager.drawItem(n + 1, n2 + 1, this.item);
    }

    @Override
    public List<String> handleTooltip(List<String> list) {
        return list;
    }
}

