/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.particle;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.util.sajh;

public class EntityRainFX
extends EntityFX {
    public EntityRainFX(ozlu ozlu2, double d, double d2, double d3) {
        super(ozlu2, d, d2, d3, 0.0, 0.0, 0.0);
        this.field_70159_w *= (double)0.3f;
        this.field_70181_x = (float)Math.random() * 0.2f + 0.1f;
        this.field_70179_y *= (double)0.3f;
        this.field_70552_h = 1.0f;
        this.field_70553_i = 1.0f;
        this.field_70551_j = 1.0f;
        this.func_70536_a(19 + this.field_70146_Z.nextInt(4));
        this.func_70105_a(0.01f, 0.01f);
        this.field_70545_g = 0.06f;
        this.field_70547_e = (int)(8.0 / (Math.random() * 0.8 + 0.2));
    }

    @Override
    public void func_70071_h_() {
        double d;
        tflj tflj2;
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        this.field_70181_x -= (double)this.field_70545_g;
        this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
        this.field_70159_w *= (double)0.98f;
        this.field_70181_x *= (double)0.98f;
        this.field_70179_y *= (double)0.98f;
        if (this.field_70547_e-- <= 0) {
            this.func_70106_y();
        }
        if (this.field_70122_E) {
            if (Math.random() < 0.5) {
                this.func_70106_y();
            }
            this.field_70159_w *= (double)0.7f;
            this.field_70179_y *= (double)0.7f;
        }
        if (((tflj2 = this.field_70170_p.func_72803_f(sajh._c(this.field_70165_t), sajh._c(this.field_70163_u), sajh._c(this.field_70161_v)))._d() || tflj2._a()) && this.field_70163_u < (d = (double)((float)(sajh._c(this.field_70163_u) + 1) - ogyy._a(this.field_70170_p.func_72805_g(sajh._c(this.field_70165_t), sajh._c(this.field_70163_u), sajh._c(this.field_70161_v)))))) {
            this.func_70106_y();
        }
    }
}

