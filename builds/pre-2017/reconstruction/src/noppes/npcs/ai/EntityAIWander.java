/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.Vec3;
import noppes.npcs.CustomNpcs;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.ai.RandomPositionGeneratorAlt;

public class EntityAIWander
extends EntityAIBase {
    private EntityNPCInterface entity;
    private double xPosition;
    private double yPosition;
    private double zPosition;

    public EntityAIWander(EntityNPCInterface entityNPCInterface) {
        this.entity = entityNPCInterface;
        this.setMutexBits(1);
    }

    @Override
    public boolean shouldExecute() {
        if (this.entity.getAge() >= 100) {
            return false;
        }
        if (this.entity.getRNG().nextInt(80) != 0) {
            return false;
        }
        Vec3 vec3 = this.getVec();
        if (vec3 == null) {
            return false;
        }
        this.xPosition = vec3._c;
        this.yPosition = vec3._d;
        this.zPosition = vec3._e;
        return true;
    }

    private Vec3 getVec() {
        if (this.entity.aiData.walkingRange > 0) {
            double d = this.entity.getDistance(this.entity.getStartXPos(), this.entity.getStartYPos(), this.entity.getStartZPos());
            int n = (int)((double)this.entity.aiData.walkingRange - d);
            if (n > CustomNpcs.NpcNavRange) {
                n = CustomNpcs.NpcNavRange;
            }
            if (n < 3) {
                n = this.entity.aiData.walkingRange;
                if (n > CustomNpcs.NpcNavRange) {
                    n = CustomNpcs.NpcNavRange;
                }
                Vec3 vec3 = this.entity.worldObj.getWorldVec3Pool()._a(this.entity.getStartXPos(), this.entity.getStartYPos(), this.entity.getStartZPos());
                return RandomPositionGeneratorAlt.findRandomTargetBlockTowards(this.entity, n / 2, 7, vec3);
            }
            return RandomPositionGeneratorAlt.findRandomTarget(this.entity, n, 7);
        }
        return RandomPositionGeneratorAlt.findRandomTarget(this.entity, CustomNpcs.NpcNavRange, 7);
    }

    @Override
    public boolean continueExecuting() {
        return !this.entity.getNavigator()._g();
    }

    @Override
    public void startExecuting() {
        this.entity.getNavigator()._a(this.xPosition, this.yPosition, this.zPosition, 0.7);
    }
}

