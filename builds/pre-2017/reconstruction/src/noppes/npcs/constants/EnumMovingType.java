/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.constants;

import java.util.ArrayList;

public enum EnumMovingType {
    Standing("Standing", 0, "ai.standing"),
    Wandering("Wandering", 1, "ai.wandering"),
    MovingPath("MovingPath", 2, "ai.movingpath");

    private static final EnumMovingType[] $VALUES;
    String name;

    private EnumMovingType(String string2, int n2, String string3) {
        this.name = string3;
    }

    public static String[] names() {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (EnumMovingType enumMovingType : EnumMovingType.values()) {
            arrayList.add(enumMovingType.name);
        }
        return arrayList.toArray(new String[arrayList.size()]);
    }

    static {
        $VALUES = new EnumMovingType[]{Standing, Wandering, MovingPath};
    }
}

