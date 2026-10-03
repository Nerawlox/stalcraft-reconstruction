/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.util.sajh;

public class ModelWither
extends ModelBase {
    public ModelRenderer[] field_82905_a;
    public ModelRenderer[] field_82904_b;

    public ModelWither() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.field_82905_a = new ModelRenderer[3];
        this.field_82905_a[0] = new ModelRenderer(this, 0, 16);
        this.field_82905_a[0].func_78789_a(-10.0f, 3.9f, -0.5f, 20, 3, 3);
        this.field_82905_a[1] = new ModelRenderer(this).func_78787_b(this.field_78090_t, this.field_78089_u);
        this.field_82905_a[1].func_78793_a(-2.0f, 6.9f, -0.5f);
        this.field_82905_a[1].func_78784_a(0, 22).func_78789_a(0.0f, 0.0f, 0.0f, 3, 10, 3);
        this.field_82905_a[1].func_78784_a(24, 22).func_78789_a(-4.0f, 1.5f, 0.5f, 11, 2, 2);
        this.field_82905_a[1].func_78784_a(24, 22).func_78789_a(-4.0f, 4.0f, 0.5f, 11, 2, 2);
        this.field_82905_a[1].func_78784_a(24, 22).func_78789_a(-4.0f, 6.5f, 0.5f, 11, 2, 2);
        this.field_82905_a[2] = new ModelRenderer(this, 12, 22);
        this.field_82905_a[2].func_78789_a(0.0f, 0.0f, 0.0f, 3, 6, 3);
        this.field_82904_b = new ModelRenderer[3];
        this.field_82904_b[0] = new ModelRenderer(this, 0, 0);
        this.field_82904_b[0].func_78789_a(-4.0f, -4.0f, -4.0f, 8, 8, 8);
        this.field_82904_b[1] = new ModelRenderer(this, 32, 0);
        this.field_82904_b[1].func_78789_a(-4.0f, -4.0f, -4.0f, 6, 6, 6);
        this.field_82904_b[1].field_78800_c = -8.0f;
        this.field_82904_b[1].field_78797_d = 4.0f;
        this.field_82904_b[2] = new ModelRenderer(this, 32, 0);
        this.field_82904_b[2].func_78789_a(-4.0f, -4.0f, -4.0f, 6, 6, 6);
        this.field_82904_b[2].field_78800_c = 10.0f;
        this.field_82904_b[2].field_78797_d = 4.0f;
    }

    public int func_82903_a() {
        return 32;
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        this.func_78087_a(f, f2, f3, f4, f5, f6, entity);
        for (ModelRenderer modelRenderer : this.field_82904_b) {
            modelRenderer.func_78785_a(f6);
        }
        for (ModelRenderer modelRenderer : this.field_82905_a) {
            modelRenderer.func_78785_a(f6);
        }
    }

    @Override
    public void func_78087_a(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        float f7 = sajh._b(f3 * 0.1f);
        this.field_82905_a[1].field_78795_f = (0.065f + 0.05f * f7) * (float)Math.PI;
        this.field_82905_a[2].func_78793_a(-2.0f, 6.9f + sajh._b(this.field_82905_a[1].field_78795_f) * 10.0f, -0.5f + sajh._a(this.field_82905_a[1].field_78795_f) * 10.0f);
        this.field_82905_a[2].field_78795_f = (0.265f + 0.1f * f7) * (float)Math.PI;
        this.field_82904_b[0].field_78796_g = f4 / 57.295776f;
        this.field_82904_b[0].field_78795_f = f5 / 57.295776f;
    }

    @Override
    public void func_78086_a(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        EntityWither entityWither = (EntityWither)entityLivingBase;
        for (int i = 1; i < 3; ++i) {
            this.field_82904_b[i].field_78796_g = (entityWither.func_82207_a(i - 1) - entityLivingBase.field_70761_aq) / 57.295776f;
            this.field_82904_b[i].field_78795_f = entityWither.func_82210_r(i - 1) / 57.295776f;
        }
    }
}

