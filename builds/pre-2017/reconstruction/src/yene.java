/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

public class yene
extends Enchantment {
    public yene(int n, int n2) {
        super(n, n2, EnumEnchantmentType._i);
        this._a("arrowKnockback");
    }

    @Override
    public int _a(int n) {
        return 12 + (n - 1) * 20;
    }

    @Override
    public int _b(int n) {
        return this._a(n) + 25;
    }

    @Override
    public int _c() {
        return 2;
    }
}

