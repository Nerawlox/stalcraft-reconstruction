/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.ModelQuadruped;
import net.minecraft.client.model.ModelRenderer;

public class ModelCow
extends ModelQuadruped {
    public ModelCow() {
        super(12, 0.0f);
        this.field_78150_a = new ModelRenderer(this, 0, 0);
        this.field_78150_a.func_78790_a(-4.0f, -4.0f, -6.0f, 8, 8, 6, 0.0f);
        this.field_78150_a.func_78793_a(0.0f, 4.0f, -8.0f);
        this.field_78150_a.func_78784_a(22, 0).func_78790_a(-5.0f, -5.0f, -4.0f, 1, 3, 1, 0.0f);
        this.field_78150_a.func_78784_a(22, 0).func_78790_a(4.0f, -5.0f, -4.0f, 1, 3, 1, 0.0f);
        this.field_78148_b = new ModelRenderer(this, 18, 4);
        this.field_78148_b.func_78790_a(-6.0f, -10.0f, -7.0f, 12, 18, 10, 0.0f);
        this.field_78148_b.func_78793_a(0.0f, 5.0f, 2.0f);
        this.field_78148_b.func_78784_a(52, 0).func_78789_a(-2.0f, 2.0f, -8.0f, 4, 6, 1);
        this.field_78149_c.field_78800_c -= 1.0f;
        this.field_78146_d.field_78800_c += 1.0f;
        this.field_78149_c.field_78798_e += 0.0f;
        this.field_78146_d.field_78798_e += 0.0f;
        this.field_78147_e.field_78800_c -= 1.0f;
        this.field_78144_f.field_78800_c += 1.0f;
        this.field_78147_e.field_78798_e -= 1.0f;
        this.field_78144_f.field_78798_e -= 1.0f;
        this.field_78151_h += 2.0f;
    }
}

