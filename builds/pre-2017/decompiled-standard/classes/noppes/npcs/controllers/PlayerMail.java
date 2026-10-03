/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import noppes.npcs.NpcMiscInventory;
import noppes.npcs.controllers.Quest;
import noppes.npcs.controllers.QuestController;

public class PlayerMail {
    public NpcMiscInventory items = new NpcMiscInventory(9);
    public String subject = "";
    public String sender = "";
    public qoac message = new qoac();
    public long time = 0L;
    public boolean beenRead = false;
    public int questId = -1;
    public String questTitle = "";
    public long timePast;

    public void readNBT(qoac qoac2) {
        this.items.setFromNBT(qoac2._m("Items"));
        this.subject = qoac2._j("Subject");
        this.sender = qoac2._j("Sender");
        this.time = qoac2._g("Time");
        this.beenRead = qoac2._o("BeenRead");
        this.message = qoac2._m("Message");
        this.timePast = qoac2._g("TimePast");
        if (qoac2._c("MailQuest")) {
            this.questId = qoac2._f("MailQuest");
        }
        this.questTitle = qoac2._j("MailQuestTitle");
    }

    public qoac writeNBT() {
        qoac qoac2 = new qoac();
        qoac2._a("Items", this.items.getToNBT());
        qoac2._a("Subject", this.subject);
        qoac2._a("Sender", this.sender);
        qoac2._a("Time", this.time);
        qoac2._a("BeenRead", this.beenRead);
        qoac2._a("Message", this.message);
        qoac2._a("TimePast", System.currentTimeMillis() - this.time);
        qoac2._a("MailQuest", this.questId);
        if (this.hasQuest()) {
            qoac2._a("MailQuestTitle", this.getQuest().title);
        }
        return qoac2;
    }

    public boolean isValid() {
        return !this.subject.isEmpty() && !this.message._e() && !this.sender.isEmpty();
    }

    public boolean hasQuest() {
        return this.getQuest() != null;
    }

    public Quest getQuest() {
        return QuestController.instance != null ? QuestController.instance.quests.get(this.questId) : null;
    }
}

