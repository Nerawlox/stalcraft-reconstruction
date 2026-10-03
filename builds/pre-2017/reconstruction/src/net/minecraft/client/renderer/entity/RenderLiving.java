/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import org.lwjgl.opengl.GL11;

public abstract class RenderLiving
extends RendererLivingEntity {
    public RenderLiving(ModelBase modelBase, float f) {
        super(modelBase, f);
    }

    public boolean func_130007_b(EntityLiving entityLiving) {
        return super.func_110813_b(entityLiving) && (entityLiving.getAlwaysRenderNameTagForRender() || entityLiving.hasCustomNameTag() && entityLiving == this.renderManager._k);
    }

    public void doRenderLiving(EntityLiving entityLiving, double d, double d2, double d3, float f, float f2) {
        super.doRenderLiving(entityLiving, d, d2, d3, f, f2);
        this.func_110827_b(entityLiving, d, d2, d3, f, f2);
    }

    public double func_110828_a(double d, double d2, double d3) {
        return d + (d2 - d) * d3;
    }

    public void func_110827_b(EntityLiving entityLiving, double d, double d2, double d3, float f, float f2) {
        Entity entity = entityLiving.getLeashedToEntity();
        if (entity != null) {
            float f3;
            int n;
            d2 -= (1.6 - (double)entityLiving.height) * 0.5;
            Tessellator tessellator = Tessellator.instance;
            double d4 = this.func_110828_a(entity.prevRotationYaw, entity.rotationYaw, f2 * 0.5f) * 0.01745329238474369;
            double d5 = this.func_110828_a(entity.prevRotationPitch, entity.rotationPitch, f2 * 0.5f) * 0.01745329238474369;
            double d6 = Math.cos(d4);
            double d7 = Math.sin(d4);
            double d8 = Math.sin(d5);
            if (entity instanceof EntityHanging) {
                d6 = 0.0;
                d7 = 0.0;
                d8 = -1.0;
            }
            double d9 = Math.cos(d5);
            double d10 = this.func_110828_a(entity.prevPosX, entity.posX, f2) - d6 * 0.7 - d7 * 0.5 * d9;
            double d11 = this.func_110828_a(entity.prevPosY + (double)entity.getEyeHeight() * 0.7, entity.posY + (double)entity.getEyeHeight() * 0.7, f2) - d8 * 0.5 - 0.25;
            double d12 = this.func_110828_a(entity.prevPosZ, entity.posZ, f2) - d7 * 0.7 + d6 * 0.5 * d9;
            double d13 = this.func_110828_a(entityLiving.prevRenderYawOffset, entityLiving.renderYawOffset, f2) * 0.01745329238474369 + 1.5707963267948966;
            d6 = Math.cos(d13) * (double)entityLiving.width * 0.4;
            d7 = Math.sin(d13) * (double)entityLiving.width * 0.4;
            double d14 = this.func_110828_a(entityLiving.prevPosX, entityLiving.posX, f2) + d6;
            double d15 = this.func_110828_a(entityLiving.prevPosY, entityLiving.posY, f2);
            double d16 = this.func_110828_a(entityLiving.prevPosZ, entityLiving.posZ, f2) + d7;
            d += d6;
            d3 += d7;
            double d17 = (float)(d10 - d14);
            double d18 = (float)(d11 - d15);
            double d19 = (float)(d12 - d16);
            GL11.glDisable(3553);
            GL11.glDisable(2896);
            GL11.glDisable(2884);
            int n2 = 24;
            double d20 = 0.025;
            tessellator.startDrawing(5);
            for (n = 0; n <= 24; ++n) {
                if (n % 2 == 0) {
                    tessellator.setColorRGBA_F(0.5f, 0.4f, 0.3f, 1.0f);
                } else {
                    tessellator.setColorRGBA_F(0.35f, 0.28f, 0.21000001f, 1.0f);
                }
                f3 = (float)n / 24.0f;
                tessellator.addVertex(d + d17 * (double)f3 + 0.0, d2 + d18 * (double)(f3 * f3 + f3) * 0.5 + (double)((24.0f - (float)n) / 18.0f + 0.125f), d3 + d19 * (double)f3);
                tessellator.addVertex(d + d17 * (double)f3 + 0.025, d2 + d18 * (double)(f3 * f3 + f3) * 0.5 + (double)((24.0f - (float)n) / 18.0f + 0.125f) + 0.025, d3 + d19 * (double)f3);
            }
            tessellator.draw();
            tessellator.startDrawing(5);
            for (n = 0; n <= 24; ++n) {
                if (n % 2 == 0) {
                    tessellator.setColorRGBA_F(0.5f, 0.4f, 0.3f, 1.0f);
                } else {
                    tessellator.setColorRGBA_F(0.35f, 0.28f, 0.21000001f, 1.0f);
                }
                f3 = (float)n / 24.0f;
                tessellator.addVertex(d + d17 * (double)f3 + 0.0, d2 + d18 * (double)(f3 * f3 + f3) * 0.5 + (double)((24.0f - (float)n) / 18.0f + 0.125f) + 0.025, d3 + d19 * (double)f3);
                tessellator.addVertex(d + d17 * (double)f3 + 0.025, d2 + d18 * (double)(f3 * f3 + f3) * 0.5 + (double)((24.0f - (float)n) / 18.0f + 0.125f), d3 + d19 * (double)f3 + 0.025);
            }
            tessellator.draw();
            GL11.glEnable(2896);
            GL11.glEnable(3553);
            GL11.glEnable(2884);
        }
    }

    @Override
    public /* synthetic */ boolean func_110813_b(EntityLivingBase entityLivingBase) {
        return this.func_130007_b((EntityLiving)entityLivingBase);
    }

    public /* synthetic */ void renderPlayer(EntityLivingBase entityLivingBase, double d, double d2, double d3, float f, float f2) {
        this.doRenderLiving((EntityLiving)entityLivingBase, d, d2, d3, f, f2);
    }

    @Override
    public /* synthetic */ void doRender(Entity entity, double d, double d2, double d3, float f, float f2) {
        this.doRenderLiving((EntityLiving)entity, d, d2, d3, f, f2);
    }
}

