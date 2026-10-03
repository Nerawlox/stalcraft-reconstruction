/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.constants;

public enum EnumDayTime {
    Always("Always", 0),
    Night("Night", 1),
    Day("Day", 2);

    private static final EnumDayTime[] $VALUES;

    private EnumDayTime(String string2, int n2) {
    }

    static {
        $VALUES = new EnumDayTime[]{Always, Night, Day};
    }
}

