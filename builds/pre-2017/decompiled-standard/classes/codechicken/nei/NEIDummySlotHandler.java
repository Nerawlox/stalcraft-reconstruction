/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.core.inventory.ContainerExtended;
import codechicken.core.inventory.SlotDummy;
import codechicken.nei.NEICPH;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.api.INEIGuiAdapter;

public class NEIDummySlotHandler
extends INEIGuiAdapter {
    @Override
    public boolean handleDragNDrop(zybc zybc2, int n, int n2, cvzo cvzo2, int n3) {
        yeso yeso2 = zybc2.func_74187_b(n, n2);
        if (yeso2 instanceof SlotDummy && yeso2.func_75214_a(cvzo2) && zybc2.field_74193_d instanceof ContainerExtended) {
            ((SlotDummy)yeso2).slotClick(cvzo2, n3, NEIClientUtils.shiftKey());
            NEICPH.sendDummySlotSet(yeso2.field_75222_d, yeso2.func_75211_c());
            return true;
        }
        return false;
    }
}

