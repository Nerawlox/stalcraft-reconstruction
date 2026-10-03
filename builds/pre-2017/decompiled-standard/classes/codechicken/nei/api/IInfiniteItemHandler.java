/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.api;

import net.minecraft.entity.player.eidj;

public interface IInfiniteItemHandler {
    public void onPickup(cvzo var1);

    public void onPlaceInfinite(cvzo var1);

    public boolean canHandleItem(cvzo var1);

    public boolean isItemInfinite(cvzo var1);

    public void replenishInfiniteStack(eidj var1, int var2);

    public cvzo getInfiniteItem(cvzo var1);
}

