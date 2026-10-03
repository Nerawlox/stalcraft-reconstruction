/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import gloomyfolken.mods.asm.FileWriteBlocker;
import gloomyfolken.mods.asm.Logger;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;
import noppes.npcs.CustomNpcs;
import noppes.npcs.NBTTags;
import noppes.npcs.controllers.Quest;
import noppes.npcs.controllers.QuestCategory;

public class QuestController {
    public static QuestController instance;
    public HashMap<Integer, QuestCategory> categories = new HashMap();
    public HashMap<Integer, Quest> quests = new HashMap();
    private int lastUsedID = 0;
    private int nextQuestId;

    public QuestController() {
        instance = this;
        this.loadCategories();
    }

    private void loadCategories() {
        File file = CustomNpcs.getWorldSaveDirectory();
        try {
            File file2 = new File(file, "quests.dat");
            if (file2.exists()) {
                this.loadCategories(file2);
            }
        }
        catch (Exception exception) {
            try {
                File file3 = new File(file, "quests.dat_old");
                if (file3.exists()) {
                    this.loadCategories(file3);
                }
            }
            catch (Exception exception2) {
                exception2.printStackTrace();
            }
        }
    }

    private void loadCategories(File file) throws Exception {
        int n;
        NBTTagCompound nBTTagCompound = bsvf._a(new FileInputStream(file));
        NBTTagList nBTTagList = nBTTagCompound._n("Data");
        HashMap<Integer, QuestCategory> hashMap = new HashMap<Integer, QuestCategory>();
        HashMap<Integer, Quest> hashMap2 = new HashMap<Integer, Quest>();
        if (nBTTagList != null) {
            for (n = 0; n < nBTTagList._d(); ++n) {
                QuestCategory questCategory = new QuestCategory();
                questCategory.readNBT((NBTTagCompound)nBTTagList._b(n));
                hashMap.put(questCategory.id, questCategory);
                Iterator<Quest> iterator2 = questCategory.quests.values().iterator();
                while (iterator2.hasNext()) {
                    Quest quest = iterator2.next();
                    Quest quest2 = (Quest)hashMap2.get(quest.id);
                    if (quest2 != null) {
                        iterator2.remove();
                        Logger.warning("Removed quest " + quest2.title + " with duplicated id " + quest.id, new Object[0]);
                        continue;
                    }
                    hashMap2.put(quest.id, quest);
                }
            }
        }
        n = hashMap2.keySet().stream().mapToInt(Integer::intValue).max().orElse(0);
        this.nextQuestId = Math.max(nBTTagCompound._f("nextQuestId"), n + 1);
        int n2 = hashMap.keySet().stream().mapToInt(Integer::intValue).max().orElse(0);
        this.lastUsedID = Math.max(nBTTagCompound._f("lastID"), n2);
        this.categories = hashMap;
        this.quests = hashMap2;
    }

