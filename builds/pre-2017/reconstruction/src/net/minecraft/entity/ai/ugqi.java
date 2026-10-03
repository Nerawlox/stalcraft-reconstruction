/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class ugqi
extends EntityAIBase {
    public EntityTameable _a;
    public EntityLivingBase _b;
    public World _c;
    public double _d;
    public PathNavigate _e;
    public int _f;
    public float _g;
    public float _h;
    public boolean _i;

    public ugqi(EntityTameable entityTameable, double d, float f, float f2) {
        this._a = entityTameable;
        this._c = entityTameable.worldObj;
        this._d = d;
        this._e = entityTameable.getNavigator();
        this._h = f;
        this._g = f2;
        this.setMutexBits(3);
    }

    @Override
    public boolean shouldExecute() {
        EntityLivingBase entityLivingBase = this._a.func_130012_q();
        if (entityLivingBase == null) {
            return false;
        }
        if (this._a.isSitting()) {
            return false;
        }
        if (this._a.getDistanceSqToEntity(entityLivingBase) < (double)(this._h * this._h)) {
            return false;
        }
        this._b = entityLivingBase;
        return true;
    }

    @Override
    public boolean continueExecuting() {
        return !this._e._g() && this._a.getDistanceSqToEntity(this._b) > (double)(this._g * this._g) && !this._a.isSitting();
    }

    @Override
    public void startExecuting() {
        this._f = 0;
        this._i = this._a.getNavigator()._a();
        this._a.getNavigator()._a(false);
    }

    @Override
    public void resetTask() {
        this._b = null;
        this._e._h();
        this._a.getNavigator()._a(this._i);
    }

    @Override
    public void updateTask() {
        this._a.getLookHelper()._a(this._b, 10.0f, (float)this._a.getVerticalFaceSpeed());
        if (this._a.isSitting()) {
            return;
        }
        if (--this._f > 0) {
            return;
        }
        this._f = 10;
        if (this._e._a(this._b, this._d)) {
            return;
        }
        if (this._a.getLeashed()) {
            return;
        }
        if (this._a.getDistanceSqToEntity(this._b) < 144.0) {
            return;
        }
        int n = sajh._c(this._b.posX) - 2;
        int n2 = sajh._c(this._b.posZ) - 2;
        int n3 = sajh._c(this._b.boundingBox._c);
        for (int i = 0; i <= 4; ++i) {
            for (int j = 0; j <= 4; ++j) {
                if (i >= 1 && j >= 1 && i <= 3 && j <= 3 || !this._c.doesBlockHaveSolidTopSurface(n + i, n3 - 1, n2 + j) || this._c.isBlockNormalCube(n + i, n3, n2 + j) || this._c.isBlockNormalCube(n + i, n3 + 1, n2 + j)) continue;
                this._a.setLocationAndAngles((float)(n + i) + 0.5f, n3, (float)(n2 + j) + 0.5f, this._a.rotationYaw, this._a.rotationPitch);
                this._e._h();
                return;
            }
        }
    }
}

