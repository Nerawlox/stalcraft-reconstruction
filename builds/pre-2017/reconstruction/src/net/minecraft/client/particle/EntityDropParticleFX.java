/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.particle;

import net.minecraft.block.BlockFluid;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class EntityDropParticleFX
extends EntityFX {
    public Material materialType;
    public int bobTimer;

    public EntityDropParticleFX(World world, double d, double d2, double d3, Material material) {
        super(world, d, d2, d3, 0.0, 0.0, 0.0);
        this.motionZ = 0.0;
        this.motionY = 0.0;
        this.motionX = 0.0;
        if (material == Material._h) {
            this.particleRed = 0.0f;
            this.particleGreen = 0.0f;
            this.particleBlue = 1.0f;
        } else {
            this.particleRed = 1.0f;
            this.particleGreen = 0.0f;
            this.particleBlue = 0.0f;
        }
        this.setParticleTextureIndex(113);
        this.setSize(0.01f, 0.01f);
        this.particleGravity = 0.06f;
        this.materialType = material;
        this.bobTimer = 40;
        this.particleMaxAge = (int)(64.0 / (Math.random() * 0.8 + 0.2));
        this.motionZ = 0.0;
        this.motionY = 0.0;
        this.motionX = 0.0;
    }

    @Override
    public int getBrightnessForRender(float f) {
        if (this.materialType == Material._h) {
            return super.getBrightnessForRender(f);
        }
        return 257;
    }

    @Override
    public float getBrightness(float f) {
        if (this.materialType == Material._h) {
            return super.getBrightness(f);
        }
        return 1.0f;
    }

    @Override
    public void onUpdate() {
        double d;
        Material material;
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.materialType == Material._h) {
            this.particleRed = 0.2f;
            this.particleGreen = 0.3f;
            this.particleBlue = 1.0f;
        } else {
            this.particleRed = 1.0f;
            this.particleGreen = 16.0f / (float)(40 - this.bobTimer + 16);
            this.particleBlue = 4.0f / (float)(40 - this.bobTimer + 8);
        }
        this.motionY -= (double)this.particleGravity;
        if (this.bobTimer-- > 0) {
            this.motionX *= 0.02;
            this.motionY *= 0.02;
            this.motionZ *= 0.02;
            this.setParticleTextureIndex(113);
        } else {
            this.setParticleTextureIndex(112);
        }
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= (double)0.98f;
        this.motionY *= (double)0.98f;
        this.motionZ *= (double)0.98f;
        if (this.particleMaxAge-- <= 0) {
            this.setDead();
        }
        if (this.onGround) {
            if (this.materialType == Material._h) {
                this.setDead();
                this.worldObj.spawnParticle("splash", this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0);
            } else {
                this.setParticleTextureIndex(114);
            }
            this.motionX *= (double)0.7f;
            this.motionZ *= (double)0.7f;
        }
        if (((material = this.worldObj.getBlockMaterial(sajh._c(this.posX), sajh._c(this.posY), sajh._c(this.posZ)))._d() || material._a()) && this.posY < (d = (double)((float)(sajh._c(this.posY) + 1) - BlockFluid._a(this.worldObj.getBlockMetadata(sajh._c(this.posX), sajh._c(this.posY), sajh._c(this.posZ)))))) {
            this.setDead();
        }
    }
}

