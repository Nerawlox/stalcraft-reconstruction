/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.network.PacketDispatcher
 *  cpw.mods.fml.common.network.Player
 *  ea
 *  hn
 *  jq
 *  net.minecraft.server.MinecraftServer
 */
package ru.stalcraft.server.network;

import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.MinecraftServer;
import ru.stalcraft.Logger;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.clans.ClanMember;
import ru.stalcraft.entity.EntityTurrel;
import ru.stalcraft.network.IOpcode;
import ru.stalcraft.network.PacketHandler;
import ru.stalcraft.player.PlayerInfo;
import ru.stalcraft.player.PlayerUtils;
import ru.stalcraft.proxy.IServerProxy;
import ru.stalcraft.server.clans.Clan;
import ru.stalcraft.server.clans.ClanManager;
import ru.stalcraft.server.clans.ClanWarState;
import ru.stalcraft.server.clans.Flag;
import ru.stalcraft.server.clans.FlagManager;
import ru.stalcraft.server.network.ClientOpcodes;
import ru.stalcraft.server.player.PlayerServerInfo;
import ru.stalcraft.tile.TileEntityMachineGun;

public class ServerPacketSender {
    public static void sendUpdateHitmarker(uf hitEntity) {
        ServerPacketSender.sendToPlayer(hitEntity, ClientOpcodes.HIT_MARKER_UPDATE, new Object[0]);
    }

    public static void sendHasQuitted(uf player) {
        ServerPacketSender.sendToTrackingPlayers(player, ClientOpcodes.PLAYER_QUIT, player.k);
    }

    public static void sendTileEntityEvent(asp tile, int arg1, int arg2) {
        ServerPacketSender.sendToTrackingPlayers(tile, ClientOpcodes.TILE_ENTITY_EVENT, tile.l, tile.m, tile.n, arg1, arg2);
    }

    public static void sendWindowId(uf player, int windowId) {
        ServerPacketSender.sendToPlayer(player, ClientOpcodes.WINDOW_ID, windowId);
    }

    public static void sendAddVelocity(uf entity, float x2, float y2, float z2) {
        ServerPacketSender.sendToPlayer(entity, ClientOpcodes.ADD_VELOCITY, entity.k, Float.valueOf(x2), Float.valueOf(y2), Float.valueOf(z2));
    }

    public static void sendForceCooldown(uf player) {
        ServerPacketSender.sendToPlayer(player, ClientOpcodes.FORCE_COOLDOWN, PlayerUtils.getInfo(player).getForceCooldown());
    }

    public static void sendClanData(uf player) {
        Clan clan = (Clan)((PlayerServerInfo)PlayerUtils.getInfo(player)).getClan();
        if (clan != null) {
            ServerPacketSender.sendToPlayer(player, ClientOpcodes.CLAN_COMMON_DATA, clan.name, clan.getClanMember((uf)player).rank.ordinal());
        } else {
            ServerPacketSender.sendToPlayer(player, ClientOpcodes.CLAN_COMMON_DATA, "", -1);
        }
    }

    public static void sendAllEnemyClans(uf player) {
        Clan clan = (Clan)((PlayerServerInfo)PlayerUtils.getInfo(player)).getClan();
        ServerPacketSender.sendToPlayer(player, ClientOpcodes.CLAN_CLEAR_ENEMIES, new Object[0]);
        if (clan != null) {
            HashMap wars = clan.getEnemies();
            Iterator it2 = wars.entrySet().iterator();
            Object[] data = null;
            int i2 = 0;
            while (it2.hasNext()) {
                if (data == null) {
                    data = new Object[Math.min(50, wars.size() - i2)];
                }
                data[i2 % 50] = ((Clan)it2.next().getKey()).name;
                if (++i2 % 50 != 0 && it2.hasNext()) continue;
                ServerPacketSender.sendToPlayer(player, ClientOpcodes.CLAN_ADD_ENEMIES, data);
                data = null;
            }
        }
    }

