/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.clans;

import ru.stalcraft.clans.ClanRank;

public class ClanMember {
    public final String username;
    public ClanRank rank;

    public ClanMember(String username, ClanRank rank) {
        this.username = username;
        this.rank = rank;
    }

    public ClanRank getRank() {
        return this.rank;
    }
}

