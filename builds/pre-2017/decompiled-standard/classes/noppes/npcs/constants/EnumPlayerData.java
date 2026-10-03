/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.constants;

public enum EnumPlayerData {
    Players("Players", 0),
    Quest("Quest", 1),
    Dialog("Dialog", 2),
    Transport("Transport", 3),
    Bank("Bank", 4),
    Factions("Factions", 5);

    private static final EnumPlayerData[] $VALUES;

    private EnumPlayerData(String string2, int n2) {
    }

    static {
        $VALUES = new EnumPlayerData[]{Players, Quest, Dialog, Transport, Bank, Factions};
    }
}

