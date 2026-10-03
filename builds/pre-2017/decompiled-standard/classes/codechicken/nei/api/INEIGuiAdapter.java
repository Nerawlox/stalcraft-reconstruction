/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.api;

import codechicken.nei.VisiblityData;
import codechicken.nei.api.INEIGuiHandler;
import codechicken.nei.api.TaggedInventoryArea;
import java.util.List;

public class INEIGuiAdapter
implements INEIGuiHandler {
    @Override
    public VisiblityData modifyVisiblity(zybc zybc2, VisiblityData visiblityData) {
        return visiblityData;
    }

    @Override
    public int getItemSpawnSlot(zybc zybc2, cvzo cvzo2) {
        return -1;
    }

    @Override
    public List<TaggedInventoryArea> getInventoryAreas(zybc zybc2) {
        return null;
    }

    @Override
    public boolean handleDragNDrop(zybc zybc2, int n, int n2, cvzo cvzo2, int n3) {
        return false;
    }

    @Override
    public boolean hideItemPanelSlot(zybc zybc2, int n, int n2, int n3, int n4) {
        return false;
    }
}

