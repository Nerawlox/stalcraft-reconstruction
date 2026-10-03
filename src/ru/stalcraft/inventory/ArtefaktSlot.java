/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  mo
 */
package ru.stalcraft.inventory;

import ru.stalcraft.inventory.ICustomContainer;
import ru.stalcraft.inventory.StalkerSlot;
import ru.stalcraft.items.ItemArtefakt;

public class ArtefaktSlot
extends StalkerSlot {
    public ArtefaktSlot(uy parent, ICustomContainer customContainer, mo par2IInventory, int par3, int par4, int par5) {
        super(parent, customContainer, par2IInventory, par3, par4, par5);
    }

    public int a() {
        return 1;
    }

    public boolean a(ye par1ItemStack) {
        return par1ItemStack.b() instanceof ItemArtefakt;
    }
}

