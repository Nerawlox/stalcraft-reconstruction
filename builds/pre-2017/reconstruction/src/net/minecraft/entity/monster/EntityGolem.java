/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.monster;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.passive.ezey;
import net.minecraft.world.World;

public abstract class EntityGolem
extends EntityCreature
implements ezey {
    public EntityGolem(World world) {
        super(world);
    }

    @Override
    public void fall(float f) {
    }

    @Override
    public String getLivingSound() {
        return "none";
    }

    @Override
    public String getHurtSound() {
        return "none";
    }

    @Override
    public String getDeathSound() {
        return "none";
    }

    @Override
    public int getTalkInterval() {
        return 120;
    }

    @Override
    public boolean canDespawn() {
        return false;
    }
}

