/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import poersch.minecraft.bettergrassandleaves.entity.EntityBloodStainsFX;

@SideOnly(value=Side.CLIENT)
public class EntityBloodDropsFX
extends EntityFX {
    private Icon iconBloodStain;

    public EntityBloodDropsFX(World world, double d, double d2, double d3, int n, Icon icon, Icon icon2) {
        super(world, d, d2, d3, 0.0, 0.0, 0.0);
        this.particleRed = (float)(n >> 16 & 0xFF) * 0.00392f;
        this.particleGreen = (float)(n >> 8 & 0xFF) * 0.00392f;
        this.particleBlue = (float)(n & 0xFF) * 0.00392f;
        this.particleGravity = 0.02f;
        this.particleScale = 0.2f;
        this.particleMaxAge = 50;
        this.noClip = false;
        this.particleIcon = icon;
        this.iconBloodStain = icon2;
    }

    @Override
    public int getFXLayer() {
        return 1;
    }

    @Override
    public void onUpdate() {
        this.particleScale = 0.2f + 0.3f * (float)this.particleAge / (float)this.particleMaxAge;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setDead();
        }
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.98;
        this.motionY = this.motionY * 0.98 - (double)this.particleGravity;
        this.motionZ *= 0.98;
        if (this.onGround) {
            double d = (int)(this.posY + 0.5);
            Minecraft._E()._w._a(new EntityBloodStainsFX(this.worldObj, this.posX, d, this.posZ, 1.0f, (float)(Math.random() * Math.PI), this.particleRed, this.particleGreen, this.particleBlue, this.iconBloodStain, Math.random() > 0.5));
            this.setDead();
        }
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
        tessellator.setColorRGBA_F(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha);
        tessellator.addVertexWithUV(f11 - f2 * this.particleScale - f5 * this.particleScale, f12 - f3 * this.particleScale, f13 - f4 * this.particleScale - f6 * this.particleScale, f7, f10);
        tessellator.addVertexWithUV(f11 - f2 * this.particleScale + f5 * this.particleScale, f12 + f3 * this.particleScale, f13 - f4 * this.particleScale + f6 * this.particleScale, f7, f9);
        tessellator.addVertexWithUV(f11 + f2 * this.particleScale + f5 * this.particleScale, f12 + f3 * this.particleScale, f13 + f4 * this.particleScale + f6 * this.particleScale, f8, f9);
        tessellator.addVertexWithUV(f11 + f2 * this.particleScale - f5 * this.particleScale, f12 - f3 * this.particleScale, f13 + f4 * this.particleScale - f6 * this.particleScale, f8, f10);
    }
}

