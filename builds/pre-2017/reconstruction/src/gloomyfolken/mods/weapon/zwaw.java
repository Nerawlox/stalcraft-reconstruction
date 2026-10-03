/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.weapon;

import net.minecraft.item.ItemStack;

public class zwaw
extends RuntimeException {
    protected wolf _a;
    protected wolf _b;

    public zwaw(wolf wolf2, ItemStack itemStack) {
        super("Gun excepted = " + wolf2 + ", stack received = " + itemStack + "!");
    }
}

