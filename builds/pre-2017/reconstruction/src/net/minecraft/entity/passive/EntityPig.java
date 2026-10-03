/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.passive;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAIControlledByPlayer;
import net.minecraft.entity.ai.ezfc;
import net.minecraft.entity.ai.ezhm;
import net.minecraft.entity.ai.iurn;
import net.minecraft.entity.ai.iurq;
import net.minecraft.entity.ai.kjwj;
import net.minecraft.entity.ai.srli;
import net.minecraft.entity.ai.tdmn;
import net.minecraft.entity.ai.tdpx;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.AchievementList;
import net.minecraft.world.World;

public class EntityPig
extends EntityAnimal {
    public final EntityAIControlledByPlayer aiControlledByPlayer;

    public EntityPig(World world) {
        super(world);
        this.setSize(0.9f, 0.9f);
        this.getNavigator()._a(true);
        this.tasks._a(0, new tdpx(this));
        this.tasks._a(1, new kjwj(this, 1.25));
        this.aiControlledByPlayer = new EntityAIControlledByPlayer(this, 0.3f);
        this.tasks._a(2, this.aiControlledByPlayer);
        this.tasks._a(3, new srli(this, 1.0));
        this.tasks._a(4, new ezhm(this, 1.2, Item.carrotOnAStick.itemID, false));
        this.tasks._a(4, new ezhm(this, 1.2, Item.carrot.itemID, false));
        this.tasks._a(5, new ezfc(this, 1.1));
        this.tasks._a(6, new iurn(this, 1.0));
        this.tasks._a(7, new iurq(this, EntityPlayer.class, 6.0f));
        this.tasks._a(8, new tdmn(this));
    }

    @Override
    public boolean isAIEnabled() {
        return true;
    }

    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(sajz._a)._a(10.0);
        this.getEntityAttribute(sajz._d)._a(0.25);
    }

    @Override
    public void updateAITasks() {
        super.updateAITasks();
    }

    @Override
    public boolean canBeSteered() {
        ItemStack itemStack = ((EntityPlayer)this.riddenByEntity).getHeldItem();
        return itemStack != null && itemStack._d == Item.carrotOnAStick.itemID;
    }

    @Override
    public void entityInit() {
        super.entityInit();
        this.dataWatcher._a(16, (Object)0);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
        nBTTagCompound._a("Saddle", this.getSaddled());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
        this.setSaddled(nBTTagCompound._o("Saddle"));
    }

    @Override
    public String getLivingSound() {
        return "mob.pig.say";
    }

    @Override
    public String getHurtSound() {
        return "mob.pig.say";
    }

    @Override
    public String getDeathSound() {
        return "mob.pig.death";
    }

    @Override
    public void playStepSound(int n, int n2, int n3, int n4) {
        this.playSound("mob.pig.step", 0.15f, 1.0f);
    }

    @Override
    public boolean interact(EntityPlayer entityPlayer) {
        if (!super.interact(entityPlayer)) {
            if (this.getSaddled() && !this.worldObj.isRemote && (this.riddenByEntity == null || this.riddenByEntity == entityPlayer)) {
                entityPlayer.mountEntity(this);
                return true;
            }
            return false;
        }
        return true;
    }

    @Override
    public int getDropItemId() {
        if (this.isBurning()) {
            return Item.porkCooked.itemID;
        }
        return Item.porkRaw.itemID;
    }

    @Override
    public void dropFewItems(boolean bl, int n) {
        int n2 = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + n);
        for (int i = 0; i < n2; ++i) {
            if (this.isBurning()) {
                this.dropItem(Item.porkCooked.itemID, 1);
                continue;
            }
            this.dropItem(Item.porkRaw.itemID, 1);
        }
        if (this.getSaddled()) {
            this.dropItem(Item.saddle.itemID, 1);
        }
    }

    public boolean getSaddled() {
        return (this.dataWatcher._a(16) & 1) != 0;
    }

    public void setSaddled(boolean bl) {
        if (bl) {
            this.dataWatcher._b(16, (byte)1);
        } else {
            this.dataWatcher._b(16, (byte)0);
        }
    }

    @Override
    public void onStruckByLightning(EntityLightningBolt entityLightningBolt) {
        if (this.worldObj.isRemote) {
            return;
        }
        EntityPigZombie entityPigZombie = new EntityPigZombie(this.worldObj);
        entityPigZombie.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
        this.worldObj.spawnEntityInWorld(entityPigZombie);
        this.setDead();
    }

    @Override
    public void fall(float f) {
        super.fall(f);
        if (f > 5.0f && this.riddenByEntity instanceof EntityPlayer) {
            ((EntityPlayer)this.riddenByEntity).triggerAchievement(AchievementList._u);
        }
    }

    public EntityPig spawnBabyAnimal(EntityAgeable entityAgeable) {
        return new EntityPig(this.worldObj);
    }

    @Override
    public boolean isBreedingItem(ItemStack itemStack) {
        return itemStack != null && itemStack._d == Item.carrot.itemID;
    }

    public EntityAIControlledByPlayer getAIControlledByPlayer() {
        return this.aiControlledByPlayer;
    }

    @Override
    public /* synthetic */ EntityAgeable createChild(EntityAgeable entityAgeable) {
        return this.spawnBabyAnimal(entityAgeable);
    }
}

