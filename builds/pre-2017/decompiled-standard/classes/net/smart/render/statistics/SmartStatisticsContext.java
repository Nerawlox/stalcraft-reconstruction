/*
 * Decompiled with CFR 0.152.
 */
package net.smart.render.statistics;

import net.minecraft.client.xpzm;
import net.smart.render.statistics.SmartStatisticsFactory;

public abstract class SmartStatisticsContext {
    protected static boolean calculateHorizontalStats = false;

    public static void setCalculateHorizontalStats(boolean bl) {
        calculateHorizontalStats = bl;
    }

    public static void onTickInGame() {
        xpzm xpzm2 = xpzm._E();
        if (xpzm2._r != null && xpzm2._r.field_72995_K) {
            SmartStatisticsFactory.handleMultiPlayerTick(xpzm2);
        }
    }
}

