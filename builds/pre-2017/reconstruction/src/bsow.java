/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.BlockDispenser;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ezfa;

public final class bsow
extends bbmo {
    public final bbmo _a = new bbmo();

    @Override
    public ItemStack _b(ekuw ekuw2, ItemStack itemStack) {
        tghl tghl2 = (tghl)itemStack._a();
        int n = ekuw2._e();
        int n2 = ekuw2._f();
        int n3 = ekuw2._g();
        ezfa ezfa2 = BlockDispenser._a(ekuw2._h());
        if (tghl2._a(ekuw2._a(), n + ezfa2._a(), n2 + ezfa2._b(), n3 + ezfa2._c())) {
            itemStack._d = Item.bucketEmpty.itemID;
            itemStack._b = 1;
            return itemStack;
        }
        return this._a._a(ekuw2, itemStack);
    }
}

