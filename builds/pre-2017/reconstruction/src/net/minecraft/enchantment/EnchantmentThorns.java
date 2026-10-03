/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.enchantment;

import java.util.Random;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class EnchantmentThorns
extends Enchantment {
    public EnchantmentThorns(int n, int n2) {
        super(n, n2, EnumEnchantmentType._e);
        this._a("thorns");
    }

    @Override
    public int _a(int n) {
        return 10 + 20 * (n - 1);
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
        if (itemStack._a() instanceof ItemArmor) {
            return true;
        }
        return super._a(itemStack);
    }

    public static boolean _a(int n, Random random) {
        if (n <= 0) {
            return false;
        }
        return random.nextFloat() < 0.15f * (float)n;
    }

    public static int _b(int n, Random random) {
        if (n > 10) {
            return n - 10;
        }
        return 1 + random.nextInt(4);
    }

    public static void _a(Entity entity, EntityLivingBase entityLivingBase, Random random) {
        int n = zhty._h(entityLivingBase);
        ItemStack itemStack = zhty._a(Enchantment._j, entityLivingBase);
        if (EnchantmentThorns._a(n, random)) {
            entity.attackEntityFrom(DamageSource.causeThornsDamage(entityLivingBase), EnchantmentThorns._b(n, random));
            entity.playSound("damage.thorns", 0.5f, 1.0f);
            if (itemStack != null) {
                itemStack._a(3, entityLivingBase);
            }
        } else if (itemStack != null) {
            itemStack._a(1, entityLivingBase);
        }
    }
}

