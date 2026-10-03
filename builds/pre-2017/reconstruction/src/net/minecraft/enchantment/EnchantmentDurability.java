/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.enchantment;

import java.util.Random;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class EnchantmentDurability
extends Enchantment {
    public EnchantmentDurability(int n, int n2) {
        super(n, n2, EnumEnchantmentType._h);
        this._a("durability");
    }

    @Override
    public int _a(int n) {
        return 5 + (n - 1) * 8;
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
    public boolean _a(ItemStack itemStack) {
        if (itemStack._f()) {
            return true;
        }
        return super._a(itemStack);
    }

    public static boolean _a(ItemStack itemStack, int n, Random random) {
        if (itemStack._a() instanceof ItemArmor && random.nextFloat() < 0.6f) {
            return false;
        }
        return random.nextInt(n + 1) > 0;
    }
}

