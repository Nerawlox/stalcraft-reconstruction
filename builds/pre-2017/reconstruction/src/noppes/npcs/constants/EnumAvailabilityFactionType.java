/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.constants;

public enum EnumAvailabilityFactionType {
    Always("\u0412\u0441\u0435\u0433\u0434\u0430", 0),
    Is("\u0415\u0441\u043b\u0438", 1),
    IsNot("\u0415\u0441\u043b\u0438 \u043d\u0435", 2);

    public final String title;

    private EnumAvailabilityFactionType(String string2, int n2) {
        this.title = string2;
    }
}

