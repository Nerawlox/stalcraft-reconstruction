/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.particle;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.util.sajh;

public class EntityDropParticleFX
extends EntityFX {
    public tflj field_70563_a;
    public int field_70564_aq;

    public EntityDropParticleFX(ozlu ozlu2, double d, double d2, double d3, tflj tflj2) {
        super(ozlu2, d, d2, d3, 0.0, 0.0, 0.0);
        this.field_70179_y = 0.0;
        this.field_70181_x = 0.0;
        this.field_70159_w = 0.0;
        if (tflj2 == tflj._h) {
            this.field_70552_h = 0.0f;
            this.field_70553_i = 0.0f;
            this.field_70551_j = 1.0f;
        } else {
            this.field_70552_h = 1.0f;
            this.field_70553_i = 0.0f;
            this.field_70551_j = 0.0f;
        }
        this.func_70536_a(113);
        this.func_70105_a(0.01f, 0.01f);
        this.field_70545_g = 0.06f;
        this.field_70563_a = tflj2;
        this.field_70564_aq = 40;
        this.field_70547_e = (int)(64.0 / (Math.random() * 0.8 + 0.2));
        this.field_70179_y = 0.0;
        this.field_70181_x = 0.0;
        this.field_70159_w = 0.0;
    }

    @Override
    public int func_70070_b(float f) {
        if (this.field_70563_a == tflj._h) {
            return super.func_70070_b(f);
        }
        return 257;
    }

    @Override
    public float func_70013_c(float f) {
        if (this.field_70563_a == tflj._h) {
            return super.func_70013_c(f);
        }
        return 1.0f;
    }

    @Override
    public void func_70071_h_() {
        double d;
        tflj tflj2;
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        if (this.field_70563_a == tflj._h) {
            this.field_70552_h = 0.2f;
            this.field_70553_i = 0.3f;
            this.field_70551_j = 1.0f;
        } else {
            this.field_70552_h = 1.0f;
            this.field_70553_i = 16.0f / (float)(40 - this.field_70564_aq + 16);
            this.field_70551_j = 4.0f / (float)(40 - this.field_70564_aq + 8);
        }
        this.field_70181_x -= (double)this.field_70545_g;
        if (this.field_70564_aq-- > 0) {
            this.field_70159_w *= 0.02;
            this.field_70181_x *= 0.02;
            this.field_70179_y *= 0.02;
            this.func_70536_a(113);
        } else {
            this.func_70536_a(112);
        }
        this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
        this.field_70159_w *= (double)0.98f;
        this.field_70181_x *= (double)0.98f;
        this.field_70179_y *= (double)0.98f;
        if (this.field_70547_e-- <= 0) {
            this.func_70106_y();
        }
        if (this.field_70122_E) {
            if (this.field_70563_a == tflj._h) {
                this.func_70106_y();
                this.field_70170_p.func_72869_a("splash", this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0);
            } else {
                this.func_70536_a(114);
            }
            this.field_70159_w *= (double)0.7f;
            this.field_70179_y *= (double)0.7f;
        }
        if (((tflj2 = this.field_70170_p.func_72803_f(sajh._c(this.field_70165_t), sajh._c(this.field_70163_u), sajh._c(this.field_70161_v)))._d() || tflj2._a()) && this.field_70163_u < (d = (double)((float)(sajh._c(this.field_70163_u) + 1) - ogyy._a(this.field_70170_p.func_72805_g(sajh._c(this.field_70165_t), sajh._c(this.field_70163_u), sajh._c(this.field_70161_v)))))) {
            this.func_70106_y();
        }
    }
}