    public static void sendEnemiesForClan(Clan clan) {
        if (clan != null) {
            ArrayList<uf> players = new ArrayList<uf>();
            Iterator wars = MinecraftServer.F().af().a.iterator();
            uf it2 = null;
            while (wars.hasNext()) {
                it2 = (uf)wars.next();
                if (PlayerUtils.getInfo(it2).getClan() != clan) continue;
                ServerPacketSender.sendToPlayer(it2, ClientOpcodes.CLAN_CLEAR_ENEMIES, new Object[0]);
                players.add(it2);
            }
            HashMap var8 = clan.getEnemies();
            Iterator var9 = var8.entrySet().iterator();
            Object[] data = null;
            int i2 = 0;
            uf player = null;
            while (var9.hasNext()) {
                if (data == null) {
                    data = new Object[Math.min(50, var8.size() - i2)];
                }
                data[i2 % 50] = ((Clan)var9.next().getKey()).name;
                if (++i2 % 50 != 0 && var9.hasNext()) continue;
                var9 = players.iterator();
                while (var9.hasNext()) {
                    player = (uf)((Object)var9.next());
                    ServerPacketSender.sendToPlayer(player, ClientOpcodes.CLAN_ADD_ENEMIES, data);
                }
                data = null;
            }
        }
    }

    public static void sendClanLands(uf player) {
        Clan clan = (Clan)PlayerUtils.getInfo(player).getClan();
        hn scf = MinecraftServer.F().af();
        if (clan == null) {
            ServerPacketSender.sendClanGuiUpdate(player);
        } else {
            ServerPacketSender.sendToPlayer(player, ClientOpcodes.CLAN_CLEAR_LANDS, new Object[0]);
            ArrayList flags = FlagManager.instance().getClanFlags(clan);
            ClanMember member = clan.getClanMember(player);
            Object[] data = null;
            Flag flag = null;
            for (int i2 = 0; i2 < (flags.size() - 1) / 25 + 1; ++i2) {
                data = new Object[Math.min(25, flags.size() - i2 * 25) * 6];
                for (int j2 = 0; j2 < 25 && j2 < flags.size() - i2 * 25; ++j2) {
                    flag = (Flag)flags.get(i2 * 25 + j2);
                    data[j2 * 6] = flag.getName();
                    data[j2 * 6 + 1] = flag.id;
                    data[j2 * 6 + 2] = flag.x;
                    data[j2 * 6 + 3] = flag.z;
                    data[j2 * 6 + 4] = flag.getMembersCount();
                    data[j2 * 6 + 5] = flag.isMember(member) ? 1 : 0;
                }
                ServerPacketSender.sendToPlayer(player, ClientOpcodes.CLAN_LANDS, data);
            }
        }
    }

    public static void sendClanMembers(uf player) {
        Clan clan = (Clan)PlayerUtils.getInfo(player).getClan();
        hn scf = MinecraftServer.F().af();
        if (clan == null) {
            ServerPacketSender.sendClanGuiUpdate(player);
        } else {
            ServerPacketSender.sendToPlayer(player, ClientOpcodes.CLAN_CLEAR_MEMBERS, new Object[0]);
            ArrayList members = clan.getMembers();
            Object[] data = null;
            ClanMember member = null;
            for (int i2 = 0; i2 < (clan.getMembers().size() - 1) / 50 + 1; ++i2) {
                data = new Object[Math.min(50, clan.getMembers().size() - i2 * 50) * 3];
                for (int j2 = 0; j2 < 50 && j2 < clan.getMembers().size() - i2 * 50; ++j2) {
                    member = (ClanMember)members.get(i2 * 50 + j2);
                    data[j2 * 3] = member.username;
                    data[j2 * 3 + 1] = member.rank.ordinal();
                    data[j2 * 3 + 2] = scf.f(member.username) == null ? 0 : 1;
                }
                ServerPacketSender.sendToPlayer(player, ClientOpcodes.CLAN_MEMBERS, data);
            }
        }
    }

