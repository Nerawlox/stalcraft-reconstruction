/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityEgg
extends EntityThrowable {
    public EntityEgg(World world) {
        super(world);
    }

    public EntityEgg(World world, EntityLivingBase entityLivingBase) {
        super(world, entityLivingBase);
    }

    public EntityEgg(World world, double d, double d2, double d3) {
        super(world, d, d2, d3);
    }

    @Override
    public void onImpact(MovingObjectPosition movingObjectPosition) {
        int n;
        if (movingObjectPosition._i != null) {
            movingObjectPosition._i.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.0f);
        }
        if (!this.worldObj.isRemote && this.rand.nextInt(8) == 0) {
            n = 1;
            if (this.rand.nextInt(32) == 0) {
                n = 4;
            }
            for (int i = 0; i < n; ++i) {
                EntityChicken entityChicken = new EntityChicken(this.worldObj);
                entityChicken.setGrowingAge(-24000);
                entityChicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                this.worldObj.spawnEntityInWorld(entityChicken);
            }
        }
        for (n = 0; n < 8; ++n) {
            this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0);
        }
        if (!this.worldObj.isRemote) {
            this.setDead();
        }
    }
}

