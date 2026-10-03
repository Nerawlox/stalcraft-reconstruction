/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;

public class tdpx
extends EntityAIBase {
    public EntityLiving _a;

    public tdpx(EntityLiving entityLiving) {
        this._a = entityLiving;
        this.setMutexBits(4);
        entityLiving.getNavigator()._e(true);
    }

    @Override
    public boolean shouldExecute() {
        return this._a.isInWater() || this._a.handleLavaMovement();
    }

    @Override
    public void updateTask() {
        if (this._a.getRNG().nextFloat() < 0.8f) {
            this._a.getJumpHelper()._a();
        }
    }
}

