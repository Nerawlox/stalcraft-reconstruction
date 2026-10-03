/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.Vec3;
import noppes.npcs.ICompatibilty;
import noppes.npcs.NBTTags;
import noppes.npcs.NoppesUtilPlayer;
import noppes.npcs.NoppesUtilServer;
import noppes.npcs.VersionCompatibility;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.constants.EnumQuestCompletion;
import noppes.npcs.constants.EnumQuestRepeat;
import noppes.npcs.constants.EnumQuestType;
import noppes.npcs.controllers.FactionOptions;
import noppes.npcs.controllers.ItemsReward;
import noppes.npcs.controllers.PlayerData;
import noppes.npcs.controllers.PlayerMail;
import noppes.npcs.controllers.QuestCategory;
import noppes.npcs.controllers.QuestController;
import noppes.npcs.controllers.QuestData;
import noppes.npcs.controllers.QuestMark;
import noppes.npcs.quests.QuestDialog;
import noppes.npcs.quests.QuestInterface;
import noppes.npcs.quests.QuestItem;
import noppes.npcs.quests.QuestKill;
import noppes.npcs.quests.QuestLocation;

public class Quest
implements ICompatibilty {
    public int version;
    public int id = -1;
    public EnumQuestType type;
    public EnumQuestRepeat repeat;
    public EnumQuestCompletion completion;
    public String title = "default";
    public QuestCategory category;
    public String logText = "";
    public String completeText = "";
    public String completerNpc = "";
    public int nextQuestid = -1;
    public String nextQuestTitle = "";
    public PlayerMail mail;
    public QuestInterface questInterface;
    public int rewardExp = 0;
    public int rewardRep = 0;
    public FactionOptions factionOptions;
    public boolean primary;
    public boolean hasWaypoints;
    public int waypointDim;
    public List<QuestMark> waypoints = new ArrayList<QuestMark>();
    public boolean confirmed;
    public boolean showTaskAndStatus = true;
    public boolean markedUnused;
    public ItemsReward reward;

    public Quest() {
        this.version = VersionCompatibility.ModRev;
        this.type = EnumQuestType.Item;
        this.repeat = EnumQuestRepeat.None;
        this.completion = EnumQuestCompletion.Npc;
        this.mail = new PlayerMail();
        this.questInterface = new QuestItem();
        this.reward = new ItemsReward();
        this.factionOptions = new FactionOptions();
    }

    public void readNBT(NBTTagCompound nBTTagCompound) {
        this.version = nBTTagCompound._f("ModRev");
        VersionCompatibility.CheckAvailabilityCompatibility(this, nBTTagCompound);
        this.id = nBTTagCompound._f("Id");
        this.setType(EnumQuestType.values()[nBTTagCompound._f("Type")]);
        this.title = nBTTagCompound._j("Title");
        this.logText = nBTTagCompound._j("Text");
        this.completeText = nBTTagCompound._j("CompleteText");
        this.completerNpc = nBTTagCompound._j("CompleterNpc");
        this.nextQuestid = nBTTagCompound._f("NextQuestId");
        this.nextQuestTitle = nBTTagCompound._j("NextQuestTitle");
        this.nextQuestTitle = this.hasNewQuest() ? this.getNextQuest().title : "";
        this.rewardExp = nBTTagCompound._f("RewardExp");
        this.rewardRep = nBTTagCompound._f("RewardRep");
        this.completion = EnumQuestCompletion.values()[nBTTagCompound._f("QuestCompletion")];
        this.repeat = EnumQuestRepeat.values()[nBTTagCompound._f("QuestRepeat")];
        this.questInterface.readEntityFromNBT(nBTTagCompound);
        this.factionOptions.readFromNBT(nBTTagCompound._m("QuestFactionPoints"));
        this.mail.readNBT(nBTTagCompound._m("QuestMail"));
        this.hasWaypoints = nBTTagCompound._o("has_waypoint");
        this.waypointDim = nBTTagCompound._f("waypoint_dim");
        this.waypoints.clear();
        if (!nBTTagCompound._c("waypoints")) {
            this.readLegacyWaypoints(nBTTagCompound);
        } else {
            NBTTagList nBTTagList = nBTTagCompound._n("waypoints");
            for (int i = 0; i < nBTTagList._d(); ++i) {
                NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList._b(i);
                Vec3 vec3 = Vec3._a(nBTTagCompound2._i("x"), nBTTagCompound2._i("y"), nBTTagCompound2._i("z"));
                float f = nBTTagCompound2._h("radius");
                this.waypoints.add(new QuestMark(vec3, f));
            }
        }
        this.confirmed = nBTTagCompound._o("confirmed");
        this.showTaskAndStatus = !nBTTagCompound._c("showTaskAndStatus") || nBTTagCompound._o("showTaskAndStatus");
        this.primary = nBTTagCompound._o("Primary");
        this.markedUnused = nBTTagCompound._o("unused");
        this.reward.readNBT(nBTTagCompound);
    }

    private void readLegacyWaypoints(NBTTagCompound nBTTagCompound) {
        int n = nBTTagCompound._f("waypoint_x");
        int n2 = nBTTagCompound._f("waypoint_y");
        int n3 = nBTTagCompound._f("waypoint_z");
        if (n != 0 || n2 != 0 || n3 != 0) {
            this.waypoints.add(new QuestMark(Vec3._a(n, n2, n3), 0.0f));
        }
    }

    public void setType(EnumQuestType enumQuestType) {
        this.type = enumQuestType;
        if (this.type == EnumQuestType.Item) {
            this.questInterface = new QuestItem();
        } else if (this.type == EnumQuestType.Dialog) {
            this.questInterface = new QuestDialog();
        } else if (this.type == EnumQuestType.Kill) {
            this.questInterface = new QuestKill();
        } else if (this.type == EnumQuestType.Location) {
            this.questInterface = new QuestLocation();
        }
        if (this.questInterface != null) {
            this.questInterface.questId = this.id;
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("ModRev", this.version);
        nBTTagCompound._a("Id", this.id);
        nBTTagCompound._a("Type", this.type.ordinal());
        nBTTagCompound._a("Title", this.title);
        nBTTagCompound._a("Text", this.logText);
        nBTTagCompound._a("CompleteText", this.completeText);
        nBTTagCompound._a("CompleterNpc", this.completerNpc);
        nBTTagCompound._a("NextQuestId", this.nextQuestid);
        nBTTagCompound._a("NextQuestTitle", this.nextQuestTitle);
        nBTTagCompound._a("RewardExp", this.rewardExp);
        nBTTagCompound._a("RewardRep", this.rewardRep);
        nBTTagCompound._a("QuestCompletion", this.completion.ordinal());
        nBTTagCompound._a("QuestRepeat", this.repeat.ordinal());
        nBTTagCompound._a("waypoint_dim", this.waypointDim);
        NBTTagList nBTTagList = new NBTTagList();
        for (QuestMark questMark : this.waypoints) {
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            Vec3 vec3 = questMark.getPos();
            nBTTagCompound2._a("x", vec3._c);
            nBTTagCompound2._a("y", vec3._d);
            nBTTagCompound2._a("z", vec3._e);
            nBTTagCompound2._a("radius", questMark.getRadius());
            nBTTagList._a(nBTTagCompound2);
        }
        nBTTagCompound._a("waypoints", nBTTagList);
        nBTTagCompound._a("has_waypoint", this.hasWaypoints);
        this.questInterface.writeEntityToNBT(nBTTagCompound);
        nBTTagCompound._a("QuestFactionPoints", this.factionOptions.writeToNBT(new NBTTagCompound()));
        nBTTagCompound._a("QuestMail", this.mail.writeNBT());
        nBTTagCompound._a("confirmed", this.confirmed);
        nBTTagCompound._a("showTaskAndStatus", this.showTaskAndStatus);
        nBTTagCompound._a("Primary", this.primary);
        nBTTagCompound._a("unused", this.markedUnused);
        this.reward.writeNBT(nBTTagCompound);
        return nBTTagCompound;
    }

    public boolean hasNewQuest() {
        return this.getNextQuest() != null;
    }

    public Quest getNextQuest() {
        return QuestController.instance == null ? null : QuestController.instance.quests.get(this.nextQuestid);
    }

    public boolean complete(EntityPlayer entityPlayer, QuestData questData) {
        if (this.completion == EnumQuestCompletion.Instant) {
            this.markCompleted(entityPlayer, questData);
            return true;
        }
        return false;
    }

    public void markCompleted(EntityPlayer entityPlayer, QuestData questData) {
        NoppesUtilPlayer.questCompletion((EntityPlayerMP)entityPlayer, questData.quest.id);
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        if (questData.quest.reward.isRandom()) {
            Collection<ItemStack> collection = PlayerData.getData((EntityPlayer)entityPlayer).questData.getRewardForQuest(questData.quest);
            NBTTagList nBTTagList = NBTTags.nbtItemStackArray(collection.toArray(new ItemStack[collection.size()]));
            nBTTagCompound._a("Items", nBTTagList);
        }
        NoppesUtilServer.sendData(entityPlayer, EnumPacketType.QuestCompletion, questData.quest.writeToNBT(new NBTTagCompound()), nBTTagCompound);
    }

    public Quest copy() {
        Quest quest = new Quest();
        quest.readNBT(this.writeToNBT(new NBTTagCompound()));
        return quest;
    }

    @Override
    public int getVersion() {
        return this.version;
    }

    @Override
    public void setVersion(int n) {
        this.version = n;
    }
}

