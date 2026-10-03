/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.particle;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;

@SideOnly(value=Side.CLIENT)
public class EntityDiggingFX
extends EntityFX {
    public Block blockInstance;
    public int side;

    public EntityDiggingFX(World world, double d, double d2, double d3, double d4, double d5, double d6, Block block, int n) {
        this(world, d, d2, d3, d4, d5, d6, block, n, world.rand.nextInt(6));
    }

    public EntityDiggingFX(World world, double d, double d2, double d3, double d4, double d5, double d6, Block block, int n, int n2) {
        super(world, d, d2, d3, d4, d5, d6);
        this.blockInstance = block;
        this.setParticleIcon(block.getIcon(n2, n));
        this.particleGravity = block.blockParticleGravity;
        this.particleBlue = 0.6f;
        this.particleGreen = 0.6f;
        this.particleRed = 0.6f;
        this.particleScale /= 2.0f;
        this.side = n2;
    }

    public EntityDiggingFX applyColourMultiplier(int n, int n2, int n3) {
        if (this.blockInstance == Block.grass && this.side != 1) {
            return this;
        }
        int n4 = this.blockInstance.colorMultiplier(this.worldObj, n, n2, n3);
        this.particleRed *= (float)(n4 >> 16 & 0xFF) / 255.0f;
        this.particleGreen *= (float)(n4 >> 8 & 0xFF) / 255.0f;
        this.particleBlue *= (float)(n4 & 0xFF) / 255.0f;
        return this;
    }

    public EntityDiggingFX applyRenderColor(int n) {
        if (this.blockInstance == Block.grass) {
            return this;
        }
        int n2 = this.blockInstance.getRenderColor(n);
        this.particleRed *= (float)(n2 >> 16 & 0xFF) / 255.0f;
        this.particleGreen *= (float)(n2 >> 8 & 0xFF) / 255.0f;
        this.particleBlue *= (float)(n2 & 0xFF) / 255.0f;
        return this;
    }

    @Override
    public int getFXLayer() {
        return 1;
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

