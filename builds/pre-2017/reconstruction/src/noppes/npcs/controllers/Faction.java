/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import java.util.HashSet;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
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

    public void readNBT(NBTTagCompound nBTTagCompound) {
        this.name = nBTTagCompound._j("Name");
        this.color = nBTTagCompound._f("Color");
        this.id = nBTTagCompound._f("Slot");
        this.neutralPoints = nBTTagCompound._f("NeutralPoints");
        this.friendlyPoints = nBTTagCompound._f("FriendlyPoints");
        this.defaultPoints = nBTTagCompound._f("DefaultPoints");
        this.hideFaction = nBTTagCompound._o("HideFaction");
        this.getsAttacked = nBTTagCompound._o("GetsAttacked");
        this.attackFactions = NBTTags.getIntegerSet(nBTTagCompound._n("AttackFactions"));
        this.neutralReputation = nBTTagCompound._c("neutralReputation") ? nBTTagCompound._f("neutralReputation") : -30;
        this.friendlyReputation = nBTTagCompound._c("friendlyReputation") ? nBTTagCompound._f("friendlyReputation") : -30;
        this.reputationForKill = nBTTagCompound._f("reputationForKill");
        this.relationData.readFromNBT(nBTTagCompound._m("relationData"));
        this.factionPresetId = nBTTagCompound._f("PresetId");
        this.factionReplicas.readFromNbt(nBTTagCompound);
    }

    public NBTTagCompound writeNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("Slot", this.id);
        nBTTagCompound._a("Name", this.name);
        nBTTagCompound._a("Color", this.color);
        nBTTagCompound._a("NeutralPoints", this.neutralPoints);
        nBTTagCompound._a("FriendlyPoints", this.friendlyPoints);
        nBTTagCompound._a("DefaultPoints", this.defaultPoints);
        nBTTagCompound._a("HideFaction", this.hideFaction);
        nBTTagCompound._a("GetsAttacked", this.getsAttacked);
        nBTTagCompound._a("AttackFactions", NBTTags.nbtIntegerSet(this.attackFactions));
        nBTTagCompound._a("neutralReputation", this.neutralReputation);
        nBTTagCompound._a("friendlyReputation", this.friendlyReputation);
        nBTTagCompound._a("reputationForKill", this.reputationForKill);
        NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
        this.relationData.writeToNBT(nBTTagCompound2);
        nBTTagCompound._a("relationData", (NBTBase)nBTTagCompound2);
        nBTTagCompound._a("PresetId", this.factionPresetId);
        this.factionReplicas.writeToNbt(nBTTagCompound);
        return nBTTagCompound;
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

