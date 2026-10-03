/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityLargeFireball
extends EntityFireball {
    public int field_92057_e = 1;

    public EntityLargeFireball(World world) {
        super(world);
    }

    public EntityLargeFireball(World world, double d, double d2, double d3, double d4, double d5, double d6) {
        super(world, d, d2, d3, d4, d5, d6);
    }

    public EntityLargeFireball(World world, EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        super(world, entityLivingBase, d, d2, d3);
    }

    @Override
    public void onImpact(MovingObjectPosition movingObjectPosition) {
        if (!this.worldObj.isRemote) {
            if (movingObjectPosition._i != null) {
                movingObjectPosition._i.attackEntityFrom(DamageSource.causeFireballDamage(this, this.shootingEntity), 6.0f);
            }
            this.worldObj.newExplosion(null, this.posX, this.posY, this.posZ, this.field_92057_e, true, this.worldObj.getGameRules()._b("mobGriefing"));
            this.setDead();
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
        nBTTagCompound._a("ExplosionPower", this.field_92057_e);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
        if (nBTTagCompound._c("ExplosionPower")) {
            this.field_92057_e = nBTTagCompound._f("ExplosionPower");
        }
    }
}

