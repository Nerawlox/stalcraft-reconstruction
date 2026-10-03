/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;

public final class jjeq
implements vmgb {
    public final bbmo _a = new bbmo();

    @Override
    public ItemStack _a(ekuw ekuw2, ItemStack itemStack) {
        if (ItemPotion._b(itemStack._j())) {
            return new tgab(this, itemStack)._a(ekuw2, itemStack);
        }
        return this._a._a(ekuw2, itemStack);
    }
}

