/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class dgnj
extends rpbk {
    public dgnj(jzak jzak2, IInventory iInventory, int n, int n2, int n3) {
        super(jzak2, iInventory, n, n2, n3);
    }

    @Override
    public boolean isItemValid(ItemStack itemStack) {
        return itemStack._a() instanceof sbvk;
    }
}

