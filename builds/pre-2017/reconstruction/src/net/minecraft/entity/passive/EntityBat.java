/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.passive;

import java.util.Calendar;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.sajz;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class EntityBat
extends EntityAmbientCreature {
    public ChunkCoordinates field_82237_a;

    public EntityBat(World world) {
        super(world);
        this.setSize(0.5f, 0.9f);
        this.setIsBatHanging(true);
    }

    @Override
    public void entityInit() {
        super.entityInit();
        this.dataWatcher._a(16, new Byte(0));
    }

    @Override
    public float getSoundVolume() {
        return 0.1f;
    }

    @Override
    public float getSoundPitch() {
        return super.getSoundPitch() * 0.95f;
    }

    @Override
    public String getLivingSound() {
        if (this.getIsBatHanging() && this.rand.nextInt(4) != 0) {
            return null;
        }
        return "mob.bat.idle";
    }

    @Override
    public String getHurtSound() {
        return "mob.bat.hurt";
    }

    @Override
    public String getDeathSound() {
        return "mob.bat.death";
    }

    @Override
    public boolean canBePushed() {
        return false;
    }

    @Override
    public void collideWithEntity(Entity entity) {
    }

    @Override
    public void collideWithNearbyEntities() {
    }

    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(sajz._a)._a(6.0);
    }

    public boolean getIsBatHanging() {
        return (this.dataWatcher._a(16) & 1) != 0;
    }

    public void setIsBatHanging(boolean bl) {
        byte by = this.dataWatcher._a(16);
        if (bl) {
            this.dataWatcher._b(16, (byte)(by | 1));
        } else {
            this.dataWatcher._b(16, (byte)(by & 0xFFFFFFFE));
        }
    }

    @Override
    public boolean isAIEnabled() {
        return true;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.getIsBatHanging()) {
            this.motionZ = 0.0;
            this.motionY = 0.0;
            this.motionX = 0.0;
            this.posY = (double)sajh._c(this.posY) + 1.0 - (double)this.height;
        } else {
            this.motionY *= (double)0.6f;
        }
    }

    @Override
    public void updateAITasks() {
        super.updateAITasks();
        if (this.getIsBatHanging()) {
            if (!this.worldObj.isBlockNormalCube(sajh._c(this.posX), (int)this.posY + 1, sajh._c(this.posZ))) {
                this.setIsBatHanging(false);
                this.worldObj.playAuxSFXAtEntity(null, 1015, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
            } else {
                if (this.rand.nextInt(200) == 0) {
                    this.rotationYawHead = this.rand.nextInt(360);
                }
                if (this.worldObj.getClosestPlayerToEntity(this, 4.0) != null) {
                    this.setIsBatHanging(false);
                    this.worldObj.playAuxSFXAtEntity(null, 1015, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
                }
            }
        } else {
            if (!(this.field_82237_a == null || this.worldObj.isAirBlock(this.field_82237_a._a, this.field_82237_a._b, this.field_82237_a._c) && this.field_82237_a._b >= 1)) {
                this.field_82237_a = null;
            }
            if (this.field_82237_a == null || this.rand.nextInt(30) == 0 || this.field_82237_a._b((int)this.posX, (int)this.posY, (int)this.posZ) < 4.0f) {
                this.field_82237_a = new ChunkCoordinates((int)this.posX + this.rand.nextInt(7) - this.rand.nextInt(7), (int)this.posY + this.rand.nextInt(6) - 2, (int)this.posZ + this.rand.nextInt(7) - this.rand.nextInt(7));
            }
            double d = (double)this.field_82237_a._a + 0.5 - this.posX;
            double d2 = (double)this.field_82237_a._b + 0.1 - this.posY;
            double d3 = (double)this.field_82237_a._c + 0.5 - this.posZ;
            this.motionX += (Math.signum(d) * 0.5 - this.motionX) * (double)0.1f;
            this.motionY += (Math.signum(d2) * (double)0.7f - this.motionY) * (double)0.1f;
            this.motionZ += (Math.signum(d3) * 0.5 - this.motionZ) * (double)0.1f;
            float f = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0 / 3.1415927410125732) - 90.0f;
            float f2 = sajh._g(f - this.rotationYaw);
            this.moveForward = 0.5f;
            this.rotationYaw += f2;
            if (this.rand.nextInt(100) == 0 && this.worldObj.isBlockNormalCube(sajh._c(this.posX), (int)this.posY + 1, sajh._c(this.posZ))) {
                this.setIsBatHanging(true);
            }
        }
    }

    @Override
    public boolean canTriggerWalking() {
        return false;
    }

    @Override
    public void fall(float f) {
    }

    @Override
    public void updateFallState(double d, boolean bl) {
    }

    @Override
    public boolean doesEntityNotTriggerPressurePlate() {
        return true;
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        if (this.isEntityInvulnerable()) {
            return false;
        }
        if (!this.worldObj.isRemote && this.getIsBatHanging()) {
            this.setIsBatHanging(false);
        }
        return super.attackEntityFrom(damageSource, f);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
        this.dataWatcher._b(16, nBTTagCompound._d("BatFlags"));
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
        nBTTagCompound._a("BatFlags", this.dataWatcher._a(16));
    }

    @Override
    public boolean getCanSpawnHere() {
        int n = sajh._c(this.boundingBox._c);
        if (n >= 63) {
            return false;
        }
        int n2 = sajh._c(this.posX);
        int n3 = sajh._c(this.posZ);
        int n4 = this.worldObj.getBlockLightValue(n2, n, n3);
        int n5 = 4;
        Calendar calendar = this.worldObj.getCurrentDate();
        if (calendar.get(2) + 1 == 10 && calendar.get(5) >= 20 || calendar.get(2) + 1 == 11 && calendar.get(5) <= 3) {
            n5 = 7;
        } else if (this.rand.nextBoolean()) {
            return false;
        }
        if (n4 > this.rand.nextInt(n5)) {
            return false;
        }
        return super.getCanSpawnHere();
    }
}

