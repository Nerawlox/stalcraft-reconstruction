/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.projectile;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class EntityWitherSkull
extends EntityFireball {
    public EntityWitherSkull(World world) {
        super(world);
        this.setSize(0.3125f, 0.3125f);
    }

    public EntityWitherSkull(World world, EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        super(world, entityLivingBase, d, d2, d3);
        this.setSize(0.3125f, 0.3125f);
    }

    @Override
    public float getMotionFactor() {
        return this.isInvulnerable() ? 0.73f : super.getMotionFactor();
    }

    public EntityWitherSkull(World world, double d, double d2, double d3, double d4, double d5, double d6) {
        super(world, d, d2, d3, d4, d5, d6);
        this.setSize(0.3125f, 0.3125f);
    }

    @Override
    public boolean isBurning() {
        return false;
    }

    @Override
    public float getBlockExplosionResistance(Explosion explosion, World world, int n, int n2, int n3, Block block) {
        float f = super.getBlockExplosionResistance(explosion, world, n, n2, n3, block);
        if (this.isInvulnerable() && block != Block.bedrock && block != Block.endPortal && block != Block.endPortalFrame) {
            f = Math.min(0.8f, f);
        }
        return f;
    }

    @Override
    public void onImpact(MovingObjectPosition movingObjectPosition) {
        if (!this.worldObj.isRemote) {
            if (movingObjectPosition._i != null) {
                if (this.shootingEntity != null) {
                    if (movingObjectPosition._i.attackEntityFrom(DamageSource.causeMobDamage(this.shootingEntity), 8.0f) && !movingObjectPosition._i.isEntityAlive()) {
                        this.shootingEntity.heal(5.0f);
                    }
                } else {
                    movingObjectPosition._i.attackEntityFrom(DamageSource.magic, 5.0f);
                }
                if (movingObjectPosition._i instanceof EntityLivingBase) {
                    int n = 0;
                    if (this.worldObj.difficultySetting > 1) {
                        if (this.worldObj.difficultySetting == 2) {
                            n = 10;
                        } else if (this.worldObj.difficultySetting == 3) {
                            n = 40;
                        }
                    }
                    if (n > 0) {
                        ((EntityLivingBase)movingObjectPosition._i).addPotionEffect(new PotionEffect(Potion._v._H, 20 * n, 1));
                    }
                }
            }
            this.worldObj.newExplosion(this, this.posX, this.posY, this.posZ, 1.0f, false, this.worldObj.getGameRules()._b("mobGriefing"));
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

    @Override
    public void entityInit() {
        this.dataWatcher._a(10, (Object)0);
    }

    public boolean isInvulnerable() {
        return this.dataWatcher._a(10) == 1;
    }

    public void setInvulnerable(boolean bl) {
        this.dataWatcher._b(10, bl ? (byte)1 : 0);
    }
}

