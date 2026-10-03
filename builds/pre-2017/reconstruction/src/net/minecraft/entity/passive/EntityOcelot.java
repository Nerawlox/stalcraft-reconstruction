/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.passive;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.amww;
import net.minecraft.entity.ai.eifc;
import net.minecraft.entity.ai.ezhm;
import net.minecraft.entity.ai.iurn;
import net.minecraft.entity.ai.iurq;
import net.minecraft.entity.ai.srli;
import net.minecraft.entity.ai.tdpx;
import net.minecraft.entity.ai.ugqi;
import net.minecraft.entity.ai.ybzs;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class EntityOcelot
extends EntityTameable {
    public ezhm aiTempt;

    public EntityOcelot(World world) {
        super(world);
        this.setSize(0.6f, 0.8f);
        this.getNavigator()._a(true);
        this.tasks._a(1, new tdpx(this));
        this.tasks._a(2, this.aiSit);
        this.aiTempt = new ezhm(this, 0.6, Item.fishRaw.itemID, true);
        this.tasks._a(3, this.aiTempt);
        this.tasks._a(4, new EntityAIAvoidEntity(this, EntityPlayer.class, 16.0f, 0.8, 1.33));
        this.tasks._a(5, new ugqi(this, 1.0, 10.0f, 5.0f));
        this.tasks._a(6, new ybzs(this, 1.33));
        this.tasks._a(7, new amww(this, 0.3f));
        this.tasks._a(8, new net.minecraft.entity.ai.sajh(this));
        this.tasks._a(9, new srli(this, 0.8));
        this.tasks._a(10, new iurn(this, 0.8));
        this.tasks._a(11, new iurq(this, EntityPlayer.class, 10.0f));
        this.targetTasks._a(1, new eifc(this, EntityChicken.class, 750, false));
    }

    @Override
    public void entityInit() {
        super.entityInit();
        this.dataWatcher._a(18, (Object)0);
    }

    @Override
    public void updateAITick() {
        if (this.getMoveHelper()._a()) {
            double d = this.getMoveHelper()._b();
            if (d == 0.6) {
                this.setSneaking(true);
                this.setSprinting(false);
            } else if (d == 1.33) {
                this.setSneaking(false);
                this.setSprinting(true);
            } else {
                this.setSneaking(false);
                this.setSprinting(false);
            }
        } else {
            this.setSneaking(false);
            this.setSprinting(false);
        }
    }

    @Override
    public boolean canDespawn() {
        return !this.isTamed() && this.ticksExisted > 2400;
    }

    @Override
    public boolean isAIEnabled() {
        return true;
    }

    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(sajz._a)._a(10.0);
        this.getEntityAttribute(sajz._d)._a(0.3f);
    }

    @Override
    public void fall(float f) {
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
        nBTTagCompound._a("CatType", this.getTameSkin());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
        this.setTameSkin(nBTTagCompound._f("CatType"));
    }

    @Override
    public String getLivingSound() {
        return this.isTamed() ? (this.isInLove() ? "mob.cat.purr" : (this.rand.nextInt(4) == 0 ? "mob.cat.purreow" : "mob.cat.meow")) : "";
    }

    @Override
    public String getHurtSound() {
        return "mob.cat.hitt";
    }

    @Override
    public String getDeathSound() {
        return "mob.cat.hitt";
    }

    @Override
    public float getSoundVolume() {
        return 0.4f;
    }

    @Override
    public int getDropItemId() {
        return Item.leather.itemID;
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        return entity.attackEntityFrom(DamageSource.causeMobDamage(this), 3.0f);
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        if (this.isEntityInvulnerable()) {
            return false;
        }
        this.aiSit._a(false);
        return super.attackEntityFrom(damageSource, f);
    }

    @Override
    public void dropFewItems(boolean bl, int n) {
    }

    @Override
    public boolean interact(EntityPlayer entityPlayer) {
        ItemStack itemStack = entityPlayer.inventory._a();
        if (this.isTamed()) {
            if (entityPlayer.getCommandSenderName().equalsIgnoreCase(this.getOwnerName()) && !this.worldObj.isRemote && !this.isBreedingItem(itemStack)) {
                this.aiSit._a(!this.isSitting());
            }
        } else if (this.aiTempt._a() && itemStack != null && itemStack._d == Item.fishRaw.itemID && entityPlayer.getDistanceSqToEntity(this) < 9.0) {
            if (!entityPlayer.capabilities._d) {
                --itemStack._b;
            }
            if (itemStack._b <= 0) {
                entityPlayer.inventory.setInventorySlotContents(entityPlayer.inventory._c, null);
            }
            if (!this.worldObj.isRemote) {
                if (this.rand.nextInt(3) == 0) {
                    this.setTamed(true);
                    this.setTameSkin(1 + this.worldObj.rand.nextInt(3));
                    this.setOwner(entityPlayer.getCommandSenderName());
                    this.playTameEffect(true);
                    this.aiSit._a(true);
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

    public EntityOcelot spawnBabyAnimal(EntityAgeable entityAgeable) {
        EntityOcelot entityOcelot = new EntityOcelot(this.worldObj);
        if (this.isTamed()) {
            entityOcelot.setOwner(this.getOwnerName());
            entityOcelot.setTamed(true);
            entityOcelot.setTameSkin(this.getTameSkin());
        }
        return entityOcelot;
    }

    @Override
    public boolean isBreedingItem(ItemStack itemStack) {
        return itemStack != null && itemStack._d == Item.fishRaw.itemID;
    }

    @Override
    public boolean canMateWith(EntityAnimal entityAnimal) {
        if (entityAnimal == this) {
            return false;
        }
        if (!this.isTamed()) {
            return false;
        }
        if (!(entityAnimal instanceof EntityOcelot)) {
            return false;
        }
        EntityOcelot entityOcelot = (EntityOcelot)entityAnimal;
        return !entityOcelot.isTamed() ? false : this.isInLove() && entityOcelot.isInLove();
    }

    public int getTameSkin() {
        return this.dataWatcher._a(18);
    }

    public void setTameSkin(int n) {
        this.dataWatcher._b(18, (byte)n);
    }

    @Override
    public boolean getCanSpawnHere() {
        if (this.worldObj.rand.nextInt(3) == 0) {
            return false;
        }
        if (this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox)) {
            int n = sajh._c(this.posX);
            int n2 = sajh._c(this.boundingBox._c);
            int n3 = sajh._c(this.posZ);
            if (n2 < 63) {
                return false;
            }
            int n4 = this.worldObj.getBlockId(n, n2 - 1, n3);
            Block block = Block.blocksList[n4];
            if (n4 == Block.grass.blockID || block != null && block.isLeaves(this.worldObj, n, n2 - 1, n3)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getEntityName() {
        return this.hasCustomNameTag() ? this.getCustomNameTag() : (this.isTamed() ? "entity.Cat.name" : super.getEntityName());
    }

    @Override
    public EntityLivingData onSpawnWithEgg(EntityLivingData entityLivingData) {
        entityLivingData = super.onSpawnWithEgg(entityLivingData);
        if (this.worldObj.rand.nextInt(7) == 0) {
            for (int i = 0; i < 2; ++i) {
                EntityOcelot entityOcelot = new EntityOcelot(this.worldObj);
                entityOcelot.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                entityOcelot.setGrowingAge(-24000);
                this.worldObj.spawnEntityInWorld(entityOcelot);
            }
        }
        return entityLivingData;
    }

    @Override
    public EntityAgeable createChild(EntityAgeable entityAgeable) {
        return this.spawnBabyAnimal(entityAgeable);
    }
}

