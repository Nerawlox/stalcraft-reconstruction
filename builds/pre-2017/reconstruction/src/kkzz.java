/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.misc.pidb;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class kkzz
extends Slot {
    public kkzz(IInventory iInventory, int n, int n2, int n3) {
        super(iInventory, n, n2, n3);
    }

    @Override
    public boolean isItemValid(ItemStack itemStack) {
        return itemStack == null || pidb._a(itemStack);
    }
}

