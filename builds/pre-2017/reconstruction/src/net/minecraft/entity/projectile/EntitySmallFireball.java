/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.projectile;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntitySmallFireball
extends EntityFireball {
    public EntitySmallFireball(World world) {
        super(world);
        this.setSize(0.3125f, 0.3125f);
    }

    public EntitySmallFireball(World world, EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        super(world, entityLivingBase, d, d2, d3);
        this.setSize(0.3125f, 0.3125f);
    }

    public EntitySmallFireball(World world, double d, double d2, double d3, double d4, double d5, double d6) {
        super(world, d, d2, d3, d4, d5, d6);
        this.setSize(0.3125f, 0.3125f);
    }

    @Override
    public void onImpact(MovingObjectPosition movingObjectPosition) {
        if (!this.worldObj.isRemote) {
            if (movingObjectPosition._i != null) {
                if (!movingObjectPosition._i.isImmuneToFire() && movingObjectPosition._i.attackEntityFrom(DamageSource.causeFireballDamage(this, this.shootingEntity), 5.0f)) {
                    movingObjectPosition._i.setFire(5);
                }
            } else {
                int n = movingObjectPosition._d;
                int n2 = movingObjectPosition._e;
                int n3 = movingObjectPosition._f;
                switch (movingObjectPosition._g) {
                    case 1: {
                        ++n2;
                        break;
                    }
                    case 0: {
                        --n2;
                        break;
                    }
                    case 2: {
                        --n3;
                        break;
                    }
                    case 3: {
                        ++n3;
                        break;
                    }
                    case 5: {
                        ++n;
                        break;
                    }
                    case 4: {
                        --n;
                    }
                }
                if (this.worldObj.isAirBlock(n, n2, n3)) {
                    this.worldObj.setBlock(n, n2, n3, Block.fire.blockID);
                }
            }
            this.setDead();
        }
    }

    @Override
    public boolean canBeCollidedWith() {
        return false;
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        return false;
    }
}

