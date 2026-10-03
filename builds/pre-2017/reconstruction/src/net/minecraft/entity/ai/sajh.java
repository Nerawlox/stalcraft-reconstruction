/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.world.World;

public class sajh
extends EntityAIBase {
    public World _a;
    public EntityLiving _b;
    public EntityLivingBase _c;
    public int _d;

    public sajh(EntityLiving entityLiving) {
        this._b = entityLiving;
        this._a = entityLiving.worldObj;
        this.setMutexBits(3);
    }

    @Override
    public boolean shouldExecute() {
        EntityLivingBase entityLivingBase = this._b.getAttackTarget();
        if (entityLivingBase == null) {
            return false;
        }
        this._c = entityLivingBase;
        return true;
    }

    @Override
    public boolean continueExecuting() {
        if (!this._c.isEntityAlive()) {
            return false;
        }
        if (this._b.getDistanceSqToEntity(this._c) > 225.0) {
            return false;
        }
        return !this._b.getNavigator()._g() || this.shouldExecute();
    }

    @Override
    public void resetTask() {
        this._c = null;
        this._b.getNavigator()._h();
    }

    @Override
    public void updateTask() {
        this._b.getLookHelper()._a(this._c, 30.0f, 30.0f);
        double d = this._b.width * 2.0f * (this._b.width * 2.0f);
        double d2 = this._b.getDistanceSq(this._c.posX, this._c.boundingBox._c, this._c.posZ);
        double d3 = 0.8;
        if (d2 > d && d2 < 16.0) {
            d3 = 1.33;
        } else if (d2 < 225.0) {
            d3 = 0.6;
        }
        this._b.getNavigator()._a(this._c, d3);
        this._d = Math.max(this._d - 1, 0);
        if (d2 > d) {
            return;
        }
        if (this._d > 0) {
            return;
        }
        this._d = 20;
        this._b.attackEntityAsMob(this._c);
    }
}

