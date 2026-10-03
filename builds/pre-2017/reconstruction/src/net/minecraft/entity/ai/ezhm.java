/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ezhm
extends EntityAIBase {
    public EntityCreature _a;
    public double _b;
    public double _c;
    public double _d;
    public double _e;
    public double _f;
    public double _g;
    public EntityPlayer _h;
    public int _i;
    public boolean _j;
    public int _k;
    public boolean _l;
    public boolean _m;

    public ezhm(EntityCreature entityCreature, double d, int n, boolean bl) {
        this._a = entityCreature;
        this._b = d;
        this._k = n;
        this._l = bl;
        this.setMutexBits(3);
    }

    @Override
    public boolean shouldExecute() {
        if (this._i > 0) {
            --this._i;
            return false;
        }
        this._h = this._a.worldObj.getClosestPlayerToEntity(this._a, 10.0);
        if (this._h == null) {
            return false;
        }
        ItemStack itemStack = this._h.getCurrentEquippedItem();
        if (itemStack == null) {
            return false;
        }
        return itemStack._d == this._k;
    }

    @Override
    public boolean continueExecuting() {
        if (this._l) {
            if (this._a.getDistanceSqToEntity(this._h) < 36.0) {
                if (this._h.getDistanceSq(this._c, this._d, this._e) > 0.010000000000000002) {
                    return false;
                }
                if (Math.abs((double)this._h.rotationPitch - this._f) > 5.0 || Math.abs((double)this._h.rotationYaw - this._g) > 5.0) {
                    return false;
                }
            } else {
                this._c = this._h.posX;
                this._d = this._h.posY;
                this._e = this._h.posZ;
            }
            this._f = this._h.rotationPitch;
            this._g = this._h.rotationYaw;
        }
        return this.shouldExecute();
    }

    @Override
    public void startExecuting() {
        this._c = this._h.posX;
        this._d = this._h.posY;
        this._e = this._h.posZ;
        this._j = true;
        this._m = this._a.getNavigator()._a();
        this._a.getNavigator()._a(false);
    }

    @Override
    public void resetTask() {
        this._h = null;
        this._a.getNavigator()._h();
        this._i = 100;
        this._j = false;
        this._a.getNavigator()._a(this._m);
    }

    @Override
    public void updateTask() {
        this._a.getLookHelper()._a(this._h, 30.0f, (float)this._a.getVerticalFaceSpeed());
        if (this._a.getDistanceSqToEntity(this._h) < 6.25) {
            this._a.getNavigator()._h();
        } else {
            this._a.getNavigator()._a(this._h, this._b);
        }
    }

    public boolean _a() {
        return this._j;
    }
}

