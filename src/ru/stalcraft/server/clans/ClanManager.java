/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cl
 *  net.minecraft.server.MinecraftServer
 */
package ru.stalcraft.server.clans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.server.MinecraftServer;
import ru.stalcraft.Logger;
import ru.stalcraft.WarningType;
import ru.stalcraft.clans.ClanMember;
import ru.stalcraft.clans.ClanRank;
import ru.stalcraft.clans.IClan;
import ru.stalcraft.clans.IClanManager;
import ru.stalcraft.player.PlayerInfo;
import ru.stalcraft.player.PlayerUtils;
import ru.stalcraft.server.CommonProxy;
import ru.stalcraft.server.clans.Clan;
import ru.stalcraft.server.clans.Flag;
import ru.stalcraft.server.clans.FlagManager;
import ru.stalcraft.server.clans.SpecialClansConfig;
import ru.stalcraft.server.network.ServerPacketSender;
import ru.stalcraft.server.player.PlayerServerInfo;

public class ClanManager
implements IClanManager {
    private ArrayList clans = new ArrayList();
    public FlagManager flagManager = new FlagManager();
    private int clanTickTimer = 0;
    public SpecialClansConfig config = new SpecialClansConfig();

    public ClanManager() {
        this.config.readConfig();
    }

    public void tickClans() {
        if (++this.clanTickTimer >= 20) {
            ArrayList<Clan> clansToRemove = new ArrayList<Clan>();
            Iterator i$ = this.clans.iterator();
            Clan clan2 = null;
            while (i$.hasNext()) {
                clan2 = (Clan)i$.next();
                if (clan2.dissolutionTimer >= 0) {
                    clan2.dissolutionTimer += 20;
                }
                if (clan2.dissolutionTimer < 72000) continue;
                clansToRemove.add(clan2);
            }
            for (Clan clan2 : clansToRemove) {
                this.removeClan(clan2);
            }
            this.clanTickTimer = 0;
        }
        this.flagManager.tick();
    }

    public ArrayList getClanFlags(Clan clan) {
        return FlagManager.instance().getClanFlags(clan);
    }

    public void trySyncReputation(uf player) {
        Clan clan = this.getPlayerClan(player);
        if (clan == null) {
            Logger.warning(player, WarningType.INVALID_USER, "update reputation");
        } else if (clan.getClanMember((uf)player).rank == ClanRank.MEMBER) {
            Logger.warning(player, WarningType.ABUSE_OF_AUTHORITY, "update reputation");
        } else {
            int oldReputation = clan.getReputation();
            clan.syncReputation(false);
            player.a("\u0420\u0435\u043f\u0443\u0442\u0430\u0446\u0438\u044f \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0438 \u0441\u0438\u043d\u0445\u0440\u043e\u043d\u0438\u0437\u0438\u0440\u043e\u0432\u0430\u043d\u0430 (\u0438\u0437\u043c\u0435\u043d\u0435\u043d\u0430 \u0441 " + oldReputation + " \u043d\u0430 " + clan.getReputation() + ")");
        }
    }

    public void tryAddPlayerToFlag(uf player) {
        ArrayList clanFlags;
        PlayerInfo info = PlayerUtils.getInfo(player);
        if (info.getClan() != null && this.flagManager.getFlagByPlayer(player) == null && (clanFlags = this.flagManager.getClanFlags(info.getClan())).size() > 0) {
            ((Flag)clanFlags.get(player.q.s.nextInt(clanFlags.size()))).addMember(info.getClan().getClanMember(player));
        }
    }

    public void tryGetMoney(uf player) {
        PlayerServerInfo info = (PlayerServerInfo)PlayerUtils.getInfo(player);
        IClan clan = info.getClan();
        if (clan.getSpecialClan() != null) {
            if (info.canGetSalary()) {
                info.onWithdrawSalary();
                PlayerUtils.addMoney(player, clan.getSpecialClan().getSalary(info.getReputation()));
            }
        } else if (clan.getClanMember((uf)player).rank == ClanRank.LEADER) {
            clan.withdraw(player);
        }
    }

    public void trySetRank(uf officer, String username, ClanRank newRank) {
        Clan clan = (Clan)PlayerUtils.getInfo(officer).getClan();
        ClanMember officerClanMember = clan.getClanMember(officer.bu);
        if (officerClanMember.rank == ClanRank.MEMBER) {
            Logger.warning(officer, WarningType.ABUSE_OF_AUTHORITY, "set rank", username);
        } else {
            ClanMember playerClanMember = clan.getClanMember(username);
            if (playerClanMember != null && playerClanMember.rank != ClanRank.LEADER) {
                playerClanMember.rank = newRank;
                jv player = MinecraftServer.F().af().f(username);
                if (player != null) {
                    ServerPacketSender.sendClanData(player);
                }
                ServerPacketSender.sendClanMembers(officer);
            } else {
                Logger.warning(officer, WarningType.INVALID_TARGET, "set rank", username);
            }
        }
    }

    public void trySetLeader(uf oldLeader, String username) {
        Clan clan = (Clan)PlayerUtils.getInfo(oldLeader).getClan();
        ClanMember oldLeaderClanMember = clan.getClanMember(oldLeader.bu);
        if (oldLeaderClanMember.rank != ClanRank.LEADER) {
            Logger.warning(oldLeader, WarningType.ABUSE_OF_AUTHORITY, "set clan leader", username);
        } else {
            ClanMember newLeaderClanMember = clan.getClanMember(username);
            if (newLeaderClanMember == null) {
                Logger.warning(oldLeader, WarningType.INVALID_TARGET, "set clan leader", username);
            } else {
                oldLeaderClanMember.rank = ClanRank.OFFICER;
                newLeaderClanMember.rank = ClanRank.LEADER;
                jv player = MinecraftServer.F().af().f(username);
                if (player != null) {
                    ServerPacketSender.sendClanData(player);
                }
                ServerPacketSender.sendClanData(oldLeader);
                ServerPacketSender.sendClanMembers(oldLeader);
            }
        }
    }

    public void tryJoinClan(uf player, String clanName) {
        Clan clan = this.getClan(clanName);
        if (clan == null) {
            Logger.warning(player, WarningType.INVALID_TARGET, "join clan", clanName);
        } else if (PlayerUtils.getInfo(player).getClan() != null) {
            Logger.warning(player, WarningType.INVALID_USER, "join clan", clanName);
        } else if (!clan.hasInvited(player)) {
            Logger.warning(player, WarningType.ABUSE_OF_AUTHORITY, "join clan", clanName);
        } else {
            clan.joinClan(player);
            PlayerUtils.getInfo(player).setClan(clan);
            this.tryAddPlayerToFlag(player);
            ServerPacketSender.sendAllEnemyClans(player);
            ServerPacketSender.sendPlayerTag(player);
            ServerPacketSender.sendClanData(player);
            ServerPacketSender.sendClanGuiUpdate(player);
        }
    }

    public void tryAddRules(uf player, String newRules) {
        Clan clan = (Clan)PlayerUtils.getInfo(player).getClan();
        if (clan == null) {
            Logger.warning(player, WarningType.INVALID_USER, "add clan rules");
        } else {
            ClanMember clanMember = clan.getClanMember(player);
            if (clanMember.rank == ClanRank.MEMBER) {
                Logger.warning(player, WarningType.ABUSE_OF_AUTHORITY, "add clan rules");
            } else {
                clan.rules = clan.rules + newRules;
            }
        }
    }

    public void tryClearRules(uf player) {
        Clan clan = (Clan)PlayerUtils.getInfo(player).getClan();
        if (clan == null) {
            Logger.warning(player, WarningType.INVALID_USER, "clear clan rules");
        } else {
            ClanMember clanMember = clan.getClanMember(player);
            if (clanMember.rank == ClanRank.MEMBER) {
                Logger.warning(player, WarningType.ABUSE_OF_AUTHORITY, "clear clan rules");
            } else {
                clan.rules = "";
            }
        }
    }

    public void tryKickPlayer(uf kicker, String username) {
        Clan clan = (Clan)PlayerUtils.getInfo(kicker).getClan();
        if (clan == null) {
            Logger.warning(kicker, WarningType.INVALID_USER, "kick player", username);
        } else {
            ClanMember clanMember = clan.getClanMember(kicker);
            if (clanMember.rank == ClanRank.MEMBER) {
                Logger.warning(kicker, WarningType.ABUSE_OF_AUTHORITY, "kick player", username);
            } else if (this.getPlayerClan(username) != clan) {
                Logger.warning(kicker, WarningType.ABUSE_OF_AUTHORITY, "kick player", username);
            } else if (clan.getClanMember((String)username).rank != ClanRank.LEADER) {
                jv player = MinecraftServer.F().af().f(username);
                if (player != null) {
                    player.a("\u0412\u0430\u0441 \u0438\u0441\u043a\u043b\u044e\u0447\u0438\u043b \u0438\u0437 \u043a\u043b\u0430\u043d\u0430 \u0438\u0433\u0440\u043e\u043a " + kicker.bu + ".");
                }
                this.leaveClan(username);
                ServerPacketSender.sendClanMembers(kicker);
            }
        }
    }

    public void tryLeaveClan(uf player) {
        Clan clan = (Clan)PlayerUtils.getInfo(player).getClan();
        if (clan == null) {
            Logger.warning(player, WarningType.INVALID_USER, "leave clan");
        } else if (clan.getClanMember((uf)player).rank == ClanRank.LEADER) {
            Logger.warning(player, WarningType.INVALID_USER, "leave clan");
        } else {
            this.leaveClan(player.bu);
            ServerPacketSender.sendClanGuiUpdate(player);
        }
    }

    public void tryCancelPeaceOffer(uf player, String enemy) {
        Clan playerClan = (Clan)PlayerUtils.getInfo(player).getClan();
        if (playerClan == null) {
            Logger.warning(player, WarningType.INVALID_USER, "cancel peace offer", enemy);
        } else {
            ClanMember clanMember = playerClan.getClanMember(player);
            if (clanMember.rank == ClanRank.MEMBER) {
                Logger.warning(player, WarningType.ABUSE_OF_AUTHORITY, "cancel peace offer", enemy);
            } else {
                Clan enemyClan = this.getClan(enemy);
                if (enemyClan == null) {
                    Logger.warning(player, WarningType.INVALID_TARGET, "cancel peace offer", enemy);
                } else if (!playerClan.isClanEnemy(enemyClan)) {
                    Logger.warning(player, WarningType.INVALID_TARGET, "cancel peace offer", enemy);
                } else {
                    playerClan.removePeaceOffer(enemyClan);
                    ServerPacketSender.sendClansList(player);
                }
            }
        }
    }

    public void tryEndWar(uf player, String enemy) {
        Clan playerClan = (Clan)PlayerUtils.getInfo(player).getClan();
        if (playerClan == null) {
            Logger.warning(player, WarningType.INVALID_USER, "end war", enemy);
        } else {
            ClanMember clanMember = playerClan.getClanMember(player);
            if (clanMember.rank == ClanRank.MEMBER) {
                Logger.warning(player, WarningType.ABUSE_OF_AUTHORITY, "end war", enemy);
            } else {
                Clan enemyClan = this.getClan(enemy);
                if (enemyClan == null) {
                    Logger.warning(player, WarningType.INVALID_TARGET, "end war", enemy);
                } else if (!playerClan.isClanEnemy(enemyClan)) {
                    Logger.warning(player, WarningType.INVALID_TARGET, "end war", enemy);
                } else {
                    playerClan.addPeaceOffer(enemyClan);
                    if (enemyClan.isPeaceOffered(playerClan)) {
                        playerClan.removeEnemy(enemyClan);
                        enemyClan.removeEnemy(playerClan);
                        ServerPacketSender.sendEnemiesForClan(playerClan);
                        ServerPacketSender.sendEnemiesForClan(enemyClan);
                    }
                    ServerPacketSender.sendClansList(player);
                }
            }
        }
    }

    public void tryStartWar(uf player, String agressived) {
        Clan playerClan = (Clan)PlayerUtils.getInfo(player).getClan();
        if (playerClan != null) {
            ClanMember clanMember = playerClan.getClanMember(player);
            if (clanMember.rank == ClanRank.MEMBER) {
                Logger.warning(player, WarningType.ABUSE_OF_AUTHORITY, "start war", agressived);
            } else if (this.getClanFlags(playerClan).size() == 0) {
                Logger.warning(player, WarningType.INVALID_USER, "start war", agressived);
            } else {
                Clan agressivedClan = this.getClan(agressived);
                if (agressivedClan != null && this.getClanFlags(agressivedClan).size() != 0) {
                    if (playerClan.isClanEnemy(agressivedClan)) {
                        Logger.warning(player, WarningType.INVALID_TARGET, "start war", agressived);
                    } else {
                        playerClan.addEnemy(agressivedClan);
                        agressivedClan.addEnemy(playerClan);
                        ServerPacketSender.sendEnemiesForClan(playerClan);
                        ServerPacketSender.sendEnemiesForClan(agressivedClan);
                        ServerPacketSender.sendClansList(player);
                    }
                } else {
                    Logger.warning(player, WarningType.INVALID_TARGET, "start war", agressived);
                }
            }
        }
    }

    public void tryRemoveClan(uf requester) {
        Clan clan = (Clan)PlayerUtils.getInfo(requester).getClan();
        if (clan != null && clan.getClanMember((String)requester.bu).rank == ClanRank.LEADER) {
            Logger.warning(requester, WarningType.ABUSE_OF_AUTHORITY, "remove clan");
            this.removeClan(clan);
        }
    }

    public void tryAddInvite(uf inviter, String username) {
        Clan clan = (Clan)PlayerUtils.getInfo(inviter).getClan();
        jv invited = MinecraftServer.F().af().f(username);
        if (invited == null) {
            inviter.a("\u0422\u0430\u043a\u043e\u0433\u043e \u0438\u0433\u0440\u043e\u043a\u0430 \u043d\u0435 \u0441\u0443\u0449\u0435\u0441\u0442\u0432\u0443\u0435\u0442, \u043b\u0438\u0431\u043e \u043e\u043d \u043d\u0435 \u0432 \u0441\u0435\u0442\u0438!");
        } else {
            Clan invitedClan = (Clan)PlayerUtils.getInfo(invited).getClan();
            if (invitedClan != null) {
                inviter.a("\u042d\u0442\u043e\u0442 \u0438\u0433\u0440\u043e\u043a \u0443\u0436\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0442 \u0432 \u043a\u043b\u0430\u043d\u0435!");
            } else if (clan != null && clan.getClanMember((String)inviter.bu).rank != ClanRank.MEMBER) {
                clan.addInvite(username);
                ServerPacketSender.sendClanInvite(clan, invited, inviter);
                inviter.a("\u041f\u0440\u0438\u0433\u043b\u0430\u0448\u0435\u043d\u0438\u0435 \u0432\u044b\u0441\u043b\u0430\u043d\u043e.");
            }
        }
    }

    void removeClan(Clan clan) {
        Iterator i$ = ((List)clan.getMembers().clone()).iterator();
        ClanMember flag = null;
        while (i$.hasNext()) {
            flag = (ClanMember)i$.next();
            this.leaveClan(flag.username);
        }
        i$ = this.flagManager.getClanFlags(clan).iterator();
        Flag flag1 = null;
        while (i$.hasNext()) {
            flag1 = (Flag)i$.next();
            MinecraftServer.F().a(flag1.dimension).c(flag1.x, flag1.y, flag1.z, 0);
        }
        this.clans.remove(clan);
    }

    private void leaveClan(String username) {
        Clan clan = this.getPlayerClan(username);
        if (clan != null) {
            ClanMember member = clan.getClanMember(username);
            this.flagManager.onClanLeave(clan, member);
            clan.leaveClan(member);
            jv player = MinecraftServer.F().af().f(username);
            if (player != null) {
                PlayerUtils.getInfo(player).setClan(null);
                ServerPacketSender.sendPlayerTag(player);
                ServerPacketSender.sendClanData(player);
                ServerPacketSender.sendClanGuiUpdate(player);
            }
        }
    }

    public Clan getPlayerClan(uf player) {
        return this.getPlayerClan(player.bu);
    }

    public Clan getPlayerClan(String username) {
        Clan clan;
        Iterator i$ = this.clans.iterator();
        do {
            if (i$.hasNext()) continue;
            return null;
        } while ((clan = (Clan)i$.next()).getClanMember(username) == null);
        return clan;
    }

    @Override
    public Clan getClan(String name) {
        Clan clan;
        Iterator i$ = this.clans.iterator();
        do {
            if (!i$.hasNext()) {
                return null;
            }
            clan = (Clan)i$.next();
        } while (!clan.name.equals(name));
        return clan;
    }

    public void tryRegisterClan(String name, uf leader) {
        boolean isNameCorrect = ClanManager.isNameCorrect(name = name.trim());
        if (!isNameCorrect) {
            leader.a("\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435 \u0434\u043e\u0436\u043d\u043e \u0431\u044b\u0442\u044c \u0434\u043b\u0438\u043d\u043e\u0439 \u043e\u0442 4 \u0434\u043e 16 \u0441\u0438\u043c\u0432\u043e\u043b\u043e\u0432, \u0441\u043e\u0441\u0442\u043e\u044f\u0442\u044c \u0446\u0435\u043b\u0438\u043a\u043e\u043c \u0438\u0437 \u0440\u0443\u0441\u0441\u043a\u0438\u0445 \u043b\u0438\u0431\u043e \u0430\u043d\u0433\u043b\u0438\u0439\u0441\u043a\u0438\u0445 \u0431\u0443\u043a\u0432, \u0442\u0430\u043a\u0436\u0435 \u0434\u043e\u043f\u0443\u0441\u043a\u0430\u044e\u0442\u0441\u044f \u043f\u0440\u043e\u0431\u0435\u043b\u044b.");
        } else if (this.getClan(name) != null) {
            leader.a("\u0413\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0430 \u0441 \u0442\u0430\u043a\u0438\u043c \u043d\u0430\u0437\u0432\u0430\u043d\u0438\u0435\u043c \u0443\u0436\u0435 \u0441\u0443\u0449\u0435\u0441\u0442\u0432\u0443\u0435\u0442!");
        } else if (name.length() > 3 && PlayerUtils.getInfo(leader).getClan() == null) {
            Clan clan = new Clan(name, leader);
            this.clans.add(clan);
            PlayerUtils.getInfo(leader).setClan(clan);
            ServerPacketSender.sendClanData(leader);
            ServerPacketSender.sendPlayerTag(leader);
            ServerPacketSender.sendClanGuiUpdate(leader);
            leader.a("\u0413\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0430 \u0441\u043e\u0437\u0434\u0430\u043d\u0430.");
            if (clan.dissolutionTimer >= 0) {
                leader.a(" \u0423 \u0432\u0430\u0441 \u0435\u0441\u0442\u044c \u0447\u0430\u0441, \u0447\u0442\u043e\u0431\u044b \u043d\u0430\u0431\u0440\u0430\u0442\u044c \u0432 \u043d\u0435\u0435 5 \u0438\u0433\u0440\u043e\u043a\u043e\u0432, \u0438\u043d\u0430\u0447\u0435 \u043e\u043d\u0430 \u0431\u0443\u0434\u0435\u0442 \u0440\u0430\u0441\u043f\u0443\u0449\u0435\u043d\u0430.");
            }
        }
    }

    public void readClans(by tag) {
        cg tagList = tag.m("clans");
        HashMap<Clan, cg> enemiesTag = new HashMap<Clan, cg>();
        Clan clan2 = null;
        by i$ = null;
        for (int it2 = 0; it2 < tagList.c(); ++it2) {
            i$ = (by)tagList.b(it2);
            clan2 = new Clan(i$);
            this.clans.add(clan2);
            enemiesTag.put(clan2, i$.m("enemies"));
        }
        for (Map.Entry var10 : enemiesTag.entrySet()) {
            HashMap<Clan, Boolean> var12 = new HashMap<Clan, Boolean>();
            Clan enemyClan = null;
            for (int i2 = 0; i2 < ((cg)((Object)var10.getValue())).c(); ++i2) {
                enemyClan = this.getClan(((by)((cg)((Object)var10.getValue())).b(i2)).i("name"));
                if (enemyClan != null) {
                    var12.put(enemyClan, ((by)((cg)((Object)var10.getValue())).b(i2)).n("peace_offered"));
                }
                ((Clan)var10.getKey()).setEnemiesList(var12);
            }
        }
        this.flagManager.readNBT(tag.l("lands"));
        for (Clan clan2 : this.clans) {
            clan2.syncReputation(false);
        }
    }

    public boolean doesClanExist(Clan clan) {
        return this.clans.contains(clan);
    }

    public void writeClans(by tag) {
        cg tagList = new cg();
        Iterator i$ = this.clans.iterator();
        Clan clan = null;
        while (i$.hasNext()) {
            clan = (Clan)i$.next();
            tagList.a(clan.writeNBT());
        }
        tag.a("clans", tagList);
        tag.a("lands", (cl)this.flagManager.writeNBT());
    }

    public ArrayList getClans() {
        return this.clans;
    }

    public static boolean isNameCorrect(String name) {
        return (name = name.trim()).length() >= 4 && name.length() <= 16 && (name.matches("[a-zA-Z\\s]*") || name.matches("[\u0430-\u044f\u0410-\u042f\\s]*"));
    }

    public static ClanManager instance() {
        return CommonProxy.clanManager;
    }
}

