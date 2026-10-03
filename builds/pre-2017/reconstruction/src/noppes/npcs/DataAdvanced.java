/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.MinecraftForge;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.constants.EnumJobType;
import noppes.npcs.constants.EnumRoleType;
import noppes.npcs.controllers.FactionOptions;
import noppes.npcs.controllers.Line;
import noppes.npcs.controllers.Lines;
import noppes.npcs.controllers.replica.ReplicaController;
import noppes.npcs.controllers.replica.ReplicaStorage;
import noppes.npcs.controllers.replica.ReplicaSystem;
import noppes.npcs.event.AddReputationEvent;
import noppes.npcs.roles.JobBard;
import noppes.npcs.roles.JobBoss;
import noppes.npcs.roles.JobConversation;
import noppes.npcs.roles.JobGuard;
import noppes.npcs.roles.JobHealer;
import noppes.npcs.roles.JobItemGiver;
import noppes.npcs.roles.JobSpawner;
import noppes.npcs.roles.RoleAuctioneer;
import noppes.npcs.roles.RoleBank;
import noppes.npcs.roles.RoleExchanger;
import noppes.npcs.roles.RoleFollower;
import noppes.npcs.roles.RoleGuide;
import noppes.npcs.roles.RolePostman;
import noppes.npcs.roles.RoleResearcher;
import noppes.npcs.roles.RoleSquad;
import noppes.npcs.roles.RoleSupplier;
import noppes.npcs.roles.RoleTrader;
import noppes.npcs.roles.RoleTransporter;
import noppes.npcs.roles.RoleWorkbench;

public class DataAdvanced {
    public Lines interactLines = new Lines();
    public Lines worldLines = new Lines();
    public Lines attackLines = new Lines();
    public Lines killedLines = new Lines();
    public String idleSound = "";
    public String angrySound = "";
    public String hurtSound = "damage.hit";
    public String deathSound = "damage.hit";
    public String stepSound = "";
    public FactionOptions factions = new FactionOptions();
    public EnumRoleType role = EnumRoleType.None;
    public EnumJobType job = EnumJobType.None;
    public boolean attackOtherFactions = false;
    public boolean defendFaction = false;
    public boolean customReputation;
    public int reputationForKill = 0;
    public int factionId = -1;
    private EntityNPCInterface npc;
    public ReplicaController replicas;

    public DataAdvanced(EntityNPCInterface entityNPCInterface) {
        this.npc = entityNPCInterface;
        this.replicas = new ReplicaController(entityNPCInterface);
    }

