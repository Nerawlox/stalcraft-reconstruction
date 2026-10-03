/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.entity;

import net.minecraft.client.particle.EntityPortalFX;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.util.sajh;

public class EntityElementalStaffFX
extends EntityPortalFX {
    double motionX;
    double motionY;
    double motionZ;
    EntityLivingBase player;

    public EntityElementalStaffFX(EntityLivingBase entityLivingBase, double d, double d2, double d3, double d4, double d5, double d6, int n) {
        super(entityLivingBase.worldObj, entityLivingBase.posX + d, entityLivingBase.posY + d2, entityLivingBase.posZ + d3, d4, d5, d6);
        this.player = entityLivingBase;
        this.motionX = d;
        this.motionY = d2;
        this.motionZ = d3;
        float[] fArray = n <= 15 ? EntitySheep.fleeceColorTable[n] : new float[]{(float)(n >> 16 & 0xFF) / 255.0f, (float)(n >> 8 & 0xFF) / 255.0f, (float)(n & 0xFF) / 255.0f};
        this.particleRed = fArray[0];
        this.particleGreen = fArray[1];
        this.particleBlue = fArray[2];
        this.particleMaxAge = (int)(16.0 / (Math.random() * 0.8 + 0.2));
        this.noClip = false;
    }

    @Override
    public void onUpdate() {
        if (this.player.isDead) {
            this.setDead();
        } else {
            float f;
            this.prevPosX = this.posX;
            this.prevPosY = this.posY;
            this.prevPosZ = this.posZ;
            float f2 = f = (float)this.particleAge / (float)this.particleMaxAge;
            f = -f + f * f * 2.0f;
            f = 1.0f - f;
            double d = -sajh._a((float)((double)(this.player.rotationYaw / 180.0f) * Math.PI)) * sajh._b((float)((double)(this.player.rotationPitch / 180.0f) * Math.PI));
            double d2 = sajh._b((float)((double)(this.player.rotationYaw / 180.0f) * Math.PI)) * sajh._b((float)((double)(this.player.rotationPitch / 180.0f) * Math.PI));
            this.posX = this.player.posX + this.motionX + d + ((Entity)this).motionX * (double)f;
            this.posY = this.player.posY + this.motionY + ((Entity)this).motionY * (double)f + (double)(1.0f - f2) - (double)(this.player.rotationPitch / 40.0f);
            this.posZ = this.player.posZ + this.motionZ + d2 + ((Entity)this).motionZ * (double)f;
            if (this.particleAge++ >= this.particleMaxAge) {
                this.setDead();
            }
        }
    }

    @Override
    public void setDead() {
        super.setDead();
    }
}