    public void saveCategories() {
        if (FileWriteBlocker._a) {
            return;
        }
        try {
            Object object;
            System.out.println("Saving quests");
            File file = CustomNpcs.getWorldSaveDirectory();
            NBTTagList nBTTagList = new NBTTagList();
            for (QuestCategory object22 : this.categories.values()) {
                object = new NBTTagCompound();
                object22.writeNBT((NBTTagCompound)object);
                nBTTagList._a((NBTBase)object);
            }
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound._a("lastID", this.lastUsedID);
            nBTTagCompound._a("Data", nBTTagList);
            nBTTagCompound._a("nextQuestId", this.nextQuestId);
            object = new File(file, "quests.dat_new");
            File file2 = new File(file, "quests.dat_old");
            File file3 = new File(file, "quests.dat");
            bsvf._a(nBTTagCompound, new FileOutputStream((File)object));
            if (file2.exists()) {
                file2.delete();
            }
            file3.renameTo(file2);
            if (file3.exists()) {
                file3.delete();
            }
            ((File)object).renameTo(file3);
            if (((File)object).exists()) {
                ((File)object).delete();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void removeCategory(int n, boolean bl) {
        QuestCategory questCategory = this.categories.get(n);
        if (questCategory != null) {
            for (Integer n2 : questCategory.quests.keySet()) {
                this.quests.remove(n2);
            }
            this.categories.remove(n);
            if (bl) {
                this.saveCategories();
            }
        }
    }

    public void removeQuest(Quest quest, boolean bl) {
        QuestCategory questCategory = quest.category;
        questCategory.quests.remove(quest.id);
        this.quests.remove(quest.id);
        if (bl) {
            this.saveCategories();
        }
    }

    public void saveCategory(QuestCategory questCategory, EntityPlayer entityPlayer) throws IOException {
        boolean bl = MinecraftServer._I().__ag()._g(entityPlayer.username);
        if (questCategory.id < 0) {
            if (this.lastUsedID == 0) {
                for (Integer object : this.categories.keySet()) {
                    if (object <= this.lastUsedID) continue;
                    this.lastUsedID = object;
                }
            }
            ++this.lastUsedID;
            questCategory.id = this.lastUsedID;
        }
        if (this.categories.containsKey(questCategory.id)) {
            Iterator<Quest> iterator2 = this.categories.get(questCategory.id);
            if (!((QuestCategory)((Object)iterator2)).title.equals(questCategory.title)) {
                while (this.containsCategoryName(questCategory.title)) {
                    questCategory.title = questCategory.title + "_";
                }
            }
        } else {
            while (this.containsCategoryName(questCategory.title)) {
                questCategory.title = questCategory.title + "_";
            }
        }
        for (Quest quest : questCategory.quests.values()) {
            Quest quest2 = this.quests.get(quest.id);
            if (quest2 != null) {
                if (quest2.confirmed && !bl) {
                    if (quest2.category.id != questCategory.id) continue;
                    questCategory.quests.put(quest.id, quest2);
                    quest2.category = questCategory;
                    continue;
                }
                this.removeQuest(quest2, false);
            }
            if (!bl) {
                quest.confirmed = false;
            }
            this.quests.put(quest.id, quest);
        }
        this.categories.put(questCategory.id, questCategory);
        this.saveCategories();
    }

    private boolean containsCategoryName(String string) {
        String string2 = string.toLowerCase();
        return this.categories.values().stream().anyMatch(questCategory -> questCategory.title.equals(string2));
    }

    private boolean containsQuestName(QuestCategory questCategory, String string) {
        String string2 = string.toLowerCase();
        return questCategory.quests.values().stream().anyMatch(quest -> quest.title.toLowerCase().equals(string2));
    }

    public Quest saveQuest(DataInputStream dataInputStream, EntityPlayer entityPlayer) throws IOException {
        List<String> list;
        boolean bl = MinecraftServer._I().__ag()._g(entityPlayer.username);
        QuestCategory questCategory = this.categories.get(dataInputStream.readInt());
        if (questCategory == null) {
            return null;
        }
        Quest quest = new Quest();
        NBTTagCompound nBTTagCompound = bsvf._a(dataInputStream);
        quest.readNBT(nBTTagCompound);
        quest.category = questCategory;
        if (quest.id < 0) {
            quest.id = this.getNextQuestIdId();
            while (this.containsQuestName(quest.category, quest.title)) {
                quest.title = quest.title + "_";
            }
        }
        Quest quest2 = this.quests.get(quest.id);
        boolean bl2 = ncwh._a(entityPlayer.username);
        if ((quest2 == null && quest.primary || quest2 != null && quest2.primary != quest.primary) && !bl2) {
            entityPlayer.addChatMessage("\u0412\u044b \u043d\u0435 \u043c\u043e\u0436\u0435\u0442\u0435 \u043c\u0435\u043d\u044f\u0442\u044c \u0441\u0442\u0430\u0442\u0443\u0441 \u043a\u0432\u0435\u0441\u0442\u0430");
            return quest2;
        }
        if (quest2 != null) {
            if (quest2.confirmed && !bl) {
                entityPlayer.addChatMessage("\u041a\u0432\u0435\u0441\u0442 \u0443\u0442\u0432\u0435\u0440\u0436\u0434\u0435\u043d, \u0432\u044b \u043d\u0435 \u0438\u043c\u0435\u0435\u0442\u0435 \u043f\u0440\u0430\u0432\u0430 \u0435\u0433\u043e \u0440\u0435\u0434\u0430\u043a\u0442\u0438\u0440\u043e\u0432\u0430\u0442\u044c!");
                return quest2;
            }
            this.removeQuest(this.quests.get(quest.id), false);
        }
        if (quest2 != null && !(list = NBTTags.nbtDiffLines(quest2.writeToNBT(new NBTTagCompound()), nBTTagCompound)).isEmpty()) {
            CustomNpcs.npcsLog.info(entityPlayer.username + " updated quest " + quest2.title + "(" + quest2.id + "):\n" + String.join((CharSequence)"\n", list));
        }
        if (quest.confirmed && !bl) {
            entityPlayer.addChatMessage("\u0412\u044b \u043d\u0435 \u0438\u043c\u0435\u0435\u0442\u0435 \u043f\u0440\u0430\u0432\u0430 \u0443\u0442\u0432\u0435\u0440\u0434\u0438\u0442\u044c \u043a\u0432\u0435\u0441\u0442!");
            quest.confirmed = false;
        }
        this.quests.put(quest.id, quest);
        quest.category.quests.put(quest.id, quest);
        this.saveCategories();
        return quest;
    }

    public int getNextQuestIdId() {
        return this.nextQuestId++;
    }
}

