/*
 * Decompiled with CFR 0.152.
 */
package net.smart.render.statistics.playerapi;

import api.player.client.ClientPlayerAPI;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.smart.render.statistics.IEntityPlayerSP;
import net.smart.render.statistics.playerapi.SmartStatisticsPlayerBase;

public abstract class SmartStatistics {
    public static final String ID = "Smart Render";

    public static void register() {
        ClientPlayerAPI.register(ID, SmartStatisticsPlayerBase.class);
    }

    public static IEntityPlayerSP getPlayerBase(EntityPlayer entityPlayer) {
        return entityPlayer instanceof EntityPlayerSP ? (SmartStatisticsPlayerBase)((EntityPlayerSP)entityPlayer).getClientPlayerBase(ID) : null;
    }
}

