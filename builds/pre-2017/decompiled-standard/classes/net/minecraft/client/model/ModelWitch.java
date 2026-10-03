/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelVillager;
import net.minecraft.entity.Entity;
import net.minecraft.util.sajh;

public class ModelWitch
extends ModelVillager {
    public boolean field_82900_g;
    public ModelRenderer field_82901_h = new ModelRenderer(this).func_78787_b(64, 128);
    public ModelRenderer field_82902_i;

    public ModelWitch(float f) {
        super(f, 0.0f, 64, 128);
        this.field_82901_h.func_78793_a(0.0f, -2.0f, 0.0f);
        this.field_82901_h.func_78784_a(0, 0).func_78790_a(0.0f, 3.0f, -6.75f, 1, 1, 1, -0.25f);
        this.field_82898_f.func_78792_a(this.field_82901_h);
        this.field_82902_i = new ModelRenderer(this).func_78787_b(64, 128);
        this.field_82902_i.func_78793_a(-5.0f, -10.03125f, -5.0f);
        this.field_82902_i.func_78784_a(0, 64).func_78789_a(0.0f, 0.0f, 0.0f, 10, 2, 10);
        this.field_78191_a.func_78792_a(this.field_82902_i);
        ModelRenderer modelRenderer = new ModelRenderer(this).func_78787_b(64, 128);
        modelRenderer.func_78793_a(1.75f, -4.0f, 2.0f);
        modelRenderer.func_78784_a(0, 76).func_78789_a(0.0f, 0.0f, 0.0f, 7, 4, 7);
        modelRenderer.field_78795_f = -0.05235988f;
        modelRenderer.field_78808_h = 0.02617994f;
        this.field_82902_i.func_78792_a(modelRenderer);
        ModelRenderer modelRenderer2 = new ModelRenderer(this).func_78787_b(64, 128);
        modelRenderer2.func_78793_a(1.75f, -4.0f, 2.0f);
        modelRenderer2.func_78784_a(0, 87).func_78789_a(0.0f, 0.0f, 0.0f, 4, 4, 4);
        modelRenderer2.field_78795_f = -0.10471976f;
        modelRenderer2.field_78808_h = 0.05235988f;
        modelRenderer.func_78792_a(modelRenderer2);
        ModelRenderer modelRenderer3 = new ModelRenderer(this).func_78787_b(64, 128);
        modelRenderer3.func_78793_a(1.75f, -2.0f, 2.0f);
        modelRenderer3.func_78784_a(0, 95).func_78790_a(0.0f, 0.0f, 0.0f, 1, 2, 1, 0.25f);
        modelRenderer3.field_78795_f = -0.20943952f;
        modelRenderer3.field_78808_h = 0.10471976f;
        modelRenderer2.func_78792_a(modelRenderer3);
    }

    @Override
    public void func_78087_a(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        super.func_78087_a(f, f2, f3, f4, f5, f6, entity);
        this.field_82898_f.field_82907_q = 0.0f;
        this.field_82898_f.field_82908_p = 0.0f;
        this.field_82898_f.field_82906_o = 0.0f;
        float f7 = 0.01f * (float)(entity.field_70157_k % 10);
        this.field_82898_f.field_78795_f = sajh._a((float)entity.field_70173_aa * f7) * 4.5f * (float)Math.PI / 180.0f;
        this.field_82898_f.field_78796_g = 0.0f;
        this.field_82898_f.field_78808_h = sajh._b((float)entity.field_70173_aa * f7) * 2.5f * (float)Math.PI / 180.0f;
        if (this.field_82900_g) {
            this.field_82898_f.field_78795_f = -0.9f;
            this.field_82898_f.field_82907_q = -0.09375f;
            this.field_82898_f.field_82908_p = 0.1875f;
        }
    }
}

