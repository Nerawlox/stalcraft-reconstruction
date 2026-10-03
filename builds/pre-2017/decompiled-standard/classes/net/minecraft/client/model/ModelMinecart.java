/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMinecart
extends ModelBase {
    public ModelRenderer[] field_78154_a = new ModelRenderer[7];

    public ModelMinecart() {
        this.field_78154_a[0] = new ModelRenderer(this, 0, 10);
        this.field_78154_a[1] = new ModelRenderer(this, 0, 0);
        this.field_78154_a[2] = new ModelRenderer(this, 0, 0);
        this.field_78154_a[3] = new ModelRenderer(this, 0, 0);
        this.field_78154_a[4] = new ModelRenderer(this, 0, 0);
        this.field_78154_a[5] = new ModelRenderer(this, 44, 10);
        int n = 20;
        int n2 = 8;
        int n3 = 16;
        int n4 = 4;
        this.field_78154_a[0].func_78790_a(-n / 2, -n3 / 2, -1.0f, n, n3, 2, 0.0f);
        this.field_78154_a[0].func_78793_a(0.0f, n4, 0.0f);
        this.field_78154_a[5].func_78790_a(-n / 2 + 1, -n3 / 2 + 1, -1.0f, n - 2, n3 - 2, 1, 0.0f);
        this.field_78154_a[5].func_78793_a(0.0f, n4, 0.0f);
        this.field_78154_a[1].func_78790_a(-n / 2 + 2, -n2 - 1, -1.0f, n - 4, n2, 2, 0.0f);
        this.field_78154_a[1].func_78793_a(-n / 2 + 1, n4, 0.0f);
        this.field_78154_a[2].func_78790_a(-n / 2 + 2, -n2 - 1, -1.0f, n - 4, n2, 2, 0.0f);
        this.field_78154_a[2].func_78793_a(n / 2 - 1, n4, 0.0f);
        this.field_78154_a[3].func_78790_a(-n / 2 + 2, -n2 - 1, -1.0f, n - 4, n2, 2, 0.0f);
        this.field_78154_a[3].func_78793_a(0.0f, n4, -n3 / 2 + 1);
        this.field_78154_a[4].func_78790_a(-n / 2 + 2, -n2 - 1, -1.0f, n - 4, n2, 2, 0.0f);
        this.field_78154_a[4].func_78793_a(0.0f, n4, n3 / 2 - 1);
        this.field_78154_a[0].field_78795_f = 1.5707964f;
        this.field_78154_a[1].field_78796_g = 4.712389f;
        this.field_78154_a[2].field_78796_g = 1.5707964f;
        this.field_78154_a[3].field_78796_g = (float)Math.PI;
        this.field_78154_a[5].field_78795_f = -1.5707964f;
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        this.field_78154_a[5].field_78797_d = 4.0f - f3;
        for (int i = 0; i < 6; ++i) {
            this.field_78154_a[i].func_78785_a(f6);
        }
    }
}

