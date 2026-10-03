/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model.part;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
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
            this.addChild(this.spider);
            float f = 0.0f;
            int n = 15;
            this.spiderNeck = new ModelRenderer(modelMPM, 0, 0);
            this.spiderNeck.addBox(-3.0f, -3.0f, -3.0f, 6, 6, 6, f);
            this.spiderNeck.setRotationPoint(0.0f, n, 2.0f);
            this.spider.addChild(this.spiderNeck);
            this.spiderBody = new ModelRenderer(modelMPM, 0, 12);
            this.spiderBody.addBox(-5.0f, -4.0f, -6.0f, 10, 8, 12, f);
            this.spiderBody.setRotationPoint(0.0f, n, 11.0f);
            this.spider.addChild(this.spiderBody);
            this.spiderLeg1 = new ModelRenderer(modelMPM, 18, 0);
            this.spiderLeg1.addBox(-15.0f, -1.0f, -1.0f, 16, 2, 2, f);
            this.spiderLeg1.setRotationPoint(-4.0f, n, 4.0f);
            this.spider.addChild(this.spiderLeg1);
            this.spiderLeg2 = new ModelRenderer(modelMPM, 18, 0);
            this.spiderLeg2.addBox(-1.0f, -1.0f, -1.0f, 16, 2, 2, f);
            this.spiderLeg2.setRotationPoint(4.0f, n, 4.0f);
            this.spider.addChild(this.spiderLeg2);
            this.spiderLeg3 = new ModelRenderer(modelMPM, 18, 0);
            this.spiderLeg3.addBox(-15.0f, -1.0f, -1.0f, 16, 2, 2, f);
            this.spiderLeg3.setRotationPoint(-4.0f, n, 3.0f);
            this.spider.addChild(this.spiderLeg3);
            this.spiderLeg4 = new ModelRenderer(modelMPM, 18, 0);
            this.spiderLeg4.addBox(-1.0f, -1.0f, -1.0f, 16, 2, 2, f);
            this.spiderLeg4.setRotationPoint(4.0f, n, 3.0f);
            this.spider.addChild(this.spiderLeg4);
            this.spiderLeg5 = new ModelRenderer(modelMPM, 18, 0);
            this.spiderLeg5.addBox(-15.0f, -1.0f, -1.0f, 16, 2, 2, f);
            this.spiderLeg5.setRotationPoint(-4.0f, n, 2.0f);
            this.spider.addChild(this.spiderLeg5);
            this.spiderLeg6 = new ModelRenderer(modelMPM, 18, 0);
            this.spiderLeg6.addBox(-1.0f, -1.0f, -1.0f, 16, 2, 2, f);
            this.spiderLeg6.setRotationPoint(4.0f, n, 2.0f);
            this.spider.addChild(this.spiderLeg6);
            this.spiderLeg7 = new ModelRenderer(modelMPM, 18, 0);
            this.spiderLeg7.addBox(-15.0f, -1.0f, -1.0f, 16, 2, 2, f);
            this.spiderLeg7.setRotationPoint(-4.0f, n, 1.0f);
            this.spider.addChild(this.spiderLeg7);
            this.spiderLeg8 = new ModelRenderer(modelMPM, 18, 0);
            this.spiderLeg8.addBox(-1.0f, -1.0f, -1.0f, 16, 2, 2, f);
            this.spiderLeg8.setRotationPoint(4.0f, n, 1.0f);
            this.spider.addChild(this.spiderLeg8);
            int n2 = 10;
            float f2 = 7.0f;
            this.horse = new ModelRenderer(modelMPM);
            this.addChild(this.horse);
            ModelRenderer modelRenderer = new ModelRenderer(modelMPM, 0, 34);
            modelRenderer.setTextureSize(128, 128);
            modelRenderer.addBox(-5.0f, -8.0f, -19.0f, 10, 10, 24);
            modelRenderer.setRotationPoint(0.0f, 11.0f + f2, 9.0f + (float)n2);
            this.horse.addChild(modelRenderer);
            this.backLeftLeg = new ModelRenderer(modelMPM, 78, 29);
            this.backLeftLeg.setTextureSize(128, 128);
            this.backLeftLeg.addBox(-2.5f, -2.0f, -2.5f, 4, 9, 5);
            this.backLeftLeg.setRotationPoint(4.0f, 9.0f + f2, 11.0f + (float)n2);
            this.horse.addChild(this.backLeftLeg);
            this.backLeftShin = new ModelRenderer(modelMPM, 78, 43);
            this.backLeftShin.setTextureSize(128, 128);
            this.backLeftShin.addBox(-2.0f, 0.0f, -1.5f, 3, 5, 3);
            this.backLeftShin.setRotationPoint(0.0f, 7.0f, 0.0f);
            this.backLeftLeg.addChild(this.backLeftShin);
            this.backLeftHoof = new ModelRenderer(modelMPM, 78, 51);
            this.backLeftHoof.setTextureSize(128, 128);
            this.backLeftHoof.addBox(-2.5f, 5.1f, -2.0f, 4, 3, 4);
            this.backLeftHoof.setRotationPoint(0.0f, 7.0f, 0.0f);
            this.backLeftLeg.addChild(this.backLeftHoof);
            this.backRightLeg = new ModelRenderer(modelMPM, 96, 29);
            this.backRightLeg.setTextureSize(128, 128);
            this.backRightLeg.addBox(-1.5f, -2.0f, -2.5f, 4, 9, 5);
            this.backRightLeg.setRotationPoint(-4.0f, 9.0f + f2, 11.0f + (float)n2);
            this.horse.addChild(this.backRightLeg);
            this.backRightShin = new ModelRenderer(modelMPM, 96, 43);
            this.backRightShin.setTextureSize(128, 128);
            this.backRightShin.addBox(-1.0f, 0.0f, -1.5f, 3, 5, 3);
            this.backRightShin.setRotationPoint(0.0f, 7.0f, 0.0f);
            this.backRightLeg.addChild(this.backRightShin);
            this.backRightHoof = new ModelRenderer(modelMPM, 96, 51);
            this.backRightHoof.setTextureSize(128, 128);
            this.backRightHoof.addBox(-1.5f, 5.1f, -2.0f, 4, 3, 4);
            this.backRightHoof.setRotationPoint(0.0f, 7.0f, 0.0f);
            this.backRightLeg.addChild(this.backRightHoof);
            this.frontLeftLeg = new ModelRenderer(modelMPM, 44, 29);
            this.frontLeftLeg.setTextureSize(128, 128);
            this.frontLeftLeg.addBox(-1.9f, -1.0f, -2.1f, 3, 8, 4);
            this.frontLeftLeg.setRotationPoint(4.0f, 9.0f + f2, -8.0f + (float)n2);
            this.horse.addChild(this.frontLeftLeg);
            this.frontLeftShin = new ModelRenderer(modelMPM, 44, 41);
            this.frontLeftShin.setTextureSize(128, 128);
            this.frontLeftShin.addBox(-1.9f, 0.0f, -1.6f, 3, 5, 3);
            this.frontLeftShin.setRotationPoint(0.0f, 7.0f, 0.0f);
            this.frontLeftLeg.addChild(this.frontLeftShin);
            this.frontLeftHoof = new ModelRenderer(modelMPM, 44, 51);
            this.frontLeftHoof.setTextureSize(128, 128);
            this.frontLeftHoof.addBox(-2.4f, 5.1f, -2.1f, 4, 3, 4);
            this.frontLeftHoof.setRotationPoint(0.0f, 7.0f, 0.0f);
            this.frontLeftLeg.addChild(this.frontLeftHoof);
            this.frontRightLeg = new ModelRenderer(modelMPM, 60, 29);
            this.frontRightLeg.setTextureSize(128, 128);
            this.frontRightLeg.addBox(-1.1f, -1.0f, -2.1f, 3, 8, 4);
            this.frontRightLeg.setRotationPoint(-4.0f, 9.0f + f2, -8.0f + (float)n2);
            this.horse.addChild(this.frontRightLeg);
            this.frontRightShin = new ModelRenderer(modelMPM, 60, 41);
            this.frontRightShin.setTextureSize(128, 128);
            this.frontRightShin.addBox(-1.1f, 0.0f, -1.6f, 3, 5, 3);
            this.frontRightShin.setRotationPoint(0.0f, 7.0f, 0.0f);
            this.frontRightLeg.addChild(this.frontRightShin);
            this.frontRightHoof = new ModelRenderer(modelMPM, 60, 51);
            this.frontRightHoof.setTextureSize(128, 128);
            this.frontRightHoof.addBox(-1.6f, 5.1f, -2.1f, 4, 3, 4);
            this.frontRightHoof.setRotationPoint(0.0f, 7.0f, 0.0f);
            this.frontRightLeg.addChild(this.frontRightHoof);
            this.naga = new ModelNagaLegs(modelMPM);
            this.addChild(this.naga);
            this.mermaid = new ModelMermaidLegs(modelMPM);
            this.addChild(this.mermaid);
            this.digitigrade = new ModelDigitigradeLegs(modelMPM);
            this.addChild(this.digitigrade);
        }
    }

    @Override
    public void setRotation(ModelRenderer modelRenderer, float f, float f2, float f3) {
        modelRenderer.rotateAngleX = f;
        modelRenderer.rotateAngleY = f2;
        modelRenderer.rotateAngleZ = f3;
    }

    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        ModelPartData modelPartData = this.entity.legParts;
        this.rotationPointZ = 0.0f;
        this.rotationPointY = 0.0f;
        if (!this.base.isArmor) {
            if (modelPartData.type == 2) {
                this.rotateAngleX = 0.0f;
                this.spiderBody.rotationPointY = 15.0f;
                this.spiderBody.rotationPointZ = 11.0f;
                this.spiderNeck.rotateAngleX = 0.0f;
                float f7 = 0.7853982f;
                this.spiderLeg1.rotateAngleZ = -f7;
                this.spiderLeg2.rotateAngleZ = f7;
                this.spiderLeg3.rotateAngleZ = -f7 * 0.74f;
                this.spiderLeg4.rotateAngleZ = f7 * 0.74f;
                this.spiderLeg5.rotateAngleZ = -f7 * 0.74f;
                this.spiderLeg6.rotateAngleZ = f7 * 0.74f;
                this.spiderLeg7.rotateAngleZ = -f7;
                this.spiderLeg8.rotateAngleZ = f7;
                float f8 = -0.0f;
                float f9 = 0.3926991f;
                this.spiderLeg1.rotateAngleY = f9 * 2.0f + f8;
                this.spiderLeg2.rotateAngleY = -f9 * 2.0f - f8;
                this.spiderLeg3.rotateAngleY = f9 * 1.0f + f8;
                this.spiderLeg4.rotateAngleY = -f9 * 1.0f - f8;
                this.spiderLeg5.rotateAngleY = -f9 * 1.0f + f8;
                this.spiderLeg6.rotateAngleY = f9 * 1.0f - f8;
                this.spiderLeg7.rotateAngleY = -f9 * 2.0f + f8;
                this.spiderLeg8.rotateAngleY = f9 * 2.0f - f8;
                float f10 = -(sajh._b(f * 0.6662f * 2.0f + 0.0f) * 0.4f) * f2;
                float f11 = -(sajh._b(f * 0.6662f * 2.0f + (float)Math.PI) * 0.4f) * f2;
                float f12 = -(sajh._b(f * 0.6662f * 2.0f + 1.5707964f) * 0.4f) * f2;
                float f13 = -(sajh._b(f * 0.6662f * 2.0f + 4.712389f) * 0.4f) * f2;
                float f14 = Math.abs(sajh._a(f * 0.6662f + 0.0f) * 0.4f) * f2;
                float f15 = Math.abs(sajh._a(f * 0.6662f + (float)Math.PI) * 0.4f) * f2;
                float f16 = Math.abs(sajh._a(f * 0.6662f + 1.5707964f) * 0.4f) * f2;
                float f17 = Math.abs(sajh._a(f * 0.6662f + 4.712389f) * 0.4f) * f2;
                this.spiderLeg1.rotateAngleY += f10;
                this.spiderLeg2.rotateAngleY += -f10;
                this.spiderLeg3.rotateAngleY += f11;
                this.spiderLeg4.rotateAngleY += -f11;
                this.spiderLeg5.rotateAngleY += f12;
                this.spiderLeg6.rotateAngleY += -f12;
                this.spiderLeg7.rotateAngleY += f13;
                this.spiderLeg8.rotateAngleY += -f13;
                this.spiderLeg1.rotateAngleZ += f14;
                this.spiderLeg2.rotateAngleZ += -f14;
                this.spiderLeg3.rotateAngleZ += f15;
                this.spiderLeg4.rotateAngleZ += -f15;
                this.spiderLeg5.rotateAngleZ += f16;
                this.spiderLeg6.rotateAngleZ += -f16;
                this.spiderLeg7.rotateAngleZ += f17;
                this.spiderLeg8.rotateAngleZ += -f17;
                if (this.base.isSneak) {
                    this.rotationPointZ = 5.0f;
                    this.rotationPointY = -1.0f;
                    this.spiderBody.rotationPointY = 16.0f;
                    this.spiderBody.rotationPointZ = 10.0f;
                    this.spiderNeck.rotateAngleX = -0.3926991f;
                }
                if (this.base.isSleeping(entity) || this.entity.currentAnimation == EnumAnimation.CRAWLING) {
                    this.rotationPointY = 12.0f * this.entity.legs.scaleY;
                    this.rotationPointZ = 15.0f * this.entity.legs.scaleY;
                    this.rotateAngleX = -1.5707964f;
                }
            } else if (modelPartData.type == 3) {
                this.frontLeftLeg.rotateAngleX = sajh._b(f * 0.6662f) * 0.4f * f2;
                this.frontRightLeg.rotateAngleX = sajh._b(f * 0.6662f + (float)Math.PI) * 0.4f * f2;
                this.backLeftLeg.rotateAngleX = sajh._b(f * 0.6662f + (float)Math.PI) * 0.4f * f2;
                this.backRightLeg.rotateAngleX = sajh._b(f * 0.6662f) * 0.4f * f2;
            } else if (modelPartData.type == 1) {
                this.naga.isRiding = this.base.isRiding;
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
    public void render(float f) {
        if (this.showModel && !this.isHidden) {
            ModelPartData modelPartData = this.entity.legParts;
            if (modelPartData.type >= 0) {
                boolean bl;
                GL11.glPushMatrix();
                if (modelPartData.type == 4) {
                    boolean bl2 = modelPartData.playerTexture = !this.entity.isInWater();
                }
                if (!this.base.isArmor) {
                    Object object;
                    if (!modelPartData.playerTexture) {
                        object = (ResourceLocation)modelPartData.getResource();
                        TextureManager textureManager = Minecraft._E()._R();
                        textureManager._a((ResourceLocation)object);
                        this.base.currentlyPlayerTexture = false;
                    } else if (!this.base.currentlyPlayerTexture) {
                        object = Minecraft._E()._R();
                        ((TextureManager)object)._a((ResourceLocation)this.entity.textureLocation);
                        this.base.currentlyPlayerTexture = true;
                    }
                }
                if (modelPartData.type == 0 || modelPartData.type == 4 && !this.entity.isInWater()) {
                    this.leg1.setConfig(this.config, this.x, this.y, this.z);
                    this.leg1.render(f);
                    this.leg2.setConfig(this.config, -this.x, this.y, this.z);
                    this.leg2.render(f);
                }
                if (!this.base.isArmor) {
                    this.naga.isHidden = modelPartData.type != 1;
                    this.spider.isHidden = modelPartData.type != 2;
                    this.horse.isHidden = modelPartData.type != 3;
                    this.mermaid.isHidden = modelPartData.type != 4 || !this.entity.isInWater();
                    boolean bl3 = this.digitigrade.isHidden = modelPartData.type != 5;
                    if (!this.horse.isHidden) {
                        this.x = 0.0f;
                        this.y *= 1.8f;
                        GL11.glScalef(0.9f, 0.9f, 0.9f);
                    } else if (!this.spider.isHidden) {
                        this.x = 0.0f;
                        this.y *= 2.0f;
                    } else if (!this.naga.isHidden) {
                        this.x = 0.0f;
                        this.y *= 2.0f;
                    } else if (!this.mermaid.isHidden || !this.digitigrade.isHidden) {
                        this.x = 0.0f;
                        this.y *= 2.0f;
                    }
                }
                boolean bl4 = bl = this.entity.hurtTime <= 0 && this.entity.deathTime <= 0L && !this.base.isArmor;
                if (bl) {
                    float f2 = (float)(this.entity.legParts.color >> 16 & 0xFF) / 255.0f;
                    float f3 = (float)(this.entity.legParts.color >> 8 & 0xFF) / 255.0f;
                    float f4 = (float)(this.entity.legParts.color & 0xFF) / 255.0f;
                    GL11.glColor3f(f2, f3, f4);
                }
                super.render(f);
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

