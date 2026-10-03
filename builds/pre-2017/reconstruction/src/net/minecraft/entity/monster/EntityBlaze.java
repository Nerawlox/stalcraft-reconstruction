/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.monster;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.sajz;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class EntityBlaze
extends EntityMob {
    public float heightOffset = 0.5f;
    public int heightOffsetUpdateTime;
    public int field_70846_g;

    public EntityBlaze(World world) {
        super(world);
        this.isImmuneToFire = true;
        this.experienceValue = 10;
    }

    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(sajz._e)._a(6.0);
    }

    @Override
    public void entityInit() {
        super.entityInit();
        this.dataWatcher._a(16, new Byte(0));
    }

    @Override
    public String getLivingSound() {
        return "mob.blaze.breathe";
    }

    @Override
    public String getHurtSound() {
        return "mob.blaze.hit";
    }

    @Override
    public String getDeathSound() {
        return "mob.blaze.death";
    }

    @Override
    public int getBrightnessForRender(float f) {
        return 0xF000F0;
    }

    @Override
    public float getBrightness(float f) {
        return 1.0f;
    }

    @Override
    public void onLivingUpdate() {
        if (!this.worldObj.isRemote) {
            if (this.isWet()) {
                this.attackEntityFrom(DamageSource.drown, 1.0f);
            }
            --this.heightOffsetUpdateTime;
            if (this.heightOffsetUpdateTime <= 0) {
                this.heightOffsetUpdateTime = 100;
                this.heightOffset = 0.5f + (float)this.rand.nextGaussian() * 3.0f;
            }
            if (this.getEntityToAttack() != null && this.getEntityToAttack().posY + (double)this.getEntityToAttack().getEyeHeight() > this.posY + (double)this.getEyeHeight() + (double)this.heightOffset) {
                this.motionY += ((double)0.3f - this.motionY) * (double)0.3f;
            }
        }
        if (this.rand.nextInt(24) == 0) {
            this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "fire.fire", 1.0f + this.rand.nextFloat(), this.rand.nextFloat() * 0.7f + 0.3f);
        }
        if (!this.onGround && this.motionY < 0.0) {
            this.motionY *= 0.6;
        }
        for (int i = 0; i < 2; ++i) {
            this.worldObj.spawnParticle("largesmoke", this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, 0.0, 0.0, 0.0);
        }
        super.onLivingUpdate();
    }

    @Override
    public void attackEntity(Entity entity, float f) {
        if (this.attackTime <= 0 && f < 2.0f && entity.boundingBox._f > this.boundingBox._c && entity.boundingBox._c < this.boundingBox._f) {
            this.attackTime = 20;
            this.attackEntityAsMob(entity);
        } else if (f < 30.0f) {
            double d = entity.posX - this.posX;
            double d2 = entity.boundingBox._c + (double)(entity.height / 2.0f) - (this.posY + (double)(this.height / 2.0f));
            double d3 = entity.posZ - this.posZ;
            if (this.attackTime == 0) {
                ++this.field_70846_g;
                if (this.field_70846_g == 1) {
                    this.attackTime = 60;
                    this.func_70844_e(true);
                } else if (this.field_70846_g <= 4) {
                    this.attackTime = 6;
                } else {
                    this.attackTime = 100;
                    this.field_70846_g = 0;
                    this.func_70844_e(false);
                }
                if (this.field_70846_g > 1) {
                    float f2 = sajh._c(f) * 0.5f;
                    this.worldObj.playAuxSFXAtEntity(null, 1009, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
                    for (int i = 0; i < 1; ++i) {
                        EntitySmallFireball entitySmallFireball = new EntitySmallFireball(this.worldObj, this, d + this.rand.nextGaussian() * (double)f2, d2, d3 + this.rand.nextGaussian() * (double)f2);
                        entitySmallFireball.posY = this.posY + (double)(this.height / 2.0f) + 0.5;
                        this.worldObj.spawnEntityInWorld(entitySmallFireball);
                    }
                }
            }
            this.rotationYaw = (float)(Math.atan2(d3, d) * 180.0 / 3.1415927410125732) - 90.0f;
            this.hasAttacked = true;
        }
    }

    @Override
    public void fall(float f) {
    }

    @Override
    public int getDropItemId() {
        return Item.blazeRod.itemID;
    }

    @Override
    public boolean isBurning() {
        return this.func_70845_n();
    }

    @Override
    public void dropFewItems(boolean bl, int n) {
        if (bl) {
            int n2 = this.rand.nextInt(2 + n);
            for (int i = 0; i < n2; ++i) {
                this.dropItem(Item.blazeRod.itemID, 1);
            }
        }
    }

    public boolean func_70845_n() {
        return (this.dataWatcher._a(16) & 1) != 0;
    }

    public void func_70844_e(boolean bl) {
        byte by = this.dataWatcher._a(16);
        by = bl ? (byte)(by | 1) : (byte)(by & 0xFFFFFFFE);
        this.dataWatcher._b(16, by);
    }

    @Override
    public boolean isValidLightLevel() {
        return true;
    }
}

