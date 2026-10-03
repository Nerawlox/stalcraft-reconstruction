/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.projectile;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public abstract class EntityFireball
extends Entity {
    public int xTile = -1;
    public int yTile = -1;
    public int zTile = -1;
    public int inTile;
    public boolean inGround;
    public EntityLivingBase shootingEntity;
    public int ticksAlive;
    public int ticksInAir;
    public double accelerationX;
    public double accelerationY;
    public double accelerationZ;

    public EntityFireball(World world) {
        super(world);
        this.setSize(1.0f, 1.0f);
    }

    @Override
    public void entityInit() {
    }

    @Override
    public boolean isInRangeToRenderDist(double d) {
        double d2 = this.boundingBox._b() * 4.0;
        return d < (d2 *= 64.0) * d2;
    }

    public EntityFireball(World world, double d, double d2, double d3, double d4, double d5, double d6) {
        super(world);
        this.setSize(1.0f, 1.0f);
        this.setLocationAndAngles(d, d2, d3, this.rotationYaw, this.rotationPitch);
        this.setPosition(d, d2, d3);
        double d7 = sajh._a(d4 * d4 + d5 * d5 + d6 * d6);
        this.accelerationX = d4 / d7 * 0.1;
        this.accelerationY = d5 / d7 * 0.1;
        this.accelerationZ = d6 / d7 * 0.1;
    }

    public EntityFireball(World world, EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        super(world);
        this.shootingEntity = entityLivingBase;
        this.setSize(1.0f, 1.0f);
        this.setLocationAndAngles(entityLivingBase.posX, entityLivingBase.posY, entityLivingBase.posZ, entityLivingBase.rotationYaw, entityLivingBase.rotationPitch);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.yOffset = 0.0f;
        this.motionZ = 0.0;
        this.motionY = 0.0;
        this.motionX = 0.0;
        double d4 = sajh._a((d += this.rand.nextGaussian() * 0.4) * d + (d2 += this.rand.nextGaussian() * 0.4) * d2 + (d3 += this.rand.nextGaussian() * 0.4) * d3);
        this.accelerationX = d / d4 * 0.1;
        this.accelerationY = d2 / d4 * 0.1;
        this.accelerationZ = d3 / d4 * 0.1;
    }

    @Override
    public void onUpdate() {
        if (!this.worldObj.isRemote && (this.shootingEntity != null && this.shootingEntity.isDead || !this.worldObj.blockExists((int)this.posX, (int)this.posY, (int)this.posZ))) {
            this.setDead();
            return;
        }
        super.onUpdate();
        this.setFire(1);
        if (this.inGround) {
            int n = this.worldObj.getBlockId(this.xTile, this.yTile, this.zTile);
            if (n == this.inTile) {
                ++this.ticksAlive;
                if (this.ticksAlive == 600) {
                    this.setDead();
                }
                return;
            }
            this.inGround = false;
            this.motionX *= (double)(this.rand.nextFloat() * 0.2f);
            this.motionY *= (double)(this.rand.nextFloat() * 0.2f);
            this.motionZ *= (double)(this.rand.nextFloat() * 0.2f);
            this.ticksAlive = 0;
            this.ticksInAir = 0;
        } else {
            ++this.ticksInAir;
        }
        Vec3 vec3 = this.worldObj.getWorldVec3Pool()._a(this.posX, this.posY, this.posZ);
        Vec3 vec32 = this.worldObj.getWorldVec3Pool()._a(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        MovingObjectPosition movingObjectPosition = this.worldObj.func_72933_a(vec3, vec32);
        vec3 = this.worldObj.getWorldVec3Pool()._a(this.posX, this.posY, this.posZ);
        vec32 = this.worldObj.getWorldVec3Pool()._a(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        if (movingObjectPosition != null) {
            vec32 = this.worldObj.getWorldVec3Pool()._a(movingObjectPosition._h._c, movingObjectPosition._h._d, movingObjectPosition._h._e);
        }
        Entity entity = null;
        List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox._a(this.motionX, this.motionY, this.motionZ)._b(1.0, 1.0, 1.0));
        double d = 0.0;
        for (int i = 0; i < list2.size(); ++i) {
            double d2;
            float f;
            AxisAlignedBB axisAlignedBB;
            MovingObjectPosition movingObjectPosition2;
            Entity entity2 = (Entity)list2.get(i);
            if (!entity2.canBeCollidedWith() || entity2.isEntityEqual(this.shootingEntity) && this.ticksInAir < 25 || (movingObjectPosition2 = (axisAlignedBB = entity2.boundingBox._b(f = 0.3f, f, f))._a(vec3, vec32)) == null || !((d2 = vec3._d(movingObjectPosition2._h)) < d) && d != 0.0) continue;
            entity = entity2;
            d = d2;
        }
        if (entity != null) {
            movingObjectPosition = new MovingObjectPosition(entity);
        }
        if (movingObjectPosition != null) {
            this.onImpact(movingObjectPosition);
        }
        this.posX += this.motionX;
        this.posY += this.motionY;
        this.posZ += this.motionZ;
        float f = sajh._a(this.motionX * this.motionX + this.motionZ * this.motionZ);
        this.rotationYaw = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0 / 3.1415927410125732) + 90.0f;
        this.rotationPitch = (float)(Math.atan2(f, this.motionY) * 180.0 / 3.1415927410125732) - 90.0f;
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
        float f2 = this.getMotionFactor();
        if (this.isInWater()) {
            for (int i = 0; i < 4; ++i) {
                float f3 = 0.25f;
                this.worldObj.spawnParticle("bubble", this.posX - this.motionX * (double)f3, this.posY - this.motionY * (double)f3, this.posZ - this.motionZ * (double)f3, this.motionX, this.motionY, this.motionZ);
            }
            f2 = 0.8f;
        }
        this.motionX += this.accelerationX;
        this.motionY += this.accelerationY;
        this.motionZ += this.accelerationZ;
        this.motionX *= (double)f2;
        this.motionY *= (double)f2;
        this.motionZ *= (double)f2;
        this.worldObj.spawnParticle("smoke", this.posX, this.posY + 0.5, this.posZ, 0.0, 0.0, 0.0);
        this.setPosition(this.posX, this.posY, this.posZ);
    }

    public float getMotionFactor() {
        return 0.95f;
    }

    public abstract void onImpact(MovingObjectPosition var1);

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("xTile", (short)this.xTile);
        nBTTagCompound._a("yTile", (short)this.yTile);
        nBTTagCompound._a("zTile", (short)this.zTile);
        nBTTagCompound._a("inTile", (byte)this.inTile);
        nBTTagCompound._a("inGround", (byte)(this.inGround ? 1 : 0));
        nBTTagCompound._a("direction", this.newDoubleNBTList(this.motionX, this.motionY, this.motionZ));
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        this.xTile = nBTTagCompound._e("xTile");
        this.yTile = nBTTagCompound._e("yTile");
        this.zTile = nBTTagCompound._e("zTile");
        this.inTile = nBTTagCompound._d("inTile") & 0xFF;
        boolean bl = this.inGround = nBTTagCompound._d("inGround") == 1;
        if (nBTTagCompound._c("direction")) {
            NBTTagList nBTTagList = nBTTagCompound._n("direction");
            this.motionX = ((qoae)nBTTagList._b((int)0))._c;
            this.motionY = ((qoae)nBTTagList._b((int)1))._c;
            this.motionZ = ((qoae)nBTTagList._b((int)2))._c;
        } else {
            this.setDead();
        }
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }

    @Override
    public float getCollisionBorderSize() {
        return 1.0f;
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        if (this.isEntityInvulnerable()) {
            return false;
        }
        this.setBeenAttacked();
        if (damageSource.getEntity() != null) {
            Vec3 vec3 = damageSource.getEntity().getLookVec();
            if (vec3 != null) {
                this.motionX = vec3._c;
                this.motionY = vec3._d;
                this.motionZ = vec3._e;
                this.accelerationX = this.motionX * 0.1;
                this.accelerationY = this.motionY * 0.1;
                this.accelerationZ = this.motionZ * 0.1;
            }
            if (damageSource.getEntity() instanceof EntityLivingBase) {
                this.shootingEntity = (EntityLivingBase)damageSource.getEntity();
            }
            return true;
        }
        return false;
    }

    @Override
    public float getShadowSize() {
        return 0.0f;
    }

    @Override
    public float getBrightness(float f) {
        return 1.0f;
    }

    @Override
    public int getBrightnessForRender(float f) {
        return 0xF000F0;
    }
}

