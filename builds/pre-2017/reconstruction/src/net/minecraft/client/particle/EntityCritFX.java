/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.particle;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;

public class EntityCritFX
extends EntityFX {
    public float initialParticleScale;

    public EntityCritFX(World world, double d, double d2, double d3, double d4, double d5, double d6) {
        this(world, d, d2, d3, d4, d5, d6, 1.0f);
    }

    public EntityCritFX(World world, double d, double d2, double d3, double d4, double d5, double d6, float f) {
        super(world, d, d2, d3, 0.0, 0.0, 0.0);
        this.motionX *= (double)0.1f;
        this.motionY *= (double)0.1f;
        this.motionZ *= (double)0.1f;
        this.motionX += d4 * 0.4;
        this.motionY += d5 * 0.4;
        this.motionZ += d6 * 0.4;
        this.particleGreen = this.particleBlue = (float)(Math.random() * (double)0.3f + (double)0.6f);
        this.particleRed = this.particleBlue;
        this.particleScale *= 0.75f;
        this.particleScale *= f;
        this.initialParticleScale = this.particleScale;
        this.particleMaxAge = (int)(6.0 / (Math.random() * 0.8 + 0.6));
        this.particleMaxAge = (int)((float)this.particleMaxAge * f);
        this.noClip = false;
        this.setParticleTextureIndex(65);
        this.onUpdate();
    }

    @Override
    public void renderParticle(Tessellator tessellator, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = ((float)this.particleAge + f) / (float)this.particleMaxAge * 32.0f;
        if (f7 < 0.0f) {
            f7 = 0.0f;
        }
        if (f7 > 1.0f) {
            f7 = 1.0f;
        }
        this.particleScale = this.initialParticleScale * f7;
        super.renderParticle(tessellator, f, f2, f3, f4, f5, f6);
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
        this.particleGreen = (float)((double)this.particleGreen * 0.96);
        this.particleBlue = (float)((double)this.particleBlue * 0.9);
        this.motionX *= (double)0.7f;
        this.motionY *= (double)0.7f;
        this.motionZ *= (double)0.7f;
        this.motionY -= (double)0.02f;
        if (this.onGround) {
            this.motionX *= (double)0.7f;
            this.motionZ *= (double)0.7f;
        }
    }
}

