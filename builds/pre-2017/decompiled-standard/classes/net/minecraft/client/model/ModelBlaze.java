/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.sajh;

public class ModelBlaze
extends ModelBase {
    public ModelRenderer[] field_78106_a = new ModelRenderer[12];
    public ModelRenderer field_78105_b;

    public ModelBlaze() {
        for (int i = 0; i < this.field_78106_a.length; ++i) {
            this.field_78106_a[i] = new ModelRenderer(this, 0, 16);
            this.field_78106_a[i].func_78789_a(0.0f, 0.0f, 0.0f, 2, 8, 2);
        }
        this.field_78105_b = new ModelRenderer(this, 0, 0);
        this.field_78105_b.func_78789_a(-4.0f, -4.0f, -4.0f, 8, 8, 8);
    }

    public int func_78104_a() {
        return 8;
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        this.func_78087_a(f, f2, f3, f4, f5, f6, entity);
        this.field_78105_b.func_78785_a(f6);
        for (int i = 0; i < this.field_78106_a.length; ++i) {
            this.field_78106_a[i].func_78785_a(f6);
        }
    }

    @Override
    public void func_78087_a(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        int n;
        float f7 = f3 * (float)Math.PI * -0.1f;
        for (n = 0; n < 4; ++n) {
            this.field_78106_a[n].field_78797_d = -2.0f + sajh._b(((float)(n * 2) + f3) * 0.25f);
            this.field_78106_a[n].field_78800_c = sajh._b(f7) * 9.0f;
            this.field_78106_a[n].field_78798_e = sajh._a(f7) * 9.0f;
            f7 += 1.5707964f;
        }
        f7 = 0.7853982f + f3 * (float)Math.PI * 0.03f;
        for (n = 4; n < 8; ++n) {
            this.field_78106_a[n].field_78797_d = 2.0f + sajh._b(((float)(n * 2) + f3) * 0.25f);
            this.field_78106_a[n].field_78800_c = sajh._b(f7) * 7.0f;
            this.field_78106_a[n].field_78798_e = sajh._a(f7) * 7.0f;
            f7 += 1.5707964f;
        }
        f7 = 0.47123894f + f3 * (float)Math.PI * -0.05f;
        for (n = 8; n < 12; ++n) {
            this.field_78106_a[n].field_78797_d = 11.0f + sajh._b(((float)n * 1.5f + f3) * 0.5f);
            this.field_78106_a[n].field_78800_c = sajh._b(f7) * 5.0f;
            this.field_78106_a[n].field_78798_e = sajh._a(f7) * 5.0f;
            f7 += 1.5707964f;
        }
        this.field_78105_b.field_78796_g = f4 / 57.295776f;
        this.field_78105_b.field_78795_f = f5 / 57.295776f;
    }
}

