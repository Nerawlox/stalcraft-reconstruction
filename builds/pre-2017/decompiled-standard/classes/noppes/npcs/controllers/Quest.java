/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ofbx;
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

    public void readNBT(qoac qoac2) {
        this.version = qoac2._f("ModRev");
        VersionCompatibility.CheckAvailabilityCompatibility(this, qoac2);
        this.id = qoac2._f("Id");
        this.setType(EnumQuestType.values()[qoac2._f("Type")]);
        this.title = qoac2._j("Title");
        this.logText = qoac2._j("Text");
        this.completeText = qoac2._j("CompleteText");
        this.completerNpc = qoac2._j("CompleterNpc");
        this.nextQuestid = qoac2._f("NextQuestId");
        this.nextQuestTitle = qoac2._j("NextQuestTitle");
        this.nextQuestTitle = this.hasNewQuest() ? this.getNextQuest().title : "";
        this.rewardExp = qoac2._f("RewardExp");
        this.rewardRep = qoac2._f("RewardRep");
        this.completion = EnumQuestCompletion.values()[qoac2._f("QuestCompletion")];
        this.repeat = EnumQuestRepeat.values()[qoac2._f("QuestRepeat")];
        this.questInterface.readEntityFromNBT(qoac2);
        this.factionOptions.readFromNBT(qoac2._m("QuestFactionPoints"));
        this.mail.readNBT(qoac2._m("QuestMail"));
        this.hasWaypoints = qoac2._o("has_waypoint");
        this.waypointDim = qoac2._f("waypoint_dim");
        this.waypoints.clear();
        if (!qoac2._c("waypoints")) {
            this.readLegacyWaypoints(qoac2);
        } else {
            bsyv bsyv2 = qoac2._n("waypoints");
            for (int i = 0; i < bsyv2._d(); ++i) {
                qoac qoac3 = (qoac)bsyv2._b(i);
                ofbx ofbx2 = ofbx._a(qoac3._i("x"), qoac3._i("y"), qoac3._i("z"));
                float f = qoac3._h("radius");
                this.waypoints.add(new QuestMark(ofbx2, f));
            }
        }
        this.confirmed = qoac2._o("confirmed");
        this.showTaskAndStatus = !qoac2._c("showTaskAndStatus") || qoac2._o("showTaskAndStatus");
        this.primary = qoac2._o("Primary");
        this.markedUnused = qoac2._o("unused");
        this.reward.readNBT(qoac2);
    }

    private void readLegacyWaypoints(qoac qoac2) {
        int n = qoac2._f("waypoint_x");
        int n2 = qoac2._f("waypoint_y");
        int n3 = qoac2._f("waypoint_z");
        if (n != 0 || n2 != 0 || n3 != 0) {
            this.waypoints.add(new QuestMark(ofbx._a(n, n2, n3), 0.0f));
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
    public qoac writeToNBT(qoac qoac2) {
        qoac2._a("ModRev", this.version);
        qoac2._a("Id", this.id);
        qoac2._a("Type", this.type.ordinal());
        qoac2._a("Title", this.title);
        qoac2._a("Text", this.logText);
        qoac2._a("CompleteText", this.completeText);
        qoac2._a("CompleterNpc", this.completerNpc);
        qoac2._a("NextQuestId", this.nextQuestid);
        qoac2._a("NextQuestTitle", this.nextQuestTitle);
        qoac2._a("RewardExp", this.rewardExp);
        qoac2._a("RewardRep", this.rewardRep);
        qoac2._a("QuestCompletion", this.completion.ordinal());
        qoac2._a("QuestRepeat", this.repeat.ordinal());
        qoac2._a("waypoint_dim", this.waypointDim);
        bsyv bsyv2 = new bsyv();
        for (QuestMark questMark : this.waypoints) {
            qoac qoac3 = new qoac();
            ofbx ofbx2 = questMark.getPos();
            qoac3._a("x", ofbx2._c);
            qoac3._a("y", ofbx2._d);
            qoac3._a("z", ofbx2._e);
            qoac3._a("radius", questMark.getRadius());
            bsyv2._a(qoac3);
        }
        qoac2._a("waypoints", bsyv2);
        qoac2._a("has_waypoint", this.hasWaypoints);
        this.questInterface.writeEntityToNBT(qoac2);
        qoac2._a("QuestFactionPoints", this.factionOptions.writeToNBT(new qoac()));
        qoac2._a("QuestMail", this.mail.writeNBT());
        qoac2._a("confirmed", this.confirmed);
        qoac2._a("showTaskAndStatus", this.showTaskAndStatus);
        qoac2._a("Primary", this.primary);
        qoac2._a("unused", this.markedUnused);
        this.reward.writeNBT(qoac2);
        return qoac2;
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
        qoac qoac2 = new qoac();
        if (questData.quest.reward.isRandom()) {
            Collection<cvzo> collection = PlayerData.getData((EntityPlayer)entityPlayer).questData.getRewardForQuest(questData.quest);
            bsyv bsyv2 = NBTTags.nbtItemStackArray(collection.toArray(new cvzo[collection.size()]));
            qoac2._a("Items", bsyv2);
        }
        NoppesUtilServer.sendData(entityPlayer, EnumPacketType.QuestCompletion, questData.quest.writeToNBT(new qoac()), qoac2);
    }

    public Quest copy() {
        Quest quest = new Quest();
        quest.readNBT(this.writeToNBT(new qoac()));
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

