/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.sajh;

public class EnchantmentProtection
extends Enchantment {
    public static final String[] _C = new String[]{"all", "fire", "fall", "explosion", "projectile"};
    public static final int[] _D = new int[]{1, 10, 5, 5, 3};
    public static final int[] _E = new int[]{11, 8, 6, 8, 6};
    public static final int[] _F = new int[]{20, 12, 10, 12, 15};
    public final int _G;

    public EnchantmentProtection(int n, int n2, int n3) {
        super(n, n2, EnumEnchantmentType._b);
        this._G = n3;
        if (n3 == 2) {
            this._A = EnumEnchantmentType._c;
        }
    }

    @Override
    public int _a(int n) {
        return _D[this._G] + (n - 1) * _E[this._G];
    }

    @Override
    public int _b(int n) {
        return this._a(n) + _F[this._G];
    }

    @Override
    public int _c() {
        return 4;
    }

    @Override
    public int _a(int n, DamageSource damageSource) {
        if (damageSource.canHarmInCreative()) {
            return 0;
        }
        float f = (float)(6 + n * n) / 3.0f;
        if (this._G == 0) {
            return sajh._d(f * 0.75f);
        }
        if (this._G == 1 && damageSource.isFireDamage()) {
            return sajh._d(f * 1.25f);
        }
        if (this._G == 2 && damageSource == DamageSource.fall) {
            return sajh._d(f * 2.5f);
        }
        if (this._G == 3 && damageSource.isExplosion()) {
            return sajh._d(f * 1.5f);
        }
        if (this._G == 4 && damageSource.isProjectile()) {
            return sajh._d(f * 1.5f);
        }
        return 0;
    }

    @Override
    public String _d() {
        return "enchantment.protect." + _C[this._G];
    }

    @Override
    public boolean _a(Enchantment enchantment) {
        if (enchantment instanceof EnchantmentProtection) {
            EnchantmentProtection enchantmentProtection = (EnchantmentProtection)enchantment;
            if (enchantmentProtection._G == this._G) {
                return false;
            }
            return this._G == 2 || enchantmentProtection._G == 2;
        }
        return super._a(enchantment);
    }

    public static int _a(Entity entity, int n) {
        int n2 = zhty._a(Enchantment._d._y, entity.func_70035_c());
        if (n2 > 0) {
            n -= sajh._d((float)n * ((float)n2 * 0.15f));
        }
        return n;
    }

    public static double _a(Entity entity, double d) {
        int n = zhty._a(Enchantment._f._y, entity.func_70035_c());
        if (n > 0) {
            d -= (double)sajh._c(d * (double)((float)n * 0.15f));
        }
        return d;
    }
}