    public static void sendClansList(uf player) {
        Clan playerClan = (Clan)PlayerUtils.getInfo(player).getClan();
        if (playerClan != null) {
            HashMap wars = playerClan.getEnemies();
            ArrayList clans = ClanManager.instance().getClans();
            ServerPacketSender.sendToPlayer(player, ClientOpcodes.CLAN_CLEAR_LIST, new Object[0]);
            Object[] data = null;
            Clan clan = null;
            for (int i2 = 0; i2 < (clans.size() - 1) / 25 + 1; ++i2) {
                data = new Object[Math.min(25, clans.size() - i2 * 25) * 5];
                for (int j2 = 0; j2 < 25 && j2 < clans.size() - i2 * 25; ++j2) {
                    clan = (Clan)clans.get(i2 * 25 + j2);
                    data[j2 * 5] = clan.name;
                    data[j2 * 5 + 1] = clan.getLeader().username;
                    data[j2 * 5 + 2] = wars.containsKey(clan) ? Integer.valueOf(((ClanWarState)((Object)wars.get(clan))).ordinal()) : Integer.valueOf(-1);
                    data[j2 * 5 + 3] = clan.getMembers().size();
                    data[j2 * 5 + 4] = FlagManager.instance().getClanFlags(clan).size();
                }
                ServerPacketSender.sendToPlayer(player, ClientOpcodes.CLAN_LIST, data);
            }
        } else {
            ServerPacketSender.sendClanGuiUpdate(player);
        }
    }

    public static void sendClanRules(uf player) {
        Clan clan = (Clan)PlayerUtils.getInfo(player).getClan();
        if (clan == null) {
            ServerPacketSender.sendClanGuiUpdate(player);
        } else {
            ServerPacketSender.sendToPlayer(player, ClientOpcodes.CLAN_CLEAR_RULES, new Object[0]);
            for (int part = 0; part < (clan.getRules().length() - 1) / 1000 + 1; ++part) {
                ServerPacketSender.sendToPlayer(player, ClientOpcodes.CLAN_ADD_RULES, clan.getRules().substring(part * 1000, Math.min(clan.getRules().length(), part * 1000 + 1000)));
            }
        }
    }

    public static void sendClanInformation(uf player) {
        PlayerServerInfo info = (PlayerServerInfo)PlayerUtils.getInfo(player);
        Clan clan = (Clan)info.getClan();
        if (clan == null) {
            ServerPacketSender.sendClanGuiUpdate(player);
        } else {
            int salaryState = 0;
            if (clan.specialClan != null) {
                ++salaryState;
                if (info.canGetSalary()) {
                    ++salaryState;
                }
            }
            ServerPacketSender.sendToPlayer(player, ClientOpcodes.CLAN_INFO, clan.getLogo(), ClanManager.instance().getClanFlags(clan).size(), clan.getReputation(), clan.getMembers().size(), clan.getOnlineMembers().size(), clan.getDissolutionTimer(), clan.getLeader().username, clan.money, salaryState);
        }
    }

    public static void sendClanGuiUpdate(uf player) {
        ServerPacketSender.sendToPlayer(player, ClientOpcodes.CLAN_GUI_UPDATE, new Object[0]);
    }

    public static void sendClanInvite(Clan clan, uf invited, uf inviter) {
        ServerPacketSender.sendToPlayer(invited, ClientOpcodes.CLAN_INVITE_SERVER_REQUEST, clan.name, inviter.bu);
    }

    public static void sendReputation(uf player) {
        ServerPacketSender.sendToPlayer(player, ClientOpcodes.REPUTATION, PlayerUtils.getInfo(player).getReputation());
    }

    public static void sendDeathScore(uf player) {
        ServerPacketSender.sendToPlayer(player, ClientOpcodes.DEATH_SCORE, PlayerUtils.getInfo(player).getDeathScore());
    }

