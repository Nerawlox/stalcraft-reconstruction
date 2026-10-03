/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.particle;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;

public class EntityFlameFX
extends EntityFX {
    public float flameScale;

    public EntityFlameFX(World world, double d, double d2, double d3, double d4, double d5, double d6) {
        super(world, d, d2, d3, d4, d5, d6);
        this.motionX = this.motionX * (double)0.01f + d4;
        this.motionY = this.motionY * (double)0.01f + d5;
        this.motionZ = this.motionZ * (double)0.01f + d6;
        d += (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.05f);
        d2 += (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.05f);
        d3 += (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.05f);
        this.flameScale = this.particleScale;
        this.particleBlue = 1.0f;
        this.particleGreen = 1.0f;
        this.particleRed = 1.0f;
        this.particleMaxAge = (int)(8.0 / (Math.random() * 0.8 + 0.2)) + 4;
        this.noClip = true;
        this.setParticleTextureIndex(48);
    }

    @Override
    public void renderParticle(Tessellator tessellator, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = ((float)this.particleAge + f) / (float)this.particleMaxAge;
        this.particleScale = this.flameScale * (1.0f - f7 * f7 * 0.5f);
        super.renderParticle(tessellator, f, f2, f3, f4, f5, f6);
    }

    @Override
    public int getBrightnessForRender(float f) {
        float f2 = ((float)this.particleAge + f) / (float)this.particleMaxAge;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        int n = super.getBrightnessForRender(f);
        int n2 = n & 0xFF;
        int n3 = n >> 16 & 0xFF;
        if ((n2 += (int)(f2 * 15.0f * 16.0f)) > 240) {
            n2 = 240;
        }
        return n2 | n3 << 16;
    }

    @Override
    public float getBrightness(float f) {
        float f2 = ((float)this.particleAge + f) / (float)this.particleMaxAge;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        float f3 = super.getBrightness(f);
        return f3 * f2 + (1.0f - f2);
    }

    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setDead();
        }
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= (double)0.96f;
        this.motionY *= (double)0.96f;
        this.motionZ *= (double)0.96f;
        if (this.onGround) {
            this.motionX *= (double)0.7f;
            this.motionZ *= (double)0.7f;
        }
    }
}

