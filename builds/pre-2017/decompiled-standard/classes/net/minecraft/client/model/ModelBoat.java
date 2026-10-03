/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBoat
extends ModelBase {
    public ModelRenderer[] field_78103_a = new ModelRenderer[5];

    public ModelBoat() {
        this.field_78103_a[0] = new ModelRenderer(this, 0, 8);
        this.field_78103_a[1] = new ModelRenderer(this, 0, 0);
        this.field_78103_a[2] = new ModelRenderer(this, 0, 0);
        this.field_78103_a[3] = new ModelRenderer(this, 0, 0);
        this.field_78103_a[4] = new ModelRenderer(this, 0, 0);
        int n = 24;
        int n2 = 6;
        int n3 = 20;
        int n4 = 4;
        this.field_78103_a[0].func_78790_a(-n / 2, -n3 / 2 + 2, -3.0f, n, n3 - 4, 4, 0.0f);
        this.field_78103_a[0].func_78793_a(0.0f, n4, 0.0f);
        this.field_78103_a[1].func_78790_a(-n / 2 + 2, -n2 - 1, -1.0f, n - 4, n2, 2, 0.0f);
        this.field_78103_a[1].func_78793_a(-n / 2 + 1, n4, 0.0f);
        this.field_78103_a[2].func_78790_a(-n / 2 + 2, -n2 - 1, -1.0f, n - 4, n2, 2, 0.0f);
        this.field_78103_a[2].func_78793_a(n / 2 - 1, n4, 0.0f);
        this.field_78103_a[3].func_78790_a(-n / 2 + 2, -n2 - 1, -1.0f, n - 4, n2, 2, 0.0f);
        this.field_78103_a[3].func_78793_a(0.0f, n4, -n3 / 2 + 1);
        this.field_78103_a[4].func_78790_a(-n / 2 + 2, -n2 - 1, -1.0f, n - 4, n2, 2, 0.0f);
        this.field_78103_a[4].func_78793_a(0.0f, n4, n3 / 2 - 1);
        this.field_78103_a[0].field_78795_f = 1.5707964f;
        this.field_78103_a[1].field_78796_g = 4.712389f;
        this.field_78103_a[2].field_78796_g = 1.5707964f;
        this.field_78103_a[3].field_78796_g = (float)Math.PI;
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        for (int i = 0; i < 5; ++i) {
            this.field_78103_a[i].func_78785_a(f6);
        }
    }
}

