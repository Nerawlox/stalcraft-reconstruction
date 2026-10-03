/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntitySnowball
extends EntityThrowable {
    public EntitySnowball(World world) {
        super(world);
    }

    public EntitySnowball(World world, EntityLivingBase entityLivingBase) {
        super(world, entityLivingBase);
    }

    public EntitySnowball(World world, double d, double d2, double d3) {
        super(world, d, d2, d3);
    }

    @Override
    public void onImpact(MovingObjectPosition movingObjectPosition) {
        int n;
        if (movingObjectPosition._i != null) {
            n = 0;
            if (movingObjectPosition._i instanceof EntityBlaze) {
                n = 3;
            }
            movingObjectPosition._i.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), n);
        }
        for (n = 0; n < 8; ++n) {
            this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0);
        }
        if (!this.worldObj.isRemote) {
            this.setDead();
        }
    }
}

