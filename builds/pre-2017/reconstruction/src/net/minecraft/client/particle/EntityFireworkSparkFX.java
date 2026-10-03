/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.particle;

import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityFireworkSparkFX
extends EntityFX {
    public int baseTextureIndex = 160;
    public boolean field_92054_ax;
    public boolean field_92048_ay;
    public final EffectRenderer field_92047_az;
    public float fadeColourRed;
    public float fadeColourGreen;
    public float fadeColourBlue;
    public boolean hasFadeColour;

    public EntityFireworkSparkFX(World world, double d, double d2, double d3, double d4, double d5, double d6, EffectRenderer effectRenderer) {
        super(world, d, d2, d3);
        this.motionX = d4;
        this.motionY = d5;
        this.motionZ = d6;
        this.field_92047_az = effectRenderer;
        this.particleScale *= 0.75f;
        this.particleMaxAge = 48 + this.rand.nextInt(12);
        this.noClip = false;
    }

    public void setTrail(boolean bl) {
        this.field_92054_ax = bl;
    }

    public void setTwinkle(boolean bl) {
        this.field_92048_ay = bl;
    }

    public void setColour(int n) {
        float f = (float)((n & 0xFF0000) >> 16) / 255.0f;
        float f2 = (float)((n & 0xFF00) >> 8) / 255.0f;
        float f3 = (float)((n & 0xFF) >> 0) / 255.0f;
        float f4 = 1.0f;
        this.setRBGColorF(f * f4, f2 * f4, f3 * f4);
    }

    public void setFadeColour(int n) {
        this.fadeColourRed = (float)((n & 0xFF0000) >> 16) / 255.0f;
        this.fadeColourGreen = (float)((n & 0xFF00) >> 8) / 255.0f;
        this.fadeColourBlue = (float)((n & 0xFF) >> 0) / 255.0f;
        this.hasFadeColour = true;
    }

    @Override
    public AxisAlignedBB getBoundingBox() {
        return null;
    }

    @Override
    public boolean canBePushed() {
        return false;
    }

    @Override
    public void renderParticle(Tessellator tessellator, float f, float f2, float f3, float f4, float f5, float f6) {
        if (!this.field_92048_ay || this.particleAge < this.particleMaxAge / 3 || (this.particleAge + this.particleMaxAge) / 3 % 2 == 0) {
            super.renderParticle(tessellator, f, f2, f3, f4, f5, f6);
        }
    }

    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setDead();
        }
        if (this.particleAge > this.particleMaxAge / 2) {
            this.setAlphaF(1.0f - ((float)this.particleAge - (float)(this.particleMaxAge / 2)) / (float)this.particleMaxAge);
            if (this.hasFadeColour) {
                this.particleRed += (this.fadeColourRed - this.particleRed) * 0.2f;
                this.particleGreen += (this.fadeColourGreen - this.particleGreen) * 0.2f;
                this.particleBlue += (this.fadeColourBlue - this.particleBlue) * 0.2f;
            }
        }
        this.setParticleTextureIndex(this.baseTextureIndex + (7 - this.particleAge * 8 / this.particleMaxAge));
        this.motionY -= 0.004;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= (double)0.91f;
        this.motionY *= (double)0.91f;
        this.motionZ *= (double)0.91f;
        if (this.onGround) {
            this.motionX *= (double)0.7f;
            this.motionZ *= (double)0.7f;
        }
        if (this.field_92054_ax && this.particleAge < this.particleMaxAge / 2 && (this.particleAge + this.particleMaxAge) % 2 == 0) {
            EntityFireworkSparkFX entityFireworkSparkFX = new EntityFireworkSparkFX(this.worldObj, this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0, this.field_92047_az);
            entityFireworkSparkFX.setRBGColorF(this.particleRed, this.particleGreen, this.particleBlue);
            entityFireworkSparkFX.particleAge = entityFireworkSparkFX.particleMaxAge / 2;
            if (this.hasFadeColour) {
                entityFireworkSparkFX.hasFadeColour = true;
                entityFireworkSparkFX.fadeColourRed = this.fadeColourRed;
                entityFireworkSparkFX.fadeColourGreen = this.fadeColourGreen;
                entityFireworkSparkFX.fadeColourBlue = this.fadeColourBlue;
            }
            entityFireworkSparkFX.field_92048_ay = this.field_92048_ay;
            this.field_92047_az._a(entityFireworkSparkFX);
        }
    }

    @Override
    public int getBrightnessForRender(float f) {
        return 0xF000F0;
    }

    @Override
    public float getBrightness(float f) {
        return 1.0f;
    }
}

