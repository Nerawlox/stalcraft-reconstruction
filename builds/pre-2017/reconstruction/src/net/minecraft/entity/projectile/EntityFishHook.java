/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.projectile;

import java.util.List;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class EntityFishHook
extends Entity {
    public int xTile = -1;
    public int yTile = -1;
    public int zTile = -1;
    public int inTile;
    public boolean inGround;
    public int shake;
    public EntityPlayer angler;
    public int ticksInGround;
    public int ticksInAir;
    public int ticksCatchable;
    public Entity bobber;
    public int fishPosRotationIncrements;
    public double fishX;
    public double fishY;
    public double fishZ;
    public double fishYaw;
    public double fishPitch;
    public double velocityX;
    public double velocityY;
    public double velocityZ;

    public EntityFishHook(World world) {
        super(world);
        this.setSize(0.25f, 0.25f);
        this.ignoreFrustumCheck = true;
    }

    public EntityFishHook(World world, double d, double d2, double d3, EntityPlayer entityPlayer) {
        this(world);
        this.setPosition(d, d2, d3);
        this.ignoreFrustumCheck = true;
        this.angler = entityPlayer;
        entityPlayer.fishEntity = this;
    }

    public EntityFishHook(World world, EntityPlayer entityPlayer) {
        super(world);
        this.ignoreFrustumCheck = true;
        this.angler = entityPlayer;
        this.angler.fishEntity = this;
        this.setSize(0.25f, 0.25f);
        this.setLocationAndAngles(entityPlayer.posX, entityPlayer.posY + 1.62 - (double)entityPlayer.yOffset, entityPlayer.posZ, entityPlayer.rotationYaw, entityPlayer.rotationPitch);
        this.posX -= (double)(sajh._b(this.rotationYaw / 180.0f * (float)Math.PI) * 0.16f);
        this.posY -= (double)0.1f;
        this.posZ -= (double)(sajh._a(this.rotationYaw / 180.0f * (float)Math.PI) * 0.16f);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.yOffset = 0.0f;
        float f = 0.4f;
        this.motionX = -sajh._a(this.rotationYaw / 180.0f * (float)Math.PI) * sajh._b(this.rotationPitch / 180.0f * (float)Math.PI) * f;
        this.motionZ = sajh._b(this.rotationYaw / 180.0f * (float)Math.PI) * sajh._b(this.rotationPitch / 180.0f * (float)Math.PI) * f;
        this.motionY = -sajh._a(this.rotationPitch / 180.0f * (float)Math.PI) * f;
        this.calculateVelocity(this.motionX, this.motionY, this.motionZ, 1.5f, 1.0f);
    }

    @Override
    public void entityInit() {
    }

    @Override
    public boolean isInRangeToRenderDist(double d) {
        double d2 = this.boundingBox._b() * 4.0;
        return d < (d2 *= 64.0) * d2;
    }

    public void calculateVelocity(double d, double d2, double d3, float f, float f2) {
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
    public void setPositionAndRotation2(double d, double d2, double d3, float f, float f2, int n) {
        this.fishX = d;
        this.fishY = d2;
        this.fishZ = d3;
        this.fishYaw = f;
        this.fishPitch = f2;
        this.fishPosRotationIncrements = n;
        this.motionX = this.velocityX;
        this.motionY = this.velocityY;
        this.motionZ = this.velocityZ;
    }

    @Override
    public void setVelocity(double d, double d2, double d3) {
        this.velocityX = this.motionX = d;
        this.velocityY = this.motionY = d2;
        this.velocityZ = this.motionZ = d3;
    }

    @Override
    public void onUpdate() {
        int n;
        double d;
        super.onUpdate();
        if (this.fishPosRotationIncrements > 0) {
            double d2 = this.posX + (this.fishX - this.posX) / (double)this.fishPosRotationIncrements;
            double d3 = this.posY + (this.fishY - this.posY) / (double)this.fishPosRotationIncrements;
            double d4 = this.posZ + (this.fishZ - this.posZ) / (double)this.fishPosRotationIncrements;
            double d5 = sajh._f(this.fishYaw - (double)this.rotationYaw);
            this.rotationYaw = (float)((double)this.rotationYaw + d5 / (double)this.fishPosRotationIncrements);
            this.rotationPitch = (float)((double)this.rotationPitch + (this.fishPitch - (double)this.rotationPitch) / (double)this.fishPosRotationIncrements);
            --this.fishPosRotationIncrements;
            this.setPosition(d2, d3, d4);
            this.setRotation(this.rotationYaw, this.rotationPitch);
            return;
        }
        if (!this.worldObj.isRemote) {
            ItemStack itemStack = this.angler.getCurrentEquippedItem();
            if (this.angler.isDead || !this.angler.isEntityAlive() || itemStack == null || itemStack._a() != Item.fishingRod || this.getDistanceSqToEntity(this.angler) > 1024.0) {
                this.setDead();
                this.angler.fishEntity = null;
                return;
            }
            if (this.bobber != null) {
                if (this.bobber.isDead) {
                    this.bobber = null;
                } else {
                    this.posX = this.bobber.posX;
                    this.posY = this.bobber.boundingBox._c + (double)this.bobber.height * 0.8;
                    this.posZ = this.bobber.posZ;
                    return;
                }
            }
        }
        if (this.shake > 0) {
            --this.shake;
        }
        if (this.inGround) {
            int n2 = this.worldObj.getBlockId(this.xTile, this.yTile, this.zTile);
            if (n2 == this.inTile) {
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
        Entity entity = null;
        List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox._a(this.motionX, this.motionY, this.motionZ)._b(1.0, 1.0, 1.0));
        double d6 = 0.0;
        for (int i = 0; i < list.size(); ++i) {
            float f;
            AxisAlignedBB axisAlignedBB;
            MovingObjectPosition movingObjectPosition2;
            Entity entity2 = (Entity)list.get(i);
            if (!entity2.canBeCollidedWith() || entity2 == this.angler && this.ticksInAir < 5 || (movingObjectPosition2 = (axisAlignedBB = entity2.boundingBox._b(f = 0.3f, f, f))._a(vec3, vec32)) == null || !((d = vec3._d(movingObjectPosition2._h)) < d6) && d6 != 0.0) continue;
            entity = entity2;
            d6 = d;
        }
        if (entity != null) {
            movingObjectPosition = new MovingObjectPosition(entity);
        }
        if (movingObjectPosition != null) {
            if (movingObjectPosition._i != null) {
                if (movingObjectPosition._i.attackEntityFrom(DamageSource.causeThrownDamage(this, this.angler), 0.0f)) {
                    this.bobber = movingObjectPosition._i;
                }
            } else {
                this.inGround = true;
            }
        }
        if (this.inGround) {
            return;
        }
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
        float f2 = 0.92f;
        if (this.onGround || this.isCollidedHorizontally) {
            f2 = 0.5f;
        }
        int n3 = 5;
        double d7 = 0.0;
        for (n = 0; n < n3; ++n) {
            double d8 = this.boundingBox._c + (this.boundingBox._f - this.boundingBox._c) * (double)(n + 0) / (double)n3 - 0.125 + 0.125;
            double d9 = this.boundingBox._c + (this.boundingBox._f - this.boundingBox._c) * (double)(n + 1) / (double)n3 - 0.125 + 0.125;
            AxisAlignedBB axisAlignedBB = AxisAlignedBB._a()._a(this.boundingBox._b, d8, this.boundingBox._d, this.boundingBox._e, d9, this.boundingBox._g);
            if (!this.worldObj.isAABBInMaterial(axisAlignedBB, Material._h)) continue;
            d7 += 1.0 / (double)n3;
        }
        if (d7 > 0.0) {
            if (this.ticksCatchable > 0) {
                --this.ticksCatchable;
            } else {
                n = 500;
                if (this.worldObj.canLightningStrikeAt(sajh._c(this.posX), sajh._c(this.posY) + 1, sajh._c(this.posZ))) {
                    n = 300;
                }
                if (this.rand.nextInt(n) == 0) {
                    float f3;
                    float f4;
                    this.ticksCatchable = this.rand.nextInt(30) + 10;
                    this.motionY -= (double)0.2f;
                    this.playSound("random.splash", 0.25f, 1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.4f);
                    float f5 = sajh._c(this.boundingBox._c);
                    int n4 = 0;
                    while ((float)n4 < 1.0f + this.width * 20.0f) {
                        f4 = (this.rand.nextFloat() * 2.0f - 1.0f) * this.width;
                        f3 = (this.rand.nextFloat() * 2.0f - 1.0f) * this.width;
                        this.worldObj.spawnParticle("bubble", this.posX + (double)f4, f5 + 1.0f, this.posZ + (double)f3, this.motionX, this.motionY - (double)(this.rand.nextFloat() * 0.2f), this.motionZ);
                        ++n4;
                    }
                    n4 = 0;
                    while ((float)n4 < 1.0f + this.width * 20.0f) {
                        f4 = (this.rand.nextFloat() * 2.0f - 1.0f) * this.width;
                        f3 = (this.rand.nextFloat() * 2.0f - 1.0f) * this.width;
                        this.worldObj.spawnParticle("splash", this.posX + (double)f4, f5 + 1.0f, this.posZ + (double)f3, this.motionX, this.motionY, this.motionZ);
                        ++n4;
                    }
                }
            }
        }
        if (this.ticksCatchable > 0) {
            this.motionY -= (double)(this.rand.nextFloat() * this.rand.nextFloat() * this.rand.nextFloat()) * 0.2;
        }
        d = d7 * 2.0 - 1.0;
        this.motionY += (double)0.04f * d;
        if (d7 > 0.0) {
            f2 = (float)((double)f2 * 0.9);
            this.motionY *= 0.8;
        }
        this.motionX *= (double)f2;
        this.motionY *= (double)f2;
        this.motionZ *= (double)f2;
        this.setPosition(this.posX, this.posY, this.posZ);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("xTile", (short)this.xTile);
        nBTTagCompound._a("yTile", (short)this.yTile);
        nBTTagCompound._a("zTile", (short)this.zTile);
        nBTTagCompound._a("inTile", (byte)this.inTile);
        nBTTagCompound._a("shake", (byte)this.shake);
        nBTTagCompound._a("inGround", (byte)(this.inGround ? 1 : 0));
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        this.xTile = nBTTagCompound._e("xTile");
        this.yTile = nBTTagCompound._e("yTile");
        this.zTile = nBTTagCompound._e("zTile");
        this.inTile = nBTTagCompound._d("inTile") & 0xFF;
        this.shake = nBTTagCompound._d("shake") & 0xFF;
        this.inGround = nBTTagCompound._d("inGround") == 1;
    }

    @Override
    public float getShadowSize() {
        return 0.0f;
    }

    public int catchFish() {
        if (this.worldObj.isRemote) {
            return 0;
        }
        int n = 0;
        if (this.bobber != null) {
            double d = this.angler.posX - this.posX;
            double d2 = this.angler.posY - this.posY;
            double d3 = this.angler.posZ - this.posZ;
            double d4 = sajh._a(d * d + d2 * d2 + d3 * d3);
            double d5 = 0.1;
            this.bobber.motionX += d * d5;
            this.bobber.motionY += d2 * d5 + (double)sajh._a(d4) * 0.08;
            this.bobber.motionZ += d3 * d5;
            n = 3;
        } else if (this.ticksCatchable > 0) {
            EntityItem entityItem = new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, new ItemStack(Item.fishRaw));
            double d = this.angler.posX - this.posX;
            double d6 = this.angler.posY - this.posY;
            double d7 = this.angler.posZ - this.posZ;
            double d8 = sajh._a(d * d + d6 * d6 + d7 * d7);
            double d9 = 0.1;
            entityItem.motionX = d * d9;
            entityItem.motionY = d6 * d9 + (double)sajh._a(d8) * 0.08;
            entityItem.motionZ = d7 * d9;
            this.worldObj.spawnEntityInWorld(entityItem);
            this.angler.addStat(dzif._B, 1);
            this.angler.worldObj.spawnEntityInWorld(new EntityXPOrb(this.angler.worldObj, this.angler.posX, this.angler.posY + 0.5, this.angler.posZ + 0.5, this.rand.nextInt(6) + 1));
            n = 1;
        }
        if (this.inGround) {
            n = 2;
        }
        this.setDead();
        this.angler.fishEntity = null;
        return n;
    }

    @Override
    public void setDead() {
        super.setDead();
        if (this.angler != null) {
            this.angler.fishEntity = null;
        }
    }
}

