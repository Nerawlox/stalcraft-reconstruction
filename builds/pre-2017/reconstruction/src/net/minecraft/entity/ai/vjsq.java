/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.ai.iurq;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;

public class vjsq
extends iurq {
    public final EntityVillager _a;

    public vjsq(EntityVillager entityVillager) {
        super(entityVillager, EntityPlayer.class, 8.0f);
        this._a = entityVillager;
    }

    @Override
    public boolean shouldExecute() {
        if (this._a.isTrading()) {
            this._c = this._a.getCustomer();
            return true;
        }
        return false;
    }
}

