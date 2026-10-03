/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.constants;

import java.util.ArrayList;

public enum EnumNavType {
    Default("Default", 0, "aitactics.rush"),
    Dodge("Dodge", 1, "aitactics.stagger"),
    Surround("Surround", 2, "aitactics.orbit"),
    Ambush("Ambush", 3, "aitactics.ambush"),
    Stalk("Stalk", 4, "aitactics.stalk");

    private static final EnumNavType[] $VALUES;
    String name;

    private EnumNavType(String string2, int n2, String string3) {
        this.name = string3;
    }

    public static String[] names() {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (EnumNavType enumNavType : EnumNavType.values()) {
            arrayList.add(enumNavType.name);
        }
        return arrayList.toArray(new String[arrayList.size()]);
    }

    static {
        $VALUES = new EnumNavType[]{Default, Dodge, Surround, Ambush, Stalk};
    }
}

