/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.ModelChest;
import net.minecraft.client.model.ModelRenderer;

public class ModelLargeChest
extends ModelChest {
    public ModelLargeChest() {
        this.field_78234_a = new ModelRenderer(this, 0, 0).func_78787_b(128, 64);
        this.field_78234_a.func_78790_a(0.0f, -5.0f, -14.0f, 30, 5, 14, 0.0f);
        this.field_78234_a.field_78800_c = 1.0f;
        this.field_78234_a.field_78797_d = 7.0f;
        this.field_78234_a.field_78798_e = 15.0f;
        this.field_78233_c = new ModelRenderer(this, 0, 0).func_78787_b(128, 64);
        this.field_78233_c.func_78790_a(-1.0f, -2.0f, -15.0f, 2, 4, 1, 0.0f);
        this.field_78233_c.field_78800_c = 16.0f;
        this.field_78233_c.field_78797_d = 7.0f;
        this.field_78233_c.field_78798_e = 15.0f;
        this.field_78232_b = new ModelRenderer(this, 0, 19).func_78787_b(128, 64);
        this.field_78232_b.func_78790_a(0.0f, 0.0f, 0.0f, 30, 10, 14, 0.0f);
        this.field_78232_b.field_78800_c = 1.0f;
        this.field_78232_b.field_78797_d = 6.0f;
        this.field_78232_b.field_78798_e = 1.0f;
    }
}

