/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityTameable;

public class EntityAISit
extends EntityAIBase {
    public EntityTameable _a;
    public boolean _b;

    public EntityAISit(EntityTameable entityTameable) {
        this._a = entityTameable;
        this.setMutexBits(5);
    }

    @Override
    public boolean shouldExecute() {
        if (!this._a.isTamed()) {
            return false;
        }
        if (this._a.isInWater()) {
            return false;
        }
        if (!this._a.onGround) {
            return false;
        }
        EntityLivingBase entityLivingBase = this._a.func_130012_q();
        if (entityLivingBase == null) {
            return true;
        }
        if (this._a.getDistanceSqToEntity(entityLivingBase) < 144.0 && entityLivingBase.getAITarget() != null) {
            return false;
        }
        return this._b;
    }

    @Override
    public void startExecuting() {
        this._a.getNavigator()._h();
        this._a.setSitting(true);
    }

    @Override
    public void resetTask() {
        this._a.setSitting(false);
    }

    public void _a(boolean bl) {
        this._b = bl;
    }
}

