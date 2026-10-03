/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.ezey;
import net.minecraft.entity.ai.ofaz;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.Vec3;

public class EntityAIAvoidEntity
extends EntityAIBase {
    public final IEntitySelector _a = new ezey(this);
    public EntityCreature _b;
    public double _c;
    public double _d;
    public Entity _e;
    public float _f;
    public PathEntity _g;
    public PathNavigate _h;
    public Class _i;

    public EntityAIAvoidEntity(EntityCreature entityCreature, Class clazz, float f, double d, double d2) {
        this._b = entityCreature;
        this._i = clazz;
        this._f = f;
        this._c = d;
        this._d = d2;
        this._h = entityCreature.getNavigator();
        this.setMutexBits(1);
    }

    @Override
    public boolean shouldExecute() {
        Object object;
        if (this._i == EntityPlayer.class) {
            if (this._b instanceof EntityTameable && ((EntityTameable)this._b).isTamed()) {
                return false;
            }
            this._e = this._b.worldObj.getClosestPlayerToEntity(this._b, this._f);
            if (this._e == null) {
                return false;
            }
        } else {
            object = this._b.worldObj.selectEntitiesWithinAABB(this._i, this._b.boundingBox._b(this._f, 3.0, this._f), this._a);
            if (object.isEmpty()) {
                return false;
            }
            this._e = (Entity)object.get(0);
        }
        if ((object = ofaz._b(this._b, 16, 7, this._b.worldObj.getWorldVec3Pool()._a(this._e.posX, this._e.posY, this._e.posZ))) == null) {
            return false;
        }
        if (this._e.getDistanceSq(((Vec3)object)._c, ((Vec3)object)._d, ((Vec3)object)._e) < this._e.getDistanceSqToEntity(this._b)) {
            return false;
        }
        this._g = this._h._a(((Vec3)object)._c, ((Vec3)object)._d, ((Vec3)object)._e);
        if (this._g == null) {
            return false;
        }
        return this._g._a((Vec3)object);
    }

    @Override
    public boolean continueExecuting() {
        return !this._h._g();
    }

    @Override
    public void startExecuting() {
        this._h._a(this._g, this._c);
    }

    @Override
    public void resetTask() {
        this._e = null;
    }

    @Override
    public void updateTask() {
        if (this._b.getDistanceSqToEntity(this._e) < 49.0) {
            this._b.getNavigator()._a(this._d);
        } else {
            this._b.getNavigator()._a(this._c);
        }
    }

    public static /* synthetic */ EntityCreature _a(EntityAIAvoidEntity entityAIAvoidEntity) {
        return entityAIAvoidEntity._b;
    }
}

