/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.lib.inventory.InventoryUtils;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.api.IInfiniteItemHandler;
import net.minecraft.entity.player.eidj;

public class InfiniteStackSizeHandler
implements IInfiniteItemHandler {
    @Override
    public void onPickup(cvzo cvzo2) {
        cvzo2._b = 1;
    }

    @Override
    public void onPlaceInfinite(cvzo cvzo2) {
        cvzo2._b = 111;
    }

    @Override
    public boolean canHandleItem(cvzo cvzo2) {
        return !cvzo2._f();
    }

    @Override
    public boolean isItemInfinite(cvzo cvzo2) {
        return false;
    }

    @Override
    public void replenishInfiniteStack(eidj eidj2, int n) {
        cvzo cvzo2 = eidj2.func_70301_a(n);
        cvzo2._b = 111;
        for (int i = 0; i < eidj2.func_70302_i_(); ++i) {
            if (i == n || !NEIServerUtils.areStacksSameType(cvzo2, eidj2.func_70301_a(i))) continue;
            eidj2.func_70299_a(i, null);
        }
    }

    @Override
    public cvzo getInfiniteItem(cvzo cvzo2) {
        return InventoryUtils.copyStack(cvzo2, -1);
    }
}

