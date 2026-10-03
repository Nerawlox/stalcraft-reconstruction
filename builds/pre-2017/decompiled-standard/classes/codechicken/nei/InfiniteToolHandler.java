/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.nei.api.IInfiniteItemHandler;
import net.minecraft.entity.player.eidj;

public class InfiniteToolHandler
implements IInfiniteItemHandler {
    @Override
    public void onPickup(cvzo cvzo2) {
        cvzo2._b(0);
    }

    @Override
    public void onPlaceInfinite(cvzo cvzo2) {
        cvzo2._b(-32000);
    }

    @Override
    public void replenishInfiniteStack(eidj eidj2, int n) {
        eidj2.func_70301_a(n)._b(-32000);
    }

    @Override
    public boolean canHandleItem(cvzo cvzo2) {
        return cvzo2._a().func_77645_m() && cvzo2._d() == 1;
    }

    @Override
    public boolean isItemInfinite(cvzo cvzo2) {
        return cvzo2._j() < -30000;
    }

    @Override
    public cvzo getInfiniteItem(cvzo cvzo2) {
        return new cvzo(cvzo2._d, 1, -32000);
    }
}

