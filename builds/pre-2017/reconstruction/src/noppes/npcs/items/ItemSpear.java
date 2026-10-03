/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import noppes.npcs.items.ItemNpcWeaponInterface;

public class ItemSpear
extends ItemNpcWeaponInterface {
    public ItemSpear(int n, txfz txfz2) {
        super(n, txfz2);
    }

    @Override
    public void renderSpecial() {
    }

    @Override
    public boolean shouldRotateAroundWhenRendering() {
        return true;
    }
}

