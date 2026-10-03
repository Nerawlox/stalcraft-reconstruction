/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.recipe;

import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.DefaultOverlayHandler;
import java.util.List;

public class BrewingOverlayHandler
extends DefaultOverlayHandler {
    @Override
    public yeso[][] mapIngredSlots(zybc zybc2, List<PositionedStack> list2) {
        yeso[][] yesoArray = super.mapIngredSlots(zybc2, list2);
        yeso[] yesoArray2 = new yeso[3];
        for (int i = 0; i < 3; ++i) {
            yesoArray2[i] = (yeso)zybc2.field_74193_d.field_75151_b.get(i);
        }
        yesoArray[1] = yesoArray2;
        return yesoArray;
    }
}

