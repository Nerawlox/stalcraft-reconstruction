/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class ndjp
extends rpbk {
    public ndjp(jzak jzak2, IInventory iInventory, int n, int n2, int n3) {
        super(jzak2, iInventory, n, n2, n3);
        this._b = jzak2;
    }

    @Override
    public boolean isItemValid(ItemStack itemStack) {
        ItemStack itemStack2 = this._a().getArmorSlots().get(2).getStack();
        return itemStack._a() instanceof brhe && (itemStack2 == null || !(itemStack2._a() instanceof dgmz) || ((dgmz)itemStack2._a())._k(itemStack));
    }

    @Override
    public int getSlotStackLimit() {
        return 1;
    }

    public jzak _a() {
        return (jzak)this._b;
    }
}

