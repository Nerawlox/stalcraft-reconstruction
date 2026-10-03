/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import java.util.List;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.ofaz;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.Vec3;

public class samo
extends EntityAIBase {
    public EntityVillager _a;
    public EntityLivingBase _b;
    public double _c;
    public int _d;

    public samo(EntityVillager entityVillager, double d) {
        this._a = entityVillager;
        this._c = d;
        this.setMutexBits(1);
    }

    @Override
    public boolean shouldExecute() {
        if (this._a.getGrowingAge() >= 0) {
            return false;
        }
        if (this._a.getRNG().nextInt(400) != 0) {
            return false;
        }
        List list = this._a.worldObj.getEntitiesWithinAABB(EntityVillager.class, this._a.boundingBox._b(6.0, 3.0, 6.0));
        double d = Double.MAX_VALUE;
        Object object = list.iterator();
        while (object.hasNext()) {
            double d2;
            EntityVillager entityVillager = (EntityVillager)object.next();
            if (entityVillager == this._a || entityVillager.isPlaying() || entityVillager.getGrowingAge() >= 0 || (d2 = entityVillager.getDistanceSqToEntity(this._a)) > d) continue;
            d = d2;
            this._b = entityVillager;
        }
        return this._b != null || (object = ofaz._a(this._a, 16, 3)) != null;
    }

    @Override
    public boolean continueExecuting() {
        return this._d > 0;
    }

    @Override
    public void startExecuting() {
        if (this._b != null) {
            this._a.setPlaying(true);
        }
        this._d = 1000;
    }

    @Override
    public void resetTask() {
        this._a.setPlaying(false);
        this._b = null;
    }

    @Override
    public void updateTask() {
        --this._d;
        if (this._b != null) {
            if (this._a.getDistanceSqToEntity(this._b) > 4.0) {
                this._a.getNavigator()._a(this._b, this._c);
            }
        } else if (this._a.getNavigator()._g()) {
            Vec3 vec3 = ofaz._a(this._a, 16, 3);
            if (vec3 == null) {
                return;
            }
            this._a.getNavigator()._a(vec3._c, vec3._d, vec3._e, this._c);
        }
    }
}

