/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.sajh;

public class amww
extends EntityAIBase {
    public EntityLiving _a;
    public EntityLivingBase _b;
    public float _c;

    public amww(EntityLiving entityLiving, float f) {
        this._a = entityLiving;
        this._c = f;
        this.setMutexBits(5);
    }

    @Override
    public boolean shouldExecute() {
        this._b = this._a.getAttackTarget();
        if (this._b == null) {
            return false;
        }
        double d = this._a.getDistanceSqToEntity(this._b);
        if (d < 4.0 || d > 16.0) {
            return false;
        }
        if (!this._a.onGround) {
            return false;
        }
        return this._a.getRNG().nextInt(5) == 0;
    }

    @Override
    public boolean continueExecuting() {
        return !this._a.onGround;
    }

    @Override
    public void startExecuting() {
        double d = this._b.posX - this._a.posX;
        double d2 = this._b.posZ - this._a.posZ;
        float f = sajh._a(d * d + d2 * d2);
        this._a.motionX += d / (double)f * 0.5 * (double)0.8f + this._a.motionX * (double)0.2f;
        this._a.motionZ += d2 / (double)f * 0.5 * (double)0.8f + this._a.motionZ * (double)0.2f;
        this._a.motionY = this._c;
    }
}

