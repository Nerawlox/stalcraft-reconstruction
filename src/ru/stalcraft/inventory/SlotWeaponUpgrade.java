/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  mo
 */
package ru.stalcraft.inventory;

import ru.stalcraft.inventory.ICustomContainer;
import ru.stalcraft.inventory.StalkerSlot;

public class SlotWeaponUpgrade
extends StalkerSlot {
    public final int itemID;

    public SlotWeaponUpgrade(uy parent, ICustomContainer customContainer, mo par1iInventory, int index, int x2, int y2, int itemID) {
        super(parent, customContainer, par1iInventory, index, x2, y2);
        this.itemID = itemID;
    }

    public boolean a(ye par1ItemStack) {
        return par1ItemStack == null || par1ItemStack.d == this.itemID;
    }
}

