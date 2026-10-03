/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import java.util.List;
import java.util.Random;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.world.World;

public class srli
extends EntityAIBase {
    public EntityAnimal _a;
    public World _b;
    public EntityAnimal _c;
    public int _d;
    public double _e;

    public srli(EntityAnimal entityAnimal, double d) {
        this._a = entityAnimal;
        this._b = entityAnimal.worldObj;
        this._e = d;
        this.setMutexBits(3);
    }

    @Override
    public boolean shouldExecute() {
        if (!this._a.isInLove()) {
            return false;
        }
        this._c = this._a();
        return this._c != null;
    }

    @Override
    public boolean continueExecuting() {
        return this._c.isEntityAlive() && this._c.isInLove() && this._d < 60;
    }

    @Override
    public void resetTask() {
        this._c = null;
        this._d = 0;
    }

    @Override
    public void updateTask() {
        this._a.getLookHelper()._a(this._c, 10.0f, (float)this._a.getVerticalFaceSpeed());
        this._a.getNavigator()._a(this._c, this._e);
        ++this._d;
        if (this._d >= 60 && this._a.getDistanceSqToEntity(this._c) < 9.0) {
            this._b();
        }
    }

    public EntityAnimal _a() {
        float f = 8.0f;
        List list2 = this._b.getEntitiesWithinAABB(this._a.getClass(), this._a.boundingBox._b(f, f, f));
        double d = Double.MAX_VALUE;
        EntityAnimal entityAnimal = null;
        for (EntityAnimal entityAnimal2 : list2) {
            if (!this._a.canMateWith(entityAnimal2) || !(this._a.getDistanceSqToEntity(entityAnimal2) < d)) continue;
            entityAnimal = entityAnimal2;
            d = this._a.getDistanceSqToEntity(entityAnimal2);
        }
        return entityAnimal;
    }

    public void _b() {
        EntityAgeable entityAgeable = this._a.createChild(this._c);
        if (entityAgeable == null) {
            return;
        }
        this._a.setGrowingAge(6000);
        this._c.setGrowingAge(6000);
        this._a.resetInLove();
        this._c.resetInLove();
        entityAgeable.setGrowingAge(-24000);
        entityAgeable.setLocationAndAngles(this._a.posX, this._a.posY, this._a.posZ, 0.0f, 0.0f);
        this._b.spawnEntityInWorld(entityAgeable);
        Random random = this._a.getRNG();
        for (int i = 0; i < 7; ++i) {
            double d = random.nextGaussian() * 0.02;
            double d2 = random.nextGaussian() * 0.02;
            double d3 = random.nextGaussian() * 0.02;
            this._b.spawnParticle("heart", this._a.posX + (double)(random.nextFloat() * this._a.width * 2.0f) - (double)this._a.width, this._a.posY + 0.5 + (double)(random.nextFloat() * this._a.height), this._a.posZ + (double)(random.nextFloat() * this._a.width * 2.0f) - (double)this._a.width, d, d2, d3);
        }
        this._b.spawnEntityInWorld(new EntityXPOrb(this._b, this._a.posX, this._a.posY, this._a.posZ, random.nextInt(7) + 1));
    }
}

