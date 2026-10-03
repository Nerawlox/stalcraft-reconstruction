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
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        this.brucho = new ModelRenderer(this, 0, 15);
        this.brucho.func_78789_a(0.0f, 0.0f, 0.0f, 4, 3, 4);
        this.brucho.func_78793_a(0.0f, 0.0f, 0.0f);
        this.brucho.func_78787_b(64, 32);
        this.brucho.field_78809_i = true;
        this.setRotation(this.brucho, 0.0f, 0.0f, 0.0f);
        this.tuloviche = new ModelRenderer(this, 24, 5);
        this.tuloviche.func_78789_a(0.0f, 0.0f, 0.0f, 3, 2, 8);
        this.tuloviche.func_78793_a(0.5f, 0.0f, 0.0f);
        this.tuloviche.func_78787_b(64, 32);
        this.tuloviche.field_78809_i = true;
        this.setRotation(this.tuloviche, 0.0f, 0.0f, 0.0f);
        this.golova = new ModelRenderer(this, 12, 23);
        this.golova.func_78789_a(0.0f, 0.0f, 0.0f, 2, 3, 2);
        this.golova.func_78793_a(1.0f, 0.0f, 0.0f);
        this.golova.func_78787_b(64, 32);
        this.golova.field_78809_i = true;
        this.setRotation(this.golova, -1.152537f, 0.0f, 0.0f);
        this.kluv = new ModelRenderer(this, 12, 28);
        this.kluv.func_78789_a(0.0f, 0.0f, 0.0f, 1, 1, 2);
        this.kluv.func_78793_a(1.5f, 2.5f, -3.5f);
        this.kluv.func_78787_b(64, 32);
        this.kluv.field_78809_i = true;
        this.setRotation(this.kluv, 0.4461433f, 0.0f, 0.0f);
        this.chvost = new ModelRenderer(this, 40, 0);
        this.chvost.func_78789_a(0.0f, 0.0f, 0.0f, 4, 4, 1);
        this.chvost.func_78793_a(0.0f, -2.0f, 10.0f);
        this.chvost.func_78787_b(64, 32);
        this.chvost.field_78809_i = true;
        this.setRotation(this.chvost, -0.7435722f, 0.0f, 0.0f);
        this.chacti_krula1 = new ModelRenderer(this, 12, 9);
        this.chacti_krula1.func_78789_a(0.0f, 0.0f, 0.0f, 2, 2, 4);
        this.chacti_krula1.func_78793_a(-1.0f, 0.0f, 0.0f);
        this.chacti_krula1.func_78787_b(64, 32);
        this.chacti_krula1.field_78809_i = true;
        this.setRotation(this.chacti_krula1, 0.0f, 0.0f, 0.0f);
        this.chacti_krula2 = new ModelRenderer(this, 0, 9);
        this.chacti_krula2.func_78789_a(0.0f, 0.0f, 0.0f, 2, 2, 4);
        this.chacti_krula2.func_78793_a(3.0f, 0.0f, 0.0f);
        this.chacti_krula2.func_78787_b(64, 32);
        this.chacti_krula2.field_78809_i = true;
        this.setRotation(this.chacti_krula2, 0.0f, 0.0f, 0.0f);
        this.krulo = new ModelRenderer(this, 0, 0);
        this.krulo.func_78789_a(0.0f, 0.0f, 0.0f, 16, 1, 4);
        this.krulo.func_78793_a(-6.0f, 0.0f, 0.0f);
        this.krulo.func_78787_b(64, 32);
        this.krulo.field_78809_i = true;
        this.setRotation(this.krulo, 0.0f, 0.0f, 0.0f);
        this.chacti_krula3 = new ModelRenderer(this, 0, 5);
        this.chacti_krula3.func_78789_a(0.0f, 0.0f, 0.0f, 2, 1, 3);
        this.chacti_krula3.func_78793_a(-8.0f, 0.0f, 1.0f);
        this.chacti_krula3.func_78787_b(64, 32);
        this.chacti_krula3.field_78809_i = true;
        this.setRotation(this.chacti_krula3, 0.0f, 0.0f, 0.0f);
        this.chacti_krula4 = new ModelRenderer(this, 10, 5);
        this.chacti_krula4.func_78789_a(0.0f, 0.0f, 0.0f, 2, 1, 3);
        this.chacti_krula4.func_78793_a(10.0f, 0.0f, 1.0f);
        this.chacti_krula4.func_78787_b(64, 32);
        this.chacti_krula4.field_78809_i = true;
        this.setRotation(this.chacti_krula4, 0.0f, 0.0f, 0.0f);
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        super.func_78088_a(entity, f, f2, f3, f4, f5, f6);
        this.func_78087_a(f, f2, f3, f4, f5, f6, entity);
        this.brucho.func_78785_a(f6);
        this.tuloviche.func_78785_a(f6);
        this.golova.func_78785_a(f6);
        this.kluv.func_78785_a(f6);
        this.chvost.func_78785_a(f6);
        this.chacti_krula1.func_78785_a(f6);
        this.chacti_krula2.func_78785_a(f6);
        this.krulo.func_78785_a(f6);
        this.chacti_krula3.func_78785_a(f6);
        this.chacti_krula4.func_78785_a(f6);
    }

    private void setRotation(ModelRenderer modelRenderer, float f, float f2, float f3) {
        modelRenderer.field_78795_f = f;
        modelRenderer.field_78796_g = f2;
        modelRenderer.field_78808_h = f3;
    }

    @Override
    public void func_78087_a(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        super.func_78087_a(f, f2, f3, f4, f5, f6, entity);
    }
}

