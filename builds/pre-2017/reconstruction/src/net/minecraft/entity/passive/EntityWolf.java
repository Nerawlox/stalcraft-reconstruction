/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.passive;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.amww;
import net.minecraft.entity.ai.eifc;
import net.minecraft.entity.ai.ezfa;
import net.minecraft.entity.ai.iurn;
import net.minecraft.entity.ai.iurq;
import net.minecraft.entity.ai.pidb;
import net.minecraft.entity.ai.pzde;
import net.minecraft.entity.ai.srli;
import net.minecraft.entity.ai.tdmn;
import net.minecraft.entity.ai.tdpx;
import net.minecraft.entity.ai.ugqi;
import net.minecraft.entity.ai.wmvj;
import net.minecraft.entity.ai.zwaw;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.sajz;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class EntityWolf
extends EntityTameable {
    public float field_70926_e;
    public float field_70924_f;
    public boolean isShaking;
    public boolean field_70928_h;
    public float timeWolfIsShaking;
    public float prevTimeWolfIsShaking;

    public EntityWolf(World world) {
        super(world);
        this.setSize(0.6f, 0.8f);
        this.getNavigator()._a(true);
        this.tasks._a(1, new tdpx(this));
        this.tasks._a(2, this.aiSit);
        this.tasks._a(3, new amww(this, 0.4f));
        this.tasks._a(4, new pidb(this, 1.0, true));
        this.tasks._a(5, new ugqi(this, 1.0, 10.0f, 2.0f));
        this.tasks._a(6, new srli(this, 1.0));
        this.tasks._a(7, new iurn(this, 1.0));
        this.tasks._a(8, new zwaw(this, 8.0f));
        this.tasks._a(9, new iurq(this, EntityPlayer.class, 8.0f));
        this.tasks._a(9, new tdmn(this));
        this.targetTasks._a(1, new wmvj(this));
        this.targetTasks._a(2, new pzde(this));
        this.targetTasks._a(3, new ezfa(this, true));
        this.targetTasks._a(4, new eifc(this, EntitySheep.class, 200, false));
        this.setTamed(false);
    }

    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(sajz._d)._a(0.3f);
        if (this.isTamed()) {
            this.getEntityAttribute(sajz._a)._a(20.0);
        } else {
            this.getEntityAttribute(sajz._a)._a(8.0);
        }
    }

    @Override
    public boolean isAIEnabled() {
        return true;
    }

    @Override
    public void setAttackTarget(EntityLivingBase entityLivingBase) {
        super.setAttackTarget(entityLivingBase);
        if (entityLivingBase == null) {
            this.setAngry(false);
        } else if (!this.isTamed()) {
            this.setAngry(true);
        }
    }

    @Override
    public void updateAITick() {
        this.dataWatcher._b(18, Float.valueOf(this.getHealth()));
    }

    @Override
    public void entityInit() {
        super.entityInit();
        this.dataWatcher._a(18, new Float(this.getHealth()));
        this.dataWatcher._a(19, new Byte(0));
        this.dataWatcher._a(20, new Byte((byte)uziv._a(1)));
    }

    @Override
    public void playStepSound(int n, int n2, int n3, int n4) {
        this.playSound("mob.wolf.step", 0.15f, 1.0f);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
        nBTTagCompound._a("Angry", this.isAngry());
        nBTTagCompound._a("CollarColor", (byte)this.getCollarColor());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
        this.setAngry(nBTTagCompound._o("Angry"));
        if (nBTTagCompound._c("CollarColor")) {
            this.setCollarColor(nBTTagCompound._d("CollarColor"));
        }
    }

    @Override
    public String getLivingSound() {
        if (this.isAngry()) {
            return "mob.wolf.growl";
        }
        if (this.rand.nextInt(3) == 0) {
            if (this.isTamed() && this.dataWatcher._d(18) < 10.0f) {
                return "mob.wolf.whine";
            }
            return "mob.wolf.panting";
        }
        return "mob.wolf.bark";
    }

    @Override
    public String getHurtSound() {
        return "mob.wolf.hurt";
    }

    @Override
    public String getDeathSound() {
        return "mob.wolf.death";
    }

    @Override
    public float getSoundVolume() {
        return 0.4f;
    }

    @Override
    public int getDropItemId() {
        return -1;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (!this.worldObj.isRemote && this.isShaking && !this.field_70928_h && !this.hasPath() && this.onGround) {
            this.field_70928_h = true;
            this.timeWolfIsShaking = 0.0f;
            this.prevTimeWolfIsShaking = 0.0f;
            this.worldObj.setEntityState(this, (byte)8);
        }
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        this.field_70924_f = this.field_70926_e;
        this.field_70926_e = this.func_70922_bv() ? (this.field_70926_e += (1.0f - this.field_70926_e) * 0.4f) : (this.field_70926_e += (0.0f - this.field_70926_e) * 0.4f);
        if (this.func_70922_bv()) {
            this.numTicksToChaseTarget = 10;
        }
        if (this.isWet()) {
            this.isShaking = true;
            this.field_70928_h = false;
            this.timeWolfIsShaking = 0.0f;
            this.prevTimeWolfIsShaking = 0.0f;
        } else if ((this.isShaking || this.field_70928_h) && this.field_70928_h) {
            if (this.timeWolfIsShaking == 0.0f) {
                this.playSound("mob.wolf.shake", this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
            }
            this.prevTimeWolfIsShaking = this.timeWolfIsShaking;
            this.timeWolfIsShaking += 0.05f;
            if (this.prevTimeWolfIsShaking >= 2.0f) {
                this.isShaking = false;
                this.field_70928_h = false;
                this.prevTimeWolfIsShaking = 0.0f;
                this.timeWolfIsShaking = 0.0f;
            }
            if (this.timeWolfIsShaking > 0.4f) {
                float f = (float)this.boundingBox._c;
                int n = (int)(sajh._a((this.timeWolfIsShaking - 0.4f) * (float)Math.PI) * 7.0f);
                for (int i = 0; i < n; ++i) {
                    float f2 = (this.rand.nextFloat() * 2.0f - 1.0f) * this.width * 0.5f;
                    float f3 = (this.rand.nextFloat() * 2.0f - 1.0f) * this.width * 0.5f;
                    this.worldObj.spawnParticle("splash", this.posX + (double)f2, f + 0.8f, this.posZ + (double)f3, this.motionX, this.motionY, this.motionZ);
                }
            }
        }
    }

    public boolean getWolfShaking() {
        return this.isShaking;
    }

    public float getShadingWhileShaking(float f) {
        return 0.75f + (this.prevTimeWolfIsShaking + (this.timeWolfIsShaking - this.prevTimeWolfIsShaking) * f) / 2.0f * 0.25f;
    }

    public float getShakeAngle(float f, float f2) {
        float f3 = (this.prevTimeWolfIsShaking + (this.timeWolfIsShaking - this.prevTimeWolfIsShaking) * f + f2) / 1.8f;
        if (f3 < 0.0f) {
            f3 = 0.0f;
        } else if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        return sajh._a(f3 * (float)Math.PI) * sajh._a(f3 * (float)Math.PI * 11.0f) * 0.15f * (float)Math.PI;
    }

    public float getInterestedAngle(float f) {
        return (this.field_70924_f + (this.field_70926_e - this.field_70924_f) * f) * 0.15f * (float)Math.PI;
    }

    @Override
    public float getEyeHeight() {
        return this.height * 0.8f;
    }

    @Override
    public int getVerticalFaceSpeed() {
        if (this.isSitting()) {
            return 20;
        }
        return super.getVerticalFaceSpeed();
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        if (this.isEntityInvulnerable()) {
            return false;
        }
        Entity entity = damageSource.getEntity();
        this.aiSit._a(false);
        if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow)) {
            f = (f + 1.0f) / 2.0f;
        }
        return super.attackEntityFrom(damageSource, f);
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        int n = this.isTamed() ? 4 : 2;
        return entity.attackEntityFrom(DamageSource.causeMobDamage(this), n);
    }

    @Override
    public void setTamed(boolean bl) {
        super.setTamed(bl);
        if (bl) {
            this.getEntityAttribute(sajz._a)._a(20.0);
        } else {
            this.getEntityAttribute(sajz._a)._a(8.0);
        }
    }

    @Override
    public boolean interact(EntityPlayer entityPlayer) {
        ItemStack itemStack = entityPlayer.inventory._a();
        if (this.isTamed()) {
            if (itemStack != null) {
                int n;
                if (Item.itemsList[itemStack._d] instanceof ItemFood) {
                    ItemFood itemFood = (ItemFood)Item.itemsList[itemStack._d];
                    if (itemFood.isWolfsFavoriteMeat() && this.dataWatcher._d(18) < 20.0f) {
                        if (!entityPlayer.capabilities._d) {
                            --itemStack._b;
                        }
                        this.heal(itemFood.getHealAmount());
                        if (itemStack._b <= 0) {
                            entityPlayer.inventory.setInventorySlotContents(entityPlayer.inventory._c, null);
                        }
                        return true;
                    }
                } else if (itemStack._d == Item.dyePowder.itemID && (n = uziv._a(itemStack._j())) != this.getCollarColor()) {
                    this.setCollarColor(n);
                    if (!entityPlayer.capabilities._d && --itemStack._b <= 0) {
                        entityPlayer.inventory.setInventorySlotContents(entityPlayer.inventory._c, null);
                    }
                    return true;
                }
            }
            if (entityPlayer.getCommandSenderName().equalsIgnoreCase(this.getOwnerName()) && !this.worldObj.isRemote && !this.isBreedingItem(itemStack)) {
                this.aiSit._a(!this.isSitting());
                this.isJumping = false;
                this.setPathToEntity(null);
                this.setTarget(null);
                this.setAttackTarget(null);
            }
        } else if (itemStack != null && itemStack._d == Item.bone.itemID && !this.isAngry()) {
            if (!entityPlayer.capabilities._d) {
                --itemStack._b;
            }
            if (itemStack._b <= 0) {
                entityPlayer.inventory.setInventorySlotContents(entityPlayer.inventory._c, null);
            }
            if (!this.worldObj.isRemote) {
                if (this.rand.nextInt(3) == 0) {
                    this.setTamed(true);
                    this.setPathToEntity(null);
                    this.setAttackTarget(null);
                    this.aiSit._a(true);
                    this.setHealth(20.0f);
                    this.setOwner(entityPlayer.getCommandSenderName());
                    this.playTameEffect(true);
                    this.worldObj.setEntityState(this, (byte)7);
                } else {
                    this.playTameEffect(false);
                    this.worldObj.setEntityState(this, (byte)6);
                }
            }
            return true;
        }
        return super.interact(entityPlayer);
    }

    @Override
    public void handleHealthUpdate(byte by) {
        if (by == 8) {
            this.field_70928_h = true;
            this.timeWolfIsShaking = 0.0f;
            this.prevTimeWolfIsShaking = 0.0f;
        } else {
            super.handleHealthUpdate(by);
        }
    }

    public float getTailRotation() {
        if (this.isAngry()) {
            return 1.5393804f;
        }
        if (this.isTamed()) {
            return (0.55f - (20.0f - this.dataWatcher._d(18)) * 0.02f) * (float)Math.PI;
        }
        return 0.62831855f;
    }

    @Override
    public boolean isBreedingItem(ItemStack itemStack) {
        if (itemStack == null) {
            return false;
        }
        if (!(Item.itemsList[itemStack._d] instanceof ItemFood)) {
            return false;
        }
        return ((ItemFood)Item.itemsList[itemStack._d]).isWolfsFavoriteMeat();
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 8;
    }

    public boolean isAngry() {
        return (this.dataWatcher._a(16) & 2) != 0;
    }

    public void setAngry(boolean bl) {
        byte by = this.dataWatcher._a(16);
        if (bl) {
            this.dataWatcher._b(16, (byte)(by | 2));
        } else {
            this.dataWatcher._b(16, (byte)(by & 0xFFFFFFFD));
        }
    }

    public int getCollarColor() {
        return this.dataWatcher._a(20) & 0xF;
    }

    public void setCollarColor(int n) {
        this.dataWatcher._b(20, (byte)(n & 0xF));
    }

    public EntityWolf spawnBabyAnimal(EntityAgeable entityAgeable) {
        EntityWolf entityWolf = new EntityWolf(this.worldObj);
        String string = this.getOwnerName();
        if (string != null && string.trim().length() > 0) {
            entityWolf.setOwner(string);
            entityWolf.setTamed(true);
        }
        return entityWolf;
    }

    public void func_70918_i(boolean bl) {
        if (bl) {
            this.dataWatcher._b(19, (byte)1);
        } else {
            this.dataWatcher._b(19, (byte)0);
        }
    }

    @Override
    public boolean canMateWith(EntityAnimal entityAnimal) {
        if (entityAnimal == this) {
            return false;
        }
        if (!this.isTamed()) {
            return false;
        }
        if (!(entityAnimal instanceof EntityWolf)) {
            return false;
        }
        EntityWolf entityWolf = (EntityWolf)entityAnimal;
        if (!entityWolf.isTamed()) {
            return false;
        }
        if (entityWolf.isSitting()) {
            return false;
        }
        return this.isInLove() && entityWolf.isInLove();
    }

    public boolean func_70922_bv() {
        return this.dataWatcher._a(19) == 1;
    }

    @Override
    public boolean canDespawn() {
        return !this.isTamed() && this.ticksExisted > 2400;
    }

    @Override
    public boolean func_142018_a(EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase2) {
        EntityWolf entityWolf;
        if (entityLivingBase instanceof EntityCreeper || entityLivingBase instanceof EntityGhast) {
            return false;
        }
        if (entityLivingBase instanceof EntityWolf && (entityWolf = (EntityWolf)entityLivingBase).isTamed() && entityWolf.func_130012_q() == entityLivingBase2) {
            return false;
        }
        if (entityLivingBase instanceof EntityPlayer && entityLivingBase2 instanceof EntityPlayer && !((EntityPlayer)entityLivingBase2).canAttackPlayer((EntityPlayer)entityLivingBase)) {
            return false;
        }
        return !(entityLivingBase instanceof EntityHorse) || !((EntityHorse)entityLivingBase).isTame();
    }

    @Override
    public /* synthetic */ EntityAgeable createChild(EntityAgeable entityAgeable) {
        return this.spawnBabyAnimal(entityAgeable);
    }
}

