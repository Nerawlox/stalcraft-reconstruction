/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.monster;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.ezey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;

public class EntitySlime
extends EntityLiving
implements ezey {
    public float squishAmount;
    public float squishFactor;
    public float prevSquishFactor;
    public int slimeJumpDelay;

    public EntitySlime(World world) {
        super(world);
        int n = 1 << this.rand.nextInt(3);
        this.yOffset = 0.0f;
        this.slimeJumpDelay = this.rand.nextInt(20) + 10;
        this.setSlimeSize(n);
    }

    @Override
    public void entityInit() {
        super.entityInit();
        this.dataWatcher._a(16, new Byte(1));
    }

    public void setSlimeSize(int n) {
        this.dataWatcher._b(16, new Byte((byte)n));
        this.setSize(0.6f * (float)n, 0.6f * (float)n);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.getEntityAttribute(sajz._a)._a(n * n);
        this.setHealth(this.getMaxHealth());
        this.experienceValue = n;
    }

    public int getSlimeSize() {
        return this.dataWatcher._a(16);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
        nBTTagCompound._a("Size", this.getSlimeSize() - 1);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
        this.setSlimeSize(nBTTagCompound._f("Size") + 1);
    }

    public String getSlimeParticle() {
        return "slime";
    }

    public String getJumpSound() {
        return "mob.slime." + (this.getSlimeSize() > 1 ? "big" : "small");
    }

    @Override
    public void onUpdate() {
        int n;
        if (!this.worldObj.isRemote && this.worldObj.difficultySetting == 0 && this.getSlimeSize() > 0) {
            this.isDead = true;
        }
        this.squishFactor += (this.squishAmount - this.squishFactor) * 0.5f;
        this.prevSquishFactor = this.squishFactor;
        boolean bl = this.onGround;
        super.onUpdate();
        if (this.onGround && !bl) {
            n = this.getSlimeSize();
            for (int i = 0; i < n * 8; ++i) {
                float f = this.rand.nextFloat() * (float)Math.PI * 2.0f;
                float f2 = this.rand.nextFloat() * 0.5f + 0.5f;
                float f3 = sajh._a(f) * (float)n * 0.5f * f2;
                float f4 = sajh._b(f) * (float)n * 0.5f * f2;
                this.worldObj.spawnParticle(this.getSlimeParticle(), this.posX + (double)f3, this.boundingBox._c, this.posZ + (double)f4, 0.0, 0.0, 0.0);
            }
            if (this.makesSoundOnLand()) {
                this.playSound(this.getJumpSound(), this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f) / 0.8f);
            }
            this.squishAmount = -0.5f;
        } else if (!this.onGround && bl) {
            this.squishAmount = 1.0f;
        }
        this.alterSquishAmount();
        if (this.worldObj.isRemote) {
            n = this.getSlimeSize();
            this.setSize(0.6f * (float)n, 0.6f * (float)n);
        }
    }

    @Override
    public void updateEntityActionState() {
        this.despawnEntity();
        EntityPlayer entityPlayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0);
        if (entityPlayer != null) {
            this.faceEntity(entityPlayer, 10.0f, 20.0f);
        }
        if (this.onGround && this.slimeJumpDelay-- <= 0) {
            this.slimeJumpDelay = this.getJumpDelay();
            if (entityPlayer != null) {
                this.slimeJumpDelay /= 3;
            }
            this.isJumping = true;
            if (this.makesSoundOnJump()) {
                this.playSound(this.getJumpSound(), this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f) * 0.8f);
            }
            this.moveStrafing = 1.0f - this.rand.nextFloat() * 2.0f;
            this.moveForward = 1 * this.getSlimeSize();
        } else {
            this.isJumping = false;
            if (this.onGround) {
                this.moveForward = 0.0f;
                this.moveStrafing = 0.0f;
            }
        }
    }

    public void alterSquishAmount() {
        this.squishAmount *= 0.6f;
    }

    public int getJumpDelay() {
        return this.rand.nextInt(20) + 10;
    }

    public EntitySlime createInstance() {
        return new EntitySlime(this.worldObj);
    }

    @Override
    public void setDead() {
        int n = this.getSlimeSize();
        if (!this.worldObj.isRemote && n > 1 && this.getHealth() <= 0.0f) {
            int n2 = 2 + this.rand.nextInt(3);
            for (int i = 0; i < n2; ++i) {
                float f = ((float)(i % 2) - 0.5f) * (float)n / 4.0f;
                float f2 = ((float)(i / 2) - 0.5f) * (float)n / 4.0f;
                EntitySlime entitySlime = this.createInstance();
                entitySlime.setSlimeSize(n / 2);
                entitySlime.setLocationAndAngles(this.posX + (double)f, this.posY + 0.5, this.posZ + (double)f2, this.rand.nextFloat() * 360.0f, 0.0f);
                this.worldObj.spawnEntityInWorld(entitySlime);
            }
        }
        super.setDead();
    }

    @Override
    public void onCollideWithPlayer(EntityPlayer entityPlayer) {
        if (this.canDamagePlayer()) {
            int n = this.getSlimeSize();
            if (this.canEntityBeSeen(entityPlayer) && this.getDistanceSqToEntity(entityPlayer) < 0.6 * (double)n * 0.6 * (double)n && entityPlayer.attackEntityFrom(DamageSource.causeMobDamage(this), this.getAttackStrength())) {
                this.playSound("mob.attack", 1.0f, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
            }
        }
    }

    public boolean canDamagePlayer() {
        return this.getSlimeSize() > 1;
    }

    public int getAttackStrength() {
        return this.getSlimeSize();
    }

    @Override
    public String getHurtSound() {
        return "mob.slime." + (this.getSlimeSize() > 1 ? "big" : "small");
    }

    @Override
    public String getDeathSound() {
        return "mob.slime." + (this.getSlimeSize() > 1 ? "big" : "small");
    }

    @Override
    public int getDropItemId() {
        return this.getSlimeSize() == 1 ? Item.slimeBall.itemID : 0;
    }

    @Override
    public boolean getCanSpawnHere() {
        Chunk chunk = this.worldObj.getChunkFromBlockCoords(sajh._c(this.posX), sajh._c(this.posZ));
        if (this.worldObj.getWorldInfo()._u()._a(this.rand, this.worldObj)) {
            return false;
        }
        if (this.getSlimeSize() == 1 || this.worldObj.difficultySetting > 0) {
            BiomeGenBase biomeGenBase = this.worldObj.getBiomeGenForCoords(sajh._c(this.posX), sajh._c(this.posZ));
            if (biomeGenBase == BiomeGenBase._h && this.posY > 50.0 && this.posY < 70.0 && this.rand.nextFloat() < 0.5f && this.rand.nextFloat() < this.worldObj.getCurrentMoonPhaseFactor() && this.worldObj.getBlockLightValue(sajh._c(this.posX), sajh._c(this.posY), sajh._c(this.posZ)) <= this.rand.nextInt(8)) {
                return super.getCanSpawnHere();
            }
            if (this.rand.nextInt(10) == 0 && chunk._a(987234911L).nextInt(10) == 0 && this.posY < 40.0) {
                return super.getCanSpawnHere();
            }
        }
        return false;
    }

    @Override
    public float getSoundVolume() {
        return 0.4f * (float)this.getSlimeSize();
    }

    @Override
    public int getVerticalFaceSpeed() {
        return 0;
    }

    public boolean makesSoundOnJump() {
        return this.getSlimeSize() > 0;
    }

    public boolean makesSoundOnLand() {
        return this.getSlimeSize() > 2;
    }
}

