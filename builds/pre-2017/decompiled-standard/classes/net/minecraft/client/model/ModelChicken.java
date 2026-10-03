/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.sajh;
import org.lwjgl.opengl.GL11;

public class ModelChicken
extends ModelBase {
    public ModelRenderer field_78142_a;
    public ModelRenderer field_78140_b;
    public ModelRenderer field_78141_c;
    public ModelRenderer field_78138_d;
    public ModelRenderer field_78139_e;
    public ModelRenderer field_78136_f;
    public ModelRenderer field_78137_g;
    public ModelRenderer field_78143_h;

    public ModelChicken() {
        int n = 16;
        this.field_78142_a = new ModelRenderer(this, 0, 0);
        this.field_78142_a.func_78790_a(-2.0f, -6.0f, -2.0f, 4, 6, 3, 0.0f);
        this.field_78142_a.func_78793_a(0.0f, -1 + n, -4.0f);
        this.field_78137_g = new ModelRenderer(this, 14, 0);
        this.field_78137_g.func_78790_a(-2.0f, -4.0f, -4.0f, 4, 2, 2, 0.0f);
        this.field_78137_g.func_78793_a(0.0f, -1 + n, -4.0f);
        this.field_78143_h = new ModelRenderer(this, 14, 4);
        this.field_78143_h.func_78790_a(-1.0f, -2.0f, -3.0f, 2, 2, 2, 0.0f);
        this.field_78143_h.func_78793_a(0.0f, -1 + n, -4.0f);
        this.field_78140_b = new ModelRenderer(this, 0, 9);
        this.field_78140_b.func_78790_a(-3.0f, -4.0f, -3.0f, 6, 8, 6, 0.0f);
        this.field_78140_b.func_78793_a(0.0f, n, 0.0f);
        this.field_78141_c = new ModelRenderer(this, 26, 0);
        this.field_78141_c.func_78789_a(-1.0f, 0.0f, -3.0f, 3, 5, 3);
        this.field_78141_c.func_78793_a(-2.0f, 3 + n, 1.0f);
        this.field_78138_d = new ModelRenderer(this, 26, 0);
        this.field_78138_d.func_78789_a(-1.0f, 0.0f, -3.0f, 3, 5, 3);
        this.field_78138_d.func_78793_a(1.0f, 3 + n, 1.0f);
        this.field_78139_e = new ModelRenderer(this, 24, 13);
        this.field_78139_e.func_78789_a(0.0f, 0.0f, -3.0f, 1, 4, 6);
        this.field_78139_e.func_78793_a(-4.0f, -3 + n, 0.0f);
        this.field_78136_f = new ModelRenderer(this, 24, 13);
        this.field_78136_f.func_78789_a(-1.0f, 0.0f, -3.0f, 1, 4, 6);
        this.field_78136_f.func_78793_a(4.0f, -3 + n, 0.0f);
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        this.func_78087_a(f, f2, f3, f4, f5, f6, entity);
        if (this.field_78091_s) {
            float f7 = 2.0f;
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0f, 5.0f * f6, 2.0f * f6);
            this.field_78142_a.func_78785_a(f6);
            this.field_78137_g.func_78785_a(f6);
            this.field_78143_h.func_78785_a(f6);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(1.0f / f7, 1.0f / f7, 1.0f / f7);
            GL11.glTranslatef(0.0f, 24.0f * f6, 0.0f);
            this.field_78140_b.func_78785_a(f6);
            this.field_78141_c.func_78785_a(f6);
            this.field_78138_d.func_78785_a(f6);
            this.field_78139_e.func_78785_a(f6);
            this.field_78136_f.func_78785_a(f6);
            GL11.glPopMatrix();
        } else {
            this.field_78142_a.func_78785_a(f6);
            this.field_78137_g.func_78785_a(f6);
            this.field_78143_h.func_78785_a(f6);
            this.field_78140_b.func_78785_a(f6);
            this.field_78141_c.func_78785_a(f6);
            this.field_78138_d.func_78785_a(f6);
            this.field_78139_e.func_78785_a(f6);
            this.field_78136_f.func_78785_a(f6);
        }
    }

    @Override
    public void func_78087_a(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        this.field_78142_a.field_78795_f = f5 / 57.295776f;
        this.field_78142_a.field_78796_g = f4 / 57.295776f;
        this.field_78137_g.field_78795_f = this.field_78142_a.field_78795_f;
        this.field_78137_g.field_78796_g = this.field_78142_a.field_78796_g;
        this.field_78143_h.field_78795_f = this.field_78142_a.field_78795_f;
        this.field_78143_h.field_78796_g = this.field_78142_a.field_78796_g;
        this.field_78140_b.field_78795_f = 1.5707964f;
        this.field_78141_c.field_78795_f = sajh._b(f * 0.6662f) * 1.4f * f2;
        this.field_78138_d.field_78795_f = sajh._b(f * 0.6662f + (float)Math.PI) * 1.4f * f2;
        this.field_78139_e.field_78808_h = f3;
        this.field_78136_f.field_78808_h = -f3;
    }
}

