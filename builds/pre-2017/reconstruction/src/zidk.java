/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.potion.Potion;

public class zidk
extends Potion {
    public zidk(int n, boolean bl, int n2) {
        super(n, bl, n2);
    }

    @Override
    public double _a(int n, AttributeModifier attributeModifier) {
        if (this._H == Potion._t._H) {
            return -0.5f * (float)(n + 1);
        }
        return 1.3 * (double)(n + 1);
    }
}

