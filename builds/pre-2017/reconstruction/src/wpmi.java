/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class wpmi
extends Enchantment {
    public wpmi(int n, int n2) {
        super(n, n2, EnumEnchantmentType._h);
        this._a("digging");
    }

    @Override
    public int _a(int n) {
        return 1 + 10 * (n - 1);
    }

    @Override
    public int _b(int n) {
        return super._a(n) + 50;
    }

    @Override
    public int _c() {
        return 5;
    }

    @Override
    public boolean _a(ItemStack itemStack) {
        if (itemStack._a().itemID == Item.shears.itemID) {
            return true;
        }
        return super._a(itemStack);
    }
}

