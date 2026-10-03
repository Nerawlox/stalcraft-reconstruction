/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import poersch.minecraft.bettergrassandleaves.entity.EntityFallingLeavesFastFX;

@SideOnly(value=Side.CLIENT)
public class EntityFallingLeavesFancyFX
extends EntityFallingLeavesFastFX {
    public EntityFallingLeavesFancyFX(World world, double d, double d2, double d3, float f, float f2, int n, Icon icon) {
        super(world, d, d2, d3, f, f2, n, icon);
    }

    @Override
    public void renderParticle(Tessellator tessellator, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = this.particleIcon.getInterpolatedU(this.particleTextureJitterX);
        float f8 = this.particleIcon.getInterpolatedU(this.particleTextureJitterX + 4.0f);
        float f9 = this.particleIcon.getInterpolatedV(this.particleTextureJitterY);
        float f10 = this.particleIcon.getInterpolatedV(this.particleTextureJitterY + 4.0f);
        float f11 = (float)(this.prevPosX + (this.posX - this.prevPosX) * (double)f - EntityFX.interpPosX);
        float f12 = (float)(this.prevPosY + (this.posY - this.prevPosY) * (double)f - EntityFX.interpPosY);
        float f13 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * (double)f - EntityFX.interpPosZ);
        float f14 = (float)(this.prevPosY + (this.posY - this.prevPosY) * (double)f + (double)this.windAngleOffset);
        double d = 0.176776695 * (double)this.particleScale;
        double d2 = (double)f12 - 0.125 * (double)this.particleScale;
        double d3 = (double)f12 + 0.125 * (double)this.particleScale;
        double d4 = (double)f11 + (double)sajh._a(f14) * d;
        double d5 = (double)f11 + (double)sajh._a((float)((double)f14 + 1.5707963267948966)) * d;
        double d6 = (double)f11 + (double)sajh._a((float)((double)f14 + Math.PI)) * d;
        double d7 = (double)f11 + (double)sajh._a((float)((double)f14 + 4.71238898038469)) * d;
        double d8 = (double)f13 + (double)sajh._b(f14) * d;
        double d9 = (double)f13 + (double)sajh._b((float)((double)f14 + 1.5707963267948966)) * d;
        double d10 = (double)f13 + (double)sajh._b((float)((double)f14 + Math.PI)) * d;
        double d11 = (double)f13 + (double)sajh._b((float)((double)f14 + 4.71238898038469)) * d;
        tessellator.setColorRGBA_F(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha);
        tessellator.addVertexWithUV(d4, d3, d8, f7, f9);
        tessellator.addVertexWithUV(d5, d3, d9, f7, f10);
        tessellator.addVertexWithUV(d6, d3, d10, f8, f10);
        tessellator.addVertexWithUV(d7, d3, d11, f8, f9);
        tessellator.setColorRGBA_F(this.particleRed * 0.6f, this.particleGreen * 0.6f, this.particleBlue * 0.6f, this.particleAlpha);
        tessellator.addVertexWithUV(d4, d2, d8, f8, f9);
        tessellator.addVertexWithUV(d7, d2, d11, f8, f10);
        tessellator.addVertexWithUV(d6, d2, d10, f7, f10);
        tessellator.addVertexWithUV(d5, d2, d9, f7, f9);
        tessellator.setColorRGBA_F(this.particleRed * 0.8f, this.particleGreen * 0.8f, this.particleBlue * 0.8f, this.particleAlpha);
        tessellator.addVertexWithUV(d4, d3, d8, f7, f9);
        tessellator.addVertexWithUV(d4, d2, d8, f7, f10);
        tessellator.addVertexWithUV(d5, d2, d9, f8, f10);
        tessellator.addVertexWithUV(d5, d3, d9, f8, f9);
        tessellator.addVertexWithUV(d6, d3, d10, f7, f9);
        tessellator.addVertexWithUV(d6, d2, d10, f7, f10);
        tessellator.addVertexWithUV(d7, d2, d11, f8, f10);
        tessellator.addVertexWithUV(d7, d3, d11, f8, f9);
        tessellator.addVertexWithUV(d5, d3, d9, f7, f9);
        tessellator.addVertexWithUV(d5, d2, d9, f7, f10);
        tessellator.addVertexWithUV(d6, d2, d10, f8, f10);
        tessellator.addVertexWithUV(d6, d3, d10, f8, f9);
        tessellator.addVertexWithUV(d7, d3, d11, f7, f9);
        tessellator.addVertexWithUV(d7, d2, d11, f7, f10);
        tessellator.addVertexWithUV(d4, d2, d8, f8, f10);
        tessellator.addVertexWithUV(d4, d3, d8, f8, f9);
    }
}

