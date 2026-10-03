/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.boss;

import net.minecraft.entity.boss.eidj;

public final class kjui {
    public static float _a;
    public static int _b;
    public static String _c;
    public static boolean _d;

    public static void _a(eidj eidj2, boolean bl) {
        _a = eidj2.getHealth() / eidj2.getMaxHealth();
        _b = 100;
        _c = eidj2.getEntityName();
        _d = bl;
    }
}

