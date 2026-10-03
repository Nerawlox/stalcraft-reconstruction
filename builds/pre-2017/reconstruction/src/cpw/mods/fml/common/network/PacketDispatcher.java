/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.network;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.common.network.NetworkModHandler;
import cpw.mods.fml.common.network.Player;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.server.MinecraftServer;

public class PacketDispatcher {
    public static Packet250CustomPayload getPacket(String string, byte[] byArray) {
        return new Packet250CustomPayload(string, byArray);
    }

    public static void sendPacketToServer(Packet packet) {
        FMLCommonHandler.instance().getSidedDelegate().sendPacket(packet);
    }

    public static void sendPacketToPlayer(Packet packet, Player player) {
        if (player instanceof EntityPlayerMP) {
            ((EntityPlayerMP)player).playerNetServerHandler.func_72567_b(packet);
        }
    }

    public static void sendPacketToAllAround(double d, double d2, double d3, double d4, int n, Packet packet) {
        MinecraftServer minecraftServer = FMLCommonHandler.instance().getMinecraftServerInstance();
        if (minecraftServer != null) {
            minecraftServer.__ag()._a(d, d2, d3, d4, n, packet);
        } else {
            FMLLog.fine("Attempt to send packet to all around without a server instance available", new Object[0]);
        }
    }

    public static void sendPacketToAllInDimension(Packet packet, int n) {
        MinecraftServer minecraftServer = FMLCommonHandler.instance().getMinecraftServerInstance();
        if (minecraftServer != null) {
            minecraftServer.__ag()._a(packet, n);
        } else {
            FMLLog.fine("Attempt to send packet to all in dimension without a server instance available", new Object[0]);
        }
    }

    public static void sendPacketToAllPlayers(Packet packet) {
        MinecraftServer minecraftServer = FMLCommonHandler.instance().getMinecraftServerInstance();
        if (minecraftServer != null) {
            minecraftServer.__ag()._a(packet);
        } else {
            FMLLog.fine("Attempt to send packet to all in dimension without a server instance available", new Object[0]);
        }
    }

    public static yexp getTinyPacket(Object object, short s, byte[] byArray) {
        NetworkModHandler networkModHandler = FMLNetworkHandler.instance().findNetworkModHandler(object);
        return new yexp((short)networkModHandler.getNetworkId(), s, byArray);
    }
}

