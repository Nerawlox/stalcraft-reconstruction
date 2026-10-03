/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.item.ItemStack;

public class briu
implements ndjm {
    @Override
    public float _a(ItemStack itemStack) {
        float f = ndjm.super._a(itemStack);
        int n = wolf._F(itemStack);
        if (n != 0) {
            f += (float)wolf._E(itemStack) * bahe._a(n);
        }
        return f;
    }
}

