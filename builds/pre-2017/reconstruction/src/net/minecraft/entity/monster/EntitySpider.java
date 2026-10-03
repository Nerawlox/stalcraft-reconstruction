/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.monster;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.dwan;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.sajz;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class EntitySpider
extends EntityMob {
    public EntitySpider(World world) {
        super(world);
        this.setSize(1.4f, 0.9f);
    }

    @Override
    public void entityInit() {
        super.entityInit();
        this.dataWatcher._a(16, new Byte(0));
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!this.worldObj.isRemote) {
            this.setBesideClimbableBlock(this.isCollidedHorizontally);
        }
    }

    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(sajz._a)._a(16.0);
        this.getEntityAttribute(sajz._d)._a(0.8f);
    }

    @Override
    public Entity findPlayerToAttack() {
        float f = this.getBrightness(1.0f);
        if (f < 0.5f) {
            double d = 16.0;
            return this.worldObj.getClosestVulnerablePlayerToEntity(this, d);
        }
        return null;
    }

    @Override
    public String getLivingSound() {
        return "mob.spider.say";
    }

    @Override
    public String getHurtSound() {
        return "mob.spider.say";
    }

    @Override
    public String getDeathSound() {
        return "mob.spider.death";
    }

    @Override
    public void playStepSound(int n, int n2, int n3, int n4) {
        this.playSound("mob.spider.step", 0.15f, 1.0f);
    }

    @Override
    public void attackEntity(Entity entity, float f) {
        float f2 = this.getBrightness(1.0f);
        if (f2 > 0.5f && this.rand.nextInt(100) == 0) {
            this.entityToAttack = null;
            return;
        }
        if (f > 2.0f && f < 6.0f && this.rand.nextInt(10) == 0) {
            if (this.onGround) {
                double d = entity.posX - this.posX;
                double d2 = entity.posZ - this.posZ;
                float f3 = sajh._a(d * d + d2 * d2);
                this.motionX = d / (double)f3 * 0.5 * (double)0.8f + this.motionX * (double)0.2f;
                this.motionZ = d2 / (double)f3 * 0.5 * (double)0.8f + this.motionZ * (double)0.2f;
                this.motionY = 0.4f;
            }
        } else {
            super.attackEntity(entity, f);
        }
    }

    @Override
    public int getDropItemId() {
        return Item.silk.itemID;
    }

    @Override
    public void dropFewItems(boolean bl, int n) {
        super.dropFewItems(bl, n);
        if (bl && (this.rand.nextInt(3) == 0 || this.rand.nextInt(1 + n) > 0)) {
            this.dropItem(Item.spiderEye.itemID, 1);
        }
    }

    @Override
    public boolean isOnLadder() {
        return this.isBesideClimbableBlock();
    }

    @Override
    public void setInWeb() {
    }

    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute._c;
    }

    @Override
    public boolean isPotionApplicable(PotionEffect potionEffect) {
        if (potionEffect._a() == Potion._u._H) {
            return false;
        }
        return super.isPotionApplicable(potionEffect);
    }

    public boolean isBesideClimbableBlock() {
        return (this.dataWatcher._a(16) & 1) != 0;
    }

    public void setBesideClimbableBlock(boolean bl) {
        byte by = this.dataWatcher._a(16);
        by = bl ? (byte)(by | 1) : (byte)(by & 0xFFFFFFFE);
        this.dataWatcher._b(16, by);
    }

    @Override
    public EntityLivingData onSpawnWithEgg(EntityLivingData entityLivingData) {
        int n;
        entityLivingData = super.onSpawnWithEgg(entityLivingData);
        if (this.worldObj.rand.nextInt(100) == 0) {
            EntitySkeleton entitySkeleton = new EntitySkeleton(this.worldObj);
            entitySkeleton.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
            entitySkeleton.onSpawnWithEgg(null);
            this.worldObj.spawnEntityInWorld(entitySkeleton);
            entitySkeleton.mountEntity(this);
        }
        if (entityLivingData == null) {
            entityLivingData = new dwan();
            if (this.worldObj.difficultySetting > 2 && this.worldObj.rand.nextFloat() < 0.1f * this.worldObj.getLocationTensionFactor(this.posX, this.posY, this.posZ)) {
                ((dwan)entityLivingData)._a(this.worldObj.rand);
            }
        }
        if (entityLivingData instanceof dwan && (n = ((dwan)entityLivingData)._a) > 0 && Potion._a[n] != null) {
            this.addPotionEffect(new PotionEffect(n, Integer.MAX_VALUE));
        }
        return entityLivingData;
    }
}

