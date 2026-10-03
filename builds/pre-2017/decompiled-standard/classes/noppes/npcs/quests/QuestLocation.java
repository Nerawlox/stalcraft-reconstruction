/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.quests;

import java.util.Vector;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.controllers.PlayerDataController;
import noppes.npcs.controllers.PlayerQuestData;
import noppes.npcs.controllers.QuestData;
import noppes.npcs.quests.QuestInterface;

public class QuestLocation
extends QuestInterface {
    public String location = "";
    public String location2 = "";
    public String location3 = "";

    @Override
    public void readEntityFromNBT(qoac qoac2) {
        this.location = qoac2._j("QuestLocation");
        this.location2 = qoac2._j("QuestLocation2");
        this.location3 = qoac2._j("QuestLocation3");
    }

    @Override
    public void writeEntityToNBT(qoac qoac2) {
        qoac2._a("QuestLocation", this.location);
        qoac2._a("QuestLocation2", this.location2);
        qoac2._a("QuestLocation3", this.location3);
    }

    @Override
    public boolean isCompleted(EntityPlayer entityPlayer) {
        PlayerQuestData playerQuestData = PlayerDataController.instance.getPlayerData((EntityPlayer)entityPlayer).questData;
        QuestData questData = playerQuestData.activeQuests.get(this.questId);
        return questData != null && this.getFound(questData, 0);
    }

    @Override
    public void handleComplete(EntityPlayer entityPlayer) {
    }

    @Override
    public Vector getQuestLogStatus(EntityPlayer entityPlayer) {
        Vector<String> vector = new Vector<String>();
        PlayerQuestData playerQuestData = PlayerDataController.instance.getPlayerData((EntityPlayer)entityPlayer).questData;
        QuestData questData = playerQuestData.activeQuests.get(this.questId);
        if (questData == null) {
            return vector;
        }
        String[] stringArray = new String[]{this.location, this.location2, this.location3};
        for (int i = 0; i < stringArray.length; ++i) {
            String string = stringArray[i];
            if (string.isEmpty()) continue;
            vector.add(string + ": " + (this.getFound(questData, i + 1) ? "{quest.found}" : "{quest.notfound}"));
        }
        return vector;
    }

    public boolean getFound(QuestData questData, int n) {
        boolean bl;
        boolean bl2 = this.location.isEmpty() || questData.extraData._o("LocationFound");
        boolean bl3 = this.location2.isEmpty() || questData.extraData._o("Location2Found");
        boolean bl4 = bl = this.location3.isEmpty() || questData.extraData._o("Location3Found");
        if (n == 1) {
            return bl2;
        }
        if (n == 2) {
            return bl3;
        }
        if (n == 3) {
            return bl;
        }
        return bl2 && bl3 && bl;
    }

    public boolean setFound(QuestData questData, String string) {
        boolean bl = false;
        if (string.equalsIgnoreCase(this.location)) {
            questData.extraData._a("LocationFound", true);
            bl = true;
        }
        if (string.equalsIgnoreCase(this.location2)) {
            questData.extraData._a("Location2Found", true);
            bl = true;
        }
        if (string.equalsIgnoreCase(this.location3)) {
            questData.extraData._a("Location3Found", true);
            bl = true;
        }
        return bl;
    }
}

