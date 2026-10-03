/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.constants;

public enum EnumStandingType {
    RotateBody("RotateBody", 0),
    NoRotation("NoRotation", 1),
    Stalking("Stalking", 2),
    HeadRotation("HeadRotation", 3);

    private static final EnumStandingType[] $VALUES;

    private EnumStandingType(String string2, int n2) {
    }

    static {
        $VALUES = new EnumStandingType[]{RotateBody, NoRotation, Stalking, HeadRotation};
    }
}

