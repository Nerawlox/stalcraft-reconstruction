/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.nei.NEIServerUtils;
import codechicken.nei.api.INEIGuiAdapter;
import codechicken.nei.api.TaggedInventoryArea;
import java.util.Arrays;
import java.util.List;

public class NEIChestGuiHandler
extends INEIGuiAdapter {
    public int chestSize(zybc zybc2) {
        return ((wpkx)zybc2.field_74193_d)._a().func_70302_i_();
    }

    @Override
    public int getItemSpawnSlot(zybc zybc2, cvzo cvzo2) {
        if (!(zybc2 instanceof hcly)) {
            return -1;
        }
        return NEIServerUtils.getSlotForStack(zybc2.field_74193_d, 0, this.chestSize(zybc2), cvzo2);
    }

    @Override
    public List<TaggedInventoryArea> getInventoryAreas(zybc zybc2) {
        if (!(zybc2 instanceof hcly)) {
            return null;
        }
        return Arrays.asList(new TaggedInventoryArea("Chest", 0, this.chestSize(zybc2), zybc2.field_74193_d));
    }
}

