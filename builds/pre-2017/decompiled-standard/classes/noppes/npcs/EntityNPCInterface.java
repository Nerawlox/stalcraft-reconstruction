/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.InvokeWithResult;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.mods.core.misc.jxtc;
import gloomyfolken.mods.weapon.entity.kjui;
import gloomyfolken.mods.weapon.ezey;
import gloomyfolken.mods.weapon.trace.EntityTracer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.amww;
import net.minecraft.entity.ai.idpz;
import net.minecraft.entity.ai.pidb;
import net.minecraft.entity.ai.tdpf;
import net.minecraft.entity.ai.turb;
import net.minecraft.entity.ai.ugqx;
import net.minecraft.entity.ai.uxqz;
import net.minecraft.entity.ai.zwat;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.sajz;
import net.minecraft.entity.tdmn;
import net.minecraft.entity.vjta;
import net.minecraft.util.dwan;
import net.minecraft.util.ezfc;
import net.minecraft.util.hank;
import net.minecraft.util.iurn;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;
import net.minecraft.util.zwaw;
import noppes.npcs.CustomItems;
import noppes.npcs.CustomNpcs;
import noppes.npcs.DataAI;
import noppes.npcs.DataAdvanced;
import noppes.npcs.DataDisplay;
import noppes.npcs.DataInventory;
import noppes.npcs.DataStats;
import noppes.npcs.NBTTags;
import noppes.npcs.NoppesStringUtils;
import noppes.npcs.NoppesUtilServer;
import noppes.npcs.NpcDamageSource;
import noppes.npcs.NpcSynchronizer;
import noppes.npcs.VersionCompatibility;
import noppes.npcs.ai.EntityAIAmbushTarget;
import noppes.npcs.ai.EntityAIAnimation;
import noppes.npcs.ai.EntityAIAttackTarget;
import noppes.npcs.ai.EntityAIAvoidTarget;
import noppes.npcs.ai.EntityAIBustDoor;
import noppes.npcs.ai.EntityAIDodgeShoot;
import noppes.npcs.ai.EntityAIFindShade;
import noppes.npcs.ai.EntityAIJob;
import noppes.npcs.ai.EntityAILook;
import noppes.npcs.ai.EntityAIMoveIndoors;
import noppes.npcs.ai.EntityAIMovingPath;
import noppes.npcs.ai.EntityAIOccupyBed;
import noppes.npcs.ai.EntityAIOrbitTarget;
import noppes.npcs.ai.EntityAIPanic;
import noppes.npcs.ai.EntityAIRangedAttack;
import noppes.npcs.ai.EntityAIReturn;
import noppes.npcs.ai.EntityAIRole;
import noppes.npcs.ai.EntityAISprintToTarget;
import noppes.npcs.ai.EntityAIStalkTarget;
import noppes.npcs.ai.EntityAIWander;
import noppes.npcs.ai.EntityAIWatchClosest;
import noppes.npcs.ai.EntityAIWorldLines;
import noppes.npcs.ai.EntityAIZigZagTarget;
import noppes.npcs.constants.EnumAnimation;
import noppes.npcs.constants.EnumJobType;
import noppes.npcs.constants.EnumModelType;
import noppes.npcs.constants.EnumMovingType;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.constants.EnumPotionType;
import noppes.npcs.constants.EnumQuestCompletion;
import noppes.npcs.constants.EnumRoleType;
import noppes.npcs.constants.EnumStandingType;
import noppes.npcs.controllers.Dialog;
import noppes.npcs.controllers.DialogOption;
import noppes.npcs.controllers.Faction;
import noppes.npcs.controllers.FactionController;
import noppes.npcs.controllers.Line;
import noppes.npcs.controllers.NpcQuestDependencies;
import noppes.npcs.controllers.NpcSquad;
import noppes.npcs.controllers.PlayerData;
import noppes.npcs.controllers.PlayerDataController;
import noppes.npcs.controllers.Quest;
import noppes.npcs.controllers.QuestData;
import noppes.npcs.controllers.RandomEquipState;
import noppes.npcs.controllers.SquadsRegistry;
import noppes.npcs.controllers.replica.ReplicaSystem;
import noppes.npcs.permissions.ConfirmationStatus;
import noppes.npcs.permissions.CustomNpcsPermissions;
import noppes.npcs.roles.JobBard;
import noppes.npcs.roles.JobBoss;
import noppes.npcs.roles.JobInterface;
import noppes.npcs.roles.RoleFollower;
import noppes.npcs.roles.RoleInterface;
import noppes.npcs.roles.RoleSquad;
import org.jetbrains.annotations.NotNull;

