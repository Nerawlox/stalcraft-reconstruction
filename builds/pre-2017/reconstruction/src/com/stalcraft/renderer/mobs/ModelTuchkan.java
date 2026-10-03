/*
 * Decompiled with CFR 0.152.
 */
package com.stalcraft.renderer.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.sajh;

public class ModelTuchkan
extends ModelBase {
    ModelRenderer hvost2;
    ModelRenderer hvost1;
    ModelRenderer uxo2;
    ModelRenderer uxo1;
    ModelRenderer bedro2;
    ModelRenderer bedro1;
    ModelRenderer noga2;
    ModelRenderer noga1;
    ModelRenderer kisti1;
    ModelRenderer kisti2;
    ModelRenderer lapka1;
    ModelRenderer lapka2;
    ModelRenderer lapa1;
    ModelRenderer lapa2;
    ModelRenderer golova;
    ModelRenderer tuloviche;

    public ModelTuchkan() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.hvost2 = new ModelRenderer(this, 12, 0);
        this.hvost2.addBox(0.0f, 0.0f, 0.0f, 1, 5, 1);
        this.hvost2.setRotationPoint(-1.0f, 20.0f, 3.0f);
        this.hvost2.setTextureSize(64, 32);
        this.hvost2.mirror = true;
        this.setRotation(this.hvost2, -1.814316f, 0.0f, 0.0f);
        this.hvost1 = new ModelRenderer(this, 16, 0);
        this.hvost1.addBox(0.0f, 0.0f, 0.0f, 1, 5, 1);
        this.hvost1.setRotationPoint(-1.0f, 20.0f, 7.0f);
        this.hvost1.setTextureSize(64, 32);
        this.hvost1.mirror = true;
        this.setRotation(this.hvost1, -1.606116f, 0.0f, 0.0f);
        this.uxo2 = new ModelRenderer(this, 30, 0);
        this.uxo2.addBox(-1.0f, 0.0f, 0.0f, 2, 2, 1);
        this.uxo2.setRotationPoint(1.0f, 13.0f, -9.0f);
        this.uxo2.setTextureSize(64, 32);
        this.uxo2.mirror = true;
        this.setRotation(this.uxo2, 0.0f, 0.0f, 0.0f);
        this.uxo1 = new ModelRenderer(this, 36, 0);
        this.uxo1.addBox(-1.0f, 0.0f, 0.0f, 2, 2, 1);
        this.uxo1.setRotationPoint(-2.0f, 13.0f, -9.0f);
        this.uxo1.setTextureSize(64, 32);
        this.uxo1.mirror = true;
        this.setRotation(this.uxo1, 0.0f, 0.0f, 0.0f);
        this.bedro2 = new ModelRenderer(this, 9, 19);
        this.bedro2.addBox(0.0f, 0.0f, 0.0f, 1, 3, 2);
        this.bedro2.setRotationPoint(1.0f, 19.0f, -3.0f);
        this.bedro2.setTextureSize(64, 32);
        this.bedro2.mirror = true;
        this.setRotation(this.bedro2, -0.8625438f, 0.0f, 0.0f);
        this.bedro1 = new ModelRenderer(this, 9, 19);
        this.bedro1.addBox(0.0f, 0.0f, 0.0f, 1, 3, 2);
        this.bedro1.setRotationPoint(-3.0f, 19.0f, -3.0f);
        this.bedro1.setTextureSize(64, 32);
        this.bedro1.mirror = true;
        this.setRotation(this.bedro1, -0.8625438f, 0.0f, 0.0f);
        this.noga2 = new ModelRenderer(this, 9, 19);
        this.noga2.addBox(0.0f, -2.0f, 0.0f, 1, 3, 1);
        this.noga2.setRotationPoint(1.0f, 23.0f, -4.0f);
        this.noga2.setTextureSize(64, 32);
        this.noga2.mirror = true;
        this.setRotation(this.noga2, 0.803058f, 0.0f, 0.0f);
        this.noga1 = new ModelRenderer(this, 9, 19);
        this.noga1.addBox(0.0f, -2.0f, 0.0f, 1, 3, 1);
        this.noga1.setRotationPoint(-3.0f, 23.0f, -4.0f);
        this.noga1.setTextureSize(64, 32);
        this.noga1.mirror = true;
        this.setRotation(this.noga1, 0.803058f, 0.0f, 0.0f);
        this.kisti1 = new ModelRenderer(this, 9, 19);
        this.kisti1.addBox(0.0f, 0.0f, 0.0f, 1, 3, 1);
        this.kisti1.setRotationPoint(-3.0f, 17.0f, -8.0f);
        this.kisti1.setTextureSize(64, 32);
        this.kisti1.mirror = true;
        this.setRotation(this.kisti1, 0.0f, 0.0f, 0.0f);
        this.kisti2 = new ModelRenderer(this, 9, 19);
        this.kisti2.addBox(0.0f, 0.0f, 0.0f, 1, 3, 1);
        this.kisti2.setRotationPoint(1.0f, 17.0f, -8.0f);
        this.kisti2.setTextureSize(64, 32);
        this.kisti2.mirror = true;
        this.setRotation(this.kisti2, 0.0f, 0.0f, 0.0f);
        this.lapka1 = new ModelRenderer(this, 9, 25);
        this.lapka1.addBox(0.0f, 0.0f, 0.0f, 1, 1, 3);
        this.lapka1.setRotationPoint(-2.0f, 23.0f, -3.0f);
        this.lapka1.setTextureSize(64, 32);
        this.lapka1.mirror = true;
        this.setRotation(this.lapka1, -0.1487144f, -3.141593f, 0.0f);
        this.lapka2 = new ModelRenderer(this, 9, 25);
        this.lapka2.addBox(0.0f, 0.0f, 0.0f, 1, 1, 3);
        this.lapka2.setRotationPoint(2.0f, 23.0f, -3.0f);
        this.lapka2.setTextureSize(64, 32);
        this.lapka2.mirror = true;
        this.setRotation(this.lapka2, -0.1487144f, -3.141593f, 0.0f);
        this.lapa1 = new ModelRenderer(this, 9, 19);
        this.lapa1.addBox(0.0f, 0.0f, 0.0f, 1, 3, 1);
        this.lapa1.setRotationPoint(-3.0f, 19.0f, -8.0f);
        this.lapa1.setTextureSize(64, 32);
        this.lapa1.mirror = true;
        this.setRotation(this.lapa1, -1.041001f, 0.0f, 0.0f);
        this.lapa2 = new ModelRenderer(this, 9, 19);
        this.lapa2.addBox(0.0f, 0.0f, 0.0f, 1, 3, 1);
        this.lapa2.setRotationPoint(1.0f, 19.0f, -8.0f);
        this.lapa2.setTextureSize(64, 32);
        this.lapa2.mirror = true;
        this.setRotation(this.lapa2, -1.041001f, 0.0f, 0.0f);
        this.golova = new ModelRenderer(this, 0, 0);
        this.golova.addBox(-2.0f, -2.0f, -1.0f, 3, 4, 3);
        this.golova.setRotationPoint(0.0f, 16.0f, -10.0f);
        this.golova.setTextureSize(64, 32);
        this.golova.mirror = true;
        this.setRotation(this.golova, 0.0f, 0.0f, 0.0f);
        this.tuloviche = new ModelRenderer(this, 0, 19);
        this.tuloviche.addBox(-5.0f, -4.0f, -6.0f, 3, 3, 9);
        this.tuloviche.setRotationPoint(3.0f, 21.0f, -5.0f);
        this.tuloviche.setTextureSize(64, 32);
        this.tuloviche.mirror = true;
        this.setRotation(this.tuloviche, -0.6840864f, 0.0f, 0.0f);
    }

    @Override
    public void render(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        super.render(entity, f, f2, f3, f4, f5, f6);
        this.setRotationAngles(f, f2, f3, f4, f5, f6, entity);
        this.hvost2.render(f6);
        this.hvost1.render(f6);
        this.uxo2.render(f6);
        this.uxo1.render(f6);
        this.bedro2.render(f6);
        this.bedro1.render(f6);
        this.noga2.render(f6);
        this.noga1.render(f6);
        this.kisti1.render(f6);
        this.kisti2.render(f6);
        this.lapka1.render(f6);
        this.lapka2.render(f6);
        this.lapa1.render(f6);
        this.lapa2.render(f6);
        this.golova.render(f6);
        this.tuloviche.render(f6);
    }

    private void setRotation(ModelRenderer modelRenderer, float f, float f2, float f3) {
        modelRenderer.rotateAngleX = f;
        modelRenderer.rotateAngleY = f2;
        modelRenderer.rotateAngleZ = f3;
    }

    @Override
    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        super.setRotationAngles(f, f2, f3, f4, f5, f6, entity);
        float f7 = sajh._b(f * 0.6662f) * 2.0f * f2 * 0.5f;
        float f8 = sajh._b(f * 0.6662f + (float)Math.PI) * 2.0f * f2 * 0.5f;
        this.golova.rotateAngleY = f4 / 57.295776f;
        this.uxo1.rotateAngleX = this.golova.rotateAngleX = f5 / 57.295776f;
        this.uxo2.rotateAngleX = this.golova.rotateAngleX;
        this.uxo1.rotateAngleY = this.golova.rotateAngleY;
        this.uxo2.rotateAngleY = this.golova.rotateAngleY;
        this.uxo1.rotateAngleZ = this.golova.rotateAngleZ;
        this.uxo2.rotateAngleZ = this.golova.rotateAngleZ;
        this.bedro1.rotateAngleX = f7;
        this.bedro1.rotateAngleZ = 0.0f;
        this.noga1.rotateAngleX = -this.bedro1.rotateAngleX;
        this.noga1.rotateAngleZ = 0.0f;
        this.bedro2.rotateAngleX = f8;
        this.bedro2.rotateAngleZ = 0.0f;
        this.noga2.rotateAngleX = -this.bedro2.rotateAngleX;
        this.noga2.rotateAngleZ = 0.0f;
        this.lapka1.rotateAngleX = f7;
        this.lapka1.rotateAngleZ = 0.0f;
        this.lapka2.rotateAngleX = -this.lapka1.rotateAngleX;
        this.lapka2.rotateAngleZ = 0.0f;
    }
}

