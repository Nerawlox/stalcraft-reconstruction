/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

import gloomyfolken.mods.core.misc.amww;
import net.minecraft.item.ItemStack;

public interface vjta
extends amww {
    public static final String _c_ = "material";

    default public String _i_(ItemStack itemStack) {
        if (itemStack._e == null || !itemStack._e._c(_c_)) {
            return null;
        }
        return itemStack._e._j(_c_);
    }

    default public void _a(ItemStack itemStack, String string) {
        ncwh._b(itemStack)._a(_c_, string);
    }
}

