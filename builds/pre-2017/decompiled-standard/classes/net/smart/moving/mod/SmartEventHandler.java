/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  gloomyfolken.mods.anticheat.movement.AnticheatHandler
 *  gloomyfolken.mods.anticheat.movement.AnticheatSmartmoving
 */
package net.smart.moving.mod;

import gloomyfolken.bundle.common.core.zwaw;
import gloomyfolken.mods.anticheat.movement.AnticheatHandler;
import gloomyfolken.mods.anticheat.movement.AnticheatSmartmoving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.smart.moving.SmartMovingPacketStream;
import net.smart.moving.playerapi.SmartMovingServerPlayerBase;

public class SmartEventHandler {
    @ForgeSubscribe
    public void onEntityJoin(EntityJoinWorldEvent entityJoinWorldEvent) {
        if (!entityJoinWorldEvent.world.field_72995_K && entityJoinWorldEvent.entity instanceof EntityPlayer) {
            SmartMovingServerPlayerBase smartMovingServerPlayerBase = SmartMovingServerPlayerBase.getPlayerBase(entityJoinWorldEvent.entity);
            smartMovingServerPlayerBase.onPlayerJoin();
        }
    }

    @ForgeSubscribe
    @zwaw
    public void onStartTracking(mqqq mqqq2) {
        if (mqqq2.entity instanceof EntityPlayerMP) {
            AnticheatSmartmoving anticheatSmartmoving = AnticheatHandler.getAnticheatHandler((EntityPlayer)((EntityPlayer)mqqq2.entity)).getSmartmoving();
            long l = anticheatSmartmoving._F();
            byte[] byArray = SmartMovingPacketStream.getStatePacket(mqqq2.entity.field_70157_k, l);
            jjqf jjqf2 = SmartMovingPacketStream.genPacket(byArray);
            mqqq2._a.field_71135_a.func_72567_b(jjqf2);
        }
    }
}

