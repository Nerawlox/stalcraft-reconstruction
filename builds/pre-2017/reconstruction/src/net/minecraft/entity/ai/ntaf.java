/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ntaf
extends EntityAIBase {
    public EntityVillager _a;

    public ntaf(EntityVillager entityVillager) {
        this._a = entityVillager;
        this.setMutexBits(5);
    }

    @Override
    public boolean shouldExecute() {
        if (!this._a.isEntityAlive()) {
            return false;
        }
        if (this._a.isInWater()) {
            return false;
        }
        if (!this._a.onGround) {
            return false;
        }
        if (this._a.velocityChanged) {
            return false;
        }
        EntityPlayer entityPlayer = this._a.getCustomer();
        if (entityPlayer == null) {
            return false;
        }
        if (this._a.getDistanceSqToEntity(entityPlayer) > 16.0) {
            return false;
        }
        return entityPlayer.openContainer instanceof Container;
    }

    @Override
    public void startExecuting() {
        this._a.getNavigator()._h();
    }

    @Override
    public void resetTask() {
        this._a.setCustomer(null);
    }
}

