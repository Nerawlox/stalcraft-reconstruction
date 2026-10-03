/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.api;

import codechicken.nei.Button;
import codechicken.nei.VisiblityData;
import codechicken.nei.forge.GuiContainerManager;
import net.minecraft.client.gui.inventory.GuiContainer;

public abstract class LayoutStyle {
    public abstract void init();

    public abstract void reset();

    public abstract void layout(GuiContainer var1, VisiblityData var2);

    public abstract String getName();

    public void drawBackground(GuiContainerManager guiContainerManager) {
    }

    public abstract void drawButton(Button var1, int var2, int var3);

    public abstract boolean texturedButtons();
}

