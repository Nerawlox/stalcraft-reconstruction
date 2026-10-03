/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;

public final class pkxv
implements dywt {
    public float _a;
    public EntityLivingBase _b;

    public pkxv() {
    }

    @Override
    public void _a(Enchantment enchantment, int n) {
        this._a += enchantment._a(n, this._b);
    }

    public /* synthetic */ pkxv(dhsk dhsk2) {
        this();
    }
}

