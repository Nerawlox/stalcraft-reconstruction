/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelChest
extends ModelBase {
    public ModelRenderer field_78234_a = new ModelRenderer(this, 0, 0).func_78787_b(64, 64);
    public ModelRenderer field_78232_b;
    public ModelRenderer field_78233_c;

    public ModelChest() {
        this.field_78234_a.func_78790_a(0.0f, -5.0f, -14.0f, 14, 5, 14, 0.0f);
        this.field_78234_a.field_78800_c = 1.0f;
        this.field_78234_a.field_78797_d = 7.0f;
        this.field_78234_a.field_78798_e = 15.0f;
        this.field_78233_c = new ModelRenderer(this, 0, 0).func_78787_b(64, 64);
        this.field_78233_c.func_78790_a(-1.0f, -2.0f, -15.0f, 2, 4, 1, 0.0f);
        this.field_78233_c.field_78800_c = 8.0f;
        this.field_78233_c.field_78797_d = 7.0f;
        this.field_78233_c.field_78798_e = 15.0f;
        this.field_78232_b = new ModelRenderer(this, 0, 19).func_78787_b(64, 64);
        this.field_78232_b.func_78790_a(0.0f, 0.0f, 0.0f, 14, 10, 14, 0.0f);
        this.field_78232_b.field_78800_c = 1.0f;
        this.field_78232_b.field_78797_d = 6.0f;
        this.field_78232_b.field_78798_e = 1.0f;
    }

    public void func_78231_a() {
        this.field_78233_c.field_78795_f = this.field_78234_a.field_78795_f;
        this.field_78234_a.func_78785_a(0.0625f);
        this.field_78233_c.func_78785_a(0.0625f);
        this.field_78232_b.func_78785_a(0.0625f);
    }
}

