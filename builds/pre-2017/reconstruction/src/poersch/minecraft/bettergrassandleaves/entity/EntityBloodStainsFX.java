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

@SideOnly(value=Side.CLIENT)
public class EntityBloodStainsFX
extends EntityFX {
    private boolean flipU;

    public EntityBloodStainsFX(World world, double d, double d2, double d3, float f, float f2, float f3, float f4, float f5, Icon icon, boolean bl) {
        super(world, d, d2 + 0.03, d3, 0.0, 0.0, 0.0);
        this.particleScale = f;
        f = (float)((double)f * 0.707106781);
        f2 = (float)((double)f2 - 0.7853981633974483);
        this.prevPosX = sajh._a(f2) * f;
        this.prevPosY = sajh._b(f2) * f;
        f2 = (float)((double)f2 + 1.5707963267948966);
        this.prevPosZ = sajh._a(f2) * f;
        this.particleGravity = sajh._b(f2) * f;
        this.particleRed = f3;
        this.particleGreen = f4;
        this.particleBlue = f5;
        this.particleAlpha = 1.0f;
        this.particleMaxAge = 450;
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
        this.particleAlpha = 1.0f - 1.0f * (float)this.particleAge / (float)this.particleMaxAge;
        if (this.particleAge++ > this.particleMaxAge) {
            this.setDead();
        }
        if ((this.particleAge & 8) == 0 && this.worldObj.getBlockId((int)this.posX, (int)(this.posY - 0.035), (int)this.posZ) == 0) {
            this.setDead();
        }
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
        tessellator.setColorRGBA_F(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha);
        if (this.particleAge < 4) {
            this.particleScale = ((float)this.particleAge + f) / 4.0f;
            tessellator.addVertexWithUV(d5 + this.prevPosX * (double)this.particleScale, d6, d7 + this.prevPosY * (double)this.particleScale, d, d3);
            tessellator.addVertexWithUV(d5 + this.prevPosZ * (double)this.particleScale, d6, d7 + (double)(this.particleGravity * this.particleScale), d2, d3);
            tessellator.addVertexWithUV(d5 - this.prevPosX * (double)this.particleScale, d6, d7 - this.prevPosY * (double)this.particleScale, d2, d4);
            tessellator.addVertexWithUV(d5 - this.prevPosZ * (double)this.particleScale, d6, d7 - (double)(this.particleGravity * this.particleScale), d, d4);
        } else {
            tessellator.addVertexWithUV(d5 + this.prevPosX, d6, d7 + this.prevPosY, d, d3);
            tessellator.addVertexWithUV(d5 + this.prevPosZ, d6, d7 + (double)this.particleGravity, d2, d3);
            tessellator.addVertexWithUV(d5 - this.prevPosX, d6, d7 - this.prevPosY, d2, d4);
            tessellator.addVertexWithUV(d5 - this.prevPosZ, d6, d7 - (double)this.particleGravity, d, d4);
        }
    }
}

