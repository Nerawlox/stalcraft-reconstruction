/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.constants;

public enum EnumJobType {
    None("None", 0),
    Bard("Bard", 1),
    Healer("Healer", 2),
    Guard("Guard", 3),
    ItemGiver("ItemGiver", 4),
    Boss("Boss", 5),
    Spawner("Spawner", 6),
    Conversation("Conversation", 7);

    private static final EnumJobType[] $VALUES;

    private EnumJobType(String string2, int n2) {
    }

    static {
        $VALUES = new EnumJobType[]{None, Bard, Healer, Guard, ItemGiver, Boss, Spawner, Conversation};
    }
}

