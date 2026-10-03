/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.enchantment;

import com.google.common.collect.ObjectArrays;
import java.util.ArrayList;
import net.minecraft.enchantment.EnchantmentDamage;
import net.minecraft.enchantment.EnchantmentDurability;
import net.minecraft.enchantment.EnchantmentLootBonus;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.enchantment.EnchantmentThorns;
import net.minecraft.enchantment.EnchantmentUntouching;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.tdpx;

public abstract class Enchantment {
    public static final Enchantment[] _a = new Enchantment[256];
    public static final Enchantment[] _b;
    public static final Enchantment _c;
    public static final Enchantment _d;
    public static final Enchantment _e;
    public static final Enchantment _f;
    public static final Enchantment _g;
    public static final Enchantment _h;
    public static final Enchantment _i;
    public static final Enchantment _j;
    public static final Enchantment _k;
    public static final Enchantment _l;
    public static final Enchantment _m;
    public static final Enchantment _n;
    public static final Enchantment _o;
    public static final Enchantment _p;
    public static final Enchantment _q;
    public static final Enchantment _r;
    public static final Enchantment _s;
    public static final Enchantment _t;
    public static final Enchantment _u;
    public static final Enchantment _v;
    public static final Enchantment _w;
    public static final Enchantment _x;
    public final int _y;
    public final int _z;
    public EnumEnchantmentType _A;
    public String _B;

    public Enchantment(int n, int n2, EnumEnchantmentType enumEnchantmentType) {
        this._y = n;
        this._z = n2;
        this._A = enumEnchantmentType;
        if (_a[n] != null) {
            throw new IllegalArgumentException("Duplicate enchantment id!");
        }
        Enchantment._a[n] = this;
    }

    public int _a() {
        return this._z;
    }

    public int _b() {
        return 1;
    }

    public int _c() {
        return 1;
    }

    public int _a(int n) {
        return 1 + n * 10;
    }

    public int _b(int n) {
        return this._a(n) + 5;
    }

    public int _a(int n, DamageSource damageSource) {
        return 0;
    }

    public float _a(int n, EntityLivingBase entityLivingBase) {
        return 0.0f;
    }

    public boolean _a(Enchantment enchantment) {
        return this != enchantment;
    }

    public Enchantment _a(String string) {
        this._B = string;
        return this;
    }

    public String _d() {
        return "enchantment." + this._B;
    }

    public String _c(int n) {
        String string = tdpx._a(this._d());
        return string + " " + tdpx._a("enchantment.level." + n);
    }

    public boolean _a(ItemStack itemStack) {
        return this._A._a(itemStack._a());
    }

    public boolean _b(ItemStack itemStack) {
        return this._a(itemStack);
    }

    public static void _b(Enchantment enchantment) {
        ObjectArrays.concat(_b, enchantment);
    }

    public boolean _e() {
        return true;
    }

    static {
        _c = new EnchantmentProtection(0, 10, 0);
        _d = new EnchantmentProtection(1, 5, 1);
        _e = new EnchantmentProtection(2, 5, 2);
        _f = new EnchantmentProtection(3, 2, 3);
        _g = new EnchantmentProtection(4, 5, 4);
        _h = new ohua(5, 2);
        _i = new nerj(6, 2);
        _j = new EnchantmentThorns(7, 1);
        _k = new EnchantmentDamage(16, 10, 0);
        _l = new EnchantmentDamage(17, 5, 1);
        _m = new EnchantmentDamage(18, 5, 2);
        _n = new sdan(19, 5);
        _o = new nvtg(20, 2);
        _p = new EnchantmentLootBonus(21, 2, EnumEnchantmentType._g);
        _q = new wpmi(32, 10);
        _r = new EnchantmentUntouching(33, 1);
        _s = new EnchantmentDurability(34, 5);
        _t = new EnchantmentLootBonus(35, 2, EnumEnchantmentType._h);
        _u = new dytw(48, 10);
        _v = new yene(49, 2);
        _w = new txbm(50, 2);
        _x = new ohrg(51, 1);
        ArrayList<Enchantment> arrayList = new ArrayList<Enchantment>();
        for (Enchantment enchantment : _a) {
            if (enchantment == null) continue;
            arrayList.add(enchantment);
        }
        _b = arrayList.toArray(new Enchantment[0]);
    }
}

