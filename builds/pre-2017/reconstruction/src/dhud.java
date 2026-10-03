/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class dhud
extends Slot {
    public final /* synthetic */ qnzl _a;

    public dhud(qnzl qnzl2, IInventory iInventory, int n, int n2, int n3) {
        this._a = qnzl2;
        super(iInventory, n, n2, n3);
    }

    @Override
    public boolean isItemValid(ItemStack itemStack) {
        return super.isItemValid(itemStack) && itemStack._d == Item.saddle.itemID && !this.getHasStack();
    }
}

