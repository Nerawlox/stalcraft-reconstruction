/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.renderer;

public enum EnumPlanePosition {
    TOP("TOP", 0),
    BOTTOM("BOTTOM", 1),
    RIGHT("RIGHT", 2),
    LEFT("LEFT", 3),
    FRONT("FRONT", 4),
    BACK("BACK", 5);

    private static final EnumPlanePosition[] $VALUES;

    private EnumPlanePosition(String string2, int n2) {
    }

    static {
        $VALUES = new EnumPlanePosition[]{TOP, BOTTOM, RIGHT, LEFT, FRONT, BACK};
    }
}

