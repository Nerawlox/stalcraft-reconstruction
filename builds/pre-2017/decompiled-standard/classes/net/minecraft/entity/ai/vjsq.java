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
    public boolean func_75250_a() {
        if (this._a.func_70940_q()) {
            this._c = this._a.func_70931_l_();
            return true;
        }
        return false;
    }
}

