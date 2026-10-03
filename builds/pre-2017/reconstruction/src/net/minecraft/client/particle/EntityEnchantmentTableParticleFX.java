/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.particle;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;

public class EntityEnchantmentTableParticleFX
extends EntityFX {
    public float field_70565_a;
    public double field_70568_aq;
    public double field_70567_ar;
    public double field_70566_as;

    public EntityEnchantmentTableParticleFX(World world, double d, double d2, double d3, double d4, double d5, double d6) {
        super(world, d, d2, d3, d4, d5, d6);
        this.motionX = d4;
        this.motionY = d5;
        this.motionZ = d6;
        this.field_70568_aq = this.posX = d;
        this.field_70567_ar = this.posY = d2;
        this.field_70566_as = this.posZ = d3;
        float f = this.rand.nextFloat() * 0.6f + 0.4f;
        this.field_70565_a = this.particleScale = this.rand.nextFloat() * 0.5f + 0.2f;
        this.particleGreen = this.particleBlue = 1.0f * f;
        this.particleRed = this.particleBlue;
        this.particleGreen *= 0.9f;
        this.particleRed *= 0.9f;
        this.particleMaxAge = (int)(Math.random() * 10.0) + 30;
        this.noClip = true;
        this.setParticleTextureIndex((int)(Math.random() * 26.0 + 1.0 + 224.0));
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
        f3 *= f3;
        f3 *= f3;
        return f2 * (1.0f - f3) + f3;
    }

    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        float f = (float)this.particleAge / (float)this.particleMaxAge;
        f = 1.0f - f;
        float f2 = 1.0f - f;
        f2 *= f2;
        f2 *= f2;
        this.posX = this.field_70568_aq + this.motionX * (double)f;
        this.posY = this.field_70567_ar + this.motionY * (double)f - (double)(f2 * 1.2f);
        this.posZ = this.field_70566_as + this.motionZ * (double)f;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setDead();
        }
    }
}

