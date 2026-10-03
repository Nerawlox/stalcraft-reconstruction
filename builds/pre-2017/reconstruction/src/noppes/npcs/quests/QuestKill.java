/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.quests;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.NBTTags;
import noppes.npcs.controllers.PlayerDataController;
import noppes.npcs.controllers.PlayerQuestData;
import noppes.npcs.controllers.QuestData;
import noppes.npcs.quests.QuestInterface;

public class QuestKill
extends QuestInterface {
    public HashMap targets = new HashMap();

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        this.targets = NBTTags.getStringIntegerMap(nBTTagCompound._n("QuestDialogs"));
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("QuestDialogs", NBTTags.nbtStringIntegerMap(this.targets));
    }

    @Override
    public boolean isCompleted(EntityPlayer entityPlayer) {
        String string;
        PlayerQuestData playerQuestData = PlayerDataController.instance.getPlayerData((EntityPlayer)entityPlayer).questData;
        QuestData questData = playerQuestData.activeQuests.get(this.questId);
        if (questData == null) {
            return false;
        }
        HashMap hashMap = this.getKilled(questData);
        if (hashMap.size() != this.targets.size()) {
            return false;
        }
        Iterator iterator2 = hashMap.keySet().iterator();
        do {
            if (iterator2.hasNext()) continue;
            return true;
        } while (this.targets.containsKey(string = (String)iterator2.next()) && (Integer)this.targets.get(string) <= (Integer)hashMap.get(string));
        return false;
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
        HashMap hashMap = this.getKilled(questData);
        for (String string : this.targets.keySet()) {
            int n = 0;
            if (hashMap.containsKey(string)) {
                n = (Integer)hashMap.get(string);
            }
            String string2 = n + "/" + this.targets.get(string);
            vector.add(string + " " + string2);
        }
        return vector;
    }

    public HashMap getKilled(QuestData questData) {
        return NBTTags.getStringIntegerMap(questData.extraData._n("Killed"));
    }

    public void setKilled(QuestData questData, HashMap hashMap) {
        questData.extraData._a("Killed", NBTTags.nbtStringIntegerMap(hashMap));
    }
}

