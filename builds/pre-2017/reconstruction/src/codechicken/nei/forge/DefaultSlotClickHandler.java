/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.forge;

import codechicken.nei.forge.IContainerSlotClickHandler;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Slot;

public class DefaultSlotClickHandler
implements IContainerSlotClickHandler {
    @Override
    public void beforeSlotClick(GuiContainer guiContainer, int n, int n2, Slot slot, int n3) {
    }

    @Override
    public boolean handleSlotClick(GuiContainer guiContainer, int n, int n2, Slot slot, int n3, boolean bl) {
        if (!bl) {
            guiContainer.sendMouseClick(slot, n, n2, n != -999 ? n3 : 0);
        }
        return true;
    }

    @Override
    public void afterSlotClick(GuiContainer guiContainer, int n, int n2, Slot slot, int n3) {
    }
}

