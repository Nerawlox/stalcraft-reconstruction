/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common.network;

import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.network.ForgePacket;
import net.minecraftforge.fluids.FluidIdMapPacket;

public class ForgeConnectionHandler
implements IConnectionHandler {
    @Override
    public void playerLoggedIn(Player player, NetHandler netHandler, jjpj jjpj2) {
        Packet250CustomPayload[] packet250CustomPayloadArray = ForgePacket.makePacketSet(new FluidIdMapPacket());
        for (int i = 0; i < packet250CustomPayloadArray.length; ++i) {
            PacketDispatcher.sendPacketToPlayer(packet250CustomPayloadArray[i], player);
        }
    }

    @Override
    public String connectionReceived(yezc yezc2, jjpj jjpj2) {
        return null;
    }

    @Override
    public void connectionOpened(NetHandler netHandler, String string, int n, jjpj jjpj2) {
    }

    @Override
    public void connectionOpened(NetHandler netHandler, MinecraftServer minecraftServer, jjpj jjpj2) {
    }

    @Override
    public void connectionClosed(jjpj jjpj2) {
    }

    @Override
    public void clientLoggedIn(NetHandler netHandler, jjpj jjpj2, txpf txpf2) {
    }
}

