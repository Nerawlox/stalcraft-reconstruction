/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  hn
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
import ru.stalcraft.clans.ClanMember;
import ru.stalcraft.clans.ClanRank;
import ru.stalcraft.clans.IClan;
import ru.stalcraft.clans.ISpecialClan;
import ru.stalcraft.player.PlayerUtils;
import ru.stalcraft.server.clans.ClanManager;
import ru.stalcraft.server.clans.ClanWarState;
import ru.stalcraft.server.clans.SaveHandler;
import ru.stalcraft.server.clans.SpecialClanFields;

public class Clan
implements IClan {
    static final int MIN_MEMBERS_COUNT = 5;
    private ArrayList members = new ArrayList();
    ArrayList invites = new ArrayList();
    private int reputation;
    public final String name;
    int dissolutionTimer;
    private HashMap enemies = new HashMap();
    String rules = "";
    String logo = "";
    int landNumber = 0;
    public final SpecialClanFields specialClan;
    public int money;
    public boolean isAdminClan;

    Clan(String name, uf leader) {
        this.name = name;
        this.members.add(new ClanMember(leader.bu, ClanRank.LEADER));
        boolean isOp = MinecraftServer.F().af().e(leader.bu);
        this.dissolutionTimer = !isOp ? 0 : -1;
        this.addReputation(PlayerUtils.getInfo(leader).getReputation());
        this.specialClan = (SpecialClanFields)ClanManager.instance().config.specialClans.get(name);
        this.isAdminClan = isOp;
    }

    Clan(by tag) {
        this.name = tag.i("name");
        this.reputation = tag.e("reputation");
        this.dissolutionTimer = tag.e("dissolution_timer");
        this.rules = tag.i("rules");
        this.logo = tag.i("logo");
        this.landNumber = tag.e("land_number");
        this.money = tag.e("money");
        this.isAdminClan = tag.n("admin_clan");
        cg membersList = tag.m("members");
        for (int i2 = 0; i2 < membersList.c(); ++i2) {
            by memberTag = (by)membersList.b(i2);
            ClanRank memberRank = ClanRank.values()[memberTag.d("rank")];
            String memberName = memberTag.i("username");
            this.members.add(new ClanMember(memberName, memberRank));
        }
        this.specialClan = (SpecialClanFields)ClanManager.instance().config.specialClans.get(this.name);
    }

    by writeNBT() {
        by tag = new by();
        tag.a("name", this.name);
        tag.a("reputation", this.reputation);
        tag.a("dissolution_timer", this.dissolutionTimer);
        tag.a("rules", this.rules);
        tag.a("logo", this.logo);
        tag.a("land_number", this.landNumber);
        tag.a("money", this.money);
        tag.a("admin_clan", this.isAdminClan);
        cg membersList = new cg();
        for (ClanMember it2 : this.members) {
            by entry = new by();
            entry.a("username", it2.username);
            entry.a("rank", (short)it2.rank.ordinal());
            membersList.a(entry);
        }
        tag.a("members", membersList);
        cg enemiesList1 = new cg();
        for (Map.Entry entry1 : this.enemies.entrySet()) {
            by enemyTag = new by();
            enemyTag.a("name", ((Clan)entry1.getKey()).name);
            enemyTag.a("peace_offered", (Boolean)entry1.getValue());
            enemiesList1.a(enemyTag);
        }
        tag.a("enemies", enemiesList1);
        return tag;
    }

    public String getRules() {
        return this.rules;
    }

    public int getDissolutionTimer() {
        return this.dissolutionTimer;
    }

    void addEnemy(Clan enemy) {
        this.enemies.put(enemy, false);
    }

    void setEnemiesList(HashMap enemies) {
        this.enemies = enemies;
    }

    @Override
    public void addReputation(int amount) {
        this.reputation += amount;
    }

    public int getReputation() {
        return this.reputation;
    }

    public ArrayList getMembers() {
        return this.members;
    }

    @Override
    public void withdraw(uf player) {
        PlayerUtils.addMoney(player, this.money);
        this.money = 0;
    }

    public ArrayList getOnlineMembers() {
        ArrayList<uf> list = new ArrayList<uf>();
        List players = MinecraftServer.F().af().a;
        for (uf player : players) {
            if (PlayerUtils.getInfo(player).getClan() != this) continue;
            list.add(player);
        }
        return list;
    }

    public ClanMember getLeader() {
        ClanMember member;
        Iterator i$ = this.members.iterator();
        do {
            if (!i$.hasNext()) {
                return null;
            }
            member = (ClanMember)i$.next();
        } while (member.rank != ClanRank.LEADER);
        return member;
    }

    public void syncReputation(boolean debugIfOK) {
        int oldReputation = this.reputation;
        this.reputation = 0;
        hn scf = MinecraftServer.F().af();
        for (ClanMember member : this.members) {
            if (scf.f(member.username) != null) {
                this.addReputation(PlayerUtils.getInfo(scf.f(member.username)).getReputation());
                continue;
            }
            by tag = SaveHandler.getOfflinePlayer(member.username);
            by persistedTag = tag.l("ForgeData").l("PlayerPersisted");
            this.addReputation(persistedTag.e("reputation"));
        }
        if (debugIfOK || oldReputation != this.reputation) {
            Logger.debug("Reputation sync for clan " + this.name + ". Old value = " + oldReputation + ", new value = " + this.reputation);
        }
    }

    void joinClan(uf player) {
        this.members.add(new ClanMember(player.bu, ClanRank.MEMBER));
        if (this.dissolutionTimer >= 0 && this.members.size() >= 5) {
            this.dissolutionTimer = -1;
        }
        this.addReputation(PlayerUtils.getInfo(player).getReputation());
    }

    public void addInvite(String username) {
        this.invites.add(username.toLowerCase());
    }

    public boolean hasInvited(uf player) {
        return this.invites.contains(player.bu.toLowerCase());
    }

    void leaveClan(ClanMember member) {
        this.members.remove(member);
        hn scf = MinecraftServer.F().af();
        if (scf.f(member.username) != null) {
            this.addReputation(-PlayerUtils.getInfo(scf.f(member.username)).getReputation());
        } else {
            by tag = SaveHandler.getOfflinePlayer(member.username);
            by persistedTag = tag.l("ForgeData").l("PlayerPersisted");
            this.addReputation(-persistedTag.e("reputation"));
        }
    }

    public ClanMember getClanMember(String username) {
        ClanMember member;
        Iterator i$ = this.members.iterator();
        do {
            if (!i$.hasNext()) {
                return null;
            }
            member = (ClanMember)i$.next();
        } while (!member.username.equals(username));
        return member;
    }

    @Override
    public ClanMember getClanMember(uf player) {
        return this.getClanMember(player.bu);
    }

    void addPeaceOffer(Clan clan) {
        if (this.enemies.containsKey(clan)) {
            this.enemies.put(clan, true);
        }
    }

    void removePeaceOffer(Clan clan) {
        if (this.enemies.containsKey(clan)) {
            this.enemies.put(clan, false);
        }
    }

    boolean isPeaceOffered(Clan clan) {
        return !this.enemies.containsKey(clan) ? true : (Boolean)this.enemies.get(clan);
    }

    void removeEnemy(Clan clan) {
        this.enemies.remove(clan);
    }

    @Override
    public boolean isClanEnemy(IClan clan) {
        return this.enemies.containsKey(clan);
    }

    public String getLogo() {
        return this.logo;
    }

    @Override
    public int getMaxLandsCount() {
        return Math.max(0, 1 + this.reputation / 100);
    }

    public HashMap getEnemies() {
        HashMap answer = new HashMap();
        for (Map.Entry entry : this.enemies.entrySet()) {
            if (((Boolean)((Clan)entry.getKey()).enemies.get(this)).booleanValue()) {
                answer.put(entry.getKey(), ClanWarState.PEACE_OFFERED_2);
                continue;
            }
            if (((Boolean)entry.getValue()).booleanValue()) {
                answer.put(entry.getKey(), ClanWarState.PEACE_OFFERED_1);
                continue;
            }
            answer.put(entry.getKey(), ClanWarState.NO_PEACE_OFFERED);
        }
        return answer;
    }

    @Override
    public ISpecialClan getSpecialClan() {
        return this.specialClan;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isAdminClan() {
        return this.isAdminClan;
    }
}

