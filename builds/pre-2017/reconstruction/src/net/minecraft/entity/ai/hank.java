/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.sajh;
import net.minecraft.village.Village;

public class hank
extends EntityAIBase {
    public EntityCreature _a;
    public ellv _b;

    public hank(EntityCreature entityCreature) {
        this._a = entityCreature;
    }

    @Override
    public boolean shouldExecute() {
        if (this._a.worldObj.isDaytime()) {
            return false;
        }
        Village village = this._a.worldObj.villageCollectionObj._a(sajh._c(this._a.posX), sajh._c(this._a.posY), sajh._c(this._a.posZ), 16);
        if (village == null) {
            return false;
        }
        this._b = village._b(sajh._c(this._a.posX), sajh._c(this._a.posY), sajh._c(this._a.posZ));
        if (this._b == null) {
            return false;
        }
        return (double)this._b._b(sajh._c(this._a.posX), sajh._c(this._a.posY), sajh._c(this._a.posZ)) < 2.25;
    }

    @Override
    public boolean continueExecuting() {
        if (this._a.worldObj.isDaytime()) {
            return false;
        }
        return !this._b._g && this._b._a(sajh._c(this._a.posX), sajh._c(this._a.posZ));
    }

    @Override
    public void startExecuting() {
        this._a.getNavigator()._b(false);
        this._a.getNavigator()._c(false);
    }

    @Override
    public void resetTask() {
        this._a.getNavigator()._b(true);
        this._a.getNavigator()._c(true);
        this._b = null;
    }

    @Override
    public void updateTask() {
        this._b._e();
    }
}

