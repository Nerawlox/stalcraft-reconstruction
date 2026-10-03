/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.api;

import codechicken.nei.VisiblityData;
import codechicken.nei.api.TaggedInventoryArea;
import java.util.List;

public interface INEIGuiHandler {
    public VisiblityData modifyVisiblity(zybc var1, VisiblityData var2);

    public int getItemSpawnSlot(zybc var1, cvzo var2);

    public List<TaggedInventoryArea> getInventoryAreas(zybc var1);

    public boolean handleDragNDrop(zybc var1, int var2, int var3, cvzo var4, int var5);

    public boolean hideItemPanelSlot(zybc var1, int var2, int var3, int var4, int var5);
}

