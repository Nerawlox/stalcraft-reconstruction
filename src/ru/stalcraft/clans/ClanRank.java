/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.clans;

public enum ClanRank {
    MEMBER("MEMBER", 0),
    OFFICER("OFFICER", 1),
    LEADER("LEADER", 2);

    private static final ClanRank[] $VALUES;

    private ClanRank(String var1, int var2) {
    }

    static {
        $VALUES = new ClanRank[]{MEMBER, OFFICER, LEADER};
    }
}

