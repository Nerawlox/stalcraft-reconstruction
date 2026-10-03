/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public abstract class RendererLivingEntity
extends Render {
    public static final ResourceLocation RES_ITEM_GLINT = new ResourceLocation("textures/misc/enchanted_item_glint.png");
    public ModelBase mainModel;
    public ModelBase renderPassModel;
    public static float NAME_TAG_RANGE = 64.0f;
    public static float NAME_TAG_RANGE_SNEAK = 32.0f;

    public RendererLivingEntity(ModelBase modelBase, float f) {
        this.mainModel = modelBase;
        this.shadowSize = f;
    }

    public void setRenderPassModel(ModelBase modelBase) {
        this.renderPassModel = modelBase;
    }

    public float interpolateRotation(float f, float f2, float f3) {
        float f4;
        for (f4 = f2 - f; f4 < -180.0f; f4 += 360.0f) {
        }
        while (f4 >= 180.0f) {
            f4 -= 360.0f;
        }
        return f + f3 * f4;
    }

    public void doRenderLiving(EntityLivingBase entityLivingBase, double d, double d2, double d3, float f, float f2) {
        if (MinecraftForge.EVENT_BUS.post(new RenderLivingEvent.Pre(entityLivingBase, this))) {
            return;
        }
        GL11.glPushMatrix();
        GL11.glDisable(2884);
        this.mainModel.onGround = this.renderSwingProgress(entityLivingBase, f2);
        if (this.renderPassModel != null) {
            this.renderPassModel.onGround = this.mainModel.onGround;
        }
        this.mainModel.isRiding = entityLivingBase.isRiding();
        if (this.renderPassModel != null) {
            this.renderPassModel.isRiding = this.mainModel.isRiding;
        }
        this.mainModel.isChild = entityLivingBase.isChild();
        if (this.renderPassModel != null) {
            this.renderPassModel.isChild = this.mainModel.isChild;
        }
        try {
            float f3;
            int n;
            float f4;
            float f5;
            int n2;
            float f6;
            float f7 = this.interpolateRotation(entityLivingBase.prevRenderYawOffset, entityLivingBase.renderYawOffset, f2);
            float f8 = this.interpolateRotation(entityLivingBase.prevRotationYawHead, entityLivingBase.rotationYawHead, f2);
            if (entityLivingBase.isRiding() && entityLivingBase.ridingEntity instanceof EntityLivingBase) {
                EntityLivingBase entityLivingBase2 = (EntityLivingBase)entityLivingBase.ridingEntity;
                f7 = this.interpolateRotation(entityLivingBase2.prevRenderYawOffset, entityLivingBase2.renderYawOffset, f2);
                f6 = sajh._g(f8 - f7);
                if (f6 < -85.0f) {
                    f6 = -85.0f;
                }
                if (f6 >= 85.0f) {
                    f6 = 85.0f;
                }
                f7 = f8 - f6;
                if (f6 * f6 > 2500.0f) {
                    f7 += f6 * 0.2f;
                }
            }
            float f9 = entityLivingBase.prevRotationPitch + (entityLivingBase.rotationPitch - entityLivingBase.prevRotationPitch) * f2;
            this.renderLivingAt(entityLivingBase, d, d2, d3);
            f6 = this.handleRotationFloat(entityLivingBase, f2);
            this.rotateCorpse(entityLivingBase, f6, f7, f2);
            float f10 = 0.0625f;
            GL11.glEnable(32826);
            GL11.glScalef(-1.0f, -1.0f, 1.0f);
            this.preRenderCallback(entityLivingBase, f2);
            GL11.glTranslatef(0.0f, -24.0f * f10 - 0.0078125f, 0.0f);
            float f11 = entityLivingBase.prevLimbSwingAmount + (entityLivingBase.limbSwingAmount - entityLivingBase.prevLimbSwingAmount) * f2;
            float f12 = entityLivingBase.limbSwing - entityLivingBase.limbSwingAmount * (1.0f - f2);
            if (entityLivingBase.isChild()) {
                f12 *= 3.0f;
            }
            if (f11 > 1.0f) {
                f11 = 1.0f;
            }
            GL11.glEnable(3008);
            this.mainModel.setLivingAnimations(entityLivingBase, f12, f11, f2);
            this.renderModel(entityLivingBase, f12, f11, f6, f8 - f7, f9, f10);
            for (int i = 0; i < 4; ++i) {
                n2 = this.shouldRenderPass(entityLivingBase, i, f2);
                if (n2 <= 0) continue;
                this.renderPassModel.setLivingAnimations(entityLivingBase, f12, f11, f2);
                this.renderPassModel.render(entityLivingBase, f12, f11, f6, f8 - f7, f9, f10);
                if ((n2 & 0xF0) == 16) {
                    this.func_82408_c(entityLivingBase, i, f2);
                    this.renderPassModel.render(entityLivingBase, f12, f11, f6, f8 - f7, f9, f10);
                }
                if ((n2 & 0xF) == 15) {
                    f5 = (float)entityLivingBase.ticksExisted + f2;
                    this.bindTexture(RES_ITEM_GLINT);
                    GL11.glEnable(3042);
                    f4 = 0.5f;
                    GL11.glColor4f(f4, f4, f4, 1.0f);
                    GL11.glDepthFunc(514);
                    GL11.glDepthMask(false);
                    for (n = 0; n < 2; ++n) {
                        GL11.glDisable(2896);
                        f3 = 0.76f;
                        GL11.glColor4f(0.5f * f3, 0.25f * f3, 0.8f * f3, 1.0f);
                        GL11.glBlendFunc(768, 1);
                        GL11.glMatrixMode(5890);
                        GL11.glLoadIdentity();
                        float f13 = f5 * (0.001f + (float)n * 0.003f) * 20.0f;
                        float f14 = 0.33333334f;
                        GL11.glScalef(f14, f14, f14);
                        GL11.glRotatef(30.0f - (float)n * 60.0f, 0.0f, 0.0f, 1.0f);
                        GL11.glTranslatef(0.0f, f13, 0.0f);
                        GL11.glMatrixMode(5888);
                        this.renderPassModel.render(entityLivingBase, f12, f11, f6, f8 - f7, f9, f10);
                    }
                    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                    GL11.glMatrixMode(5890);
                    GL11.glDepthMask(true);
                    GL11.glLoadIdentity();
                    GL11.glMatrixMode(5888);
                    GL11.glEnable(2896);
                    GL11.glDisable(3042);
                    GL11.glDepthFunc(515);
                }
                GL11.glDisable(3042);
                GL11.glEnable(3008);
            }
            GL11.glDepthMask(true);
            this.renderEquippedItems(entityLivingBase, f2);
            float f15 = entityLivingBase.getBrightness(f2);
            n2 = this.getColorMultiplier(entityLivingBase, f15, f2);
            iwya._a(iwya._b);
            GL11.glDisable(3553);
            iwya._a(iwya._a);
            if ((n2 >> 24 & 0xFF) > 0 || entityLivingBase.hurtTime > 0 || entityLivingBase.deathTime > 0) {
                GL11.glDisable(3553);
                GL11.glDisable(3008);
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
                GL11.glDepthFunc(514);
                if (entityLivingBase.hurtTime > 0 || entityLivingBase.deathTime > 0) {
                    GL11.glColor4f(f15, 0.0f, 0.0f, 0.4f);
                    this.mainModel.render(entityLivingBase, f12, f11, f6, f8 - f7, f9, f10);
                    for (n = 0; n < 4; ++n) {
                        if (this.inheritRenderPass(entityLivingBase, n, f2) < 0) continue;
                        GL11.glColor4f(f15, 0.0f, 0.0f, 0.4f);
                        this.renderPassModel.render(entityLivingBase, f12, f11, f6, f8 - f7, f9, f10);
                    }
                }
                if ((n2 >> 24 & 0xFF) > 0) {
                    f5 = (float)(n2 >> 16 & 0xFF) / 255.0f;
                    f4 = (float)(n2 >> 8 & 0xFF) / 255.0f;
                    float f16 = (float)(n2 & 0xFF) / 255.0f;
                    f3 = (float)(n2 >> 24 & 0xFF) / 255.0f;
                    GL11.glColor4f(f5, f4, f16, f3);
                    this.mainModel.render(entityLivingBase, f12, f11, f6, f8 - f7, f9, f10);
                    for (int i = 0; i < 4; ++i) {
                        if (this.inheritRenderPass(entityLivingBase, i, f2) < 0) continue;
                        GL11.glColor4f(f5, f4, f16, f3);
                        this.renderPassModel.render(entityLivingBase, f12, f11, f6, f8 - f7, f9, f10);
                    }
                }
                GL11.glDepthFunc(515);
                GL11.glDisable(3042);
                GL11.glEnable(3008);
                GL11.glEnable(3553);
            }
            GL11.glDisable(32826);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        iwya._a(iwya._b);
        GL11.glEnable(3553);
        iwya._a(iwya._a);
        GL11.glEnable(2884);
        GL11.glPopMatrix();
        this.passSpecialRender(entityLivingBase, d, d2, d3);
        MinecraftForge.EVENT_BUS.post(new RenderLivingEvent.Post(entityLivingBase, this));
    }

    public void renderModel(EntityLivingBase entityLivingBase, float f, float f2, float f3, float f4, float f5, float f6) {
        this.bindEntityTexture(entityLivingBase);
        if (!entityLivingBase.isInvisible()) {
            this.mainModel.render(entityLivingBase, f, f2, f3, f4, f5, f6);
        } else if (!entityLivingBase.isInvisibleToPlayer(Minecraft._E()._t)) {
            GL11.glPushMatrix();
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.15f);
            GL11.glDepthMask(false);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            GL11.glAlphaFunc(516, 0.003921569f);
            this.mainModel.render(entityLivingBase, f, f2, f3, f4, f5, f6);
            GL11.glDisable(3042);
            GL11.glAlphaFunc(516, 0.1f);
            GL11.glPopMatrix();
            GL11.glDepthMask(true);
        } else {
            this.mainModel.setRotationAngles(f, f2, f3, f4, f5, f6, entityLivingBase);
        }
    }

    public void renderLivingAt(EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        GL11.glTranslatef((float)d, (float)d2, (float)d3);
    }

    public void rotateCorpse(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        GL11.glRotatef(180.0f - f2, 0.0f, 1.0f, 0.0f);
        if (entityLivingBase.deathTime > 0) {
            float f4 = ((float)entityLivingBase.deathTime + f3 - 1.0f) / 20.0f * 1.6f;
            if ((f4 = sajh._c(f4)) > 1.0f) {
                f4 = 1.0f;
            }
            GL11.glRotatef(f4 * this.getDeathMaxRotation(entityLivingBase), 0.0f, 0.0f, 1.0f);
        } else {
            String string = EnumChatFormatting._a(entityLivingBase.getEntityName());
            if (!(!string.equals("Dinnerbone") && !string.equals("Grumm") || entityLivingBase instanceof EntityPlayer && ((EntityPlayer)entityLivingBase).getHideCape())) {
                GL11.glTranslatef(0.0f, entityLivingBase.height + 0.1f, 0.0f);
                GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
            }
        }
    }

    public float renderSwingProgress(EntityLivingBase entityLivingBase, float f) {
        return entityLivingBase.getSwingProgress(f);
    }

    public float handleRotationFloat(EntityLivingBase entityLivingBase, float f) {
        return (float)entityLivingBase.ticksExisted + f;
    }

    public void renderEquippedItems(EntityLivingBase entityLivingBase, float f) {
    }

    public void renderArrowsStuckInEntity(EntityLivingBase entityLivingBase, float f) {
        int n = entityLivingBase.getArrowCountInEntity();
        if (n > 0) {
            EntityArrow entityArrow = new EntityArrow(entityLivingBase.worldObj, entityLivingBase.posX, entityLivingBase.posY, entityLivingBase.posZ);
            Random random = new Random(entityLivingBase.entityId);
            qnon._a();
            for (int i = 0; i < n; ++i) {
                GL11.glPushMatrix();
                ModelRenderer modelRenderer = this.mainModel.getRandomModelBox(random);
                ModelBox modelBox = (ModelBox)modelRenderer.cubeList.get(random.nextInt(modelRenderer.cubeList.size()));
                modelRenderer.postRender(0.0625f);
                float f2 = random.nextFloat();
                float f3 = random.nextFloat();
                float f4 = random.nextFloat();
                float f5 = (modelBox.posX1 + (modelBox.posX2 - modelBox.posX1) * f2) / 16.0f;
                float f6 = (modelBox.posY1 + (modelBox.posY2 - modelBox.posY1) * f3) / 16.0f;
                float f7 = (modelBox.posZ1 + (modelBox.posZ2 - modelBox.posZ1) * f4) / 16.0f;
                GL11.glTranslatef(f5, f6, f7);
                f2 = f2 * 2.0f - 1.0f;
                f3 = f3 * 2.0f - 1.0f;
                f4 = f4 * 2.0f - 1.0f;
                float f8 = sajh._c((f2 *= -1.0f) * f2 + (f4 *= -1.0f) * f4);
                entityArrow.prevRotationYaw = entityArrow.rotationYaw = (float)(Math.atan2(f2, f4) * 180.0 / Math.PI);
                entityArrow.prevRotationPitch = entityArrow.rotationPitch = (float)(Math.atan2(f3 *= -1.0f, f8) * 180.0 / Math.PI);
                double d = 0.0;
                double d2 = 0.0;
                double d3 = 0.0;
                float f9 = 0.0f;
                this.renderManager._a(entityArrow, d, d2, d3, f9, f);
                GL11.glPopMatrix();
            }
            qnon._b();
        }
    }

    public int inheritRenderPass(EntityLivingBase entityLivingBase, int n, float f) {
        return this.shouldRenderPass(entityLivingBase, n, f);
    }

    public int shouldRenderPass(EntityLivingBase entityLivingBase, int n, float f) {
        return -1;
    }

    public void func_82408_c(EntityLivingBase entityLivingBase, int n, float f) {
    }

    public float getDeathMaxRotation(EntityLivingBase entityLivingBase) {
        return 90.0f;
    }

    public int getColorMultiplier(EntityLivingBase entityLivingBase, float f, float f2) {
        return 0;
    }

    public void preRenderCallback(EntityLivingBase entityLivingBase, float f) {
    }

    public void passSpecialRender(EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        if (MinecraftForge.EVENT_BUS.post(new RenderLivingEvent.Specials.Pre(entityLivingBase, this))) {
            return;
        }
        if (this.func_110813_b(entityLivingBase)) {
            float f;
            float f2 = 1.6f;
            float f3 = 0.016666668f * f2;
            double d4 = entityLivingBase.getDistanceSqToEntity(this.renderManager._j);
            float f4 = f = entityLivingBase.isSneaking() ? NAME_TAG_RANGE_SNEAK : NAME_TAG_RANGE;
            if (d4 < (double)(f * f)) {
                String string = entityLivingBase.getTranslatedEntityName();
                if (entityLivingBase.isSneaking()) {
                    FontRenderer fontRenderer = this.getFontRendererFromRenderManager();
                    GL11.glPushMatrix();
                    GL11.glTranslatef((float)d + 0.0f, (float)d2 + entityLivingBase.height + 0.5f, (float)d3);
                    GL11.glNormal3f(0.0f, 1.0f, 0.0f);
                    GL11.glRotatef(-this.renderManager._l, 0.0f, 1.0f, 0.0f);
                    GL11.glRotatef(this.renderManager._m, 1.0f, 0.0f, 0.0f);
                    GL11.glScalef(-f3, -f3, f3);
                    GL11.glDisable(2896);
                    GL11.glTranslatef(0.0f, 0.25f / f3, 0.0f);
                    GL11.glDepthMask(false);
                    GL11.glEnable(3042);
                    GL11.glBlendFunc(770, 771);
                    Tessellator tessellator = Tessellator.instance;
                    GL11.glDisable(3553);
                    tessellator.startDrawingQuads();
                    int n = fontRenderer._b(string) / 2;
                    tessellator.setColorRGBA_F(0.0f, 0.0f, 0.0f, 0.25f);
                    tessellator.addVertex(-n - 1, -1.0, 0.0);
                    tessellator.addVertex(-n - 1, 8.0, 0.0);
                    tessellator.addVertex(n + 1, 8.0, 0.0);
                    tessellator.addVertex(n + 1, -1.0, 0.0);
                    tessellator.draw();
                    GL11.glEnable(3553);
                    GL11.glDepthMask(true);
                    fontRenderer._b(string, -fontRenderer._b(string) / 2, 0, 0x20FFFFFF);
                    GL11.glEnable(2896);
                    GL11.glDisable(3042);
                    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                    GL11.glPopMatrix();
                } else {
                    this.func_96449_a(entityLivingBase, d, d2, d3, string, f3, d4);
                }
            }
        }
        MinecraftForge.EVENT_BUS.post(new RenderLivingEvent.Specials.Post(entityLivingBase, this));
    }

    public boolean func_110813_b(EntityLivingBase entityLivingBase) {
        return Minecraft._A() && entityLivingBase != this.renderManager._j && !entityLivingBase.isInvisibleToPlayer(Minecraft._E()._t) && entityLivingBase.riddenByEntity == null;
    }

    public void func_96449_a(EntityLivingBase entityLivingBase, double d, double d2, double d3, String string, float f, double d4) {
        if (entityLivingBase.isPlayerSleeping()) {
            this.renderLivingLabel(entityLivingBase, string, d, d2 - 1.5, d3, 64);
        } else {
            this.renderLivingLabel(entityLivingBase, string, d, d2, d3, 64);
        }
    }

    public void renderLivingLabel(EntityLivingBase entityLivingBase, String string, double d, double d2, double d3, int n) {
        double d4 = entityLivingBase.getDistanceSqToEntity(this.renderManager._j);
        if (d4 <= (double)(n * n)) {
            FontRenderer fontRenderer = this.getFontRendererFromRenderManager();
            float f = 1.6f;
            float f2 = 0.016666668f * f;
            GL11.glPushMatrix();
            GL11.glTranslatef((float)d + 0.0f, (float)d2 + entityLivingBase.height + 0.5f, (float)d3);
            GL11.glNormal3f(0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-this.renderManager._l, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(this.renderManager._m, 1.0f, 0.0f, 0.0f);
            GL11.glScalef(-f2, -f2, f2);
            GL11.glDisable(2896);
            GL11.glDepthMask(false);
            GL11.glDisable(2929);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            Tessellator tessellator = Tessellator.instance;
            int n2 = 0;
            if (string.equals("deadmau5")) {
                n2 = -10;
            }
            GL11.glDisable(3553);
            tessellator.startDrawingQuads();
            int n3 = fontRenderer._b(string) / 2;
            tessellator.setColorRGBA_F(0.0f, 0.0f, 0.0f, 0.25f);
            tessellator.addVertex(-n3 - 1, -1 + n2, 0.0);
            tessellator.addVertex(-n3 - 1, 8 + n2, 0.0);
            tessellator.addVertex(n3 + 1, 8 + n2, 0.0);
            tessellator.addVertex(n3 + 1, -1 + n2, 0.0);
            tessellator.draw();
            GL11.glEnable(3553);
            fontRenderer._b(string, -fontRenderer._b(string) / 2, n2, 0x20FFFFFF);
            GL11.glEnable(2929);
            GL11.glDepthMask(true);
            fontRenderer._b(string, -fontRenderer._b(string) / 2, n2, -1);
            GL11.glEnable(2896);
            GL11.glDisable(3042);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glPopMatrix();
        }
    }

    @Override
    public void doRender(Entity entity, double d, double d2, double d3, float f, float f2) {
        this.doRenderLiving((EntityLivingBase)entity, d, d2, d3, f, f2);
    }
}

