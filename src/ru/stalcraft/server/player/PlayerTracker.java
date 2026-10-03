/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.IPlayerTracker
 */
package ru.stalcraft.server.player;

import cpw.mods.fml.common.IPlayerTracker;
import java.util.Iterator;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.player.PlayerUtils;
import ru.stalcraft.server.CommonProxy;
import ru.stalcraft.server.WeaponServerInfo;
import ru.stalcraft.server.clans.ClanManager;
import ru.stalcraft.server.network.ServerPacketSender;
import ru.stalcraft.server.player.PlayerSavedDrop;
import ru.stalcraft.server.player.PlayerServerInfo;
import ru.stalcraft.tile.IPlayerQuitListener;

public class PlayerTracker
implements IPlayerTracker {
    public void onPlayerLogin(uf player) {
        PlayerServerInfo playerInfo = (PlayerServerInfo)PlayerUtils.getInfo(player);
        playerInfo.sendUpdateStalkerContainer();
        ServerPacketSender.sendReputation(player);
        ServerPacketSender.sendDeathScore(player);
        ServerPacketSender.sendAllEnemyClans(player);
        ServerPacketSender.sendClanData(player);
        ServerPacketSender.sendAllTags(player);
        ServerPacketSender.sendPlayerTag(player);
        if (player.aN() <= 0.0f) {
            ServerPacketSender.sendForceCooldown(player);
        }
        ClanManager.instance().tryAddPlayerToFlag(player);
    }

    public void onPlayerLogout(uf player) {
        PlayerServerInfo info = (PlayerServerInfo)PlayerUtils.getInfo(player);
        CommonProxy commonProxy = (CommonProxy)StalkerMain.getProxy();
        if (info.getLeashingPlayer() != null) {
            info.getLeashingPlayer().bn.a(new ye(StalkerMain.rope.cv, 1, 0));
        }
        Iterator i$ = info.quitListeners.iterator();
        IPlayerQuitListener listener = null;
        while (i$.hasNext()) {
            listener = (IPlayerQuitListener)i$.next();
            listener.onPlayerExit();
        }
        commonProxy.getAntiRelog().addReloggingPlayer((jv)player);
        info.setPositionToPrevious();
    }

    public void onPlayerChangedDimension(uf player) {
    }

    public void onPlayerRespawn(uf player) {
        PlayerServerInfo playerInfo = (PlayerServerInfo)PlayerUtils.getInfo(player);
        PlayerSavedDrop.retrieveDrops(player);
        playerInfo.sendUpdateStalkerContainer();
        playerInfo.resetInfo(new WeaponServerInfo(player), player);
        playerInfo.teleportToSpawnPoint();
    }
}