    public NBTTagCompound writeToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("NpcIdleSound", this.idleSound);
        nBTTagCompound._a("NpcAngrySound", this.angrySound);
        nBTTagCompound._a("NpcHurtSound", this.hurtSound);
        nBTTagCompound._a("NpcDeathSound", this.deathSound);
        nBTTagCompound._a("NpcStepSound", this.stepSound);
        nBTTagCompound._a("FactionID", this.factionId);
        nBTTagCompound._a("AttackOtherFactions", this.attackOtherFactions);
        nBTTagCompound._a("DefendFaction", this.defendFaction);
        nBTTagCompound._a("Role", this.role.ordinal());
        nBTTagCompound._a("NpcJob", this.job.ordinal());
        nBTTagCompound._a("FactionPoints", this.factions.writeToNBT(new NBTTagCompound()));
        if (this.role != EnumRoleType.None && this.npc.roleInterface != null) {
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            this.npc.roleInterface.writeEntityToNBT(nBTTagCompound2);
            nBTTagCompound._a("RoleData", (NBTBase)nBTTagCompound2);
        }
        if (this.job != EnumJobType.None && this.npc.jobInterface != null) {
            this.npc.jobInterface.writeEntityToNBT(nBTTagCompound);
        }
        nBTTagCompound._a("customReputation", this.customReputation);
        nBTTagCompound._a("reputationForKill", this.reputationForKill);
        this.replicas.writeToNbt(nBTTagCompound);
        return nBTTagCompound;
    }

    public void readToNBT(NBTTagCompound nBTTagCompound) {
        this.replicas.readFromNbt(nBTTagCompound);
        if (nBTTagCompound._c("NpcInteractLines")) {
            this.readLegacyLines(ReplicaSystem.ReplicaType.INTERACT, nBTTagCompound._m("NpcInteractLines"));
            this.readLegacyLines(ReplicaSystem.ReplicaType.GENERAL, nBTTagCompound._m("NpcLines"));
            this.readLegacyLines(ReplicaSystem.ReplicaType.ATTACK, nBTTagCompound._m("NpcAttackLines"));
            this.readLegacyLines(ReplicaSystem.ReplicaType.DEATH, nBTTagCompound._m("NpcKilledLines"));
        }
        this.idleSound = nBTTagCompound._j("NpcIdleSound");
        this.angrySound = nBTTagCompound._j("NpcAngrySound");
        this.hurtSound = nBTTagCompound._j("NpcHurtSound");
        this.deathSound = nBTTagCompound._j("NpcDeathSound");
        this.stepSound = nBTTagCompound._j("NpcStepSound");
        this.factionId = nBTTagCompound._f("FactionID");
        this.npc.setFaction(this.factionId);
        this.attackOtherFactions = nBTTagCompound._o("AttackOtherFactions");
        this.defendFaction = nBTTagCompound._o("DefendFaction");
        this.setRole(nBTTagCompound._f("Role"));
        this.setJob(nBTTagCompound._f("NpcJob"));
        this.factions.readFromNBT(nBTTagCompound._m("FactionPoints"));
        if (this.role != EnumRoleType.None && this.npc.roleInterface != null) {
            NBTTagCompound nBTTagCompound2 = nBTTagCompound._m("RoleData");
            if (nBTTagCompound2._e()) {
                this.npc.roleInterface.readEntityFromNBT(nBTTagCompound);
            } else {
                this.npc.roleInterface.readEntityFromNBT(nBTTagCompound2);
            }
        }
        if (this.job != EnumJobType.None && this.npc.jobInterface != null) {
            this.npc.jobInterface.readEntityFromNBT(nBTTagCompound);
        }
        this.customReputation = nBTTagCompound._o("customReputation");
        this.reputationForKill = nBTTagCompound._f("reputationForKill");
    }

    private void readLegacyLines(ReplicaSystem.ReplicaType replicaType, NBTTagCompound nBTTagCompound) {
        Lines lines = new Lines();
        lines.readNBT(nBTTagCompound);
        ReplicaStorage replicaStorage = this.replicas.npcReplicas.getReplicas(replicaType);
        for (Line line : lines.lines.values()) {
            if (line.sound.isEmpty()) continue;
            String string = line.sound;
            String string2 = string.replace(".", "/");
            if (string2.startsWith("customnpcs:")) {
                string2 = string2.substring("customnpcs:".length());
            }
            System.out.println(String.format("Converting old line '%s' to replica of type %s as '%s'", new Object[]{string, replicaType, string2}));
            replicaStorage.getSounds().put(string2, Float.valueOf(1.0f));
        }
    }

    public void setRole(int n) {
        if (EnumRoleType.values().length <= n) {
            n -= 2;
        }
        this.role = EnumRoleType.values()[n];
        if (this.role == EnumRoleType.None) {
            this.npc.roleInterface = null;
        } else if (this.role == EnumRoleType.Trader && !(this.npc.roleInterface instanceof RoleTrader)) {
            this.npc.roleInterface = new RoleTrader(this.npc);
        } else if (this.role == EnumRoleType.Follower && !(this.npc.roleInterface instanceof RoleFollower)) {
            this.npc.roleInterface = new RoleFollower(this.npc);
        } else if (this.role == EnumRoleType.Bank && !(this.npc.roleInterface instanceof RoleBank)) {
            this.npc.roleInterface = new RoleBank(this.npc);
        } else if (this.role == EnumRoleType.Transporter && !(this.npc.roleInterface instanceof RoleTransporter)) {
            this.npc.roleInterface = new RoleTransporter(this.npc);
        } else if (this.role == EnumRoleType.Postman && !(this.npc.roleInterface instanceof RolePostman)) {
            this.npc.roleInterface = new RolePostman(this.npc);
        } else if (this.role == EnumRoleType.Auctioneer && !(this.npc.roleInterface instanceof RoleAuctioneer)) {
            this.npc.roleInterface = new RoleAuctioneer(this.npc);
        } else if (this.role == EnumRoleType.Exchanger && !(this.npc.roleInterface instanceof RoleExchanger)) {
            this.npc.roleInterface = new RoleExchanger(this.npc);
        } else if (this.role == EnumRoleType.Squad && !(this.npc.roleInterface instanceof RoleSquad)) {
            this.npc.roleInterface = new RoleSquad(this.npc);
        } else if (this.role == EnumRoleType.Researcher && !(this.npc.roleInterface instanceof RoleResearcher)) {
            this.npc.roleInterface = new RoleResearcher(this.npc);
        } else if (this.role == EnumRoleType.Supplier && !(this.npc.roleInterface instanceof RoleSupplier)) {
            this.npc.roleInterface = new RoleSupplier(this.npc);
        } else if (this.role == EnumRoleType.Workbench && !(this.npc.roleInterface instanceof RoleWorkbench)) {
            this.npc.roleInterface = new RoleWorkbench(this.npc);
        } else if (this.role == EnumRoleType.Guide && !(this.npc.roleInterface instanceof RoleGuide)) {
            this.npc.roleInterface = new RoleGuide(this.npc);
        }
    }

    public void setJob(int n) {
        this.job = EnumJobType.values()[n % EnumJobType.values().length];
        if (this.job == EnumJobType.None) {
            this.npc.jobInterface = null;
        } else if (this.job == EnumJobType.Bard && !(this.npc.jobInterface instanceof JobBard)) {
            this.npc.jobInterface = new JobBard(this.npc);
        } else if (this.job == EnumJobType.Healer && !(this.npc.jobInterface instanceof JobHealer)) {
            this.npc.jobInterface = new JobHealer(this.npc);
        } else if (this.job == EnumJobType.Guard && !(this.npc.jobInterface instanceof JobGuard)) {
            this.npc.jobInterface = new JobGuard(this.npc);
        } else if (this.job == EnumJobType.ItemGiver && !(this.npc.jobInterface instanceof JobItemGiver)) {
            this.npc.jobInterface = new JobItemGiver(this.npc);
        } else if (this.job == EnumJobType.Boss && !(this.npc.jobInterface instanceof JobBoss)) {
            this.npc.jobInterface = new JobBoss(this.npc);
        } else if (this.job == EnumJobType.Spawner && !(this.npc.jobInterface instanceof JobSpawner)) {
            this.npc.jobInterface = new JobSpawner(this.npc);
        } else if (this.job == EnumJobType.Conversation && !(this.npc.jobInterface instanceof JobConversation)) {
            this.npc.jobInterface = new JobConversation(this.npc);
        }
    }

    public boolean hasWorldLines() {
        return !this.worldLines.isEmpty();
    }

    public void addReputation(EntityPlayer entityPlayer) {
        int n = this.customReputation ? this.reputationForKill : this.npc.getFaction().reputationForKill;
        MinecraftForge.EVENT_BUS.post(new AddReputationEvent(entityPlayer, n));
    }
}

