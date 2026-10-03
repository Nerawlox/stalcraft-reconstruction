/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

public class nerj
extends Enchantment {
    public nerj(int n, int n2) {
        super(n, n2, EnumEnchantmentType._f);
        this._a("waterWorker");
    }

    @Override
    public int _a(int n) {
        return 1;
    }

    @Override
    public int _b(int n) {
        return this._a(n) + 40;
    }

    @Override
    public int _c() {
        return 1;
    }
}

