/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public abstract class EntityFlying
extends EntityLiving {
    public EntityFlying(World world) {
        super(world);
    }

    @Override
    public void fall(float f) {
    }

    @Override
    public void updateFallState(double d, boolean bl) {
    }

    @Override
    public void moveEntityWithHeading(float f, float f2) {
        if (this.isInWater()) {
            this.moveFlying(f, f2, 0.02f);
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= (double)0.8f;
            this.motionY *= (double)0.8f;
            this.motionZ *= (double)0.8f;
        } else if (this.handleLavaMovement()) {
            this.moveFlying(f, f2, 0.02f);
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.5;
            this.motionY *= 0.5;
            this.motionZ *= 0.5;
        } else {
            float f3 = 0.91f;
            if (this.onGround) {
                f3 = 0.54600006f;
                int n = this.worldObj.getBlockId(sajh._c(this.posX), sajh._c(this.boundingBox._c) - 1, sajh._c(this.posZ));
                if (n > 0) {
                    f3 = Block.blocksList[n].slipperiness * 0.91f;
                }
            }
            float f4 = 0.16277136f / (f3 * f3 * f3);
            this.moveFlying(f, f2, this.onGround ? 0.1f * f4 : 0.02f);
            f3 = 0.91f;
            if (this.onGround) {
                f3 = 0.54600006f;
                int n = this.worldObj.getBlockId(sajh._c(this.posX), sajh._c(this.boundingBox._c) - 1, sajh._c(this.posZ));
                if (n > 0) {
                    f3 = Block.blocksList[n].slipperiness * 0.91f;
                }
            }
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= (double)f3;
            this.motionY *= (double)f3;
            this.motionZ *= (double)f3;
        }
        this.prevLimbSwingAmount = this.limbSwingAmount;
        double d = this.posX - this.prevPosX;
        double d2 = this.posZ - this.prevPosZ;
        float f5 = sajh._a(d * d + d2 * d2) * 4.0f;
        if (f5 > 1.0f) {
            f5 = 1.0f;
        }
        this.limbSwingAmount += (f5 - this.limbSwingAmount) * 0.4f;
        this.limbSwing += this.limbSwingAmount;
    }

    @Override
    public boolean isOnLadder() {
        return false;
    }
}

