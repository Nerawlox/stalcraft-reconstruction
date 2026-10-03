/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EnchantmentUntouching
extends Enchantment {
    public EnchantmentUntouching(int n, int n2) {
        super(n, n2, EnumEnchantmentType._h);
        this._a("untouching");
    }

    @Override
    public int _a(int n) {
        return 15;
    }

    @Override
    public int _b(int n) {
        return super._a(n) + 50;
    }

    @Override
    public int _c() {
        return 1;
    }

    @Override
    public boolean _a(Enchantment enchantment) {
        return super._a(enchantment) && enchantment._y != EnchantmentUntouching._t._y;
    }

    @Override
    public boolean _a(ItemStack itemStack) {
        if (itemStack._a().itemID == Item.shears.itemID) {
            return true;
        }
        return super._a(itemStack);
    }
}

