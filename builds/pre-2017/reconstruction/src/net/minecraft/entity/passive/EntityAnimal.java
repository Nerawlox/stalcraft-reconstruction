/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.passive;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.ezey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public abstract class EntityAnimal
extends EntityAgeable
implements ezey {
    public int inLove;
    public int breeding;

    public EntityAnimal(World world) {
        super(world);
    }

    @Override
    public void updateAITick() {
        if (this.getGrowingAge() != 0) {
            this.inLove = 0;
        }
        super.updateAITick();
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.getGrowingAge() != 0) {
            this.inLove = 0;
        }
        if (this.inLove > 0) {
            --this.inLove;
            String string = "heart";
            if (this.inLove % 10 == 0) {
                double d = this.rand.nextGaussian() * 0.02;
                double d2 = this.rand.nextGaussian() * 0.02;
                double d3 = this.rand.nextGaussian() * 0.02;
                this.worldObj.spawnParticle(string, this.posX + (double)(this.rand.nextFloat() * this.width * 2.0f) - (double)this.width, this.posY + 0.5 + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0f) - (double)this.width, d, d2, d3);
            }
        } else {
            this.breeding = 0;
        }
    }

    @Override
    public void attackEntity(Entity entity, float f) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer entityPlayer;
            if (f < 3.0f) {
                double d = entity.posX - this.posX;
                double d2 = entity.posZ - this.posZ;
                this.rotationYaw = (float)(Math.atan2(d2, d) * 180.0 / 3.1415927410125732) - 90.0f;
                this.hasAttacked = true;
            }
            if ((entityPlayer = (EntityPlayer)entity).getCurrentEquippedItem() == null || !this.isBreedingItem(entityPlayer.getCurrentEquippedItem())) {
                this.entityToAttack = null;
            }
        } else if (entity instanceof EntityAnimal) {
            EntityAnimal entityAnimal = (EntityAnimal)entity;
            if (this.getGrowingAge() > 0 && entityAnimal.getGrowingAge() < 0) {
                if ((double)f < 2.5) {
                    this.hasAttacked = true;
                }
            } else if (this.inLove > 0 && entityAnimal.inLove > 0) {
                if (entityAnimal.entityToAttack == null) {
                    entityAnimal.entityToAttack = this;
                }
                if (entityAnimal.entityToAttack == this && (double)f < 3.5) {
                    ++entityAnimal.inLove;
                    ++this.inLove;
                    ++this.breeding;
                    if (this.breeding % 4 == 0) {
                        this.worldObj.spawnParticle("heart", this.posX + (double)(this.rand.nextFloat() * this.width * 2.0f) - (double)this.width, this.posY + 0.5 + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0f) - (double)this.width, 0.0, 0.0, 0.0);
                    }
                    if (this.breeding == 60) {
                        this.procreate((EntityAnimal)entity);
                    }
                } else {
                    this.breeding = 0;
                }
            } else {
                this.breeding = 0;
                this.entityToAttack = null;
            }
        }
    }

    public void procreate(EntityAnimal entityAnimal) {
        EntityAgeable entityAgeable = this.createChild(entityAnimal);
        if (entityAgeable != null) {
            this.setGrowingAge(6000);
            entityAnimal.setGrowingAge(6000);
            this.inLove = 0;
            this.breeding = 0;
            this.entityToAttack = null;
            entityAnimal.entityToAttack = null;
            entityAnimal.breeding = 0;
            entityAnimal.inLove = 0;
            entityAgeable.setGrowingAge(-24000);
            entityAgeable.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
            for (int i = 0; i < 7; ++i) {
                double d = this.rand.nextGaussian() * 0.02;
                double d2 = this.rand.nextGaussian() * 0.02;
                double d3 = this.rand.nextGaussian() * 0.02;
                this.worldObj.spawnParticle("heart", this.posX + (double)(this.rand.nextFloat() * this.width * 2.0f) - (double)this.width, this.posY + 0.5 + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0f) - (double)this.width, d, d2, d3);
            }
            this.worldObj.spawnEntityInWorld(entityAgeable);
        }
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        hubf hubf2;
        if (this.isEntityInvulnerable()) {
            return false;
        }
        this.fleeingTick = 60;
        if (!this.isAIEnabled() && (hubf2 = this.getEntityAttribute(sajz._d))._a(field_110179_h) == null) {
            hubf2._a(field_110181_i);
        }
        this.entityToAttack = null;
        this.inLove = 0;
        return super.attackEntityFrom(damageSource, f);
    }

    @Override
    public float getBlockPathWeight(int n, int n2, int n3) {
        if (this.worldObj.getBlockId(n, n2 - 1, n3) == Block.grass.blockID) {
            return 10.0f;
        }
        return this.worldObj.getLightBrightness(n, n2, n3) - 0.5f;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
        nBTTagCompound._a("InLove", this.inLove);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
        this.inLove = nBTTagCompound._f("InLove");
    }

    @Override
    public Entity findPlayerToAttack() {
        block5: {
            float f;
            block6: {
                block4: {
                    if (this.fleeingTick > 0) {
                        return null;
                    }
                    f = 8.0f;
                    if (this.inLove <= 0) break block4;
                    List list2 = this.worldObj.getEntitiesWithinAABB(this.getClass(), this.boundingBox._b(f, f, f));
                    for (int i = 0; i < list2.size(); ++i) {
                        EntityAnimal entityAnimal = (EntityAnimal)list2.get(i);
                        if (entityAnimal == this || entityAnimal.inLove <= 0) continue;
                        return entityAnimal;
                    }
                    break block5;
                }
                if (this.getGrowingAge() != 0) break block6;
                List list3 = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.boundingBox._b(f, f, f));
                for (int i = 0; i < list3.size(); ++i) {
                    EntityPlayer entityPlayer = (EntityPlayer)list3.get(i);
                    if (entityPlayer.getCurrentEquippedItem() == null || !this.isBreedingItem(entityPlayer.getCurrentEquippedItem())) continue;
                    return entityPlayer;
                }
                break block5;
            }
            if (this.getGrowingAge() <= 0) break block5;
            List list4 = this.worldObj.getEntitiesWithinAABB(this.getClass(), this.boundingBox._b(f, f, f));
            for (int i = 0; i < list4.size(); ++i) {
                EntityAnimal entityAnimal = (EntityAnimal)list4.get(i);
                if (entityAnimal == this || entityAnimal.getGrowingAge() >= 0) continue;
                return entityAnimal;
            }
        }
        return null;
    }

    @Override
    public boolean getCanSpawnHere() {
        int n;
        int n2;
        int n3 = sajh._c(this.posX);
        return this.worldObj.getBlockId(n3, (n2 = sajh._c(this.boundingBox._c)) - 1, n = sajh._c(this.posZ)) == Block.grass.blockID && this.worldObj.getFullBlockLightValue(n3, n2, n) > 8 && super.getCanSpawnHere();
    }

    @Override
    public int getTalkInterval() {
        return 120;
    }

    @Override
    public boolean canDespawn() {
        return false;
    }

    @Override
    public int getExperiencePoints(EntityPlayer entityPlayer) {
        return 1 + this.worldObj.rand.nextInt(3);
    }

    public boolean isBreedingItem(ItemStack itemStack) {
        return itemStack._d == Item.wheat.itemID;
    }

    @Override
    public boolean interact(EntityPlayer entityPlayer) {
        ItemStack itemStack = entityPlayer.inventory._a();
        if (itemStack != null && this.isBreedingItem(itemStack) && this.getGrowingAge() == 0 && this.inLove <= 0) {
            if (!entityPlayer.capabilities._d) {
                --itemStack._b;
                if (itemStack._b <= 0) {
                    entityPlayer.inventory.setInventorySlotContents(entityPlayer.inventory._c, null);
                }
            }
            this.func_110196_bT();
            return true;
        }
        return super.interact(entityPlayer);
    }

    public void func_110196_bT() {
        this.inLove = 600;
        this.entityToAttack = null;
        this.worldObj.setEntityState(this, (byte)18);
    }

    public boolean isInLove() {
        return this.inLove > 0;
    }

    public void resetInLove() {
        this.inLove = 0;
    }

    public boolean canMateWith(EntityAnimal entityAnimal) {
        if (entityAnimal == this) {
            return false;
        }
        if (entityAnimal.getClass() != this.getClass()) {
            return false;
        }
        return this.isInLove() && entityAnimal.isInLove();
    }

    @Override
    public void handleHealthUpdate(byte by) {
        if (by == 18) {
            for (int i = 0; i < 7; ++i) {
                double d = this.rand.nextGaussian() * 0.02;
                double d2 = this.rand.nextGaussian() * 0.02;
                double d3 = this.rand.nextGaussian() * 0.02;
                this.worldObj.spawnParticle("heart", this.posX + (double)(this.rand.nextFloat() * this.width * 2.0f) - (double)this.width, this.posY + 0.5 + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0f) - (double)this.width, d, d2, d3);
            }
        } else {
            super.handleHealthUpdate(by);
        }
    }
}

