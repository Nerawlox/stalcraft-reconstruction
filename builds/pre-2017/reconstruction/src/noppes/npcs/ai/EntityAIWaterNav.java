/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import net.minecraft.entity.ai.EntityAIBase;
import noppes.npcs.EntityNPCInterface;

public class EntityAIWaterNav
extends EntityAIBase {
    private EntityNPCInterface theEntity;

    public EntityAIWaterNav(EntityNPCInterface entityNPCInterface) {
        this.theEntity = entityNPCInterface;
        this.setMutexBits(4);
        entityNPCInterface.getNavigator()._e(true);
    }

    @Override
    public boolean shouldExecute() {
        if (this.theEntity.isInWater() || this.theEntity.handleLavaMovement()) {
            if (this.theEntity.aiData.canSwim) {
                return true;
            }
            if (this.theEntity.isCollidedHorizontally) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void updateTask() {
        if (this.theEntity.getRNG().nextFloat() < 0.8f) {
            this.theEntity.getJumpHelper()._a();
        }
    }
}

