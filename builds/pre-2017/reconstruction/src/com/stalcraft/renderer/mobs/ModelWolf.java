/*
 * Decompiled with CFR 0.152.
 */
package com.stalcraft.renderer.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWolf
extends ModelBase {
    ModelRenderer cheya;
    ModelRenderer noga1;
    ModelRenderer noga2;
    ModelRenderer lapka1;
    ModelRenderer lapka2;
    ModelRenderer noga3;
    ModelRenderer noga4;
    ModelRenderer noga5;
    ModelRenderer noga6;
    ModelRenderer lapka3;
    ModelRenderer lapka4;
    ModelRenderer lapka5;
    ModelRenderer lapka6;
    ModelRenderer golova;
    ModelRenderer nos;
    ModelRenderer Body;
    ModelRenderer Mane;
    ModelRenderer bedro1;
    ModelRenderer noga7;
    ModelRenderer Tail;
    ModelRenderer noga8;
    ModelRenderer bedro2;

    public ModelWolf() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.cheya = new ModelRenderer(this, 81, 0);
        this.cheya.addBox(0.0f, 0.0f, 0.0f, 4, 6, 4);
        this.cheya.setRotationPoint(-3.0f, 12.0f, -11.0f);
        this.cheya.setTextureSize(128, 64);
        this.cheya.mirror = true;
        this.setRotation(this.cheya, 1.011258f, 0.0f, 0.0f);
        this.noga1 = new ModelRenderer(this, 34, 45);
        this.noga1.addBox(0.0f, 0.0f, 0.0f, 2, 5, 2);
        this.noga1.setRotationPoint(0.0f, 18.0f, -3.626667f);
        this.noga1.setTextureSize(128, 64);
        this.noga1.mirror = true;
        this.setRotation(this.noga1, -0.3271718f, 0.0f, 0.0f);
        this.noga2 = new ModelRenderer(this, 34, 45);
        this.noga2.addBox(0.0f, 0.0f, 0.0f, 2, 5, 2);
        this.noga2.setRotationPoint(-4.0f, 18.0f, -3.5f);
        this.noga2.setTextureSize(128, 64);
        this.noga2.mirror = true;
        this.setRotation(this.noga2, -0.3271718f, 0.0f, 0.0f);
        this.lapka1 = new ModelRenderer(this, 34, 47);
        this.lapka1.addBox(0.0f, 0.0f, 0.0f, 2, 1, 4);
        this.lapka1.setRotationPoint(0.0f, 23.0f, -7.0f);
        this.lapka1.setTextureSize(128, 64);
        this.lapka1.mirror = true;
        this.setRotation(this.lapka1, 0.0f, 0.0f, 0.0f);
        this.lapka2 = new ModelRenderer(this, 34, 47);
        this.lapka2.addBox(0.0f, 0.0f, 0.0f, 2, 1, 4);
        this.lapka2.setRotationPoint(-4.0f, 23.0f, -7.0f);
        this.lapka2.setTextureSize(128, 64);
        this.lapka2.mirror = true;
        this.setRotation(this.lapka2, 0.0f, 0.0f, 0.0f);
        this.noga3 = new ModelRenderer(this, 12, 45);
        this.noga3.addBox(0.0f, 0.0f, 0.0f, 2, 4, 2);
        this.noga3.setRotationPoint(0.5f, 15.0f, 5.0f);
        this.noga3.setTextureSize(128, 64);
        this.noga3.mirror = true;
        this.setRotation(this.noga3, -0.2974289f, 0.0f, 0.0f);
        this.noga4 = new ModelRenderer(this, 12, 45);
        this.noga4.addBox(0.0f, 0.0f, 0.0f, 2, 4, 2);
        this.noga4.setRotationPoint(-4.5f, 15.0f, 5.0f);
        this.noga4.setTextureSize(128, 64);
        this.noga4.mirror = true;
        this.setRotation(this.noga4, -0.2974289f, 0.0f, 0.0f);
        this.noga5 = new ModelRenderer(this, 34, 45);
        this.noga5.addBox(0.0f, 0.0f, 0.0f, 2, 5, 2);
        this.noga5.setRotationPoint(-4.5f, 18.0f, 4.5f);
        this.noga5.setTextureSize(128, 64);
        this.noga5.mirror = true;
        this.setRotation(this.noga5, 0.5056291f, 0.0f, 0.0f);
        this.noga6 = new ModelRenderer(this, 34, 45);
        this.noga6.addBox(0.0f, 0.0f, 0.0f, 2, 5, 2);
        this.noga6.setRotationPoint(0.5f, 18.0f, 4.5f);
        this.noga6.setTextureSize(128, 64);
        this.noga6.mirror = true;
        this.setRotation(this.noga6, 0.5056291f, 0.0f, 0.0f);
        this.lapka3 = new ModelRenderer(this, 35, 46);
        this.lapka3.addBox(0.0f, 0.0f, 0.0f, 2, 5, 1);
        this.lapka3.setRotationPoint(0.5f, 21.0f, 8.0f);
        this.lapka3.setTextureSize(128, 64);
        this.lapka3.mirror = true;
        this.setRotation(this.lapka3, -1.041001f, 0.0f, 0.0f);
        this.lapka4 = new ModelRenderer(this, 35, 46);
        this.lapka4.addBox(0.0f, 0.0f, 0.0f, 2, 5, 1);
        this.lapka4.setRotationPoint(-4.5f, 21.0f, 8.0f);
        this.lapka4.setTextureSize(128, 64);
        this.lapka4.mirror = true;
        this.setRotation(this.lapka4, -1.041001f, 0.0f, 0.0f);
        this.lapka5 = new ModelRenderer(this, 34, 47);
        this.lapka5.addBox(0.0f, 0.0f, 0.0f, 2, 3, 1);
        this.lapka5.setRotationPoint(-4.5f, 23.0f, 5.0f);
        this.lapka5.setTextureSize(128, 64);
        this.lapka5.mirror = true;
        this.setRotation(this.lapka5, -1.516887f, 0.0f, 0.0f);
        this.lapka6 = new ModelRenderer(this, 34, 47);
        this.lapka6.addBox(0.0f, 0.0f, 0.0f, 2, 3, 1);
        this.lapka6.setRotationPoint(0.5f, 23.0f, 5.0f);
        this.lapka6.setTextureSize(128, 64);
        this.lapka6.mirror = true;
        this.setRotation(this.lapka6, -1.516887f, 0.0f, 0.0f);
        this.golova = new ModelRenderer(this, 0, 0);
        this.golova.addBox(0.0f, 0.0f, 0.0f, 6, 6, 6);
        this.golova.setRotationPoint(-4.0f, 7.0f, -14.0f);
        this.golova.setTextureSize(128, 64);
        this.golova.mirror = true;
        this.setRotation(this.golova, 0.0f, 0.0f, 0.0f);
        this.nos = new ModelRenderer(this, 0, 13);
        this.nos.addBox(0.0f, 0.0f, 0.0f, 4, 3, 4);
        this.nos.setRotationPoint(-3.0f, 10.0f, -18.0f);
        this.nos.setTextureSize(128, 64);
        this.nos.mirror = true;
        this.setRotation(this.nos, 0.0f, 0.0f, 0.0f);
        this.Body = new ModelRenderer(this, 56, 0);
        this.Body.addBox(-4.0f, -2.0f, -3.0f, 6, 9, 6);
        this.Body.setRotationPoint(0.0f, 14.0f, 2.0f);
        this.Body.setTextureSize(128, 64);
        this.Body.mirror = true;
        this.setRotation(this.Body, 1.570796f, 0.0f, 0.0f);
        this.Mane = new ModelRenderer(this, 25, 0);
        this.Mane.addBox(-4.0f, -3.0f, -3.0f, 8, 6, 7);
        this.Mane.setRotationPoint(-1.0f, 14.0f, -3.0f);
        this.Mane.setTextureSize(128, 64);
        this.Mane.mirror = true;
        this.setRotation(this.Mane, 1.570796f, 0.0f, 0.0f);
        this.bedro1 = new ModelRenderer(this, 11, 44);
        this.bedro1.addBox(-1.0f, 0.0f, -1.0f, 2, 4, 3);
        this.bedro1.setRotationPoint(-3.5f, 14.0f, 6.0f);
        this.bedro1.setTextureSize(128, 64);
        this.bedro1.mirror = true;
        this.setRotation(this.bedro1, -0.2974289f, 0.0f, 0.0f);
        this.noga7 = new ModelRenderer(this, 9, 37);
        this.noga7.addBox(0.0f, 0.0f, 0.0f, 2, 4, 2);
        this.noga7.setRotationPoint(-4.0f, 16.0f, -5.0f);
        this.noga7.setTextureSize(128, 64);
        this.noga7.mirror = true;
        this.setRotation(this.noga7, 0.2974289f, 0.0f, 0.0f);
        this.Tail = new ModelRenderer(this, 69, 7);
        this.Tail.addBox(-1.0f, 0.0f, -1.0f, 2, 6, 1);
        this.Tail.setRotationPoint(-1.0f, 11.0f, 9.0f);
        this.Tail.setTextureSize(128, 64);
        this.Tail.mirror = true;
        this.setRotation(this.Tail, 0.3270113f, 0.0f, 0.0f);
        this.noga8 = new ModelRenderer(this, 9, 37);
        this.noga8.addBox(0.0f, 0.0f, 0.0f, 2, 4, 2);
        this.noga8.setRotationPoint(0.0f, 16.0f, -5.0f);
        this.noga8.setTextureSize(128, 64);
        this.noga8.mirror = true;
        this.setRotation(this.noga8, 0.2974289f, 0.0f, 0.0f);
        this.bedro2 = new ModelRenderer(this, 11, 44);
        this.bedro2.addBox(0.0f, 0.0f, 0.0f, 2, 4, 3);
        this.bedro2.setRotationPoint(0.5f, 14.0f, 5.0f);
        this.bedro2.setTextureSize(128, 64);
        this.bedro2.mirror = true;
        this.setRotation(this.bedro2, -0.2974289f, 0.0f, 0.0f);
    }

    @Override
    public void render(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        super.render(entity, f, f2, f3, f4, f5, f6);
        this.setRotationAngles(f, f2, f3, f4, f5, f6, entity);
        this.cheya.render(f6);
        this.noga1.render(f6);
        this.noga2.render(f6);
        this.lapka1.render(f6);
        this.lapka2.render(f6);
        this.noga3.render(f6);
        this.noga4.render(f6);
        this.noga5.render(f6);
        this.noga6.render(f6);
        this.lapka3.render(f6);
        this.lapka4.render(f6);
        this.lapka5.render(f6);
        this.lapka6.render(f6);
        this.golova.render(f6);
        this.nos.render(f6);
        this.Body.render(f6);
        this.Mane.render(f6);
        this.bedro1.render(f6);
        this.noga7.render(f6);
        this.Tail.render(f6);
        this.noga8.render(f6);
        this.bedro2.render(f6);
    }

    private void setRotation(ModelRenderer modelRenderer, float f, float f2, float f3) {
        modelRenderer.rotateAngleX = f;
        modelRenderer.rotateAngleY = f2;
        modelRenderer.rotateAngleZ = f3;
    }

    @Override
    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        super.setRotationAngles(f, f2, f3, f4, f5, f6, entity);
    }
}

