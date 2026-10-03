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
import net.minecraft.client.xpzm;

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
            if (!(iterator2.next() instanceof zybc)) continue;
            iterator2.remove();
        }
    }

    public static void switchGui(gqjz gqjz2) {
        xpzm xpzm2 = xpzm._E();
        if (xpzm2._B instanceof zybc) {
            ((zybc)xpzm2._B).sendMouseClick(null, -999, 0, 0);
        }
        xpzm2._a(gqjz2);
        if (gqjz2 instanceof zybc) {
            ((zybc)gqjz2).refresh();
        } else if (gqjz2 instanceof GuiScreenWidget) {
            ((GuiScreenWidget)gqjz2).reset();
        }
    }
}

