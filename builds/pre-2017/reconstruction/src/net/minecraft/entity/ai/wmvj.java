/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.passive.EntityTameable;

public class wmvj
extends EntityAITarget {
    public EntityTameable _a;
    public EntityLivingBase _b;
    public int _c;

    public wmvj(EntityTameable entityTameable) {
        super(entityTameable, false);
        this._a = entityTameable;
        this.setMutexBits(1);
    }

    @Override
    public boolean shouldExecute() {
        if (!this._a.isTamed()) {
            return false;
        }
        EntityLivingBase entityLivingBase = this._a.func_130012_q();
        if (entityLivingBase == null) {
            return false;
        }
        this._b = entityLivingBase.getAITarget();
        int n = entityLivingBase.func_142015_aE();
        return n != this._c && this.isSuitableTarget(this._b, false) && this._a.func_142018_a(this._b, entityLivingBase);
    }

    @Override
    public void startExecuting() {
        this.taskOwner.setAttackTarget(this._b);
        EntityLivingBase entityLivingBase = this._a.func_130012_q();
        if (entityLivingBase != null) {
            this._c = entityLivingBase.func_142015_aE();
        }
        super.startExecuting();
    }
}

