/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import org.lwjgl.opengl.GL11;

public class bbbz
extends Render {
    public static final ResourceLocation _a = new ResourceLocation("textures/particle/particles.png");

    public void _a(EntityFishHook entityFishHook, double d, double d2, double d3, float f, float f2) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d, (float)d2, (float)d3);
        GL11.glEnable(32826);
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        this.bindEntityTexture(entityFishHook);
        Tessellator tessellator = Tessellator.instance;
        int n = 1;
        int n2 = 2;
        float f3 = (float)(n * 8 + 0) / 128.0f;
        float f4 = (float)(n * 8 + 8) / 128.0f;
        float f5 = (float)(n2 * 8 + 0) / 128.0f;
        float f6 = (float)(n2 * 8 + 8) / 128.0f;
        float f7 = 1.0f;
        float f8 = 0.5f;
        float f9 = 0.5f;
        GL11.glRotatef(180.0f - this.renderManager._l, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-this.renderManager._m, 1.0f, 0.0f, 0.0f);
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0f, 1.0f, 0.0f);
        tessellator.addVertexWithUV(0.0f - f8, 0.0f - f9, 0.0, f3, f6);
        tessellator.addVertexWithUV(f7 - f8, 0.0f - f9, 0.0, f4, f6);
        tessellator.addVertexWithUV(f7 - f8, 1.0f - f9, 0.0, f4, f5);
        tessellator.addVertexWithUV(0.0f - f8, 1.0f - f9, 0.0, f3, f5);
        tessellator.draw();
        GL11.glDisable(32826);
        GL11.glPopMatrix();
        if (entityFishHook.angler != null) {
            double d4;
            float f10 = entityFishHook.angler.getSwingProgress(f2);
            float f11 = sajh._a(sajh._c(f10) * (float)Math.PI);
            Vec3 vec3 = entityFishHook.worldObj.getWorldVec3Pool()._a(-0.5, 0.03, 0.8);
            vec3._a(-(entityFishHook.angler.prevRotationPitch + (entityFishHook.angler.rotationPitch - entityFishHook.angler.prevRotationPitch) * f2) * (float)Math.PI / 180.0f);
            vec3._b(-(entityFishHook.angler.prevRotationYaw + (entityFishHook.angler.rotationYaw - entityFishHook.angler.prevRotationYaw) * f2) * (float)Math.PI / 180.0f);
            vec3._b(f11 * 0.5f);
            vec3._a(-f11 * 0.7f);
            double d5 = entityFishHook.angler.prevPosX + (entityFishHook.angler.posX - entityFishHook.angler.prevPosX) * (double)f2 + vec3._c;
            double d6 = entityFishHook.angler.prevPosY + (entityFishHook.angler.posY - entityFishHook.angler.prevPosY) * (double)f2 + vec3._d;
            double d7 = entityFishHook.angler.prevPosZ + (entityFishHook.angler.posZ - entityFishHook.angler.prevPosZ) * (double)f2 + vec3._e;
            double d8 = d4 = entityFishHook.angler == Minecraft._E()._t ? 0.0 : (double)entityFishHook.angler.getEyeHeight();
            if (this.renderManager._n.thirdPersonView > 0 || entityFishHook.angler != Minecraft._E()._t) {
                float f12 = (entityFishHook.angler.prevRenderYawOffset + (entityFishHook.angler.renderYawOffset - entityFishHook.angler.prevRenderYawOffset) * f2) * (float)Math.PI / 180.0f;
                double d9 = sajh._a(f12);
                double d10 = sajh._b(f12);
                d5 = entityFishHook.angler.prevPosX + (entityFishHook.angler.posX - entityFishHook.angler.prevPosX) * (double)f2 - d10 * 0.35 - d9 * 0.85;
                d6 = entityFishHook.angler.prevPosY + d4 + (entityFishHook.angler.posY - entityFishHook.angler.prevPosY) * (double)f2 - 0.45;
                d7 = entityFishHook.angler.prevPosZ + (entityFishHook.angler.posZ - entityFishHook.angler.prevPosZ) * (double)f2 - d9 * 0.35 + d10 * 0.85;
            }
            double d11 = entityFishHook.prevPosX + (entityFishHook.posX - entityFishHook.prevPosX) * (double)f2;
            double d12 = entityFishHook.prevPosY + (entityFishHook.posY - entityFishHook.prevPosY) * (double)f2 + 0.25;
            double d13 = entityFishHook.prevPosZ + (entityFishHook.posZ - entityFishHook.prevPosZ) * (double)f2;
            double d14 = (float)(d5 - d11);
            double d15 = (float)(d6 - d12);
            double d16 = (float)(d7 - d13);
            GL11.glDisable(3553);
            GL11.glDisable(2896);
            tessellator.startDrawing(3);
            tessellator.setColorOpaque_I(0);
            int n3 = 16;
            for (int i = 0; i <= n3; ++i) {
                float f13 = (float)i / (float)n3;
                tessellator.addVertex(d + d14 * (double)f13, d2 + d15 * (double)(f13 * f13 + f13) * 0.5 + 0.25, d3 + d16 * (double)f13);
            }
            tessellator.draw();
            GL11.glEnable(2896);
            GL11.glEnable(3553);
        }
    }

    public ResourceLocation _a(EntityFishHook entityFishHook) {
        return _a;
    }

    @Override
    public /* synthetic */ ResourceLocation getEntityTexture(Entity entity) {
        return this._a((EntityFishHook)entity);
    }

    @Override
    public /* synthetic */ void doRender(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityFishHook)entity, d, d2, d3, f, f2);
    }
}

