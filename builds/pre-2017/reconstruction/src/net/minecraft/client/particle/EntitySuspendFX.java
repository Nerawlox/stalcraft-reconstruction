/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.particle;

import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class EntitySuspendFX
extends EntityFX {
    public EntitySuspendFX(World world, double d, double d2, double d3, double d4, double d5, double d6) {
        super(world, d, d2 - 0.125, d3, d4, d5, d6);
        this.particleRed = 0.4f;
        this.particleGreen = 0.4f;
        this.particleBlue = 0.7f;
        this.setParticleTextureIndex(0);
        this.setSize(0.01f, 0.01f);
        this.particleScale *= this.rand.nextFloat() * 0.6f + 0.2f;
        this.motionX = d4 * 0.0;
        this.motionY = d5 * 0.0;
        this.motionZ = d6 * 0.0;
        this.particleMaxAge = (int)(16.0 / (Math.random() * 0.8 + 0.2));
    }

    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        if (this.worldObj.getBlockMaterial(sajh._c(this.posX), sajh._c(this.posY), sajh._c(this.posZ)) != Material._h) {
            this.setDead();
        }
        if (this.particleMaxAge-- <= 0) {
            this.setDead();
        }
    }
}

