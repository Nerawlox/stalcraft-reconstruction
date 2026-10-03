/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class txdj
extends Slot {
    public final /* synthetic */ EntityHorse _a;
    public final /* synthetic */ qnzl _b;

    public txdj(qnzl qnzl2, IInventory iInventory, int n, int n2, int n3, EntityHorse entityHorse) {
        this._b = qnzl2;
        this._a = entityHorse;
        super(iInventory, n, n2, n3);
    }

    @Override
    public boolean isItemValid(ItemStack itemStack) {
        return super.isItemValid(itemStack) && this._a.func_110259_cr() && EntityHorse.func_110211_v(itemStack._d);
    }

    @Override
    public boolean func_111238_b() {
        return this._a.func_110259_cr();
    }
}

