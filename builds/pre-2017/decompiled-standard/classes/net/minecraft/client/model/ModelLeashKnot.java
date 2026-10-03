/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLeashKnot
extends ModelBase {
    public ModelRenderer field_110723_a;

    public ModelLeashKnot() {
        this(0, 0, 32, 32);
    }

    public ModelLeashKnot(int n, int n2, int n3, int n4) {
        this.field_78090_t = n3;
        this.field_78089_u = n4;
        this.field_110723_a = new ModelRenderer(this, n, n2);
        this.field_110723_a.func_78790_a(-3.0f, -6.0f, -3.0f, 6, 8, 6, 0.0f);
        this.field_110723_a.func_78793_a(0.0f, 0.0f, 0.0f);
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        this.func_78087_a(f, f2, f3, f4, f5, f6, entity);
        this.field_110723_a.func_78785_a(f6);
    }

    @Override
    public void func_78087_a(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        super.func_78087_a(f, f2, f3, f4, f5, f6, entity);
        this.field_110723_a.field_78796_g = f4 / 57.295776f;
        this.field_110723_a.field_78795_f = f5 / 57.295776f;
    }
}

