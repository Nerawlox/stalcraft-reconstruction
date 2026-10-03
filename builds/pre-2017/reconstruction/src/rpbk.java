/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashSet;
import java.util.Set;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class rpbk
extends Slot {
    public static Set<Class> _a = new HashSet<Class>();
    public zwyn _b;

    public rpbk(zwyn zwyn2, IInventory iInventory, int n, int n2, int n3) {
        super(iInventory, n, n2, n3);
        this._b = zwyn2;
    }

    @Override
    public boolean isItemValid(ItemStack itemStack) {
        return itemStack == null || !rpbk._a(itemStack);
    }

    private static boolean _a(ItemStack itemStack) {
        Item item = itemStack._a();
        if (item == null) {
            return false;
        }
        Class<?> clazz = item.getClass();
        for (Class clazz2 : _a) {
            if (!clazz2.isAssignableFrom(clazz)) continue;
            return true;
        }
        return false;
    }

    @Override
    public void onSlotChanged() {
        super.onSlotChanged();
    }

    @Override
    public boolean func_111238_b() {
        return this._b.isSlotActive(this);
    }
}

