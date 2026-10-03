/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ccvh
extends rpbk {
    public final int _c;

    public ccvh(zwyn zwyn2, IInventory iInventory, int n, int n2, int n3, int n4) {
        super(zwyn2, iInventory, n, n2, n3);
        this._c = n4;
    }

    @Override
    public int getSlotStackLimit() {
        return 1;
    }

    @Override
    public boolean isItemValid(ItemStack itemStack) {
        Item item = itemStack == null ? null : itemStack._a();
        return item != null && item.isValidArmor(itemStack, this._c, this._b.owner);
    }

    @Override
    public void onSlotChanged() {
        super.onSlotChanged();
        this._b.onArmorChanged();
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public Icon getBackgroundIconIndex() {
        return ItemArmor.func_94602_b(this._c);
    }
}

