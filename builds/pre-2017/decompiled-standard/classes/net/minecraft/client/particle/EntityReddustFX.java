/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.particle;

import net.minecraft.client.particle.EntityFX;

public class EntityReddustFX
extends EntityFX {
    public float field_70570_a;

    public EntityReddustFX(ozlu ozlu2, double d, double d2, double d3, float f, float f2, float f3) {
        this(ozlu2, d, d2, d3, 1.0f, f, f2, f3);
    }

    public EntityReddustFX(ozlu ozlu2, double d, double d2, double d3, float f, float f2, float f3, float f4) {
        super(ozlu2, d, d2, d3, 0.0, 0.0, 0.0);
        this.field_70159_w *= (double)0.1f;
        this.field_70181_x *= (double)0.1f;
        this.field_70179_y *= (double)0.1f;
        if (f2 == 0.0f) {
            f2 = 1.0f;
        }
        float f5 = (float)Math.random() * 0.4f + 0.6f;
        this.field_70552_h = ((float)(Math.random() * (double)0.2f) + 0.8f) * f2 * f5;
        this.field_70553_i = ((float)(Math.random() * (double)0.2f) + 0.8f) * f3 * f5;
        this.field_70551_j = ((float)(Math.random() * (double)0.2f) + 0.8f) * f4 * f5;
        this.field_70544_f *= 0.75f;
        this.field_70544_f *= f;
        this.field_70570_a = this.field_70544_f;
        this.field_70547_e = (int)(8.0 / (Math.random() * 0.8 + 0.2));
        this.field_70547_e = (int)((float)this.field_70547_e * f);
        this.field_70145_X = false;
    }

    @Override
    public void func_70539_a(htvf htvf2, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = ((float)this.field_70546_d + f) / (float)this.field_70547_e * 32.0f;
        if (f7 < 0.0f) {
            f7 = 0.0f;
        }
        if (f7 > 1.0f) {
            f7 = 1.0f;
        }
        this.field_70544_f = this.field_70570_a * f7;
        super.func_70539_a(htvf2, f, f2, f3, f4, f5, f6);
    }

    @Override
    public void func_70071_h_() {
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        if (this.field_70546_d++ >= this.field_70547_e) {
            this.func_70106_y();
        }
        this.func_70536_a(7 - this.field_70546_d * 8 / this.field_70547_e);
        this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
        if (this.field_70163_u == this.field_70167_r) {
            this.field_70159_w *= 1.1;
            this.field_70179_y *= 1.1;
        }
        this.field_70159_w *= (double)0.96f;
        this.field_70181_x *= (double)0.96f;
        this.field_70179_y *= (double)0.96f;
        if (this.field_70122_E) {
            this.field_70159_w *= (double)0.7f;
            this.field_70179_y *= (double)0.7f;
        }
    }
}

