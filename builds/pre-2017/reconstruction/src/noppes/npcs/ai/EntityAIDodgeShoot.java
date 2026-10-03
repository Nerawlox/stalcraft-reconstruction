/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.ofaz;
import net.minecraft.util.Vec3;
import noppes.npcs.EntityNPCInterface;

public class EntityAIDodgeShoot
extends EntityAIBase {
    private EntityNPCInterface entity;
    private double xPosition;
    private double yPosition;
    private double zPosition;

    public EntityAIDodgeShoot(EntityNPCInterface entityNPCInterface) {
        this.entity = entityNPCInterface;
        this.setMutexBits(1);
    }

    @Override
    public boolean shouldExecute() {
        EntityLivingBase entityLivingBase = this.entity.getAttackTarget();
        if (entityLivingBase != null && entityLivingBase.isEntityAlive()) {
            Vec3 vec3;
            if (this.entity.inventory.getFirearm() == null) {
                return false;
            }
            if (this.entity.getRangedTask() == null) {
                return false;
            }
            Vec3 vec32 = vec3 = this.entity.getRangedTask().hasFired() ? ofaz._a(this.entity, 4, 1) : null;
            if (vec3 == null) {
                return false;
            }
            this.xPosition = vec3._c;
            this.yPosition = vec3._d;
            this.zPosition = vec3._e;
            return true;
        }
        return false;
    }

    @Override
    public boolean continueExecuting() {
        return !this.entity.getNavigator()._g();
    }

    @Override
    public void startExecuting() {
        this.entity.getNavigator()._a(this.xPosition, this.yPosition, this.zPosition, 1.2);
    }

    @Override
    public void updateTask() {
        if (this.entity.getAttackTarget() != null) {
            this.entity.getLookHelper()._a(this.entity.getAttackTarget(), 30.0f, 30.0f);
        }
    }
}

