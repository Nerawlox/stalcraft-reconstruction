/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.particle;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class EntityPickupFX
extends EntityFX {
    public Entity entityToPickUp;
    public Entity entityPickingUp;
    public int age;
    public int maxAge;
    public float yOffs;

    public EntityPickupFX(World world, Entity entity, Entity entity2, float f) {
        super(world, entity.posX, entity.posY, entity.posZ, entity.motionX, entity.motionY, entity.motionZ);
        this.entityToPickUp = entity;
        this.entityPickingUp = entity2;
        this.maxAge = 3;
        this.yOffs = f;
    }

    @Override
    public void renderParticle(Tessellator tessellator, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = ((float)this.age + f) / (float)this.maxAge;
        f7 *= f7;
        double d = this.entityToPickUp.posX;
        double d2 = this.entityToPickUp.posY;
        double d3 = this.entityToPickUp.posZ;
        double d4 = this.entityPickingUp.lastTickPosX + (this.entityPickingUp.posX - this.entityPickingUp.lastTickPosX) * (double)f;
        double d5 = this.entityPickingUp.lastTickPosY + (this.entityPickingUp.posY - this.entityPickingUp.lastTickPosY) * (double)f + (double)this.yOffs;
        double d6 = this.entityPickingUp.lastTickPosZ + (this.entityPickingUp.posZ - this.entityPickingUp.lastTickPosZ) * (double)f;
        double d7 = d + (d4 - d) * (double)f7;
        double d8 = d2 + (d5 - d2) * (double)f7;
        double d9 = d3 + (d6 - d3) * (double)f7;
        int n = sajh._c(d7);
        int n2 = sajh._c(d8 + (double)(this.yOffset / 2.0f));
        int n3 = sajh._c(d9);
        int n4 = this.getBrightnessForRender(f);
        int n5 = n4 % 65536;
        int n6 = n4 / 65536;
        iwya._a(iwya._b, (float)n5 / 1.0f, (float)n6 / 1.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        RenderManager._b._a(this.entityToPickUp, (float)(d7 -= interpPosX), (float)(d8 -= interpPosY), (float)(d9 -= interpPosZ), this.entityToPickUp.rotationYaw, f);
    }

    @Override
    public void onUpdate() {
        ++this.age;
        if (this.age == this.maxAge) {
            this.setDead();
        }
    }

    @Override
    public int getFXLayer() {
        return 3;
    }
}

