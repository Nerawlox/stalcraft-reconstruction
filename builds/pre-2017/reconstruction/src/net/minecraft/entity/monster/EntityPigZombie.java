/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.monster;

import java.util.List;
import java.util.UUID;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityPigZombie
extends EntityZombie {
    public static final UUID field_110189_bq = UUID.fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");
    public static final AttributeModifier field_110190_br = new AttributeModifier(field_110189_bq, "Attacking speed boost", 0.45, 0)._a(false);
    public int angerLevel;
    public int randomSoundDelay;
    public Entity field_110191_bu;

    public EntityPigZombie(World world) {
        super(world);
        this.isImmuneToFire = true;
    }

    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(field_110186_bp)._a(0.0);
        this.getEntityAttribute(sajz._d)._a(0.5);
        this.getEntityAttribute(sajz._e)._a(5.0);
    }

    @Override
    public boolean isAIEnabled() {
        return false;
    }

    @Override
    public void onUpdate() {
        if (this.field_110191_bu != this.entityToAttack && !this.worldObj.isRemote) {
            hubf hubf2 = this.getEntityAttribute(sajz._d);
            hubf2._b(field_110190_br);
            if (this.entityToAttack != null) {
                hubf2._a(field_110190_br);
            }
        }
        this.field_110191_bu = this.entityToAttack;
        if (this.randomSoundDelay > 0 && --this.randomSoundDelay == 0) {
            this.playSound("mob.zombiepig.zpigangry", this.getSoundVolume() * 2.0f, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f) * 1.8f);
        }
        super.onUpdate();
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.worldObj.difficultySetting > 0 && this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
        nBTTagCompound._a("Anger", (short)this.angerLevel);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
        this.angerLevel = nBTTagCompound._e("Anger");
    }

    @Override
    public Entity findPlayerToAttack() {
        if (this.angerLevel == 0) {
            return null;
        }
        return super.findPlayerToAttack();
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        if (this.isEntityInvulnerable()) {
            return false;
        }
        Entity entity = damageSource.getEntity();
        if (entity instanceof EntityPlayer) {
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox._b(32.0, 32.0, 32.0));
            for (int i = 0; i < list.size(); ++i) {
                Entity entity2 = (Entity)list.get(i);
                if (!(entity2 instanceof EntityPigZombie)) continue;
                EntityPigZombie entityPigZombie = (EntityPigZombie)entity2;
                entityPigZombie.becomeAngryAt(entity);
            }
            this.becomeAngryAt(entity);
        }
        return super.attackEntityFrom(damageSource, f);
    }

    public void becomeAngryAt(Entity entity) {
        this.entityToAttack = entity;
        this.angerLevel = 400 + this.rand.nextInt(400);
        this.randomSoundDelay = this.rand.nextInt(40);
    }

    @Override
    public String getLivingSound() {
        return "mob.zombiepig.zpig";
    }

    @Override
    public String getHurtSound() {
        return "mob.zombiepig.zpighurt";
    }

    @Override
    public String getDeathSound() {
        return "mob.zombiepig.zpigdeath";
    }

    @Override
    public void dropFewItems(boolean bl, int n) {
        int n2;
        int n3 = this.rand.nextInt(2 + n);
        for (n2 = 0; n2 < n3; ++n2) {
            this.dropItem(Item.rottenFlesh.itemID, 1);
        }
        n3 = this.rand.nextInt(2 + n);
        for (n2 = 0; n2 < n3; ++n2) {
            this.dropItem(Item.goldNugget.itemID, 1);
        }
    }

    @Override
    public boolean interact(EntityPlayer entityPlayer) {
        return false;
    }

    @Override
    public void dropRareDrop(int n) {
        this.dropItem(Item.ingotGold.itemID, 1);
    }

    @Override
    public int getDropItemId() {
        return Item.rottenFlesh.itemID;
    }

    @Override
    public void addRandomArmor() {
        this.setCurrentItemOrArmor(0, new ItemStack(Item.swordGold));
    }

    @Override
    public EntityLivingData onSpawnWithEgg(EntityLivingData entityLivingData) {
        super.onSpawnWithEgg(entityLivingData);
        this.setVillager(false);
        return entityLivingData;
    }
}

