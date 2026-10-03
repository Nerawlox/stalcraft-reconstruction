/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.client;

import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.toposort.ModSortingException;
import net.minecraft.client.gui.GuiScreen;

public class GuiSortingProblem
extends GuiScreen {
    private ModSortingException modSorting;
    private ModSortingException.SortingExceptionData<ModContainer> failedList;

    public GuiSortingProblem(ModSortingException modSortingException) {
        this.modSorting = modSortingException;
        this.failedList = modSortingException.getExceptionData();
    }

    @Override
    public void initGui() {
        super.initGui();
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        int n3 = Math.max(85 - (this.failedList.getVisitedNodes().size() + 3) * 10, 10);
        this.drawCenteredString(this.fontRenderer, "Forge Mod Loader has found a problem with your minecraft installation", this.width / 2, n3, 0xFFFFFF);
        this.drawCenteredString(this.fontRenderer, "A mod sorting cycle was detected and loading cannot continue", this.width / 2, n3 += 10, 0xFFFFFF);
        this.drawCenteredString(this.fontRenderer, String.format("The first mod in the cycle is %s", this.failedList.getFirstBadNode()), this.width / 2, n3 += 10, 0xFFFFFF);
        this.drawCenteredString(this.fontRenderer, "The remainder of the cycle involves these mods", this.width / 2, n3 += 10, 0xFFFFFF);
        n3 += 5;
        for (ModContainer modContainer : this.failedList.getVisitedNodes()) {
            this.drawCenteredString(this.fontRenderer, String.format("%s : before: %s, after: %s", modContainer.toString(), modContainer.getDependants(), modContainer.getDependencies()), this.width / 2, n3 += 10, 0xEEEEEE);
        }
        this.drawCenteredString(this.fontRenderer, "The file 'ForgeModLoader-client-0.log' contains more information", this.width / 2, n3 += 20, 0xFFFFFF);
    }
}

