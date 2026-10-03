/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  mo
 *  we
 */
package ru.stalcraft.inventory;

import ru.stalcraft.inventory.ICustomContainer;

public class StalkerSlot
extends we {
    public uy parent;
    public ICustomContainer customContainer;

    public StalkerSlot(uy parent, ICustomContainer customContainer, mo par1iInventory, int index, int x2, int y2) {
        super(par1iInventory, index, x2, y2);
        this.parent = parent;
        this.customContainer = customContainer;
    }

    public void f() {
        super.f();
    }

    public boolean b() {
        return this.customContainer.isSlotActive(this);
    }
}

