/*
 * Decompiled with CFR 0.152.
 */
package net.smart.render.statistics.playerapi;

import net.minecraft.entity.player.EntityPlayer;
import net.smart.render.statistics.IEntityPlayerSP;
import net.smart.render.statistics.SmartStatistics;

public class SmartStatisticsFactory
extends net.smart.render.statistics.SmartStatisticsFactory {
    public static void initialize() {
        if (!SmartStatisticsFactory.isInitialized()) {
            new SmartStatisticsFactory();
        }
    }

    @Override
    protected SmartStatistics doGetInstance(EntityPlayer entityPlayer) {
        SmartStatistics smartStatistics = super.doGetInstance(entityPlayer);
        if (smartStatistics != null) {
            return smartStatistics;
        }
        IEntityPlayerSP iEntityPlayerSP = net.smart.render.statistics.playerapi.SmartStatistics.getPlayerBase(entityPlayer);
        return iEntityPlayerSP != null ? iEntityPlayerSP.getStatistics() : null;
    }
}

