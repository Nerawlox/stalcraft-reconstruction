/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.inventory.ContainerEnchantment;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class xbpi
extends Slot {
    public final /* synthetic */ ContainerEnchantment _a;

    public xbpi(ContainerEnchantment containerEnchantment, IInventory iInventory, int n, int n2, int n3) {
        this._a = containerEnchantment;
        super(iInventory, n, n2, n3);
    }

    @Override
    public boolean isItemValid(ItemStack itemStack) {
        return true;
    }
}

