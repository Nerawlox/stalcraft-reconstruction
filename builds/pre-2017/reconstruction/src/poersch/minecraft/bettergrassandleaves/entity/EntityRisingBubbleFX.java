/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.entity;

import net.minecraft.block.BlockFluid;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityBubbleFX;
import net.minecraft.client.particle.EntityRainFX;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class EntityRisingBubbleFX
extends EntityBubbleFX {
    protected float streamAngleOffset;
    protected double surfaceY = 1000000.0;

    public EntityRisingBubbleFX(World world, double d, double d2, double d3, float f) {
        super(world, d, d2, d3, 0.0, 0.0, 0.0);
        this.motionZ = 0.0;
        this.motionY = 0.0;
        this.motionX = 0.0;
        this.streamAngleOffset = f;
        this.particleGravity = this.particleScale;
        this.particleScale = 0.0f;
        this.particleMaxAge = 0;
    }

    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.surfaceY == 1000000.0 && this.worldObj.getBlockMaterial((int)this.posX, (int)(this.posY + 0.5), (int)this.posZ) != Material._h) {
            this.surfaceY = (double)((int)this.posY) + 1.01 - (double)BlockFluid._a(this.worldObj.getBlockMetadata((int)this.posX, (int)this.posY, (int)this.posZ));
        }
        if (this.posY < this.surfaceY) {
            if (this.particleAge++ < 12) {
                this.particleScale = this.particleGravity * ((float)this.particleAge / 12.0f);
            }
            float f = (float)this.posY * 0.8f + this.streamAngleOffset;
            this.motionX = (double)sajh._a(f) * 0.22 * this.motionY;
            this.motionY = this.motionY * 0.98 + 0.008 - 0.0022 * (double)this.particleGravity;
            this.motionZ = (double)sajh._a(f) * 0.22 * this.motionY;
            this.moveEntity(this.motionX, this.posY + this.motionY < this.surfaceY ? this.motionY : this.surfaceY - this.posY, this.motionZ);
            if (this.surfaceY < 1000000.0 && this.worldObj.getBlockMaterial((int)this.posX, (int)this.posY, (int)this.posZ) != Material._h) {
                this.setDead();
            }
        } else {
            this.particleScale = this.particleGravity * 1.5f;
            if (this.particleMaxAge++ > 0) {
                Minecraft._E()._w._a(new EntityRainFX(this.worldObj, this.posX, this.posY, this.posZ));
                this.setDead();
            }
        }
    }
}

