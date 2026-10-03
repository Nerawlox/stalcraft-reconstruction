/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.passive;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.passive.ezey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public abstract class EntityWaterMob
extends EntityCreature
implements ezey {
    public EntityWaterMob(World world) {
        super(world);
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.worldObj.checkNoEntityCollision(this.boundingBox);
    }

    @Override
    public int getTalkInterval() {
        return 120;
    }

    @Override
    public boolean canDespawn() {
        return true;
    }

    @Override
    public int getExperiencePoints(EntityPlayer entityPlayer) {
        return 1 + this.worldObj.rand.nextInt(3);
    }

    @Override
    public void onEntityUpdate() {
        int n = this.getAir();
        super.onEntityUpdate();
        if (this.isEntityAlive() && !this.isInWater()) {
            this.setAir(--n);
            if (this.getAir() == -20) {
                this.setAir(0);
                this.attackEntityFrom(DamageSource.drown, 2.0f);
            }
        } else {
            this.setAir(300);
        }
    }
}

