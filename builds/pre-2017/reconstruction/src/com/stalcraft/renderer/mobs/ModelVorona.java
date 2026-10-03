/*
 * Decompiled with CFR 0.152.
 */
package com.stalcraft.renderer.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelVorona
extends ModelBase {
    ModelRenderer brucho;
    ModelRenderer tuloviche;
    ModelRenderer golova;
    ModelRenderer kluv;
    ModelRenderer chvost;
    ModelRenderer chacti_krula1;
    ModelRenderer chacti_krula2;
    ModelRenderer krulo;
    ModelRenderer chacti_krula3;
    ModelRenderer chacti_krula4;

    public ModelVorona() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.brucho = new ModelRenderer(this, 0, 15);
        this.brucho.addBox(0.0f, 0.0f, 0.0f, 4, 3, 4);
        this.brucho.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.brucho.setTextureSize(64, 32);
        this.brucho.mirror = true;
        this.setRotation(this.brucho, 0.0f, 0.0f, 0.0f);
        this.tuloviche = new ModelRenderer(this, 24, 5);
        this.tuloviche.addBox(0.0f, 0.0f, 0.0f, 3, 2, 8);
        this.tuloviche.setRotationPoint(0.5f, 0.0f, 0.0f);
        this.tuloviche.setTextureSize(64, 32);
        this.tuloviche.mirror = true;
        this.setRotation(this.tuloviche, 0.0f, 0.0f, 0.0f);
        this.golova = new ModelRenderer(this, 12, 23);
        this.golova.addBox(0.0f, 0.0f, 0.0f, 2, 3, 2);
        this.golova.setRotationPoint(1.0f, 0.0f, 0.0f);
        this.golova.setTextureSize(64, 32);
        this.golova.mirror = true;
        this.setRotation(this.golova, -1.152537f, 0.0f, 0.0f);
        this.kluv = new ModelRenderer(this, 12, 28);
        this.kluv.addBox(0.0f, 0.0f, 0.0f, 1, 1, 2);
        this.kluv.setRotationPoint(1.5f, 2.5f, -3.5f);
        this.kluv.setTextureSize(64, 32);
        this.kluv.mirror = true;
        this.setRotation(this.kluv, 0.4461433f, 0.0f, 0.0f);
        this.chvost = new ModelRenderer(this, 40, 0);
        this.chvost.addBox(0.0f, 0.0f, 0.0f, 4, 4, 1);
        this.chvost.setRotationPoint(0.0f, -2.0f, 10.0f);
        this.chvost.setTextureSize(64, 32);
        this.chvost.mirror = true;
        this.setRotation(this.chvost, -0.7435722f, 0.0f, 0.0f);
        this.chacti_krula1 = new ModelRenderer(this, 12, 9);
        this.chacti_krula1.addBox(0.0f, 0.0f, 0.0f, 2, 2, 4);
        this.chacti_krula1.setRotationPoint(-1.0f, 0.0f, 0.0f);
        this.chacti_krula1.setTextureSize(64, 32);
        this.chacti_krula1.mirror = true;
        this.setRotation(this.chacti_krula1, 0.0f, 0.0f, 0.0f);
        this.chacti_krula2 = new ModelRenderer(this, 0, 9);
        this.chacti_krula2.addBox(0.0f, 0.0f, 0.0f, 2, 2, 4);
        this.chacti_krula2.setRotationPoint(3.0f, 0.0f, 0.0f);
        this.chacti_krula2.setTextureSize(64, 32);
        this.chacti_krula2.mirror = true;
        this.setRotation(this.chacti_krula2, 0.0f, 0.0f, 0.0f);
        this.krulo = new ModelRenderer(this, 0, 0);
        this.krulo.addBox(0.0f, 0.0f, 0.0f, 16, 1, 4);
        this.krulo.setRotationPoint(-6.0f, 0.0f, 0.0f);
        this.krulo.setTextureSize(64, 32);
        this.krulo.mirror = true;
        this.setRotation(this.krulo, 0.0f, 0.0f, 0.0f);
        this.chacti_krula3 = new ModelRenderer(this, 0, 5);
        this.chacti_krula3.addBox(0.0f, 0.0f, 0.0f, 2, 1, 3);
        this.chacti_krula3.setRotationPoint(-8.0f, 0.0f, 1.0f);
        this.chacti_krula3.setTextureSize(64, 32);
        this.chacti_krula3.mirror = true;
        this.setRotation(this.chacti_krula3, 0.0f, 0.0f, 0.0f);
        this.chacti_krula4 = new ModelRenderer(this, 10, 5);
        this.chacti_krula4.addBox(0.0f, 0.0f, 0.0f, 2, 1, 3);
        this.chacti_krula4.setRotationPoint(10.0f, 0.0f, 1.0f);
        this.chacti_krula4.setTextureSize(64, 32);
        this.chacti_krula4.mirror = true;
        this.setRotation(this.chacti_krula4, 0.0f, 0.0f, 0.0f);
    }

    @Override
    public void render(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        super.render(entity, f, f2, f3, f4, f5, f6);
        this.setRotationAngles(f, f2, f3, f4, f5, f6, entity);
        this.brucho.render(f6);
        this.tuloviche.render(f6);
        this.golova.render(f6);
        this.kluv.render(f6);
        this.chvost.render(f6);
        this.chacti_krula1.render(f6);
        this.chacti_krula2.render(f6);
        this.krulo.render(f6);
        this.chacti_krula3.render(f6);
        this.chacti_krula4.render(f6);
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

