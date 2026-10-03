/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.nei.VisiblityData;
import codechicken.nei.api.INEIGuiAdapter;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.creativetab.CreativeTabs;

public class NEICreativeGuiHandler
extends INEIGuiAdapter {
    @Override
    public VisiblityData modifyVisiblity(GuiContainer guiContainer, VisiblityData visiblityData) {
        if (!(guiContainer instanceof qngy)) {
            return visiblityData;
        }
        if (((qngy)guiContainer)._c() != CreativeTabs.tabInventory.getTabIndex()) {
            visiblityData.enableDeleteMode = false;
            visiblityData.showItemSection = false;
        }
        return visiblityData;
    }
}

