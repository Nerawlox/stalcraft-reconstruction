/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers.availability;

import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.constants.EnumAvailabilityQuest;
import noppes.npcs.controllers.PlayerQuestController;
import noppes.npcs.controllers.availability.AvailabilityRule;
import noppes.npcs.controllers.availability.EnumRule;

public class QuestRule
extends EnumRule<EnumAvailabilityQuest> {
    public QuestRule(EnumAvailabilityQuest enumAvailabilityQuest, int n) {
        super(AvailabilityRule.RuleType.QUEST);
        this.setEnum(enumAvailabilityQuest);
        this.setId(n);
    }

    @Override
    public boolean available(EntityPlayer entityPlayer) {
        EnumAvailabilityQuest enumAvailabilityQuest = (EnumAvailabilityQuest)((Object)this.getEnum());
        switch (enumAvailabilityQuest) {
            case Always: {
                return true;
            }
            case After: {
                return PlayerQuestController.isQuestFinished(entityPlayer, this.id);
            }
            case Before: {
                return !PlayerQuestController.isQuestFinished(entityPlayer, this.id);
            }
            case Active: {
                return PlayerQuestController.isQuestActive(entityPlayer, this.id);
            }
            case NotActive: {
                return !PlayerQuestController.isQuestActive(entityPlayer, this.id);
            }
            case BeforeGetting: {
                return !PlayerQuestController.isQuestActive(entityPlayer, this.id) && !PlayerQuestController.isQuestFinished(entityPlayer, this.id);
            }
        }
        return false;
    }

    EnumAvailabilityQuest[] getEnumValues() {
        return EnumAvailabilityQuest.values();
    }
}

