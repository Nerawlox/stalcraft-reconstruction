/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.network;

import ru.stalcraft.network.PacketHandler;

public enum DebugGroup {
    WEAPONS("WEAPONS", 0),
    CLANS("CLANS", 1),
    PLAYERS_DATA("PLAYERS_DATA", 2),
    CLIENT_DATA("CLIENT_DATA", 3),
    ANOMALIES("ANOMALIES", 4),
    OTHER("OTHER", 5);

    private static final DebugGroup[] $VALUES;

    private DebugGroup(String var1, int var2) {
        PacketHandler.debugGroups.add(this);
    }

    static {
        $VALUES = new DebugGroup[]{WEAPONS, CLANS, PLAYERS_DATA, CLIENT_DATA, ANOMALIES, OTHER};
    }
}

