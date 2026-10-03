/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import java.util.Random;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.sajh;
import noppes.npcs.EntityNPCInterface;

public class EntityAIOrbitTarget
extends EntityAIBase {
    private EntityNPCInterface theEntity;
    private EntityLivingBase targetEntity;
    private double movePosX;
    private double movePosY;
    private double movePosZ;
    private double speed;
    private float distance;
    private int delay = 0;
    private float angle = 0.0f;
    private int direction = 1;
    private float targetDistance;
    private boolean decay;
    private boolean canNavigate = true;
    private float decayRate = 1.0f;
    private int tick = 0;

    public EntityAIOrbitTarget(EntityNPCInterface entityNPCInterface, double d, float f, boolean bl) {
        this.theEntity = entityNPCInterface;
        this.speed = d;
        this.distance = f;
        this.decay = bl;
        this.setMutexBits(3);
    }

    @Override
    public boolean shouldExecute() {
        if (--this.delay > 0) {
            return false;
        }
        this.targetEntity = this.theEntity.getAttackTarget();
        if (this.targetEntity == null) {
            return false;
        }
        double d = this.theEntity.getDistanceToEntity(this.targetEntity);
        return d >= (double)(this.distance / 2.0f) && (this.theEntity.inventory.getFirearm() != null || d <= (double)this.distance);
    }

    @Override
    public boolean continueExecuting() {
        double d = this.targetEntity.getDistanceToEntity(this.theEntity);
        return this.targetEntity.isEntityAlive() && d >= (double)(this.distance / 2.0f) && d <= (double)(this.distance * 1.5f) && !this.theEntity.isInWater() && this.canNavigate;
    }

    @Override
    public void resetTask() {
        this.theEntity.getNavigator()._h();
        this.delay = 60;
        if (this.theEntity.inventory.getFirearm() != null) {
            this.theEntity.getRangedTask().navOverride(false);
        }
    }

    @Override
    public void startExecuting() {
        this.canNavigate = true;
        Random random = this.theEntity.getRNG();
        this.direction = random.nextInt(10) > 5 ? 1 : -1;
        this.decayRate = random.nextFloat() + this.distance / 16.0f;
        this.targetDistance = this.theEntity.getDistanceToEntity(this.targetEntity);
        double d = this.theEntity.posX - this.targetEntity.posX;
        double d2 = this.theEntity.posZ - this.targetEntity.posZ;
        this.angle = (float)(Math.atan2(d2, d) * 180.0 / Math.PI);
        if (this.theEntity.inventory.getFirearm() != null) {
            this.theEntity.getRangedTask().navOverride(true);
        }
    }

    @Override
    public void updateTask() {
        this.theEntity.getLookHelper()._a(this.targetEntity, 30.0f, 30.0f);
        if (this.theEntity.getNavigator()._g() && this.tick >= 0 && this.theEntity.onGround && !this.theEntity.isInWater()) {
            double d = (double)this.targetDistance * (double)sajh._b(this.angle / 180.0f * (float)Math.PI);
            double d2 = (double)this.targetDistance * (double)sajh._a(this.angle / 180.0f * (float)Math.PI);
            this.movePosX = this.targetEntity.posX + d;
            this.movePosY = this.targetEntity.boundingBox._f;
            this.movePosZ = this.targetEntity.posZ + d2;
            this.theEntity.getNavigator()._a(this.movePosX, this.movePosY, this.movePosZ, this.speed);
            this.angle += 15.0f * (float)this.direction;
            this.tick = sajh._e(this.theEntity.getDistance(this.movePosX, this.movePosY, this.movePosZ) / (double)(this.theEntity.getSpeed() / 20.0f));
            if (this.decay) {
                this.targetDistance -= this.decayRate;
            }
        }
        if (this.tick >= 0) {
            --this.tick;
        }
    }
}

