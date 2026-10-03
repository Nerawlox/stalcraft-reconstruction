/*
 * Decompiled with CFR 0.152.
 */
import java.util.Comparator;
import net.minecraft.item.ItemStack;

public class hbdx
implements Comparator<ItemStack> {
    public int _a(ItemStack itemStack, ItemStack itemStack2) {
        if (itemStack == null && itemStack2 == null) {
            return 0;
        }
        if (itemStack == null) {
            return 1;
        }
        if (itemStack2 == null) {
            return -1;
        }
        if (itemStack._d == itemStack2._d) {
            return 0;
        }
        if (itemStack._d > itemStack2._d) {
            return 1;
        }
        return -1;
    }

    @Override
    public /* synthetic */ int compare(Object object, Object object2) {
        return this._a((ItemStack)object, (ItemStack)object2);
    }
}

