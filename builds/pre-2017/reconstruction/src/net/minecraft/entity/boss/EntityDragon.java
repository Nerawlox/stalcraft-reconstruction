/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.boss;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEndPortal;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.entity.boss.eidj;
import net.minecraft.entity.ezfa;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.ezey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class EntityDragon
extends EntityLiving
implements eidj,
ezfa,
ezey {
    public double targetX;
    public double targetY;
    public double targetZ;
    public double[][] ringBuffer = new double[64][3];
    public int ringBufferIndex = -1;
    public EntityDragonPart[] dragonPartArray;
    public EntityDragonPart dragonPartHead = new EntityDragonPart(this, "head", 6.0f, 6.0f);
    public EntityDragonPart dragonPartBody = new EntityDragonPart(this, "body", 8.0f, 8.0f);
    public EntityDragonPart dragonPartTail1 = new EntityDragonPart(this, "tail", 4.0f, 4.0f);
    public EntityDragonPart dragonPartTail2 = new EntityDragonPart(this, "tail", 4.0f, 4.0f);
    public EntityDragonPart dragonPartTail3 = new EntityDragonPart(this, "tail", 4.0f, 4.0f);
    public EntityDragonPart dragonPartWing1 = new EntityDragonPart(this, "wing", 4.0f, 4.0f);
    public EntityDragonPart dragonPartWing2 = new EntityDragonPart(this, "wing", 4.0f, 4.0f);
    public float prevAnimTime;
    public float animTime;
    public boolean forceNewTarget;
    public boolean slowed;
    public Entity target;
    public int deathTicks;
    public EntityEnderCrystal healingEnderCrystal;

    public EntityDragon(World world) {
        super(world);
        this.dragonPartArray = new EntityDragonPart[]{this.dragonPartHead, this.dragonPartBody, this.dragonPartTail1, this.dragonPartTail2, this.dragonPartTail3, this.dragonPartWing1, this.dragonPartWing2};
        this.setHealth(this.getMaxHealth());
        this.setSize(16.0f, 8.0f);
        this.noClip = true;
        this.isImmuneToFire = true;
        this.targetY = 100.0;
        this.ignoreFrustumCheck = true;
    }

    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(sajz._a)._a(200.0);
    }

    @Override
    public void entityInit() {
        super.entityInit();
    }

    public double[] getMovementOffsets(int n, float f) {
        if (this.getHealth() <= 0.0f) {
            f = 0.0f;
        }
        f = 1.0f - f;
        int n2 = this.ringBufferIndex - n * 1 & 0x3F;
        int n3 = this.ringBufferIndex - n * 1 - 1 & 0x3F;
        double[] dArray = new double[3];
        double d = this.ringBuffer[n2][0];
        double d2 = sajh._f(this.ringBuffer[n3][0] - d);
        dArray[0] = d + d2 * (double)f;
        d = this.ringBuffer[n2][1];
        d2 = this.ringBuffer[n3][1] - d;
        dArray[1] = d + d2 * (double)f;
        dArray[2] = this.ringBuffer[n2][2] + (this.ringBuffer[n3][2] - this.ringBuffer[n2][2]) * (double)f;
        return dArray;
    }

    @Override
    public void onLivingUpdate() {
        float f;
        float f2;
        if (this.worldObj.isRemote) {
            f2 = sajh._b(this.animTime * (float)Math.PI * 2.0f);
            f = sajh._b(this.prevAnimTime * (float)Math.PI * 2.0f);
            if (f <= -0.3f && f2 >= -0.3f) {
                this.worldObj.playSound(this.posX, this.posY, this.posZ, "mob.enderdragon.wings", 5.0f, 0.8f + this.rand.nextFloat() * 0.3f, false);
            }
        }
        this.prevAnimTime = this.animTime;
        if (this.getHealth() <= 0.0f) {
            f2 = (this.rand.nextFloat() - 0.5f) * 8.0f;
            f = (this.rand.nextFloat() - 0.5f) * 4.0f;
            float f3 = (this.rand.nextFloat() - 0.5f) * 8.0f;
            this.worldObj.spawnParticle("largeexplode", this.posX + (double)f2, this.posY + 2.0 + (double)f, this.posZ + (double)f3, 0.0, 0.0, 0.0);
        } else {
            float f4;
            float f5;
            float f6;
            float f7;
            Object object;
            Object object2;
            float f8;
            double d;
            double d2;
            double d3;
            double d4;
            this.updateDragonEnderCrystal();
            f2 = 0.2f / (sajh._a(this.motionX * this.motionX + this.motionZ * this.motionZ) * 10.0f + 1.0f);
            this.animTime = this.slowed ? (this.animTime += f2 * 0.5f) : (this.animTime += (f2 *= (float)Math.pow(2.0, this.motionY)));
            this.rotationYaw = sajh._g(this.rotationYaw);
            if (this.ringBufferIndex < 0) {
                for (int i = 0; i < this.ringBuffer.length; ++i) {
                    this.ringBuffer[i][0] = this.rotationYaw;
                    this.ringBuffer[i][1] = this.posY;
                }
            }
            if (++this.ringBufferIndex == this.ringBuffer.length) {
                this.ringBufferIndex = 0;
            }
            this.ringBuffer[this.ringBufferIndex][0] = this.rotationYaw;
            this.ringBuffer[this.ringBufferIndex][1] = this.posY;
            if (this.worldObj.isRemote) {
                if (this.newPosRotationIncrements > 0) {
                    d4 = this.posX + (this.newPosX - this.posX) / (double)this.newPosRotationIncrements;
                    d3 = this.posY + (this.newPosY - this.posY) / (double)this.newPosRotationIncrements;
                    d2 = this.posZ + (this.newPosZ - this.posZ) / (double)this.newPosRotationIncrements;
                    d = sajh._f(this.newRotationYaw - (double)this.rotationYaw);
                    this.rotationYaw = (float)((double)this.rotationYaw + d / (double)this.newPosRotationIncrements);
                    this.rotationPitch = (float)((double)this.rotationPitch + (this.newRotationPitch - (double)this.rotationPitch) / (double)this.newPosRotationIncrements);
                    --this.newPosRotationIncrements;
                    this.setPosition(d4, d3, d2);
                    this.setRotation(this.rotationYaw, this.rotationPitch);
                }
            } else {
                double d5;
                double d6;
                d4 = this.targetX - this.posX;
                d3 = this.targetY - this.posY;
                d2 = this.targetZ - this.posZ;
                d = d4 * d4 + d3 * d3 + d2 * d2;
                if (this.target != null) {
                    this.targetX = this.target.posX;
                    this.targetZ = this.target.posZ;
                    d6 = this.targetX - this.posX;
                    d5 = this.targetZ - this.posZ;
                    double d7 = Math.sqrt(d6 * d6 + d5 * d5);
                    double d8 = (double)0.4f + d7 / 80.0 - 1.0;
                    if (d8 > 10.0) {
                        d8 = 10.0;
                    }
                    this.targetY = this.target.boundingBox._c + d8;
                } else {
                    this.targetX += this.rand.nextGaussian() * 2.0;
                    this.targetZ += this.rand.nextGaussian() * 2.0;
                }
                if (this.forceNewTarget || d < 100.0 || d > 22500.0 || this.isCollidedHorizontally || this.isCollidedVertically) {
                    this.setNewTarget();
                }
                if ((d3 /= (double)sajh._a(d4 * d4 + d2 * d2)) < (double)(-(f8 = 0.6f))) {
                    d3 = -f8;
                }
                if (d3 > (double)f8) {
                    d3 = f8;
                }
                this.motionY += d3 * (double)0.1f;
                this.rotationYaw = sajh._g(this.rotationYaw);
                d6 = 180.0 - Math.atan2(d4, d2) * 180.0 / Math.PI;
                d5 = sajh._f(d6 - (double)this.rotationYaw);
                if (d5 > 50.0) {
                    d5 = 50.0;
                }
                if (d5 < -50.0) {
                    d5 = -50.0;
                }
                object2 = this.worldObj.getWorldVec3Pool()._a(this.targetX - this.posX, this.targetY - this.posY, this.targetZ - this.posZ)._a();
                object = this.worldObj.getWorldVec3Pool()._a(sajh._a(this.rotationYaw * (float)Math.PI / 180.0f), this.motionY, -sajh._b(this.rotationYaw * (float)Math.PI / 180.0f))._a();
                f7 = (float)(((Vec3)object)._b((Vec3)object2) + 0.5) / 1.5f;
                if (f7 < 0.0f) {
                    f7 = 0.0f;
                }
                this.randomYawVelocity *= 0.8f;
                float f9 = sajh._a(this.motionX * this.motionX + this.motionZ * this.motionZ) * 1.0f + 1.0f;
                double d9 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ) * 1.0 + 1.0;
                if (d9 > 40.0) {
                    d9 = 40.0;
                }
                this.randomYawVelocity = (float)((double)this.randomYawVelocity + d5 * ((double)0.7f / d9 / (double)f9));
                this.rotationYaw += this.randomYawVelocity * 0.1f;
                f6 = (float)(2.0 / (d9 + 1.0));
                f5 = 0.06f;
                this.moveFlying(0.0f, -1.0f, f5 * (f7 * f6 + (1.0f - f6)));
                if (this.slowed) {
                    this.moveEntity(this.motionX * (double)0.8f, this.motionY * (double)0.8f, this.motionZ * (double)0.8f);
                } else {
                    this.moveEntity(this.motionX, this.motionY, this.motionZ);
                }
                Vec3 vec3 = this.worldObj.getWorldVec3Pool()._a(this.motionX, this.motionY, this.motionZ)._a();
                f4 = (float)(vec3._b((Vec3)object) + 1.0) / 2.0f;
                f4 = 0.8f + 0.15f * f4;
                this.motionX *= (double)f4;
                this.motionZ *= (double)f4;
                this.motionY *= (double)0.91f;
            }
            this.renderYawOffset = this.rotationYaw;
            this.dragonPartHead.height = 3.0f;
            this.dragonPartHead.width = 3.0f;
            this.dragonPartTail1.height = 2.0f;
            this.dragonPartTail1.width = 2.0f;
            this.dragonPartTail2.height = 2.0f;
            this.dragonPartTail2.width = 2.0f;
            this.dragonPartTail3.height = 2.0f;
            this.dragonPartTail3.width = 2.0f;
            this.dragonPartBody.height = 3.0f;
            this.dragonPartBody.width = 5.0f;
            this.dragonPartWing1.height = 2.0f;
            this.dragonPartWing1.width = 4.0f;
            this.dragonPartWing2.height = 3.0f;
            this.dragonPartWing2.width = 4.0f;
            f = (float)(this.getMovementOffsets(5, 1.0f)[1] - this.getMovementOffsets(10, 1.0f)[1]) * 10.0f / 180.0f * (float)Math.PI;
            float f10 = sajh._b(f);
            float f11 = -sajh._a(f);
            float f12 = this.rotationYaw * (float)Math.PI / 180.0f;
            float f13 = sajh._a(f12);
            float f14 = sajh._b(f12);
            this.dragonPartBody.onUpdate();
            this.dragonPartBody.setLocationAndAngles(this.posX + (double)(f13 * 0.5f), this.posY, this.posZ - (double)(f14 * 0.5f), 0.0f, 0.0f);
            this.dragonPartWing1.onUpdate();
            this.dragonPartWing1.setLocationAndAngles(this.posX + (double)(f14 * 4.5f), this.posY + 2.0, this.posZ + (double)(f13 * 4.5f), 0.0f, 0.0f);
            this.dragonPartWing2.onUpdate();
            this.dragonPartWing2.setLocationAndAngles(this.posX - (double)(f14 * 4.5f), this.posY + 2.0, this.posZ - (double)(f13 * 4.5f), 0.0f, 0.0f);
            if (!this.worldObj.isRemote && this.hurtTime == 0) {
                this.collideWithEntities(this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.dragonPartWing1.boundingBox._b(4.0, 2.0, 4.0)._d(0.0, -2.0, 0.0)));
                this.collideWithEntities(this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.dragonPartWing2.boundingBox._b(4.0, 2.0, 4.0)._d(0.0, -2.0, 0.0)));
                this.attackEntitiesInList(this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.dragonPartHead.boundingBox._b(1.0, 1.0, 1.0)));
            }
            object2 = this.getMovementOffsets(5, 1.0f);
            object = this.getMovementOffsets(0, 1.0f);
            f8 = sajh._a(this.rotationYaw * (float)Math.PI / 180.0f - this.randomYawVelocity * 0.01f);
            f7 = sajh._b(this.rotationYaw * (float)Math.PI / 180.0f - this.randomYawVelocity * 0.01f);
            this.dragonPartHead.onUpdate();
            this.dragonPartHead.setLocationAndAngles(this.posX + (double)(f8 * 5.5f * f10), this.posY + (object[1] - object2[1]) * 1.0 + (double)(f11 * 5.5f), this.posZ - (double)(f7 * 5.5f * f10), 0.0f, 0.0f);
            for (int i = 0; i < 3; ++i) {
                EntityDragonPart entityDragonPart = null;
                if (i == 0) {
                    entityDragonPart = this.dragonPartTail1;
                }
                if (i == 1) {
                    entityDragonPart = this.dragonPartTail2;
                }
                if (i == 2) {
                    entityDragonPart = this.dragonPartTail3;
                }
                double[] dArray = this.getMovementOffsets(12 + i * 2, 1.0f);
                f6 = this.rotationYaw * (float)Math.PI / 180.0f + this.simplifyAngle(dArray[0] - object2[0]) * (float)Math.PI / 180.0f * 1.0f;
                f5 = sajh._a(f6);
                float f15 = sajh._b(f6);
                f4 = 1.5f;
                float f16 = (float)(i + 1) * 2.0f;
                entityDragonPart.onUpdate();
                entityDragonPart.setLocationAndAngles(this.posX - (double)((f13 * f4 + f5 * f16) * f10), this.posY + (dArray[1] - object2[1]) * 1.0 - (double)((f16 + f4) * f11) + 1.5, this.posZ + (double)((f14 * f4 + f15 * f16) * f10), 0.0f, 0.0f);
            }
            if (!this.worldObj.isRemote) {
                this.slowed = this.destroyBlocksInAABB(this.dragonPartHead.boundingBox) | this.destroyBlocksInAABB(this.dragonPartBody.boundingBox);
            }
        }
    }

    public void updateDragonEnderCrystal() {
        if (this.healingEnderCrystal != null) {
            if (this.healingEnderCrystal.isDead) {
                if (!this.worldObj.isRemote) {
                    this.attackEntityFromPart(this.dragonPartHead, DamageSource.setExplosionSource(null), 10.0f);
                }
                this.healingEnderCrystal = null;
            } else if (this.ticksExisted % 10 == 0 && this.getHealth() < this.getMaxHealth()) {
                this.setHealth(this.getHealth() + 1.0f);
            }
        }
        if (this.rand.nextInt(10) == 0) {
            float f = 32.0f;
            List list2 = this.worldObj.getEntitiesWithinAABB(EntityEnderCrystal.class, this.boundingBox._b(f, f, f));
            EntityEnderCrystal entityEnderCrystal = null;
            double d = Double.MAX_VALUE;
            for (EntityEnderCrystal entityEnderCrystal2 : list2) {
                double d2 = entityEnderCrystal2.getDistanceSqToEntity(this);
                if (!(d2 < d)) continue;
                d = d2;
                entityEnderCrystal = entityEnderCrystal2;
            }
            this.healingEnderCrystal = entityEnderCrystal;
        }
    }

    public void collideWithEntities(List list2) {
        double d = (this.dragonPartBody.boundingBox._b + this.dragonPartBody.boundingBox._e) / 2.0;
        double d2 = (this.dragonPartBody.boundingBox._d + this.dragonPartBody.boundingBox._g) / 2.0;
        for (Entity entity : list2) {
            if (!(entity instanceof EntityLivingBase)) continue;
            double d3 = entity.posX - d;
            double d4 = entity.posZ - d2;
            double d5 = d3 * d3 + d4 * d4;
            entity.addVelocity(d3 / d5 * 4.0, 0.2f, d4 / d5 * 4.0);
        }
    }

    public void attackEntitiesInList(List list2) {
        for (int i = 0; i < list2.size(); ++i) {
            Entity entity = (Entity)list2.get(i);
            if (!(entity instanceof EntityLivingBase)) continue;
            entity.attackEntityFrom(DamageSource.causeMobDamage(this), 10.0f);
        }
    }

    public void setNewTarget() {
        this.forceNewTarget = false;
        if (this.rand.nextInt(2) == 0 && !this.worldObj.playerEntities.isEmpty()) {
            this.target = (Entity)this.worldObj.playerEntities.get(this.rand.nextInt(this.worldObj.playerEntities.size()));
        } else {
            double d;
            double d2;
            double d3;
            boolean bl = false;
            do {
                this.targetX = 0.0;
                this.targetY = 70.0f + this.rand.nextFloat() * 50.0f;
                this.targetZ = 0.0;
                this.targetX += (double)(this.rand.nextFloat() * 120.0f - 60.0f);
                this.targetZ += (double)(this.rand.nextFloat() * 120.0f - 60.0f);
            } while (!(bl = (d3 = this.posX - this.targetX) * d3 + (d2 = this.posY - this.targetY) * d2 + (d = this.posZ - this.targetZ) * d > 100.0));
            this.target = null;
        }
    }

    public float simplifyAngle(double d) {
        return (float)sajh._f(d);
    }

    public boolean destroyBlocksInAABB(AxisAlignedBB axisAlignedBB) {
        int n = sajh._c(axisAlignedBB._b);
        int n2 = sajh._c(axisAlignedBB._c);
        int n3 = sajh._c(axisAlignedBB._d);
        int n4 = sajh._c(axisAlignedBB._e);
        int n5 = sajh._c(axisAlignedBB._f);
        int n6 = sajh._c(axisAlignedBB._g);
        boolean bl = false;
        boolean bl2 = false;
        for (int i = n; i <= n4; ++i) {
            for (int j = n2; j <= n5; ++j) {
                for (int k = n3; k <= n6; ++k) {
                    int n7 = this.worldObj.getBlockId(i, j, k);
                    Block block = Block.blocksList[n7];
                    if (block == null) continue;
                    if (block.canEntityDestroy(this.worldObj, i, j, k, this) && this.worldObj.getGameRules()._b("mobGriefing")) {
                        bl2 = this.worldObj.setBlockToAir(i, j, k) || bl2;
                        continue;
                    }
                    bl = true;
                }
            }
        }
        if (bl2) {
            double d = axisAlignedBB._b + (axisAlignedBB._e - axisAlignedBB._b) * (double)this.rand.nextFloat();
            double d2 = axisAlignedBB._c + (axisAlignedBB._f - axisAlignedBB._c) * (double)this.rand.nextFloat();
            double d3 = axisAlignedBB._d + (axisAlignedBB._g - axisAlignedBB._d) * (double)this.rand.nextFloat();
            this.worldObj.spawnParticle("largeexplode", d, d2, d3, 0.0, 0.0, 0.0);
        }
        return bl;
    }

    @Override
    public boolean attackEntityFromPart(EntityDragonPart entityDragonPart, DamageSource damageSource, float f) {
        if (entityDragonPart != this.dragonPartHead) {
            f = f / 4.0f + 1.0f;
        }
        float f2 = this.rotationYaw * (float)Math.PI / 180.0f;
        float f3 = sajh._a(f2);
        float f4 = sajh._b(f2);
        this.targetX = this.posX + (double)(f3 * 5.0f) + (double)((this.rand.nextFloat() - 0.5f) * 2.0f);
        this.targetY = this.posY + (double)(this.rand.nextFloat() * 3.0f) + 1.0;
        this.targetZ = this.posZ - (double)(f4 * 5.0f) + (double)((this.rand.nextFloat() - 0.5f) * 2.0f);
        this.target = null;
        if (damageSource.getEntity() instanceof EntityPlayer || damageSource.isExplosion()) {
            this.func_82195_e(damageSource, f);
        }
        return true;
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        return false;
    }

    public boolean func_82195_e(DamageSource damageSource, float f) {
        return super.attackEntityFrom(damageSource, f);
    }

    @Override
    public void onDeathUpdate() {
        ++this.deathTicks;
        if (this.deathTicks >= 180 && this.deathTicks <= 200) {
            float f = (this.rand.nextFloat() - 0.5f) * 8.0f;
            float f2 = (this.rand.nextFloat() - 0.5f) * 4.0f;
            float f3 = (this.rand.nextFloat() - 0.5f) * 8.0f;
            this.worldObj.spawnParticle("hugeexplosion", this.posX + (double)f, this.posY + 2.0 + (double)f2, this.posZ + (double)f3, 0.0, 0.0, 0.0);
        }
        if (!this.worldObj.isRemote) {
            if (this.deathTicks > 150 && this.deathTicks % 5 == 0) {
                int n;
                for (int i = 1000; i > 0; i -= n) {
                    n = EntityXPOrb.getXPSplit(i);
                    this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, n));
                }
            }
            if (this.deathTicks == 1) {
                this.worldObj.func_82739_e(1018, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
            }
        }
        this.moveEntity(0.0, 0.1f, 0.0);
        this.renderYawOffset = this.rotationYaw += 20.0f;
        if (this.deathTicks == 200 && !this.worldObj.isRemote) {
            int n;
            for (int i = 2000; i > 0; i -= n) {
                n = EntityXPOrb.getXPSplit(i);
                this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, n));
            }
            this.createEnderPortal(sajh._c(this.posX), sajh._c(this.posZ));
            this.setDead();
        }
    }

    public void createEnderPortal(int n, int n2) {
        int n3 = 64;
        BlockEndPortal._a = true;
        int n4 = 4;
        for (int i = n3 - 1; i <= n3 + 32; ++i) {
            for (int j = n - n4; j <= n + n4; ++j) {
                for (int k = n2 - n4; k <= n2 + n4; ++k) {
                    double d = j - n;
                    double d2 = k - n2;
                    double d3 = d * d + d2 * d2;
                    if (!(d3 <= ((double)n4 - 0.5) * ((double)n4 - 0.5))) continue;
                    if (i < n3) {
                        if (!(d3 <= ((double)(n4 - 1) - 0.5) * ((double)(n4 - 1) - 0.5))) continue;
                        this.worldObj.setBlock(j, i, k, Block.bedrock.blockID);
                        continue;
                    }
                    if (i > n3) {
                        this.worldObj.setBlock(j, i, k, 0);
                        continue;
                    }
                    if (d3 > ((double)(n4 - 1) - 0.5) * ((double)(n4 - 1) - 0.5)) {
                        this.worldObj.setBlock(j, i, k, Block.bedrock.blockID);
                        continue;
                    }
                    this.worldObj.setBlock(j, i, k, Block.endPortal.blockID);
                }
            }
        }
        this.worldObj.setBlock(n, n3 + 0, n2, Block.bedrock.blockID);
        this.worldObj.setBlock(n, n3 + 1, n2, Block.bedrock.blockID);
        this.worldObj.setBlock(n, n3 + 2, n2, Block.bedrock.blockID);
        this.worldObj.setBlock(n - 1, n3 + 2, n2, Block.torchWood.blockID);
        this.worldObj.setBlock(n + 1, n3 + 2, n2, Block.torchWood.blockID);
        this.worldObj.setBlock(n, n3 + 2, n2 - 1, Block.torchWood.blockID);
        this.worldObj.setBlock(n, n3 + 2, n2 + 1, Block.torchWood.blockID);
        this.worldObj.setBlock(n, n3 + 3, n2, Block.bedrock.blockID);
        this.worldObj.setBlock(n, n3 + 4, n2, Block.dragonEgg.blockID);
        BlockEndPortal._a = false;
    }

    @Override
    public void despawnEntity() {
    }

    @Override
    public Entity[] getParts() {
        return this.dragonPartArray;
    }

    @Override
    public boolean canBeCollidedWith() {
        return false;
    }

    @Override
    public World func_82194_d() {
        return this.worldObj;
    }

    @Override
    public String getLivingSound() {
        return "mob.enderdragon.growl";
    }

    @Override
    public String getHurtSound() {
        return "mob.enderdragon.hit";
    }

    @Override
    public float getSoundVolume() {
        return 5.0f;
    }
}

