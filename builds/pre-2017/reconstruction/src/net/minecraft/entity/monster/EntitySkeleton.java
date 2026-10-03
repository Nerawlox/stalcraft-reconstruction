/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.monster;

import java.util.Calendar;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.ezfa;
import net.minecraft.entity.ai.iurn;
import net.minecraft.entity.ai.iurq;
import net.minecraft.entity.ai.pibk;
import net.minecraft.entity.ai.pidb;
import net.minecraft.entity.ai.tdpx;
import net.minecraft.entity.ai.turb;
import net.minecraft.entity.ai.vjta;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.sajz;
import net.minecraft.entity.tdmn;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderHell;

public class EntitySkeleton
extends EntityMob
implements tdmn {
    public EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack(this, 1.0, 20, 60, 15.0f);
    public pidb aiAttackOnCollide = new pidb(this, EntityPlayer.class, 1.2, false);

    public EntitySkeleton(World world) {
        super(world);
        this.tasks._a(1, new tdpx(this));
        this.tasks._a(2, new turb(this));
        this.tasks._a(3, new vjta(this, 1.0));
        this.tasks._a(5, new iurn(this, 1.0));
        this.tasks._a(6, new iurq(this, EntityPlayer.class, 8.0f));
        this.tasks._a(6, new net.minecraft.entity.ai.tdmn(this));
        this.targetTasks._a(1, new ezfa(this, false));
        this.targetTasks._a(2, new pibk(this, EntityPlayer.class, 0, true));
        if (world != null && !world.isRemote) {
            this.setCombatTask();
        }
    }

    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(sajz._d)._a(0.25);
    }

    @Override
    public void entityInit() {
        super.entityInit();
        this.dataWatcher._a(13, new Byte(0));
    }

    @Override
    public boolean isAIEnabled() {
        return true;
    }

    @Override
    public String getLivingSound() {
        return "mob.skeleton.say";
    }

    @Override
    public String getHurtSound() {
        return "mob.skeleton.hurt";
    }

    @Override
    public String getDeathSound() {
        return "mob.skeleton.death";
    }

    @Override
    public void playStepSound(int n, int n2, int n3, int n4) {
        this.playSound("mob.skeleton.step", 0.15f, 1.0f);
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        if (super.attackEntityAsMob(entity)) {
            if (this.getSkeletonType() == 1 && entity instanceof EntityLivingBase) {
                ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion._v._H, 200));
            }
            return true;
        }
        return false;
    }

    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute._b;
    }

    @Override
    public void onLivingUpdate() {
        float f;
        if (this.worldObj.isDaytime() && !this.worldObj.isRemote && (f = this.getBrightness(1.0f)) > 0.5f && this.rand.nextFloat() * 30.0f < (f - 0.4f) * 2.0f && this.worldObj.canBlockSeeTheSky(sajh._c(this.posX), sajh._c(this.posY), sajh._c(this.posZ))) {
            boolean bl = true;
            ItemStack itemStack = this.func_71124_b(4);
            if (itemStack != null) {
                if (itemStack._f()) {
                    itemStack._b(itemStack._i() + this.rand.nextInt(2));
                    if (itemStack._i() >= itemStack._k()) {
                        this.renderBrokenItemStack(itemStack);
                        this.setCurrentItemOrArmor(4, null);
                    }
                }
                bl = false;
            }
            if (bl) {
                this.setFire(8);
            }
        }
        if (this.worldObj.isRemote && this.getSkeletonType() == 1) {
            this.setSize(0.72f, 2.34f);
        }
        super.onLivingUpdate();
    }

    @Override
    public void updateRidden() {
        super.updateRidden();
        if (this.ridingEntity instanceof EntityCreature) {
            EntityCreature entityCreature = (EntityCreature)this.ridingEntity;
            this.renderYawOffset = entityCreature.renderYawOffset;
        }
    }

    @Override
    public void onDeath(DamageSource damageSource) {
        super.onDeath(damageSource);
        if (damageSource.getSourceOfDamage() instanceof EntityArrow && damageSource.getEntity() instanceof EntityPlayer) {
            EntityPlayer entityPlayer = (EntityPlayer)damageSource.getEntity();
            double d = entityPlayer.posX - this.posX;
            double d2 = entityPlayer.posZ - this.posZ;
            if (d * d + d2 * d2 >= 2500.0) {
                entityPlayer.triggerAchievement(AchievementList._v);
            }
        }
    }

    @Override
    public int getDropItemId() {
        return Item.arrow.itemID;
    }

    @Override
    public void dropFewItems(boolean bl, int n) {
        int n2;
        int n3;
        if (this.getSkeletonType() == 1) {
            n3 = this.rand.nextInt(3 + n) - 1;
            for (n2 = 0; n2 < n3; ++n2) {
                this.dropItem(Item.coal.itemID, 1);
            }
        } else {
            n3 = this.rand.nextInt(3 + n);
            for (n2 = 0; n2 < n3; ++n2) {
                this.dropItem(Item.arrow.itemID, 1);
            }
        }
        n3 = this.rand.nextInt(3 + n);
        for (n2 = 0; n2 < n3; ++n2) {
            this.dropItem(Item.bone.itemID, 1);
        }
    }

    @Override
    public void dropRareDrop(int n) {
        if (this.getSkeletonType() == 1) {
            this.entityDropItem(new ItemStack(Item.skull.itemID, 1, 1), 0.0f);
        }
    }

    @Override
    public void addRandomArmor() {
        super.addRandomArmor();
        this.setCurrentItemOrArmor(0, new ItemStack(Item.bow));
    }

    @Override
    public EntityLivingData onSpawnWithEgg(EntityLivingData entityLivingData) {
        Calendar calendar;
        entityLivingData = super.onSpawnWithEgg(entityLivingData);
        if (this.worldObj.provider instanceof WorldProviderHell && this.getRNG().nextInt(5) > 0) {
            this.tasks._a(4, this.aiAttackOnCollide);
            this.setSkeletonType(1);
            this.setCurrentItemOrArmor(0, new ItemStack(Item.swordStone));
            this.getEntityAttribute(sajz._e)._a(4.0);
        } else {
            this.tasks._a(4, this.aiArrowAttack);
            this.addRandomArmor();
            this.enchantEquipment();
        }
        this.setCanPickUpLoot(this.rand.nextFloat() < 0.55f * this.worldObj.getLocationTensionFactor(this.posX, this.posY, this.posZ));
        if (this.func_71124_b(4) == null && (calendar = this.worldObj.getCurrentDate()).get(2) + 1 == 10 && calendar.get(5) == 31 && this.rand.nextFloat() < 0.25f) {
            this.setCurrentItemOrArmor(4, new ItemStack(this.rand.nextFloat() < 0.1f ? Block.pumpkinLantern : Block.pumpkin));
            this.equipmentDropChances[4] = 0.0f;
        }
        return entityLivingData;
    }

    public void setCombatTask() {
        this.tasks._a(this.aiAttackOnCollide);
        this.tasks._a(this.aiArrowAttack);
        ItemStack itemStack = this.getHeldItem();
        if (itemStack != null && itemStack._d == Item.bow.itemID) {
            this.tasks._a(4, this.aiArrowAttack);
        } else {
            this.tasks._a(4, this.aiAttackOnCollide);
        }
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase entityLivingBase, float f) {
        EntityArrow entityArrow = new EntityArrow(this.worldObj, this, entityLivingBase, 1.6f, 14 - this.worldObj.difficultySetting * 4);
        int n = zhty._a(Enchantment._u._y, this.getHeldItem());
        int n2 = zhty._a(Enchantment._v._y, this.getHeldItem());
        entityArrow.setDamage((double)(f * 2.0f) + (this.rand.nextGaussian() * 0.25 + (double)((float)this.worldObj.difficultySetting * 0.11f)));
        if (n > 0) {
            entityArrow.setDamage(entityArrow.getDamage() + (double)n * 0.5 + 0.5);
        }
        if (n2 > 0) {
            entityArrow.setKnockbackStrength(n2);
        }
        if (zhty._a(Enchantment._w._y, this.getHeldItem()) > 0 || this.getSkeletonType() == 1) {
            entityArrow.setFire(100);
        }
        this.playSound("random.bow", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
        this.worldObj.spawnEntityInWorld(entityArrow);
    }

    public int getSkeletonType() {
        return this.dataWatcher._a(13);
    }

    public void setSkeletonType(int n) {
        this.dataWatcher._b(13, (byte)n);
        boolean bl = this.isImmuneToFire = n == 1;
        if (n == 1) {
            this.setSize(0.72f, 2.34f);
        } else {
            this.setSize(0.6f, 1.8f);
        }
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
        if (nBTTagCompound._c("SkeletonType")) {
            byte by = nBTTagCompound._d("SkeletonType");
            this.setSkeletonType(by);
        }
        this.setCombatTask();
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
        nBTTagCompound._a("SkeletonType", (byte)this.getSkeletonType());
    }

    @Override
    public void setCurrentItemOrArmor(int n, ItemStack itemStack) {
        super.setCurrentItemOrArmor(n, itemStack);
        if (!this.worldObj.isRemote && n == 0) {
            this.setCombatTask();
        }
    }

    @Override
    public double getYOffset() {
        return super.getYOffset() - 0.5;
    }
}

