/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import java.util.Random;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class EntityAIAmbushTarget
extends EntityAIBase {
    private EntityCreature theEntity;
    private EntityLivingBase targetEntity;
    private double shelterX;
    private double shelterY;
    private double shelterZ;
    private double movementSpeed;
    private double distance;
    private int delay = 0;
    private World theWorld;
    private int tick;
    private boolean attackFromBehind;

    public EntityAIAmbushTarget(EntityCreature entityCreature, double d, double d2, boolean bl) {
        this.theEntity = entityCreature;
        this.movementSpeed = d;
        this.theWorld = entityCreature.worldObj;
        this.distance = d2 * d2;
        this.attackFromBehind = bl;
        this.setMutexBits(3);
    }

    @Override
    public boolean shouldExecute() {
        this.targetEntity = this.theEntity.getAttackTarget();
        if (this.targetEntity == null) {
            return false;
        }
        if (this.delay > 0) {
            --this.delay;
            return false;
        }
        if (this.targetEntity.getDistanceSqToEntity(this.theEntity) > this.distance && this.targetEntity.canEntityBeSeen(this.theEntity)) {
            Vec3 vec3 = this.findHidingSpot();
            if (vec3 == null) {
                return false;
            }
            this.shelterX = vec3._c;
            this.shelterY = vec3._d;
            this.shelterZ = vec3._e;
            return true;
        }
        return false;
    }

    @Override
    public boolean continueExecuting() {
        if (this.targetEntity.isEntityAlive()) {
            boolean bl;
            if (this.attackFromBehind) {
                this.theEntity.getNavigator()._g();
            } else {
                bl = true;
            }
            bl = this.attackFromBehind ? this.isLookingAway() && !this.targetEntity.canEntityBeSeen(this.theEntity) : false;
            return this.targetEntity.getDistanceSqToEntity(this.theEntity) > this.distance && (!this.theEntity.getNavigator()._g() || !this.targetEntity.canEntityBeSeen(this.theEntity));
        }
        return false;
    }

    @Override
    public void startExecuting() {
        this.theEntity.getNavigator()._a(this.shelterX, this.shelterY, this.shelterZ, this.movementSpeed);
    }

    @Override
    public void resetTask() {
        this.theEntity.getNavigator()._h();
        if (this.theEntity.getAttackTarget() == null && this.targetEntity != null) {
            this.theEntity.setAttackTarget(this.targetEntity);
        }
    }

    private Vec3 findHidingSpot() {
        Random random = this.theEntity.getRNG();
        Vec3 vec3 = null;
        for (int i = 1; i <= 8; ++i) {
            for (int j = -2; j <= 2; ++j) {
                for (int k = -i; k <= i; ++k) {
                    for (int i2 = -i; i2 <= i; ++i2) {
                        Vec3 vec32;
                        Vec3 vec33;
                        MovingObjectPosition movingObjectPosition;
                        double d;
                        double d2;
                        double d3 = (double)sajh._c(this.theEntity.posX + (double)k) + 0.5;
                        if (this.theWorld.isAirBlock((int)d3, (int)(d2 = (double)sajh._c(this.theEntity.boundingBox._c + (double)j) + 0.5), (int)(d = (double)sajh._c(this.theEntity.posZ + (double)i2) + 0.5)) || !this.theWorld.isAirBlock((int)d3, (int)d2 + 1, (int)d) || (movingObjectPosition = this.theWorld.func_72933_a(vec33 = this.theWorld.getWorldVec3Pool()._a(this.targetEntity.posX, this.targetEntity.posY + (double)this.targetEntity.getEyeHeight(), this.targetEntity.posZ), vec32 = this.theWorld.getWorldVec3Pool()._a(d3, d2 + (double)this.theEntity.getEyeHeight(), d))) == null || this.shelterX == d3 || this.shelterY == d2 || this.shelterZ == d) continue;
                        vec3 = this.theWorld.getWorldVec3Pool()._a(d3, d2, d);
                    }
                }
            }
            if (vec3 == null) continue;
            return vec3;
        }
        this.delay = 60;
        return null;
    }

    private boolean isLookingAway() {
        Vec3 vec3 = this.targetEntity.getLook(1.0f)._a();
        Vec3 vec32 = this.theWorld.getWorldVec3Pool()._a(this.theEntity.posX - this.targetEntity.posX, this.theEntity.boundingBox._c + (double)(this.theEntity.height / 2.0f) - (this.targetEntity.posY + (double)this.targetEntity.getEyeHeight()), this.theEntity.posZ - this.targetEntity.posZ);
        double d = vec32._b();
        double d2 = vec3._b(vec32 = vec32._a());
        return d2 < 0.6;
    }
}

