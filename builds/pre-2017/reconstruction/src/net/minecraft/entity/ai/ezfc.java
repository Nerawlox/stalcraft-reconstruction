/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import java.util.List;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityAnimal;

public class ezfc
extends EntityAIBase {
    public EntityAnimal _a;
    public EntityAnimal _b;
    public double _c;
    public int _d;

    public ezfc(EntityAnimal entityAnimal, double d) {
        this._a = entityAnimal;
        this._c = d;
    }

    @Override
    public boolean shouldExecute() {
        if (this._a.getGrowingAge() >= 0) {
            return false;
        }
        List list2 = this._a.worldObj.getEntitiesWithinAABB(this._a.getClass(), this._a.boundingBox._b(8.0, 4.0, 8.0));
        EntityAnimal entityAnimal = null;
        double d = Double.MAX_VALUE;
        for (EntityAnimal entityAnimal2 : list2) {
            double d2;
            if (entityAnimal2.getGrowingAge() < 0 || (d2 = this._a.getDistanceSqToEntity(entityAnimal2)) > d) continue;
            d = d2;
            entityAnimal = entityAnimal2;
        }
        if (entityAnimal == null) {
            return false;
        }
        if (d < 9.0) {
            return false;
        }
        this._b = entityAnimal;
        return true;
    }

    @Override
    public boolean continueExecuting() {
        if (!this._b.isEntityAlive()) {
            return false;
        }
        double d = this._a.getDistanceSqToEntity(this._b);
        return !(d < 9.0) && !(d > 256.0);
    }

    @Override
    public void startExecuting() {
        this._d = 0;
    }

    @Override
    public void resetTask() {
        this._b = null;
    }

    @Override
    public void updateTask() {
        if (--this._d > 0) {
            return;
        }
        this._d = 10;
        this._a.getNavigator()._a(this._b, this._c);
    }
}