    public static void sendAllTags(uf receiver) {
        ClanManager clanManager = ClanManager.instance();
        List players = MinecraftServer.F().af().a;
        Object[] data = null;
        uf player = null;
        PlayerServerInfo info = null;
        for (int i2 = 0; i2 < (players.size() - 1) / 25 + 1; ++i2) {
            data = new Object[Math.min(25, players.size() - i2 * 25) * 4];
            for (int j2 = 0; j2 < 25 && j2 < players.size() - i2 * 25; ++j2) {
                player = (uf)players.get(i2 * 25 + j2);
                info = (PlayerServerInfo)PlayerUtils.getInfo(player);
                data[j2 * 4] = player.bu;
                data[j2 * 4 + 1] = info.getReputation();
                data[j2 * 4 + 2] = info.getClan() == null ? "" : info.getClan().getName();
                data[j2 * 4 + 3] = info.isPlayerAgressive() ? 1 : 0;
            }
            ServerPacketSender.sendToPlayer(receiver, ClientOpcodes.TAG_LIST, data);
        }
    }

    public static void sendPlayerTag(uf player) {
        PlayerServerInfo info = (PlayerServerInfo)PlayerUtils.getInfo(player);
        Clan clan = (Clan)info.getClan();
        String clanStr = clan == null ? "" : clan.name;
        ServerPacketSender.sendToAll(ClientOpcodes.TAG_LIST, player.bu, info.getReputation(), clanStr, info.isPlayerAgressive() ? 1 : 0);
    }

    public static void sendHandcuffsRequest(uf handcuffer, uf toHandcuff) {
        ServerPacketSender.sendToPlayer(toHandcuff, ClientOpcodes.HANDCUFFS_SERVER_REQUEST, handcuffer.k);
    }

    public static void sendEjectionStartToPlayer(Player player, int id, int age) {
        PacketDispatcher.sendPacketToPlayer((ey)ServerPacketSender.createPacket(ClientOpcodes.EJECTION_START, id, age), (Player)player);
    }

    public static void sendEjectionStart(int id, int age) {
        ServerPacketSender.sendToAll(ClientOpcodes.EJECTION_START, id, age);
    }

    public static void sendEjectionEnd() {
        ServerPacketSender.sendToAll(ClientOpcodes.EJECTION_END, new Object[0]);
    }

    public static void syncContamination(uf player, int[] levels) {
        ServerPacketSender.sendToPlayer(player, ClientOpcodes.CONTAMINATIONS, levels[0], levels[1], levels[2], levels[3]);
    }

    public static void sendShoot(of shooter, boolean hasFlash) {
        if (shooter instanceof uf) {
            ServerPacketSender.sendToTrackingPlayers((uf)shooter, ClientOpcodes.SHOOT, shooter.k, hasFlash);
        } else {
            ServerPacketSender.sendToTrackingPlayers(shooter, ClientOpcodes.SHOOT, shooter.k, hasFlash);
        }
    }

    public static void sendReloadStart(of shooter) {
        if (shooter instanceof uf) {
            ServerPacketSender.sendToTrackingPlayers((uf)shooter, ClientOpcodes.RELOAD_START, shooter.k);
        } else {
            ServerPacketSender.sendToTrackingPlayers(shooter, ClientOpcodes.RELOAD_START, shooter.k);
        }
    }

    public static void sendReloadFinish(uf player) {
        ServerPacketSender.sendToTrackingPlayers(player, ClientOpcodes.RELOAD_END, player.k);
    }

    public static void sendEntityPos(nn entity) {
        ServerPacketSender.sendToTrackingPlayers(entity, ClientOpcodes.ENTITY_POS, entity.k, Float.valueOf((float)entity.u), Float.valueOf((float)entity.v), Float.valueOf((float)entity.w));
    }

    public static void sendBackpack(uf player, int backpack) {
        ServerPacketSender.sendToTrackingPlayers(player, ClientOpcodes.BACKPACK, player.k, backpack);
    }

    public static void sendEquippedWeapons(uf player, ye rifle, ye pistol) {
        ServerPacketSender.sendToTrackingPlayers(player, ClientOpcodes.EQUIPPED_WEAPONS, ServerPacketSender.createEquippedWeaponsPacket(player, rifle, pistol));
    }

