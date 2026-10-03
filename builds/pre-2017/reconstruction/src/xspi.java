/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.DamageSource;

public final class xspi
implements dywt {
    public int _a;
    public DamageSource _b;

    public xspi() {
    }

    @Override
    public void _a(Enchantment enchantment, int n) {
        this._a += enchantment._a(n, this._b);
    }

    public /* synthetic */ xspi(dhsk dhsk2) {
        this();
    }
}

