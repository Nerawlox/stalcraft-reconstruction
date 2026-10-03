/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.inventory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.inventory.ContainerPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class SlotArmor
extends Slot {
    public final int armorType;
    public final ContainerPlayer parent;

    public SlotArmor(ContainerPlayer containerPlayer, IInventory iInventory, int n, int n2, int n3, int n4) {
        super(iInventory, n, n2, n3);
        this.parent = containerPlayer;
        this.armorType = n4;
    }

    @Override
    public int getSlotStackLimit() {
        return 1;
    }

    @Override
    public boolean isItemValid(ItemStack itemStack) {
        Item item = itemStack == null ? null : itemStack._a();
        return item != null && item.isValidArmor(itemStack, this.armorType, this.parent._d);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public Icon getBackgroundIconIndex() {
        return ItemArmor.func_94602_b(this.armorType);
    }
}

