/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.server.clans;

import java.util.ArrayList;
import ru.stalcraft.clans.ClanMember;
import ru.stalcraft.clans.IClan;
import ru.stalcraft.clans.IFlag;
import ru.stalcraft.server.clans.Clan;
import ru.stalcraft.server.clans.ClanManager;
import ru.stalcraft.server.clans.FlagsLand;

public class Flag
implements IFlag {
    public final int id;
    public final int x;
    public final int y;
    public final int z;
    public final int dimension;
    public final Clan clan;
    private Clan invader = null;
    private String name;
    private int rentTimer;
    private final int maxRentTimer;
    private final int rent;
    private ArrayList members = new ArrayList();
    private static int nextTickId = 0;
    final int tickId;

    public Flag(by tag) {
        this.clan = ClanManager.instance().getClan(tag.i("clan"));
        this.name = tag.i("name");
        this.dimension = tag.e("dimension");
        this.x = tag.e("x");
        this.y = tag.e("y");
        this.z = tag.e("z");
        this.id = tag.e("id");
        this.maxRentTimer = tag.e("maxRentTimer");
        this.rent = tag.e("rent");
        cg membersList = tag.m("members");
        for (int i2 = 0; i2 < membersList.c(); ++i2) {
            ClanMember member = this.clan.getClanMember(((by)membersList.b(i2)).i("username"));
            if (member == null) continue;
            this.members.add(member);
        }
        this.tickId = nextTickId++ % 20;
    }

    public Flag(Clan clan, String name, int id, int dimension, int x2, int y2, int z2, FlagsLand land) {
        this.clan = clan;
        this.name = name;
        this.dimension = dimension;
        this.x = x2;
        this.y = y2;
        this.z = z2;
        this.id = id;
        this.maxRentTimer = land.maxRentTimer;
        this.rent = land.rent;
        this.tickId = nextTickId++ % 20;
    }

    public by writeNBT() {
        by tag = new by();
        tag.a("clan", this.clan.name);
        tag.a("name", this.name);
        tag.a("dimension", this.dimension);
        tag.a("x", this.x);
        tag.a("y", this.y);
        tag.a("z", this.z);
        tag.a("id", this.id);
        tag.a("rent", this.rent);
        tag.a("maxRentTimer", this.maxRentTimer);
        cg membersList = new cg();
        for (ClanMember member : this.members) {
            by memberTag = new by();
            memberTag.a("username", member.username);
            membersList.a(memberTag);
        }
        tag.a("members", membersList);
        return tag;
    }

    public boolean isMember(ClanMember member) {
        return this.members.contains(member);
    }

    public void addMember(ClanMember member) {
        this.members.add(member);
    }

    public void removeMember(ClanMember member) {
        this.members.remove(member);
    }

    public int getMembersCount() {
        return this.members.size();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void tick(int tickCounter) {
        if (tickCounter == this.tickId && ++this.rentTimer >= this.maxRentTimer) {
            this.rentTimer = 0;
            this.clan.money += this.rent;
        }
    }

    @Override
    public IClan getClan() {
        return this.clan;
    }

    @Override
    public int getPosZ() {
        return this.x;
    }

    @Override
    public int getPosY() {
        return this.y;
    }

    @Override
    public int getPosX() {
        return this.z;
    }
}

