/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;

public class iurq
extends EntityAIBase {
    public EntityLiving _b;
    public Entity _c;
    public float _d;
    public int _e;
    public float _f;
    public Class _g;

    public iurq(EntityLiving entityLiving, Class clazz, float f) {
        this._b = entityLiving;
        this._g = clazz;
        this._d = f;
        this._f = 0.02f;
        this.setMutexBits(2);
    }

    public iurq(EntityLiving entityLiving, Class clazz, float f, float f2) {
        this._b = entityLiving;
        this._g = clazz;
        this._d = f;
        this._f = f2;
        this.setMutexBits(2);
    }

    @Override
    public boolean shouldExecute() {
        if (this._b.getRNG().nextFloat() >= this._f) {
            return false;
        }
        if (this._b.getAttackTarget() != null) {
            this._c = this._b.getAttackTarget();
        }
        this._c = this._g == EntityPlayer.class ? this._b.worldObj.getClosestPlayerToEntity(this._b, this._d) : this._b.worldObj.findNearestEntityWithinAABB(this._g, this._b.boundingBox._b(this._d, 3.0, this._d), this._b);
        return this._c != null;
    }

    @Override
    public boolean continueExecuting() {
        if (!this._c.isEntityAlive()) {
            return false;
        }
        if (this._b.getDistanceSqToEntity(this._c) > (double)(this._d * this._d)) {
            return false;
        }
        return this._e > 0;
    }

    @Override
    public void startExecuting() {
        this._e = 40 + this._b.getRNG().nextInt(40);
    }

    @Override
    public void resetTask() {
        this._c = null;
    }

    @Override
    public void updateTask() {
        this._b.getLookHelper()._a(this._c.posX, this._c.posY + (double)this._c.getEyeHeight(), this._c.posZ, 10.0f, this._b.getVerticalFaceSpeed());
        --this._e;
    }
}

