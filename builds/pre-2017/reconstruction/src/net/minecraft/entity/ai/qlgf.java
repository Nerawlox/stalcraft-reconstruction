/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.monster.EntityCreeper;

public class qlgf
extends EntityAIBase {
    public EntityCreeper _a;
    public EntityLivingBase _b;

    public qlgf(EntityCreeper entityCreeper) {
        this._a = entityCreeper;
        this.setMutexBits(1);
    }

    @Override
    public boolean shouldExecute() {
        EntityLivingBase entityLivingBase = this._a.getAttackTarget();
        return this._a.getCreeperState() > 0 || entityLivingBase != null && this._a.getDistanceSqToEntity(entityLivingBase) < 9.0;
    }

    @Override
    public void startExecuting() {
        this._a.getNavigator()._h();
        this._b = this._a.getAttackTarget();
    }

    @Override
    public void resetTask() {
        this._b = null;
    }

    @Override
    public void updateTask() {
        if (this._b == null) {
            this._a.setCreeperState(-1);
            return;
        }
        if (this._a.getDistanceSqToEntity(this._b) > 49.0) {
            this._a.setCreeperState(-1);
            return;
        }
        if (!this._a.getEntitySenses()._a(this._b)) {
            this._a.setCreeperState(-1);
            return;
        }
        this._a.setCreeperState(1);
    }
}

