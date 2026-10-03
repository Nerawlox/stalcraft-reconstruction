/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockFluid;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

@SideOnly(value=Side.CLIENT)
public class EntityFallingLeavesFastFX
extends EntityFX {
    protected float windAngleOffset;
    protected boolean wasInWater = false;

    public EntityFallingLeavesFastFX(World world, double d, double d2, double d3, float f, float f2, int n, Icon icon) {
        super(world, d, d2, d3, 0.0, 0.0, 0.0);
        this.motionZ = 0.0;
        this.motionY = 0.0;
        this.motionX = 0.0;
        this.particleTextureJitterX = (float)((int)this.particleTextureJitterX) * 4.0f;
        this.particleTextureJitterY = (float)((int)this.particleTextureJitterY) * 4.0f;
        this.particleRed = (float)(n >> 16 & 0xFF) * 0.00392f * f2;
        this.particleGreen = (float)(n >> 8 & 0xFF) * 0.00392f * f2;
        this.particleBlue = (float)(n & 0xFF) * 0.00392f * f2;
        this.windAngleOffset = this.particleScale * 10.0f;
        this.particleScale = f;
        this.particleGravity = 0.0032f;
        this.particleMaxAge = 50;
        this.noClip = false;
        this.particleIcon = icon;
    }

    @Override
    public int getFXLayer() {
        return 1;
    }

    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.onGround) {
            this.motionY = -0.001;
            this.motionX *= 0.6;
            this.motionZ *= 0.6;
            ++this.particleAge;
            if (this.particleAge > this.particleMaxAge - 12) {
                this.particleAlpha = (float)(this.particleMaxAge - this.particleAge) / 12.0f;
                if (this.particleAge > this.particleMaxAge) {
                    this.setDead();
                }
            }
        } else if (this.worldObj.getBlockMaterial((int)this.posX, (int)this.posY, (int)this.posZ) == Material._h && this.posY < (double)((int)this.posY) + 1.06 - (double)BlockFluid._a(this.worldObj.getBlockMetadata((int)this.posX, (int)this.posY, (int)this.posZ))) {
            this.wasInWater = true;
            this.motionY = (double)this.particleGravity * 0.5;
            float f = (float)BlockFluid._a(this.worldObj, (int)this.posX, (int)this.posY, (int)this.posZ, Material._h);
            this.motionX *= 0.93;
            this.motionZ *= 0.93;
            if ((double)f != -1000.0) {
                this.motionX -= (double)sajh._a(f) * 0.0044;
                this.motionZ += (double)sajh._b(f) * 0.0044;
            }
            ++this.particleAge;
            if (this.particleAge > this.particleMaxAge - 12) {
                this.particleAlpha = (float)(this.particleMaxAge - this.particleAge) / 12.0f;
                if (this.particleAge > this.particleMaxAge) {
                    this.setDead();
                }
            }
        } else {
            this.motionY = this.motionY * 0.98 - (double)this.particleGravity;
            if (!this.wasInWater) {
                float f = (float)this.posY * 0.8f + this.windAngleOffset;
                this.motionX = (double)sajh._a(f) * 0.4 * -this.motionY;
                this.motionZ = (double)sajh._b(f) * 0.4 * -this.motionY;
            } else {
                this.motionX *= 0.99;
                this.motionZ *= 0.99;
            }
        }
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
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
        tessellator.setColorRGBA_F(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha);
        double d = 0.125 * (double)this.particleScale;
        tessellator.addVertexWithUV((double)f11 - (double)f2 * d - (double)f5 * d, (double)f12 - (double)f3 * d, (double)f13 - (double)f4 * d - (double)f6 * d, f7, f10);
        tessellator.addVertexWithUV((double)f11 - (double)f2 * d + (double)f5 * d, (double)f12 + (double)f3 * d, (double)f13 - (double)f4 * d + (double)f6 * d, f7, f9);
        tessellator.addVertexWithUV((double)f11 + (double)f2 * d + (double)f5 * d, (double)f12 + (double)f3 * d, (double)f13 + (double)f4 * d + (double)f6 * d, f8, f9);
        tessellator.addVertexWithUV((double)f11 + (double)f2 * d - (double)f5 * d, (double)f12 - (double)f3 * d, (double)f13 + (double)f4 * d - (double)f6 * d, f8, f10);
    }
}

