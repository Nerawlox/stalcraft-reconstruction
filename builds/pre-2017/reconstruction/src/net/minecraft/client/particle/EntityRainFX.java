/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.particle;

import net.minecraft.block.BlockFluid;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class EntityRainFX
extends EntityFX {
    public EntityRainFX(World world, double d, double d2, double d3) {
        super(world, d, d2, d3, 0.0, 0.0, 0.0);
        this.motionX *= (double)0.3f;
        this.motionY = (float)Math.random() * 0.2f + 0.1f;
        this.motionZ *= (double)0.3f;
        this.particleRed = 1.0f;
        this.particleGreen = 1.0f;
        this.particleBlue = 1.0f;
        this.setParticleTextureIndex(19 + this.rand.nextInt(4));
        this.setSize(0.01f, 0.01f);
        this.particleGravity = 0.06f;
        this.particleMaxAge = (int)(8.0 / (Math.random() * 0.8 + 0.2));
    }

    @Override
    public void onUpdate() {
        double d;
        Material material;
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.motionY -= (double)this.particleGravity;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= (double)0.98f;
        this.motionY *= (double)0.98f;
        this.motionZ *= (double)0.98f;
        if (this.particleMaxAge-- <= 0) {
            this.setDead();
        }
        if (this.onGround) {
            if (Math.random() < 0.5) {
                this.setDead();
            }
            this.motionX *= (double)0.7f;
            this.motionZ *= (double)0.7f;
        }
        if (((material = this.worldObj.getBlockMaterial(sajh._c(this.posX), sajh._c(this.posY), sajh._c(this.posZ)))._d() || material._a()) && this.posY < (d = (double)((float)(sajh._c(this.posY) + 1) - BlockFluid._a(this.worldObj.getBlockMetadata(sajh._c(this.posX), sajh._c(this.posY), sajh._c(this.posZ)))))) {
            this.setDead();
        }
    }
}

