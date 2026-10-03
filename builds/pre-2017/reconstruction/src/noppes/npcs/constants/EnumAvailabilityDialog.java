/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.constants;

public enum EnumAvailabilityDialog {
    Always("\u0412\u0441\u0435\u0433\u0434\u0430", 0),
    After("\u041f\u043e\u0441\u043b\u0435", 1),
    Before("\u041f\u0435\u0440\u0435\u0434", 2);

    public final String title;

    private EnumAvailabilityDialog(String string2, int n2) {
        this.title = string2;
    }
}

