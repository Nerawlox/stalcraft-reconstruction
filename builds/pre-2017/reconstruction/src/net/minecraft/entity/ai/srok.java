/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.ofaz;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;

public class srok
extends EntityAIBase {
    public EntityHorse _a;
    public double _b;
    public double _c;
    public double _d;
    public double _e;

    public srok(EntityHorse entityHorse, double d) {
        this._a = entityHorse;
        this._b = d;
        this.setMutexBits(1);
    }

    @Override
    public boolean shouldExecute() {
        if (this._a.isTame() || this._a.riddenByEntity == null) {
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
        return !this._a.getNavigator()._g() && this._a.riddenByEntity != null;
    }

    @Override
    public void updateTask() {
        if (this._a.getRNG().nextInt(50) == 0) {
            if (this._a.riddenByEntity instanceof EntityPlayer) {
                int n = this._a.getTemper();
                int n2 = this._a.getMaxTemper();
                if (n2 > 0 && this._a.getRNG().nextInt(n2) < n) {
                    this._a.setTamedBy((EntityPlayer)this._a.riddenByEntity);
                    this._a.worldObj.setEntityState(this._a, (byte)7);
                    return;
                }
                this._a.increaseTemper(5);
            }
            this._a.riddenByEntity.mountEntity(null);
            this._a.riddenByEntity = null;
            this._a.makeHorseRearWithSound();
            this._a.worldObj.setEntityState(this._a, (byte)6);
        }
    }
}