public class EntityNPCInterface
extends EntityCreature
implements IEntityAdditionalSpawnData,
jxtc.pidb,
kjui,
ezey,
EntityTracer.ezey,
nemo,
net.minecraft.entity.boss.eidj,
tdmn {
    private static final long SOUND_COOLDOWN = TimeUnit.SECONDS.toMillis(1L);
    public DataDisplay display;
    public DataStats stats;
    public DataAI aiData;
    public DataAdvanced advanced;
    public DataInventory inventory;
    public HashMap<Integer, DialogOption> dialogs;
    public RandomEquipState randomEquipState;
    public RoleInterface roleInterface;
    public JobInterface jobInterface;
    public int[] startPos;
    public float scaleX;
    public float scaleY;
    public float scaleZ;
    public float labelOffset;
    public boolean hasDied = false;
    public Object textureLocation = null;
    public Object textureGlowLocation = null;
    public Object textureCloakLocation = null;
    public EnumAnimation currentAnimation;
    public int npcVersion;
    public double field_20066_r;
    public double field_20065_s;
    public double field_20064_t;
    public double field_20063_u;
    public double field_20062_v;
    public double field_20061_w;
    public int shootTimer = 0;
    private boolean wasKilled = false;
    private int taskCount = 1;
    private boolean isSleeping = false;
    private EntityAIRangedAttack aiRange;
    public int sharedDataId;
    public Set<String> dungeons = new HashSet<String>();
    public final ConfirmationStatus status = new ConfirmationStatus();
    public Map<String, Long> lastSounds = new WeakHashMap<String, Long>();
    private boolean needsReset;
    public Faction clientFaction = new Faction();
    public long deathTime = -1L;
    public NpcQuestDependencies availableQuestDeps = null;
    public boolean isSpawned = false;
    public int crashMode;
    @gloomyfolken.bundle.common.core.ezey(_a={eidj.CLIENT})
    public boolean isSeen;

    public EntityNPCInterface(ozlu ozlu2) {
        super(ozlu2);
        this.currentAnimation = EnumAnimation.NONE;
        this.npcVersion = VersionCompatibility.ModRev;
        this.display = new DataDisplay(this);
        this.stats = new DataStats(this);
        this.aiData = new DataAI(this);
        this.advanced = new DataAdvanced(this);
        this.inventory = new DataInventory(this);
        this.dialogs = new HashMap();
        this.randomEquipState = new RandomEquipState();
        this.advanced.interactLines.lines.put(0, new Line("Hello {player}"));
        this.field_70728_aV = 0;
        this.labelOffset = 0.0f;
        this.scaleZ = 0.9375f;
        this.scaleY = 0.9375f;
        this.scaleX = 0.9375f;
        this.updateHitbox();
        this.setFaction(this.getFaction().id);
        this.updateTasks();
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af._a(14, (Object)0);
        this.field_70180_af._a(15, (Object)0);
        this.field_70180_af._a(23, (Object)0);
        this.field_70180_af._a(24, (Object)0);
    }

    @Override
    public boolean func_70685_l(Entity entity) {
        iurn iurn2 = this.field_70170_p.func_82732_R();
        hank hank2 = this.field_70170_p.func_72831_a(iurn2._a(this.field_70165_t, this.field_70163_u + (double)this.func_70047_e(), this.field_70161_v), iurn2._a(entity.field_70165_t, entity.field_70163_u + (double)entity.func_70047_e(), entity.field_70161_v), false, true);
        return hank2 == null;
    }

    @Override
    public net.minecraft.util.eidj func_70114_g(Entity entity) {
        return entity.func_70104_M() && !this.isKilled() ? entity.field_70121_D : null;
    }

    @Override
    public net.minecraft.util.eidj func_70046_E() {
        return this.stats.collidable && !this.isKilled() ? this.field_70121_D : null;
    }

    public boolean doesProhibitsWeapon() {
        return this.advanced.replicas.hasAntiWeaponSounds();
    }

    @Override
    protected boolean func_70650_aV() {
        return true;
    }

    @Override
    public boolean func_110167_bD() {
        return false;
    }

    public void performInteractReplica(EntityPlayer entityPlayer) {
        if (entityPlayer.func_71045_bC() != null && entityPlayer.func_71045_bC()._a() instanceof wolf) {
            this.performReplica(ReplicaSystem.ReplicaType.INTERACT_WEAPON);
        } else {
            this.performReplica(ReplicaSystem.ReplicaType.INTERACT);
        }
    }

    public void performReplica(ReplicaSystem.ReplicaType replicaType) {
        this.advanced.replicas.perform(replicaType);
    }

    @Override
    public boolean func_70652_k(Entity entity) {
        boolean bl;
        float f = (float)this.func_110148_a(sajz._e)._e();
        if (this.stats.attackSpeed < 10) {
            entity.field_70172_ad = 0;
        }
        if ((bl = entity.func_70097_a(new NpcDamageSource("mob", this), f)) && this.stats.knockback > 0) {
            entity.func_70024_g(-sajh._a(this.field_70177_z * (float)Math.PI / 180.0f) * (float)this.stats.knockback * 0.5f, 0.1, sajh._b(this.field_70177_z * (float)Math.PI / 180.0f) * (float)this.stats.knockback * 0.5f);
            this.field_70159_w *= 0.6;
            this.field_70179_y *= 0.6;
        }
        if (this.stats.potionType != EnumPotionType.None) {
            if (this.stats.potionType != EnumPotionType.Fire) {
                ((EntityLivingBase)entity).func_70690_d(new supr(this.getPotionEffect(this.stats.potionType), this.stats.potionDuration * 20, this.stats.potionAmp));
            } else {
                entity.func_70015_d(this.stats.potionDuration);
            }
        }
        return bl;
    }

    @Override
    public void func_70071_h_() {
        jxtc._a._a("npc");
        super.func_70071_h_();
        jxtc._a._b();
    }

    @Override
    public void func_70636_d() {
        if (this.availableQuestDeps == null) {
            this.updateQuestDependencies();
        }
        InvokeSideOnly.client(this.field_70170_p.field_72995_K, () -> this.checkClientVisiblity());
        if (this.crashMode == 1) {
            throw new RuntimeException("Crash mode 1");
        }
        if (!CustomNpcs.FreezeNPCs) {
            float f;
            if (this.needsReset) {
                this.reset();
                this.needsReset = false;
            }
            if (this.field_70789_a != null) {
                this.field_70789_a = null;
            }
            this.func_82168_bl();
            if (!this.field_70170_p.field_72995_K) {
                if (!this.isKilled() && !this.isAttacking() && this.field_70173_aa % 20 == 0) {
                    if (this.stats.healthRegen && this.func_110143_aJ() < this.func_110138_aP()) {
                        f = this.func_110138_aP() / 20.0f;
                        this.func_70691_i(f > 0.0f ? f : 1.0f);
                    }
                    if (this.getFaction().getsAttacked) {
                        List list2 = this.field_70170_p.func_72872_a(EntityMob.class, this.field_70121_D._b(16.0, 16.0, 16.0));
                        for (EntityMob entityMob : list2) {
                            if (entityMob.func_70638_az() != null || !this.func_70685_l(entityMob)) continue;
                            if (entityMob instanceof EntityZombie && !entityMob.getEntityData()._c("AttackNpcs")) {
                                entityMob.field_70714_bg._a(2, new pidb(entityMob, EntityLivingBase.class, 1.0, false));
                                entityMob.getEntityData()._a("AttackNpcs", true);
                            }
                            entityMob.func_70624_b(this);
                            break;
                        }
                    }
                }
                if (this.func_110143_aJ() <= 0.0f) {
                    this.func_70674_bp();
                    this.field_70180_af._b(24, 1);
                }
                this.field_70180_af._b(23, (byte)(this.func_70638_az() != null ? 1 : 0));
                this.field_70180_af._b(15, this.func_70661_as()._g() ? 0 : 1);
            }
            if (this.wasKilled != this.isKilled() && this.wasKilled) {
                this.reset();
            }
            this.wasKilled = this.isKilled();
            if (this.field_70170_p.func_72935_r() && !this.field_70170_p.field_72995_K && this.stats.burnInSun && (f = this.func_70013_c(1.0f)) > 0.5f && this.field_70146_Z.nextFloat() * 30.0f < (f - 0.4f) * 2.0f && this.field_70170_p.func_72937_j(sajh._c(this.field_70165_t), sajh._c(this.field_70163_u), sajh._c(this.field_70161_v))) {
                this.func_70015_d(8);
            }
            super.func_70636_d();
            if (this.field_70170_p.field_72995_K) {
                if (!this.display.cloakTexture.isEmpty()) {
                    this.cloakUpdate();
                }
                if (this.currentAnimation.ordinal() != this.field_70180_af._c(14)) {
                    this.currentAnimation = EnumAnimation.values()[this.field_70180_af._c(14)];
                    this.updateHitbox();
                }
                if (this.advanced.job == EnumJobType.Bard) {
                    ((JobBard)this.jobInterface).onLivingUpdate();
                }
            }
            if (this.shootTimer > 0) {
                --this.shootTimer;
            }
            if (this.func_70638_az() != null && !this.func_70638_az().func_70089_S()) {
                this.func_70624_b(null);
            }
        }
    }

    @gloomyfolken.bundle.common.core.ezey(_a={eidj.CLIENT})
    private void checkClientVisiblity() {
        fokl fokl2 = xpzm._E().__ah;
        fokl2._a("npc_visibility");
        EntityClientPlayerMP entityClientPlayerMP = xpzm._E()._t;
        if (entityClientPlayerMP != null && this.func_70068_e(entityClientPlayerMP) < 256.0) {
            ofbx ofbx2;
            iurn iurn2 = this.field_70170_p.func_82732_R();
            ofbx ofbx3 = iurn2._a(entityClientPlayerMP.field_70165_t, entityClientPlayerMP.field_70163_u, entityClientPlayerMP.field_70161_v);
            this.isSeen = this.field_70170_p.func_72933_a(ofbx3, ofbx2 = iurn2._a(this.field_70165_t, this.field_70163_u + (double)this.func_70047_e(), this.field_70161_v)) == null;
        }
        fokl2._b();
    }

    private void updateQuestDependencies() {
        if (!this.field_70170_p.field_72995_K) {
            this.availableQuestDeps = NpcQuestDependencies.buildDependencies(this);
        }
    }

    private void handleSquadInteraction(EntityPlayer entityPlayer) {
        entityPlayer.func_71035_c(this.func_110124_au().toString());
        PlayerData playerData = PlayerData.getData(entityPlayer);
        if (entityPlayer.func_70093_af()) {
            NpcSquad npcSquad;
            if (!(this.roleInterface instanceof RoleSquad) || (npcSquad = ((RoleSquad)this.roleInterface).getSquad()) == null) {
                entityPlayer.func_71035_c((Object)((Object)ezfc._l) + this.display.name + " \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0442 \u0432 \u043e\u0442\u0440\u044f\u0434\u0435");
            } else {
                Set set = npcSquad.getMembers().values().stream().map(squadMember -> squadMember.getNpc(entityPlayer.field_70170_p)).collect(Collectors.toSet());
                set.remove(this);
                entityPlayer.func_71035_c((Object)((Object)ezfc._l) + this.display.name + " \u0441\u043e\u0441\u0442\u043e\u0438\u0442 \u0432 \u043e\u0434\u043d\u043e\u043c \u043e\u0442\u0440\u044f\u0434\u0435 \u0441 " + set.stream().map(entityNPCInterface -> entityNPCInterface.display.name).collect(Collectors.joining(", ")));
            }
        } else {
            if (this.advanced.role != EnumRoleType.Squad) {
                RoleSquad.setSquadMember(this);
                entityPlayer.func_71035_c((Object)((Object)ezfc._k) + "\u0420\u043e\u043b\u044c " + this.display.name + " \u0438\u0437\u043c\u0435\u043d\u0435\u043d\u0435\u043d\u0430 \u043d\u0430 '\u041e\u0442\u0440\u044f\u0434'");
                System.out.println("Changed role to squad");
            }
            if (!this.func_110124_au().equals(playerData.targetNpcUUID)) {
                if (playerData.targetNpcUUID == null) {
                    playerData.targetNpcUUID = this.getPersistentID();
                    entityPlayer.func_71035_c((Object)((Object)ezfc._k) + "\u041d\u041f\u0421 " + this.display.name + " \u0441\u043e\u0445\u0440\u0430\u043d\u0435\u043d. \u0423\u043a\u0430\u0436\u0438\u0442\u0435 \u043d\u043f\u0441, \u0437\u0430 \u043a\u043e\u0442\u043e\u0440\u043e\u043c \u043e\u043d \u0434\u043e\u043b\u0436\u0435\u043d \u0441\u043b\u0435\u0434\u043e\u0432\u0430\u0442\u044c.");
                    System.out.println("Target uuid null, attaching to players");
                } else {
                    EntityNPCInterface entityNPCInterface2 = (EntityNPCInterface)ncwh._a(this.field_70170_p, playerData.targetNpcUUID);
                    if (entityNPCInterface2 != null) {
                        NpcSquad npcSquad;
                        System.out.println("Target follower found");
                        SquadsRegistry squadsRegistry = SquadsRegistry.get(this.field_70170_p);
                        NpcSquad npcSquad2 = squadsRegistry.getSquadWith(this);
                        if (npcSquad2 == null) {
                            System.out.println("Trying to add to squad which doesnt exists, creating it");
                            npcSquad2 = squadsRegistry.addSquad(NpcSquad.createWith(this));
                        }
                        if ((npcSquad = squadsRegistry.getSquadWith(entityNPCInterface2)) != null) {
                            System.out.println("Follower was in squad, removing him from it");
                            npcSquad.removeFromSquad(entityNPCInterface2.func_110124_au());
                            if (npcSquad.getMembers().size() <= 1) {
                                squadsRegistry.removeSquad(npcSquad.id);
                            }
                        }
                        entityPlayer.func_71035_c((Object)((Object)ezfc._k) + "\u041d\u041f\u0421 " + entityNPCInterface2.display.name + " \u0442\u0435\u043f\u0435\u0440\u044c \u0441\u043b\u0435\u0434\u0443\u0435\u0442 \u0437\u0430 " + this.display.name);
                        npcSquad2.addToSquad(entityNPCInterface2, this);
                        squadsRegistry.func_76185_a();
                    } else {
                        entityPlayer.func_71035_c((Object)((Object)ezfc._m) + "\u0421\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u043d\u044b\u0439 \u043d\u043f\u0441 \u043d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d.");
                    }
                    playerData.targetNpcUUID = null;
                }
            } else {
                entityPlayer.func_71035_c((Object)((Object)ezfc._l) + "\u0423\u043a\u0430\u0436\u0438\u0442\u0435 \u043d\u043f\u0441 \u0437\u0430 \u043a\u043e\u0442\u043e\u0440\u044b\u043c \u0434\u043e\u043b\u0436\u0435\u043d \u0441\u043b\u0435\u0434\u043e\u0432\u0430\u0442\u044c " + this.display.name);
            }
        }
    }

    @Override
    public boolean func_70085_c(EntityPlayer entityPlayer) {
        if (this.field_70170_p.field_72995_K) {
            return false;
        }
        System.out.println(this.getPersistentID().toString());
        cvzo cvzo2 = entityPlayer.field_71071_by._a();
        if (cvzo2 != null) {
            if (cvzo2._d == CustomItems.moving.field_77779_bT) {
                this.func_70624_b(null);
                if (cvzo2._e == null) {
                    cvzo2._e = new qoac();
                }
                cvzo2._e._a("NPCID", this.field_70157_k);
                entityPlayer.func_70006_a(net.minecraft.util.zwat._d("Registered " + this.func_70023_ak() + " to your NPC Pather"));
                return true;
            }
            if (cvzo2._d == CustomItems.squadController.field_77779_bT) {
                this.handleSquadInteraction(entityPlayer);
                return true;
            }
        }
        if (!(this.isAttacking() || this.isKilled() || this.getFaction().isAggressiveToPlayer(entityPlayer))) {
            this.handleCasualInteraction(entityPlayer);
            return true;
        }
        return false;
    }

    private void handleCasualInteraction(EntityPlayer entityPlayer) {
        boolean bl;
        PlayerData playerData = PlayerDataController.instance.getPlayerData(entityPlayer);
        if (playerData.currentDialogNpc != null && playerData.currentDialogNpc.equals(this.func_110124_au())) {
            return;
        }
        boolean bl2 = bl = entityPlayer.func_71045_bC() != null && entityPlayer.func_71045_bC()._a() instanceof wolf;
        if (bl && this.doesProhibitsWeapon()) {
            this.performReplica(ReplicaSystem.ReplicaType.INTERACT_WEAPON);
        } else {
            if (NoppesUtilServer.openStoredDialog(entityPlayer, this)) {
                return;
            }
            boolean bl3 = this.tryCompleteQuests(entityPlayer);
            if (this.tryOpenDialogWith(entityPlayer) || bl3) {
                return;
            }
            if (this.roleInterface != null) {
                this.roleInterface.interact(entityPlayer);
            } else {
                this.performInteractReplica(entityPlayer);
            }
        }
    }

    public boolean tryCompleteQuests(EntityPlayer entityPlayer) {
        List list2 = PlayerData.getData((EntityPlayer)entityPlayer).questData.activeQuests.values().stream().filter(questData -> this.canBeCompleted(questData.quest) && questData.quest.questInterface.isCompleted(entityPlayer)).collect(Collectors.toList());
        if (list2.isEmpty()) {
            return false;
        }
        for (QuestData questData2 : list2) {
            questData2.quest.markCompleted(entityPlayer, questData2);
        }
        return true;
    }

    public boolean canBeCompleted(Quest quest) {
        return quest != null && quest.completion == EnumQuestCompletion.Npc && quest.completerNpc.equals(this.func_70023_ak());
    }

    public boolean tryOpenDialogWith(EntityPlayer entityPlayer) {
        Dialog dialog = this.getDialog(entityPlayer);
        if (dialog != null) {
            PlayerData.getData((EntityPlayer)entityPlayer).dialogData.lastRead.put(dialog.id, System.currentTimeMillis());
            NoppesUtilServer.openDialog(entityPlayer, this, dialog);
            return true;
        }
        return false;
    }

    private Dialog getDialog(EntityPlayer entityPlayer) {
        Integer n = PlayerData.getData((EntityPlayer)entityPlayer).storedDialogs.getOrDefault(this.func_110124_au(), -1);
        for (DialogOption dialogOption : this.dialogs.values()) {
            if (dialogOption == null || !dialogOption.hasDialog()) continue;
            Dialog dialog = dialogOption.getDialog();
            if (n != -1 && n == dialog.id || !dialog.isAvailable(entityPlayer)) continue;
            return dialog;
        }
        return null;
    }

    private void clearSquad(EntityPlayer entityPlayer) {
        NpcSquad npcSquad = ((RoleSquad)this.roleInterface).getSquad();
        if (npcSquad != null) {
            npcSquad.removeFromSquad(this.func_110124_au());
            if (npcSquad.getMembers().size() <= 1) {
                SquadsRegistry squadsRegistry = SquadsRegistry.get(this.field_70170_p);
                squadsRegistry.removeSquad(npcSquad.id);
                squadsRegistry.func_76185_a();
            }
            this.advanced.setRole(EnumRoleType.None.ordinal());
            entityPlayer.func_71035_c((Object)((Object)ezfc._k) + this.display.name + " \u0443\u0434\u0430\u043b\u0435\u043d \u0438\u0437 \u043e\u0442\u0440\u044f\u0434\u0430");
        } else {
            entityPlayer.func_71035_c((Object)((Object)ezfc._m) + "\u041d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0442 \u0432 \u043e\u0442\u0440\u044f\u0434\u0435");
        }
    }

    @Override
    public boolean func_70097_a(net.minecraft.util.jxtc jxtc2, float f) {
        if (!(this.field_70170_p.field_72995_K || this.isKilled() || CustomNpcs.FreezeNPCs || jxtc2.field_76373_n.equals("inWall"))) {
            Object object;
            Object object2;
            f = this.stats.resistances.applyResistance(jxtc2, f);
            if (this.advanced.job == EnumJobType.Boss && ((JobBoss)this.jobInterface).applyDamage(f)) {
                return false;
            }
            Entity entity = jxtc2.func_76346_g();
            EntityLivingBase entityLivingBase = null;
            if (this.advanced.role == EnumRoleType.Squad && entity instanceof EntityPlayer && (object2 = ((EntityPlayer)(object = (EntityPlayer)entity)).func_71045_bC()) != null && ((cvzo)object2)._d == CustomItems.squadController.field_77779_bT) {
                this.clearSquad((EntityPlayer)object);
                return false;
            }
            if (entity instanceof EntityLivingBase) {
                entityLivingBase = (EntityLivingBase)entity;
            }
            if (entityLivingBase instanceof EntityPlayer && this.getFaction().isFriendlyToPlayer((EntityPlayer)entityLivingBase)) {
                return false;
            }
            if (entity instanceof EntityArrow && ((EntityArrow)entity).field_70250_c != null) {
                entityLivingBase = (EntityLivingBase)((EntityArrow)entity).field_70250_c;
            }
            if (this.roleInterface instanceof RoleSquad && entityLivingBase != null && (object2 = ((RoleSquad)(object = (RoleSquad)this.roleInterface)).getSquad()) != null) {
                ((NpcSquad)object2).squadState = NpcSquad.DEFENSE_STATE;
                ((NpcSquad)object2).enemeyEntityId = entityLivingBase.field_70157_k;
            }
            int n = this.getFaction().id;
            if (!jxtc2.func_94541_c() && entityLivingBase instanceof EntityNPCInterface && ((EntityNPCInterface)entityLivingBase).getFaction().id == n) {
                return false;
            }
            if (entityLivingBase == null || jxtc2.func_94541_c() && entity == this) {
                return super.func_70097_a(jxtc2, f);
            }
            if (this.isAttacking()) {
                if (this.func_70638_az() != null && entityLivingBase != null && this.func_70068_e(this.func_70638_az()) > this.func_70068_e(entityLivingBase)) {
                    this.func_70624_b(entityLivingBase);
                }
                return super.func_70097_a(jxtc2, f);
            }
            if (f > 0.0f) {
                this.notifyAlliesAboutAttacker(entityLivingBase);
                this.func_70624_b(entityLivingBase);
            }
            return super.func_70097_a(jxtc2, f);
        }
        return false;
    }

    public void notifyAlliesAboutAttacker(EntityLivingBase entityLivingBase) {
        int n = this.getFaction().id;
        List list2 = this.field_70170_p.func_72872_a(EntityNPCInterface.class, this.field_70121_D._b(32.0, 16.0, 32.0));
        for (EntityNPCInterface entityNPCInterface : list2) {
            if (entityNPCInterface.isKilled() || !entityNPCInterface.advanced.defendFaction || entityNPCInterface.getFaction().id != n || !entityNPCInterface.func_70685_l(this) && !entityNPCInterface.func_70685_l(entityLivingBase)) continue;
            entityNPCInterface.onAttack(entityLivingBase);
        }
    }

    public void onAttack(EntityLivingBase entityLivingBase) {
        if (entityLivingBase != null && entityLivingBase != this && !this.isAttacking() && this.aiData.onAttack != 3) {
            super.func_70624_b(entityLivingBase);
        }
    }

    @Override
    public void func_70624_b(EntityLivingBase entityLivingBase) {
        if (!(entityLivingBase instanceof EntityPlayer) || !((EntityPlayer)entityLivingBase).field_71075_bZ._a) {
            if (entityLivingBase != null && entityLivingBase != this && this.aiData.onAttack != 3 && !this.isAttacking() && !this.isRemote()) {
                this.performReplica(ReplicaSystem.ReplicaType.ATTACK);
            }
            super.func_70624_b(entityLivingBase);
        }
    }

    @Override
    public void func_82196_d(EntityLivingBase entityLivingBase, float f) {
        InvokeSideOnly.frontend(() -> {});
    }

    private void clearTasks(idpz idpz2) {
        for (tdpf tdpf2 : idpz2._a) {
            zwat zwat2 = tdpf2._a;
            if (!idpz2._b.contains(tdpf2)) continue;
            zwat2.func_75251_c();
        }
        idpz2._a = new ArrayList();
        idpz2._b = new ArrayList();
    }

    public void updateTasks() {
        InvokeSideOnly.frontend(this.field_70170_p != null && !this.field_70170_p.field_72995_K, () -> {});
    }

    public void setResponse() {
        this.aiRange = null;
        if (this.aiData.onAttack == 1) {
            this.field_70714_bg._a(this.taskCount++, new EntityAIPanic(this, 1.4f));
        } else if (this.aiData.onAttack == 2) {
            this.field_70714_bg._a(this.taskCount++, new EntityAIAvoidTarget(this));
            this.setCanSprint();
        } else if (this.aiData.onAttack == 0) {
            this.setCanLeap();
            this.setCanSprint();
            if (this.inventory.getFirearm() != null && this.aiData.useRangeMelee != 2) {
                switch (this.aiData.tacticalVariant) {
                    case Dodge: {
                        this.field_70714_bg._a(this.taskCount++, new EntityAIDodgeShoot(this));
                        break;
                    }
                    case Surround: {
                        this.field_70714_bg._a(this.taskCount++, new EntityAIOrbitTarget(this, 1.0, this.stats.rangedRange, false));
                        break;
                    }
                    case Ambush: {
                        this.field_70714_bg._a(this.taskCount++, new EntityAIAmbushTarget(this, 1.2, this.aiData.tacticalRadius, false));
                        break;
                    }
                    case Stalk: {
                        this.field_70714_bg._a(this.taskCount++, new EntityAIStalkTarget(this, this.aiData.tacticalRadius));
                    }
                }
            } else {
                switch (this.aiData.tacticalVariant) {
                    case Dodge: {
                        this.field_70714_bg._a(this.taskCount++, new EntityAIZigZagTarget(this, 1.0, this.aiData.tacticalRadius));
                        break;
                    }
                    case Surround: {
                        this.field_70714_bg._a(this.taskCount++, new EntityAIOrbitTarget(this, 1.0, this.aiData.tacticalRadius, true));
                        break;
                    }
                    case Ambush: {
                        this.field_70714_bg._a(this.taskCount++, new EntityAIAmbushTarget(this, 1.2, this.aiData.tacticalRadius, false));
                        break;
                    }
                    case Stalk: {
                        this.field_70714_bg._a(this.taskCount++, new EntityAIStalkTarget(this, this.aiData.tacticalRadius));
                    }
                }
            }
            this.field_70714_bg._a(this.taskCount, new EntityAIAttackTarget(this, true));
            if (this.inventory.getFirearm() != null) {
                this.aiRange = new EntityAIRangedAttack(this);
                this.field_70714_bg._a(this.taskCount++, this.aiRange);
            }
        }
    }

    public void setMoveType() {
        if (this.aiData.movingType == EnumMovingType.Wandering) {
            this.field_70714_bg._a(this.taskCount++, new EntityAIWander(this));
        }
        if (this.aiData.movingType == EnumMovingType.MovingPath) {
            this.field_70714_bg._a(this.taskCount++, new EntityAIMovingPath(this));
        }
    }

    public void doorInteractType() {
        ugqx ugqx2 = null;
        if (this.aiData.doorInteract == 1) {
            ugqx2 = new uxqz(this, true);
        } else if (this.aiData.doorInteract == 0) {
            ugqx2 = new EntityAIBustDoor(this);
        }
        if (ugqx2 != null) {
            this.field_70714_bg._a(this.taskCount++, ugqx2);
        }
        this.func_70661_as()._b(ugqx2 != null);
    }

    public void seekShelter() {
        if (this.aiData.findShelter == 0) {
            this.field_70714_bg._a(this.taskCount++, new EntityAIMoveIndoors(this));
        } else if (this.aiData.findShelter == 1) {
            this.field_70714_bg._a(this.taskCount++, new turb(this));
            this.field_70714_bg._a(this.taskCount++, new EntityAIFindShade(this));
        }
    }

    public void setCanSleep() {
        if (this.aiData.canSleep) {
            this.field_70714_bg._a(this.taskCount++, new EntityAIOccupyBed(this));
        }
    }

    public void setCanLeap() {
        if (this.aiData.canLeap) {
            this.field_70714_bg._a(this.taskCount++, new amww(this, 0.4f));
        }
    }

    public void setCanSprint() {
        if (this.aiData.canSprint) {
            this.field_70714_bg._a(this.taskCount++, new EntityAISprintToTarget(this));
        }
    }

    public void addRegularEntries() {
        this.field_70714_bg._a(this.taskCount++, new EntityAIReturn(this));
        this.field_70714_bg._a(this.taskCount++, new EntityAILook(this));
        if (this.aiData.standingType != EnumStandingType.NoRotation && this.aiData.standingType != EnumStandingType.HeadRotation) {
            this.field_70714_bg._a(this.taskCount++, new EntityAIWatchClosest(this, EntityLiving.class, 5.0f));
        }
        this.field_70714_bg._a(this.taskCount++, new EntityAIWorldLines(this));
        this.field_70714_bg._a(this.taskCount++, new EntityAIJob(this));
        this.field_70714_bg._a(this.taskCount++, new EntityAIRole(this));
        this.field_70714_bg._a(this.taskCount++, new EntityAIAnimation(this));
    }

    public float getSpeed() {
        return (float)this.stats.moveSpeed / 20.0f;
    }

    @Override
    public float func_70783_a(int n, int n2, int n3) {
        return this.field_70170_p.func_72801_o(n, n2, n3) - 0.5f;
    }

    private int getPotionEffect(EnumPotionType enumPotionType) {
        switch (enumPotionType) {
            case Poison: {
                return hdpq._u._H;
            }
            case Hunger: {
                return hdpq._s._H;
            }
            case Weakness: {
                return hdpq._t._H;
            }
            case Slowness: {
                return hdpq._d._H;
            }
            case Nausea: {
                return hdpq._k._H;
            }
            case Blindness: {
                return hdpq._q._H;
            }
            case Wither: {
                return hdpq._v._H;
            }
        }
        return 0;
    }

    @Override
    protected int func_70682_h(int n) {
        return !this.stats.canDrown ? n : super.func_70682_h(n);
    }

    @Override
    public vjta func_70668_bt() {
        return this.stats.creatureType;
    }

    @Override
    public String func_70023_ak() {
        return this.display.name;
    }

    @Override
    protected String func_70639_aQ() {
        return this.func_70089_S() ? (this.func_70638_az() != null && !this.advanced.angrySound.equals("") ? this.advanced.angrySound : this.advanced.idleSound) : null;
    }

    @Override
    public String func_70621_aR() {
        return this.advanced.hurtSound;
    }

    @Override
    public String func_70673_aS() {
        return this.advanced.deathSound;
    }

    @Override
    protected void func_70036_a(int n, int n2, int n3, int n4) {
        if (!this.advanced.stepSound.equals("")) {
            this.func_85030_a(this.advanced.stepSound, 0.15f, 1.0f);
        } else {
            uioo uioo2 = twgu.field_71973_m[n4].field_72020_cn;
            if (this.field_70170_p.func_72798_a(n, n2 + 1, n3) == twgu.field_72037_aS.field_71990_ca) {
                uioo2 = twgu.field_72037_aS.field_72020_cn;
                this.func_85030_a(uioo2._d(), uioo2._a() * 0.15f, uioo2._b());
            } else if (!twgu.field_71973_m[n4].field_72018_cp._d()) {
                this.func_85030_a(uioo2._d(), uioo2._a() * 0.15f, uioo2._b());
            }
        }
    }

    public void say(EntityPlayer entityPlayer, Line line) {
        this.say(entityPlayer, line, true);
    }

    public void say(EntityPlayer entityPlayer, Line line, boolean bl) {
        if (line != null && (!bl || this.func_70685_l(entityPlayer))) {
            if (!line.sound.isEmpty()) {
                long l = System.currentTimeMillis();
                if (!this.lastSounds.containsKey(entityPlayer.func_70005_c_()) || l - this.lastSounds.get(entityPlayer.func_70005_c_()) > SOUND_COOLDOWN) {
                    NoppesUtilServer.sendData(entityPlayer, EnumPacketType.PlaySound, line.sound, Float.valueOf((float)this.field_70165_t), Float.valueOf((float)this.field_70163_u), Float.valueOf((float)this.field_70161_v));
                    this.lastSounds.put(entityPlayer.func_70005_c_(), l);
                }
            }
            if (!line.text.isEmpty()) {
                String string = NoppesStringUtils.formatText(line.text, entityPlayer.field_71092_bJ);
                entityPlayer.func_71035_c(this.func_70023_ak() + ": " + string);
            }
        }
    }

    @Override
    public void func_70024_g(double d, double d2, double d3) {
        if (this.isWalking() && !this.isKilled()) {
            super.func_70024_g(d, d2, d3);
        }
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        super.func_70037_a(qoac2);
        this.crashMode = qoac2._f("crashMode");
        if (this.crashMode == 2) {
            throw new RuntimeException("Crash mode 2");
        }
        this.npcVersion = qoac2._f("ModRev");
        VersionCompatibility.CheckNpcCompatibility(this, qoac2);
        this.status.readFromNBT(qoac2);
        this.readDungeons(qoac2);
        this.isSpawned = qoac2._o("IsSpawned");
        this.sharedDataId = qoac2._f("sharedDataId");
        if (this.sharedDataId == 0 || this.field_70170_p.field_72995_K || NpcSynchronizer.instance.loadSharedData(this)) {
            this.display.readToNBT(qoac2);
            this.stats.readToNBT(qoac2);
            this.aiData.readData(qoac2);
            this.advanced.readToNBT(qoac2);
            this.inventory.readEntityFromNBT(qoac2);
            this.dialogs = this.getDialogs(qoac2._n("NPCDialogOptions"));
        }
        this.randomEquipState.readFromNbt(qoac2);
        this.aiData.readMovement(qoac2);
        this.deathTime = qoac2._g("NpcDeathTime");
        this.startPos = NBTTags.getIntArray(qoac2._n("StartPos"));
        if (this.startPos == null || this.startPos.length != 3) {
            this.startPos = new int[]{sajh._c(this.field_70165_t), sajh._c(this.field_70163_u), sajh._c(this.field_70161_v)};
        }
        this.needsReset = qoac2._o("needsReset");
        this.textureLocation = null;
        this.textureGlowLocation = null;
        this.textureCloakLocation = null;
        this.updateTasks();
        if (this.availableQuestDeps == null) {
            this.updateQuestDependencies();
        }
    }

    public HashMap getDialogs(bsyv bsyv2) {
        HashMap<Integer, DialogOption> hashMap = new HashMap<Integer, DialogOption>();
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac2 = (qoac)bsyv2._b(i);
            int n = qoac2._f("DialogSlot");
            DialogOption dialogOption = new DialogOption();
            dialogOption.readNBT(qoac2._m("NPCDialog"));
            hashMap.put(n, dialogOption);
        }
        return hashMap;
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        super.func_70014_b(qoac2);
        qoac2._a("crashMode", this.crashMode);
        if (this.crashMode == 3) {
            throw new RuntimeException("Crash mode 3");
        }
        qoac2._a("sharedDataId", this.sharedDataId);
        this.status.writeToNBT(qoac2);
        this.display.writeToNBT(qoac2);
        this.stats.writeToNBT(qoac2);
        this.aiData.writeToNBT(qoac2);
        this.aiData.writeMovement(qoac2);
        this.advanced.writeToNBT(qoac2);
        this.inventory.writeEntityToNBT(qoac2);
        this.randomEquipState.writeToNbt(qoac2);
        qoac2._a("IsSpawned", this.isSpawned);
        qoac2._a("NPCDialogOptions", this.nbtDialogs(this.dialogs));
        qoac2._a("NpcDeathTime", this.deathTime);
        this.writeDungeons(qoac2);
        if (this.startPos == null) {
            this.startPos = new int[]{sajh._c(this.field_70165_t), sajh._c(this.field_70163_u), sajh._c(this.field_70161_v)};
        }
        qoac2._a("StartPos", NBTTags.nbtIntArray(this.startPos));
        qoac2._a("ModRev", this.npcVersion);
        qoac2._a("needsReset", this.needsReset);
        this.func_110148_a(sajz._a)._a(this.stats.maxHealth);
        this.func_110148_a(sajz._b)._a(CustomNpcs.NpcNavRange);
        this.func_110148_a(sajz._d)._a(this.getSpeed());
        this.func_110148_a(sajz._e)._a(this.stats.attackStrength);
    }

    private void writeDungeons(qoac qoac2) {
        bsyv bsyv2 = new bsyv();
        for (String string : this.dungeons) {
            bsyv2._a(new xsxy(null, string));
        }
        qoac2._a("Dungeons", bsyv2);
    }

    private void readDungeons(qoac qoac2) {
        this.dungeons.clear();
        bsyv bsyv2 = qoac2._n("Dungeons");
        for (int i = 0; i < bsyv2._d(); ++i) {
            this.dungeons.add(((xsxy)bsyv2._b((int)i))._c);
        }
    }

    public bsyv nbtDialogs(HashMap hashMap) {
        bsyv bsyv2 = new bsyv();
        Iterator iterator2 = hashMap.keySet().iterator();
        while (iterator2.hasNext()) {
            int n = (Integer)iterator2.next();
            qoac qoac2 = new qoac();
            qoac2._a("DialogSlot", n);
            qoac2._a("NPCDialog", ((DialogOption)hashMap.get(n)).writeNBT());
            bsyv2._a(qoac2);
        }
        return bsyv2;
    }

    public void updateHitbox() {
        if (this.currentAnimation == EnumAnimation.LYING) {
            this.field_70131_O = 0.2f;
            this.field_70130_N = 0.2f;
        } else if (this.currentAnimation == EnumAnimation.SITTING) {
            this.field_70130_N = 0.6f;
            this.field_70131_O = 1.3f;
        } else {
            this.field_70130_N = 0.6f;
            this.field_70131_O = 1.8f;
        }
        this.field_70130_N = this.field_70130_N / 5.0f * (float)this.display.modelSize;
        this.field_70131_O = this.field_70131_O / 5.0f * (float)this.display.modelSize;
    }

    public void dropPlayerItemWithRandomChoice(cvzo cvzo2, boolean bl) {
        if (cvzo2 != null) {
            EntityItem entityItem = new EntityItem(this.field_70170_p, this.field_70165_t, this.field_70163_u - (double)0.3f + (double)this.func_70047_e(), this.field_70161_v, cvzo2);
            entityItem.field_70293_c = 40;
            if (bl) {
                float f = this.field_70146_Z.nextFloat() * 0.5f;
                float f2 = this.field_70146_Z.nextFloat() * 3.141593f * 2.0f;
                entityItem.field_70159_w = -sajh._a(f2) * f;
                entityItem.field_70179_y = sajh._b(f2) * f;
                entityItem.field_70181_x = 0.2f;
            } else {
                float f = 0.3f;
                entityItem.field_70159_w = -sajh._a(this.field_70177_z / 180.0f * 3.141593f) * sajh._b(this.field_70125_A / 180.0f * 3.141593f) * f;
                entityItem.field_70179_y = sajh._b(this.field_70177_z / 180.0f * 3.141593f) * sajh._b(this.field_70125_A / 180.0f * 3.141593f) * f;
                entityItem.field_70181_x = -sajh._a(this.field_70125_A / 180.0f * 3.141593f) * f + 0.1f;
                f = 0.02f;
                float f3 = this.field_70146_Z.nextFloat() * 3.141593f * 2.0f;
                entityItem.field_70159_w += Math.cos(f3) * (double)(f *= this.field_70146_Z.nextFloat());
                entityItem.field_70181_x += (double)((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.1f);
                entityItem.field_70179_y += Math.sin(f3) * (double)f;
            }
            this.field_70170_p.func_72838_d(entityItem);
        }
    }

    @Override
    public void func_70609_aI() {
        if (this.stats.spawnCycle == 1 && this.onProductionServer()) {
            super.func_70609_aI();
        } else if (!this.field_70170_p.field_72995_K) {
            boolean bl;
            boolean bl2;
            if (!this.hasDied) {
                this.func_70106_y();
            }
            boolean bl3 = bl2 = System.currentTimeMillis() - this.deathTime > (long)(this.stats.respawnTime * 10 * 50);
            if (!bl2) {
                return;
            }
            boolean bl4 = bl = !this.stats.spawnTimeRanges.shouldCheck() || this.stats.spawnTimeRanges.matches(bqgh._c(this.field_70170_p.func_72820_D()));
            if (bl) {
                this.reset();
            }
        }
    }

    public void reset() {
        this.hasDied = false;
        this.func_70606_j(this.func_110138_aP());
        this.field_70180_af._b(24, 0);
        this.field_70180_af._b(14, 0);
        this.field_70180_af._b(15, 0);
        this.func_70624_b(null);
        this.func_70604_c(null);
        this.field_70725_aQ = 0;
        if (this.startPos != null) {
            this.func_70012_b(this.getStartXPos(), this.getStartYPos() + 1.0, this.getStartZPos(), this.field_70177_z, this.field_70125_A);
        }
        this.deathTime = -1L;
        this.func_70066_B();
        this.func_70674_bp();
        this.func_70612_e(0.0f, 0.0f);
        this.field_70140_Q = 0.0f;
        this.func_70661_as()._h();
        this.currentAnimation = EnumAnimation.NONE;
        this.updateHitbox();
        this.updateTasks();
        this.aiData.movingPos = 0;
        if (this.jobInterface != null) {
            this.jobInterface.reset();
        }
        this.updateQuestDependencies();
        this.shuffleEquipment();
    }

    public void shuffleEquipment() {
        if (!this.field_70170_p.field_72995_K) {
            InvokeSideOnly.frontend(() -> {});
        }
    }

    public void cloakUpdate() {
        this.field_20066_r = this.field_20063_u;
        this.field_20065_s = this.field_20062_v;
        this.field_20064_t = this.field_20061_w;
        double d = this.field_70165_t - this.field_20063_u;
        double d2 = this.field_70163_u - this.field_20062_v;
        double d3 = this.field_70161_v - this.field_20061_w;
        double d4 = 10.0;
        if (d > d4) {
            this.field_20066_r = this.field_20063_u = this.field_70165_t;
        }
        if (d3 > d4) {
            this.field_20064_t = this.field_20061_w = this.field_70161_v;
        }
        if (d2 > d4) {
            this.field_20065_s = this.field_20062_v = this.field_70163_u;
        }
        if (d < -d4) {
            this.field_20066_r = this.field_20063_u = this.field_70165_t;
        }
        if (d3 < -d4) {
            this.field_20064_t = this.field_20061_w = this.field_70161_v;
        }
        if (d2 < -d4) {
            this.field_20065_s = this.field_20062_v = this.field_70163_u;
        }
        this.field_20063_u += d * 0.25;
        this.field_20061_w += d3 * 0.25;
        this.field_20062_v += d2 * 0.25;
    }

    @Override
    protected boolean func_70692_ba() {
        return false;
    }

    @Override
    public cvzo func_70694_bm() {
        return this.isAttacking() ? this.inventory.getWeapon() : (this.jobInterface != null && this.jobInterface.overrideMainHand ? this.jobInterface.mainhand : this.inventory.getWeapon());
    }

    public cvzo getOffHand() {
        return this.isAttacking() ? this.inventory.getOffHand() : (this.jobInterface != null && this.jobInterface.overrideOffHand ? this.jobInterface.offhand : this.inventory.getOffHand());
    }

    protected void dropStuff() {
        this.inventory.dropStuff(this.field_70718_bc > 0);
    }

    protected void onNpcDeath(net.minecraft.util.jxtc jxtc2) {
        this.func_70661_as()._b(false);
        this.dropStuff();
        if (!this.isRemote()) {
            this.performReplica(ReplicaSystem.ReplicaType.DEATH);
        }
    }

    @Override
    public void func_70645_a(net.minecraft.util.jxtc jxtc2) {
        this.onNpcDeath(jxtc2);
        super.func_70645_a(jxtc2);
    }

    @Override
    public void func_70106_y() {
        this.hasDied = true;
        boolean bl = this.onProductionServer();
        if (!(this.isSpawned || this.field_70170_p.field_72995_K || this.stats.spawnCycle == 1 && bl)) {
            this.func_70606_j(-1.0f);
            this.deathTime = System.currentTimeMillis();
            if (this.advanced.role != EnumRoleType.None && this.roleInterface != null) {
                this.roleInterface.killed();
            }
            if (this.advanced.job != EnumJobType.None && this.jobInterface != null) {
                this.jobInterface.killed();
            }
        } else {
            this.func_70656_aK();
            this.delete();
        }
    }

    private boolean onProductionServer() {
        if (!this.field_70170_p.field_72995_K) {
            return InvokeWithResult.frontend(() -> null);
        }
        return true;
    }

    public void delete() {
        if (this.advanced.role != EnumRoleType.None && this.roleInterface != null) {
            this.roleInterface.delete();
        }
        if (this.advanced.job != EnumJobType.None && this.jobInterface != null) {
            this.jobInterface.delete();
        }
        super.func_70106_y();
    }

    public float getStartXPos() {
        return (float)this.startPos[0] + this.aiData.bodyOffsetX / 10.0f;
    }

    public float getStartZPos() {
        return (float)this.startPos[2] + this.aiData.bodyOffsetZ / 10.0f;
    }

    public boolean isVeryNearAssignedPlace() {
        double d = this.field_70165_t - (double)this.getStartXPos();
        double d2 = this.field_70161_v - (double)this.getStartZPos();
        return d >= -0.2 && d <= 0.2 && d2 >= -0.2 && d2 <= 0.2;
    }

    @Override
    public dwan func_70620_b(cvzo cvzo2, int n) {
        EntityPlayer entityPlayer = CustomNpcs.proxy.getPlayer();
        return entityPlayer == null ? super.func_70620_b(cvzo2, n) : entityPlayer.func_70620_b(cvzo2, n);
    }

    public double getStartYPos() {
        int n = this.startPos[0];
        int n2 = this.startPos[1];
        int n3 = this.startPos[2];
        double d = 0.0;
        for (int i = n2; i >= 0; --i) {
            twgu twgu2;
            net.minecraft.util.eidj eidj2;
            int n4 = this.field_70170_p.func_72798_a(n, i, n3);
            if (n4 == 0 || (eidj2 = (twgu2 = twgu.field_71973_m[n4]).func_71872_e(this.field_70170_p, n, i, n3)) == null) continue;
            d = eidj2._f;
            break;
        }
        if (d == 0.0) {
            this.func_70106_y();
        }
        return d += 0.5;
    }

    public void givePlayerItem(EntityPlayer entityPlayer, cvzo cvzo2) {
        if (!this.field_70170_p.field_72995_K) {
            cvzo2 = cvzo2._l();
            CustomNpcs.GivePlayerItem(this, entityPlayer, cvzo2);
            this.field_70170_p.func_72956_a(entityPlayer, "random.pop", 0.2f, ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.7f + 1.0f) * 2.0f);
        }
    }

    @Override
    public boolean func_70608_bn() {
        return this.currentAnimation == EnumAnimation.LYING;
    }

    @Override
    public boolean func_70115_ae() {
        return this.currentAnimation == EnumAnimation.SITTING;
    }

    public boolean isWalking() {
        return this.aiData.movingType != EnumMovingType.Standing || this.isAttacking() || this.isFollowerWithOwner() || this.field_70180_af._c(15) == 1;
    }

    @Override
    public boolean func_70093_af() {
        return this.currentAnimation == EnumAnimation.SNEAKING;
    }

    @Override
    public void func_70653_a(Entity entity, float f, double d, double d2) {
    }

    public Faction getFaction() {
        if (!this.isRemote()) {
            int n;
            FactionController factionController = FactionController.getInstance();
            Faction faction = factionController.getFaction(n = this.advanced.factionId);
            if (faction == null) {
                faction = FactionController.getInstance().getFirstFaction();
                this.advanced.factionId = faction.id;
            }
            return faction;
        }
        if (this.clientFaction == null) {
            this.clientFaction = new Faction();
        }
        return this.clientFaction;
    }

    public void setFaction(int n) {
        if (n >= 0 && !this.isRemote()) {
            Faction faction = FactionController.getInstance().getFaction(n);
            this.advanced.factionId = faction.id;
            InvokeSideOnly.frontend(() -> {});
        }
    }

    public String getNpcTexture() {
        if (this.randomEquipState.applied) {
            return this.randomEquipState.skin;
        }
        return this.display.texture;
    }

    public boolean isRemote() {
        return this.field_70170_p == null || this.field_70170_p.field_72995_K;
    }

    public boolean isFollowerWithOwner() {
        return this.advanced.role == EnumRoleType.Follower && ((RoleFollower)this.roleInterface).getDaysLeft() > 0;
    }

    @Override
    public boolean func_70687_e(supr supr2) {
        return this.func_70668_bt() == vjta._c && supr2._a() == hdpq._u._H ? false : super.func_70687_e(supr2);
    }

    public qoac copy() {
        qoac qoac2 = new qoac();
        this.func_70039_c(qoac2);
        qoac2._a("EntityId", this.field_70157_k);
        return qoac2;
    }

    public boolean inNormalState() {
        return !this.isAttacking() && !this.isFollowerWithOwner();
    }

    public boolean isAttacking() {
        return this.field_70180_af._a(23) == 1;
    }

    public boolean isKilled() {
        return this.field_70180_af._c(24) == 1;
    }

    @Override
    public void writeSpawnData(ByteArrayDataOutput byteArrayDataOutput) {
        try {
            bsvf._a(this.writeSpawnData(), byteArrayDataOutput);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public boolean shouldRenderDeadBody() {
        return this.deathTime <= 10L;
    }

    public qoac writeSpawnData() {
        qoac qoac2 = new qoac();
        this.display.writeToNBT(qoac2);
        qoac2._a("MaxHealth", this.stats.maxHealth);
        qoac2._a("Armor", NBTTags.nbtItemStackList(this.inventory.armor));
        qoac2._a("Weapons", NBTTags.nbtItemStackList(this.inventory.weapons));
        qoac2._a("Speed", this.stats.moveSpeed);
        qoac2._a("StandingState", this.aiData.standingType.ordinal());
        qoac2._a("MovingState", this.aiData.movingType.ordinal());
        qoac2._a("Orientation", this.aiData.orientation);
        qoac2._a("Role", this.advanced.role.ordinal());
        qoac2._a("Job", this.advanced.job.ordinal());
        qoac2._a("Collision", this.stats.collidable);
        qoac2._a("ThrowOff", this.stats.playersThrowOff);
        this.status.writeToNBT(qoac2);
        this.writeDungeons(qoac2);
        this.randomEquipState.writeToNbt(qoac2);
        if (this.advanced.job == EnumJobType.Bard) {
            qoac qoac3 = new qoac();
            this.jobInterface.writeEntityToNBT(qoac3);
            qoac2._a("Bard", (huhy)qoac3);
        }
        if (this.advanced.job == EnumJobType.Boss) {
            qoac2._a("Boss", ((JobBoss)this.jobInterface).hideName);
        }
        qoac2._a("Faction", this.getFaction().writeNBT(new qoac()));
        return qoac2;
    }

    @Override
    public void readSpawnData(ByteArrayDataInput byteArrayDataInput) {
        try {
            qoac qoac2 = bsvf._a(byteArrayDataInput);
            this.readSpawnData(qoac2);
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }

    public void readSpawnData(qoac qoac2) {
        this.stats.maxHealth = qoac2._f("MaxHealth");
        this.stats.moveSpeed = qoac2._f("Speed");
        this.aiData.standingType = EnumStandingType.values()[qoac2._f("StandingState") % EnumStandingType.values().length];
        this.aiData.movingType = EnumMovingType.values()[qoac2._f("MovingState") % EnumMovingType.values().length];
        this.aiData.orientation = qoac2._f("Orientation");
        this.func_110148_a(sajz._a)._a(this.stats.maxHealth);
        this.inventory.setArmor(NBTTags.getItemStackList(qoac2._n("Armor")));
        this.inventory.setWeapons(NBTTags.getItemStackList(qoac2._n("Weapons")));
        this.advanced.setRole(qoac2._f("Role"));
        this.advanced.setJob(qoac2._f("Job"));
        this.status.readFromNBT(qoac2);
        this.readDungeons(qoac2);
        this.randomEquipState.readFromNbt(qoac2);
        if (this.advanced.job == EnumJobType.Bard) {
            qoac qoac3 = qoac2._m("Bard");
            this.jobInterface.readEntityFromNBT(qoac3);
        }
        if (this.advanced.job == EnumJobType.Boss) {
            ((JobBoss)this.jobInterface).hideName = qoac2._o("Boss");
        }
        this.stats.collidable = qoac2._o("Collision");
        this.stats.playersThrowOff = qoac2._o("ThrowOff");
        this.clientFaction = new Faction();
        this.clientFaction.readNBT(qoac2._m("Faction"));
        this.display.readToNBT(qoac2);
    }

    @Override
    public String func_70005_c_() {
        return this.display.name;
    }

    @Override
    public boolean func_70003_b(int n, String string) {
        return CustomNpcs.NpcUseOpCommands ? true : n <= 2;
    }

    @Override
    public zwaw func_82114_b() {
        return new zwaw(sajh._c(this.field_70165_t), sajh._c(this.field_70163_u), sajh._c(this.field_70161_v));
    }

    @Override
    public boolean func_70686_a(Class clazz) {
        return EntityBat.class != clazz;
    }

    public void setImmuneToFire(boolean bl) {
        this.field_70178_ae = bl;
        this.stats.immuneToFire = bl;
    }

    public void setAvoidWater(boolean bl) {
        this.func_70661_as()._a(bl);
        this.aiData.avoidsWater = bl;
    }

    public boolean isSleeping() {
        return this.isSleeping;
    }

    public void setSleeping(boolean bl) {
        this.isSleeping = bl;
    }

    @Override
    protected void func_70069_a(float f) {
        if (!this.stats.noFallDamage) {
            super.func_70069_a(f);
        }
    }

    @Override
    public boolean func_70067_L() {
        return !this.isKilled();
    }

    @Override
    public boolean func_70104_M() {
        return !this.isKilled();
    }

    @Override
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110140_aT()._b(sajz._e);
    }

    public EntityAIRangedAttack getRangedTask() {
        return this.aiRange;
    }

    @Override
    public void func_70006_a(net.minecraft.util.zwat zwat2) {
    }

    @Override
    public cvzo func_130225_q(int n) {
        return this.inventory.armorItemInSlot(n);
    }

    @Override
    public void func_70063_aa() {
    }

    @Override
    public ozlu func_130014_f_() {
        return this.field_70170_p;
    }

    @Override
    public boolean func_98034_c(EntityPlayer entityPlayer) {
        return this.display.visible == 1 && (entityPlayer.func_70694_bm() == null || entityPlayer.func_70694_bm()._a() != CustomItems.wand);
    }

    @Override
    public boolean func_82150_aj() {
        return this.display.visible != 0;
    }

    @Override
    public float getDamage() {
        return this.stats.pDamage;
    }

    @Override
    public float getDamageDecrease() {
        return (float)(this.stats.damageLoss / 100.0);
    }

    @Override
    public float getBleedingChance() {
        return (float)this.stats.bleedingChance / 100.0f;
    }

    public boolean canPlayerEdit(EntityPlayer entityPlayer) {
        if (!CustomNpcsPermissions.Instance.hasPermission(entityPlayer.field_71092_bJ, "customnpcs.npc.edit")) {
            return false;
        }
        return this.status.canEdit(entityPlayer);
    }

    public boolean isHuman() {
        return this.display.modelType == EnumModelType.HumanMale || this.display.modelType == EnumModelType.HumanFemale;
    }

    public String getCurrentOwner() {
        return this.status.getCurrentOwner();
    }

    public void sync() {
        NoppesUtilServer.sendDataToAll(this, EnumPacketType.UpdateNpc, this.copy());
    }

    @Override
    @NotNull
    public String getType() {
        if ("npc" == null) {
            EntityNPCInterface.$$$reportNull$$$0(0);
        }
        return "npc";
    }

    @Override
    public int getTraceWeight() {
        return this.roleInterface != null ? 2 : 1;
    }

    private static /* synthetic */ void $$$reportNull$$$0(int n) {
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "noppes/npcs/EntityNPCInterface", "getType"));
    }
}

