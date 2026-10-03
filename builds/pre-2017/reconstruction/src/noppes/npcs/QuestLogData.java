/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import java.util.HashMap;
import java.util.Vector;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
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

    public NBTTagCompound writeNBT() {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        nBTTagCompound._a("Categories", NBTTags.nbtVectorMap(this.categories));
        nBTTagCompound._a("Logs", NBTTags.nbtStringStringMap(this.questText));
        nBTTagCompound._a("Status", NBTTags.nbtVectorMap(this.questStatus));
        return nBTTagCompound;
    }

    public void readNBT(NBTTagCompound nBTTagCompound) {
        this.categories = NBTTags.getVectorMap(nBTTagCompound._n("Categories"));
        this.questText = NBTTags.getStringStringMap(nBTTagCompound._n("Logs"));
        this.questStatus = NBTTags.getVectorMap(nBTTagCompound._n("Status"));
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

