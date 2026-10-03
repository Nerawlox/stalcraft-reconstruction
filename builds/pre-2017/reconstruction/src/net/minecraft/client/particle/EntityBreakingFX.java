/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.particle;

import net.minecraft.block.Block;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityBreakingFX
extends EntityFX {
    public EntityBreakingFX(World world, double d, double d2, double d3, Item item) {
        this(world, d, d2, d3, item, 0);
    }

    public EntityBreakingFX(World world, double d, double d2, double d3, Item item, int n) {
        super(world, d, d2, d3, 0.0, 0.0, 0.0);
        this.setParticleIcon(item.getIconFromDamage(n));
        this.particleBlue = 1.0f;
        this.particleGreen = 1.0f;
        this.particleRed = 1.0f;
        this.particleGravity = Block.blockSnow.blockParticleGravity;
        this.particleScale /= 2.0f;
    }

    public EntityBreakingFX(World world, double d, double d2, double d3, double d4, double d5, double d6, Item item, int n) {
        this(world, d, d2, d3, item, n);
        this.motionX *= (double)0.1f;
        this.motionY *= (double)0.1f;
        this.motionZ *= (double)0.1f;
        this.motionX += d4;
        this.motionY += d5;
        this.motionZ += d6;
    }

    @Override
    public int getFXLayer() {
        return 2;
    }

    @Override
    public void renderParticle(Tessellator tessellator, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = ((float)this.particleTextureIndexX + this.particleTextureJitterX / 4.0f) / 16.0f;
        float f8 = f7 + 0.015609375f;
        float f9 = ((float)this.particleTextureIndexY + this.particleTextureJitterY / 4.0f) / 16.0f;
        float f10 = f9 + 0.015609375f;
        float f11 = 0.1f * this.particleScale;
        if (this.particleIcon != null) {
            f7 = this.particleIcon.getInterpolatedU(this.particleTextureJitterX / 4.0f * 16.0f);
            f8 = this.particleIcon.getInterpolatedU((this.particleTextureJitterX + 1.0f) / 4.0f * 16.0f);
            f9 = this.particleIcon.getInterpolatedV(this.particleTextureJitterY / 4.0f * 16.0f);
            f10 = this.particleIcon.getInterpolatedV((this.particleTextureJitterY + 1.0f) / 4.0f * 16.0f);
        }
        float f12 = (float)(this.prevPosX + (this.posX - this.prevPosX) * (double)f - interpPosX);
        float f13 = (float)(this.prevPosY + (this.posY - this.prevPosY) * (double)f - interpPosY);
        float f14 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * (double)f - interpPosZ);
        float f15 = 1.0f;
        tessellator.setColorOpaque_F(f15 * this.particleRed, f15 * this.particleGreen, f15 * this.particleBlue);
        tessellator.addVertexWithUV(f12 - f2 * f11 - f5 * f11, f13 - f3 * f11, f14 - f4 * f11 - f6 * f11, f7, f10);
        tessellator.addVertexWithUV(f12 - f2 * f11 + f5 * f11, f13 + f3 * f11, f14 - f4 * f11 + f6 * f11, f7, f9);
        tessellator.addVertexWithUV(f12 + f2 * f11 + f5 * f11, f13 + f3 * f11, f14 + f4 * f11 + f6 * f11, f8, f9);
        tessellator.addVertexWithUV(f12 + f2 * f11 - f5 * f11, f13 - f3 * f11, f14 + f4 * f11 - f6 * f11, f8, f10);
    }
}

