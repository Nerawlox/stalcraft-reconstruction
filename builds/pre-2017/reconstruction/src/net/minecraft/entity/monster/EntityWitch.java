/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.monster;

import java.util.List;
import java.util.UUID;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.ezfa;
import net.minecraft.entity.ai.iurn;
import net.minecraft.entity.ai.iurq;
import net.minecraft.entity.ai.pibk;
import net.minecraft.entity.ai.tdpx;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.sajz;
import net.minecraft.entity.tdmn;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class EntityWitch
extends EntityMob
implements tdmn {
    public static final UUID field_110184_bp = UUID.fromString("5CD17E52-A79A-43D3-A529-90FDE04B181E");
    public static final AttributeModifier field_110185_bq = new AttributeModifier(field_110184_bp, "Drinking speed penalty", -0.25, 0)._a(false);
    public static final int[] witchDrops = new int[]{Item.glowstone.itemID, Item.sugar.itemID, Item.redstone.itemID, Item.spiderEye.itemID, Item.glassBottle.itemID, Item.gunpowder.itemID, Item.stick.itemID, Item.stick.itemID};
    public int witchAttackTimer;

    public EntityWitch(World world) {
        super(world);
        this.tasks._a(1, new tdpx(this));
        this.tasks._a(2, new EntityAIArrowAttack(this, 1.0, 60, 10.0f));
        this.tasks._a(2, new iurn(this, 1.0));
        this.tasks._a(3, new iurq(this, EntityPlayer.class, 8.0f));
        this.tasks._a(3, new net.minecraft.entity.ai.tdmn(this));
        this.targetTasks._a(1, new ezfa(this, false));
        this.targetTasks._a(2, new pibk(this, EntityPlayer.class, 0, true));
    }

    @Override
    public void entityInit() {
        super.entityInit();
        this.getDataWatcher()._a(21, (Object)0);
    }

    @Override
    public String getLivingSound() {
        return "mob.witch.idle";
    }

    @Override
    public String getHurtSound() {
        return "mob.witch.hurt";
    }

    @Override
    public String getDeathSound() {
        return "mob.witch.death";
    }

    public void setAggressive(boolean bl) {
        this.getDataWatcher()._b(21, bl ? (byte)1 : 0);
    }

    public boolean getAggressive() {
        return this.getDataWatcher()._a(21) == 1;
    }

    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(sajz._a)._a(26.0);
        this.getEntityAttribute(sajz._d)._a(0.25);
    }

    @Override
    public boolean isAIEnabled() {
        return true;
    }

    @Override
    public void onLivingUpdate() {
        if (!this.worldObj.isRemote) {
            if (this.getAggressive()) {
                if (this.witchAttackTimer-- <= 0) {
                    List list2;
                    this.setAggressive(false);
                    ItemStack itemStack = this.getHeldItem();
                    this.setCurrentItemOrArmor(0, null);
                    if (itemStack != null && itemStack._d == Item.potion.itemID && (list2 = Item.potion._a(itemStack)) != null) {
                        for (PotionEffect potionEffect : list2) {
                            this.addPotionEffect(new PotionEffect(potionEffect));
                        }
                    }
                    this.getEntityAttribute(sajz._d)._b(field_110185_bq);
                }
            } else {
                int n = -1;
                if (this.rand.nextFloat() < 0.15f && this.isBurning() && !this.isPotionActive(Potion._n)) {
                    n = 16307;
                } else if (this.rand.nextFloat() < 0.05f && this.getHealth() < this.getMaxHealth()) {
                    n = 16341;
                } else if (this.rand.nextFloat() < 0.25f && this.getAttackTarget() != null && !this.isPotionActive(Potion._c) && this.getAttackTarget().getDistanceSqToEntity(this) > 121.0) {
                    n = 16274;
                } else if (this.rand.nextFloat() < 0.25f && this.getAttackTarget() != null && !this.isPotionActive(Potion._c) && this.getAttackTarget().getDistanceSqToEntity(this) > 121.0) {
                    n = 16274;
                }
                if (n > -1) {
                    this.setCurrentItemOrArmor(0, new ItemStack(Item.potion, 1, n));
                    this.witchAttackTimer = this.getHeldItem()._n();
                    this.setAggressive(true);
                    hubf hubf2 = this.getEntityAttribute(sajz._d);
                    hubf2._b(field_110185_bq);
                    hubf2._a(field_110185_bq);
                }
            }
            if (this.rand.nextFloat() < 7.5E-4f) {
                this.worldObj.setEntityState(this, (byte)15);
            }
        }
        super.onLivingUpdate();
    }

    @Override
    public void handleHealthUpdate(byte by) {
        if (by == 15) {
            for (int i = 0; i < this.rand.nextInt(35) + 10; ++i) {
                this.worldObj.spawnParticle("witchMagic", this.posX + this.rand.nextGaussian() * (double)0.13f, this.boundingBox._f + 0.5 + this.rand.nextGaussian() * (double)0.13f, this.posZ + this.rand.nextGaussian() * (double)0.13f, 0.0, 0.0, 0.0);
            }
        } else {
            super.handleHealthUpdate(by);
        }
    }

    @Override
    public float applyPotionDamageCalculations(DamageSource damageSource, float f) {
        f = super.applyPotionDamageCalculations(damageSource, f);
        if (damageSource.getEntity() == this) {
            f = 0.0f;
        }
        if (damageSource.isMagicDamage()) {
            f = (float)((double)f * 0.15);
        }
        return f;
    }

    @Override
    public void dropFewItems(boolean bl, int n) {
        int n2 = this.rand.nextInt(3) + 1;
        for (int i = 0; i < n2; ++i) {
            int n3 = this.rand.nextInt(3);
            int n4 = witchDrops[this.rand.nextInt(witchDrops.length)];
            if (n > 0) {
                n3 += this.rand.nextInt(n + 1);
            }
            for (int j = 0; j < n3; ++j) {
                this.dropItem(n4, 1);
            }
        }
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase entityLivingBase, float f) {
        if (this.getAggressive()) {
            return;
        }
        EntityPotion entityPotion = new EntityPotion(this.worldObj, (EntityLivingBase)this, 32732);
        entityPotion.rotationPitch -= -20.0f;
        double d = entityLivingBase.posX + entityLivingBase.motionX - this.posX;
        double d2 = entityLivingBase.posY + (double)entityLivingBase.getEyeHeight() - (double)1.1f - this.posY;
        double d3 = entityLivingBase.posZ + entityLivingBase.motionZ - this.posZ;
        float f2 = sajh._a(d * d + d3 * d3);
        if (f2 >= 8.0f && !entityLivingBase.isPotionActive(Potion._d)) {
            entityPotion.setPotionDamage(32698);
        } else if (entityLivingBase.getHealth() >= 8.0f && !entityLivingBase.isPotionActive(Potion._u)) {
            entityPotion.setPotionDamage(32660);
        } else if (f2 <= 3.0f && !entityLivingBase.isPotionActive(Potion._t) && this.rand.nextFloat() < 0.25f) {
            entityPotion.setPotionDamage(32696);
        }
        entityPotion.setThrowableHeading(d, d2 + (double)(f2 * 0.2f), d3, 0.75f, 8.0f);
        this.worldObj.spawnEntityInWorld(entityPotion);
    }
}

