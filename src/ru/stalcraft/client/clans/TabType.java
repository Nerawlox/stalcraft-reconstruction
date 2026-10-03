/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.client.clans;

public enum TabType {
    INFO("INFO", 0),
    RULES("RULES", 1),
    LANDS("LANDS", 2),
    MEMBERS("MEMBERS", 3),
    CLANS("CLANS", 4);

    private static final TabType[] $VALUES;

    private TabType(String var1, int var2) {
    }

    static {
        $VALUES = new TabType[]{INFO, RULES, LANDS, MEMBERS, CLANS};
    }
}

