/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

public class ohrg
extends Enchantment {
    public ohrg(int n, int n2) {
        super(n, n2, EnumEnchantmentType._i);
        this._a("arrowInfinite");
    }

    @Override
    public int _a(int n) {
        return 20;
    }

    @Override
    public int _b(int n) {
        return 50;
    }

    @Override
    public int _c() {
        return 1;
    }
}

