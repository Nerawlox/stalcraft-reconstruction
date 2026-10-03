/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  we
 */
package ru.stalcraft.inventory;

import java.util.ArrayList;

public interface ICustomContainer {
    public ArrayList getBackpackSlots();

    public ArrayList getArmorSlots();

    public boolean hasBackpack();

    public void handleBackpackChanged(boolean var1);

    public of getOwner();

    public boolean isSlotActive(we var1);
}

