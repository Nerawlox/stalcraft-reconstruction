/*
 * Decompiled with CFR 0.152.
 */
package net.smart.render.statistics;

import net.minecraft.client.Minecraft;
import net.smart.render.statistics.SmartStatisticsFactory;

public abstract class SmartStatisticsContext {
    protected static boolean calculateHorizontalStats = false;

    public static void setCalculateHorizontalStats(boolean bl) {
        calculateHorizontalStats = bl;
    }

    public static void onTickInGame() {
        Minecraft minecraft = Minecraft._E();
        if (minecraft._r != null && minecraft._r.isRemote) {
            SmartStatisticsFactory.handleMultiPlayerTick(minecraft);
        }
    }
}

