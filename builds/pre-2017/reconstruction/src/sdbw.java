/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class sdbw
extends Slot {
    public final tgbu _a;

    public sdbw(tgbu tgbu2, IInventory iInventory, int n, int n2, int n3) {
        super(iInventory, n, n2, n3);
        this._a = tgbu2;
    }

    @Override
    public boolean isItemValid(ItemStack itemStack) {
        return itemStack != null ? Item.itemsList[itemStack._d].isPotionIngredient(itemStack) : false;
    }

    @Override
    public int getSlotStackLimit() {
        return 64;
    }
}

