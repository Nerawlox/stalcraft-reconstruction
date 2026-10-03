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
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
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
    public ArrayListMultimap<Integer, ItemStack> randomQuestsReward = ArrayListMultimap.create();

    public void readNBT(NBTTagCompound nBTTagCompound) {
        if (nBTTagCompound != null) {
            List<ItemStack> list2;
            NBTTagCompound nBTTagCompound2 = nBTTagCompound._m("QuestData");
            NBTTagList nBTTagList = nBTTagCompound2._n("CompletedQuests");
            this.finishedQuests.clear();
            for (int i = 0; i < nBTTagList._d(); ++i) {
                NBTTagCompound nBTTagCompound3 = (NBTTagCompound)nBTTagList._b(i);
                this.finishedQuests.put(nBTTagCompound3._f("Quest"), nBTTagCompound3._g("Date"));
            }
            NBTTagList nBTTagList2 = nBTTagCompound2._n("ActiveQuests");
            this.activeQuests.clear();
            for (int i = 0; i < nBTTagList2._d(); ++i) {
                NBTTagCompound nBTTagCompound4 = (NBTTagCompound)nBTTagList2._b(i);
                int n = nBTTagCompound4._f("Quest");
                Quest quest = QuestController.instance.quests.get(n);
                if (quest == null) continue;
                list2 = new QuestData(quest);
                ((QuestData)((Object)list2)).readEntityFromNBT(nBTTagCompound4);
                this.activeQuests.put(n, (QuestData)((Object)list2));
            }
            NBTTagList nBTTagList3 = nBTTagCompound2._n("Reward");
            this.randomQuestsReward.clear();
            for (int i = 0; i < nBTTagList3._d(); ++i) {
                NBTTagCompound nBTTagCompound5 = (NBTTagCompound)nBTTagList3._b(i);
                int n = nBTTagCompound5._f("Quest");
                if (!nBTTagCompound5._c("Items")) {
                    list2 = Collections.singletonList(ItemStack._a(nBTTagCompound5));
                } else {
                    NBTTagList nBTTagList4 = nBTTagCompound5._n("Items");
                    list2 = Arrays.asList(NBTTags.getItemStackArray(nBTTagList4));
                }
                this.randomQuestsReward.replaceValues((Object)n, list2);
            }
        }
    }

    @Override
    public NBTTagCompound writeNBT(NBTTagCompound nBTTagCompound) {
        NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
        NBTTagList nBTTagList = new NBTTagList();
        Object object = this.finishedQuests.keySet().iterator();
        while (object.hasNext()) {
            int n = object.next();
            NBTTagCompound nBTTagCompound3 = new NBTTagCompound();
            nBTTagCompound3._a("Quest", n);
            nBTTagCompound3._a("Date", this.finishedQuests.get(n));
            nBTTagList._a(nBTTagCompound3);
        }
        nBTTagCompound2._a("CompletedQuests", nBTTagList);
        object = new NBTTagList();
        Object object2 = this.activeQuests.keySet().iterator();
        while (object2.hasNext()) {
            int n = object2.next();
            NBTTagCompound nBTTagCompound4 = new NBTTagCompound();
            nBTTagCompound4._a("Quest", n);
            this.activeQuests.get(n).writeEntityToNBT(nBTTagCompound4);
            ((NBTTagList)object)._a(nBTTagCompound4);
        }
        nBTTagCompound2._a("ActiveQuests", (NBTBase)object);
        object2 = new NBTTagList();
        Set set = this.randomQuestsReward.keySet();
        for (Integer n : set) {
            List list2 = this.randomQuestsReward.get((Object)n);
            if (list2.isEmpty()) continue;
            NBTTagCompound nBTTagCompound5 = new NBTTagCompound();
            nBTTagCompound5._a("Quest", (int)n);
            nBTTagCompound5._a("Items", NBTTags.nbtItemStackArray(list2.toArray(new ItemStack[list2.size()])));
            ((NBTTagList)object2)._a(nBTTagCompound5);
        }
        nBTTagCompound2._a("Reward", (NBTBase)object2);
        nBTTagCompound._a("QuestData", nBTTagCompound2);
        return nBTTagCompound;
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

    public Collection<ItemStack> getRewardForQuest(Quest quest) {
        if (quest.reward.selectionMethod == ItemsReward.RewardSelectionMethod.ALL) {
            return quest.reward.items.items.values();
        }
        return this.randomQuestsReward.get((Object)quest.id);
    }
}

