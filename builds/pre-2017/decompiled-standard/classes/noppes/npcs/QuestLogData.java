/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import java.util.HashMap;
import java.util.Vector;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.NBTTags;
import noppes.npcs.controllers.PlayerQuestController;
import noppes.npcs.controllers.Quest;

@Deprecated
public class QuestLogData {
    public HashMap<String, Vector<String>> categories = new HashMap();
    public String selectedQuest = "";
    public String selectedCategory = "";
    public HashMap<String, String> questText = new HashMap();
    public HashMap<String, Vector<String>> questStatus = new HashMap();

    public qoac writeNBT() {
        qoac qoac2 = new qoac();
        qoac2._a("Categories", NBTTags.nbtVectorMap(this.categories));
        qoac2._a("Logs", NBTTags.nbtStringStringMap(this.questText));
        qoac2._a("Status", NBTTags.nbtVectorMap(this.questStatus));
        return qoac2;
    }

    public void readNBT(qoac qoac2) {
        this.categories = NBTTags.getVectorMap(qoac2._n("Categories"));
        this.questText = NBTTags.getStringStringMap(qoac2._n("Logs"));
        this.questStatus = NBTTags.getVectorMap(qoac2._n("Status"));
    }

    public void setData(EntityPlayer entityPlayer, Vector<Quest> vector) {
        for (Quest quest : vector) {
            String string = quest.category.title;
            if (!this.categories.containsKey(string)) {
                this.categories.put(string, new Vector());
            }
            Vector<String> vector2 = this.categories.get(string);
            vector2.add(quest.title);
            this.questText.put(string + ":" + quest.title, quest.logText);
            Vector vector3 = quest.showTaskAndStatus ? quest.questInterface.getQuestLogStatus(entityPlayer) : new Vector();
            this.questStatus.put(string + ":" + quest.title, vector3);
        }
    }

    public void setData(EntityPlayer entityPlayer) {
        this.setData(entityPlayer, PlayerQuestController.getActiveQuests(entityPlayer));
    }

    public boolean hasSelectedQuest() {
        return !this.selectedQuest.isEmpty();
    }

    public String getQuestText() {
        return this.questText.get(this.selectedCategory + ":" + this.selectedQuest);
    }

    public Vector getQuestStatus() {
        return this.questStatus.get(this.selectedCategory + ":" + this.selectedQuest);
    }
}

