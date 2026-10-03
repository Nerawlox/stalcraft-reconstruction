/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntityPortalFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.ClientProxy;
import noppes.npcs.client.renderer.RenderNPCInterface;
import org.lwjgl.opengl.GL11;

public class EntityEnderFX
extends EntityPortalFX {
    private static final ResourceLocation particleTextures = new ResourceLocation("textures/particle/particles.png");
    private float portalParticleScale;
    private int particleNumber;
    private RenderNPCInterface npcRenderer;
    private EntityNPCInterface npc;

    public EntityEnderFX(EntityNPCInterface entityNPCInterface, double d, double d2, double d3, double d4, double d5, double d6) {
        super(entityNPCInterface.worldObj, d, d2, d3, d4, d5, d6);
        this.npcRenderer = (RenderNPCInterface)RenderManager._b._a(entityNPCInterface);
        this.npc = entityNPCInterface;
        this.particleNumber = entityNPCInterface.worldObj.rand.nextInt(2);
        this.portalParticleScale = this.particleScale = this.rand.nextFloat() * 0.2f + 0.5f;
        this.particleBlue = 1.0f;
        this.particleGreen = 1.0f;
        this.particleRed = 1.0f;
    }

    @Override
    public void renderParticle(Tessellator tessellator, float f, float f2, float f3, float f4, float f5, float f6) {
        Tessellator tessellator2 = Tessellator.instance;
        tessellator2.draw();
        float f7 = ((float)this.particleAge + f) / (float)this.particleMaxAge;
        f7 = 1.0f - f7;
        f7 *= f7;
        f7 = 1.0f - f7;
        this.particleScale = this.portalParticleScale * f7;
        Minecraft minecraft = Minecraft._E();
        ClientProxy.bindTexture(this.npcRenderer.getEntityTexture(this.npc));
        float f8 = 0.875f;
        float f9 = f8 + 0.125f;
        float f10 = 0.75f - (float)this.particleNumber * 0.25f;
        float f11 = f10 + 0.25f;
        float f12 = 0.1f * this.particleScale;
        float f13 = (float)(this.prevPosX + (this.posX - this.prevPosX) * (double)f - EntityFX.interpPosX);
        float f14 = (float)(this.prevPosY + (this.posY - this.prevPosY) * (double)f - EntityFX.interpPosY);
        float f15 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * (double)f - EntityFX.interpPosZ);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        tessellator2.startDrawingQuads();
        tessellator2.setBrightness(this.getBrightnessForRender(f));
        tessellator.setColorOpaque_F(1.0f, 1.0f, 1.0f);
        tessellator.addVertexWithUV(f13 - f2 * f12 - f5 * f12, f14 - f3 * f12, f15 - f4 * f12 - f6 * f12, f9, f11);
        tessellator.addVertexWithUV(f13 - f2 * f12 + f5 * f12, f14 + f3 * f12, f15 - f4 * f12 + f6 * f12, f9, f10);
        tessellator.addVertexWithUV(f13 + f2 * f12 + f5 * f12, f14 + f3 * f12, f15 + f4 * f12 + f6 * f12, f8, f10);
        tessellator.addVertexWithUV(f13 + f2 * f12 - f5 * f12, f14 - f3 * f12, f15 + f4 * f12 - f6 * f12, f8, f11);
        tessellator2.draw();
        ClientProxy.bindTexture(particleTextures);
        tessellator2.startDrawingQuads();
    }

    @Override
    public int getFXLayer() {
        return 0;
    }
}

