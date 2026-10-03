/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.constants;

public enum EnumOptionType {
    QuitOption("QuitOption", 0),
    DialogOption("DialogOption", 1),
    Disabled("Disabled", 2),
    RoleOption("RoleOption", 3),
    CommandBlock("CommandBlock", 4);

    private static final EnumOptionType[] $VALUES;

    private EnumOptionType(String string2, int n2) {
    }

    static {
        $VALUES = new EnumOptionType[]{QuitOption, DialogOption, Disabled, RoleOption, CommandBlock};
    }
}

