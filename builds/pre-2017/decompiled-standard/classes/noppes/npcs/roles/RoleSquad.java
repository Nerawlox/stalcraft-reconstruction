/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.roles;

import java.util.UUID;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.constants.EnumRoleType;
import noppes.npcs.controllers.NpcSquad;
import noppes.npcs.controllers.SquadsRegistry;
import noppes.npcs.roles.RoleInterface;

public class RoleSquad
extends RoleInterface
implements zhos {
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
    public void writeEntityToNBT(qoac qoac2) {
        if (this.squadId != null) {
            wnbr._a(qoac2, "SquadId", this.squadId);
        }
    }

    @Override
    public void readEntityFromNBT(qoac qoac2) {
        this.squadId = qoac2._c("SquadIdM") ? wnbr._a(qoac2, "SquadId") : null;
    }

    @Override
    public boolean aiShouldExecute() {
        if (!this.npc.field_70170_p.field_72995_K) {
            Entity entity;
            NpcSquad npcSquad = this.getSquad();
            if (npcSquad == null) {
                return false;
            }
            if (npcSquad.squadState == NpcSquad.DEFENSE_STATE) {
                entity = this.npc.field_70170_p.func_73045_a(npcSquad.enemeyEntityId);
                System.out.print(this.npc.display.name + ": ");
                if (!(entity instanceof EntityLivingBase) || !entity.func_70089_S() || this.npc.func_70068_e(entity) >= 10000.0) {
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
                return entity != null && this.npc.field_70170_p.field_72996_f.contains(entity) && this.npc.func_70068_e(entity) > 9.0;
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
            if (npcSquad.squadState == NpcSquad.IDLE_STATE && (entityNPCInterface = this.getFollowing()) != null && entityNPCInterface.func_70089_S()) {
                double d = this.npc.func_70068_e(entityNPCInterface);
                if (d > 9.0) {
                    this.npc.func_70671_ap()._a(entityNPCInterface, 10.0f, (float)this.npc.func_70646_bf());
                    this.npc.func_70661_as()._a(entityNPCInterface, 1.0);
                } else {
                    this.npc.func_70661_as()._h();
                }
            }
            if (!(npcSquad.squadState != NpcSquad.DEFENSE_STATE || this.enemy != null && this.enemy.func_70089_S())) {
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
            return entityNPCInterface != null && !this.npc.func_70661_as()._g() && ((Entity)entityNPCInterface).func_70089_S();
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
        if (npcSquad != null && (squadMember = npcSquad.getToFollow(npcSquad.getMembers().get(this.npc.func_110124_au()))) != null) {
            return squadMember.getNpc(this.npc.field_70170_p);
        }
        return null;
    }

    @Override
    public boolean syncBetweenClones() {
        return false;
    }

    public NpcSquad getSquad() {
        if (this.squadId != null) {
            return SquadsRegistry.get(this.npc.field_70170_p).getSquad(this.squadId);
        }
        return null;
    }

    public static void setSquadMember(EntityNPCInterface entityNPCInterface) {
        entityNPCInterface.advanced.role = EnumRoleType.Squad;
        entityNPCInterface.roleInterface = new RoleSquad(entityNPCInterface);
    }

    @Override
    public boolean func_82704_a(Entity entity) {
        NpcSquad npcSquad = this.getSquad();
        return entity != null && npcSquad != null && entity.func_70089_S() && npcSquad.squadState == NpcSquad.DEFENSE_STATE && entity.field_70157_k == this.getSquad().enemeyEntityId;
    }
}

