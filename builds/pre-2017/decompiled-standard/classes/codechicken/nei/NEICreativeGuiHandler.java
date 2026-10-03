/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.nei.VisiblityData;
import codechicken.nei.api.INEIGuiAdapter;

public class NEICreativeGuiHandler
extends INEIGuiAdapter {
    @Override
    public VisiblityData modifyVisiblity(zybc zybc2, VisiblityData visiblityData) {
        if (!(zybc2 instanceof qngy)) {
            return visiblityData;
        }
        if (((qngy)zybc2)._c() != tgbl.field_78036_m.func_78021_a()) {
            visiblityData.enableDeleteMode = false;
            visiblityData.showItemSection = false;
        }
        return visiblityData;
    }
}

