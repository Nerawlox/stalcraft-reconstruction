/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.NpcMiscInventory;
import noppes.npcs.controllers.Quest;
import noppes.npcs.controllers.QuestController;

public class PlayerMail {
    public NpcMiscInventory items = new NpcMiscInventory(9);
    public String subject = "";
    public String sender = "";
    public NBTTagCompound message = new NBTTagCompound();
    public long time = 0L;
    public boolean beenRead = false;
    public int questId = -1;
    public String questTitle = "";
    public long timePast;

    public void readNBT(NBTTagCompound nBTTagCompound) {
        this.items.setFromNBT(nBTTagCompound._m("Items"));
        this.subject = nBTTagCompound._j("Subject");
        this.sender = nBTTagCompound._j("Sender");
        this.time = nBTTagCompound._g("Time");
        this.beenRead = nBTTagCompound._o("BeenRead");
        this.message = nBTTagCompound._m("Message");
        this.timePast = nBTTagCompound._g("TimePast");
        if (nBTTagCompound._c("MailQuest")) {
            this.questId = nBTTagCompound._f("MailQuest");
        }
        this.questTitle = nBTTagCompound._j("MailQuestTitle");
    }

    public NBTTagCompound writeNBT() {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        nBTTagCompound._a("Items", this.items.getToNBT());
        nBTTagCompound._a("Subject", this.subject);
        nBTTagCompound._a("Sender", this.sender);
        nBTTagCompound._a("Time", this.time);
        nBTTagCompound._a("BeenRead", this.beenRead);
        nBTTagCompound._a("Message", this.message);
        nBTTagCompound._a("TimePast", System.currentTimeMillis() - this.time);
        nBTTagCompound._a("MailQuest", this.questId);
        if (this.hasQuest()) {
            nBTTagCompound._a("MailQuestTitle", this.getQuest().title);
        }
        return nBTTagCompound;
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

