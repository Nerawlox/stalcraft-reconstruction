/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.roles;

import java.util.UUID;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.constants.EnumRoleType;
import noppes.npcs.controllers.NpcSquad;
import noppes.npcs.controllers.SquadsRegistry;
import noppes.npcs.roles.RoleInterface;

public class RoleSquad
extends RoleInterface
implements IEntitySelector {
    private static final double FOLLOW_DISTANCE = 3.0;
    private static final double FOLLOW_DISTANCE_SQ = 9.0;
    private static final double ATTACK_DISTANCE = 100.0;
    private static final double ATTACK_DISTANCE_SQ = 10000.0;
    public UUID squadId = null;
    private int updateDelay = 0;
    private EntityLivingBase enemy;

    public RoleSquad(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        if (this.squadId != null) {
            wnbr._a(nBTTagCompound, "SquadId", this.squadId);
        }
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        this.squadId = nBTTagCompound._c("SquadIdM") ? wnbr._a(nBTTagCompound, "SquadId") : null;
    }

    @Override
    public boolean aiShouldExecute() {
        if (!this.npc.worldObj.isRemote) {
            Entity entity;
            NpcSquad npcSquad = this.getSquad();
            if (npcSquad == null) {
                return false;
            }
            if (npcSquad.squadState == NpcSquad.DEFENSE_STATE) {
                entity = this.npc.worldObj.getEntityByID(npcSquad.enemeyEntityId);
                System.out.print(this.npc.display.name + ": ");
                if (!(entity instanceof EntityLivingBase) || !entity.isEntityAlive() || this.npc.getDistanceSqToEntity(entity) >= 10000.0) {
                    npcSquad.squadState = NpcSquad.IDLE_STATE;
                    npcSquad.enemeyEntityId = -1;
                    this.enemy = null;
                    System.out.println("Setting target to null");
                } else {
                    this.enemy = (EntityLivingBase)entity;
                    System.out.println("Setting target ot " + entity);
                    return true;
                }
            }
            if (npcSquad.squadState == NpcSquad.IDLE_STATE) {
                entity = this.getFollowing();
                return entity != null && this.npc.worldObj.loadedEntityList.contains(entity) && this.npc.getDistanceSqToEntity(entity) > 9.0;
            }
        }
        return false;
    }

    @Override
    public void aiStartExecuting() {
        this.updateDelay = 10;
    }

    @Override
    public void aiUpdateTask() {
        if (++this.updateDelay >= 10) {
            EntityNPCInterface entityNPCInterface;
            NpcSquad npcSquad = this.getSquad();
            if (npcSquad == null) {
                return;
            }
            if (npcSquad.squadState == NpcSquad.IDLE_STATE && (entityNPCInterface = this.getFollowing()) != null && entityNPCInterface.isEntityAlive()) {
                double d = this.npc.getDistanceSqToEntity(entityNPCInterface);
                if (d > 9.0) {
                    this.npc.getLookHelper()._a(entityNPCInterface, 10.0f, (float)this.npc.getVerticalFaceSpeed());
                    this.npc.getNavigator()._a(entityNPCInterface, 1.0);
                } else {
                    this.npc.getNavigator()._h();
                }
            }
            if (!(npcSquad.squadState != NpcSquad.DEFENSE_STATE || this.enemy != null && this.enemy.isEntityAlive())) {
                npcSquad.squadState = NpcSquad.IDLE_STATE;
            }
            this.updateDelay = 0;
        }
    }

    @Override
    public boolean aiContinueExecute() {
        NpcSquad npcSquad = this.getSquad();
        if (npcSquad == null) {
            return false;
        }
        if (npcSquad.squadState == NpcSquad.IDLE_STATE) {
            EntityNPCInterface entityNPCInterface = this.getFollowing();
            return entityNPCInterface != null && !this.npc.getNavigator()._g() && ((Entity)entityNPCInterface).isEntityAlive();
        }
        return true;
    }

    @Override
    public boolean interact(EntityPlayer entityPlayer) {
        return false;
    }

    private EntityNPCInterface getFollowing() {
        NpcSquad.SquadMember squadMember;
        NpcSquad npcSquad = this.getSquad();
        if (npcSquad != null && (squadMember = npcSquad.getToFollow(npcSquad.getMembers().get(this.npc.getUniqueID()))) != null) {
            return squadMember.getNpc(this.npc.worldObj);
        }
        return null;
    }

    @Override
    public boolean syncBetweenClones() {
        return false;
    }

    public NpcSquad getSquad() {
        if (this.squadId != null) {
            return SquadsRegistry.get(this.npc.worldObj).getSquad(this.squadId);
        }
        return null;
    }

    public static void setSquadMember(EntityNPCInterface entityNPCInterface) {
        entityNPCInterface.advanced.role = EnumRoleType.Squad;
        entityNPCInterface.roleInterface = new RoleSquad(entityNPCInterface);
    }

    @Override
    public boolean isEntityApplicable(Entity entity) {
        NpcSquad npcSquad = this.getSquad();
        return entity != null && npcSquad != null && entity.isEntityAlive() && npcSquad.squadState == NpcSquad.DEFENSE_STATE && entity.entityId == this.getSquad().enemeyEntityId;
    }
}

