/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.projectile;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.owak;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public abstract class EntityThrowable
extends Entity
implements owak {
    public int xTile = -1;
    public int yTile = -1;
    public int zTile = -1;
    public int inTile;
    public boolean inGround;
    public int throwableShake;
    public EntityLivingBase thrower;
    public String throwerName;
    public int ticksInGround;
    public int ticksInAir;

    public EntityThrowable(World world) {
        super(world);
        this.setSize(0.25f, 0.25f);
    }

    @Override
    public void entityInit() {
    }

    @Override
    public boolean isInRangeToRenderDist(double d) {
        double d2 = this.boundingBox._b() * 4.0;
        return d < (d2 *= 64.0) * d2;
    }

    public EntityThrowable(World world, EntityLivingBase entityLivingBase) {
        super(world);
        this.thrower = entityLivingBase;
        this.setSize(0.25f, 0.25f);
        this.setLocationAndAngles(entityLivingBase.posX, entityLivingBase.posY + (double)entityLivingBase.getEyeHeight(), entityLivingBase.posZ, entityLivingBase.rotationYaw, entityLivingBase.rotationPitch);
        this.posX -= (double)(sajh._b(this.rotationYaw / 180.0f * (float)Math.PI) * 0.16f);
        this.posY -= (double)0.1f;
        this.posZ -= (double)(sajh._a(this.rotationYaw / 180.0f * (float)Math.PI) * 0.16f);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.yOffset = 0.0f;
        float f = 0.4f;
        this.motionX = -sajh._a(this.rotationYaw / 180.0f * (float)Math.PI) * sajh._b(this.rotationPitch / 180.0f * (float)Math.PI) * f;
        this.motionZ = sajh._b(this.rotationYaw / 180.0f * (float)Math.PI) * sajh._b(this.rotationPitch / 180.0f * (float)Math.PI) * f;
        this.motionY = -sajh._a((this.rotationPitch + this.func_70183_g()) / 180.0f * (float)Math.PI) * f;
        this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, this.func_70182_d(), 1.0f);
    }

    public EntityThrowable(World world, double d, double d2, double d3) {
        super(world);
        this.ticksInGround = 0;
        this.setSize(0.25f, 0.25f);
        this.setPosition(d, d2, d3);
        this.yOffset = 0.0f;
    }

    public float func_70182_d() {
        return 1.5f;
    }

    public float func_70183_g() {
        return 0.0f;
    }

    @Override
    public void setThrowableHeading(double d, double d2, double d3, float f, float f2) {
        float f3 = sajh._a(d * d + d2 * d2 + d3 * d3);
        d /= (double)f3;
        d2 /= (double)f3;
        d3 /= (double)f3;
        d += this.rand.nextGaussian() * (double)0.0075f * (double)f2;
        d2 += this.rand.nextGaussian() * (double)0.0075f * (double)f2;
        d3 += this.rand.nextGaussian() * (double)0.0075f * (double)f2;
        this.motionX = d *= (double)f;
        this.motionY = d2 *= (double)f;
        this.motionZ = d3 *= (double)f;
        float f4 = sajh._a(d * d + d3 * d3);
        this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(d, d3) * 180.0 / 3.1415927410125732);
        this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(d2, f4) * 180.0 / 3.1415927410125732);
        this.ticksInGround = 0;
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
        if (this.throwableShake > 0) {
            --this.throwableShake;
        }
        if (this.inGround) {
            int n = this.worldObj.getBlockId(this.xTile, this.yTile, this.zTile);
            if (n == this.inTile) {
                ++this.ticksInGround;
                if (this.ticksInGround == 1200) {
                    this.setDead();
                }
                return;
            }
            this.inGround = false;
            this.motionX *= (double)(this.rand.nextFloat() * 0.2f);
            this.motionY *= (double)(this.rand.nextFloat() * 0.2f);
            this.motionZ *= (double)(this.rand.nextFloat() * 0.2f);
            this.ticksInGround = 0;
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
        if (!this.worldObj.isRemote) {
            Entity entity = null;
            List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox._a(this.motionX, this.motionY, this.motionZ)._b(1.0, 1.0, 1.0));
            double d = 0.0;
            EntityLivingBase entityLivingBase = this.getThrower();
            for (int i = 0; i < list2.size(); ++i) {
                double d2;
                float f;
                AxisAlignedBB axisAlignedBB;
                MovingObjectPosition movingObjectPosition2;
                Entity entity2 = (Entity)list2.get(i);
                if (!entity2.canBeCollidedWith() || entity2 == entityLivingBase && this.ticksInAir < 5 || (movingObjectPosition2 = (axisAlignedBB = entity2.boundingBox._b(f = 0.3f, f, f))._a(vec3, vec32)) == null || !((d2 = vec3._d(movingObjectPosition2._h)) < d) && d != 0.0) continue;
                entity = entity2;
                d = d2;
            }
            if (entity != null) {
                movingObjectPosition = new MovingObjectPosition(entity);
            }
        }
        if (movingObjectPosition != null) {
            if (movingObjectPosition._c == EnumMovingObjectType._a && this.worldObj.getBlockId(movingObjectPosition._d, movingObjectPosition._e, movingObjectPosition._f) == Block.portal.blockID) {
                this.setInPortal();
            } else {
                this.onImpact(movingObjectPosition);
            }
        }
        this.posX += this.motionX;
        this.posY += this.motionY;
        this.posZ += this.motionZ;
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
        float f2 = 0.99f;
        float f3 = this.getGravityVelocity();
        if (this.isInWater()) {
            for (int i = 0; i < 4; ++i) {
                float f4 = 0.25f;
                this.worldObj.spawnParticle("bubble", this.posX - this.motionX * (double)f4, this.posY - this.motionY * (double)f4, this.posZ - this.motionZ * (double)f4, this.motionX, this.motionY, this.motionZ);
            }
            f2 = 0.8f;
        }
        this.motionX *= (double)f2;
        this.motionY *= (double)f2;
        this.motionZ *= (double)f2;
        this.motionY -= (double)f3;
        this.setPosition(this.posX, this.posY, this.posZ);
    }

    public float getGravityVelocity() {
        return 0.03f;
    }

    public abstract void onImpact(MovingObjectPosition var1);

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("xTile", (short)this.xTile);
        nBTTagCompound._a("yTile", (short)this.yTile);
        nBTTagCompound._a("zTile", (short)this.zTile);
        nBTTagCompound._a("inTile", (byte)this.inTile);
        nBTTagCompound._a("shake", (byte)this.throwableShake);
        nBTTagCompound._a("inGround", (byte)(this.inGround ? 1 : 0));
        if ((this.throwerName == null || this.throwerName.length() == 0) && this.thrower != null && this.thrower instanceof EntityPlayer) {
            this.throwerName = this.thrower.getEntityName();
        }
        nBTTagCompound._a("ownerName", this.throwerName == null ? "" : this.throwerName);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        this.xTile = nBTTagCompound._e("xTile");
        this.yTile = nBTTagCompound._e("yTile");
        this.zTile = nBTTagCompound._e("zTile");
        this.inTile = nBTTagCompound._d("inTile") & 0xFF;
        this.throwableShake = nBTTagCompound._d("shake") & 0xFF;
        this.inGround = nBTTagCompound._d("inGround") == 1;
        this.throwerName = nBTTagCompound._j("ownerName");
        if (this.throwerName != null && this.throwerName.length() == 0) {
            this.throwerName = null;
        }
    }

    @Override
    public float getShadowSize() {
        return 0.0f;
    }

    public EntityLivingBase getThrower() {
        if (this.thrower == null && this.throwerName != null && this.throwerName.length() > 0) {
            this.thrower = this.worldObj.getPlayerEntityByName(this.throwerName);
        }
        return this.thrower;
    }
}