    private static Object[] createEquippedWeaponsPacket(uf player, ye rifle, ye pistol) {
        by rifleTag = rifle == null ? new by() : PlayerUtils.getTag(rifle);
        by pistolTag = pistol == null ? new by() : PlayerUtils.getTag(pistol);
        return new Object[]{player.k, rifle == null ? 0 : rifle.d, rifle == null ? 0 : rifle.b, rifle == null ? 0 : rifle.k(), rifleTag.n("flashlight") ? 1 : 0, rifleTag.n("silencer") ? 1 : 0, rifleTag.n("sight") ? 1 : 0, pistol == null ? 0 : pistol.d, pistol == null ? 0 : pistol.b, pistol == null ? 0 : pistol.k(), pistolTag.n("flashlight") ? 1 : 0, pistolTag.n("silencer") ? 1 : 0, pistolTag.n("sight") ? 1 : 0};
    }

    public static void sendRotation(nn entity, float yaw, float pitch) {
        ServerPacketSender.sendToTrackingPlayers(entity, ClientOpcodes.ROTATION, entity.k, Float.valueOf(yaw), Float.valueOf(pitch));
    }

    public static void sendTurrelShoot(EntityTurrel turrel) {
        ServerPacketSender.sendToTrackingPlayers(turrel, ClientOpcodes.TURREL_SHOOT, turrel.k);
    }

    public static void sendFlashlight(uf player, boolean value) {
        ServerPacketSender.sendToTrackingPlayers(player, ClientOpcodes.FLASHLIGHT, value ? 1 : 0, player.k);
    }

    public static void sendMachinegunState(uf player, TileEntityMachineGun gun, boolean join) {
        if (gun == null) {
            ServerPacketSender.sendToTrackingPlayers(player, ClientOpcodes.MACHINEGUN_INFO, join ? 1 : 0, 0, 0, 0, player.k);
        } else {
            ServerPacketSender.sendToTrackingPlayers(player, ClientOpcodes.MACHINEGUN_INFO, join ? 1 : 0, gun.l, gun.m, gun.n, player.k);
        }
    }

    public static void sendHandcuffs(uf player, boolean handcuffs) {
        ServerPacketSender.sendToTrackingPlayers(player, ClientOpcodes.HANDCUFFS, handcuffs ? 1 : 0, player.k);
    }

    public static void sendLeashing(uf follower, uf followed) {
        ServerPacketSender.sendToTrackingPlayers(follower, ClientOpcodes.LEASHING, follower.k, followed == null ? 0 : followed.k);
    }

    public static void sendStartWatchingPackets(uf player, uf watcher) {
        PlayerInfo info = PlayerUtils.getInfo(player);
        ServerPacketSender.sendToPlayer(watcher, ClientOpcodes.BACKPACK, player.k, info.stInv.getBackpack());
        ServerPacketSender.sendToPlayer(watcher, ClientOpcodes.EQUIPPED_WEAPONS, ServerPacketSender.createEquippedWeaponsPacket(player, info.weaponInfo.getRifle(), info.weaponInfo.getPistol()));
        ServerPacketSender.sendToPlayer(watcher, ClientOpcodes.FLASHLIGHT, info.weaponInfo.isFlashlightEnabled() ? 1 : 0, player.k);
        ServerPacketSender.sendToPlayer(watcher, ClientOpcodes.HANDCUFFS, info.getHandcuffs() ? 1 : 0, player.k);
        ServerPacketSender.sendToPlayer(watcher, ClientOpcodes.LEASHING, player.k, info.getLeashingPlayer() == null ? 0 : info.getLeashingPlayer().k);
        if (info.weaponInfo.currentGun == null) {
            ServerPacketSender.sendToPlayer(watcher, ClientOpcodes.MACHINEGUN_INFO, 0, 0, 0, 0, player.k);
        } else {
            TileEntityMachineGun gun = info.weaponInfo.currentGun;
            ServerPacketSender.sendToPlayer(watcher, ClientOpcodes.MACHINEGUN_INFO, 1, gun.l, gun.m, gun.n, player.k);
        }
        if (!StalkerMain.getProxy().isRemote() && ((IServerProxy)StalkerMain.getProxy()).getAntiRelog().isPlayerRelogging((jv)player)) {
            ServerPacketSender.sendToPlayer(watcher, ClientOpcodes.PLAYER_QUIT, player.k);
        }
    }

