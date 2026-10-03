/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.controllers.Quest;

public class QuestData {
    public Quest quest;
    public boolean isCompleted;
    public NBTTagCompound extraData = new NBTTagCompound();

    public QuestData(Quest quest) {
        this.quest = quest;
    }

    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("QuestCompleted", this.isCompleted);
        nBTTagCompound._a("ExtraData", this.extraData);
    }

    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        this.isCompleted = nBTTagCompound._o("QuestCompleted");
        this.extraData = nBTTagCompound._m("ExtraData");
    }
}

