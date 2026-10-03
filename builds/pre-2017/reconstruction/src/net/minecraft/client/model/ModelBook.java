/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.sajh;

public class ModelBook
extends ModelBase {
    public ModelRenderer coverRight = new ModelRenderer(this).setTextureOffset(0, 0).addBox(-6.0f, -5.0f, 0.0f, 6, 10, 0);
    public ModelRenderer coverLeft = new ModelRenderer(this).setTextureOffset(16, 0).addBox(0.0f, -5.0f, 0.0f, 6, 10, 0);
    public ModelRenderer pagesRight;
    public ModelRenderer pagesLeft;
    public ModelRenderer flippingPageRight;
    public ModelRenderer flippingPageLeft;
    public ModelRenderer bookSpine = new ModelRenderer(this).setTextureOffset(12, 0).addBox(-1.0f, -5.0f, 0.0f, 2, 10, 0);

    public ModelBook() {
        this.pagesRight = new ModelRenderer(this).setTextureOffset(0, 10).addBox(0.0f, -4.0f, -0.99f, 5, 8, 1);
        this.pagesLeft = new ModelRenderer(this).setTextureOffset(12, 10).addBox(0.0f, -4.0f, -0.01f, 5, 8, 1);
        this.flippingPageRight = new ModelRenderer(this).setTextureOffset(24, 10).addBox(0.0f, -4.0f, 0.0f, 5, 8, 0);
        this.flippingPageLeft = new ModelRenderer(this).setTextureOffset(24, 10).addBox(0.0f, -4.0f, 0.0f, 5, 8, 0);
        this.coverRight.setRotationPoint(0.0f, 0.0f, -1.0f);
        this.coverLeft.setRotationPoint(0.0f, 0.0f, 1.0f);
        this.bookSpine.rotateAngleY = 1.5707964f;
    }

    @Override
    public void render(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        this.setRotationAngles(f, f2, f3, f4, f5, f6, entity);
        this.coverRight.render(f6);
        this.coverLeft.render(f6);
        this.bookSpine.render(f6);
        this.pagesRight.render(f6);
        this.pagesLeft.render(f6);
        this.flippingPageRight.render(f6);
        this.flippingPageLeft.render(f6);
    }

    @Override
    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        float f7 = (sajh._a(f * 0.02f) * 0.1f + 1.25f) * f4;
        this.coverRight.rotateAngleY = (float)Math.PI + f7;
        this.coverLeft.rotateAngleY = -f7;
        this.pagesRight.rotateAngleY = f7;
        this.pagesLeft.rotateAngleY = -f7;
        this.flippingPageRight.rotateAngleY = f7 - f7 * 2.0f * f2;
        this.flippingPageLeft.rotateAngleY = f7 - f7 * 2.0f * f3;
        this.pagesRight.rotationPointX = sajh._a(f7);
        this.pagesLeft.rotationPointX = sajh._a(f7);
        this.flippingPageRight.rotationPointX = sajh._a(f7);
        this.flippingPageLeft.rotationPointX = sajh._a(f7);
    }
}

