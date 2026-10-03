/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

public class EnchantmentLootBonus
extends Enchantment {
    public EnchantmentLootBonus(int n, int n2, EnumEnchantmentType enumEnchantmentType) {
        super(n, n2, enumEnchantmentType);
        this._a("lootBonus");
        if (enumEnchantmentType == EnumEnchantmentType._h) {
            this._a("lootBonusDigger");
        }
    }

    @Override
    public int _a(int n) {
        return 15 + (n - 1) * 9;
    }

    @Override
    public int _b(int n) {
        return super._a(n) + 50;
    }

    @Override
    public int _c() {
        return 3;
    }

    @Override
    public boolean _a(Enchantment enchantment) {
        return super._a(enchantment) && enchantment._y != EnchantmentLootBonus._r._y;
    }
}

