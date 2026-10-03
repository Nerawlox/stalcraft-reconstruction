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

public class PacketDispatcher {
    public static jjqf getPacket(String string, byte[] byArray) {
        return new jjqf(string, byArray);
    }

    public static void sendPacketToServer(cezg cezg2) {
        FMLCommonHandler.instance().getSidedDelegate().sendPacket(cezg2);
    }

    public static void sendPacketToPlayer(cezg cezg2, Player player) {
        if (player instanceof EntityPlayerMP) {
            ((EntityPlayerMP)player).field_71135_a.func_72567_b(cezg2);
        }
    }

    public static void sendPacketToAllAround(double d, double d2, double d3, double d4, int n, cezg cezg2) {
        dzfd dzfd2 = FMLCommonHandler.instance().getMinecraftServerInstance();
        if (dzfd2 != null) {
            dzfd2.__ag()._a(d, d2, d3, d4, n, cezg2);
        } else {
            FMLLog.fine("Attempt to send packet to all around without a server instance available", new Object[0]);
        }
    }

    public static void sendPacketToAllInDimension(cezg cezg2, int n) {
        dzfd dzfd2 = FMLCommonHandler.instance().getMinecraftServerInstance();
        if (dzfd2 != null) {
            dzfd2.__ag()._a(cezg2, n);
        } else {
            FMLLog.fine("Attempt to send packet to all in dimension without a server instance available", new Object[0]);
        }
    }

    public static void sendPacketToAllPlayers(cezg cezg2) {
        dzfd dzfd2 = FMLCommonHandler.instance().getMinecraftServerInstance();
        if (dzfd2 != null) {
            dzfd2.__ag()._a(cezg2);
        } else {
            FMLLog.fine("Attempt to send packet to all in dimension without a server instance available", new Object[0]);
        }
    }

    public static yexp getTinyPacket(Object object, short s, byte[] byArray) {
        NetworkModHandler networkModHandler = FMLNetworkHandler.instance().findNetworkModHandler(object);
        return new yexp((short)networkModHandler.getNetworkId(), s, byArray);
    }
}

