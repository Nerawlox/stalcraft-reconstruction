/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.forge;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;

public interface IContainerObjectHandler {
    public void guiTick(GuiContainer var1);

    public void refresh(GuiContainer var1);

    public void load(GuiContainer var1);

    public ItemStack getStackUnderMouse(GuiContainer var1, int var2, int var3);

    public boolean objectUnderMouse(GuiContainer var1, int var2, int var3);

    public boolean shouldShowTooltip(GuiContainer var1);
}

