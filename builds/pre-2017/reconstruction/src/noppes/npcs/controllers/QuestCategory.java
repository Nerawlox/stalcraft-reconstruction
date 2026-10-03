/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import java.util.HashMap;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import noppes.npcs.controllers.Quest;

public class QuestCategory {
    public HashMap<Integer, Quest> quests = new HashMap();
    public int id = -1;
    public String title = "";
    public boolean markedUnused;
    public String displayTitle = "";

    public void readNBT(NBTTagCompound nBTTagCompound) {
        this.id = nBTTagCompound._f("Slot");
        this.title = nBTTagCompound._j("Title");
        this.displayTitle = nBTTagCompound._j("DisplayTitle");
        this.markedUnused = nBTTagCompound._o("unused");
        NBTTagList nBTTagList = nBTTagCompound._n("Dialogs");
        if (nBTTagList != null) {
            for (int i = 0; i < nBTTagList._d(); ++i) {
                NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList._b(i);
                Quest quest = new Quest();
                quest.readNBT(nBTTagCompound2);
                quest.category = this;
                this.quests.put(quest.id, quest);
            }
        }
    }

    public NBTTagCompound writeNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("Slot", this.id);
        nBTTagCompound._a("Title", this.title);
        nBTTagCompound._a("DisplayTitle", this.displayTitle);
        nBTTagCompound._a("unused", this.markedUnused);
        NBTTagList nBTTagList = new NBTTagList();
        for (int n : this.quests.keySet()) {
            Quest quest = this.quests.get(n);
            nBTTagList._a(quest.writeToNBT(new NBTTagCompound()));
        }
        nBTTagCompound._a("Dialogs", nBTTagList);
        return nBTTagCompound;
    }
}

