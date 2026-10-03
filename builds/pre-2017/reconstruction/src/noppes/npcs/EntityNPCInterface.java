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
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIDoorInteract;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.amww;
import net.minecraft.entity.ai.pidb;
import net.minecraft.entity.ai.tdpf;
import net.minecraft.entity.ai.turb;
import net.minecraft.entity.ai.uxqz;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.sajz;
import net.minecraft.entity.tdmn;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.Vec3Pool;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
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
ICommandSender,
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

    public EntityNPCInterface(World world) {
        super(world);
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
        this.experienceValue = 0;
        this.labelOffset = 0.0f;
        this.scaleZ = 0.9375f;
        this.scaleY = 0.9375f;
        this.scaleX = 0.9375f;
        this.updateHitbox();
        this.setFaction(this.getFaction().id);
        this.updateTasks();
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher._a(14, (Object)0);
        this.dataWatcher._a(15, (Object)0);
        this.dataWatcher._a(23, (Object)0);
        this.dataWatcher._a(24, (Object)0);
    }

    @Override
    public boolean canEntityBeSeen(Entity entity) {
        Vec3Pool vec3Pool = this.worldObj.getWorldVec3Pool();
        MovingObjectPosition movingObjectPosition = this.worldObj.func_72831_a(vec3Pool._a(this.posX, this.posY + (double)this.getEyeHeight(), this.posZ), vec3Pool._a(entity.posX, entity.posY + (double)entity.getEyeHeight(), entity.posZ), false, true);
        return movingObjectPosition == null;
    }

    @Override
    public AxisAlignedBB getCollisionBox(Entity entity) {
        return entity.canBePushed() && !this.isKilled() ? entity.boundingBox : null;
    }

    @Override
    public AxisAlignedBB getBoundingBox() {
        return this.stats.collidable && !this.isKilled() ? this.boundingBox : null;
    }

    public boolean doesProhibitsWeapon() {
        return this.advanced.replicas.hasAntiWeaponSounds();
    }

    @Override
    protected boolean isAIEnabled() {
        return true;
    }

    @Override
    public boolean getLeashed() {
        return false;
    }

    public void performInteractReplica(EntityPlayer entityPlayer) {
        if (entityPlayer.getCurrentEquippedItem() != null && entityPlayer.getCurrentEquippedItem()._a() instanceof wolf) {
            this.performReplica(ReplicaSystem.ReplicaType.INTERACT_WEAPON);
        } else {
            this.performReplica(ReplicaSystem.ReplicaType.INTERACT);
        }
    }

    public void performReplica(ReplicaSystem.ReplicaType replicaType) {
        this.advanced.replicas.perform(replicaType);
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        boolean bl;
        float f = (float)this.getEntityAttribute(sajz._e)._e();
        if (this.stats.attackSpeed < 10) {
            entity.hurtResistantTime = 0;
        }
        if ((bl = entity.attackEntityFrom(new NpcDamageSource("mob", this), f)) && this.stats.knockback > 0) {
            entity.addVelocity(-sajh._a(this.rotationYaw * (float)Math.PI / 180.0f) * (float)this.stats.knockback * 0.5f, 0.1, sajh._b(this.rotationYaw * (float)Math.PI / 180.0f) * (float)this.stats.knockback * 0.5f);
            this.motionX *= 0.6;
            this.motionZ *= 0.6;
        }
        if (this.stats.potionType != EnumPotionType.None) {
            if (this.stats.potionType != EnumPotionType.Fire) {
                ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(this.getPotionEffect(this.stats.potionType), this.stats.potionDuration * 20, this.stats.potionAmp));
            } else {
                entity.setFire(this.stats.potionDuration);
            }
        }
        return bl;
    }

    @Override
    public void onUpdate() {
        jxtc._a._a("npc");
        super.onUpdate();
        jxtc._a._b();
    }

    @Override
    public void onLivingUpdate() {
        if (this.availableQuestDeps == null) {
            this.updateQuestDependencies();
        }
        InvokeSideOnly.client(this.worldObj.isRemote, () -> this.checkClientVisiblity());
        if (this.crashMode == 1) {
            throw new RuntimeException("Crash mode 1");
        }
        if (!CustomNpcs.FreezeNPCs) {
            float f;
            if (this.needsReset) {
                this.reset();
                this.needsReset = false;
            }
            if (this.entityToAttack != null) {
                this.entityToAttack = null;
            }
            this.updateArmSwingProgress();
            if (!this.worldObj.isRemote) {
                if (!this.isKilled() && !this.isAttacking() && this.ticksExisted % 20 == 0) {
                    if (this.stats.healthRegen && this.getHealth() < this.getMaxHealth()) {
                        f = this.getMaxHealth() / 20.0f;
                        this.heal(f > 0.0f ? f : 1.0f);
                    }
                    if (this.getFaction().getsAttacked) {
                        List list2 = this.worldObj.getEntitiesWithinAABB(EntityMob.class, this.boundingBox._b(16.0, 16.0, 16.0));
                        for (EntityMob entityMob : list2) {
                            if (entityMob.getAttackTarget() != null || !this.canEntityBeSeen(entityMob)) continue;
                            if (entityMob instanceof EntityZombie && !entityMob.getEntityData()._c("AttackNpcs")) {
                                entityMob.tasks._a(2, new pidb(entityMob, EntityLivingBase.class, 1.0, false));
                                entityMob.getEntityData()._a("AttackNpcs", true);
                            }
                            entityMob.setAttackTarget(this);
                            break;
                        }
                    }
                }
                if (this.getHealth() <= 0.0f) {
                    this.clearActivePotions();
                    this.dataWatcher._b(24, 1);
                }
                this.dataWatcher._b(23, (byte)(this.getAttackTarget() != null ? 1 : 0));
                this.dataWatcher._b(15, this.getNavigator()._g() ? 0 : 1);
            }
            if (this.wasKilled != this.isKilled() && this.wasKilled) {
                this.reset();
            }
            this.wasKilled = this.isKilled();
            if (this.worldObj.isDaytime() && !this.worldObj.isRemote && this.stats.burnInSun && (f = this.getBrightness(1.0f)) > 0.5f && this.rand.nextFloat() * 30.0f < (f - 0.4f) * 2.0f && this.worldObj.canBlockSeeTheSky(sajh._c(this.posX), sajh._c(this.posY), sajh._c(this.posZ))) {
                this.setFire(8);
            }
            super.onLivingUpdate();
            if (this.worldObj.isRemote) {
                if (!this.display.cloakTexture.isEmpty()) {
                    this.cloakUpdate();
                }
                if (this.currentAnimation.ordinal() != this.dataWatcher._c(14)) {
                    this.currentAnimation = EnumAnimation.values()[this.dataWatcher._c(14)];
                    this.updateHitbox();
                }
                if (this.advanced.job == EnumJobType.Bard) {
                    ((JobBard)this.jobInterface).onLivingUpdate();
                }
            }
            if (this.shootTimer > 0) {
                --this.shootTimer;
            }
            if (this.getAttackTarget() != null && !this.getAttackTarget().isEntityAlive()) {
                this.setAttackTarget(null);
            }
        }
    }

    @gloomyfolken.bundle.common.core.ezey(_a={eidj.CLIENT})
    private void checkClientVisiblity() {
        fokl fokl2 = Minecraft._E().__ah;
        fokl2._a("npc_visibility");
        EntityClientPlayerMP entityClientPlayerMP = Minecraft._E()._t;
        if (entityClientPlayerMP != null && this.getDistanceSqToEntity(entityClientPlayerMP) < 256.0) {
            Vec3 vec3;
            Vec3Pool vec3Pool = this.worldObj.getWorldVec3Pool();
            Vec3 vec32 = vec3Pool._a(entityClientPlayerMP.posX, entityClientPlayerMP.posY, entityClientPlayerMP.posZ);
            this.isSeen = this.worldObj.func_72933_a(vec32, vec3 = vec3Pool._a(this.posX, this.posY + (double)this.getEyeHeight(), this.posZ)) == null;
        }
        fokl2._b();
    }

    private void updateQuestDependencies() {
        if (!this.worldObj.isRemote) {
            this.availableQuestDeps = NpcQuestDependencies.buildDependencies(this);
        }
    }

    private void handleSquadInteraction(EntityPlayer entityPlayer) {
        entityPlayer.addChatMessage(this.getUniqueID().toString());
        PlayerData playerData = PlayerData.getData(entityPlayer);
        if (entityPlayer.isSneaking()) {
            NpcSquad npcSquad;
            if (!(this.roleInterface instanceof RoleSquad) || (npcSquad = ((RoleSquad)this.roleInterface).getSquad()) == null) {
                entityPlayer.addChatMessage((Object)((Object)EnumChatFormatting._l) + this.display.name + " \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0442 \u0432 \u043e\u0442\u0440\u044f\u0434\u0435");
            } else {
                Set set = npcSquad.getMembers().values().stream().map(squadMember -> squadMember.getNpc(entityPlayer.worldObj)).collect(Collectors.toSet());
                set.remove(this);
                entityPlayer.addChatMessage((Object)((Object)EnumChatFormatting._l) + this.display.name + " \u0441\u043e\u0441\u0442\u043e\u0438\u0442 \u0432 \u043e\u0434\u043d\u043e\u043c \u043e\u0442\u0440\u044f\u0434\u0435 \u0441 " + set.stream().map(entityNPCInterface -> entityNPCInterface.display.name).collect(Collectors.joining(", ")));
            }
        } else {
            if (this.advanced.role != EnumRoleType.Squad) {
                RoleSquad.setSquadMember(this);
                entityPlayer.addChatMessage((Object)((Object)EnumChatFormatting._k) + "\u0420\u043e\u043b\u044c " + this.display.name + " \u0438\u0437\u043c\u0435\u043d\u0435\u043d\u0435\u043d\u0430 \u043d\u0430 '\u041e\u0442\u0440\u044f\u0434'");
                System.out.println("Changed role to squad");
            }
            if (!this.getUniqueID().equals(playerData.targetNpcUUID)) {
                if (playerData.targetNpcUUID == null) {
                    playerData.targetNpcUUID = this.getPersistentID();
                    entityPlayer.addChatMessage((Object)((Object)EnumChatFormatting._k) + "\u041d\u041f\u0421 " + this.display.name + " \u0441\u043e\u0445\u0440\u0430\u043d\u0435\u043d. \u0423\u043a\u0430\u0436\u0438\u0442\u0435 \u043d\u043f\u0441, \u0437\u0430 \u043a\u043e\u0442\u043e\u0440\u043e\u043c \u043e\u043d \u0434\u043e\u043b\u0436\u0435\u043d \u0441\u043b\u0435\u0434\u043e\u0432\u0430\u0442\u044c.");
                    System.out.println("Target uuid null, attaching to players");
                } else {
                    EntityNPCInterface entityNPCInterface2 = (EntityNPCInterface)ncwh._a(this.worldObj, playerData.targetNpcUUID);
                    if (entityNPCInterface2 != null) {
                        NpcSquad npcSquad;
                        System.out.println("Target follower found");
                        SquadsRegistry squadsRegistry = SquadsRegistry.get(this.worldObj);
                        NpcSquad npcSquad2 = squadsRegistry.getSquadWith(this);
                        if (npcSquad2 == null) {
                            System.out.println("Trying to add to squad which doesnt exists, creating it");
                            npcSquad2 = squadsRegistry.addSquad(NpcSquad.createWith(this));
                        }
                        if ((npcSquad = squadsRegistry.getSquadWith(entityNPCInterface2)) != null) {
                            System.out.println("Follower was in squad, removing him from it");
                            npcSquad.removeFromSquad(entityNPCInterface2.getUniqueID());
                            if (npcSquad.getMembers().size() <= 1) {
                                squadsRegistry.removeSquad(npcSquad.id);
                            }
                        }
                        entityPlayer.addChatMessage((Object)((Object)EnumChatFormatting._k) + "\u041d\u041f\u0421 " + entityNPCInterface2.display.name + " \u0442\u0435\u043f\u0435\u0440\u044c \u0441\u043b\u0435\u0434\u0443\u0435\u0442 \u0437\u0430 " + this.display.name);
                        npcSquad2.addToSquad(entityNPCInterface2, this);
                        squadsRegistry.markDirty();
                    } else {
                        entityPlayer.addChatMessage((Object)((Object)EnumChatFormatting._m) + "\u0421\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u043d\u044b\u0439 \u043d\u043f\u0441 \u043d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d.");
                    }
                    playerData.targetNpcUUID = null;
                }
            } else {
                entityPlayer.addChatMessage((Object)((Object)EnumChatFormatting._l) + "\u0423\u043a\u0430\u0436\u0438\u0442\u0435 \u043d\u043f\u0441 \u0437\u0430 \u043a\u043e\u0442\u043e\u0440\u044b\u043c \u0434\u043e\u043b\u0436\u0435\u043d \u0441\u043b\u0435\u0434\u043e\u0432\u0430\u0442\u044c " + this.display.name);
            }
        }
    }

    @Override
    public boolean interact(EntityPlayer entityPlayer) {
        if (this.worldObj.isRemote) {
            return false;
        }
        System.out.println(this.getPersistentID().toString());
        ItemStack itemStack = entityPlayer.inventory._a();
        if (itemStack != null) {
            if (itemStack._d == CustomItems.moving.itemID) {
                this.setAttackTarget(null);
                if (itemStack._e == null) {
                    itemStack._e = new NBTTagCompound();
                }
                itemStack._e._a("NPCID", this.entityId);
                entityPlayer.sendChatToPlayer(ChatMessageComponent._d("Registered " + this.getEntityName() + " to your NPC Pather"));
                return true;
            }
            if (itemStack._d == CustomItems.squadController.itemID) {
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
        if (playerData.currentDialogNpc != null && playerData.currentDialogNpc.equals(this.getUniqueID())) {
            return;
        }
        boolean bl2 = bl = entityPlayer.getCurrentEquippedItem() != null && entityPlayer.getCurrentEquippedItem()._a() instanceof wolf;
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
        return quest != null && quest.completion == EnumQuestCompletion.Npc && quest.completerNpc.equals(this.getEntityName());
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
        Integer n = PlayerData.getData((EntityPlayer)entityPlayer).storedDialogs.getOrDefault(this.getUniqueID(), -1);
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
            npcSquad.removeFromSquad(this.getUniqueID());
            if (npcSquad.getMembers().size() <= 1) {
                SquadsRegistry squadsRegistry = SquadsRegistry.get(this.worldObj);
                squadsRegistry.removeSquad(npcSquad.id);
                squadsRegistry.markDirty();
            }
            this.advanced.setRole(EnumRoleType.None.ordinal());
            entityPlayer.addChatMessage((Object)((Object)EnumChatFormatting._k) + this.display.name + " \u0443\u0434\u0430\u043b\u0435\u043d \u0438\u0437 \u043e\u0442\u0440\u044f\u0434\u0430");
        } else {
            entityPlayer.addChatMessage((Object)((Object)EnumChatFormatting._m) + "\u041d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0442 \u0432 \u043e\u0442\u0440\u044f\u0434\u0435");
        }
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        if (!(this.worldObj.isRemote || this.isKilled() || CustomNpcs.FreezeNPCs || damageSource.damageType.equals("inWall"))) {
            Object object;
            Object object2;
            f = this.stats.resistances.applyResistance(damageSource, f);
            if (this.advanced.job == EnumJobType.Boss && ((JobBoss)this.jobInterface).applyDamage(f)) {
                return false;
            }
            Entity entity = damageSource.getEntity();
            EntityLivingBase entityLivingBase = null;
            if (this.advanced.role == EnumRoleType.Squad && entity instanceof EntityPlayer && (object2 = ((EntityPlayer)(object = (EntityPlayer)entity)).getCurrentEquippedItem()) != null && ((ItemStack)object2)._d == CustomItems.squadController.itemID) {
                this.clearSquad((EntityPlayer)object);
                return false;
            }
            if (entity instanceof EntityLivingBase) {
                entityLivingBase = (EntityLivingBase)entity;
            }
            if (entityLivingBase instanceof EntityPlayer && this.getFaction().isFriendlyToPlayer((EntityPlayer)entityLivingBase)) {
                return false;
            }
            if (entity instanceof EntityArrow && ((EntityArrow)entity).shootingEntity != null) {
                entityLivingBase = (EntityLivingBase)((EntityArrow)entity).shootingEntity;
            }
            if (this.roleInterface instanceof RoleSquad && entityLivingBase != null && (object2 = ((RoleSquad)(object = (RoleSquad)this.roleInterface)).getSquad()) != null) {
                ((NpcSquad)object2).squadState = NpcSquad.DEFENSE_STATE;
                ((NpcSquad)object2).enemeyEntityId = entityLivingBase.entityId;
            }
            int n = this.getFaction().id;
            if (!damageSource.isExplosion() && entityLivingBase instanceof EntityNPCInterface && ((EntityNPCInterface)entityLivingBase).getFaction().id == n) {
                return false;
            }
            if (entityLivingBase == null || damageSource.isExplosion() && entity == this) {
                return super.attackEntityFrom(damageSource, f);
            }
            if (this.isAttacking()) {
                if (this.getAttackTarget() != null && entityLivingBase != null && this.getDistanceSqToEntity(this.getAttackTarget()) > this.getDistanceSqToEntity(entityLivingBase)) {
                    this.setAttackTarget(entityLivingBase);
                }
                return super.attackEntityFrom(damageSource, f);
            }
            if (f > 0.0f) {
                this.notifyAlliesAboutAttacker(entityLivingBase);
                this.setAttackTarget(entityLivingBase);
            }
            return super.attackEntityFrom(damageSource, f);
        }
        return false;
    }

    public void notifyAlliesAboutAttacker(EntityLivingBase entityLivingBase) {
        int n = this.getFaction().id;
        List list2 = this.worldObj.getEntitiesWithinAABB(EntityNPCInterface.class, this.boundingBox._b(32.0, 16.0, 32.0));
        for (EntityNPCInterface entityNPCInterface : list2) {
            if (entityNPCInterface.isKilled() || !entityNPCInterface.advanced.defendFaction || entityNPCInterface.getFaction().id != n || !entityNPCInterface.canEntityBeSeen(this) && !entityNPCInterface.canEntityBeSeen(entityLivingBase)) continue;
            entityNPCInterface.onAttack(entityLivingBase);
        }
    }

    public void onAttack(EntityLivingBase entityLivingBase) {
        if (entityLivingBase != null && entityLivingBase != this && !this.isAttacking() && this.aiData.onAttack != 3) {
            super.setAttackTarget(entityLivingBase);
        }
    }

    @Override
    public void setAttackTarget(EntityLivingBase entityLivingBase) {
        if (!(entityLivingBase instanceof EntityPlayer) || !((EntityPlayer)entityLivingBase).capabilities._a) {
            if (entityLivingBase != null && entityLivingBase != this && this.aiData.onAttack != 3 && !this.isAttacking() && !this.isRemote()) {
                this.performReplica(ReplicaSystem.ReplicaType.ATTACK);
            }
            super.setAttackTarget(entityLivingBase);
        }
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase entityLivingBase, float f) {
        InvokeSideOnly.frontend(() -> {});
    }

    private void clearTasks(EntityAITasks entityAITasks) {
        for (tdpf tdpf2 : entityAITasks._a) {
            EntityAIBase entityAIBase = tdpf2._a;
            if (!entityAITasks._b.contains(tdpf2)) continue;
            entityAIBase.resetTask();
        }
        entityAITasks._a = new ArrayList();
        entityAITasks._b = new ArrayList();
    }

    public void updateTasks() {
        InvokeSideOnly.frontend(this.worldObj != null && !this.worldObj.isRemote, () -> {});
    }

    public void setResponse() {
        this.aiRange = null;
        if (this.aiData.onAttack == 1) {
            this.tasks._a(this.taskCount++, new EntityAIPanic(this, 1.4f));
        } else if (this.aiData.onAttack == 2) {
            this.tasks._a(this.taskCount++, new EntityAIAvoidTarget(this));
            this.setCanSprint();
        } else if (this.aiData.onAttack == 0) {
            this.setCanLeap();
            this.setCanSprint();
            if (this.inventory.getFirearm() != null && this.aiData.useRangeMelee != 2) {
                switch (this.aiData.tacticalVariant) {
                    case Dodge: {
                        this.tasks._a(this.taskCount++, new EntityAIDodgeShoot(this));
                        break;
                    }
                    case Surround: {
                        this.tasks._a(this.taskCount++, new EntityAIOrbitTarget(this, 1.0, this.stats.rangedRange, false));
                        break;
                    }
                    case Ambush: {
                        this.tasks._a(this.taskCount++, new EntityAIAmbushTarget(this, 1.2, this.aiData.tacticalRadius, false));
                        break;
                    }
                    case Stalk: {
                        this.tasks._a(this.taskCount++, new EntityAIStalkTarget(this, this.aiData.tacticalRadius));
                    }
                }
            } else {
                switch (this.aiData.tacticalVariant) {
                    case Dodge: {
                        this.tasks._a(this.taskCount++, new EntityAIZigZagTarget(this, 1.0, this.aiData.tacticalRadius));
                        break;
                    }
                    case Surround: {
                        this.tasks._a(this.taskCount++, new EntityAIOrbitTarget(this, 1.0, this.aiData.tacticalRadius, true));
                        break;
                    }
                    case Ambush: {
                        this.tasks._a(this.taskCount++, new EntityAIAmbushTarget(this, 1.2, this.aiData.tacticalRadius, false));
                        break;
                    }
                    case Stalk: {
                        this.tasks._a(this.taskCount++, new EntityAIStalkTarget(this, this.aiData.tacticalRadius));
                    }
                }
            }
            this.tasks._a(this.taskCount, new EntityAIAttackTarget(this, true));
            if (this.inventory.getFirearm() != null) {
                this.aiRange = new EntityAIRangedAttack(this);
                this.tasks._a(this.taskCount++, this.aiRange);
            }
        }
    }

    public void setMoveType() {
        if (this.aiData.movingType == EnumMovingType.Wandering) {
            this.tasks._a(this.taskCount++, new EntityAIWander(this));
        }
        if (this.aiData.movingType == EnumMovingType.MovingPath) {
            this.tasks._a(this.taskCount++, new EntityAIMovingPath(this));
        }
    }

    public void doorInteractType() {
        EntityAIDoorInteract entityAIDoorInteract = null;
        if (this.aiData.doorInteract == 1) {
            entityAIDoorInteract = new uxqz(this, true);
        } else if (this.aiData.doorInteract == 0) {
            entityAIDoorInteract = new EntityAIBustDoor(this);
        }
        if (entityAIDoorInteract != null) {
            this.tasks._a(this.taskCount++, entityAIDoorInteract);
        }
        this.getNavigator()._b(entityAIDoorInteract != null);
    }

    public void seekShelter() {
        if (this.aiData.findShelter == 0) {
            this.tasks._a(this.taskCount++, new EntityAIMoveIndoors(this));
        } else if (this.aiData.findShelter == 1) {
            this.tasks._a(this.taskCount++, new turb(this));
            this.tasks._a(this.taskCount++, new EntityAIFindShade(this));
        }
    }

    public void setCanSleep() {
        if (this.aiData.canSleep) {
            this.tasks._a(this.taskCount++, new EntityAIOccupyBed(this));
        }
    }

    public void setCanLeap() {
        if (this.aiData.canLeap) {
            this.tasks._a(this.taskCount++, new amww(this, 0.4f));
        }
    }

    public void setCanSprint() {
        if (this.aiData.canSprint) {
            this.tasks._a(this.taskCount++, new EntityAISprintToTarget(this));
        }
    }

    public void addRegularEntries() {
        this.tasks._a(this.taskCount++, new EntityAIReturn(this));
        this.tasks._a(this.taskCount++, new EntityAILook(this));
        if (this.aiData.standingType != EnumStandingType.NoRotation && this.aiData.standingType != EnumStandingType.HeadRotation) {
            this.tasks._a(this.taskCount++, new EntityAIWatchClosest(this, EntityLiving.class, 5.0f));
        }
        this.tasks._a(this.taskCount++, new EntityAIWorldLines(this));
        this.tasks._a(this.taskCount++, new EntityAIJob(this));
        this.tasks._a(this.taskCount++, new EntityAIRole(this));
        this.tasks._a(this.taskCount++, new EntityAIAnimation(this));
    }

    public float getSpeed() {
        return (float)this.stats.moveSpeed / 20.0f;
    }

    @Override
    public float getBlockPathWeight(int n, int n2, int n3) {
        return this.worldObj.getLightBrightness(n, n2, n3) - 0.5f;
    }

    private int getPotionEffect(EnumPotionType enumPotionType) {
        switch (enumPotionType) {
            case Poison: {
                return Potion._u._H;
            }
            case Hunger: {
                return Potion._s._H;
            }
            case Weakness: {
                return Potion._t._H;
            }
            case Slowness: {
                return Potion._d._H;
            }
            case Nausea: {
                return Potion._k._H;
            }
            case Blindness: {
                return Potion._q._H;
            }
            case Wither: {
                return Potion._v._H;
            }
        }
        return 0;
    }

    @Override
    protected int decreaseAirSupply(int n) {
        return !this.stats.canDrown ? n : super.decreaseAirSupply(n);
    }

    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return this.stats.creatureType;
    }

    @Override
    public String getEntityName() {
        return this.display.name;
    }

    @Override
    protected String getLivingSound() {
        return this.isEntityAlive() ? (this.getAttackTarget() != null && !this.advanced.angrySound.equals("") ? this.advanced.angrySound : this.advanced.idleSound) : null;
    }

    @Override
    public String getHurtSound() {
        return this.advanced.hurtSound;
    }

    @Override
    public String getDeathSound() {
        return this.advanced.deathSound;
    }

    @Override
    protected void playStepSound(int n, int n2, int n3, int n4) {
        if (!this.advanced.stepSound.equals("")) {
            this.playSound(this.advanced.stepSound, 0.15f, 1.0f);
        } else {
            StepSound stepSound = Block.blocksList[n4].stepSound;
            if (this.worldObj.getBlockId(n, n2 + 1, n3) == Block.snow.blockID) {
                stepSound = Block.snow.stepSound;
                this.playSound(stepSound._d(), stepSound._a() * 0.15f, stepSound._b());
            } else if (!Block.blocksList[n4].blockMaterial._d()) {
                this.playSound(stepSound._d(), stepSound._a() * 0.15f, stepSound._b());
            }
        }
    }

    public void say(EntityPlayer entityPlayer, Line line) {
        this.say(entityPlayer, line, true);
    }

    public void say(EntityPlayer entityPlayer, Line line, boolean bl) {
        if (line != null && (!bl || this.canEntityBeSeen(entityPlayer))) {
            if (!line.sound.isEmpty()) {
                long l = System.currentTimeMillis();
                if (!this.lastSounds.containsKey(entityPlayer.getCommandSenderName()) || l - this.lastSounds.get(entityPlayer.getCommandSenderName()) > SOUND_COOLDOWN) {
                    NoppesUtilServer.sendData(entityPlayer, EnumPacketType.PlaySound, line.sound, Float.valueOf((float)this.posX), Float.valueOf((float)this.posY), Float.valueOf((float)this.posZ));
                    this.lastSounds.put(entityPlayer.getCommandSenderName(), l);
                }
            }
            if (!line.text.isEmpty()) {
                String string = NoppesStringUtils.formatText(line.text, entityPlayer.username);
                entityPlayer.addChatMessage(this.getEntityName() + ": " + string);
            }
        }
    }

    @Override
    public void addVelocity(double d, double d2, double d3) {
        if (this.isWalking() && !this.isKilled()) {
            super.addVelocity(d, d2, d3);
        }
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
        this.crashMode = nBTTagCompound._f("crashMode");
        if (this.crashMode == 2) {
            throw new RuntimeException("Crash mode 2");
        }
        this.npcVersion = nBTTagCompound._f("ModRev");
        VersionCompatibility.CheckNpcCompatibility(this, nBTTagCompound);
        this.status.readFromNBT(nBTTagCompound);
        this.readDungeons(nBTTagCompound);
        this.isSpawned = nBTTagCompound._o("IsSpawned");
        this.sharedDataId = nBTTagCompound._f("sharedDataId");
        if (this.sharedDataId == 0 || this.worldObj.isRemote || NpcSynchronizer.instance.loadSharedData(this)) {
            this.display.readToNBT(nBTTagCompound);
            this.stats.readToNBT(nBTTagCompound);
            this.aiData.readData(nBTTagCompound);
            this.advanced.readToNBT(nBTTagCompound);
            this.inventory.readEntityFromNBT(nBTTagCompound);
            this.dialogs = this.getDialogs(nBTTagCompound._n("NPCDialogOptions"));
        }
        this.randomEquipState.readFromNbt(nBTTagCompound);
        this.aiData.readMovement(nBTTagCompound);
        this.deathTime = nBTTagCompound._g("NpcDeathTime");
        this.startPos = NBTTags.getIntArray(nBTTagCompound._n("StartPos"));
        if (this.startPos == null || this.startPos.length != 3) {
            this.startPos = new int[]{sajh._c(this.posX), sajh._c(this.posY), sajh._c(this.posZ)};
        }
        this.needsReset = nBTTagCompound._o("needsReset");
        this.textureLocation = null;
        this.textureGlowLocation = null;
        this.textureCloakLocation = null;
        this.updateTasks();
        if (this.availableQuestDeps == null) {
            this.updateQuestDependencies();
        }
    }

    public HashMap getDialogs(NBTTagList nBTTagList) {
        HashMap<Integer, DialogOption> hashMap = new HashMap<Integer, DialogOption>();
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTTagList._b(i);
            int n = nBTTagCompound._f("DialogSlot");
            DialogOption dialogOption = new DialogOption();
            dialogOption.readNBT(nBTTagCompound._m("NPCDialog"));
            hashMap.put(n, dialogOption);
        }
        return hashMap;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
        nBTTagCompound._a("crashMode", this.crashMode);
        if (this.crashMode == 3) {
            throw new RuntimeException("Crash mode 3");
        }
        nBTTagCompound._a("sharedDataId", this.sharedDataId);
        this.status.writeToNBT(nBTTagCompound);
        this.display.writeToNBT(nBTTagCompound);
        this.stats.writeToNBT(nBTTagCompound);
        this.aiData.writeToNBT(nBTTagCompound);
        this.aiData.writeMovement(nBTTagCompound);
        this.advanced.writeToNBT(nBTTagCompound);
        this.inventory.writeEntityToNBT(nBTTagCompound);
        this.randomEquipState.writeToNbt(nBTTagCompound);
        nBTTagCompound._a("IsSpawned", this.isSpawned);
        nBTTagCompound._a("NPCDialogOptions", this.nbtDialogs(this.dialogs));
        nBTTagCompound._a("NpcDeathTime", this.deathTime);
        this.writeDungeons(nBTTagCompound);
        if (this.startPos == null) {
            this.startPos = new int[]{sajh._c(this.posX), sajh._c(this.posY), sajh._c(this.posZ)};
        }
        nBTTagCompound._a("StartPos", NBTTags.nbtIntArray(this.startPos));
        nBTTagCompound._a("ModRev", this.npcVersion);
        nBTTagCompound._a("needsReset", this.needsReset);
        this.getEntityAttribute(sajz._a)._a(this.stats.maxHealth);
        this.getEntityAttribute(sajz._b)._a(CustomNpcs.NpcNavRange);
        this.getEntityAttribute(sajz._d)._a(this.getSpeed());
        this.getEntityAttribute(sajz._e)._a(this.stats.attackStrength);
    }

    private void writeDungeons(NBTTagCompound nBTTagCompound) {
        NBTTagList nBTTagList = new NBTTagList();
        for (String string : this.dungeons) {
            nBTTagList._a(new NBTTagString(null, string));
        }
        nBTTagCompound._a("Dungeons", nBTTagList);
    }

    private void readDungeons(NBTTagCompound nBTTagCompound) {
        this.dungeons.clear();
        NBTTagList nBTTagList = nBTTagCompound._n("Dungeons");
        for (int i = 0; i < nBTTagList._d(); ++i) {
            this.dungeons.add(((NBTTagString)nBTTagList._b((int)i))._c);
        }
    }

    public NBTTagList nbtDialogs(HashMap hashMap) {
        NBTTagList nBTTagList = new NBTTagList();
        Iterator iterator2 = hashMap.keySet().iterator();
        while (iterator2.hasNext()) {
            int n = (Integer)iterator2.next();
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound._a("DialogSlot", n);
            nBTTagCompound._a("NPCDialog", ((DialogOption)hashMap.get(n)).writeNBT());
            nBTTagList._a(nBTTagCompound);
        }
        return nBTTagList;
    }

    public void updateHitbox() {
        if (this.currentAnimation == EnumAnimation.LYING) {
            this.height = 0.2f;
            this.width = 0.2f;
        } else if (this.currentAnimation == EnumAnimation.SITTING) {
            this.width = 0.6f;
            this.height = 1.3f;
        } else {
            this.width = 0.6f;
            this.height = 1.8f;
        }
        this.width = this.width / 5.0f * (float)this.display.modelSize;
        this.height = this.height / 5.0f * (float)this.display.modelSize;
    }

    public void dropPlayerItemWithRandomChoice(ItemStack itemStack, boolean bl) {
        if (itemStack != null) {
            EntityItem entityItem = new EntityItem(this.worldObj, this.posX, this.posY - (double)0.3f + (double)this.getEyeHeight(), this.posZ, itemStack);
            entityItem.delayBeforeCanPickup = 40;
            if (bl) {
                float f = this.rand.nextFloat() * 0.5f;
                float f2 = this.rand.nextFloat() * 3.141593f * 2.0f;
                entityItem.motionX = -sajh._a(f2) * f;
                entityItem.motionZ = sajh._b(f2) * f;
                entityItem.motionY = 0.2f;
            } else {
                float f = 0.3f;
                entityItem.motionX = -sajh._a(this.rotationYaw / 180.0f * 3.141593f) * sajh._b(this.rotationPitch / 180.0f * 3.141593f) * f;
                entityItem.motionZ = sajh._b(this.rotationYaw / 180.0f * 3.141593f) * sajh._b(this.rotationPitch / 180.0f * 3.141593f) * f;
                entityItem.motionY = -sajh._a(this.rotationPitch / 180.0f * 3.141593f) * f + 0.1f;
                f = 0.02f;
                float f3 = this.rand.nextFloat() * 3.141593f * 2.0f;
                entityItem.motionX += Math.cos(f3) * (double)(f *= this.rand.nextFloat());
                entityItem.motionY += (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1f);
                entityItem.motionZ += Math.sin(f3) * (double)f;
            }
            this.worldObj.spawnEntityInWorld(entityItem);
        }
    }

    @Override
    public void onDeathUpdate() {
        if (this.stats.spawnCycle == 1 && this.onProductionServer()) {
            super.onDeathUpdate();
        } else if (!this.worldObj.isRemote) {
            boolean bl;
            boolean bl2;
            if (!this.hasDied) {
                this.setDead();
            }
            boolean bl3 = bl2 = System.currentTimeMillis() - this.deathTime > (long)(this.stats.respawnTime * 10 * 50);
            if (!bl2) {
                return;
            }
            boolean bl4 = bl = !this.stats.spawnTimeRanges.shouldCheck() || this.stats.spawnTimeRanges.matches(bqgh._c(this.worldObj.getWorldTime()));
            if (bl) {
                this.reset();
            }
        }
    }

    public void reset() {
        this.hasDied = false;
        this.setHealth(this.getMaxHealth());
        this.dataWatcher._b(24, 0);
        this.dataWatcher._b(14, 0);
        this.dataWatcher._b(15, 0);
        this.setAttackTarget(null);
        this.setRevengeTarget(null);
        ((EntityLivingBase)this).deathTime = 0;
        if (this.startPos != null) {
            this.setLocationAndAngles(this.getStartXPos(), this.getStartYPos() + 1.0, this.getStartZPos(), this.rotationYaw, this.rotationPitch);
        }
        this.deathTime = -1L;
        this.extinguish();
        this.clearActivePotions();
        this.moveEntityWithHeading(0.0f, 0.0f);
        this.distanceWalkedModified = 0.0f;
        this.getNavigator()._h();
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
        if (!this.worldObj.isRemote) {
            InvokeSideOnly.frontend(() -> {});
        }
    }

    public void cloakUpdate() {
        this.field_20066_r = this.field_20063_u;
        this.field_20065_s = this.field_20062_v;
        this.field_20064_t = this.field_20061_w;
        double d = this.posX - this.field_20063_u;
        double d2 = this.posY - this.field_20062_v;
        double d3 = this.posZ - this.field_20061_w;
        double d4 = 10.0;
        if (d > d4) {
            this.field_20066_r = this.field_20063_u = this.posX;
        }
        if (d3 > d4) {
            this.field_20064_t = this.field_20061_w = this.posZ;
        }
        if (d2 > d4) {
            this.field_20065_s = this.field_20062_v = this.posY;
        }
        if (d < -d4) {
            this.field_20066_r = this.field_20063_u = this.posX;
        }
        if (d3 < -d4) {
            this.field_20064_t = this.field_20061_w = this.posZ;
        }
        if (d2 < -d4) {
            this.field_20065_s = this.field_20062_v = this.posY;
        }
        this.field_20063_u += d * 0.25;
        this.field_20061_w += d3 * 0.25;
        this.field_20062_v += d2 * 0.25;
    }

    @Override
    protected boolean canDespawn() {
        return false;
    }

    @Override
    public ItemStack getHeldItem() {
        return this.isAttacking() ? this.inventory.getWeapon() : (this.jobInterface != null && this.jobInterface.overrideMainHand ? this.jobInterface.mainhand : this.inventory.getWeapon());
    }

    public ItemStack getOffHand() {
        return this.isAttacking() ? this.inventory.getOffHand() : (this.jobInterface != null && this.jobInterface.overrideOffHand ? this.jobInterface.offhand : this.inventory.getOffHand());
    }

    protected void dropStuff() {
        this.inventory.dropStuff(this.recentlyHit > 0);
    }

    protected void onNpcDeath(DamageSource damageSource) {
        this.getNavigator()._b(false);
        this.dropStuff();
        if (!this.isRemote()) {
            this.performReplica(ReplicaSystem.ReplicaType.DEATH);
        }
    }

    @Override
    public void onDeath(DamageSource damageSource) {
        this.onNpcDeath(damageSource);
        super.onDeath(damageSource);
    }

    @Override
    public void setDead() {
        this.hasDied = true;
        boolean bl = this.onProductionServer();
        if (!(this.isSpawned || this.worldObj.isRemote || this.stats.spawnCycle == 1 && bl)) {
            this.setHealth(-1.0f);
            this.deathTime = System.currentTimeMillis();
            if (this.advanced.role != EnumRoleType.None && this.roleInterface != null) {
                this.roleInterface.killed();
            }
            if (this.advanced.job != EnumJobType.None && this.jobInterface != null) {
                this.jobInterface.killed();
            }
        } else {
            this.spawnExplosionParticle();
            this.delete();
        }
    }

    private boolean onProductionServer() {
        if (!this.worldObj.isRemote) {
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
        super.setDead();
    }

    public float getStartXPos() {
        return (float)this.startPos[0] + this.aiData.bodyOffsetX / 10.0f;
    }

    public float getStartZPos() {
        return (float)this.startPos[2] + this.aiData.bodyOffsetZ / 10.0f;
    }

    public boolean isVeryNearAssignedPlace() {
        double d = this.posX - (double)this.getStartXPos();
        double d2 = this.posZ - (double)this.getStartZPos();
        return d >= -0.2 && d <= 0.2 && d2 >= -0.2 && d2 <= 0.2;
    }

    @Override
    public Icon getItemIcon(ItemStack itemStack, int n) {
        EntityPlayer entityPlayer = CustomNpcs.proxy.getPlayer();
        return entityPlayer == null ? super.getItemIcon(itemStack, n) : entityPlayer.getItemIcon(itemStack, n);
    }

    public double getStartYPos() {
        int n = this.startPos[0];
        int n2 = this.startPos[1];
        int n3 = this.startPos[2];
        double d = 0.0;
        for (int i = n2; i >= 0; --i) {
            Block block;
            AxisAlignedBB axisAlignedBB;
            int n4 = this.worldObj.getBlockId(n, i, n3);
            if (n4 == 0 || (axisAlignedBB = (block = Block.blocksList[n4]).getCollisionBoundingBoxFromPool(this.worldObj, n, i, n3)) == null) continue;
            d = axisAlignedBB._f;
            break;
        }
        if (d == 0.0) {
            this.setDead();
        }
        return d += 0.5;
    }

    public void givePlayerItem(EntityPlayer entityPlayer, ItemStack itemStack) {
        if (!this.worldObj.isRemote) {
            itemStack = itemStack._l();
            CustomNpcs.GivePlayerItem(this, entityPlayer, itemStack);
            this.worldObj.playSoundAtEntity(entityPlayer, "random.pop", 0.2f, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7f + 1.0f) * 2.0f);
        }
    }

    @Override
    public boolean isPlayerSleeping() {
        return this.currentAnimation == EnumAnimation.LYING;
    }

    @Override
    public boolean isRiding() {
        return this.currentAnimation == EnumAnimation.SITTING;
    }

    public boolean isWalking() {
        return this.aiData.movingType != EnumMovingType.Standing || this.isAttacking() || this.isFollowerWithOwner() || this.dataWatcher._c(15) == 1;
    }

    @Override
    public boolean isSneaking() {
        return this.currentAnimation == EnumAnimation.SNEAKING;
    }

    @Override
    public void knockBack(Entity entity, float f, double d, double d2) {
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
        return this.worldObj == null || this.worldObj.isRemote;
    }

    public boolean isFollowerWithOwner() {
        return this.advanced.role == EnumRoleType.Follower && ((RoleFollower)this.roleInterface).getDaysLeft() > 0;
    }

    @Override
    public boolean isPotionApplicable(PotionEffect potionEffect) {
        return this.getCreatureAttribute() == EnumCreatureAttribute._c && potionEffect._a() == Potion._u._H ? false : super.isPotionApplicable(potionEffect);
    }

    public NBTTagCompound copy() {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        this.writeToNBTOptional(nBTTagCompound);
        nBTTagCompound._a("EntityId", this.entityId);
        return nBTTagCompound;
    }

    public boolean inNormalState() {
        return !this.isAttacking() && !this.isFollowerWithOwner();
    }

    public boolean isAttacking() {
        return this.dataWatcher._a(23) == 1;
    }

    public boolean isKilled() {
        return this.dataWatcher._c(24) == 1;
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

    public NBTTagCompound writeSpawnData() {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        this.display.writeToNBT(nBTTagCompound);
        nBTTagCompound._a("MaxHealth", this.stats.maxHealth);
        nBTTagCompound._a("Armor", NBTTags.nbtItemStackList(this.inventory.armor));
        nBTTagCompound._a("Weapons", NBTTags.nbtItemStackList(this.inventory.weapons));
        nBTTagCompound._a("Speed", this.stats.moveSpeed);
        nBTTagCompound._a("StandingState", this.aiData.standingType.ordinal());
        nBTTagCompound._a("MovingState", this.aiData.movingType.ordinal());
        nBTTagCompound._a("Orientation", this.aiData.orientation);
        nBTTagCompound._a("Role", this.advanced.role.ordinal());
        nBTTagCompound._a("Job", this.advanced.job.ordinal());
        nBTTagCompound._a("Collision", this.stats.collidable);
        nBTTagCompound._a("ThrowOff", this.stats.playersThrowOff);
        this.status.writeToNBT(nBTTagCompound);
        this.writeDungeons(nBTTagCompound);
        this.randomEquipState.writeToNbt(nBTTagCompound);
        if (this.advanced.job == EnumJobType.Bard) {
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            this.jobInterface.writeEntityToNBT(nBTTagCompound2);
            nBTTagCompound._a("Bard", (NBTBase)nBTTagCompound2);
        }
        if (this.advanced.job == EnumJobType.Boss) {
            nBTTagCompound._a("Boss", ((JobBoss)this.jobInterface).hideName);
        }
        nBTTagCompound._a("Faction", this.getFaction().writeNBT(new NBTTagCompound()));
        return nBTTagCompound;
    }

    @Override
    public void readSpawnData(ByteArrayDataInput byteArrayDataInput) {
        try {
            NBTTagCompound nBTTagCompound = bsvf._a(byteArrayDataInput);
            this.readSpawnData(nBTTagCompound);
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }

    public void readSpawnData(NBTTagCompound nBTTagCompound) {
        this.stats.maxHealth = nBTTagCompound._f("MaxHealth");
        this.stats.moveSpeed = nBTTagCompound._f("Speed");
        this.aiData.standingType = EnumStandingType.values()[nBTTagCompound._f("StandingState") % EnumStandingType.values().length];
        this.aiData.movingType = EnumMovingType.values()[nBTTagCompound._f("MovingState") % EnumMovingType.values().length];
        this.aiData.orientation = nBTTagCompound._f("Orientation");
        this.getEntityAttribute(sajz._a)._a(this.stats.maxHealth);
        this.inventory.setArmor(NBTTags.getItemStackList(nBTTagCompound._n("Armor")));
        this.inventory.setWeapons(NBTTags.getItemStackList(nBTTagCompound._n("Weapons")));
        this.advanced.setRole(nBTTagCompound._f("Role"));
        this.advanced.setJob(nBTTagCompound._f("Job"));
        this.status.readFromNBT(nBTTagCompound);
        this.readDungeons(nBTTagCompound);
        this.randomEquipState.readFromNbt(nBTTagCompound);
        if (this.advanced.job == EnumJobType.Bard) {
            NBTTagCompound nBTTagCompound2 = nBTTagCompound._m("Bard");
            this.jobInterface.readEntityFromNBT(nBTTagCompound2);
        }
        if (this.advanced.job == EnumJobType.Boss) {
            ((JobBoss)this.jobInterface).hideName = nBTTagCompound._o("Boss");
        }
        this.stats.collidable = nBTTagCompound._o("Collision");
        this.stats.playersThrowOff = nBTTagCompound._o("ThrowOff");
        this.clientFaction = new Faction();
        this.clientFaction.readNBT(nBTTagCompound._m("Faction"));
        this.display.readToNBT(nBTTagCompound);
    }

    @Override
    public String getCommandSenderName() {
        return this.display.name;
    }

    @Override
    public boolean canCommandSenderUseCommand(int n, String string) {
        return CustomNpcs.NpcUseOpCommands ? true : n <= 2;
    }

    @Override
    public ChunkCoordinates func_82114_b() {
        return new ChunkCoordinates(sajh._c(this.posX), sajh._c(this.posY), sajh._c(this.posZ));
    }

    @Override
    public boolean canAttackClass(Class clazz) {
        return EntityBat.class != clazz;
    }

    public void setImmuneToFire(boolean bl) {
        this.isImmuneToFire = bl;
        this.stats.immuneToFire = bl;
    }

    public void setAvoidWater(boolean bl) {
        this.getNavigator()._a(bl);
        this.aiData.avoidsWater = bl;
    }

    public boolean isSleeping() {
        return this.isSleeping;
    }

    public void setSleeping(boolean bl) {
        this.isSleeping = bl;
    }

    @Override
    protected void fall(float f) {
        if (!this.stats.noFallDamage) {
            super.fall(f);
        }
    }

    @Override
    public boolean canBeCollidedWith() {
        return !this.isKilled();
    }

    @Override
    public boolean canBePushed() {
        return !this.isKilled();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getAttributeMap()._b(sajz._e);
    }

    public EntityAIRangedAttack getRangedTask() {
        return this.aiRange;
    }

    @Override
    public void sendChatToPlayer(ChatMessageComponent chatMessageComponent) {
    }

    @Override
    public ItemStack func_130225_q(int n) {
        return this.inventory.armorItemInSlot(n);
    }

    @Override
    public void setInPortal() {
    }

    @Override
    public World getEntityWorld() {
        return this.worldObj;
    }

    @Override
    public boolean isInvisibleToPlayer(EntityPlayer entityPlayer) {
        return this.display.visible == 1 && (entityPlayer.getHeldItem() == null || entityPlayer.getHeldItem()._a() != CustomItems.wand);
    }

    @Override
    public boolean isInvisible() {
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
        if (!CustomNpcsPermissions.Instance.hasPermission(entityPlayer.username, "customnpcs.npc.edit")) {
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

