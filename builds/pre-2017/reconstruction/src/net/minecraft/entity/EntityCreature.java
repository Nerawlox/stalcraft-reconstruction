/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import java.util.UUID;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.amxi;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.sajz;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public abstract class EntityCreature
extends EntityLiving {
    public static final UUID field_110179_h = UUID.fromString("E199AD21-BA8A-4C53-8D13-6182D5C69D3A");
    public static final AttributeModifier field_110181_i = new AttributeModifier(field_110179_h, "Fleeing speed bonus", 2.0, 2)._a(false);
    public PathEntity pathToEntity;
    public Entity entityToAttack;
    public boolean hasAttacked;
    public int fleeingTick;
    public ChunkCoordinates homePosition = new ChunkCoordinates(0, 0, 0);
    public float maximumHomeDistance = -1.0f;
    public EntityAIBase field_110178_bs = new amxi(this, 1.0);
    public boolean field_110180_bt;

    public EntityCreature(World world) {
        super(world);
    }

    public boolean isMovementCeased() {
        return false;
    }

    @Override
    public void updateEntityActionState() {
        this.worldObj.theProfiler._a("ai");
        if (this.fleeingTick > 0 && --this.fleeingTick == 0) {
            hubf hubf2 = this.getEntityAttribute(sajz._d);
            hubf2._b(field_110181_i);
        }
        this.hasAttacked = this.isMovementCeased();
        float f = 16.0f;
        if (this.entityToAttack == null) {
            this.entityToAttack = this.findPlayerToAttack();
            if (this.entityToAttack != null) {
                this.pathToEntity = this.worldObj.getPathEntityToEntity(this, this.entityToAttack, f, true, false, false, true);
            }
        } else if (this.entityToAttack.isEntityAlive()) {
            float f2 = this.entityToAttack.getDistanceToEntity(this);
            if (this.canEntityBeSeen(this.entityToAttack)) {
                this.attackEntity(this.entityToAttack, f2);
            }
        } else {
            this.entityToAttack = null;
        }
        this.worldObj.theProfiler._b();
        if (!(this.hasAttacked || this.entityToAttack == null || this.pathToEntity != null && this.rand.nextInt(20) != 0)) {
            this.pathToEntity = this.worldObj.getPathEntityToEntity(this, this.entityToAttack, f, true, false, false, true);
        } else if (!this.hasAttacked && (this.pathToEntity == null && this.rand.nextInt(180) == 0 || this.rand.nextInt(120) == 0 || this.fleeingTick > 0) && this.entityAge < 100) {
            this.updateWanderPath();
        }
        int n = sajh._c(this.boundingBox._c + 0.5);
        boolean bl = this.isInWater();
        boolean bl2 = this.handleLavaMovement();
        this.rotationPitch = 0.0f;
        if (this.pathToEntity == null || this.rand.nextInt(100) == 0) {
            super.updateEntityActionState();
            this.pathToEntity = null;
            return;
        }
        this.worldObj.theProfiler._a("followpath");
        Vec3 vec3 = this.pathToEntity._a(this);
        double d = this.width * 2.0f;
        while (vec3 != null && vec3._d(this.posX, vec3._d, this.posZ) < d * d) {
            this.pathToEntity._d();
            if (this.pathToEntity._e()) {
                vec3 = null;
                this.pathToEntity = null;
                continue;
            }
            vec3 = this.pathToEntity._a(this);
        }
        this.isJumping = false;
        if (vec3 != null) {
            double d2 = vec3._c - this.posX;
            double d3 = vec3._e - this.posZ;
            double d4 = vec3._d - (double)n;
            float f3 = (float)(Math.atan2(d3, d2) * 180.0 / 3.1415927410125732) - 90.0f;
            float f4 = sajh._g(f3 - this.rotationYaw);
            this.moveForward = (float)this.getEntityAttribute(sajz._d)._e();
            if (f4 > 30.0f) {
                f4 = 30.0f;
            }
            if (f4 < -30.0f) {
                f4 = -30.0f;
            }
            this.rotationYaw += f4;
            if (this.hasAttacked && this.entityToAttack != null) {
                double d5 = this.entityToAttack.posX - this.posX;
                double d6 = this.entityToAttack.posZ - this.posZ;
                float f5 = this.rotationYaw;
                this.rotationYaw = (float)(Math.atan2(d6, d5) * 180.0 / 3.1415927410125732) - 90.0f;
                f4 = (f5 - this.rotationYaw + 90.0f) * (float)Math.PI / 180.0f;
                this.moveStrafing = -sajh._a(f4) * this.moveForward * 1.0f;
                this.moveForward = sajh._b(f4) * this.moveForward * 1.0f;
            }
            if (d4 > 0.0) {
                this.isJumping = true;
            }
        }
        if (this.entityToAttack != null) {
            this.faceEntity(this.entityToAttack, 30.0f, 30.0f);
        }
        if (this.isCollidedHorizontally && !this.hasPath()) {
            this.isJumping = true;
        }
        if (this.rand.nextFloat() < 0.8f && (bl || bl2)) {
            this.isJumping = true;
        }
        this.worldObj.theProfiler._b();
    }

    public void updateWanderPath() {
        this.worldObj.theProfiler._a("stroll");
        boolean bl = false;
        int n = -1;
        int n2 = -1;
        int n3 = -1;
        float f = -99999.0f;
        for (int i = 0; i < 10; ++i) {
            int n4;
            int n5;
            int n6 = sajh._c(this.posX + (double)this.rand.nextInt(13) - 6.0);
            float f2 = this.getBlockPathWeight(n6, n5 = sajh._c(this.posY + (double)this.rand.nextInt(7) - 3.0), n4 = sajh._c(this.posZ + (double)this.rand.nextInt(13) - 6.0));
            if (!(f2 > f)) continue;
            f = f2;
            n = n6;
            n2 = n5;
            n3 = n4;
            bl = true;
        }
        if (bl) {
            this.pathToEntity = this.worldObj.getEntityPathToXYZ(this, n, n2, n3, 10.0f, true, false, false, true);
        }
        this.worldObj.theProfiler._b();
    }

    public void attackEntity(Entity entity, float f) {
    }

    public float getBlockPathWeight(int n, int n2, int n3) {
        return 0.0f;
    }

    public Entity findPlayerToAttack() {
        return null;
    }

    @Override
    public boolean getCanSpawnHere() {
        int n = sajh._c(this.posX);
        int n2 = sajh._c(this.boundingBox._c);
        int n3 = sajh._c(this.posZ);
        return super.getCanSpawnHere() && this.getBlockPathWeight(n, n2, n3) >= 0.0f;
    }

    public boolean hasPath() {
        return this.pathToEntity != null;
    }

    public void setPathToEntity(PathEntity pathEntity) {
        this.pathToEntity = pathEntity;
    }

    public Entity getEntityToAttack() {
        return this.entityToAttack;
    }

    public void setTarget(Entity entity) {
        this.entityToAttack = entity;
    }

    public boolean func_110173_bK() {
        return this.func_110176_b(sajh._c(this.posX), sajh._c(this.posY), sajh._c(this.posZ));
    }

    public boolean func_110176_b(int n, int n2, int n3) {
        if (this.maximumHomeDistance == -1.0f) {
            return true;
        }
        return this.homePosition._b(n, n2, n3) < this.maximumHomeDistance * this.maximumHomeDistance;
    }

    public void setHomeArea(int n, int n2, int n3, int n4) {
        this.homePosition._a(n, n2, n3);
        this.maximumHomeDistance = n4;
    }

    public ChunkCoordinates getHomePosition() {
        return this.homePosition;
    }

    public float func_110174_bM() {
        return this.maximumHomeDistance;
    }

    public void detachHome() {
        this.maximumHomeDistance = -1.0f;
    }

    public boolean hasHome() {
        return this.maximumHomeDistance != -1.0f;
    }

    @Override
    public void func_110159_bB() {
        super.func_110159_bB();
        if (this.getLeashed() && this.getLeashedToEntity() != null && this.getLeashedToEntity().worldObj == this.worldObj) {
            Entity entity = this.getLeashedToEntity();
            this.setHomeArea((int)entity.posX, (int)entity.posY, (int)entity.posZ, 5);
            float f = this.getDistanceToEntity(entity);
            if (this instanceof EntityTameable && ((EntityTameable)this).isSitting()) {
                if (f > 10.0f) {
                    this.clearLeashed(true, true);
                }
                return;
            }
            if (!this.field_110180_bt) {
                this.tasks._a(2, this.field_110178_bs);
                this.getNavigator()._a(false);
                this.field_110180_bt = true;
            }
            this.func_142017_o(f);
            if (f > 4.0f) {
                this.getNavigator()._a(entity, 1.0);
            }
            if (f > 6.0f) {
                double d = (entity.posX - this.posX) / (double)f;
                double d2 = (entity.posY - this.posY) / (double)f;
                double d3 = (entity.posZ - this.posZ) / (double)f;
                this.motionX += d * Math.abs(d) * 0.4;
                this.motionY += d2 * Math.abs(d2) * 0.4;
                this.motionZ += d3 * Math.abs(d3) * 0.4;
            }
            if (f > 10.0f) {
                this.clearLeashed(true, true);
            }
        } else if (!this.getLeashed() && this.field_110180_bt) {
            this.field_110180_bt = false;
            this.tasks._a(this.field_110178_bs);
            this.getNavigator()._a(true);
            this.detachHome();
        }
    }

    public void func_142017_o(float f) {
    }
}

