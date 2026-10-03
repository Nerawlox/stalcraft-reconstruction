/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import noppes.npcs.controllers.Quest;

public class QuestData {
    public Quest quest;
    public boolean isCompleted;
    public qoac extraData = new qoac();

    public QuestData(Quest quest) {
        this.quest = quest;
    }

    public void writeEntityToNBT(qoac qoac2) {
        qoac2._a("QuestCompleted", this.isCompleted);
        qoac2._a("ExtraData", this.extraData);
    }

    public void readEntityFromNBT(qoac qoac2) {
        this.isCompleted = qoac2._o("QuestCompleted");
        this.extraData = qoac2._m("ExtraData");
    }
}

