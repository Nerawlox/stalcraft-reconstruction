/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.bundle;

import net.minecraft.util.ezfc;
import net.minecraftforge.event.ForgeSubscribe;

public class kjui {
    @ForgeSubscribe
    public void _a(ycvh ycvh2) {
        qoac qoac2 = ycvh2._a._e;
        if (qoac2 != null && qoac2._o("locitem")) {
            ycvh2._b.add((Object)((Object)ezfc._k) + "\u0414\u043e\u0441\u0442\u0443\u043f\u043d\u043e \u0442\u043e\u043b\u044c\u043a\u043e \u043d\u0430 \u0442\u0435\u043a\u0443\u0449\u0435\u0439 \u043b\u043e\u043a\u0430\u0446\u0438\u0438");
        }
    }
}

