/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.sajh;

public class ModelSilverfish
extends ModelBase {
    public ModelRenderer[] field_78171_a;
    public ModelRenderer[] field_78169_b;
    public float[] field_78170_c = new float[7];
    public static final int[][] field_78167_d = new int[][]{{3, 2, 2}, {4, 3, 2}, {6, 4, 3}, {3, 3, 3}, {2, 2, 3}, {2, 1, 2}, {1, 1, 2}};
    public static final int[][] field_78168_e = new int[][]{{0, 0}, {0, 4}, {0, 9}, {0, 16}, {0, 22}, {11, 0}, {13, 4}};

    public ModelSilverfish() {
        this.field_78171_a = new ModelRenderer[7];
        float f = -3.5f;
        for (int i = 0; i < this.field_78171_a.length; ++i) {
            this.field_78171_a[i] = new ModelRenderer(this, field_78168_e[i][0], field_78168_e[i][1]);
            this.field_78171_a[i].func_78789_a((float)field_78167_d[i][0] * -0.5f, 0.0f, (float)field_78167_d[i][2] * -0.5f, field_78167_d[i][0], field_78167_d[i][1], field_78167_d[i][2]);
            this.field_78171_a[i].func_78793_a(0.0f, 24 - field_78167_d[i][1], f);
            this.field_78170_c[i] = f;
            if (i >= this.field_78171_a.length - 1) continue;
            f += (float)(field_78167_d[i][2] + field_78167_d[i + 1][2]) * 0.5f;
        }
        this.field_78169_b = new ModelRenderer[3];
        this.field_78169_b[0] = new ModelRenderer(this, 20, 0);
        this.field_78169_b[0].func_78789_a(-5.0f, 0.0f, (float)field_78167_d[2][2] * -0.5f, 10, 8, field_78167_d[2][2]);
        this.field_78169_b[0].func_78793_a(0.0f, 16.0f, this.field_78170_c[2]);
        this.field_78169_b[1] = new ModelRenderer(this, 20, 11);
        this.field_78169_b[1].func_78789_a(-3.0f, 0.0f, (float)field_78167_d[4][2] * -0.5f, 6, 4, field_78167_d[4][2]);
        this.field_78169_b[1].func_78793_a(0.0f, 20.0f, this.field_78170_c[4]);
        this.field_78169_b[2] = new ModelRenderer(this, 20, 18);
        this.field_78169_b[2].func_78789_a(-3.0f, 0.0f, (float)field_78167_d[4][2] * -0.5f, 6, 5, field_78167_d[1][2]);
        this.field_78169_b[2].func_78793_a(0.0f, 19.0f, this.field_78170_c[1]);
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        int n;
        this.func_78087_a(f, f2, f3, f4, f5, f6, entity);
        for (n = 0; n < this.field_78171_a.length; ++n) {
            this.field_78171_a[n].func_78785_a(f6);
        }
        for (n = 0; n < this.field_78169_b.length; ++n) {
            this.field_78169_b[n].func_78785_a(f6);
        }
    }

    @Override
    public void func_78087_a(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        for (int i = 0; i < this.field_78171_a.length; ++i) {
            this.field_78171_a[i].field_78796_g = sajh._b(f3 * 0.9f + (float)i * 0.15f * (float)Math.PI) * (float)Math.PI * 0.05f * (float)(1 + Math.abs(i - 2));
            this.field_78171_a[i].field_78800_c = sajh._a(f3 * 0.9f + (float)i * 0.15f * (float)Math.PI) * (float)Math.PI * 0.2f * (float)Math.abs(i - 2);
        }
        this.field_78169_b[0].field_78796_g = this.field_78171_a[2].field_78796_g;
        this.field_78169_b[1].field_78796_g = this.field_78171_a[4].field_78796_g;
        this.field_78169_b[1].field_78800_c = this.field_78171_a[4].field_78800_c;
        this.field_78169_b[2].field_78796_g = this.field_78171_a[1].field_78796_g;
        this.field_78169_b[2].field_78800_c = this.field_78171_a[1].field_78800_c;
    }
}

