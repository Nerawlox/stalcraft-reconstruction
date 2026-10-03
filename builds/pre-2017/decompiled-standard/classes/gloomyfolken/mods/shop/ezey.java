/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.shop;

import gloomyfolken.mods.shop.zwat;
import net.minecraft.util.ezfc;
import net.minecraftforge.event.ForgeSubscribe;

public class ezey {
    @ForgeSubscribe
    public void _a(mquk mquk2) {
        mquk2._a("donateinv", new zwat(mquk2._a));
    }

    @ForgeSubscribe
    public void _a(ycvh ycvh2) {
        qoac qoac2 = ycvh2._a._e;
        if (qoac2 != null && qoac2._c("buyer")) {
            ycvh2._b.add((Object)((Object)ezfc._k) + "\u041f\u0440\u0438\u043e\u0431\u0440\u0435\u043b: " + qoac2._j("buyer"));
        }
    }
}

