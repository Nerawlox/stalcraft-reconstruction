/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.client.clans;

import java.util.ArrayList;
import java.util.HashSet;

public class ClientClanData {
    public int thePlayerRank = -1;
    public String thePlayerClan = null;
    public String leader = "";
    public String logo = "";
    public int landsCount;
    public int reputatuion;
    public int deathCount;
    public int membersCount;
    public int onlineMembersCount;
    public int removeTime;
    public int money;
    public int salaryState;
    public String rules = "";
    public ArrayList lands = new ArrayList();
    public ArrayList members = new ArrayList();
    public ArrayList clans = new ArrayList();
    public HashSet enemies = new HashSet();

    public void resetData() {
        this.leader = "";
        this.logo = "";
        this.landsCount = 0;
        this.reputatuion = 0;
        this.deathCount = 0;
        this.membersCount = 0;
        this.onlineMembersCount = 0;
        this.removeTime = -1;
        this.rules = "";
        this.lands.clear();
        this.members.clear();
        this.clans.clear();
    }

    public void parseInfo(String[] data) {
        this.logo = data[0];
        this.landsCount = Integer.parseInt(data[1]);
        this.reputatuion = Integer.parseInt(data[2]);
        this.membersCount = Integer.parseInt(data[3]);
        this.onlineMembersCount = Integer.parseInt(data[4]);
        this.removeTime = Integer.parseInt(data[5]);
        this.leader = data[6];
        this.money = Integer.parseInt(data[7]);
        this.salaryState = Integer.parseInt(data[8]);
    }

    public void clearRules() {
        this.rules = "";
    }

    public void clearMembers() {
        this.members.clear();
    }

    public void clearClans() {
        this.clans.clear();
    }

    public void clearLands() {
        this.lands.clear();
    }

    public void clearEnemies() {
        this.enemies.clear();
    }

    public void addRules(String newRules) {
        this.rules = this.rules + newRules;
    }

    public void parseEnemies(String[] data) {
        String[] arr$ = data;
        int len$ = data.length;
        for (int i$ = 0; i$ < len$; ++i$) {
            String str = arr$[i$];
            this.enemies.add(str);
        }
    }

    public void parseLands(String[] data) {
        int i2 = 0;
        while (i2 + 6 <= data.length) {
            ClientClanLand land = new ClientClanLand();
            land.name = data[i2];
            land.id = Integer.parseInt(data[i2 + 1]);
            land.x = Integer.parseInt(data[i2 + 2]);
            land.z = Integer.parseInt(data[i2 + 3]);
            land.membersCount = Integer.parseInt(data[i2 + 4]);
            land.isThePlayerMember = data[i2 + 5].equals("1");
            this.lands.add(land);
            i2 += 6;
        }
    }

    public void parseMembers(String[] data) {
        int i2 = 0;
        while (i2 + 3 <= data.length) {
            ClientClanMember member = new ClientClanMember();
            member.username = data[i2];
            member.rank = Integer.parseInt(data[i2 + 1]);
            member.online = data[i2 + 2].equals("1");
            this.members.add(member);
            i2 += 3;
        }
    }

    public void parseClans(String[] data) {
        int i2 = 0;
        while (i2 + 5 <= data.length) {
            if (data[i2].equals(this.thePlayerClan)) {
                i2 += 5;
                continue;
            }
            ClientOtherClan clan = new ClientOtherClan();
            clan.name = data[i2];
            clan.leader = data[i2 + 1];
            clan.warState = Integer.parseInt(data[i2 + 2]);
            clan.membersCount = Integer.parseInt(data[i2 + 3]);
            clan.landsCount = Integer.parseInt(data[i2 + 4]);
            this.clans.add(clan);
            i2 += 5;
        }
    }

    public void parseCommonData(String[] data) {
        this.thePlayerClan = data[0];
        this.thePlayerRank = Integer.parseInt(data[1]);
        if (this.thePlayerClan.isEmpty()) {
            this.clearEnemies();
        }
    }

    public class ClientClanLand
    implements IListable {
        public String name;
        public int id;
        public int x;
        public int z;
        public int membersCount;
        public boolean isThePlayerMember;

        @Override
        public String getString() {
            return this.name;
        }

        @Override
        public int getColor() {
            return this.isThePlayerMember ? 0x11AA11 : 0xFFFFFF;
        }
    }

    public static interface IListable {
        public String getString();

        public int getColor();
    }

    public class ClientOtherClan
    implements IListable {
        String name;
        String leader;
        int warState;
        int membersCount;
        int landsCount;

        @Override
        public String getString() {
            return this.name;
        }

        @Override
        public int getColor() {
            return this.warState == -1 ? 0xFFFFFF : 0xAA1111;
        }
    }

    public class ClientClanMember
    implements IListable {
        public String username;
        public int rank;
        public boolean online;

        @Override
        public String getString() {
            return this.username;
        }

        @Override
        public int getColor() {
            return 0xFFFFFF;
        }
    }
}

