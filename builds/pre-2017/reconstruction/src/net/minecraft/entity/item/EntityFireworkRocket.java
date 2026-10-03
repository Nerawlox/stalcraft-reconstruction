/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class EntityFireworkRocket
extends Entity {
    public int fireworkAge;
    public int lifetime;

    public EntityFireworkRocket(World world) {
        super(world);
        this.setSize(0.25f, 0.25f);
    }

    @Override
    public void entityInit() {
        this.dataWatcher._a(8, 5);
    }

    @Override
    public boolean isInRangeToRenderDist(double d) {
        return d < 4096.0;
    }

    public EntityFireworkRocket(World world, double d, double d2, double d3, ItemStack itemStack) {
        super(world);
        this.fireworkAge = 0;
        this.setSize(0.25f, 0.25f);
        this.setPosition(d, d2, d3);
        this.yOffset = 0.0f;
        int n = 1;
        if (itemStack != null && itemStack._p()) {
            this.dataWatcher._b(8, itemStack);
            NBTTagCompound nBTTagCompound = itemStack._q();
            NBTTagCompound nBTTagCompound2 = nBTTagCompound._m("Fireworks");
            if (nBTTagCompound2 != null) {
                n += nBTTagCompound2._d("Flight");
            }
        }
        this.motionX = this.rand.nextGaussian() * 0.001;
        this.motionZ = this.rand.nextGaussian() * 0.001;
        this.motionY = 0.05;
        this.lifetime = 10 * n + this.rand.nextInt(6) + this.rand.nextInt(7);
    }

    @Override
    public void setVelocity(double d, double d2, double d3) {
        this.motionX = d;
        this.motionY = d2;
        this.motionZ = d3;
        if (this.prevRotationPitch == 0.0f && this.prevRotationYaw == 0.0f) {
            float f = sajh._a(d * d + d3 * d3);
            this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(d, d3) * 180.0 / 3.1415927410125732);
            this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(d2, f) * 180.0 / 3.1415927410125732);
        }
    }

    @Override
    public void onUpdate() {
        this.lastTickPosX = this.posX;
        this.lastTickPosY = this.posY;
        this.lastTickPosZ = this.posZ;
        super.onUpdate();
        this.motionX *= 1.15;
        this.motionZ *= 1.15;
        this.motionY += 0.04;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        float f = sajh._a(this.motionX * this.motionX + this.motionZ * this.motionZ);
        this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0 / 3.1415927410125732);
        this.rotationPitch = (float)(Math.atan2(this.motionY, f) * 180.0 / 3.1415927410125732);
        while (this.rotationPitch - this.prevRotationPitch < -180.0f) {
            this.prevRotationPitch -= 360.0f;
        }
        while (this.rotationPitch - this.prevRotationPitch >= 180.0f) {
            this.prevRotationPitch += 360.0f;
        }
        while (this.rotationYaw - this.prevRotationYaw < -180.0f) {
            this.prevRotationYaw -= 360.0f;
        }
        while (this.rotationYaw - this.prevRotationYaw >= 180.0f) {
            this.prevRotationYaw += 360.0f;
        }
        this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2f;
        this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2f;
        if (this.fireworkAge == 0) {
            this.worldObj.playSoundAtEntity(this, "fireworks.launch", 3.0f, 1.0f);
        }
        ++this.fireworkAge;
        if (this.worldObj.isRemote && this.fireworkAge % 2 < 2) {
            this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY - 0.3, this.posZ, this.rand.nextGaussian() * 0.05, -this.motionY * 0.5, this.rand.nextGaussian() * 0.05);
        }
        if (!this.worldObj.isRemote && this.fireworkAge > this.lifetime) {
            this.worldObj.setEntityState(this, (byte)17);
            this.setDead();
        }
    }

    @Override
    public void handleHealthUpdate(byte by) {
        if (by == 17 && this.worldObj.isRemote) {
            ItemStack itemStack = this.dataWatcher._f(8);
            NBTTagCompound nBTTagCompound = null;
            if (itemStack != null && itemStack._p()) {
                nBTTagCompound = itemStack._q()._m("Fireworks");
            }
            this.worldObj.func_92088_a(this.posX, this.posY, this.posZ, this.motionX, this.motionY, this.motionZ, nBTTagCompound);
        }
        super.handleHealthUpdate(by);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("Life", this.fireworkAge);
        nBTTagCompound._a("LifeTime", this.lifetime);
        ItemStack itemStack = this.dataWatcher._f(8);
        if (itemStack != null) {
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            itemStack._b(nBTTagCompound2);
            nBTTagCompound._a("FireworksItem", nBTTagCompound2);
        }
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        ItemStack itemStack;
        this.fireworkAge = nBTTagCompound._f("Life");
        this.lifetime = nBTTagCompound._f("LifeTime");
        NBTTagCompound nBTTagCompound2 = nBTTagCompound._m("FireworksItem");
        if (nBTTagCompound2 != null && (itemStack = ItemStack._a(nBTTagCompound2)) != null) {
            this.dataWatcher._b(8, itemStack);
        }
    }

    @Override
    public float getShadowSize() {
        return 0.0f;
    }

    @Override
    public float getBrightness(float f) {
        return super.getBrightness(f);
    }

    @Override
    public int getBrightnessForRender(float f) {
        return super.getBrightnessForRender(f);
    }

    @Override
    public boolean canAttackWithItem() {
        return false;
    }
}

