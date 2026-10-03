/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.util.Icon;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

@SideOnly(value=Side.CLIENT)
public class EntityFootprintsFX
extends EntityFX {
    private Entity entity;
    private float distanceWalked;
    private boolean flipU;
    private int allowedBlockID;

    public EntityFootprintsFX(World world, double d, double d2, double d3, float f, float f2, Icon icon, boolean bl, Entity entity, int n) {
        super(world, d, d2 + 0.02, d3, 0.0, 0.0, 0.0);
        this.particleScale = f;
        f = (float)((double)f * 0.707106781);
        f2 = (float)((double)f2 - 0.7853981633974483);
        this.prevPosX = sajh._a(f2) * f;
        this.prevPosY = sajh._b(f2) * f;
        f2 = (float)((double)f2 + 1.5707963267948966);
        this.prevPosZ = sajh._a(f2) * f;
        this.particleGravity = sajh._b(f2) * f;
        this.particleAlpha = 0.4f;
        this.particleMaxAge = 550;
        this.noClip = true;
        this.particleIcon = icon;
        this.flipU = bl;
        this.allowedBlockID = n;
        this.entity = entity;
        if (this.entity != null) {
            this.distanceWalked = entity.distanceWalkedOnStepModified + 0.5f;
        }
    }

    @Override
    public int getFXLayer() {
        return 1;
    }

    @Override
    public void onUpdate() {
        this.particleAlpha = 0.4f - 0.4f * (float)this.particleAge / (float)this.particleMaxAge;
        if (this.particleAge++ > this.particleMaxAge) {
            this.setDead();
        }
        if ((this.particleAge & 8) == 0 && this.worldObj.getBlockId((int)this.posX, (int)(this.posY - 0.025), (int)this.posZ) != this.allowedBlockID) {
            this.setDead();
        }
        if (this.entity != null && this.entity.distanceWalkedOnStepModified > this.distanceWalked) {
            if (this.worldObj.getBlockId((int)this.entity.posX, (int)(this.posY - 0.025), (int)this.entity.posZ) == this.allowedBlockID) {
                double d = this.posY - 0.02;
                Minecraft._E()._w._a(new EntityFootprintsFX(this.worldObj, this.entity.posX, d, this.entity.posZ, this.particleScale, -(this.entity.rotationYaw * 3.141593f) / 180.0f, this.particleIcon, !this.flipU, null, this.allowedBlockID));
            }
            this.entity = null;
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
        tessellator.setColorRGBA_F(1.0f, 1.0f, 1.0f, this.particleAlpha);
        tessellator.addVertexWithUV(d5 + this.prevPosX, d6, d7 + this.prevPosY, d, d3);
        tessellator.addVertexWithUV(d5 + this.prevPosZ, d6, d7 + (double)this.particleGravity, d2, d3);
        tessellator.addVertexWithUV(d5 - this.prevPosX, d6, d7 - this.prevPosY, d2, d4);
        tessellator.addVertexWithUV(d5 - this.prevPosZ, d6, d7 - (double)this.particleGravity, d, d4);
    }
}

