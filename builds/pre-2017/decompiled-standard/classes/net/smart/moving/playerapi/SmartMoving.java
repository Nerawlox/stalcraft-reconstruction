/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving.playerapi;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.smart.moving.IEntityPlayerMP;
import net.smart.moving.IEntityPlayerSP;
import net.smart.moving.playerapi.SmartMovingPlayerBase;
import net.smart.moving.playerapi.SmartMovingServerPlayerBase;

public abstract class SmartMoving {
    public static final String SPC_ID = "Single Player Commands";

    public static void register() {
        SmartMovingPlayerBase.registerPlayerBase();
        SmartMovingServerPlayerBase.registerPlayerBase();
    }

    public static IEntityPlayerSP getPlayerBase(EntityPlayer entityPlayer) {
        return entityPlayer instanceof EntityPlayerSP ? SmartMovingPlayerBase.getPlayerBase((EntityPlayerSP)entityPlayer) : null;
    }

    public static IEntityPlayerMP getServerPlayerBase(EntityPlayer entityPlayer) {
        return entityPlayer instanceof EntityPlayerMP ? SmartMovingServerPlayerBase.getPlayerBase(entityPlayer) : null;
    }
}

