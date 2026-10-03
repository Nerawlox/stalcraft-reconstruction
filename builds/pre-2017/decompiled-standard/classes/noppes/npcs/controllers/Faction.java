/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import java.util.HashSet;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.NBTTags;
import noppes.npcs.controllers.PlayerDataController;
import noppes.npcs.controllers.PlayerFactionData;
import noppes.npcs.controllers.RelationData;
import noppes.npcs.controllers.SoundPresetsController;
import noppes.npcs.controllers.replica.ReplicaSystem;
import noppes.npcs.event.AgressiveCheckEvent;
import noppes.npcs.event.FriendlyCheckEvent;

public class Faction {
    public String name = "";
    public int color = Integer.parseInt("FF00", 16);
    public HashSet<Integer> attackFactions;
    public int id = -1;
    public int neutralPoints = 500;
    public int friendlyPoints = 1500;
    public int minPoints = 0;
    public int maxPoints = 2000;
    public int defaultPoints = 1000;
    public boolean hideFaction = false;
    public boolean getsAttacked = false;
    public int neutralReputation = -30;
    public int friendlyReputation = -30;
    public int reputationForKill = 0;
    public int factionPresetId = 0;
    public ReplicaSystem factionReplicas = new ReplicaSystem();
    public RelationData relationData = new RelationData();

    public Faction() {
        this.attackFactions = new HashSet();
    }

    public Faction(int n, String string, int n2, int n3) {
        this.name = string;
        this.color = n2;
        this.defaultPoints = n3;
        this.id = n;
        this.attackFactions = new HashSet();
    }

    public static String formatName(String string) {
        string = string.toLowerCase().trim();
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }

    public void readNBT(qoac qoac2) {
        this.name = qoac2._j("Name");
        this.color = qoac2._f("Color");
        this.id = qoac2._f("Slot");
        this.neutralPoints = qoac2._f("NeutralPoints");
        this.friendlyPoints = qoac2._f("FriendlyPoints");
        this.defaultPoints = qoac2._f("DefaultPoints");
        this.hideFaction = qoac2._o("HideFaction");
        this.getsAttacked = qoac2._o("GetsAttacked");
        this.attackFactions = NBTTags.getIntegerSet(qoac2._n("AttackFactions"));
        this.neutralReputation = qoac2._c("neutralReputation") ? qoac2._f("neutralReputation") : -30;
        this.friendlyReputation = qoac2._c("friendlyReputation") ? qoac2._f("friendlyReputation") : -30;
        this.reputationForKill = qoac2._f("reputationForKill");
        this.relationData.readFromNBT(qoac2._m("relationData"));
        this.factionPresetId = qoac2._f("PresetId");
        this.factionReplicas.readFromNbt(qoac2);
    }

    public qoac writeNBT(qoac qoac2) {
        qoac2._a("Slot", this.id);
        qoac2._a("Name", this.name);
        qoac2._a("Color", this.color);
        qoac2._a("NeutralPoints", this.neutralPoints);
        qoac2._a("FriendlyPoints", this.friendlyPoints);
        qoac2._a("DefaultPoints", this.defaultPoints);
        qoac2._a("HideFaction", this.hideFaction);
        qoac2._a("GetsAttacked", this.getsAttacked);
        qoac2._a("AttackFactions", NBTTags.nbtIntegerSet(this.attackFactions));
        qoac2._a("neutralReputation", this.neutralReputation);
        qoac2._a("friendlyReputation", this.friendlyReputation);
        qoac2._a("reputationForKill", this.reputationForKill);
        qoac qoac3 = new qoac();
        this.relationData.writeToNBT(qoac3);
        qoac2._a("relationData", (huhy)qoac3);
        qoac2._a("PresetId", this.factionPresetId);
        this.factionReplicas.writeToNbt(qoac2);
        return qoac2;
    }

    public ReplicaSystem getFactionReplicas() {
        if (this.factionPresetId > 0) {
            SoundPresetsController.SoundPreset soundPreset = SoundPresetsController.instance.getReplicas().get(this.factionPresetId);
            return soundPreset != null ? soundPreset.replicas : this.factionReplicas;
        }
        return this.factionReplicas;
    }

    public boolean isFriendlyToPlayer(EntityPlayer entityPlayer) {
        PlayerFactionData playerFactionData = PlayerDataController.instance.getPlayerData((EntityPlayer)entityPlayer).factionData;
        boolean bl = playerFactionData.getFactionPoints(this.id) >= this.friendlyPoints;
        FriendlyCheckEvent friendlyCheckEvent = new FriendlyCheckEvent(this, entityPlayer, bl);
        MinecraftForge.EVENT_BUS.post(friendlyCheckEvent);
        return friendlyCheckEvent.isFriendly;
    }

    public boolean isAggressiveToPlayer(EntityPlayer entityPlayer) {
        PlayerFactionData playerFactionData = PlayerDataController.instance.getPlayerData((EntityPlayer)entityPlayer).factionData;
        boolean bl = playerFactionData.getFactionPoints(this.id) < this.neutralPoints;
        AgressiveCheckEvent agressiveCheckEvent = new AgressiveCheckEvent(this, entityPlayer, bl);
        MinecraftForge.EVENT_BUS.post(agressiveCheckEvent);
        return agressiveCheckEvent.isAgressive;
    }

    public boolean isAggressiveToNpc(EntityNPCInterface entityNPCInterface) {
        return this.isAggressiveToFaction(entityNPCInterface.getFaction());
    }

    public boolean isAggressiveToFaction(Faction faction) {
        return this.attackFactions.contains(faction.id);
    }
}

