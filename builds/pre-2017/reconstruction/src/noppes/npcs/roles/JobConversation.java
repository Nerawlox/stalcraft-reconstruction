/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.roles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.controllers.Availability;
import noppes.npcs.controllers.Line;
import noppes.npcs.controllers.PlayerQuestController;
import noppes.npcs.controllers.Quest;
import noppes.npcs.controllers.QuestController;
import noppes.npcs.roles.JobInterface;

public class JobConversation
extends JobInterface {
    public Availability availability = new Availability();
    public HashMap lines = new HashMap();
    public int quest = -1;
    public String questTitle = "";
    public int generalDelay = 400;
    public long lastLineTime = -1L;
    public long delaySeconds = 0L;
    public int range = 20;
    public boolean visiblityCheck = true;
    private ArrayList names = new ArrayList();
    private HashMap npcs = new HashMap();
    private ConversationLine nextLine;

    public JobConversation(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("ConversationAvailability", this.availability.writeToNBT(new NBTTagCompound()));
        nBTTagCompound._a("ConversationQuest", this.quest);
        nBTTagCompound._a("ConversationDelaySeconds", this.generalDelay);
        nBTTagCompound._a("ConversationRange", this.range);
        nBTTagCompound._a("VisibilityCheck", this.visiblityCheck);
        NBTTagList nBTTagList = new NBTTagList();
        for (Object k : this.lines.keySet()) {
            int n = (Integer)k;
            ConversationLine conversationLine = (ConversationLine)this.lines.get(n);
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2._a("Slot", n);
            conversationLine.writeEntityToNBT(nBTTagCompound2);
            nBTTagList._a(nBTTagCompound2);
        }
        nBTTagCompound._a("ConversationLines", nBTTagList);
        if (this.hasQuest()) {
            nBTTagCompound._a("ConversationQuestTitle", this.getQuest().title);
        }
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        this.names.clear();
        this.availability.readFromNBT(nBTTagCompound._m("ConversationAvailability"));
        this.quest = nBTTagCompound._f("ConversationQuest");
        this.generalDelay = nBTTagCompound._c("ConversationDelay") ? nBTTagCompound._f("ConversationDelay") / 20 : nBTTagCompound._f("ConversationDelaySeconds");
        this.questTitle = nBTTagCompound._j("ConversationQuestTitle");
        this.range = nBTTagCompound._f("ConversationRange");
        this.visiblityCheck = !nBTTagCompound._c("VisibilityCheck") || nBTTagCompound._o("VisibilityCheck");
        NBTTagList nBTTagList = nBTTagCompound._n("ConversationLines");
        HashMap<Integer, ConversationLine> hashMap = new HashMap<Integer, ConversationLine>();
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList._b(i);
            ConversationLine conversationLine = new ConversationLine();
            conversationLine.readEntityFromNBT(nBTTagCompound2);
            if (!conversationLine.npc.isEmpty() && !this.names.contains(conversationLine.npc.toLowerCase())) {
                this.names.add(conversationLine.npc.toLowerCase());
            }
            hashMap.put(nBTTagCompound2._f("Slot"), conversationLine);
        }
        this.lines = hashMap;
        this.setDelay(this.generalDelay);
    }

    public boolean hasQuest() {
        return this.getQuest() != null;
    }

    public Quest getQuest() {
        return this.npc.worldObj.isRemote ? null : QuestController.instance.quests.get(this.quest);
    }

    public long delayLeft() {
        if (this.lastLineTime == -1L) {
            return 0L;
        }
        return this.delaySeconds - (System.currentTimeMillis() - this.lastLineTime) / 1000L;
    }

    public void setDelay(int n) {
        this.lastLineTime = System.currentTimeMillis();
        this.delaySeconds = n;
    }

    @Override
    public void aiUpdateTask() {
        if (this.delayLeft() < 0L && this.nextLine != null) {
            this.say(this.nextLine);
            boolean bl = false;
            ConversationLine conversationLine = this.nextLine;
            this.nextLine = null;
            for (Object object : this.lines.values()) {
                if (((ConversationLine)object).isEmpty()) continue;
                if (bl) {
                    this.nextLine = object;
                    break;
                }
                if (object != conversationLine) continue;
                bl = true;
            }
            if (this.nextLine != null) {
                this.setDelay(this.nextLine.delay);
            } else if (this.hasQuest()) {
                Object object;
                object = this.npc.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.npc.boundingBox._b(this.range, this.range, this.range));
                Iterator iterator2 = object.iterator();
                while (iterator2.hasNext()) {
                    Object e = iterator2.next();
                    EntityPlayer entityPlayer = (EntityPlayer)e;
                    if (!this.availability.isAvailable(entityPlayer)) continue;
                    PlayerQuestController.addActiveQuest(this.getQuest(), entityPlayer);
                }
            }
        }
    }

    @Override
    public boolean aiShouldExecute() {
        if (!this.lines.isEmpty() && !this.npc.isKilled() && !this.npc.isAttacking() && this.shouldRun()) {
            for (ConversationLine conversationLine : this.lines.values()) {
                if (conversationLine == null || conversationLine.isEmpty()) continue;
                this.nextLine = conversationLine;
                break;
            }
            return this.nextLine != null;
        }
        return false;
    }

    private boolean shouldRun() {
        if (this.delayLeft() > 0L) {
            return false;
        }
        this.npcs.clear();
        List list2 = this.npc.worldObj.getEntitiesWithinAABB(EntityNPCInterface.class, this.npc.boundingBox._b(10.0, 20.0, 10.0));
        for (EntityNPCInterface entityNPCInterface : list2) {
            if (entityNPCInterface.isKilled() || entityNPCInterface.isAttacking() || !this.names.contains(entityNPCInterface.getEntityName().toLowerCase())) continue;
            this.npcs.put(entityNPCInterface.getEntityName().toLowerCase(), entityNPCInterface);
        }
        return this.names.size() == this.npcs.size();
    }

    @Override
    public boolean aiContinueExecute() {
        EntityNPCInterface entityNPCInterface;
        Iterator iterator2 = this.npcs.values().iterator();
        do {
            if (iterator2.hasNext()) continue;
            return this.nextLine != null;
        } while (!(entityNPCInterface = (EntityNPCInterface)iterator2.next()).isKilled() && !entityNPCInterface.isAttacking());
        return false;
    }

    @Override
    public void resetTask() {
        this.nextLine = null;
        this.setDelay(this.generalDelay);
    }

    @Override
    public void aiStartExecuting() {
    }

    private void say(ConversationLine conversationLine) {
        List list2 = this.npc.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.npc.boundingBox._b(20.0, 20.0, 20.0));
        EntityNPCInterface entityNPCInterface = (EntityNPCInterface)this.npcs.get(conversationLine.npc.toLowerCase());
        if (entityNPCInterface != null) {
            for (EntityPlayer entityPlayer : list2) {
                if (!this.availability.isAvailable(entityPlayer)) continue;
                entityNPCInterface.say(entityPlayer, conversationLine, this.visiblityCheck);
            }
        }
    }

    @Override
    public void reset() {
        this.resetTask();
    }

    @Override
    public void killed() {
        this.reset();
    }

    public ConversationLine getLine(int n) {
        if (this.lines.containsKey(n)) {
            return (ConversationLine)this.lines.get(n);
        }
        ConversationLine conversationLine = new ConversationLine();
        this.lines.put(n, conversationLine);
        return conversationLine;
    }

    public class ConversationLine
    extends Line {
        public String npc = "";
        public int delay = 2;

        public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
            nBTTagCompound._a("Line", this.text);
            nBTTagCompound._a("Npc", this.npc);
            nBTTagCompound._a("Sound", this.sound);
            nBTTagCompound._a("SecondsDelay", this.delay);
        }

        public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
            this.text = nBTTagCompound._j("Line");
            this.npc = nBTTagCompound._j("Npc");
            this.sound = nBTTagCompound._j("Sound");
            this.delay = nBTTagCompound._c("Delay") ? nBTTagCompound._f("Delay") / 20 : nBTTagCompound._f("SecondsDelay");
        }

        public boolean isEmpty() {
            return this.npc.isEmpty() || this.text.isEmpty();
        }
    }
}

