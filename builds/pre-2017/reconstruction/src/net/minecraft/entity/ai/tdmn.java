/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;

public class tdmn
extends EntityAIBase {
    public EntityLiving _a;
    public double _b;
    public double _c;
    public int _d;

    public tdmn(EntityLiving entityLiving) {
        this._a = entityLiving;
        this.setMutexBits(3);
    }

    @Override
    public boolean shouldExecute() {
        return this._a.getRNG().nextFloat() < 0.02f;
    }

    @Override
    public boolean continueExecuting() {
        return this._d >= 0;
    }

    @Override
    public void startExecuting() {
        double d = Math.PI * 2 * this._a.getRNG().nextDouble();
        this._b = Math.cos(d);
        this._c = Math.sin(d);
        this._d = 20 + this._a.getRNG().nextInt(20);
    }

    @Override
    public void updateTask() {
        --this._d;
        this._a.getLookHelper()._a(this._a.posX + this._b, this._a.posY + (double)this._a.getEyeHeight(), this._a.posZ + this._c, 10.0f, this._a.getVerticalFaceSpeed());
    }
}

