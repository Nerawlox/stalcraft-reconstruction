/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.api;

import codechicken.core.gui.GuiScreenWidget;
import codechicken.nei.NEIChestGuiHandler;
import codechicken.nei.NEICreativeGuiHandler;
import codechicken.nei.NEIDummySlotHandler;
import codechicken.nei.api.API;
import codechicken.nei.api.INEIGuiHandler;
import java.util.Iterator;
import java.util.LinkedList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;

public class GuiInfo {
    public static LinkedList<INEIGuiHandler> guiHandlers = new LinkedList();

    public static void load() {
        API.registerNEIGuiHandler(new NEICreativeGuiHandler());
        API.registerNEIGuiHandler(new NEIChestGuiHandler());
        API.registerNEIGuiHandler(new NEIDummySlotHandler());
    }

    public static void clearGuiHandlers() {
        Iterator iterator2 = guiHandlers.iterator();
        while (iterator2.hasNext()) {
            if (!(iterator2.next() instanceof GuiContainer)) continue;
            iterator2.remove();
        }
    }

    public static void switchGui(GuiScreen guiScreen) {
        Minecraft minecraft = Minecraft._E();
        if (minecraft._B instanceof GuiContainer) {
            ((GuiContainer)minecraft._B).sendMouseClick(null, -999, 0, 0);
        }
        minecraft._a(guiScreen);
        if (guiScreen instanceof GuiContainer) {
            ((GuiContainer)guiScreen).refresh();
        } else if (guiScreen instanceof GuiScreenWidget) {
            ((GuiScreenWidget)guiScreen).reset();
        }
    }
}

