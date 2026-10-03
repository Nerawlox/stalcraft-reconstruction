/*
 * Decompiled with CFR 0.152.
 */
import java.util.Comparator;
import net.minecraft.item.crafting.CraftingManager;

public class xsvg
implements Comparator {
    public final /* synthetic */ CraftingManager _a;

    public xsvg(CraftingManager craftingManager) {
        this._a = craftingManager;
    }

    public int _a(lpso lpso2, lpso lpso3) {
        if (lpso2 instanceof vmoj && lpso3 instanceof xbtf) {
            return 1;
        }
        if (lpso3 instanceof vmoj && lpso2 instanceof xbtf) {
            return -1;
        }
        if (lpso3.getRecipeSize() < lpso2.getRecipeSize()) {
            return -1;
        }
        if (lpso3.getRecipeSize() > lpso2.getRecipeSize()) {
            return 1;
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this._a((lpso)object, (lpso)object2);
    }
}

