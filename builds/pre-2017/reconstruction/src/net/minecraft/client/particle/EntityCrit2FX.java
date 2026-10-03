/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.particle;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class EntityCrit2FX
extends EntityFX {
    public Entity theEntity;
    public int currentLife;
    public int maximumLife;
    public String particleName;

    public EntityCrit2FX(World world, Entity entity) {
        this(world, entity, "crit");
    }

    public EntityCrit2FX(World world, Entity entity, String string) {
        super(world, entity.posX, entity.boundingBox._c + (double)(entity.height / 2.0f), entity.posZ, entity.motionX, entity.motionY, entity.motionZ);
        this.theEntity = entity;
        this.maximumLife = 3;
        this.particleName = string;
        this.onUpdate();
    }

    @Override
    public void renderParticle(Tessellator tessellator, float f, float f2, float f3, float f4, float f5, float f6) {
    }

    @Override
    public void onUpdate() {
        for (int i = 0; i < 16; ++i) {
            double d;
            double d2;
            double d3 = this.rand.nextFloat() * 2.0f - 1.0f;
            if (d3 * d3 + (d2 = (double)(this.rand.nextFloat() * 2.0f - 1.0f)) * d2 + (d = (double)(this.rand.nextFloat() * 2.0f - 1.0f)) * d > 1.0) continue;
            double d4 = this.theEntity.posX + d3 * (double)this.theEntity.width / 4.0;
            double d5 = this.theEntity.boundingBox._c + (double)(this.theEntity.height / 2.0f) + d2 * (double)this.theEntity.height / 4.0;
            double d6 = this.theEntity.posZ + d * (double)this.theEntity.width / 4.0;
            this.worldObj.spawnParticle(this.particleName, d4, d5, d6, d3, d2 + 0.2, d);
        }
        ++this.currentLife;
        if (this.currentLife >= this.maximumLife) {
            this.setDead();
        }
    }

    @Override
    public int getFXLayer() {
        return 3;
    }
}

