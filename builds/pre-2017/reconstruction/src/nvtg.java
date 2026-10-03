/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

public class nvtg
extends Enchantment {
    public nvtg(int n, int n2) {
        super(n, n2, EnumEnchantmentType._g);
        this._a("fire");
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
        return 2;
    }
}

