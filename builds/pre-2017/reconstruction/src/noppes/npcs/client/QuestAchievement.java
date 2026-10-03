/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client;

import net.minecraft.item.Item;
import net.minecraft.stats.Achievement;
import noppes.npcs.CustomItems;

public class QuestAchievement
extends Achievement {
    private String description;

    public QuestAchievement(String string, String string2) {
        super(-1, string, 0, 0, CustomItems.letter == null ? Item.paper : CustomItems.letter, (Achievement)null);
        this.description = string2;
    }

    @Override
    public String getName() {
        return this.statName.substring(12);
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}

