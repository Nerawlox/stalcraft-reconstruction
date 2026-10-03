/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.ofaz;
import net.minecraft.util.Vec3;

public class pibn
extends EntityAIBase {
    public EntityCreature _a;
    public EntityLivingBase _b;
    public double _c;
    public double _d;
    public double _e;
    public double _f;
    public float _g;

    public pibn(EntityCreature entityCreature, double d, float f) {
        this._a = entityCreature;
        this._f = d;
        this._g = f;
        this.setMutexBits(1);
    }

    @Override
    public boolean shouldExecute() {
        this._b = this._a.getAttackTarget();
        if (this._b == null) {
            return false;
        }
        if (this._b.getDistanceSqToEntity(this._a) > (double)(this._g * this._g)) {
            return false;
        }
        Vec3 vec3 = ofaz._a(this._a, 16, 7, this._a.worldObj.getWorldVec3Pool()._a(this._b.posX, this._b.posY, this._b.posZ));
        if (vec3 == null) {
            return false;
        }
        this._c = vec3._c;
        this._d = vec3._d;
        this._e = vec3._e;
        return true;
    }

    @Override
    public boolean continueExecuting() {
        return !this._a.getNavigator()._g() && this._b.isEntityAlive() && this._b.getDistanceSqToEntity(this._a) < (double)(this._g * this._g);
    }

    @Override
    public void resetTask() {
        this._b = null;
    }

    @Override
    public void startExecuting() {
        this._a.getNavigator()._a(this._c, this._d, this._e, this._f);
    }
}

