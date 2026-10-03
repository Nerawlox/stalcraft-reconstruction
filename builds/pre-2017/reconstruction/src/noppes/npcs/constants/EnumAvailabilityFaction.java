/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.constants;

public enum EnumAvailabilityFaction {
    Friendly("\u0414\u0440\u0443\u0436\u0435\u043b\u044e\u0431\u0435\u043d", 0),
    Neutral("\u041d\u0435\u0439\u0442\u0440\u0430\u043b\u0435\u043d", 1),
    Hostile("\u0412\u0440\u0430\u0436\u0434\u0435\u0431\u0435\u043d", 2);

    public final String title;

    private EnumAvailabilityFaction(String string2, int n2) {
        this.title = string2;
    }
}

