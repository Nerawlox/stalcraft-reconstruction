/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.particle;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class EntityLargeExplodeFX
extends EntityFX {
    public static final ResourceLocation field_110127_a = new ResourceLocation("textures/entity/explosion.png");
    public int field_70581_a;
    public int field_70584_aq;
    public TextureManager theRenderEngine;
    public float field_70582_as;

    public EntityLargeExplodeFX(TextureManager textureManager, World world, double d, double d2, double d3, double d4, double d5, double d6) {
        super(world, d, d2, d3, 0.0, 0.0, 0.0);
        this.theRenderEngine = textureManager;
        this.field_70584_aq = 6 + this.rand.nextInt(4);
        this.particleGreen = this.particleBlue = this.rand.nextFloat() * 0.6f + 0.4f;
        this.particleRed = this.particleBlue;
        this.field_70582_as = 1.0f - (float)d4 * 0.5f;
    }

    @Override
    public void renderParticle(Tessellator tessellator, float f, float f2, float f3, float f4, float f5, float f6) {
        int n = (int)(((float)this.field_70581_a + f) * 15.0f / (float)this.field_70584_aq);
        if (n > 15) {
            return;
        }
        this.theRenderEngine._a(field_110127_a);
        float f7 = (float)(n % 4) / 4.0f;
        float f8 = f7 + 0.24975f;
        float f9 = (float)(n / 4) / 4.0f;
        float f10 = f9 + 0.24975f;
        float f11 = 2.0f * this.field_70582_as;
        float f12 = (float)(this.prevPosX + (this.posX - this.prevPosX) * (double)f - interpPosX);
        float f13 = (float)(this.prevPosY + (this.posY - this.prevPosY) * (double)f - interpPosY);
        float f14 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * (double)f - interpPosZ);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(2896);
        qnon._a();
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_F(this.particleRed, this.particleGreen, this.particleBlue, 1.0f);
        tessellator.setNormal(0.0f, 1.0f, 0.0f);
        tessellator.setBrightness(240);
        tessellator.addVertexWithUV(f12 - f2 * f11 - f5 * f11, f13 - f3 * f11, f14 - f4 * f11 - f6 * f11, f8, f10);
        tessellator.addVertexWithUV(f12 - f2 * f11 + f5 * f11, f13 + f3 * f11, f14 - f4 * f11 + f6 * f11, f8, f9);
        tessellator.addVertexWithUV(f12 + f2 * f11 + f5 * f11, f13 + f3 * f11, f14 + f4 * f11 + f6 * f11, f7, f9);
        tessellator.addVertexWithUV(f12 + f2 * f11 - f5 * f11, f13 - f3 * f11, f14 + f4 * f11 - f6 * f11, f7, f10);
        tessellator.draw();
        GL11.glPolygonOffset(0.0f, 0.0f);
        GL11.glEnable(2896);
    }

    @Override
    public int getBrightnessForRender(float f) {
        return 61680;
    }

    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        ++this.field_70581_a;
        if (this.field_70581_a == this.field_70584_aq) {
            this.setDead();
        }
    }

    @Override
    public int getFXLayer() {
        return 3;
    }
}

