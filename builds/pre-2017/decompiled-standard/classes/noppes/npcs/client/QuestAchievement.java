/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client;

import noppes.npcs.CustomItems;

public class QuestAchievement
extends nfcl {
    private String description;

    public QuestAchievement(String string, String string2) {
        super(-1, string, 0, 0, CustomItems.letter == null ? tgdv.field_77759_aK : CustomItems.letter, (nfcl)null);
        this.description = string2;
    }

    @Override
    public String func_75970_i() {
        return this.field_75978_a.substring(12);
    }

    @Override
    public String func_75989_e() {
        return this.description;
    }
}

