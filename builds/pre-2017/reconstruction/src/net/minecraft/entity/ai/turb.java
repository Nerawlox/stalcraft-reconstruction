/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;

public class turb
extends EntityAIBase {
    public EntityCreature _a;

    public turb(EntityCreature entityCreature) {
        this._a = entityCreature;
    }

    @Override
    public boolean shouldExecute() {
        return this._a.worldObj.isDaytime();
    }

    @Override
    public void startExecuting() {
        this._a.getNavigator()._d(true);
    }

    @Override
    public void resetTask() {
        this._a.getNavigator()._d(false);
    }
}

