/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import noppes.npcs.EntityNPCInterface;

public class EntityAIStalkTarget
extends EntityAIBase {
    private EntityNPCInterface theEntity;
    private EntityLivingBase targetEntity;
    private Vec3 movePosition;
    private double distance;
    private boolean overRide;
    private World theWorld;
    private int delay;
    private int tick = 0;

    public EntityAIStalkTarget(EntityNPCInterface entityNPCInterface, double d) {
        this.theEntity = entityNPCInterface;
        this.theWorld = entityNPCInterface.worldObj;
        this.distance = d * d;
        this.overRide = false;
        this.delay = 0;
        this.setMutexBits(3);
    }

    @Override
    public boolean shouldExecute() {
        this.targetEntity = this.theEntity.getAttackTarget();
        if (this.targetEntity == null) {
            return false;
        }
        if (this.tick > 0) {
            --this.tick;
            return false;
        }
        return this.targetEntity.getDistanceSqToEntity(this.theEntity) > this.distance;
    }

    @Override
    public void resetTask() {
        this.theEntity.getNavigator()._h();
        if (this.theEntity.getAttackTarget() == null && this.targetEntity != null) {
            this.theEntity.setAttackTarget(this.targetEntity);
        }
        if (this.theEntity.inventory.getFirearm() != null) {
            this.theEntity.getRangedTask().navOverride(false);
        }
    }

    @Override
    public void startExecuting() {
        if (this.theEntity.inventory.getFirearm() != null) {
            this.theEntity.getRangedTask().navOverride(true);
        }
    }

    @Override
    public void updateTask() {
        this.theEntity.getLookHelper()._a(this.targetEntity, 30.0f, 30.0f);
        if (this.theEntity.getNavigator()._g() || this.overRide) {
            if (this.isLookingAway()) {
                this.movePosition = this.stalkTarget();
                if (this.movePosition != null) {
                    this.theEntity.getNavigator()._a(this.movePosition._c, this.movePosition._d, this.movePosition._e, 1.0);
                    this.overRide = false;
                } else {
                    this.tick = 100;
                }
            } else if (this.targetEntity.canEntityBeSeen(this.theEntity)) {
                this.movePosition = this.hideFromTarget();
                if (this.movePosition != null) {
                    this.theEntity.getNavigator()._a(this.movePosition._c, this.movePosition._d, this.movePosition._e, 1.33);
                    this.overRide = false;
                } else {
                    this.tick = 100;
                }
            }
        }
        if (this.delay > 0) {
            --this.delay;
        }
        if (!this.isLookingAway() && this.targetEntity.canEntityBeSeen(this.theEntity) && this.delay == 0) {
            this.overRide = true;
            this.delay = 60;
        }
    }

    private Vec3 hideFromTarget() {
        for (int i = 1; i <= 8; ++i) {
            Vec3 vec3 = this.findSecludedXYZ(i, false);
            if (vec3 == null) continue;
            return vec3;
        }
        return null;
    }

    private Vec3 stalkTarget() {
        for (int i = 8; i >= 1; --i) {
            Vec3 vec3 = this.findSecludedXYZ(i, true);
            if (vec3 == null) continue;
            return vec3;
        }
        return null;
    }

    private Vec3 findSecludedXYZ(int n, boolean bl) {
        Vec3 vec3 = null;
        double d = this.targetEntity.getDistanceSqToEntity(this.theEntity);
        double d2 = 0.0;
        double d3 = 0.0;
        double d4 = 0.0;
        if (this.movePosition != null) {
            d2 = this.movePosition._c;
            d3 = this.movePosition._d;
            d4 = this.movePosition._e;
        }
        for (int i = -2; i <= 2; ++i) {
            for (int j = -n; j <= n; ++j) {
                for (int k = -n; k <= n; ++k) {
                    boolean bl2;
                    Vec3 vec32;
                    Vec3 vec33;
                    MovingObjectPosition movingObjectPosition;
                    double d5;
                    double d6;
                    double d7 = (double)sajh._c(this.theEntity.posX + (double)j) + 0.5;
                    if (this.theWorld.isAirBlock((int)d7, (int)(d6 = (double)sajh._c(this.theEntity.boundingBox._c + (double)i) + 0.5), (int)(d5 = (double)sajh._c(this.theEntity.posZ + (double)k) + 0.5)) || !this.theWorld.isAirBlock((int)d7, (int)d6 + 1, (int)d5) || !this.theWorld.isAirBlock((int)d7, (int)d6 + 2, (int)d5) || (movingObjectPosition = this.theWorld.func_72933_a(vec33 = this.theWorld.getWorldVec3Pool()._a(this.targetEntity.posX, this.targetEntity.posY + (double)this.targetEntity.getEyeHeight(), this.targetEntity.posZ), vec32 = this.theWorld.getWorldVec3Pool()._a(d7, d6 + (double)this.theEntity.getEyeHeight(), d5))) == null) continue;
                    boolean bl3 = bl ? this.targetEntity.getDistanceSq(d7, d6, d5) <= d : (bl2 = true);
                    if (!bl2 || d7 == d2 && d6 == d3 && d5 == d4) continue;
                    vec3 = this.theWorld.getWorldVec3Pool()._a(d7, d6, d5);
                    if (!bl) continue;
                    d = this.targetEntity.getDistanceSq(d7, d6, d5);
                }
            }
        }
        return vec3;
    }

    private boolean isLookingAway() {
        Vec3 vec3 = this.targetEntity.getLook(1.0f)._a();
        Vec3 vec32 = this.theWorld.getWorldVec3Pool()._a(this.theEntity.posX - this.targetEntity.posX, this.theEntity.boundingBox._c + (double)(this.theEntity.height / 2.0f) - (this.targetEntity.posY + (double)this.targetEntity.getEyeHeight()), this.theEntity.posZ - this.targetEntity.posZ);
        double d = vec32._b();
        double d2 = vec3._b(vec32 = vec32._a());
        return d2 < 0.6;
    }
}

