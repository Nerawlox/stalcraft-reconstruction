/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

@SideOnly(value=Side.CLIENT)
public class EntityWaterSuspendFX
extends EntityFX {
    public EntityWaterSuspendFX(World world, double d, double d2, double d3, Icon icon) {
        super(world, d, d2, d3, 0.0, 0.0, 0.0);
        this.particleBlue = 1.0f;
        this.particleGreen = 1.0f;
        this.particleRed = 1.0f;
        this.particleAlpha = 0.0f;
        this.particleScale = 0.5f;
        this.particleMaxAge = 40;
        this.noClip = true;
        this.particleIcon = icon;
    }

    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        float f = (float)this.posY * 0.3f + (float)this.worldObj.getTotalWorldTime() * 0.02f;
        this.moveEntity((double)sajh._a(f) * 0.01, 0.0, (double)sajh._b(f) * 0.01);
        ++this.particleAge;
        if (this.particleAge < 20) {
            this.particleAlpha = (float)this.particleAge / 500.0f;
        } else if (this.particleAge > this.particleMaxAge - 20) {
            this.particleAlpha = (float)(this.particleMaxAge - this.particleAge) / 500.0f;
            if (this.particleAge > this.particleMaxAge) {
                this.setDead();
            }
        } else {
            this.particleAlpha = 0.04f;
        }
        if (this.worldObj.getBlockMaterial(sajh._c(this.posX), sajh._c(this.posY), sajh._c(this.posZ)) != Material._h) {
            this.setDead();
        }
    }

    @Override
    public int getFXLayer() {
        return 1;
    }

    @Override
    public void renderParticle(Tessellator tessellator, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = this.particleIcon.getMinU();
        float f8 = this.particleIcon.getMaxU();
        float f9 = this.particleIcon.getMinV();
        float f10 = this.particleIcon.getMaxV();
        float f11 = (float)(this.prevPosX + (this.posX - this.prevPosX) * (double)f - EntityFX.interpPosX);
        float f12 = (float)(this.prevPosY + (this.posY - this.prevPosY) * (double)f - EntityFX.interpPosY);
        float f13 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * (double)f - EntityFX.interpPosZ);
        tessellator.setBrightness(0xF00000);
        tessellator.setColorRGBA_F(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha);
        tessellator.addVertexWithUV(f11 - f2 * this.particleScale - f5 * this.particleScale, f12 - f3 * this.particleScale, f13 - f4 * this.particleScale - f6 * this.particleScale, f7, f10);
        tessellator.addVertexWithUV(f11 - f2 * this.particleScale + f5 * this.particleScale, f12 + f3 * this.particleScale, f13 - f4 * this.particleScale + f6 * this.particleScale, f7, f9);
        tessellator.addVertexWithUV(f11 + f2 * this.particleScale + f5 * this.particleScale, f12 + f3 * this.particleScale, f13 + f4 * this.particleScale + f6 * this.particleScale, f8, f9);
        tessellator.addVertexWithUV(f11 + f2 * this.particleScale - f5 * this.particleScale, f12 - f3 * this.particleScale, f13 + f4 * this.particleScale - f6 * this.particleScale, f8, f10);
    }
}

