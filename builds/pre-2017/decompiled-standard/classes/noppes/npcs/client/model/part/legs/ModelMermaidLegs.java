/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model.part.legs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.sajh;

public class ModelMermaidLegs
extends ModelRenderer {
    ModelRenderer top;
    ModelRenderer middle;
    ModelRenderer bottom;
    ModelRenderer fin1;
    ModelRenderer fin2;

    public ModelMermaidLegs(ModelBase modelBase) {
        super(modelBase);
        this.field_78801_a = 64.0f;
        this.field_78799_b = 32.0f;
        this.top = new ModelRenderer(modelBase, 0, 16);
        this.top.func_78789_a(-2.0f, -2.5f, -2.0f, 8, 9, 4);
        this.top.func_78793_a(-2.0f, 14.0f, 1.0f);
        this.setRotation(this.top, 0.26f, 0.0f, 0.0f);
        this.middle = new ModelRenderer(modelBase, 28, 0);
        this.middle.func_78789_a(0.0f, 0.0f, 0.0f, 7, 6, 4);
        this.middle.func_78793_a(-1.5f, 6.5f, -1.0f);
        this.setRotation(this.middle, 0.86f, 0.0f, 0.0f);
        this.top.func_78792_a(this.middle);
        this.bottom = new ModelRenderer(modelBase, 24, 16);
        this.bottom.func_78789_a(0.0f, 0.0f, 0.0f, 6, 7, 3);
        this.bottom.func_78793_a(0.5f, 6.0f, 0.5f);
        this.setRotation(this.bottom, 0.15f, 0.0f, 0.0f);
        this.middle.func_78792_a(this.bottom);
        this.fin1 = new ModelRenderer(modelBase, 0, 0);
        this.fin1.func_78789_a(0.0f, 0.0f, 0.0f, 5, 9, 1);
        this.fin1.func_78793_a(0.0f, 4.5f, 1.0f);
        this.setRotation(this.fin1, 0.05f, 0.0f, 0.5911399f);
        this.bottom.func_78792_a(this.fin1);
        this.fin2 = new ModelRenderer(modelBase, 0, 0);
        this.fin2.field_78809_i = true;
        this.fin2.func_78789_a(-5.0f, 0.0f, 0.0f, 5, 9, 1);
        this.fin2.func_78793_a(6.0f, 4.5f, 1.0f);
        this.setRotation(this.fin2, 0.05f, 0.0f, -0.591143f);
        this.bottom.func_78792_a(this.fin2);
    }

    @Override
    public void func_78785_a(float f) {
        if (!this.field_78807_k && this.field_78806_j) {
            this.top.func_78785_a(f);
        }
    }

    private void setRotation(ModelRenderer modelRenderer, float f, float f2, float f3) {
        modelRenderer.field_78795_f = f;
        modelRenderer.field_78796_g = f2;
        modelRenderer.field_78808_h = f3;
    }

    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        float f7 = sajh._a(f * 0.6662f);
        if ((double)f7 > 0.2) {
            f7 /= 3.0f;
        }
        this.top.field_78795_f = 0.26f - f7 * 0.2f * f2;
        this.middle.field_78795_f = 0.86f - f7 * 0.24f * f2;
        this.bottom.field_78795_f = 0.15f - f7 * 0.28f * f2;
        this.fin2.field_78795_f = this.fin1.field_78795_f = 0.05f - f7 * 0.35f * f2;
    }
}

