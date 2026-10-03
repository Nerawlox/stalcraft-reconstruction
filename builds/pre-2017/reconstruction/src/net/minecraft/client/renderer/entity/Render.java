/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public abstract class Render {
    public static final ResourceLocation shadowTextures = new ResourceLocation("textures/misc/shadow.png");
    public RenderManager renderManager;
    public RenderBlocks renderBlocks = new RenderBlocks();
    public float shadowSize;
    public float shadowOpaque = 1.0f;

    public abstract void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9);

    public abstract ResourceLocation getEntityTexture(Entity var1);

    public void bindEntityTexture(Entity entity) {
        this.bindTexture(this.getEntityTexture(entity));
    }

    public void bindTexture(ResourceLocation resourceLocation) {
        this.renderManager._g._a(resourceLocation);
    }

    public void renderEntityOnFire(Entity entity, double d, double d2, double d3, float f) {
        GL11.glDisable(2896);
        Icon icon = Block.fire._a(0);
        Icon icon2 = Block.fire._a(1);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d, (float)d2, (float)d3);
        float f2 = entity.width * 1.4f;
        GL11.glScalef(f2, f2, f2);
        Tessellator tessellator = Tessellator.instance;
        float f3 = 0.5f;
        float f4 = 0.0f;
        float f5 = entity.height / f2;
        float f6 = (float)(entity.posY - entity.boundingBox._c);
        GL11.glRotatef(-this.renderManager._l, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(0.0f, 0.0f, -0.3f + (float)((int)f5) * 0.02f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        float f7 = 0.0f;
        int n = 0;
        EntityRenderer cfr_ignored_0 = Minecraft._E()._D;
        EntityRenderer.enableTerrainShader(-1);
        tessellator.startDrawingQuads();
        while (f5 > 0.0f) {
            Icon icon3 = n % 2 == 0 ? icon : icon2;
            this.bindTexture(sctd._c);
            float f8 = icon3.getMinU();
            float f9 = icon3.getMinV();
            float f10 = icon3.getMaxU();
            float f11 = icon3.getMaxV();
            if (n / 2 % 2 == 0) {
                float f12 = f10;
                f10 = f8;
                f8 = f12;
            }
            tessellator.addVertexWithUV(f3 - f4, 0.0f - f6, f7, f10, f11);
            tessellator.addVertexWithUV(-f3 - f4, 0.0f - f6, f7, f8, f11);
            tessellator.addVertexWithUV(-f3 - f4, 1.4f - f6, f7, f8, f9);
            tessellator.addVertexWithUV(f3 - f4, 1.4f - f6, f7, f10, f9);
            f5 -= 0.45f;
            f6 -= 0.45f;
            f3 *= 0.9f;
            f7 += 0.03f;
            ++n;
        }
        tessellator.draw();
        Minecraft minecraft = Minecraft._E();
        minecraft._D.disableTerrainShader();
        GL11.glPopMatrix();
        GL11.glEnable(2896);
    }

    public void renderShadow(Entity entity, double d, double d2, double d3, float f, float f2) {
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        this.renderManager._g._a(shadowTextures);
        World world = this.getWorldFromRenderManager();
        GL11.glDepthMask(false);
        float f3 = this.shadowSize;
        if (entity instanceof EntityLiving) {
            EntityLiving entityLiving = (EntityLiving)entity;
            f3 *= entityLiving.getRenderSizeModifier();
            if (entityLiving.isChild()) {
                f3 *= 0.5f;
            }
        }
        double d4 = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)f2;
        double d5 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)f2 + (double)entity.getShadowSize();
        double d6 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)f2;
        int n = sajh._c(d4 - (double)f3);
        int n2 = sajh._c(d4 + (double)f3);
        int n3 = sajh._c(d5 - (double)f3);
        int n4 = sajh._c(d5);
        int n5 = sajh._c(d6 - (double)f3);
        int n6 = sajh._c(d6 + (double)f3);
        double d7 = d - d4;
        double d8 = d2 - d5;
        double d9 = d3 - d6;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        for (int i = n; i <= n2; ++i) {
            for (int j = n3; j <= n4; ++j) {
                for (int k = n5; k <= n6; ++k) {
                    int n7 = world.getBlockId(i, j - 1, k);
                    if (n7 <= 0 || world.getBlockLightValue(i, j, k) <= 3) continue;
                    this.renderShadowOnBlock(Block.blocksList[n7], d, d2 + (double)entity.getShadowSize(), d3, i, j, k, f, f3, d7, d8 + (double)entity.getShadowSize(), d9);
                }
            }
        }
        tessellator.draw();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(3042);
        GL11.glDepthMask(true);
    }

    public World getWorldFromRenderManager() {
        return this.renderManager._i;
    }

    public void renderShadowOnBlock(Block block, double d, double d2, double d3, int n, int n2, int n3, float f, float f2, double d4, double d5, double d6) {
        double d7;
        Tessellator tessellator = Tessellator.instance;
        if (block.renderAsNormalBlock() && (d7 = ((double)f - (d2 - ((double)n2 + d5)) / 2.0) * 0.5 * (double)this.getWorldFromRenderManager().getLightBrightness(n, n2, n3)) >= 0.0) {
            if (d7 > 1.0) {
                d7 = 1.0;
            }
            tessellator.setColorRGBA_F(1.0f, 1.0f, 1.0f, (float)d7);
            double d8 = (double)n + block.func_83009_v() + d4;
            double d9 = (double)n + block.getBlockBoundsMaxX() + d4;
            double d10 = (double)n2 + block.getBlockBoundsMinY() + d5 + 0.015625;
            double d11 = (double)n3 + block.getBlockBoundsMinZ() + d6;
            double d12 = (double)n3 + block.getBlockBoundsMaxZ() + d6;
            float f3 = (float)((d - d8) / 2.0 / (double)f2 + 0.5);
            float f4 = (float)((d - d9) / 2.0 / (double)f2 + 0.5);
            float f5 = (float)((d3 - d11) / 2.0 / (double)f2 + 0.5);
            float f6 = (float)((d3 - d12) / 2.0 / (double)f2 + 0.5);
            tessellator.addVertexWithUV(d8, d10, d11, f3, f5);
            tessellator.addVertexWithUV(d8, d10, d12, f3, f6);
            tessellator.addVertexWithUV(d9, d10, d12, f4, f6);
            tessellator.addVertexWithUV(d9, d10, d11, f4, f5);
        }
    }

    public static void renderOffsetAABB(AxisAlignedBB axisAlignedBB, double d, double d2, double d3) {
        GL11.glDisable(3553);
        Tessellator tessellator = Tessellator.instance;
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        tessellator.startDrawingQuads();
        tessellator.setTranslation(d, d2, d3);
        tessellator.setNormal(0.0f, 0.0f, -1.0f);
        tessellator.addVertex(axisAlignedBB._b, axisAlignedBB._f, axisAlignedBB._d);
        tessellator.addVertex(axisAlignedBB._e, axisAlignedBB._f, axisAlignedBB._d);
        tessellator.addVertex(axisAlignedBB._e, axisAlignedBB._c, axisAlignedBB._d);
        tessellator.addVertex(axisAlignedBB._b, axisAlignedBB._c, axisAlignedBB._d);
        tessellator.setNormal(0.0f, 0.0f, 1.0f);
        tessellator.addVertex(axisAlignedBB._b, axisAlignedBB._c, axisAlignedBB._g);
        tessellator.addVertex(axisAlignedBB._e, axisAlignedBB._c, axisAlignedBB._g);
        tessellator.addVertex(axisAlignedBB._e, axisAlignedBB._f, axisAlignedBB._g);
        tessellator.addVertex(axisAlignedBB._b, axisAlignedBB._f, axisAlignedBB._g);
        tessellator.setNormal(0.0f, -1.0f, 0.0f);
        tessellator.addVertex(axisAlignedBB._b, axisAlignedBB._c, axisAlignedBB._d);
        tessellator.addVertex(axisAlignedBB._e, axisAlignedBB._c, axisAlignedBB._d);
        tessellator.addVertex(axisAlignedBB._e, axisAlignedBB._c, axisAlignedBB._g);
        tessellator.addVertex(axisAlignedBB._b, axisAlignedBB._c, axisAlignedBB._g);
        tessellator.setNormal(0.0f, 1.0f, 0.0f);
        tessellator.addVertex(axisAlignedBB._b, axisAlignedBB._f, axisAlignedBB._g);
        tessellator.addVertex(axisAlignedBB._e, axisAlignedBB._f, axisAlignedBB._g);
        tessellator.addVertex(axisAlignedBB._e, axisAlignedBB._f, axisAlignedBB._d);
        tessellator.addVertex(axisAlignedBB._b, axisAlignedBB._f, axisAlignedBB._d);
        tessellator.setNormal(-1.0f, 0.0f, 0.0f);
        tessellator.addVertex(axisAlignedBB._b, axisAlignedBB._c, axisAlignedBB._g);
        tessellator.addVertex(axisAlignedBB._b, axisAlignedBB._f, axisAlignedBB._g);
        tessellator.addVertex(axisAlignedBB._b, axisAlignedBB._f, axisAlignedBB._d);
        tessellator.addVertex(axisAlignedBB._b, axisAlignedBB._c, axisAlignedBB._d);
        tessellator.setNormal(1.0f, 0.0f, 0.0f);
        tessellator.addVertex(axisAlignedBB._e, axisAlignedBB._c, axisAlignedBB._d);
        tessellator.addVertex(axisAlignedBB._e, axisAlignedBB._f, axisAlignedBB._d);
        tessellator.addVertex(axisAlignedBB._e, axisAlignedBB._f, axisAlignedBB._g);
        tessellator.addVertex(axisAlignedBB._e, axisAlignedBB._c, axisAlignedBB._g);
        tessellator.setTranslation(0.0, 0.0, 0.0);
        tessellator.draw();
        GL11.glEnable(3553);
    }

    public static void renderAABB(AxisAlignedBB axisAlignedBB) {
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertex(axisAlignedBB._b, axisAlignedBB._f, axisAlignedBB._d);
        tessellator.addVertex(axisAlignedBB._e, axisAlignedBB._f, axisAlignedBB._d);
        tessellator.addVertex(axisAlignedBB._e, axisAlignedBB._c, axisAlignedBB._d);
        tessellator.addVertex(axisAlignedBB._b, axisAlignedBB._c, axisAlignedBB._d);
        tessellator.addVertex(axisAlignedBB._b, axisAlignedBB._c, axisAlignedBB._g);
        tessellator.addVertex(axisAlignedBB._e, axisAlignedBB._c, axisAlignedBB._g);
        tessellator.addVertex(axisAlignedBB._e, axisAlignedBB._f, axisAlignedBB._g);
        tessellator.addVertex(axisAlignedBB._b, axisAlignedBB._f, axisAlignedBB._g);
        tessellator.addVertex(axisAlignedBB._b, axisAlignedBB._c, axisAlignedBB._d);
        tessellator.addVertex(axisAlignedBB._e, axisAlignedBB._c, axisAlignedBB._d);
        tessellator.addVertex(axisAlignedBB._e, axisAlignedBB._c, axisAlignedBB._g);
        tessellator.addVertex(axisAlignedBB._b, axisAlignedBB._c, axisAlignedBB._g);
        tessellator.addVertex(axisAlignedBB._b, axisAlignedBB._f, axisAlignedBB._g);
        tessellator.addVertex(axisAlignedBB._e, axisAlignedBB._f, axisAlignedBB._g);
        tessellator.addVertex(axisAlignedBB._e, axisAlignedBB._f, axisAlignedBB._d);
        tessellator.addVertex(axisAlignedBB._b, axisAlignedBB._f, axisAlignedBB._d);
        tessellator.addVertex(axisAlignedBB._b, axisAlignedBB._c, axisAlignedBB._g);
        tessellator.addVertex(axisAlignedBB._b, axisAlignedBB._f, axisAlignedBB._g);
        tessellator.addVertex(axisAlignedBB._b, axisAlignedBB._f, axisAlignedBB._d);
        tessellator.addVertex(axisAlignedBB._b, axisAlignedBB._c, axisAlignedBB._d);
        tessellator.addVertex(axisAlignedBB._e, axisAlignedBB._c, axisAlignedBB._d);
        tessellator.addVertex(axisAlignedBB._e, axisAlignedBB._f, axisAlignedBB._d);
        tessellator.addVertex(axisAlignedBB._e, axisAlignedBB._f, axisAlignedBB._g);
        tessellator.addVertex(axisAlignedBB._e, axisAlignedBB._c, axisAlignedBB._g);
        tessellator.draw();
    }

    public void setRenderManager(RenderManager renderManager) {
        this.renderManager = renderManager;
    }

    public void doRenderShadowAndFire(Entity entity, double d, double d2, double d3, float f, float f2) {
        double d4;
        float f3;
        if (this.renderManager._n.fancyGraphics && this.shadowSize > 0.0f && !entity.isInvisible() && (f3 = (float)((1.0 - (d4 = this.renderManager._a(entity.posX, entity.posY, entity.posZ)) / 256.0) * (double)this.shadowOpaque)) > 0.0f) {
            this.renderShadow(entity, d, d2, d3, f3, f2);
        }
        if (entity.canRenderOnFire()) {
            this.renderEntityOnFire(entity, d, d2, d3, f2);
        }
    }

    public FontRenderer getFontRendererFromRenderManager() {
        return this.renderManager._a();
    }

    public void updateIcons(IconRegister iconRegister) {
    }
}

