/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.server.clans;

public enum ClanWarState {
    NO_PEACE_OFFERED("NO_PEACE_OFFERED", 0),
    PEACE_OFFERED_1("PEACE_OFFERED_1", 1),
    PEACE_OFFERED_2("PEACE_OFFERED_2", 2);

    private static final ClanWarState[] $VALUES;

    private ClanWarState(String var1, int var2) {
    }

    static {
        $VALUES = new ClanWarState[]{NO_PEACE_OFFERED, PEACE_OFFERED_1, PEACE_OFFERED_2};
    }
}

