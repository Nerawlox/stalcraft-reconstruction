/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import java.util.Random;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.sajh;
import org.lwjgl.opengl.GL11;

public class ModelGhast
extends ModelBase {
    public ModelRenderer field_78128_a;
    public ModelRenderer[] field_78127_b = new ModelRenderer[9];

    public ModelGhast() {
        int n = -16;
        this.field_78128_a = new ModelRenderer(this, 0, 0);
        this.field_78128_a.func_78789_a(-8.0f, -8.0f, -8.0f, 16, 16, 16);
        this.field_78128_a.field_78797_d += (float)(24 + n);
        Random random = new Random(1660L);
        for (int i = 0; i < this.field_78127_b.length; ++i) {
            this.field_78127_b[i] = new ModelRenderer(this, 0, 0);
            float f = (((float)(i % 3) - (float)(i / 3 % 2) * 0.5f + 0.25f) / 2.0f * 2.0f - 1.0f) * 5.0f;
            float f2 = ((float)(i / 3) / 2.0f * 2.0f - 1.0f) * 5.0f;
            int n2 = random.nextInt(7) + 8;
            this.field_78127_b[i].func_78789_a(-1.0f, 0.0f, -1.0f, 2, n2, 2);
            this.field_78127_b[i].field_78800_c = f;
            this.field_78127_b[i].field_78798_e = f2;
            this.field_78127_b[i].field_78797_d = 31 + n;
        }
    }

    @Override
    public void func_78087_a(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        for (int i = 0; i < this.field_78127_b.length; ++i) {
            this.field_78127_b[i].field_78795_f = 0.2f * sajh._a(f3 * 0.3f + (float)i) + 0.4f;
        }
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        this.func_78087_a(f, f2, f3, f4, f5, f6, entity);
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0f, 0.6f, 0.0f);
        this.field_78128_a.func_78785_a(f6);
        for (ModelRenderer modelRenderer : this.field_78127_b) {
            modelRenderer.func_78785_a(f6);
        }
        GL11.glPopMatrix();
    }
}

