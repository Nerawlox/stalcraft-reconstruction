/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.piet;

public class ixcc
extends piet {
    public final Enchantment _a;
    public final int _b;

    public ixcc(Enchantment enchantment, int n) {
        super(enchantment._a());
        this._a = enchantment;
        this._b = n;
    }

    public ixcc(int n, int n2) {
        this(Enchantment._a[n], n2);
    }
}

