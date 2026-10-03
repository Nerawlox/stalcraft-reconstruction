/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.recipe;

import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.DefaultOverlayHandler;
import java.util.List;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Slot;

public class BrewingOverlayHandler
extends DefaultOverlayHandler {
    @Override
    public Slot[][] mapIngredSlots(GuiContainer guiContainer, List<PositionedStack> list2) {
        Slot[][] slotArray = super.mapIngredSlots(guiContainer, list2);
        Slot[] slotArray2 = new Slot[3];
        for (int i = 0; i < 3; ++i) {
            slotArray2[i] = (Slot)guiContainer.inventorySlots.inventorySlots.get(i);
        }
        slotArray[1] = slotArray2;
        return slotArray;
    }
}

