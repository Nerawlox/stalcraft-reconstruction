/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model.part;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import noppes.npcs.EntityCustomNpc;
import noppes.npcs.ModelPartData;
import noppes.npcs.client.model.ModelMPM;
import noppes.npcs.client.model.part.legs.ModelDigitigradeLegs;
import noppes.npcs.client.model.part.legs.ModelMermaidLegs;
import noppes.npcs.client.model.part.legs.ModelNagaLegs;
import noppes.npcs.client.model.util.ModelScaleRenderer;
import noppes.npcs.constants.EnumAnimation;
import org.lwjgl.opengl.GL11;

public class ModelLegs
extends ModelScaleRenderer {
    private EntityCustomNpc entity;
    private ModelScaleRenderer leg1;
    private ModelScaleRenderer leg2;
    private ModelRenderer spider;
    private ModelRenderer horse;
    private ModelNagaLegs naga;
    private ModelDigitigradeLegs digitigrade;
    private ModelMermaidLegs mermaid;
    private ModelRenderer spiderLeg1;
    private ModelRenderer spiderLeg2;
    private ModelRenderer spiderLeg3;
    private ModelRenderer spiderLeg4;
    private ModelRenderer spiderLeg5;
    private ModelRenderer spiderLeg6;
    private ModelRenderer spiderLeg7;
    private ModelRenderer spiderLeg8;
    private ModelRenderer spiderBody;
    private ModelRenderer spiderNeck;
    private ModelRenderer backLeftLeg;
    private ModelRenderer backLeftShin;
    private ModelRenderer backLeftHoof;
    private ModelRenderer backRightLeg;
    private ModelRenderer backRightShin;
    private ModelRenderer backRightHoof;
    private ModelRenderer frontLeftLeg;
    private ModelRenderer frontLeftShin;
    private ModelRenderer frontLeftHoof;
    private ModelRenderer frontRightLeg;
    private ModelRenderer frontRightShin;
    private ModelRenderer frontRightHoof;
    private ModelMPM base;

    public ModelLegs(ModelMPM modelMPM, ModelScaleRenderer modelScaleRenderer, ModelScaleRenderer modelScaleRenderer2) {
        super(modelMPM);
        this.base = modelMPM;
        this.leg1 = modelScaleRenderer;
        this.leg2 = modelScaleRenderer2;
        if (!modelMPM.isArmor) {
            this.spider = new ModelRenderer(modelMPM);
            this.func_78792_a(this.spider);
            float f = 0.0f;
            int n = 15;
            this.spiderNeck = new ModelRenderer(modelMPM, 0, 0);
            this.spiderNeck.func_78790_a(-3.0f, -3.0f, -3.0f, 6, 6, 6, f);
            this.spiderNeck.func_78793_a(0.0f, n, 2.0f);
            this.spider.func_78792_a(this.spiderNeck);
            this.spiderBody = new ModelRenderer(modelMPM, 0, 12);
            this.spiderBody.func_78790_a(-5.0f, -4.0f, -6.0f, 10, 8, 12, f);
            this.spiderBody.func_78793_a(0.0f, n, 11.0f);
            this.spider.func_78792_a(this.spiderBody);
            this.spiderLeg1 = new ModelRenderer(modelMPM, 18, 0);
            this.spiderLeg1.func_78790_a(-15.0f, -1.0f, -1.0f, 16, 2, 2, f);
            this.spiderLeg1.func_78793_a(-4.0f, n, 4.0f);
            this.spider.func_78792_a(this.spiderLeg1);
            this.spiderLeg2 = new ModelRenderer(modelMPM, 18, 0);
            this.spiderLeg2.func_78790_a(-1.0f, -1.0f, -1.0f, 16, 2, 2, f);
            this.spiderLeg2.func_78793_a(4.0f, n, 4.0f);
            this.spider.func_78792_a(this.spiderLeg2);
            this.spiderLeg3 = new ModelRenderer(modelMPM, 18, 0);
            this.spiderLeg3.func_78790_a(-15.0f, -1.0f, -1.0f, 16, 2, 2, f);
            this.spiderLeg3.func_78793_a(-4.0f, n, 3.0f);
            this.spider.func_78792_a(this.spiderLeg3);
            this.spiderLeg4 = new ModelRenderer(modelMPM, 18, 0);
            this.spiderLeg4.func_78790_a(-1.0f, -1.0f, -1.0f, 16, 2, 2, f);
            this.spiderLeg4.func_78793_a(4.0f, n, 3.0f);
            this.spider.func_78792_a(this.spiderLeg4);
            this.spiderLeg5 = new ModelRenderer(modelMPM, 18, 0);
            this.spiderLeg5.func_78790_a(-15.0f, -1.0f, -1.0f, 16, 2, 2, f);
            this.spiderLeg5.func_78793_a(-4.0f, n, 2.0f);
            this.spider.func_78792_a(this.spiderLeg5);
            this.spiderLeg6 = new ModelRenderer(modelMPM, 18, 0);
            this.spiderLeg6.func_78790_a(-1.0f, -1.0f, -1.0f, 16, 2, 2, f);
            this.spiderLeg6.func_78793_a(4.0f, n, 2.0f);
            this.spider.func_78792_a(this.spiderLeg6);
            this.spiderLeg7 = new ModelRenderer(modelMPM, 18, 0);
            this.spiderLeg7.func_78790_a(-15.0f, -1.0f, -1.0f, 16, 2, 2, f);
            this.spiderLeg7.func_78793_a(-4.0f, n, 1.0f);
            this.spider.func_78792_a(this.spiderLeg7);
            this.spiderLeg8 = new ModelRenderer(modelMPM, 18, 0);
            this.spiderLeg8.func_78790_a(-1.0f, -1.0f, -1.0f, 16, 2, 2, f);
            this.spiderLeg8.func_78793_a(4.0f, n, 1.0f);
            this.spider.func_78792_a(this.spiderLeg8);
            int n2 = 10;
            float f2 = 7.0f;
            this.horse = new ModelRenderer(modelMPM);
            this.func_78792_a(this.horse);
            ModelRenderer modelRenderer = new ModelRenderer(modelMPM, 0, 34);
            modelRenderer.func_78787_b(128, 128);
            modelRenderer.func_78789_a(-5.0f, -8.0f, -19.0f, 10, 10, 24);
            modelRenderer.func_78793_a(0.0f, 11.0f + f2, 9.0f + (float)n2);
            this.horse.func_78792_a(modelRenderer);
            this.backLeftLeg = new ModelRenderer(modelMPM, 78, 29);
            this.backLeftLeg.func_78787_b(128, 128);
            this.backLeftLeg.func_78789_a(-2.5f, -2.0f, -2.5f, 4, 9, 5);
            this.backLeftLeg.func_78793_a(4.0f, 9.0f + f2, 11.0f + (float)n2);
            this.horse.func_78792_a(this.backLeftLeg);
            this.backLeftShin = new ModelRenderer(modelMPM, 78, 43);
            this.backLeftShin.func_78787_b(128, 128);
            this.backLeftShin.func_78789_a(-2.0f, 0.0f, -1.5f, 3, 5, 3);
            this.backLeftShin.func_78793_a(0.0f, 7.0f, 0.0f);
            this.backLeftLeg.func_78792_a(this.backLeftShin);
            this.backLeftHoof = new ModelRenderer(modelMPM, 78, 51);
            this.backLeftHoof.func_78787_b(128, 128);
            this.backLeftHoof.func_78789_a(-2.5f, 5.1f, -2.0f, 4, 3, 4);
            this.backLeftHoof.func_78793_a(0.0f, 7.0f, 0.0f);
            this.backLeftLeg.func_78792_a(this.backLeftHoof);
            this.backRightLeg = new ModelRenderer(modelMPM, 96, 29);
            this.backRightLeg.func_78787_b(128, 128);
            this.backRightLeg.func_78789_a(-1.5f, -2.0f, -2.5f, 4, 9, 5);
            this.backRightLeg.func_78793_a(-4.0f, 9.0f + f2, 11.0f + (float)n2);
            this.horse.func_78792_a(this.backRightLeg);
            this.backRightShin = new ModelRenderer(modelMPM, 96, 43);
            this.backRightShin.func_78787_b(128, 128);
            this.backRightShin.func_78789_a(-1.0f, 0.0f, -1.5f, 3, 5, 3);
            this.backRightShin.func_78793_a(0.0f, 7.0f, 0.0f);
            this.backRightLeg.func_78792_a(this.backRightShin);
            this.backRightHoof = new ModelRenderer(modelMPM, 96, 51);
            this.backRightHoof.func_78787_b(128, 128);
            this.backRightHoof.func_78789_a(-1.5f, 5.1f, -2.0f, 4, 3, 4);
            this.backRightHoof.func_78793_a(0.0f, 7.0f, 0.0f);
            this.backRightLeg.func_78792_a(this.backRightHoof);
            this.frontLeftLeg = new ModelRenderer(modelMPM, 44, 29);
            this.frontLeftLeg.func_78787_b(128, 128);
            this.frontLeftLeg.func_78789_a(-1.9f, -1.0f, -2.1f, 3, 8, 4);
            this.frontLeftLeg.func_78793_a(4.0f, 9.0f + f2, -8.0f + (float)n2);
            this.horse.func_78792_a(this.frontLeftLeg);
            this.frontLeftShin = new ModelRenderer(modelMPM, 44, 41);
            this.frontLeftShin.func_78787_b(128, 128);
            this.frontLeftShin.func_78789_a(-1.9f, 0.0f, -1.6f, 3, 5, 3);
            this.frontLeftShin.func_78793_a(0.0f, 7.0f, 0.0f);
            this.frontLeftLeg.func_78792_a(this.frontLeftShin);
            this.frontLeftHoof = new ModelRenderer(modelMPM, 44, 51);
            this.frontLeftHoof.func_78787_b(128, 128);
            this.frontLeftHoof.func_78789_a(-2.4f, 5.1f, -2.1f, 4, 3, 4);
            this.frontLeftHoof.func_78793_a(0.0f, 7.0f, 0.0f);
            this.frontLeftLeg.func_78792_a(this.frontLeftHoof);
            this.frontRightLeg = new ModelRenderer(modelMPM, 60, 29);
            this.frontRightLeg.func_78787_b(128, 128);
            this.frontRightLeg.func_78789_a(-1.1f, -1.0f, -2.1f, 3, 8, 4);
            this.frontRightLeg.func_78793_a(-4.0f, 9.0f + f2, -8.0f + (float)n2);
            this.horse.func_78792_a(this.frontRightLeg);
            this.frontRightShin = new ModelRenderer(modelMPM, 60, 41);
            this.frontRightShin.func_78787_b(128, 128);
            this.frontRightShin.func_78789_a(-1.1f, 0.0f, -1.6f, 3, 5, 3);
            this.frontRightShin.func_78793_a(0.0f, 7.0f, 0.0f);
            this.frontRightLeg.func_78792_a(this.frontRightShin);
            this.frontRightHoof = new ModelRenderer(modelMPM, 60, 51);
            this.frontRightHoof.func_78787_b(128, 128);
            this.frontRightHoof.func_78789_a(-1.6f, 5.1f, -2.1f, 4, 3, 4);
            this.frontRightHoof.func_78793_a(0.0f, 7.0f, 0.0f);
            this.frontRightLeg.func_78792_a(this.frontRightHoof);
            this.naga = new ModelNagaLegs(modelMPM);
            this.func_78792_a(this.naga);
            this.mermaid = new ModelMermaidLegs(modelMPM);
            this.func_78792_a(this.mermaid);
            this.digitigrade = new ModelDigitigradeLegs(modelMPM);
            this.func_78792_a(this.digitigrade);
        }
    }

    @Override
    public void setRotation(ModelRenderer modelRenderer, float f, float f2, float f3) {
        modelRenderer.field_78795_f = f;
        modelRenderer.field_78796_g = f2;
        modelRenderer.field_78808_h = f3;
    }

    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        ModelPartData modelPartData = this.entity.legParts;
        this.field_78798_e = 0.0f;
        this.field_78797_d = 0.0f;
        if (!this.base.isArmor) {
            if (modelPartData.type == 2) {
                this.field_78795_f = 0.0f;
                this.spiderBody.field_78797_d = 15.0f;
                this.spiderBody.field_78798_e = 11.0f;
                this.spiderNeck.field_78795_f = 0.0f;
                float f7 = 0.7853982f;
                this.spiderLeg1.field_78808_h = -f7;
                this.spiderLeg2.field_78808_h = f7;
                this.spiderLeg3.field_78808_h = -f7 * 0.74f;
                this.spiderLeg4.field_78808_h = f7 * 0.74f;
                this.spiderLeg5.field_78808_h = -f7 * 0.74f;
                this.spiderLeg6.field_78808_h = f7 * 0.74f;
                this.spiderLeg7.field_78808_h = -f7;
                this.spiderLeg8.field_78808_h = f7;
                float f8 = -0.0f;
                float f9 = 0.3926991f;
                this.spiderLeg1.field_78796_g = f9 * 2.0f + f8;
                this.spiderLeg2.field_78796_g = -f9 * 2.0f - f8;
                this.spiderLeg3.field_78796_g = f9 * 1.0f + f8;
                this.spiderLeg4.field_78796_g = -f9 * 1.0f - f8;
                this.spiderLeg5.field_78796_g = -f9 * 1.0f + f8;
                this.spiderLeg6.field_78796_g = f9 * 1.0f - f8;
                this.spiderLeg7.field_78796_g = -f9 * 2.0f + f8;
                this.spiderLeg8.field_78796_g = f9 * 2.0f - f8;
                float f10 = -(sajh._b(f * 0.6662f * 2.0f + 0.0f) * 0.4f) * f2;
                float f11 = -(sajh._b(f * 0.6662f * 2.0f + (float)Math.PI) * 0.4f) * f2;
                float f12 = -(sajh._b(f * 0.6662f * 2.0f + 1.5707964f) * 0.4f) * f2;
                float f13 = -(sajh._b(f * 0.6662f * 2.0f + 4.712389f) * 0.4f) * f2;
                float f14 = Math.abs(sajh._a(f * 0.6662f + 0.0f) * 0.4f) * f2;
                float f15 = Math.abs(sajh._a(f * 0.6662f + (float)Math.PI) * 0.4f) * f2;
                float f16 = Math.abs(sajh._a(f * 0.6662f + 1.5707964f) * 0.4f) * f2;
                float f17 = Math.abs(sajh._a(f * 0.6662f + 4.712389f) * 0.4f) * f2;
                this.spiderLeg1.field_78796_g += f10;
                this.spiderLeg2.field_78796_g += -f10;
                this.spiderLeg3.field_78796_g += f11;
                this.spiderLeg4.field_78796_g += -f11;
                this.spiderLeg5.field_78796_g += f12;
                this.spiderLeg6.field_78796_g += -f12;
                this.spiderLeg7.field_78796_g += f13;
                this.spiderLeg8.field_78796_g += -f13;
                this.spiderLeg1.field_78808_h += f14;
                this.spiderLeg2.field_78808_h += -f14;
                this.spiderLeg3.field_78808_h += f15;
                this.spiderLeg4.field_78808_h += -f15;
                this.spiderLeg5.field_78808_h += f16;
                this.spiderLeg6.field_78808_h += -f16;
                this.spiderLeg7.field_78808_h += f17;
                this.spiderLeg8.field_78808_h += -f17;
                if (this.base.isSneak) {
                    this.field_78798_e = 5.0f;
                    this.field_78797_d = -1.0f;
                    this.spiderBody.field_78797_d = 16.0f;
                    this.spiderBody.field_78798_e = 10.0f;
                    this.spiderNeck.field_78795_f = -0.3926991f;
                }
                if (this.base.isSleeping(entity) || this.entity.currentAnimation == EnumAnimation.CRAWLING) {
                    this.field_78797_d = 12.0f * this.entity.legs.scaleY;
                    this.field_78798_e = 15.0f * this.entity.legs.scaleY;
                    this.field_78795_f = -1.5707964f;
                }
            } else if (modelPartData.type == 3) {
                this.frontLeftLeg.field_78795_f = sajh._b(f * 0.6662f) * 0.4f * f2;
                this.frontRightLeg.field_78795_f = sajh._b(f * 0.6662f + (float)Math.PI) * 0.4f * f2;
                this.backLeftLeg.field_78795_f = sajh._b(f * 0.6662f + (float)Math.PI) * 0.4f * f2;
                this.backRightLeg.field_78795_f = sajh._b(f * 0.6662f) * 0.4f * f2;
            } else if (modelPartData.type == 1) {
                this.naga.isRiding = this.base.field_78093_q;
                this.naga.isSleeping = this.base.isSleeping(entity);
                this.naga.isCrawling = this.entity.currentAnimation == EnumAnimation.CRAWLING;
                this.naga.isSneaking = this.base.isSneak;
                this.naga.setRotationAngles(f, f2, f3, f4, f5, f6, entity);
            } else if (modelPartData.type == 4) {
                this.mermaid.setRotationAngles(f, f2, f3, f4, f5, f6, entity);
            } else if (modelPartData.type == 5) {
                this.digitigrade.setRotationAngles(f, f2, f3, f4, f5, f6, entity);
            }
        }
    }

    @Override
    public void func_78785_a(float f) {
        if (this.field_78806_j && !this.field_78807_k) {
            ModelPartData modelPartData = this.entity.legParts;
            if (modelPartData.type >= 0) {
                boolean bl;
                GL11.glPushMatrix();
                if (modelPartData.type == 4) {
                    boolean bl2 = modelPartData.playerTexture = !this.entity.func_70090_H();
                }
                if (!this.base.isArmor) {
                    Object object;
                    if (!modelPartData.playerTexture) {
                        object = (ResourceLocation)modelPartData.getResource();
                        apbu apbu2 = xpzm._E()._R();
                        apbu2._a((ResourceLocation)object);
                        this.base.currentlyPlayerTexture = false;
                    } else if (!this.base.currentlyPlayerTexture) {
                        object = xpzm._E()._R();
                        ((apbu)object)._a((ResourceLocation)this.entity.textureLocation);
                        this.base.currentlyPlayerTexture = true;
                    }
                }
                if (modelPartData.type == 0 || modelPartData.type == 4 && !this.entity.func_70090_H()) {
                    this.leg1.setConfig(this.config, this.x, this.y, this.z);
                    this.leg1.func_78785_a(f);
                    this.leg2.setConfig(this.config, -this.x, this.y, this.z);
                    this.leg2.func_78785_a(f);
                }
                if (!this.base.isArmor) {
                    this.naga.field_78807_k = modelPartData.type != 1;
                    this.spider.field_78807_k = modelPartData.type != 2;
                    this.horse.field_78807_k = modelPartData.type != 3;
                    this.mermaid.field_78807_k = modelPartData.type != 4 || !this.entity.func_70090_H();
                    boolean bl3 = this.digitigrade.field_78807_k = modelPartData.type != 5;
                    if (!this.horse.field_78807_k) {
                        this.x = 0.0f;
                        this.y *= 1.8f;
                        GL11.glScalef(0.9f, 0.9f, 0.9f);
                    } else if (!this.spider.field_78807_k) {
                        this.x = 0.0f;
                        this.y *= 2.0f;
                    } else if (!this.naga.field_78807_k) {
                        this.x = 0.0f;
                        this.y *= 2.0f;
                    } else if (!this.mermaid.field_78807_k || !this.digitigrade.field_78807_k) {
                        this.x = 0.0f;
                        this.y *= 2.0f;
                    }
                }
                boolean bl4 = bl = this.entity.field_70737_aN <= 0 && this.entity.deathTime <= 0L && !this.base.isArmor;
                if (bl) {
                    float f2 = (float)(this.entity.legParts.color >> 16 & 0xFF) / 255.0f;
                    float f3 = (float)(this.entity.legParts.color >> 8 & 0xFF) / 255.0f;
                    float f4 = (float)(this.entity.legParts.color & 0xFF) / 255.0f;
                    GL11.glColor3f(f2, f3, f4);
                }
                super.func_78785_a(f);
                if (bl) {
                    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                }
                GL11.glPopMatrix();
            }
        }
    }

    public void setData(EntityCustomNpc entityCustomNpc) {
        this.entity = entityCustomNpc;
    }
}

