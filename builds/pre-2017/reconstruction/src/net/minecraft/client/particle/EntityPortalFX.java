/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.particle;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;

public class EntityPortalFX
extends EntityFX {
    public float portalParticleScale;
    public double portalPosX;
    public double portalPosY;
    public double portalPosZ;

    public EntityPortalFX(World world, double d, double d2, double d3, double d4, double d5, double d6) {
        super(world, d, d2, d3, d4, d5, d6);
        this.motionX = d4;
        this.motionY = d5;
        this.motionZ = d6;
        this.portalPosX = this.posX = d;
        this.portalPosY = this.posY = d2;
        this.portalPosZ = this.posZ = d3;
        float f = this.rand.nextFloat() * 0.6f + 0.4f;
        this.portalParticleScale = this.particleScale = this.rand.nextFloat() * 0.2f + 0.5f;
        this.particleGreen = this.particleBlue = 1.0f * f;
        this.particleRed = this.particleBlue;
        this.particleGreen *= 0.3f;
        this.particleRed *= 0.9f;
        this.particleMaxAge = (int)(Math.random() * 10.0) + 40;
        this.noClip = true;
        this.setParticleTextureIndex((int)(Math.random() * 8.0));
    }

    @Override
    public void renderParticle(Tessellator tessellator, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = ((float)this.particleAge + f) / (float)this.particleMaxAge;
        f7 = 1.0f - f7;
        f7 *= f7;
        f7 = 1.0f - f7;
        this.particleScale = this.portalParticleScale * f7;
        super.renderParticle(tessellator, f, f2, f3, f4, f5, f6);
    }

    @Override
    public int getBrightnessForRender(float f) {
        int n = super.getBrightnessForRender(f);
        float f2 = (float)this.particleAge / (float)this.particleMaxAge;
        f2 *= f2;
        f2 *= f2;
        int n2 = n & 0xFF;
        int n3 = n >> 16 & 0xFF;
        if ((n3 += (int)(f2 * 15.0f * 16.0f)) > 240) {
            n3 = 240;
        }
        return n2 | n3 << 16;
    }

    @Override
    public float getBrightness(float f) {
        float f2 = super.getBrightness(f);
        float f3 = (float)this.particleAge / (float)this.particleMaxAge;
        f3 = f3 * f3 * f3 * f3;
        return f2 * (1.0f - f3) + f3;
    }

    @Override
    public void onUpdate() {
        float f;
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        float f2 = f = (float)this.particleAge / (float)this.particleMaxAge;
        f = -f + f * f * 2.0f;
        f = 1.0f - f;
        this.posX = this.portalPosX + this.motionX * (double)f;
        this.posY = this.portalPosY + this.motionY * (double)f + (double)(1.0f - f2);
        this.posZ = this.portalPosZ + this.motionZ * (double)f;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setDead();
        }
    }
}

