/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.constants;

public enum EnumParticleType {
    None("None", 0, ""),
    Smoke("Smoke", 1, "smoke"),
    Portal("Portal", 2, "portal"),
    Redstone("Redstone", 3, "reddust"),
    Lightning("Lightning", 4, "magicCrit"),
    LargeSmoke("LargeSmoke", 5, "largesmoke"),
    Magic("Magic", 6, "witchMagic"),
    Enchant("Enchant", 7, "enchantmenttable"),
    Crit("Crit", 8, "crit");

    private static final EnumParticleType[] $VALUES;
    public String particleName;

    private EnumParticleType(String string2, int n2, String string3) {
        this.particleName = string3;
    }

    static {
        $VALUES = new EnumParticleType[]{None, Smoke, Portal, Redstone, Lightning, LargeSmoke, Magic, Enchant, Crit};
    }
}

