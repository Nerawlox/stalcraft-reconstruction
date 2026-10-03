/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class zwaw
extends EntityAIBase {
    public EntityWolf _a;
    public EntityPlayer _b;
    public World _c;
    public float _d;
    public int _e;

    public zwaw(EntityWolf entityWolf, float f) {
        this._a = entityWolf;
        this._c = entityWolf.worldObj;
        this._d = f;
        this.setMutexBits(2);
    }

    @Override
    public boolean shouldExecute() {
        this._b = this._c.getClosestPlayerToEntity(this._a, this._d);
        if (this._b == null) {
            return false;
        }
        return this._a(this._b);
    }

    @Override
    public boolean continueExecuting() {
        if (!this._b.isEntityAlive()) {
            return false;
        }
        if (this._a.getDistanceSqToEntity(this._b) > (double)(this._d * this._d)) {
            return false;
        }
        return this._e > 0 && this._a(this._b);
    }

    @Override
    public void startExecuting() {
        this._a.func_70918_i(true);
        this._e = 40 + this._a.getRNG().nextInt(40);
    }

    @Override
    public void resetTask() {
        this._a.func_70918_i(false);
        this._b = null;
    }

    @Override
    public void updateTask() {
        this._a.getLookHelper()._a(this._b.posX, this._b.posY + (double)this._b.getEyeHeight(), this._b.posZ, 10.0f, this._a.getVerticalFaceSpeed());
        --this._e;
    }

    public boolean _a(EntityPlayer entityPlayer) {
        ItemStack itemStack = entityPlayer.inventory._a();
        if (itemStack == null) {
            return false;
        }
        if (!this._a.isTamed() && itemStack._d == Item.bone.itemID) {
            return true;
        }
        return this._a.isBreedingItem(itemStack);
    }
}

