/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

public class dytw
extends Enchantment {
    public dytw(int n, int n2) {
        super(n, n2, EnumEnchantmentType._i);
        this._a("arrowDamage");
    }

    @Override
    public int _a(int n) {
        return 1 + (n - 1) * 10;
    }

    @Override
    public int _b(int n) {
        return this._a(n) + 15;
    }

    @Override
    public int _c() {
        return 5;
    }
}

