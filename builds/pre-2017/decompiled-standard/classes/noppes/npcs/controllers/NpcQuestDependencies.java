/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import java.util.HashSet;
import java.util.Set;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.controllers.Dialog;
import noppes.npcs.controllers.DialogController;
import noppes.npcs.controllers.DialogOption;
import noppes.npcs.controllers.Quest;
import noppes.npcs.controllers.QuestController;
import noppes.npcs.controllers.availability.AvailabilityRule;
import noppes.npcs.controllers.availability.DialogRule;
import noppes.npcs.controllers.availability.FactionPointsRule;
import noppes.npcs.controllers.availability.FactionRule;
import noppes.npcs.controllers.availability.QuestRule;

public class NpcQuestDependencies {
    public Set<Integer> checkedDialogs = new HashSet<Integer>();
    public boolean hasQuests = false;
    private Set<Integer> quests = new HashSet<Integer>();
    private Set<Integer> dialogs = new HashSet<Integer>();
    private Set<Integer> factions = new HashSet<Integer>();

    public boolean isHasQuests() {
        return this.hasQuests;
    }

    public Set<Integer> getQuests() {
        return this.quests;
    }

    public Set<Integer> getDialogs() {
        return this.dialogs;
    }

    public Set<Integer> getFactions() {
        return this.factions;
    }

    public static NpcQuestDependencies buildDependencies(EntityNPCInterface entityNPCInterface) {
        NpcQuestDependencies npcQuestDependencies = new NpcQuestDependencies();
        for (DialogOption dialogOption : entityNPCInterface.dialogs.values()) {
            if (dialogOption == null) continue;
            NpcQuestDependencies.addOptionDependencies(dialogOption, npcQuestDependencies);
        }
        return npcQuestDependencies;
    }

    private static void addOptionDependencies(DialogOption dialogOption, NpcQuestDependencies npcQuestDependencies) {
        if (npcQuestDependencies.checkedDialogs.contains(dialogOption.dialogId)) {
            return;
        }
        DialogController dialogController = DialogController.instance;
        Dialog dialog = dialogController.dialogs.get(dialogOption.dialogId);
        if (dialog == null) {
            return;
        }
        npcQuestDependencies.checkedDialogs.add(dialogOption.dialogId);
        Quest quest = QuestController.instance.quests.get(dialog.quest);
        if (quest != null) {
            npcQuestDependencies.hasQuests = true;
            npcQuestDependencies.getQuests().add(quest.id);
        }
        for (AvailabilityRule object : dialog.availability.getRuleSet()) {
            if (object.getType() == AvailabilityRule.RuleType.FACTION) {
                npcQuestDependencies.getFactions().add(((FactionRule)object).getId());
                continue;
            }
            if (object.getType() == AvailabilityRule.RuleType.FACTION_POINTS) {
                npcQuestDependencies.getFactions().add(((FactionPointsRule)object).getId());
                continue;
            }
            if (object.getType() == AvailabilityRule.RuleType.DIALOG) {
                npcQuestDependencies.getDialogs().add(((DialogRule)object).getId());
                continue;
            }
            if (object.getType() != AvailabilityRule.RuleType.QUEST) continue;
            npcQuestDependencies.getQuests().add(((QuestRule)object).getId());
        }
        for (DialogOption dialogOption2 : dialog.options.values()) {
            if (dialogOption2 == null) continue;
            NpcQuestDependencies.addOptionDependencies(dialogOption2, npcQuestDependencies);
        }
    }
}

