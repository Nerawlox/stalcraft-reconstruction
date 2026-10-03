/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  mo
 */
package ru.stalcraft.inventory;

import ru.stalcraft.inventory.ICustomContainer;
import ru.stalcraft.inventory.StalkerSlot;
import ru.stalcraft.items.ItemDetector;

public class SlotDetector
extends StalkerSlot {
    public SlotDetector(uy parent, ICustomContainer customContainer, mo par1iInventory, int par2, int par3, int par4) {
        super(parent, customContainer, par1iInventory, par2, par3, par4);
    }

    public boolean a(ye par1ItemStack) {
        return par1ItemStack.b() instanceof ItemDetector;
    }

    public int a() {
        return 1;
    }
}

