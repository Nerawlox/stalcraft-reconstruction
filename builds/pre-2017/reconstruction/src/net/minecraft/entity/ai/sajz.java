/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.ofaz;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.village.Village;

public class sajz
extends EntityAIBase {
    public EntityCreature _a;
    public ellv _b;
    public int _c = -1;
    public int _d = -1;

    public sajz(EntityCreature entityCreature) {
        this._a = entityCreature;
        this.setMutexBits(1);
    }

    @Override
    public boolean shouldExecute() {
        if (this._a.worldObj.isDaytime() && !this._a.worldObj.isRaining() || this._a.worldObj.provider._g) {
            return false;
        }
        if (this._a.getRNG().nextInt(50) != 0) {
            return false;
        }
        if (this._c != -1 && this._a.getDistanceSq(this._c, this._a.posY, this._d) < 4.0) {
            return false;
        }
        Village village = this._a.worldObj.villageCollectionObj._a(sajh._c(this._a.posX), sajh._c(this._a.posY), sajh._c(this._a.posZ), 14);
        if (village == null) {
            return false;
        }
        this._b = village._c(sajh._c(this._a.posX), sajh._c(this._a.posY), sajh._c(this._a.posZ));
        return this._b != null;
    }

    @Override
    public boolean continueExecuting() {
        return !this._a.getNavigator()._g();
    }

    @Override
    public void startExecuting() {
        this._c = -1;
        if (this._a.getDistanceSq(this._b._a(), this._b._b, this._b._c()) > 256.0) {
            Vec3 vec3 = ofaz._a(this._a, 14, 3, this._a.worldObj.getWorldVec3Pool()._a((double)this._b._a() + 0.5, this._b._b(), (double)this._b._c() + 0.5));
            if (vec3 != null) {
                this._a.getNavigator()._a(vec3._c, vec3._d, vec3._e, 1.0);
            }
        } else {
            this._a.getNavigator()._a((double)this._b._a() + 0.5, this._b._b(), (double)this._b._c() + 0.5, 1.0);
        }
    }

    @Override
    public void resetTask() {
        this._c = this._b._a();
        this._d = this._b._c();
        this._b = null;
    }
}

