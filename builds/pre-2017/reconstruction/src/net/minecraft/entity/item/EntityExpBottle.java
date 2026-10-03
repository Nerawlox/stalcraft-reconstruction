/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityExpBottle
extends EntityThrowable {
    public EntityExpBottle(World world) {
        super(world);
    }

    public EntityExpBottle(World world, EntityLivingBase entityLivingBase) {
        super(world, entityLivingBase);
    }

    public EntityExpBottle(World world, double d, double d2, double d3) {
        super(world, d, d2, d3);
    }

    @Override
    public float getGravityVelocity() {
        return 0.07f;
    }

    @Override
    public float func_70182_d() {
        return 0.7f;
    }

    @Override
    public float func_70183_g() {
        return -20.0f;
    }

    @Override
    public void onImpact(MovingObjectPosition movingObjectPosition) {
        if (!this.worldObj.isRemote) {
            int n;
            this.worldObj.playAuxSFX(2002, (int)Math.round(this.posX), (int)Math.round(this.posY), (int)Math.round(this.posZ), 0);
            for (int i = 3 + this.worldObj.rand.nextInt(5) + this.worldObj.rand.nextInt(5); i > 0; i -= n) {
                n = EntityXPOrb.getXPSplit(i);
                this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, n));
            }
            this.setDead();
        }
    }
}

