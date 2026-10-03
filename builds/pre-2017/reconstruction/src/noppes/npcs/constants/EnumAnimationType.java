/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.constants;

public enum EnumAnimationType {
    Normal("Normal", 0),
    Sitting("Sitting", 1),
    Lying("Lying", 2),
    Sneaking("Sneaking", 3),
    Dancing("Dancing", 4),
    Aiming("Aiming", 5);

    private static final EnumAnimationType[] $VALUES;

    private EnumAnimationType(String string2, int n2) {
    }

    public int getWalkingAnimation() {
        return this == Sneaking ? 1 : (this == Aiming ? 2 : (this == Dancing ? 3 : 0));
    }

    static {
        $VALUES = new EnumAnimationType[]{Normal, Sitting, Lying, Sneaking, Dancing, Aiming};
    }
}

