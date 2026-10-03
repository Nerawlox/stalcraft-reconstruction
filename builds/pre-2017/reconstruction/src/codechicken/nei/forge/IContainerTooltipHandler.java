/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.forge;

import java.util.List;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;

public interface IContainerTooltipHandler {
    public List<String> handleTooltipFirst(GuiContainer var1, int var2, int var3, List<String> var4);

    public List<String> handleItemTooltip(GuiContainer var1, ItemStack var2, List<String> var3);
}

