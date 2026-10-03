/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class pidb
extends EntityAIBase {
    public World _a;
    public EntityCreature _b;
    public int _c;
    public double _d;
    public boolean _e;
    public PathEntity _f;
    public Class _g;
    public int _h;
    public int _i;

    public pidb(EntityCreature entityCreature, Class clazz, double d, boolean bl) {
        this(entityCreature, d, bl);
        this._g = clazz;
    }

    public pidb(EntityCreature entityCreature, double d, boolean bl) {
        this._b = entityCreature;
        this._a = entityCreature.worldObj;
        this._d = d;
        this._e = bl;
        this.setMutexBits(3);
    }

    @Override
    public boolean shouldExecute() {
        EntityLivingBase entityLivingBase = this._b.getAttackTarget();
        if (entityLivingBase == null) {
            return false;
        }
        if (!entityLivingBase.isEntityAlive()) {
            return false;
        }
        if (this._g != null && !this._g.isAssignableFrom(entityLivingBase.getClass())) {
            return false;
        }
        if (--this._h <= 0) {
            this._f = this._b.getNavigator()._a(entityLivingBase);
            this._h = 4 + this._b.getRNG().nextInt(7);
            return this._f != null;
        }
        return true;
    }

    @Override
    public boolean continueExecuting() {
        EntityLivingBase entityLivingBase = this._b.getAttackTarget();
        return entityLivingBase == null ? false : (!entityLivingBase.isEntityAlive() ? false : (!this._e ? !this._b.getNavigator()._g() : this._b.func_110176_b(sajh._c(entityLivingBase.posX), sajh._c(entityLivingBase.posY), sajh._c(entityLivingBase.posZ))));
    }

    @Override
    public void startExecuting() {
        this._b.getNavigator()._a(this._f, this._d);
        this._h = 0;
    }

    @Override
    public void resetTask() {
        this._b.getNavigator()._h();
    }

    @Override
    public void updateTask() {
        EntityLivingBase entityLivingBase = this._b.getAttackTarget();
        this._b.getLookHelper()._a(entityLivingBase, 30.0f, 30.0f);
        if ((this._e || this._b.getEntitySenses()._a(entityLivingBase)) && --this._h <= 0) {
            elhc elhc2;
            this._h = this._i + 4 + this._b.getRNG().nextInt(7);
            this._b.getNavigator()._a(entityLivingBase, this._d);
            this._i = this._b.getNavigator()._d() != null ? ((elhc2 = this._b.getNavigator()._d()._f()) != null && entityLivingBase.getDistanceSq(elhc2._a, elhc2._b, elhc2._c) < 1.0 ? 0 : (this._i += 10)) : (this._i += 10);
        }
        this._c = Math.max(this._c - 1, 0);
        double d = this._b.width * 2.0f * this._b.width * 2.0f + entityLivingBase.width;
        if (this._b.getDistanceSq(entityLivingBase.posX, entityLivingBase.boundingBox._c, entityLivingBase.posZ) <= d && this._c <= 0) {
            this._c = 20;
            if (this._b.getHeldItem() != null) {
                this._b.swingItem();
            }
            this._b.attackEntityAsMob(entityLivingBase);
        }
    }
}

