/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.constants;

public enum EnumPotionType {
    None("None", 0),
    Fire("Fire", 1),
    Poison("Poison", 2),
    Hunger("Hunger", 3),
    Weakness("Weakness", 4),
    Slowness("Slowness", 5),
    Nausea("Nausea", 6),
    Blindness("Blindness", 7),
    Wither("Wither", 8);

    private static final EnumPotionType[] $VALUES;

    private EnumPotionType(String string2, int n2) {
    }

    static {
        $VALUES = new EnumPotionType[]{None, Fire, Poison, Hunger, Weakness, Slowness, Nausea, Blindness, Wither};
    }
}

