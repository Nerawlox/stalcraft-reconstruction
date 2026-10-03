/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIDoorInteract;

public class uxqz
extends EntityAIDoorInteract {
    public boolean _a;
    public int _b;

    public uxqz(EntityLiving entityLiving, boolean bl) {
        super(entityLiving);
        this.theEntity = entityLiving;
        this._a = bl;
    }

    @Override
    public boolean continueExecuting() {
        return this._a && this._b > 0 && super.continueExecuting();
    }

    @Override
    public void startExecuting() {
        this._b = 20;
        this.targetDoor._a(this.theEntity.worldObj, this.entityPosX, this.entityPosY, this.entityPosZ, true);
    }

    @Override
    public void resetTask() {
        if (this._a) {
            this.targetDoor._a(this.theEntity.worldObj, this.entityPosX, this.entityPosY, this.entityPosZ, false);
        }
    }

    @Override
    public void updateTask() {
        --this._b;
        super.updateTask();
    }
}