    public static void sendUpdateStalkerInventory(uf par1) {
        ServerPacketSender.sendToPlayer(par1, ClientOpcodes.UPDATE_STALKER_INVENTORY, new Object[0]);
    }

    private static void sendToAll(ClientOpcodes opcode, Object ... data) {
        PacketDispatcher.sendPacketToAllPlayers((ey)ServerPacketSender.createPacket(opcode, data));
        if (PacketHandler.debugGroups.contains((Object)opcode.getGroup()) && PacketHandler.debugOpcodes.contains(opcode) && PacketHandler.minPriority.ordinal() <= opcode.getPriority().ordinal()) {
            Logger.debug("Sending packet " + opcode.getName() + " to all players");
            PacketHandler.printArgs(data);
        }
    }

    private static void sendToTrackingPlayers(asp tile, ClientOpcodes opcode, Object ... data) {
        ea packet = ServerPacketSender.createPacket(opcode, data);
        adr chunk = tile.az().d(tile.l, tile.n);
        int x2 = ls.c((double)tile.l / 16.0);
        int z2 = ls.c((double)tile.n / 16.0);
        jq pi = ((js)tile.az()).s().a(x2, z2, false);
        if (pi != null) {
            pi.a((ey)packet);
        }
        if (PacketHandler.debugGroups.contains((Object)opcode.getGroup()) && PacketHandler.debugOpcodes.contains(opcode) && PacketHandler.minPriority.ordinal() <= opcode.getPriority().ordinal()) {
            Logger.debug("Sending packet " + opcode.getName() + " to all players that tracking tile " + tile);
            PacketHandler.printArgs(data);
        }
    }

    private static void sendToTrackingPlayers(nn entity, ClientOpcodes opcode, Object ... data) {
        ea packet = ServerPacketSender.createPacket(opcode, data);
        ((js)entity.q).q().a(entity, (ey)packet);
        if (PacketHandler.debugGroups.contains((Object)opcode.getGroup()) && PacketHandler.debugOpcodes.contains(opcode) && PacketHandler.minPriority.ordinal() <= opcode.getPriority().ordinal()) {
            Logger.debug("Sending packet " + opcode.getName() + " to players that tracking entity " + entity.toString());
            PacketHandler.printArgs(data);
        }
    }

    private static void sendToTrackingPlayers(uf player, ClientOpcodes opcode, Object ... data) {
        ea packet = ServerPacketSender.createPacket(opcode, data);
        ((js)player.q).q().a(player, (ey)packet);
        ((jv)player).a.b((ey)packet);
        if (PacketHandler.debugGroups.contains((Object)opcode.getGroup()) && PacketHandler.debugOpcodes.contains(opcode) && PacketHandler.minPriority.ordinal() <= opcode.getPriority().ordinal()) {
            Logger.debug("Sending packet " + opcode.getName() + " to players that tracking player " + player.bu);
            PacketHandler.printArgs(data);
        }
    }

    private static void sendToPlayer(uf receiver, ClientOpcodes opcode, Object ... data) {
        ((jv)receiver).a.b((ey)ServerPacketSender.createPacket(opcode, data));
        if (PacketHandler.debugGroups.contains((Object)opcode.getGroup()) && PacketHandler.debugOpcodes.contains(opcode) && PacketHandler.minPriority.ordinal() <= opcode.getPriority().ordinal()) {
            Logger.debug("Sending packet " + opcode.getName() + " to player " + receiver.bu);
            PacketHandler.printArgs(data);
        }
    }

    private static ea createPacket(IOpcode opcode, Object ... data) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(opcode.getOrdinal()).append(":").append(data.length);
        for (int str = 0; str < data.length; ++str) {
            buffer.append(":");
            buffer.append(data[str].toString().replaceAll("\\\\", "\\\\\\\\").replaceAll(":", "\\\\:"));
        }
        return new ea("modST", buffer.toString().getBytes(Charset.forName("UTF-8")));
    }
}

