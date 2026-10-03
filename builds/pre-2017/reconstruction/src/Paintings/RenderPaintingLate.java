/*
 * Decompiled with CFR 0.152.
 */
package Paintings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import net.minecraft.util.ugqi;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderPaintingLate
extends Render {
    static boolean Insane;
    static boolean sphax;
    static boolean tiny;
    static boolean gib;
    protected static final ResourceLocation art;

    private float getSize() {
        if (Insane && !tiny && !gib && !sphax) {
            return 512.0f;
        }
        if (!Insane && tiny && !gib && !sphax) {
            return 512.0f;
        }
        if (!Insane && !tiny && gib && !sphax) {
            return 256.0f;
        }
        return !Insane && !tiny && !gib && sphax ? 256.0f : 256.0f;
    }

    public void renderThePainting(EntityPainting entityPainting, double d, double d2, double d3, float f, float f2) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d, (float)d2, (float)d3);
        GL11.glRotatef(f, 0.0f, 1.0f, 0.0f);
        GL11.glEnable(32826);
        Minecraft._E()._h._a(art);
        ugqi ugqi2 = entityPainting.art;
        float f3 = 0.0625f;
        GL11.glScalef(f3, f3, f3);
        this.func_77010_a(entityPainting, ugqi2.__aL, ugqi2.__aM, ugqi2.__aN, ugqi2.__aO);
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }

    private void func_77010_a(EntityPainting entityPainting, int n, int n2, int n3, int n4) {
        float f = (float)(-n) / 2.0f;
        float f2 = (float)(-n2) / 2.0f;
        float f3 = 0.5f;
        float f4 = 0.75f;
        float f5 = 0.8125f;
        float f6 = 0.0f;
        float f7 = 0.0625f;
        float f8 = 0.75f;
        float f9 = 0.8125f;
        float f10 = 0.001953125f;
        float f11 = 0.001953125f;
        float f12 = 0.7519531f;
        float f13 = 0.7519531f;
        float f14 = 0.0f;
        float f15 = 0.0625f;
        for (int i = 0; i < n / 16; ++i) {
            for (int j = 0; j < n2 / 16; ++j) {
                float f16 = f + (float)((i + 1) * 16);
                float f17 = f + (float)(i * 16);
                float f18 = f2 + (float)((j + 1) * 16);
                float f19 = f2 + (float)(j * 16);
                this.func_77008_a(entityPainting, (f16 + f17) / 2.0f, (f18 + f19) / 2.0f);
                float f20 = (float)(n3 + n - i * 16) / this.getSize();
                float f21 = (float)(n3 + n - (i + 1) * 16) / this.getSize();
                float f22 = (float)(n4 + n2 - j * 16) / this.getSize();
                float f23 = (float)(n4 + n2 - (j + 1) * 16) / this.getSize();
                Tessellator tessellator = Tessellator.instance;
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0f, 0.0f, -1.0f);
                tessellator.addVertexWithUV(f16, f19, -f3, f21, f22);
                tessellator.addVertexWithUV(f17, f19, -f3, f20, f22);
                tessellator.addVertexWithUV(f17, f18, -f3, f20, f23);
                tessellator.addVertexWithUV(f16, f18, -f3, f21, f23);
                tessellator.setNormal(0.0f, 0.0f, 1.0f);
                tessellator.addVertexWithUV(f16, f18, f3, f4, f6);
                tessellator.addVertexWithUV(f17, f18, f3, f5, f6);
                tessellator.addVertexWithUV(f17, f19, f3, f5, f7);
                tessellator.addVertexWithUV(f16, f19, f3, f4, f7);
                tessellator.setNormal(0.0f, 1.0f, 0.0f);
                tessellator.addVertexWithUV(f16, f18, -f3, f8, f10);
                tessellator.addVertexWithUV(f17, f18, -f3, f9, f10);
                tessellator.addVertexWithUV(f17, f18, f3, f9, f11);
                tessellator.addVertexWithUV(f16, f18, f3, f8, f11);
                tessellator.setNormal(0.0f, -1.0f, 0.0f);
                tessellator.addVertexWithUV(f16, f19, f3, f8, f10);
                tessellator.addVertexWithUV(f17, f19, f3, f9, f10);
                tessellator.addVertexWithUV(f17, f19, -f3, f9, f11);
                tessellator.addVertexWithUV(f16, f19, -f3, f8, f11);
                tessellator.setNormal(-1.0f, 0.0f, 0.0f);
                tessellator.addVertexWithUV(f16, f18, f3, f13, f14);
                tessellator.addVertexWithUV(f16, f19, f3, f13, f15);
                tessellator.addVertexWithUV(f16, f19, -f3, f12, f15);
                tessellator.addVertexWithUV(f16, f18, -f3, f12, f14);
                tessellator.setNormal(1.0f, 0.0f, 0.0f);
                tessellator.addVertexWithUV(f17, f18, -f3, f13, f14);
                tessellator.addVertexWithUV(f17, f19, -f3, f13, f15);
                tessellator.addVertexWithUV(f17, f19, f3, f12, f15);
                tessellator.addVertexWithUV(f17, f18, f3, f12, f14);
                tessellator.draw();
            }
        }
    }

    private void func_77008_a(EntityPainting entityPainting, float f, float f2) {
        int n = sajh._c(entityPainting.posX);
        int n2 = sajh._c(entityPainting.posY + (double)(f2 / 16.0f));
        int n3 = sajh._c(entityPainting.posZ);
        if (entityPainting.hangingDirection == 2) {
            n = sajh._c(entityPainting.posX + (double)(f / 16.0f));
        }
        if (entityPainting.hangingDirection == 1) {
            n3 = sajh._c(entityPainting.posZ - (double)(f / 16.0f));
        }
        if (entityPainting.hangingDirection == 0) {
            n = sajh._c(entityPainting.posX - (double)(f / 16.0f));
        }
        if (entityPainting.hangingDirection == 3) {
            n3 = sajh._c(entityPainting.posZ + (double)(f / 16.0f));
        }
        int n4 = this.renderManager._i.getLightBrightnessForSkyBlocks(n, n2, n3, 0);
        int n5 = n4 % 65536;
        int n6 = n4 / 65536;
        iwya._a(iwya._b, n5, n6);
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
    }

    @Override
    public void doRender(Entity entity, double d, double d2, double d3, float f, float f2) {
        this.renderThePainting((EntityPainting)entity, d, d2, d3, f, f2);
    }

    protected ResourceLocation func_110806_a(EntityPainting entityPainting) {
        return art;
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return this.func_110806_a((EntityPainting)entity);
    }

    static {
        art = new ResourceLocation("subaraki:art/gib.png");
    }
}

