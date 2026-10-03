/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cm
 *  cpw.mods.fml.common.network.IConnectionHandler
 *  cpw.mods.fml.common.network.Player
 *  ep
 *  ez
 *  net.minecraft.server.MinecraftServer
 */
package ru.stalcraft.network;

import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.Player;
import net.minecraft.server.MinecraftServer;
import ru.stalcraft.player.IPlayerServerInfo;
import ru.stalcraft.player.PlayerInfo;
import ru.stalcraft.player.PlayerUtils;

public class ConnectionHandler
implements IConnectionHandler {
    public void playerLoggedIn(Player player, ez netHandler, cm manager) {
        PlayerInfo playerInfo;
        if (player instanceof jv && (playerInfo = PlayerUtils.getInfo((jv)player)) instanceof IPlayerServerInfo) {
            ((IPlayerServerInfo)((Object)playerInfo)).startEjection();
        }
    }

    public String connectionReceived(jy netHandler, cm manager) {
        return null;
    }

    public void connectionOpened(ez netClientHandler, String server, int port, cm manager) {
    }

    public void connectionOpened(ez netClientHandler, MinecraftServer server, cm manager) {
    }

    public void connectionClosed(cm manager) {
    }

    public void clientLoggedIn(ez clientHandler, cm manager, ep login) {
    }
}

