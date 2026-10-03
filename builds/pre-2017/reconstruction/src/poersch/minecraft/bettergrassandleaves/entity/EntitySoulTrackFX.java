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

@SideOnly(value=Side.CLIENT)
public class EntitySoulTrackFX
extends EntityFX {
    float maxAlpha;
    boolean flipU;
    boolean flipV;

    public EntitySoulTrackFX(World world, double d, double d2, double d3, float f, Icon icon) {
        super(world, d, d2, d3, 0.0, 0.0, 0.0);
        this.motionZ = 0.0;
        this.motionY = 0.0;
        this.motionX = 0.0;
        this.particleScale = 0.3f;
        this.particleGravity = 0.01f;
        this.particleMaxAge = 24;
        this.maxAlpha = f;
        this.particleAlpha = f;
        this.noClip = true;
        this.particleIcon = icon;
        this.flipU = Math.random() > 0.5;
        this.flipV = Math.random() > 0.5;
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
        this.motionY = this.motionY * 0.98 - 0.04 * (double)this.particleGravity;
        ++this.particleAge;
        if (this.particleAge < 2) {
            this.particleAlpha = this.maxAlpha * (float)this.particleAge / 2.0f;
        } else if (this.particleAge > this.particleMaxAge - 20) {
            this.particleAlpha = this.maxAlpha * (float)(this.particleMaxAge - this.particleAge) / 20.0f;
            if (this.particleAge > this.particleMaxAge) {
                this.setDead();
            }
        } else {
            this.particleAlpha = this.maxAlpha;
        }
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
    }

    @Override
    public void renderParticle(Tessellator tessellator, float f, float f2, float f3, float f4, float f5, float f6) {
        double d;
        double d2;
        double d3;
        double d4;
        if (!this.flipU) {
            d4 = this.particleIcon.getMinU();
            d3 = this.particleIcon.getMaxU();
        } else {
            d4 = this.particleIcon.getMaxU();
            d3 = this.particleIcon.getMinU();
        }
        if (!this.flipV) {
            d2 = this.particleIcon.getMinV();
            d = this.particleIcon.getMaxV();
        } else {
            d2 = this.particleIcon.getMaxV();
            d = this.particleIcon.getMinV();
        }
        float f7 = (float)(this.prevPosX + (this.posX - this.prevPosX) * (double)f - EntityFX.interpPosX);
        float f8 = (float)(this.prevPosY + (this.posY - this.prevPosY) * (double)f - EntityFX.interpPosY);
        float f9 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * (double)f - EntityFX.interpPosZ);
        tessellator.setColorRGBA_F(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha);
        tessellator.addVertexWithUV(f7 - f2 * this.particleScale - f5 * this.particleScale, f8 - f3 * this.particleScale, f9 - f4 * this.particleScale - f6 * this.particleScale, d4, d);
        tessellator.addVertexWithUV(f7 - f2 * this.particleScale + f5 * this.particleScale, f8 + f3 * this.particleScale, f9 - f4 * this.particleScale + f6 * this.particleScale, d4, d2);
        tessellator.addVertexWithUV(f7 + f2 * this.particleScale + f5 * this.particleScale, f8 + f3 * this.particleScale, f9 + f4 * this.particleScale + f6 * this.particleScale, d3, d2);
        tessellator.addVertexWithUV(f7 + f2 * this.particleScale - f5 * this.particleScale, f8 - f3 * this.particleScale, f9 + f4 * this.particleScale - f6 * this.particleScale, d3, d);
    }
}

