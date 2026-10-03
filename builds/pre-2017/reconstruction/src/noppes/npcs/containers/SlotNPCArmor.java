/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import noppes.npcs.containers.ContainerNPCInv;

class SlotNPCArmor
extends Slot {
    final int armorType;
    final ContainerNPCInv inventory;

    SlotNPCArmor(ContainerNPCInv containerNPCInv, IInventory iInventory, int n, int n2, int n3, int n4) {
        super(iInventory, n, n2, n3);
        this.inventory = containerNPCInv;
        this.armorType = n4;
    }

    @Override
    public int getSlotStackLimit() {
        return 1;
    }

    @Override
    public Icon getBackgroundIconIndex() {
        return ItemArmor.func_94602_b(this.armorType);
    }

    @Override
    public boolean isItemValid(ItemStack itemStack) {
        return itemStack._a() instanceof ItemArmor ? ((ItemArmor)itemStack._a()).armorType == this.armorType : (itemStack._a() instanceof ItemBlock ? this.armorType == 0 : false);
    }
}

