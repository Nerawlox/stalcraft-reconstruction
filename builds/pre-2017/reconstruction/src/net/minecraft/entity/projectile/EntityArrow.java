/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.projectile;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentThorns;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.owak;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet70GameEvent;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class EntityArrow
extends Entity
implements owak {
    public int xTile = -1;
    public int yTile = -1;
    public int zTile = -1;
    public int inTile;
    public int inData;
    public boolean inGround;
    public int canBePickedUp;
    public int arrowShake;
    public Entity shootingEntity;
    public int ticksInGround;
    public int ticksInAir;
    public double damage = 2.0;
    public int knockbackStrength;

    public EntityArrow(World world) {
        super(world);
        this.renderDistanceWeight = 10.0;
        this.setSize(0.5f, 0.5f);
    }

    public EntityArrow(World world, double d, double d2, double d3) {
        super(world);
        this.renderDistanceWeight = 10.0;
        this.setSize(0.5f, 0.5f);
        this.setPosition(d, d2, d3);
        this.yOffset = 0.0f;
    }

    public EntityArrow(World world, EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase2, float f, float f2) {
        super(world);
        this.renderDistanceWeight = 10.0;
        this.shootingEntity = entityLivingBase;
        if (entityLivingBase instanceof EntityPlayer) {
            this.canBePickedUp = 1;
        }
        this.posY = entityLivingBase.posY + (double)entityLivingBase.getEyeHeight() - (double)0.1f;
        double d = entityLivingBase2.posX - entityLivingBase.posX;
        double d2 = entityLivingBase2.boundingBox._c + (double)(entityLivingBase2.height / 3.0f) - this.posY;
        double d3 = entityLivingBase2.posZ - entityLivingBase.posZ;
        double d4 = sajh._a(d * d + d3 * d3);
        if (d4 < 1.0E-7) {
            return;
        }
        float f3 = (float)(Math.atan2(d3, d) * 180.0 / 3.1415927410125732) - 90.0f;
        float f4 = (float)(-(Math.atan2(d2, d4) * 180.0 / 3.1415927410125732));
        double d5 = d / d4;
        double d6 = d3 / d4;
        this.setLocationAndAngles(entityLivingBase.posX + d5, this.posY, entityLivingBase.posZ + d6, f3, f4);
        this.yOffset = 0.0f;
        float f5 = (float)d4 * 0.2f;
        this.setThrowableHeading(d, d2 + (double)f5, d3, f, f2);
    }

    public EntityArrow(World world, EntityLivingBase entityLivingBase, float f) {
        super(world);
        this.renderDistanceWeight = 10.0;
        this.shootingEntity = entityLivingBase;
        if (entityLivingBase instanceof EntityPlayer) {
            this.canBePickedUp = 1;
        }
        this.setSize(0.5f, 0.5f);
        this.setLocationAndAngles(entityLivingBase.posX, entityLivingBase.posY + (double)entityLivingBase.getEyeHeight(), entityLivingBase.posZ, entityLivingBase.rotationYaw, entityLivingBase.rotationPitch);
        this.posX -= (double)(sajh._b(this.rotationYaw / 180.0f * (float)Math.PI) * 0.16f);
        this.posY -= (double)0.1f;
        this.posZ -= (double)(sajh._a(this.rotationYaw / 180.0f * (float)Math.PI) * 0.16f);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.yOffset = 0.0f;
        this.motionX = -sajh._a(this.rotationYaw / 180.0f * (float)Math.PI) * sajh._b(this.rotationPitch / 180.0f * (float)Math.PI);
        this.motionZ = sajh._b(this.rotationYaw / 180.0f * (float)Math.PI) * sajh._b(this.rotationPitch / 180.0f * (float)Math.PI);
        this.motionY = -sajh._a(this.rotationPitch / 180.0f * (float)Math.PI);
        this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, f * 1.5f, 1.0f);
    }

    @Override
    public void entityInit() {
        this.dataWatcher._a(16, (Object)0);
    }

    @Override
    public void setThrowableHeading(double d, double d2, double d3, float f, float f2) {
        float f3 = sajh._a(d * d + d2 * d2 + d3 * d3);
        d /= (double)f3;
        d2 /= (double)f3;
        d3 /= (double)f3;
        d += this.rand.nextGaussian() * (double)(this.rand.nextBoolean() ? -1 : 1) * (double)0.0075f * (double)f2;
        d2 += this.rand.nextGaussian() * (double)(this.rand.nextBoolean() ? -1 : 1) * (double)0.0075f * (double)f2;
        d3 += this.rand.nextGaussian() * (double)(this.rand.nextBoolean() ? -1 : 1) * (double)0.0075f * (double)f2;
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
        this.setPosition(d, d2, d3);
        this.setRotation(f, f2);
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
            this.prevRotationPitch = this.rotationPitch;
            this.prevRotationYaw = this.rotationYaw;
            this.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
            this.ticksInGround = 0;
        }
    }

    @Override
    public void onUpdate() {
        Object object;
        int n;
        Object object2;
        int n2;
        super.onUpdate();
        if (this.prevRotationPitch == 0.0f && this.prevRotationYaw == 0.0f) {
            float f = sajh._a(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0 / 3.1415927410125732);
            this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(this.motionY, f) * 180.0 / 3.1415927410125732);
        }
        if ((n2 = this.worldObj.getBlockId(this.xTile, this.yTile, this.zTile)) > 0) {
            Block.blocksList[n2].setBlockBoundsBasedOnState(this.worldObj, this.xTile, this.yTile, this.zTile);
            object2 = Block.blocksList[n2].getCollisionBoundingBoxFromPool(this.worldObj, this.xTile, this.yTile, this.zTile);
            if (object2 != null && ((AxisAlignedBB)object2)._a(this.worldObj.getWorldVec3Pool()._a(this.posX, this.posY, this.posZ))) {
                this.inGround = true;
            }
        }
        if (this.arrowShake > 0) {
            --this.arrowShake;
        }
        if (this.inGround) {
            int n3 = this.worldObj.getBlockId(this.xTile, this.yTile, this.zTile);
            int n4 = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);
            if (n3 != this.inTile || n4 != this.inData) {
                this.inGround = false;
                this.motionX *= (double)(this.rand.nextFloat() * 0.2f);
                this.motionY *= (double)(this.rand.nextFloat() * 0.2f);
                this.motionZ *= (double)(this.rand.nextFloat() * 0.2f);
                this.ticksInGround = 0;
                this.ticksInAir = 0;
                return;
            }
            ++this.ticksInGround;
            if (this.ticksInGround == 1200) {
                this.setDead();
            }
            return;
        }
        ++this.ticksInAir;
        object2 = this.worldObj.getWorldVec3Pool()._a(this.posX, this.posY, this.posZ);
        Vec3 vec3 = this.worldObj.getWorldVec3Pool()._a(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        MovingObjectPosition movingObjectPosition = this.worldObj.func_72831_a((Vec3)object2, vec3, false, true);
        object2 = this.worldObj.getWorldVec3Pool()._a(this.posX, this.posY, this.posZ);
        vec3 = this.worldObj.getWorldVec3Pool()._a(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        if (movingObjectPosition != null) {
            vec3 = this.worldObj.getWorldVec3Pool()._a(movingObjectPosition._h._c, movingObjectPosition._h._d, movingObjectPosition._h._e);
        }
        Entity entity = null;
        List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox._a(this.motionX, this.motionY, this.motionZ)._b(1.0, 1.0, 1.0));
        double d = 0.0;
        for (n = 0; n < list2.size(); ++n) {
            double d2;
            float f;
            MovingObjectPosition movingObjectPosition2;
            Entity entity2 = (Entity)list2.get(n);
            if (!entity2.canBeCollidedWith() || entity2 == this.shootingEntity && this.ticksInAir < 5 || (movingObjectPosition2 = ((AxisAlignedBB)(object = entity2.boundingBox._b(f = 0.3f, f, f)))._a((Vec3)object2, vec3)) == null || !((d2 = ((Vec3)object2)._d(movingObjectPosition2._h)) < d) && d != 0.0) continue;
            entity = entity2;
            d = d2;
        }
        if (entity != null) {
            movingObjectPosition = new MovingObjectPosition(entity);
        }
        if (movingObjectPosition != null && movingObjectPosition._i != null && movingObjectPosition._i instanceof EntityPlayer) {
            EntityPlayer entityPlayer = (EntityPlayer)movingObjectPosition._i;
            if (entityPlayer.capabilities._a || this.shootingEntity instanceof EntityPlayer && !((EntityPlayer)this.shootingEntity).canAttackPlayer(entityPlayer)) {
                movingObjectPosition = null;
            }
        }
        if (movingObjectPosition != null) {
            if (movingObjectPosition._i != null) {
                float f = sajh._a(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
                int n5 = sajh._e((double)f * this.damage);
                if (this.getIsCritical()) {
                    n5 += this.rand.nextInt(n5 / 2 + 2);
                }
                DamageSource damageSource = null;
                damageSource = this.shootingEntity == null ? DamageSource.causeArrowDamage(this, this) : DamageSource.causeArrowDamage(this, this.shootingEntity);
                if (this.isBurning() && !(movingObjectPosition._i instanceof EntityEnderman)) {
                    movingObjectPosition._i.setFire(5);
                }
                if (movingObjectPosition._i.attackEntityFrom(damageSource, n5)) {
                    if (movingObjectPosition._i instanceof EntityLivingBase) {
                        float f2;
                        object = (EntityLivingBase)movingObjectPosition._i;
                        if (!this.worldObj.isRemote) {
                            ((EntityLivingBase)object).setArrowCountInEntity(((EntityLivingBase)object).getArrowCountInEntity() + 1);
                        }
                        if (this.knockbackStrength > 0 && (f2 = sajh._a(this.motionX * this.motionX + this.motionZ * this.motionZ)) > 0.0f) {
                            movingObjectPosition._i.addVelocity(this.motionX * (double)this.knockbackStrength * (double)0.6f / (double)f2, 0.1, this.motionZ * (double)this.knockbackStrength * (double)0.6f / (double)f2);
                        }
                        if (this.shootingEntity != null) {
                            EnchantmentThorns._a(this.shootingEntity, (EntityLivingBase)object, this.rand);
                        }
                        if (this.shootingEntity != null && movingObjectPosition._i != this.shootingEntity && movingObjectPosition._i instanceof EntityPlayer && this.shootingEntity instanceof EntityPlayerMP) {
                            ((EntityPlayerMP)this.shootingEntity).playerNetServerHandler.func_72567_b(new Packet70GameEvent(6, 0));
                        }
                    }
                    this.playSound("random.bowhit", 1.0f, 1.2f / (this.rand.nextFloat() * 0.2f + 0.9f));
                    if (!(movingObjectPosition._i instanceof EntityEnderman)) {
                        this.setDead();
                    }
                } else {
                    this.motionX *= (double)-0.1f;
                    this.motionY *= (double)-0.1f;
                    this.motionZ *= (double)-0.1f;
                    this.rotationYaw += 180.0f;
                    this.prevRotationYaw += 180.0f;
                    this.ticksInAir = 0;
                }
            } else {
                this.xTile = movingObjectPosition._d;
                this.yTile = movingObjectPosition._e;
                this.zTile = movingObjectPosition._f;
                this.inTile = this.worldObj.getBlockId(this.xTile, this.yTile, this.zTile);
                this.inData = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);
                this.motionX = (float)(movingObjectPosition._h._c - this.posX);
                this.motionY = (float)(movingObjectPosition._h._d - this.posY);
                this.motionZ = (float)(movingObjectPosition._h._e - this.posZ);
                float f = sajh._a(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
                this.posX -= this.motionX / (double)f * (double)0.05f;
                this.posY -= this.motionY / (double)f * (double)0.05f;
                this.posZ -= this.motionZ / (double)f * (double)0.05f;
                this.playSound("random.bowhit", 1.0f, 1.2f / (this.rand.nextFloat() * 0.2f + 0.9f));
                this.inGround = true;
                this.arrowShake = 7;
                this.setIsCritical(false);
                if (this.inTile != 0) {
                    Block.blocksList[this.inTile].onEntityCollidedWithBlock(this.worldObj, this.xTile, this.yTile, this.zTile, this);
                }
            }
        }
        if (this.getIsCritical()) {
            for (n = 0; n < 4; ++n) {
                this.worldObj.spawnParticle("crit", this.posX + this.motionX * (double)n / 4.0, this.posY + this.motionY * (double)n / 4.0, this.posZ + this.motionZ * (double)n / 4.0, -this.motionX, -this.motionY + 0.2, -this.motionZ);
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
        float f3 = 0.99f;
        float f4 = 0.05f;
        if (this.isInWater()) {
            for (int i = 0; i < 4; ++i) {
                float f5 = 0.25f;
                this.worldObj.spawnParticle("bubble", this.posX - this.motionX * (double)f5, this.posY - this.motionY * (double)f5, this.posZ - this.motionZ * (double)f5, this.motionX, this.motionY, this.motionZ);
            }
            f3 = 0.8f;
        }
        this.motionX *= (double)f3;
        this.motionY *= (double)f3;
        this.motionZ *= (double)f3;
        this.motionY -= (double)f4;
        this.setPosition(this.posX, this.posY, this.posZ);
        this.doBlockCollisions();
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("xTile", (short)this.xTile);
        nBTTagCompound._a("yTile", (short)this.yTile);
        nBTTagCompound._a("zTile", (short)this.zTile);
        nBTTagCompound._a("inTile", (byte)this.inTile);
        nBTTagCompound._a("inData", (byte)this.inData);
        nBTTagCompound._a("shake", (byte)this.arrowShake);
        nBTTagCompound._a("inGround", (byte)(this.inGround ? 1 : 0));
        nBTTagCompound._a("pickup", (byte)this.canBePickedUp);
        nBTTagCompound._a("damage", this.damage);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        this.xTile = nBTTagCompound._e("xTile");
        this.yTile = nBTTagCompound._e("yTile");
        this.zTile = nBTTagCompound._e("zTile");
        this.inTile = nBTTagCompound._d("inTile") & 0xFF;
        this.inData = nBTTagCompound._d("inData") & 0xFF;
        this.arrowShake = nBTTagCompound._d("shake") & 0xFF;
        boolean bl = this.inGround = nBTTagCompound._d("inGround") == 1;
        if (nBTTagCompound._c("damage")) {
            this.damage = nBTTagCompound._i("damage");
        }
        if (nBTTagCompound._c("pickup")) {
            this.canBePickedUp = nBTTagCompound._d("pickup");
        } else if (nBTTagCompound._c("player")) {
            this.canBePickedUp = nBTTagCompound._o("player") ? 1 : 0;
        }
    }

    @Override
    public void onCollideWithPlayer(EntityPlayer entityPlayer) {
        boolean bl;
        if (this.worldObj.isRemote || !this.inGround || this.arrowShake > 0) {
            return;
        }
        boolean bl2 = bl = this.canBePickedUp == 1 || this.canBePickedUp == 2 && entityPlayer.capabilities._d;
        if (this.canBePickedUp == 1 && !entityPlayer.inventory._c(new ItemStack(Item.arrow, 1))) {
            bl = false;
        }
        if (bl) {
            this.playSound("random.pop", 0.2f, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7f + 1.0f) * 2.0f);
            entityPlayer.onItemPickup(this, 1);
            this.setDead();
        }
    }

    @Override
    public boolean canTriggerWalking() {
        return false;
    }

    @Override
    public float getShadowSize() {
        return 0.0f;
    }

    public void setDamage(double d) {
        this.damage = d;
    }

    public double getDamage() {
        return this.damage;
    }

    public void setKnockbackStrength(int n) {
        this.knockbackStrength = n;
    }

    @Override
    public boolean canAttackWithItem() {
        return false;
    }

    public void setIsCritical(boolean bl) {
        byte by = this.dataWatcher._a(16);
        if (bl) {
            this.dataWatcher._b(16, (byte)(by | 1));
        } else {
            this.dataWatcher._b(16, (byte)(by & 0xFFFFFFFE));
        }
    }

    public boolean getIsCritical() {
        byte by = this.dataWatcher._a(16);
        return (by & 1) != 0;
    }
}

