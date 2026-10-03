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
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        this.hvost2 = new ModelRenderer(this, 12, 0);
        this.hvost2.func_78789_a(0.0f, 0.0f, 0.0f, 1, 5, 1);
        this.hvost2.func_78793_a(-1.0f, 20.0f, 3.0f);
        this.hvost2.func_78787_b(64, 32);
        this.hvost2.field_78809_i = true;
        this.setRotation(this.hvost2, -1.814316f, 0.0f, 0.0f);
        this.hvost1 = new ModelRenderer(this, 16, 0);
        this.hvost1.func_78789_a(0.0f, 0.0f, 0.0f, 1, 5, 1);
        this.hvost1.func_78793_a(-1.0f, 20.0f, 7.0f);
        this.hvost1.func_78787_b(64, 32);
        this.hvost1.field_78809_i = true;
        this.setRotation(this.hvost1, -1.606116f, 0.0f, 0.0f);
        this.uxo2 = new ModelRenderer(this, 30, 0);
        this.uxo2.func_78789_a(-1.0f, 0.0f, 0.0f, 2, 2, 1);
        this.uxo2.func_78793_a(1.0f, 13.0f, -9.0f);
        this.uxo2.func_78787_b(64, 32);
        this.uxo2.field_78809_i = true;
        this.setRotation(this.uxo2, 0.0f, 0.0f, 0.0f);
        this.uxo1 = new ModelRenderer(this, 36, 0);
        this.uxo1.func_78789_a(-1.0f, 0.0f, 0.0f, 2, 2, 1);
        this.uxo1.func_78793_a(-2.0f, 13.0f, -9.0f);
        this.uxo1.func_78787_b(64, 32);
        this.uxo1.field_78809_i = true;
        this.setRotation(this.uxo1, 0.0f, 0.0f, 0.0f);
        this.bedro2 = new ModelRenderer(this, 9, 19);
        this.bedro2.func_78789_a(0.0f, 0.0f, 0.0f, 1, 3, 2);
        this.bedro2.func_78793_a(1.0f, 19.0f, -3.0f);
        this.bedro2.func_78787_b(64, 32);
        this.bedro2.field_78809_i = true;
        this.setRotation(this.bedro2, -0.8625438f, 0.0f, 0.0f);
        this.bedro1 = new ModelRenderer(this, 9, 19);
        this.bedro1.func_78789_a(0.0f, 0.0f, 0.0f, 1, 3, 2);
        this.bedro1.func_78793_a(-3.0f, 19.0f, -3.0f);
        this.bedro1.func_78787_b(64, 32);
        this.bedro1.field_78809_i = true;
        this.setRotation(this.bedro1, -0.8625438f, 0.0f, 0.0f);
        this.noga2 = new ModelRenderer(this, 9, 19);
        this.noga2.func_78789_a(0.0f, -2.0f, 0.0f, 1, 3, 1);
        this.noga2.func_78793_a(1.0f, 23.0f, -4.0f);
        this.noga2.func_78787_b(64, 32);
        this.noga2.field_78809_i = true;
        this.setRotation(this.noga2, 0.803058f, 0.0f, 0.0f);
        this.noga1 = new ModelRenderer(this, 9, 19);
        this.noga1.func_78789_a(0.0f, -2.0f, 0.0f, 1, 3, 1);
        this.noga1.func_78793_a(-3.0f, 23.0f, -4.0f);
        this.noga1.func_78787_b(64, 32);
        this.noga1.field_78809_i = true;
        this.setRotation(this.noga1, 0.803058f, 0.0f, 0.0f);
        this.kisti1 = new ModelRenderer(this, 9, 19);
        this.kisti1.func_78789_a(0.0f, 0.0f, 0.0f, 1, 3, 1);
        this.kisti1.func_78793_a(-3.0f, 17.0f, -8.0f);
        this.kisti1.func_78787_b(64, 32);
        this.kisti1.field_78809_i = true;
        this.setRotation(this.kisti1, 0.0f, 0.0f, 0.0f);
        this.kisti2 = new ModelRenderer(this, 9, 19);
        this.kisti2.func_78789_a(0.0f, 0.0f, 0.0f, 1, 3, 1);
        this.kisti2.func_78793_a(1.0f, 17.0f, -8.0f);
        this.kisti2.func_78787_b(64, 32);
        this.kisti2.field_78809_i = true;
        this.setRotation(this.kisti2, 0.0f, 0.0f, 0.0f);
        this.lapka1 = new ModelRenderer(this, 9, 25);
        this.lapka1.func_78789_a(0.0f, 0.0f, 0.0f, 1, 1, 3);
        this.lapka1.func_78793_a(-2.0f, 23.0f, -3.0f);
        this.lapka1.func_78787_b(64, 32);
        this.lapka1.field_78809_i = true;
        this.setRotation(this.lapka1, -0.1487144f, -3.141593f, 0.0f);
        this.lapka2 = new ModelRenderer(this, 9, 25);
        this.lapka2.func_78789_a(0.0f, 0.0f, 0.0f, 1, 1, 3);
        this.lapka2.func_78793_a(2.0f, 23.0f, -3.0f);
        this.lapka2.func_78787_b(64, 32);
        this.lapka2.field_78809_i = true;
        this.setRotation(this.lapka2, -0.1487144f, -3.141593f, 0.0f);
        this.lapa1 = new ModelRenderer(this, 9, 19);
        this.lapa1.func_78789_a(0.0f, 0.0f, 0.0f, 1, 3, 1);
        this.lapa1.func_78793_a(-3.0f, 19.0f, -8.0f);
        this.lapa1.func_78787_b(64, 32);
        this.lapa1.field_78809_i = true;
        this.setRotation(this.lapa1, -1.041001f, 0.0f, 0.0f);
        this.lapa2 = new ModelRenderer(this, 9, 19);
        this.lapa2.func_78789_a(0.0f, 0.0f, 0.0f, 1, 3, 1);
        this.lapa2.func_78793_a(1.0f, 19.0f, -8.0f);
        this.lapa2.func_78787_b(64, 32);
        this.lapa2.field_78809_i = true;
        this.setRotation(this.lapa2, -1.041001f, 0.0f, 0.0f);
        this.golova = new ModelRenderer(this, 0, 0);
        this.golova.func_78789_a(-2.0f, -2.0f, -1.0f, 3, 4, 3);
        this.golova.func_78793_a(0.0f, 16.0f, -10.0f);
        this.golova.func_78787_b(64, 32);
        this.golova.field_78809_i = true;
        this.setRotation(this.golova, 0.0f, 0.0f, 0.0f);
        this.tuloviche = new ModelRenderer(this, 0, 19);
        this.tuloviche.func_78789_a(-5.0f, -4.0f, -6.0f, 3, 3, 9);
        this.tuloviche.func_78793_a(3.0f, 21.0f, -5.0f);
        this.tuloviche.func_78787_b(64, 32);
        this.tuloviche.field_78809_i = true;
        this.setRotation(this.tuloviche, -0.6840864f, 0.0f, 0.0f);
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        super.func_78088_a(entity, f, f2, f3, f4, f5, f6);
        this.func_78087_a(f, f2, f3, f4, f5, f6, entity);
        this.hvost2.func_78785_a(f6);
        this.hvost1.func_78785_a(f6);
        this.uxo2.func_78785_a(f6);
        this.uxo1.func_78785_a(f6);
        this.bedro2.func_78785_a(f6);
        this.bedro1.func_78785_a(f6);
        this.noga2.func_78785_a(f6);
        this.noga1.func_78785_a(f6);
        this.kisti1.func_78785_a(f6);
        this.kisti2.func_78785_a(f6);
        this.lapka1.func_78785_a(f6);
        this.lapka2.func_78785_a(f6);
        this.lapa1.func_78785_a(f6);
        this.lapa2.func_78785_a(f6);
        this.golova.func_78785_a(f6);
        this.tuloviche.func_78785_a(f6);
    }

    private void setRotation(ModelRenderer modelRenderer, float f, float f2, float f3) {
        modelRenderer.field_78795_f = f;
        modelRenderer.field_78796_g = f2;
        modelRenderer.field_78808_h = f3;
    }

    @Override
    public void func_78087_a(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        super.func_78087_a(f, f2, f3, f4, f5, f6, entity);
        float f7 = sajh._b(f * 0.6662f) * 2.0f * f2 * 0.5f;
        float f8 = sajh._b(f * 0.6662f + (float)Math.PI) * 2.0f * f2 * 0.5f;
        this.golova.field_78796_g = f4 / 57.295776f;
        this.uxo1.field_78795_f = this.golova.field_78795_f = f5 / 57.295776f;
        this.uxo2.field_78795_f = this.golova.field_78795_f;
        this.uxo1.field_78796_g = this.golova.field_78796_g;
        this.uxo2.field_78796_g = this.golova.field_78796_g;
        this.uxo1.field_78808_h = this.golova.field_78808_h;
        this.uxo2.field_78808_h = this.golova.field_78808_h;
        this.bedro1.field_78795_f = f7;
        this.bedro1.field_78808_h = 0.0f;
        this.noga1.field_78795_f = -this.bedro1.field_78795_f;
        this.noga1.field_78808_h = 0.0f;
        this.bedro2.field_78795_f = f8;
        this.bedro2.field_78808_h = 0.0f;
        this.noga2.field_78795_f = -this.bedro2.field_78795_f;
        this.noga2.field_78808_h = 0.0f;
        this.lapka1.field_78795_f = f7;
        this.lapka1.field_78808_h = 0.0f;
        this.lapka2.field_78795_f = -this.lapka1.field_78795_f;
        this.lapka2.field_78808_h = 0.0f;
    }
}

