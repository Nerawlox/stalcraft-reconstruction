/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.constants;

public enum EnumRoleType {
    None("role.none", false),
    Trader("role.trader", true),
    Follower("role.follower", true),
    Bank("role.bank", true),
    Transporter("role.transporter", true),
    Postman("role.mailman", false),
    Auctioneer("role.auctioneer", false),
    Exchanger("\u041e\u0431\u043c\u0435\u043d\u043d\u0438\u043a", true),
    Researcher("\u0418\u0441\u0441\u043b\u0435\u0434\u043e\u0432\u0430\u0442\u0435\u043b\u044c", false),
    Squad("\u041e\u0442\u0440\u044f\u0434", false),
    Supplier("\u041f\u043e\u0441\u0442\u0430\u0432\u0449\u0438\u043a", true),
    Workbench("\u041c\u0430\u0441\u0442\u0435\u0440", true),
    Guide("\u041f\u0440\u043e\u0432\u043e\u0434\u043d\u0438\u043a", true);

    private final String title;
    private final boolean customizable;

    private EnumRoleType(String string2, boolean bl) {
        this.title = string2;
        this.customizable = bl;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isCustomizable() {
        return this.customizable;
    }
}

