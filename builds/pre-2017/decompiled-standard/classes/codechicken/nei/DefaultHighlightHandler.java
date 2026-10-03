/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.nei.api.IHighlightHandler;
import codechicken.nei.api.ItemInfo;
import codechicken.nei.forge.GuiContainerManager;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.hank;

public class DefaultHighlightHandler
implements IHighlightHandler {
    @Override
    public List<String> handleTextData(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer, hank hank2, List<String> list2, ItemInfo.Layout layout) {
        String string = null;
        try {
            String string2 = GuiContainerManager.itemDisplayNameShort(cvzo2);
            if (string2 != null && !string2.endsWith("Unnamed")) {
                string = string2;
            }
            if (string != null) {
                list2.add(string);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        if (cvzo2._a() == tgdv.field_77767_aC) {
            int n = ozlu2.func_72805_g(hank2._d, hank2._e, hank2._f);
            String string3 = "" + n;
            if (string3.length() < 2) {
                string3 = " " + string3;
            }
            list2.set(list2.size() - 1, string + " " + string3);
        }
        return list2;
    }

    @Override
    public cvzo identifyHighlight(ozlu ozlu2, EntityPlayer entityPlayer, hank hank2) {
        return null;
    }
}

