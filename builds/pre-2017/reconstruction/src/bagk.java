/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class bagk
extends ccvh {
    private final jzak _d;

    public bagk(jzak jzak2, IInventory iInventory, int n, int n2, int n3, int n4) {
        super(jzak2, iInventory, n, n2, n3, n4);
        this._d = jzak2;
    }

    @Override
    public boolean isItemValid(ItemStack itemStack) {
        if (itemStack != null && itemStack._a() instanceof dgmz && !((dgmz)itemStack._a())._k(this._d.backpackSlot.getStack())) {
            return false;
        }
        return super.isItemValid(itemStack);
    }
}

