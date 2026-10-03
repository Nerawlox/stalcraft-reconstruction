/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.passive.EntityVillager;

public class owak
extends EntityAIBase {
    public EntityIronGolem _a;
    public EntityVillager _b;
    public int _c;

    public owak(EntityIronGolem entityIronGolem) {
        this._a = entityIronGolem;
        this.setMutexBits(3);
    }

    @Override
    public boolean shouldExecute() {
        if (!this._a.worldObj.isDaytime()) {
            return false;
        }
        if (this._a.getRNG().nextInt(8000) != 0) {
            return false;
        }
        this._b = (EntityVillager)this._a.worldObj.findNearestEntityWithinAABB(EntityVillager.class, this._a.boundingBox._b(6.0, 2.0, 6.0), this._a);
        return this._b != null;
    }

    @Override
    public boolean continueExecuting() {
        return this._c > 0;
    }

    @Override
    public void startExecuting() {
        this._c = 400;
        this._a.setHoldingRose(true);
    }

    @Override
    public void resetTask() {
        this._a.setHoldingRose(false);
        this._b = null;
    }

    @Override
    public void updateTask() {
        this._a.getLookHelper()._a(this._b, 30.0f, 30.0f);
        --this._c;
    }
}

