/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.passive;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.ezey;
import net.minecraft.entity.player.EntityPlayer;

public abstract class EntityAmbientCreature
extends EntityLiving
implements ezey {
    public EntityAmbientCreature(ozlu ozlu2) {
        super(ozlu2);
    }

    @Override
    public boolean func_110164_bC() {
        return false;
    }

    @Override
    public boolean func_70085_c(EntityPlayer entityPlayer) {
        return false;
    }
}

