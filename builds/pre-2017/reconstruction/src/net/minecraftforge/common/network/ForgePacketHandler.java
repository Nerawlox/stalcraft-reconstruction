/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common.network;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraftforge.common.network.ForgePacket;

public class ForgePacketHandler
implements IPacketHandler {
    @Override
    public void onPacketData(jjpj jjpj2, Packet250CustomPayload packet250CustomPayload, Player player) {
        ForgePacket forgePacket = ForgePacket.readPacket(jjpj2, packet250CustomPayload.data);
        if (forgePacket == null) {
            return;
        }
        forgePacket.execute(jjpj2, (EntityPlayer)player);
    }
}

