/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.sajh;
import noppes.npcs.client.model.ModelNPCFemale;
import noppes.npcs.client.model.util.ModelPlaneRenderer;
import org.lwjgl.opengl.GL11;

public class ModelNagaFemale
extends ModelNPCFemale {
    ModelRenderer leg;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer leg5;

    public ModelNagaFemale(int n, int n2, float f) {
        super(n, n2, f);
    }

    @Override
    public void init(float f, float f2) {
        super.init(f, f2);
        this.bipedRightLeg = new ModelRenderer(this, 0, 0);
        this.bipedLeftLeg = new ModelRenderer(this, 0, 0);
        this.leg = new ModelRenderer(this, 0, 0);
        ModelRenderer modelRenderer = new ModelRenderer(this, 0, 16);
        modelRenderer.addBox(0.0f, -2.0f, -2.0f, 4, 4, 4);
        modelRenderer.setRotationPoint(-4.0f, 0.0f, 0.0f);
        this.leg.addChild(modelRenderer);
        modelRenderer = new ModelRenderer(this, 0, 16);
        modelRenderer.mirror = true;
        modelRenderer.addBox(0.0f, -2.0f, -2.0f, 4, 4, 4);
        this.leg.addChild(modelRenderer);
        this.leg2 = new ModelRenderer(this, 0, 0);
        this.leg2.childModels = this.leg.childModels;
        this.leg3 = new ModelRenderer(this, 0, 0);
        ModelPlaneRenderer modelPlaneRenderer = new ModelPlaneRenderer(this, 4, 24);
        modelPlaneRenderer.setTextureSize(this.textureWidth, this.textureHeight);
        modelPlaneRenderer.addBackPlane(0.0f, -2.0f, 0.0f, 4, 4);
        modelPlaneRenderer.setRotationPoint(-4.0f, 0.0f, 0.0f);
        this.leg3.addChild(modelPlaneRenderer);
        modelPlaneRenderer = new ModelPlaneRenderer(this, 4, 24);
        modelPlaneRenderer.setTextureSize(this.textureWidth, this.textureHeight);
        modelPlaneRenderer.mirror = true;
        modelPlaneRenderer.addBackPlane(0.0f, -2.0f, 0.0f, 4, 4);
        this.leg3.addChild(modelPlaneRenderer);
        modelPlaneRenderer = new ModelPlaneRenderer(this, 8, 24);
        modelPlaneRenderer.setTextureSize(this.textureWidth, this.textureHeight);
        modelPlaneRenderer.addBackPlane(0.0f, -2.0f, 6.0f, 4, 4);
        modelPlaneRenderer.setRotationPoint(-4.0f, 0.0f, 0.0f);
        this.leg3.addChild(modelPlaneRenderer);
        modelPlaneRenderer = new ModelPlaneRenderer(this, 8, 24);
        modelPlaneRenderer.setTextureSize(this.textureWidth, this.textureHeight);
        modelPlaneRenderer.mirror = true;
        modelPlaneRenderer.addBackPlane(0.0f, -2.0f, 6.0f, 4, 4);
        this.leg3.addChild(modelPlaneRenderer);
        modelPlaneRenderer = new ModelPlaneRenderer(this, 4, 26);
        modelPlaneRenderer.setTextureSize(this.textureWidth, this.textureHeight);
        modelPlaneRenderer.addTopPlane(0.0f, -2.0f, -6.0f, 4, 6);
        modelPlaneRenderer.setRotationPoint(-4.0f, 0.0f, 0.0f);
        modelPlaneRenderer.rotateAngleX = (float)Math.PI;
        this.leg3.addChild(modelPlaneRenderer);
        modelPlaneRenderer = new ModelPlaneRenderer(this, 4, 26);
        modelPlaneRenderer.setTextureSize(this.textureWidth, this.textureHeight);
        modelPlaneRenderer.mirror = true;
        modelPlaneRenderer.addTopPlane(0.0f, -2.0f, -6.0f, 4, 6);
        modelPlaneRenderer.rotateAngleX = (float)Math.PI;
        this.leg3.addChild(modelPlaneRenderer);
        modelPlaneRenderer = new ModelPlaneRenderer(this, 8, 26);
        modelPlaneRenderer.setTextureSize(this.textureWidth, this.textureHeight);
        modelPlaneRenderer.addTopPlane(0.0f, -2.0f, 0.0f, 4, 6);
        modelPlaneRenderer.setRotationPoint(-4.0f, 0.0f, 0.0f);
        this.leg3.addChild(modelPlaneRenderer);
        modelPlaneRenderer = new ModelPlaneRenderer(this, 8, 26);
        modelPlaneRenderer.setTextureSize(this.textureWidth, this.textureHeight);
        modelPlaneRenderer.mirror = true;
        modelPlaneRenderer.addTopPlane(0.0f, -2.0f, 0.0f, 4, 6);
        this.leg3.addChild(modelPlaneRenderer);
        modelPlaneRenderer = new ModelPlaneRenderer(this, 0, 26);
        modelPlaneRenderer.setTextureSize(this.textureWidth, this.textureHeight);
        modelPlaneRenderer.rotateAngleX = 1.5707964f;
        modelPlaneRenderer.addSidePlane(0.0f, 0.0f, -2.0f, 6, 4);
        modelPlaneRenderer.setRotationPoint(-4.0f, 0.0f, 0.0f);
        this.leg3.addChild(modelPlaneRenderer);
        modelPlaneRenderer = new ModelPlaneRenderer(this, 0, 26);
        modelPlaneRenderer.setTextureSize(this.textureWidth, this.textureHeight);
        modelPlaneRenderer.rotateAngleX = 1.5707964f;
        modelPlaneRenderer.addSidePlane(4.0f, 0.0f, -2.0f, 6, 4);
        this.leg3.addChild(modelPlaneRenderer);
        this.leg4 = new ModelRenderer(this, 0, 0);
        this.leg4.setTextureSize(this.textureWidth, this.textureHeight);
        this.leg4.childModels = this.leg3.childModels;
        this.leg5 = new ModelRenderer(this, 0, 0);
        modelRenderer = new ModelRenderer(this, 56, 20);
        modelRenderer.addBox(0.0f, 0.0f, -2.0f, 2, 5, 2);
        modelRenderer.setRotationPoint(-2.0f, 0.0f, 0.0f);
        modelRenderer.rotateAngleX = 1.5707964f;
        this.leg5.addChild(modelRenderer);
        modelRenderer = new ModelRenderer(this, 56, 20);
        modelRenderer.mirror = true;
        modelRenderer.addBox(0.0f, 0.0f, -2.0f, 2, 5, 2);
        modelRenderer.rotateAngleX = 1.5707964f;
        this.leg5.addChild(modelRenderer);
        this.defaultRotation();
        if (this.textureHeight != 32) {
            ModelRenderer modelRenderer2 = new ModelRenderer(this, 0, 32);
            modelRenderer2.addBox(0.0f, 0.0f, 0.0f, 4, 3, 3);
            modelRenderer2.setRotationPoint(-2.0f, -3.0f, -7.0f);
            this.bipedHead.addChild(modelRenderer2);
            ModelRenderer modelRenderer3 = new ModelRenderer(this, 0, 38);
            modelRenderer3.addBox(0.0f, 0.0f, 0.0f, 4, 3, 1);
            modelRenderer3.setRotationPoint(-2.0f, -3.0f, -5.0f);
            this.bipedHead.addChild(modelRenderer3);
            ModelPlaneRenderer modelPlaneRenderer2 = new ModelPlaneRenderer(this, 14, 32);
            modelPlaneRenderer2.setTextureSize(64, 64);
            modelPlaneRenderer2.addSidePlane(0.0f, -12.0f, -1.0f, 9, 9);
            this.bipedHead.addChild(modelPlaneRenderer2);
            ModelPlaneRenderer modelPlaneRenderer3 = new ModelPlaneRenderer(this, 23, 32);
            modelPlaneRenderer3.setTextureSize(64, 64);
            modelPlaneRenderer3.addSidePlane(0.0f, 0.0f, 2.0f, 12, 7);
            this.bipedBody.addChild(modelPlaneRenderer3);
        }
    }

    private void defaultRotation() {
        this.leg.setRotationPoint(0.0f, 14.0f, 0.0f);
        this.leg2.setRotationPoint(0.0f, 18.0f, 0.6f);
        this.leg3.setRotationPoint(0.0f, 22.0f, -0.3f);
        this.leg4.setRotationPoint(0.0f, 22.0f, 5.0f);
        this.leg5.setRotationPoint(0.0f, 22.0f, 10.0f);
        this.leg.rotateAngleX = 0.0f;
        this.leg2.rotateAngleX = 0.0f;
        this.leg3.rotateAngleX = 0.0f;
        this.leg4.rotateAngleX = 0.0f;
        this.leg5.rotateAngleX = 0.0f;
    }

    @Override
    public void render(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        super.render(entity, f, f2, f3, f4, f5, f6);
        this.leg.render(f6);
        this.leg3.render(f6);
        if (!this.isRiding) {
            this.leg2.render(f6);
        }
        GL11.glPushMatrix();
        GL11.glScalef(0.64f, 0.7f, 0.85f);
        GL11.glTranslatef(this.leg3.rotateAngleY, 0.66f, 0.06f);
        this.leg4.render(f6);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.leg3.rotateAngleY + this.leg4.rotateAngleY, 0.0f, 0.0f);
        this.leg5.render(f6);
        GL11.glPopMatrix();
    }

    @Override
    public void setLivingAnimations(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        super.setLivingAnimations(entityLivingBase, f, f2, f3);
    }

    @Override
    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6) {
        super.setRotationAngles(f, f2, f3, f4, f5, f6);
        this.leg.rotateAngleY = sajh._b(f * 0.6662f) * 0.26f * f2;
        this.leg2.rotateAngleY = sajh._b(f * 0.6662f) * 0.5f * f2;
        this.leg3.rotateAngleY = sajh._b(f * 0.6662f) * 0.26f * f2;
        this.leg4.rotateAngleY = -sajh._b(f * 0.6662f) * 0.16f * f2;
        this.leg5.rotateAngleY = -sajh._b(f * 0.6662f) * 0.3f * f2;
        this.defaultRotation();
        if (this.isSleeping) {
            this.leg3.rotateAngleX = -1.5707964f;
            this.leg4.rotateAngleX = -1.5707964f;
            this.leg5.rotateAngleX = -1.5707964f;
            this.leg3.rotationPointY -= 2.0f;
            this.leg3.rotationPointZ = 0.9f;
            this.leg4.rotationPointY += 4.0f;
            this.leg4.rotationPointZ = 0.9f;
            this.leg5.rotationPointY += 7.0f;
            this.leg5.rotationPointZ = 2.9f;
        }
        if (this.isRiding) {
            this.leg.rotationPointY -= 1.0f;
            this.leg.rotateAngleX = -0.19634955f;
            this.leg.rotationPointZ = -1.0f;
            this.leg2.rotationPointY -= 4.0f;
            this.leg2.rotationPointZ = -1.0f;
            this.leg3.rotationPointY -= 9.0f;
            this.leg3.rotationPointZ -= 1.0f;
            this.leg4.rotationPointY -= 13.0f;
            this.leg4.rotationPointZ -= 1.0f;
            this.leg5.rotationPointY -= 9.0f;
            this.leg5.rotationPointZ -= 1.0f;
            if (this.isSneak) {
                this.leg.rotationPointZ += 5.0f;
                this.leg3.rotationPointZ += 5.0f;
                this.leg4.rotationPointZ += 5.0f;
                this.leg5.rotationPointZ += 4.0f;
                this.leg.rotationPointY -= 1.0f;
                this.leg2.rotationPointY -= 1.0f;
                this.leg3.rotationPointY -= 1.0f;
                this.leg4.rotationPointY -= 1.0f;
                this.leg5.rotationPointY -= 1.0f;
            }
        } else if (this.isSneak) {
            this.leg.rotationPointY -= 1.0f;
            this.leg2.rotationPointY -= 1.0f;
            this.leg3.rotationPointY -= 1.0f;
            this.leg4.rotationPointY -= 1.0f;
            this.leg5.rotationPointY -= 1.0f;
            this.leg.rotationPointZ = 5.0f;
            this.leg2.rotationPointZ = 3.0f;
        }
    }
}

