/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.constants;

public enum EnumQuestType {
    Item("Item", 0),
    Dialog("Dialog", 1),
    Kill("Kill", 2),
    Location("Location", 3);

    private static final EnumQuestType[] $VALUES;

    private EnumQuestType(String string2, int n2) {
    }

    static {
        $VALUES = new EnumQuestType[]{Item, Dialog, Kill, Location};
    }
}

