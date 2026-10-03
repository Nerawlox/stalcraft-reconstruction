/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class jjil
extends Slot {
    public final /* synthetic */ ixdv _a;

    public jjil(ixdv ixdv2, IInventory iInventory, int n, int n2, int n3) {
        this._a = ixdv2;
        super(iInventory, n, n2, n3);
    }

    @Override
    public boolean isItemValid(ItemStack itemStack) {
        if (itemStack != null) {
            return itemStack._d == Item.emerald.itemID || itemStack._d == Item.diamond.itemID || itemStack._d == Item.ingotGold.itemID || itemStack._d == Item.ingotIron.itemID;
        }
        return false;
    }

    @Override
    public int getSlotStackLimit() {
        return 1;
    }
}

