/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.particle;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class EntityFX
extends Entity {
    public int particleTextureIndexX;
    public int particleTextureIndexY;
    public float particleTextureJitterX;
    public float particleTextureJitterY;
    public int particleAge;
    public int particleMaxAge;
    public float particleScale;
    public float particleGravity;
    public float particleRed;
    public float particleGreen;
    public float particleBlue;
    public float particleAlpha = 1.0f;
    public Icon particleIcon;
    public static double interpPosX;
    public static double interpPosY;
    public static double interpPosZ;

    public EntityFX(World world, double d, double d2, double d3) {
        super(world);
        this.setSize(0.2f, 0.2f);
        this.yOffset = this.height / 2.0f;
        this.setPosition(d, d2, d3);
        this.lastTickPosX = d;
        this.lastTickPosY = d2;
        this.lastTickPosZ = d3;
        this.particleBlue = 1.0f;
        this.particleGreen = 1.0f;
        this.particleRed = 1.0f;
        this.particleTextureJitterX = this.rand.nextFloat() * 3.0f;
        this.particleTextureJitterY = this.rand.nextFloat() * 3.0f;
        this.particleScale = (this.rand.nextFloat() * 0.5f + 0.5f) * 2.0f;
        this.particleMaxAge = (int)(4.0f / (this.rand.nextFloat() * 0.9f + 0.1f));
        this.particleAge = 0;
    }

    public EntityFX(World world, double d, double d2, double d3, double d4, double d5, double d6) {
        this(world, d, d2, d3);
        this.motionX = d4 + (double)((float)(Math.random() * 2.0 - 1.0) * 0.4f);
        this.motionY = d5 + (double)((float)(Math.random() * 2.0 - 1.0) * 0.4f);
        this.motionZ = d6 + (double)((float)(Math.random() * 2.0 - 1.0) * 0.4f);
        float f = (float)(Math.random() + Math.random() + 1.0) * 0.15f;
        float f2 = sajh._a(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
        this.motionX = this.motionX / (double)f2 * (double)f * (double)0.4f;
        this.motionY = this.motionY / (double)f2 * (double)f * (double)0.4f + (double)0.1f;
        this.motionZ = this.motionZ / (double)f2 * (double)f * (double)0.4f;
    }

    public EntityFX multiplyVelocity(float f) {
        this.motionX *= (double)f;
        this.motionY = (this.motionY - (double)0.1f) * (double)f + (double)0.1f;
        this.motionZ *= (double)f;
        return this;
    }

    public EntityFX multipleParticleScaleBy(float f) {
        this.setSize(0.2f * f, 0.2f * f);
        this.particleScale *= f;
        return this;
    }

    public void setRBGColorF(float f, float f2, float f3) {
        this.particleRed = f;
        this.particleGreen = f2;
        this.particleBlue = f3;
    }

    public void setAlphaF(float f) {
        this.particleAlpha = f;
    }

    public float getRedColorF() {
        return this.particleRed;
    }

    public float getGreenColorF() {
        return this.particleGreen;
    }

    public float getBlueColorF() {
        return this.particleBlue;
    }

    @Override
    public boolean canTriggerWalking() {
        return false;
    }

    @Override
    public void entityInit() {
    }

    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setDead();
        }
        this.motionY -= 0.04 * (double)this.particleGravity;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= (double)0.98f;
        this.motionY *= (double)0.98f;
        this.motionZ *= (double)0.98f;
        if (this.onGround) {
            this.motionX *= (double)0.7f;
            this.motionZ *= (double)0.7f;
        }
    }

    public void renderParticle(Tessellator tessellator, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = (float)this.particleTextureIndexX / 16.0f;
        float f8 = f7 + 0.0624375f;
        float f9 = (float)this.particleTextureIndexY / 16.0f;
        float f10 = f9 + 0.0624375f;
        float f11 = 0.1f * this.particleScale;
        if (this.particleIcon != null) {
            f7 = this.particleIcon.getMinU();
            f8 = this.particleIcon.getMaxU();
            f9 = this.particleIcon.getMinV();
            f10 = this.particleIcon.getMaxV();
        }
        float f12 = (float)(this.prevPosX + (this.posX - this.prevPosX) * (double)f - interpPosX);
        float f13 = (float)(this.prevPosY + (this.posY - this.prevPosY) * (double)f - interpPosY);
        float f14 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * (double)f - interpPosZ);
        float f15 = 1.0f;
        tessellator.setColorRGBA_F(this.particleRed * f15, this.particleGreen * f15, this.particleBlue * f15, this.particleAlpha);
        tessellator.addVertexWithUV(f12 - f2 * f11 - f5 * f11, f13 - f3 * f11, f14 - f4 * f11 - f6 * f11, f8, f10);
        tessellator.addVertexWithUV(f12 - f2 * f11 + f5 * f11, f13 + f3 * f11, f14 - f4 * f11 + f6 * f11, f8, f9);
        tessellator.addVertexWithUV(f12 + f2 * f11 + f5 * f11, f13 + f3 * f11, f14 + f4 * f11 + f6 * f11, f7, f9);
        tessellator.addVertexWithUV(f12 + f2 * f11 - f5 * f11, f13 - f3 * f11, f14 + f4 * f11 - f6 * f11, f7, f10);
    }

    public int getFXLayer() {
        return 0;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
    }

    public void setParticleIcon(Icon icon) {
        if (this.getFXLayer() == 1) {
            this.particleIcon = icon;
        } else if (this.getFXLayer() == 2) {
            this.particleIcon = icon;
        } else {
            throw new RuntimeException("Invalid call to Particle.setTex, use coordinate methods");
        }
    }

    public void setParticleTextureIndex(int n) {
        if (this.getFXLayer() != 0) {
            throw new RuntimeException("Invalid call to Particle.setMiscTex");
        }
        this.particleTextureIndexX = n % 16;
        this.particleTextureIndexY = n / 16;
    }

    public void nextTextureIndexX() {
        ++this.particleTextureIndexX;
    }

    @Override
    public boolean canAttackWithItem() {
        return false;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ", Pos (" + this.posX + "," + this.posY + "," + this.posZ + "), RGBA (" + this.particleRed + "," + this.particleGreen + "," + this.particleBlue + "," + this.particleAlpha + "), Age " + this.particleAge;
    }
}

