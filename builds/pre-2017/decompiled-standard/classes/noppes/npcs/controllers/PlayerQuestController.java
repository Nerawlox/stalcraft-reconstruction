/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import java.util.Vector;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.constants.EnumQuestRepeat;
import noppes.npcs.controllers.PlayerDataController;
import noppes.npcs.controllers.PlayerQuestData;
import noppes.npcs.controllers.Quest;
import noppes.npcs.controllers.QuestData;

public class PlayerQuestController {
    private static long dayDurationMillis = 86400000L;
    private static long weekDurationMillis = dayDurationMillis * 7L;

    public static boolean hasActiveQuests(EntityPlayer entityPlayer) {
        PlayerQuestData playerQuestData = PlayerDataController.instance.getPlayerData((EntityPlayer)entityPlayer).questData;
        return !playerQuestData.activeQuests.isEmpty();
    }

    public static boolean isQuestActive(EntityPlayer entityPlayer, int n) {
        PlayerQuestData playerQuestData = PlayerDataController.instance.getPlayerData((EntityPlayer)entityPlayer).questData;
        return playerQuestData.activeQuests.containsKey(n);
    }

    public static boolean isQuestFinished(EntityPlayer entityPlayer, int n) {
        PlayerQuestData playerQuestData = PlayerDataController.instance.getPlayerData((EntityPlayer)entityPlayer).questData;
        return playerQuestData.finishedQuests.containsKey(n);
    }

    public static void addActiveQuest(Quest quest, EntityPlayer entityPlayer) {
        InvokeSideOnly.frontend(() -> {});
    }

    public static void setQuestFinished(Quest quest, EntityPlayer entityPlayer) {
        InvokeSideOnly.frontend(() -> {});
    }

    public static boolean canQuestBeAccepted(Quest quest, EntityPlayer entityPlayer) {
        if (quest == null) {
            return false;
        }
        PlayerQuestData playerQuestData = PlayerDataController.instance.getPlayerData((EntityPlayer)entityPlayer).questData;
        if (playerQuestData.activeQuests.containsKey(quest.id)) {
            return false;
        }
        if (playerQuestData.finishedQuests.containsKey(quest.id) && quest.repeat != EnumQuestRepeat.Repeatable) {
            if (quest.repeat == EnumQuestRepeat.None) {
                return false;
            }
            long l = playerQuestData.finishedQuests.get(quest.id);
            long l2 = System.currentTimeMillis();
            long l3 = l2 - l;
            return l2 < l || quest.repeat == EnumQuestRepeat.Daily && l3 >= dayDurationMillis || quest.repeat == EnumQuestRepeat.Weekly && l3 >= weekDurationMillis || quest.repeat == EnumQuestRepeat.NextDay && !bqgh._a(6, l2, l) || quest.repeat == EnumQuestRepeat.NextWeek && !bqgh._a(3, l2, l);
        }
        return true;
    }

    public static Vector getActiveQuests(EntityPlayer entityPlayer) {
        Vector<Quest> vector = new Vector<Quest>();
        PlayerQuestData playerQuestData = PlayerDataController.instance.getPlayerData((EntityPlayer)entityPlayer).questData;
        for (QuestData questData : playerQuestData.activeQuests.values()) {
            if (questData.quest == null) continue;
            vector.add(questData.quest);
        }
        return vector;
    }
}

