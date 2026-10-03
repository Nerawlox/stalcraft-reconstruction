/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.constants;

public enum EnumAnimation {
    NONE("NEAREST", 0),
    SITTING("SITTING", 1),
    LYING("LYING", 2),
    SNEAKING("SNEAKING", 3),
    DANCING("DANCING", 4),
    Aiming("Aiming", 5),
    CRAWLING("CRAWLING", 6),
    HUG("HUG", 7),
    CRY("CRY", 8),
    WAVING("WAVING", 9),
    BOW("BOW", 10);

    private static final EnumAnimation[] $VALUES;

    private EnumAnimation(String string2, int n2) {
    }

    public int getWalkingAnimation() {
        return this == SNEAKING ? 1 : (this == Aiming ? 2 : (this == DANCING ? 3 : 0));
    }

    static {
        $VALUES = new EnumAnimation[]{NONE, SITTING, LYING, SNEAKING, DANCING, Aiming, CRAWLING, HUG, CRY, WAVING, BOW};
    }
}

