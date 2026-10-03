/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.constants;

public enum EnumAvailabilityQuest {
    Always("\u0412\u0441\u0435\u0433\u0434\u0430", 0),
    After("\u041f\u043e\u0441\u043b\u0435", 1),
    Before("\u041f\u0435\u0440\u0435\u0434 \u0437\u0430\u0432\u0435\u0440\u0448\u0435\u043d\u0438\u0435\u043c", 2),
    Active("\u0410\u043a\u0442\u0438\u0432\u0435\u043d", 3),
    NotActive("\u041d\u0435 \u0430\u043a\u0442\u0438\u0432\u0435\u043d", 4),
    BeforeGetting("\u041f\u0435\u0440\u0435\u0434 \u0432\u0437\u044f\u0442\u0438\u0435\u043c", 5);

    public final String title;

    private EnumAvailabilityQuest(String string2, int n2) {
        this.title = string2;
    }
}

