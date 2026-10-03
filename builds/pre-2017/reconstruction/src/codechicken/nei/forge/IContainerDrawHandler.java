/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.forge;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Slot;

public interface IContainerDrawHandler {
    public void onPreDraw(GuiContainer var1);

    public void renderObjects(GuiContainer var1, int var2, int var3);

    public void postRenderObjects(GuiContainer var1, int var2, int var3);

    public void renderSlotUnderlay(GuiContainer var1, Slot var2);

    public void renderSlotOverlay(GuiContainer var1, Slot var2);
}

