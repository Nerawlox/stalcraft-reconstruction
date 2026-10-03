/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.village.Village;

public class jxtc
extends EntityAITarget {
    public EntityIronGolem _a;
    public EntityLivingBase _b;

    public jxtc(EntityIronGolem entityIronGolem) {
        super(entityIronGolem, false, true);
        this._a = entityIronGolem;
        this.setMutexBits(1);
    }

    @Override
    public boolean shouldExecute() {
        Village village = this._a.getVillage();
        if (village == null) {
            return false;
        }
        this._b = village._b(this._a);
        if (!this.isSuitableTarget(this._b, false)) {
            if (this.taskOwner.getRNG().nextInt(20) == 0) {
                this._b = village._c(this._a);
                return this.isSuitableTarget(this._b, false);
            }
            return false;
        }
        return true;
    }

    @Override
    public void startExecuting() {
        this._a.setAttackTarget(this._b);
        super.startExecuting();
    }
}

