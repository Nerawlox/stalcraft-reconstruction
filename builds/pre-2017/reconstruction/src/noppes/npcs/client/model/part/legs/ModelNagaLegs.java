/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model.part.legs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.sajh;
import noppes.npcs.client.model.util.ModelPlaneRenderer;
import org.lwjgl.opengl.GL11;

public class ModelNagaLegs
extends ModelRenderer {
    public boolean isRiding = false;
    public boolean isSneaking = false;
    public boolean isSleeping = false;
    public boolean isCrawling = false;
    private ModelRenderer nagaPart1;
    private ModelRenderer nagaPart2;
    private ModelRenderer nagaPart3;
    private ModelRenderer nagaPart4;
    private ModelRenderer nagaPart5;

    public ModelNagaLegs(ModelBase modelBase) {
        super(modelBase);
        this.nagaPart1 = new ModelRenderer(modelBase, 0, 0);
        ModelRenderer modelRenderer = new ModelRenderer(modelBase, 0, 16);
        modelRenderer.addBox(0.0f, -2.0f, -2.0f, 4, 4, 4);
        modelRenderer.setRotationPoint(-4.0f, 0.0f, 0.0f);
        this.nagaPart1.addChild(modelRenderer);
        modelRenderer = new ModelRenderer(modelBase, 0, 16);
        modelRenderer.mirror = true;
        modelRenderer.addBox(0.0f, -2.0f, -2.0f, 4, 4, 4);
        this.nagaPart1.addChild(modelRenderer);
        this.nagaPart2 = new ModelRenderer(modelBase, 0, 0);
        this.nagaPart2.childModels = this.nagaPart1.childModels;
        this.nagaPart3 = new ModelRenderer(modelBase, 0, 0);
        ModelPlaneRenderer modelPlaneRenderer = new ModelPlaneRenderer(modelBase, 4, 24);
        modelPlaneRenderer.addBackPlane(0.0f, -2.0f, 0.0f, 4, 4);
        modelPlaneRenderer.setRotationPoint(-4.0f, 0.0f, 0.0f);
        this.nagaPart3.addChild(modelPlaneRenderer);
        modelPlaneRenderer = new ModelPlaneRenderer(modelBase, 4, 24);
        modelPlaneRenderer.mirror = true;
        modelPlaneRenderer.addBackPlane(0.0f, -2.0f, 0.0f, 4, 4);
        this.nagaPart3.addChild(modelPlaneRenderer);
        modelPlaneRenderer = new ModelPlaneRenderer(modelBase, 8, 24);
        modelPlaneRenderer.addBackPlane(0.0f, -2.0f, 6.0f, 4, 4);
        modelPlaneRenderer.setRotationPoint(-4.0f, 0.0f, 0.0f);
        this.nagaPart3.addChild(modelPlaneRenderer);
        modelPlaneRenderer = new ModelPlaneRenderer(modelBase, 8, 24);
        modelPlaneRenderer.mirror = true;
        modelPlaneRenderer.addBackPlane(0.0f, -2.0f, 6.0f, 4, 4);
        this.nagaPart3.addChild(modelPlaneRenderer);
        modelPlaneRenderer = new ModelPlaneRenderer(modelBase, 4, 26);
        modelPlaneRenderer.addTopPlane(0.0f, -2.0f, -6.0f, 4, 6);
        modelPlaneRenderer.setRotationPoint(-4.0f, 0.0f, 0.0f);
        modelPlaneRenderer.rotateAngleX = (float)Math.PI;
        this.nagaPart3.addChild(modelPlaneRenderer);
        modelPlaneRenderer = new ModelPlaneRenderer(modelBase, 4, 26);
        modelPlaneRenderer.mirror = true;
        modelPlaneRenderer.addTopPlane(0.0f, -2.0f, -6.0f, 4, 6);
        modelPlaneRenderer.rotateAngleX = (float)Math.PI;
        this.nagaPart3.addChild(modelPlaneRenderer);
        modelPlaneRenderer = new ModelPlaneRenderer(modelBase, 8, 26);
        modelPlaneRenderer.addTopPlane(0.0f, -2.0f, 0.0f, 4, 6);
        modelPlaneRenderer.setRotationPoint(-4.0f, 0.0f, 0.0f);
        this.nagaPart3.addChild(modelPlaneRenderer);
        modelPlaneRenderer = new ModelPlaneRenderer(modelBase, 8, 26);
        modelPlaneRenderer.mirror = true;
        modelPlaneRenderer.addTopPlane(0.0f, -2.0f, 0.0f, 4, 6);
        this.nagaPart3.addChild(modelPlaneRenderer);
        modelPlaneRenderer = new ModelPlaneRenderer(modelBase, 0, 26);
        modelPlaneRenderer.rotateAngleX = 1.5707964f;
        modelPlaneRenderer.addSidePlane(0.0f, 0.0f, -2.0f, 6, 4);
        modelPlaneRenderer.setRotationPoint(-4.0f, 0.0f, 0.0f);
        this.nagaPart3.addChild(modelPlaneRenderer);
        modelPlaneRenderer = new ModelPlaneRenderer(modelBase, 0, 26);
        modelPlaneRenderer.rotateAngleX = 1.5707964f;
        modelPlaneRenderer.addSidePlane(4.0f, 0.0f, -2.0f, 6, 4);
        this.nagaPart3.addChild(modelPlaneRenderer);
        this.nagaPart4 = new ModelRenderer(modelBase, 0, 0);
        this.nagaPart4.childModels = this.nagaPart3.childModels;
        this.nagaPart5 = new ModelRenderer(modelBase, 0, 0);
        modelRenderer = new ModelRenderer(modelBase, 56, 20);
        modelRenderer.addBox(0.0f, 0.0f, -2.0f, 2, 5, 2);
        modelRenderer.setRotationPoint(-2.0f, 0.0f, 0.0f);
        modelRenderer.rotateAngleX = 1.5707964f;
        this.nagaPart5.addChild(modelRenderer);
        modelRenderer = new ModelRenderer(modelBase, 56, 20);
        modelRenderer.mirror = true;
        modelRenderer.addBox(0.0f, 0.0f, -2.0f, 2, 5, 2);
        modelRenderer.rotateAngleX = 1.5707964f;
        this.nagaPart5.addChild(modelRenderer);
        this.addChild(this.nagaPart1);
        this.addChild(this.nagaPart2);
        this.addChild(this.nagaPart3);
        this.addChild(this.nagaPart4);
        this.addChild(this.nagaPart5);
        this.nagaPart1.setRotationPoint(0.0f, 14.0f, 0.0f);
        this.nagaPart2.setRotationPoint(0.0f, 18.0f, 0.6f);
        this.nagaPart3.setRotationPoint(0.0f, 22.0f, -0.3f);
        this.nagaPart4.setRotationPoint(0.0f, 22.0f, 5.0f);
        this.nagaPart5.setRotationPoint(0.0f, 22.0f, 10.0f);
    }

    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        this.nagaPart1.rotateAngleY = sajh._b(f * 0.6662f) * 0.26f * f2;
        this.nagaPart2.rotateAngleY = sajh._b(f * 0.6662f) * 0.5f * f2;
        this.nagaPart3.rotateAngleY = sajh._b(f * 0.6662f) * 0.26f * f2;
        this.nagaPart4.rotateAngleY = -sajh._b(f * 0.6662f) * 0.16f * f2;
        this.nagaPart5.rotateAngleY = -sajh._b(f * 0.6662f) * 0.3f * f2;
        this.nagaPart1.setRotationPoint(0.0f, 14.0f, 0.0f);
        this.nagaPart2.setRotationPoint(0.0f, 18.0f, 0.6f);
        this.nagaPart3.setRotationPoint(0.0f, 22.0f, -0.3f);
        this.nagaPart4.setRotationPoint(0.0f, 22.0f, 5.0f);
        this.nagaPart5.setRotationPoint(0.0f, 22.0f, 10.0f);
        this.nagaPart1.rotateAngleX = 0.0f;
        this.nagaPart2.rotateAngleX = 0.0f;
        this.nagaPart3.rotateAngleX = 0.0f;
        this.nagaPart4.rotateAngleX = 0.0f;
        this.nagaPart5.rotateAngleX = 0.0f;
        if (this.isSleeping || this.isCrawling) {
            this.nagaPart3.rotateAngleX = -1.5707964f;
            this.nagaPart4.rotateAngleX = -1.5707964f;
            this.nagaPart5.rotateAngleX = -1.5707964f;
            this.nagaPart3.rotationPointY -= 2.0f;
            this.nagaPart3.rotationPointZ = 0.9f;
            this.nagaPart4.rotationPointY += 4.0f;
            this.nagaPart4.rotationPointZ = 0.9f;
            this.nagaPart5.rotationPointY += 7.0f;
            this.nagaPart5.rotationPointZ = 2.9f;
        }
        if (this.isRiding) {
            this.nagaPart1.rotationPointY -= 1.0f;
            this.nagaPart1.rotateAngleX = -0.19634955f;
            this.nagaPart1.rotationPointZ = -1.0f;
            this.nagaPart2.rotationPointY -= 4.0f;
            this.nagaPart2.rotationPointZ = -1.0f;
            this.nagaPart3.rotationPointY -= 9.0f;
            this.nagaPart3.rotationPointZ -= 1.0f;
            this.nagaPart4.rotationPointY -= 13.0f;
            this.nagaPart4.rotationPointZ -= 1.0f;
            this.nagaPart5.rotationPointY -= 9.0f;
            this.nagaPart5.rotationPointZ -= 1.0f;
            if (this.isSneaking) {
                this.nagaPart1.rotationPointZ += 5.0f;
                this.nagaPart3.rotationPointZ += 5.0f;
                this.nagaPart4.rotationPointZ += 5.0f;
                this.nagaPart5.rotationPointZ += 4.0f;
                this.nagaPart1.rotationPointY -= 1.0f;
                this.nagaPart2.rotationPointY -= 1.0f;
                this.nagaPart3.rotationPointY -= 1.0f;
                this.nagaPart4.rotationPointY -= 1.0f;
                this.nagaPart5.rotationPointY -= 1.0f;
            }
        } else if (this.isSneaking) {
            this.nagaPart1.rotationPointY -= 1.0f;
            this.nagaPart2.rotationPointY -= 1.0f;
            this.nagaPart3.rotationPointY -= 1.0f;
            this.nagaPart4.rotationPointY -= 1.0f;
            this.nagaPart5.rotationPointY -= 1.0f;
            this.nagaPart1.rotationPointZ = 5.0f;
            this.nagaPart2.rotationPointZ = 3.0f;
        }
    }

    @Override
    public void render(float f) {
        if (!this.isHidden && this.showModel) {
            this.nagaPart1.render(f);
            this.nagaPart3.render(f);
            if (!this.isRiding) {
                this.nagaPart2.render(f);
            }
            GL11.glPushMatrix();
            GL11.glScalef(0.74f, 0.7f, 0.85f);
            GL11.glTranslatef(this.nagaPart3.rotateAngleY, 0.66f, 0.06f);
            this.nagaPart4.render(f);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glTranslatef(this.nagaPart3.rotateAngleY + this.nagaPart4.rotateAngleY, 0.0f, 0.0f);
            this.nagaPart5.render(f);
            GL11.glPopMatrix();
        }
    }
}

