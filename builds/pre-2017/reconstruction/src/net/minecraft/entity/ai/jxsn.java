/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import java.util.List;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.passive.EntityVillager;

public class jxsn
extends EntityAIBase {
    public EntityVillager _a;
    public EntityIronGolem _b;
    public int _c;
    public boolean _d;

    public jxsn(EntityVillager entityVillager) {
        this._a = entityVillager;
        this.setMutexBits(3);
    }

    @Override
    public boolean shouldExecute() {
        if (this._a.getGrowingAge() >= 0) {
            return false;
        }
        if (!this._a.worldObj.isDaytime()) {
            return false;
        }
        List list = this._a.worldObj.getEntitiesWithinAABB(EntityIronGolem.class, this._a.boundingBox._b(6.0, 2.0, 6.0));
        if (list.isEmpty()) {
            return false;
        }
        for (EntityIronGolem entityIronGolem : list) {
            if (entityIronGolem.getHoldRoseTick() <= 0) continue;
            this._b = entityIronGolem;
            break;
        }
        return this._b != null;
    }

    @Override
    public boolean continueExecuting() {
        return this._b.getHoldRoseTick() > 0;
    }

    @Override
    public void startExecuting() {
        this._c = this._a.getRNG().nextInt(320);
        this._d = false;
        this._b.getNavigator()._h();
    }

    @Override
    public void resetTask() {
        this._b = null;
        this._a.getNavigator()._h();
    }

    @Override
    public void updateTask() {
        this._a.getLookHelper()._a(this._b, 30.0f, 30.0f);
        if (this._b.getHoldRoseTick() == this._c) {
            this._a.getNavigator()._a(this._b, 0.5);
            this._d = true;
        }
        if (this._d && this._a.getDistanceSqToEntity(this._b) < 4.0) {
            this._b.setHoldingRose(false);
            this._a.getNavigator()._h();
        }
    }
}

