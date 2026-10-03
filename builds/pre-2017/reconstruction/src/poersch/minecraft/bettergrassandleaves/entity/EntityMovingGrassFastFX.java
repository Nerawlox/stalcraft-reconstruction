/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRenderer;

@SideOnly(value=Side.CLIENT)
public class EntityMovingGrassFastFX
extends EntityFX {
    protected int offsetIndex;
    protected float lightScale = 0.8f;
    protected boolean flipU;

    public EntityMovingGrassFastFX(World world, double d, double d2, double d3, float f, int n, int n2, float f2, int n3, Icon icon, boolean bl) {
        super(world, d, d2, d3, 0.0, 0.0, 0.0);
        this.motionX = f;
        this.particleScale = f;
        this.motionY = 1.0;
        this.motionZ = n2;
        this.offsetIndex = n + 1;
        this.particleRed = (float)(n3 >> 16 & 0xFF) * 0.00392f * f2;
        this.particleGreen = (float)(n3 >> 8 & 0xFF) * 0.00392f * f2;
        this.particleBlue = (float)(n3 & 0xFF) * 0.00392f * f2;
        this.particleMaxAge = 22;
        this.noClip = true;
        this.particleIcon = icon;
        this.flipU = bl;
    }

    @Override
    public int getFXLayer() {
        return 1;
    }

    @Override
    public void onUpdate() {
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setDead();
        }
        this.motionY = 1.0 - (double)this.particleAge / (double)this.particleMaxAge;
        this.particleScale = (float)(this.motionX * this.motionY);
        this.lightScale = 1.0f - (float)this.motionY * 0.2f;
        this.motionY *= 1.8;
    }

    @Override
    public void renderParticle(Tessellator tessellator, float f, float f2, float f3, float f4, float f5, float f6) {
        double d;
        double d2;
        if (this.flipU) {
            d2 = this.particleIcon.getMaxU();
            d = this.particleIcon.getMinU();
        } else {
            d2 = this.particleIcon.getMinU();
            d = this.particleIcon.getMaxU();
        }
        double d3 = this.particleIcon.getMinV();
        double d4 = this.particleIcon.getMaxV();
        double d5 = this.posX - EntityFX.interpPosX;
        double d6 = this.posY - EntityFX.interpPosY;
        double d7 = this.posZ - EntityFX.interpPosZ;
        double d8 = d6 - BlockRenderer.offsetMap24px[0][0];
        double d9 = d6 + BlockRenderer.offsetMap24px[0][0] + (double)this.particleScale;
        double d10 = d5 - BlockRenderer.offsetMap24px[this.offsetIndex][0];
        double d11 = d5 + BlockRenderer.offsetMap24px[this.offsetIndex][0];
        double d12 = d7 - BlockRenderer.offsetMap24px[this.offsetIndex][1];
        double d13 = d7 + BlockRenderer.offsetMap24px[this.offsetIndex][1];
        double d14 = BlockRenderer.offsetMap24px[this.offsetIndex][0] * this.motionY;
        double d15 = BlockRenderer.offsetMap24px[this.offsetIndex][1] * this.motionY;
        tessellator.setBrightness((int)this.motionZ);
        tessellator.setColorRGBA_F(this.particleRed * this.lightScale, this.particleGreen * this.lightScale, this.particleBlue * this.lightScale, this.particleAlpha);
        tessellator.addVertexWithUV(d11 + d14, d9, d13 - d15, d2, d3);
        tessellator.addVertexWithUV(d11, d8, d13, d2, d4);
        tessellator.addVertexWithUV(d10, d8, d12, d, d4);
        tessellator.addVertexWithUV(d10 + d14, d9, d12 - d15, d, d3);
        tessellator.addVertexWithUV(d11 - d14, d9, d13 + d15, d2, d3);
        tessellator.addVertexWithUV(d11, d8, d13, d2, d4);
        tessellator.addVertexWithUV(d10, d8, d12, d, d4);
        tessellator.addVertexWithUV(d10 - d14, d9, d12 + d15, d, d3);
        tessellator.addVertexWithUV(d10 - d14, d9, d12 + d15, d, d3);
        tessellator.addVertexWithUV(d10, d8, d12, d, d4);
        tessellator.addVertexWithUV(d11, d8, d13, d2, d4);
        tessellator.addVertexWithUV(d11 - d14, d9, d13 + d15, d2, d3);
        tessellator.addVertexWithUV(d10 + d14, d9, d12 - d15, d, d3);
        tessellator.addVertexWithUV(d10, d8, d12, d, d4);
        tessellator.addVertexWithUV(d11, d8, d13, d2, d4);
        tessellator.addVertexWithUV(d11 + d14, d9, d13 - d15, d2, d3);
        d10 = d5 - BlockRenderer.offsetMap24px[this.offsetIndex][2];
        d11 = d5 + BlockRenderer.offsetMap24px[this.offsetIndex][2];
        d12 = d7 - BlockRenderer.offsetMap24px[this.offsetIndex][3];
        d13 = d7 + BlockRenderer.offsetMap24px[this.offsetIndex][3];
        d14 = BlockRenderer.offsetMap24px[this.offsetIndex][0] * this.motionY;
        d15 = BlockRenderer.offsetMap24px[this.offsetIndex][1] * this.motionY;
        tessellator.addVertexWithUV(d11 - d14, d9, d13 - d15, d2, d3);
        tessellator.addVertexWithUV(d11, d8, d13, d2, d4);
        tessellator.addVertexWithUV(d10, d8, d12, d, d4);
        tessellator.addVertexWithUV(d10 - d14, d9, d12 - d15, d, d3);
        tessellator.addVertexWithUV(d11 + d14, d9, d13 + d15, d2, d3);
        tessellator.addVertexWithUV(d11, d8, d13, d2, d4);
        tessellator.addVertexWithUV(d10, d8, d12, d, d4);
        tessellator.addVertexWithUV(d10 + d14, d9, d12 + d15, d, d3);
        tessellator.addVertexWithUV(d10 + d14, d9, d12 + d15, d, d3);
        tessellator.addVertexWithUV(d10, d8, d12, d, d4);
        tessellator.addVertexWithUV(d11, d8, d13, d2, d4);
        tessellator.addVertexWithUV(d11 + d14, d9, d13 + d15, d2, d3);
        tessellator.addVertexWithUV(d10 - d14, d9, d12 - d15, d, d3);
        tessellator.addVertexWithUV(d10, d8, d12, d, d4);
        tessellator.addVertexWithUV(d11, d8, d13, d2, d4);
        tessellator.addVertexWithUV(d11 - d14, d9, d13 - d15, d2, d3);
    }
}

