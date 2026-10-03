/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class vnhr
extends Slot {
    public vnhr(IInventory iInventory, int n, int n2, int n3) {
        super(iInventory, n, n2, n3);
    }

    @Override
    public boolean isItemValid(ItemStack itemStack) {
        return itemStack._e == null || !itemStack._e._c("clan");
    }
}

