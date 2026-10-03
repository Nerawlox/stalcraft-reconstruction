/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import com.google.common.collect.ArrayListMultimap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.NBTTags;
import noppes.npcs.NoppesUtilServer;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.constants.EnumQuestType;
import noppes.npcs.controllers.IPlayerData;
import noppes.npcs.controllers.ItemsReward;
import noppes.npcs.controllers.Quest;
import noppes.npcs.controllers.QuestController;
import noppes.npcs.controllers.QuestData;
import noppes.npcs.quests.QuestInterface;

public class PlayerQuestData
implements IPlayerData {
    public HashMap<Integer, QuestData> activeQuests = new HashMap();
    public HashMap<Integer, Long> finishedQuests = new HashMap();
    public ArrayListMultimap<Integer, cvzo> randomQuestsReward = ArrayListMultimap.create();

    public void readNBT(qoac qoac2) {
        if (qoac2 != null) {
            List<cvzo> list2;
            qoac qoac3 = qoac2._m("QuestData");
            bsyv bsyv2 = qoac3._n("CompletedQuests");
            this.finishedQuests.clear();
            for (int i = 0; i < bsyv2._d(); ++i) {
                qoac qoac4 = (qoac)bsyv2._b(i);
                this.finishedQuests.put(qoac4._f("Quest"), qoac4._g("Date"));
            }
            bsyv bsyv3 = qoac3._n("ActiveQuests");
            this.activeQuests.clear();
            for (int i = 0; i < bsyv3._d(); ++i) {
                qoac qoac5 = (qoac)bsyv3._b(i);
                int n = qoac5._f("Quest");
                Quest quest = QuestController.instance.quests.get(n);
                if (quest == null) continue;
                list2 = new QuestData(quest);
                ((QuestData)((Object)list2)).readEntityFromNBT(qoac5);
                this.activeQuests.put(n, (QuestData)((Object)list2));
            }
            bsyv bsyv4 = qoac3._n("Reward");
            this.randomQuestsReward.clear();
            for (int i = 0; i < bsyv4._d(); ++i) {
                qoac qoac6 = (qoac)bsyv4._b(i);
                int n = qoac6._f("Quest");
                if (!qoac6._c("Items")) {
                    list2 = Collections.singletonList(cvzo._a(qoac6));
                } else {
                    bsyv bsyv5 = qoac6._n("Items");
                    list2 = Arrays.asList(NBTTags.getItemStackArray(bsyv5));
                }
                this.randomQuestsReward.replaceValues((Object)n, list2);
            }
        }
    }

    @Override
    public qoac writeNBT(qoac qoac2) {
        qoac qoac3 = new qoac();
        bsyv bsyv2 = new bsyv();
        Object object = this.finishedQuests.keySet().iterator();
        while (object.hasNext()) {
            int n = object.next();
            qoac qoac4 = new qoac();
            qoac4._a("Quest", n);
            qoac4._a("Date", this.finishedQuests.get(n));
            bsyv2._a(qoac4);
        }
        qoac3._a("CompletedQuests", bsyv2);
        object = new bsyv();
        Object object2 = this.activeQuests.keySet().iterator();
        while (object2.hasNext()) {
            int n = object2.next();
            qoac qoac5 = new qoac();
            qoac5._a("Quest", n);
            this.activeQuests.get(n).writeEntityToNBT(qoac5);
            ((bsyv)object)._a(qoac5);
        }
        qoac3._a("ActiveQuests", (huhy)object);
        object2 = new bsyv();
        Set set = this.randomQuestsReward.keySet();
        for (Integer n : set) {
            List list2 = this.randomQuestsReward.get((Object)n);
            if (list2.isEmpty()) continue;
            qoac qoac6 = new qoac();
            qoac6._a("Quest", (int)n);
            qoac6._a("Items", NBTTags.nbtItemStackArray(list2.toArray(new cvzo[list2.size()])));
            ((bsyv)object2)._a(qoac6);
        }
        qoac3._a("Reward", (huhy)object2);
        qoac2._a("QuestData", qoac3);
        return qoac2;
    }

    public boolean checkQuestCompletion(EntityPlayer entityPlayer, EnumQuestType enumQuestType) {
        boolean bl = false;
        Iterator<QuestData> iterator2 = this.activeQuests.values().iterator();
        ArrayList<Object> arrayList = new ArrayList<Object>(1);
        while (iterator2.hasNext()) {
            QuestData questData = iterator2.next();
            if (questData.quest.type != enumQuestType && enumQuestType != null) continue;
            Object object = questData.quest.questInterface;
            if (((QuestInterface)object).isCompleted(entityPlayer)) {
                if (questData.isCompleted) continue;
                arrayList.add(questData);
                questData.isCompleted = true;
                bl = true;
                continue;
            }
            questData.isCompleted = false;
        }
        for (Object object : arrayList) {
            if (((QuestData)object).quest.complete(entityPlayer, (QuestData)object)) continue;
            NoppesUtilServer.sendData(entityPlayer, EnumPacketType.Message, "quest.completed", ((QuestData)object).quest.title);
            NoppesUtilServer.sendData(entityPlayer, EnumPacketType.Chat, "quest.completed", ": ", ((QuestData)object).quest.title);
        }
        arrayList.clear();
        return bl;
    }

    public Collection<cvzo> getRewardForQuest(Quest quest) {
        if (quest.reward.selectionMethod == ItemsReward.RewardSelectionMethod.ALL) {
            return quest.reward.items.items.values();
        }
        return this.randomQuestsReward.get((Object)quest.id);
    }
}

