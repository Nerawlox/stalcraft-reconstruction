/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import gloomyfolken.bundle.common.core.qlgf;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.QuestLogUnit;
import noppes.npcs.constants.EnumQuestType;
import noppes.npcs.controllers.PlayerData;
import noppes.npcs.controllers.Quest;
import noppes.npcs.controllers.QuestCategory;

public class AdvancedQuestLog
extends qlgf {
    private Multimap<Integer, Integer> categoriesContent = HashMultimap.create();
    private Map<Integer, String> categoriesTitles = new HashMap<Integer, String>();
    private Map<Integer, QuestLogUnit> questUnits = new HashMap<Integer, QuestLogUnit>();

    public void setData(EntityPlayer entityPlayer, Collection<Quest> collection, boolean bl) {
        for (Quest quest : collection) {
            Object object;
            QuestCategory questCategory = quest.category;
            this.categoriesTitles.put(questCategory.id, questCategory.displayTitle.isEmpty() ? questCategory.title : questCategory.displayTitle);
            this.categoriesContent.put(questCategory.id, quest.id);
            Vector vector = quest.showTaskAndStatus ? quest.questInterface.getQuestLogStatus(entityPlayer) : Collections.emptyList();
            boolean bl2 = quest.questInterface.isCompleted(entityPlayer);
            boolean bl3 = quest.primary;
            ArrayList<Long> arrayList = new ArrayList<Long>();
            if (bl) {
                object = PlayerData.getData((EntityPlayer)entityPlayer).questData.getRewardForQuest(quest);
                Iterator<cvzo> iterator2 = object.iterator();
                while (iterator2.hasNext()) {
                    cvzo cvzo2 = iterator2.next();
                    if (cvzo2 == null) continue;
                    arrayList.add((long)cvzo2._b << 32 | ((long)cvzo2._d & 0xFFFFL) << 16 | (long)cvzo2._f & 0xFFFFL);
                }
            }
            object = new QuestLogUnit(quest.id, quest.title, quest.logText, quest.type, vector, bl2, bl3);
            ((QuestLogUnit)object).setReward(arrayList);
            this.questUnits.put(quest.id, (QuestLogUnit)object);
        }
    }

    public Multimap<Integer, Integer> getCategoriesContent() {
        return this.categoriesContent;
    }

    public Map<Integer, String> getCategoriesTitles() {
        return this.categoriesTitles;
    }

    public Map<Integer, QuestLogUnit> getQuestUnits() {
        return this.questUnits;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.categoriesContent.size());
        for (Map.Entry<Integer, Integer> entry : this.categoriesContent.entries()) {
            dataOutput.writeInt(entry.getKey());
            dataOutput.writeInt(entry.getValue());
        }
        dataOutput.writeInt(this.categoriesTitles.size());
        for (Map.Entry<Integer, Object> entry : this.categoriesTitles.entrySet()) {
            dataOutput.writeInt(entry.getKey());
            dataOutput.writeUTF((String)entry.getValue());
        }
        dataOutput.writeInt(this.questUnits.size());
        for (Map.Entry<Integer, Object> entry : this.questUnits.entrySet()) {
            dataOutput.writeInt(entry.getKey());
            if (entry.getValue() == null) {
                dataOutput.writeBoolean(false);
                continue;
            }
            dataOutput.writeBoolean(true);
            QuestLogUnit questLogUnit = (QuestLogUnit)entry.getValue();
            dataOutput.writeUTF(questLogUnit.getQuestTitle());
            dataOutput.writeUTF(questLogUnit.getQuestText());
            dataOutput.writeByte(questLogUnit.getType().ordinal());
            dataOutput.writeBoolean(questLogUnit.isCompleted());
            AdvancedQuestLog.writeStringList(questLogUnit.getStatuses(), dataOutput);
            dataOutput.writeBoolean(questLogUnit.isPrimary());
            dataOutput.writeInt(questLogUnit.getReward().size());
            for (long l : questLogUnit.getReward()) {
                dataOutput.writeLong(l);
            }
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        int n;
        int n2;
        int n3 = dataInput.readInt();
        for (n2 = 0; n2 < n3; ++n2) {
            this.categoriesContent.put(dataInput.readInt(), dataInput.readInt());
        }
        n2 = dataInput.readInt();
        for (n = 0; n < n2; ++n) {
            this.categoriesTitles.put(dataInput.readInt(), dataInput.readUTF());
        }
        n = dataInput.readInt();
        for (int i = 0; i < n; ++i) {
            int n4 = dataInput.readInt();
            if (!dataInput.readBoolean()) {
                this.questUnits.put(n4, null);
                continue;
            }
            String string = dataInput.readUTF();
            String string2 = dataInput.readUTF();
            EnumQuestType enumQuestType = EnumQuestType.values()[dataInput.readByte()];
            boolean bl = dataInput.readBoolean();
            List<String> list2 = AdvancedQuestLog.readStringList(dataInput);
            boolean bl2 = dataInput.readBoolean();
            int n5 = dataInput.readInt();
            ArrayList<Long> arrayList = new ArrayList<Long>();
            for (int j = 0; j < n5; ++j) {
                arrayList.add(dataInput.readLong());
            }
            QuestLogUnit questLogUnit = new QuestLogUnit(n4, string, string2, enumQuestType, list2, bl, bl2);
            questLogUnit.setReward(arrayList);
            this.questUnits.put(n4, questLogUnit);
        }
    }
}

