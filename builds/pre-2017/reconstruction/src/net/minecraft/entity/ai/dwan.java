/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.ofaz;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.village.Village;

public class dwan
extends EntityAIBase {
    public EntityCreature _a;
    public double _b;
    public PathEntity _c;
    public ellv _d;
    public boolean _e;
    public List _f = new ArrayList();

    public dwan(EntityCreature entityCreature, double d, boolean bl) {
        this._a = entityCreature;
        this._b = d;
        this._e = bl;
        this.setMutexBits(1);
    }

    @Override
    public boolean shouldExecute() {
        this._a();
        if (this._e && this._a.worldObj.isDaytime()) {
            return false;
        }
        Village village = this._a.worldObj.villageCollectionObj._a(sajh._c(this._a.posX), sajh._c(this._a.posY), sajh._c(this._a.posZ), 0);
        if (village == null) {
            return false;
        }
        this._d = this._a(village);
        if (this._d == null) {
            return false;
        }
        boolean bl = this._a.getNavigator()._b();
        this._a.getNavigator()._b(false);
        this._c = this._a.getNavigator()._a(this._d._a, this._d._b, this._d._c);
        this._a.getNavigator()._b(bl);
        if (this._c != null) {
            return true;
        }
        Vec3 vec3 = ofaz._a(this._a, 10, 7, this._a.worldObj.getWorldVec3Pool()._a(this._d._a, this._d._b, this._d._c));
        if (vec3 == null) {
            return false;
        }
        this._a.getNavigator()._b(false);
        this._c = this._a.getNavigator()._a(vec3._c, vec3._d, vec3._e);
        this._a.getNavigator()._b(bl);
        return this._c != null;
    }

    @Override
    public boolean continueExecuting() {
        if (this._a.getNavigator()._g()) {
            return false;
        }
        float f = this._a.width + 4.0f;
        return this._a.getDistanceSq(this._d._a, this._d._b, this._d._c) > (double)(f * f);
    }

    @Override
    public void startExecuting() {
        this._a.getNavigator()._a(this._c, this._b);
    }

    @Override
    public void resetTask() {
        if (this._a.getNavigator()._g() || this._a.getDistanceSq(this._d._a, this._d._b, this._d._c) < 16.0) {
            this._f.add(this._d);
        }
    }

    public ellv _a(Village village) {
        ellv ellv2 = null;
        int n = Integer.MAX_VALUE;
        List list = village._h();
        for (ellv ellv3 : list) {
            int n2 = ellv3._a(sajh._c(this._a.posX), sajh._c(this._a.posY), sajh._c(this._a.posZ));
            if (n2 >= n || this._a(ellv3)) continue;
            ellv2 = ellv3;
            n = n2;
        }
        return ellv2;
    }

    public boolean _a(ellv ellv2) {
        for (ellv ellv3 : this._f) {
            if (ellv2._a != ellv3._a || ellv2._b != ellv3._b || ellv2._c != ellv3._c) continue;
            return true;
        }
        return false;
    }

    public void _a() {
        if (this._f.size() > 15) {
            this._f.remove(0);
        }
    }
}

