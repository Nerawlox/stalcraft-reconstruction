/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import java.util.HashMap;
import noppes.npcs.controllers.Quest;

public class QuestCategory {
    public HashMap<Integer, Quest> quests = new HashMap();
    public int id = -1;
    public String title = "";
    public boolean markedUnused;
    public String displayTitle = "";

    public void readNBT(qoac qoac2) {
        this.id = qoac2._f("Slot");
        this.title = qoac2._j("Title");
        this.displayTitle = qoac2._j("DisplayTitle");
        this.markedUnused = qoac2._o("unused");
        bsyv bsyv2 = qoac2._n("Dialogs");
        if (bsyv2 != null) {
            for (int i = 0; i < bsyv2._d(); ++i) {
                qoac qoac3 = (qoac)bsyv2._b(i);
                Quest quest = new Quest();
                quest.readNBT(qoac3);
                quest.category = this;
                this.quests.put(quest.id, quest);
            }
        }
    }

    public qoac writeNBT(qoac qoac2) {
        qoac2._a("Slot", this.id);
        qoac2._a("Title", this.title);
        qoac2._a("DisplayTitle", this.displayTitle);
        qoac2._a("unused", this.markedUnused);
        bsyv bsyv2 = new bsyv();
        for (int n : this.quests.keySet()) {
            Quest quest = this.quests.get(n);
            bsyv2._a(quest.writeToNBT(new qoac()));
        }
        qoac2._a("Dialogs", bsyv2);
        return qoac2;
    }
}

