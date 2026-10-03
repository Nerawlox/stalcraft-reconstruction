/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityBubbleFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;
import poersch.minecraft.bettergrassandleaves.entity.EntityRisingBubbleFX;

public class EntityRisingBubbleSpawnerFX
extends EntityBubbleFX {
    protected float streamAngleOffset;

    public EntityRisingBubbleSpawnerFX(World world, double d, double d2, double d3, float f, int n) {
        super(world, d, d2, d3, 0.0, 0.0, 0.0);
        f = this.particleScale * 10.0f;
        this.particleMaxAge = n;
    }

    @Override
    public void onUpdate() {
        if (this.particleAge++ > this.particleMaxAge) {
            this.setDead();
        }
        if (this.particleAge % 3 == 0) {
            Minecraft._E()._w._a(new EntityRisingBubbleFX(this.worldObj, this.posX + (double)(this.particleAge & 1) * 0.08, this.posY, this.posZ + (double)(this.particleAge & 2) * 0.04, this.streamAngleOffset));
        }
    }

    @Override
    public void renderParticle(Tessellator tessellator, float f, float f2, float f3, float f4, float f5, float f6) {
    }
}

