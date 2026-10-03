/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import java.util.Random;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class vjta
extends EntityAIBase {
    public EntityCreature _a;
    public double _b;
    public double _c;
    public double _d;
    public double _e;
    public World _f;

    public vjta(EntityCreature entityCreature, double d) {
        this._a = entityCreature;
        this._e = d;
        this._f = entityCreature.worldObj;
        this.setMutexBits(1);
    }

    @Override
    public boolean shouldExecute() {
        if (!this._f.isDaytime()) {
            return false;
        }
        if (!this._a.isBurning()) {
            return false;
        }
        if (!this._f.canBlockSeeTheSky(sajh._c(this._a.posX), (int)this._a.boundingBox._c, sajh._c(this._a.posZ))) {
            return false;
        }
        Vec3 vec3 = this._a();
        if (vec3 == null) {
            return false;
        }
        this._b = vec3._c;
        this._c = vec3._d;
        this._d = vec3._e;
        return true;
    }

    @Override
    public boolean continueExecuting() {
        return !this._a.getNavigator()._g();
    }

    @Override
    public void startExecuting() {
        this._a.getNavigator()._a(this._b, this._c, this._d, this._e);
    }

    public Vec3 _a() {
        Random random = this._a.getRNG();
        for (int i = 0; i < 10; ++i) {
            int n;
            int n2;
            int n3 = sajh._c(this._a.posX + (double)random.nextInt(20) - 10.0);
            if (this._f.canBlockSeeTheSky(n3, n2 = sajh._c(this._a.boundingBox._c + (double)random.nextInt(6) - 3.0), n = sajh._c(this._a.posZ + (double)random.nextInt(20) - 10.0)) || !(this._a.getBlockPathWeight(n3, n2, n) < 0.0f)) continue;
            return this._f.getWorldVec3Pool()._a(n3, n2, n);
        }
        return null;
    }
}

