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
import poersch.minecraft.bettergrassandleaves.renderer.BlockRenderer;

@SideOnly(value=Side.CLIENT)
public class EntityWaterSprayFX
extends EntityFX {
    public EntityWaterSprayFX(World world, double d, double d2, double d3, float f, Icon icon) {
        super(world, d, d2, d3, 0.0, 0.0, 0.0);
        this.motionX *= 0.0;
        this.motionY *= 0.0;
        this.motionZ *= 0.0;
        this.particleGravity = 0.02f;
        this.particleScale = 0.3f;
        this.particleMaxAge = 40;
        this.noClip = true;
        this.particleIcon = icon;
    }

    @Override
    public int getFXLayer() {
        return 1;
    }

    @Override
    public void onUpdate() {
        ++this.particleAge;
        if (this.particleAge < 10) {
            this.particleAlpha = (float)this.particleAge / 16.7f;
        } else if (this.particleAge > this.particleMaxAge - 10) {
            this.particleAlpha = (float)(this.particleMaxAge - this.particleAge) / 16.7f;
            if (this.particleAge > this.particleMaxAge) {
                this.setDead();
            }
        } else {
            this.particleAlpha = 0.6f;
        }
        if (this.worldObj.getBlockMaterial((int)this.posX, (int)this.posY, (int)this.posZ) == Material._h) {
            this.motionY = this.posY < (double)((float)((int)this.posY + 1) - BlockFluid._a(this.worldObj.getBlockMetadata((int)this.posX, (int)this.posY, (int)this.posZ))) ? 0.0 : this.motionY * 0.98 - (double)this.particleGravity * 0.5;
            float f = (float)BlockFluid._a(this.worldObj, (int)this.posX, (int)this.posY, (int)this.posZ, Material._h);
            this.motionX *= 0.86;
            this.motionZ *= 0.86;
            if ((double)f != -1000.0) {
                this.motionX -= (double)sajh._a(f) * 0.005;
                this.motionZ += (double)sajh._b(f) * 0.005;
            }
        }
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
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
        tessellator.setColorRGBA_F(1.0f, 1.0f, 1.0f, this.particleAlpha);
        this.particleScale = 0.3f + ((float)this.particleAge + f) / (float)this.particleMaxAge * 0.3f;
        BlockRenderer.renderBlock(this.particleIcon, 0.0, 0.0, 0.0, this.particleScale, 1.0f, 1.0f, 1.0f, this.particleAlpha, false, false);
        tessellator.addVertexWithUV(f11 - f2 * this.particleScale - f5 * this.particleScale, f12 - f3 * this.particleScale, f13 - f4 * this.particleScale - f6 * this.particleScale, f7, f10);
        tessellator.addVertexWithUV(f11 - f2 * this.particleScale + f5 * this.particleScale, f12 + f3 * this.particleScale, f13 - f4 * this.particleScale + f6 * this.particleScale, f7, f9);
        tessellator.addVertexWithUV(f11 + f2 * this.particleScale + f5 * this.particleScale, f12 + f3 * this.particleScale, f13 + f4 * this.particleScale + f6 * this.particleScale, f8, f9);
        tessellator.addVertexWithUV(f11 + f2 * this.particleScale - f5 * this.particleScale, f12 - f3 * this.particleScale, f13 + f4 * this.particleScale - f6 * this.particleScale, f8, f10);
    }
}

