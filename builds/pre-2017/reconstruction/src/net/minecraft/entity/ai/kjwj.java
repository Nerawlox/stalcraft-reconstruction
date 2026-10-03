/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.ofaz;
import net.minecraft.util.Vec3;

public class kjwj
extends EntityAIBase {
    public EntityCreature _a;
    public double _b;
    public double _c;
    public double _d;
    public double _e;

    public kjwj(EntityCreature entityCreature, double d) {
        this._a = entityCreature;
        this._b = d;
        this.setMutexBits(1);
    }

    @Override
    public boolean shouldExecute() {
        if (this._a.getAITarget() == null && !this._a.isBurning()) {
            return false;
        }
        Vec3 vec3 = ofaz._a(this._a, 5, 4);
        if (vec3 == null) {
            return false;
        }
        this._c = vec3._c;
        this._d = vec3._d;
        this._e = vec3._e;
        return true;
    }

    @Override
    public void startExecuting() {
        this._a.getNavigator()._a(this._c, this._d, this._e, this._b);
    }

    @Override
    public boolean continueExecuting() {
        return !this._a.getNavigator()._g();
    }
}

