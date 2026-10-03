/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryCrafting;

public class InventoryCraftingDummy
extends InventoryCrafting {
    public InventoryCraftingDummy() {
        super(new Container(){

            @Override
            public boolean canInteractWith(EntityPlayer entityPlayer) {
                return true;
            }
        }, 3, 3);
    }
}

