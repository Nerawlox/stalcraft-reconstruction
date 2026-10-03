/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.core.CommonUtils;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerPlayer;
import net.minecraft.inventory.SlotArmor;
import net.minecraft.item.ItemStack;

public class SlotBlockArmor
extends SlotArmor {
    public SlotBlockArmor(ContainerPlayer containerPlayer, InventoryPlayer inventoryPlayer, int n, int n2, int n3, int n4) {
        super(containerPlayer, inventoryPlayer, n, n2, n3, n4);
    }

    @Override
    public boolean isItemValid(ItemStack itemStack) {
        return super.isItemValid(itemStack) || CommonUtils.isBlock(itemStack._d);
    }
}

