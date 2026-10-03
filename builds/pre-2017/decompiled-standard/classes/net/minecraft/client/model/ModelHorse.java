/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.util.sajh;
import org.lwjgl.opengl.GL11;

public class ModelHorse
extends ModelBase {
    public ModelRenderer field_110709_a;
    public ModelRenderer field_110707_b;
    public ModelRenderer field_110708_c;
    public ModelRenderer field_110705_d;
    public ModelRenderer field_110706_e;
    public ModelRenderer field_110703_f;
    public ModelRenderer field_110704_g;
    public ModelRenderer field_110716_h;
    public ModelRenderer field_110717_i;
    public ModelRenderer field_110714_j;
    public ModelRenderer field_110715_k;
    public ModelRenderer field_110712_l;
    public ModelRenderer field_110713_m;
    public ModelRenderer field_110710_n;
    public ModelRenderer field_110711_o;
    public ModelRenderer field_110719_v;
    public ModelRenderer field_110718_w;
    public ModelRenderer field_110722_x;
    public ModelRenderer field_110721_y;
    public ModelRenderer field_110720_z;
    public ModelRenderer field_110688_A;
    public ModelRenderer field_110689_B;
    public ModelRenderer field_110690_C;
    public ModelRenderer field_110684_D;
    public ModelRenderer field_110685_E;
    public ModelRenderer field_110686_F;
    public ModelRenderer field_110687_G;
    public ModelRenderer field_110695_H;
    public ModelRenderer field_110696_I;
    public ModelRenderer field_110697_J;
    public ModelRenderer field_110698_K;
    public ModelRenderer field_110691_L;
    public ModelRenderer field_110692_M;
    public ModelRenderer field_110693_N;
    public ModelRenderer field_110694_O;
    public ModelRenderer field_110700_P;
    public ModelRenderer field_110699_Q;
    public ModelRenderer field_110702_R;
    public ModelRenderer field_110701_S;

    public ModelHorse() {
        this.field_78090_t = 128;
        this.field_78089_u = 128;
        this.field_110715_k = new ModelRenderer(this, 0, 34);
        this.field_110715_k.func_78789_a(-5.0f, -8.0f, -19.0f, 10, 10, 24);
        this.field_110715_k.func_78793_a(0.0f, 11.0f, 9.0f);
        this.field_110712_l = new ModelRenderer(this, 44, 0);
        this.field_110712_l.func_78789_a(-1.0f, -1.0f, 0.0f, 2, 2, 3);
        this.field_110712_l.func_78793_a(0.0f, 3.0f, 14.0f);
        this.func_110682_a(this.field_110712_l, -1.134464f, 0.0f, 0.0f);
        this.field_110713_m = new ModelRenderer(this, 38, 7);
        this.field_110713_m.func_78789_a(-1.5f, -2.0f, 3.0f, 3, 4, 7);
        this.field_110713_m.func_78793_a(0.0f, 3.0f, 14.0f);
        this.func_110682_a(this.field_110713_m, -1.134464f, 0.0f, 0.0f);
        this.field_110710_n = new ModelRenderer(this, 24, 3);
        this.field_110710_n.func_78789_a(-1.5f, -4.5f, 9.0f, 3, 4, 7);
        this.field_110710_n.func_78793_a(0.0f, 3.0f, 14.0f);
        this.func_110682_a(this.field_110710_n, -1.40215f, 0.0f, 0.0f);
        this.field_110711_o = new ModelRenderer(this, 78, 29);
        this.field_110711_o.func_78789_a(-2.5f, -2.0f, -2.5f, 4, 9, 5);
        this.field_110711_o.func_78793_a(4.0f, 9.0f, 11.0f);
        this.field_110719_v = new ModelRenderer(this, 78, 43);
        this.field_110719_v.func_78789_a(-2.0f, 0.0f, -1.5f, 3, 5, 3);
        this.field_110719_v.func_78793_a(4.0f, 16.0f, 11.0f);
        this.field_110718_w = new ModelRenderer(this, 78, 51);
        this.field_110718_w.func_78789_a(-2.5f, 5.1f, -2.0f, 4, 3, 4);
        this.field_110718_w.func_78793_a(4.0f, 16.0f, 11.0f);
        this.field_110722_x = new ModelRenderer(this, 96, 29);
        this.field_110722_x.func_78789_a(-1.5f, -2.0f, -2.5f, 4, 9, 5);
        this.field_110722_x.func_78793_a(-4.0f, 9.0f, 11.0f);
        this.field_110721_y = new ModelRenderer(this, 96, 43);
        this.field_110721_y.func_78789_a(-1.0f, 0.0f, -1.5f, 3, 5, 3);
        this.field_110721_y.func_78793_a(-4.0f, 16.0f, 11.0f);
        this.field_110720_z = new ModelRenderer(this, 96, 51);
        this.field_110720_z.func_78789_a(-1.5f, 5.1f, -2.0f, 4, 3, 4);
        this.field_110720_z.func_78793_a(-4.0f, 16.0f, 11.0f);
        this.field_110688_A = new ModelRenderer(this, 44, 29);
        this.field_110688_A.func_78789_a(-1.9f, -1.0f, -2.1f, 3, 8, 4);
        this.field_110688_A.func_78793_a(4.0f, 9.0f, -8.0f);
        this.field_110689_B = new ModelRenderer(this, 44, 41);
        this.field_110689_B.func_78789_a(-1.9f, 0.0f, -1.6f, 3, 5, 3);
        this.field_110689_B.func_78793_a(4.0f, 16.0f, -8.0f);
        this.field_110690_C = new ModelRenderer(this, 44, 51);
        this.field_110690_C.func_78789_a(-2.4f, 5.1f, -2.1f, 4, 3, 4);
        this.field_110690_C.func_78793_a(4.0f, 16.0f, -8.0f);
        this.field_110684_D = new ModelRenderer(this, 60, 29);
        this.field_110684_D.func_78789_a(-1.1f, -1.0f, -2.1f, 3, 8, 4);
        this.field_110684_D.func_78793_a(-4.0f, 9.0f, -8.0f);
        this.field_110685_E = new ModelRenderer(this, 60, 41);
        this.field_110685_E.func_78789_a(-1.1f, 0.0f, -1.6f, 3, 5, 3);
        this.field_110685_E.func_78793_a(-4.0f, 16.0f, -8.0f);
        this.field_110686_F = new ModelRenderer(this, 60, 51);
        this.field_110686_F.func_78789_a(-1.6f, 5.1f, -2.1f, 4, 3, 4);
        this.field_110686_F.func_78793_a(-4.0f, 16.0f, -8.0f);
        this.field_110709_a = new ModelRenderer(this, 0, 0);
        this.field_110709_a.func_78789_a(-2.5f, -10.0f, -1.5f, 5, 5, 7);
        this.field_110709_a.func_78793_a(0.0f, 4.0f, -10.0f);
        this.func_110682_a(this.field_110709_a, 0.5235988f, 0.0f, 0.0f);
        this.field_110707_b = new ModelRenderer(this, 24, 18);
        this.field_110707_b.func_78789_a(-2.0f, -10.0f, -7.0f, 4, 3, 6);
        this.field_110707_b.func_78793_a(0.0f, 3.95f, -10.0f);
        this.func_110682_a(this.field_110707_b, 0.5235988f, 0.0f, 0.0f);
        this.field_110708_c = new ModelRenderer(this, 24, 27);
        this.field_110708_c.func_78789_a(-2.0f, -7.0f, -6.5f, 4, 2, 5);
        this.field_110708_c.func_78793_a(0.0f, 4.0f, -10.0f);
        this.func_110682_a(this.field_110708_c, 0.5235988f, 0.0f, 0.0f);
        this.field_110709_a.func_78792_a(this.field_110707_b);
        this.field_110709_a.func_78792_a(this.field_110708_c);
        this.field_110705_d = new ModelRenderer(this, 0, 0);
        this.field_110705_d.func_78789_a(0.45f, -12.0f, 4.0f, 2, 3, 1);
        this.field_110705_d.func_78793_a(0.0f, 4.0f, -10.0f);
        this.func_110682_a(this.field_110705_d, 0.5235988f, 0.0f, 0.0f);
        this.field_110706_e = new ModelRenderer(this, 0, 0);
        this.field_110706_e.func_78789_a(-2.45f, -12.0f, 4.0f, 2, 3, 1);
        this.field_110706_e.func_78793_a(0.0f, 4.0f, -10.0f);
        this.func_110682_a(this.field_110706_e, 0.5235988f, 0.0f, 0.0f);
        this.field_110703_f = new ModelRenderer(this, 0, 12);
        this.field_110703_f.func_78789_a(-2.0f, -16.0f, 4.0f, 2, 7, 1);
        this.field_110703_f.func_78793_a(0.0f, 4.0f, -10.0f);
        this.func_110682_a(this.field_110703_f, 0.5235988f, 0.0f, 0.2617994f);
        this.field_110704_g = new ModelRenderer(this, 0, 12);
        this.field_110704_g.func_78789_a(0.0f, -16.0f, 4.0f, 2, 7, 1);
        this.field_110704_g.func_78793_a(0.0f, 4.0f, -10.0f);
        this.func_110682_a(this.field_110704_g, 0.5235988f, 0.0f, -0.2617994f);
        this.field_110716_h = new ModelRenderer(this, 0, 12);
        this.field_110716_h.func_78789_a(-2.05f, -9.8f, -2.0f, 4, 14, 8);
        this.field_110716_h.func_78793_a(0.0f, 4.0f, -10.0f);
        this.func_110682_a(this.field_110716_h, 0.5235988f, 0.0f, 0.0f);
        this.field_110687_G = new ModelRenderer(this, 0, 34);
        this.field_110687_G.func_78789_a(-3.0f, 0.0f, 0.0f, 8, 8, 3);
        this.field_110687_G.func_78793_a(-7.5f, 3.0f, 10.0f);
        this.func_110682_a(this.field_110687_G, 0.0f, 1.570796f, 0.0f);
        this.field_110695_H = new ModelRenderer(this, 0, 47);
        this.field_110695_H.func_78789_a(-3.0f, 0.0f, 0.0f, 8, 8, 3);
        this.field_110695_H.func_78793_a(4.5f, 3.0f, 10.0f);
        this.func_110682_a(this.field_110695_H, 0.0f, 1.570796f, 0.0f);
        this.field_110696_I = new ModelRenderer(this, 80, 0);
        this.field_110696_I.func_78789_a(-5.0f, 0.0f, -3.0f, 10, 1, 8);
        this.field_110696_I.func_78793_a(0.0f, 2.0f, 2.0f);
        this.field_110697_J = new ModelRenderer(this, 106, 9);
        this.field_110697_J.func_78789_a(-1.5f, -1.0f, -3.0f, 3, 1, 2);
        this.field_110697_J.func_78793_a(0.0f, 2.0f, 2.0f);
        this.field_110698_K = new ModelRenderer(this, 80, 9);
        this.field_110698_K.func_78789_a(-4.0f, -1.0f, 3.0f, 8, 1, 2);
        this.field_110698_K.func_78793_a(0.0f, 2.0f, 2.0f);
        this.field_110692_M = new ModelRenderer(this, 74, 0);
        this.field_110692_M.func_78789_a(-0.5f, 6.0f, -1.0f, 1, 2, 2);
        this.field_110692_M.func_78793_a(5.0f, 3.0f, 2.0f);
        this.field_110691_L = new ModelRenderer(this, 70, 0);
        this.field_110691_L.func_78789_a(-0.5f, 0.0f, -0.5f, 1, 6, 1);
        this.field_110691_L.func_78793_a(5.0f, 3.0f, 2.0f);
        this.field_110694_O = new ModelRenderer(this, 74, 4);
        this.field_110694_O.func_78789_a(-0.5f, 6.0f, -1.0f, 1, 2, 2);
        this.field_110694_O.func_78793_a(-5.0f, 3.0f, 2.0f);
        this.field_110693_N = new ModelRenderer(this, 80, 0);
        this.field_110693_N.func_78789_a(-0.5f, 0.0f, -0.5f, 1, 6, 1);
        this.field_110693_N.func_78793_a(-5.0f, 3.0f, 2.0f);
        this.field_110700_P = new ModelRenderer(this, 74, 13);
        this.field_110700_P.func_78789_a(1.5f, -8.0f, -4.0f, 1, 2, 2);
        this.field_110700_P.func_78793_a(0.0f, 4.0f, -10.0f);
        this.func_110682_a(this.field_110700_P, 0.5235988f, 0.0f, 0.0f);
        this.field_110699_Q = new ModelRenderer(this, 74, 13);
        this.field_110699_Q.func_78789_a(-2.5f, -8.0f, -4.0f, 1, 2, 2);
        this.field_110699_Q.func_78793_a(0.0f, 4.0f, -10.0f);
        this.func_110682_a(this.field_110699_Q, 0.5235988f, 0.0f, 0.0f);
        this.field_110702_R = new ModelRenderer(this, 44, 10);
        this.field_110702_R.func_78789_a(2.6f, -6.0f, -6.0f, 0, 3, 16);
        this.field_110702_R.func_78793_a(0.0f, 4.0f, -10.0f);
        this.field_110701_S = new ModelRenderer(this, 44, 5);
        this.field_110701_S.func_78789_a(-2.6f, -6.0f, -6.0f, 0, 3, 16);
        this.field_110701_S.func_78793_a(0.0f, 4.0f, -10.0f);
        this.field_110714_j = new ModelRenderer(this, 58, 0);
        this.field_110714_j.func_78789_a(-1.0f, -11.5f, 5.0f, 2, 16, 4);
        this.field_110714_j.func_78793_a(0.0f, 4.0f, -10.0f);
        this.func_110682_a(this.field_110714_j, 0.5235988f, 0.0f, 0.0f);
        this.field_110717_i = new ModelRenderer(this, 80, 12);
        this.field_110717_i.func_78790_a(-2.5f, -10.1f, -7.0f, 5, 5, 12, 0.2f);
        this.field_110717_i.func_78793_a(0.0f, 4.0f, -10.0f);
        this.func_110682_a(this.field_110717_i, 0.5235988f, 0.0f, 0.0f);
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        boolean bl;
        EntityHorse entityHorse = (EntityHorse)entity;
        int n = entityHorse.func_110265_bP();
        float f7 = entityHorse.func_110258_o(0.0f);
        boolean bl2 = entityHorse.func_110228_bR();
        boolean bl3 = bl2 && entityHorse.func_110257_ck();
        boolean bl4 = bl2 && entityHorse.func_110261_ca();
        boolean bl5 = n == 1 || n == 2;
        float f8 = entityHorse.func_110254_bY();
        boolean bl6 = bl = entityHorse.field_70153_n != null;
        if (bl3) {
            this.field_110717_i.func_78785_a(f6);
            this.field_110696_I.func_78785_a(f6);
            this.field_110697_J.func_78785_a(f6);
            this.field_110698_K.func_78785_a(f6);
            this.field_110691_L.func_78785_a(f6);
            this.field_110692_M.func_78785_a(f6);
            this.field_110693_N.func_78785_a(f6);
            this.field_110694_O.func_78785_a(f6);
            this.field_110700_P.func_78785_a(f6);
            this.field_110699_Q.func_78785_a(f6);
            if (bl) {
                this.field_110702_R.func_78785_a(f6);
                this.field_110701_S.func_78785_a(f6);
            }
        }
        if (!bl2) {
            GL11.glPushMatrix();
            GL11.glScalef(f8, 0.5f + f8 * 0.5f, f8);
            GL11.glTranslatef(0.0f, 0.95f * (1.0f - f8), 0.0f);
        }
        this.field_110711_o.func_78785_a(f6);
        this.field_110719_v.func_78785_a(f6);
        this.field_110718_w.func_78785_a(f6);
        this.field_110722_x.func_78785_a(f6);
        this.field_110721_y.func_78785_a(f6);
        this.field_110720_z.func_78785_a(f6);
        this.field_110688_A.func_78785_a(f6);
        this.field_110689_B.func_78785_a(f6);
        this.field_110690_C.func_78785_a(f6);
        this.field_110684_D.func_78785_a(f6);
        this.field_110685_E.func_78785_a(f6);
        this.field_110686_F.func_78785_a(f6);
        if (!bl2) {
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(f8, f8, f8);
            GL11.glTranslatef(0.0f, 1.35f * (1.0f - f8), 0.0f);
        }
        this.field_110715_k.func_78785_a(f6);
        this.field_110712_l.func_78785_a(f6);
        this.field_110713_m.func_78785_a(f6);
        this.field_110710_n.func_78785_a(f6);
        this.field_110716_h.func_78785_a(f6);
        this.field_110714_j.func_78785_a(f6);
        if (!bl2) {
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            float f9 = 0.5f + f8 * f8 * 0.5f;
            GL11.glScalef(f9, f9, f9);
            if (f7 <= 0.0f) {
                GL11.glTranslatef(0.0f, 1.35f * (1.0f - f8), 0.0f);
            } else {
                GL11.glTranslatef(0.0f, 0.9f * (1.0f - f8) * f7 + 1.35f * (1.0f - f8) * (1.0f - f7), 0.15f * (1.0f - f8) * f7);
            }
        }
        if (bl5) {
            this.field_110703_f.func_78785_a(f6);
            this.field_110704_g.func_78785_a(f6);
        } else {
            this.field_110705_d.func_78785_a(f6);
            this.field_110706_e.func_78785_a(f6);
        }
        this.field_110709_a.func_78785_a(f6);
        if (!bl2) {
            GL11.glPopMatrix();
        }
        if (bl4) {
            this.field_110687_G.func_78785_a(f6);
            this.field_110695_H.func_78785_a(f6);
        }
    }

    public void func_110682_a(ModelRenderer modelRenderer, float f, float f2, float f3) {
        modelRenderer.field_78795_f = f;
        modelRenderer.field_78796_g = f2;
        modelRenderer.field_78808_h = f3;
    }

    public float func_110683_a(float f, float f2, float f3) {
        float f4;
        for (f4 = f2 - f; f4 < -180.0f; f4 += 360.0f) {
        }
        while (f4 >= 180.0f) {
            f4 -= 360.0f;
        }
        return f + f3 * f4;
    }

    @Override
    public void func_78086_a(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        super.func_78086_a(entityLivingBase, f, f2, f3);
        float f4 = this.func_110683_a(entityLivingBase.field_70760_ar, entityLivingBase.field_70761_aq, f3);
        float f5 = this.func_110683_a(entityLivingBase.field_70758_at, entityLivingBase.field_70759_as, f3);
        float f6 = entityLivingBase.field_70127_C + (entityLivingBase.field_70125_A - entityLivingBase.field_70127_C) * f3;
        float f7 = f5 - f4;
        float f8 = f6 / 57.29578f;
        if (f7 > 20.0f) {
            f7 = 20.0f;
        }
        if (f7 < -20.0f) {
            f7 = -20.0f;
        }
        if (f2 > 0.2f) {
            f8 += sajh._b(f * 0.4f) * 0.15f * f2;
        }
        EntityHorse entityHorse = (EntityHorse)entityLivingBase;
        float f9 = entityHorse.func_110258_o(f3);
        float f10 = entityHorse.func_110223_p(f3);
        float f11 = 1.0f - f10;
        float f12 = entityHorse.func_110201_q(f3);
        boolean bl = entityHorse.field_110278_bp != 0;
        boolean bl2 = entityHorse.func_110257_ck();
        boolean bl3 = entityHorse.field_70153_n != null;
        float f13 = (float)entityLivingBase.field_70173_aa + f3;
        float f14 = sajh._b(f * 0.6662f + 3.141593f);
        float f15 = f14 * 0.8f * f2;
        this.field_110709_a.field_78797_d = 4.0f;
        this.field_110709_a.field_78798_e = -10.0f;
        this.field_110712_l.field_78797_d = 3.0f;
        this.field_110713_m.field_78798_e = 14.0f;
        this.field_110695_H.field_78797_d = 3.0f;
        this.field_110695_H.field_78798_e = 10.0f;
        this.field_110715_k.field_78795_f = 0.0f;
        this.field_110709_a.field_78795_f = 0.5235988f + f8;
        this.field_110709_a.field_78796_g = f7 / 57.29578f;
        this.field_110709_a.field_78795_f = f10 * (0.2617994f + f8) + f9 * 2.18166f + (1.0f - Math.max(f10, f9)) * this.field_110709_a.field_78795_f;
        this.field_110709_a.field_78796_g = f10 * (f7 / 57.29578f) + (1.0f - Math.max(f10, f9)) * this.field_110709_a.field_78796_g;
        this.field_110709_a.field_78797_d = f10 * -6.0f + f9 * 11.0f + (1.0f - Math.max(f10, f9)) * this.field_110709_a.field_78797_d;
        this.field_110709_a.field_78798_e = f10 * -1.0f + f9 * -10.0f + (1.0f - Math.max(f10, f9)) * this.field_110709_a.field_78798_e;
        this.field_110712_l.field_78797_d = f10 * 9.0f + f11 * this.field_110712_l.field_78797_d;
        this.field_110713_m.field_78798_e = f10 * 18.0f + f11 * this.field_110713_m.field_78798_e;
        this.field_110695_H.field_78797_d = f10 * 5.5f + f11 * this.field_110695_H.field_78797_d;
        this.field_110695_H.field_78798_e = f10 * 15.0f + f11 * this.field_110695_H.field_78798_e;
        this.field_110715_k.field_78795_f = f10 * -0.7853981f + f11 * this.field_110715_k.field_78795_f;
        this.field_110705_d.field_78797_d = this.field_110709_a.field_78797_d;
        this.field_110706_e.field_78797_d = this.field_110709_a.field_78797_d;
        this.field_110703_f.field_78797_d = this.field_110709_a.field_78797_d;
        this.field_110704_g.field_78797_d = this.field_110709_a.field_78797_d;
        this.field_110716_h.field_78797_d = this.field_110709_a.field_78797_d;
        this.field_110707_b.field_78797_d = 0.02f;
        this.field_110708_c.field_78797_d = 0.0f;
        this.field_110714_j.field_78797_d = this.field_110709_a.field_78797_d;
        this.field_110705_d.field_78798_e = this.field_110709_a.field_78798_e;
        this.field_110706_e.field_78798_e = this.field_110709_a.field_78798_e;
        this.field_110703_f.field_78798_e = this.field_110709_a.field_78798_e;
        this.field_110704_g.field_78798_e = this.field_110709_a.field_78798_e;
        this.field_110716_h.field_78798_e = this.field_110709_a.field_78798_e;
        this.field_110707_b.field_78798_e = 0.02f - f12 * 1.0f;
        this.field_110708_c.field_78798_e = 0.0f + f12 * 1.0f;
        this.field_110714_j.field_78798_e = this.field_110709_a.field_78798_e;
        this.field_110705_d.field_78795_f = this.field_110709_a.field_78795_f;
        this.field_110706_e.field_78795_f = this.field_110709_a.field_78795_f;
        this.field_110703_f.field_78795_f = this.field_110709_a.field_78795_f;
        this.field_110704_g.field_78795_f = this.field_110709_a.field_78795_f;
        this.field_110716_h.field_78795_f = this.field_110709_a.field_78795_f;
        this.field_110707_b.field_78795_f = 0.0f - 0.09424778f * f12;
        this.field_110708_c.field_78795_f = 0.0f + 0.15707964f * f12;
        this.field_110714_j.field_78795_f = this.field_110709_a.field_78795_f;
        this.field_110705_d.field_78796_g = this.field_110709_a.field_78796_g;
        this.field_110706_e.field_78796_g = this.field_110709_a.field_78796_g;
        this.field_110703_f.field_78796_g = this.field_110709_a.field_78796_g;
        this.field_110704_g.field_78796_g = this.field_110709_a.field_78796_g;
        this.field_110716_h.field_78796_g = this.field_110709_a.field_78796_g;
        this.field_110707_b.field_78796_g = 0.0f;
        this.field_110708_c.field_78796_g = 0.0f;
        this.field_110714_j.field_78796_g = this.field_110709_a.field_78796_g;
        this.field_110687_G.field_78795_f = f15 / 5.0f;
        this.field_110695_H.field_78795_f = -f15 / 5.0f;
        float f16 = 1.5707964f;
        float f17 = 4.712389f;
        float f18 = -1.0471976f;
        float f19 = 0.2617994f * f10;
        float f20 = sajh._b(f13 * 0.6f + 3.141593f);
        this.field_110688_A.field_78797_d = -2.0f * f10 + 9.0f * f11;
        this.field_110688_A.field_78798_e = -2.0f * f10 + -8.0f * f11;
        this.field_110684_D.field_78797_d = this.field_110688_A.field_78797_d;
        this.field_110684_D.field_78798_e = this.field_110688_A.field_78798_e;
        this.field_110719_v.field_78797_d = this.field_110711_o.field_78797_d + sajh._a(1.5707964f + f19 + f11 * (-f14 * 0.5f * f2)) * 7.0f;
        this.field_110719_v.field_78798_e = this.field_110711_o.field_78798_e + sajh._b(4.712389f + f19 + f11 * (-f14 * 0.5f * f2)) * 7.0f;
        this.field_110721_y.field_78797_d = this.field_110722_x.field_78797_d + sajh._a(1.5707964f + f19 + f11 * (f14 * 0.5f * f2)) * 7.0f;
        this.field_110721_y.field_78798_e = this.field_110722_x.field_78798_e + sajh._b(4.712389f + f19 + f11 * (f14 * 0.5f * f2)) * 7.0f;
        float f21 = (-1.0471976f + f20) * f10 + f15 * f11;
        float f22 = (-1.0471976f + -f20) * f10 + -f15 * f11;
        this.field_110689_B.field_78797_d = this.field_110688_A.field_78797_d + sajh._a(1.5707964f + f21) * 7.0f;
        this.field_110689_B.field_78798_e = this.field_110688_A.field_78798_e + sajh._b(4.712389f + f21) * 7.0f;
        this.field_110685_E.field_78797_d = this.field_110684_D.field_78797_d + sajh._a(1.5707964f + f22) * 7.0f;
        this.field_110685_E.field_78798_e = this.field_110684_D.field_78798_e + sajh._b(4.712389f + f22) * 7.0f;
        this.field_110711_o.field_78795_f = f19 + -f14 * 0.5f * f2 * f11;
        this.field_110718_w.field_78795_f = this.field_110719_v.field_78795_f = -0.08726646f * f10 + (-f14 * 0.5f * f2 - Math.max(0.0f, f14 * 0.5f * f2)) * f11;
        this.field_110722_x.field_78795_f = f19 + f14 * 0.5f * f2 * f11;
        this.field_110720_z.field_78795_f = this.field_110721_y.field_78795_f = -0.08726646f * f10 + (f14 * 0.5f * f2 - Math.max(0.0f, -f14 * 0.5f * f2)) * f11;
        this.field_110688_A.field_78795_f = f21;
        this.field_110690_C.field_78795_f = this.field_110689_B.field_78795_f = (this.field_110688_A.field_78795_f + (float)Math.PI * Math.max(0.0f, 0.2f + f20 * 0.2f)) * f10 + (f15 + Math.max(0.0f, f14 * 0.5f * f2)) * f11;
        this.field_110684_D.field_78795_f = f22;
        this.field_110686_F.field_78795_f = this.field_110685_E.field_78795_f = (this.field_110684_D.field_78795_f + (float)Math.PI * Math.max(0.0f, 0.2f - f20 * 0.2f)) * f10 + (-f15 + Math.max(0.0f, -f14 * 0.5f * f2)) * f11;
        this.field_110718_w.field_78797_d = this.field_110719_v.field_78797_d;
        this.field_110718_w.field_78798_e = this.field_110719_v.field_78798_e;
        this.field_110720_z.field_78797_d = this.field_110721_y.field_78797_d;
        this.field_110720_z.field_78798_e = this.field_110721_y.field_78798_e;
        this.field_110690_C.field_78797_d = this.field_110689_B.field_78797_d;
        this.field_110690_C.field_78798_e = this.field_110689_B.field_78798_e;
        this.field_110686_F.field_78797_d = this.field_110685_E.field_78797_d;
        this.field_110686_F.field_78798_e = this.field_110685_E.field_78798_e;
        if (bl2) {
            this.field_110696_I.field_78797_d = f10 * 0.5f + f11 * 2.0f;
            this.field_110696_I.field_78798_e = f10 * 11.0f + f11 * 2.0f;
            this.field_110697_J.field_78797_d = this.field_110696_I.field_78797_d;
            this.field_110698_K.field_78797_d = this.field_110696_I.field_78797_d;
            this.field_110691_L.field_78797_d = this.field_110696_I.field_78797_d;
            this.field_110693_N.field_78797_d = this.field_110696_I.field_78797_d;
            this.field_110692_M.field_78797_d = this.field_110696_I.field_78797_d;
            this.field_110694_O.field_78797_d = this.field_110696_I.field_78797_d;
            this.field_110687_G.field_78797_d = this.field_110695_H.field_78797_d;
            this.field_110697_J.field_78798_e = this.field_110696_I.field_78798_e;
            this.field_110698_K.field_78798_e = this.field_110696_I.field_78798_e;
            this.field_110691_L.field_78798_e = this.field_110696_I.field_78798_e;
            this.field_110693_N.field_78798_e = this.field_110696_I.field_78798_e;
            this.field_110692_M.field_78798_e = this.field_110696_I.field_78798_e;
            this.field_110694_O.field_78798_e = this.field_110696_I.field_78798_e;
            this.field_110687_G.field_78798_e = this.field_110695_H.field_78798_e;
            this.field_110696_I.field_78795_f = this.field_110715_k.field_78795_f;
            this.field_110697_J.field_78795_f = this.field_110715_k.field_78795_f;
            this.field_110698_K.field_78795_f = this.field_110715_k.field_78795_f;
            this.field_110702_R.field_78797_d = this.field_110709_a.field_78797_d;
            this.field_110701_S.field_78797_d = this.field_110709_a.field_78797_d;
            this.field_110717_i.field_78797_d = this.field_110709_a.field_78797_d;
            this.field_110700_P.field_78797_d = this.field_110709_a.field_78797_d;
            this.field_110699_Q.field_78797_d = this.field_110709_a.field_78797_d;
            this.field_110702_R.field_78798_e = this.field_110709_a.field_78798_e;
            this.field_110701_S.field_78798_e = this.field_110709_a.field_78798_e;
            this.field_110717_i.field_78798_e = this.field_110709_a.field_78798_e;
            this.field_110700_P.field_78798_e = this.field_110709_a.field_78798_e;
            this.field_110699_Q.field_78798_e = this.field_110709_a.field_78798_e;
            this.field_110702_R.field_78795_f = f8;
            this.field_110701_S.field_78795_f = f8;
            this.field_110717_i.field_78795_f = this.field_110709_a.field_78795_f;
            this.field_110700_P.field_78795_f = this.field_110709_a.field_78795_f;
            this.field_110699_Q.field_78795_f = this.field_110709_a.field_78795_f;
            this.field_110717_i.field_78796_g = this.field_110709_a.field_78796_g;
            this.field_110700_P.field_78796_g = this.field_110709_a.field_78796_g;
            this.field_110702_R.field_78796_g = this.field_110709_a.field_78796_g;
            this.field_110699_Q.field_78796_g = this.field_110709_a.field_78796_g;
            this.field_110701_S.field_78796_g = this.field_110709_a.field_78796_g;
            if (bl3) {
                this.field_110691_L.field_78795_f = -1.0471976f;
                this.field_110692_M.field_78795_f = -1.0471976f;
                this.field_110693_N.field_78795_f = -1.0471976f;
                this.field_110694_O.field_78795_f = -1.0471976f;
                this.field_110691_L.field_78808_h = 0.0f;
                this.field_110692_M.field_78808_h = 0.0f;
                this.field_110693_N.field_78808_h = 0.0f;
                this.field_110694_O.field_78808_h = 0.0f;
            } else {
                this.field_110691_L.field_78795_f = f15 / 3.0f;
                this.field_110692_M.field_78795_f = f15 / 3.0f;
                this.field_110693_N.field_78795_f = f15 / 3.0f;
                this.field_110694_O.field_78795_f = f15 / 3.0f;
                this.field_110691_L.field_78808_h = f15 / 5.0f;
                this.field_110692_M.field_78808_h = f15 / 5.0f;
                this.field_110693_N.field_78808_h = -f15 / 5.0f;
                this.field_110694_O.field_78808_h = -f15 / 5.0f;
            }
        }
        if ((f16 = -1.3089f + f2 * 1.5f) > 0.0f) {
            f16 = 0.0f;
        }
        if (bl) {
            this.field_110712_l.field_78796_g = sajh._b(f13 * 0.7f);
            f16 = 0.0f;
        } else {
            this.field_110712_l.field_78796_g = 0.0f;
        }
        this.field_110713_m.field_78796_g = this.field_110712_l.field_78796_g;
        this.field_110710_n.field_78796_g = this.field_110712_l.field_78796_g;
        this.field_110713_m.field_78797_d = this.field_110712_l.field_78797_d;
        this.field_110710_n.field_78797_d = this.field_110712_l.field_78797_d;
        this.field_110713_m.field_78798_e = this.field_110712_l.field_78798_e;
        this.field_110710_n.field_78798_e = this.field_110712_l.field_78798_e;
        this.field_110712_l.field_78795_f = f16;
        this.field_110713_m.field_78795_f = f16;
        this.field_110710_n.field_78795_f = -0.2618f + f16;
    }
}

