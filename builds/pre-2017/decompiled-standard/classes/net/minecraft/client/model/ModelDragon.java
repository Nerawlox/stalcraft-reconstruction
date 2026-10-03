/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import org.lwjgl.opengl.GL11;

public class ModelDragon
extends ModelBase {
    public ModelRenderer field_78221_a;
    public ModelRenderer field_78219_b;
    public ModelRenderer field_78220_c;
    public ModelRenderer field_78217_d;
    public ModelRenderer field_78218_e;
    public ModelRenderer field_78215_f;
    public ModelRenderer field_78216_g;
    public ModelRenderer field_78226_h;
    public ModelRenderer field_78227_i;
    public ModelRenderer field_78224_j;
    public ModelRenderer field_78225_k;
    public ModelRenderer field_78222_l;
    public float field_78223_m;

    public ModelDragon(float f) {
        this.field_78090_t = 256;
        this.field_78089_u = 256;
        this.func_78085_a("body.body", 0, 0);
        this.func_78085_a("wing.skin", -56, 88);
        this.func_78085_a("wingtip.skin", -56, 144);
        this.func_78085_a("rearleg.main", 0, 0);
        this.func_78085_a("rearfoot.main", 112, 0);
        this.func_78085_a("rearlegtip.main", 196, 0);
        this.func_78085_a("head.upperhead", 112, 30);
        this.func_78085_a("wing.bone", 112, 88);
        this.func_78085_a("head.upperlip", 176, 44);
        this.func_78085_a("jaw.jaw", 176, 65);
        this.func_78085_a("frontleg.main", 112, 104);
        this.func_78085_a("wingtip.bone", 112, 136);
        this.func_78085_a("frontfoot.main", 144, 104);
        this.func_78085_a("neck.box", 192, 104);
        this.func_78085_a("frontlegtip.main", 226, 138);
        this.func_78085_a("body.scale", 220, 53);
        this.func_78085_a("head.scale", 0, 0);
        this.func_78085_a("neck.scale", 48, 0);
        this.func_78085_a("head.nostril", 112, 0);
        float f2 = -16.0f;
        this.field_78221_a = new ModelRenderer(this, "head");
        this.field_78221_a.func_78786_a("upperlip", -6.0f, -1.0f, -8.0f + f2, 12, 5, 16);
        this.field_78221_a.func_78786_a("upperhead", -8.0f, -8.0f, 6.0f + f2, 16, 16, 16);
        this.field_78221_a.field_78809_i = true;
        this.field_78221_a.func_78786_a("scale", -5.0f, -12.0f, 12.0f + f2, 2, 4, 6);
        this.field_78221_a.func_78786_a("nostril", -5.0f, -3.0f, -6.0f + f2, 2, 2, 4);
        this.field_78221_a.field_78809_i = false;
        this.field_78221_a.func_78786_a("scale", 3.0f, -12.0f, 12.0f + f2, 2, 4, 6);
        this.field_78221_a.func_78786_a("nostril", 3.0f, -3.0f, -6.0f + f2, 2, 2, 4);
        this.field_78220_c = new ModelRenderer(this, "jaw");
        this.field_78220_c.func_78793_a(0.0f, 4.0f, 8.0f + f2);
        this.field_78220_c.func_78786_a("jaw", -6.0f, 0.0f, -16.0f, 12, 4, 16);
        this.field_78221_a.func_78792_a(this.field_78220_c);
        this.field_78219_b = new ModelRenderer(this, "neck");
        this.field_78219_b.func_78786_a("box", -5.0f, -5.0f, -5.0f, 10, 10, 10);
        this.field_78219_b.func_78786_a("scale", -1.0f, -9.0f, -3.0f, 2, 4, 6);
        this.field_78217_d = new ModelRenderer(this, "body");
        this.field_78217_d.func_78793_a(0.0f, 4.0f, 8.0f);
        this.field_78217_d.func_78786_a("body", -12.0f, 0.0f, -16.0f, 24, 24, 64);
        this.field_78217_d.func_78786_a("scale", -1.0f, -6.0f, -10.0f, 2, 6, 12);
        this.field_78217_d.func_78786_a("scale", -1.0f, -6.0f, 10.0f, 2, 6, 12);
        this.field_78217_d.func_78786_a("scale", -1.0f, -6.0f, 30.0f, 2, 6, 12);
        this.field_78225_k = new ModelRenderer(this, "wing");
        this.field_78225_k.func_78793_a(-12.0f, 5.0f, 2.0f);
        this.field_78225_k.func_78786_a("bone", -56.0f, -4.0f, -4.0f, 56, 8, 8);
        this.field_78225_k.func_78786_a("skin", -56.0f, 0.0f, 2.0f, 56, 0, 56);
        this.field_78222_l = new ModelRenderer(this, "wingtip");
        this.field_78222_l.func_78793_a(-56.0f, 0.0f, 0.0f);
        this.field_78222_l.func_78786_a("bone", -56.0f, -2.0f, -2.0f, 56, 4, 4);
        this.field_78222_l.func_78786_a("skin", -56.0f, 0.0f, 2.0f, 56, 0, 56);
        this.field_78225_k.func_78792_a(this.field_78222_l);
        this.field_78215_f = new ModelRenderer(this, "frontleg");
        this.field_78215_f.func_78793_a(-12.0f, 20.0f, 2.0f);
        this.field_78215_f.func_78786_a("main", -4.0f, -4.0f, -4.0f, 8, 24, 8);
        this.field_78226_h = new ModelRenderer(this, "frontlegtip");
        this.field_78226_h.func_78793_a(0.0f, 20.0f, -1.0f);
        this.field_78226_h.func_78786_a("main", -3.0f, -1.0f, -3.0f, 6, 24, 6);
        this.field_78215_f.func_78792_a(this.field_78226_h);
        this.field_78224_j = new ModelRenderer(this, "frontfoot");
        this.field_78224_j.func_78793_a(0.0f, 23.0f, 0.0f);
        this.field_78224_j.func_78786_a("main", -4.0f, 0.0f, -12.0f, 8, 4, 16);
        this.field_78226_h.func_78792_a(this.field_78224_j);
        this.field_78218_e = new ModelRenderer(this, "rearleg");
        this.field_78218_e.func_78793_a(-16.0f, 16.0f, 42.0f);
        this.field_78218_e.func_78786_a("main", -8.0f, -4.0f, -8.0f, 16, 32, 16);
        this.field_78216_g = new ModelRenderer(this, "rearlegtip");
        this.field_78216_g.func_78793_a(0.0f, 32.0f, -4.0f);
        this.field_78216_g.func_78786_a("main", -6.0f, -2.0f, 0.0f, 12, 32, 12);
        this.field_78218_e.func_78792_a(this.field_78216_g);
        this.field_78227_i = new ModelRenderer(this, "rearfoot");
        this.field_78227_i.func_78793_a(0.0f, 31.0f, 4.0f);
        this.field_78227_i.func_78786_a("main", -9.0f, 0.0f, -20.0f, 18, 6, 24);
        this.field_78216_g.func_78792_a(this.field_78227_i);
    }

    @Override
    public void func_78086_a(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        this.field_78223_m = f3;
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7;
        GL11.glPushMatrix();
        EntityDragon entityDragon = (EntityDragon)entity;
        float f8 = entityDragon.field_70991_bC + (entityDragon.field_70988_bD - entityDragon.field_70991_bC) * this.field_78223_m;
        this.field_78220_c.field_78795_f = (float)(Math.sin(f8 * (float)Math.PI * 2.0f) + 1.0) * 0.2f;
        float f9 = (float)(Math.sin(f8 * (float)Math.PI * 2.0f - 1.0f) + 1.0);
        f9 = (f9 * f9 * 1.0f + f9 * 2.0f) * 0.05f;
        GL11.glTranslatef(0.0f, f9 - 2.0f, -3.0f);
        GL11.glRotatef(f9 * 2.0f, 1.0f, 0.0f, 0.0f);
        float f10 = -30.0f;
        float f11 = 0.0f;
        float f12 = 1.5f;
        double[] dArray = entityDragon.func_70974_a(6, this.field_78223_m);
        float f13 = this.func_78214_a(entityDragon.func_70974_a(5, this.field_78223_m)[0] - entityDragon.func_70974_a(10, this.field_78223_m)[0]);
        float f14 = this.func_78214_a(entityDragon.func_70974_a(5, this.field_78223_m)[0] + (double)(f13 / 2.0f));
        f10 += 2.0f;
        float f15 = f8 * (float)Math.PI * 2.0f;
        f10 = 20.0f;
        float f16 = -12.0f;
        for (int i = 0; i < 5; ++i) {
            double[] dArray2 = entityDragon.func_70974_a(5 - i, this.field_78223_m);
            f7 = (float)Math.cos((float)i * 0.45f + f15) * 0.15f;
            this.field_78219_b.field_78796_g = this.func_78214_a(dArray2[0] - dArray[0]) * (float)Math.PI / 180.0f * f12;
            this.field_78219_b.field_78795_f = f7 + (float)(dArray2[1] - dArray[1]) * (float)Math.PI / 180.0f * f12 * 5.0f;
            this.field_78219_b.field_78808_h = -this.func_78214_a(dArray2[0] - (double)f14) * (float)Math.PI / 180.0f * f12;
            this.field_78219_b.field_78797_d = f10;
            this.field_78219_b.field_78798_e = f16;
            this.field_78219_b.field_78800_c = f11;
            f10 = (float)((double)f10 + Math.sin(this.field_78219_b.field_78795_f) * 10.0);
            f16 = (float)((double)f16 - Math.cos(this.field_78219_b.field_78796_g) * Math.cos(this.field_78219_b.field_78795_f) * 10.0);
            f11 = (float)((double)f11 - Math.sin(this.field_78219_b.field_78796_g) * Math.cos(this.field_78219_b.field_78795_f) * 10.0);
            this.field_78219_b.func_78785_a(f6);
        }
        this.field_78221_a.field_78797_d = f10;
        this.field_78221_a.field_78798_e = f16;
        this.field_78221_a.field_78800_c = f11;
        double[] dArray3 = entityDragon.func_70974_a(0, this.field_78223_m);
        this.field_78221_a.field_78796_g = this.func_78214_a(dArray3[0] - dArray[0]) * (float)Math.PI / 180.0f * 1.0f;
        this.field_78221_a.field_78808_h = -this.func_78214_a(dArray3[0] - (double)f14) * (float)Math.PI / 180.0f * 1.0f;
        this.field_78221_a.func_78785_a(f6);
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-f13 * f12 * 1.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.0f, -1.0f, 0.0f);
        this.field_78217_d.field_78808_h = 0.0f;
        this.field_78217_d.func_78785_a(f6);
        for (int i = 0; i < 2; ++i) {
            GL11.glEnable(2884);
            f7 = f8 * (float)Math.PI * 2.0f;
            this.field_78225_k.field_78795_f = 0.125f - (float)Math.cos(f7) * 0.2f;
            this.field_78225_k.field_78796_g = 0.25f;
            this.field_78225_k.field_78808_h = (float)(Math.sin(f7) + 0.125) * 0.8f;
            this.field_78222_l.field_78808_h = -((float)(Math.sin(f7 + 2.0f) + 0.5)) * 0.75f;
            this.field_78218_e.field_78795_f = 1.0f + f9 * 0.1f;
            this.field_78216_g.field_78795_f = 0.5f + f9 * 0.1f;
            this.field_78227_i.field_78795_f = 0.75f + f9 * 0.1f;
            this.field_78215_f.field_78795_f = 1.3f + f9 * 0.1f;
            this.field_78226_h.field_78795_f = -0.5f - f9 * 0.1f;
            this.field_78224_j.field_78795_f = 0.75f + f9 * 0.1f;
            this.field_78225_k.func_78785_a(f6);
            this.field_78215_f.func_78785_a(f6);
            this.field_78218_e.func_78785_a(f6);
            GL11.glScalef(-1.0f, 1.0f, 1.0f);
            if (i != 0) continue;
            GL11.glCullFace(1028);
        }
        GL11.glPopMatrix();
        GL11.glCullFace(1029);
        GL11.glDisable(2884);
        float f17 = -((float)Math.sin(f8 * (float)Math.PI * 2.0f)) * 0.0f;
        f15 = f8 * (float)Math.PI * 2.0f;
        f10 = 10.0f;
        f16 = 60.0f;
        f11 = 0.0f;
        dArray = entityDragon.func_70974_a(11, this.field_78223_m);
        for (int i = 0; i < 12; ++i) {
            dArray3 = entityDragon.func_70974_a(12 + i, this.field_78223_m);
            f17 = (float)((double)f17 + Math.sin((float)i * 0.45f + f15) * (double)0.05f);
            this.field_78219_b.field_78796_g = (this.func_78214_a(dArray3[0] - dArray[0]) * f12 + 180.0f) * (float)Math.PI / 180.0f;
            this.field_78219_b.field_78795_f = f17 + (float)(dArray3[1] - dArray[1]) * (float)Math.PI / 180.0f * f12 * 5.0f;
            this.field_78219_b.field_78808_h = this.func_78214_a(dArray3[0] - (double)f14) * (float)Math.PI / 180.0f * f12;
            this.field_78219_b.field_78797_d = f10;
            this.field_78219_b.field_78798_e = f16;
            this.field_78219_b.field_78800_c = f11;
            f10 = (float)((double)f10 + Math.sin(this.field_78219_b.field_78795_f) * 10.0);
            f16 = (float)((double)f16 - Math.cos(this.field_78219_b.field_78796_g) * Math.cos(this.field_78219_b.field_78795_f) * 10.0);
            f11 = (float)((double)f11 - Math.sin(this.field_78219_b.field_78796_g) * Math.cos(this.field_78219_b.field_78795_f) * 10.0);
            this.field_78219_b.func_78785_a(f6);
        }
        GL11.glPopMatrix();
    }

    public float func_78214_a(double d) {
        while (d >= 180.0) {
            d -= 360.0;
        }
        while (d < -180.0) {
            d += 360.0;
        }
        return (float)d;
    }
}

