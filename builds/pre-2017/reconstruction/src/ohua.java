/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

public class ohua
extends Enchantment {
    public ohua(int n, int n2) {
        super(n, n2, EnumEnchantmentType._f);
        this._a("oxygen");
    }

    @Override
    public int _a(int n) {
        return 10 * n;
    }

    @Override
    public int _b(int n) {
        return this._a(n) + 30;
    }

    @Override
    public int _c() {
        return 3;
    }
}

