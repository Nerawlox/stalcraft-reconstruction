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
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import poersch.minecraft.bettergrassandleaves.entity.EntitySoulTrackFX;

@SideOnly(value=Side.CLIENT)
public class EntityRisingSoulFX
extends EntityFX {
    private float windAngleOffset;
    private Icon[] trackIcons;

    public EntityRisingSoulFX(World world, double d, double d2, double d3, Icon icon, Icon[] iconArray) {
        super(world, d, d2, d3, 0.0, 0.0, 0.0);
        this.motionZ = 0.0;
        this.motionY = 0.0;
        this.motionX = 0.0;
        this.windAngleOffset = this.particleScale * 10.0f;
        this.particleScale = 0.6f;
        this.particleGravity = -0.3f;
        this.particleMaxAge = 40;
        this.particleAlpha = 0.5f;
        this.noClip = true;
        this.particleIcon = icon;
        this.trackIcons = iconArray;
    }

    @Override
    public int getFXLayer() {
        return 1;
    }

    @Override
    public void onUpdate() {
        Icon icon;
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.motionY = this.motionY * 0.98 - 0.04 * (double)this.particleGravity;
        ++this.particleAge;
        if (this.particleAge < 18) {
            this.particleAlpha = (float)this.particleAge / 45.0f;
        } else if (this.particleAge > this.particleMaxAge - 12) {
            this.particleAlpha = (float)(this.particleMaxAge - this.particleAge) / 30.0f;
            if (this.particleAge > this.particleMaxAge) {
                this.setDead();
            }
        } else {
            this.particleAlpha = 0.4f;
        }
        if (this.trackIcons != null && (icon = this.trackIcons[(int)(Math.random() * (double)(this.trackIcons.length - 1) + 0.5)]) != null) {
            Minecraft._E()._w._a(new EntitySoulTrackFX(this.worldObj, this.posX, this.posY - 0.3, this.posZ, this.particleAlpha * 0.8f, icon));
        }
        long l = (long)(this.posX * 3129871.0) ^ (long)this.posZ * 116129781L ^ (long)this.posY;
        l = l * l * 42317861L + l * 11L;
        float f = (float)this.posY * 0.8f + this.windAngleOffset;
        this.motionX = this.motionX * 0.8 + ((double)((float)(l >> 16 & 0xFL) / 15.0f) - 0.5 + (double)sajh._a(f)) * 0.025;
        this.motionZ = this.motionZ * 0.8 + ((double)((float)(l >> 24 & 0xFL) / 15.0f) - 0.5 + (double)sajh._b(f)) * 0.025;
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
        tessellator.setColorRGBA_F(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha);
        tessellator.addVertexWithUV(f11 - f2 * this.particleScale - f5 * this.particleScale, f12 - f3 * this.particleScale, f13 - f4 * this.particleScale - f6 * this.particleScale, f7, f10);
        tessellator.addVertexWithUV(f11 - f2 * this.particleScale + f5 * this.particleScale, f12 + f3 * this.particleScale, f13 - f4 * this.particleScale + f6 * this.particleScale, f7, f9);
        tessellator.addVertexWithUV(f11 + f2 * this.particleScale + f5 * this.particleScale, f12 + f3 * this.particleScale, f13 + f4 * this.particleScale + f6 * this.particleScale, f8, f9);
        tessellator.addVertexWithUV(f11 + f2 * this.particleScale - f5 * this.particleScale, f12 - f3 * this.particleScale, f13 + f4 * this.particleScale - f6 * this.particleScale, f8, f10);
    }
}

