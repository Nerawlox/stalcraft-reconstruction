/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.constants.EnumJobType;
import noppes.npcs.constants.EnumMovingType;
import noppes.npcs.constants.EnumRoleType;
import noppes.npcs.controllers.FactionController;
import noppes.npcs.roles.JobGuard;
import noppes.npcs.roles.RoleSquad;

public class AttackSelectorNPC
implements zhos {
    private EntityNPCInterface npc;

    public AttackSelectorNPC(EntityNPCInterface entityNPCInterface) {
        this.npc = entityNPCInterface;
    }

    @Override
    public boolean func_82704_a(Entity entity) {
        if (entity != this.npc && entity instanceof EntityLivingBase && this.npc.func_70032_d(entity) <= (float)this.npc.stats.aggroRange && !entity.func_85032_ar()) {
            if (this.npc.aiData.directLOS && !this.npc.func_70635_at()._a(entity)) {
                return false;
            }
            if (!this.npc.isFollowerWithOwner() && this.npc.aiData.returnToStart) {
                int n = this.npc.stats.aggroRange * 2;
                if (this.npc.aiData.movingType == EnumMovingType.Wandering) {
                    n += this.npc.aiData.walkingRange;
                }
                if (entity.func_70011_f(this.npc.getStartXPos(), this.npc.getStartYPos(), this.npc.getStartZPos()) > (double)n) {
                    return false;
                }
            }
            if (this.npc.advanced.job == EnumJobType.Guard && ((JobGuard)this.npc.jobInterface).isEntityApplicable((EntityLivingBase)entity)) {
                return true;
            }
            if (this.npc.advanced.role == EnumRoleType.Squad && ((RoleSquad)this.npc.roleInterface).func_82704_a(entity)) {
                return true;
            }
            if (entity instanceof EntityPlayer) {
                return this.npc.getFaction().isAggressiveToPlayer((EntityPlayer)entity);
            }
            if (entity instanceof EntityMutant) {
                if (!entity.func_70089_S()) {
                    return false;
                }
                if (this.npc.advanced.attackOtherFactions) {
                    return this.npc.getFaction().isAggressiveToFaction(FactionController.getInstance().getMobFaction());
                }
                return false;
            }
            if (entity instanceof EntityNPCInterface) {
                if (((EntityNPCInterface)entity).isKilled()) {
                    return false;
                }
                if (this.npc.advanced.attackOtherFactions) {
                    return this.npc.getFaction().isAggressiveToNpc((EntityNPCInterface)entity);
                }
            }
            return false;
        }
        return false;
    }
}

