/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.sajh;
import net.minecraft.village.Village;
import net.minecraft.world.World;

public class ofbx
extends EntityAIBase {
    public EntityVillager _a;
    public EntityVillager _b;
    public World _c;
    public int _d;
    public Village _e;

    public ofbx(EntityVillager entityVillager) {
        this._a = entityVillager;
        this._c = entityVillager.worldObj;
        this.setMutexBits(3);
    }

    @Override
    public boolean shouldExecute() {
        if (this._a.getGrowingAge() != 0) {
            return false;
        }
        if (this._a.getRNG().nextInt(500) != 0) {
            return false;
        }
        this._e = this._c.villageCollectionObj._a(sajh._c(this._a.posX), sajh._c(this._a.posY), sajh._c(this._a.posZ), 0);
        if (this._e == null) {
            return false;
        }
        if (!this._a()) {
            return false;
        }
        Entity entity = this._c.findNearestEntityWithinAABB(EntityVillager.class, this._a.boundingBox._b(8.0, 3.0, 8.0), this._a);
        if (entity == null) {
            return false;
        }
        this._b = (EntityVillager)entity;
        return this._b.getGrowingAge() == 0;
    }

    @Override
    public void startExecuting() {
        this._d = 300;
        this._a.setMating(true);
    }

    @Override
    public void resetTask() {
        this._e = null;
        this._b = null;
        this._a.setMating(false);
    }

    @Override
    public boolean continueExecuting() {
        return this._d >= 0 && this._a() && this._a.getGrowingAge() == 0;
    }

    @Override
    public void updateTask() {
        --this._d;
        this._a.getLookHelper()._a(this._b, 10.0f, 30.0f);
        if (this._a.getDistanceSqToEntity(this._b) > 2.25) {
            this._a.getNavigator()._a(this._b, 0.25);
        } else if (this._d == 0 && this._b.isMating()) {
            this._b();
        }
        if (this._a.getRNG().nextInt(35) == 0) {
            this._c.setEntityState(this._a, (byte)12);
        }
    }

    public boolean _a() {
        if (!this._e._n()) {
            return false;
        }
        int n = (int)((double)this._e._e() * 0.35);
        return this._e._g() < n;
    }

    public void _b() {
        EntityVillager entityVillager = this._a.func_90012_b(this._b);
        this._b.setGrowingAge(6000);
        this._a.setGrowingAge(6000);
        entityVillager.setGrowingAge(-24000);
        entityVillager.setLocationAndAngles(this._a.posX, this._a.posY, this._a.posZ, 0.0f, 0.0f);
        this._c.spawnEntityInWorld(entityVillager);
        this._c.setEntityState(entityVillager, (byte)12);
    }
}

