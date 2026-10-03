/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.particle;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class EntityFootStepFX
extends EntityFX {
    public static final ResourceLocation field_110126_a = new ResourceLocation("textures/particle/footprint.png");
    public int footstepAge;
    public int footstepMaxAge;
    public TextureManager currentFootSteps;

    public EntityFootStepFX(TextureManager textureManager, World world, double d, double d2, double d3) {
        super(world, d, d2, d3, 0.0, 0.0, 0.0);
        this.currentFootSteps = textureManager;
        this.motionZ = 0.0;
        this.motionY = 0.0;
        this.motionX = 0.0;
        this.footstepMaxAge = 200;
    }

    @Override
    public void renderParticle(Tessellator tessellator, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7;
        float f8 = ((float)this.footstepAge + f) / (float)this.footstepMaxAge;
        if ((f7 = 2.0f - (f8 *= f8) * 2.0f) > 1.0f) {
            f7 = 1.0f;
        }
        f7 *= 0.2f;
        GL11.glDisable(2896);
        float f9 = 0.125f;
        float f10 = (float)(this.posX - interpPosX);
        float f11 = (float)(this.posY - interpPosY);
        float f12 = (float)(this.posZ - interpPosZ);
        float f13 = this.worldObj.getLightBrightness(sajh._c(this.posX), sajh._c(this.posY), sajh._c(this.posZ));
        this.currentFootSteps._a(field_110126_a);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_F(f13, f13, f13, f7);
        tessellator.addVertexWithUV(f10 - f9, f11, f12 + f9, 0.0, 1.0);
        tessellator.addVertexWithUV(f10 + f9, f11, f12 + f9, 1.0, 1.0);
        tessellator.addVertexWithUV(f10 + f9, f11, f12 - f9, 1.0, 0.0);
        tessellator.addVertexWithUV(f10 - f9, f11, f12 - f9, 0.0, 0.0);
        tessellator.draw();
        GL11.glDisable(3042);
        GL11.glEnable(2896);
    }

    @Override
    public void onUpdate() {
        ++this.footstepAge;
        if (this.footstepAge == this.footstepMaxAge) {
            this.setDead();
        }
    }

    @Override
    public int getFXLayer() {
        return 3;
    }
}

